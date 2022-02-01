package com.tencent.mm.plugin.voip_cs.ui;

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
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zu;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.a.c;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.protocal.protobuf.fvs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

@com.tencent.mm.ui.base.a(3)
public class VoipCSMainUI
  extends MMActivity
  implements com.tencent.mm.plugin.voip_cs.model.b, com.tencent.mm.plugin.voip_cs.model.b.a.a
{
  private TelephonyManager JFz;
  public String UXS;
  private com.tencent.mm.plugin.voip_cs.model.a.a UXY;
  private com.tencent.mm.plugin.voip_cs.model.a.b UYF;
  private com.tencent.mm.plugin.voip_cs.a.a UYG;
  public String UYH;
  public String UYI;
  public String UYJ;
  public boolean UYK;
  public CharSequence UYL;
  private MTimerHandler UYM;
  private BroadcastReceiver UxS;
  private String appId;
  private com.tencent.mm.compatible.util.b hqw;
  private com.tencent.mm.network.p mPf;
  private MMHandler mRi;
  public String nVM;
  public String scene;
  PhoneStateListener swG;
  public CharSequence title;
  public String type;
  public String wording;
  
  public VoipCSMainUI()
  {
    AppMethodBeat.i(125458);
    this.UXS = "";
    this.appId = "";
    this.nVM = "";
    this.UYH = "";
    this.UYI = "";
    this.UYJ = "";
    this.scene = "";
    this.type = "";
    this.UYK = false;
    this.wording = MMApplicationContext.getContext().getString(a.e.UWv);
    this.UYL = MMApplicationContext.getContext().getString(a.e.UWv);
    this.title = MMApplicationContext.getContext().getString(a.e.UWp);
    this.UYM = new MTimerHandler(Looper.getMainLooper(), new VoipCSMainUI.16(this), true);
    this.UxS = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(263873);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          Log.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
          VoipCSMainUI.c(VoipCSMainUI.this).hJi = false;
          AppMethodBeat.o(263873);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          Log.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
          VoipCSMainUI.c(VoipCSMainUI.this).hJi = false;
          if ((!VoipCSMainUI.d(VoipCSMainUI.this).dro()) && (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR == 2))
          {
            VoipCSMainUI.d(VoipCSMainUI.this).ieg();
            AppMethodBeat.o(263873);
          }
        }
        else if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          Log.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
          VoipCSMainUI.c(VoipCSMainUI.this).hJi = true;
          if (!VoipCSMainUI.d(VoipCSMainUI.this).dro()) {
            VoipCSMainUI.d(VoipCSMainUI.this).stopRing();
          }
        }
        AppMethodBeat.o(263873);
      }
    };
    this.swG = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(263872);
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
        if (paramAnonymousInt == 2)
        {
          Log.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
          com.tencent.mm.plugin.voip_cs.model.c.idY().UXl = 4;
          VoipCSMainUI.this.arC(7);
        }
        AppMethodBeat.o(263872);
      }
    };
    this.mPf = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(263864);
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        com.tencent.mm.plugin.voip_cs.model.a locala;
        if ((com.tencent.mm.plugin.voip_cs.model.c.idX().UXR == 2) && ((paramAnonymousInt == 4) || (paramAnonymousInt == 6)))
        {
          localObject = com.tencent.mm.plugin.voip_cs.model.c.idX();
          locala = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC;
          if (((com.tencent.mm.plugin.voip_cs.model.e)localObject).Uzf == 0) {
            ((com.tencent.mm.plugin.voip_cs.model.e)localObject).Uzf = locala.UDs;
          }
          MMApplicationContext.getContext();
          paramAnonymousInt = g.ibq();
          if (paramAnonymousInt != ((com.tencent.mm.plugin.voip_cs.model.e)localObject).Uzf) {
            Log.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + ((com.tencent.mm.plugin.voip_cs.model.e)localObject).Uzf + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locala.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            Log.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locala.JHb + ", roomkey=" + locala.Hnt + "]");
          }
          fvs localfvs = new fvs();
          localfvs.abTS = 3;
          localfvs.abTT = new com.tencent.mm.bx.b(arrayOfByte, 0, 1);
          locala.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
          }
        }
        ((com.tencent.mm.plugin.voip_cs.model.e)localObject).Uzf = paramAnonymousInt;
        Object localObject = com.tencent.mm.plugin.voip_cs.model.c.idX();
        Log.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.UDu + "roomkey:" + com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.Hnt);
        com.tencent.mm.kernel.h.aZW().a(285, (com.tencent.mm.am.h)localObject);
        localObject = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC;
        localObject = new com.tencent.mm.plugin.voip_cs.model.c.d(((v2protocal)localObject).UDu, ((v2protocal)localObject).Hnt);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
        AppMethodBeat.o(263864);
      }
    };
    AppMethodBeat.o(125458);
  }
  
  private void ieq()
  {
    AppMethodBeat.i(125460);
    if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR <= 0)
    {
      this.UYF.ieh();
      this.UYF.iei();
      com.tencent.mm.plugin.voip_cs.model.c.idW().init();
      com.tencent.mm.plugin.voip_cs.model.c.idX().bk(this.UXS, this.appId, this.UYJ);
    }
    if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR < 2) {
      this.UXY.ieg();
    }
    this.UYF.iel();
    AppMethodBeat.o(125460);
  }
  
  private boolean ier()
  {
    AppMethodBeat.i(125471);
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, ""))
    {
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "");
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
  
  public final void arC(int paramInt)
  {
    AppMethodBeat.i(125468);
    Log.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + paramInt + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.model.c.idX().UXR);
    if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR == 0)
    {
      finish();
      AppMethodBeat.o(125468);
      return;
    }
    if (this.UYF != null) {
      this.UYF.arF(paramInt);
    }
    AppMethodBeat.o(125468);
  }
  
  public final void fQM()
  {
    com.tencent.mm.plugin.voip.model.c localc = null;
    AppMethodBeat.i(125473);
    this.UYF.fQM();
    this.UYG.aER();
    Object localObject = this.UYG;
    if (((com.tencent.mm.plugin.voip_cs.a.a)localObject).wTG != null)
    {
      localObject = ((com.tencent.mm.plugin.voip_cs.a.a)localObject).wTG;
      if (localObject == null)
      {
        localObject = null;
        com.tencent.mm.plugin.voip_cs.model.c.idY().UXq = 1;
        if (!kotlin.g.b.s.p(localObject, Boolean.TRUE)) {
          break label221;
        }
      }
    }
    com.tencent.mm.plugin.voip_cs.a.a locala;
    label221:
    for (int i = 1;; i = -1)
    {
      com.tencent.mm.plugin.voip_cs.model.c.idY().UXJ = i;
      locala = this.UYG;
      if (locala.UzC != null) {
        break label226;
      }
      com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.UDJ = Math.abs(1);
      this.UXY.stopRing();
      localObject = com.tencent.mm.plugin.voip_cs.model.c.idY();
      if (((com.tencent.mm.plugin.voip_cs.model.d)localObject).UXE != 0) {
        ((com.tencent.mm.plugin.voip_cs.model.d)localObject).UXt = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.model.d)localObject).UXE);
      }
      localObject = com.tencent.mm.plugin.voip_cs.model.c.idY();
      Log.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
      if (((com.tencent.mm.plugin.voip_cs.model.d)localObject).UXH == 0) {
        ((com.tencent.mm.plugin.voip_cs.model.d)localObject).UXH = ((int)(System.currentTimeMillis() / 1000L));
      }
      localObject = com.tencent.mm.plugin.voip_cs.model.c.idY();
      Log.d("MicroMsg.VoipCSReportHelper", "markConnect");
      if (((com.tencent.mm.plugin.voip_cs.model.d)localObject).UXG != 0) {
        ((com.tencent.mm.plugin.voip_cs.model.d)localObject).UXv = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.model.d)localObject).UXG);
      }
      AppMethodBeat.o(125473);
      return;
      localObject = Boolean.valueOf(((com.tencent.mm.audio.b.c)localObject).aGR());
      break;
    }
    label226:
    localObject = locala.UzC;
    if (localObject == null)
    {
      localObject = localc;
      label238:
      localc = locala.UzC;
      if (localc != null) {
        break label290;
      }
    }
    label290:
    for (i = 0;; i = localc.hVD())
    {
      if (i <= 0) {
        com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.UDJ = Math.abs(1);
      }
      if (localObject == null) {
        break;
      }
      ((Integer)localObject).intValue();
      break;
      localObject = Integer.valueOf(((com.tencent.mm.plugin.voip.model.c)localObject).hVD());
      break label238;
    }
  }
  
  public int getLayoutId()
  {
    return a.c.UWb;
  }
  
  public final void iep()
  {
    AppMethodBeat.i(125474);
    Log.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
    this.UYF.arF(5);
    AppMethodBeat.o(125474);
  }
  
  public final void nw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125470);
    com.tencent.mm.plugin.voip_cs.model.a.b localb = this.UYF;
    if ((localb.UYr.equals("")) && (Util.isNullOrNil(paramString2))) {
      if (localb.UXZ.UYK) {
        localb.lBD.setText(a.e.UWf);
      }
    }
    while ((localb.UYq.equals("")) && (Util.isNullOrNil(paramString1)) && ((localb.UXZ.nVM == null) || (localb.UXZ.nVM.equals(""))))
    {
      localb.UYf.setImageResource(com.tencent.mm.plugin.voip_cs.a.a.default_avatar);
      AppMethodBeat.o(125470);
      return;
      localb.lBD.setText(a.e.UWe);
      continue;
      localb.setNickName(paramString2);
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if ((!Util.isNullOrNil(paramString1)) && (!localb.UYq.equals(paramString1)))
    {
      localb.bfR(paramString1);
      localSharedPreferences.edit().putString(localb.iej(), paramString1).commit();
    }
    if ((!Util.isNullOrNil(paramString2)) && (!localb.UYr.equals(paramString2)))
    {
      localb.setNickName(paramString2);
      localSharedPreferences.edit().putString(localb.iek(), paramString2).commit();
    }
    AppMethodBeat.o(125470);
  }
  
  public final void oc(int paramInt)
  {
    AppMethodBeat.i(125469);
    if (this.UYF != null)
    {
      Log.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(paramInt)));
      this.UYF.arF(paramInt);
    }
    AppMethodBeat.o(125469);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125459);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
    super.onCreate(paramBundle);
    hideTitleView();
    this.UXS = getIntent().getStringExtra("voipCSBizId");
    this.appId = getIntent().getStringExtra("voipCSAppId");
    this.scene = Util.nullAsNil(getIntent().getStringExtra("voipCSScene"));
    this.type = Util.nullAsNil(getIntent().getStringExtra("voipCSType"));
    this.UYH = getIntent().getStringExtra("voipCSAllowBackCamera");
    this.UYI = getIntent().getStringExtra("voipCSShowOther");
    this.nVM = getIntent().getStringExtra("voipCSAvatarUrl");
    this.UYJ = getIntent().getStringExtra("voipCSContext");
    this.UYK = getIntent().getBooleanExtra("launch_from_appbrand", false);
    getWindow().addFlags(6946944);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(67108864);
    }
    this.mRi = new MMHandler();
    paramBundle = com.tencent.mm.plugin.voip_cs.model.c.idY();
    Log.d("MicroMsg.VoipCSReportHelper", "reset");
    paramBundle.dataType = 0;
    paramBundle.UWV = 0;
    paramBundle.UWW = 0;
    paramBundle.UWX = 0;
    paramBundle.videoFps = 0;
    paramBundle.UWY = 0;
    paramBundle.UWZ = 0;
    paramBundle.UXa = 0;
    paramBundle.UXb = 0;
    paramBundle.UXc = 0;
    paramBundle.UXd = 0;
    paramBundle.networkType = 0;
    paramBundle.UXe = 0;
    paramBundle.UXf = com.tencent.mm.plugin.voip_cs.model.d.UWS;
    paramBundle.mNT = 0;
    paramBundle.roomId = 0L;
    paramBundle.Hnt = 0L;
    paramBundle.UXg = "";
    paramBundle.UDs = 0;
    paramBundle.UXj = 0;
    paramBundle.UXk = 0;
    paramBundle.UXl = 0;
    paramBundle.UDN = 0;
    paramBundle.UDM = 0;
    paramBundle.UXm = 0;
    paramBundle.UXn = 0;
    paramBundle.UXo = 0;
    paramBundle.UXp = 0;
    paramBundle.UXq = 0;
    paramBundle.UXr = 0;
    paramBundle.UXs = 0L;
    paramBundle.UXt = 0;
    paramBundle.UXu = 0L;
    paramBundle.UXv = 0L;
    paramBundle.UXw = 0L;
    paramBundle.JIg = 0L;
    paramBundle.UXx = 0;
    paramBundle.UXy = 0;
    paramBundle.channelStrategy = 1;
    paramBundle.UFM = 0;
    paramBundle.UDO = 0;
    paramBundle.UXz = 0;
    paramBundle.UXA = 0;
    paramBundle.JIq = "";
    paramBundle.JIp = "";
    paramBundle.UXE = 0;
    paramBundle.UXF = 0;
    paramBundle.UXG = 0;
    paramBundle.UXH = 0;
    paramBundle.UXI = 0;
    this.JFz = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    com.tencent.mm.plugin.voip_cs.model.c.idX().UXS = this.UXS;
    this.UYF = new com.tencent.mm.plugin.voip_cs.model.a.b(this);
    this.UYG = new com.tencent.mm.plugin.voip_cs.a.a();
    this.hqw = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    this.UXY = com.tencent.mm.plugin.voip_cs.model.a.a.iee();
    com.tencent.mm.plugin.voip_cs.model.c.idW().UYD = this;
    com.tencent.mm.plugin.voip_cs.model.c.idX().UXK = this;
    if ((com.tencent.mm.plugin.voip_cs.model.c.idX().UXR == 0) || (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR == 3)) {
      com.tencent.mm.plugin.voip_cs.model.c.idX().UXR = 0;
    }
    com.tencent.mm.booter.a.aKj().aKl();
    this.hqw.requestFocus();
    this.UYG.aER();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.USER_PRESENT");
    MMApplicationContext.getContext().registerReceiver(this.UxS, paramBundle);
    com.tencent.mm.kernel.h.baD().a(this.mPf);
    if (this.UYK) {
      if (this.scene.equals("1")) {
        if (this.type.equals("video"))
        {
          this.title = MMApplicationContext.getContext().getString(a.e.UWn);
          this.UYL = MMApplicationContext.getContext().getString(a.e.UWr);
          this.wording = MMApplicationContext.getContext().getString(a.e.UWr);
          i = this.JFz.getCallState();
          if ((i != 2) && (i != 1)) {
            break label1140;
          }
          Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
          k.a(this, a.e.UWB, a.e.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125440);
              paramAnonymousDialogInterface.dismiss();
              VoipCSMainUI.this.arC(0);
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
      this.title = MMApplicationContext.getContext().getString(a.e.UWo);
      this.UYL = MMApplicationContext.getContext().getString(a.e.UWs);
      this.wording = MMApplicationContext.getContext().getString(a.e.UWs);
      break;
      if (this.type.equals("video"))
      {
        this.title = MMApplicationContext.getContext().getString(a.e.UWp);
        this.UYL = MMApplicationContext.getContext().getString(a.e.UWt);
        this.wording = MMApplicationContext.getContext().getString(a.e.UWt);
        break;
      }
      this.title = MMApplicationContext.getContext().getString(a.e.UWo);
      this.UYL = MMApplicationContext.getContext().getString(a.e.UWs);
      this.wording = MMApplicationContext.getContext().getString(a.e.UWs);
      break;
      if (this.scene.equals("1"))
      {
        if (this.type.equals("video"))
        {
          this.title = MMApplicationContext.getContext().getString(a.e.UWn);
          this.UYL = MMApplicationContext.getContext().getString(a.e.UWr);
          this.wording = MMApplicationContext.getContext().getString(a.e.UWr);
          break;
        }
        this.title = MMApplicationContext.getContext().getString(a.e.UWo);
        this.UYL = MMApplicationContext.getContext().getString(a.e.UWv);
        this.wording = MMApplicationContext.getContext().getString(a.e.UWv);
        break;
      }
      if (this.type.equals("video"))
      {
        this.title = MMApplicationContext.getContext().getString(a.e.UWp);
        this.UYL = MMApplicationContext.getContext().getString(a.e.UWv);
        this.wording = MMApplicationContext.getContext().getString(a.e.UWv);
        break;
      }
      this.title = MMApplicationContext.getContext().getString(a.e.UWo);
      this.UYL = MMApplicationContext.getContext().getString(a.e.UWu);
      this.wording = MMApplicationContext.getContext().getString(a.e.UWu);
      break;
    }
    label1145:
    paramBundle = this.JFz;
    Object localObject = this.swG;
    localObject = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onCreate", "(Landroid/os/Bundle;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramBundle.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onCreate", "(Landroid/os/Bundle;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    if (!NetStatusUtil.isNetworkConnected(this))
    {
      Log.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
      k.a(this, a.e.UWx, a.e.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125454);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.arC(9);
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
      if ((NetStatusUtil.isWifi(this)) || (com.tencent.mm.plugin.voip.model.s.hXN()))
      {
        i = 1;
      }
      else
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
        k.a(this, a.e.UWy, a.e.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125455);
            Log.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
            com.tencent.mm.plugin.voip.model.s.hXM();
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
            VoipCSMainUI.this.arC(8);
            AppMethodBeat.o(125456);
          }
        });
        i = 0;
      }
    }
    if (m.isVoipStarted())
    {
      Log.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
      k.a(this, a.e.in_voip_tip, a.e.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125450);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.arC(0);
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
      if (m.icd())
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
        k.a(this, a.e.in_wechat_out_tip, a.e.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125451);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.arC(0);
            AppMethodBeat.o(125451);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.n.a.aTe())
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
        k.a(this, a.e.in_multitalk_tip, a.e.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125452);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.arC(0);
            AppMethodBeat.o(125452);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.bc.e.bNC())
      {
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
        k.a(this, a.e.in_new_share_location_tip, a.e.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125453);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.arC(0);
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
    if (ier()) {
      ieq();
    }
    AppMethodBeat.o(125459);
  }
  
  public void onDestroy()
  {
    int j = 2;
    AppMethodBeat.i(125467);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
    if (this.hqw != null) {
      this.hqw.aPS();
    }
    Object localObject1 = new zu();
    Object localObject2;
    Object localObject3;
    if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXT == -1)
    {
      ((zu)localObject1).idp.status = 3;
      ((zu)localObject1).publish();
      localObject1 = this.UYG;
      localObject2 = com.tencent.mm.plugin.voip_cs.model.c.idY();
      if ((((com.tencent.mm.plugin.voip_cs.a.a)localObject1).UzC == null) || (com.tencent.mm.plugin.voip_cs.model.c.idY().UXq != 1)) {
        break label1273;
      }
      localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).UzC;
      kotlin.g.b.s.checkNotNull(localObject3);
    }
    label180:
    label715:
    label1233:
    label1263:
    label1268:
    label1273:
    for (int i = ((com.tencent.mm.plugin.voip.model.c)localObject3).gdZ();; i = 0)
    {
      float f = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamMaxVolume(i);
      ((com.tencent.mm.plugin.voip_cs.model.d)localObject2).UXA = ((int)(((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamVolume(i) / f * 100.0F));
      localObject2 = com.tencent.mm.plugin.voip_cs.model.c.idY();
      byte[] arrayOfByte;
      if ((((com.tencent.mm.plugin.voip_cs.a.a)localObject1).wTG != null) && (com.tencent.mm.plugin.voip_cs.model.c.idY().UXq == 1))
      {
        localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).wTG;
        kotlin.g.b.s.checkNotNull(localObject3);
        i = ((com.tencent.mm.audio.b.c)localObject3).aGV();
        ((com.tencent.mm.plugin.voip_cs.model.d)localObject2).UDO = i;
        localObject2 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).wTG;
        if (localObject2 != null) {
          ((com.tencent.mm.audio.b.c)localObject2).aGH();
        }
        localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).UzC;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.voip.model.c)localObject1).hVF();
        }
        this.UXY.stopRing();
        if (this.UYF != null)
        {
          localObject1 = this.UYF;
          if (com.tencent.mm.plugin.voip_cs.model.c.idY().dataType == 0)
          {
            if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR >= 2) {
              break label1223;
            }
            com.tencent.mm.plugin.voip_cs.model.c.idY().dataType = 1;
          }
          ((com.tencent.mm.plugin.voip_cs.model.a.b)localObject1).UKJ.ici();
          ((com.tencent.mm.plugin.voip_cs.model.a.b)localObject1).UKK.ici();
          ((com.tencent.mm.plugin.voip_cs.model.a.b)localObject1).gfp();
          ((com.tencent.mm.plugin.voip_cs.model.a.b)localObject1).ieo();
          localObject1 = com.tencent.mm.plugin.voip_cs.model.c.idX();
          Log.i("MicroMsg.voipcs.VoipCSService", "now stop service");
          com.tencent.mm.kernel.h.aZW().b(823, (com.tencent.mm.am.h)localObject1);
          com.tencent.mm.kernel.h.aZW().b(106, (com.tencent.mm.am.h)localObject1);
          com.tencent.mm.kernel.h.aZW().b(818, (com.tencent.mm.am.h)localObject1);
          com.tencent.mm.kernel.h.aZW().b(795, (com.tencent.mm.am.h)localObject1);
          com.tencent.mm.kernel.h.aZW().b(285, (com.tencent.mm.am.h)localObject1);
          com.tencent.mm.kernel.h.aZW().b(312, (com.tencent.mm.am.h)localObject1);
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXR = 3;
          if (((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXT != 823)
          {
            com.tencent.mm.kernel.h.aZW().a(880, (com.tencent.mm.am.h)localObject1);
            if (((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXM != 0) {
              break label1233;
            }
            i = 1;
            Log.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXS + ",inviteId：" + com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.JGW + ",csroomId:" + com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.UDu + ",roomkey:" + com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.Hnt + ",reason:" + i);
            localObject2 = new com.tencent.mm.plugin.voip_cs.model.c.a(com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.JGW, com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.UDu, com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.Hnt, ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXS, i);
            com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject2, 0);
          }
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXV.stopTimer();
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXW.stopTimer();
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXL = 0;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXh = 0;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXM = 0;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXN = 0;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXO = null;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).JHd = 0;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXP = 0;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXR = 0;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXS = "";
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXQ = 0;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXT = 0;
          ((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXU = 999;
          localObject1 = com.tencent.mm.plugin.voip_cs.model.c.idW();
          Log.i("MicroMsg.VoipCSEngine", "now stop engine");
          ((com.tencent.mm.plugin.voip_cs.model.b.a)localObject1).UYC.Gw(true);
          localObject2 = com.tencent.mm.plugin.voip_cs.model.c.idY();
          if ((Util.isNullOrNil(((com.tencent.mm.plugin.voip_cs.model.d)localObject2).JIq)) && (Util.isNullOrNil(((com.tencent.mm.plugin.voip_cs.model.d)localObject2).JIp)))
          {
            localObject3 = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC;
            if (((com.tencent.mm.plugin.voip_cs.model.d)localObject2).UXo != 1) {
              break label1263;
            }
            i = 1;
            arrayOfByte = ((com.tencent.mm.plugin.voip_cs.model.a)localObject3).UWJ;
            j = ((com.tencent.mm.plugin.voip_cs.model.a)localObject3).UWJ.length;
            if (i == 0) {
              break label1268;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip_cs.model.a)localObject3).getVoipcsChannelInfo(arrayOfByte, j, i);
        Log.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.model.a)localObject3).field_voipcsChannelInfoLength) });
        ((com.tencent.mm.plugin.voip_cs.model.d)localObject2).JIq = new String(((com.tencent.mm.plugin.voip_cs.model.a)localObject3).UWJ, 0, ((com.tencent.mm.plugin.voip_cs.model.a)localObject3).field_voipcsChannelInfoLength);
        ((com.tencent.mm.plugin.voip_cs.model.d)localObject2).JIp = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.idT();
        Log.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.model.d)localObject2).JIq });
        Log.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.model.d)localObject2).JIp });
        localObject2 = com.tencent.mm.plugin.voip_cs.model.c.idX();
        com.tencent.mm.kernel.h.aZW().a(312, (com.tencent.mm.am.h)localObject2);
        localObject2 = new com.tencent.mm.plugin.voip_cs.model.c.e(com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.UDu, com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.Hnt);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject2, 0);
        ((com.tencent.mm.plugin.voip_cs.model.b.a)localObject1).UYC.reset();
        r.hXJ().hXL();
        r.hXJ().a(null);
        this.UYF = null;
        localObject1 = this.UYG;
        com.tencent.mm.plugin.audio.b.a.a((com.tencent.mm.plugin.audio.b.a)localObject1, 0);
        ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).ahq("voipcs");
        MMApplicationContext.getContext().unregisterReceiver(this.UxS);
        com.tencent.mm.kernel.h.baD().b(this.mPf);
        if (this.UYM != null) {
          this.UYM.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(44);
        if ((this.JFz != null) && (this.swG != null))
        {
          localObject1 = this.JFz;
          localObject2 = this.swG;
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          this.swG = null;
        }
        com.tencent.mm.plugin.voip_cs.a.a.unInit();
        this.UYG = null;
        super.onDestroy();
        AppMethodBeat.o(125467);
        return;
        if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXT == 823)
        {
          ((zu)localObject1).idp.status = 4;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR <= 1)
        {
          ((zu)localObject1).idp.status = 1;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR < 2) {
          break;
        }
        ((zu)localObject1).idp.status = 2;
        break;
        i = 0;
        break label180;
        com.tencent.mm.plugin.voip_cs.model.c.idY().dataType = 3;
        break label268;
        i = j;
        if (((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXM == 2) {
          break label411;
        }
        if (((com.tencent.mm.plugin.voip_cs.model.e)localObject1).UXM == 3)
        {
          i = 3;
          break label411;
        }
        i = 4;
        break label411;
        i = 0;
        break label715;
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
      paramInt = this.UYG.Hc(this.UXY.dro());
      this.UYG.EZ(paramInt);
      AppMethodBeat.o(125461);
      return true;
    }
    if (paramInt == 24)
    {
      paramInt = this.UYG.Hc(this.UXY.dro());
      this.UYG.EY(paramInt);
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
    if (!this.UXY.dro()) {
      this.UXY.stopRing();
    }
    if ((com.tencent.mm.plugin.voip_cs.model.c.idX().UXR == 1) || (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR == 2))
    {
      Object localObject = new Intent(MMApplicationContext.getContext(), VoipCSMainUI.class);
      ((Intent)localObject).putExtra("voipCSBizId", this.UXS);
      ((Intent)localObject).putExtra("voipCSAppId", this.appId);
      ((Intent)localObject).putExtra("voipCSScene", this.scene);
      ((Intent)localObject).putExtra("voipCSType", this.type);
      ((Intent)localObject).putExtra("voipCSAllowBackCamera", this.UYH);
      ((Intent)localObject).putExtra("voipCSShowOther", this.UYI);
      ((Intent)localObject).putExtra("voipCSAvatarUrl", this.nVM);
      ((Intent)localObject).putExtra("voipCSContext", this.UYJ);
      ((Intent)localObject).putExtra("launch_from_appbrand", this.UYK);
      localObject = PendingIntent.getActivity(MMApplicationContext.getContext(), 44, (Intent)localObject, 134217728);
      f.d locald = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(this.UYL).bt(System.currentTimeMillis()).l(this.title).m(this.wording);
      locald.bor = ((PendingIntent)localObject);
      locald.q(2, true);
      localObject = locald.DA();
      ((Notification)localObject).icon = com.tencent.mm.bq.a.guX();
      ((Notification)localObject).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().a(44, (Notification)localObject, false);
      if ((this.UYM != null) && (this.UYM.stopped())) {
        this.UYM.startTimer(5000L);
      }
    }
    for (;;)
    {
      this.UYF.gfp();
      this.UYF.hJi = true;
      AppMethodBeat.o(125464);
      return;
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(44);
      if (this.UYM != null) {
        this.UYM.stopTimer();
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
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "")) {
          ieq();
        }
        AppMethodBeat.o(125472);
        return;
      }
      k.a(this, getString(a.e.permission_microphone_request_again_msg), getString(a.e.permission_tips_title), getString(a.e.jump_to_settings), getString(a.e.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(263874);
          com.tencent.mm.pluginsdk.permission.b.lx(VoipCSMainUI.this.getContext());
          AppMethodBeat.o(263874);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(263870);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.arC(2);
          AppMethodBeat.o(263870);
        }
      });
      AppMethodBeat.o(125472);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      ieq();
      AppMethodBeat.o(125472);
      return;
    }
    if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
    for (paramInt = a.e.permission_camera_request_again_msg;; paramInt = a.e.permission_microphone_request_again_msg)
    {
      k.a(this, getString(paramInt), getString(a.e.permission_tips_title), getString(a.e.jump_to_settings), getString(a.e.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125445);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.pluginsdk.permission.b.lx(VoipCSMainUI.this.getContext());
          AppMethodBeat.o(125445);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125446);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.arC(3);
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
    if ((ier()) && (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR <= 1)) {
      ieq();
    }
    if (this.UYF != null) {
      this.UYF.hJi = false;
    }
    AppMethodBeat.o(125465);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125463);
    Log.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
    super.onResume();
    if (this.UYF != null)
    {
      this.UYF.hJi = false;
      if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR > 1)
      {
        ieq();
        if ((this.UYI != null) && (this.UYI.equals("1"))) {
          this.UYF.ien();
        }
      }
    }
    if (this.UYM != null) {
      this.UYM.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(44);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI
 * JD-Core Version:    0.7.0.1
 */