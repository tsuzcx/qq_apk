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
import android.support.v4.app.s.c;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.c.b.a.a;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class VoipCSMainUI
  extends MMActivity
  implements com.tencent.mm.plugin.voip_cs.c.b, a.a
{
  private com.tencent.mm.network.p FPE;
  private BroadcastReceiver GUV;
  public String HrM;
  private com.tencent.mm.plugin.voip_cs.c.a.a HrS;
  public String HsA;
  public String HsB;
  public String HsC;
  public boolean HsD;
  private MTimerHandler HsE;
  private com.tencent.mm.plugin.voip_cs.c.a.b Hsy;
  private com.tencent.mm.plugin.voip_cs.a.a Hsz;
  private String appId;
  public String dQx;
  private com.tencent.mm.compatible.util.b dtz;
  private MMHandler hAk;
  public String kog;
  PhoneStateListener mtH;
  public String scene;
  public CharSequence tickerText;
  public CharSequence title;
  public String type;
  private TelephonyManager yoi;
  
  public VoipCSMainUI()
  {
    AppMethodBeat.i(125458);
    this.HrM = "";
    this.appId = "";
    this.kog = "";
    this.HsA = "";
    this.HsB = "";
    this.HsC = "";
    this.scene = "";
    this.type = "";
    this.HsD = false;
    this.dQx = MMApplicationContext.getContext().getString(2131767276);
    this.tickerText = MMApplicationContext.getContext().getString(2131767276);
    this.title = MMApplicationContext.getContext().getString(2131767270);
    this.HsE = new MTimerHandler(Looper.getMainLooper(), new VoipCSMainUI.16(this), true);
    this.GUV = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(199030);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          Log.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
          VoipCSMainUI.c(VoipCSMainUI.this).dLD = false;
          AppMethodBeat.o(199030);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          Log.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
          VoipCSMainUI.c(VoipCSMainUI.this).dLD = false;
          if ((!VoipCSMainUI.d(VoipCSMainUI.this).czl()) && (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL == 2))
          {
            VoipCSMainUI.d(VoipCSMainUI.this).fMC();
            AppMethodBeat.o(199030);
          }
        }
        else if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          Log.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
          VoipCSMainUI.c(VoipCSMainUI.this).dLD = true;
          if (!VoipCSMainUI.d(VoipCSMainUI.this).czl()) {
            VoipCSMainUI.d(VoipCSMainUI.this).stopRing();
          }
        }
        AppMethodBeat.o(199030);
      }
    };
    this.mtH = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(199031);
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
        if (paramAnonymousInt == 2)
        {
          Log.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
          com.tencent.mm.plugin.voip_cs.c.c.fMt().Hrf = 4;
          VoipCSMainUI.this.aeh(7);
        }
        AppMethodBeat.o(199031);
      }
    };
    this.FPE = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(199034);
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        com.tencent.mm.plugin.voip_cs.c.a locala;
        if ((com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL == 2) && ((paramAnonymousInt == 4) || (paramAnonymousInt == 6)))
        {
          localObject = com.tencent.mm.plugin.voip_cs.c.c.fMs();
          locala = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv;
          if (((com.tencent.mm.plugin.voip_cs.c.e)localObject).GWg == 0) {
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject).GWg = locala.Hau;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext());
          if (paramAnonymousInt != ((com.tencent.mm.plugin.voip_cs.c.e)localObject).GWg) {
            Log.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + ((com.tencent.mm.plugin.voip_cs.c.e)localObject).GWg + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locala.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            Log.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locala.ypO + ", roomkey=" + locala.ypH + "]");
          }
          epd localepd = new epd();
          localepd.NmY = 3;
          localepd.NmZ = new com.tencent.mm.bw.b(arrayOfByte, 0, 1);
          locala.SendRUDP(localepd.toByteArray(), localepd.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
          }
        }
        ((com.tencent.mm.plugin.voip_cs.c.e)localObject).GWg = paramAnonymousInt;
        Object localObject = com.tencent.mm.plugin.voip_cs.c.c.fMs();
        Log.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.Haw + "roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.ypH);
        g.azz().a(285, (i)localObject);
        localObject = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv;
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.d(((v2protocal)localObject).Haw, ((v2protocal)localObject).ypH);
        g.azz().a((q)localObject, 0);
        AppMethodBeat.o(199034);
      }
    };
    AppMethodBeat.o(125458);
  }
  
  private void fMO()
  {
    AppMethodBeat.i(125460);
    if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL <= 0)
    {
      this.Hsy.fMD();
      this.Hsy.fME();
      com.tencent.mm.plugin.voip_cs.c.c.fMr().init();
      com.tencent.mm.plugin.voip_cs.c.c.fMs().aY(this.HrM, this.appId, this.HsC);
    }
    if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL < 2) {
      this.HrS.fMC();
    }
    this.Hsy.fMH();
    AppMethodBeat.o(125460);
  }
  
  private boolean fMP()
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
  
  public final void aeh(int paramInt)
  {
    AppMethodBeat.i(125468);
    Log.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + paramInt + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL);
    if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL == 0)
    {
      finish();
      AppMethodBeat.o(125468);
      return;
    }
    if (this.Hsy != null) {
      this.Hsy.aek(paramInt);
    }
    AppMethodBeat.o(125468);
  }
  
  public final void dZP()
  {
    Object localObject2 = null;
    AppMethodBeat.i(125473);
    this.Hsy.dZP();
    this.Hsz.Yl();
    Object localObject1 = this.Hsz;
    if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).qrH != null)
    {
      localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).qrH;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((com.tencent.mm.audio.b.c)localObject1).aai());
        com.tencent.mm.plugin.voip_cs.c.c.fMt().Hrk = 1;
        if (!kotlin.g.b.p.j(localObject1, Boolean.TRUE)) {
          break label230;
        }
      }
    }
    com.tencent.mm.plugin.voip_cs.a.a locala;
    label230:
    for (int i = 1;; i = -1)
    {
      com.tencent.mm.plugin.voip_cs.c.c.fMt().HrD = i;
      locala = this.Hsz;
      if (locala.GWB != null) {
        break label235;
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.fMr();
      kotlin.g.b.p.g(localObject1, "SubCoreVoipCS.getVoipCSEngine()");
      ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).Hsv.HaL = Math.abs(1);
      this.HrS.stopRing();
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.fMt();
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Hry != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Hrn = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Hry);
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.fMt();
      Log.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).HrB == 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).HrB = ((int)(System.currentTimeMillis() / 1000L));
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.fMt();
      Log.d("MicroMsg.VoipCSReportHelper", "markConnect");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).HrA != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Hrp = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).HrA);
      }
      AppMethodBeat.o(125473);
      return;
      localObject1 = null;
      break;
    }
    label235:
    com.tencent.mm.plugin.voip.model.c localc = locala.GWB;
    localObject1 = localObject2;
    if (localc != null) {
      localObject1 = Integer.valueOf(localc.fFp());
    }
    localObject2 = locala.GWB;
    if (localObject2 != null) {}
    for (i = ((com.tencent.mm.plugin.voip.model.c)localObject2).fFp();; i = 0)
    {
      if (i <= 0)
      {
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.fMr();
        kotlin.g.b.p.g(localObject2, "SubCoreVoipCS.getVoipCSEngine()");
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject2).Hsv.HaL = Math.abs(1);
      }
      if (localObject1 == null) {
        break;
      }
      ((Integer)localObject1).intValue();
      break;
    }
  }
  
  public final void fMN()
  {
    AppMethodBeat.i(125474);
    Log.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
    this.Hsy.aek(5);
    AppMethodBeat.o(125474);
  }
  
  public int getLayoutId()
  {
    return 2131496858;
  }
  
  public final void ln(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125470);
    com.tencent.mm.plugin.voip_cs.c.a.b localb = this.Hsy;
    if ((localb.Hsl.equals("")) && (Util.isNullOrNil(paramString2))) {
      if (localb.HrT.HsD) {
        localb.gvw.setText(2131767257);
      }
    }
    while ((localb.Hsk.equals("")) && (Util.isNullOrNil(paramString1)) && ((localb.HrT.kog == null) || (localb.HrT.kog.equals(""))))
    {
      localb.HrZ.setImageResource(2131231957);
      AppMethodBeat.o(125470);
      return;
      localb.gvw.setText(2131767256);
      continue;
      localb.setNickName(paramString2);
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if ((!Util.isNullOrNil(paramString1)) && (!localb.Hsk.equals(paramString1)))
    {
      localb.aUE(paramString1);
      localSharedPreferences.edit().putString(localb.fMF(), paramString1).commit();
    }
    if ((!Util.isNullOrNil(paramString2)) && (!localb.Hsl.equals(paramString2)))
    {
      localb.setNickName(paramString2);
      localSharedPreferences.edit().putString(localb.fMG(), paramString2).commit();
    }
    AppMethodBeat.o(125470);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125459);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
    super.onCreate(paramBundle);
    hideTitleView();
    this.HrM = getIntent().getStringExtra("voipCSBizId");
    this.appId = getIntent().getStringExtra("voipCSAppId");
    this.scene = Util.nullAsNil(getIntent().getStringExtra("voipCSScene"));
    this.type = Util.nullAsNil(getIntent().getStringExtra("voipCSType"));
    this.HsA = getIntent().getStringExtra("voipCSAllowBackCamera");
    this.HsB = getIntent().getStringExtra("voipCSShowOther");
    this.kog = getIntent().getStringExtra("voipCSAvatarUrl");
    this.HsC = getIntent().getStringExtra("voipCSContext");
    this.HsD = getIntent().getBooleanExtra("launch_from_appbrand", false);
    getWindow().addFlags(6946944);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(67108864);
    }
    this.hAk = new MMHandler();
    paramBundle = com.tencent.mm.plugin.voip_cs.c.c.fMt();
    Log.d("MicroMsg.VoipCSReportHelper", "reset");
    paramBundle.dataType = 0;
    paramBundle.HqP = 0;
    paramBundle.HqQ = 0;
    paramBundle.HqR = 0;
    paramBundle.videoFps = 0;
    paramBundle.HqS = 0;
    paramBundle.HqT = 0;
    paramBundle.HqU = 0;
    paramBundle.HqV = 0;
    paramBundle.HqW = 0;
    paramBundle.HqX = 0;
    paramBundle.networkType = 0;
    paramBundle.HqY = 0;
    paramBundle.HqZ = com.tencent.mm.plugin.voip_cs.c.d.HqM;
    paramBundle.hzL = 0;
    paramBundle.roomId = 0L;
    paramBundle.ypH = 0L;
    paramBundle.Hra = "";
    paramBundle.Hau = 0;
    paramBundle.Hrd = 0;
    paramBundle.Hre = 0;
    paramBundle.Hrf = 0;
    paramBundle.HaP = 0;
    paramBundle.HaO = 0;
    paramBundle.Hrg = 0;
    paramBundle.Hrh = 0;
    paramBundle.Hri = 0;
    paramBundle.Hrj = 0;
    paramBundle.Hrk = 0;
    paramBundle.Hrl = 0;
    paramBundle.Hrm = 0L;
    paramBundle.Hrn = 0;
    paramBundle.Hro = 0L;
    paramBundle.Hrp = 0L;
    paramBundle.Hrq = 0L;
    paramBundle.yqU = 0L;
    paramBundle.Hrr = 0;
    paramBundle.Hrs = 0;
    paramBundle.channelStrategy = 1;
    paramBundle.Hcv = 0;
    paramBundle.HaQ = 0;
    paramBundle.Hrt = 0;
    paramBundle.Hru = 0;
    paramBundle.yre = "";
    paramBundle.yrd = "";
    paramBundle.Hry = 0;
    paramBundle.Hrz = 0;
    paramBundle.HrA = 0;
    paramBundle.HrB = 0;
    paramBundle.HrC = 0;
    this.yoi = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    com.tencent.mm.plugin.voip_cs.c.c.fMs().HrM = this.HrM;
    this.Hsy = new com.tencent.mm.plugin.voip_cs.c.a.b(this);
    this.Hsz = new com.tencent.mm.plugin.voip_cs.a.a();
    this.dtz = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    this.HrS = com.tencent.mm.plugin.voip_cs.c.a.a.fMA();
    com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsw = this;
    com.tencent.mm.plugin.voip_cs.c.c.fMs().HrE = this;
    if ((com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL == 0) || (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL == 3)) {
      com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL = 0;
    }
    com.tencent.mm.booter.a.akp().akr();
    this.dtz.requestFocus();
    this.Hsz.Yl();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.USER_PRESENT");
    MMApplicationContext.getContext().registerReceiver(this.GUV, paramBundle);
    g.aAg().a(this.FPE);
    if (this.HsD) {
      if (this.scene.equals("1")) {
        if (this.type.equals("video"))
        {
          this.title = MMApplicationContext.getContext().getString(2131767268);
          this.tickerText = MMApplicationContext.getContext().getString(2131767272);
          this.dQx = MMApplicationContext.getContext().getString(2131767272);
          i = this.yoi.getCallState();
          if ((i != 2) && (i != 1)) {
            break label1134;
          }
          Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
          h.a(this, 2131767282, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125440);
              paramAnonymousDialogInterface.dismiss();
              VoipCSMainUI.this.aeh(0);
              AppMethodBeat.o(125440);
            }
          });
        }
      }
    }
    label1134:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label1139;
      }
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
      AppMethodBeat.o(125459);
      return;
      this.title = MMApplicationContext.getContext().getString(2131767269);
      this.tickerText = MMApplicationContext.getContext().getString(2131767273);
      this.dQx = MMApplicationContext.getContext().getString(2131767273);
      break;
      if (this.type.equals("video"))
      {
        this.title = MMApplicationContext.getContext().getString(2131767270);
        this.tickerText = MMApplicationContext.getContext().getString(2131767274);
        this.dQx = MMApplicationContext.getContext().getString(2131767274);
        break;
      }
      this.title = MMApplicationContext.getContext().getString(2131767269);
      this.tickerText = MMApplicationContext.getContext().getString(2131767273);
      this.dQx = MMApplicationContext.getContext().getString(2131767273);
      break;
      if (this.scene.equals("1"))
      {
        if (this.type.equals("video"))
        {
          this.title = MMApplicationContext.getContext().getString(2131767268);
          this.tickerText = MMApplicationContext.getContext().getString(2131767272);
          this.dQx = MMApplicationContext.getContext().getString(2131767272);
          break;
        }
        this.title = MMApplicationContext.getContext().getString(2131767269);
        this.tickerText = MMApplicationContext.getContext().getString(2131767276);
        this.dQx = MMApplicationContext.getContext().getString(2131767276);
        break;
      }
      if (this.type.equals("video"))
      {
        this.title = MMApplicationContext.getContext().getString(2131767270);
        this.tickerText = MMApplicationContext.getContext().getString(2131767276);
        this.dQx = MMApplicationContext.getContext().getString(2131767276);
        break;
      }
      this.title = MMApplicationContext.getContext().getString(2131767269);
      this.tickerText = MMApplicationContext.getContext().getString(2131767275);
      this.dQx = MMApplicationContext.getContext().getString(2131767275);
      break;
    }
    label1139:
    paramBundle = this.yoi;
    Object localObject = this.mtH;
    localObject = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onCreate", "(Landroid/os/Bundle;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramBundle.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onCreate", "(Landroid/os/Bundle;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    if (!NetStatusUtil.isNetworkConnected(this))
    {
      Log.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
      h.a(this, 2131767278, 2131767338, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125454);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.aeh(9);
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
      if ((NetStatusUtil.isWifi(this)) || (s.fHs()))
      {
        i = 1;
      }
      else
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
        h.a(this, 2131767279, 2131767338, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125455);
            Log.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
            s.fHr();
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
            VoipCSMainUI.this.aeh(8);
            AppMethodBeat.o(125456);
          }
        });
        i = 0;
      }
    }
    if (m.isVoipStarted())
    {
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
      h.a(this, 2131761781, 2131755998, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125450);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.aeh(0);
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
      if (m.fKH())
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
        h.a(this, 2131761782, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125451);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.aeh(0);
            AppMethodBeat.o(125451);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.q.a.att())
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
        h.a(this, 2131761776, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125452);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.aeh(0);
            AppMethodBeat.o(125452);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.bh.e.bgH())
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
        h.a(this, 2131761777, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125453);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.aeh(0);
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
    if (fMP()) {
      fMO();
    }
    AppMethodBeat.o(125459);
  }
  
  public void onDestroy()
  {
    int j = 2;
    AppMethodBeat.i(125467);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
    if (this.dtz != null) {
      this.dtz.apm();
    }
    Object localObject1 = new wv();
    Object localObject2;
    Object localObject3;
    if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrN == -1)
    {
      ((wv)localObject1).edj.status = 3;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = this.Hsz;
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.fMt();
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).GWB == null) {
        break label1303;
      }
      localObject3 = com.tencent.mm.plugin.voip_cs.c.c.fMt();
      kotlin.g.b.p.g(localObject3, "SubCoreVoipCS.getReporter()");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrk != 1) {
        break label1303;
      }
      localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).GWB;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
    }
    label1293:
    label1298:
    label1303:
    for (int i = ((com.tencent.mm.plugin.voip.model.c)localObject3).bhV();; i = 0)
    {
      float f = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamMaxVolume(i);
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).Hru = ((int)(((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamVolume(i) / f * 100.0F));
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.fMt();
      label213:
      label748:
      byte[] arrayOfByte;
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).qrH != null)
      {
        localObject3 = com.tencent.mm.plugin.voip_cs.c.c.fMt();
        kotlin.g.b.p.g(localObject3, "SubCoreVoipCS.getReporter()");
        if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrk == 1)
        {
          localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).qrH;
          if (localObject3 == null) {
            kotlin.g.b.p.hyc();
          }
          i = ((com.tencent.mm.audio.b.c)localObject3).aal();
          ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HaQ = i;
          localObject2 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).qrH;
          if (localObject2 != null) {
            ((com.tencent.mm.audio.b.c)localObject2).ZZ();
          }
          localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).GWB;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.voip.model.c)localObject1).fFr();
          }
          this.HrS.stopRing();
          if (this.Hsy != null)
          {
            localObject1 = this.Hsy;
            if (com.tencent.mm.plugin.voip_cs.c.c.fMt().dataType == 0)
            {
              if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL >= 2) {
                break label1253;
              }
              com.tencent.mm.plugin.voip_cs.c.c.fMt().dataType = 1;
            }
            label301:
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).Hfp.fKM();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).Hfq.fKM();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).fMI();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).fML();
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.fMs();
            Log.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            g.azz().b(823, (i)localObject1);
            g.azz().b(106, (i)localObject1);
            g.azz().b(818, (i)localObject1);
            g.azz().b(795, (i)localObject1);
            g.azz().b(285, (i)localObject1);
            g.azz().b(312, (i)localObject1);
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrL = 3;
            if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrN != 823)
            {
              g.azz().a(880, (i)localObject1);
              if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrG != 0) {
                break label1263;
              }
              i = 1;
              label444:
              Log.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrM + ",inviteId：" + com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.ypJ + ",csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.Haw + ",roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.ypH + ",reason:" + i);
              localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.a(com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.ypJ, com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.Haw, com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.ypH, ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrM, i);
              g.azz().a((q)localObject2, 0);
            }
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrP.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrQ.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrF = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Hrb = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrG = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrH = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrI = null;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).ypQ = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrJ = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrL = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrM = "";
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrK = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrN = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrO = 999;
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.fMr();
            Log.i("MicroMsg.VoipCSEngine", "now stop engine");
            ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).Hsv.xh(true);
            localObject2 = com.tencent.mm.plugin.voip_cs.c.c.fMt();
            if ((Util.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).yre)) && (Util.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).yrd)))
            {
              localObject3 = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv;
              if (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).Hri != 1) {
                break label1293;
              }
              i = 1;
              arrayOfByte = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).HqD;
              j = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).HqD.length;
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
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).yre = new String(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).HqD, 0, ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength);
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).yrd = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.fMo();
        Log.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).yre });
        Log.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).yrd });
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.fMs();
        g.azz().a(312, (i)localObject2);
        localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.e(com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.Haw, com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.ypH);
        g.azz().a((q)localObject2, 0);
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).Hsv.reset();
        r.fHo().fHq();
        r.fHo().a(null);
        this.Hsy = null;
        localObject1 = this.Hsz;
        com.tencent.mm.plugin.audio.b.a.a((com.tencent.mm.plugin.audio.b.a)localObject1, 0);
        ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).agq("voipcs");
        MMApplicationContext.getContext().unregisterReceiver(this.GUV);
        g.aAg().b(this.FPE);
        if (this.HsE != null) {
          this.HsE.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        if ((this.yoi != null) && (this.mtH != null))
        {
          localObject1 = this.yoi;
          localObject2 = this.mtH;
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          this.mtH = null;
        }
        com.tencent.mm.plugin.voip_cs.a.a.unInit();
        this.Hsz = null;
        super.onDestroy();
        AppMethodBeat.o(125467);
        return;
        if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrN == 823)
        {
          ((wv)localObject1).edj.status = 4;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL <= 1)
        {
          ((wv)localObject1).edj.status = 1;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL < 2) {
          break;
        }
        ((wv)localObject1).edj.status = 2;
        break;
        i = 0;
        break label213;
        label1253:
        com.tencent.mm.plugin.voip_cs.c.c.fMt().dataType = 3;
        break label301;
        label1263:
        i = j;
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrG == 2) {
          break label444;
        }
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).HrG == 3)
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
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(125469);
    if (this.Hsy != null)
    {
      Log.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(paramInt)));
      this.Hsy.aek(paramInt);
    }
    AppMethodBeat.o(125469);
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
      paramInt = this.Hsz.xC(this.HrS.czl());
      this.Hsz.AX(paramInt);
      AppMethodBeat.o(125461);
      return true;
    }
    if (paramInt == 24)
    {
      paramInt = this.Hsz.xC(this.HrS.czl());
      this.Hsz.AW(paramInt);
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
    if (!this.HrS.czl()) {
      this.HrS.stopRing();
    }
    if ((com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL == 1) || (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL == 2))
    {
      Object localObject = new Intent(MMApplicationContext.getContext(), VoipCSMainUI.class);
      ((Intent)localObject).putExtra("voipCSBizId", this.HrM);
      ((Intent)localObject).putExtra("voipCSAppId", this.appId);
      ((Intent)localObject).putExtra("voipCSScene", this.scene);
      ((Intent)localObject).putExtra("voipCSType", this.type);
      ((Intent)localObject).putExtra("voipCSAllowBackCamera", this.HsA);
      ((Intent)localObject).putExtra("voipCSShowOther", this.HsB);
      ((Intent)localObject).putExtra("voipCSAvatarUrl", this.kog);
      ((Intent)localObject).putExtra("voipCSContext", this.HsC);
      ((Intent)localObject).putExtra("launch_from_appbrand", this.HsD);
      localObject = PendingIntent.getActivity(MMApplicationContext.getContext(), 44, (Intent)localObject, 134217728);
      s.c localc = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(this.tickerText).i(System.currentTimeMillis()).f(this.title).g(this.dQx);
      localc.Hv = ((PendingIntent)localObject);
      localc.g(2, true);
      localObject = localc.build();
      ((Notification)localObject).icon = com.tencent.mm.bq.a.ezb();
      ((Notification)localObject).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
      if ((this.HsE != null) && (this.HsE.stopped())) {
        this.HsE.startTimer(5000L);
      }
    }
    for (;;)
    {
      this.Hsy.fMI();
      this.Hsy.dLD = true;
      AppMethodBeat.o(125464);
      return;
      ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
      if (this.HsE != null) {
        this.HsE.stopTimer();
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
          fMO();
        }
        AppMethodBeat.o(125472);
        return;
      }
      h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131755761), false, new VoipCSMainUI.4(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(199033);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.aeh(2);
          AppMethodBeat.o(199033);
        }
      });
      AppMethodBeat.o(125472);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      fMO();
      AppMethodBeat.o(125472);
      return;
    }
    if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
    for (paramInt = 2131763864;; paramInt = 2131763876)
    {
      h.a(this, getString(paramInt), getString(2131763890), getString(2131762043), getString(2131755761), false, new VoipCSMainUI.6(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125446);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.aeh(3);
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
    if ((fMP()) && (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL <= 1)) {
      fMO();
    }
    if (this.Hsy != null) {
      this.Hsy.dLD = false;
    }
    AppMethodBeat.o(125465);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125463);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
    super.onResume();
    if (this.Hsy != null)
    {
      this.Hsy.dLD = false;
      if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL > 1)
      {
        fMO();
        if ((this.HsB != null) && (this.HsB.equals("1"))) {
          this.Hsy.fMK();
        }
      }
    }
    if (this.HsE != null) {
      this.HsE.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI
 * JD-Core Version:    0.7.0.1
 */