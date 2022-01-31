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
import android.support.v4.app.s.c;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.model.an;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.b.b.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class VoipCSMainUI
  extends MMActivity
  implements com.tencent.mm.plugin.voip_cs.b.b, a.a
{
  private String appId;
  public String bSd;
  private com.tencent.mm.compatible.util.b cko;
  public String cyA;
  private ak faV;
  public String gGm;
  private TelephonyManager nLF;
  PhoneStateListener nLG;
  private n qwx;
  public String tKP;
  private com.tencent.mm.plugin.voip_cs.b.a.a tKV;
  private com.tencent.mm.plugin.voip_cs.b.a.b tLB;
  private com.tencent.mm.plugin.voip_cs.b.a.c tLC;
  private boolean tLD;
  public String tLE;
  public String tLF;
  public String tLG;
  public boolean tLH;
  private ap tLI;
  g.a tLJ;
  public CharSequence tickerText;
  public CharSequence title;
  private HeadsetPlugReceiver txb;
  private BroadcastReceiver tyk;
  private HeadsetPlugReceiver.a tyl;
  public String type;
  
  public VoipCSMainUI()
  {
    AppMethodBeat.i(135407);
    this.tLD = false;
    this.txb = null;
    this.tKP = "";
    this.appId = "";
    this.gGm = "";
    this.tLE = "";
    this.tLF = "";
    this.tLG = "";
    this.bSd = "";
    this.type = "";
    this.tLH = false;
    this.cyA = ah.getContext().getString(2131304661);
    this.tickerText = ah.getContext().getString(2131304661);
    this.title = ah.getContext().getString(2131304655);
    this.tLI = new ap(Looper.getMainLooper(), new VoipCSMainUI.18(this), true);
    this.tLJ = new VoipCSMainUI.2(this);
    this.tyl = new VoipCSMainUI.3(this);
    this.tyk = new VoipCSMainUI.4(this);
    this.nLG = new VoipCSMainUI.5(this);
    this.qwx = new VoipCSMainUI.10(this);
    AppMethodBeat.o(135407);
  }
  
  private int bJG()
  {
    int i = 2;
    AppMethodBeat.i(135411);
    if (com.tencent.mm.compatible.b.g.KC().KH()) {
      i = com.tencent.mm.compatible.b.g.KC().KU();
    }
    for (;;)
    {
      ab.d("MicroMsg.voipcs.VoipCSMainUI", "Current StreamType:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(135411);
      return i;
      if (this.tKV.cOm()) {
        if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO == 2) {
          i = 0;
        } else {
          i = this.tLC.cLL();
        }
      }
    }
  }
  
  private void cQH()
  {
    AppMethodBeat.i(135409);
    if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO <= 0)
    {
      this.tLB.cQx();
      this.tLB.cQy();
      com.tencent.mm.plugin.voip_cs.b.c.cQm().init();
      com.tencent.mm.plugin.voip_cs.b.c.cQn().as(this.tKP, this.appId, this.tLG);
    }
    if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO < 2) {
      this.tKV.cQw();
    }
    this.tLB.cQB();
    AppMethodBeat.o(135409);
  }
  
  private boolean cQI()
  {
    AppMethodBeat.i(135420);
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", ""))
    {
      ab.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
      AppMethodBeat.o(135420);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
    ab.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      ab.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
      AppMethodBeat.o(135420);
      return false;
    }
    AppMethodBeat.o(135420);
    return true;
  }
  
  public final void Ic(int paramInt)
  {
    AppMethodBeat.i(135417);
    ab.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + paramInt + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO);
    if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO == 0)
    {
      finish();
      AppMethodBeat.o(135417);
      return;
    }
    if (this.tLB != null) {
      this.tLB.If(paramInt);
    }
    AppMethodBeat.o(135417);
  }
  
  public final void bIN()
  {
    AppMethodBeat.i(135422);
    this.tLB.bIN();
    Object localObject;
    int i;
    if ((com.tencent.mm.compatible.b.g.KC().KN()) || (com.tencent.mm.compatible.b.g.KC().KH()))
    {
      this.tLC.mR(false);
      localObject = this.tLC;
      if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).kJB == null) {
        break label227;
      }
      boolean bool = ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).kJB.EC();
      com.tencent.mm.plugin.voip_cs.b.c.cQo().tKn = 1;
      if (!bool) {
        break label227;
      }
      i = 1;
      label72:
      com.tencent.mm.plugin.voip_cs.b.c.cQo().tKG = i;
      localObject = this.tLC;
      if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).tvF != null) {
        break label232;
      }
      com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.tAq = Math.abs(1);
    }
    for (;;)
    {
      this.tKV.stopRing();
      localObject = com.tencent.mm.plugin.voip_cs.b.c.cQo();
      if (((com.tencent.mm.plugin.voip_cs.b.d)localObject).tKB != 0) {
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject).tKq = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.b.d)localObject).tKB);
      }
      localObject = com.tencent.mm.plugin.voip_cs.b.c.cQo();
      ab.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
      if (((com.tencent.mm.plugin.voip_cs.b.d)localObject).tKE == 0) {
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject).tKE = ((int)(System.currentTimeMillis() / 1000L));
      }
      localObject = com.tencent.mm.plugin.voip_cs.b.c.cQo();
      ab.d("MicroMsg.VoipCSReportHelper", "markConnect");
      if (((com.tencent.mm.plugin.voip_cs.b.d)localObject).tKD != 0) {
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject).tKs = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.b.d)localObject).tKD);
      }
      AppMethodBeat.o(135422);
      return;
      this.tLC.mR(true);
      break;
      label227:
      i = -1;
      break label72;
      label232:
      ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).tvF.cLH();
      if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).tvF.cLH() <= 0) {
        com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.tAq = Math.abs(1);
      }
    }
  }
  
  public final void cQG()
  {
    AppMethodBeat.i(135423);
    ab.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
    this.tLB.If(5);
    AppMethodBeat.o(135423);
  }
  
  public final void gU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(135419);
    com.tencent.mm.plugin.voip_cs.b.a.b localb = this.tLB;
    if ((localb.tLn.equals("")) && (bo.isNullOrNil(paramString2))) {
      if (localb.tKW.tLH) {
        localb.egr.setText(2131304642);
      }
    }
    while ((localb.tLm.equals("")) && (bo.isNullOrNil(paramString1)) && ((localb.tKW.gGm == null) || (localb.tKW.gGm.equals(""))))
    {
      localb.tLc.setImageResource(2130838493);
      AppMethodBeat.o(135419);
      return;
      localb.egr.setText(2131304641);
      continue;
      localb.aeL(paramString2);
    }
    SharedPreferences localSharedPreferences = ah.dsQ();
    if ((!bo.isNullOrNil(paramString1)) && (!localb.tLm.equals(paramString1)))
    {
      localb.aeM(paramString1);
      localSharedPreferences.edit().putString(localb.cQz(), paramString1).commit();
    }
    if ((!bo.isNullOrNil(paramString2)) && (!localb.tLn.equals(paramString2)))
    {
      localb.aeL(paramString2);
      localSharedPreferences.edit().putString(localb.cQA(), paramString2).commit();
    }
    AppMethodBeat.o(135419);
  }
  
  public int getLayoutId()
  {
    return 2130971108;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(135408);
    ab.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
    super.onCreate(paramBundle);
    hideTitleView();
    this.tKP = getIntent().getStringExtra("voipCSBizId");
    this.appId = getIntent().getStringExtra("voipCSAppId");
    this.bSd = bo.nullAsNil(getIntent().getStringExtra("voipCSScene"));
    this.type = bo.nullAsNil(getIntent().getStringExtra("voipCSType"));
    this.tLE = getIntent().getStringExtra("voipCSAllowBackCamera");
    this.tLF = getIntent().getStringExtra("voipCSShowOther");
    this.gGm = getIntent().getStringExtra("voipCSAvatarUrl");
    this.tLG = getIntent().getStringExtra("voipCSContext");
    this.tLH = getIntent().getBooleanExtra("launch_from_appbrand", false);
    getWindow().addFlags(6946944);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(67108864);
    }
    this.faV = new ak();
    paramBundle = com.tencent.mm.plugin.voip_cs.b.c.cQo();
    ab.d("MicroMsg.VoipCSReportHelper", "reset");
    paramBundle.dataType = 0;
    paramBundle.tJQ = 0;
    paramBundle.tJR = 0;
    paramBundle.tJS = 0;
    paramBundle.videoFps = 0;
    paramBundle.tJT = 0;
    paramBundle.tJU = 0;
    paramBundle.tJV = 0;
    paramBundle.tJW = 0;
    paramBundle.tJX = 0;
    paramBundle.tJY = 0;
    paramBundle.networkType = 0;
    paramBundle.tJZ = 0;
    paramBundle.tKa = com.tencent.mm.plugin.voip_cs.b.d.tJO;
    paramBundle.tKb = 0;
    paramBundle.tKc = 0L;
    paramBundle.nNa = 0L;
    paramBundle.tKd = "";
    paramBundle.tzZ = 0;
    paramBundle.tKg = 0;
    paramBundle.tKh = 0;
    paramBundle.tKi = 0;
    paramBundle.tAu = 0;
    paramBundle.tAt = 0;
    paramBundle.tKj = 0;
    paramBundle.tKk = 0;
    paramBundle.tKl = 0;
    paramBundle.tKm = 0;
    paramBundle.tKn = 0;
    paramBundle.tKo = 0;
    paramBundle.tKp = 0L;
    paramBundle.tKq = 0;
    paramBundle.tKr = 0L;
    paramBundle.tKs = 0L;
    paramBundle.tKt = 0L;
    paramBundle.nOr = 0L;
    paramBundle.tKu = 0;
    paramBundle.tKv = 0;
    paramBundle.channelStrategy = 1;
    paramBundle.tBM = 0;
    paramBundle.tAv = 0;
    paramBundle.tKw = 0;
    paramBundle.tKx = 0;
    paramBundle.nOB = "";
    paramBundle.nOA = "";
    paramBundle.tKB = 0;
    paramBundle.tKC = 0;
    paramBundle.tKD = 0;
    paramBundle.tKE = 0;
    paramBundle.tKF = 0;
    this.nLF = ((TelephonyManager)ah.getContext().getSystemService("phone"));
    com.tencent.mm.plugin.voip_cs.b.c.cQn().tKP = this.tKP;
    this.tLB = new com.tencent.mm.plugin.voip_cs.b.a.b(this);
    this.tLC = new com.tencent.mm.plugin.voip_cs.b.a.c();
    this.cko = new com.tencent.mm.compatible.util.b(ah.getContext());
    this.tKV = com.tencent.mm.plugin.voip_cs.b.a.a.cQu();
    com.tencent.mm.plugin.voip_cs.b.c.cQm().tLz = this;
    com.tencent.mm.plugin.voip_cs.b.c.cQn().tKH = this;
    if ((com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO == 0) || (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO == 3)) {
      com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO = 0;
    }
    com.tencent.mm.booter.a.Ia().Ic();
    this.cko.requestFocus();
    com.tencent.mm.compatible.b.g.KC().KE();
    com.tencent.mm.compatible.b.g.KC().a(this.tLJ);
    this.txb = new HeadsetPlugReceiver();
    this.txb.a(ah.getContext(), this.tyl);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.USER_PRESENT");
    ah.getContext().registerReceiver(this.tyk, paramBundle);
    com.tencent.mm.kernel.g.RK().a(this.qwx);
    if (this.tLH) {
      if (this.bSd.equals("1")) {
        if (this.type.equals("video"))
        {
          this.title = ah.getContext().getString(2131304653);
          this.tickerText = ah.getContext().getString(2131304657);
          this.cyA = ah.getContext().getString(2131304657);
          i = this.nLF.getCallState();
          if ((i != 2) && (i != 1)) {
            break label1169;
          }
          ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
          h.a(this, 2131304667, 2131297087, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(135389);
              paramAnonymousDialogInterface.dismiss();
              VoipCSMainUI.this.Ic(0);
              AppMethodBeat.o(135389);
            }
          });
        }
      }
    }
    label1169:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label1174;
      }
      ab.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
      AppMethodBeat.o(135408);
      return;
      this.title = ah.getContext().getString(2131304654);
      this.tickerText = ah.getContext().getString(2131304658);
      this.cyA = ah.getContext().getString(2131304658);
      break;
      if (this.type.equals("video"))
      {
        this.title = ah.getContext().getString(2131304655);
        this.tickerText = ah.getContext().getString(2131304659);
        this.cyA = ah.getContext().getString(2131304659);
        break;
      }
      this.title = ah.getContext().getString(2131304654);
      this.tickerText = ah.getContext().getString(2131304658);
      this.cyA = ah.getContext().getString(2131304658);
      break;
      if (this.bSd.equals("1"))
      {
        if (this.type.equals("video"))
        {
          this.title = ah.getContext().getString(2131304653);
          this.tickerText = ah.getContext().getString(2131304657);
          this.cyA = ah.getContext().getString(2131304657);
          break;
        }
        this.title = ah.getContext().getString(2131304654);
        this.tickerText = ah.getContext().getString(2131304661);
        this.cyA = ah.getContext().getString(2131304661);
        break;
      }
      if (this.type.equals("video"))
      {
        this.title = ah.getContext().getString(2131304655);
        this.tickerText = ah.getContext().getString(2131304661);
        this.cyA = ah.getContext().getString(2131304661);
        break;
      }
      this.title = ah.getContext().getString(2131304654);
      this.tickerText = ah.getContext().getString(2131304660);
      this.cyA = ah.getContext().getString(2131304660);
      break;
    }
    label1174:
    this.nLF.listen(this.nLG, 32);
    if (!at.isNetworkConnected(this))
    {
      ab.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
      h.a(this, 2131304663, 2131304717, new VoipCSMainUI.15(this));
      i = 0;
    }
    while (i == 0)
    {
      ab.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
      AppMethodBeat.o(135408);
      return;
      if ((at.isWifi(this)) || (r.cNv()))
      {
        i = 1;
      }
      else
      {
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
        h.a(this, 2131304664, 2131304717, new VoipCSMainUI.16(this), new VoipCSMainUI.17(this));
        i = 0;
      }
    }
    if (com.tencent.mm.plugin.voip.a.d.isVoipStarted())
    {
      ab.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
      h.a(this, 2131300735, 2131297087, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(135399);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.Ic(0);
          AppMethodBeat.o(135399);
        }
      });
      i = 1;
    }
    while (i != 0)
    {
      ab.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
      AppMethodBeat.o(135408);
      return;
      if (com.tencent.mm.plugin.voip.a.d.cPu())
      {
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
        h.a(this, 2131300736, 2131297087, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(135400);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.Ic(0);
            AppMethodBeat.o(135400);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.r.a.Ok())
      {
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
        h.a(this, 2131300730, 2131297087, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(135401);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.Ic(0);
            AppMethodBeat.o(135401);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.bg.e.ald())
      {
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
        h.a(this, 2131300731, 2131297087, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(135402);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.Ic(0);
            AppMethodBeat.o(135402);
          }
        });
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    if (cQI()) {
      cQH();
    }
    AppMethodBeat.o(135408);
  }
  
  public void onDestroy()
  {
    int j = 2;
    AppMethodBeat.i(135416);
    ab.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
    if (this.cko != null) {
      this.cko.Mh();
    }
    Object localObject1 = new sr();
    Object localObject2;
    if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKQ == -1)
    {
      ((sr)localObject1).cJm.status = 3;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = this.tLC;
      localObject2 = com.tencent.mm.plugin.voip_cs.b.c.cQo();
      if ((((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).tvF == null) || (com.tencent.mm.plugin.voip_cs.b.c.cQo().tKn != 1)) {
        break label1177;
      }
    }
    label396:
    label1167:
    label1172:
    label1177:
    for (int i = ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).tvF.cLL();; i = 0)
    {
      float f = com.tencent.mm.compatible.b.g.KC().getStreamMaxVolume(i);
      ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).tKx = ((int)(com.tencent.mm.compatible.b.g.KC().getStreamVolume(i) / f * 100.0F));
      localObject2 = com.tencent.mm.plugin.voip_cs.b.c.cQo();
      label167:
      label253:
      com.tencent.mm.plugin.voip_cs.b.a locala;
      label700:
      byte[] arrayOfByte;
      if ((((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).kJB != null) && (com.tencent.mm.plugin.voip_cs.b.c.cQo().tKn == 1))
      {
        i = ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).kJB.EF();
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).tAv = i;
        if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).kJB != null) {
          ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).kJB.Et();
        }
        if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).tvF != null) {
          ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).tvF.cLJ();
        }
        this.tKV.stopRing();
        if (this.tLB != null)
        {
          localObject1 = this.tLB;
          if (com.tencent.mm.plugin.voip_cs.b.c.cQo().dataType == 0)
          {
            if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO >= 2) {
              break label1127;
            }
            com.tencent.mm.plugin.voip_cs.b.c.cQo().dataType = 1;
          }
          ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).tCZ.cPF();
          ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).tDa.cPF();
          ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).cQC();
          ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).cQF();
          localObject1 = com.tencent.mm.plugin.voip_cs.b.c.cQn();
          ab.i("MicroMsg.voipcs.VoipCSService", "now stop service");
          com.tencent.mm.kernel.g.Rc().b(823, (f)localObject1);
          com.tencent.mm.kernel.g.Rc().b(106, (f)localObject1);
          com.tencent.mm.kernel.g.Rc().b(818, (f)localObject1);
          com.tencent.mm.kernel.g.Rc().b(795, (f)localObject1);
          com.tencent.mm.kernel.g.Rc().b(285, (f)localObject1);
          com.tencent.mm.kernel.g.Rc().b(312, (f)localObject1);
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKO = 3;
          if (((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKQ != 823)
          {
            com.tencent.mm.kernel.g.Rc().a(880, (f)localObject1);
            if (((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKJ != 0) {
              break label1137;
            }
            i = 1;
            ab.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKP + ",inviteId：" + com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.nNc + ",csroomId:" + com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.tAb + ",roomkey:" + com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.nNa + ",reason:" + i);
            localObject2 = new com.tencent.mm.plugin.voip_cs.b.c.a(com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.nNc, com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.tAb, com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.nNa, ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKP, i);
            com.tencent.mm.kernel.g.Rc().a((m)localObject2, 0);
          }
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKS.stopTimer();
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKT.stopTimer();
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKI = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKe = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKJ = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKK = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKL = null;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).nNj = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKM = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKO = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKP = "";
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKN = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKQ = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKR = 999;
          localObject1 = com.tencent.mm.plugin.voip_cs.b.c.cQm();
          ab.i("MicroMsg.VoipCSEngine", "now stop engine");
          ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).tLy.mX(true);
          localObject2 = com.tencent.mm.plugin.voip_cs.b.c.cQo();
          if ((bo.isNullOrNil(((com.tencent.mm.plugin.voip_cs.b.d)localObject2).nOB)) && (bo.isNullOrNil(((com.tencent.mm.plugin.voip_cs.b.d)localObject2).nOA)))
          {
            locala = com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy;
            if (((com.tencent.mm.plugin.voip_cs.b.d)localObject2).tKl != 1) {
              break label1167;
            }
            i = 1;
            arrayOfByte = locala.tJF;
            j = locala.tJF.length;
            if (i == 0) {
              break label1172;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        locala.getVoipcsChannelInfo(arrayOfByte, j, i);
        ab.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(locala.field_voipcsChannelInfoLength) });
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).nOB = new String(locala.tJF, 0, locala.field_voipcsChannelInfoLength);
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).nOA = com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.cQj();
        ab.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).nOB });
        ab.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).nOA });
        localObject2 = com.tencent.mm.plugin.voip_cs.b.c.cQn();
        com.tencent.mm.kernel.g.Rc().a(312, (f)localObject2);
        localObject2 = new com.tencent.mm.plugin.voip_cs.b.c.e(com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.tAb, com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.nNa);
        com.tencent.mm.kernel.g.Rc().a((m)localObject2, 0);
        ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).tLy.reset();
        q.cNr().cNt();
        q.cNr().a(null);
        this.tLB = null;
        this.tLC = null;
        com.tencent.mm.compatible.b.g.KC().setMode(0);
        ah.getContext().unregisterReceiver(this.tyk);
        com.tencent.mm.compatible.b.g.KC().b(this.tLJ);
        com.tencent.mm.compatible.b.g.KC().KF();
        if (this.txb != null) {
          this.txb.fg(ah.getContext());
        }
        com.tencent.mm.kernel.g.RK().b(this.qwx);
        if (this.tLI != null) {
          this.tLI.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        if ((this.nLF != null) && (this.nLG != null))
        {
          this.nLF.listen(this.nLG, 0);
          this.nLG = null;
        }
        super.onDestroy();
        AppMethodBeat.o(135416);
        return;
        if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKQ == 823)
        {
          ((sr)localObject1).cJm.status = 4;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO <= 1)
        {
          ((sr)localObject1).cJm.status = 1;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO < 2) {
          break;
        }
        ((sr)localObject1).cJm.status = 2;
        break;
        i = 0;
        break label167;
        label1127:
        com.tencent.mm.plugin.voip_cs.b.c.cQo().dataType = 3;
        break label253;
        label1137:
        i = j;
        if (((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKJ == 2) {
          break label396;
        }
        if (((com.tencent.mm.plugin.voip_cs.b.e)localObject1).tKJ == 3)
        {
          i = 3;
          break label396;
        }
        i = 4;
        break label396;
        i = 0;
        break label700;
      }
    }
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(135418);
    if (this.tLB != null)
    {
      ab.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(paramInt)));
      this.tLB.If(paramInt);
    }
    AppMethodBeat.o(135418);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(135410);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      AppMethodBeat.o(135410);
      return true;
    }
    if (paramInt == 25)
    {
      paramInt = bJG();
      com.tencent.mm.compatible.b.g.KC().iG(paramInt);
      AppMethodBeat.o(135410);
      return true;
    }
    if (paramInt == 24)
    {
      paramInt = bJG();
      com.tencent.mm.compatible.b.g.KC().iF(paramInt);
      AppMethodBeat.o(135410);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(135410);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(135413);
    super.onPause();
    if (!this.tKV.cOm()) {
      this.tKV.stopRing();
    }
    if ((com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO == 1) || (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO == 2))
    {
      Object localObject = new Intent(ah.getContext(), VoipCSMainUI.class);
      ((Intent)localObject).putExtra("voipCSBizId", this.tKP);
      ((Intent)localObject).putExtra("voipCSAppId", this.appId);
      ((Intent)localObject).putExtra("voipCSScene", this.bSd);
      ((Intent)localObject).putExtra("voipCSType", this.type);
      ((Intent)localObject).putExtra("voipCSAllowBackCamera", this.tLE);
      ((Intent)localObject).putExtra("voipCSShowOther", this.tLF);
      ((Intent)localObject).putExtra("voipCSAvatarUrl", this.gGm);
      ((Intent)localObject).putExtra("voipCSContext", this.tLG);
      ((Intent)localObject).putExtra("launch_from_appbrand", this.tLH);
      localObject = PendingIntent.getActivity(ah.getContext(), 44, (Intent)localObject, 134217728);
      s.c localc = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(this.tickerText).g(System.currentTimeMillis()).e(this.title).f(this.cyA);
      localc.ya = ((PendingIntent)localObject);
      localc.g(2, true);
      localObject = localc.build();
      ((Notification)localObject).icon = com.tencent.mm.bp.a.bYt();
      ((Notification)localObject).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
      if ((this.tLI != null) && (this.tLI.dtj())) {
        this.tLI.ag(5000L, 5000L);
      }
    }
    for (;;)
    {
      this.tLB.cQC();
      this.tLB.cvo = true;
      AppMethodBeat.o(135413);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
      if (this.tLI != null) {
        this.tLI.stopTimer();
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135421);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      ab.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(135421);
      return;
    }
    ab.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(135421);
      return;
    case 82: 
      if (paramArrayOfInt[0] == 0)
      {
        ab.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
          cQH();
        }
        AppMethodBeat.o(135421);
        return;
      }
      h.a(this, getString(2131302075), getString(2131302083), getString(2131300996), getString(2131296888), false, new VoipCSMainUI.6(this), new VoipCSMainUI.7(this));
      AppMethodBeat.o(135421);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      cQH();
      AppMethodBeat.o(135421);
      return;
    }
    if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
    for (paramInt = 2131302067;; paramInt = 2131302075)
    {
      h.a(this, getString(paramInt), getString(2131302083), getString(2131300996), getString(2131296888), false, new VoipCSMainUI.8(this), new VoipCSMainUI.9(this));
      break;
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(135414);
    ab.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
    super.onRestart();
    if ((cQI()) && (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO <= 1)) {
      cQH();
    }
    if (this.tLB != null) {
      this.tLB.cvo = false;
    }
    AppMethodBeat.o(135414);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(135412);
    ab.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
    super.onResume();
    if (this.tLB != null)
    {
      this.tLB.cvo = false;
      if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO > 1)
      {
        cQH();
        if ((this.tLF != null) && (this.tLF.equals("1"))) {
          this.tLB.cQE();
        }
      }
    }
    if (this.tLI != null) {
      this.tLI.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
    AppMethodBeat.o(135412);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(135415);
    super.onStop();
    AppMethodBeat.o(135415);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI
 * JD-Core Version:    0.7.0.1
 */