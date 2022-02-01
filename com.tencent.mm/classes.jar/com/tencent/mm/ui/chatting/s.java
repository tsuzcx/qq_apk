package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.R.a;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.l.a;
import com.tencent.mm.am.l.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.a.acm;
import com.tencent.mm.autogen.a.acm.a;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.tt;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.ao;
import com.tencent.mm.autogen.mmdata.rpt.hv;
import com.tencent.mm.cj.a.a;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.luckymoney.model.ah;
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
import com.tencent.mm.plugin.recordvideo.plugin.parent.CameraKitPluginLayout;
import com.tencent.mm.plugin.vlog.ui.video.EditorVideoCompositionPluginLayout;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.component.api.ac;
import com.tencent.mm.ui.chatting.component.api.ag;
import com.tencent.mm.ui.chatting.component.api.ay;
import com.tencent.mm.ui.chatting.component.api.ba;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public final class s
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  public static boolean aehG = true;
  private String AWk;
  private final l.a KNC;
  private final l.b KND;
  private ChatFooter KNy;
  public AppPanel.a KOi;
  private com.tencent.mm.ui.chatting.d.a adHw;
  private boolean aedO;
  public com.tencent.mm.am.l aehH;
  private String aehI;
  private String aehJ;
  private ToneGenerator aehK;
  private boolean aehL;
  private boolean aehM;
  public boolean aehN;
  private boolean aehO;
  private volatile boolean aehP;
  private volatile boolean aehQ;
  private boolean aehR;
  private au contact;
  private Object lock;
  private final MTimerHandler pgR;
  private String qYC;
  private Vibrator uAL;
  private final MTimerHandler xxZ;
  
  public s(com.tencent.mm.ui.chatting.d.a parama, ChatFooter paramChatFooter, String paramString)
  {
    AppMethodBeat.i(34518);
    this.aehO = true;
    this.AWk = "";
    this.qYC = "";
    this.KNC = new l.a()
    {
      public final void atR()
      {
        AppMethodBeat.i(34487);
        s.a(s.this).reset();
        s.b(s.this).stopTimer();
        s.c(s.this).stopTimer();
        MMEntryLock.unlock("keep_app_silent");
        s.d(s.this).a(ChatFooter.h.YjB);
        bf localbf = (bf)s.e(s.this).cm(bf.class);
        if ((localbf != null) && (localbf.jut() != null)) {
          localbf.jut().joA();
        }
        Log.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        s.e(s.this).aezO.enableOptionMenu(true);
        s.e(s.this).aezO.enableBackMenu(true);
        Toast.makeText(s.e(s.this).aezO.getContext(), s.e(s.this).aezO.getContext().getString(R.l.gzh), 0).show();
        AppMethodBeat.o(34487);
      }
    };
    this.KND = new l.b()
    {
      public final void bFK()
      {
        AppMethodBeat.i(34491);
        s.d(s.this).iMh();
        AppMethodBeat.o(34491);
      }
    };
    this.aehP = false;
    this.aehQ = false;
    this.lock = new Object();
    this.pgR = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34493);
        s.d(s.this).awE(s.a(s.this).aGI());
        AppMethodBeat.o(34493);
        return true;
      }
    }, true);
    this.aehR = false;
    this.xxZ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34494);
        long l = s.a(s.this).aHd();
        Log.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(l)));
        int i = (int)((60000L - l) / 1000L);
        if ((l >= 50000L) && (l <= 60000L) && (!s.f(s.this)))
        {
          Util.lightShake(s.e(s.this).aezO.getContext());
          s.g(s.this);
        }
        s.d(s.this).setVoiceReactArea(i);
        if (l >= 60000L)
        {
          Log.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
          if (!s.d(s.this).iNb())
          {
            s.h(s.this);
            s.d(s.this).a(ChatFooter.h.Yjw);
          }
          for (;;)
          {
            PlaySound.play(s.e(s.this).aezO.getContext(), R.l.time_limit);
            AppMethodBeat.o(34494);
            return false;
            s.d(s.this).iMH();
          }
        }
        AppMethodBeat.o(34494);
        return true;
      }
    }, true);
    this.KOi = new AppPanel.a()
    {
      com.tencent.mm.ui.widget.a.f MTX = null;
      
      public final void aar(int paramAnonymousInt)
      {
        AppMethodBeat.i(34504);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34504);
          return;
          bh.bCz();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.aa.j(s.e(s.this).aezO.getContext(), s.e(s.this).aezO.getContentView());
            AppMethodBeat.o(34504);
            return;
          }
          Object localObject = s.e(s.this).aezO.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
          com.tencent.mm.plugin.report.service.g.ahw(19);
          if (((String)localObject).equalsIgnoreCase("0")) {
            t.x(s.e(s.this).aezO);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            AppMethodBeat.o(34504);
            return;
            localObject = s.e(s.this).getSelfUserName();
            String str = s.e(s.this).getTalkerUserName();
            Intent localIntent = new Intent();
            if (s.e(s.this).juG()) {
              localIntent.putExtra("gallery_report_tag", 20);
            }
            for (;;)
            {
              if (au.bwW(str)) {
                localIntent.putExtra("album_business_tag", "album_business_byp");
              }
              if ((!s.i(s.this)) || (!s.aehG)) {
                break label293;
              }
              t.a(s.e(s.this).aezO, (String)localObject, str, localIntent);
              break;
              localIntent.putExtra("gallery_report_tag", 21);
            }
            label293:
            if (au.Hh(str)) {
              t.a(s.e(s.this).aezO, 12, (String)localObject, str, localIntent);
            } else {
              t.a(s.e(s.this).aezO, 3, (String)localObject, str, localIntent);
            }
          }
          localObject = new u(com.tencent.mm.loader.i.b.bmL());
          if ((!((u)localObject).jKS()) && (!((u)localObject).jKY()))
          {
            Toast.makeText(s.e(s.this).aezO.getContext(), s.e(s.this).aezO.getMMResources().getString(R.l.gzM), 1).show();
            AppMethodBeat.o(34504);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(s.e(s.this).aezO.getContext(), "android.permission.CAMERA", 20, "");
          Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), s.e(s.this).aezO.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34504);
            return;
          }
          s.this.jpA();
        }
      }
      
      public final void aas(int paramAnonymousInt)
      {
        AppMethodBeat.i(34510);
        if ((!com.tencent.mm.n.a.p(s.e(s.this).aezO.getContext(), true)) && (!com.tencent.mm.n.a.dm(s.e(s.this).aezO.getContext())) && (!com.tencent.mm.n.a.dl(s.e(s.this).aezO.getContext())) && (!com.tencent.mm.n.a.dp(s.e(s.this).aezO.getContext()))) {
          s.this.aBL(paramAnonymousInt);
        }
        AppMethodBeat.o(34510);
      }
      
      public final void d(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(34505);
        ((com.tencent.mm.ui.chatting.component.api.b)s.e(s.this).cm(com.tencent.mm.ui.chatting.component.api.b.class)).u(paramAnonymousg);
        AppMethodBeat.o(34505);
      }
      
      public final void gaA()
      {
        AppMethodBeat.i(179848);
        ((ac)s.e(s.this).cm(ac.class)).jsx();
        AppMethodBeat.o(179848);
      }
      
      public final void gaB()
      {
        AppMethodBeat.i(254330);
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterGroupSolitaire() chatroom:%s", new Object[] { s.e(s.this).getTalkerUserName() });
        Intent localIntent = new Intent();
        localIntent.putExtra("key_group_solitatire_create", true);
        localIntent.putExtra("key_group_solitatire_scene", 5);
        com.tencent.mm.plugin.groupsolitaire.c.a locala = new com.tencent.mm.plugin.groupsolitaire.c.a();
        locala.header = (s.e(s.this).aezO.getContext().getString(R.l.gJg) + "\n");
        locala.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(locala);
        locala.dIC = ".";
        locala.Jjq = 1;
        localIntent.putExtra("key_group_solitatire_key", locala.field_key);
        localIntent.putExtra("key_group_solitatire_chatroom_username", s.e(s.this).getTalkerUserName());
        com.tencent.mm.plugin.groupsolitaire.b.b.a(s.e(s.this).getTalkerUserName(), locala);
        ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(s.e(s.this).getTalkerUserName(), locala);
        com.tencent.mm.br.c.b(s.e(s.this).aezO.getContext(), "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent);
        AppMethodBeat.o(254330);
      }
      
      public final void gak()
      {
        AppMethodBeat.i(34499);
        if (com.tencent.mm.n.a.dl(s.e(s.this).aezO.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.n.a.c(s.e(s.this).aezO.getContext(), null))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.n.a.q(s.e(s.this).aezO.getContext(), true))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.n.a.v(s.e(s.this).aezO.getContext(), true))
        {
          AppMethodBeat.o(34499);
          return;
        }
        if (com.tencent.mm.n.a.dp(s.e(s.this).aezO.getContext()))
        {
          AppMethodBeat.o(34499);
          return;
        }
        acm localacm = new acm();
        localacm.publish();
        if ((s.this.getTalkerUserName() != null) && (!s.this.getTalkerUserName().equals(localacm.ifS.talker)) && ((localacm.ifS.hzJ) || (localacm.ifS.hzK)))
        {
          if (localacm.ifS.ifT) {}
          for (int i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
          {
            Toast.makeText(s.e(s.this).aezO.getContext(), i, 0).show();
            Log.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34499);
            return;
          }
        }
        final boolean bool;
        if (1 == com.tencent.mm.k.i.aRC().getInt("EnableVoiceVoipFromPlugin", 0))
        {
          if ((!au.bwO(s.e(s.this).Uxa.field_username)) && (!au.bwF(s.e(s.this).Uxa.field_username))) {
            break label468;
          }
          if ((((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).bl(s.e(s.this).Uxa.field_openImAppid, 0) & 0x2000) == 0) {
            bool = true;
          }
        }
        for (;;)
        {
          this.MTX = new com.tencent.mm.ui.widget.a.f(s.e(s.this).aezO.getContext(), 1, false);
          this.MTX.Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
            {
              AppMethodBeat.i(34495);
              paramAnonymous2s.bx(2, R.l.app_field_voip, R.k.sharemore_videovoip);
              if (!bool) {
                paramAnonymous2s.bx(1, R.l.app_field_voipaudio, R.k.sharemore_voipvoice);
              }
              AppMethodBeat.o(34495);
            }
          };
          this.MTX.GAC = new u.i()
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
                s.this.gBT();
                AppMethodBeat.o(34496);
                return;
                s.this.gBU();
              }
            }
          };
          this.MTX.dDn();
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(34499);
            return;
            bool = false;
            break;
            s.this.jpy();
          }
          label468:
          bool = false;
        }
      }
      
      public final void gal()
      {
        AppMethodBeat.i(34500);
        if (com.tencent.mm.n.a.dl(s.e(s.this).aezO.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.n.a.c(s.e(s.this).aezO.getContext(), null))
        {
          AppMethodBeat.o(34500);
          return;
        }
        if (com.tencent.mm.n.a.dp(s.e(s.this).aezO.getContext()))
        {
          AppMethodBeat.o(34500);
          return;
        }
        acm localacm = new acm();
        localacm.publish();
        if ((!s.this.getTalkerUserName().equals(localacm.ifS.talker)) && ((localacm.ifS.hzJ) || (localacm.ifS.hzK)))
        {
          if (localacm.ifS.ifT) {}
          for (int i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
          {
            Toast.makeText(s.e(s.this).aezO.getContext(), i, 0).show();
            Log.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            AppMethodBeat.o(34500);
            return;
          }
        }
        s.this.jpx();
        AppMethodBeat.o(34500);
      }
      
      public final void gam()
      {
        AppMethodBeat.i(34501);
        if ((!com.tencent.mm.n.a.dm(s.e(s.this).aezO.getContext())) && (!com.tencent.mm.n.a.dl(s.e(s.this).aezO.getContext())) && (!com.tencent.mm.n.a.dp(s.e(s.this).aezO.getContext())))
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(s.e(s.this).aezO.getContext(), "android.permission.RECORD_AUDIO", 81, "");
          Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), s.e(s.this).aezO.getContext() });
          if (!bool)
          {
            AppMethodBeat.o(34501);
            return;
          }
          s.this.jpz();
        }
        AppMethodBeat.o(34501);
      }
      
      public final void gan()
      {
        AppMethodBeat.i(34502);
        ((ag)s.e(s.this).cm(ag.class)).jte();
        AppMethodBeat.o(34502);
      }
      
      public final void gao()
      {
        AppMethodBeat.i(34503);
        ((com.tencent.mm.ui.chatting.component.api.f)s.e(s.this).cm(com.tencent.mm.ui.chatting.component.api.f.class)).jro();
        AppMethodBeat.o(34503);
      }
      
      public final void gap()
      {
        AppMethodBeat.i(34506);
        com.tencent.mm.br.c.b(s.e(s.this).aezO.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.o(34506);
      }
      
      public final void gaq()
      {
        AppMethodBeat.i(34507);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("3");
        if (com.tencent.mm.an.g.Dn(s.j(s.this).field_username))
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
        for (;;)
        {
          localIntent.putExtra("key_to_user", s.j(s.this).field_username);
          localIntent.putExtra("key_fav_item_id", TextUtils.join(",", localArrayList));
          com.tencent.mm.plugin.fav.a.b.b(s.e(s.this).aezO.getContext(), ".ui.FavSelectUI", localIntent);
          com.tencent.mm.plugin.report.service.h.OAn.b(14103, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(34507);
          return;
          if (au.bwQ(s.j(s.this).field_username))
          {
            localArrayList.add("5");
            localArrayList.add("7");
            localArrayList.add("14");
            localArrayList.add("18");
            localArrayList.add("4");
            localArrayList.add("9");
            localArrayList.add("10");
            localArrayList.add("11");
            localArrayList.add("12");
            localArrayList.add("15");
            localArrayList.add("13");
            localArrayList.add("16");
            localArrayList.add("17");
            localArrayList.add("19");
            localArrayList.add("20");
          }
        }
      }
      
      public final void gar()
      {
        AppMethodBeat.i(34508);
        Intent localIntent = new Intent();
        localIntent.putExtra("service_app_talker_user", s.this.getTalkerUserName());
        com.tencent.mm.br.c.a(s.e(s.this).aezO, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
        AppMethodBeat.o(34508);
      }
      
      public final void gas()
      {
        AppMethodBeat.i(34509);
        Object localObject;
        if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
        {
          localObject = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new LinkedHashMap());
          ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.a.a.class)).a(s.e(s.this).aezO.getContext(), (com.tencent.mm.plugin.flutter.a.c)localObject);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(12065, new Object[] { Integer.valueOf(4) });
          AppMethodBeat.o(34509);
          return;
          localObject = new Intent();
          ((Intent)localObject).putExtra("download_entrance_scene", 17);
          ((Intent)localObject).putExtra("preceding_scence", 13);
          com.tencent.mm.br.c.b(s.e(s.this).aezO.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
        }
      }
      
      public final void gat()
      {
        AppMethodBeat.i(34511);
        com.tencent.mm.plugin.report.service.h.OAn.b(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        s.a(s.this, s.k(s.this) + "_" + System.currentTimeMillis());
        final String str = UUID.randomUUID().toString();
        s.aa(2, 0, s.l(s.this));
        final s.b localb = s.jpB();
        Object localObject = s.this.getTalkerUserName();
        final int i;
        final boolean bool1;
        if (ah.IH((String)localObject))
        {
          com.tencent.mm.kernel.h.baF();
          i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acID, 0);
          if ((i != 1) || (!localb.aeil)) {
            break label444;
          }
          bool1 = true;
          label185:
          if (!s.m(s.this)) {
            break label502;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
          com.tencent.mm.kernel.h.baF();
          i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIz, Integer.valueOf(0))).intValue();
          if ((!((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry()) || (!((cn)com.tencent.mm.kernel.h.az(cn.class)).showPostEntry()) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) || (i != 1)) {
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
          localObject = new com.tencent.mm.ui.widget.a.f(s.e(s.this).aezO.getContext(), 1, false);
          ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
            {
              AppMethodBeat.i(163290);
              paramAnonymous2s.c(0, s.e(s.this).aezO.getMMResources().getString(R.l.gyO));
              if (bool2)
              {
                paramAnonymous2s.a(1, s.e(s.this).aezO.getMMResources().getString(R.l.gyM), s.e(s.this).aezO.getMMResources().getString(R.l.gyL), 0);
                com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()) });
              }
              if (bool1)
              {
                s.a locala = s.a(localb);
                if (locala != null) {
                  paramAnonymous2s.a(2, locala.title, locala.desc, 0);
                }
              }
              AppMethodBeat.o(163290);
            }
          };
          ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new u.i()
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
                s.b(s.this, str);
                com.tencent.mm.plugin.report.service.h.OAn.b(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
                s.aa(4, 0, s.l(s.this));
                AppMethodBeat.o(163291);
                return;
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).createLuckyMoneyLive(s.e(s.this).aezO.getContext(), s.this.getTalkerUserName());
                com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()) });
                AppMethodBeat.o(163291);
                return;
                s.n(s.this);
              }
            }
          };
          ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
          s.o(s.this);
          s.aa(3, 0, s.l(s.this));
          AppMethodBeat.o(34511);
          return;
          com.tencent.mm.kernel.h.baF();
          i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acIy, 0);
          break;
          bool1 = false;
          break label185;
        }
        label454:
        s.b(s.this, str);
        com.tencent.mm.plugin.report.service.h.OAn.b(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
        AppMethodBeat.o(34511);
        return;
        label502:
        if (((i != 1) || (!localb.aeil)) && (s.bAB((String)localObject)))
        {
          s.c(s.this, str);
          if (ah.fXj()) {
            s.o(s.this);
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(18890, new Object[] { Integer.valueOf(4), Integer.valueOf(0), str });
          AppMethodBeat.o(34511);
          return;
        }
        com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(s.e(s.this).aezO.getContext(), 1, false);
        localf.Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
          {
            AppMethodBeat.i(163292);
            paramAnonymous2s.c(0, s.e(s.this).aezO.getMMResources().getString(R.l.gyO));
            Object localObject;
            if (!s.bAB(this.aeif))
            {
              localObject = new hv();
              ((hv)localObject).iPe = 13L;
              ((hv)localObject).bMH();
              localObject = s.e(s.this).aezO.getMMResources().getString(R.l.gyN);
              if (!ah.fXj()) {
                break label166;
              }
              bh.bCz();
              paramAnonymous2s.c(1, (String)com.tencent.mm.model.c.ban().get(at.a.acIB, localObject));
            }
            for (;;)
            {
              if ((localb.aeil) && (i == 1))
              {
                localObject = s.a(localb);
                if (localObject != null) {
                  paramAnonymous2s.a(2, ((s.a)localObject).title, ((s.a)localObject).desc, 0);
                }
              }
              AppMethodBeat.o(163292);
              return;
              label166:
              paramAnonymous2s.c(1, (CharSequence)localObject);
            }
          }
        };
        localf.GAC = new u.i()
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
              s.c(s.this, str);
              com.tencent.mm.plugin.report.service.h.OAn.b(18890, new Object[] { Integer.valueOf(5), Integer.valueOf(0), str });
              s.aa(4, 0, s.l(s.this));
              AppMethodBeat.o(163293);
              return;
              com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
              localIntent.putExtra("key_username", s.this.getTalkerUserName());
              localIntent.putExtra("key_way", 0);
              localIntent.putExtra("pay_channel", 11);
              if (ah.fXj()) {
                com.tencent.mm.br.c.b(s.e(s.this).aezO.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", localIntent);
              }
              for (;;)
              {
                paramAnonymous2MenuItem = new hv();
                paramAnonymous2MenuItem.iPe = 1L;
                paramAnonymous2MenuItem.bMH();
                s.aa(5, 0, s.l(s.this));
                AppMethodBeat.o(163293);
                return;
                com.tencent.mm.br.c.b(s.e(s.this).aezO.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", localIntent);
              }
              s.n(s.this);
            }
          }
        };
        localf.dDn();
        s.o(s.this);
        s.aa(3, 0, s.l(s.this));
        AppMethodBeat.o(34511);
      }
      
      public final void gau()
      {
        AppMethodBeat.i(34512);
        bh.bCz();
        com.tencent.mm.model.c.ban().B(81, Boolean.FALSE);
        if (!NetStatusUtil.isNetworkConnected(s.e(s.this).aezO.getContext()))
        {
          com.tencent.mm.bc.e.a(s.e(s.this).aezO.getContext(), R.l.voip_net_unavailable, null);
          AppMethodBeat.o(34512);
          return;
        }
        s.this.jpw();
        AppMethodBeat.o(34512);
      }
      
      public final void gav()
      {
        AppMethodBeat.i(34513);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_scene", 4);
        localIntent.putExtra("enterprise_biz_name", s.this.getTalkerUserName());
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.component.api.e)s.e(s.this).cm(com.tencent.mm.ui.chatting.component.api.e.class)).jrk());
        com.tencent.mm.br.c.b(s.e(s.this).aezO.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
        AppMethodBeat.o(34513);
      }
      
      public final void gaw()
      {
        AppMethodBeat.i(254316);
        ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.gamelife.c.class)).enterSendGift(s.e(s.this).aezO.getContext(), s.this.getTalkerUserName());
        AppMethodBeat.o(254316);
      }
      
      public final void gax()
      {
        AppMethodBeat.i(34514);
        if (s.m(s.this))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enter_scene", 1);
          localIntent.putExtra("chatroom_name", s.this.getTalkerUserName());
          com.tencent.mm.br.c.b(s.e(s.this).aezO.getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        }
        AppMethodBeat.o(34514);
      }
      
      public final void gay()
      {
        AppMethodBeat.i(34515);
        com.tencent.mm.plugin.report.service.h.OAn.b(14523, new Object[] { Integer.valueOf(0) });
        Activity localActivity = s.e(s.this).aezO.getContext();
        s.e(s.this).aezO.getContext().getString(R.l.permission_tips_title);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(localActivity, "android.permission.READ_EXTERNAL_STORAGE", 145, s.e(s.this).aezO.getContext().getString(R.l.gUM));
        Log.i("MicroMsg.ChattingFooterEventImpl", "checkPermission checkStorage[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), s.e(s.this).aezO.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(34515);
          return;
        }
        s.this.jpu();
        AppMethodBeat.o(34515);
      }
      
      public final void gaz()
      {
        AppMethodBeat.i(254325);
        if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
        {
          Log.i("MicroMsg.ChattingFooterEventImpl", "exit in teen mode");
          ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(s.e(s.this).aezO.getContext());
          AppMethodBeat.o(254325);
          return;
        }
        Log.i("MicroMsg.ChattingFooterEventImpl", "gotoRoomLiveEntrance");
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(s.e(s.this).aezO.getContext(), "android.permission.CAMERA", 25, "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), s.e(s.this).aezO.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(254325);
          return;
        }
        bool = com.tencent.mm.pluginsdk.permission.b.a(s.e(s.this).aezO.getContext(), "android.permission.RECORD_AUDIO", 25, "");
        Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), s.e(s.this).aezO.getContext() });
        if (!bool)
        {
          AppMethodBeat.o(254325);
          return;
        }
        if ((!com.tencent.mm.n.a.p(s.e(s.this).aezO.getContext(), true)) && (!com.tencent.mm.n.a.dm(s.e(s.this).aezO.getContext())) && (!com.tencent.mm.n.a.dl(s.e(s.this).aezO.getContext())) && (!com.tencent.mm.n.a.dp(s.e(s.this).aezO.getContext())))
        {
          if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adfo, 0) == 1)
          {
            final Activity localActivity = s.e(s.this).aezO.getContext();
            com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActivity);
            locall.Vtg = new u.g()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
              {
                AppMethodBeat.i(254374);
                paramAnonymous2s.c(0, localActivity.getString(R.l.live_debug_entrance));
                paramAnonymous2s.c(1, localActivity.getString(R.l.live_debug_create));
                AppMethodBeat.o(254374);
              }
            };
            locall.GAC = new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(254372);
                if (paramAnonymous2Int == 0)
                {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).liveEntranceJumper().a(s.e(s.this).aezO.getContext(), LiveConfig.aw(s.e(s.this).getTalkerUserName(), LiveConfig.mIr));
                  AppMethodBeat.o(254372);
                  return;
                }
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).liveEntranceJumper().c(s.e(s.this).aezO.getContext(), LiveConfig.aw(s.e(s.this).getTalkerUserName(), LiveConfig.mIr));
                AppMethodBeat.o(254372);
              }
            };
            locall.jDd();
            AppMethodBeat.o(254325);
            return;
          }
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).liveEntranceJumper().c(s.e(s.this).aezO.getContext(), LiveConfig.aw(s.e(s.this).getTalkerUserName(), LiveConfig.mIr));
        }
        AppMethodBeat.o(254325);
      }
    };
    this.adHw = parama;
    this.KNy = paramChatFooter;
    this.aehI = paramString;
    bh.bCz();
    this.contact = com.tencent.mm.model.c.bzA().JE(paramString);
    this.aehL = au.bwE(this.adHw.getTalkerUserName());
    this.aehM = au.bwK(this.adHw.getTalkerUserName());
    boolean bool;
    if ((this.aehL) || (this.aehM))
    {
      bool = true;
      this.aedO = bool;
      this.uAL = ((Vibrator)this.adHw.aezO.getContext().getSystemService("vibrator"));
      if (!au.bwm(this.aehI)) {
        break label347;
      }
      this.aehH = new com.tencent.mm.plugin.subapp.modelvoiceremind.i();
      Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.aehH.a(this.KND);
      this.aehH.a(this.KNC);
      paramChatFooter.setAppPanelListener(this.KOi);
      this.aehO = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVi, true);
      bh.bCz();
      this.AWk = ((String)com.tencent.mm.model.c.ban().d(2, null));
      AppMethodBeat.o(34518);
      return;
      bool = false;
      break;
      label347:
      parama = this.aehI;
      int i;
      if (au.bwx(parama)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label532;
        }
        this.aehH = new com.tencent.mm.audio.b.h(this.adHw.aezO.getContext(), true);
        Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(parama);
        if ((parama != null) && (parama.iZC()))
        {
          paramString = com.tencent.mm.an.g.hU(parama.field_username);
          if (paramString != null)
          {
            paramString = paramString.dO(false);
            if (paramString != null)
            {
              if (paramString.hcG != null) {
                paramString.hcK = "1".equals(paramString.hcG.optString("CanReceiveSpeexVoice"));
              }
              if (paramString.hcK)
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
      this.aehH = new com.tencent.mm.audio.b.h(this.adHw.aezO.getContext(), false);
      Log.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
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
      paramb = paramb.aeim;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_TW".equals(str))
    {
      paramb = paramb.aeio;
      AppMethodBeat.o(163300);
      return paramb;
    }
    if ("zh_HK".equals(str))
    {
      paramb = paramb.aein;
      AppMethodBeat.o(163300);
      return paramb;
    }
    paramb = paramb.aeip;
    AppMethodBeat.o(163300);
    return paramb;
  }
  
  private static void aBK(int paramInt)
  {
    AppMethodBeat.i(34541);
    tt localtt = new tt();
    localtt.hXI.state = paramInt;
    localtt.publish();
    AppMethodBeat.o(34541);
  }
  
  public static void aa(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(163296);
    ao localao = new ao();
    localao.ioV = paramInt1;
    localao.ioX = System.currentTimeMillis();
    localao.ijk = localao.F("SessionId", paramString, true);
    localao.ioW = paramInt2;
    localao.bMH();
    AppMethodBeat.o(163296);
  }
  
  public static boolean bAB(String paramString)
  {
    AppMethodBeat.i(253901);
    int i;
    if (ah.IH(paramString))
    {
      bh.bCz();
      paramString = (Integer)com.tencent.mm.model.c.ban().get(at.a.acIC, Integer.valueOf(0));
      bh.bCz();
      Integer localInteger = (Integer)com.tencent.mm.model.c.ban().get(at.a.acIx, Integer.valueOf(0));
      if ((!com.tencent.mm.model.z.bBl()) && (!ah.fXj())) {
        break label157;
      }
      i = 1;
      label69:
      if ((paramString.intValue() != 1) && (localInteger.intValue() != 1)) {
        break label162;
      }
    }
    label157:
    label162:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (i != 0)) {
        break label167;
      }
      AppMethodBeat.o(253901);
      return true;
      if (ah.fXj())
      {
        bh.bCz();
        paramString = (Integer)com.tencent.mm.model.c.ban().get(at.a.acIA, Integer.valueOf(0));
        break;
      }
      bh.bCz();
      paramString = (Integer)com.tencent.mm.model.c.ban().get(at.a.acIw, Integer.valueOf(0));
      break;
      i = 0;
      break label69;
    }
    label167:
    AppMethodBeat.o(253901);
    return false;
  }
  
  private void jpp()
  {
    AppMethodBeat.i(253875);
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.ChattingFooterEventImpl", "trickyStopFling() called");
    }
    this.adHw.jpL();
    AppMethodBeat.o(253875);
  }
  
  @Deprecated
  private void jpq()
  {
    AppMethodBeat.i(253883);
    this.adHw.r(true, false, false);
    AppMethodBeat.o(253883);
  }
  
  private boolean jpr()
  {
    boolean bool = false;
    int i = 1;
    AppMethodBeat.i(34534);
    this.adHw.aezO.enableOptionMenu(true);
    this.adHw.aezO.enableBackMenu(true);
    if (this.aehH != null) {
      if ((this.aehH.isRecording()) && (jps()))
      {
        bool = this.aehH.stop();
        this.pgR.stopTimer();
        this.xxZ.stopTimer();
        if (i != 0) {
          jpt();
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
  
  private boolean jps()
  {
    AppMethodBeat.i(34538);
    if ((this.contact.field_username.equals("medianote")) && ((com.tencent.mm.model.z.bAQ() & 0x4000) == 0))
    {
      AppMethodBeat.o(34538);
      return true;
    }
    AppMethodBeat.o(34538);
    return false;
  }
  
  private void jpt()
  {
    AppMethodBeat.i(34539);
    cc localcc = new cc();
    localcc.BS("medianote");
    localcc.setType(34);
    localcc.pI(1);
    localcc.BT(this.aehJ);
    localcc.setStatus(2);
    localcc.setContent(p.a(com.tencent.mm.model.z.bAM(), this.aehH.aHa(), false));
    localcc.setCreateTime(br.JN("medianote"));
    if (this.aehH.aHe() == 2) {
      localcc.AU("SOURCE_SILK_FILE");
    }
    bh.bCz();
    long l = com.tencent.mm.model.c.bzD().ba(localcc);
    if (l <= 0L)
    {
      Log.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
      AppMethodBeat.o(34539);
      return;
    }
    Log.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(l)));
    AppMethodBeat.o(34539);
  }
  
  private static b jpv()
  {
    AppMethodBeat.i(163298);
    b localb = new b();
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zlk, "");
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
        localb.aeil = false;
        localb.aeim = s((JSONObject)localObject, "simple_chinese");
        localb.aein = s((JSONObject)localObject, "xg_traditional_chinese");
        localb.aeio = s((JSONObject)localObject, "tw_traditional_chinese");
        localb.aeip = s((JSONObject)localObject, "english");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.ChattingFooterEventImpl", "getWeiShiHbConfig() Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(163298);
      return localb;
      localb.aeil = true;
    }
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(34533);
    this.adHw.setKeepScreenOn(false);
    AppMethodBeat.o(34533);
  }
  
  private static a s(JSONObject paramJSONObject, String paramString)
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
  
  public final void aBL(final int paramInt)
  {
    AppMethodBeat.i(34543);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.adHw.aezO.getContext(), "android.permission.CAMERA", 18, "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.adHw.aezO.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34543);
      return;
    }
    Object localObject1;
    if ((CrashReportFactory.hasDebuger()) || (com.tencent.mm.platformtools.z.pDk))
    {
      localObject1 = new com.tencent.mm.ui.tools.l(this.adHw.aezO.getContext());
      ((com.tencent.mm.ui.tools.l)localObject1).Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(253945);
          paramAnonymouss.c(1, s.e(s.this).aezO.getMMResources().getString(R.l.app_field_mmsight));
          paramAnonymouss.c(5, "拍摄参数设置面板");
          AppMethodBeat.o(253945);
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).GAC = new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(253961);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(253961);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            paramAnonymousMenuItem = new SightParams(1, paramInt);
            Object localObject = com.tencent.mm.modelvideo.aa.PW(s.this.getTalkerUserName());
            v.bOh();
            String str = com.tencent.mm.modelvideo.aa.PX((String)localObject);
            v.bOh();
            paramAnonymousMenuItem = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.aa.PY((String)localObject), paramAnonymousMenuItem.nLH, paramAnonymousMenuItem.nLH.duration * 1000, 1);
            if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVj, false)) {
              paramAnonymousMenuItem.remuxType = 2;
            }
            localObject = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject).ybL = 3;
            if (s.q(s.this)) {
              ((VideoCaptureReportInfo)localObject).ybL = 4;
            }
            paramAnonymousMenuItem.NIi = ((VideoCaptureReportInfo)localObject);
            localObject = new UICustomParam.a();
            ((UICustomParam.a)localObject).aQw();
            ((UICustomParam.a)localObject).aQv();
            ((UICustomParam.a)localObject).eL(true);
            paramAnonymousMenuItem.NHR = ((UICustomParam.a)localObject).lZB;
            paramAnonymousMenuItem.cD(2, EditorVideoCompositionPluginLayout.class.getName());
            paramAnonymousMenuItem.cD(0, CameraKitPluginLayout.class.getName());
            localObject = new CaptureDataManager.c()
            {
              public final void a(Context paramAnonymous2Context, CaptureDataManager.CaptureVideoNormalModel paramAnonymous2CaptureVideoNormalModel, Bundle paramAnonymous2Bundle)
              {
                AppMethodBeat.i(253678);
                paramAnonymous2Bundle = new dmb();
                paramAnonymous2Bundle.aaSg = true;
                paramAnonymous2Bundle.aaSf = false;
                String str = y.bEq(paramAnonymous2CaptureVideoNormalModel.videoPath);
                paramAnonymous2Bundle = new SightCaptureResult(true, paramAnonymous2CaptureVideoNormalModel.videoPath, paramAnonymous2CaptureVideoNormalModel.thumbPath, str, com.tencent.mm.b.g.getMD5(paramAnonymous2CaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymous2CaptureVideoNormalModel.NHJ.longValue() * 1.0F / 1000.0F), paramAnonymous2Bundle);
                if (paramAnonymous2CaptureVideoNormalModel.NHK.booleanValue())
                {
                  paramAnonymous2Bundle.KTL = true;
                  paramAnonymous2Bundle.AnF = false;
                  paramAnonymous2Bundle.KTT = paramAnonymous2CaptureVideoNormalModel.thumbPath;
                }
                paramAnonymous2CaptureVideoNormalModel = new Intent();
                paramAnonymous2CaptureVideoNormalModel.putExtra("key_req_result", paramAnonymous2Bundle);
                ((Activity)paramAnonymous2Context).setResult(-1, paramAnonymous2CaptureVideoNormalModel);
                ((Activity)paramAnonymous2Context).finish();
                AppMethodBeat.o(253678);
              }
              
              public final boolean a(Context paramAnonymous2Context, Bundle paramAnonymous2Bundle, CaptureDataManager.a paramAnonymous2a)
              {
                return false;
              }
            };
            CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)localObject);
            if (s.r(s.this))
            {
              localObject = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(s.e(s.this).aezO.getContext(), 226, R.a.sight_slide_bottom_in, R.a.sight_slide_bottom_out, paramAnonymousMenuItem);
              AppMethodBeat.o(253961);
              return;
            }
            t.a(s.e(s.this).aezO, new Intent(), s.this.getTalkerUserName(), paramInt);
            AppMethodBeat.o(253961);
            return;
            com.tencent.mm.br.c.b(s.e(s.this).aezO.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
          }
        }
      };
      ((com.tencent.mm.ui.tools.l)localObject1).jDd();
      AppMethodBeat.o(34543);
      return;
    }
    if (!com.tencent.mm.platformtools.z.pDl)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new SightParams(1, paramInt);
      Object localObject2 = com.tencent.mm.modelvideo.aa.PW(getTalkerUserName());
      v.bOh();
      String str = com.tencent.mm.modelvideo.aa.PX((String)localObject2);
      v.bOh();
      localObject1 = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.aa.PY((String)localObject2), ((SightParams)localObject1).nLH, ((SightParams)localObject1).nLH.duration * 1000, 1);
      localObject2 = com.tencent.mm.plugin.sns.statistics.b.QDt;
      kotlin.g.b.s.u(localObject1, "provider");
      bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMb, false);
      Log.i("MicroMsg.EditorVideoCompositionConfig", kotlin.g.b.s.X("C2CVideoCompositionSwitch: ", Boolean.valueOf(bool)));
      if (bool) {
        ((RecordConfigProvider)localObject1).cD(2, "com.tencent.mm.plugin.vlog.ui.video.EditorVideoCompositionPluginLayout");
      }
      localObject2 = com.tencent.mm.media.camera.c.ntw;
      if (com.tencent.mm.media.camera.c.bnM())
      {
        bool = true;
        if (bool)
        {
          Log.i("MicroMsg.EditorVideoCompositionConfig", "useCameraKitRecord");
          ((RecordConfigProvider)localObject1).cD(0, CameraKitPluginLayout.class.getName());
        }
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVj, false)) {
          ((RecordConfigProvider)localObject1).remuxType = 2;
        }
        localObject2 = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject2).ybL = 3;
        if (this.aedO) {
          ((VideoCaptureReportInfo)localObject2).ybL = 4;
        }
        ((RecordConfigProvider)localObject1).NIi = ((VideoCaptureReportInfo)localObject2);
        localObject2 = new UICustomParam.a();
        ((UICustomParam.a)localObject2).aQw();
        ((UICustomParam.a)localObject2).aQv();
        ((UICustomParam.a)localObject2).eL(true);
        ((RecordConfigProvider)localObject1).NHR = ((UICustomParam.a)localObject2).lZB;
        localObject2 = new CaptureDataManager.c()
        {
          public final void a(Context paramAnonymousContext, CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(253956);
            paramAnonymousBundle = new dmb();
            paramAnonymousBundle.aaSg = true;
            paramAnonymousBundle.aaSf = false;
            String str = y.bEq(paramAnonymousCaptureVideoNormalModel.videoPath);
            paramAnonymousBundle = new SightCaptureResult(true, paramAnonymousCaptureVideoNormalModel.videoPath, paramAnonymousCaptureVideoNormalModel.thumbPath, str, com.tencent.mm.b.g.getMD5(paramAnonymousCaptureVideoNormalModel.videoPath), Math.round((float)paramAnonymousCaptureVideoNormalModel.NHJ.longValue() * 1.0F / 1000.0F), paramAnonymousBundle);
            if (paramAnonymousCaptureVideoNormalModel.NHK.booleanValue())
            {
              paramAnonymousBundle.KTL = true;
              paramAnonymousBundle.AnF = false;
              paramAnonymousBundle.KTT = paramAnonymousCaptureVideoNormalModel.thumbPath;
            }
            paramAnonymousCaptureVideoNormalModel = new Intent();
            paramAnonymousCaptureVideoNormalModel.putExtra("key_req_result", paramAnonymousBundle);
            ((Activity)paramAnonymousContext).setResult(-1, paramAnonymousCaptureVideoNormalModel);
            ((Activity)paramAnonymousContext).finish();
            AppMethodBeat.o(253956);
          }
          
          public final boolean a(Context paramAnonymousContext, Bundle paramAnonymousBundle, CaptureDataManager.a paramAnonymousa)
          {
            return false;
          }
        };
        CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)localObject2);
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this.adHw.aezO.getContext(), 226, R.a.sight_slide_bottom_in, R.a.sight_slide_bottom_out, (RecordConfigProvider)localObject1);
      }
    }
    else
    {
      AppMethodBeat.o(34543);
      return;
    }
    if ((com.tencent.mm.ui.aw.ato()) || (com.tencent.mm.ui.aw.jkP())) {}
    for (bool = true;; bool = false)
    {
      Log.i("MicroMsg.EditorVideoCompositionConfig", "c2c UIUtils.isFoldableDevice:" + com.tencent.mm.ui.aw.ato() + " UIUtils.inTabletEnv:" + com.tencent.mm.ui.aw.jkP());
      bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTx, bool);
      break;
    }
  }
  
  public final void aHY(String paramString)
  {
    AppMethodBeat.i(34526);
    ((ay)this.adHw.cm(ay.class)).aHY(paramString);
    AppMethodBeat.o(34526);
  }
  
  public final long aHd()
  {
    AppMethodBeat.i(34522);
    if (this.aehH != null)
    {
      long l = this.aehH.aHd();
      AppMethodBeat.o(34522);
      return l;
    }
    AppMethodBeat.o(34522);
    return 0L;
  }
  
  public final boolean aKU(String paramString)
  {
    AppMethodBeat.i(34525);
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.ChattingFooterEventImpl", "onSendTextRequest");
    }
    jpq();
    jpp();
    boolean bool = ((ay)this.adHw.cm(ay.class)).bAS(paramString);
    AppMethodBeat.o(34525);
    return bool;
  }
  
  public final boolean aKV(String paramString)
  {
    AppMethodBeat.i(34528);
    if (!Util.isNullOrNil(paramString))
    {
      com.tencent.mm.modelvoice.s.QK(paramString);
      o.bPh().run();
      AppMethodBeat.o(34528);
      return true;
    }
    AppMethodBeat.o(34528);
    return false;
  }
  
  public final void ah(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34531);
    if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
    {
      this.adHw.r(true, false, false);
      jpp();
    }
    AppMethodBeat.o(34531);
  }
  
  public final boolean fN(String paramString, int paramInt)
  {
    AppMethodBeat.i(34527);
    if ((!Util.isNullOrNil(paramString)) && (paramInt > 0) && (com.tencent.mm.modelvoice.s.QQ(paramString) != null))
    {
      com.tencent.mm.modelvoice.s.bi(paramString, paramInt);
      o.bPh().run();
      AppMethodBeat.o(34527);
      return true;
    }
    AppMethodBeat.o(34527);
    return false;
  }
  
  public final boolean fZY()
  {
    AppMethodBeat.i(34519);
    synchronized (this.lock)
    {
      this.aehP = true;
      if (!this.aehQ)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34519);
        return false;
      }
    }
    this.aehQ = false;
    releaseWakeLock();
    if (!jpr())
    {
      this.KNy.dwb();
      Log.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
      ((bf)this.adHw.cm(bf.class)).jut().joA();
      ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).aCk(4);
      ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).stopSignalling();
      aBK(1);
      ((bf)this.adHw.cm(bf.class)).a(this.adHw.aezO, false);
      AppMethodBeat.o(34519);
      return true;
    }
    this.KNy.setExitType(0);
    ??? = this.KNy;
    if (!((ChatFooter)???).Yhg) {
      if (1 != ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zln, 1)) {
        break label369;
      }
    }
    label369:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject3 = MMApplicationContext.getContext().getSharedPreferences(ChatFooter.YiH, 0);
        if (((SharedPreferences)localObject3).getInt("trans2txt_edu_key", 0) == 0)
        {
          ((SharedPreferences)localObject3).edit().putInt("trans2txt_edu_key", 1).apply();
          localObject3 = new cc();
          ??? = ((ChatFooter)???).Ygv.getTalkerUserName();
          ((cc)localObject3).setCreateTime(br.JN((String)???));
          ((cc)localObject3).BS((String)???);
          ((cc)localObject3).setContent(MMApplicationContext.getContext().getString(R.l.gXJ));
          ((cc)localObject3).setType(10000);
          ((cc)localObject3).setStatus(6);
          ((cc)localObject3).pI(0);
          bh.bCz();
          com.tencent.mm.model.c.bzD().ba((cc)localObject3);
        }
      }
      this.KNy.a(ChatFooter.h.Yjw);
      Log.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
      break;
    }
  }
  
  public final boolean fZZ()
  {
    AppMethodBeat.i(34520);
    Log.v("MicroMsg.ChattingFooterEventImpl", "only stop recording.");
    synchronized (this.lock)
    {
      this.aehP = true;
      if (!this.aehQ)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "ever never begin.");
        AppMethodBeat.o(34520);
        return false;
      }
    }
    this.aehQ = false;
    releaseWakeLock();
    this.adHw.aezO.enableOptionMenu(true);
    this.adHw.aezO.enableBackMenu(true);
    if (this.aehH != null)
    {
      this.aehH.aHc();
      this.pgR.stopTimer();
      this.xxZ.stopTimer();
    }
    this.KNy.a(ChatFooter.h.Yjx);
    ((bf)this.adHw.cm(bf.class)).jut().joA();
    ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).aCk(4);
    ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).stopSignalling();
    aBK(1);
    ((bf)this.adHw.cm(bf.class)).a(this.adHw.aezO, false);
    AppMethodBeat.o(34520);
    return true;
  }
  
  public final void gBT()
  {
    AppMethodBeat.i(34546);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.adHw.aezO.getContext(), "android.permission.RECORD_AUDIO", 82, "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.adHw.aezO.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34546);
      return;
    }
    acn localacn = new acn();
    localacn.ifU.hId = 5;
    localacn.ifU.talker = getTalkerUserName();
    localacn.ifU.context = this.adHw.aezO.getContext();
    localacn.ifU.ifQ = 4;
    if (this.KNy.iMz()) {
      this.KNy.setBottomPanelVisibility(8);
    }
    localacn.publish();
    AppMethodBeat.o(34546);
  }
  
  public final void gBU()
  {
    AppMethodBeat.i(34547);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.adHw.aezO.getContext(), "android.permission.CAMERA", 19, "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.adHw.aezO.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.adHw.aezO.getContext(), "android.permission.RECORD_AUDIO", 19, "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.adHw.aezO.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34547);
      return;
    }
    acn localacn = new acn();
    localacn.ifU.hId = 5;
    localacn.ifU.talker = getTalkerUserName();
    localacn.ifU.context = this.adHw.aezO.getContext();
    localacn.ifU.ifQ = 2;
    if (this.KNy.iMz()) {
      this.KNy.setBottomPanelVisibility(8);
    }
    localacn.publish();
    AppMethodBeat.o(34547);
  }
  
  public final boolean gab()
  {
    AppMethodBeat.i(34523);
    Log.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.aehP = true;
      if (!this.aehQ)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(34523);
        return false;
      }
    }
    this.aehQ = false;
    releaseWakeLock();
    gac();
    this.KNy.a(ChatFooter.h.Yjz);
    ((bf)this.adHw.cm(bf.class)).jut().joA();
    ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).aCk(4);
    ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).stopSignalling();
    aBK(1);
    ((bf)this.adHw.cm(bf.class)).a(this.adHw.aezO, false);
    AppMethodBeat.o(34523);
    return true;
  }
  
  public final void gac()
  {
    AppMethodBeat.i(185863);
    this.adHw.aezO.enableOptionMenu(true);
    this.adHw.aezO.enableBackMenu(true);
    if (this.aehH != null)
    {
      this.aehH.cancel();
      this.pgR.stopTimer();
      this.xxZ.stopTimer();
    }
    this.KNy.a(ChatFooter.h.Yjz);
    AppMethodBeat.o(185863);
  }
  
  public final boolean gad()
  {
    AppMethodBeat.i(34524);
    if ((com.tencent.mm.n.a.dm(this.adHw.aezO.getContext())) || (com.tencent.mm.n.a.dl(this.adHw.aezO.getContext())) || (com.tencent.mm.n.a.dp(this.adHw.aezO.getContext())))
    {
      Log.d("MicroMsg.ChattingFooterEventImpl", "voip is running, can't record voice");
      AppMethodBeat.o(34524);
      return false;
    }
    ??? = this.adHw.aezO.getContext();
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
      if (com.tencent.mm.n.a.c(this.adHw.aezO.getContext(), null))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.aa.j(this.adHw.aezO.getContext(), this.adHw.aezO.getContentView());
        Log.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        AppMethodBeat.o(34524);
        return false;
      }
      if (!com.tencent.mm.compatible.e.b.aPO()) {
        k.a(this.adHw.aezO.getContext(), this.adHw.aezO.getMMResources().getString(R.l.app_special_no_record_audio_permission), this.adHw.aezO.getMMResources().getString(R.l.app_need_audio_title), this.adHw.aezO.getMMResources().getString(R.l.app_need_show_settings_button), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34492);
            com.tencent.mm.compatible.e.b.dg(s.e(s.this).aezO.getContext());
            AppMethodBeat.o(34492);
          }
        });
      }
      synchronized (this.lock)
      {
        this.aehP = false;
      }
      synchronized (this.lock)
      {
        if (this.aehP)
        {
          Log.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
          AppMethodBeat.o(34524);
          return false;
          localObject2 = finally;
          AppMethodBeat.o(34524);
          throw localObject2;
        }
        if (this.adHw.aezO.getContext().isFinishing())
        {
          AppMethodBeat.o(34524);
          return false;
        }
      }
      if ((Build.VERSION.SDK_INT >= 17) && (this.adHw.aezO.getContext().isDestroyed()))
      {
        AppMethodBeat.o(34524);
        return false;
      }
      this.aehQ = true;
      ??? = com.tencent.mm.plugin.transvoice.model.c.TUa;
      com.tencent.mm.plugin.transvoice.model.c.hPD().TUb = true;
      this.pgR.startTimer(100L);
      this.aehR = false;
      this.xxZ.startTimer(200L);
      this.KNy.awD(this.adHw.getListView().getHeight());
      ??? = ((bf)this.adHw.cm(bf.class)).jut();
      ((d)???).nJm = true;
      ((d)???).joD();
      ((d)???).joz();
      this.adHw.aezO.enableOptionMenu(false);
      this.adHw.aezO.enableBackMenu(false);
      if (this.aehH != null)
      {
        MMEntryLock.lock("keep_app_silent");
        this.KNy.setVoiceReactArea(-1);
        this.aehH.jM(getTalkerUserName());
        this.aehJ = this.aehH.getFileName();
        this.aehH.a(this.KND);
        this.uAL.vibrate(50L);
        this.adHw.dcZ();
        jpq();
        this.aehH.a(this.KNC);
      }
      for (;;)
      {
        this.adHw.setKeepScreenOn(true);
        ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).aCk(3);
        ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).keepSignalling();
        aBK(0);
        ((bf)this.adHw.cm(bf.class)).a(this.adHw.aezO, true);
        AppMethodBeat.o(34524);
        return true;
        Log.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
      }
    }
  }
  
  public final void gae()
  {
    AppMethodBeat.i(34529);
    jpq();
    jpp();
    AppMethodBeat.o(34529);
  }
  
  public final void gaf()
  {
    AppMethodBeat.i(34530);
    jpq();
    jpp();
    AppMethodBeat.o(34530);
  }
  
  public final void gag()
  {
    AppMethodBeat.i(254022);
    jpq();
    jpp();
    AppMethodBeat.o(254022);
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(34521);
    if (this.aehH != null)
    {
      String str = this.aehH.getFileName();
      AppMethodBeat.o(34521);
      return str;
    }
    AppMethodBeat.o(34521);
    return "";
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(34535);
    if ((this.contact != null) && (au.bwS(this.contact.field_username)))
    {
      str = this.aehI;
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
  
  public final void jpA()
  {
    AppMethodBeat.i(34549);
    if (!t.a(this.adHw.aezO, com.tencent.mm.loader.i.b.bmL(), "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.adHw.aezO.getContext(), this.adHw.aezO.getMMResources().getString(R.l.selectcameraapp_none), 1).show();
    }
    AppMethodBeat.o(34549);
  }
  
  public final void jpu()
  {
    AppMethodBeat.i(169859);
    Intent localIntent = new Intent();
    localIntent.setClass(this.adHw.aezO.getContext(), FileSelectorUI.class);
    localIntent.putExtra("TO_USER", this.aehI);
    this.adHw.a(localIntent, 227, new com.tencent.mm.br.c.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(169858);
        if (paramAnonymousInt1 == 227) {
          s.a(s.this, s.e(s.this), paramAnonymousInt2, paramAnonymousIntent);
        }
        AppMethodBeat.o(169858);
      }
    });
    AppMethodBeat.o(169859);
  }
  
  public final void jpw()
  {
    AppMethodBeat.i(34542);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.adHw.aezO.getContext(), "android.permission.CAMERA", 22, "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.adHw.aezO.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.adHw.aezO.getContext(), "android.permission.RECORD_AUDIO", 22, "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.adHw.aezO.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34542);
      return;
    }
    Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (com.tencent.mm.bd.d.oXN.Py(getTalkerUserName()))
    {
      Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(MMApplicationContext.getContext(), R.l.in_share_location_tip, 0).show();
      AppMethodBeat.o(34542);
      return;
    }
    List localList;
    if (getTalkerUserName() != null)
    {
      localList = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMR(getTalkerUserName());
      bh.bCz();
      String str1 = (String)com.tencent.mm.model.c.ban().d(2, null);
      bool = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMO(getTalkerUserName());
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
      if ((localList.size() >= com.tencent.mm.plugin.multitalk.e.f.giS()) && (i == 0))
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_members_reach_max_limit, new Object[] { com.tencent.mm.plugin.multitalk.e.f.giS() }), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).geX())
        {
          Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_exit_tip), 0).show();
          AppMethodBeat.o(34542);
          return;
        }
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).geV())
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_exit_tip), 0).show();
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.n.a.dp(this.adHw.aezO.getContext()))
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in appbrand voice!");
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.n.a.c(this.adHw.aezO.getContext(), null))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.n.a.q(this.adHw.aezO.getContext(), true))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (com.tencent.mm.n.a.v(this.adHw.aezO.getContext(), true))
      {
        AppMethodBeat.o(34542);
        return;
      }
      if (bool)
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        k.b(this.adHw.aezO.getContext(), this.adHw.aezO.getMMResources().getString(R.l.multitalk_talking_chose_enter), "", this.adHw.aezO.getMMResources().getString(R.l.multitalk_enter), this.adHw.aezO.getMMResources().getString(R.l.multitalk_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(253951);
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMO(s.this.getTalkerUserName()))
            {
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_system_master_multi_finish_msg), 0).show();
              AppMethodBeat.o(253951);
              return;
            }
            if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMU(s.this.getTalkerUserName())) {
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_error_300), 0).show();
            }
            AppMethodBeat.o(253951);
          }
        }, null);
        AppMethodBeat.o(34542);
        return;
      }
      localIntent.putExtra("chatroomName", getTalkerUserName());
      localIntent.putExtra("key_need_gallery", true);
      localIntent.putExtra("titile", this.adHw.aezO.getMMResources().getString(R.l.multitalk_select_contact));
      com.tencent.mm.br.c.b(this.adHw.aezO.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      if (this.KNy.iMz()) {
        this.KNy.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(34542);
      return;
    }
  }
  
  public final void jpx()
  {
    AppMethodBeat.i(34544);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.adHw.aezO.getContext(), "android.permission.RECORD_AUDIO", 83, "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.adHw.aezO.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34544);
      return;
    }
    if (this.KNy.iMz()) {
      this.KNy.setBottomPanelVisibility(8);
    }
    acn localacn = new acn();
    localacn.ifU.hId = 5;
    localacn.ifU.talker = getTalkerUserName();
    localacn.ifU.context = this.adHw.aezO.getContext();
    localacn.ifU.ifQ = 3;
    localacn.publish();
    com.tencent.mm.plugin.report.service.h.OAn.b(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
    AppMethodBeat.o(34544);
  }
  
  public final void jpy()
  {
    AppMethodBeat.i(34545);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.adHw.aezO.getContext(), "android.permission.CAMERA", 21, "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.adHw.aezO.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.adHw.aezO.getContext(), "android.permission.RECORD_AUDIO", 21, "");
    Log.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.adHw.aezO.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(34545);
      return;
    }
    if (this.KNy.iMz()) {
      this.KNy.setBottomPanelVisibility(8);
    }
    acn localacn = new acn();
    localacn.ifU.hId = 5;
    localacn.ifU.talker = getTalkerUserName();
    localacn.ifU.context = this.adHw.aezO.getContext();
    localacn.ifU.ifQ = 2;
    localacn.publish();
    AppMethodBeat.o(34545);
  }
  
  public final void jpz()
  {
    AppMethodBeat.i(34548);
    ((ba)this.adHw.cm(ba.class)).Mc(false);
    this.KNy.setBottomPanelVisibility(8);
    AppMethodBeat.o(34548);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(34537);
    if (this.aehK != null)
    {
      Log.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.aehK.release();
      this.aehK = null;
    }
    a.a locala = com.tencent.mm.cj.a.adtq;
    if (!a.a.bzC(this.aehH.getFileName()))
    {
      locala = com.tencent.mm.cj.a.adtq;
      if (!a.a.bzE(this.aehH.getFileName())) {
        jpr();
      }
    }
    this.pgR.stopTimer();
    this.xxZ.stopTimer();
    AppMethodBeat.o(34537);
  }
  
  public final void release()
  {
    AppMethodBeat.i(34536);
    if (this.aehK != null)
    {
      Log.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.aehK.release();
      this.aehK = null;
    }
    AppMethodBeat.o(34536);
  }
  
  public final void yp(boolean paramBoolean)
  {
    AppMethodBeat.i(34540);
    if (paramBoolean)
    {
      ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).keepSignalling();
      AppMethodBeat.o(34540);
      return;
    }
    ((com.tencent.mm.ui.chatting.component.api.aw)this.adHw.cm(com.tencent.mm.ui.chatting.component.api.aw.class)).stopSignalling();
    AppMethodBeat.o(34540);
  }
  
  public static final class a
  {
    String desc;
    String title;
  }
  
  public static final class b
  {
    boolean aeil = false;
    s.a aeim;
    s.a aein;
    s.a aeio;
    s.a aeip;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s
 * JD-Core Version:    0.7.0.1
 */