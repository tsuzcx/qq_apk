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
import com.tencent.mm.ak.m.a;
import com.tencent.mm.ak.m.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.br.c.a;
import com.tencent.mm.cj.a.a;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zi.a;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.n.f;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.d.b.aq;
import com.tencent.mm.ui.chatting.d.b.aw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public final class q
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  public static boolean PgR = true;
  private com.tencent.mm.ui.chatting.e.a OIz;
  private boolean Pdm;
  public com.tencent.mm.ak.m PgS;
  private String PgT;
  private String PgU;
  private ToneGenerator PgV;
  private boolean PgW;
  private boolean PgX;
  public boolean PgY;
  private boolean PgZ;
  private volatile boolean Pha;
  private volatile boolean Phb;
  private boolean Phc;
  private com.tencent.mm.storage.as contact;
  private final MTimerHandler jxC;
  private String lem;
  private Object lock;
  private Vibrator paT;
  private final MTimerHandler qPy;
  private String tOw;
  private ChatFooter znD;
  private final m.a znH;
  private final m.b znI;
  public AppPanel.a zon;
  
  public q(com.tencent.mm.ui.chatting.e.a parama, ChatFooter paramChatFooter, String paramString)
  {
    AppMethodBeat.i(34518);
    this.PgZ = true;
    this.tOw = "";
    this.lem = "";
    this.znH = new m.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(34487);
        q.a(q.this).reset();
        q.b(q.this).stopTimer();
        q.c(q.this).stopTimer();
        MMEntryLock.unlock("keep_app_silent");
        q.d(q.this).a(ChatFooter.h.Kmy);
        aw localaw = (aw)q.e(q.this).bh(aw.class);
        if ((localaw != null) && (localaw.gRx() != null)) {
          localaw.gRx().gMP();
        }
        Log.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        q.e(q.this).Pwc.enableOptionMenu(true);
        q.e(q.this).Pwc.enableBackMenu(true);
        Toast.makeText(q.e(q.this).Pwc.getContext(), q.e(q.this).Pwc.getContext().getString(2131757490), 0).show();
        AppMethodBeat.o(34487);
      }
    };
    this.znI = new m.b()
    {
      public final void aYN()
      {
        AppMethodBeat.i(34491);
        q.d(q.this).gqr();
        AppMethodBeat.o(34491);
      }
    };
    this.Pha = false;
    this.Phb = false;
    this.lock = new Object();
    this.jxC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34493);
        q.d(q.this).aiy(q.a(q.this).getMaxAmplitude());
        AppMethodBeat.o(34493);
        return true;
      }
    }, true);
    this.Phc = false;
    this.qPy = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34494);
        long l = q.a(q.this).aas();
        Log.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(l)));
        int i = (int)((60000L - l) / 1000L);
        if ((l >= 50000L) && (l <= 60000L) && (!q.f(q.this)))
        {
          Util.lightShake(q.e(q.this).Pwc.getContext());
          q.g(q.this);
        }
        q.d(q.this).setVoiceReactArea(i);
        if (l >= 60000L)
        {
          Log.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
          if (!q.d(q.this).grl())
          {
            q.h(q.this);
            q.d(q.this).a(ChatFooter.h.Kmt);
          }
          for (;;)
          {
            PlaySound.play(q.e(q.this).Pwc.getContext(), 2131766767);
            AppMethodBeat.o(34494);
            return false;
            q.d(q.this).gqR();
          }
        }
        AppMethodBeat.o(34494);
        return true;
      }
    }, true);
    this.zon = new AppPanel.a()
    {
      com.tencent.mm.ui.widget.a.e Bcp = null;
      
      public final void Qj(int paramAnonymousInt)
      {
        AppMethodBeat.i(34504);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34504);
          return;
          bg.aVF();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            u.g(q.e(q.this).Pwc.getContext(), q.e(q.this).Pwc.getContentView());
            AppMethodBeat.o(34504);
            return;
          }
          Object localObject = q.e(q.this).Pwc.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
          com.tencent.mm.plugin.report.service.g.Wl(19);
          if (((String)localObject).equalsIgnoreCase("0")) {
            com.tencent.mm.pluginsdk.ui.tools.s.f(q.e(q.this).Pwc);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            AppMethodBeat.o(34504);
            return;
            localObject = q.e(q.this).gRI();
            String str = q.e(q.this).getTalkerUserName();
            Intent localIntent = new Intent();
            if (q.e(q.this).gRM()) {
              localIntent.putExtra("gallery_report_tag", 20);
            }
            for (;;)
            {
              if (com.tencent.mm.storage.as.bju(str)) {
                localIntent.putExtra("album_business_tag", "album_business_byp");
              }
              if ((!q.i(q.this)) || (!q.PgR)) {
                break label293;
              }
              com.tencent.mm.pluginsdk.ui.tools.s.a(q.e(q.this).Pwc, (String)localObject, str, localIntent);
              break;
              localIntent.putExtra("gallery_report_tag", 21);
            }
            label293:
            if (com.tencent.mm.storage.as.HF(str)) {
              com.tencent.mm.pluginsdk.ui.tools.s.a(q.e(q.this).Pwc, 12, (String)localObject, str, localIntent);
            } else {
              com.tencent.mm.pluginsdk.ui.tools.s.a(q.e(q.this).Pwc, 3, (String)localObject, str, localIntent);
            }
          }
          localObject = new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKV());
          if ((!((com.tencent.mm.vfs.o)localObject).exists()) && (!((com.tencent.mm.vfs.o)localObject).mkdirs()))
          {
            Toast.makeText(q.e(q.this).Pwc.getContext(), q.e(q.this).Pwc.getMMResources().getString(2131757534), 1).show();
            AppMethodBeat.o(34504);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Pwc.getContext(), "android.permission.CAMERA", 20, "", "");
          Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).Pwc.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34504);
            return;
          }
          q.this.gNO();
        }
      }
      
      public final void Qk(int paramAnonymousInt)
      {
        AppMethodBeat.i(34510);
        if ((!com.tencent.mm.q.a.o(q.e(q.this).Pwc.getContext(), true)) && (!com.tencent.mm.q.a.cC(q.e(q.this).Pwc.getContext())) && (!com.tencent.mm.q.a.cA(q.e(q.this).Pwc.getContext())) && (!com.tencent.mm.q.a.cE(q.e(q.this).Pwc.getContext()))) {
          q.this.ami(paramAnonymousInt);
        }
        AppMethodBeat.o(34510);
      }
      
      public final void d(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(34505);
        ((com.tencent.mm.ui.chatting.d.b.b)q.e(q.this).bh(com.tencent.mm.ui.chatting.d.b.b.class)).u(paramAnonymousg);
        AppMethodBeat.o(34505);
      }
      
      public final void ehU()
      {
        AppMethodBeat.i(34499);
        if (com.tencent.mm.q.a.cA(q.e(q.this).Pwc.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.q.a.cB(q.e(q.this).Pwc.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.q.a.p(q.e(q.this).Pwc.getContext(), true))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.q.a.cE(q.e(q.this).Pwc.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        zi localzi = new zi();
        EventCenter.instance.publish(localzi);
        if ((q.this.getTalkerUserName() != null) && (!q.this.getTalkerUserName().equals(localzi.efv.talker)) && ((localzi.efv.dCH) || (localzi.efv.dCI)))
        {
          if (localzi.efv.efw) {}
          for (int i = 2131756942;; i = 2131756943)
          {
            Toast.makeText(q.e(q.this).Pwc.getContext(), i, 0).show();
            Log.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34499);
            return;
          }
        }
        final boolean bool;
        if (1 == com.tencent.mm.n.h.aqJ().getInt("EnableVoiceVoipFromPlugin", 0))
        {
          if ((!com.tencent.mm.storage.as.bjp(q.e(q.this).GUe.field_username)) && (!ab.Iy(q.e(q.this).GUe.field_username))) {
            break label442;
          }
          if ((((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).RZ(q.e(q.this).GUe.field_openImAppid) & 0x2000) == 0) {
            bool = true;
          }
        }
        for (;;)
        {
          this.Bcp = new com.tencent.mm.ui.widget.a.e(q.e(q.this).Pwc.getContext(), 1, false);
          this.Bcp.HLX = new o.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
            {
              AppMethodBeat.i(34495);
              paramAnonymous2m.aS(2, 2131755840, 2131691478);
              if (!bool) {
                paramAnonymous2m.aS(1, 2131755842, 2131691479);
              }
              AppMethodBeat.o(34495);
            }
          };
          this.Bcp.HLY = new o.g()
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
                q.this.eEK();
                AppMethodBeat.o(34496);
                return;
                q.this.eEL();
              }
            }
          };
          this.Bcp.dGm();
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(34499);
            return;
            bool = false;
            break;
            q.this.gNM();
          }
          label442:
          bool = false;
        }
      }
      
      public final void ehV()
      {
        AppMethodBeat.i(34500);
        if (com.tencent.mm.q.a.cA(q.e(q.this).Pwc.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.q.a.cB(q.e(q.this).Pwc.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.q.a.cE(q.e(q.this).Pwc.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        zi localzi = new zi();
        EventCenter.instance.publish(localzi);
        if ((!q.this.getTalkerUserName().equals(localzi.efv.talker)) && ((localzi.efv.dCH) || (localzi.efv.dCI)))
        {
          if (localzi.efv.efw) {}
          for (int i = 2131756942;; i = 2131756943)
          {
            Toast.makeText(q.e(q.this).Pwc.getContext(), i, 0).show();
            Log.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34500);
            return;
          }
        }
        q.this.gNL();
        AppMethodBeat.o(34500);
      }
      
      public final void ehW()
      {
        AppMethodBeat.i(34501);
        if ((!com.tencent.mm.q.a.cC(q.e(q.this).Pwc.getContext())) && (!com.tencent.mm.q.a.cA(q.e(q.this).Pwc.getContext())) && (!com.tencent.mm.q.a.cE(q.e(q.this).Pwc.getContext())))
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Pwc.getContext(), "android.permission.RECORD_AUDIO", 81, "", "");
          Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).Pwc.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34501);
            return;
          }
          q.this.gNN();
        }
        AppMethodBeat.o(34501);
      }
      
      public final void ehX()
      {
        AppMethodBeat.i(34502);
        ((ad)q.e(q.this).bh(ad.class)).gQI();
        AppMethodBeat.o(34502);
      }
      
      public final void ehY()
      {
        AppMethodBeat.i(34503);
        ((com.tencent.mm.ui.chatting.d.b.e)q.e(q.this).bh(com.tencent.mm.ui.chatting.d.b.e.class)).gPg();
        AppMethodBeat.o(34503);
      }
      
      public final void ehZ()
      {
        AppMethodBeat.i(34506);
        com.tencent.mm.br.c.b(q.e(q.this).Pwc.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.o(34506);
      }
      
      public final void eia()
      {
        AppMethodBeat.i(34507);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("3");
        if (com.tencent.mm.al.g.DQ(q.j(q.this).field_username))
        {
          localArrayList.add("4");
          localArrayList.add("7");
          localArrayList.add("21");
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
        com.tencent.mm.plugin.fav.a.b.b(q.e(q.this).Pwc.getContext(), ".ui.FavSelectUI", localIntent);
        com.tencent.mm.plugin.report.service.h.CyF.a(14103, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(34507);
      }
      
      public final void eib()
      {
        AppMethodBeat.i(34508);
        Intent localIntent = new Intent();
        localIntent.putExtra("service_app_talker_user", q.this.getTalkerUserName());
        com.tencent.mm.br.c.a(q.e(q.this).Pwc, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
        AppMethodBeat.o(34508);
      }
      
      public final void eic()
      {
        AppMethodBeat.i(34509);
        Object localObject;
        if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
        {
          localObject = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new LinkedHashMap());
          ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.flutter.a.a.class)).a(q.e(q.this).Pwc.getContext(), (com.tencent.mm.plugin.flutter.a.c)localObject);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(12065, new Object[] { Integer.valueOf(4) });
          AppMethodBeat.o(34509);
          return;
          localObject = new Intent();
          ((Intent)localObject).putExtra("download_entrance_scene", 17);
          ((Intent)localObject).putExtra("preceding_scence", 13);
          com.tencent.mm.br.c.b(q.e(q.this).Pwc.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
        }
      }
      
      public final void eid()
      {
        AppMethodBeat.i(34511);
        com.tencent.mm.plugin.report.service.h.CyF.a(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        q.a(q.this, q.k(q.this) + "_" + System.currentTimeMillis());
        final String str = UUID.randomUUID().toString();
        q.S(2, 0, q.l(q.this));
        final q.b localb = q.gNP();
        Object localObject = q.this.getTalkerUserName();
        final int i;
        if (af.IA((String)localObject))
        {
          com.tencent.mm.kernel.g.aAi();
          i = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.NTk, 0);
        }
        while (q.m(q.this))
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
          if ((i == 1) && (localb.Php))
          {
            localObject = new com.tencent.mm.ui.widget.a.e(q.e(q.this).Pwc.getContext(), 1, false);
            ((com.tencent.mm.ui.widget.a.e)localObject).HLX = new o.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
              {
                AppMethodBeat.i(163290);
                paramAnonymous2m.d(0, q.e(q.this).Pwc.getMMResources().getString(2131757459));
                q.a locala = q.a(localb);
                if (locala != null) {
                  paramAnonymous2m.a(1, locala.title, locala.desc, 0);
                }
                AppMethodBeat.o(163290);
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject).HLY = new o.g()
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
                  com.tencent.mm.plugin.report.service.h.CyF.a(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
                  q.S(4, 0, q.l(q.this));
                  AppMethodBeat.o(163291);
                  return;
                  q.n(q.this);
                }
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject).dGm();
            q.o(q.this);
            q.S(3, 0, q.l(q.this));
            AppMethodBeat.o(34511);
            return;
            com.tencent.mm.kernel.g.aAi();
            i = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.NTi, 0);
          }
          else
          {
            q.b(q.this, str);
            com.tencent.mm.plugin.report.service.h.CyF.a(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
            AppMethodBeat.o(34511);
            return;
          }
        }
        if (((i != 1) || (!localb.Php)) && (q.bmw((String)localObject)))
        {
          q.c(q.this, str);
          com.tencent.mm.plugin.report.service.h.CyF.a(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(q.e(q.this).Pwc.getContext(), 1, false);
        locale.HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
          {
            AppMethodBeat.i(163292);
            paramAnonymous2m.d(0, q.e(q.this).Pwc.getMMResources().getString(2131757459));
            Object localObject;
            if (!q.bmw(this.Phj))
            {
              localObject = new ex();
              ((ex)localObject).eEH = 13L;
              ((ex)localObject).bfK();
              paramAnonymous2m.d(1, q.e(q.this).Pwc.getMMResources().getString(2131757458));
            }
            if ((localb.Php) && (i == 1))
            {
              localObject = q.a(localb);
              if (localObject != null) {
                paramAnonymous2m.a(2, ((q.a)localObject).title, ((q.a)localObject).desc, 0);
              }
            }
            AppMethodBeat.o(163292);
          }
        };
        locale.HLY = new o.g()
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
              com.tencent.mm.plugin.report.service.h.CyF.a(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
              q.S(4, 0, q.l(q.this));
              AppMethodBeat.o(163293);
              return;
              com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
              localIntent.putExtra("key_username", q.this.getTalkerUserName());
              localIntent.putExtra("key_way", 0);
              localIntent.putExtra("pay_channel", 11);
              com.tencent.mm.br.c.b(q.e(q.this).Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", localIntent);
              paramAnonymous2MenuItem = new ex();
              paramAnonymous2MenuItem.eEH = 1L;
              paramAnonymous2MenuItem.bfK();
              q.S(5, 0, q.l(q.this));
              AppMethodBeat.o(163293);
              return;
              q.n(q.this);
            }
          }
        };
        locale.dGm();
        q.o(q.this);
        q.S(3, 0, q.l(q.this));
        AppMethodBeat.o(34511);
      }
      
      public final void eie()
      {
        AppMethodBeat.i(34512);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(81, Boolean.FALSE);
        if (!NetStatusUtil.isNetworkConnected(q.e(q.this).Pwc.getContext()))
        {
          com.tencent.mm.bh.e.a(q.e(q.this).Pwc.getContext(), 2131767334, null);
          AppMethodBeat.o(34512);
          return;
        }
        q.this.gNK();
        AppMethodBeat.o(34512);
      }
      
      public final void eif()
      {
        AppMethodBeat.i(34513);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_scene", 4);
        localIntent.putExtra("enterprise_biz_name", q.this.getTalkerUserName());
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)q.e(q.this).bh(com.tencent.mm.ui.chatting.d.b.d.class)).gPc());
        com.tencent.mm.br.c.b(q.e(q.this).Pwc.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
        AppMethodBeat.o(34513);
      }
      
      public final void eig()
      {
        AppMethodBeat.i(232873);
        ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.gamelife.c.class)).enterSendGift(q.e(q.this).Pwc.getContext(), q.this.getTalkerUserName());
        AppMethodBeat.o(232873);
      }
      
      public final void eih()
      {
        AppMethodBeat.i(34514);
        if (q.m(q.this))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enter_scene", 1);
          localIntent.putExtra("chatroom_name", q.this.getTalkerUserName());
          com.tencent.mm.br.c.b(q.e(q.this).Pwc.getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        }
        AppMethodBeat.o(34514);
      }
      
      public final void eii()
      {
        AppMethodBeat.i(34515);
        com.tencent.mm.plugin.report.service.h.CyF.a(14523, new Object[] { Integer.valueOf(0) });
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Pwc.getContext(), "android.permission.READ_EXTERNAL_STORAGE", 145, q.e(q.this).Pwc.getContext().getString(2131763890), q.e(q.this).Pwc.getContext().getString(2131765207));
        Log.i("MicroMsg.ChattingFooterEventImpl", "checkPermission checkStorage[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).Pwc.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(34515);
          return;
        }
        q.this.gNI();
        AppMethodBeat.o(34515);
      }
      
      public final void eij()
      {
        AppMethodBeat.i(232874);
        if (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt())
        {
          Log.i("MicroMsg.ChattingFooterEventImpl", "exit in teen mode");
          ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(q.e(q.this).Pwc.getContext());
          AppMethodBeat.o(232874);
          return;
        }
        Log.i("MicroMsg.ChattingFooterEventImpl", "gotoRoomLiveEntrance");
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Pwc.getContext(), "android.permission.CAMERA", 25, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).Pwc.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(232874);
          return;
        }
        bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).Pwc.getContext(), "android.permission.RECORD_AUDIO", 25, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).Pwc.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(232874);
          return;
        }
        if ((!com.tencent.mm.q.a.o(q.e(q.this).Pwc.getContext(), true)) && (!com.tencent.mm.q.a.cC(q.e(q.this).Pwc.getContext())) && (!com.tencent.mm.q.a.cA(q.e(q.this).Pwc.getContext())) && (!com.tencent.mm.q.a.cE(q.e(q.this).Pwc.getContext())))
        {
          if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Onj, 0) == 1)
          {
            final Activity localActivity = q.e(q.this).Pwc.getContext();
            com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
            locall.HLX = new o.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
              {
                AppMethodBeat.i(232871);
                paramAnonymous2m.d(0, localActivity.getString(2131762276));
                paramAnonymous2m.d(1, localActivity.getString(2131762275));
                AppMethodBeat.o(232871);
              }
            };
            locall.HLY = new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(232872);
                if (paramAnonymous2Int == 0)
                {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().a(q.e(q.this).Pwc.getContext(), LiveConfig.V(q.e(q.this).getTalkerUserName(), LiveConfig.hvS));
                  AppMethodBeat.o(232872);
                  return;
                }
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(q.e(q.this).Pwc.getContext(), LiveConfig.V(q.e(q.this).getTalkerUserName(), LiveConfig.hvS));
                AppMethodBeat.o(232872);
              }
            };
            locall.gXI();
            AppMethodBeat.o(232874);
            return;
          }
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(q.e(q.this).Pwc.getContext(), LiveConfig.V(q.e(q.this).getTalkerUserName(), LiveConfig.hvS));
        }
        AppMethodBeat.o(232874);
      }
      
      public final void eik()
      {
        AppMethodBeat.i(179848);
        ((com.tencent.mm.ui.chatting.d.b.z)q.e(q.this).bh(com.tencent.mm.ui.chatting.d.b.z.class)).gQg();
        AppMethodBeat.o(179848);
      }
      
      public final void eil()
      {
        AppMethodBeat.i(232875);
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterGroupSolitaire() chatroom:%s", new Object[] { q.e(q.this).getTalkerUserName() });
        Intent localIntent = new Intent();
        localIntent.putExtra("key_group_solitatire_create", true);
        localIntent.putExtra("key_group_solitatire_scene", 5);
        com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
        locala.header = (q.e(q.this).Pwc.getContext().getString(2131761473) + "\n");
        locala.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(locala);
        locala.separator = ".";
        locala.yfG = 1;
        localIntent.putExtra("key_group_solitatire_key", locala.field_key);
        localIntent.putExtra("key_group_solitatire_chatroom_username", q.e(q.this).getTalkerUserName());
        com.tencent.mm.plugin.groupsolitaire.b.b.a(q.e(q.this).getTalkerUserName(), locala);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(q.e(q.this).getTalkerUserName(), locala);
        com.tencent.mm.br.c.b(q.e(q.this).Pwc.getContext(), "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent);
        AppMethodBeat.o(232875);
      }
    };
    this.OIz = parama;
    this.znD = paramChatFooter;
    this.PgT = paramString;
    bg.aVF();
    this.contact = com.tencent.mm.model.c.aSN().Kn(paramString);
    this.PgW = ab.Eq(this.OIz.getTalkerUserName());
    this.PgX = ab.II(this.OIz.getTalkerUserName());
    boolean bool;
    if ((this.PgW) || (this.PgX))
    {
      bool = true;
      this.Pdm = bool;
      this.paT = ((Vibrator)this.OIz.Pwc.getContext().getSystemService("vibrator"));
      if (!ab.Jp(this.PgT)) {
        break label347;
      }
      this.PgS = new com.tencent.mm.plugin.subapp.d.i();
      Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.PgS.a(this.znI);
      this.PgS.a(this.znH);
      paramChatFooter.setAppPanelListener(this.zon);
      this.PgZ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYM, true);
      bg.aVF();
      this.tOw = ((String)com.tencent.mm.model.c.azQ().get(2, null));
      AppMethodBeat.o(34518);
      return;
      bool = false;
      break;
      label347:
      parama = this.PgT;
      int i;
      if (ab.JA(parama)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label532;
        }
        this.PgS = new com.tencent.mm.audio.b.h(this.OIz.Pwc.getContext(), true);
        Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(parama);
        if ((parama != null) && (parama.gBM()))
        {
          paramString = com.tencent.mm.al.g.fJ(parama.field_username);
          if (paramString != null)
          {
            paramString = paramString.cG(false);
            if (paramString != null)
            {
              if (paramString.dhz != null) {
                paramString.dhD = "1".equals(paramString.dhz.optString("CanReceiveSpeexVoice"));
              }
              if (paramString.dhD)
              {
                Log.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + parama.field_username + " canReceiveSpeexVoice");
                i = 1;
                continue;
              }
            }
          }
        }
        i = 0;
      }
      label532:
      this.PgS = new com.tencent.mm.audio.b.h(this.OIz.Pwc.getContext(), false);
      Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
  }
  
  public static void S(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(163296);
    aa localaa = new aa();
    localaa.enl = paramInt1;
    localaa.enn = System.currentTimeMillis();
    localaa.eiB = localaa.x("SessionId", paramString, true);
    localaa.enm = paramInt2;
    localaa.bfK();
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
    String str = LocaleUtil.getApplicationLanguage();
    if ("zh_CN".equals(str))
    {
      paramb = paramb.Phq;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_TW".equals(str))
    {
      paramb = paramb.Phs;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_HK".equals(str))
    {
      paramb = paramb.Phr;
      AppMethodBeat.o(163300);
      return paramb;
    }
    paramb = paramb.Pht;
    AppMethodBeat.o(163300);
    return paramb;
  }
  
  private static void amh(int paramInt)
  {
    AppMethodBeat.i(34541);
    rd localrd = new rd();
    localrd.dXT.state = paramInt;
    EventCenter.instance.publish(localrd);
    AppMethodBeat.o(34541);
  }
  
  public static boolean bmw(String paramString)
  {
    AppMethodBeat.i(232877);
    if (af.IA(paramString)) {
      bg.aVF();
    }
    for (paramString = (Integer)com.tencent.mm.model.c.azQ().get(ar.a.NTj, Integer.valueOf(0));; paramString = (Integer)com.tencent.mm.model.c.azQ().get(ar.a.NTg, Integer.valueOf(0)))
    {
      bg.aVF();
      Integer localInteger = (Integer)com.tencent.mm.model.c.azQ().get(ar.a.NTh, Integer.valueOf(0));
      if (((paramString.intValue() == 1) || (localInteger.intValue() == 1)) && (com.tencent.mm.model.z.aUr())) {
        break;
      }
      AppMethodBeat.o(232877);
      return true;
      bg.aVF();
    }
    AppMethodBeat.o(232877);
    return false;
  }
  
  @Deprecated
  @SuppressLint({"NewApi"})
  private void gNE()
  {
    AppMethodBeat.i(34532);
    this.OIz.BN(true);
    AppMethodBeat.o(34532);
  }
  
  private boolean gNF()
  {
    boolean bool = false;
    int i = 1;
    AppMethodBeat.i(34534);
    this.OIz.Pwc.enableOptionMenu(true);
    this.OIz.Pwc.enableBackMenu(true);
    if (this.PgS != null) {
      if ((this.PgS.isRecording()) && (gNG()))
      {
        bool = this.PgS.Qt();
        this.jxC.stopTimer();
        this.qPy.stopTimer();
        if (i != 0) {
          gNH();
        }
        MMEntryLock.unlock("keep_app_silent");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34534);
      return bool;
      i = 0;
      break;
      Log.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
    }
  }
  
  private boolean gNG()
  {
    AppMethodBeat.i(34538);
    if ((this.contact.field_username.equals("medianote")) && ((com.tencent.mm.model.z.aUc() & 0x4000) == 0))
    {
      AppMethodBeat.o(34538);
      return true;
    }
    AppMethodBeat.o(34538);
    return false;
  }
  
  private void gNH()
  {
    AppMethodBeat.i(34539);
    ca localca = new ca();
    localca.Cy("medianote");
    localca.setType(34);
    localca.nv(1);
    localca.Cz(this.PgU);
    localca.setStatus(2);
    localca.setContent(p.b(com.tencent.mm.model.z.aTY(), this.PgS.aaq(), false));
    localca.setCreateTime(bp.Kw("medianote"));
    if (this.PgS.aat() == 2) {
      localca.BB("SOURCE_SILK_FILE");
    }
    bg.aVF();
    long l = com.tencent.mm.model.c.aSQ().aC(localca);
    if (l <= 0L)
    {
      Log.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
      AppMethodBeat.o(34539);
      return;
    }
    Log.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(l)));
    AppMethodBeat.o(34539);
  }
  
  private static b gNJ()
  {
    AppMethodBeat.i(163298);
    b localb = new b();
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siI, "");
    if (Util.isNullOrNil((String)localObject))
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
        localb.Php = false;
        localb.Phq = p((JSONObject)localObject, "simple_chinese");
        localb.Phr = p((JSONObject)localObject, "xg_traditional_chinese");
        localb.Phs = p((JSONObject)localObject, "tw_traditional_chinese");
        localb.Pht = p((JSONObject)localObject, "english");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(163298);
      return localb;
      localb.Php = true;
    }
  }
  
  private static a p(JSONObject paramJSONObject, String paramString)
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
    this.OIz.setKeepScreenOn(false);
    AppMethodBeat.o(34533);
  }
  
  public final void X(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34531);
    if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
    {
      gNE();
      this.OIz.gNY();
    }
    AppMethodBeat.o(34531);
  }
  
  public final void aBt(String paramString)
  {
    AppMethodBeat.i(34526);
    ((aq)this.OIz.bh(aq.class)).aBt(paramString);
    AppMethodBeat.o(34526);
  }
  
  public final boolean aDN(String paramString)
  {
    AppMethodBeat.i(34525);
    gNE();
    this.OIz.gNY();
    boolean bool = ((aq)this.OIz.bh(aq.class)).bmO(paramString);
    AppMethodBeat.o(34525);
    return bool;
  }
  
  public final boolean aDO(String paramString)
  {
    AppMethodBeat.i(34528);
    if (!Util.isNullOrNil(paramString))
    {
      com.tencent.mm.modelvoice.s.Ri(paramString);
      com.tencent.mm.modelvoice.o.bid().run();
      AppMethodBeat.o(34528);
      return true;
    }
    AppMethodBeat.o(34528);
    return false;
  }
  
  public final long aas()
  {
    AppMethodBeat.i(34522);
    if (this.PgS != null)
    {
      long l = this.PgS.aas();
      AppMethodBeat.o(34522);
      return l;
    }
    AppMethodBeat.o(34522);
    return 0L;
  }
  
  public final void ami(final int paramInt)
  {
    AppMethodBeat.i(34543);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.CAMERA", 18, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.OIz.Pwc.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    Object localObject1;
    if ((CrashReportFactory.hasDebuger()) || (ac.jPA))
    {
      localObject1 = new com.tencent.mm.ui.tools.l(this.OIz.Pwc.getContext());
      ((com.tencent.mm.ui.tools.l)localObject1).HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(169854);
          paramAnonymousm.d(1, q.e(q.this).Pwc.getMMResources().getString(2131755822));
          paramAnonymousm.d(5, "拍摄参数设置面板");
          AppMethodBeat.o(169854);
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).HLY = new o.g()
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
            com.tencent.mm.plugin.report.service.h.CyF.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            paramAnonymousMenuItem = new SightParams(1, paramInt);
            Object localObject = t.Qv(q.this.getTalkerUserName());
            com.tencent.mm.modelvideo.o.bhj();
            String str = t.Qw((String)localObject);
            com.tencent.mm.modelvideo.o.bhj();
            paramAnonymousMenuItem = RecordConfigProvider.a(str, t.Qx((String)localObject), paramAnonymousMenuItem.irT, paramAnonymousMenuItem.irT.duration * 1000, 1);
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYN, false)) {
              paramAnonymousMenuItem.remuxType = 2;
            }
            localObject = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject).sQn = 3;
            if (q.p(q.this)) {
              ((VideoCaptureReportInfo)localObject).sQn = 4;
            }
            paramAnonymousMenuItem.BOE = ((VideoCaptureReportInfo)localObject);
            localObject = new UICustomParam.a();
            ((UICustomParam.a)localObject).apE();
            ((UICustomParam.a)localObject).apD();
            ((UICustomParam.a)localObject).dz(true);
            paramAnonymousMenuItem.BOn = ((UICustomParam.a)localObject).gLU;
            localObject = new CaptureDataManager.c()
            {
              public final void a(Context paramAnonymous2Context, CaptureDataManager.CaptureVideoNormalModel paramAnonymous2CaptureVideoNormalModel, Bundle paramAnonymous2Bundle)
              {
                AppMethodBeat.i(169855);
                paramAnonymous2Bundle = new cly();
                paramAnonymous2Bundle.Mrn = true;
                paramAnonymous2Bundle.Mrm = false;
                String str = com.tencent.mm.vfs.s.bpb(paramAnonymous2CaptureVideoNormalModel.videoPath);
                paramAnonymous2Bundle = new SightCaptureResult(true, paramAnonymous2CaptureVideoNormalModel.videoPath, paramAnonymous2CaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymous2CaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymous2CaptureVideoNormalModel.BOd.longValue() * 1.0F / 1000.0F), paramAnonymous2Bundle);
                if (paramAnonymous2CaptureVideoNormalModel.BOe.booleanValue())
                {
                  paramAnonymous2Bundle.zsy = true;
                  paramAnonymous2Bundle.tkD = false;
                  paramAnonymous2Bundle.zsG = paramAnonymous2CaptureVideoNormalModel.thumbPath;
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
            CaptureDataManager.BOb.BOa = ((CaptureDataManager.b)localObject);
            if (q.q(q.this))
            {
              localObject = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(q.e(q.this).Pwc.getContext(), 226, 2130772161, 2130772162, paramAnonymousMenuItem);
              AppMethodBeat.o(169856);
              return;
            }
            com.tencent.mm.pluginsdk.ui.tools.s.a(q.e(q.this).Pwc, new Intent(), q.this.getTalkerUserName(), paramInt);
            AppMethodBeat.o(169856);
            return;
            com.tencent.mm.br.c.b(q.e(q.this).Pwc.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
          }
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).gXI();
      AppMethodBeat.o(34543);
      return;
    }
    if (!ac.jPB)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new SightParams(1, paramInt);
      Object localObject2 = t.Qv(getTalkerUserName());
      com.tencent.mm.modelvideo.o.bhj();
      String str = t.Qw((String)localObject2);
      com.tencent.mm.modelvideo.o.bhj();
      localObject1 = RecordConfigProvider.a(str, t.Qx((String)localObject2), ((SightParams)localObject1).irT, ((SightParams)localObject1).irT.duration * 1000, 1);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYN, false)) {
        ((RecordConfigProvider)localObject1).remuxType = 2;
      }
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).sQn = 3;
      if (this.Pdm) {
        ((VideoCaptureReportInfo)localObject2).sQn = 4;
      }
      ((RecordConfigProvider)localObject1).BOE = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).apE();
      ((UICustomParam.a)localObject2).apD();
      ((UICustomParam.a)localObject2).dz(true);
      ((RecordConfigProvider)localObject1).BOn = ((UICustomParam.a)localObject2).gLU;
      localObject2 = new CaptureDataManager.c()
      {
        public final void a(Context paramAnonymousContext, CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(169857);
          paramAnonymousBundle = new cly();
          paramAnonymousBundle.Mrn = true;
          paramAnonymousBundle.Mrm = false;
          String str = com.tencent.mm.vfs.s.bpb(paramAnonymousCaptureVideoNormalModel.videoPath);
          paramAnonymousBundle = new SightCaptureResult(true, paramAnonymousCaptureVideoNormalModel.videoPath, paramAnonymousCaptureVideoNormalModel.thumbPath, str, com.tencent.xweb.util.d.getMD5(paramAnonymousCaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymousCaptureVideoNormalModel.BOd.longValue() * 1.0F / 1000.0F), paramAnonymousBundle);
          if (paramAnonymousCaptureVideoNormalModel.BOe.booleanValue())
          {
            paramAnonymousBundle.zsy = true;
            paramAnonymousBundle.tkD = false;
            paramAnonymousBundle.zsG = paramAnonymousCaptureVideoNormalModel.thumbPath;
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
      CaptureDataManager.BOb.BOa = ((CaptureDataManager.b)localObject2);
      if (this.PgZ)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this.OIz.Pwc.getContext(), 226, 2130772161, 2130772162, (RecordConfigProvider)localObject1);
        AppMethodBeat.o(34543);
        return;
      }
      com.tencent.mm.pluginsdk.ui.tools.s.a(this.OIz.Pwc, new Intent(), getTalkerUserName(), paramInt);
    }
    AppMethodBeat.o(34543);
  }
  
  public final void eEK()
  {
    AppMethodBeat.i(34546);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 82, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.OIz.Pwc.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34546);
      return;
    }
    zj localzj = new zj();
    localzj.efx.dKy = 5;
    localzj.efx.talker = getTalkerUserName();
    localzj.efx.context = this.OIz.Pwc.getContext();
    localzj.efx.eft = 4;
    if (this.znD.gqJ()) {
      this.znD.setBottomPanelVisibility(8);
    }
    EventCenter.instance.publish(localzj);
    AppMethodBeat.o(34546);
  }
  
  public final void eEL()
  {
    AppMethodBeat.i(34547);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.CAMERA", 19, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.OIz.Pwc.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 19, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.OIz.Pwc.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    zj localzj = new zj();
    localzj.efx.dKy = 5;
    localzj.efx.talker = getTalkerUserName();
    localzj.efx.context = this.OIz.Pwc.getContext();
    localzj.efx.eft = 2;
    if (this.znD.gqJ()) {
      this.znD.setBottomPanelVisibility(8);
    }
    EventCenter.instance.publish(localzj);
    AppMethodBeat.o(34547);
  }
  
  public final boolean ehI()
  {
    AppMethodBeat.i(34519);
    synchronized (this.lock)
    {
      this.Pha = true;
      if (!this.Phb)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34519);
        return false;
      }
    }
    this.Phb = false;
    releaseWakeLock();
    if (!gNF())
    {
      this.znD.cDd();
      Log.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
      ((aw)this.OIz.bh(aw.class)).gRx().gMP();
      ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).amF(4);
      ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).stopSignalling();
      amh(1);
      ((aw)this.OIz.bh(aw.class)).a(this.OIz.Pwc, false);
      AppMethodBeat.o(34519);
      return true;
    }
    this.znD.setExitType(0);
    ??? = this.znD;
    if (!((ChatFooter)???).Kkf) {
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siK, 1)) {
        break label369;
      }
    }
    label369:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject3 = MMApplicationContext.getContext().getSharedPreferences(ChatFooter.KlG, 0);
        if (((SharedPreferences)localObject3).getInt("trans2txt_edu_key", 0) == 0)
        {
          ((SharedPreferences)localObject3).edit().putInt("trans2txt_edu_key", 1).apply();
          localObject3 = new ca();
          ??? = ((ChatFooter)???).Kjy.getTalkerUserName();
          ((ca)localObject3).setCreateTime(bp.Kw((String)???));
          ((ca)localObject3).Cy((String)???);
          ((ca)localObject3).setContent(MMApplicationContext.getContext().getString(2131767147));
          ((ca)localObject3).setType(10000);
          ((ca)localObject3).setStatus(6);
          ((ca)localObject3).nv(0);
          bg.aVF();
          com.tencent.mm.model.c.aSQ().aC((ca)localObject3);
        }
      }
      this.znD.a(ChatFooter.h.Kmt);
      Log.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
      break;
    }
  }
  
  public final boolean ehJ()
  {
    AppMethodBeat.i(34520);
    Log.v("MicroMsg.ChattingFooterEventImpl", "only stop recording.");
    synchronized (this.lock)
    {
      this.Pha = true;
      if (!this.Phb)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "ever never begin.");
        AppMethodBeat.o(34520);
        return false;
      }
    }
    this.Phb = false;
    releaseWakeLock();
    this.OIz.Pwc.enableOptionMenu(true);
    this.OIz.Pwc.enableBackMenu(true);
    if (this.PgS != null)
    {
      this.PgS.aar();
      this.jxC.stopTimer();
      this.qPy.stopTimer();
    }
    this.znD.a(ChatFooter.h.Kmu);
    ((aw)this.OIz.bh(aw.class)).gRx().gMP();
    ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).amF(4);
    ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).stopSignalling();
    amh(1);
    ((aw)this.OIz.bh(aw.class)).a(this.OIz.Pwc, false);
    AppMethodBeat.o(34520);
    return true;
  }
  
  public final boolean ehL()
  {
    AppMethodBeat.i(34523);
    Log.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.Pha = true;
      if (!this.Phb)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34523);
        return false;
      }
    }
    this.Phb = false;
    releaseWakeLock();
    ehM();
    this.znD.a(ChatFooter.h.Kmw);
    ((aw)this.OIz.bh(aw.class)).gRx().gMP();
    ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).amF(4);
    ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).stopSignalling();
    amh(1);
    ((aw)this.OIz.bh(aw.class)).a(this.OIz.Pwc, false);
    AppMethodBeat.o(34523);
    return true;
  }
  
  public final void ehM()
  {
    AppMethodBeat.i(185863);
    this.OIz.Pwc.enableOptionMenu(true);
    this.OIz.Pwc.enableBackMenu(true);
    if (this.PgS != null)
    {
      this.PgS.cancel();
      this.jxC.stopTimer();
      this.qPy.stopTimer();
    }
    this.znD.a(ChatFooter.h.Kmw);
    AppMethodBeat.o(185863);
  }
  
  public final boolean ehN()
  {
    AppMethodBeat.i(34524);
    if ((com.tencent.mm.q.a.cC(this.OIz.Pwc.getContext())) || (com.tencent.mm.q.a.cA(this.OIz.Pwc.getContext())) || (com.tencent.mm.q.a.cE(this.OIz.Pwc.getContext())))
    {
      Log.d("MicroMsg.ChattingFooterEventImpl", "voip is running, can't record voice");
      AppMethodBeat.o(34524);
      return false;
    }
    ??? = this.OIz.Pwc.getContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)((Context)???).getSystemService("phone");
    if ((2 == localTelephonyManager.getCallState()) || (1 == localTelephonyManager.getCallState())) {
      Toast.makeText((Context)???, ((Context)???).getString(2131756940), 0).show();
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.d("MicroMsg.ChattingFooterEventImpl", "system has calling , can't record voice");
        AppMethodBeat.o(34524);
        return false;
      }
      if (com.tencent.mm.q.a.cB(this.OIz.Pwc.getContext()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        u.g(this.OIz.Pwc.getContext(), this.OIz.Pwc.getContentView());
        Log.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        AppMethodBeat.o(34524);
        return false;
      }
      if (!com.tencent.mm.compatible.e.b.api()) {
        com.tencent.mm.ui.base.h.a(this.OIz.Pwc.getContext(), this.OIz.Pwc.getMMResources().getString(2131755993), this.OIz.Pwc.getMMResources().getString(2131755910), this.OIz.Pwc.getMMResources().getString(2131755912), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34492);
            com.tencent.mm.compatible.e.b.cw(q.e(q.this).Pwc.getContext());
            AppMethodBeat.o(34492);
          }
        });
      }
      synchronized (this.lock)
      {
        this.Pha = false;
      }
      synchronized (this.lock)
      {
        if (this.Pha)
        {
          Log.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
          AppMethodBeat.o(34524);
          return false;
          localObject2 = finally;
          AppMethodBeat.o(34524);
          throw localObject2;
        }
        if (this.OIz.Pwc.getContext().isFinishing())
        {
          AppMethodBeat.o(34524);
          return false;
        }
      }
      if ((Build.VERSION.SDK_INT >= 17) && (this.OIz.Pwc.getContext().isDestroyed()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      this.Phb = true;
      ??? = com.tencent.mm.plugin.transvoice.a.c.Guc;
      com.tencent.mm.plugin.transvoice.a.c.fAu().GtJ = true;
      this.jxC.startTimer(100L);
      this.Phc = false;
      this.qPy.startTimer(200L);
      this.znD.aix(this.OIz.getListView().getHeight());
      ??? = ((aw)this.OIz.bh(aw.class)).gRx();
      ((d)???).ipv = true;
      ((d)???).gMT();
      ((d)???).gMO();
      this.OIz.Pwc.enableOptionMenu(false);
      this.OIz.Pwc.enableBackMenu(false);
      if (this.PgS != null)
      {
        MMEntryLock.lock("keep_app_silent");
        this.znD.setVoiceReactArea(-1);
        this.PgS.hx(getTalkerUserName());
        this.PgU = this.PgS.getFileName();
        this.PgS.a(this.znI);
        this.paT.vibrate(50L);
        this.OIz.cmy();
        gNE();
        this.PgS.a(this.znH);
      }
      for (;;)
      {
        this.OIz.setKeepScreenOn(true);
        ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).amF(3);
        ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).keepSignalling();
        amh(0);
        ((aw)this.OIz.bh(aw.class)).a(this.OIz.Pwc, true);
        AppMethodBeat.o(34524);
        return true;
        Log.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
      }
    }
  }
  
  public final void ehO()
  {
    AppMethodBeat.i(34529);
    gNE();
    this.OIz.gNY();
    AppMethodBeat.o(34529);
  }
  
  public final void ehP()
  {
    AppMethodBeat.i(34530);
    gNE();
    this.OIz.gNY();
    AppMethodBeat.o(34530);
  }
  
  public final void ehQ()
  {
    AppMethodBeat.i(232876);
    gNE();
    this.OIz.gNY();
    AppMethodBeat.o(232876);
  }
  
  public final boolean eu(String paramString, int paramInt)
  {
    AppMethodBeat.i(34527);
    if ((!Util.isNullOrNil(paramString)) && (paramInt > 0) && (com.tencent.mm.modelvoice.s.Ro(paramString) != null))
    {
      com.tencent.mm.modelvoice.s.aB(paramString, paramInt);
      com.tencent.mm.modelvoice.o.bid().run();
      AppMethodBeat.o(34527);
      return true;
    }
    AppMethodBeat.o(34527);
    return false;
  }
  
  public final void gNI()
  {
    AppMethodBeat.i(169859);
    Intent localIntent = new Intent();
    localIntent.setClass(this.OIz.Pwc.getContext(), FileSelectorUI.class);
    localIntent.putExtra("TO_USER", this.PgT);
    this.OIz.a(localIntent, 227, new c.a()
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
  
  public final void gNK()
  {
    AppMethodBeat.i(34542);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.CAMERA", 22, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.OIz.Pwc.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 22, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.OIz.Pwc.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (com.tencent.mm.bi.d.jpA.PZ(getTalkerUserName()))
    {
      Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(MMApplicationContext.getContext(), 2131761779, 0).show();
      AppMethodBeat.o(34542);
      return;
    }
    List localList;
    if (getTalkerUserName() != null)
    {
      localList = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFK(getTalkerUserName());
      bg.aVF();
      String str1 = (String)com.tencent.mm.model.c.azQ().get(2, null);
      bool = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFH(getTalkerUserName());
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
      if ((localList.size() >= com.tencent.mm.plugin.multitalk.d.e.epZ()) && (i == 0))
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131763279, new Object[] { com.tencent.mm.plugin.multitalk.d.e.epZ() }), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).ems())
        {
          Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131763265), 0).show();
          AppMethodBeat.o(34542);
          return;
        }
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).emq())
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131763265), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.q.a.cE(this.OIz.Pwc.getContext()))
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in appbrand voice!");
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.q.a.cB(this.OIz.Pwc.getContext()))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.q.a.p(this.OIz.Pwc.getContext(), true))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (bool)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        com.tencent.mm.ui.base.h.c(this.OIz.Pwc.getContext(), this.OIz.Pwc.getMMResources().getString(2131763314), "", this.OIz.Pwc.getMMResources().getString(2131763248), this.OIz.Pwc.getMMResources().getString(2131763244), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169853);
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFH(q.this.getTalkerUserName()))
            {
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131763307), 0).show();
              AppMethodBeat.o(169853);
              return;
            }
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFN(q.this.getTalkerUserName())) {
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131763258), 0).show();
            }
            AppMethodBeat.o(169853);
          }
        }, null);
        AppMethodBeat.o(34542);
        return;
      }
      localIntent.putExtra("chatroomName", getTalkerUserName());
      localIntent.putExtra("key_need_gallery", true);
      localIntent.putExtra("titile", this.OIz.Pwc.getMMResources().getString(2131763298));
      com.tencent.mm.br.c.b(this.OIz.Pwc.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      if (this.znD.gqJ()) {
        this.znD.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(34542);
      return;
    }
  }
  
  public final void gNL()
  {
    AppMethodBeat.i(34544);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 83, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.OIz.Pwc.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34544);
      return;
    }
    if (this.znD.gqJ()) {
      this.znD.setBottomPanelVisibility(8);
    }
    zj localzj = new zj();
    localzj.efx.dKy = 5;
    localzj.efx.talker = getTalkerUserName();
    localzj.efx.context = this.OIz.Pwc.getContext();
    localzj.efx.eft = 3;
    EventCenter.instance.publish(localzj);
    com.tencent.mm.plugin.report.service.h.CyF.a(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
    AppMethodBeat.o(34544);
  }
  
  public final void gNM()
  {
    AppMethodBeat.i(34545);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.CAMERA", 21, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.OIz.Pwc.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.OIz.Pwc.getContext(), "android.permission.RECORD_AUDIO", 21, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.OIz.Pwc.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    if (this.znD.gqJ()) {
      this.znD.setBottomPanelVisibility(8);
    }
    zj localzj = new zj();
    localzj.efx.dKy = 5;
    localzj.efx.talker = getTalkerUserName();
    localzj.efx.context = this.OIz.Pwc.getContext();
    localzj.efx.eft = 2;
    EventCenter.instance.publish(localzj);
    AppMethodBeat.o(34545);
  }
  
  public final void gNN()
  {
    AppMethodBeat.i(34548);
    ((com.tencent.mm.ui.chatting.d.b.as)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.as.class)).BU(false);
    this.znD.setBottomPanelVisibility(8);
    AppMethodBeat.o(34548);
  }
  
  public final void gNO()
  {
    AppMethodBeat.i(34549);
    if (!com.tencent.mm.pluginsdk.ui.tools.s.a(this.OIz.Pwc, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.OIz.Pwc.getContext(), this.OIz.Pwc.getMMResources().getString(2131765171), 1).show();
    }
    AppMethodBeat.o(34549);
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(34521);
    if (this.PgS != null)
    {
      String str = this.PgS.getFileName();
      AppMethodBeat.o(34521);
      return str;
    }
    AppMethodBeat.o(34521);
    return "";
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(34535);
    if ((this.contact != null) && (com.tencent.mm.storage.as.IG(this.contact.field_username)))
    {
      str = this.PgT;
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
    if (this.PgV != null)
    {
      Log.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.PgV.release();
      this.PgV = null;
    }
    a.a locala = com.tencent.mm.cj.a.Owq;
    if (!a.a.blI(this.PgS.getFileName()))
    {
      locala = com.tencent.mm.cj.a.Owq;
      if (!a.a.blK(this.PgS.getFileName())) {
        gNF();
      }
    }
    this.jxC.stopTimer();
    this.qPy.stopTimer();
    AppMethodBeat.o(34537);
  }
  
  public final void qY(boolean paramBoolean)
  {
    AppMethodBeat.i(34540);
    if (paramBoolean)
    {
      ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).keepSignalling();
      AppMethodBeat.o(34540);
      return;
    }
    ((com.tencent.mm.ui.chatting.d.b.ao)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).stopSignalling();
    AppMethodBeat.o(34540);
  }
  
  public final void release()
  {
    AppMethodBeat.i(34536);
    if (this.PgV != null)
    {
      Log.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.PgV.release();
      this.PgV = null;
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
    boolean Php = false;
    q.a Phq;
    q.a Phr;
    q.a Phs;
    q.a Pht;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q
 * JD-Core Version:    0.7.0.1
 */