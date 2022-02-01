package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.j;
import com.tencent.mm.al.j.a;
import com.tencent.mm.al.j.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public final class p
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  public static boolean JAN = true;
  private String EWS;
  private j JAO;
  private String JAP;
  private String JAQ;
  private ToneGenerator JAR;
  private boolean JAS;
  private boolean JAT;
  public boolean JAU;
  private boolean JAV;
  private volatile boolean JAW;
  private volatile boolean JAX;
  private boolean JAY;
  private com.tencent.mm.ui.chatting.e.a Jdu;
  private boolean Jxs;
  private com.tencent.mm.storage.am contact;
  private final av izu;
  private String jXQ;
  private Object lock;
  private Vibrator nKv;
  private final av ptD;
  private ChatFooter vHt;
  private final j.a vHx;
  private final j.b vHy;
  public AppPanel.a vId;
  
  public p(com.tencent.mm.ui.chatting.e.a parama, ChatFooter paramChatFooter, String paramString)
  {
    AppMethodBeat.i(34518);
    this.JAV = true;
    this.EWS = "";
    this.jXQ = "";
    this.vHx = new j.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(34487);
        p.a(p.this).reset();
        p.b(p.this).stopTimer();
        p.c(p.this).stopTimer();
        an.aQv("keep_app_silent");
        p.d(p.this).a(ChatFooter.h.Fdf);
        as localas = (as)p.e(p.this).bh(as.class);
        if ((localas != null) && (localas.fFk() != null)) {
          localas.fFk().fAG();
        }
        ad.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        p.e(p.this).JOR.enableOptionMenu(true);
        p.e(p.this).JOR.enableBackMenu(true);
        Toast.makeText(p.e(p.this).JOR.getContext(), p.e(p.this).JOR.getContext().getString(2131757276), 0).show();
        AppMethodBeat.o(34487);
      }
    };
    this.vHy = new j.b()
    {
      public final void aEI()
      {
        AppMethodBeat.i(34491);
        p.d(p.this).fdt();
        AppMethodBeat.o(34491);
      }
    };
    this.JAW = false;
    this.JAX = false;
    this.lock = new Object();
    this.izu = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34493);
        p.d(p.this).Zg(p.a(p.this).getMaxAmplitude());
        AppMethodBeat.o(34493);
        return true;
      }
    }, true);
    this.JAY = false;
    this.ptD = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34494);
        long l = p.a(p.this).PZ();
        ad.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(l)));
        int i = (int)((60000L - l) / 1000L);
        if ((l >= 50000L) && (l <= 60000L) && (!p.f(p.this)))
        {
          bt.jd(p.e(p.this).JOR.getContext());
          p.g(p.this);
        }
        p.d(p.this).setVoiceReactArea(i);
        if (l >= 60000L)
        {
          ad.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
          if (!p.d(p.this).fel())
          {
            p.h(p.this);
            p.d(p.this).a(ChatFooter.h.Fda);
          }
          for (;;)
          {
            bd.aI(p.e(p.this).JOR.getContext(), 2131764424);
            AppMethodBeat.o(34494);
            return false;
            p.d(p.this).fdS();
          }
        }
        AppMethodBeat.o(34494);
        return true;
      }
    }, true);
    this.vId = new AppPanel.a()
    {
      com.tencent.mm.ui.widget.a.e wOZ = null;
      
      public final void JI(int paramAnonymousInt)
      {
        AppMethodBeat.i(34504);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34504);
          return;
          ba.aBQ();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.t.g(p.e(p.this).JOR.getContext(), p.e(p.this).JOR.getContentView());
            AppMethodBeat.o(34504);
            return;
          }
          Object localObject = p.e(p.this).JOR.getContext().getSharedPreferences(aj.fkC(), 0).getString("gallery", "1");
          f.Oj(19);
          if (((String)localObject).equalsIgnoreCase("0")) {
            q.f(p.e(p.this).JOR);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            AppMethodBeat.o(34504);
            return;
            localObject = p.e(p.this).fFr();
            String str = p.e(p.this).getTalkerUserName();
            Intent localIntent = new Intent();
            if (p.e(p.this).fFv()) {
              localIntent.putExtra("gallery_report_tag", 20);
            }
            for (;;)
            {
              if ((!p.i(p.this)) || (!p.JAN)) {
                break label275;
              }
              q.a(p.e(p.this).JOR, (String)localObject, str, localIntent);
              break;
              localIntent.putExtra("gallery_report_tag", 21);
            }
            label275:
            if (com.tencent.mm.storage.am.yt(str)) {
              q.a(p.e(p.this).JOR, 12, (String)localObject, str, localIntent);
            } else {
              q.a(p.e(p.this).JOR, 3, (String)localObject, str, localIntent);
            }
          }
          localObject = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.asg());
          if ((!((com.tencent.mm.vfs.e)localObject).exists()) && (!((com.tencent.mm.vfs.e)localObject).mkdirs()))
          {
            Toast.makeText(p.e(p.this).JOR.getContext(), p.e(p.this).JOR.getMMResources().getString(2131757320), 1).show();
            AppMethodBeat.o(34504);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).JOR.getContext(), "android.permission.CAMERA", 20, "", "");
          ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), p.e(p.this).JOR.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34504);
            return;
          }
          p.this.fBF();
        }
      }
      
      public final void JJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(34510);
        if ((!com.tencent.mm.s.a.n(p.e(p.this).JOR.getContext(), true)) && (!com.tencent.mm.s.a.cf(p.e(p.this).JOR.getContext())) && (!com.tencent.mm.s.a.cd(p.e(p.this).JOR.getContext())) && (!com.tencent.mm.s.a.ch(p.e(p.this).JOR.getContext()))) {
          p.this.acQ(paramAnonymousInt);
        }
        AppMethodBeat.o(34510);
      }
      
      public final void d(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(34505);
        ((com.tencent.mm.ui.chatting.d.b.b)p.e(p.this).bh(com.tencent.mm.ui.chatting.d.b.b.class)).t(paramAnonymousg);
        AppMethodBeat.o(34505);
      }
      
      public final void dlh()
      {
        AppMethodBeat.i(34499);
        if (com.tencent.mm.s.a.cd(p.e(p.this).JOR.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.s.a.ce(p.e(p.this).JOR.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.s.a.ch(p.e(p.this).JOR.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        ya localya = new ya();
        com.tencent.mm.sdk.b.a.IbL.l(localya);
        if ((p.this.getTalkerUserName() != null) && (!p.this.getTalkerUserName().equals(localya.dMm.talker)) && ((localya.dMm.dkp) || (localya.dMm.dkq)))
        {
          if (localya.dMm.dMn) {}
          for (int i = 2131756778;; i = 2131756779)
          {
            Toast.makeText(p.e(p.this).JOR.getContext(), i, 0).show();
            ad.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34499);
            return;
          }
        }
        final boolean bool;
        if (1 == com.tencent.mm.n.g.acA().getInt("EnableVoiceVoipFromPlugin", 0))
        {
          if ((!com.tencent.mm.storage.am.aSQ(p.e(p.this).BYG.field_username)) && (!w.zl(p.e(p.this).BYG.field_username))) {
            break label415;
          }
          if ((((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).ID(p.e(p.this).BYG.field_openImAppid) & 0x2000) == 0) {
            bool = true;
          }
        }
        for (;;)
        {
          this.wOZ = new com.tencent.mm.ui.widget.a.e(p.e(p.this).JOR.getContext(), 1, false);
          this.wOZ.KJy = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(34495);
              paramAnonymous2l.aL(2, 2131755762, 2131691164);
              if (!bool) {
                paramAnonymous2l.aL(1, 2131755764, 2131691165);
              }
              AppMethodBeat.o(34495);
            }
          };
          this.wOZ.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(34496);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(34496);
                return;
                p.this.dAX();
                AppMethodBeat.o(34496);
                return;
                p.this.dAY();
              }
            }
          };
          this.wOZ.cMW();
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(34499);
            return;
            bool = false;
            break;
            p.this.fBD();
          }
          label415:
          bool = false;
        }
      }
      
      public final void dli()
      {
        AppMethodBeat.i(34500);
        if (com.tencent.mm.s.a.cd(p.e(p.this).JOR.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.s.a.ce(p.e(p.this).JOR.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.s.a.ch(p.e(p.this).JOR.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        ya localya = new ya();
        com.tencent.mm.sdk.b.a.IbL.l(localya);
        if ((!p.this.getTalkerUserName().equals(localya.dMm.talker)) && ((localya.dMm.dkp) || (localya.dMm.dkq)))
        {
          if (localya.dMm.dMn) {}
          for (int i = 2131756778;; i = 2131756779)
          {
            Toast.makeText(p.e(p.this).JOR.getContext(), i, 0).show();
            ad.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34500);
            return;
          }
        }
        p.this.fBC();
        AppMethodBeat.o(34500);
      }
      
      public final void dlj()
      {
        AppMethodBeat.i(34501);
        if ((!com.tencent.mm.s.a.cf(p.e(p.this).JOR.getContext())) && (!com.tencent.mm.s.a.cd(p.e(p.this).JOR.getContext())) && (!com.tencent.mm.s.a.ch(p.e(p.this).JOR.getContext())))
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).JOR.getContext(), "android.permission.RECORD_AUDIO", 81, "", "");
          ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), p.e(p.this).JOR.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34501);
            return;
          }
          p.this.fBE();
        }
        AppMethodBeat.o(34501);
      }
      
      public final void dlk()
      {
        AppMethodBeat.i(34502);
        ((ab)p.e(p.this).bh(ab.class)).fEu();
        AppMethodBeat.o(34502);
      }
      
      public final void dll()
      {
        AppMethodBeat.i(34503);
        ((com.tencent.mm.ui.chatting.d.b.e)p.e(p.this).bh(com.tencent.mm.ui.chatting.d.b.e.class)).fCY();
        AppMethodBeat.o(34503);
      }
      
      public final void dlm()
      {
        AppMethodBeat.i(34506);
        com.tencent.mm.bs.d.b(p.e(p.this).JOR.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.o(34506);
      }
      
      public final void dln()
      {
        AppMethodBeat.i(34507);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("3");
        if (com.tencent.mm.am.g.vd(p.j(p.this).field_username))
        {
          localArrayList.add("4");
          localArrayList.add("7");
          localArrayList.add("9");
          localArrayList.add("10");
          localArrayList.add("11");
          localArrayList.add("12");
          localArrayList.add("13");
          localArrayList.add("15");
          localArrayList.add("16");
          localArrayList.add("17");
          localArrayList.add("18");
        }
        localIntent.putExtra("key_to_user", p.j(p.this).field_username);
        localIntent.putExtra("key_fav_item_id", TextUtils.join(",", localArrayList));
        com.tencent.mm.plugin.fav.a.b.b(p.e(p.this).JOR.getContext(), ".ui.FavSelectUI", localIntent);
        com.tencent.mm.plugin.report.service.g.yhR.f(14103, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(34507);
      }
      
      public final void dlo()
      {
        AppMethodBeat.i(34508);
        Intent localIntent = new Intent();
        localIntent.putExtra("service_app_talker_user", p.this.getTalkerUserName());
        com.tencent.mm.bs.d.a(p.e(p.this).JOR, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
        AppMethodBeat.o(34508);
      }
      
      public final void dlp()
      {
        AppMethodBeat.i(34509);
        Object localObject;
        if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
        {
          localObject = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new HashMap());
          ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.flutter.a.a.class)).a(p.e(p.this).JOR.getContext(), (com.tencent.mm.plugin.flutter.a.c)localObject);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(12065, new Object[] { Integer.valueOf(4) });
          AppMethodBeat.o(34509);
          return;
          localObject = new Intent();
          ((Intent)localObject).putExtra("download_entrance_scene", 17);
          ((Intent)localObject).putExtra("preceding_scence", 13);
          com.tencent.mm.bs.d.b(p.e(p.this).JOR.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
        }
      }
      
      public final void dlq()
      {
        AppMethodBeat.i(34511);
        com.tencent.mm.plugin.report.service.g.yhR.f(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        p.a(p.this, p.k(p.this) + "_" + System.currentTimeMillis());
        final String str = UUID.randomUUID().toString();
        p.Q(2, 0, p.l(p.this));
        final p.b localb = p.fBG();
        com.tencent.mm.kernel.g.ajD();
        final int i = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IqO, 0);
        if (p.m(p.this))
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
          if ((i == 1) && (localb.JBk))
          {
            locale = new com.tencent.mm.ui.widget.a.e(p.e(p.this).JOR.getContext(), 1, false);
            locale.KJy = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(163290);
                paramAnonymous2l.c(0, p.e(p.this).JOR.getMMResources().getString(2131757246));
                p.a locala = p.a(localb);
                if (locala != null) {
                  paramAnonymous2l.a(1, locala.title, locala.desc, 0);
                }
                AppMethodBeat.o(163290);
              }
            };
            locale.KJz = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(163291);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(163291);
                  return;
                  p.b(p.this, str);
                  com.tencent.mm.plugin.report.service.g.yhR.f(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
                  p.Q(4, 0, p.l(p.this));
                  AppMethodBeat.o(163291);
                  return;
                  p.n(p.this);
                }
              }
            };
            locale.cMW();
            p.fBH();
            p.Q(3, 0, p.l(p.this));
            AppMethodBeat.o(34511);
            return;
          }
          p.b(p.this, str);
          com.tencent.mm.plugin.report.service.g.yhR.f(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        if (((i != 1) || (!localb.JBk)) && (p.fBz()))
        {
          p.c(p.this, str);
          com.tencent.mm.plugin.report.service.g.yhR.f(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(p.e(p.this).JOR.getContext(), 1, false);
        locale.KJy = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(163292);
            paramAnonymous2l.c(0, p.e(p.this).JOR.getMMResources().getString(2131757246));
            Object localObject;
            if (!p.fBz())
            {
              localObject = new cm();
              ((cm)localObject).ecM = 13L;
              ((cm)localObject).aLk();
              paramAnonymous2l.c(1, p.e(p.this).JOR.getMMResources().getString(2131757245));
            }
            if ((localb.JBk) && (i == 1))
            {
              localObject = p.a(localb);
              if (localObject != null) {
                paramAnonymous2l.a(2, ((p.a)localObject).title, ((p.a)localObject).desc, 0);
              }
            }
            AppMethodBeat.o(163292);
          }
        };
        locale.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(163293);
            Intent localIntent = new Intent();
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(163293);
              return;
              p.c(p.this, str);
              com.tencent.mm.plugin.report.service.g.yhR.f(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
              p.Q(4, 0, p.l(p.this));
              AppMethodBeat.o(163293);
              return;
              com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
              localIntent.putExtra("key_username", p.this.getTalkerUserName());
              localIntent.putExtra("key_way", 0);
              localIntent.putExtra("pay_channel", 11);
              com.tencent.mm.bs.d.b(p.e(p.this).JOR.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", localIntent);
              paramAnonymous2MenuItem = new cm();
              paramAnonymous2MenuItem.ecM = 1L;
              paramAnonymous2MenuItem.aLk();
              p.Q(5, 0, p.l(p.this));
              AppMethodBeat.o(163293);
              return;
              p.n(p.this);
            }
          }
        };
        locale.cMW();
        p.fBH();
        p.Q(3, 0, p.l(p.this));
        AppMethodBeat.o(34511);
      }
      
      public final void dlr()
      {
        AppMethodBeat.i(34512);
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(81, Boolean.FALSE);
        if (!ay.isNetworkConnected(p.e(p.this).JOR.getContext()))
        {
          com.tencent.mm.bi.e.a(p.e(p.this).JOR.getContext(), 2131764895, null);
          AppMethodBeat.o(34512);
          return;
        }
        p.this.fBB();
        AppMethodBeat.o(34512);
      }
      
      public final void dls()
      {
        AppMethodBeat.i(34513);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_scene", 4);
        localIntent.putExtra("enterprise_biz_name", p.this.getTalkerUserName());
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)p.e(p.this).bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCU());
        com.tencent.mm.bs.d.b(p.e(p.this).JOR.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
        AppMethodBeat.o(34513);
      }
      
      public final void dlt()
      {
        AppMethodBeat.i(193849);
        ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.gamelife.c.class)).enterSendGift(p.e(p.this).JOR.getContext(), p.this.getTalkerUserName());
        AppMethodBeat.o(193849);
      }
      
      public final void dlu()
      {
        AppMethodBeat.i(34514);
        if (p.m(p.this))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enter_scene", 1);
          localIntent.putExtra("chatroom_name", p.this.getTalkerUserName());
          com.tencent.mm.bs.d.b(p.e(p.this).JOR.getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        }
        AppMethodBeat.o(34514);
      }
      
      public final void dlv()
      {
        AppMethodBeat.i(34515);
        com.tencent.mm.plugin.report.service.g.yhR.f(14523, new Object[] { Integer.valueOf(0) });
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).JOR.getContext(), "android.permission.READ_EXTERNAL_STORAGE", 145, p.e(p.this).JOR.getContext().getString(2131761885), p.e(p.this).JOR.getContext().getString(2131763056));
        ad.i("MicroMsg.ChattingFooterEventImpl", "checkPermission checkStorage[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), p.e(p.this).JOR.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(34515);
          return;
        }
        p.this.fBy();
        AppMethodBeat.o(34515);
      }
      
      public final void dlw()
      {
        AppMethodBeat.i(193850);
        ad.i("MicroMsg.ChattingFooterEventImpl", "gotoRoomLiveEntrance");
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).JOR.getContext(), "android.permission.CAMERA", 25, "", "");
        ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), p.e(p.this).JOR.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(193850);
          return;
        }
        bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).JOR.getContext(), "android.permission.RECORD_AUDIO", 25, "", "");
        ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), p.e(p.this).JOR.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(193850);
          return;
        }
        if ((!com.tencent.mm.s.a.n(p.e(p.this).JOR.getContext(), true)) && (!com.tencent.mm.s.a.cf(p.e(p.this).JOR.getContext())) && (!com.tencent.mm.s.a.cd(p.e(p.this).JOR.getContext())) && (!com.tencent.mm.s.a.ch(p.e(p.this).JOR.getContext())))
        {
          if (com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IIX, 0) == 1)
          {
            final Activity localActivity = p.e(p.this).JOR.getContext();
            com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
            locall.KJy = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(193847);
                paramAnonymous2l.c(0, localActivity.getString(2131766586));
                paramAnonymous2l.c(1, localActivity.getString(2131766585));
                AppMethodBeat.o(193847);
              }
            };
            locall.KJz = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(193848);
                if (paramAnonymous2Int == 0)
                {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().a(p.e(p.this).JOR.getContext(), LiveConfig.S(p.e(p.this).getTalkerUserName(), LiveConfig.gGq));
                  AppMethodBeat.o(193848);
                  return;
                }
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(p.e(p.this).JOR.getContext(), LiveConfig.S(p.e(p.this).getTalkerUserName(), LiveConfig.gGq));
                AppMethodBeat.o(193848);
              }
            };
            locall.fKy();
            AppMethodBeat.o(193850);
            return;
          }
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(p.e(p.this).JOR.getContext(), LiveConfig.S(p.e(p.this).getTalkerUserName(), LiveConfig.gGq));
        }
        AppMethodBeat.o(193850);
      }
      
      public final void dlx()
      {
        AppMethodBeat.i(179848);
        ((x)p.e(p.this).bh(x.class)).fDU();
        AppMethodBeat.o(179848);
      }
      
      public final void dly()
      {
        AppMethodBeat.i(193851);
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterGroupSolitaire() chatroom:%s", new Object[] { p.e(p.this).getTalkerUserName() });
        Intent localIntent = new Intent();
        localIntent.putExtra("key_group_solitatire_create", true);
        localIntent.putExtra("key_group_solitatire_scene", 5);
        com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
        locala.header = (p.e(p.this).JOR.getContext().getString(2131760093) + "\n");
        locala.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(locala);
        locala.separator = ".";
        locala.uBD = 1;
        localIntent.putExtra("key_group_solitatire_key", locala.field_key);
        localIntent.putExtra("key_group_solitatire_chatroom_username", p.e(p.this).getTalkerUserName());
        com.tencent.mm.plugin.groupsolitaire.b.b.a(p.e(p.this).getTalkerUserName(), locala);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(p.e(p.this).getTalkerUserName(), locala);
        com.tencent.mm.bs.d.b(p.e(p.this).JOR.getContext(), "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent);
        AppMethodBeat.o(193851);
      }
    };
    this.Jdu = parama;
    this.vHt = paramChatFooter;
    this.JAP = paramString;
    ba.aBQ();
    this.contact = com.tencent.mm.model.c.azp().Bf(paramString);
    this.JAS = w.vF(this.Jdu.getTalkerUserName());
    this.JAT = w.zu(this.Jdu.getTalkerUserName());
    boolean bool;
    if ((this.JAS) || (this.JAT))
    {
      bool = true;
      this.Jxs = bool;
      this.nKv = ((Vibrator)this.Jdu.JOR.getContext().getSystemService("vibrator"));
      if (!w.Aa(this.JAP)) {
        break label347;
      }
      this.JAO = new com.tencent.mm.plugin.subapp.d.i();
      ad.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.JAO.a(this.vHy);
      this.JAO.a(this.vHx);
      paramChatFooter.setAppPanelListener(this.vId);
      this.JAV = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyu, true);
      ba.aBQ();
      this.EWS = ((String)com.tencent.mm.model.c.ajl().get(2, null));
      AppMethodBeat.o(34518);
      return;
      bool = false;
      break;
      label347:
      parama = this.JAP;
      int i;
      if (w.Al(parama)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label532;
        }
        this.JAO = new com.tencent.mm.audio.b.h(this.Jdu.JOR.getContext(), true);
        ad.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(parama);
        if ((parama != null) && (parama.fqg()))
        {
          paramString = com.tencent.mm.am.g.eS(parama.field_username);
          if (paramString != null)
          {
            paramString = paramString.bX(false);
            if (paramString != null)
            {
              if (paramString.cQv != null) {
                paramString.cQz = "1".equals(paramString.cQv.optString("CanReceiveSpeexVoice"));
              }
              if (paramString.cQz)
              {
                ad.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + parama.field_username + " canReceiveSpeexVoice");
                i = 1;
                continue;
              }
            }
          }
        }
        i = 0;
      }
      label532:
      this.JAO = new com.tencent.mm.audio.b.h(this.Jdu.JOR.getContext(), false);
      ad.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
  }
  
  public static void Q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(163296);
    com.tencent.mm.g.b.a.l locall = new com.tencent.mm.g.b.a.l();
    locall.dSa = paramInt1;
    locall.dSd = System.currentTimeMillis();
    locall.dSb = locall.t("SessionId", paramString, true);
    locall.dSc = paramInt2;
    locall.aLk();
    AppMethodBeat.o(163296);
  }
  
  public static a a(b paramb)
  {
    AppMethodBeat.i(163300);
    if (paramb == null)
    {
      AppMethodBeat.o(163300);
      return null;
    }
    String str = com.tencent.mm.sdk.platformtools.ac.fks();
    if ("zh_CN".equals(str))
    {
      paramb = paramb.JBl;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_TW".equals(str))
    {
      paramb = paramb.JBn;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_HK".equals(str))
    {
      paramb = paramb.JBm;
      AppMethodBeat.o(163300);
      return paramb;
    }
    paramb = paramb.JBo;
    AppMethodBeat.o(163300);
    return paramb;
  }
  
  private static void acP(int paramInt)
  {
    AppMethodBeat.i(34541);
    qi localqi = new qi();
    localqi.dFd.state = paramInt;
    com.tencent.mm.sdk.b.a.IbL.l(localqi);
    AppMethodBeat.o(34541);
  }
  
  public static void ebV()
  {
    CaptureDataManager.xxY.xxX = null;
  }
  
  private static b fBA()
  {
    AppMethodBeat.i(163298);
    b localb = new b();
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEJ, "");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(163298);
      return localb;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).getInt("weishi_hb_sw") != 0) {
          continue;
        }
        localb.JBk = false;
        localb.JBl = l((JSONObject)localObject, "simple_chinese");
        localb.JBm = l((JSONObject)localObject, "xg_traditional_chinese");
        localb.JBn = l((JSONObject)localObject, "tw_traditional_chinese");
        localb.JBo = l((JSONObject)localObject, "english");
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(163298);
      return localb;
      localb.JBk = true;
    }
  }
  
  @Deprecated
  @SuppressLint({"NewApi"})
  private void fBu()
  {
    AppMethodBeat.i(34532);
    this.Jdu.xR(true);
    AppMethodBeat.o(34532);
  }
  
  private boolean fBv()
  {
    boolean bool = false;
    int i = 1;
    AppMethodBeat.i(34534);
    this.Jdu.JOR.enableOptionMenu(true);
    this.Jdu.JOR.enableBackMenu(true);
    if (this.JAO != null) {
      if ((this.JAO.isRecording()) && (fBw()))
      {
        bool = this.JAO.Gv();
        this.izu.stopTimer();
        this.ptD.stopTimer();
        if (i != 0) {
          fBx();
        }
        an.aQv("keep_app_silent");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34534);
      return bool;
      i = 0;
      break;
      ad.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
    }
  }
  
  private boolean fBw()
  {
    AppMethodBeat.i(34538);
    if ((this.contact.field_username.equals("medianote")) && ((u.aAq() & 0x4000) == 0))
    {
      AppMethodBeat.o(34538);
      return true;
    }
    AppMethodBeat.o(34538);
    return false;
  }
  
  private void fBx()
  {
    AppMethodBeat.i(34539);
    bu localbu = new bu();
    localbu.tN("medianote");
    localbu.setType(34);
    localbu.kr(1);
    localbu.tO(this.JAQ);
    localbu.setStatus(2);
    localbu.setContent(com.tencent.mm.modelvoice.p.b(u.aAm(), this.JAO.PX(), false));
    localbu.qA(bj.Bo("medianote"));
    if (this.JAO.Qa() == 2) {
      localbu.sP("SOURCE_SILK_FILE");
    }
    ba.aBQ();
    long l = com.tencent.mm.model.c.azs().as(localbu);
    if (l <= 0L)
    {
      ad.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
      AppMethodBeat.o(34539);
      return;
    }
    ad.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(l)));
    AppMethodBeat.o(34539);
  }
  
  public static boolean fBz()
  {
    AppMethodBeat.i(163297);
    ba.aBQ();
    Integer localInteger1 = (Integer)com.tencent.mm.model.c.ajl().get(al.a.IqM, Integer.valueOf(0));
    ba.aBQ();
    Integer localInteger2 = (Integer)com.tencent.mm.model.c.ajl().get(al.a.IqN, Integer.valueOf(0));
    if (((localInteger1.intValue() != 1) && (localInteger2.intValue() != 1)) || (!u.aAE()))
    {
      AppMethodBeat.o(163297);
      return true;
    }
    AppMethodBeat.o(163297);
    return false;
  }
  
  private static a l(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(163299);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject.has("wording"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("wording");
      localObject1 = localObject2;
      if (paramJSONObject.has(paramString))
      {
        localObject1 = new a();
        paramJSONObject = paramJSONObject.optJSONObject(paramString);
        ((a)localObject1).title = paramJSONObject.optString("title");
        ((a)localObject1).desc = paramJSONObject.optString("desc");
      }
    }
    AppMethodBeat.o(163299);
    return localObject1;
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(34533);
    this.Jdu.setKeepScreenOn(false);
    AppMethodBeat.o(34533);
  }
  
  public final long PZ()
  {
    AppMethodBeat.i(34522);
    if (this.JAO != null)
    {
      long l = this.JAO.PZ();
      AppMethodBeat.o(34522);
      return l;
    }
    AppMethodBeat.o(34522);
    return 0L;
  }
  
  public final void V(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34531);
    if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
    {
      fBu();
      this.Jdu.fBR();
    }
    AppMethodBeat.o(34531);
  }
  
  public final void acQ(final int paramInt)
  {
    AppMethodBeat.i(34543);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.CAMERA", 18, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.RECORD_AUDIO", 18, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    Object localObject1;
    if ((com.tencent.mm.sdk.a.b.fjN()) || (com.tencent.mm.platformtools.ac.iPM))
    {
      localObject1 = new com.tencent.mm.ui.tools.l(this.Jdu.JOR.getContext());
      ((com.tencent.mm.ui.tools.l)localObject1).KJy = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(169854);
          paramAnonymousl.c(1, p.e(p.this).JOR.getMMResources().getString(2131755747));
          paramAnonymousl.c(5, "拍摄参数设置面板");
          AppMethodBeat.o(169854);
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(169856);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(169856);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            paramAnonymousMenuItem = new SightParams(1, paramInt);
            Object localObject = com.tencent.mm.modelvideo.t.Hg(p.this.getTalkerUserName());
            com.tencent.mm.modelvideo.o.aMJ();
            String str = com.tencent.mm.modelvideo.t.Hh((String)localObject);
            com.tencent.mm.modelvideo.o.aMJ();
            paramAnonymousMenuItem = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.Hi((String)localObject), paramAnonymousMenuItem.hvh, paramAnonymousMenuItem.hvh.duration * 1000, 1);
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyv, false)) {
              paramAnonymousMenuItem.remuxType = 2;
            }
            localObject = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject).rgD = 3;
            if (p.o(p.this)) {
              ((VideoCaptureReportInfo)localObject).rgD = 4;
            }
            paramAnonymousMenuItem.xyB = ((VideoCaptureReportInfo)localObject);
            localObject = new UICustomParam.a();
            ((UICustomParam.a)localObject).aby();
            ((UICustomParam.a)localObject).abx();
            ((UICustomParam.a)localObject).cP(true);
            paramAnonymousMenuItem.xyk = ((UICustomParam.a)localObject).gei;
            localObject = new CaptureDataManager.c()
            {
              public final void a(Context paramAnonymous2Context, CaptureDataManager.CaptureVideoNormalModel paramAnonymous2CaptureVideoNormalModel, Bundle paramAnonymous2Bundle)
              {
                AppMethodBeat.i(169855);
                paramAnonymous2Bundle = new bxm();
                paramAnonymous2Bundle.GRA = true;
                paramAnonymous2Bundle.GRz = false;
                String str = com.tencent.mm.vfs.i.aYt(paramAnonymous2CaptureVideoNormalModel.videoPath);
                paramAnonymous2Bundle = new SightCaptureResult(true, paramAnonymous2CaptureVideoNormalModel.videoPath, paramAnonymous2CaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymous2CaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymous2CaptureVideoNormalModel.xya.longValue() * 1.0F / 1000.0F), paramAnonymous2Bundle);
                if (paramAnonymous2CaptureVideoNormalModel.xyb.booleanValue())
                {
                  paramAnonymous2Bundle.vMs = true;
                  paramAnonymous2Bundle.pzW = false;
                  paramAnonymous2Bundle.vMA = paramAnonymous2CaptureVideoNormalModel.thumbPath;
                }
                paramAnonymous2CaptureVideoNormalModel = new Intent();
                paramAnonymous2CaptureVideoNormalModel.putExtra("key_req_result", paramAnonymous2Bundle);
                ((Activity)paramAnonymous2Context).setResult(-1, paramAnonymous2CaptureVideoNormalModel);
                ((Activity)paramAnonymous2Context).finish();
                AppMethodBeat.o(169855);
              }
              
              public final boolean a(Context paramAnonymous2Context, Bundle paramAnonymous2Bundle, CaptureDataManager.a paramAnonymous2a)
              {
                return false;
              }
            };
            CaptureDataManager.xxY.xxX = ((CaptureDataManager.b)localObject);
            if (p.p(p.this))
            {
              localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(p.e(p.this).JOR.getContext(), 226, 2130772137, 2130772138, paramAnonymousMenuItem);
              AppMethodBeat.o(169856);
              return;
            }
            q.a(p.e(p.this).JOR, new Intent(), p.this.getTalkerUserName(), paramInt);
            AppMethodBeat.o(169856);
            return;
            com.tencent.mm.bs.d.b(p.e(p.this).JOR.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
          }
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).fKy();
      AppMethodBeat.o(34543);
      return;
    }
    if (!com.tencent.mm.platformtools.ac.iPN)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new SightParams(1, paramInt);
      Object localObject2 = com.tencent.mm.modelvideo.t.Hg(getTalkerUserName());
      com.tencent.mm.modelvideo.o.aMJ();
      String str = com.tencent.mm.modelvideo.t.Hh((String)localObject2);
      com.tencent.mm.modelvideo.o.aMJ();
      localObject1 = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.Hi((String)localObject2), ((SightParams)localObject1).hvh, ((SightParams)localObject1).hvh.duration * 1000, 1);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyv, false)) {
        ((RecordConfigProvider)localObject1).remuxType = 2;
      }
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).rgD = 3;
      if (this.Jxs) {
        ((VideoCaptureReportInfo)localObject2).rgD = 4;
      }
      ((RecordConfigProvider)localObject1).xyB = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).aby();
      ((UICustomParam.a)localObject2).abx();
      ((UICustomParam.a)localObject2).cP(true);
      ((RecordConfigProvider)localObject1).xyk = ((UICustomParam.a)localObject2).gei;
      localObject2 = new CaptureDataManager.c()
      {
        public final void a(Context paramAnonymousContext, CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(169857);
          paramAnonymousBundle = new bxm();
          paramAnonymousBundle.GRA = true;
          paramAnonymousBundle.GRz = false;
          String str = com.tencent.mm.vfs.i.aYt(paramAnonymousCaptureVideoNormalModel.videoPath);
          paramAnonymousBundle = new SightCaptureResult(true, paramAnonymousCaptureVideoNormalModel.videoPath, paramAnonymousCaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymousCaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymousCaptureVideoNormalModel.xya.longValue() * 1.0F / 1000.0F), paramAnonymousBundle);
          if (paramAnonymousCaptureVideoNormalModel.xyb.booleanValue())
          {
            paramAnonymousBundle.vMs = true;
            paramAnonymousBundle.pzW = false;
            paramAnonymousBundle.vMA = paramAnonymousCaptureVideoNormalModel.thumbPath;
          }
          paramAnonymousCaptureVideoNormalModel = new Intent();
          paramAnonymousCaptureVideoNormalModel.putExtra("key_req_result", paramAnonymousBundle);
          ((Activity)paramAnonymousContext).setResult(-1, paramAnonymousCaptureVideoNormalModel);
          ((Activity)paramAnonymousContext).finish();
          AppMethodBeat.o(169857);
        }
        
        public final boolean a(Context paramAnonymousContext, Bundle paramAnonymousBundle, CaptureDataManager.a paramAnonymousa)
        {
          return false;
        }
      };
      CaptureDataManager.xxY.xxX = ((CaptureDataManager.b)localObject2);
      if (this.JAV)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this.Jdu.JOR.getContext(), 226, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
        AppMethodBeat.o(34543);
        return;
      }
      q.a(this.Jdu.JOR, new Intent(), getTalkerUserName(), paramInt);
    }
    AppMethodBeat.o(34543);
  }
  
  public final void amZ(String paramString)
  {
    AppMethodBeat.i(34526);
    ((com.tencent.mm.ui.chatting.d.b.am)this.Jdu.bh(com.tencent.mm.ui.chatting.d.b.am.class)).amZ(paramString);
    AppMethodBeat.o(34526);
  }
  
  public final boolean apn(String paramString)
  {
    AppMethodBeat.i(34525);
    fBu();
    this.Jdu.fBR();
    boolean bool = ((com.tencent.mm.ui.chatting.d.b.am)this.Jdu.bh(com.tencent.mm.ui.chatting.d.b.am.class)).aWi(paramString);
    AppMethodBeat.o(34525);
    return bool;
  }
  
  public final boolean apo(String paramString)
  {
    AppMethodBeat.i(34528);
    if (!bt.isNullOrNil(paramString))
    {
      s.HU(paramString);
      com.tencent.mm.modelvoice.o.aNA().run();
      AppMethodBeat.o(34528);
      return true;
    }
    AppMethodBeat.o(34528);
    return false;
  }
  
  public final void dAX()
  {
    AppMethodBeat.i(34546);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.RECORD_AUDIO", 82, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34546);
      return;
    }
    yb localyb = new yb();
    localyb.dMo.dsi = 5;
    localyb.dMo.talker = getTalkerUserName();
    localyb.dMo.context = this.Jdu.JOR.getContext();
    localyb.dMo.dMk = 4;
    if (this.vHt.fdK()) {
      this.vHt.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    AppMethodBeat.o(34546);
  }
  
  public final void dAY()
  {
    AppMethodBeat.i(34547);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.CAMERA", 19, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.RECORD_AUDIO", 19, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    yb localyb = new yb();
    localyb.dMo.dsi = 5;
    localyb.dMo.talker = getTalkerUserName();
    localyb.dMo.context = this.Jdu.JOR.getContext();
    localyb.dMo.dMk = 2;
    if (this.vHt.fdK()) {
      this.vHt.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    AppMethodBeat.o(34547);
  }
  
  public final boolean dZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(34527);
    if ((!bt.isNullOrNil(paramString)) && (paramInt > 0) && (s.Ia(paramString) != null))
    {
      s.aw(paramString, paramInt);
      com.tencent.mm.modelvoice.o.aNA().run();
      AppMethodBeat.o(34527);
      return true;
    }
    AppMethodBeat.o(34527);
    return false;
  }
  
  public final boolean dkV()
  {
    AppMethodBeat.i(34519);
    synchronized (this.lock)
    {
      this.JAW = true;
      if (!this.JAX)
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34519);
        return false;
      }
    }
    this.JAX = false;
    releaseWakeLock();
    if (!fBv())
    {
      this.vHt.cdY();
      ad.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
      ((as)this.Jdu.bh(as.class)).fFk().fAG();
      ((ak)this.Jdu.bh(ak.class)).adn(4);
      ((ak)this.Jdu.bh(ak.class)).stopSignalling();
      acP(1);
      ((as)this.Jdu.bh(as.class)).a(this.Jdu.JOR, false);
      AppMethodBeat.o(34519);
      return true;
    }
    this.vHt.setExitType(0);
    ??? = this.vHt;
    if (!((ChatFooter)???).FaN) {
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEL, 1)) {
        break label369;
      }
    }
    label369:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject3 = aj.getContext().getSharedPreferences(ChatFooter.Fco, 0);
        if (((SharedPreferences)localObject3).getInt("trans2txt_edu_key", 0) == 0)
        {
          ((SharedPreferences)localObject3).edit().putInt("trans2txt_edu_key", 1).apply();
          localObject3 = new bu();
          ??? = ((ChatFooter)???).Fag.getTalkerUserName();
          ((bu)localObject3).qA(bj.Bo((String)???));
          ((bu)localObject3).tN((String)???);
          ((bu)localObject3).setContent(aj.getContext().getString(2131764710));
          ((bu)localObject3).setType(10000);
          ((bu)localObject3).setStatus(6);
          ((bu)localObject3).kr(0);
          ba.aBQ();
          com.tencent.mm.model.c.azs().as((bu)localObject3);
        }
      }
      this.vHt.a(ChatFooter.h.Fda);
      ad.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
      break;
    }
  }
  
  public final boolean dkW()
  {
    AppMethodBeat.i(34520);
    ad.v("MicroMsg.ChattingFooterEventImpl", "only stop recording.");
    synchronized (this.lock)
    {
      this.JAW = true;
      if (!this.JAX)
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "ever never begin.");
        AppMethodBeat.o(34520);
        return false;
      }
    }
    this.JAX = false;
    releaseWakeLock();
    this.Jdu.JOR.enableOptionMenu(true);
    this.Jdu.JOR.enableBackMenu(true);
    if (this.JAO != null)
    {
      this.JAO.PY();
      this.izu.stopTimer();
      this.ptD.stopTimer();
    }
    this.vHt.a(ChatFooter.h.Fdb);
    ((as)this.Jdu.bh(as.class)).fFk().fAG();
    ((ak)this.Jdu.bh(ak.class)).adn(4);
    ((ak)this.Jdu.bh(ak.class)).stopSignalling();
    acP(1);
    ((as)this.Jdu.bh(as.class)).a(this.Jdu.JOR, false);
    AppMethodBeat.o(34520);
    return true;
  }
  
  public final boolean dkY()
  {
    AppMethodBeat.i(34523);
    ad.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.JAW = true;
      if (!this.JAX)
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34523);
        return false;
      }
    }
    this.JAX = false;
    releaseWakeLock();
    dkZ();
    this.vHt.a(ChatFooter.h.Fdd);
    ((as)this.Jdu.bh(as.class)).fFk().fAG();
    ((ak)this.Jdu.bh(ak.class)).adn(4);
    ((ak)this.Jdu.bh(ak.class)).stopSignalling();
    acP(1);
    ((as)this.Jdu.bh(as.class)).a(this.Jdu.JOR, false);
    AppMethodBeat.o(34523);
    return true;
  }
  
  public final void dkZ()
  {
    AppMethodBeat.i(185863);
    this.Jdu.JOR.enableOptionMenu(true);
    this.Jdu.JOR.enableBackMenu(true);
    if (this.JAO != null)
    {
      this.JAO.cancel();
      this.izu.stopTimer();
      this.ptD.stopTimer();
    }
    this.vHt.a(ChatFooter.h.Fdd);
    AppMethodBeat.o(185863);
  }
  
  public final boolean dla()
  {
    AppMethodBeat.i(34524);
    if ((com.tencent.mm.s.a.cf(this.Jdu.JOR.getContext())) || (com.tencent.mm.s.a.cd(this.Jdu.JOR.getContext())) || (com.tencent.mm.s.a.ch(this.Jdu.JOR.getContext())))
    {
      ad.d("MicroMsg.ChattingFooterEventImpl", "voip is running, can't record voice");
      AppMethodBeat.o(34524);
      return false;
    }
    ??? = this.Jdu.JOR.getContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)((Context)???).getSystemService("phone");
    if ((2 == localTelephonyManager.getCallState()) || (1 == localTelephonyManager.getCallState())) {
      Toast.makeText((Context)???, ((Context)???).getString(2131760281), 0).show();
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.d("MicroMsg.ChattingFooterEventImpl", "system has calling , can't record voice");
        AppMethodBeat.o(34524);
        return false;
      }
      if (com.tencent.mm.s.a.ce(this.Jdu.JOR.getContext()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.Jdu.JOR.getContext(), this.Jdu.JOR.getContentView());
        ad.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        AppMethodBeat.o(34524);
        return false;
      }
      if (!com.tencent.mm.compatible.d.b.aba()) {
        com.tencent.mm.ui.base.h.a(this.Jdu.JOR.getContext(), this.Jdu.JOR.getMMResources().getString(2131755901), this.Jdu.JOR.getMMResources().getString(2131755824), this.Jdu.JOR.getMMResources().getString(2131755826), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34492);
            com.tencent.mm.compatible.d.b.bZ(p.e(p.this).JOR.getContext());
            AppMethodBeat.o(34492);
          }
        });
      }
      synchronized (this.lock)
      {
        this.JAW = false;
      }
      synchronized (this.lock)
      {
        if (this.JAW)
        {
          ad.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
          AppMethodBeat.o(34524);
          return false;
          localObject2 = finally;
          AppMethodBeat.o(34524);
          throw localObject2;
        }
        if (this.Jdu.JOR.getContext().isFinishing())
        {
          AppMethodBeat.o(34524);
          return false;
        }
      }
      if ((Build.VERSION.SDK_INT >= 17) && (this.Jdu.JOR.getContext().isDestroyed()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      this.JAX = true;
      ??? = com.tencent.mm.plugin.transvoice.a.c.BBY;
      com.tencent.mm.plugin.transvoice.a.c.eru().BBF = true;
      this.izu.az(100L, 100L);
      this.JAY = false;
      this.ptD.az(200L, 200L);
      this.vHt.Zf(this.Jdu.getListView().getHeight());
      ??? = ((as)this.Jdu.bh(as.class)).fFk();
      ((d)???).htg = true;
      ((d)???).aoV();
      ((d)???).fAF();
      this.Jdu.JOR.enableOptionMenu(false);
      this.Jdu.JOR.enableBackMenu(false);
      if (this.JAO != null)
      {
        an.aQu("keep_app_silent");
        this.vHt.setVoiceReactArea(-1);
        this.JAO.gA(getTalkerUserName());
        this.JAQ = this.JAO.getFileName();
        this.JAO.a(this.vHy);
        this.nKv.vibrate(50L);
        this.Jdu.bOo();
        fBu();
        this.JAO.a(this.vHx);
      }
      for (;;)
      {
        this.Jdu.setKeepScreenOn(true);
        ((ak)this.Jdu.bh(ak.class)).adn(3);
        ((ak)this.Jdu.bh(ak.class)).keepSignalling();
        acP(0);
        ((as)this.Jdu.bh(as.class)).a(this.Jdu.JOR, true);
        AppMethodBeat.o(34524);
        return true;
        ad.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
      }
    }
  }
  
  public final void dlb()
  {
    AppMethodBeat.i(34529);
    fBu();
    this.Jdu.fBR();
    AppMethodBeat.o(34529);
  }
  
  public final void dlc()
  {
    AppMethodBeat.i(34530);
    fBu();
    this.Jdu.fBR();
    AppMethodBeat.o(34530);
  }
  
  public final void dld()
  {
    AppMethodBeat.i(193852);
    fBu();
    this.Jdu.fBR();
    AppMethodBeat.o(193852);
  }
  
  public final void fBB()
  {
    AppMethodBeat.i(34542);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.CAMERA", 22, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.RECORD_AUDIO", 22, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (com.tencent.mm.bj.d.iru.GK(getTalkerUserName()))
    {
      ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(aj.getContext(), 2131760334, 0).show();
      AppMethodBeat.o(34542);
      return;
    }
    List localList;
    if (getTalkerUserName() != null)
    {
      localList = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arj(getTalkerUserName());
      ba.aBQ();
      String str1 = (String)com.tencent.mm.model.c.ajl().get(2, null);
      bool = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arg(getTalkerUserName());
      Iterator localIterator = localList.iterator();
      String str2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str2 = (String)localIterator.next();
      } while ((str1 == null) || (!str1.equals(str2)));
    }
    for (int i = 1;; i = 0)
    {
      if ((localList.size() >= com.tencent.mm.plugin.multitalk.c.e.drp()) && (i == 0))
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(aj.getContext(), aj.getContext().getString(2131761424, new Object[] { com.tencent.mm.plugin.multitalk.c.e.drp() }), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).dpa())
        {
          ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(aj.getContext(), aj.getContext().getString(2131761410), 0).show();
          AppMethodBeat.o(34542);
          return;
        }
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).doY())
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(aj.getContext(), aj.getContext().getString(2131761410), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.s.a.ch(this.Jdu.JOR.getContext()))
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in appbrand voice!");
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.s.a.ce(this.Jdu.JOR.getContext()))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (bool)
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        com.tencent.mm.ui.base.h.e(this.Jdu.JOR.getContext(), this.Jdu.JOR.getMMResources().getString(2131761452), "", this.Jdu.JOR.getMMResources().getString(2131761393), this.Jdu.JOR.getMMResources().getString(2131761390), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169853);
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arg(p.this.getTalkerUserName()))
            {
              Toast.makeText(aj.getContext(), aj.getContext().getString(2131761445), 0).show();
              AppMethodBeat.o(169853);
              return;
            }
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arm(p.this.getTalkerUserName())) {
              Toast.makeText(aj.getContext(), aj.getContext().getString(2131761403), 0).show();
            }
            AppMethodBeat.o(169853);
          }
        }, null);
        AppMethodBeat.o(34542);
        return;
      }
      localIntent.putExtra("chatroomName", getTalkerUserName());
      localIntent.putExtra("key_need_gallery", true);
      localIntent.putExtra("titile", this.Jdu.JOR.getMMResources().getString(2131761438));
      com.tencent.mm.bs.d.b(this.Jdu.JOR.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      if (this.vHt.fdK()) {
        this.vHt.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(34542);
      return;
    }
  }
  
  public final void fBC()
  {
    AppMethodBeat.i(34544);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.RECORD_AUDIO", 83, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34544);
      return;
    }
    if (this.vHt.fdK()) {
      this.vHt.setBottomPanelVisibility(8);
    }
    yb localyb = new yb();
    localyb.dMo.dsi = 5;
    localyb.dMo.talker = getTalkerUserName();
    localyb.dMo.context = this.Jdu.JOR.getContext();
    localyb.dMo.dMk = 3;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    com.tencent.mm.plugin.report.service.g.yhR.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
    AppMethodBeat.o(34544);
  }
  
  public final void fBD()
  {
    AppMethodBeat.i(34545);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.CAMERA", 21, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jdu.JOR.getContext(), "android.permission.RECORD_AUDIO", 21, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.Jdu.JOR.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    if (this.vHt.fdK()) {
      this.vHt.setBottomPanelVisibility(8);
    }
    yb localyb = new yb();
    localyb.dMo.dsi = 5;
    localyb.dMo.talker = getTalkerUserName();
    localyb.dMo.context = this.Jdu.JOR.getContext();
    localyb.dMo.dMk = 2;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    AppMethodBeat.o(34545);
  }
  
  public final void fBE()
  {
    AppMethodBeat.i(34548);
    ((ao)this.Jdu.bh(ao.class)).xY(false);
    this.vHt.setBottomPanelVisibility(8);
    AppMethodBeat.o(34548);
  }
  
  public final void fBF()
  {
    AppMethodBeat.i(34549);
    if (!q.a(this.Jdu.JOR, com.tencent.mm.loader.j.b.asg(), "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.Jdu.JOR.getContext(), this.Jdu.JOR.getMMResources().getString(2131763022), 1).show();
    }
    AppMethodBeat.o(34549);
  }
  
  public final void fBy()
  {
    AppMethodBeat.i(169859);
    Intent localIntent = new Intent();
    localIntent.setClass(this.Jdu.JOR.getContext(), NewFileExplorerUI.class);
    localIntent.putExtra("TO_USER", this.JAP);
    this.Jdu.a(localIntent, 227, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(169858);
        if (paramAnonymousInt1 == 227) {
          p.a(p.this, p.e(p.this), paramAnonymousInt2, paramAnonymousIntent);
        }
        AppMethodBeat.o(169858);
      }
    });
    AppMethodBeat.o(169859);
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(34521);
    if (this.JAO != null)
    {
      String str = this.JAO.getFileName();
      AppMethodBeat.o(34521);
      return str;
    }
    AppMethodBeat.o(34521);
    return "";
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(34535);
    if ((this.contact != null) && (com.tencent.mm.storage.am.zs(this.contact.field_username)))
    {
      str = this.JAP;
      AppMethodBeat.o(34535);
      return str;
    }
    if (this.contact == null)
    {
      AppMethodBeat.o(34535);
      return null;
    }
    String str = this.contact.field_username;
    AppMethodBeat.o(34535);
    return str;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(34537);
    if (this.JAR != null)
    {
      ad.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.JAR.release();
      this.JAR = null;
    }
    a.a locala = com.tencent.mm.ck.a.IRP;
    if (!a.a.aVi(this.JAO.getFileName()))
    {
      locala = com.tencent.mm.ck.a.IRP;
      if (!a.a.aVk(this.JAO.getFileName())) {
        fBv();
      }
    }
    this.izu.stopTimer();
    this.ptD.stopTimer();
    AppMethodBeat.o(34537);
  }
  
  public final void oo(boolean paramBoolean)
  {
    AppMethodBeat.i(34540);
    if (paramBoolean)
    {
      ((ak)this.Jdu.bh(ak.class)).keepSignalling();
      AppMethodBeat.o(34540);
      return;
    }
    ((ak)this.Jdu.bh(ak.class)).stopSignalling();
    AppMethodBeat.o(34540);
  }
  
  public final void release()
  {
    AppMethodBeat.i(34536);
    if (this.JAR != null)
    {
      ad.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.JAR.release();
      this.JAR = null;
    }
    AppMethodBeat.o(34536);
  }
  
  public static final class a
  {
    String desc;
    String title;
  }
  
  public static final class b
  {
    boolean JBk = false;
    p.a JBl;
    p.a JBm;
    p.a JBn;
    p.a JBo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p
 * JD-Core Version:    0.7.0.1
 */