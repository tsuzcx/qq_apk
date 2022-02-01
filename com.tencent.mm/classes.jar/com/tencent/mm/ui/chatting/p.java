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
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c.b;
import com.tencent.mm.br.d.a;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.a;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.av;
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
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.c.b.ag;
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
  public static boolean HMX = true;
  private String DrO;
  private boolean HJB;
  private com.tencent.mm.ak.k HMY;
  private String HMZ;
  private String HNa;
  private ToneGenerator HNb;
  private boolean HNc;
  private boolean HNd;
  public boolean HNe;
  private boolean HNf;
  private volatile boolean HNg;
  private volatile boolean HNh;
  private boolean HNi;
  private com.tencent.mm.ui.chatting.d.a HpO;
  private com.tencent.mm.storage.ai contact;
  private final au iga;
  private String jDP;
  private Object lock;
  private Vibrator njY;
  private final au oPT;
  private ChatFooter uEt;
  private final k.a uEx;
  private final k.b uEy;
  public AppPanel.a uFd;
  
  public p(com.tencent.mm.ui.chatting.d.a parama, ChatFooter paramChatFooter, String paramString)
  {
    AppMethodBeat.i(34518);
    this.HNf = true;
    this.DrO = "";
    this.jDP = "";
    this.uEx = new k.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(34487);
        p.a(p.this).reset();
        p.b(p.this).stopTimer();
        p.c(p.this).stopTimer();
        am.aKP("keep_app_silent");
        p.d(p.this).a(ChatFooter.h.DxW);
        ao localao = (ao)p.e(p.this).bf(ao.class);
        if ((localao != null) && (localao.foG() != null)) {
          localao.foG().fkr();
        }
        ac.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        p.e(p.this).HZF.enableOptionMenu(true);
        p.e(p.this).HZF.enableBackMenu(true);
        Toast.makeText(p.e(p.this).HZF.getContext(), p.e(p.this).HZF.getContext().getString(2131757276), 0).show();
        AppMethodBeat.o(34487);
      }
    };
    this.uEy = new k.b()
    {
      public final void aBG()
      {
        AppMethodBeat.i(34491);
        p.d(p.this).eOu();
        AppMethodBeat.o(34491);
      }
    };
    this.HNg = false;
    this.HNh = false;
    this.lock = new Object();
    this.iga = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34493);
        p.d(p.this).Xk(p.a(p.this).getMaxAmplitude());
        AppMethodBeat.o(34493);
        return true;
      }
    }, true);
    this.HNi = false;
    this.oPT = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34494);
        long l = p.a(p.this).Oq();
        ac.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(l)));
        int i = (int)((60000L - l) / 1000L);
        if ((l >= 50000L) && (l <= 60000L) && (!p.f(p.this)))
        {
          bs.iT(p.e(p.this).HZF.getContext());
          p.g(p.this);
        }
        p.d(p.this).setVoiceReactArea(i);
        if (l >= 60000L)
        {
          ac.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
          if (!p.d(p.this).ePk())
          {
            p.h(p.this);
            p.d(p.this).a(ChatFooter.h.DxR);
          }
          for (;;)
          {
            bc.aF(p.e(p.this).HZF.getContext(), 2131764424);
            AppMethodBeat.o(34494);
            return false;
            p.d(p.this).eOS();
          }
        }
        AppMethodBeat.o(34494);
        return true;
      }
    }, true);
    this.uFd = new AppPanel.a()
    {
      com.tencent.mm.ui.widget.a.e vHS = null;
      
      public final void Im(int paramAnonymousInt)
      {
        AppMethodBeat.i(34504);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34504);
          return;
          az.ayM();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.t.g(p.e(p.this).HZF.getContext(), p.e(p.this).HZF.getContentView());
            AppMethodBeat.o(34504);
            return;
          }
          Object localObject = p.e(p.this).HZF.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).getString("gallery", "1");
          com.tencent.mm.plugin.report.service.g.MH(19);
          if (((String)localObject).equalsIgnoreCase("0")) {
            q.f(p.e(p.this).HZF);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            AppMethodBeat.o(34504);
            return;
            localObject = p.e(p.this).foM();
            String str = p.e(p.this).getTalkerUserName();
            Intent localIntent = new Intent();
            if (p.e(p.this).foQ()) {
              localIntent.putExtra("gallery_report_tag", 20);
            }
            for (;;)
            {
              if ((!p.i(p.this)) || (!p.HMX)) {
                break label275;
              }
              q.a(p.e(p.this).HZF, (String)localObject, str, localIntent);
              break;
              localIntent.putExtra("gallery_report_tag", 21);
            }
            label275:
            if (com.tencent.mm.storage.ai.vC(str)) {
              q.a(p.e(p.this).HZF, 12, (String)localObject, str, localIntent);
            } else {
              q.a(p.e(p.this).HZF, 3, (String)localObject, str, localIntent);
            }
          }
          localObject = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aps());
          if ((!((com.tencent.mm.vfs.e)localObject).exists()) && (!((com.tencent.mm.vfs.e)localObject).mkdirs()))
          {
            Toast.makeText(p.e(p.this).HZF.getContext(), p.e(p.this).HZF.getMMResources().getString(2131757320), 1).show();
            AppMethodBeat.o(34504);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).HZF.getContext(), "android.permission.CAMERA", 20, "", "");
          ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), p.e(p.this).HZF.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34504);
            return;
          }
          p.this.flp();
        }
      }
      
      public final void In(int paramAnonymousInt)
      {
        AppMethodBeat.i(34510);
        if ((!com.tencent.mm.r.a.cg(p.e(p.this).HZF.getContext())) && (!com.tencent.mm.r.a.ci(p.e(p.this).HZF.getContext())) && (!com.tencent.mm.r.a.cf(p.e(p.this).HZF.getContext())) && (!com.tencent.mm.r.a.ck(p.e(p.this).HZF.getContext()))) {
          p.this.aaG(paramAnonymousInt);
        }
        AppMethodBeat.o(34510);
      }
      
      public final void d(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(34505);
        ((com.tencent.mm.ui.chatting.c.b.b)p.e(p.this).bf(com.tencent.mm.ui.chatting.c.b.b.class)).t(paramAnonymousg);
        AppMethodBeat.o(34505);
      }
      
      public final void dbN()
      {
        AppMethodBeat.i(34499);
        if (com.tencent.mm.r.a.cf(p.e(p.this).HZF.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.r.a.ch(p.e(p.this).HZF.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.r.a.ck(p.e(p.this).HZF.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        xg localxg = new xg();
        com.tencent.mm.sdk.b.a.GpY.l(localxg);
        if ((p.this.getTalkerUserName() != null) && (!p.this.getTalkerUserName().equals(localxg.dzZ.talker)) && ((localxg.dzZ.cYX) || (localxg.dzZ.cYY)))
        {
          if (localxg.dzZ.dAa) {}
          for (int i = 2131756778;; i = 2131756779)
          {
            Toast.makeText(p.e(p.this).HZF.getContext(), i, 0).show();
            ac.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34499);
            return;
          }
        }
        final boolean bool;
        if (1 == com.tencent.mm.m.g.ZY().getInt("EnableVoiceVoipFromPlugin", 0))
        {
          if ((!com.tencent.mm.storage.ai.aNc(p.e(p.this).AzG.field_username)) && (!w.wq(p.e(p.this).AzG.field_username))) {
            break label415;
          }
          if ((((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).Fn(p.e(p.this).AzG.field_openImAppid) & 0x2000) == 0) {
            bool = true;
          }
        }
        for (;;)
        {
          this.vHS = new com.tencent.mm.ui.widget.a.e(p.e(p.this).HZF.getContext(), 1, false);
          this.vHS.ISu = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(34495);
              paramAnonymous2l.aJ(2, 2131755762, 2131691164);
              if (!bool) {
                paramAnonymous2l.aJ(1, 2131755764, 2131691165);
              }
              AppMethodBeat.o(34495);
            }
          };
          this.vHS.ISv = new n.d()
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
                p.this.dqu();
                AppMethodBeat.o(34496);
                return;
                p.this.dqv();
              }
            }
          };
          this.vHS.cED();
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(34499);
            return;
            bool = false;
            break;
            p.this.fln();
          }
          label415:
          bool = false;
        }
      }
      
      public final void dbO()
      {
        AppMethodBeat.i(34500);
        if (com.tencent.mm.r.a.cf(p.e(p.this).HZF.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.r.a.ch(p.e(p.this).HZF.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.r.a.ck(p.e(p.this).HZF.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        xg localxg = new xg();
        com.tencent.mm.sdk.b.a.GpY.l(localxg);
        if ((!p.this.getTalkerUserName().equals(localxg.dzZ.talker)) && ((localxg.dzZ.cYX) || (localxg.dzZ.cYY)))
        {
          if (localxg.dzZ.dAa) {}
          for (int i = 2131756778;; i = 2131756779)
          {
            Toast.makeText(p.e(p.this).HZF.getContext(), i, 0).show();
            ac.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34500);
            return;
          }
        }
        p.this.flm();
        AppMethodBeat.o(34500);
      }
      
      public final void dbP()
      {
        AppMethodBeat.i(34501);
        if ((!com.tencent.mm.r.a.ci(p.e(p.this).HZF.getContext())) && (!com.tencent.mm.r.a.cf(p.e(p.this).HZF.getContext())) && (!com.tencent.mm.r.a.ck(p.e(p.this).HZF.getContext())))
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).HZF.getContext(), "android.permission.RECORD_AUDIO", 81, "", "");
          ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), p.e(p.this).HZF.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34501);
            return;
          }
          p.this.flo();
        }
        AppMethodBeat.o(34501);
      }
      
      public final void dbQ()
      {
        AppMethodBeat.i(34502);
        ((z)p.e(p.this).bf(z.class)).fnX();
        AppMethodBeat.o(34502);
      }
      
      public final void dbR()
      {
        AppMethodBeat.i(34503);
        ((com.tencent.mm.ui.chatting.c.b.e)p.e(p.this).bf(com.tencent.mm.ui.chatting.c.b.e.class)).fmF();
        AppMethodBeat.o(34503);
      }
      
      public final void dbS()
      {
        AppMethodBeat.i(34506);
        com.tencent.mm.br.d.b(p.e(p.this).HZF.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.o(34506);
      }
      
      public final void dbT()
      {
        AppMethodBeat.i(34507);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("3");
        if (f.so(p.j(p.this).field_username))
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
        com.tencent.mm.plugin.fav.a.b.b(p.e(p.this).HZF.getContext(), ".ui.FavSelectUI", localIntent);
        com.tencent.mm.plugin.report.service.h.wUl.f(14103, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(34507);
      }
      
      public final void dbU()
      {
        AppMethodBeat.i(34508);
        Intent localIntent = new Intent();
        localIntent.putExtra("service_app_talker_user", p.this.getTalkerUserName());
        com.tencent.mm.br.d.a(p.e(p.this).HZF, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
        AppMethodBeat.o(34508);
      }
      
      public final void dbV()
      {
        AppMethodBeat.i(34509);
        Object localObject;
        if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
        {
          localObject = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new HashMap());
          ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.flutter.a.a.class)).a(p.e(p.this).HZF.getContext(), (com.tencent.mm.plugin.flutter.a.c)localObject);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(12065, new Object[] { Integer.valueOf(4) });
          AppMethodBeat.o(34509);
          return;
          localObject = new Intent();
          ((Intent)localObject).putExtra("download_entrance_scene", 17);
          ((Intent)localObject).putExtra("preceding_scence", 13);
          com.tencent.mm.br.d.b(p.e(p.this).HZF.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
        }
      }
      
      public final void dbW()
      {
        AppMethodBeat.i(34511);
        com.tencent.mm.plugin.report.service.h.wUl.f(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.wUl.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        p.a(p.this, p.k(p.this) + "_" + System.currentTimeMillis());
        final String str = UUID.randomUUID().toString();
        p.O(2, 0, p.l(p.this));
        final p.b localb = p.flq();
        com.tencent.mm.kernel.g.agS();
        final int i = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GEv, 0);
        if (p.m(p.this))
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
          if ((i == 1) && (localb.HNu))
          {
            locale = new com.tencent.mm.ui.widget.a.e(p.e(p.this).HZF.getContext(), 1, false);
            locale.ISu = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(163290);
                paramAnonymous2l.c(0, p.e(p.this).HZF.getMMResources().getString(2131757246));
                p.a locala = p.a(localb);
                if (locala != null) {
                  paramAnonymous2l.a(1, locala.title, locala.desc, 0);
                }
                AppMethodBeat.o(163290);
              }
            };
            locale.ISv = new n.d()
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
                  com.tencent.mm.plugin.report.service.h.wUl.f(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
                  p.O(4, 0, p.l(p.this));
                  AppMethodBeat.o(163291);
                  return;
                  p.n(p.this);
                }
              }
            };
            locale.cED();
            p.flr();
            p.O(3, 0, p.l(p.this));
            AppMethodBeat.o(34511);
            return;
          }
          p.b(p.this, str);
          com.tencent.mm.plugin.report.service.h.wUl.f(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        if (((i != 1) || (!localb.HNu)) && (p.flj()))
        {
          p.c(p.this, str);
          com.tencent.mm.plugin.report.service.h.wUl.f(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(p.e(p.this).HZF.getContext(), 1, false);
        locale.ISu = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(163292);
            paramAnonymous2l.c(0, p.e(p.this).HZF.getMMResources().getString(2131757246));
            Object localObject;
            if (!p.flj())
            {
              localObject = new bv();
              ((bv)localObject).dNx = 13L;
              ((bv)localObject).aHZ();
              paramAnonymous2l.c(1, p.e(p.this).HZF.getMMResources().getString(2131757245));
            }
            if ((localb.HNu) && (i == 1))
            {
              localObject = p.a(localb);
              if (localObject != null) {
                paramAnonymous2l.a(2, ((p.a)localObject).title, ((p.a)localObject).desc, 0);
              }
            }
            AppMethodBeat.o(163292);
          }
        };
        locale.ISv = new n.d()
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
              com.tencent.mm.plugin.report.service.h.wUl.f(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
              p.O(4, 0, p.l(p.this));
              AppMethodBeat.o(163293);
              return;
              com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
              localIntent.putExtra("key_username", p.this.getTalkerUserName());
              localIntent.putExtra("key_way", 0);
              localIntent.putExtra("pay_channel", 11);
              com.tencent.mm.br.d.b(p.e(p.this).HZF.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", localIntent);
              paramAnonymous2MenuItem = new bv();
              paramAnonymous2MenuItem.dNx = 1L;
              paramAnonymous2MenuItem.aHZ();
              p.O(5, 0, p.l(p.this));
              AppMethodBeat.o(163293);
              return;
              p.n(p.this);
            }
          }
        };
        locale.cED();
        p.flr();
        p.O(3, 0, p.l(p.this));
        AppMethodBeat.o(34511);
      }
      
      public final void dbX()
      {
        AppMethodBeat.i(34512);
        az.ayM();
        com.tencent.mm.model.c.agA().set(81, Boolean.FALSE);
        if (!ax.isNetworkConnected(p.e(p.this).HZF.getContext()))
        {
          com.tencent.mm.bh.e.a(p.e(p.this).HZF.getContext(), 2131764895, null);
          AppMethodBeat.o(34512);
          return;
        }
        p.this.fll();
        AppMethodBeat.o(34512);
      }
      
      public final void dbY()
      {
        AppMethodBeat.i(34513);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_scene", 4);
        localIntent.putExtra("enterprise_biz_name", p.this.getTalkerUserName());
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.c.b.d)p.e(p.this).bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmB());
        com.tencent.mm.br.d.b(p.e(p.this).HZF.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
        AppMethodBeat.o(34513);
      }
      
      public final void dbZ()
      {
        AppMethodBeat.i(34514);
        if (p.m(p.this))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enter_scene", 1);
          localIntent.putExtra("chatroom_name", p.this.getTalkerUserName());
          com.tencent.mm.br.d.b(p.e(p.this).HZF.getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        }
        AppMethodBeat.o(34514);
      }
      
      public final void dca()
      {
        AppMethodBeat.i(34515);
        com.tencent.mm.plugin.report.service.h.wUl.f(14523, new Object[] { Integer.valueOf(0) });
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).HZF.getContext(), "android.permission.READ_EXTERNAL_STORAGE", 145, p.e(p.this).HZF.getContext().getString(2131761885), p.e(p.this).HZF.getContext().getString(2131763056));
        ac.i("MicroMsg.ChattingFooterEventImpl", "checkPermission checkStorage[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), p.e(p.this).HZF.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(34515);
          return;
        }
        p.this.fli();
        AppMethodBeat.o(34515);
      }
      
      public final void dcb()
      {
        AppMethodBeat.i(196424);
        ac.i("MicroMsg.ChattingFooterEventImpl", "gotoRoomLiveEntrance");
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).HZF.getContext(), "android.permission.CAMERA", 25, "", "");
        ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), p.e(p.this).HZF.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(196424);
          return;
        }
        bool = com.tencent.mm.pluginsdk.permission.b.a(p.e(p.this).HZF.getContext(), "android.permission.RECORD_AUDIO", 25, "", "");
        ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), p.e(p.this).HZF.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(196424);
          return;
        }
        if ((!com.tencent.mm.r.a.cg(p.e(p.this).HZF.getContext())) && (!com.tencent.mm.r.a.ci(p.e(p.this).HZF.getContext())) && (!com.tencent.mm.r.a.cf(p.e(p.this).HZF.getContext())) && (!com.tencent.mm.r.a.ck(p.e(p.this).HZF.getContext())))
        {
          if (com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GWa, 0) == 1)
          {
            final Activity localActivity = p.e(p.this).HZF.getContext();
            com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
            locall.ISu = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(196422);
                paramAnonymous2l.c(0, localActivity.getString(2131766586));
                paramAnonymous2l.c(1, localActivity.getString(2131766585));
                AppMethodBeat.o(196422);
              }
            };
            locall.ISv = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(196423);
                if (paramAnonymous2Int == 0)
                {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().a(p.e(p.this).HZF.getContext(), LiveConfig.P(p.e(p.this).getTalkerUserName(), LiveConfig.gmH));
                  AppMethodBeat.o(196423);
                  return;
                }
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(p.e(p.this).HZF.getContext(), LiveConfig.P(p.e(p.this).getTalkerUserName(), LiveConfig.gmH));
                AppMethodBeat.o(196423);
              }
            };
            locall.ftL();
            AppMethodBeat.o(196424);
            return;
          }
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(p.e(p.this).HZF.getContext(), LiveConfig.P(p.e(p.this).getTalkerUserName(), LiveConfig.gmH));
        }
        AppMethodBeat.o(196424);
      }
      
      public final void dcc()
      {
        AppMethodBeat.i(179848);
        ((v)p.e(p.this).bf(v.class)).fnw();
        AppMethodBeat.o(179848);
      }
      
      public final void dcd()
      {
        AppMethodBeat.i(196425);
        ac.i("MicroMsg.ChattingFooterEventImpl", "onEnterGroupSolitaire() chatroom:%s", new Object[] { p.e(p.this).getTalkerUserName() });
        Intent localIntent = new Intent();
        localIntent.putExtra("key_group_solitatire_create", true);
        localIntent.putExtra("key_group_solitatire_scene", 5);
        com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
        locala.header = (p.e(p.this).HZF.getContext().getString(2131760093) + "\n");
        locala.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(locala);
        locala.separator = ".";
        locala.tyU = 1;
        localIntent.putExtra("key_group_solitatire_key", locala.field_key);
        localIntent.putExtra("key_group_solitatire_chatroom_username", p.e(p.this).getTalkerUserName());
        com.tencent.mm.plugin.groupsolitaire.b.b.a(p.e(p.this).getTalkerUserName(), locala);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(p.e(p.this).getTalkerUserName(), locala);
        com.tencent.mm.br.d.b(p.e(p.this).HZF.getContext(), "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent);
        AppMethodBeat.o(196425);
      }
    };
    this.HpO = parama;
    this.uEt = paramChatFooter;
    this.HMZ = paramString;
    az.ayM();
    this.contact = com.tencent.mm.model.c.awB().aNt(paramString);
    this.HNc = w.sQ(this.HpO.getTalkerUserName());
    this.HNd = w.wy(this.HpO.getTalkerUserName());
    boolean bool;
    if ((this.HNc) || (this.HNd))
    {
      bool = true;
      this.HJB = bool;
      this.njY = ((Vibrator)this.HpO.HZF.getContext().getSystemService("vibrator"));
      if (!w.xd(this.HMZ)) {
        break label347;
      }
      this.HMY = new com.tencent.mm.plugin.subapp.d.i();
      ac.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.HMY.a(this.uEy);
      this.HMY.a(this.uEx);
      paramChatFooter.setAppPanelListener(this.uFd);
      this.HNf = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTO, true);
      az.ayM();
      this.DrO = ((String)com.tencent.mm.model.c.agA().get(2, null));
      AppMethodBeat.o(34518);
      return;
      bool = false;
      break;
      label347:
      parama = this.HMZ;
      int i;
      if (w.xo(parama)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label532;
        }
        this.HMY = new com.tencent.mm.audio.b.h(this.HpO.HZF.getContext(), true);
        ac.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parama);
        if ((parama != null) && (parama.fad()))
        {
          paramString = f.dX(parama.field_username);
          if (paramString != null)
          {
            paramString = paramString.bV(false);
            if (paramString != null)
            {
              if (paramString.cFq != null) {
                paramString.cFu = "1".equals(paramString.cFq.optString("CanReceiveSpeexVoice"));
              }
              if (paramString.cFu)
              {
                ac.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + parama.field_username + " canReceiveSpeexVoice");
                i = 1;
                continue;
              }
            }
          }
        }
        i = 0;
      }
      label532:
      this.HMY = new com.tencent.mm.audio.b.h(this.HpO.HZF.getContext(), false);
      ac.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
  }
  
  public static void O(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(163296);
    j localj = new j();
    localj.dFd = paramInt1;
    localj.dFg = System.currentTimeMillis();
    localj.dFe = localj.t("SessionId", paramString, true);
    localj.dFf = paramInt2;
    localj.aHZ();
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
    String str = com.tencent.mm.sdk.platformtools.ab.eUO();
    if ("zh_CN".equals(str))
    {
      paramb = paramb.HNv;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_TW".equals(str))
    {
      paramb = paramb.HNx;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_HK".equals(str))
    {
      paramb = paramb.HNw;
      AppMethodBeat.o(163300);
      return paramb;
    }
    paramb = paramb.HNy;
    AppMethodBeat.o(163300);
    return paramb;
  }
  
  private static void aaF(int paramInt)
  {
    AppMethodBeat.i(34541);
    px localpx = new px();
    localpx.dtb.state = paramInt;
    com.tencent.mm.sdk.b.a.GpY.l(localpx);
    AppMethodBeat.o(34541);
  }
  
  public static void dPE()
  {
    CaptureDataManager.wqi.wqh = null;
  }
  
  @Deprecated
  @SuppressLint({"NewApi"})
  private void fle()
  {
    AppMethodBeat.i(34532);
    this.HpO.xg(true);
    AppMethodBeat.o(34532);
  }
  
  private boolean flf()
  {
    boolean bool = false;
    int i = 1;
    AppMethodBeat.i(34534);
    this.HpO.HZF.enableOptionMenu(true);
    this.HpO.HZF.enableBackMenu(true);
    if (this.HMY != null) {
      if ((this.HMY.isRecording()) && (flg()))
      {
        bool = this.HMY.Fb();
        this.iga.stopTimer();
        this.oPT.stopTimer();
        if (i != 0) {
          flh();
        }
        am.aKP("keep_app_silent");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34534);
      return bool;
      i = 0;
      break;
      ac.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
    }
  }
  
  private boolean flg()
  {
    AppMethodBeat.i(34538);
    if ((this.contact.field_username.equals("medianote")) && ((u.axA() & 0x4000) == 0))
    {
      AppMethodBeat.o(34538);
      return true;
    }
    AppMethodBeat.o(34538);
    return false;
  }
  
  private void flh()
  {
    AppMethodBeat.i(34539);
    bo localbo = new bo();
    localbo.re("medianote");
    localbo.setType(34);
    localbo.jT(1);
    localbo.rf(this.HNa);
    localbo.setStatus(2);
    localbo.setContent(com.tencent.mm.modelvoice.p.b(u.axw(), this.HMY.Oo(), false));
    localbo.oA(bi.yp("medianote"));
    if (this.HMY.Or() == 2) {
      localbo.qf("SOURCE_SILK_FILE");
    }
    az.ayM();
    long l = com.tencent.mm.model.c.awD().ap(localbo);
    if (l <= 0L)
    {
      ac.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
      AppMethodBeat.o(34539);
      return;
    }
    ac.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(l)));
    AppMethodBeat.o(34539);
  }
  
  public static boolean flj()
  {
    AppMethodBeat.i(163297);
    az.ayM();
    Integer localInteger1 = (Integer)com.tencent.mm.model.c.agA().get(ah.a.GEt, Integer.valueOf(0));
    az.ayM();
    Integer localInteger2 = (Integer)com.tencent.mm.model.c.agA().get(ah.a.GEu, Integer.valueOf(0));
    if ((localInteger1.intValue() == 1) || (localInteger2.intValue() == 1)) {
      if (u.axD() != 0) {
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
  
  private static b flk()
  {
    AppMethodBeat.i(163298);
    b localb = new b();
    Object localObject = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pZw, "");
    if (bs.isNullOrNil((String)localObject))
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
        localb.HNu = false;
        localb.HNv = l((JSONObject)localObject, "simple_chinese");
        localb.HNw = l((JSONObject)localObject, "xg_traditional_chinese");
        localb.HNx = l((JSONObject)localObject, "tw_traditional_chinese");
        localb.HNy = l((JSONObject)localObject, "english");
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(163298);
      return localb;
      localb.HNu = true;
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
    this.HpO.setKeepScreenOn(false);
    AppMethodBeat.o(34533);
  }
  
  public final long Oq()
  {
    AppMethodBeat.i(34522);
    if (this.HMY != null)
    {
      long l = this.HMY.Oq();
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
      fle();
      this.HpO.flB();
    }
    AppMethodBeat.o(34531);
  }
  
  public final void aaG(final int paramInt)
  {
    AppMethodBeat.i(34543);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.CAMERA", 18, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.RECORD_AUDIO", 18, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    Object localObject1;
    if ((com.tencent.mm.sdk.a.b.eUk()) || (com.tencent.mm.platformtools.ab.iwE))
    {
      localObject1 = new com.tencent.mm.ui.tools.l(this.HpO.HZF.getContext());
      ((com.tencent.mm.ui.tools.l)localObject1).ISu = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(169854);
          paramAnonymousl.c(1, p.e(p.this).HZF.getMMResources().getString(2131755747));
          paramAnonymousl.c(5, "拍摄参数设置面板");
          AppMethodBeat.o(169854);
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).ISv = new n.d()
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
            com.tencent.mm.plugin.report.service.h.wUl.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            paramAnonymousMenuItem = new SightParams(1, paramInt);
            Object localObject = com.tencent.mm.modelvideo.t.DU(p.this.getTalkerUserName());
            com.tencent.mm.modelvideo.o.aJy();
            String str = com.tencent.mm.modelvideo.t.DV((String)localObject);
            com.tencent.mm.modelvideo.o.aJy();
            paramAnonymousMenuItem = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.DW((String)localObject), paramAnonymousMenuItem.hcZ, paramAnonymousMenuItem.hcZ.duration * 1000, 1);
            if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTP, false)) {
              paramAnonymousMenuItem.remuxType = 2;
            }
            localObject = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject).qwN = 3;
            if (p.o(p.this)) {
              ((VideoCaptureReportInfo)localObject).qwN = 4;
            }
            paramAnonymousMenuItem.wqK = ((VideoCaptureReportInfo)localObject);
            localObject = new UICustomParam.a();
            ((UICustomParam.a)localObject).YX();
            ((UICustomParam.a)localObject).YW();
            ((UICustomParam.a)localObject).cN(true);
            paramAnonymousMenuItem.wqu = ((UICustomParam.a)localObject).fKH;
            localObject = new CaptureDataManager.b()
            {
              public final void a(Context paramAnonymous2Context, CaptureDataManager.CaptureVideoNormalModel paramAnonymous2CaptureVideoNormalModel, Bundle paramAnonymous2Bundle)
              {
                AppMethodBeat.i(169855);
                paramAnonymous2Bundle = new bsz();
                paramAnonymous2Bundle.FhZ = true;
                paramAnonymous2Bundle.FhY = false;
                String str = com.tencent.mm.vfs.i.aSu(paramAnonymous2CaptureVideoNormalModel.videoPath);
                paramAnonymous2Bundle = new SightCaptureResult(true, paramAnonymous2CaptureVideoNormalModel.videoPath, paramAnonymous2CaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymous2CaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymous2CaptureVideoNormalModel.wqk.longValue() * 1.0F / 1000.0F), paramAnonymous2Bundle);
                if (paramAnonymous2CaptureVideoNormalModel.wql.booleanValue())
                {
                  paramAnonymous2Bundle.uJm = true;
                  paramAnonymous2Bundle.oWm = false;
                  paramAnonymous2Bundle.uJu = paramAnonymous2CaptureVideoNormalModel.thumbPath;
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
            CaptureDataManager.wqi.wqh = ((CaptureDataManager.b)localObject);
            if (p.p(p.this))
            {
              localObject = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(p.e(p.this).HZF.getContext(), 226, 2130772137, 2130772138, paramAnonymousMenuItem);
              AppMethodBeat.o(169856);
              return;
            }
            q.a(p.e(p.this).HZF, new Intent(), p.this.getTalkerUserName(), paramInt);
            AppMethodBeat.o(169856);
            return;
            com.tencent.mm.br.d.b(p.e(p.this).HZF.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
          }
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).ftL();
      AppMethodBeat.o(34543);
      return;
    }
    if (!com.tencent.mm.platformtools.ab.iwF)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new SightParams(1, paramInt);
      Object localObject2 = com.tencent.mm.modelvideo.t.DU(getTalkerUserName());
      com.tencent.mm.modelvideo.o.aJy();
      String str = com.tencent.mm.modelvideo.t.DV((String)localObject2);
      com.tencent.mm.modelvideo.o.aJy();
      localObject1 = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.DW((String)localObject2), ((SightParams)localObject1).hcZ, ((SightParams)localObject1).hcZ.duration * 1000, 1);
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTP, false)) {
        ((RecordConfigProvider)localObject1).remuxType = 2;
      }
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).qwN = 3;
      if (this.HJB) {
        ((VideoCaptureReportInfo)localObject2).qwN = 4;
      }
      ((RecordConfigProvider)localObject1).wqK = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).YX();
      ((UICustomParam.a)localObject2).YW();
      ((UICustomParam.a)localObject2).cN(true);
      ((RecordConfigProvider)localObject1).wqu = ((UICustomParam.a)localObject2).fKH;
      localObject2 = new CaptureDataManager.b()
      {
        public final void a(Context paramAnonymousContext, CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(169857);
          paramAnonymousBundle = new bsz();
          paramAnonymousBundle.FhZ = true;
          paramAnonymousBundle.FhY = false;
          String str = com.tencent.mm.vfs.i.aSu(paramAnonymousCaptureVideoNormalModel.videoPath);
          paramAnonymousBundle = new SightCaptureResult(true, paramAnonymousCaptureVideoNormalModel.videoPath, paramAnonymousCaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymousCaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymousCaptureVideoNormalModel.wqk.longValue() * 1.0F / 1000.0F), paramAnonymousBundle);
          if (paramAnonymousCaptureVideoNormalModel.wql.booleanValue())
          {
            paramAnonymousBundle.uJm = true;
            paramAnonymousBundle.oWm = false;
            paramAnonymousBundle.uJu = paramAnonymousCaptureVideoNormalModel.thumbPath;
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
      CaptureDataManager.wqi.wqh = ((CaptureDataManager.b)localObject2);
      if (this.HNf)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this.HpO.HZF.getContext(), 226, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
        AppMethodBeat.o(34543);
        return;
      }
      q.a(this.HpO.HZF, new Intent(), getTalkerUserName(), paramInt);
    }
    AppMethodBeat.o(34543);
  }
  
  public final void aim(String paramString)
  {
    AppMethodBeat.i(34526);
    ((com.tencent.mm.ui.chatting.c.b.ai)this.HpO.bf(com.tencent.mm.ui.chatting.c.b.ai.class)).aim(paramString);
    AppMethodBeat.o(34526);
  }
  
  public final boolean akA(String paramString)
  {
    AppMethodBeat.i(34525);
    fle();
    this.HpO.flB();
    boolean bool = ((com.tencent.mm.ui.chatting.c.b.ai)this.HpO.bf(com.tencent.mm.ui.chatting.c.b.ai.class)).aQp(paramString);
    AppMethodBeat.o(34525);
    return bool;
  }
  
  public final boolean akB(String paramString)
  {
    AppMethodBeat.i(34528);
    if (!bs.isNullOrNil(paramString))
    {
      s.EF(paramString);
      com.tencent.mm.modelvoice.o.aKr().run();
      AppMethodBeat.o(34528);
      return true;
    }
    AppMethodBeat.o(34528);
    return false;
  }
  
  public final boolean dI(String paramString, int paramInt)
  {
    AppMethodBeat.i(34527);
    if ((!bs.isNullOrNil(paramString)) && (paramInt > 0) && (s.EL(paramString) != null))
    {
      s.au(paramString, paramInt);
      com.tencent.mm.modelvoice.o.aKr().run();
      AppMethodBeat.o(34527);
      return true;
    }
    AppMethodBeat.o(34527);
    return false;
  }
  
  public final boolean dbB()
  {
    AppMethodBeat.i(34519);
    synchronized (this.lock)
    {
      this.HNg = true;
      if (!this.HNh)
      {
        ac.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34519);
        return false;
      }
    }
    this.HNh = false;
    releaseWakeLock();
    if (!flf())
    {
      this.uEt.bZu();
      ac.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
      ((ao)this.HpO.bf(ao.class)).foG().fkr();
      ((ag)this.HpO.bf(ag.class)).abb(4);
      ((ag)this.HpO.bf(ag.class)).stopSignalling();
      aaF(1);
      ((ao)this.HpO.bf(ao.class)).a(this.HpO.HZF, false);
      AppMethodBeat.o(34519);
      return true;
    }
    this.uEt.setExitType(0);
    ??? = this.uEt;
    if (!((ChatFooter)???).DvE) {
      if (1 != ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pZy, 1)) {
        break label369;
      }
    }
    label369:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject3 = com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences(ChatFooter.Dxf, 0);
        if (((SharedPreferences)localObject3).getInt("trans2txt_edu_key", 0) == 0)
        {
          ((SharedPreferences)localObject3).edit().putInt("trans2txt_edu_key", 1).apply();
          localObject3 = new bo();
          ??? = ((ChatFooter)???).DuX.getTalkerUserName();
          ((bo)localObject3).oA(bi.yp((String)???));
          ((bo)localObject3).re((String)???);
          ((bo)localObject3).setContent(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764710));
          ((bo)localObject3).setType(10000);
          ((bo)localObject3).setStatus(6);
          ((bo)localObject3).jT(0);
          az.ayM();
          com.tencent.mm.model.c.awD().ap((bo)localObject3);
        }
      }
      this.uEt.a(ChatFooter.h.DxR);
      ac.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
      break;
    }
  }
  
  public final boolean dbC()
  {
    AppMethodBeat.i(34520);
    ac.v("MicroMsg.ChattingFooterEventImpl", "only stop recording.");
    synchronized (this.lock)
    {
      this.HNg = true;
      if (!this.HNh)
      {
        ac.i("MicroMsg.ChattingFooterEventImpl", "ever never begin.");
        AppMethodBeat.o(34520);
        return false;
      }
    }
    this.HNh = false;
    releaseWakeLock();
    this.HpO.HZF.enableOptionMenu(true);
    this.HpO.HZF.enableBackMenu(true);
    if (this.HMY != null)
    {
      this.HMY.Op();
      this.iga.stopTimer();
      this.oPT.stopTimer();
    }
    this.uEt.a(ChatFooter.h.DxS);
    ((ao)this.HpO.bf(ao.class)).foG().fkr();
    ((ag)this.HpO.bf(ag.class)).abb(4);
    ((ag)this.HpO.bf(ag.class)).stopSignalling();
    aaF(1);
    ((ao)this.HpO.bf(ao.class)).a(this.HpO.HZF, false);
    AppMethodBeat.o(34520);
    return true;
  }
  
  public final boolean dbE()
  {
    AppMethodBeat.i(34523);
    ac.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.HNg = true;
      if (!this.HNh)
      {
        ac.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34523);
        return false;
      }
    }
    this.HNh = false;
    releaseWakeLock();
    dbF();
    this.uEt.a(ChatFooter.h.DxU);
    ((ao)this.HpO.bf(ao.class)).foG().fkr();
    ((ag)this.HpO.bf(ag.class)).abb(4);
    ((ag)this.HpO.bf(ag.class)).stopSignalling();
    aaF(1);
    ((ao)this.HpO.bf(ao.class)).a(this.HpO.HZF, false);
    AppMethodBeat.o(34523);
    return true;
  }
  
  public final void dbF()
  {
    AppMethodBeat.i(185863);
    this.HpO.HZF.enableOptionMenu(true);
    this.HpO.HZF.enableBackMenu(true);
    if (this.HMY != null)
    {
      this.HMY.cancel();
      this.iga.stopTimer();
      this.oPT.stopTimer();
    }
    this.uEt.a(ChatFooter.h.DxU);
    AppMethodBeat.o(185863);
  }
  
  public final boolean dbG()
  {
    AppMethodBeat.i(34524);
    if ((com.tencent.mm.r.a.ci(this.HpO.HZF.getContext())) || (com.tencent.mm.r.a.cf(this.HpO.HZF.getContext())) || (com.tencent.mm.r.a.ck(this.HpO.HZF.getContext())))
    {
      ac.d("MicroMsg.ChattingFooterEventImpl", "voip is running, can't record voice");
      AppMethodBeat.o(34524);
      return false;
    }
    ??? = this.HpO.HZF.getContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)((Context)???).getSystemService("phone");
    if ((2 == localTelephonyManager.getCallState()) || (1 == localTelephonyManager.getCallState())) {
      Toast.makeText((Context)???, ((Context)???).getString(2131760281), 0).show();
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ac.d("MicroMsg.ChattingFooterEventImpl", "system has calling , can't record voice");
        AppMethodBeat.o(34524);
        return false;
      }
      if (com.tencent.mm.r.a.ch(this.HpO.HZF.getContext()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.HpO.HZF.getContext(), this.HpO.HZF.getContentView());
        ac.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        AppMethodBeat.o(34524);
        return false;
      }
      if (!com.tencent.mm.compatible.d.b.Yy()) {
        com.tencent.mm.ui.base.h.a(this.HpO.HZF.getContext(), this.HpO.HZF.getMMResources().getString(2131755901), this.HpO.HZF.getMMResources().getString(2131755824), this.HpO.HZF.getMMResources().getString(2131755826), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34492);
            com.tencent.mm.compatible.d.b.cb(p.e(p.this).HZF.getContext());
            AppMethodBeat.o(34492);
          }
        });
      }
      synchronized (this.lock)
      {
        this.HNg = false;
      }
      synchronized (this.lock)
      {
        if (this.HNg)
        {
          ac.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
          AppMethodBeat.o(34524);
          return false;
          localObject2 = finally;
          AppMethodBeat.o(34524);
          throw localObject2;
        }
        if (this.HpO.HZF.getContext().isFinishing())
        {
          AppMethodBeat.o(34524);
          return false;
        }
      }
      if ((Build.VERSION.SDK_INT >= 17) && (this.HpO.HZF.getContext().isDestroyed()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      this.HNh = true;
      ??? = com.tencent.mm.plugin.transvoice.a.c.Akm;
      com.tencent.mm.plugin.transvoice.a.c.efd().AjT = true;
      this.iga.au(100L, 100L);
      this.HNi = false;
      this.oPT.au(200L, 200L);
      this.uEt.Xj(this.HpO.getListView().getHeight());
      ??? = ((ao)this.HpO.bf(ao.class)).foG();
      ((d)???).hba = true;
      ((d)???).ami();
      ((d)???).fkq();
      this.HpO.HZF.enableOptionMenu(false);
      this.HpO.HZF.enableBackMenu(false);
      if (this.HMY != null)
      {
        am.aKO("keep_app_silent");
        this.uEt.setVoiceReactArea(-1);
        this.HMY.fF(getTalkerUserName());
        this.HNa = this.HMY.getFileName();
        this.HMY.a(this.uEy);
        this.njY.vibrate(50L);
        this.HpO.bJU();
        fle();
        this.HMY.a(this.uEx);
      }
      for (;;)
      {
        this.HpO.setKeepScreenOn(true);
        ((ag)this.HpO.bf(ag.class)).abb(3);
        ((ag)this.HpO.bf(ag.class)).keepSignalling();
        aaF(0);
        ((ao)this.HpO.bf(ao.class)).a(this.HpO.HZF, true);
        AppMethodBeat.o(34524);
        return true;
        ac.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
      }
    }
  }
  
  public final void dbH()
  {
    AppMethodBeat.i(34529);
    fle();
    this.HpO.flB();
    AppMethodBeat.o(34529);
  }
  
  public final void dbI()
  {
    AppMethodBeat.i(34530);
    fle();
    this.HpO.flB();
    AppMethodBeat.o(34530);
  }
  
  public final void dbJ()
  {
    AppMethodBeat.i(196426);
    fle();
    this.HpO.flB();
    AppMethodBeat.o(196426);
  }
  
  public final void dqu()
  {
    AppMethodBeat.i(34546);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.RECORD_AUDIO", 82, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34546);
      return;
    }
    xh localxh = new xh();
    localxh.dAb.dgL = 5;
    localxh.dAb.talker = getTalkerUserName();
    localxh.dAb.context = this.HpO.HZF.getContext();
    localxh.dAb.dzX = 4;
    if (this.uEt.eOK()) {
      this.uEt.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    AppMethodBeat.o(34546);
  }
  
  public final void dqv()
  {
    AppMethodBeat.i(34547);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.CAMERA", 19, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.RECORD_AUDIO", 19, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    xh localxh = new xh();
    localxh.dAb.dgL = 5;
    localxh.dAb.talker = getTalkerUserName();
    localxh.dAb.context = this.HpO.HZF.getContext();
    localxh.dAb.dzX = 2;
    if (this.uEt.eOK()) {
      this.uEt.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    AppMethodBeat.o(34547);
  }
  
  public final void fli()
  {
    AppMethodBeat.i(169859);
    Intent localIntent = new Intent();
    localIntent.setClass(this.HpO.HZF.getContext(), NewFileExplorerUI.class);
    localIntent.putExtra("TO_USER", this.HMZ);
    this.HpO.a(localIntent, 227, new d.a()
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
  
  public final void fll()
  {
    AppMethodBeat.i(34542);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.CAMERA", 22, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.RECORD_AUDIO", 22, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    ac.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (com.tencent.mm.bi.d.hXY.DF(getTalkerUserName()))
    {
      ac.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), 2131760334, 0).show();
      AppMethodBeat.o(34542);
      return;
    }
    List localList;
    if (getTalkerUserName() != null)
    {
      localList = ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amn(getTalkerUserName());
      az.ayM();
      String str1 = (String)com.tencent.mm.model.c.agA().get(2, null);
      bool = ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amk(getTalkerUserName());
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
      if ((localList.size() >= com.tencent.mm.plugin.multitalk.c.c.dhi()) && (i == 0))
      {
        ac.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761424, new Object[] { com.tencent.mm.plugin.multitalk.c.c.dhi() }), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).dfo())
        {
          ac.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761410), 0).show();
          AppMethodBeat.o(34542);
          return;
        }
        ac.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).dfm())
      {
        ac.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761410), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.r.a.ck(this.HpO.HZF.getContext()))
      {
        ac.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in appbrand voice!");
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.r.a.ch(this.HpO.HZF.getContext()))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (bool)
      {
        ac.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        com.tencent.mm.ui.base.h.d(this.HpO.HZF.getContext(), this.HpO.HZF.getMMResources().getString(2131761452), "", this.HpO.HZF.getMMResources().getString(2131761393), this.HpO.HZF.getMMResources().getString(2131761390), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169853);
            if (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amk(p.this.getTalkerUserName()))
            {
              Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761445), 0).show();
              AppMethodBeat.o(169853);
              return;
            }
            if (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amq(p.this.getTalkerUserName())) {
              Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761403), 0).show();
            }
            AppMethodBeat.o(169853);
          }
        }, null);
        AppMethodBeat.o(34542);
        return;
      }
      localIntent.putExtra("chatroomName", getTalkerUserName());
      localIntent.putExtra("key_need_gallery", true);
      localIntent.putExtra("titile", this.HpO.HZF.getMMResources().getString(2131761438));
      com.tencent.mm.br.d.b(this.HpO.HZF.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      if (this.uEt.eOK()) {
        this.uEt.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(34542);
      return;
    }
  }
  
  public final void flm()
  {
    AppMethodBeat.i(34544);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.RECORD_AUDIO", 83, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34544);
      return;
    }
    if (this.uEt.eOK()) {
      this.uEt.setBottomPanelVisibility(8);
    }
    xh localxh = new xh();
    localxh.dAb.dgL = 5;
    localxh.dAb.talker = getTalkerUserName();
    localxh.dAb.context = this.HpO.HZF.getContext();
    localxh.dAb.dzX = 3;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    com.tencent.mm.plugin.report.service.h.wUl.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
    AppMethodBeat.o(34544);
  }
  
  public final void fln()
  {
    AppMethodBeat.i(34545);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.CAMERA", 21, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.HpO.HZF.getContext(), "android.permission.RECORD_AUDIO", 21, "", "");
    ac.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.HpO.HZF.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    if (this.uEt.eOK()) {
      this.uEt.setBottomPanelVisibility(8);
    }
    xh localxh = new xh();
    localxh.dAb.dgL = 5;
    localxh.dAb.talker = getTalkerUserName();
    localxh.dAb.context = this.HpO.HZF.getContext();
    localxh.dAb.dzX = 2;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    AppMethodBeat.o(34545);
  }
  
  public final void flo()
  {
    AppMethodBeat.i(34548);
    ((ak)this.HpO.bf(ak.class)).xm(false);
    this.uEt.setBottomPanelVisibility(8);
    AppMethodBeat.o(34548);
  }
  
  public final void flp()
  {
    AppMethodBeat.i(34549);
    if (!q.a(this.HpO.HZF, com.tencent.mm.loader.j.b.aps(), "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.HpO.HZF.getContext(), this.HpO.HZF.getMMResources().getString(2131763022), 1).show();
    }
    AppMethodBeat.o(34549);
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(34521);
    if (this.HMY != null)
    {
      String str = this.HMY.getFileName();
      AppMethodBeat.o(34521);
      return str;
    }
    AppMethodBeat.o(34521);
    return "";
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(34535);
    if ((this.contact != null) && (com.tencent.mm.storage.ai.ww(this.contact.field_username)))
    {
      str = this.HMZ;
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
  
  public final void nU(boolean paramBoolean)
  {
    AppMethodBeat.i(34540);
    if (paramBoolean)
    {
      ((ag)this.HpO.bf(ag.class)).keepSignalling();
      AppMethodBeat.o(34540);
      return;
    }
    ((ag)this.HpO.bf(ag.class)).stopSignalling();
    AppMethodBeat.o(34540);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(34537);
    if (this.HNb != null)
    {
      ac.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.HNb.release();
      this.HNb = null;
    }
    a.a locala = com.tencent.mm.ck.a.Hez;
    if (!a.a.aPr(this.HMY.getFileName()))
    {
      locala = com.tencent.mm.ck.a.Hez;
      if (!a.a.aPt(this.HMY.getFileName())) {
        flf();
      }
    }
    this.iga.stopTimer();
    this.oPT.stopTimer();
    AppMethodBeat.o(34537);
  }
  
  public final void release()
  {
    AppMethodBeat.i(34536);
    if (this.HNb != null)
    {
      ac.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.HNb.release();
      this.HNb = null;
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
    boolean HNu = false;
    p.a HNv;
    p.a HNw;
    p.a HNx;
    p.a HNy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p
 * JD-Core Version:    0.7.0.1
 */