package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.app.k;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.NewVoipMgr;
import com.tencent.mm.plugin.voip.model.VoipMgr;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import java.lang.ref.WeakReference;

@i
@com.tencent.mm.ui.base.a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity
  extends MMActivity
  implements ServiceConnection, d.a, VoipBaseFragment.d, b
{
  private am BYG;
  private boolean BYH;
  private boolean BYI;
  private int BYM;
  private VoipBaseFragment CiQ;
  private WeakReference<c> CiR;
  private long CiS;
  private long CiT;
  private boolean CiU;
  private int CiV;
  private boolean CiW;
  private boolean CiX;
  private boolean CiY;
  private long CiZ;
  @Deprecated
  com.tencent.mm.plugin.voip.video.b.a Cja;
  private String fGM;
  private com.tencent.mm.sdk.b.c gGf;
  com.tencent.mm.plugin.mmsight.model.d gXX;
  private Point hqz;
  private ap jwD;
  private boolean mIsMute;
  private int mStatus;
  private CaptureView oXg;
  private boolean rnU;
  private com.tencent.mm.plugin.voip.a.b uUL;
  private boolean uVF;
  private boolean uVG;
  private com.tencent.mm.sdk.b.c vWV;
  
  public VideoActivity()
  {
    AppMethodBeat.i(115323);
    this.CiS = -1L;
    this.rnU = false;
    this.CiT = 0L;
    this.CiU = false;
    this.BYM = -1;
    this.mIsMute = false;
    this.CiV = 1;
    this.uVG = false;
    this.CiW = false;
    this.uVF = false;
    this.CiX = false;
    this.CiY = false;
    this.gGf = new VideoActivity.1(this);
    this.vWV = new VideoActivity.9(this);
    AppMethodBeat.o(115323);
  }
  
  private int ddZ()
  {
    AppMethodBeat.i(115344);
    int i;
    if (com.tencent.mm.plugin.audio.c.a.bGC().isBluetoothScoOn())
    {
      i = com.tencent.mm.plugin.audio.c.a.bGy();
      AppMethodBeat.o(115344);
      return i;
    }
    if (!com.tencent.mm.plugin.voip.b.l.UN(this.mStatus))
    {
      i = 2;
      if (this.BYH) {
        if (!this.BYI)
        {
          if (ae.gcF.fWN < 0) {
            break label199;
          }
          i = ae.gcF.fWN;
        }
      }
    }
    for (;;)
    {
      int j = i;
      if (!com.tencent.mm.plugin.audio.c.a.bGD())
      {
        j = i;
        if (ae.gcF.fWP < 0) {}
      }
      for (j = ae.gcF.fWP;; j = com.tencent.mm.plugin.voip.c.euM().aNs())
      {
        ad.i("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(115344);
        return j;
        i = 3;
        if (com.tencent.mm.plugin.audio.c.a.bGx())
        {
          if (ae.gcF.fWN < 0) {
            break label199;
          }
          i = ae.gcF.fWN;
          break;
        }
        if (ae.gcF.fWK < 0) {
          break;
        }
        i = ae.gcF.fWK;
        break;
        if (!com.tencent.mm.plugin.audio.c.a.bGx()) {
          break;
        }
        if (ae.gcF.fWN < 0) {
          break label199;
        }
        i = ae.gcF.fWN;
        break;
      }
      label199:
      i = 0;
    }
  }
  
  private static boolean dqg()
  {
    AppMethodBeat.i(115326);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)aj.getContext().getSystemService("phone");
        if (localTelephonyManager == null) {
          continue;
        }
        i = localTelephonyManager.getCallState();
        switch (i)
        {
        default: 
          bool = false;
        }
      }
      catch (Exception localException1)
      {
        int i;
        boolean bool = false;
        ad.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ad.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(115326);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      bool = false;
      continue;
      bool = true;
    }
  }
  
  private void evs()
  {
    AppMethodBeat.i(115327);
    this.jwD.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115316);
        VideoActivity.this.finish();
        AppMethodBeat.o(115316);
      }
    }, 2000L);
    AppMethodBeat.o(115327);
  }
  
  private void eyT()
  {
    AppMethodBeat.i(115330);
    if ((this.CiR != null) && (this.CiR.get() != null) && (!this.BYH))
    {
      if (!this.BYI) {
        break label91;
      }
      ((c)this.CiR.get()).euZ();
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.voip.c.euM().dfP) && (this.BYI)) {
        ((c)this.CiR.get()).evj();
      }
      AppMethodBeat.o(115330);
      return;
      label91:
      ((c)this.CiR.get()).evc();
    }
  }
  
  @Deprecated
  public final com.tencent.mm.plugin.voip.video.b.a Uu(int paramInt)
  {
    AppMethodBeat.i(115340);
    if (((this.CiQ instanceof VoipVideoFragment)) && (this.CiQ.eyV() != null)) {
      this.CiQ.eyV().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            VideoActivity.this.Cja = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.Cja;
    AppMethodBeat.o(115340);
    return locala;
  }
  
  public final void Uv(int paramInt)
  {
    AppMethodBeat.i(216506);
    if (this.CiQ != null) {
      this.CiQ.Uv(paramInt);
    }
    AppMethodBeat.o(216506);
  }
  
  public final void Uw(int paramInt)
  {
    AppMethodBeat.i(216507);
    if (this.CiQ != null) {
      this.CiQ.Uw(paramInt);
    }
    AppMethodBeat.o(216507);
  }
  
  public final void Ux(int paramInt)
  {
    AppMethodBeat.i(216508);
    if (this.CiQ != null) {
      this.CiQ.Ux(paramInt);
    }
    AppMethodBeat.o(216508);
  }
  
  @Deprecated
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115351);
    if (this.CiQ != null) {
      this.CiQ.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115351);
  }
  
  @Deprecated
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(216501);
    if (this.CiQ != null) {
      this.CiQ.b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(216501);
  }
  
  public final void aDI(final String paramString)
  {
    AppMethodBeat.i(115342);
    if (this.CiQ != null) {
      this.jwD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115320);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).aDI(paramString);
          }
          AppMethodBeat.o(115320);
        }
      });
    }
    AppMethodBeat.o(115342);
  }
  
  public final void ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115359);
    this.CiU = paramBoolean2;
    if (paramBoolean1)
    {
      evs();
      AppMethodBeat.o(115359);
      return;
    }
    finish();
    AppMethodBeat.o(115359);
  }
  
  public final void co(final int paramInt, String paramString)
  {
    AppMethodBeat.i(115341);
    ad.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.BYI) });
    this.rnU = true;
    if (paramInt == 241)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, null, true);
      AppMethodBeat.o(115341);
      return;
    }
    this.jwD.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216500);
        VideoActivity.a(VideoActivity.this, paramInt);
        AppMethodBeat.o(216500);
      }
    });
    AppMethodBeat.o(115341);
  }
  
  public final void deY()
  {
    AppMethodBeat.i(115358);
    ad.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
    if (this.CiQ != null) {
      this.CiQ.eyM();
    }
    AppMethodBeat.o(115358);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(115343);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V", this, localb.ahq());
    al.n(al.a(getWindow(), null), getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(paramView, 0);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V");
    AppMethodBeat.o(115343);
  }
  
  public final void dqh() {}
  
  @Deprecated
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115347);
    if (this.CiQ != null) {
      this.CiQ.e(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115347);
  }
  
  public final void evo()
  {
    AppMethodBeat.i(216503);
    Intent localIntent = new Intent(this, SettingsAboutCamera.class);
    localIntent.putExtra("activity_caller_params", 1);
    startActivityForResult(localIntent, 1);
    this.CiW = true;
    AppMethodBeat.o(216503);
  }
  
  @Deprecated
  public final void eyH()
  {
    AppMethodBeat.i(115361);
    if ((this.CiQ instanceof VoipVideoFragment)) {
      ((VoipVideoFragment)this.CiQ).eyH();
    }
    AppMethodBeat.o(115361);
  }
  
  public final Context eyI()
  {
    AppMethodBeat.i(115354);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(115354);
    return localAppCompatActivity;
  }
  
  public final void eyJ()
  {
    AppMethodBeat.i(216505);
    if (this.CiQ != null) {
      this.CiQ.eyJ();
    }
    AppMethodBeat.o(216505);
  }
  
  public final void eyK()
  {
    AppMethodBeat.i(216502);
    if (this.CiQ != null) {
      this.CiQ.Uz(10);
    }
    AppMethodBeat.o(216502);
  }
  
  public void finish()
  {
    AppMethodBeat.i(115334);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V", this);
    this.CiV = 3;
    ad.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[] { Boolean.valueOf(this.CiU), com.tencent.mm.plugin.voip.b.l.UK(this.mStatus) });
    Object localObject;
    if ((!this.CiU) && (com.tencent.mm.plugin.voip.b.l.UN(this.mStatus)) && (4 != this.CiV))
    {
      ad.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.fGM);
      com.tencent.mm.plugin.voip.d.iRG.d((Intent)localObject, this);
    }
    int i;
    if (this.CiY)
    {
      this.CiY = false;
      int j = com.tencent.mm.plugin.voip.c.euM().exw();
      long l = com.tencent.mm.plugin.voip.c.euM().exx();
      if (this.BYH)
      {
        i = 0;
        com.tencent.mm.plugin.voip.b.f.c(j, l, i, 5);
        com.tencent.mm.plugin.voip.b.f.UE(1);
      }
    }
    else
    {
      if (this.gXX != null)
      {
        this.gXX.disable();
        this.gXX.vNC = null;
        this.gXX = null;
      }
      if (this.CiQ == null) {
        break label379;
      }
      if (this.CiQ.Cjh != 4105) {
        break label374;
      }
      i = 1;
      label229:
      this.CiQ.uninit();
      this.CiQ = null;
    }
    for (;;)
    {
      this.CiR = null;
      this.oXg = null;
      this.uVF = true;
      super.finish();
      if (i != 0)
      {
        localObject = new kf();
        ((kf)localObject).dxj.dxm = true;
        ((kf)localObject).dxj.dxl = this.CiZ;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        VoipBaseFragment.Cji = -1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V");
        AppMethodBeat.o(115334);
        return;
        i = 1;
        break;
        localObject = new kf();
        ((kf)localObject).dxj.dxm = false;
        ((kf)localObject).dxj.dxl = 0L;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      label374:
      i = 0;
      break label229;
      label379:
      i = 0;
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495879;
  }
  
  @Deprecated
  public final void ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115350);
    if (this.CiQ != null) {
      this.CiQ.ir(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115350);
  }
  
  public final void iu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115328);
    this.mStatus = paramInt2;
    if ((1 != this.CiV) && (paramInt2 != 8) && (paramInt2 != 262))
    {
      ad.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
      AppMethodBeat.o(115328);
      return;
    }
    if (this.CiQ == null)
    {
      ad.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
      AppMethodBeat.o(115328);
      return;
    }
    this.CiQ.iu(paramInt1, paramInt2);
    Object localObject;
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(115328);
      return;
    case 1: 
    case 3: 
    case 7: 
    case 257: 
    case 261: 
      this.BYI = false;
      if ((this.CiQ == null) || (!(this.CiQ instanceof VoipVoiceFragment)))
      {
        if (this.CiQ != null)
        {
          this.CiQ.uninit();
          getSupportFragmentManager().beginTransaction().a(this.CiQ).commit();
          this.CiQ = null;
        }
        ad.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_username", this.BYG.field_username);
        ((Bundle)localObject).putBoolean("key_isoutcall", this.BYH);
        ((Bundle)localObject).putInt("key_status", this.mStatus);
        this.CiQ = new VoipVoiceFragment();
        this.CiQ.setArguments((Bundle)localObject);
        this.CiQ.setVoipUIListener((c)this.CiR.get());
        this.CiQ.Bx(this.CiS);
        this.CiQ.a(this);
        this.CiQ.setVoicePlayDevice(this.BYM);
        this.CiQ.setMute(this.mIsMute);
        getSupportFragmentManager().beginTransaction().b(2131306559, this.CiQ).commit();
      }
      AppMethodBeat.o(115328);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      evs();
      ad.d("MicroMsg.Voip.VideoActivity", "finishSmallWindow mStatus: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.UK(this.mStatus) });
      if ((this.mStatus != 262) && (this.mStatus != 8)) {
        break;
      }
      com.tencent.mm.plugin.voip.c.euN().rf(true);
      break;
      if (this.BYH)
      {
        localObject = this.CiQ;
        if (!this.BYI) {
          break label523;
        }
      }
      label523:
      for (paramInt1 = 2131764931;; paramInt1 = 2131764789)
      {
        ((VoipBaseFragment)localObject).iv(paramInt1, -1);
        evs();
        break;
      }
      this.jwD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115321);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).iv(2131764918, -1);
          }
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115321);
        }
      });
      continue;
      this.jwD.post(new VideoActivity.2(this));
      continue;
      this.jwD.postDelayed(new VideoActivity.8(this), 50L);
      continue;
      evs();
      continue;
      finish();
    }
  }
  
  public final void nL(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(216509);
    paramInt = i;
    switch (((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation())
    {
    }
    for (paramInt = i;; paramInt = 180)
    {
      if ((this.CiR != null) && (this.CiR.get() != null) && (this.CiQ != null)) {
        ((c)this.CiR.get()).nL(paramInt);
      }
      AppMethodBeat.o(216509);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(216504);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.CiW = false;
      if (this.CiQ != null) {
        this.CiQ.Uz(5);
      }
    }
    AppMethodBeat.o(216504);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(115325);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.hqz != null) && (com.tencent.mm.compatible.util.d.ly(17)))
    {
      paramConfiguration = new Point();
      getWindowManager().getDefaultDisplay().getRealSize(paramConfiguration);
      if ((!paramConfiguration.equals(this.hqz)) && (this.CiQ != null))
      {
        this.hqz = paramConfiguration;
        this.CiQ.eyN();
      }
    }
    AppMethodBeat.o(115325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(115324);
    super.onCreate(paramBundle);
    for (;;)
    {
      PBool localPBool1;
      PBool localPBool2;
      PString localPString;
      PInt localPInt;
      boolean bool;
      try
      {
        paramBundle = t.CdB;
        t.ewW();
        com.tencent.mm.util.d.erL();
        setActionbarColor(getResources().getColor(2131101053));
        if (!n.gC(getContext())) {
          n.gD(getContext());
        }
        ad.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(3);
        this.gXX = new com.tencent.mm.plugin.mmsight.model.d(this);
        this.gXX.enable();
        this.gXX.vNC = this;
        getWindow().addFlags(6815872);
        if (com.tencent.mm.kernel.g.ajx()) {
          com.tencent.mm.plugin.voip.c.euM().av(false, false);
        }
        this.jwD = new ap();
        localPBool1 = new PBool();
        localPBool2 = new PBool();
        localPString = new PString();
        localPInt = new PInt();
        Object localObject = new PInt();
        localPString.value = getIntent().getStringExtra("Voip_User");
        localPBool1.value = getIntent().getBooleanExtra("Voip_Outcall", true);
        localPBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.CiZ = getIntent().getLongExtra("Voip_LastPage_Hash", 0L);
        localPInt.value = com.tencent.mm.plugin.voip.b.l.aF(localPBool1.value, localPBool2.value);
        paramBundle = new PLong();
        paramBundle.value = getIntent().getLongExtra("Voip_CallRoomKey", 0L);
        ((PInt)localObject).value = getIntent().getIntExtra("Voip_Call_From", -1);
        bool = localPBool1.value;
        if (bool) {
          try
          {
            if ((dqg()) && (!isFinishing()))
            {
              Toast.makeText(this, 2131764869, 0).show();
              ad.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
              com.tencent.mm.plugin.voip.c.euM().aKp();
              super.finish();
              AppMethodBeat.o(115324);
              return;
            }
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.Voip.VideoActivity", "not ready now!");
          }
        }
        com.tencent.mm.plugin.voip.b.e locale;
        if (paramBundle.value != com.tencent.mm.plugin.voip.c.euM().exx())
        {
          locale = com.tencent.mm.plugin.voip.b.e.Cln;
          com.tencent.mm.plugin.voip.b.e.ezy();
          locale = com.tencent.mm.plugin.voip.b.e.Cln;
          com.tencent.mm.plugin.voip.b.e.a(((PInt)localObject).value, true, paramBundle.value, com.tencent.mm.plugin.voip.c.euM().exx());
          if ((com.tencent.mm.plugin.voip.b.e.ezx()) && (com.tencent.mm.plugin.voip.c.euM().exx() != 0L))
          {
            ad.e("MicroMsg.Voip.VideoActivity", "fake calling comming and forbid itself");
            com.tencent.mm.plugin.voip.c.euM().aKp();
            super.finish();
            AppMethodBeat.o(115324);
          }
        }
        else
        {
          locale = com.tencent.mm.plugin.voip.b.e.Cln;
          com.tencent.mm.plugin.voip.b.e.ezz();
          locale = com.tencent.mm.plugin.voip.b.e.Cln;
          com.tencent.mm.plugin.voip.b.e.a(((PInt)localObject).value, false, paramBundle.value, com.tencent.mm.plugin.voip.c.euM().exx());
        }
        localObject = com.tencent.mm.plugin.voip.c.euM();
        if (((u)localObject).CdG != null)
        {
          ad.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
          localPString.value = ((u)localObject).CdG.getUserName();
          localPBool1.value = ((u)localObject).CdG.euG();
          localPBool2.value = ((u)localObject).CdG.euF();
          localPInt.value = ((u)localObject).CdG.getState();
          paramBundle = ((u)localObject).CdG;
          if (paramBundle == null)
          {
            ad.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
            com.tencent.mm.plugin.voip.c.euM().aKp();
            super.finish();
            AppMethodBeat.o(115324);
          }
        }
        else
        {
          if (localPString.value == null)
          {
            ad.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
            paramBundle = null;
            continue;
          }
          if ((!localPBool1.value) && (!((u)localObject).CdF.evW()))
          {
            ad.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
            localObject = localPString.value;
            if (localPBool2.value)
            {
              paramBundle = bu.IMe;
              if (!localPBool1.value) {
                break label1472;
              }
              i = 1;
              s.c((String)localObject, paramBundle, i, 4, aj.getContext().getString(2131764797));
              paramBundle = null;
              continue;
            }
            paramBundle = bu.IMd;
            continue;
          }
          if (com.tencent.mm.plugin.voip.b.h.ezF())
          {
            ((u)localObject).CdG = new NewVoipMgr();
            ((u)localObject).CdG.a(this, localPString.value, localPBool1.value, localPBool2.value, paramBundle.value);
            paramBundle = ((u)localObject).CdG;
            continue;
          }
          ((u)localObject).CdG = new VoipMgr();
          continue;
        }
        this.CiR = new WeakReference(paramBundle);
      }
      catch (Exception paramBundle)
      {
        com.tencent.mm.plugin.voip.b.f.UE(2);
        ad.printErrStackTrace("MicroMsg.Voip.VideoActivity", paramBundle, "", new Object[0]);
        AppMethodBeat.o(115324);
        return;
      }
      this.fGM = localPString.value;
      this.BYI = localPBool2.value;
      this.BYH = localPBool1.value;
      this.mStatus = localPInt.value;
      this.BYG = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.fGM);
      paramBundle = new Bundle();
      paramBundle.putString("key_username", this.BYG.field_username);
      paramBundle.putBoolean("key_isoutcall", this.BYH);
      paramBundle.putInt("key_status", com.tencent.mm.plugin.voip.b.l.aF(this.BYH, this.BYI));
      if (com.tencent.mm.plugin.voip.b.l.UO(this.mStatus)) {
        if (com.tencent.mm.plugin.voip.b.h.ezF())
        {
          this.CiQ = new NewVoipVideoFragment();
          this.CiQ.setArguments(paramBundle);
          getSupportFragmentManager().beginTransaction().b(2131306559, this.CiQ).commit();
          setTitleVisibility(8);
          if ((com.tencent.mm.plugin.voip.b.l.UP(this.mStatus)) && (this.BYH)) {
            this.jwD.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115315);
                if ((com.tencent.mm.plugin.voip.b.l.UP(VideoActivity.b(VideoActivity.this))) && (!VideoActivity.c(VideoActivity.this)) && (VideoActivity.d(VideoActivity.this) != null)) {
                  VideoActivity.d(VideoActivity.this).iv(2131764812, 10000);
                }
                AppMethodBeat.o(115315);
              }
            }, 20000L);
          }
          if (com.tencent.mm.plugin.voip.c.euM().CdG.euH() != null) {
            aDI(com.tencent.mm.plugin.voip.c.euM().CdG.euH());
          }
          this.uUL = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
          this.uUL.ac(9, "VOIPFloatBall");
          if ((this.CiR != null) && (this.CiR.get() != null)) {
            ((c)this.CiR.get()).a(this, 1);
          }
          this.CiQ.setVoipUIListener((c)this.CiR.get());
          this.CiQ.a(this);
          this.CiQ.setMute(this.mIsMute);
          ad.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[] { Boolean.valueOf(this.BYH), Boolean.valueOf(this.BYI), this.fGM, Integer.valueOf(this.mStatus) });
          if (!com.tencent.mm.plugin.voip.b.l.UO(this.mStatus)) {
            break label1426;
          }
          bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
          ad.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this });
          if (!bool) {
            ((c)this.CiR.get()).eva();
          }
          ad.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bt.flS(), this });
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.IbL.c(this.gGf);
        com.tencent.mm.sdk.b.a.IbL.c(this.vWV);
        if (com.tencent.mm.compatible.util.d.ly(17))
        {
          this.hqz = new Point();
          if (getWindow().getDecorView().getDisplay() != null) {
            getWindow().getDecorView().getDisplay().getRealSize(this.hqz);
          }
        }
        AppMethodBeat.o(115324);
        return;
        this.CiQ = new VoipVideoFragment();
        break;
        this.CiQ = new VoipVoiceFragment();
        break;
        label1426:
        ad.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bt.flS(), this });
      }
      label1472:
      int i = 0;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115331);
    this.CiV = 4;
    ad.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.UK(this.mStatus) });
    t localt = t.CdB;
    t.ewX();
    if (!this.uVF) {
      finish();
    }
    if ((this.CiR != null) && (this.CiR.get() != null)) {
      ((c)this.CiR.get()).a(this);
    }
    if (this.uUL != null) {
      this.uUL.onDestroy();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.gGf);
    com.tencent.mm.sdk.b.a.IbL.d(this.vWV);
    setScreenEnable(true);
    super.onDestroy();
    if (!this.CiU) {
      com.tencent.mm.media.g.c.hkn.atJ();
    }
    AppMethodBeat.o(115331);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(115329);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.mr(paramInt);
    localb.bd(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", this, localb.ahq());
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(115329);
      return true;
    }
    if (paramInt == 25)
    {
      if ((!com.tencent.mm.plugin.voip.c.euM().CdF.cae()) && (!this.BYH))
      {
        if ((this.CiR != null) && (this.CiR.get() != null)) {
          ((c)this.CiR.get()).evn();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.bGC().isBluetoothScoOn()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.bGy();; paramInt = ddZ())
      {
        com.tencent.mm.plugin.audio.c.a.xm(paramInt);
        break;
      }
    }
    if (paramInt == 24)
    {
      if ((!com.tencent.mm.plugin.voip.c.euM().CdF.cae()) && (!this.BYH))
      {
        ((c)this.CiR.get()).evn();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.bGC().isBluetoothScoOn()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.bGy();; paramInt = ddZ())
      {
        com.tencent.mm.plugin.audio.c.a.xl(paramInt);
        break;
      }
    }
    if ((ae.gcE.fYf == 1) && (paramInt == 700))
    {
      eyT();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(115329);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(115329);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(115336);
    ad.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(115336);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(115337);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)aj.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)aj.getContext().getSystemService("power");
    boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool3 = hasWindowFocus();
    boolean bool4 = localPowerManager.isScreenOn();
    if (((bool3) || (!bool2)) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.uVG = bool1;
      ad.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.UK(this.mStatus), Boolean.valueOf(this.uVG), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      AppMethodBeat.o(115337);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(115362);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(115362);
      return;
    }
    ad.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115362);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
        for (paramInt = 2131761860;; paramInt = 2131761871)
        {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new VideoActivity.3(this), new VideoActivity.4(this));
          AppMethodBeat.o(115362);
          return;
        }
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131755691), false, new VideoActivity.5(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(115338);
    ad.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.UK(this.mStatus) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    com.tencent.mm.plugin.voip.model.l locall = com.tencent.mm.plugin.voip.c.euM().CdF.BXC;
    if (locall.Cau) {
      locall.Cau = false;
    }
    super.onResume();
    if ((this.CiR != null) && (this.CiR.get() != null)) {
      ((c)this.CiR.get()).evf();
    }
    setScreenEnable(true);
    this.CiT = bt.HI();
    this.CiY = true;
    if ((this.CiR != null) && (this.CiR.get() != null)) {
      ((c)this.CiR.get()).evg();
    }
    if ((this.uUL != null) && (!this.CiW))
    {
      this.uUL.bKs();
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    AppMethodBeat.o(115338);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStart()
  {
    AppMethodBeat.i(115333);
    super.onStart();
    if (!this.uVF)
    {
      ad.i("MicroMsg.Voip.VideoActivity", "onStart");
      this.CiV = 1;
      iu(4096, this.mStatus);
    }
    AppMethodBeat.o(115333);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115332);
    this.CiV = 2;
    ad.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.UK(this.mStatus) });
    com.tencent.mm.plugin.report.service.g localg;
    if ((262 != this.mStatus) && (8 != this.mStatus) && (this.uVG) && (!this.CiW) && (!this.uVF) && (this.CiR != null) && (this.CiR.get() != null) && (((c)this.CiR.get()).tf(false)))
    {
      if (this.CiQ != null) {
        this.CiQ.eyU();
      }
      ax(false, true);
      if (com.tencent.mm.plugin.voip.b.l.UN(this.mStatus))
      {
        localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (!com.tencent.mm.plugin.voip.b.l.UO(this.mStatus)) {
          break label218;
        }
      }
    }
    label218:
    for (int i = 2;; i = 3)
    {
      localg.f(11618, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      if ((this.uUL != null) && (!this.CiW))
      {
        this.uUL.bgC();
        com.tencent.mm.plugin.ball.f.f.e(false, true, true);
      }
      super.onStop();
      AppMethodBeat.o(115332);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Deprecated
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115353);
    if (this.CiQ != null) {
      this.CiQ.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115353);
  }
  
  @Deprecated
  public final void requestRender()
  {
    AppMethodBeat.i(115352);
    if (this.CiQ != null) {
      this.CiQ.requestRender();
    }
    AppMethodBeat.o(115352);
  }
  
  @Deprecated
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115360);
    this.oXg = paramCaptureView;
    if (this.CiQ != null) {
      this.CiQ.a(paramCaptureView);
    }
    AppMethodBeat.o(115360);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115356);
    this.CiS = paramLong;
    if (this.CiQ != null) {
      this.CiQ.Bx(this.CiS);
    }
    AppMethodBeat.o(115356);
  }
  
  @Deprecated
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115349);
    if (this.CiQ != null) {
      this.CiQ.setHWDecMode(paramInt);
    }
    AppMethodBeat.o(115349);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115346);
    this.mIsMute = paramBoolean;
    if (this.CiQ != null) {
      this.CiQ.setMute(paramBoolean);
    }
    AppMethodBeat.o(115346);
  }
  
  public void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(115335);
    super.setScreenEnable(paramBoolean);
    if (this.CiR != null) {
      this.CiR.get();
    }
    AppMethodBeat.o(115335);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115345);
    if (this.BYM != -1) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.BYM = paramInt;
      if ((this.CiR != null) && (this.CiR.get() != null)) {
        ((c)this.CiR.get()).setVoicePlayDevice(paramInt);
      }
      if (this.CiQ != null) {
        this.CiQ.setVoicePlayDevice(paramInt);
      }
      AppMethodBeat.o(115345);
      return;
      Toast.makeText(getContext(), getContext().getString(2131764937), 0).show();
      continue;
      Toast.makeText(getContext(), getContext().getString(2131764936), 0).show();
    }
  }
  
  @Deprecated
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115348);
    if (this.CiQ != null) {
      this.CiQ.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115348);
  }
  
  public final void tr(boolean paramBoolean)
  {
    AppMethodBeat.i(115357);
    ad.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(paramBoolean)));
    if (this.CiQ != null) {
      this.CiQ.tt(paramBoolean);
    }
    AppMethodBeat.o(115357);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115355);
    if (this.CiQ != null) {
      this.CiQ.uninit();
    }
    AppMethodBeat.o(115355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity
 * JD-Core Version:    0.7.0.1
 */