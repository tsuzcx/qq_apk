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
import com.tencent.mm.al.k.a;
import com.tencent.mm.al.k.b;
import com.tencent.mm.am.f;
import com.tencent.mm.api.c.b;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.cl.a.a;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wv.a;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.au;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.c.b.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public final class p
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  public static boolean Gnh = true;
  private String BZx;
  private com.tencent.mm.ui.chatting.d.a FQd;
  private boolean GjM;
  private com.tencent.mm.al.k Gni;
  private String Gnj;
  private String Gnk;
  private ToneGenerator Gnl;
  private boolean Gnm;
  private boolean Gnn;
  public boolean Gno;
  private boolean Gnp;
  private volatile boolean Gnq;
  private volatile boolean Gnr;
  private boolean Gns;
  private af contact;
  private final com.tencent.mm.sdk.platformtools.av hFy;
  private Object lock;
  private Vibrator mHT;
  private final com.tencent.mm.sdk.platformtools.av omt;
  public AppPanel.a twL;
  private ChatFooter twb;
  private final k.a twf;
  private final k.b twg;
  private String xWG;
  
  public p(com.tencent.mm.ui.chatting.d.a parama, ChatFooter paramChatFooter, String paramString)
  {
    AppMethodBeat.i(34518);
    this.Gnp = true;
    this.BZx = "";
    this.xWG = "";
    this.twf = new k.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(34487);
        p.a(p.this).reset();
        p.b(p.this).stopTimer();
        p.c(p.this).stopTimer();
        an.aFy("keep_app_silent");
        p.d(p.this).a(ChatFooter.h.CfF);
        ao localao = (ao)p.e(p.this).be(ao.class);
        if ((localao != null) && (localao.eYQ() != null)) {
          localao.eYQ().eUE();
        }
        ad.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        p.e(p.this).GzJ.enableOptionMenu(true);
        p.e(p.this).GzJ.enableBackMenu(true);
        Toast.makeText(p.e(p.this).GzJ.getContext(), p.e(p.this).GzJ.getContext().getString(2131757276), 0).show();
        AppMethodBeat.o(34487);
      }
    };
    this.twg = new k.b()
    {
      public final void auN()
      {
        AppMethodBeat.i(34491);
        p.d(p.this).eza();
        AppMethodBeat.o(34491);
      }
    };
    this.Gnq = false;
    this.Gnr = false;
    this.lock = new Object();
    this.hFy = new com.tencent.mm.sdk.platformtools.av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34493);
        p.d(p.this).Vb(p.a(p.this).getMaxAmplitude());
        AppMethodBeat.o(34493);
        return true;
      }
    }, true);
    this.Gns = false;
    this.omt = new com.tencent.mm.sdk.platformtools.av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34494);
        long l = p.a(p.this).Ou();
        ad.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(l)));
        int i = (int)((60000L - l) / 1000L);
        if ((l >= 50000L) && (l <= 60000L) && (!p.f(p.this)))
        {
          bt.iI(p.e(p.this).GzJ.getContext());
          p.g(p.this);
        }
        p.d(p.this).setVoiceReactArea(i);
        if (l >= 60000L)
        {
          ad.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
          if (!p.d(p.this).ezQ())
          {
            p.h(p.this);
            p.d(p.this).a(ChatFooter.h.CfA);
          }
          for (;;)
          {
            bd.az(p.e(p.this).GzJ.getContext(), 2131764424);
            AppMethodBeat.o(34494);
            return false;
            p.d(p.this).ezy();
          }
        }
        AppMethodBeat.o(34494);
        return true;
      }
    }, true);
    this.twL = new AppPanel.a()
    {
      com.tencent.mm.ui.widget.a.e uyZ = null;
      
      public final void Gq(int paramAnonymousInt)
      {
        AppMethodBeat.i(34504);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34504);
          return;
          az.arV();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.t.g(p.e(p.this).GzJ.getContext(), p.e(p.this).GzJ.getContentView());
            AppMethodBeat.o(34504);
            return;
          }
          Object localObject = p.e(p.this).GzJ.getContext().getSharedPreferences(aj.eFD(), 0).getString("gallery", "1");
          com.tencent.mm.plugin.report.service.g.KI(19);
          if (((String)localObject).equalsIgnoreCase("0")) {
            q.g(p.e(p.this).GzJ);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            AppMethodBeat.o(34504);
            return;
            localObject = p.e(p.this).eYX();
            String str = p.e(p.this).getTalkerUserName();
            Intent localIntent = new Intent();
            if (p.e(p.this).eZb()) {
              localIntent.putExtra("gallery_report_tag", 20);
            }
            for (;;)
            {
              if ((!p.i(p.this)) || (!p.Gnh)) {
                break label275;
              }
              q.a(p.e(p.this).GzJ, (String)localObject, str, localIntent);
              break;
              localIntent.putExtra("gallery_report_tag", 21);
            }
            label275:
            if (af.rz(str)) {
              q.a(p.e(p.this).GzJ, 12, (String)localObject, str, localIntent);
            } else {
              q.a(p.e(p.this).GzJ, 3, (String)localObject, str, localIntent);
            }
          }
          localObject = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.ais());
          if ((!((com.tencent.mm.vfs.e)localObject).exists()) && (!((com.tencent.mm.vfs.e)localObject).mkdirs()))
          {
            Toast.makeText(p.e(p.this).GzJ.getContext(), p.e(p.this).GzJ.getMMResources().getString(2131757320), 1).show();
            AppMethodBeat.o(34504);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).GzJ.getContext(), "android.permission.CAMERA", 20, "", "");
          ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), p.e(p.this).GzJ.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34504);
            return;
          }
          p.this.eVD();
        }
      }
      
      public final void Gr(int paramAnonymousInt)
      {
        AppMethodBeat.i(34510);
        if ((!com.tencent.mm.r.a.cd(p.e(p.this).GzJ.getContext())) && (!com.tencent.mm.r.a.ce(p.e(p.this).GzJ.getContext())) && (!com.tencent.mm.r.a.cc(p.e(p.this).GzJ.getContext()))) {
          p.this.Yv(paramAnonymousInt);
        }
        AppMethodBeat.o(34510);
      }
      
      public final void cOf()
      {
        AppMethodBeat.i(34499);
        if (com.tencent.mm.r.a.cc(p.e(p.this).GzJ.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.r.a.dV(p.e(p.this).GzJ.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        wv localwv = new wv();
        com.tencent.mm.sdk.b.a.ESL.l(localwv);
        if ((p.this.getTalkerUserName() != null) && (!p.this.getTalkerUserName().equals(localwv.dCl.talker)) && ((localwv.dCl.dCn) || (localwv.dCl.dCo)))
        {
          if (localwv.dCl.dCm) {}
          for (int i = 2131756778;; i = 2131756779)
          {
            Toast.makeText(p.e(p.this).GzJ.getContext(), i, 0).show();
            ad.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34499);
            return;
          }
        }
        final boolean bool;
        if (1 == com.tencent.mm.m.g.Zd().getInt("EnableVoiceVoipFromPlugin", 0))
        {
          if ((!af.aHH(p.e(p.this).zgX.field_username)) && (!w.sn(p.e(p.this).zgX.field_username))) {
            break label389;
          }
          if ((((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).Bi(p.e(p.this).zgX.field_openImAppid) & 0x2000) == 0) {
            bool = true;
          }
        }
        for (;;)
        {
          this.uyZ = new com.tencent.mm.ui.widget.a.e(p.e(p.this).GzJ.getContext(), 1, false);
          this.uyZ.HrX = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(34495);
              paramAnonymous2l.aI(2, 2131755762, 2131691164);
              if (!bool) {
                paramAnonymous2l.aI(1, 2131755764, 2131691165);
              }
              AppMethodBeat.o(34495);
            }
          };
          this.uyZ.HrY = new n.d()
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
                p.this.dcM();
                AppMethodBeat.o(34496);
                return;
                p.this.dcN();
              }
            }
          };
          this.uyZ.csG();
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(34499);
            return;
            bool = false;
            break;
            p.this.eVB();
          }
          label389:
          bool = false;
        }
      }
      
      public final void cOg()
      {
        AppMethodBeat.i(34500);
        if (com.tencent.mm.r.a.cc(p.e(p.this).GzJ.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.r.a.dV(p.e(p.this).GzJ.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        wv localwv = new wv();
        com.tencent.mm.sdk.b.a.ESL.l(localwv);
        if ((!p.this.getTalkerUserName().equals(localwv.dCl.talker)) && ((localwv.dCl.dCn) || (localwv.dCl.dCo)))
        {
          if (localwv.dCl.dCm) {}
          for (int i = 2131756778;; i = 2131756779)
          {
            Toast.makeText(p.e(p.this).GzJ.getContext(), i, 0).show();
            ad.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34500);
            return;
          }
        }
        p.this.eVA();
        AppMethodBeat.o(34500);
      }
      
      public final void cOh()
      {
        AppMethodBeat.i(34501);
        if ((!com.tencent.mm.r.a.ce(p.e(p.this).GzJ.getContext())) && (!com.tencent.mm.r.a.cc(p.e(p.this).GzJ.getContext())))
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).GzJ.getContext(), "android.permission.RECORD_AUDIO", 81, "", "");
          ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), p.e(p.this).GzJ.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34501);
            return;
          }
          p.this.eVC();
        }
        AppMethodBeat.o(34501);
      }
      
      public final void cOi()
      {
        AppMethodBeat.i(34502);
        ((z)p.e(p.this).be(z.class)).eYl();
        AppMethodBeat.o(34502);
      }
      
      public final void cOj()
      {
        AppMethodBeat.i(34503);
        ((com.tencent.mm.ui.chatting.c.b.e)p.e(p.this).be(com.tencent.mm.ui.chatting.c.b.e.class)).eWT();
        AppMethodBeat.o(34503);
      }
      
      public final void cOk()
      {
        AppMethodBeat.i(34506);
        com.tencent.mm.bs.d.b(p.e(p.this).GzJ.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.o(34506);
      }
      
      public final void cOl()
      {
        AppMethodBeat.i(34507);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("3");
        if (f.pc(p.j(p.this).field_username))
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
        com.tencent.mm.plugin.fav.a.b.b(p.e(p.this).GzJ.getContext(), ".ui.FavSelectUI", localIntent);
        com.tencent.mm.plugin.report.service.h.vKh.f(14103, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(34507);
      }
      
      public final void cOm()
      {
        AppMethodBeat.i(34508);
        Intent localIntent = new Intent();
        localIntent.putExtra("service_app_talker_user", p.this.getTalkerUserName());
        com.tencent.mm.bs.d.a(p.e(p.this).GzJ, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
        AppMethodBeat.o(34508);
      }
      
      public final void cOn()
      {
        AppMethodBeat.i(34509);
        Object localObject;
        if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
        {
          localObject = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new HashMap());
          ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.flutter.a.a.class)).a(p.e(p.this).GzJ.getContext(), (com.tencent.mm.plugin.flutter.a.c)localObject);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(12065, new Object[] { Integer.valueOf(4) });
          AppMethodBeat.o(34509);
          return;
          localObject = new Intent();
          ((Intent)localObject).putExtra("download_entrance_scene", 17);
          ((Intent)localObject).putExtra("preceding_scence", 13);
          com.tencent.mm.bs.d.b(p.e(p.this).GzJ.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
        }
      }
      
      public final void cOo()
      {
        AppMethodBeat.i(34511);
        com.tencent.mm.plugin.report.service.h.vKh.f(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.vKh.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        p.a(p.this, p.k(p.this) + "_" + System.currentTimeMillis());
        final String str = UUID.randomUUID().toString();
        p.P(2, 0, p.l(p.this));
        final p.b localb = p.eVE();
        com.tencent.mm.kernel.g.afC();
        final int i = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.FgH, 0);
        if (p.m(p.this))
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
          if ((i == 1) && (localb.GnD))
          {
            locale = new com.tencent.mm.ui.widget.a.e(p.e(p.this).GzJ.getContext(), 1, false);
            locale.HrX = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(163290);
                paramAnonymous2l.c(0, p.e(p.this).GzJ.getMMResources().getString(2131757246));
                p.a locala = p.a(localb);
                if (locala != null) {
                  paramAnonymous2l.a(1, locala.title, locala.desc, 0);
                }
                AppMethodBeat.o(163290);
              }
            };
            locale.HrY = new n.d()
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
                  com.tencent.mm.plugin.report.service.h.vKh.f(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
                  p.P(4, 0, p.l(p.this));
                  AppMethodBeat.o(163291);
                  return;
                  p.n(p.this);
                }
              }
            };
            locale.csG();
            p.eVF();
            p.P(3, 0, p.l(p.this));
            AppMethodBeat.o(34511);
            return;
          }
          p.b(p.this, str);
          com.tencent.mm.plugin.report.service.h.vKh.f(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        if (((i != 1) || (!localb.GnD)) && (p.eVx()))
        {
          p.c(p.this, str);
          com.tencent.mm.plugin.report.service.h.vKh.f(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(p.e(p.this).GzJ.getContext(), 1, false);
        locale.HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(163292);
            paramAnonymous2l.c(0, p.e(p.this).GzJ.getMMResources().getString(2131757246));
            Object localObject;
            if (!p.eVx())
            {
              localObject = new com.tencent.mm.g.b.a.av();
              ((com.tencent.mm.g.b.a.av)localObject).dMW = 13L;
              ((com.tencent.mm.g.b.a.av)localObject).aBj();
              paramAnonymous2l.c(1, p.e(p.this).GzJ.getMMResources().getString(2131757245));
            }
            if ((localb.GnD) && (i == 1))
            {
              localObject = p.a(localb);
              if (localObject != null) {
                paramAnonymous2l.a(2, ((p.a)localObject).title, ((p.a)localObject).desc, 0);
              }
            }
            AppMethodBeat.o(163292);
          }
        };
        locale.HrY = new n.d()
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
              com.tencent.mm.plugin.report.service.h.vKh.f(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
              p.P(4, 0, p.l(p.this));
              AppMethodBeat.o(163293);
              return;
              com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
              localIntent.putExtra("key_username", p.this.getTalkerUserName());
              localIntent.putExtra("key_way", 0);
              localIntent.putExtra("pay_channel", 11);
              com.tencent.mm.bs.d.b(p.e(p.this).GzJ.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", localIntent);
              paramAnonymous2MenuItem = new com.tencent.mm.g.b.a.av();
              paramAnonymous2MenuItem.dMW = 1L;
              paramAnonymous2MenuItem.aBj();
              p.P(5, 0, p.l(p.this));
              AppMethodBeat.o(163293);
              return;
              p.n(p.this);
            }
          }
        };
        locale.csG();
        p.eVF();
        p.P(3, 0, p.l(p.this));
        AppMethodBeat.o(34511);
      }
      
      public final void cOp()
      {
        AppMethodBeat.i(34512);
        az.arV();
        com.tencent.mm.model.c.afk().set(81, Boolean.FALSE);
        if (!ay.isNetworkConnected(p.e(p.this).GzJ.getContext()))
        {
          com.tencent.mm.bi.e.a(p.e(p.this).GzJ.getContext(), 2131764895, null);
          AppMethodBeat.o(34512);
          return;
        }
        p.this.eVz();
        AppMethodBeat.o(34512);
      }
      
      public final void cOq()
      {
        AppMethodBeat.i(34513);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_scene", 4);
        localIntent.putExtra("enterprise_biz_name", p.this.getTalkerUserName());
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.c.b.d)p.e(p.this).be(com.tencent.mm.ui.chatting.c.b.d.class)).eWP());
        com.tencent.mm.bs.d.b(p.e(p.this).GzJ.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
        AppMethodBeat.o(34513);
      }
      
      public final void cOr()
      {
        AppMethodBeat.i(34514);
        if (p.m(p.this))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enter_scene", 1);
          localIntent.putExtra("chatroom_name", p.this.getTalkerUserName());
          com.tencent.mm.bs.d.b(p.e(p.this).GzJ.getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        }
        AppMethodBeat.o(34514);
      }
      
      public final void cOs()
      {
        AppMethodBeat.i(34515);
        com.tencent.mm.plugin.report.service.h.vKh.f(14523, new Object[] { Integer.valueOf(0) });
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).GzJ.getContext(), "android.permission.READ_EXTERNAL_STORAGE", 145, p.e(p.this).GzJ.getContext().getString(2131761885), p.e(p.this).GzJ.getContext().getString(2131763056));
        ad.i("MicroMsg.ChattingFooterEventImpl", "checkPermission checkStorage[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), p.e(p.this).GzJ.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(34515);
          return;
        }
        p.this.eVw();
        AppMethodBeat.o(34515);
      }
      
      public final void cOt()
      {
        AppMethodBeat.i(179848);
        ((v)p.e(p.this).be(v.class)).eXK();
        AppMethodBeat.o(179848);
      }
      
      public final void cOu()
      {
        AppMethodBeat.i(191480);
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterGroupSolitaire() chatroom:%s", new Object[] { p.e(p.this).getTalkerUserName() });
        Intent localIntent = new Intent();
        localIntent.putExtra("key_group_solitatire_create", true);
        localIntent.putExtra("key_group_solitatire_scene", 5);
        com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
        locala.header = (p.e(p.this).GzJ.getContext().getString(2131760093) + "\n");
        locala.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(locala);
        locala.separator = ".";
        locala.srd = 1;
        localIntent.putExtra("key_group_solitatire_key", locala.field_key);
        localIntent.putExtra("key_group_solitatire_chatroom_username", p.e(p.this).getTalkerUserName());
        com.tencent.mm.plugin.groupsolitaire.b.b.a(p.e(p.this).getTalkerUserName(), locala);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(p.e(p.this).getTalkerUserName(), locala);
        com.tencent.mm.bs.d.b(p.e(p.this).GzJ.getContext(), "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent);
        AppMethodBeat.o(191480);
      }
      
      public final void d(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(34505);
        ((com.tencent.mm.ui.chatting.c.b.b)p.e(p.this).be(com.tencent.mm.ui.chatting.c.b.b.class)).t(paramAnonymousg);
        AppMethodBeat.o(34505);
      }
      
      public final void fXT()
      {
        AppMethodBeat.i(204951);
        ad.i("MicroMsg.ChattingFooterEventImpl", "gotoRoomLiveEntrance");
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).GzJ.getContext(), "android.permission.CAMERA", 25, "", "");
        ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), p.e(p.this).GzJ.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(204951);
          return;
        }
        bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).GzJ.getContext(), "android.permission.RECORD_AUDIO", 25, "", "");
        ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), p.e(p.this).GzJ.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(204951);
          return;
        }
        if ((!com.tencent.mm.r.a.cd(p.e(p.this).GzJ.getContext())) && (!com.tencent.mm.r.a.ce(p.e(p.this).GzJ.getContext())) && (!com.tencent.mm.r.a.cc(p.e(p.this).GzJ.getContext())))
        {
          if (com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.LBC, 0) == 1)
          {
            Activity localActivity = p.e(p.this).GzJ.getContext();
            com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
            locall.HrX = new p.11.7(this, localActivity);
            locall.HrY = new p.11.8(this);
            locall.fdQ();
            AppMethodBeat.o(204951);
            return;
          }
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(p.e(p.this).GzJ.getContext(), LiveConfig.db(p.e(p.this).getTalkerUserName(), LiveConfig.qsG));
        }
        AppMethodBeat.o(204951);
      }
    };
    this.FQd = parama;
    this.twb = paramChatFooter;
    this.Gnj = paramString;
    az.arV();
    this.contact = com.tencent.mm.model.c.apM().aHY(paramString);
    this.Gnm = w.pF(this.FQd.getTalkerUserName());
    this.Gnn = w.sv(this.FQd.getTalkerUserName());
    boolean bool;
    if ((this.Gnm) || (this.Gnn))
    {
      bool = true;
      this.GjM = bool;
      this.mHT = ((Vibrator)this.FQd.GzJ.getContext().getSystemService("vibrator"));
      if (!w.ta(this.Gnj)) {
        break label347;
      }
      this.Gni = new com.tencent.mm.plugin.subapp.d.i();
      ad.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.Gni.a(this.twg);
      this.Gni.a(this.twf);
      paramChatFooter.setAppPanelListener(this.twL);
      this.Gnp = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqd, true);
      az.arV();
      this.BZx = ((String)com.tencent.mm.model.c.afk().get(2, null));
      AppMethodBeat.o(34518);
      return;
      bool = false;
      break;
      label347:
      parama = this.Gnj;
      int i;
      if (w.tl(parama)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label532;
        }
        this.Gni = new com.tencent.mm.audio.b.h(this.FQd.GzJ.getContext(), true);
        ad.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parama);
        if ((parama != null) && (parama.eKB()))
        {
          paramString = f.ei(parama.field_username);
          if (paramString != null)
          {
            paramString = paramString.bU(false);
            if (paramString != null)
            {
              if (paramString.cIj != null) {
                paramString.cIn = "1".equals(paramString.cIj.optString("CanReceiveSpeexVoice"));
              }
              if (paramString.cIn)
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
      this.Gni = new com.tencent.mm.audio.b.h(this.FQd.GzJ.getContext(), false);
      ad.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
  }
  
  public static void P(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(163296);
    j localj = new j();
    localj.dHq = paramInt1;
    localj.dHt = System.currentTimeMillis();
    localj.dHr = localj.t("SessionId", paramString, true);
    localj.dHs = paramInt2;
    localj.aBj();
    AppMethodBeat.o(163296);
  }
  
  private static void Yu(int paramInt)
  {
    AppMethodBeat.i(34541);
    po localpo = new po();
    localpo.dvp.state = paramInt;
    com.tencent.mm.sdk.b.a.ESL.l(localpo);
    AppMethodBeat.o(34541);
  }
  
  public static a a(b paramb)
  {
    AppMethodBeat.i(163300);
    if (paramb == null)
    {
      AppMethodBeat.o(163300);
      return null;
    }
    String str = ac.eFu();
    if ("zh_CN".equals(str))
    {
      paramb = paramb.GnE;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_TW".equals(str))
    {
      paramb = paramb.GnG;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_HK".equals(str))
    {
      paramb = paramb.GnF;
      AppMethodBeat.o(163300);
      return paramb;
    }
    paramb = paramb.GnH;
    AppMethodBeat.o(163300);
    return paramb;
  }
  
  public static void dBh()
  {
    CaptureDataManager.vhw.vhv = null;
  }
  
  @Deprecated
  @SuppressLint({"NewApi"})
  private void eVs()
  {
    AppMethodBeat.i(34532);
    this.FQd.wc(true);
    AppMethodBeat.o(34532);
  }
  
  private boolean eVt()
  {
    boolean bool = false;
    int i = 1;
    AppMethodBeat.i(34534);
    this.FQd.GzJ.enableOptionMenu(true);
    this.FQd.GzJ.enableBackMenu(true);
    if (this.Gni != null) {
      if ((this.Gni.isRecording()) && (eVu()))
      {
        bool = this.Gni.Ft();
        this.hFy.stopTimer();
        this.omt.stopTimer();
        if (i != 0) {
          eVv();
        }
        an.aFy("keep_app_silent");
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
  
  private boolean eVu()
  {
    AppMethodBeat.i(34538);
    if ((this.contact.field_username.equals("medianote")) && ((u.aqK() & 0x4000) == 0))
    {
      AppMethodBeat.o(34538);
      return true;
    }
    AppMethodBeat.o(34538);
    return false;
  }
  
  private void eVv()
  {
    AppMethodBeat.i(34539);
    bl localbl = new bl();
    localbl.nY("medianote");
    localbl.setType(34);
    localbl.jV(1);
    localbl.nZ(this.Gnk);
    localbl.setStatus(2);
    localbl.setContent(com.tencent.mm.modelvoice.p.b(u.aqG(), this.Gni.Os(), false));
    localbl.kY(bi.uj("medianote"));
    if (this.Gni.Ov() == 2) {
      localbl.mZ("SOURCE_SILK_FILE");
    }
    az.arV();
    long l = com.tencent.mm.model.c.apO().an(localbl);
    if (l <= 0L)
    {
      ad.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
      AppMethodBeat.o(34539);
      return;
    }
    ad.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(l)));
    AppMethodBeat.o(34539);
  }
  
  public static boolean eVx()
  {
    AppMethodBeat.i(163297);
    az.arV();
    Integer localInteger1 = (Integer)com.tencent.mm.model.c.afk().get(ae.a.FgF, Integer.valueOf(0));
    az.arV();
    Integer localInteger2 = (Integer)com.tencent.mm.model.c.afk().get(ae.a.FgG, Integer.valueOf(0));
    if ((localInteger1.intValue() == 1) || (localInteger2.intValue() == 1)) {
      if (u.aqN() != 0) {
        break label84;
      }
    }
    label84:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(163297);
      return true;
    }
    AppMethodBeat.o(163297);
    return false;
  }
  
  private static b eVy()
  {
    AppMethodBeat.i(163298);
    b localb = new b();
    Object localObject = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvi, "");
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
        localb.GnD = false;
        localb.GnE = l((JSONObject)localObject, "simple_chinese");
        localb.GnF = l((JSONObject)localObject, "xg_traditional_chinese");
        localb.GnG = l((JSONObject)localObject, "tw_traditional_chinese");
        localb.GnH = l((JSONObject)localObject, "english");
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(163298);
      return localb;
      localb.GnD = true;
    }
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
    this.FQd.setKeepScreenOn(false);
    AppMethodBeat.o(34533);
  }
  
  public final long Ou()
  {
    AppMethodBeat.i(34522);
    if (this.Gni != null)
    {
      long l = this.Gni.Ou();
      AppMethodBeat.o(34522);
      return l;
    }
    AppMethodBeat.o(34522);
    return 0L;
  }
  
  public final void W(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34531);
    if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
    {
      eVs();
      this.FQd.eVP();
    }
    AppMethodBeat.o(34531);
  }
  
  public final void Yv(final int paramInt)
  {
    AppMethodBeat.i(34543);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.CAMERA", 18, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.RECORD_AUDIO", 18, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    Object localObject1;
    if ((com.tencent.mm.sdk.a.b.eEQ()) || (com.tencent.mm.platformtools.ab.hWA))
    {
      localObject1 = new com.tencent.mm.ui.tools.l(this.FQd.GzJ.getContext());
      ((com.tencent.mm.ui.tools.l)localObject1).HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(169854);
          paramAnonymousl.c(1, p.e(p.this).GzJ.getMMResources().getString(2131755747));
          paramAnonymousl.c(5, "拍摄参数设置面板");
          AppMethodBeat.o(169854);
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).HrY = new n.d()
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
            com.tencent.mm.plugin.report.service.h.vKh.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            paramAnonymousMenuItem = new SightParams(1, paramInt);
            Object localObject = com.tencent.mm.modelvideo.t.zP(p.this.getTalkerUserName());
            com.tencent.mm.modelvideo.o.aCI();
            String str = com.tencent.mm.modelvideo.t.zQ((String)localObject);
            com.tencent.mm.modelvideo.o.aCI();
            paramAnonymousMenuItem = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.zR((String)localObject), paramAnonymousMenuItem.gCB, paramAnonymousMenuItem.gCB.duration * 1000, 1);
            if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqe, false)) {
              paramAnonymousMenuItem.vhB = 2;
            }
            localObject = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject).pOf = 3;
            if (p.o(p.this)) {
              ((VideoCaptureReportInfo)localObject).pOf = 4;
            }
            paramAnonymousMenuItem.vhY = ((VideoCaptureReportInfo)localObject);
            localObject = new UICustomParam.a();
            ((UICustomParam.a)localObject).Ya();
            ((UICustomParam.a)localObject).XZ();
            ((UICustomParam.a)localObject).cO(true);
            paramAnonymousMenuItem.vhI = ((UICustomParam.a)localObject).fHa;
            localObject = new CaptureDataManager.b()
            {
              public final void a(Context paramAnonymous2Context, CaptureDataManager.CaptureVideoNormalModel paramAnonymous2CaptureVideoNormalModel, Bundle paramAnonymous2Bundle)
              {
                AppMethodBeat.i(169855);
                paramAnonymous2Bundle = new boj();
                paramAnonymous2Bundle.DLK = true;
                paramAnonymous2Bundle.DLJ = false;
                String str = com.tencent.mm.vfs.i.aMS(paramAnonymous2CaptureVideoNormalModel.videoPath);
                paramAnonymous2Bundle = new SightCaptureResult(true, paramAnonymous2CaptureVideoNormalModel.videoPath, paramAnonymous2CaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymous2CaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymous2CaptureVideoNormalModel.vhy.longValue() * 1.0F / 1000.0F), paramAnonymous2Bundle);
                if (paramAnonymous2CaptureVideoNormalModel.vhz.booleanValue())
                {
                  paramAnonymous2Bundle.tAP = true;
                  paramAnonymous2Bundle.osM = false;
                  paramAnonymous2Bundle.tAX = paramAnonymous2CaptureVideoNormalModel.thumbPath;
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
            CaptureDataManager.vhw.vhv = ((CaptureDataManager.b)localObject);
            if (p.p(p.this))
            {
              localObject = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(p.e(p.this).GzJ.getContext(), 226, 2130772137, 2130772138, paramAnonymousMenuItem);
              AppMethodBeat.o(169856);
              return;
            }
            q.a(p.e(p.this).GzJ, new Intent(), p.this.getTalkerUserName(), paramInt);
            AppMethodBeat.o(169856);
            return;
            com.tencent.mm.bs.d.b(p.e(p.this).GzJ.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
          }
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).fdQ();
      AppMethodBeat.o(34543);
      return;
    }
    if (!com.tencent.mm.platformtools.ab.hWB)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new SightParams(1, paramInt);
      Object localObject2 = com.tencent.mm.modelvideo.t.zP(getTalkerUserName());
      com.tencent.mm.modelvideo.o.aCI();
      String str = com.tencent.mm.modelvideo.t.zQ((String)localObject2);
      com.tencent.mm.modelvideo.o.aCI();
      localObject1 = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.zR((String)localObject2), ((SightParams)localObject1).gCB, ((SightParams)localObject1).gCB.duration * 1000, 1);
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqe, false)) {
        ((RecordConfigProvider)localObject1).vhB = 2;
      }
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).pOf = 3;
      if (this.GjM) {
        ((VideoCaptureReportInfo)localObject2).pOf = 4;
      }
      ((RecordConfigProvider)localObject1).vhY = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).Ya();
      ((UICustomParam.a)localObject2).XZ();
      ((UICustomParam.a)localObject2).cO(true);
      ((RecordConfigProvider)localObject1).vhI = ((UICustomParam.a)localObject2).fHa;
      localObject2 = new CaptureDataManager.b()
      {
        public final void a(Context paramAnonymousContext, CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(169857);
          paramAnonymousBundle = new boj();
          paramAnonymousBundle.DLK = true;
          paramAnonymousBundle.DLJ = false;
          String str = com.tencent.mm.vfs.i.aMS(paramAnonymousCaptureVideoNormalModel.videoPath);
          paramAnonymousBundle = new SightCaptureResult(true, paramAnonymousCaptureVideoNormalModel.videoPath, paramAnonymousCaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymousCaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymousCaptureVideoNormalModel.vhy.longValue() * 1.0F / 1000.0F), paramAnonymousBundle);
          if (paramAnonymousCaptureVideoNormalModel.vhz.booleanValue())
          {
            paramAnonymousBundle.tAP = true;
            paramAnonymousBundle.osM = false;
            paramAnonymousBundle.tAX = paramAnonymousCaptureVideoNormalModel.thumbPath;
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
      CaptureDataManager.vhw.vhv = ((CaptureDataManager.b)localObject2);
      if (this.Gnp)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this.FQd.GzJ.getContext(), 226, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
        AppMethodBeat.o(34543);
        return;
      }
      q.a(this.FQd.GzJ, new Intent(), getTalkerUserName(), paramInt);
    }
    AppMethodBeat.o(34543);
  }
  
  public final void adu(String paramString)
  {
    AppMethodBeat.i(34526);
    ((ai)this.FQd.be(ai.class)).adu(paramString);
    AppMethodBeat.o(34526);
  }
  
  public final boolean afG(String paramString)
  {
    AppMethodBeat.i(34525);
    eVs();
    this.FQd.eVP();
    boolean bool = ((ai)this.FQd.be(ai.class)).aKM(paramString);
    AppMethodBeat.o(34525);
    return bool;
  }
  
  public final boolean afH(String paramString)
  {
    AppMethodBeat.i(34528);
    if (!bt.isNullOrNil(paramString))
    {
      s.AA(paramString);
      com.tencent.mm.modelvoice.o.aDA().run();
      AppMethodBeat.o(34528);
      return true;
    }
    AppMethodBeat.o(34528);
    return false;
  }
  
  public final boolean cNU()
  {
    AppMethodBeat.i(34519);
    synchronized (this.lock)
    {
      this.Gnq = true;
      if (!this.Gnr)
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34519);
        return false;
      }
    }
    this.Gnr = false;
    releaseWakeLock();
    if (!eVt())
    {
      this.twb.bSf();
      ad.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
      ((ao)this.FQd.be(ao.class)).eYQ().eUE();
      ((ag)this.FQd.be(ag.class)).YQ(4);
      ((ag)this.FQd.be(ag.class)).stopSignalling();
      Yu(1);
      ((ao)this.FQd.be(ao.class)).a(this.FQd.GzJ, false);
      AppMethodBeat.o(34519);
      return true;
    }
    this.twb.setExitType(0);
    ??? = this.twb;
    if (!((ChatFooter)???).Cdm) {
      if (1 != ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvk, 1)) {
        break label369;
      }
    }
    label369:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject3 = aj.getContext().getSharedPreferences(ChatFooter.CeO, 0);
        if (((SharedPreferences)localObject3).getInt("trans2txt_edu_key", 0) == 0)
        {
          ((SharedPreferences)localObject3).edit().putInt("trans2txt_edu_key", 1).apply();
          localObject3 = new bl();
          ??? = ((ChatFooter)???).CcF.getTalkerUserName();
          ((bl)localObject3).kY(bi.uj((String)???));
          ((bl)localObject3).nY((String)???);
          ((bl)localObject3).setContent(aj.getContext().getString(2131764710));
          ((bl)localObject3).setType(10000);
          ((bl)localObject3).setStatus(6);
          ((bl)localObject3).jV(0);
          az.arV();
          com.tencent.mm.model.c.apO().an((bl)localObject3);
        }
      }
      this.twb.a(ChatFooter.h.CfA);
      ad.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
      break;
    }
  }
  
  public final boolean cNV()
  {
    AppMethodBeat.i(34520);
    ad.v("MicroMsg.ChattingFooterEventImpl", "only stop recording.");
    synchronized (this.lock)
    {
      this.Gnq = true;
      if (!this.Gnr)
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "ever never begin.");
        AppMethodBeat.o(34520);
        return false;
      }
    }
    this.Gnr = false;
    releaseWakeLock();
    this.FQd.GzJ.enableOptionMenu(true);
    this.FQd.GzJ.enableBackMenu(true);
    if (this.Gni != null)
    {
      this.Gni.Ot();
      this.hFy.stopTimer();
      this.omt.stopTimer();
    }
    this.twb.a(ChatFooter.h.CfB);
    ((ao)this.FQd.be(ao.class)).eYQ().eUE();
    ((ag)this.FQd.be(ag.class)).YQ(4);
    ((ag)this.FQd.be(ag.class)).stopSignalling();
    Yu(1);
    ((ao)this.FQd.be(ao.class)).a(this.FQd.GzJ, false);
    AppMethodBeat.o(34520);
    return true;
  }
  
  public final boolean cNX()
  {
    AppMethodBeat.i(34523);
    ad.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.Gnq = true;
      if (!this.Gnr)
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34523);
        return false;
      }
    }
    this.Gnr = false;
    releaseWakeLock();
    cNY();
    this.twb.a(ChatFooter.h.CfD);
    ((ao)this.FQd.be(ao.class)).eYQ().eUE();
    ((ag)this.FQd.be(ag.class)).YQ(4);
    ((ag)this.FQd.be(ag.class)).stopSignalling();
    Yu(1);
    ((ao)this.FQd.be(ao.class)).a(this.FQd.GzJ, false);
    AppMethodBeat.o(34523);
    return true;
  }
  
  public final void cNY()
  {
    AppMethodBeat.i(185863);
    this.FQd.GzJ.enableOptionMenu(true);
    this.FQd.GzJ.enableBackMenu(true);
    if (this.Gni != null)
    {
      this.Gni.cancel();
      this.hFy.stopTimer();
      this.omt.stopTimer();
    }
    this.twb.a(ChatFooter.h.CfD);
    AppMethodBeat.o(185863);
  }
  
  public final boolean cNZ()
  {
    AppMethodBeat.i(34524);
    if ((com.tencent.mm.r.a.ce(this.FQd.GzJ.getContext())) || (com.tencent.mm.r.a.cc(this.FQd.GzJ.getContext())))
    {
      ad.d("MicroMsg.ChattingFooterEventImpl", "voip is running, can't record voice");
      AppMethodBeat.o(34524);
      return false;
    }
    ??? = this.FQd.GzJ.getContext();
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
      if (com.tencent.mm.r.a.dV(this.FQd.GzJ.getContext()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.FQd.GzJ.getContext(), this.FQd.GzJ.getContentView());
        ad.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        AppMethodBeat.o(34524);
        return false;
      }
      if (!com.tencent.mm.compatible.d.b.XB()) {
        com.tencent.mm.ui.base.h.a(this.FQd.GzJ.getContext(), this.FQd.GzJ.getMMResources().getString(2131755901), this.FQd.GzJ.getMMResources().getString(2131755824), this.FQd.GzJ.getMMResources().getString(2131755826), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34492);
            com.tencent.mm.compatible.d.b.bY(p.e(p.this).GzJ.getContext());
            AppMethodBeat.o(34492);
          }
        });
      }
      synchronized (this.lock)
      {
        this.Gnq = false;
      }
      synchronized (this.lock)
      {
        if (this.Gnq)
        {
          ad.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
          AppMethodBeat.o(34524);
          return false;
          localObject2 = finally;
          AppMethodBeat.o(34524);
          throw localObject2;
        }
        if (this.FQd.GzJ.getContext().isFinishing())
        {
          AppMethodBeat.o(34524);
          return false;
        }
      }
      if ((Build.VERSION.SDK_INT >= 17) && (this.FQd.GzJ.getContext().isDestroyed()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      this.Gnr = true;
      ??? = com.tencent.mm.plugin.transvoice.a.c.yWx;
      com.tencent.mm.plugin.transvoice.a.c.dQE().yWe = true;
      this.hFy.av(100L, 100L);
      this.Gns = false;
      this.omt.av(200L, 200L);
      this.twb.Va(this.FQd.getListView().getHeight());
      ??? = ((ao)this.FQd.be(ao.class)).eYQ();
      ((d)???).gAF = true;
      ((d)???).eUI();
      ((d)???).eUD();
      this.FQd.GzJ.enableOptionMenu(false);
      this.FQd.GzJ.enableBackMenu(false);
      if (this.Gni != null)
      {
        an.aFx("keep_app_silent");
        this.twb.setVoiceReactArea(-1);
        this.Gni.fP(getTalkerUserName());
        this.Gnk = this.Gni.getFileName();
        this.Gni.a(this.twg);
        this.mHT.vibrate(50L);
        this.FQd.bCM();
        eVs();
        this.Gni.a(this.twf);
      }
      for (;;)
      {
        this.FQd.setKeepScreenOn(true);
        ((ag)this.FQd.be(ag.class)).YQ(3);
        ((ag)this.FQd.be(ag.class)).keepSignalling();
        Yu(0);
        ((ao)this.FQd.be(ao.class)).a(this.FQd.GzJ, true);
        AppMethodBeat.o(34524);
        return true;
        ad.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
      }
    }
  }
  
  public final void cOa()
  {
    AppMethodBeat.i(34529);
    eVs();
    this.FQd.eVP();
    AppMethodBeat.o(34529);
  }
  
  public final void cOb()
  {
    AppMethodBeat.i(34530);
    eVs();
    this.FQd.eVP();
    AppMethodBeat.o(34530);
  }
  
  public final boolean dC(String paramString, int paramInt)
  {
    AppMethodBeat.i(34527);
    if ((!bt.isNullOrNil(paramString)) && (paramInt > 0) && (s.AG(paramString) != null))
    {
      s.aq(paramString, paramInt);
      com.tencent.mm.modelvoice.o.aDA().run();
      AppMethodBeat.o(34527);
      return true;
    }
    AppMethodBeat.o(34527);
    return false;
  }
  
  public final void dcM()
  {
    AppMethodBeat.i(34546);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.RECORD_AUDIO", 82, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34546);
      return;
    }
    ww localww = new ww();
    localww.dCp.djq = 5;
    localww.dCp.talker = getTalkerUserName();
    localww.dCp.context = this.FQd.GzJ.getContext();
    localww.dCp.dCj = 4;
    if (this.twb.ezq()) {
      this.twb.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    AppMethodBeat.o(34546);
  }
  
  public final void dcN()
  {
    AppMethodBeat.i(34547);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.CAMERA", 19, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.RECORD_AUDIO", 19, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    ww localww = new ww();
    localww.dCp.djq = 5;
    localww.dCp.talker = getTalkerUserName();
    localww.dCp.context = this.FQd.GzJ.getContext();
    localww.dCp.dCj = 2;
    if (this.twb.ezq()) {
      this.twb.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    AppMethodBeat.o(34547);
  }
  
  public final void eVA()
  {
    AppMethodBeat.i(34544);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.RECORD_AUDIO", 83, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34544);
      return;
    }
    if (this.twb.ezq()) {
      this.twb.setBottomPanelVisibility(8);
    }
    ww localww = new ww();
    localww.dCp.djq = 5;
    localww.dCp.talker = getTalkerUserName();
    localww.dCp.context = this.FQd.GzJ.getContext();
    localww.dCp.dCj = 3;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    com.tencent.mm.plugin.report.service.h.vKh.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
    AppMethodBeat.o(34544);
  }
  
  public final void eVB()
  {
    AppMethodBeat.i(34545);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.CAMERA", 21, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.RECORD_AUDIO", 21, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    if (this.twb.ezq()) {
      this.twb.setBottomPanelVisibility(8);
    }
    ww localww = new ww();
    localww.dCp.djq = 5;
    localww.dCp.talker = getTalkerUserName();
    localww.dCp.context = this.FQd.GzJ.getContext();
    localww.dCp.dCj = 2;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    AppMethodBeat.o(34545);
  }
  
  public final void eVC()
  {
    AppMethodBeat.i(34548);
    ((ak)this.FQd.be(ak.class)).wi(false);
    this.twb.setBottomPanelVisibility(8);
    AppMethodBeat.o(34548);
  }
  
  public final void eVD()
  {
    AppMethodBeat.i(34549);
    if (!q.a(this.FQd.GzJ, com.tencent.mm.loader.j.b.ais(), "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.FQd.GzJ.getContext(), this.FQd.GzJ.getMMResources().getString(2131763022), 1).show();
    }
    AppMethodBeat.o(34549);
  }
  
  public final void eVw()
  {
    AppMethodBeat.i(169859);
    Intent localIntent = new Intent();
    localIntent.setClass(this.FQd.GzJ.getContext(), NewFileExplorerUI.class);
    localIntent.putExtra("TO_USER", this.Gnj);
    this.FQd.a(localIntent, 227, new d.a()
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
  
  public final void eVz()
  {
    AppMethodBeat.i(34542);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.CAMERA", 22, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.FQd.GzJ.getContext(), "android.permission.RECORD_AUDIO", 22, "", "");
    ad.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.FQd.GzJ.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (com.tencent.mm.bj.d.hxx.zA(getTalkerUserName()))
    {
      ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(aj.getContext(), 2131760334, 0).show();
      AppMethodBeat.o(34542);
      return;
    }
    List localList;
    if (getTalkerUserName() != null)
    {
      localList = ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahs(getTalkerUserName());
      az.arV();
      String str1 = (String)com.tencent.mm.model.c.afk().get(2, null);
      bool = ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahp(getTalkerUserName());
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
      if ((localList.size() >= com.tencent.mm.plugin.multitalk.c.c.cTy()) && (i == 0))
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(aj.getContext(), aj.getContext().getString(2131761424, new Object[] { com.tencent.mm.plugin.multitalk.c.c.cTy() }), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).cRE())
        {
          ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(aj.getContext(), aj.getContext().getString(2131761410), 0).show();
          AppMethodBeat.o(34542);
          return;
        }
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).cRC())
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(aj.getContext(), aj.getContext().getString(2131761410), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.r.a.dV(this.FQd.GzJ.getContext()))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (bool)
      {
        ad.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        com.tencent.mm.ui.base.h.d(this.FQd.GzJ.getContext(), this.FQd.GzJ.getMMResources().getString(2131761452), "", this.FQd.GzJ.getMMResources().getString(2131761393), this.FQd.GzJ.getMMResources().getString(2131761390), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169853);
            if (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahp(p.this.getTalkerUserName()))
            {
              Toast.makeText(aj.getContext(), aj.getContext().getString(2131761445), 0).show();
              AppMethodBeat.o(169853);
              return;
            }
            if (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahv(p.this.getTalkerUserName())) {
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
      localIntent.putExtra("titile", this.FQd.GzJ.getMMResources().getString(2131761438));
      com.tencent.mm.bs.d.b(this.FQd.GzJ.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      if (this.twb.ezq()) {
        this.twb.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(34542);
      return;
    }
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(34521);
    if (this.Gni != null)
    {
      String str = this.Gni.getFileName();
      AppMethodBeat.o(34521);
      return str;
    }
    AppMethodBeat.o(34521);
    return "";
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(34535);
    if ((this.contact != null) && (af.st(this.contact.field_username)))
    {
      str = this.Gnj;
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
  
  public final void nb(boolean paramBoolean)
  {
    AppMethodBeat.i(34540);
    if (paramBoolean)
    {
      ((ag)this.FQd.be(ag.class)).keepSignalling();
      AppMethodBeat.o(34540);
      return;
    }
    ((ag)this.FQd.be(ag.class)).stopSignalling();
    AppMethodBeat.o(34540);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(34537);
    if (this.Gnl != null)
    {
      ad.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.Gnl.release();
      this.Gnl = null;
    }
    a.a locala = com.tencent.mm.cl.a.FFw;
    if (!a.a.aJT(this.Gni.getFileName()))
    {
      locala = com.tencent.mm.cl.a.FFw;
      if (!a.a.aJV(this.Gni.getFileName())) {
        eVt();
      }
    }
    this.hFy.stopTimer();
    this.omt.stopTimer();
    AppMethodBeat.o(34537);
  }
  
  public final void release()
  {
    AppMethodBeat.i(34536);
    if (this.Gnl != null)
    {
      ad.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.Gnl.release();
      this.Gnl = null;
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
    boolean GnD = false;
    p.a GnE;
    p.a GnF;
    p.a GnG;
    p.a GnH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p
 * JD-Core Version:    0.7.0.1
 */