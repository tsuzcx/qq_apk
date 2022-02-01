package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.yb;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.a.c;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.protocal.protobuf.ezo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class VoipCSMainUI
  extends MMActivity
  implements com.tencent.mm.plugin.voip_cs.c.b, com.tencent.mm.plugin.voip_cs.c.b.a.a
{
  private TelephonyManager DOk;
  public CharSequence Ig;
  private com.tencent.mm.network.p MjF;
  private BroadcastReceiver NLh;
  private com.tencent.mm.plugin.voip_cs.c.a.a OjD;
  public String Ojx;
  private com.tencent.mm.plugin.voip_cs.c.a.b Oki;
  private com.tencent.mm.plugin.voip_cs.a.a Okj;
  public String Okk;
  public String Okl;
  public String Okm;
  public boolean Okn;
  public CharSequence Oko;
  private MTimerHandler Okp;
  private String appId;
  private com.tencent.mm.compatible.util.b fmh;
  private MMHandler knk;
  public String nfY;
  PhoneStateListener prS;
  public String scene;
  public String type;
  public String wording;
  
  public VoipCSMainUI()
  {
    AppMethodBeat.i(125458);
    this.Ojx = "";
    this.appId = "";
    this.nfY = "";
    this.Okk = "";
    this.Okl = "";
    this.Okm = "";
    this.scene = "";
    this.type = "";
    this.Okn = false;
    this.wording = MMApplicationContext.getContext().getString(a.e.OhZ);
    this.Oko = MMApplicationContext.getContext().getString(a.e.OhZ);
    this.Ig = MMApplicationContext.getContext().getString(a.e.OhT);
    this.Okp = new MTimerHandler(Looper.getMainLooper(), new VoipCSMainUI.16(this), true);
    this.NLh = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(214133);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          Log.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
          VoipCSMainUI.c(VoipCSMainUI.this).fEs = false;
          AppMethodBeat.o(214133);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          Log.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
          VoipCSMainUI.c(VoipCSMainUI.this).fEs = false;
          if ((!VoipCSMainUI.d(VoipCSMainUI.this).cNL()) && (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw == 2))
          {
            VoipCSMainUI.d(VoipCSMainUI.this).gFg();
            AppMethodBeat.o(214133);
          }
        }
        else if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          Log.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
          VoipCSMainUI.c(VoipCSMainUI.this).fEs = true;
          if (!VoipCSMainUI.d(VoipCSMainUI.this).cNL()) {
            VoipCSMainUI.d(VoipCSMainUI.this).stopRing();
          }
        }
        AppMethodBeat.o(214133);
      }
    };
    this.prS = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(213771);
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
        if (paramAnonymousInt == 2)
        {
          Log.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
          com.tencent.mm.plugin.voip_cs.c.c.gEX().OiQ = 4;
          VoipCSMainUI.this.alU(7);
        }
        AppMethodBeat.o(213771);
      }
    };
    this.MjF = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(214116);
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        com.tencent.mm.plugin.voip_cs.c.a locala;
        if ((com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw == 2) && ((paramAnonymousInt == 4) || (paramAnonymousInt == 6)))
        {
          localObject = com.tencent.mm.plugin.voip_cs.c.c.gEW();
          locala = com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf;
          if (((com.tencent.mm.plugin.voip_cs.c.e)localObject).NMt == 0) {
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject).NMt = locala.NQG;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext());
          if (paramAnonymousInt != ((com.tencent.mm.plugin.voip_cs.c.e)localObject).NMt) {
            Log.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + ((com.tencent.mm.plugin.voip_cs.c.e)localObject).NMt + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locala.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            Log.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locala.DPQ + ", roomkey=" + locala.DPJ + "]");
          }
          ezo localezo = new ezo();
          localezo.UzP = 3;
          localezo.UzQ = new com.tencent.mm.cd.b(arrayOfByte, 0, 1);
          locala.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
          }
        }
        ((com.tencent.mm.plugin.voip_cs.c.e)localObject).NMt = paramAnonymousInt;
        Object localObject = com.tencent.mm.plugin.voip_cs.c.c.gEW();
        Log.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.NQI + "roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.DPJ);
        com.tencent.mm.kernel.h.aGY().a(285, (i)localObject);
        localObject = com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf;
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.d(((v2protocal)localObject).NQI, ((v2protocal)localObject).DPJ);
        com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
        AppMethodBeat.o(214116);
      }
    };
    AppMethodBeat.o(125458);
  }
  
  private void gFs()
  {
    AppMethodBeat.i(125460);
    if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw <= 0)
    {
      this.Oki.gFh();
      this.Oki.gFi();
      com.tencent.mm.plugin.voip_cs.c.c.gEV().init();
      com.tencent.mm.plugin.voip_cs.c.c.gEW().aS(this.Ojx, this.appId, this.Okm);
    }
    if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw < 2) {
      this.OjD.gFg();
    }
    this.Oki.gFl();
    AppMethodBeat.o(125460);
  }
  
  private boolean gFt()
  {
    AppMethodBeat.i(125471);
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", ""))
    {
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
    Log.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (!bool)
    {
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    AppMethodBeat.o(125471);
    return true;
  }
  
  public final void alU(int paramInt)
  {
    AppMethodBeat.i(125468);
    Log.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + paramInt + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw);
    if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw == 0)
    {
      finish();
      AppMethodBeat.o(125468);
      return;
    }
    if (this.Oki != null) {
      this.Oki.alX(paramInt);
    }
    AppMethodBeat.o(125468);
  }
  
  public final void eIM()
  {
    Object localObject2 = null;
    AppMethodBeat.i(125473);
    this.Oki.eIM();
    this.Okj.acR();
    Object localObject1 = this.Okj;
    if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).tQq != null)
    {
      localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).tQq;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((com.tencent.mm.audio.b.c)localObject1).aeU());
        com.tencent.mm.plugin.voip_cs.c.c.gEX().OiV = 1;
        if (!kotlin.g.b.p.h(localObject1, Boolean.TRUE)) {
          break label230;
        }
      }
    }
    com.tencent.mm.plugin.voip_cs.a.a locala;
    label230:
    for (int i = 1;; i = -1)
    {
      com.tencent.mm.plugin.voip_cs.c.c.gEX().Ojo = i;
      locala = this.Okj;
      if (locala.NMO != null) {
        break label235;
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.gEV();
      kotlin.g.b.p.j(localObject1, "SubCoreVoipCS.getVoipCSEngine()");
      ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).Okf.NQX = Math.abs(1);
      this.OjD.stopRing();
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.gEX();
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Ojj != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).OiY = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Ojj);
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.gEX();
      Log.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Ojm == 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Ojm = ((int)(System.currentTimeMillis() / 1000L));
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.gEX();
      Log.d("MicroMsg.VoipCSReportHelper", "markConnect");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Ojl != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Oja = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Ojl);
      }
      AppMethodBeat.o(125473);
      return;
      localObject1 = null;
      break;
    }
    label235:
    com.tencent.mm.plugin.voip.model.c localc = locala.NMO;
    localObject1 = localObject2;
    if (localc != null) {
      localObject1 = Integer.valueOf(localc.gxB());
    }
    localObject2 = locala.NMO;
    if (localObject2 != null) {}
    for (i = ((com.tencent.mm.plugin.voip.model.c)localObject2).gxB();; i = 0)
    {
      if (i <= 0)
      {
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.gEV();
        kotlin.g.b.p.j(localObject2, "SubCoreVoipCS.getVoipCSEngine()");
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject2).Okf.NQX = Math.abs(1);
      }
      if (localObject1 == null) {
        break;
      }
      ((Integer)localObject1).intValue();
      break;
    }
  }
  
  public final void gFr()
  {
    AppMethodBeat.i(125474);
    Log.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
    this.Oki.alX(5);
    AppMethodBeat.o(125474);
  }
  
  public int getLayoutId()
  {
    return a.c.OhF;
  }
  
  public final void kv(int paramInt)
  {
    AppMethodBeat.i(125469);
    if (this.Oki != null)
    {
      Log.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(paramInt)));
      this.Oki.alX(paramInt);
    }
    AppMethodBeat.o(125469);
  }
  
  public final void lK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125470);
    com.tencent.mm.plugin.voip_cs.c.a.b localb = this.Oki;
    if ((localb.OjW.equals("")) && (Util.isNullOrNil(paramString2))) {
      if (localb.OjE.Okn) {
        localb.iZH.setText(a.e.OhJ);
      }
    }
    while ((localb.OjV.equals("")) && (Util.isNullOrNil(paramString1)) && ((localb.OjE.nfY == null) || (localb.OjE.nfY.equals(""))))
    {
      localb.OjK.setImageResource(com.tencent.mm.plugin.voip_cs.a.a.default_avatar);
      AppMethodBeat.o(125470);
      return;
      localb.iZH.setText(a.e.OhI);
      continue;
      localb.setNickName(paramString2);
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if ((!Util.isNullOrNil(paramString1)) && (!localb.OjV.equals(paramString1)))
    {
      localb.bgm(paramString1);
      localSharedPreferences.edit().putString(localb.gFj(), paramString1).commit();
    }
    if ((!Util.isNullOrNil(paramString2)) && (!localb.OjW.equals(paramString2)))
    {
      localb.setNickName(paramString2);
      localSharedPreferences.edit().putString(localb.gFk(), paramString2).commit();
    }
    AppMethodBeat.o(125470);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125459);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
    super.onCreate(paramBundle);
    hideTitleView();
    this.Ojx = getIntent().getStringExtra("voipCSBizId");
    this.appId = getIntent().getStringExtra("voipCSAppId");
    this.scene = Util.nullAsNil(getIntent().getStringExtra("voipCSScene"));
    this.type = Util.nullAsNil(getIntent().getStringExtra("voipCSType"));
    this.Okk = getIntent().getStringExtra("voipCSAllowBackCamera");
    this.Okl = getIntent().getStringExtra("voipCSShowOther");
    this.nfY = getIntent().getStringExtra("voipCSAvatarUrl");
    this.Okm = getIntent().getStringExtra("voipCSContext");
    this.Okn = getIntent().getBooleanExtra("launch_from_appbrand", false);
    getWindow().addFlags(6946944);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(67108864);
    }
    this.knk = new MMHandler();
    paramBundle = com.tencent.mm.plugin.voip_cs.c.c.gEX();
    Log.d("MicroMsg.VoipCSReportHelper", "reset");
    paramBundle.dataType = 0;
    paramBundle.OiA = 0;
    paramBundle.OiB = 0;
    paramBundle.OiC = 0;
    paramBundle.videoFps = 0;
    paramBundle.OiD = 0;
    paramBundle.OiE = 0;
    paramBundle.OiF = 0;
    paramBundle.OiG = 0;
    paramBundle.OiH = 0;
    paramBundle.OiI = 0;
    paramBundle.networkType = 0;
    paramBundle.OiJ = 0;
    paramBundle.OiK = com.tencent.mm.plugin.voip_cs.c.d.Oix;
    paramBundle.kmJ = 0;
    paramBundle.roomId = 0L;
    paramBundle.DPJ = 0L;
    paramBundle.OiL = "";
    paramBundle.NQG = 0;
    paramBundle.OiO = 0;
    paramBundle.OiP = 0;
    paramBundle.OiQ = 0;
    paramBundle.NRb = 0;
    paramBundle.NRa = 0;
    paramBundle.OiR = 0;
    paramBundle.OiS = 0;
    paramBundle.OiT = 0;
    paramBundle.OiU = 0;
    paramBundle.OiV = 0;
    paramBundle.OiW = 0;
    paramBundle.OiX = 0L;
    paramBundle.OiY = 0;
    paramBundle.OiZ = 0L;
    paramBundle.Oja = 0L;
    paramBundle.Ojb = 0L;
    paramBundle.DQW = 0L;
    paramBundle.Ojc = 0;
    paramBundle.Ojd = 0;
    paramBundle.channelStrategy = 1;
    paramBundle.NSH = 0;
    paramBundle.NRc = 0;
    paramBundle.Oje = 0;
    paramBundle.Ojf = 0;
    paramBundle.DRg = "";
    paramBundle.DRf = "";
    paramBundle.Ojj = 0;
    paramBundle.Ojk = 0;
    paramBundle.Ojl = 0;
    paramBundle.Ojm = 0;
    paramBundle.Ojn = 0;
    this.DOk = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojx = this.Ojx;
    this.Oki = new com.tencent.mm.plugin.voip_cs.c.a.b(this);
    this.Okj = new com.tencent.mm.plugin.voip_cs.a.a();
    this.fmh = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    this.OjD = com.tencent.mm.plugin.voip_cs.c.a.a.gFe();
    com.tencent.mm.plugin.voip_cs.c.c.gEV().Okg = this;
    com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojp = this;
    if ((com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw == 0) || (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw == 3)) {
      com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw = 0;
    }
    com.tencent.mm.booter.a.aql().aqn();
    this.fmh.avy();
    this.Okj.acR();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.USER_PRESENT");
    MMApplicationContext.getContext().registerReceiver(this.NLh, paramBundle);
    com.tencent.mm.kernel.h.aHF().a(this.MjF);
    if (this.Okn) {
      if (this.scene.equals("1")) {
        if (this.type.equals("video"))
        {
          this.Ig = MMApplicationContext.getContext().getString(a.e.OhR);
          this.Oko = MMApplicationContext.getContext().getString(a.e.OhV);
          this.wording = MMApplicationContext.getContext().getString(a.e.OhV);
          i = this.DOk.getCallState();
          if ((i != 2) && (i != 1)) {
            break label1140;
          }
          Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.ui.base.h.a(this, a.e.Oif, a.e.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125440);
              paramAnonymousDialogInterface.dismiss();
              VoipCSMainUI.this.alU(0);
              AppMethodBeat.o(125440);
            }
          });
        }
      }
    }
    label1140:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label1145;
      }
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
      AppMethodBeat.o(125459);
      return;
      this.Ig = MMApplicationContext.getContext().getString(a.e.OhS);
      this.Oko = MMApplicationContext.getContext().getString(a.e.OhW);
      this.wording = MMApplicationContext.getContext().getString(a.e.OhW);
      break;
      if (this.type.equals("video"))
      {
        this.Ig = MMApplicationContext.getContext().getString(a.e.OhT);
        this.Oko = MMApplicationContext.getContext().getString(a.e.OhX);
        this.wording = MMApplicationContext.getContext().getString(a.e.OhX);
        break;
      }
      this.Ig = MMApplicationContext.getContext().getString(a.e.OhS);
      this.Oko = MMApplicationContext.getContext().getString(a.e.OhW);
      this.wording = MMApplicationContext.getContext().getString(a.e.OhW);
      break;
      if (this.scene.equals("1"))
      {
        if (this.type.equals("video"))
        {
          this.Ig = MMApplicationContext.getContext().getString(a.e.OhR);
          this.Oko = MMApplicationContext.getContext().getString(a.e.OhV);
          this.wording = MMApplicationContext.getContext().getString(a.e.OhV);
          break;
        }
        this.Ig = MMApplicationContext.getContext().getString(a.e.OhS);
        this.Oko = MMApplicationContext.getContext().getString(a.e.OhZ);
        this.wording = MMApplicationContext.getContext().getString(a.e.OhZ);
        break;
      }
      if (this.type.equals("video"))
      {
        this.Ig = MMApplicationContext.getContext().getString(a.e.OhT);
        this.Oko = MMApplicationContext.getContext().getString(a.e.OhZ);
        this.wording = MMApplicationContext.getContext().getString(a.e.OhZ);
        break;
      }
      this.Ig = MMApplicationContext.getContext().getString(a.e.OhS);
      this.Oko = MMApplicationContext.getContext().getString(a.e.OhY);
      this.wording = MMApplicationContext.getContext().getString(a.e.OhY);
      break;
    }
    label1145:
    paramBundle = this.DOk;
    Object localObject = this.prS;
    localObject = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onCreate", "(Landroid/os/Bundle;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramBundle.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onCreate", "(Landroid/os/Bundle;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    if (!NetStatusUtil.isNetworkConnected(this))
    {
      Log.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
      com.tencent.mm.ui.base.h.a(this, a.e.Oib, a.e.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125454);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.alU(9);
          AppMethodBeat.o(125454);
        }
      });
      i = 0;
    }
    while (i == 0)
    {
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
      AppMethodBeat.o(125459);
      return;
      if ((NetStatusUtil.isWifi(this)) || (s.gzG()))
      {
        i = 1;
      }
      else
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
        com.tencent.mm.ui.base.h.a(this, a.e.Oic, a.e.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125455);
            Log.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
            s.gzF();
            if (VoipCSMainUI.a(VoipCSMainUI.this)) {
              VoipCSMainUI.b(VoipCSMainUI.this);
            }
            AppMethodBeat.o(125455);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125456);
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.alU(8);
            AppMethodBeat.o(125456);
          }
        });
        i = 0;
      }
    }
    if (m.isVoipStarted())
    {
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
      com.tencent.mm.ui.base.h.a(this, a.e.in_voip_tip, a.e.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125450);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.alU(0);
          AppMethodBeat.o(125450);
        }
      });
      i = 1;
    }
    while (i != 0)
    {
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
      AppMethodBeat.o(125459);
      return;
      if (m.gDh())
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
        com.tencent.mm.ui.base.h.a(this, a.e.in_wechat_out_tip, a.e.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125451);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.alU(0);
            AppMethodBeat.o(125451);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.q.a.aAj())
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
        com.tencent.mm.ui.base.h.a(this, a.e.in_multitalk_tip, a.e.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125452);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.alU(0);
            AppMethodBeat.o(125452);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.bj.e.bpW())
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
        com.tencent.mm.ui.base.h.a(this, a.e.in_new_share_location_tip, a.e.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125453);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.alU(0);
            AppMethodBeat.o(125453);
          }
        });
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    if (gFt()) {
      gFs();
    }
    AppMethodBeat.o(125459);
  }
  
  public void onDestroy()
  {
    int j = 2;
    AppMethodBeat.i(125467);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
    if (this.fmh != null) {
      this.fmh.avz();
    }
    Object localObject1 = new yb();
    Object localObject2;
    Object localObject3;
    if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojy == -1)
    {
      ((yb)localObject1).fXp.status = 3;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = this.Okj;
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.gEX();
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).NMO == null) {
        break label1303;
      }
      localObject3 = com.tencent.mm.plugin.voip_cs.c.c.gEX();
      kotlin.g.b.p.j(localObject3, "SubCoreVoipCS.getReporter()");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiV != 1) {
        break label1303;
      }
      localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).NMO;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
    }
    label1293:
    label1298:
    label1303:
    for (int i = ((com.tencent.mm.plugin.voip.model.c)localObject3).gxF();; i = 0)
    {
      float f = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamMaxVolume(i);
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).Ojf = ((int)(((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamVolume(i) / f * 100.0F));
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.gEX();
      label213:
      label748:
      byte[] arrayOfByte;
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).tQq != null)
      {
        localObject3 = com.tencent.mm.plugin.voip_cs.c.c.gEX();
        kotlin.g.b.p.j(localObject3, "SubCoreVoipCS.getReporter()");
        if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiV == 1)
        {
          localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).tQq;
          if (localObject3 == null) {
            kotlin.g.b.p.iCn();
          }
          i = ((com.tencent.mm.audio.b.c)localObject3).aeX();
          ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).NRc = i;
          localObject2 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).tQq;
          if (localObject2 != null) {
            ((com.tencent.mm.audio.b.c)localObject2).aeJ();
          }
          localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).NMO;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.voip.model.c)localObject1).gxD();
          }
          this.OjD.stopRing();
          if (this.Oki != null)
          {
            localObject1 = this.Oki;
            if (com.tencent.mm.plugin.voip_cs.c.c.gEX().dataType == 0)
            {
              if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw >= 2) {
                break label1253;
              }
              com.tencent.mm.plugin.voip_cs.c.c.gEX().dataType = 1;
            }
            label301:
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).NWg.gDm();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).NWh.gDm();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).gFm();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).gFp();
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.gEW();
            Log.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            com.tencent.mm.kernel.h.aGY().b(823, (i)localObject1);
            com.tencent.mm.kernel.h.aGY().b(106, (i)localObject1);
            com.tencent.mm.kernel.h.aGY().b(818, (i)localObject1);
            com.tencent.mm.kernel.h.aGY().b(795, (i)localObject1);
            com.tencent.mm.kernel.h.aGY().b(285, (i)localObject1);
            com.tencent.mm.kernel.h.aGY().b(312, (i)localObject1);
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojw = 3;
            if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojy != 823)
            {
              com.tencent.mm.kernel.h.aGY().a(880, (i)localObject1);
              if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojr != 0) {
                break label1263;
              }
              i = 1;
              label444:
              Log.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojx + ",inviteId：" + com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.DPL + ",csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.NQI + ",roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.DPJ + ",reason:" + i);
              localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.a(com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.DPL, com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.NQI, com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.DPJ, ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojx, i);
              com.tencent.mm.kernel.h.aGY().a((q)localObject2, 0);
            }
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).OjA.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).OjB.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojq = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).OiM = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojr = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojs = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojt = null;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).DPS = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Oju = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojw = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojx = "";
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojv = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojy = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojz = 999;
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.gEV();
            Log.i("MicroMsg.VoipCSEngine", "now stop engine");
            ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).Okf.AZ(true);
            localObject2 = com.tencent.mm.plugin.voip_cs.c.c.gEX();
            if ((Util.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).DRg)) && (Util.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).DRf)))
            {
              localObject3 = com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf;
              if (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiT != 1) {
                break label1293;
              }
              i = 1;
              arrayOfByte = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).Oio;
              j = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).Oio.length;
              if (i == 0) {
                break label1298;
              }
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).getVoipcsChannelInfo(arrayOfByte, j, i);
        Log.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength) });
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).DRg = new String(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).Oio, 0, ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength);
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).DRf = com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.gES();
        Log.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).DRg });
        Log.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).DRf });
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.gEW();
        com.tencent.mm.kernel.h.aGY().a(312, (i)localObject2);
        localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.e(com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.NQI, com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.DPJ);
        com.tencent.mm.kernel.h.aGY().a((q)localObject2, 0);
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).Okf.reset();
        r.gzC().gzE();
        r.gzC().a(null);
        this.Oki = null;
        localObject1 = this.Okj;
        com.tencent.mm.plugin.audio.b.a.a((com.tencent.mm.plugin.audio.b.a)localObject1, 0);
        ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).anT("voipcs");
        MMApplicationContext.getContext().unregisterReceiver(this.NLh);
        com.tencent.mm.kernel.h.aHF().b(this.MjF);
        if (this.Okp != null) {
          this.Okp.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        if ((this.DOk != null) && (this.prS != null))
        {
          localObject1 = this.DOk;
          localObject2 = this.prS;
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          this.prS = null;
        }
        com.tencent.mm.plugin.voip_cs.a.a.unInit();
        this.Okj = null;
        super.onDestroy();
        AppMethodBeat.o(125467);
        return;
        if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojy == 823)
        {
          ((yb)localObject1).fXp.status = 4;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw <= 1)
        {
          ((yb)localObject1).fXp.status = 1;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw < 2) {
          break;
        }
        ((yb)localObject1).fXp.status = 2;
        break;
        i = 0;
        break label213;
        label1253:
        com.tencent.mm.plugin.voip_cs.c.c.gEX().dataType = 3;
        break label301;
        label1263:
        i = j;
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojr == 2) {
          break label444;
        }
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Ojr == 3)
        {
          i = 3;
          break label444;
        }
        i = 4;
        break label444;
        i = 0;
        break label748;
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125461);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      AppMethodBeat.o(125461);
      return true;
    }
    if (paramInt == 25)
    {
      paramInt = this.Okj.Bw(this.OjD.cNL());
      this.Okj.Ey(paramInt);
      AppMethodBeat.o(125461);
      return true;
    }
    if (paramInt == 24)
    {
      paramInt = this.Okj.Bw(this.OjD.cNL());
      this.Okj.Ex(paramInt);
      AppMethodBeat.o(125461);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125461);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125464);
    super.onPause();
    if (!this.OjD.cNL()) {
      this.OjD.stopRing();
    }
    if ((com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw == 1) || (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw == 2))
    {
      Object localObject = new Intent(MMApplicationContext.getContext(), VoipCSMainUI.class);
      ((Intent)localObject).putExtra("voipCSBizId", this.Ojx);
      ((Intent)localObject).putExtra("voipCSAppId", this.appId);
      ((Intent)localObject).putExtra("voipCSScene", this.scene);
      ((Intent)localObject).putExtra("voipCSType", this.type);
      ((Intent)localObject).putExtra("voipCSAllowBackCamera", this.Okk);
      ((Intent)localObject).putExtra("voipCSShowOther", this.Okl);
      ((Intent)localObject).putExtra("voipCSAvatarUrl", this.nfY);
      ((Intent)localObject).putExtra("voipCSContext", this.Okm);
      ((Intent)localObject).putExtra("launch_from_appbrand", this.Okn);
      localObject = PendingIntent.getActivity(MMApplicationContext.getContext(), 44, (Intent)localObject, 134217728);
      e.d locald = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(this.Oko).e(System.currentTimeMillis()).k(this.Ig).l(this.wording);
      locald.Ip = ((PendingIntent)localObject);
      locald.e(2, true);
      localObject = locald.gr();
      ((Notification)localObject).icon = com.tencent.mm.bx.a.fkG();
      ((Notification)localObject).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
      if ((this.Okp != null) && (this.Okp.stopped())) {
        this.Okp.startTimer(5000L);
      }
    }
    for (;;)
    {
      this.Oki.gFm();
      this.Oki.fEs = true;
      AppMethodBeat.o(125464);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
      if (this.Okp != null) {
        this.Okp.stopTimer();
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(125472);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      Log.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(125472);
      return;
    }
    Log.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(125472);
      return;
    case 82: 
      if (paramArrayOfInt[0] == 0)
      {
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
          gFs();
        }
        AppMethodBeat.o(125472);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(a.e.permission_microphone_request_again_msg), getString(a.e.permission_tips_title), getString(a.e.jump_to_settings), getString(a.e.app_cancel), false, new VoipCSMainUI.4(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(213151);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.alU(2);
          AppMethodBeat.o(213151);
        }
      });
      AppMethodBeat.o(125472);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      gFs();
      AppMethodBeat.o(125472);
      return;
    }
    if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
    for (paramInt = a.e.permission_camera_request_again_msg;; paramInt = a.e.permission_microphone_request_again_msg)
    {
      com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(a.e.permission_tips_title), getString(a.e.jump_to_settings), getString(a.e.app_cancel), false, new VoipCSMainUI.6(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125446);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.alU(3);
          AppMethodBeat.o(125446);
        }
      });
      break;
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(125465);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
    super.onRestart();
    if ((gFt()) && (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw <= 1)) {
      gFs();
    }
    if (this.Oki != null) {
      this.Oki.fEs = false;
    }
    AppMethodBeat.o(125465);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125463);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
    super.onResume();
    if (this.Oki != null)
    {
      this.Oki.fEs = false;
      if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw > 1)
      {
        gFs();
        if ((this.Okl != null) && (this.Okl.equals("1"))) {
          this.Oki.gFo();
        }
      }
    }
    if (this.Okp != null) {
      this.Okp.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
    AppMethodBeat.o(125463);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(125466);
    super.onStop();
    AppMethodBeat.o(125466);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI
 * JD-Core Version:    0.7.0.1
 */