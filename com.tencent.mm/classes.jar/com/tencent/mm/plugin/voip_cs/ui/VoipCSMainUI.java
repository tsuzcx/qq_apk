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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.model.aq;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.c.b.a.a;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class VoipCSMainUI
  extends MMActivity
  implements com.tencent.mm.plugin.voip_cs.c.b, a.a
{
  private String appId;
  private com.tencent.mm.compatible.util.b cST;
  public String doh;
  private ap gAC;
  public String itN;
  PhoneStateListener klv;
  public String scene;
  private TelephonyManager szx;
  public CharSequence tickerText;
  public CharSequence title;
  public String type;
  private com.tencent.mm.network.n yIx;
  public String zCW;
  private com.tencent.mm.plugin.voip_cs.c.a.b zDH;
  private com.tencent.mm.plugin.voip_cs.a.a zDI;
  public String zDJ;
  public String zDK;
  public String zDL;
  public boolean zDM;
  private av zDN;
  private com.tencent.mm.plugin.voip_cs.c.a.a zDc;
  private BroadcastReceiver zhY;
  
  public VoipCSMainUI()
  {
    AppMethodBeat.i(125458);
    this.zCW = "";
    this.appId = "";
    this.itN = "";
    this.zDJ = "";
    this.zDK = "";
    this.zDL = "";
    this.scene = "";
    this.type = "";
    this.zDM = false;
    this.doh = aj.getContext().getString(2131764837);
    this.tickerText = aj.getContext().getString(2131764837);
    this.title = aj.getContext().getString(2131764831);
    this.zDN = new av(Looper.getMainLooper(), new VoipCSMainUI.16(this), true);
    this.zhY = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(190833);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)aj.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          ad.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
          VoipCSMainUI.c(VoipCSMainUI.this).dkt = false;
          AppMethodBeat.o(190833);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          ad.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
          VoipCSMainUI.c(VoipCSMainUI.this).dkt = false;
          if ((!VoipCSMainUI.d(VoipCSMainUI.this).cSx()) && (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV == 2))
          {
            VoipCSMainUI.d(VoipCSMainUI.this).dYr();
            AppMethodBeat.o(190833);
          }
        }
        else if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          ad.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
          VoipCSMainUI.c(VoipCSMainUI.this).dkt = true;
          if (!VoipCSMainUI.d(VoipCSMainUI.this).cSx()) {
            VoipCSMainUI.d(VoipCSMainUI.this).stopRing();
          }
        }
        AppMethodBeat.o(190833);
      }
    };
    this.klv = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(190834);
        ad.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
        if (paramAnonymousInt == 2)
        {
          ad.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
          com.tencent.mm.plugin.voip_cs.c.c.dYi().zCp = 4;
          VoipCSMainUI.this.QZ(7);
        }
        AppMethodBeat.o(190834);
      }
    };
    this.yIx = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(190837);
        ad.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        com.tencent.mm.plugin.voip_cs.c.a locala;
        if ((com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV == 2) && ((paramAnonymousInt == 4) || (paramAnonymousInt == 6)))
        {
          localObject = com.tencent.mm.plugin.voip_cs.c.c.dYh();
          locala = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE;
          if (((com.tencent.mm.plugin.voip_cs.c.e)localObject).zjk == 0) {
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject).zjk = locala.znq;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.b.c.getNetType(aj.getContext());
          if (paramAnonymousInt != ((com.tencent.mm.plugin.voip_cs.c.e)localObject).zjk) {
            ad.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + ((com.tencent.mm.plugin.voip_cs.c.e)localObject).zjk + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locala.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            ad.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locala.sBf + ", roomkey=" + locala.sAY + "]");
          }
          diz localdiz = new diz();
          localdiz.Ezh = 3;
          localdiz.Ezi = new com.tencent.mm.bx.b(arrayOfByte, 0, 1);
          locala.SendRUDP(localdiz.toByteArray(), localdiz.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
          }
        }
        ((com.tencent.mm.plugin.voip_cs.c.e)localObject).zjk = paramAnonymousInt;
        Object localObject = com.tencent.mm.plugin.voip_cs.c.c.dYh();
        ad.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.zns + "roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.sAY);
        com.tencent.mm.kernel.g.aeS().a(285, (com.tencent.mm.al.g)localObject);
        localObject = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE;
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.d(((v2protocal)localObject).zns, ((v2protocal)localObject).sAY);
        com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject, 0);
        AppMethodBeat.o(190837);
      }
    };
    AppMethodBeat.o(125458);
  }
  
  private void dYD()
  {
    AppMethodBeat.i(125460);
    if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV <= 0)
    {
      this.zDH.dYs();
      this.zDH.dYt();
      com.tencent.mm.plugin.voip_cs.c.c.dYg().init();
      com.tencent.mm.plugin.voip_cs.c.c.dYh().aE(this.zCW, this.appId, this.zDL);
    }
    if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV < 2) {
      this.zDc.dYr();
    }
    this.zDH.dYw();
    AppMethodBeat.o(125460);
  }
  
  private boolean dYE()
  {
    AppMethodBeat.i(125471);
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", ""))
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
    ad.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this });
    if (!bool)
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    AppMethodBeat.o(125471);
    return true;
  }
  
  public final void QZ(int paramInt)
  {
    AppMethodBeat.i(125468);
    ad.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + paramInt + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV);
    if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV == 0)
    {
      finish();
      AppMethodBeat.o(125468);
      return;
    }
    if (this.zDH != null) {
      this.zDH.Rc(paramInt);
    }
    AppMethodBeat.o(125468);
  }
  
  public final void cGI()
  {
    Object localObject2 = null;
    AppMethodBeat.i(125473);
    this.zDH.cGI();
    this.zDI.Mu();
    Object localObject1 = this.zDI;
    if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).nPF != null)
    {
      localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).nPF;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((com.tencent.mm.audio.b.c)localObject1).Ok());
        com.tencent.mm.plugin.voip_cs.c.c.dYi().zCu = 1;
        if (!d.g.b.k.g(localObject1, Boolean.TRUE)) {
          break label230;
        }
      }
    }
    com.tencent.mm.plugin.voip_cs.a.a locala;
    label230:
    for (int i = 1;; i = -1)
    {
      com.tencent.mm.plugin.voip_cs.c.c.dYi().zCN = i;
      locala = this.zDI;
      if (locala.zjI != null) {
        break label235;
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.dYg();
      d.g.b.k.g(localObject1, "SubCoreVoipCS.getVoipCSEngine()");
      ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).zDE.znI = Math.abs(1);
      this.zDc.stopRing();
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).zCI != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).zCx = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).zCI);
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
      ad.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).zCL == 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).zCL = ((int)(System.currentTimeMillis() / 1000L));
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
      ad.d("MicroMsg.VoipCSReportHelper", "markConnect");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).zCK != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).zCz = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).zCK);
      }
      AppMethodBeat.o(125473);
      return;
      localObject1 = null;
      break;
    }
    label235:
    com.tencent.mm.plugin.voip.model.c localc = locala.zjI;
    localObject1 = localObject2;
    if (localc != null) {
      localObject1 = Integer.valueOf(localc.dRU());
    }
    localObject2 = locala.zjI;
    if (localObject2 != null) {}
    for (i = ((com.tencent.mm.plugin.voip.model.c)localObject2).dRU();; i = 0)
    {
      if (i <= 0)
      {
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.dYg();
        d.g.b.k.g(localObject2, "SubCoreVoipCS.getVoipCSEngine()");
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject2).zDE.znI = Math.abs(1);
      }
      if (localObject1 == null) {
        break;
      }
      ((Integer)localObject1).intValue();
      break;
    }
  }
  
  public final void dYC()
  {
    AppMethodBeat.i(125474);
    ad.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
    this.zDH.Rc(5);
    AppMethodBeat.o(125474);
  }
  
  public int getLayoutId()
  {
    return 2131495878;
  }
  
  public final void jx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125470);
    com.tencent.mm.plugin.voip_cs.c.a.b localb = this.zDH;
    if ((localb.zDu.equals("")) && (bt.isNullOrNil(paramString2))) {
      if (localb.zDd.zDM) {
        localb.frs.setText(2131764818);
      }
    }
    while ((localb.zDt.equals("")) && (bt.isNullOrNil(paramString1)) && ((localb.zDd.itN == null) || (localb.zDd.itN.equals(""))))
    {
      localb.zDj.setImageResource(2131231875);
      AppMethodBeat.o(125470);
      return;
      localb.frs.setText(2131764817);
      continue;
      localb.setNickName(paramString2);
    }
    SharedPreferences localSharedPreferences = aj.eFE();
    if ((!bt.isNullOrNil(paramString1)) && (!localb.zDt.equals(paramString1)))
    {
      localb.atn(paramString1);
      localSharedPreferences.edit().putString(localb.dYu(), paramString1).commit();
    }
    if ((!bt.isNullOrNil(paramString2)) && (!localb.zDu.equals(paramString2)))
    {
      localb.setNickName(paramString2);
      localSharedPreferences.edit().putString(localb.dYv(), paramString2).commit();
    }
    AppMethodBeat.o(125470);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125459);
    ad.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
    super.onCreate(paramBundle);
    hideTitleView();
    this.zCW = getIntent().getStringExtra("voipCSBizId");
    this.appId = getIntent().getStringExtra("voipCSAppId");
    this.scene = bt.nullAsNil(getIntent().getStringExtra("voipCSScene"));
    this.type = bt.nullAsNil(getIntent().getStringExtra("voipCSType"));
    this.zDJ = getIntent().getStringExtra("voipCSAllowBackCamera");
    this.zDK = getIntent().getStringExtra("voipCSShowOther");
    this.itN = getIntent().getStringExtra("voipCSAvatarUrl");
    this.zDL = getIntent().getStringExtra("voipCSContext");
    this.zDM = getIntent().getBooleanExtra("launch_from_appbrand", false);
    getWindow().addFlags(6946944);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(67108864);
    }
    this.gAC = new ap();
    paramBundle = com.tencent.mm.plugin.voip_cs.c.c.dYi();
    ad.d("MicroMsg.VoipCSReportHelper", "reset");
    paramBundle.dataType = 0;
    paramBundle.zBY = 0;
    paramBundle.zBZ = 0;
    paramBundle.zCa = 0;
    paramBundle.videoFps = 0;
    paramBundle.zCb = 0;
    paramBundle.zCc = 0;
    paramBundle.zCd = 0;
    paramBundle.zCe = 0;
    paramBundle.zCf = 0;
    paramBundle.zCg = 0;
    paramBundle.networkType = 0;
    paramBundle.zCh = 0;
    paramBundle.zCi = com.tencent.mm.plugin.voip_cs.c.d.zBV;
    paramBundle.zCj = 0;
    paramBundle.roomId = 0L;
    paramBundle.sAY = 0L;
    paramBundle.zCk = "";
    paramBundle.znq = 0;
    paramBundle.zCn = 0;
    paramBundle.zCo = 0;
    paramBundle.zCp = 0;
    paramBundle.znM = 0;
    paramBundle.znL = 0;
    paramBundle.zCq = 0;
    paramBundle.zCr = 0;
    paramBundle.zCs = 0;
    paramBundle.zCt = 0;
    paramBundle.zCu = 0;
    paramBundle.zCv = 0;
    paramBundle.zCw = 0L;
    paramBundle.zCx = 0;
    paramBundle.zCy = 0L;
    paramBundle.zCz = 0L;
    paramBundle.zCA = 0L;
    paramBundle.sCm = 0L;
    paramBundle.zCB = 0;
    paramBundle.zCC = 0;
    paramBundle.channelStrategy = 1;
    paramBundle.zpp = 0;
    paramBundle.znN = 0;
    paramBundle.zCD = 0;
    paramBundle.zCE = 0;
    paramBundle.sCw = "";
    paramBundle.sCv = "";
    paramBundle.zCI = 0;
    paramBundle.zCJ = 0;
    paramBundle.zCK = 0;
    paramBundle.zCL = 0;
    paramBundle.zCM = 0;
    this.szx = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    com.tencent.mm.plugin.voip_cs.c.c.dYh().zCW = this.zCW;
    this.zDH = new com.tencent.mm.plugin.voip_cs.c.a.b(this);
    this.zDI = new com.tencent.mm.plugin.voip_cs.a.a();
    this.cST = new com.tencent.mm.compatible.util.b(aj.getContext());
    this.zDc = com.tencent.mm.plugin.voip_cs.c.a.a.dYp();
    com.tencent.mm.plugin.voip_cs.c.c.dYg().zDF = this;
    com.tencent.mm.plugin.voip_cs.c.c.dYh().zCO = this;
    if ((com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV == 0) || (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV == 3)) {
      com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV = 0;
    }
    com.tencent.mm.booter.a.Ti().Tk();
    this.cST.requestFocus();
    this.zDI.Mu();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.USER_PRESENT");
    aj.getContext().registerReceiver(this.zhY, paramBundle);
    com.tencent.mm.kernel.g.afA().a(this.yIx);
    if (this.zDM) {
      if (this.scene.equals("1")) {
        if (this.type.equals("video"))
        {
          this.title = aj.getContext().getString(2131764829);
          this.tickerText = aj.getContext().getString(2131764833);
          this.doh = aj.getContext().getString(2131764833);
          i = this.szx.getCallState();
          if ((i != 2) && (i != 1)) {
            break label1134;
          }
          ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
          h.a(this, 2131764843, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125440);
              paramAnonymousDialogInterface.dismiss();
              VoipCSMainUI.this.QZ(0);
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
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
      AppMethodBeat.o(125459);
      return;
      this.title = aj.getContext().getString(2131764830);
      this.tickerText = aj.getContext().getString(2131764834);
      this.doh = aj.getContext().getString(2131764834);
      break;
      if (this.type.equals("video"))
      {
        this.title = aj.getContext().getString(2131764831);
        this.tickerText = aj.getContext().getString(2131764835);
        this.doh = aj.getContext().getString(2131764835);
        break;
      }
      this.title = aj.getContext().getString(2131764830);
      this.tickerText = aj.getContext().getString(2131764834);
      this.doh = aj.getContext().getString(2131764834);
      break;
      if (this.scene.equals("1"))
      {
        if (this.type.equals("video"))
        {
          this.title = aj.getContext().getString(2131764829);
          this.tickerText = aj.getContext().getString(2131764833);
          this.doh = aj.getContext().getString(2131764833);
          break;
        }
        this.title = aj.getContext().getString(2131764830);
        this.tickerText = aj.getContext().getString(2131764837);
        this.doh = aj.getContext().getString(2131764837);
        break;
      }
      if (this.type.equals("video"))
      {
        this.title = aj.getContext().getString(2131764831);
        this.tickerText = aj.getContext().getString(2131764837);
        this.doh = aj.getContext().getString(2131764837);
        break;
      }
      this.title = aj.getContext().getString(2131764830);
      this.tickerText = aj.getContext().getString(2131764836);
      this.doh = aj.getContext().getString(2131764836);
      break;
    }
    label1139:
    this.szx.listen(this.klv, 32);
    if (!ay.isNetworkConnected(this))
    {
      ad.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
      h.a(this, 2131764839, 2131764899, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125454);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.QZ(9);
          AppMethodBeat.o(125454);
        }
      });
      i = 0;
    }
    while (i == 0)
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
      AppMethodBeat.o(125459);
      return;
      if ((ay.isWifi(this)) || (s.dTX()))
      {
        i = 1;
      }
      else
      {
        ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
        h.a(this, 2131764840, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125455);
            ad.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
            s.dTW();
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
            ad.i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.QZ(8);
            AppMethodBeat.o(125456);
          }
        });
        i = 0;
      }
    }
    if (com.tencent.mm.plugin.voip.b.k.isVoipStarted())
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
      h.a(this, 2131760336, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125450);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.QZ(0);
          AppMethodBeat.o(125450);
        }
      });
      i = 1;
    }
    while (i != 0)
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
      AppMethodBeat.o(125459);
      return;
      if (com.tencent.mm.plugin.voip.b.k.dWP())
      {
        ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
        h.a(this, 2131760337, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125451);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.QZ(0);
            AppMethodBeat.o(125451);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.r.a.aad())
      {
        ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
        h.a(this, 2131760331, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125452);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.QZ(0);
            AppMethodBeat.o(125452);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.bi.e.aCj())
      {
        ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
        h.a(this, 2131760332, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125453);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.QZ(0);
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
    if (dYE()) {
      dYD();
    }
    AppMethodBeat.o(125459);
  }
  
  public void onDestroy()
  {
    int j = 2;
    AppMethodBeat.i(125467);
    ad.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
    if (this.cST != null) {
      this.cST.XF();
    }
    Object localObject1 = new uo();
    Object localObject2;
    Object localObject3;
    if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCX == -1)
    {
      ((uo)localObject1).dAg.status = 3;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = this.zDI;
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).zjI == null) {
        break label1208;
      }
      localObject3 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
      d.g.b.k.g(localObject3, "SubCoreVoipCS.getReporter()");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).zCu != 1) {
        break label1208;
      }
      localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).zjI;
      if (localObject3 == null) {
        d.g.b.k.fvU();
      }
    }
    label301:
    label1198:
    label1203:
    label1208:
    for (int i = ((com.tencent.mm.plugin.voip.model.c)localObject3).aDs();; i = 0)
    {
      float f = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamMaxVolume(i);
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).zCE = ((int)(((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamVolume(i) / f * 100.0F));
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
      label213:
      label748:
      byte[] arrayOfByte;
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).nPF != null)
      {
        localObject3 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
        d.g.b.k.g(localObject3, "SubCoreVoipCS.getReporter()");
        if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).zCu == 1)
        {
          localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).nPF;
          if (localObject3 == null) {
            d.g.b.k.fvU();
          }
          i = ((com.tencent.mm.audio.b.c)localObject3).On();
          ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).znN = i;
          localObject2 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).nPF;
          if (localObject2 != null) {
            ((com.tencent.mm.audio.b.c)localObject2).Ob();
          }
          localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).zjI;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.voip.model.c)localObject1).dRW();
          }
          this.zDc.stopRing();
          if (this.zDH != null)
          {
            localObject1 = this.zDH;
            if (com.tencent.mm.plugin.voip_cs.c.c.dYi().dataType == 0)
            {
              if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV >= 2) {
                break label1158;
              }
              com.tencent.mm.plugin.voip_cs.c.c.dYi().dataType = 1;
            }
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).zsj.dXg();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).zsk.dXg();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).dYx();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).dYA();
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.dYh();
            ad.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            com.tencent.mm.kernel.g.aeS().b(823, (com.tencent.mm.al.g)localObject1);
            com.tencent.mm.kernel.g.aeS().b(106, (com.tencent.mm.al.g)localObject1);
            com.tencent.mm.kernel.g.aeS().b(818, (com.tencent.mm.al.g)localObject1);
            com.tencent.mm.kernel.g.aeS().b(795, (com.tencent.mm.al.g)localObject1);
            com.tencent.mm.kernel.g.aeS().b(285, (com.tencent.mm.al.g)localObject1);
            com.tencent.mm.kernel.g.aeS().b(312, (com.tencent.mm.al.g)localObject1);
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCV = 3;
            if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCX != 823)
            {
              com.tencent.mm.kernel.g.aeS().a(880, (com.tencent.mm.al.g)localObject1);
              if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCQ != 0) {
                break label1168;
              }
              i = 1;
              label444:
              ad.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCW + ",inviteId：" + com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.sBa + ",csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.zns + ",roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.sAY + ",reason:" + i);
              localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.a(com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.sBa, com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.zns, com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.sAY, ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCW, i);
              com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject2, 0);
            }
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCZ.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zDa.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCP = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCl = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCQ = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCR = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCS = null;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).sBh = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCT = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCV = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCW = "";
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCU = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCX = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCY = 999;
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.dYg();
            ad.i("MicroMsg.VoipCSEngine", "now stop engine");
            ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).zDE.rG(true);
            localObject2 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
            if ((bt.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).sCw)) && (bt.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).sCv)))
            {
              localObject3 = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE;
              if (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).zCs != 1) {
                break label1198;
              }
              i = 1;
              arrayOfByte = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).zBM;
              j = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).zBM.length;
              if (i == 0) {
                break label1203;
              }
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).getVoipcsChannelInfo(arrayOfByte, j, i);
        ad.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength) });
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).sCw = new String(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).zBM, 0, ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength);
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).sCv = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.dYd();
        ad.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).sCw });
        ad.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).sCv });
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.dYh();
        com.tencent.mm.kernel.g.aeS().a(312, (com.tencent.mm.al.g)localObject2);
        localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.e(com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.zns, com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.sAY);
        com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject2, 0);
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).zDE.reset();
        r.dTT().dTV();
        r.dTT().a(null);
        this.zDH = null;
        localObject1 = this.zDI;
        com.tencent.mm.plugin.audio.b.a.a((com.tencent.mm.plugin.audio.b.a)localObject1, 0);
        ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).Oc("voipcs");
        aj.getContext().unregisterReceiver(this.zhY);
        com.tencent.mm.kernel.g.afA().b(this.yIx);
        if (this.zDN != null) {
          this.zDN.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        if ((this.szx != null) && (this.klv != null))
        {
          this.szx.listen(this.klv, 0);
          this.klv = null;
        }
        com.tencent.mm.plugin.voip_cs.a.a.NX();
        this.zDI = null;
        super.onDestroy();
        AppMethodBeat.o(125467);
        return;
        if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCX == 823)
        {
          ((uo)localObject1).dAg.status = 4;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV <= 1)
        {
          ((uo)localObject1).dAg.status = 1;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV < 2) {
          break;
        }
        ((uo)localObject1).dAg.status = 2;
        break;
        i = 0;
        break label213;
        com.tencent.mm.plugin.voip_cs.c.c.dYi().dataType = 3;
        break label301;
        i = j;
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCQ == 2) {
          break label444;
        }
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).zCQ == 3)
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
    if (this.zDH != null)
    {
      ad.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(paramInt)));
      this.zDH.Rc(paramInt);
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
      paramInt = this.zDI.sc(this.zDc.cSx());
      this.zDI.vP(paramInt);
      AppMethodBeat.o(125461);
      return true;
    }
    if (paramInt == 24)
    {
      paramInt = this.zDI.sc(this.zDc.cSx());
      this.zDI.vO(paramInt);
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
    if (!this.zDc.cSx()) {
      this.zDc.stopRing();
    }
    if ((com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV == 1) || (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV == 2))
    {
      Object localObject = new Intent(aj.getContext(), VoipCSMainUI.class);
      ((Intent)localObject).putExtra("voipCSBizId", this.zCW);
      ((Intent)localObject).putExtra("voipCSAppId", this.appId);
      ((Intent)localObject).putExtra("voipCSScene", this.scene);
      ((Intent)localObject).putExtra("voipCSType", this.type);
      ((Intent)localObject).putExtra("voipCSAllowBackCamera", this.zDJ);
      ((Intent)localObject).putExtra("voipCSShowOther", this.zDK);
      ((Intent)localObject).putExtra("voipCSAvatarUrl", this.itN);
      ((Intent)localObject).putExtra("voipCSContext", this.zDL);
      ((Intent)localObject).putExtra("launch_from_appbrand", this.zDM);
      localObject = PendingIntent.getActivity(aj.getContext(), 44, (Intent)localObject, 134217728);
      s.c localc = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(this.tickerText).g(System.currentTimeMillis()).f(this.title).g(this.doh);
      localc.Ew = ((PendingIntent)localObject);
      localc.f(2, true);
      localObject = localc.build();
      ((Notification)localObject).icon = com.tencent.mm.br.a.cYf();
      ((Notification)localObject).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
      if ((this.zDN != null) && (this.zDN.eFX())) {
        this.zDN.av(5000L, 5000L);
      }
    }
    for (;;)
    {
      this.zDH.dYx();
      this.zDH.dkt = true;
      AppMethodBeat.o(125464);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
      if (this.zDN != null) {
        this.zDN.stopTimer();
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(125472);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      ad.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(125472);
      return;
    }
    ad.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(125472);
      return;
    case 82: 
      if (paramArrayOfInt[0] == 0)
      {
        ad.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
          dYD();
        }
        AppMethodBeat.o(125472);
        return;
      }
      h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131755691), false, new VoipCSMainUI.4(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190836);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.QZ(2);
          AppMethodBeat.o(190836);
        }
      });
      AppMethodBeat.o(125472);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      dYD();
      AppMethodBeat.o(125472);
      return;
    }
    if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
    for (paramInt = 2131761860;; paramInt = 2131761871)
    {
      h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new VoipCSMainUI.6(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125446);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.QZ(3);
          AppMethodBeat.o(125446);
        }
      });
      break;
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(125465);
    ad.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
    super.onRestart();
    if ((dYE()) && (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV <= 1)) {
      dYD();
    }
    if (this.zDH != null) {
      this.zDH.dkt = false;
    }
    AppMethodBeat.o(125465);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125463);
    ad.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
    super.onResume();
    if (this.zDH != null)
    {
      this.zDH.dkt = false;
      if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV > 1)
      {
        dYD();
        if ((this.zDK != null) && (this.zDK.equals("1"))) {
          this.zDH.dYz();
        }
      }
    }
    if (this.zDN != null) {
      this.zDN.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI
 * JD-Core Version:    0.7.0.1
 */