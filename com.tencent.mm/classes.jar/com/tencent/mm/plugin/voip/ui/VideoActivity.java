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
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.model.NewVoipMgr;
import com.tencent.mm.plugin.voip.model.VoipMgr;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import java.lang.ref.WeakReference;

@i
@com.tencent.mm.ui.base.a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity
  extends MMActivity
  implements ServiceConnection, d.a, VoipBaseFragment.d, b
{
  private VoipBaseFragment AJP;
  private WeakReference<c> AJQ;
  private long AJR;
  private long AJS;
  private boolean AJT;
  private int AJU;
  private boolean AJV;
  private boolean AJW;
  private long AJX;
  @Deprecated
  com.tencent.mm.plugin.voip.video.b.a AJY;
  private com.tencent.mm.storage.ai AzG;
  private boolean AzH;
  private boolean AzI;
  private int AzM;
  private String foE;
  com.tencent.mm.plugin.mmsight.model.d gEn;
  private Point gYt;
  private com.tencent.mm.sdk.b.c gmw;
  private ao jdu;
  private boolean mIsMute;
  private int mStatus;
  private CaptureView otK;
  private boolean qEe;
  private com.tencent.mm.plugin.voip.a.b tRY;
  private boolean tSS;
  private boolean tST;
  private com.tencent.mm.sdk.b.c uTL;
  
  public VideoActivity()
  {
    AppMethodBeat.i(115323);
    this.AJR = -1L;
    this.qEe = false;
    this.AJS = 0L;
    this.AJT = false;
    this.AzM = -1;
    this.mIsMute = false;
    this.AJU = 1;
    this.tST = false;
    this.tSS = false;
    this.AJV = false;
    this.AJW = false;
    this.gmw = new VideoActivity.1(this);
    this.uTL = new VideoActivity.9(this);
    AppMethodBeat.o(115323);
  }
  
  private int cUO()
  {
    AppMethodBeat.i(115344);
    int i;
    if (com.tencent.mm.plugin.audio.c.a.bCx().isBluetoothScoOn())
    {
      i = com.tencent.mm.plugin.audio.c.a.bCt();
      AppMethodBeat.o(115344);
      return i;
    }
    if (!j.SU(this.mStatus))
    {
      i = 2;
      if (this.AzH) {
        if (!this.AzI)
        {
          if (ae.fJe.fDz < 0) {
            break label199;
          }
          i = ae.fJe.fDz;
        }
      }
    }
    for (;;)
    {
      int j = i;
      if (!com.tencent.mm.plugin.audio.c.a.bCy())
      {
        j = i;
        if (ae.fJe.fDB < 0) {}
      }
      for (j = ae.fJe.fDB;; j = com.tencent.mm.plugin.voip.c.ehb().aKj())
      {
        ac.i("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(115344);
        return j;
        i = 3;
        if (com.tencent.mm.plugin.audio.c.a.bCs())
        {
          if (ae.fJe.fDz < 0) {
            break label199;
          }
          i = ae.fJe.fDz;
          break;
        }
        if (ae.fJe.fDw < 0) {
          break;
        }
        i = ae.fJe.fDw;
        break;
        if (!com.tencent.mm.plugin.audio.c.a.bCs()) {
          break;
        }
        if (ae.fJe.fDz < 0) {
          break label199;
        }
        i = ae.fJe.fDz;
        break;
      }
      label199:
      i = 0;
    }
  }
  
  private static boolean dgh()
  {
    AppMethodBeat.i(115326);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("phone");
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
        ac.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ac.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
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
  
  private void ehH()
  {
    AppMethodBeat.i(115327);
    this.jdu.postDelayed(new Runnable()
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
  
  private void elj()
  {
    AppMethodBeat.i(115330);
    if ((this.AJQ != null) && (this.AJQ.get() != null) && (!this.AzH))
    {
      if (!this.AzI) {
        break label91;
      }
      ((c)this.AJQ.get()).ehp();
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.voip.c.ehb().cUz) && (this.AzI)) {
        ((c)this.AJQ.get()).ehz();
      }
      AppMethodBeat.o(115330);
      return;
      label91:
      ((c)this.AJQ.get()).ehs();
    }
  }
  
  @Deprecated
  public final com.tencent.mm.plugin.voip.video.b.a SD(int paramInt)
  {
    AppMethodBeat.i(115340);
    if (((this.AJP instanceof VoipVideoFragment)) && (this.AJP.ell() != null)) {
      this.AJP.ell().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            VideoActivity.this.AJY = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.AJY;
    AppMethodBeat.o(115340);
    return locala;
  }
  
  public final void SE(int paramInt)
  {
    AppMethodBeat.i(208468);
    if (this.AJP != null) {
      this.AJP.SE(paramInt);
    }
    AppMethodBeat.o(208468);
  }
  
  public final void SF(int paramInt)
  {
    AppMethodBeat.i(208469);
    if (this.AJP != null) {
      this.AJP.SF(paramInt);
    }
    AppMethodBeat.o(208469);
  }
  
  @Deprecated
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.f.d paramd)
  {
    AppMethodBeat.i(115351);
    if (this.AJP != null) {
      this.AJP.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115351);
  }
  
  @Deprecated
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(208464);
    if (this.AJP != null) {
      this.AJP.b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(208464);
  }
  
  public final void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115359);
    this.AJT = paramBoolean2;
    if (paramBoolean1)
    {
      ehH();
      AppMethodBeat.o(115359);
      return;
    }
    finish();
    AppMethodBeat.o(115359);
  }
  
  public final void ayA(final String paramString)
  {
    AppMethodBeat.i(115342);
    if (this.AJP != null) {
      this.jdu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115320);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).ayA(paramString);
          }
          AppMethodBeat.o(115320);
        }
      });
    }
    AppMethodBeat.o(115342);
  }
  
  public final void cVN()
  {
    AppMethodBeat.i(115358);
    ac.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
    if (this.AJP != null) {
      this.AJP.elc();
    }
    AppMethodBeat.o(115358);
  }
  
  public final void cg(final int paramInt, String paramString)
  {
    AppMethodBeat.i(115341);
    ac.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.AzI) });
    this.qEe = true;
    if (paramInt == 241)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, null, true);
      AppMethodBeat.o(115341);
      return;
    }
    this.jdu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208463);
        VideoActivity.a(VideoActivity.this, paramInt);
        AppMethodBeat.o(208463);
      }
    });
    AppMethodBeat.o(115341);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(115343);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bb(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V", this, localb.aeE());
    aj.m(aj.a(getWindow(), null), getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(paramView, 0);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V");
    AppMethodBeat.o(115343);
  }
  
  public final void dgi() {}
  
  @Deprecated
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115347);
    if (this.AJP != null) {
      this.AJP.e(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115347);
  }
  
  @Deprecated
  public final void ekW()
  {
    AppMethodBeat.i(115361);
    if ((this.AJP instanceof VoipVideoFragment)) {
      ((VoipVideoFragment)this.AJP).ekW();
    }
    AppMethodBeat.o(115361);
  }
  
  public final Context ekX()
  {
    AppMethodBeat.i(115354);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(115354);
    return localAppCompatActivity;
  }
  
  public final void ekY()
  {
    AppMethodBeat.i(208466);
    if (this.AJP != null) {
      this.AJP.ekY();
    }
    AppMethodBeat.o(208466);
  }
  
  public final void ekZ()
  {
    AppMethodBeat.i(208467);
    if (this.AJP != null) {
      this.AJP.ekZ();
    }
    AppMethodBeat.o(208467);
  }
  
  public final void ela()
  {
    AppMethodBeat.i(208465);
    if (this.AJP != null) {
      this.AJP.ela();
    }
    AppMethodBeat.o(208465);
  }
  
  public void finish()
  {
    AppMethodBeat.i(115334);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V", this);
    this.AJU = 3;
    ac.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[] { Boolean.valueOf(this.AJT), j.SR(this.mStatus) });
    Object localObject;
    if ((!this.AJT) && (j.SU(this.mStatus)) && (4 != this.AJU))
    {
      ac.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.foE);
      com.tencent.mm.plugin.voip.d.iyx.d((Intent)localObject, this);
    }
    int i;
    if (this.AJW)
    {
      this.AJW = false;
      int j = com.tencent.mm.plugin.voip.c.ehb().ejL();
      long l = com.tencent.mm.plugin.voip.c.ehb().ejM();
      if (this.AzH)
      {
        i = 0;
        com.tencent.mm.plugin.voip.b.d.c(j, l, i, 5);
        com.tencent.mm.plugin.voip.b.d.SL(1);
      }
    }
    else
    {
      if (this.gEn != null)
      {
        this.gEn.disable();
        this.gEn.uKw = null;
        this.gEn = null;
      }
      if (this.AJP == null) {
        break label379;
      }
      if (this.AJP.AKf != 4105) {
        break label374;
      }
      i = 1;
      label229:
      this.AJP.uninit();
      this.AJP = null;
    }
    for (;;)
    {
      this.AJQ = null;
      this.otK = null;
      this.tSS = true;
      super.finish();
      if (i != 0)
      {
        localObject = new jx();
        ((jx)localObject).dlw.dlz = true;
        ((jx)localObject).dlw.dly = this.AJX;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        VoipBaseFragment.AKg = -1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V");
        AppMethodBeat.o(115334);
        return;
        i = 1;
        break;
        localObject = new jx();
        ((jx)localObject).dlw.dlz = false;
        ((jx)localObject).dlw.dly = 0L;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
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
  public final void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115350);
    if (this.AJP != null) {
      this.AJP.ie(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115350);
  }
  
  public final void ih(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115328);
    this.mStatus = paramInt2;
    if ((1 != this.AJU) && (paramInt2 != 8) && (paramInt2 != 262))
    {
      ac.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
      AppMethodBeat.o(115328);
      return;
    }
    if (this.AJP == null)
    {
      ac.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
      AppMethodBeat.o(115328);
      return;
    }
    this.AJP.ih(paramInt1, paramInt2);
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
      this.AzI = false;
      if ((this.AJP == null) || (!(this.AJP instanceof VoipVoiceFragment)))
      {
        if (this.AJP != null)
        {
          this.AJP.uninit();
          getSupportFragmentManager().beginTransaction().a(this.AJP).commit();
          this.AJP = null;
        }
        ac.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_username", this.AzG.field_username);
        ((Bundle)localObject).putBoolean("key_isoutcall", this.AzH);
        ((Bundle)localObject).putInt("key_status", this.mStatus);
        this.AJP = new VoipVoiceFragment();
        this.AJP.setArguments((Bundle)localObject);
        this.AJP.setVoipUIListener((c)this.AJQ.get());
        this.AJP.yQ(this.AJR);
        this.AJP.a(this);
        this.AJP.setVoicePlayDevice(this.AzM);
        this.AJP.setMute(this.mIsMute);
        getSupportFragmentManager().beginTransaction().b(2131306559, this.AJP).commit();
      }
      AppMethodBeat.o(115328);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      ehH();
      ac.d("MicroMsg.Voip.VideoActivity", "finishSmallWindow mStatus: %s", new Object[] { j.SR(this.mStatus) });
      if ((this.mStatus != 262) && (this.mStatus != 8)) {
        break;
      }
      com.tencent.mm.plugin.voip.c.ehc().qD(true);
      break;
      if (this.AzH)
      {
        localObject = this.AJP;
        if (!this.AzI) {
          break label523;
        }
      }
      label523:
      for (paramInt1 = 2131764931;; paramInt1 = 2131764789)
      {
        ((VoipBaseFragment)localObject).ii(paramInt1, -1);
        ehH();
        break;
      }
      this.jdu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115321);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).ii(2131764918, -1);
          }
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115321);
        }
      });
      continue;
      this.jdu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115311);
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115311);
        }
      });
      continue;
      this.jdu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115317);
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115317);
        }
      }, 50L);
      continue;
      ehH();
      continue;
      finish();
    }
  }
  
  public final void nm(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(208470);
    paramInt = i;
    switch (((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation())
    {
    }
    for (paramInt = i;; paramInt = 180)
    {
      if ((this.AJQ != null) && (this.AJQ.get() != null) && (this.AJP != null)) {
        ((c)this.AJQ.get()).nm(paramInt);
      }
      AppMethodBeat.o(208470);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(115325);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.gYt != null) && (com.tencent.mm.compatible.util.d.kZ(17)))
    {
      paramConfiguration = new Point();
      getWindowManager().getDefaultDisplay().getRealSize(paramConfiguration);
      if ((!paramConfiguration.equals(this.gYt)) && (this.AJP != null))
      {
        this.gYt = paramConfiguration;
        this.AJP.eld();
      }
    }
    AppMethodBeat.o(115325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
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
        paramBundle = t.AEB;
        t.ejl();
        com.tencent.mm.util.b.fwU();
        setActionbarColor(getResources().getColor(2131101053));
        if (!com.tencent.mm.plugin.voip.b.l.gy(getContext())) {
          com.tencent.mm.plugin.voip.b.l.gz(getContext());
        }
        ac.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(3);
        this.gEn = new com.tencent.mm.plugin.mmsight.model.d(this);
        this.gEn.enable();
        this.gEn.uKw = this;
        getWindow().addFlags(6815872);
        if (com.tencent.mm.kernel.g.agM()) {
          com.tencent.mm.plugin.voip.c.ehb().aq(false, false);
        }
        this.jdu = new ao();
        localPBool1 = new PBool();
        localPBool2 = new PBool();
        localPString = new PString();
        localPInt = new PInt();
        localPString.value = getIntent().getStringExtra("Voip_User");
        localPBool1.value = getIntent().getBooleanExtra("Voip_Outcall", true);
        localPBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.AJX = getIntent().getLongExtra("Voip_LastPage_Hash", 0L);
        localPInt.value = j.ay(localPBool1.value, localPBool2.value);
        bool = localPBool1.value;
        if (bool) {
          try
          {
            if ((dgh()) && (!isFinishing()))
            {
              Toast.makeText(this, 2131764869, 0).show();
              ac.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
              com.tencent.mm.plugin.voip.c.ehb().aHe();
              super.finish();
              AppMethodBeat.o(115324);
              return;
            }
          }
          catch (Exception paramBundle)
          {
            ac.e("MicroMsg.Voip.VideoActivity", "not ready now!");
          }
        }
        paramBundle = com.tencent.mm.plugin.voip.c.ehb();
        if (paramBundle.AEG != null)
        {
          ac.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
          localPString.value = paramBundle.AEG.getUserName();
          localPBool1.value = paramBundle.AEG.egV();
          localPBool2.value = paramBundle.AEG.egU();
          localPInt.value = paramBundle.AEG.getState();
          paramBundle = paramBundle.AEG;
          if (paramBundle == null)
          {
            ac.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
            com.tencent.mm.plugin.voip.c.ehb().aHe();
            super.finish();
            AppMethodBeat.o(115324);
          }
        }
        else
        {
          if (localPString.value == null)
          {
            ac.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
            paramBundle = null;
            continue;
          }
          if ((!localPBool1.value) && (!paramBundle.AEF.eil()))
          {
            ac.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
            String str = localPString.value;
            if (localPBool2.value)
            {
              paramBundle = bo.GYP;
              if (!localPBool1.value) {
                break label1287;
              }
              s.c(str, paramBundle, i, 4, com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764797));
              paramBundle = null;
              continue;
            }
            paramBundle = bo.GYO;
            continue;
          }
          if (com.tencent.mm.plugin.voip.b.f.elM())
          {
            paramBundle.AEG = new NewVoipMgr();
            paramBundle.AEG.a(this, localPString.value, localPBool1.value, localPBool2.value);
            paramBundle = paramBundle.AEG;
            continue;
          }
          paramBundle.AEG = new VoipMgr();
          continue;
        }
        this.AJQ = new WeakReference(paramBundle);
      }
      catch (Exception paramBundle)
      {
        com.tencent.mm.plugin.voip.b.d.SL(2);
        ac.printErrStackTrace("MicroMsg.Voip.VideoActivity", paramBundle, "", new Object[0]);
        AppMethodBeat.o(115324);
        return;
      }
      this.foE = localPString.value;
      this.AzI = localPBool2.value;
      this.AzH = localPBool1.value;
      this.mStatus = localPInt.value;
      this.AzG = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.foE);
      paramBundle = new Bundle();
      paramBundle.putString("key_username", this.AzG.field_username);
      paramBundle.putBoolean("key_isoutcall", this.AzH);
      paramBundle.putInt("key_status", j.ay(this.AzH, this.AzI));
      if (j.SV(this.mStatus)) {
        if (com.tencent.mm.plugin.voip.b.f.elM())
        {
          this.AJP = new NewVoipVideoFragment();
          this.AJP.setArguments(paramBundle);
          getSupportFragmentManager().beginTransaction().b(2131306559, this.AJP).commit();
          setTitleVisibility(8);
          if ((j.SW(this.mStatus)) && (this.AzH)) {
            this.jdu.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115315);
                if ((j.SW(VideoActivity.b(VideoActivity.this))) && (!VideoActivity.c(VideoActivity.this)) && (VideoActivity.d(VideoActivity.this) != null)) {
                  VideoActivity.d(VideoActivity.this).ii(2131764812, 10000);
                }
                AppMethodBeat.o(115315);
              }
            }, 20000L);
          }
          if (com.tencent.mm.plugin.voip.c.ehb().AEG.egW() != null) {
            ayA(com.tencent.mm.plugin.voip.c.ehb().AEG.egW());
          }
          this.tRY = new com.tencent.mm.plugin.voip.a.b(new e(this));
          this.tRY.aa(9, "VOIPFloatBall");
          if ((this.AJQ != null) && (this.AJQ.get() != null)) {
            ((c)this.AJQ.get()).a(this, 1);
          }
          this.AJP.setVoipUIListener((c)this.AJQ.get());
          this.AJP.a(this);
          this.AJP.setMute(this.mIsMute);
          ac.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[] { Boolean.valueOf(this.AzH), Boolean.valueOf(this.AzI), this.foE, Integer.valueOf(this.mStatus) });
          if (!j.SV(this.mStatus)) {
            break label1241;
          }
          bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
          ac.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this });
          if (!bool) {
            ((c)this.AJQ.get()).ehq();
          }
          ac.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bs.eWi(), this });
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.GpY.c(this.gmw);
        com.tencent.mm.sdk.b.a.GpY.c(this.uTL);
        if (com.tencent.mm.compatible.util.d.kZ(17))
        {
          this.gYt = new Point();
          if (getWindow().getDecorView().getDisplay() != null) {
            getWindow().getDecorView().getDisplay().getRealSize(this.gYt);
          }
        }
        AppMethodBeat.o(115324);
        return;
        this.AJP = new VoipVideoFragment();
        break;
        this.AJP = new VoipVoiceFragment();
        break;
        label1241:
        ac.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bs.eWi(), this });
      }
      label1287:
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115331);
    this.AJU = 4;
    ac.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[] { j.SR(this.mStatus) });
    t localt = t.AEB;
    t.ejm();
    if (!this.tSS) {
      finish();
    }
    if ((this.AJQ != null) && (this.AJQ.get() != null)) {
      ((c)this.AJQ.get()).a(this);
    }
    if (this.tRY != null) {
      this.tRY.onDestroy();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.gmw);
    com.tencent.mm.sdk.b.a.GpY.d(this.uTL);
    setScreenEnable(true);
    super.onDestroy();
    if (!this.AJT) {
      com.tencent.mm.media.f.c.gRV.aqV();
    }
    AppMethodBeat.o(115331);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(115329);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.lS(paramInt);
    localb.bb(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", this, localb.aeE());
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(115329);
      return true;
    }
    if (paramInt == 25)
    {
      if ((!com.tencent.mm.plugin.voip.c.ehb().AEF.bVB()) && (!this.AzH))
      {
        if ((this.AJQ != null) && (this.AJQ.get() != null)) {
          ((c)this.AJQ.get()).ehD();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.bCx().isBluetoothScoOn()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.bCt();; paramInt = cUO())
      {
        com.tencent.mm.plugin.audio.c.a.wG(paramInt);
        break;
      }
    }
    if (paramInt == 24)
    {
      if ((!com.tencent.mm.plugin.voip.c.ehb().AEF.bVB()) && (!this.AzH))
      {
        ((c)this.AJQ.get()).ehD();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.bCx().isBluetoothScoOn()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.bCt();; paramInt = cUO())
      {
        com.tencent.mm.plugin.audio.c.a.wF(paramInt);
        break;
      }
    }
    if ((ae.fJd.fEG == 1) && (paramInt == 700))
    {
      elj();
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
    ac.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(115336);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(115337);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("power");
    boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool3 = hasWindowFocus();
    boolean bool4 = localPowerManager.isScreenOn();
    if (((bool3) || (!bool2)) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.tST = bool1;
      ac.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[] { j.SR(this.mStatus), Boolean.valueOf(this.tST), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      AppMethodBeat.o(115337);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(115362);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(115362);
      return;
    }
    ac.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
    ac.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[] { j.SR(this.mStatus) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    com.tencent.mm.plugin.voip.model.l locall = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh;
    if (locall.ABv) {
      locall.ABv = false;
    }
    super.onResume();
    if ((this.AJQ != null) && (this.AJQ.get() != null)) {
      ((c)this.AJQ.get()).ehv();
    }
    setScreenEnable(true);
    this.AJS = bs.Gn();
    this.AJW = true;
    if ((this.AJQ != null) && (this.AJQ.get() != null)) {
      ((c)this.AJQ.get()).ehw();
    }
    if (this.tRY != null)
    {
      this.tRY.bGh();
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
    if (!this.tSS)
    {
      ac.i("MicroMsg.Voip.VideoActivity", "onStart");
      this.AJU = 1;
      ih(4096, this.mStatus);
    }
    AppMethodBeat.o(115333);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115332);
    this.AJU = 2;
    ac.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[] { j.SR(this.mStatus) });
    com.tencent.mm.plugin.report.service.h localh;
    if ((262 != this.mStatus) && (8 != this.mStatus) && (this.tST) && (!this.tSS) && (this.AJQ != null) && (this.AJQ.get() != null) && (((c)this.AJQ.get()).sw(false)))
    {
      if (this.AJP != null) {
        this.AJP.elk();
      }
      as(false, true);
      if (j.SU(this.mStatus))
      {
        localh = com.tencent.mm.plugin.report.service.h.wUl;
        if (!j.SV(this.mStatus)) {
          break label204;
        }
      }
    }
    label204:
    for (int i = 2;; i = 3)
    {
      localh.f(11618, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      if (this.tRY != null)
      {
        this.tRY.bcY();
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
    if (this.AJP != null) {
      this.AJP.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115353);
  }
  
  @Deprecated
  public final void requestRender()
  {
    AppMethodBeat.i(115352);
    if (this.AJP != null) {
      this.AJP.requestRender();
    }
    AppMethodBeat.o(115352);
  }
  
  public final void sI(boolean paramBoolean)
  {
    AppMethodBeat.i(115357);
    ac.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(paramBoolean)));
    if (this.AJP != null) {
      this.AJP.sK(paramBoolean);
    }
    AppMethodBeat.o(115357);
  }
  
  @Deprecated
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115360);
    this.otK = paramCaptureView;
    if (this.AJP != null) {
      this.AJP.a(paramCaptureView);
    }
    AppMethodBeat.o(115360);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115356);
    this.AJR = paramLong;
    if (this.AJP != null) {
      this.AJP.yQ(this.AJR);
    }
    AppMethodBeat.o(115356);
  }
  
  @Deprecated
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115349);
    if (this.AJP != null) {
      this.AJP.setHWDecMode(paramInt);
    }
    AppMethodBeat.o(115349);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115346);
    this.mIsMute = paramBoolean;
    if (this.AJP != null) {
      this.AJP.setMute(paramBoolean);
    }
    AppMethodBeat.o(115346);
  }
  
  public void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(115335);
    super.setScreenEnable(paramBoolean);
    if (this.AJQ != null) {
      this.AJQ.get();
    }
    AppMethodBeat.o(115335);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115345);
    if (this.AzM != -1) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.AzM = paramInt;
      if ((this.AJQ != null) && (this.AJQ.get() != null)) {
        ((c)this.AJQ.get()).setVoicePlayDevice(paramInt);
      }
      if (this.AJP != null) {
        this.AJP.setVoicePlayDevice(paramInt);
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
    if (this.AJP != null) {
      this.AJP.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115348);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115355);
    if (this.AJP != null) {
      this.AJP.uninit();
    }
    AppMethodBeat.o(115355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity
 * JD-Core Version:    0.7.0.1
 */