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
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.m.a;
import com.tencent.mm.an.m.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.by.c.a;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.cq.a.a;
import com.tencent.mm.f.a.aap;
import com.tencent.mm.f.a.aap.a;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.sd;
import com.tencent.mm.f.b.a.ga;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.vlog.ui.video.EditorVideoCompositionPluginLayout;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.pluginsdk.ui.tools.u;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public final class q
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  public static boolean WAk = true;
  private ChatFooter ESU;
  private final m.a ESY;
  private final m.b ESZ;
  public AppPanel.a ETE;
  public com.tencent.mm.an.m WAl;
  private String WAm;
  private String WAn;
  private ToneGenerator WAo;
  private boolean WAp;
  private boolean WAq;
  public boolean WAr;
  private boolean WAs;
  private volatile boolean WAt;
  private volatile boolean WAu;
  private boolean WAv;
  private com.tencent.mm.ui.chatting.e.a WbU;
  private boolean Wwx;
  private as contact;
  private Object lock;
  private final MTimerHandler mnf;
  private String nYA;
  private Vibrator rqC;
  private final MTimerHandler urE;
  private String xyW;
  
  public q(com.tencent.mm.ui.chatting.e.a parama, ChatFooter paramChatFooter, String paramString)
  {
    AppMethodBeat.i(34518);
    this.WAs = true;
    this.xyW = "";
    this.nYA = "";
    this.ESY = new m.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(34487);
        q.a(q.this).reset();
        q.b(q.this).stopTimer();
        q.c(q.this).stopTimer();
        MMEntryLock.unlock("keep_app_silent");
        q.d(q.this).a(ChatFooter.h.Rnl);
        com.tencent.mm.ui.chatting.d.b.ax localax = (com.tencent.mm.ui.chatting.d.b.ax)q.e(q.this).bC(com.tencent.mm.ui.chatting.d.b.ax.class);
        if ((localax != null) && (localax.hQU() != null)) {
          localax.hQU().hLY();
        }
        Log.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        q.e(q.this).WQv.enableOptionMenu(true);
        q.e(q.this).WQv.enableBackMenu(true);
        Toast.makeText(q.e(q.this).WQv.getContext(), q.e(q.this).WQv.getContext().getString(R.l.ewE), 0).show();
        AppMethodBeat.o(34487);
      }
    };
    this.ESZ = new m.b()
    {
      public final void bic()
      {
        AppMethodBeat.i(34491);
        q.d(q.this).hlq();
        AppMethodBeat.o(34491);
      }
    };
    this.WAt = false;
    this.WAu = false;
    this.lock = new Object();
    this.mnf = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34493);
        q.d(q.this).aqA(q.a(q.this).aeK());
        AppMethodBeat.o(34493);
        return true;
      }
    }, true);
    this.WAv = false;
    this.urE = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34494);
        long l = q.a(q.this).aff();
        Log.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(l)));
        int i = (int)((60000L - l) / 1000L);
        if ((l >= 50000L) && (l <= 60000L) && (!q.f(q.this)))
        {
          Util.lightShake(q.e(q.this).WQv.getContext());
          q.g(q.this);
        }
        q.d(q.this).setVoiceReactArea(i);
        if (l >= 60000L)
        {
          Log.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
          if (!q.d(q.this).hmk())
          {
            q.h(q.this);
            q.d(q.this).a(ChatFooter.h.Rng);
          }
          for (;;)
          {
            PlaySound.play(q.e(q.this).WQv.getContext(), R.l.time_limit);
            AppMethodBeat.o(34494);
            return false;
            q.d(q.this).hlQ();
          }
        }
        AppMethodBeat.o(34494);
        return true;
      }
    }, true);
    this.ETE = new AppPanel.a()
    {
      com.tencent.mm.ui.widget.a.e GWo = null;
      
      public final void Wv(int paramAnonymousInt)
      {
        AppMethodBeat.i(34504);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34504);
          return;
          bh.beI();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            w.g(q.e(q.this).WQv.getContext(), q.e(q.this).WQv.getContentView());
            AppMethodBeat.o(34504);
            return;
          }
          Object localObject = q.e(q.this).WQv.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
          com.tencent.mm.plugin.report.service.g.ada(19);
          if (((String)localObject).equalsIgnoreCase("0")) {
            u.g(q.e(q.this).WQv);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            AppMethodBeat.o(34504);
            return;
            localObject = q.e(q.this).getSelfUserName();
            String str = q.e(q.this).getTalkerUserName();
            Intent localIntent = new Intent();
            if (q.e(q.this).hRi()) {
              localIntent.putExtra("gallery_report_tag", 20);
            }
            for (;;)
            {
              if (as.bvQ(str)) {
                localIntent.putExtra("album_business_tag", "album_business_byp");
              }
              if ((!q.i(q.this)) || (!q.WAk)) {
                break label293;
              }
              u.a(q.e(q.this).WQv, (String)localObject, str, localIntent);
              break;
              localIntent.putExtra("gallery_report_tag", 21);
            }
            label293:
            if (as.OS(str)) {
              u.a(q.e(q.this).WQv, 12, (String)localObject, str, localIntent);
            } else {
              u.a(q.e(q.this).WQv, 3, (String)localObject, str, localIntent);
            }
          }
          localObject = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSX());
          if ((!((com.tencent.mm.vfs.q)localObject).ifE()) && (!((com.tencent.mm.vfs.q)localObject).ifK()))
          {
            Toast.makeText(q.e(q.this).WQv.getContext(), q.e(q.this).WQv.getMMResources().getString(R.l.exi), 1).show();
            AppMethodBeat.o(34504);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).WQv.getContext(), "android.permission.CAMERA", 20, "", "");
          Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).WQv.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34504);
            return;
          }
          q.this.hMX();
        }
      }
      
      public final void Ww(int paramAnonymousInt)
      {
        AppMethodBeat.i(34510);
        if ((!com.tencent.mm.q.a.p(q.e(q.this).WQv.getContext(), true)) && (!com.tencent.mm.q.a.cy(q.e(q.this).WQv.getContext())) && (!com.tencent.mm.q.a.cw(q.e(q.this).WQv.getContext())) && (!com.tencent.mm.q.a.cB(q.e(q.this).WQv.getContext()))) {
          q.this.avj(paramAnonymousInt);
        }
        AppMethodBeat.o(34510);
      }
      
      public final void d(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(34505);
        ((com.tencent.mm.ui.chatting.d.b.b)q.e(q.this).bC(com.tencent.mm.ui.chatting.d.b.b.class)).u(paramAnonymousg);
        AppMethodBeat.o(34505);
      }
      
      public final void eRB()
      {
        AppMethodBeat.i(34499);
        if (com.tencent.mm.q.a.cw(q.e(q.this).WQv.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.q.a.cx(q.e(q.this).WQv.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.q.a.q(q.e(q.this).WQv.getContext(), true))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.q.a.u(q.e(q.this).WQv.getContext(), true))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.q.a.cB(q.e(q.this).WQv.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        aap localaap = new aap();
        EventCenter.instance.publish(localaap);
        if ((q.this.getTalkerUserName() != null) && (!q.this.getTalkerUserName().equals(localaap.fZK.talker)) && ((localaap.fZK.fvo) || (localaap.fZK.fvp)))
        {
          if (localaap.fZK.fZL) {}
          for (int i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
          {
            Toast.makeText(q.e(q.this).WQv.getContext(), i, 0).show();
            Log.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34499);
            return;
          }
        }
        final boolean bool;
        if (1 == com.tencent.mm.n.h.axc().getInt("EnableVoiceVoipFromPlugin", 0))
        {
          if ((!as.bvK(q.e(q.this).NKq.field_username)) && (!ab.PQ(q.e(q.this).NKq.field_username))) {
            break label469;
          }
          if ((((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).ZB(q.e(q.this).NKq.field_openImAppid) & 0x2000) == 0) {
            bool = true;
          }
        }
        for (;;)
        {
          this.GWo = new com.tencent.mm.ui.widget.a.e(q.e(q.this).WQv.getContext(), 1, false);
          this.GWo.ODT = new q.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
            {
              AppMethodBeat.i(34495);
              paramAnonymous2o.aW(2, R.l.app_field_voip, R.k.sharemore_videovoip);
              if (!bool) {
                paramAnonymous2o.aW(1, R.l.app_field_voipaudio, R.k.sharemore_voipvoice);
              }
              AppMethodBeat.o(34495);
            }
          };
          this.GWo.ODU = new q.g()
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
                q.this.fqy();
                AppMethodBeat.o(34496);
                return;
                q.this.fqz();
              }
            }
          };
          this.GWo.eik();
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(34499);
            return;
            bool = false;
            break;
            q.this.hMV();
          }
          label469:
          bool = false;
        }
      }
      
      public final void eRC()
      {
        AppMethodBeat.i(34500);
        if (com.tencent.mm.q.a.cw(q.e(q.this).WQv.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.q.a.cx(q.e(q.this).WQv.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.q.a.cB(q.e(q.this).WQv.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        aap localaap = new aap();
        EventCenter.instance.publish(localaap);
        if ((!q.this.getTalkerUserName().equals(localaap.fZK.talker)) && ((localaap.fZK.fvo) || (localaap.fZK.fvp)))
        {
          if (localaap.fZK.fZL) {}
          for (int i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
          {
            Toast.makeText(q.e(q.this).WQv.getContext(), i, 0).show();
            Log.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34500);
            return;
          }
        }
        q.this.hMU();
        AppMethodBeat.o(34500);
      }
      
      public final void eRD()
      {
        AppMethodBeat.i(34501);
        if ((!com.tencent.mm.q.a.cy(q.e(q.this).WQv.getContext())) && (!com.tencent.mm.q.a.cw(q.e(q.this).WQv.getContext())) && (!com.tencent.mm.q.a.cB(q.e(q.this).WQv.getContext())))
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).WQv.getContext(), "android.permission.RECORD_AUDIO", 81, "", "");
          Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).WQv.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34501);
            return;
          }
          q.this.hMW();
        }
        AppMethodBeat.o(34501);
      }
      
      public final void eRE()
      {
        AppMethodBeat.i(34502);
        ((ad)q.e(q.this).bC(ad.class)).hQf();
        AppMethodBeat.o(34502);
      }
      
      public final void eRF()
      {
        AppMethodBeat.i(34503);
        ((com.tencent.mm.ui.chatting.d.b.e)q.e(q.this).bC(com.tencent.mm.ui.chatting.d.b.e.class)).hOw();
        AppMethodBeat.o(34503);
      }
      
      public final void eRG()
      {
        AppMethodBeat.i(34506);
        com.tencent.mm.by.c.b(q.e(q.this).WQv.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.o(34506);
      }
      
      public final void eRH()
      {
        AppMethodBeat.i(34507);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("3");
        if (com.tencent.mm.ao.g.KI(q.j(q.this).field_username))
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
        com.tencent.mm.plugin.fav.a.b.b(q.e(q.this).WQv.getContext(), ".ui.FavSelectUI", localIntent);
        com.tencent.mm.plugin.report.service.h.IzE.a(14103, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(34507);
      }
      
      public final void eRI()
      {
        AppMethodBeat.i(34508);
        Intent localIntent = new Intent();
        localIntent.putExtra("service_app_talker_user", q.this.getTalkerUserName());
        com.tencent.mm.by.c.a(q.e(q.this).WQv, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
        AppMethodBeat.o(34508);
      }
      
      public final void eRJ()
      {
        AppMethodBeat.i(34509);
        Object localObject;
        if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
        {
          localObject = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new LinkedHashMap());
          ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.flutter.a.a.class)).a(q.e(q.this).WQv.getContext(), (com.tencent.mm.plugin.flutter.a.c)localObject);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(12065, new Object[] { Integer.valueOf(4) });
          AppMethodBeat.o(34509);
          return;
          localObject = new Intent();
          ((Intent)localObject).putExtra("download_entrance_scene", 17);
          ((Intent)localObject).putExtra("preceding_scence", 13);
          com.tencent.mm.by.c.b(q.e(q.this).WQv.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
        }
      }
      
      public final void eRK()
      {
        AppMethodBeat.i(34511);
        com.tencent.mm.plugin.report.service.h.IzE.a(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        q.a(q.this, q.k(q.this) + "_" + System.currentTimeMillis());
        final String str = UUID.randomUUID().toString();
        q.Q(2, 0, q.l(q.this));
        final q.b localb = q.hMY();
        Object localObject = q.this.getTalkerUserName();
        final int i;
        final boolean bool1;
        if (com.tencent.mm.plugin.luckymoney.model.ag.PS((String)localObject))
        {
          com.tencent.mm.kernel.h.aHH();
          i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vhj, 0);
          if ((i != 1) || (!localb.WAQ)) {
            break label444;
          }
          bool1 = true;
          label185:
          if (!q.m(q.this)) {
            break label502;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
          com.tencent.mm.kernel.h.aHH();
          i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vhh, Integer.valueOf(0))).intValue();
          if ((!((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry()) || (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).showPostEntry()) || (((ae)com.tencent.mm.kernel.h.ae(ae.class)).dYT()) || (i != 1)) {
            break label449;
          }
        }
        label444:
        label449:
        for (final boolean bool2 = true;; bool2 = false)
        {
          if ((!bool1) && (!bool2)) {
            break label454;
          }
          localObject = new com.tencent.mm.ui.widget.a.e(q.e(q.this).WQv.getContext(), 1, false);
          ((com.tencent.mm.ui.widget.a.e)localObject).ODT = new q.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
            {
              AppMethodBeat.i(163290);
              paramAnonymous2o.d(0, q.e(q.this).WQv.getMMResources().getString(R.l.ewo));
              if (bool2)
              {
                paramAnonymous2o.a(1, q.e(q.this).WQv.getMMResources().getString(R.l.ewm), q.e(q.this).WQv.getMMResources().getString(R.l.ewl), 0);
                com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
              }
              if (bool1)
              {
                q.a locala = q.a(localb);
                if (locala != null) {
                  paramAnonymous2o.a(2, locala.title, locala.desc, 0);
                }
              }
              AppMethodBeat.o(163290);
            }
          };
          ((com.tencent.mm.ui.widget.a.e)localObject).ODU = new q.g()
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
                com.tencent.mm.plugin.report.service.h.IzE.a(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
                q.Q(4, 0, q.l(q.this));
                AppMethodBeat.o(163291);
                return;
                ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).createLuckyMoneyLive(q.e(q.this).WQv.getContext(), q.this.getTalkerUserName());
                com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()) });
                AppMethodBeat.o(163291);
                return;
                q.n(q.this);
              }
            }
          };
          ((com.tencent.mm.ui.widget.a.e)localObject).eik();
          q.o(q.this);
          q.Q(3, 0, q.l(q.this));
          AppMethodBeat.o(34511);
          return;
          com.tencent.mm.kernel.h.aHH();
          i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vhg, 0);
          break;
          bool1 = false;
          break label185;
        }
        label454:
        q.b(q.this, str);
        com.tencent.mm.plugin.report.service.h.IzE.a(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
        AppMethodBeat.o(34511);
        return;
        label502:
        if (((i != 1) || (!localb.WAQ)) && (q.byX((String)localObject)))
        {
          q.c(q.this, str);
          com.tencent.mm.plugin.report.service.h.IzE.a(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(q.e(q.this).WQv.getContext(), 1, false);
        locale.ODT = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
          {
            AppMethodBeat.i(163292);
            paramAnonymous2o.d(0, q.e(q.this).WQv.getMMResources().getString(R.l.ewo));
            Object localObject;
            if (!q.byX(this.WAJ))
            {
              localObject = new ga();
              ((ga)localObject).gCd = 13L;
              ((ga)localObject).bpa();
              paramAnonymous2o.d(1, q.e(q.this).WQv.getMMResources().getString(R.l.ewn));
            }
            if ((localb.WAQ) && (i == 1))
            {
              localObject = q.a(localb);
              if (localObject != null) {
                paramAnonymous2o.a(2, ((q.a)localObject).title, ((q.a)localObject).desc, 0);
              }
            }
            AppMethodBeat.o(163292);
          }
        };
        locale.ODU = new q.g()
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
              com.tencent.mm.plugin.report.service.h.IzE.a(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
              q.Q(4, 0, q.l(q.this));
              AppMethodBeat.o(163293);
              return;
              com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
              localIntent.putExtra("key_username", q.this.getTalkerUserName());
              localIntent.putExtra("key_way", 0);
              localIntent.putExtra("pay_channel", 11);
              com.tencent.mm.by.c.b(q.e(q.this).WQv.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", localIntent);
              paramAnonymous2MenuItem = new ga();
              paramAnonymous2MenuItem.gCd = 1L;
              paramAnonymous2MenuItem.bpa();
              q.Q(5, 0, q.l(q.this));
              AppMethodBeat.o(163293);
              return;
              q.n(q.this);
            }
          }
        };
        locale.eik();
        q.o(q.this);
        q.Q(3, 0, q.l(q.this));
        AppMethodBeat.o(34511);
      }
      
      public final void eRL()
      {
        AppMethodBeat.i(34512);
        bh.beI();
        com.tencent.mm.model.c.aHp().i(81, Boolean.FALSE);
        if (!NetStatusUtil.isNetworkConnected(q.e(q.this).WQv.getContext()))
        {
          com.tencent.mm.bj.e.a(q.e(q.this).WQv.getContext(), R.l.voip_net_unavailable, null);
          AppMethodBeat.o(34512);
          return;
        }
        q.this.hMT();
        AppMethodBeat.o(34512);
      }
      
      public final void eRM()
      {
        AppMethodBeat.i(34513);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_scene", 4);
        localIntent.putExtra("enterprise_biz_name", q.this.getTalkerUserName());
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)q.e(q.this).bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOs());
        com.tencent.mm.by.c.b(q.e(q.this).WQv.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
        AppMethodBeat.o(34513);
      }
      
      public final void eRN()
      {
        AppMethodBeat.i(201308);
        ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.gamelife.c.class)).enterSendGift(q.e(q.this).WQv.getContext(), q.this.getTalkerUserName());
        AppMethodBeat.o(201308);
      }
      
      public final void eRO()
      {
        AppMethodBeat.i(34514);
        if (q.m(q.this))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enter_scene", 1);
          localIntent.putExtra("chatroom_name", q.this.getTalkerUserName());
          com.tencent.mm.by.c.b(q.e(q.this).WQv.getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        }
        AppMethodBeat.o(34514);
      }
      
      public final void eRP()
      {
        AppMethodBeat.i(34515);
        com.tencent.mm.plugin.report.service.h.IzE.a(14523, new Object[] { Integer.valueOf(0) });
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).WQv.getContext(), "android.permission.READ_EXTERNAL_STORAGE", 145, q.e(q.this).WQv.getContext().getString(R.l.permission_tips_title), q.e(q.this).WQv.getContext().getString(R.l.eSc));
        Log.i("MicroMsg.ChattingFooterEventImpl", "checkPermission checkStorage[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).WQv.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(34515);
          return;
        }
        q.this.hMR();
        AppMethodBeat.o(34515);
      }
      
      public final void eRQ()
      {
        AppMethodBeat.i(201324);
        if (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM())
        {
          Log.i("MicroMsg.ChattingFooterEventImpl", "exit in teen mode");
          ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(q.e(q.this).WQv.getContext());
          AppMethodBeat.o(201324);
          return;
        }
        Log.i("MicroMsg.ChattingFooterEventImpl", "gotoRoomLiveEntrance");
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).WQv.getContext(), "android.permission.CAMERA", 25, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).WQv.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(201324);
          return;
        }
        bool = com.tencent.mm.pluginsdk.permission.b.a(q.e(q.this).WQv.getContext(), "android.permission.RECORD_AUDIO", 25, "", "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), q.e(q.this).WQv.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(201324);
          return;
        }
        if ((!com.tencent.mm.q.a.p(q.e(q.this).WQv.getContext(), true)) && (!com.tencent.mm.q.a.cy(q.e(q.this).WQv.getContext())) && (!com.tencent.mm.q.a.cw(q.e(q.this).WQv.getContext())) && (!com.tencent.mm.q.a.cB(q.e(q.this).WQv.getContext())))
        {
          if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VCv, 0) == 1)
          {
            Activity localActivity = q.e(q.this).WQv.getContext();
            com.tencent.mm.ui.tools.m localm = new com.tencent.mm.ui.tools.m(localActivity);
            localm.ODT = new q.12.7(this, localActivity);
            localm.ODU = new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(278701);
                if (paramAnonymous2Int == 0)
                {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).liveEntranceJumper().a(q.e(q.this).WQv.getContext(), LiveConfig.an(q.e(q.this).getTalkerUserName(), LiveConfig.khV));
                  AppMethodBeat.o(278701);
                  return;
                }
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).liveEntranceJumper().c(q.e(q.this).WQv.getContext(), LiveConfig.an(q.e(q.this).getTalkerUserName(), LiveConfig.khV));
                AppMethodBeat.o(278701);
              }
            };
            localm.hYu();
            AppMethodBeat.o(201324);
            return;
          }
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).liveEntranceJumper().c(q.e(q.this).WQv.getContext(), LiveConfig.an(q.e(q.this).getTalkerUserName(), LiveConfig.khV));
        }
        AppMethodBeat.o(201324);
      }
      
      public final void eRR()
      {
        AppMethodBeat.i(179848);
        ((com.tencent.mm.ui.chatting.d.b.z)q.e(q.this).bC(com.tencent.mm.ui.chatting.d.b.z.class)).hPB();
        AppMethodBeat.o(179848);
      }
      
      public final void eRS()
      {
        AppMethodBeat.i(201327);
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterGroupSolitaire() chatroom:%s", new Object[] { q.e(q.this).getTalkerUserName() });
        Intent localIntent = new Intent();
        localIntent.putExtra("key_group_solitatire_create", true);
        localIntent.putExtra("key_group_solitatire_scene", 5);
        com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
        locala.header = (q.e(q.this).WQv.getContext().getString(R.l.eGl) + "\n");
        locala.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(locala);
        locala.bOX = ".";
        locala.DpI = 1;
        localIntent.putExtra("key_group_solitatire_key", locala.field_key);
        localIntent.putExtra("key_group_solitatire_chatroom_username", q.e(q.this).getTalkerUserName());
        com.tencent.mm.plugin.groupsolitaire.b.b.a(q.e(q.this).getTalkerUserName(), locala);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(q.e(q.this).getTalkerUserName(), locala);
        com.tencent.mm.by.c.b(q.e(q.this).WQv.getContext(), "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent);
        AppMethodBeat.o(201327);
      }
    };
    this.WbU = parama;
    this.ESU = paramChatFooter;
    this.WAm = paramString;
    bh.beI();
    this.contact = com.tencent.mm.model.c.bbL().RG(paramString);
    this.WAp = ab.Lj(this.WbU.getTalkerUserName());
    this.WAq = ab.Qa(this.WbU.getTalkerUserName());
    boolean bool;
    if ((this.WAp) || (this.WAq))
    {
      bool = true;
      this.Wwx = bool;
      this.rqC = ((Vibrator)this.WbU.WQv.getContext().getSystemService("vibrator"));
      if (!ab.QI(this.WAm)) {
        break label347;
      }
      this.WAl = new com.tencent.mm.plugin.subapp.d.i();
      Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.WAl.a(this.ESZ);
      this.WAl.a(this.ESY);
      paramChatFooter.setAppPanelListener(this.ETE);
      this.WAs = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFJ, true);
      bh.beI();
      this.xyW = ((String)com.tencent.mm.model.c.aHp().b(2, null));
      AppMethodBeat.o(34518);
      return;
      bool = false;
      break;
      label347:
      parama = this.WAm;
      int i;
      if (ab.QT(parama)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label532;
        }
        this.WAl = new com.tencent.mm.audio.b.h(this.WbU.WQv.getContext(), true);
        Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        parama = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(parama);
        if ((parama != null) && (parama.hxX()))
        {
          paramString = com.tencent.mm.ao.g.gu(parama.field_username);
          if (paramString != null)
          {
            paramString = paramString.dc(false);
            if (paramString != null)
            {
              if (paramString.eZg != null) {
                paramString.eZk = "1".equals(paramString.eZg.optString("CanReceiveSpeexVoice"));
              }
              if (paramString.eZk)
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
      this.WAl = new com.tencent.mm.audio.b.h(this.WbU.WQv.getContext(), false);
      Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
  }
  
  public static void Q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(163296);
    com.tencent.mm.f.b.a.ag localag = new com.tencent.mm.f.b.a.ag();
    localag.giq = paramInt1;
    localag.gis = System.currentTimeMillis();
    localag.gcU = localag.z("SessionId", paramString, true);
    localag.gir = paramInt2;
    localag.bpa();
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
      paramb = paramb.WAR;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_TW".equals(str))
    {
      paramb = paramb.WAT;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_HK".equals(str))
    {
      paramb = paramb.WAS;
      AppMethodBeat.o(163300);
      return paramb;
    }
    paramb = paramb.WAU;
    AppMethodBeat.o(163300);
    return paramb;
  }
  
  private static void avi(int paramInt)
  {
    AppMethodBeat.i(34541);
    sd localsd = new sd();
    localsd.fRK.state = paramInt;
    EventCenter.instance.publish(localsd);
    AppMethodBeat.o(34541);
  }
  
  public static boolean byX(String paramString)
  {
    AppMethodBeat.i(226804);
    if (com.tencent.mm.plugin.luckymoney.model.ag.PS(paramString)) {
      bh.beI();
    }
    for (paramString = (Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vhi, Integer.valueOf(0));; paramString = (Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vhe, Integer.valueOf(0)))
    {
      bh.beI();
      Integer localInteger = (Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vhf, Integer.valueOf(0));
      if (((paramString.intValue() == 1) || (localInteger.intValue() == 1)) && (com.tencent.mm.model.z.bdt())) {
        break;
      }
      AppMethodBeat.o(226804);
      return true;
      bh.beI();
    }
    AppMethodBeat.o(226804);
    return false;
  }
  
  @Deprecated
  @SuppressLint({"NewApi"})
  private void hMN()
  {
    AppMethodBeat.i(34532);
    this.WbU.Gi(true);
    AppMethodBeat.o(34532);
  }
  
  private boolean hMO()
  {
    boolean bool = false;
    int i = 1;
    AppMethodBeat.i(34534);
    this.WbU.WQv.enableOptionMenu(true);
    this.WbU.WQv.enableBackMenu(true);
    if (this.WAl != null) {
      if ((this.WAl.isRecording()) && (hMP()))
      {
        bool = this.WAl.TV();
        this.mnf.stopTimer();
        this.urE.stopTimer();
        if (i != 0) {
          hMQ();
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
  
  private boolean hMP()
  {
    AppMethodBeat.i(34538);
    if ((this.contact.field_username.equals("medianote")) && ((com.tencent.mm.model.z.bdd() & 0x4000) == 0))
    {
      AppMethodBeat.o(34538);
      return true;
    }
    AppMethodBeat.o(34538);
    return false;
  }
  
  private void hMQ()
  {
    AppMethodBeat.i(34539);
    ca localca = new ca();
    localca.Jm("medianote");
    localca.setType(34);
    localca.pJ(1);
    localca.Jn(this.WAn);
    localca.setStatus(2);
    localca.setContent(p.a(com.tencent.mm.model.z.bcZ(), this.WAl.afc(), false));
    localca.setCreateTime(bq.RP("medianote"));
    if (this.WAl.afg() == 2) {
      localca.Ip("SOURCE_SILK_FILE");
    }
    bh.beI();
    long l = com.tencent.mm.model.c.bbO().aM(localca);
    if (l <= 0L)
    {
      Log.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
      AppMethodBeat.o(34539);
      return;
    }
    Log.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(l)));
    AppMethodBeat.o(34539);
  }
  
  private static b hMS()
  {
    AppMethodBeat.i(163298);
    b localb = new b();
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSG, "");
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
        int i = ((JSONObject)localObject).getInt("weishi_hb_sw");
        Log.i("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() weishi_hb_sw: %s", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          continue;
        }
        localb.WAQ = false;
        localb.WAR = r((JSONObject)localObject, "simple_chinese");
        localb.WAS = r((JSONObject)localObject, "xg_traditional_chinese");
        localb.WAT = r((JSONObject)localObject, "tw_traditional_chinese");
        localb.WAU = r((JSONObject)localObject, "english");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(163298);
      return localb;
      localb.WAQ = true;
    }
  }
  
  private static a r(JSONObject paramJSONObject, String paramString)
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
    this.WbU.setKeepScreenOn(false);
    AppMethodBeat.o(34533);
  }
  
  public final void aLh(String paramString)
  {
    AppMethodBeat.i(34526);
    ((ar)this.WbU.bC(ar.class)).aLh(paramString);
    AppMethodBeat.o(34526);
  }
  
  public final boolean aNX(String paramString)
  {
    AppMethodBeat.i(34525);
    hMN();
    this.WbU.hNh();
    boolean bool = ((ar)this.WbU.bC(ar.class)).bzp(paramString);
    AppMethodBeat.o(34525);
    return bool;
  }
  
  public final boolean aNY(String paramString)
  {
    AppMethodBeat.i(34528);
    if (!Util.isNullOrNil(paramString))
    {
      com.tencent.mm.modelvoice.s.YF(paramString);
      com.tencent.mm.modelvoice.o.brB().run();
      AppMethodBeat.o(34528);
      return true;
    }
    AppMethodBeat.o(34528);
    return false;
  }
  
  public final long aff()
  {
    AppMethodBeat.i(34522);
    if (this.WAl != null)
    {
      long l = this.WAl.aff();
      AppMethodBeat.o(34522);
      return l;
    }
    AppMethodBeat.o(34522);
    return 0L;
  }
  
  public final void ag(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34531);
    if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
    {
      hMN();
      this.WbU.hNh();
    }
    AppMethodBeat.o(34531);
  }
  
  public final void avj(final int paramInt)
  {
    AppMethodBeat.i(34543);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.WbU.WQv.getContext(), "android.permission.CAMERA", 18, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WbU.WQv.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    Object localObject1;
    if ((CrashReportFactory.hasDebuger()) || (ac.mGK))
    {
      localObject1 = new com.tencent.mm.ui.tools.m(this.WbU.WQv.getContext());
      ((com.tencent.mm.ui.tools.m)localObject1).ODT = new q.5(this);
      ((com.tencent.mm.ui.tools.m)localObject1).ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(274669);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(274669);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            paramAnonymousMenuItem = new SightParams(1, paramInt);
            Object localObject = x.XS(q.this.getTalkerUserName());
            com.tencent.mm.modelvideo.s.bqB();
            String str = x.XT((String)localObject);
            com.tencent.mm.modelvideo.s.bqB();
            paramAnonymousMenuItem = RecordConfigProvider.a(str, x.XU((String)localObject), paramAnonymousMenuItem.lgX, paramAnonymousMenuItem.lgX.duration * 1000, 1);
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFK, false)) {
              paramAnonymousMenuItem.remuxType = 2;
            }
            localObject = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject).wwk = 3;
            if (q.q(q.this)) {
              ((VideoCaptureReportInfo)localObject).wwk = 4;
            }
            paramAnonymousMenuItem.HLk = ((VideoCaptureReportInfo)localObject);
            localObject = new UICustomParam.a();
            ((UICustomParam.a)localObject).avX();
            ((UICustomParam.a)localObject).avW();
            ((UICustomParam.a)localObject).dZ(true);
            paramAnonymousMenuItem.HKT = ((UICustomParam.a)localObject).jwj;
            paramAnonymousMenuItem.G(2, EditorVideoCompositionPluginLayout.class.getName());
            localObject = new q.6.1(this);
            CaptureDataManager.HKJ.HKI = ((CaptureDataManager.b)localObject);
            if (q.r(q.this))
            {
              localObject = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(q.e(q.this).WQv.getContext(), 226, R.a.sight_slide_bottom_in, R.a.sight_slide_bottom_out, paramAnonymousMenuItem);
              AppMethodBeat.o(274669);
              return;
            }
            u.a(q.e(q.this).WQv, new Intent(), q.this.getTalkerUserName(), paramInt);
            AppMethodBeat.o(274669);
            return;
            com.tencent.mm.by.c.b(q.e(q.this).WQv.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
          }
        }
      };
      ((com.tencent.mm.ui.tools.m)localObject1).hYu();
      AppMethodBeat.o(34543);
      return;
    }
    if (!ac.mGL)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new SightParams(1, paramInt);
      Object localObject2 = x.XS(getTalkerUserName());
      com.tencent.mm.modelvideo.s.bqB();
      String str = x.XT((String)localObject2);
      com.tencent.mm.modelvideo.s.bqB();
      localObject1 = RecordConfigProvider.a(str, x.XU((String)localObject2), ((SightParams)localObject1).lgX, ((SightParams)localObject1).lgX.duration * 1000, 1);
      localObject2 = com.tencent.mm.plugin.sns.k.b.KfK;
      com.tencent.mm.plugin.sns.k.b.k((RecordConfigProvider)localObject1);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFK, false)) {
        ((RecordConfigProvider)localObject1).remuxType = 2;
      }
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).wwk = 3;
      if (this.Wwx) {
        ((VideoCaptureReportInfo)localObject2).wwk = 4;
      }
      ((RecordConfigProvider)localObject1).HLk = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).avX();
      ((UICustomParam.a)localObject2).avW();
      ((UICustomParam.a)localObject2).dZ(true);
      ((RecordConfigProvider)localObject1).HKT = ((UICustomParam.a)localObject2).jwj;
      localObject2 = new q.7(this);
      CaptureDataManager.HKJ.HKI = ((CaptureDataManager.b)localObject2);
      if (this.WAs)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this.WbU.WQv.getContext(), 226, R.a.sight_slide_bottom_in, R.a.sight_slide_bottom_out, (RecordConfigProvider)localObject1);
        AppMethodBeat.o(34543);
        return;
      }
      u.a(this.WbU.WQv, new Intent(), getTalkerUserName(), paramInt);
    }
    AppMethodBeat.o(34543);
  }
  
  public final boolean eRp()
  {
    AppMethodBeat.i(34519);
    synchronized (this.lock)
    {
      this.WAt = true;
      if (!this.WAu)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34519);
        return false;
      }
    }
    this.WAu = false;
    releaseWakeLock();
    if (!hMO())
    {
      this.ESU.cRI();
      Log.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
      ((com.tencent.mm.ui.chatting.d.b.ax)this.WbU.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).hQU().hLY();
      ((ap)this.WbU.bC(ap.class)).avG(4);
      ((ap)this.WbU.bC(ap.class)).stopSignalling();
      avi(1);
      ((com.tencent.mm.ui.chatting.d.b.ax)this.WbU.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).a(this.WbU.WQv, false);
      AppMethodBeat.o(34519);
      return true;
    }
    this.ESU.setExitType(0);
    ??? = this.ESU;
    if (!((ChatFooter)???).RkS) {
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSJ, 1)) {
        break label369;
      }
    }
    label369:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject3 = MMApplicationContext.getContext().getSharedPreferences(ChatFooter.Rmt, 0);
        if (((SharedPreferences)localObject3).getInt("trans2txt_edu_key", 0) == 0)
        {
          ((SharedPreferences)localObject3).edit().putInt("trans2txt_edu_key", 1).apply();
          localObject3 = new ca();
          ??? = ((ChatFooter)???).Rkl.getTalkerUserName();
          ((ca)localObject3).setCreateTime(bq.RP((String)???));
          ((ca)localObject3).Jm((String)???);
          ((ca)localObject3).setContent(MMApplicationContext.getContext().getString(R.l.eUI));
          ((ca)localObject3).setType(10000);
          ((ca)localObject3).setStatus(6);
          ((ca)localObject3).pJ(0);
          bh.beI();
          com.tencent.mm.model.c.bbO().aM((ca)localObject3);
        }
      }
      this.ESU.a(ChatFooter.h.Rng);
      Log.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
      break;
    }
  }
  
  public final boolean eRq()
  {
    AppMethodBeat.i(34520);
    Log.v("MicroMsg.ChattingFooterEventImpl", "only stop recording.");
    synchronized (this.lock)
    {
      this.WAt = true;
      if (!this.WAu)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "ever never begin.");
        AppMethodBeat.o(34520);
        return false;
      }
    }
    this.WAu = false;
    releaseWakeLock();
    this.WbU.WQv.enableOptionMenu(true);
    this.WbU.WQv.enableBackMenu(true);
    if (this.WAl != null)
    {
      this.WAl.afe();
      this.mnf.stopTimer();
      this.urE.stopTimer();
    }
    this.ESU.a(ChatFooter.h.Rnh);
    ((com.tencent.mm.ui.chatting.d.b.ax)this.WbU.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).hQU().hLY();
    ((ap)this.WbU.bC(ap.class)).avG(4);
    ((ap)this.WbU.bC(ap.class)).stopSignalling();
    avi(1);
    ((com.tencent.mm.ui.chatting.d.b.ax)this.WbU.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).a(this.WbU.WQv, false);
    AppMethodBeat.o(34520);
    return true;
  }
  
  public final boolean eRs()
  {
    AppMethodBeat.i(34523);
    Log.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.WAt = true;
      if (!this.WAu)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34523);
        return false;
      }
    }
    this.WAu = false;
    releaseWakeLock();
    eRt();
    this.ESU.a(ChatFooter.h.Rnj);
    ((com.tencent.mm.ui.chatting.d.b.ax)this.WbU.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).hQU().hLY();
    ((ap)this.WbU.bC(ap.class)).avG(4);
    ((ap)this.WbU.bC(ap.class)).stopSignalling();
    avi(1);
    ((com.tencent.mm.ui.chatting.d.b.ax)this.WbU.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).a(this.WbU.WQv, false);
    AppMethodBeat.o(34523);
    return true;
  }
  
  public final void eRt()
  {
    AppMethodBeat.i(185863);
    this.WbU.WQv.enableOptionMenu(true);
    this.WbU.WQv.enableBackMenu(true);
    if (this.WAl != null)
    {
      this.WAl.cancel();
      this.mnf.stopTimer();
      this.urE.stopTimer();
    }
    this.ESU.a(ChatFooter.h.Rnj);
    AppMethodBeat.o(185863);
  }
  
  public final boolean eRu()
  {
    AppMethodBeat.i(34524);
    if ((com.tencent.mm.q.a.cy(this.WbU.WQv.getContext())) || (com.tencent.mm.q.a.cw(this.WbU.WQv.getContext())) || (com.tencent.mm.q.a.cB(this.WbU.WQv.getContext())))
    {
      Log.d("MicroMsg.ChattingFooterEventImpl", "voip is running, can't record voice");
      AppMethodBeat.o(34524);
      return false;
    }
    ??? = this.WbU.WQv.getContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)((Context)???).getSystemService("phone");
    if ((2 == localTelephonyManager.getCallState()) || (1 == localTelephonyManager.getCallState())) {
      Toast.makeText((Context)???, ((Context)???).getString(c.h.cannot_use_feature_bcz_system_calling_using), 0).show();
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.d("MicroMsg.ChattingFooterEventImpl", "system has calling , can't record voice");
        AppMethodBeat.o(34524);
        return false;
      }
      if (com.tencent.mm.q.a.cx(this.WbU.WQv.getContext()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        w.g(this.WbU.WQv.getContext(), this.WbU.WQv.getContentView());
        Log.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        AppMethodBeat.o(34524);
        return false;
      }
      if (!com.tencent.mm.compatible.e.b.avu()) {
        com.tencent.mm.ui.base.h.a(this.WbU.WQv.getContext(), this.WbU.WQv.getMMResources().getString(R.l.app_special_no_record_audio_permission), this.WbU.WQv.getMMResources().getString(R.l.app_need_audio_title), this.WbU.WQv.getMMResources().getString(R.l.app_need_show_settings_button), true, new q.9(this));
      }
      synchronized (this.lock)
      {
        this.WAt = false;
      }
      synchronized (this.lock)
      {
        if (this.WAt)
        {
          Log.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
          AppMethodBeat.o(34524);
          return false;
          localObject2 = finally;
          AppMethodBeat.o(34524);
          throw localObject2;
        }
        if (this.WbU.WQv.getContext().isFinishing())
        {
          AppMethodBeat.o(34524);
          return false;
        }
      }
      if ((Build.VERSION.SDK_INT >= 17) && (this.WbU.WQv.getContext().isDestroyed()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      this.WAu = true;
      ??? = com.tencent.mm.plugin.transvoice.a.c.Nhv;
      com.tencent.mm.plugin.transvoice.a.c.gsv().Nhc = true;
      this.mnf.startTimer(100L);
      this.WAv = false;
      this.urE.startTimer(200L);
      this.ESU.aqz(this.WbU.getListView().getHeight());
      ??? = ((com.tencent.mm.ui.chatting.d.b.ax)this.WbU.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).hQU();
      ((d)???).leA = true;
      ((d)???).hMc();
      ((d)???).hLX();
      this.WbU.WQv.enableOptionMenu(false);
      this.WbU.WQv.enableBackMenu(false);
      if (this.WAl != null)
      {
        MMEntryLock.lock("keep_app_silent");
        this.ESU.setVoiceReactArea(-1);
        this.WAl.il(getTalkerUserName());
        this.WAn = this.WAl.getFileName();
        this.WAl.a(this.ESZ);
        this.rqC.vibrate(50L);
        this.WbU.cAe();
        hMN();
        this.WAl.a(this.ESY);
      }
      for (;;)
      {
        this.WbU.setKeepScreenOn(true);
        ((ap)this.WbU.bC(ap.class)).avG(3);
        ((ap)this.WbU.bC(ap.class)).keepSignalling();
        avi(0);
        ((com.tencent.mm.ui.chatting.d.b.ax)this.WbU.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).a(this.WbU.WQv, true);
        AppMethodBeat.o(34524);
        return true;
        Log.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
      }
    }
  }
  
  public final void eRv()
  {
    AppMethodBeat.i(34529);
    hMN();
    this.WbU.hNh();
    AppMethodBeat.o(34529);
  }
  
  public final void eRw()
  {
    AppMethodBeat.i(34530);
    hMN();
    this.WbU.hNh();
    AppMethodBeat.o(34530);
  }
  
  public final void eRx()
  {
    AppMethodBeat.i(226787);
    hMN();
    this.WbU.hNh();
    AppMethodBeat.o(226787);
  }
  
  public final boolean eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(34527);
    if ((!Util.isNullOrNil(paramString)) && (paramInt > 0) && (com.tencent.mm.modelvoice.s.YL(paramString) != null))
    {
      com.tencent.mm.modelvoice.s.aU(paramString, paramInt);
      com.tencent.mm.modelvoice.o.brB().run();
      AppMethodBeat.o(34527);
      return true;
    }
    AppMethodBeat.o(34527);
    return false;
  }
  
  public final void fqy()
  {
    AppMethodBeat.i(34546);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.WbU.WQv.getContext(), "android.permission.RECORD_AUDIO", 82, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WbU.WQv.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34546);
      return;
    }
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 5;
    localaaq.fZM.talker = getTalkerUserName();
    localaaq.fZM.context = this.WbU.WQv.getContext();
    localaaq.fZM.fZI = 4;
    if (this.ESU.hlI()) {
      this.ESU.setBottomPanelVisibility(8);
    }
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(34546);
  }
  
  public final void fqz()
  {
    AppMethodBeat.i(34547);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.WbU.WQv.getContext(), "android.permission.CAMERA", 19, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WbU.WQv.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.WbU.WQv.getContext(), "android.permission.RECORD_AUDIO", 19, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WbU.WQv.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 5;
    localaaq.fZM.talker = getTalkerUserName();
    localaaq.fZM.context = this.WbU.WQv.getContext();
    localaaq.fZM.fZI = 2;
    if (this.ESU.hlI()) {
      this.ESU.setBottomPanelVisibility(8);
    }
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(34547);
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(34521);
    if (this.WAl != null)
    {
      String str = this.WAl.getFileName();
      AppMethodBeat.o(34521);
      return str;
    }
    AppMethodBeat.o(34521);
    return "";
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(34535);
    if ((this.contact != null) && (as.PY(this.contact.field_username)))
    {
      str = this.WAm;
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
  
  public final void hMR()
  {
    AppMethodBeat.i(169859);
    Intent localIntent = new Intent();
    localIntent.setClass(this.WbU.WQv.getContext(), FileSelectorUI.class);
    localIntent.putExtra("TO_USER", this.WAm);
    this.WbU.a(localIntent, 227, new c.a()
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
  
  public final void hMT()
  {
    AppMethodBeat.i(34542);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.WbU.WQv.getContext(), "android.permission.CAMERA", 22, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WbU.WQv.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.WbU.WQv.getContext(), "android.permission.RECORD_AUDIO", 22, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WbU.WQv.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (com.tencent.mm.bk.d.meV.Xw(getTalkerUserName()))
    {
      Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(MMApplicationContext.getContext(), R.l.in_share_location_tip, 0).show();
      AppMethodBeat.o(34542);
      return;
    }
    List localList;
    if (getTalkerUserName() != null)
    {
      localList = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPW(getTalkerUserName());
      bh.beI();
      String str1 = (String)com.tencent.mm.model.c.aHp().b(2, null);
      bool = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPT(getTalkerUserName());
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
      if ((localList.size() >= com.tencent.mm.plugin.multitalk.d.e.eZN()) && (i == 0))
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_members_reach_max_limit, new Object[] { com.tencent.mm.plugin.multitalk.d.e.eZN() }), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).eWg())
        {
          Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_exit_tip), 0).show();
          AppMethodBeat.o(34542);
          return;
        }
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).eWe())
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_exit_tip), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.q.a.cB(this.WbU.WQv.getContext()))
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in appbrand voice!");
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.q.a.cx(this.WbU.WQv.getContext()))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.q.a.q(this.WbU.WQv.getContext(), true))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.q.a.u(this.WbU.WQv.getContext(), true))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (bool)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        com.tencent.mm.ui.base.h.c(this.WbU.WQv.getContext(), this.WbU.WQv.getMMResources().getString(R.l.multitalk_talking_chose_enter), "", this.WbU.WQv.getMMResources().getString(R.l.multitalk_enter), this.WbU.WQv.getMMResources().getString(R.l.multitalk_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(290654);
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPT(q.this.getTalkerUserName()))
            {
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_system_master_multi_finish_msg), 0).show();
              AppMethodBeat.o(290654);
              return;
            }
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPZ(q.this.getTalkerUserName())) {
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_error_300), 0).show();
            }
            AppMethodBeat.o(290654);
          }
        }, null);
        AppMethodBeat.o(34542);
        return;
      }
      localIntent.putExtra("chatroomName", getTalkerUserName());
      localIntent.putExtra("key_need_gallery", true);
      localIntent.putExtra("titile", this.WbU.WQv.getMMResources().getString(R.l.multitalk_select_contact));
      com.tencent.mm.by.c.b(this.WbU.WQv.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      if (this.ESU.hlI()) {
        this.ESU.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(34542);
      return;
    }
  }
  
  public final void hMU()
  {
    AppMethodBeat.i(34544);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.WbU.WQv.getContext(), "android.permission.RECORD_AUDIO", 83, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WbU.WQv.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34544);
      return;
    }
    if (this.ESU.hlI()) {
      this.ESU.setBottomPanelVisibility(8);
    }
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 5;
    localaaq.fZM.talker = getTalkerUserName();
    localaaq.fZM.context = this.WbU.WQv.getContext();
    localaaq.fZM.fZI = 3;
    EventCenter.instance.publish(localaaq);
    com.tencent.mm.plugin.report.service.h.IzE.a(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
    AppMethodBeat.o(34544);
  }
  
  public final void hMV()
  {
    AppMethodBeat.i(34545);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.WbU.WQv.getContext(), "android.permission.CAMERA", 21, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WbU.WQv.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.WbU.WQv.getContext(), "android.permission.RECORD_AUDIO", 21, "", "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WbU.WQv.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    if (this.ESU.hlI()) {
      this.ESU.setBottomPanelVisibility(8);
    }
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 5;
    localaaq.fZM.talker = getTalkerUserName();
    localaaq.fZM.context = this.WbU.WQv.getContext();
    localaaq.fZM.fZI = 2;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(34545);
  }
  
  public final void hMW()
  {
    AppMethodBeat.i(34548);
    ((at)this.WbU.bC(at.class)).Gp(false);
    this.ESU.setBottomPanelVisibility(8);
    AppMethodBeat.o(34548);
  }
  
  public final void hMX()
  {
    AppMethodBeat.i(34549);
    if (!u.a(this.WbU.WQv, com.tencent.mm.loader.j.b.aSX(), "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.WbU.WQv.getContext(), this.WbU.WQv.getMMResources().getString(R.l.selectcameraapp_none), 1).show();
    }
    AppMethodBeat.o(34549);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(34537);
    if (this.WAo != null)
    {
      Log.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.WAo.release();
      this.WAo = null;
    }
    a.a locala = com.tencent.mm.cq.a.VPo;
    if (!a.a.byh(this.WAl.getFileName()))
    {
      locala = com.tencent.mm.cq.a.VPo;
      if (!a.a.byj(this.WAl.getFileName())) {
        hMO();
      }
    }
    this.mnf.stopTimer();
    this.urE.stopTimer();
    AppMethodBeat.o(34537);
  }
  
  public final void release()
  {
    AppMethodBeat.i(34536);
    if (this.WAo != null)
    {
      Log.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.WAo.release();
      this.WAo = null;
    }
    AppMethodBeat.o(34536);
  }
  
  public final void ua(boolean paramBoolean)
  {
    AppMethodBeat.i(34540);
    if (paramBoolean)
    {
      ((ap)this.WbU.bC(ap.class)).keepSignalling();
      AppMethodBeat.o(34540);
      return;
    }
    ((ap)this.WbU.bC(ap.class)).stopSignalling();
    AppMethodBeat.o(34540);
  }
  
  public static final class a
  {
    String desc;
    String title;
  }
  
  public static final class b
  {
    boolean WAQ = false;
    q.a WAR;
    q.a WAS;
    q.a WAT;
    q.a WAU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q
 * JD-Core Version:    0.7.0.1
 */