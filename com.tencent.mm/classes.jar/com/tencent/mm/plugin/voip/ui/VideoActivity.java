package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.tencent.mm.g.a.jp;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.mmsight.model.d.a;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import java.lang.ref.WeakReference;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity
  extends MMActivity
  implements ServiceConnection, d.a, VoipBaseFragment.d, b
{
  private String flk;
  private Point gxV;
  private ap iDu;
  private boolean mIsMute;
  private int mStatus;
  private boolean pVz;
  private com.tencent.mm.plugin.voip.a.b sKs;
  private boolean sLn;
  private boolean sLo;
  com.tencent.mm.plugin.mmsight.model.d tKW;
  private com.tencent.mm.sdk.b.c tLh;
  private af zgX;
  private boolean zgY;
  private boolean zgZ;
  private int zhd;
  private CaptureView zlf;
  private VoipBaseFragment zrc;
  private WeakReference<c> zrd;
  private long zre;
  private long zrf;
  private boolean zrg;
  private int zrh;
  private boolean zri;
  private VideoActivity.ScreenActionReceiver zrj;
  private boolean zrk;
  private com.tencent.mm.sdk.b.c zrl;
  private long zrm;
  @Deprecated
  com.tencent.mm.plugin.voip.video.b.a zrn;
  
  public VideoActivity()
  {
    AppMethodBeat.i(115323);
    this.zre = -1L;
    this.pVz = false;
    this.zrf = 0L;
    this.zrg = false;
    this.zhd = -1;
    this.mIsMute = false;
    this.zrh = 1;
    this.sLo = false;
    this.sLn = false;
    this.zri = false;
    this.zrk = false;
    this.zrl = new VideoActivity.1(this);
    this.tLh = new VideoActivity.9(this);
    AppMethodBeat.o(115323);
  }
  
  private int cHD()
  {
    AppMethodBeat.i(115344);
    int i;
    if (com.tencent.mm.plugin.audio.c.a.bvC())
    {
      i = com.tencent.mm.plugin.audio.c.a.bvx();
      AppMethodBeat.o(115344);
      return i;
    }
    if (!com.tencent.mm.plugin.voip.b.i.QL(this.mStatus))
    {
      i = 2;
      if (this.zgY) {
        if (!this.zgZ)
        {
          if (ae.fFx.fzS < 0) {
            break label196;
          }
          i = ae.fFx.fzS;
        }
      }
    }
    for (;;)
    {
      int j = i;
      if (!com.tencent.mm.plugin.audio.c.a.bvC())
      {
        j = i;
        if (ae.fFx.fzU < 0) {}
      }
      for (j = ae.fFx.fzU;; j = com.tencent.mm.plugin.voip.c.dRQ().aDs())
      {
        ad.i("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(115344);
        return j;
        i = 3;
        if (com.tencent.mm.plugin.audio.c.a.bvw())
        {
          if (ae.fFx.fzS < 0) {
            break label196;
          }
          i = ae.fFx.fzS;
          break;
        }
        if (ae.fFx.fzP < 0) {
          break;
        }
        i = ae.fFx.fzP;
        break;
        if (!com.tencent.mm.plugin.audio.c.a.bvw()) {
          break;
        }
        if (ae.fFx.fzS < 0) {
          break label196;
        }
        i = ae.fFx.fzS;
        break;
      }
      label196:
      i = 0;
    }
  }
  
  private static boolean cSy()
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
  
  private void dSv()
  {
    AppMethodBeat.i(115327);
    this.iDu.postDelayed(new Runnable()
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
  
  private void dVX()
  {
    AppMethodBeat.i(115330);
    if ((this.zrd != null) && (this.zrd.get() != null) && (!this.zgY))
    {
      if (!this.zgZ) {
        break label91;
      }
      ((c)this.zrd.get()).dSd();
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.voip.c.dRQ().cXd) && (this.zgZ)) {
        ((c)this.zrd.get()).dSn();
      }
      AppMethodBeat.o(115330);
      return;
      label91:
      ((c)this.zrd.get()).dSg();
    }
  }
  
  @Deprecated
  public final com.tencent.mm.plugin.voip.video.b.a Qu(int paramInt)
  {
    AppMethodBeat.i(115340);
    if (((this.zrc instanceof VoipVideoFragment)) && (this.zrc != null) && (this.zrc.dVZ() != null)) {
      this.zrc.dVZ().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            VideoActivity.this.zrn = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.zrn;
    AppMethodBeat.o(115340);
    return locala;
  }
  
  public final void Qv(int paramInt)
  {
    AppMethodBeat.i(192140);
    if (this.zrc != null) {
      this.zrc.Qv(paramInt);
    }
    AppMethodBeat.o(192140);
  }
  
  public final void Qw(int paramInt)
  {
    AppMethodBeat.i(192141);
    if (this.zrc != null) {
      this.zrc.Qw(paramInt);
    }
    AppMethodBeat.o(192141);
  }
  
  @Deprecated
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.f.d paramd)
  {
    AppMethodBeat.i(115351);
    if (this.zrc != null) {
      this.zrc.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115351);
  }
  
  @Deprecated
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(192137);
    if (this.zrc != null) {
      this.zrc.b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(192137);
  }
  
  public final void ao(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115359);
    this.zrg = paramBoolean2;
    if (paramBoolean1)
    {
      dSv();
      AppMethodBeat.o(115359);
      return;
    }
    finish();
    AppMethodBeat.o(115359);
  }
  
  public final void atj(final String paramString)
  {
    AppMethodBeat.i(115342);
    if (this.zrc != null) {
      this.iDu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115320);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).atj(paramString);
          }
          AppMethodBeat.o(115320);
        }
      });
    }
    AppMethodBeat.o(115342);
  }
  
  public final void cIC()
  {
    AppMethodBeat.i(115358);
    ad.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
    if (this.zrc != null) {
      this.zrc.dVQ();
    }
    AppMethodBeat.o(115358);
  }
  
  public final void cSz() {}
  
  public final void cd(final int paramInt, String paramString)
  {
    AppMethodBeat.i(115341);
    ad.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.zgZ) });
    this.pVz = true;
    if (paramInt == 241)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, null, true);
      AppMethodBeat.o(115341);
      return;
    }
    this.iDu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192136);
        VideoActivity.a(VideoActivity.this, paramInt);
        AppMethodBeat.o(192136);
      }
    });
    AppMethodBeat.o(115341);
  }
  
  @Deprecated
  public final void dVK()
  {
    AppMethodBeat.i(115361);
    if ((this.zrc instanceof VoipVideoFragment)) {
      ((VoipVideoFragment)this.zrc).dVK();
    }
    AppMethodBeat.o(115361);
  }
  
  public final Context dVM()
  {
    AppMethodBeat.i(115354);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(115354);
    return localAppCompatActivity;
  }
  
  public final void dVN()
  {
    AppMethodBeat.i(192138);
    if (this.zrc != null) {
      this.zrc.dVN();
    }
    AppMethodBeat.o(192138);
  }
  
  public final void dVO()
  {
    AppMethodBeat.i(192139);
    if (this.zrc != null) {
      this.zrc.dVO();
    }
    AppMethodBeat.o(192139);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(115343);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.be(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V", this, localb.ado());
    ai.l(ai.a(getWindow(), null), getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(paramView, 0);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V");
    AppMethodBeat.o(115343);
  }
  
  @Deprecated
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115347);
    if (this.zrc != null) {
      this.zrc.e(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115347);
  }
  
  public void finish()
  {
    AppMethodBeat.i(115334);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V", this);
    this.zrh = 3;
    ad.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[] { Boolean.valueOf(this.zrg), com.tencent.mm.plugin.voip.b.i.QI(this.mStatus) });
    Object localObject;
    if ((!this.zrg) && (com.tencent.mm.plugin.voip.b.i.QL(this.mStatus)) && (4 != this.zrh))
    {
      ad.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.flk);
      com.tencent.mm.plugin.voip.d.hYt.d((Intent)localObject, this);
    }
    int i;
    if (this.zrk)
    {
      this.zrk = false;
      int j = com.tencent.mm.plugin.voip.c.dRQ().dUz();
      long l = com.tencent.mm.plugin.voip.c.dRQ().dUA();
      if (this.zgY)
      {
        i = 0;
        com.tencent.mm.plugin.voip.b.c.c(j, l, i, 5);
        com.tencent.mm.plugin.voip.b.c.QC(1);
      }
    }
    else
    {
      if (this.tKW != null)
      {
        this.tKW.disable();
        this.tKW.tBZ = null;
        this.tKW = null;
      }
      if (this.zrc == null) {
        break label379;
      }
      if (this.zrc.zru != 4105) {
        break label374;
      }
      i = 1;
      label229:
      this.zrc.uninit();
      this.zrc = null;
    }
    for (;;)
    {
      this.zrd = null;
      this.zlf = null;
      this.sLn = true;
      super.finish();
      if (i != 0)
      {
        localObject = new jp();
        ((jp)localObject).dnN.dnQ = true;
        ((jp)localObject).dnN.dnP = this.zrm;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        VoipBaseFragment.zrv = -1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V");
        AppMethodBeat.o(115334);
        return;
        i = 1;
        break;
        localObject = new jp();
        ((jp)localObject).dnN.dnQ = false;
        ((jp)localObject).dnN.dnP = 0L;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
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
  public final void hP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115350);
    if (this.zrc != null) {
      this.zrc.hP(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115350);
  }
  
  public final void hS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115328);
    this.mStatus = paramInt2;
    if ((1 != this.zrh) && (paramInt2 != 8) && (paramInt2 != 262))
    {
      ad.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
      AppMethodBeat.o(115328);
      return;
    }
    if (this.zrc == null)
    {
      ad.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
      AppMethodBeat.o(115328);
      return;
    }
    this.zrc.hS(paramInt1, paramInt2);
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
      this.zgZ = false;
      if ((this.zrc == null) || (!(this.zrc instanceof VoipVoiceFragment)))
      {
        if (this.zrc != null)
        {
          this.zrc.uninit();
          getSupportFragmentManager().beginTransaction().b(this.zrc).commit();
          this.zrc = null;
        }
        ad.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_username", this.zgX.field_username);
        ((Bundle)localObject).putBoolean("key_isoutcall", this.zgY);
        ((Bundle)localObject).putInt("key_status", this.mStatus);
        this.zrc = new VoipVoiceFragment();
        this.zrc.setArguments((Bundle)localObject);
        this.zrc.setVoipUIListener((c)this.zrd.get());
        this.zrc.un(this.zre);
        this.zrc.a(this);
        this.zrc.setVoicePlayDevice(this.zhd);
        this.zrc.setMute(this.mIsMute);
        getSupportFragmentManager().beginTransaction().b(2131306559, this.zrc).commit();
      }
      AppMethodBeat.o(115328);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      dSv();
      ad.d("MicroMsg.Voip.VideoActivity", "finishSmallWindow mStatus: %s", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(this.mStatus) });
      if ((this.mStatus != 262) && (this.mStatus != 8)) {
        break;
      }
      com.tencent.mm.plugin.voip.c.dRR().pE(true);
      break;
      if (this.zgY)
      {
        localObject = this.zrc;
        if (!this.zgZ) {
          break label523;
        }
      }
      label523:
      for (paramInt1 = 2131764931;; paramInt1 = 2131764789)
      {
        ((VoipBaseFragment)localObject).hT(paramInt1, -1);
        dSv();
        break;
      }
      this.iDu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115321);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).hT(2131764918, -1);
          }
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115321);
        }
      });
      continue;
      this.iDu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115311);
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115311);
        }
      });
      continue;
      this.iDu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115317);
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115317);
        }
      }, 50L);
      continue;
      dSv();
      continue;
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(115325);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.gxV != null) && (com.tencent.mm.compatible.util.d.lf(17)))
    {
      paramConfiguration = new Point();
      getWindowManager().getDefaultDisplay().getRealSize(paramConfiguration);
      if ((!paramConfiguration.equals(this.gxV)) && (this.zrc != null))
      {
        this.gxV = paramConfiguration;
        this.zrc.dVR();
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
        paramBundle = t.zlN;
        t.dTZ();
        com.tencent.mm.util.b.fgU();
        setActionbarColor(getResources().getColor(2131101053));
        if (!com.tencent.mm.plugin.voip.b.k.gm(getContext())) {
          com.tencent.mm.plugin.voip.b.k.gn(getContext());
        }
        ad.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(3);
        this.tKW = new com.tencent.mm.plugin.mmsight.model.d(this);
        this.tKW.enable();
        this.tKW.tBZ = this;
        getWindow().addFlags(6815872);
        if (com.tencent.mm.kernel.g.afw()) {
          com.tencent.mm.plugin.voip.c.dRQ().am(false, false);
        }
        this.iDu = new ap();
        localPBool1 = new PBool();
        localPBool2 = new PBool();
        localPString = new PString();
        localPInt = new PInt();
        localPString.value = getIntent().getStringExtra("Voip_User");
        localPBool1.value = getIntent().getBooleanExtra("Voip_Outcall", true);
        localPBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.zrm = getIntent().getLongExtra("Voip_LastPage_Hash", 0L);
        localPInt.value = com.tencent.mm.plugin.voip.b.i.au(localPBool1.value, localPBool2.value);
        bool = localPBool1.value;
        if (bool) {
          try
          {
            if ((cSy()) && (!isFinishing()))
            {
              Toast.makeText(this, 2131764869, 0).show();
              ad.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
              com.tencent.mm.plugin.voip.c.dRQ().aAo();
              super.finish();
              AppMethodBeat.o(115324);
              return;
            }
          }
          catch (Exception paramBundle)
          {
            ad.e("MicroMsg.Voip.VideoActivity", "not ready now!");
          }
        }
        paramBundle = com.tencent.mm.plugin.voip.c.dRQ();
        if (paramBundle.zlS != null)
        {
          ad.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
          localPString.value = paramBundle.zlS.getUserName();
          localPBool1.value = paramBundle.zlS.dRK();
          localPBool2.value = paramBundle.zlS.dRJ();
          localPInt.value = paramBundle.zlS.getState();
          paramBundle = paramBundle.zlS;
          if (paramBundle == null)
          {
            ad.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
            com.tencent.mm.plugin.voip.c.dRQ().aAo();
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
          if ((!localPBool1.value) && (!paramBundle.zlR.dSZ()))
          {
            ad.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
            String str = localPString.value;
            if (localPBool2.value)
            {
              paramBundle = bl.FzN;
              if (!localPBool1.value) {
                break label1341;
              }
              s.c(str, paramBundle, i, 4, aj.getContext().getString(2131764797));
              paramBundle = null;
              continue;
            }
            paramBundle = bl.FzM;
            continue;
          }
          if (com.tencent.mm.plugin.voip.b.e.dWu())
          {
            paramBundle.zlS = new NewVoipMgr();
            paramBundle.zlS.a(this, localPString.value, localPBool1.value, localPBool2.value);
            paramBundle = paramBundle.zlS;
            continue;
          }
          paramBundle.zlS = new VoipMgr();
          continue;
        }
        this.zrd = new WeakReference(paramBundle);
      }
      catch (Exception paramBundle)
      {
        com.tencent.mm.plugin.voip.b.c.QC(2);
        ad.printErrStackTrace("MicroMsg.Voip.VideoActivity", paramBundle, "", new Object[0]);
        AppMethodBeat.o(115324);
        return;
      }
      this.flk = localPString.value;
      this.zgZ = localPBool2.value;
      this.zgY = localPBool1.value;
      this.mStatus = localPInt.value;
      this.zgX = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.flk);
      paramBundle = new Bundle();
      paramBundle.putString("key_username", this.zgX.field_username);
      paramBundle.putBoolean("key_isoutcall", this.zgY);
      paramBundle.putInt("key_status", com.tencent.mm.plugin.voip.b.i.au(this.zgY, this.zgZ));
      if (com.tencent.mm.plugin.voip.b.i.QM(this.mStatus)) {
        if (com.tencent.mm.plugin.voip.b.e.dWu())
        {
          this.zrc = new NewVoipVideoFragment();
          this.zrc.setArguments(paramBundle);
          getSupportFragmentManager().beginTransaction().b(2131306559, this.zrc).commit();
          setTitleVisibility(8);
          if ((com.tencent.mm.plugin.voip.b.i.QN(this.mStatus)) && (this.zgY)) {
            this.iDu.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115315);
                if ((com.tencent.mm.plugin.voip.b.i.QN(VideoActivity.b(VideoActivity.this))) && (!VideoActivity.c(VideoActivity.this)) && (VideoActivity.d(VideoActivity.this) != null)) {
                  VideoActivity.d(VideoActivity.this).hT(2131764812, 10000);
                }
                AppMethodBeat.o(115315);
              }
            }, 20000L);
          }
          if (com.tencent.mm.plugin.voip.c.dRQ().zlS.dRL() != null) {
            atj(com.tencent.mm.plugin.voip.c.dRQ().zlS.dRL());
          }
          this.sKs = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
          this.sKs.Z(9, "VOIPFloatBall");
          if ((this.zrd != null) && (this.zrd.get() != null)) {
            ((c)this.zrd.get()).a(this, 1);
          }
          this.zrc.setVoipUIListener((c)this.zrd.get());
          this.zrc.a(this);
          this.zrc.setMute(this.mIsMute);
          ad.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[] { Boolean.valueOf(this.zgY), Boolean.valueOf(this.zgZ), this.flk, Integer.valueOf(this.mStatus) });
          if (!com.tencent.mm.plugin.voip.b.i.QM(this.mStatus)) {
            break label1295;
          }
          bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
          ad.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this });
          if (!bool) {
            ((c)this.zrd.get()).dSe();
          }
          ad.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bt.eGN(), this });
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.ESL.c(this.zrl);
        com.tencent.mm.sdk.b.a.ESL.c(this.tLh);
        if (com.tencent.mm.compatible.util.d.lf(26))
        {
          this.zrj = new VideoActivity.ScreenActionReceiver(this);
          paramBundle = new IntentFilter();
          paramBundle.addAction("android.intent.action.SCREEN_OFF");
          paramBundle.addAction("android.intent.action.SCREEN_ON");
          aj.getContext().registerReceiver(this.zrj, paramBundle);
        }
        if (com.tencent.mm.compatible.util.d.lf(17))
        {
          this.gxV = new Point();
          if (getWindow().getDecorView().getDisplay() != null) {
            getWindow().getDecorView().getDisplay().getRealSize(this.gxV);
          }
        }
        AppMethodBeat.o(115324);
        return;
        this.zrc = new VoipVideoFragment();
        break;
        this.zrc = new VoipVoiceFragment();
        break;
        label1295:
        ad.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bt.eGN(), this });
      }
      label1341:
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115331);
    this.zrh = 4;
    ad.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(this.mStatus) });
    t localt = t.zlN;
    t.dUa();
    if (!this.sLn) {
      finish();
    }
    if ((this.zrd != null) && (this.zrd.get() != null)) {
      ((c)this.zrd.get()).a(this);
    }
    if (this.sKs != null) {
      this.sKs.onDestroy();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.zrl);
    com.tencent.mm.sdk.b.a.ESL.d(this.tLh);
    setScreenEnable(true);
    if ((com.tencent.mm.compatible.util.d.lf(26)) && (this.zrj != null)) {}
    try
    {
      aj.getContext().unregisterReceiver(this.zrj);
      this.zrj = null;
      super.onDestroy();
      if (!this.zrg) {
        com.tencent.mm.media.f.c.grn.ajW();
      }
      AppMethodBeat.o(115331);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.i("MicroMsg.Voip.VideoActivity", "unregisterBatteryChange err:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(115329);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.lT(paramInt);
    localb.be(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", this, localb.ado());
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(115329);
      return true;
    }
    if (paramInt == 25)
    {
      if ((!com.tencent.mm.plugin.voip.c.dRQ().zlR.cSx()) && (!this.zgY))
      {
        if ((this.zrd != null) && (this.zrd.get() != null)) {
          ((c)this.zrd.get()).dSr();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.bvC()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.bvx();; paramInt = cHD())
      {
        com.tencent.mm.plugin.audio.c.a.vP(paramInt);
        break;
      }
    }
    if (paramInt == 24)
    {
      if ((!com.tencent.mm.plugin.voip.c.dRQ().zlR.cSx()) && (!this.zgY))
      {
        ((c)this.zrd.get()).dSr();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.bvC()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.bvx();; paramInt = cHD())
      {
        com.tencent.mm.plugin.audio.c.a.vO(paramInt);
        break;
      }
    }
    if ((ae.fFw.fAZ == 1) && (paramInt == 700))
    {
      dVX();
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
      this.sLo = bool1;
      ad.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(this.mStatus), Boolean.valueOf(this.sLo), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
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
    ad.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(this.mStatus) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    com.tencent.mm.plugin.voip.model.l locall = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA;
    if (locall.ziL) {
      locall.ziL = false;
    }
    super.onResume();
    if ((this.zrd != null) && (this.zrd.get() != null)) {
      ((c)this.zrd.get()).dSj();
    }
    setScreenEnable(true);
    this.zrf = bt.GC();
    this.zrk = true;
    if ((this.zrd != null) && (this.zrd.get() != null)) {
      ((c)this.zrd.get()).dSk();
    }
    if (this.sKs != null)
    {
      this.sKs.bzl();
      f.d(true, false, true);
    }
    AppMethodBeat.o(115338);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStart()
  {
    AppMethodBeat.i(115333);
    super.onStart();
    if (!this.sLn)
    {
      ad.i("MicroMsg.Voip.VideoActivity", "onStart");
      this.zrh = 1;
      hS(4096, this.mStatus);
    }
    AppMethodBeat.o(115333);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115332);
    this.zrh = 2;
    ad.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(this.mStatus) });
    com.tencent.mm.plugin.report.service.h localh;
    if ((262 != this.mStatus) && (8 != this.mStatus) && (this.sLo) && (!this.sLn) && (this.zrd != null) && (this.zrd.get() != null) && (((c)this.zrd.get()).rv(false)))
    {
      if (this.zrc != null) {
        this.zrc.dVY();
      }
      ao(false, true);
      if (com.tencent.mm.plugin.voip.b.i.QL(this.mStatus))
      {
        localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (!com.tencent.mm.plugin.voip.b.i.QM(this.mStatus)) {
          break label204;
        }
      }
    }
    label204:
    for (int i = 2;; i = 3)
    {
      localh.f(11618, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      if (this.sKs != null)
      {
        this.sKs.aWa();
        f.d(false, true, true);
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
  
  public final void rH(boolean paramBoolean)
  {
    AppMethodBeat.i(115357);
    ad.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(paramBoolean)));
    if (this.zrc != null) {
      this.zrc.rJ(paramBoolean);
    }
    AppMethodBeat.o(115357);
  }
  
  @Deprecated
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115353);
    if (this.zrc != null) {
      this.zrc.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115353);
  }
  
  @Deprecated
  public final void requestRender()
  {
    AppMethodBeat.i(115352);
    if (this.zrc != null) {
      this.zrc.requestRender();
    }
    AppMethodBeat.o(115352);
  }
  
  @Deprecated
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115360);
    this.zlf = paramCaptureView;
    if (this.zrc != null) {
      this.zrc.a(paramCaptureView);
    }
    AppMethodBeat.o(115360);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115356);
    this.zre = paramLong;
    if (this.zrc != null) {
      this.zrc.un(this.zre);
    }
    AppMethodBeat.o(115356);
  }
  
  @Deprecated
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115349);
    if (this.zrc != null) {
      this.zrc.setHWDecMode(paramInt);
    }
    AppMethodBeat.o(115349);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115346);
    this.mIsMute = paramBoolean;
    if (this.zrc != null) {
      this.zrc.setMute(paramBoolean);
    }
    AppMethodBeat.o(115346);
  }
  
  public void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(115335);
    super.setScreenEnable(paramBoolean);
    if (this.zrd != null) {
      this.zrd.get();
    }
    AppMethodBeat.o(115335);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115345);
    if (this.zhd != -1) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.zhd = paramInt;
      if ((this.zrd != null) && (this.zrd.get() != null)) {
        ((c)this.zrd.get()).setVoicePlayDevice(paramInt);
      }
      if (this.zrc != null) {
        this.zrc.setVoicePlayDevice(paramInt);
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
    if (this.zrc != null) {
      this.zrc.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115348);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115355);
    if (this.zrc != null) {
      this.zrc.uninit();
    }
    AppMethodBeat.o(115355);
  }
  
  public final void wy(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(192142);
    paramInt = i;
    switch (((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation())
    {
    }
    for (paramInt = i;; paramInt = 180)
    {
      if ((this.zrd != null) && (this.zrd.get() != null) && (this.zrc != null)) {
        ((c)this.zrd.get()).wy(paramInt);
      }
      AppMethodBeat.o(192142);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity
 * JD-Core Version:    0.7.0.1
 */