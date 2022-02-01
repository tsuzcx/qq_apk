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
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.ak.j.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.br.d.a;
import com.tencent.mm.cj.a.a;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.platformtools.ac;
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
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.al;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.vfs.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public final class q
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  public static boolean JVE = true;
  private boolean JSi;
  private j JVF;
  private String JVG;
  private String JVH;
  private ToneGenerator JVI;
  private boolean JVJ;
  private boolean JVK;
  public boolean JVL;
  private boolean JVM;
  private volatile boolean JVN;
  private volatile boolean JVO;
  private boolean JVP;
  private com.tencent.mm.ui.chatting.e.a Jyf;
  private com.tencent.mm.storage.an contact;
  private final com.tencent.mm.sdk.platformtools.aw iCn;
  private String kbf;
  private Object lock;
  private Vibrator nQa;
  private final com.tencent.mm.sdk.platformtools.aw pAh;
  private String seP;
  private final j.a vTB;
  private final j.b vTC;
  private ChatFooter vTx;
  public AppPanel.a vUh;
  
  public q(com.tencent.mm.ui.chatting.e.a parama, ChatFooter paramChatFooter, String paramString)
  {
    AppMethodBeat.i(34518);
    this.JVM = true;
    this.seP = "";
    this.kbf = "";
    this.vTB = new j.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(34487);
        q.a(q.this).reset();
        q.b(q.this).stopTimer();
        q.c(q.this).stopTimer();
        ao.aRS("keep_app_silent");
        q.d(q.this).a(ChatFooter.h.FvD);
        at localat = (at)q.e(q.this).bh(at.class);
        if ((localat != null) && (localat.fJn() != null)) {
          localat.fJn().fEI();
        }
        ae.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        q.e(q.this).Kkd.enableOptionMenu(true);
        q.e(q.this).Kkd.enableBackMenu(true);
        Toast.makeText(q.e(q.this).Kkd.getContext(), q.e(q.this).Kkd.getContext().getString(2131757276), 0).show();
        AppMethodBeat.o(34487);
      }
    };
    this.vTC = new j.b()
    {
      public final void aEY()
      {
        AppMethodBeat.i(34491);
        q.d(q.this).fhi();
        AppMethodBeat.o(34491);
      }
    };
    this.JVN = false;
    this.JVO = false;
    this.lock = new Object();
    this.iCn = new com.tencent.mm.sdk.platformtools.aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34493);
        q.d(q.this).ZM(q.a(q.this).getMaxAmplitude());
        AppMethodBeat.o(34493);
        return true;
      }
    }, true);
    this.JVP = false;
    this.pAh = new com.tencent.mm.sdk.platformtools.aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34494);
        long l = q.a(q.this).PY();
        ae.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(l)));
        int i = (int)((60000L - l) / 1000L);
        if ((l >= 50000L) && (l <= 60000L) && (!q.f(q.this)))
        {
          bu.jj(q.e(q.this).Kkd.getContext());
          q.g(q.this);
        }
        q.d(q.this).setVoiceReactArea(i);
        if (l >= 60000L)
        {
          ae.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
          if (!q.d(q.this).fib())
          {
            q.h(q.this);
            q.d(q.this).a(ChatFooter.h.Fvy);
          }
          for (;;)
          {
            be.aI(q.e(q.this).Kkd.getContext(), 2131764424);
            AppMethodBeat.o(34494);
            return false;
            q.d(q.this).fhH();
          }
        }
        AppMethodBeat.o(34494);
        return true;
      }
    }, true);
    this.vUh = new AppPanel.a()
    {
      com.tencent.mm.ui.widget.a.e xeN = null;
      
      public final void Kh(int paramAnonymousInt)
      {
        AppMethodBeat.i(34504);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34504);
          return;
          bc.aCg();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.t.g(q.e(q.this).Kkd.getContext(), q.e(q.this).Kkd.getContentView());
            AppMethodBeat.o(34504);
            return;
          }
          Object localObject = q.e(q.this).Kkd.getContext().getSharedPreferences(ak.fow(), 0).getString("gallery", "1");
          f.OP(19);
          if (((String)localObject).equalsIgnoreCase("0")) {
            com.tencent.mm.pluginsdk.ui.tools.q.f(q.e(q.this).Kkd);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            AppMethodBeat.o(34504);
            return;
            localObject = q.e(q.this).fJy();
            String str = q.e(q.this).getTalkerUserName();
            Intent localIntent = new Intent();
            if (q.e(q.this).fJC()) {
              localIntent.putExtra("gallery_report_tag", 20);
            }
            for (;;)
            {
              if (com.tencent.mm.storage.an.aUv(str)) {
                localIntent.putExtra("album_business_tag", "album_business_byp");
              }
              if ((!q.i(q.this)) || (!q.JVE)) {
                break label293;
              }
              com.tencent.mm.pluginsdk.ui.tools.q.a(q.e(q.this).Kkd, (String)localObject, str, localIntent);
              break;
              localIntent.putExtra("gallery_report_tag", 21);
            }
            label293:
            if (com.tencent.mm.storage.an.zd(str)) {
              com.tencent.mm.pluginsdk.ui.tools.q.a(q.e(q.this).Kkd, 12, (String)localObject, str, localIntent);
            } else {
              com.tencent.mm.pluginsdk.ui.tools.q.a(q.e(q.this).Kkd, 3, (String)localObject, str, localIntent);
            }
          }
          localObject = new k(com.tencent.mm.loader.j.b.asv());
          if ((!((k)localObject).exists()) && (!((k)localObject).mkdirs()))
          {
            Toast.makeText(q.e(q.this).Kkd.getContext(), q.e(q.this).Kkd.getMMResources().getString(2131757320), 1).show();
            AppMethodBeat.o(34504);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Kkd.getContext(), "android.permission.CAMERA", 20, "", "");
          ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), q.e(q.this).Kkd.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34504);
            return;
          }
          q.this.fFH();
        }
      }
      
      public final void Ki(int paramAnonymousInt)
      {
        AppMethodBeat.i(34510);
        if ((!com.tencent.mm.r.a.n(q.e(q.this).Kkd.getContext(), true)) && (!com.tencent.mm.r.a.ch(q.e(q.this).Kkd.getContext())) && (!com.tencent.mm.r.a.cf(q.e(q.this).Kkd.getContext())) && (!com.tencent.mm.r.a.cj(q.e(q.this).Kkd.getContext()))) {
          q.this.ady(paramAnonymousInt);
        }
        AppMethodBeat.o(34510);
      }
      
      public final void d(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(34505);
        ((com.tencent.mm.ui.chatting.d.b.b)q.e(q.this).bh(com.tencent.mm.ui.chatting.d.b.b.class)).t(paramAnonymousg);
        AppMethodBeat.o(34505);
      }
      
      public final void doh()
      {
        AppMethodBeat.i(34499);
        if (com.tencent.mm.r.a.cf(q.e(q.this).Kkd.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.r.a.cg(q.e(q.this).Kkd.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.r.a.cj(q.e(q.this).Kkd.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        yg localyg = new yg();
        com.tencent.mm.sdk.b.a.IvT.l(localyg);
        if ((q.this.getTalkerUserName() != null) && (!q.this.getTalkerUserName().equals(localyg.dNC.talker)) && ((localyg.dNC.dlr) || (localyg.dNC.dls)))
        {
          if (localyg.dNC.dND) {}
          for (int i = 2131756778;; i = 2131756779)
          {
            Toast.makeText(q.e(q.this).Kkd.getContext(), i, 0).show();
            ae.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34499);
            return;
          }
        }
        final boolean bool;
        if (1 == com.tencent.mm.n.g.acL().getInt("EnableVoiceVoipFromPlugin", 0))
        {
          if ((!com.tencent.mm.storage.an.aUq(q.e(q.this).Cqh.field_username)) && (!com.tencent.mm.model.x.zV(q.e(q.this).Cqh.field_username))) {
            break label415;
          }
          if ((((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Jc(q.e(q.this).Cqh.field_openImAppid) & 0x2000) == 0) {
            bool = true;
          }
        }
        for (;;)
        {
          this.xeN = new com.tencent.mm.ui.widget.a.e(q.e(q.this).Kkd.getContext(), 1, false);
          this.xeN.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(34495);
              paramAnonymous2l.aM(2, 2131755762, 2131691164);
              if (!bool) {
                paramAnonymous2l.aM(1, 2131755764, 2131691165);
              }
              AppMethodBeat.o(34495);
            }
          };
          this.xeN.LfT = new n.e()
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
                q.this.dEo();
                AppMethodBeat.o(34496);
                return;
                q.this.dEp();
              }
            }
          };
          this.xeN.cPF();
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(34499);
            return;
            bool = false;
            break;
            q.this.fFF();
          }
          label415:
          bool = false;
        }
      }
      
      public final void doi()
      {
        AppMethodBeat.i(34500);
        if (com.tencent.mm.r.a.cf(q.e(q.this).Kkd.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.r.a.cg(q.e(q.this).Kkd.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.r.a.cj(q.e(q.this).Kkd.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        yg localyg = new yg();
        com.tencent.mm.sdk.b.a.IvT.l(localyg);
        if ((!q.this.getTalkerUserName().equals(localyg.dNC.talker)) && ((localyg.dNC.dlr) || (localyg.dNC.dls)))
        {
          if (localyg.dNC.dND) {}
          for (int i = 2131756778;; i = 2131756779)
          {
            Toast.makeText(q.e(q.this).Kkd.getContext(), i, 0).show();
            ae.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34500);
            return;
          }
        }
        q.this.fFE();
        AppMethodBeat.o(34500);
      }
      
      public final void doj()
      {
        AppMethodBeat.i(34501);
        if ((!com.tencent.mm.r.a.ch(q.e(q.this).Kkd.getContext())) && (!com.tencent.mm.r.a.cf(q.e(q.this).Kkd.getContext())) && (!com.tencent.mm.r.a.cj(q.e(q.this).Kkd.getContext())))
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Kkd.getContext(), "android.permission.RECORD_AUDIO", 81, "", "");
          ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), q.e(q.this).Kkd.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34501);
            return;
          }
          q.this.fFG();
        }
        AppMethodBeat.o(34501);
      }
      
      public final void dok()
      {
        AppMethodBeat.i(34502);
        ((ab)q.e(q.this).bh(ab.class)).fIy();
        AppMethodBeat.o(34502);
      }
      
      public final void dol()
      {
        AppMethodBeat.i(34503);
        ((com.tencent.mm.ui.chatting.d.b.e)q.e(q.this).bh(com.tencent.mm.ui.chatting.d.b.e.class)).fHa();
        AppMethodBeat.o(34503);
      }
      
      public final void dom()
      {
        AppMethodBeat.i(34506);
        com.tencent.mm.br.d.b(q.e(q.this).Kkd.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.o(34506);
      }
      
      public final void don()
      {
        AppMethodBeat.i(34507);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("3");
        if (com.tencent.mm.al.g.vz(q.j(q.this).field_username))
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
        localIntent.putExtra("key_to_user", q.j(q.this).field_username);
        localIntent.putExtra("key_fav_item_id", TextUtils.join(",", localArrayList));
        com.tencent.mm.plugin.fav.a.b.b(q.e(q.this).Kkd.getContext(), ".ui.FavSelectUI", localIntent);
        com.tencent.mm.plugin.report.service.g.yxI.f(14103, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(34507);
      }
      
      public final void doo()
      {
        AppMethodBeat.i(34508);
        Intent localIntent = new Intent();
        localIntent.putExtra("service_app_talker_user", q.this.getTalkerUserName());
        com.tencent.mm.br.d.a(q.e(q.this).Kkd, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
        AppMethodBeat.o(34508);
      }
      
      public final void dop()
      {
        AppMethodBeat.i(34509);
        Object localObject;
        if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
        {
          localObject = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new HashMap());
          ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.flutter.a.a.class)).a(q.e(q.this).Kkd.getContext(), (com.tencent.mm.plugin.flutter.a.c)localObject);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(12065, new Object[] { Integer.valueOf(4) });
          AppMethodBeat.o(34509);
          return;
          localObject = new Intent();
          ((Intent)localObject).putExtra("download_entrance_scene", 17);
          ((Intent)localObject).putExtra("preceding_scence", 13);
          com.tencent.mm.br.d.b(q.e(q.this).Kkd.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
        }
      }
      
      public final void doq()
      {
        AppMethodBeat.i(34511);
        com.tencent.mm.plugin.report.service.g.yxI.f(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        q.a(q.this, q.k(q.this) + "_" + System.currentTimeMillis());
        final String str = UUID.randomUUID().toString();
        q.Q(2, 0, q.l(q.this));
        final q.b localb = q.fFI();
        com.tencent.mm.kernel.g.ajS();
        final int i = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.ILk, 0);
        if (q.m(q.this))
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
          if ((i == 1) && (localb.JWb))
          {
            locale = new com.tencent.mm.ui.widget.a.e(q.e(q.this).Kkd.getContext(), 1, false);
            locale.LfS = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(163290);
                paramAnonymous2l.d(0, q.e(q.this).Kkd.getMMResources().getString(2131757246));
                q.a locala = q.a(localb);
                if (locala != null) {
                  paramAnonymous2l.a(1, locala.title, locala.desc, 0);
                }
                AppMethodBeat.o(163290);
              }
            };
            locale.LfT = new n.e()
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
                  q.b(q.this, str);
                  com.tencent.mm.plugin.report.service.g.yxI.f(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
                  q.Q(4, 0, q.l(q.this));
                  AppMethodBeat.o(163291);
                  return;
                  q.n(q.this);
                }
              }
            };
            locale.cPF();
            q.fFJ();
            q.Q(3, 0, q.l(q.this));
            AppMethodBeat.o(34511);
            return;
          }
          q.b(q.this, str);
          com.tencent.mm.plugin.report.service.g.yxI.f(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        if (((i != 1) || (!localb.JWb)) && (q.fFB()))
        {
          q.c(q.this, str);
          com.tencent.mm.plugin.report.service.g.yxI.f(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(q.e(q.this).Kkd.getContext(), 1, false);
        locale.LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(163292);
            paramAnonymous2l.d(0, q.e(q.this).Kkd.getMMResources().getString(2131757246));
            Object localObject;
            if (!q.fFB())
            {
              localObject = new cm();
              ((cm)localObject).eeh = 13L;
              ((cm)localObject).aLH();
              paramAnonymous2l.d(1, q.e(q.this).Kkd.getMMResources().getString(2131757245));
            }
            if ((localb.JWb) && (i == 1))
            {
              localObject = q.a(localb);
              if (localObject != null) {
                paramAnonymous2l.a(2, ((q.a)localObject).title, ((q.a)localObject).desc, 0);
              }
            }
            AppMethodBeat.o(163292);
          }
        };
        locale.LfT = new n.e()
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
              q.c(q.this, str);
              com.tencent.mm.plugin.report.service.g.yxI.f(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
              q.Q(4, 0, q.l(q.this));
              AppMethodBeat.o(163293);
              return;
              com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
              localIntent.putExtra("key_username", q.this.getTalkerUserName());
              localIntent.putExtra("key_way", 0);
              localIntent.putExtra("pay_channel", 11);
              com.tencent.mm.br.d.b(q.e(q.this).Kkd.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", localIntent);
              paramAnonymous2MenuItem = new cm();
              paramAnonymous2MenuItem.eeh = 1L;
              paramAnonymous2MenuItem.aLH();
              q.Q(5, 0, q.l(q.this));
              AppMethodBeat.o(163293);
              return;
              q.n(q.this);
            }
          }
        };
        locale.cPF();
        q.fFJ();
        q.Q(3, 0, q.l(q.this));
        AppMethodBeat.o(34511);
      }
      
      public final void dor()
      {
        AppMethodBeat.i(34512);
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(81, Boolean.FALSE);
        if (!az.isNetworkConnected(q.e(q.this).Kkd.getContext()))
        {
          com.tencent.mm.bh.e.a(q.e(q.this).Kkd.getContext(), 2131764895, null);
          AppMethodBeat.o(34512);
          return;
        }
        q.this.fFD();
        AppMethodBeat.o(34512);
      }
      
      public final void dos()
      {
        AppMethodBeat.i(34513);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_scene", 4);
        localIntent.putExtra("enterprise_biz_name", q.this.getTalkerUserName());
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)q.e(q.this).bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGW());
        com.tencent.mm.br.d.b(q.e(q.this).Kkd.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
        AppMethodBeat.o(34513);
      }
      
      public final void dot()
      {
        AppMethodBeat.i(187154);
        ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.gamelife.c.class)).enterSendGift(q.e(q.this).Kkd.getContext(), q.this.getTalkerUserName());
        AppMethodBeat.o(187154);
      }
      
      public final void dou()
      {
        AppMethodBeat.i(34514);
        if (q.m(q.this))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enter_scene", 1);
          localIntent.putExtra("chatroom_name", q.this.getTalkerUserName());
          com.tencent.mm.br.d.b(q.e(q.this).Kkd.getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        }
        AppMethodBeat.o(34514);
      }
      
      public final void dov()
      {
        AppMethodBeat.i(34515);
        com.tencent.mm.plugin.report.service.g.yxI.f(14523, new Object[] { Integer.valueOf(0) });
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Kkd.getContext(), "android.permission.READ_EXTERNAL_STORAGE", 145, q.e(q.this).Kkd.getContext().getString(2131761885), q.e(q.this).Kkd.getContext().getString(2131763056));
        ae.i("MicroMsg.ChattingFooterEventImpl", "checkPermission checkStorage[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), q.e(q.this).Kkd.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(34515);
          return;
        }
        q.this.fFA();
        AppMethodBeat.o(34515);
      }
      
      public final void dow()
      {
        AppMethodBeat.i(187155);
        ae.i("MicroMsg.ChattingFooterEventImpl", "gotoRoomLiveEntrance");
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Kkd.getContext(), "android.permission.CAMERA", 25, "", "");
        ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), q.e(q.this).Kkd.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(187155);
          return;
        }
        bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Kkd.getContext(), "android.permission.RECORD_AUDIO", 25, "", "");
        ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), q.e(q.this).Kkd.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(187155);
          return;
        }
        if ((!com.tencent.mm.r.a.n(q.e(q.this).Kkd.getContext(), true)) && (!com.tencent.mm.r.a.ch(q.e(q.this).Kkd.getContext())) && (!com.tencent.mm.r.a.cf(q.e(q.this).Kkd.getContext())) && (!com.tencent.mm.r.a.cj(q.e(q.this).Kkd.getContext())))
        {
          if (com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.JdD, 0) == 1)
          {
            final Activity localActivity = q.e(q.this).Kkd.getContext();
            com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
            locall.LfS = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(187152);
                paramAnonymous2l.d(0, localActivity.getString(2131766586));
                paramAnonymous2l.d(1, localActivity.getString(2131766585));
                AppMethodBeat.o(187152);
              }
            };
            locall.LfT = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(187153);
                if (paramAnonymous2Int == 0)
                {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().a(q.e(q.this).Kkd.getContext(), LiveConfig.T(q.e(q.this).getTalkerUserName(), LiveConfig.gIZ));
                  AppMethodBeat.o(187153);
                  return;
                }
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(q.e(q.this).Kkd.getContext(), LiveConfig.T(q.e(q.this).getTalkerUserName(), LiveConfig.gIZ));
                AppMethodBeat.o(187153);
              }
            };
            locall.fOP();
            AppMethodBeat.o(187155);
            return;
          }
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(q.e(q.this).Kkd.getContext(), LiveConfig.T(q.e(q.this).getTalkerUserName(), LiveConfig.gIZ));
        }
        AppMethodBeat.o(187155);
      }
      
      public final void dox()
      {
        AppMethodBeat.i(179848);
        ((com.tencent.mm.ui.chatting.d.b.x)q.e(q.this).bh(com.tencent.mm.ui.chatting.d.b.x.class)).fHX();
        AppMethodBeat.o(179848);
      }
      
      public final void doy()
      {
        AppMethodBeat.i(187156);
        ae.i("MicroMsg.ChattingFooterEventImpl", "onEnterGroupSolitaire() chatroom:%s", new Object[] { q.e(q.this).getTalkerUserName() });
        Intent localIntent = new Intent();
        localIntent.putExtra("key_group_solitatire_create", true);
        localIntent.putExtra("key_group_solitatire_scene", 5);
        com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
        locala.header = (q.e(q.this).Kkd.getContext().getString(2131760093) + "\n");
        locala.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(locala);
        locala.separator = ".";
        locala.uNi = 1;
        localIntent.putExtra("key_group_solitatire_key", locala.field_key);
        localIntent.putExtra("key_group_solitatire_chatroom_username", q.e(q.this).getTalkerUserName());
        com.tencent.mm.plugin.groupsolitaire.b.b.a(q.e(q.this).getTalkerUserName(), locala);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(q.e(q.this).getTalkerUserName(), locala);
        com.tencent.mm.br.d.b(q.e(q.this).Kkd.getContext(), "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent);
        AppMethodBeat.o(187156);
      }
    };
    this.Jyf = parama;
    this.vTx = paramChatFooter;
    this.JVG = paramString;
    bc.aCg();
    this.contact = com.tencent.mm.model.c.azF().BH(paramString);
    this.JVJ = com.tencent.mm.model.x.wb(this.Jyf.getTalkerUserName());
    this.JVK = com.tencent.mm.model.x.Ae(this.Jyf.getTalkerUserName());
    boolean bool;
    if ((this.JVJ) || (this.JVK))
    {
      bool = true;
      this.JSi = bool;
      this.nQa = ((Vibrator)this.Jyf.Kkd.getContext().getSystemService("vibrator"));
      if (!com.tencent.mm.model.x.AK(this.JVG)) {
        break label347;
      }
      this.JVF = new com.tencent.mm.plugin.subapp.d.i();
      ae.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.JVF.a(this.vTC);
      this.JVF.a(this.vTB);
      paramChatFooter.setAppPanelListener(this.vUh);
      this.JVM = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFA, true);
      bc.aCg();
      this.seP = ((String)com.tencent.mm.model.c.ajA().get(2, null));
      AppMethodBeat.o(34518);
      return;
      bool = false;
      break;
      label347:
      parama = this.JVG;
      int i;
      if (com.tencent.mm.model.x.AV(parama)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label532;
        }
        this.JVF = new com.tencent.mm.audio.b.h(this.Jyf.Kkd.getContext(), true);
        ae.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(parama);
        if ((parama != null) && (parama.fug()))
        {
          paramString = com.tencent.mm.al.g.eX(parama.field_username);
          if (paramString != null)
          {
            paramString = paramString.bX(false);
            if (paramString != null)
            {
              if (paramString.cRf != null) {
                paramString.cRj = "1".equals(paramString.cRf.optString("CanReceiveSpeexVoice"));
              }
              if (paramString.cRj)
              {
                ae.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + parama.field_username + " canReceiveSpeexVoice");
                i = 1;
                continue;
              }
            }
          }
        }
        i = 0;
      }
      label532:
      this.JVF = new com.tencent.mm.audio.b.h(this.Jyf.Kkd.getContext(), false);
      ae.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
  }
  
  public static void Q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(163296);
    com.tencent.mm.g.b.a.l locall = new com.tencent.mm.g.b.a.l();
    locall.dTq = paramInt1;
    locall.dTt = System.currentTimeMillis();
    locall.dTr = locall.t("SessionId", paramString, true);
    locall.dTs = paramInt2;
    locall.aLH();
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
    String str = ad.fom();
    if ("zh_CN".equals(str))
    {
      paramb = paramb.JWc;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_TW".equals(str))
    {
      paramb = paramb.JWe;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_HK".equals(str))
    {
      paramb = paramb.JWd;
      AppMethodBeat.o(163300);
      return paramb;
    }
    paramb = paramb.JWf;
    AppMethodBeat.o(163300);
    return paramb;
  }
  
  private static void adx(int paramInt)
  {
    AppMethodBeat.i(34541);
    qj localqj = new qj();
    localqj.dGi.state = paramInt;
    com.tencent.mm.sdk.b.a.IvT.l(localqj);
    AppMethodBeat.o(34541);
  }
  
  public static void efC()
  {
    CaptureDataManager.xNV.xNU = null;
  }
  
  public static boolean fFB()
  {
    AppMethodBeat.i(163297);
    bc.aCg();
    Integer localInteger1 = (Integer)com.tencent.mm.model.c.ajA().get(am.a.ILi, Integer.valueOf(0));
    bc.aCg();
    Integer localInteger2 = (Integer)com.tencent.mm.model.c.ajA().get(am.a.ILj, Integer.valueOf(0));
    if (((localInteger1.intValue() != 1) && (localInteger2.intValue() != 1)) || (!v.aAU()))
    {
      AppMethodBeat.o(163297);
      return true;
    }
    AppMethodBeat.o(163297);
    return false;
  }
  
  private static b fFC()
  {
    AppMethodBeat.i(163298);
    b localb = new b();
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMp, "");
    if (bu.isNullOrNil((String)localObject))
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
        localb.JWb = false;
        localb.JWc = l((JSONObject)localObject, "simple_chinese");
        localb.JWd = l((JSONObject)localObject, "xg_traditional_chinese");
        localb.JWe = l((JSONObject)localObject, "tw_traditional_chinese");
        localb.JWf = l((JSONObject)localObject, "english");
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(163298);
      return localb;
      localb.JWb = true;
    }
  }
  
  @Deprecated
  @SuppressLint({"NewApi"})
  private void fFw()
  {
    AppMethodBeat.i(34532);
    this.Jyf.xY(true);
    AppMethodBeat.o(34532);
  }
  
  private boolean fFx()
  {
    boolean bool = false;
    int i = 1;
    AppMethodBeat.i(34534);
    this.Jyf.Kkd.enableOptionMenu(true);
    this.Jyf.Kkd.enableBackMenu(true);
    if (this.JVF != null) {
      if ((this.JVF.isRecording()) && (fFy()))
      {
        bool = this.JVF.GB();
        this.iCn.stopTimer();
        this.pAh.stopTimer();
        if (i != 0) {
          fFz();
        }
        ao.aRS("keep_app_silent");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34534);
      return bool;
      i = 0;
      break;
      ae.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
    }
  }
  
  private boolean fFy()
  {
    AppMethodBeat.i(34538);
    if ((this.contact.field_username.equals("medianote")) && ((v.aAG() & 0x4000) == 0))
    {
      AppMethodBeat.o(34538);
      return true;
    }
    AppMethodBeat.o(34538);
    return false;
  }
  
  private void fFz()
  {
    AppMethodBeat.i(34539);
    bv localbv = new bv();
    localbv.ui("medianote");
    localbv.setType(34);
    localbv.kt(1);
    localbv.uj(this.JVH);
    localbv.setStatus(2);
    localbv.setContent(p.b(v.aAC(), this.JVF.PW(), false));
    localbv.qN(bl.BQ("medianote"));
    if (this.JVF.PZ() == 2) {
      localbv.tk("SOURCE_SILK_FILE");
    }
    bc.aCg();
    long l = com.tencent.mm.model.c.azI().ar(localbv);
    if (l <= 0L)
    {
      ae.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
      AppMethodBeat.o(34539);
      return;
    }
    ae.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(l)));
    AppMethodBeat.o(34539);
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
    this.Jyf.setKeepScreenOn(false);
    AppMethodBeat.o(34533);
  }
  
  public final long PY()
  {
    AppMethodBeat.i(34522);
    if (this.JVF != null)
    {
      long l = this.JVF.PY();
      AppMethodBeat.o(34522);
      return l;
    }
    AppMethodBeat.o(34522);
    return 0L;
  }
  
  public final void T(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34531);
    if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
    {
      fFw();
      this.Jyf.fFT();
    }
    AppMethodBeat.o(34531);
  }
  
  public final void ady(final int paramInt)
  {
    AppMethodBeat.i(34543);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.CAMERA", 18, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.RECORD_AUDIO", 18, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    Object localObject1;
    if ((com.tencent.mm.sdk.a.b.fnF()) || (ac.iSF))
    {
      localObject1 = new com.tencent.mm.ui.tools.l(this.Jyf.Kkd.getContext());
      ((com.tencent.mm.ui.tools.l)localObject1).LfS = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(169854);
          paramAnonymousl.d(1, q.e(q.this).Kkd.getMMResources().getString(2131755747));
          paramAnonymousl.d(5, "拍摄参数设置面板");
          AppMethodBeat.o(169854);
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).LfT = new n.e()
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
            com.tencent.mm.plugin.report.service.g.yxI.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            paramAnonymousMenuItem = new SightParams(1, paramInt);
            Object localObject = com.tencent.mm.modelvideo.t.HI(q.this.getTalkerUserName());
            com.tencent.mm.modelvideo.o.aNh();
            String str = com.tencent.mm.modelvideo.t.HJ((String)localObject);
            com.tencent.mm.modelvideo.o.aNh();
            paramAnonymousMenuItem = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.HK((String)localObject), paramAnonymousMenuItem.hxV, paramAnonymousMenuItem.hxV.duration * 1000, 1);
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFB, false)) {
              paramAnonymousMenuItem.remuxType = 2;
            }
            localObject = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject).roH = 3;
            if (q.o(q.this)) {
              ((VideoCaptureReportInfo)localObject).roH = 4;
            }
            paramAnonymousMenuItem.xOx = ((VideoCaptureReportInfo)localObject);
            localObject = new UICustomParam.a();
            ((UICustomParam.a)localObject).abH();
            ((UICustomParam.a)localObject).abG();
            ((UICustomParam.a)localObject).cP(true);
            paramAnonymousMenuItem.xOh = ((UICustomParam.a)localObject).ggq;
            localObject = new CaptureDataManager.c()
            {
              public final void a(Context paramAnonymous2Context, CaptureDataManager.CaptureVideoNormalModel paramAnonymous2CaptureVideoNormalModel, Bundle paramAnonymous2Bundle)
              {
                AppMethodBeat.i(169855);
                paramAnonymous2Bundle = new byg();
                paramAnonymous2Bundle.Hlb = true;
                paramAnonymous2Bundle.Hla = false;
                String str = com.tencent.mm.vfs.o.aZW(paramAnonymous2CaptureVideoNormalModel.videoPath);
                paramAnonymous2Bundle = new SightCaptureResult(true, paramAnonymous2CaptureVideoNormalModel.videoPath, paramAnonymous2CaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymous2CaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymous2CaptureVideoNormalModel.xNX.longValue() * 1.0F / 1000.0F), paramAnonymous2Bundle);
                if (paramAnonymous2CaptureVideoNormalModel.xNY.booleanValue())
                {
                  paramAnonymous2Bundle.vYw = true;
                  paramAnonymous2Bundle.pGA = false;
                  paramAnonymous2Bundle.vYE = paramAnonymous2CaptureVideoNormalModel.thumbPath;
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
            CaptureDataManager.xNV.xNU = ((CaptureDataManager.b)localObject);
            if (q.p(q.this))
            {
              localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(q.e(q.this).Kkd.getContext(), 226, 2130772137, 2130772138, paramAnonymousMenuItem);
              AppMethodBeat.o(169856);
              return;
            }
            com.tencent.mm.pluginsdk.ui.tools.q.a(q.e(q.this).Kkd, new Intent(), q.this.getTalkerUserName(), paramInt);
            AppMethodBeat.o(169856);
            return;
            com.tencent.mm.br.d.b(q.e(q.this).Kkd.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
          }
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).fOP();
      AppMethodBeat.o(34543);
      return;
    }
    if (!ac.iSG)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new SightParams(1, paramInt);
      Object localObject2 = com.tencent.mm.modelvideo.t.HI(getTalkerUserName());
      com.tencent.mm.modelvideo.o.aNh();
      String str = com.tencent.mm.modelvideo.t.HJ((String)localObject2);
      com.tencent.mm.modelvideo.o.aNh();
      localObject1 = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.HK((String)localObject2), ((SightParams)localObject1).hxV, ((SightParams)localObject1).hxV.duration * 1000, 1);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFB, false)) {
        ((RecordConfigProvider)localObject1).remuxType = 2;
      }
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).roH = 3;
      if (this.JSi) {
        ((VideoCaptureReportInfo)localObject2).roH = 4;
      }
      ((RecordConfigProvider)localObject1).xOx = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).abH();
      ((UICustomParam.a)localObject2).abG();
      ((UICustomParam.a)localObject2).cP(true);
      ((RecordConfigProvider)localObject1).xOh = ((UICustomParam.a)localObject2).ggq;
      localObject2 = new CaptureDataManager.c()
      {
        public final void a(Context paramAnonymousContext, CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(169857);
          paramAnonymousBundle = new byg();
          paramAnonymousBundle.Hlb = true;
          paramAnonymousBundle.Hla = false;
          String str = com.tencent.mm.vfs.o.aZW(paramAnonymousCaptureVideoNormalModel.videoPath);
          paramAnonymousBundle = new SightCaptureResult(true, paramAnonymousCaptureVideoNormalModel.videoPath, paramAnonymousCaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymousCaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymousCaptureVideoNormalModel.xNX.longValue() * 1.0F / 1000.0F), paramAnonymousBundle);
          if (paramAnonymousCaptureVideoNormalModel.xNY.booleanValue())
          {
            paramAnonymousBundle.vYw = true;
            paramAnonymousBundle.pGA = false;
            paramAnonymousBundle.vYE = paramAnonymousCaptureVideoNormalModel.thumbPath;
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
      CaptureDataManager.xNV.xNU = ((CaptureDataManager.b)localObject2);
      if (this.JVM)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this.Jyf.Kkd.getContext(), 226, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
        AppMethodBeat.o(34543);
        return;
      }
      com.tencent.mm.pluginsdk.ui.tools.q.a(this.Jyf.Kkd, new Intent(), getTalkerUserName(), paramInt);
    }
    AppMethodBeat.o(34543);
  }
  
  public final void aoa(String paramString)
  {
    AppMethodBeat.i(34526);
    ((com.tencent.mm.ui.chatting.d.b.an)this.Jyf.bh(com.tencent.mm.ui.chatting.d.b.an.class)).aoa(paramString);
    AppMethodBeat.o(34526);
  }
  
  public final boolean aqs(String paramString)
  {
    AppMethodBeat.i(34525);
    fFw();
    this.Jyf.fFT();
    boolean bool = ((com.tencent.mm.ui.chatting.d.b.an)this.Jyf.bh(com.tencent.mm.ui.chatting.d.b.an.class)).aXJ(paramString);
    AppMethodBeat.o(34525);
    return bool;
  }
  
  public final boolean aqt(String paramString)
  {
    AppMethodBeat.i(34528);
    if (!bu.isNullOrNil(paramString))
    {
      s.Iw(paramString);
      com.tencent.mm.modelvoice.o.aNY().run();
      AppMethodBeat.o(34528);
      return true;
    }
    AppMethodBeat.o(34528);
    return false;
  }
  
  public final void dEo()
  {
    AppMethodBeat.i(34546);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.RECORD_AUDIO", 82, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34546);
      return;
    }
    yh localyh = new yh();
    localyh.dNE.dto = 5;
    localyh.dNE.talker = getTalkerUserName();
    localyh.dNE.context = this.Jyf.Kkd.getContext();
    localyh.dNE.dNA = 4;
    if (this.vTx.fhz()) {
      this.vTx.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    AppMethodBeat.o(34546);
  }
  
  public final void dEp()
  {
    AppMethodBeat.i(34547);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.CAMERA", 19, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.RECORD_AUDIO", 19, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    yh localyh = new yh();
    localyh.dNE.dto = 5;
    localyh.dNE.talker = getTalkerUserName();
    localyh.dNE.context = this.Jyf.Kkd.getContext();
    localyh.dNE.dNA = 2;
    if (this.vTx.fhz()) {
      this.vTx.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    AppMethodBeat.o(34547);
  }
  
  public final boolean dnV()
  {
    AppMethodBeat.i(34519);
    synchronized (this.lock)
    {
      this.JVN = true;
      if (!this.JVO)
      {
        ae.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34519);
        return false;
      }
    }
    this.JVO = false;
    releaseWakeLock();
    if (!fFx())
    {
      this.vTx.cfn();
      ae.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
      ((at)this.Jyf.bh(at.class)).fJn().fEI();
      ((al)this.Jyf.bh(al.class)).adU(4);
      ((al)this.Jyf.bh(al.class)).stopSignalling();
      adx(1);
      ((at)this.Jyf.bh(at.class)).a(this.Jyf.Kkd, false);
      AppMethodBeat.o(34519);
      return true;
    }
    this.vTx.setExitType(0);
    ??? = this.vTx;
    if (!((ChatFooter)???).Ftl) {
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMr, 1)) {
        break label369;
      }
    }
    label369:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject3 = ak.getContext().getSharedPreferences(ChatFooter.FuM, 0);
        if (((SharedPreferences)localObject3).getInt("trans2txt_edu_key", 0) == 0)
        {
          ((SharedPreferences)localObject3).edit().putInt("trans2txt_edu_key", 1).apply();
          localObject3 = new bv();
          ??? = ((ChatFooter)???).FsE.getTalkerUserName();
          ((bv)localObject3).qN(bl.BQ((String)???));
          ((bv)localObject3).ui((String)???);
          ((bv)localObject3).setContent(ak.getContext().getString(2131764710));
          ((bv)localObject3).setType(10000);
          ((bv)localObject3).setStatus(6);
          ((bv)localObject3).kt(0);
          bc.aCg();
          com.tencent.mm.model.c.azI().ar((bv)localObject3);
        }
      }
      this.vTx.a(ChatFooter.h.Fvy);
      ae.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
      break;
    }
  }
  
  public final boolean dnW()
  {
    AppMethodBeat.i(34520);
    ae.v("MicroMsg.ChattingFooterEventImpl", "only stop recording.");
    synchronized (this.lock)
    {
      this.JVN = true;
      if (!this.JVO)
      {
        ae.i("MicroMsg.ChattingFooterEventImpl", "ever never begin.");
        AppMethodBeat.o(34520);
        return false;
      }
    }
    this.JVO = false;
    releaseWakeLock();
    this.Jyf.Kkd.enableOptionMenu(true);
    this.Jyf.Kkd.enableBackMenu(true);
    if (this.JVF != null)
    {
      this.JVF.PX();
      this.iCn.stopTimer();
      this.pAh.stopTimer();
    }
    this.vTx.a(ChatFooter.h.Fvz);
    ((at)this.Jyf.bh(at.class)).fJn().fEI();
    ((al)this.Jyf.bh(al.class)).adU(4);
    ((al)this.Jyf.bh(al.class)).stopSignalling();
    adx(1);
    ((at)this.Jyf.bh(at.class)).a(this.Jyf.Kkd, false);
    AppMethodBeat.o(34520);
    return true;
  }
  
  public final boolean dnY()
  {
    AppMethodBeat.i(34523);
    ae.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.JVN = true;
      if (!this.JVO)
      {
        ae.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34523);
        return false;
      }
    }
    this.JVO = false;
    releaseWakeLock();
    dnZ();
    this.vTx.a(ChatFooter.h.FvB);
    ((at)this.Jyf.bh(at.class)).fJn().fEI();
    ((al)this.Jyf.bh(al.class)).adU(4);
    ((al)this.Jyf.bh(al.class)).stopSignalling();
    adx(1);
    ((at)this.Jyf.bh(at.class)).a(this.Jyf.Kkd, false);
    AppMethodBeat.o(34523);
    return true;
  }
  
  public final void dnZ()
  {
    AppMethodBeat.i(185863);
    this.Jyf.Kkd.enableOptionMenu(true);
    this.Jyf.Kkd.enableBackMenu(true);
    if (this.JVF != null)
    {
      this.JVF.cancel();
      this.iCn.stopTimer();
      this.pAh.stopTimer();
    }
    this.vTx.a(ChatFooter.h.FvB);
    AppMethodBeat.o(185863);
  }
  
  public final boolean doa()
  {
    AppMethodBeat.i(34524);
    if ((com.tencent.mm.r.a.ch(this.Jyf.Kkd.getContext())) || (com.tencent.mm.r.a.cf(this.Jyf.Kkd.getContext())) || (com.tencent.mm.r.a.cj(this.Jyf.Kkd.getContext())))
    {
      ae.d("MicroMsg.ChattingFooterEventImpl", "voip is running, can't record voice");
      AppMethodBeat.o(34524);
      return false;
    }
    ??? = this.Jyf.Kkd.getContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)((Context)???).getSystemService("phone");
    if ((2 == localTelephonyManager.getCallState()) || (1 == localTelephonyManager.getCallState())) {
      Toast.makeText((Context)???, ((Context)???).getString(2131760281), 0).show();
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ae.d("MicroMsg.ChattingFooterEventImpl", "system has calling , can't record voice");
        AppMethodBeat.o(34524);
        return false;
      }
      if (com.tencent.mm.r.a.cg(this.Jyf.Kkd.getContext()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.Jyf.Kkd.getContext(), this.Jyf.Kkd.getContentView());
        ae.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        AppMethodBeat.o(34524);
        return false;
      }
      if (!com.tencent.mm.compatible.d.b.abj()) {
        com.tencent.mm.ui.base.h.a(this.Jyf.Kkd.getContext(), this.Jyf.Kkd.getMMResources().getString(2131755901), this.Jyf.Kkd.getMMResources().getString(2131755824), this.Jyf.Kkd.getMMResources().getString(2131755826), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34492);
            com.tencent.mm.compatible.d.b.cb(q.e(q.this).Kkd.getContext());
            AppMethodBeat.o(34492);
          }
        });
      }
      synchronized (this.lock)
      {
        this.JVN = false;
      }
      synchronized (this.lock)
      {
        if (this.JVN)
        {
          ae.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
          AppMethodBeat.o(34524);
          return false;
          localObject2 = finally;
          AppMethodBeat.o(34524);
          throw localObject2;
        }
        if (this.Jyf.Kkd.getContext().isFinishing())
        {
          AppMethodBeat.o(34524);
          return false;
        }
      }
      if ((Build.VERSION.SDK_INT >= 17) && (this.Jyf.Kkd.getContext().isDestroyed()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      this.JVO = true;
      ??? = com.tencent.mm.plugin.transvoice.a.c.BTw;
      com.tencent.mm.plugin.transvoice.a.c.evb().BTd = true;
      this.iCn.ay(100L, 100L);
      this.JVP = false;
      this.pAh.ay(200L, 200L);
      this.vTx.ZL(this.Jyf.getListView().getHeight());
      ??? = ((at)this.Jyf.bh(at.class)).fJn();
      ((d)???).hvU = true;
      ((d)???).apj();
      ((d)???).fEH();
      this.Jyf.Kkd.enableOptionMenu(false);
      this.Jyf.Kkd.enableBackMenu(false);
      if (this.JVF != null)
      {
        ao.aRR("keep_app_silent");
        this.vTx.setVoiceReactArea(-1);
        this.JVF.gG(getTalkerUserName());
        this.JVH = this.JVF.getFileName();
        this.JVF.a(this.vTC);
        this.nQa.vibrate(50L);
        this.Jyf.bPl();
        fFw();
        this.JVF.a(this.vTB);
      }
      for (;;)
      {
        this.Jyf.setKeepScreenOn(true);
        ((al)this.Jyf.bh(al.class)).adU(3);
        ((al)this.Jyf.bh(al.class)).keepSignalling();
        adx(0);
        ((at)this.Jyf.bh(at.class)).a(this.Jyf.Kkd, true);
        AppMethodBeat.o(34524);
        return true;
        ae.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
      }
    }
  }
  
  public final void dob()
  {
    AppMethodBeat.i(34529);
    fFw();
    this.Jyf.fFT();
    AppMethodBeat.o(34529);
  }
  
  public final void doc()
  {
    AppMethodBeat.i(34530);
    fFw();
    this.Jyf.fFT();
    AppMethodBeat.o(34530);
  }
  
  public final void dod()
  {
    AppMethodBeat.i(187157);
    fFw();
    this.Jyf.fFT();
    AppMethodBeat.o(187157);
  }
  
  public final boolean eg(String paramString, int paramInt)
  {
    AppMethodBeat.i(34527);
    if ((!bu.isNullOrNil(paramString)) && (paramInt > 0) && (s.IC(paramString) != null))
    {
      s.ax(paramString, paramInt);
      com.tencent.mm.modelvoice.o.aNY().run();
      AppMethodBeat.o(34527);
      return true;
    }
    AppMethodBeat.o(34527);
    return false;
  }
  
  public final void fFA()
  {
    AppMethodBeat.i(169859);
    Intent localIntent = new Intent();
    localIntent.setClass(this.Jyf.Kkd.getContext(), NewFileExplorerUI.class);
    localIntent.putExtra("TO_USER", this.JVG);
    this.Jyf.a(localIntent, 227, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(169858);
        if (paramAnonymousInt1 == 227) {
          q.a(q.this, q.e(q.this), paramAnonymousInt2, paramAnonymousIntent);
        }
        AppMethodBeat.o(169858);
      }
    });
    AppMethodBeat.o(169859);
  }
  
  public final void fFD()
  {
    AppMethodBeat.i(34542);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.CAMERA", 22, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.RECORD_AUDIO", 22, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    ae.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (com.tencent.mm.bi.d.iuo.Hm(getTalkerUserName()))
    {
      ae.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(ak.getContext(), 2131760334, 0).show();
      AppMethodBeat.o(34542);
      return;
    }
    List localList;
    if (getTalkerUserName() != null)
    {
      localList = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asr(getTalkerUserName());
      bc.aCg();
      String str1 = (String)com.tencent.mm.model.c.ajA().get(2, null);
      bool = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).aso(getTalkerUserName());
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
      if ((localList.size() >= com.tencent.mm.plugin.multitalk.d.e.duB()) && (i == 0))
      {
        ae.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(ak.getContext(), ak.getContext().getString(2131761424, new Object[] { com.tencent.mm.plugin.multitalk.d.e.duB() }), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).dsk())
        {
          ae.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(ak.getContext(), ak.getContext().getString(2131761410), 0).show();
          AppMethodBeat.o(34542);
          return;
        }
        ae.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).dsi())
      {
        ae.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(ak.getContext(), ak.getContext().getString(2131761410), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.r.a.cj(this.Jyf.Kkd.getContext()))
      {
        ae.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in appbrand voice!");
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.r.a.cg(this.Jyf.Kkd.getContext()))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (bool)
      {
        ae.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        com.tencent.mm.ui.base.h.e(this.Jyf.Kkd.getContext(), this.Jyf.Kkd.getMMResources().getString(2131761452), "", this.Jyf.Kkd.getMMResources().getString(2131761393), this.Jyf.Kkd.getMMResources().getString(2131761390), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169853);
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).aso(q.this.getTalkerUserName()))
            {
              Toast.makeText(ak.getContext(), ak.getContext().getString(2131761445), 0).show();
              AppMethodBeat.o(169853);
              return;
            }
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asu(q.this.getTalkerUserName())) {
              Toast.makeText(ak.getContext(), ak.getContext().getString(2131761403), 0).show();
            }
            AppMethodBeat.o(169853);
          }
        }, null);
        AppMethodBeat.o(34542);
        return;
      }
      localIntent.putExtra("chatroomName", getTalkerUserName());
      localIntent.putExtra("key_need_gallery", true);
      localIntent.putExtra("titile", this.Jyf.Kkd.getMMResources().getString(2131761438));
      com.tencent.mm.br.d.b(this.Jyf.Kkd.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      if (this.vTx.fhz()) {
        this.vTx.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(34542);
      return;
    }
  }
  
  public final void fFE()
  {
    AppMethodBeat.i(34544);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.RECORD_AUDIO", 83, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34544);
      return;
    }
    if (this.vTx.fhz()) {
      this.vTx.setBottomPanelVisibility(8);
    }
    yh localyh = new yh();
    localyh.dNE.dto = 5;
    localyh.dNE.talker = getTalkerUserName();
    localyh.dNE.context = this.Jyf.Kkd.getContext();
    localyh.dNE.dNA = 3;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    com.tencent.mm.plugin.report.service.g.yxI.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
    AppMethodBeat.o(34544);
  }
  
  public final void fFF()
  {
    AppMethodBeat.i(34545);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.CAMERA", 21, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.Jyf.Kkd.getContext(), "android.permission.RECORD_AUDIO", 21, "", "");
    ae.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Jyf.Kkd.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    if (this.vTx.fhz()) {
      this.vTx.setBottomPanelVisibility(8);
    }
    yh localyh = new yh();
    localyh.dNE.dto = 5;
    localyh.dNE.talker = getTalkerUserName();
    localyh.dNE.context = this.Jyf.Kkd.getContext();
    localyh.dNE.dNA = 2;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    AppMethodBeat.o(34545);
  }
  
  public final void fFG()
  {
    AppMethodBeat.i(34548);
    ((ap)this.Jyf.bh(ap.class)).yf(false);
    this.vTx.setBottomPanelVisibility(8);
    AppMethodBeat.o(34548);
  }
  
  public final void fFH()
  {
    AppMethodBeat.i(34549);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.a(this.Jyf.Kkd, com.tencent.mm.loader.j.b.asv(), "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.Jyf.Kkd.getContext(), this.Jyf.Kkd.getMMResources().getString(2131763022), 1).show();
    }
    AppMethodBeat.o(34549);
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(34521);
    if (this.JVF != null)
    {
      String str = this.JVF.getFileName();
      AppMethodBeat.o(34521);
      return str;
    }
    AppMethodBeat.o(34521);
    return "";
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(34535);
    if ((this.contact != null) && (com.tencent.mm.storage.an.Ac(this.contact.field_username)))
    {
      str = this.JVG;
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
    if (this.JVI != null)
    {
      ae.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.JVI.release();
      this.JVI = null;
    }
    a.a locala = com.tencent.mm.cj.a.Jmx;
    if (!a.a.aWJ(this.JVF.getFileName()))
    {
      locala = com.tencent.mm.cj.a.Jmx;
      if (!a.a.aWL(this.JVF.getFileName())) {
        fFx();
      }
    }
    this.iCn.stopTimer();
    this.pAh.stopTimer();
    AppMethodBeat.o(34537);
  }
  
  public final void ot(boolean paramBoolean)
  {
    AppMethodBeat.i(34540);
    if (paramBoolean)
    {
      ((al)this.Jyf.bh(al.class)).keepSignalling();
      AppMethodBeat.o(34540);
      return;
    }
    ((al)this.Jyf.bh(al.class)).stopSignalling();
    AppMethodBeat.o(34540);
  }
  
  public final void release()
  {
    AppMethodBeat.i(34536);
    if (this.JVI != null)
    {
      ae.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.JVI.release();
      this.JVI = null;
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
    boolean JWb = false;
    q.a JWc;
    q.a JWd;
    q.a JWe;
    q.a JWf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q
 * JD-Core Version:    0.7.0.1
 */