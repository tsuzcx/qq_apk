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
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.at;
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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
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
  private boolean CAA;
  private boolean CAB;
  private boolean CAC;
  private long CAD;
  @Deprecated
  com.tencent.mm.plugin.voip.video.b.a CAE;
  private VoipBaseFragment CAu;
  private WeakReference<c> CAv;
  private long CAw;
  private long CAx;
  private boolean CAy;
  private int CAz;
  private an Cqh;
  private boolean Cqi;
  private boolean Cqj;
  private int Cqn;
  private String fIQ;
  private com.tencent.mm.sdk.b.c gIM;
  com.tencent.mm.plugin.mmsight.model.d haJ;
  private Point htn;
  private aq jzz;
  private boolean mIsMute;
  private int mStatus;
  private CaptureView pdJ;
  private boolean rvZ;
  private com.tencent.mm.plugin.voip.a.b vgy;
  private boolean vhs;
  private boolean vht;
  private com.tencent.mm.sdk.b.c wiZ;
  
  public VideoActivity()
  {
    AppMethodBeat.i(115323);
    this.CAw = -1L;
    this.rvZ = false;
    this.CAx = 0L;
    this.CAy = false;
    this.Cqn = -1;
    this.mIsMute = false;
    this.CAz = 1;
    this.vht = false;
    this.CAA = false;
    this.vhs = false;
    this.CAB = false;
    this.CAC = false;
    this.gIM = new VideoActivity.1(this);
    this.wiZ = new VideoActivity.9(this);
    AppMethodBeat.o(115323);
  }
  
  private int dgR()
  {
    AppMethodBeat.i(115344);
    int i;
    if (com.tencent.mm.plugin.audio.c.a.bHy().isBluetoothScoOn())
    {
      i = com.tencent.mm.plugin.audio.c.a.bHu();
      AppMethodBeat.o(115344);
      return i;
    }
    if (!com.tencent.mm.plugin.voip.b.l.Vu(this.mStatus))
    {
      i = 2;
      if (this.Cqi) {
        if (!this.Cqj)
        {
          if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYT < 0) {
            break label199;
          }
          i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYT;
        }
      }
    }
    for (;;)
    {
      int j = i;
      if (!com.tencent.mm.plugin.audio.c.a.bHz())
      {
        j = i;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYV < 0) {}
      }
      for (j = com.tencent.mm.compatible.deviceinfo.ae.geN.fYV;; j = com.tencent.mm.plugin.voip.c.eys().aNQ())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(115344);
        return j;
        i = 3;
        if (com.tencent.mm.plugin.audio.c.a.bHt())
        {
          if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYT < 0) {
            break label199;
          }
          i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYT;
          break;
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ < 0) {
          break;
        }
        i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ;
        break;
        if (!com.tencent.mm.plugin.audio.c.a.bHt()) {
          break;
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYT < 0) {
          break label199;
        }
        i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYT;
        break;
      }
      label199:
      i = 0;
    }
  }
  
  private static boolean dtt()
  {
    AppMethodBeat.i(115326);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)ak.getContext().getSystemService("phone");
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
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
  
  private void eCB()
  {
    AppMethodBeat.i(115330);
    if ((this.CAv != null) && (this.CAv.get() != null) && (!this.Cqi))
    {
      if (!this.Cqj) {
        break label91;
      }
      ((c)this.CAv.get()).eyG();
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.voip.c.eys().dgR) && (this.Cqj)) {
        ((c)this.CAv.get()).eyQ();
      }
      AppMethodBeat.o(115330);
      return;
      label91:
      ((c)this.CAv.get()).eyJ();
    }
  }
  
  private void eyZ()
  {
    AppMethodBeat.i(115327);
    this.jzz.postDelayed(new Runnable()
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
  
  @Deprecated
  public final com.tencent.mm.plugin.voip.video.b.a Vb(int paramInt)
  {
    AppMethodBeat.i(115340);
    if (((this.CAu instanceof VoipVideoFragment)) && (this.CAu.eCD() != null)) {
      this.CAu.eCD().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            VideoActivity.this.CAE = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.CAE;
    AppMethodBeat.o(115340);
    return locala;
  }
  
  public final void Vc(int paramInt)
  {
    AppMethodBeat.i(210185);
    if (this.CAu != null) {
      this.CAu.Vc(paramInt);
    }
    AppMethodBeat.o(210185);
  }
  
  public final void Vd(int paramInt)
  {
    AppMethodBeat.i(210186);
    if (this.CAu != null) {
      this.CAu.Vd(paramInt);
    }
    AppMethodBeat.o(210186);
  }
  
  public final void Ve(int paramInt)
  {
    AppMethodBeat.i(210187);
    if (this.CAu != null) {
      this.CAu.Ve(paramInt);
    }
    AppMethodBeat.o(210187);
  }
  
  @Deprecated
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115351);
    if (this.CAu != null) {
      this.CAu.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115351);
  }
  
  @Deprecated
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(210180);
    if (this.CAu != null) {
      this.CAu.b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(210180);
  }
  
  public final void aFb(final String paramString)
  {
    AppMethodBeat.i(115342);
    if (this.CAu != null) {
      this.jzz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115320);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).aFb(paramString);
          }
          AppMethodBeat.o(115320);
        }
      });
    }
    AppMethodBeat.o(115342);
  }
  
  public final void aw(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115359);
    this.CAy = paramBoolean2;
    if (paramBoolean1)
    {
      eyZ();
      AppMethodBeat.o(115359);
      return;
    }
    finish();
    AppMethodBeat.o(115359);
  }
  
  public final void co(final int paramInt, String paramString)
  {
    AppMethodBeat.i(115341);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.Cqj) });
    this.rvZ = true;
    if (paramInt == 241)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, null, true);
      AppMethodBeat.o(115341);
      return;
    }
    this.jzz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210179);
        VideoActivity.a(VideoActivity.this, paramInt);
        AppMethodBeat.o(210179);
      }
    });
    AppMethodBeat.o(115341);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(115343);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V", this, localb.ahF());
    al.n(al.a(getWindow(), null), getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(paramView, 0);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V");
    AppMethodBeat.o(115343);
  }
  
  public final void dhQ()
  {
    AppMethodBeat.i(115358);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
    if (this.CAu != null) {
      this.CAu.eCu();
    }
    AppMethodBeat.o(115358);
  }
  
  public final void dtu() {}
  
  @Deprecated
  public final void eCp()
  {
    AppMethodBeat.i(115361);
    if ((this.CAu instanceof VoipVideoFragment)) {
      ((VoipVideoFragment)this.CAu).eCp();
    }
    AppMethodBeat.o(115361);
  }
  
  public final Context eCq()
  {
    AppMethodBeat.i(115354);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(115354);
    return localAppCompatActivity;
  }
  
  public final void eCr()
  {
    AppMethodBeat.i(210184);
    if (this.CAu != null) {
      this.CAu.eCr();
    }
    AppMethodBeat.o(210184);
  }
  
  public final void eCs()
  {
    AppMethodBeat.i(210181);
    if (this.CAu != null) {
      this.CAu.Vg(10);
    }
    AppMethodBeat.o(210181);
  }
  
  public final void eyV()
  {
    AppMethodBeat.i(210182);
    Intent localIntent = new Intent(this, SettingsAboutCamera.class);
    localIntent.putExtra("activity_caller_params", 1);
    startActivityForResult(localIntent, 1);
    this.CAA = true;
    AppMethodBeat.o(210182);
  }
  
  @Deprecated
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115347);
    if (this.CAu != null) {
      this.CAu.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115347);
  }
  
  public void finish()
  {
    AppMethodBeat.i(115334);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V", this);
    this.CAz = 3;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[] { Boolean.valueOf(this.CAy), com.tencent.mm.plugin.voip.b.l.Vr(this.mStatus) });
    Object localObject;
    if ((!this.CAy) && (com.tencent.mm.plugin.voip.b.l.Vu(this.mStatus)) && (4 != this.CAz))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.fIQ);
      com.tencent.mm.plugin.voip.d.iUz.d((Intent)localObject, this);
    }
    int i;
    if (this.CAC)
    {
      this.CAC = false;
      int j = com.tencent.mm.plugin.voip.c.eys().eBd();
      long l = com.tencent.mm.plugin.voip.c.eys().eBe();
      if (this.Cqi)
      {
        i = 0;
        com.tencent.mm.plugin.voip.b.f.c(j, l, i, 5);
        com.tencent.mm.plugin.voip.b.f.Vl(1);
      }
    }
    else
    {
      if (this.haJ != null)
      {
        this.haJ.disable();
        this.haJ.vZF = null;
        this.haJ = null;
      }
      if (this.CAu == null) {
        break label379;
      }
      if (this.CAu.CAL != 4105) {
        break label374;
      }
      i = 1;
      label229:
      this.CAu.uninit();
      this.CAu = null;
    }
    for (;;)
    {
      this.CAv = null;
      this.pdJ = null;
      this.vhs = true;
      super.finish();
      if (i != 0)
      {
        localObject = new kg();
        ((kg)localObject).dyo.dyr = true;
        ((kg)localObject).dyo.dyq = this.CAD;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        VoipBaseFragment.CAM = -1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V");
        AppMethodBeat.o(115334);
        return;
        i = 1;
        break;
        localObject = new kg();
        ((kg)localObject).dyo.dyr = false;
        ((kg)localObject).dyo.dyq = 0L;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
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
  public final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115350);
    if (this.CAu != null) {
      this.CAu.iv(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115350);
  }
  
  public final void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115328);
    this.mStatus = paramInt2;
    if ((1 != this.CAz) && (paramInt2 != 8) && (paramInt2 != 262))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
      AppMethodBeat.o(115328);
      return;
    }
    if (this.CAu == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
      AppMethodBeat.o(115328);
      return;
    }
    this.CAu.iy(paramInt1, paramInt2);
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
      this.Cqj = false;
      if ((this.CAu == null) || (!(this.CAu instanceof VoipVoiceFragment)))
      {
        if (this.CAu != null)
        {
          this.CAu.uninit();
          getSupportFragmentManager().beginTransaction().a(this.CAu).commit();
          this.CAu = null;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_username", this.Cqh.field_username);
        ((Bundle)localObject).putBoolean("key_isoutcall", this.Cqi);
        ((Bundle)localObject).putInt("key_status", this.mStatus);
        this.CAu = new VoipVoiceFragment();
        this.CAu.setArguments((Bundle)localObject);
        this.CAu.setVoipUIListener((c)this.CAv.get());
        this.CAu.BV(this.CAw);
        this.CAu.a(this);
        this.CAu.setVoicePlayDevice(this.Cqn);
        this.CAu.setMute(this.mIsMute);
        getSupportFragmentManager().beginTransaction().b(2131306559, this.CAu).commit();
      }
      AppMethodBeat.o(115328);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      eyZ();
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VideoActivity", "finishSmallWindow mStatus: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.Vr(this.mStatus) });
      if ((this.mStatus != 262) && (this.mStatus != 8)) {
        break;
      }
      com.tencent.mm.plugin.voip.c.eyt().rm(true);
      break;
      if (this.Cqi)
      {
        localObject = this.CAu;
        if (!this.Cqj) {
          break label523;
        }
      }
      label523:
      for (paramInt1 = 2131764931;; paramInt1 = 2131764789)
      {
        ((VoipBaseFragment)localObject).iz(paramInt1, -1);
        eyZ();
        break;
      }
      this.jzz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115321);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).iz(2131764918, -1);
          }
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115321);
        }
      });
      continue;
      this.jzz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115311);
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115311);
        }
      });
      continue;
      this.jzz.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115317);
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115317);
        }
      }, 50L);
      continue;
      eyZ();
      continue;
      finish();
    }
  }
  
  public final void nO(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(210188);
    paramInt = i;
    switch (((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation())
    {
    }
    for (paramInt = i;; paramInt = 180)
    {
      if ((this.CAv != null) && (this.CAv.get() != null) && (this.CAu != null)) {
        ((c)this.CAv.get()).nO(paramInt);
      }
      AppMethodBeat.o(210188);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(210183);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.CAA = false;
      if (this.CAu != null) {
        this.CAu.Vg(5);
      }
    }
    AppMethodBeat.o(210183);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(115325);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.htn != null) && (com.tencent.mm.compatible.util.d.lA(17)))
    {
      paramConfiguration = new Point();
      getWindowManager().getDefaultDisplay().getRealSize(paramConfiguration);
      if ((!paramConfiguration.equals(this.htn)) && (this.CAu != null))
      {
        this.htn = paramConfiguration;
        this.CAu.eCv();
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
        paramBundle = t.Cvc;
        t.eAD();
        com.tencent.mm.util.d.evs();
        setActionbarColor(getResources().getColor(2131101053));
        if (!n.gH(getContext())) {
          n.gI(getContext());
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(3);
        this.haJ = new com.tencent.mm.plugin.mmsight.model.d(this);
        this.haJ.enable();
        this.haJ.vZF = this;
        getWindow().addFlags(6815872);
        if (com.tencent.mm.kernel.g.ajM()) {
          com.tencent.mm.plugin.voip.c.eys().au(false, false);
        }
        this.jzz = new aq();
        localPBool1 = new PBool();
        localPBool2 = new PBool();
        localPString = new PString();
        localPInt = new PInt();
        Object localObject = new PInt();
        localPString.value = getIntent().getStringExtra("Voip_User");
        localPBool1.value = getIntent().getBooleanExtra("Voip_Outcall", true);
        localPBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.CAD = getIntent().getLongExtra("Voip_LastPage_Hash", 0L);
        localPInt.value = com.tencent.mm.plugin.voip.b.l.aE(localPBool1.value, localPBool2.value);
        paramBundle = new PLong();
        paramBundle.value = getIntent().getLongExtra("Voip_CallRoomKey", 0L);
        ((PInt)localObject).value = getIntent().getIntExtra("Voip_Call_From", -1);
        bool = localPBool1.value;
        if (bool) {
          try
          {
            if ((dtt()) && (!isFinishing()))
            {
              Toast.makeText(this, 2131764869, 0).show();
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
              com.tencent.mm.plugin.voip.c.eys().aKI();
              super.finish();
              AppMethodBeat.o(115324);
              return;
            }
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VideoActivity", "not ready now!");
          }
        }
        com.tencent.mm.plugin.voip.b.e locale;
        if (paramBundle.value != com.tencent.mm.plugin.voip.c.eys().eBe())
        {
          locale = com.tencent.mm.plugin.voip.b.e.CCR;
          com.tencent.mm.plugin.voip.b.e.eDg();
          locale = com.tencent.mm.plugin.voip.b.e.CCR;
          com.tencent.mm.plugin.voip.b.e.a(((PInt)localObject).value, true, paramBundle.value, com.tencent.mm.plugin.voip.c.eys().eBe());
          if ((com.tencent.mm.plugin.voip.b.e.eDf()) && (com.tencent.mm.plugin.voip.c.eys().eBe() != 0L))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VideoActivity", "fake calling comming and forbid itself");
            com.tencent.mm.plugin.voip.c.eys().aKI();
            super.finish();
            AppMethodBeat.o(115324);
          }
        }
        else
        {
          locale = com.tencent.mm.plugin.voip.b.e.CCR;
          com.tencent.mm.plugin.voip.b.e.eDh();
          locale = com.tencent.mm.plugin.voip.b.e.CCR;
          com.tencent.mm.plugin.voip.b.e.a(((PInt)localObject).value, false, paramBundle.value, com.tencent.mm.plugin.voip.c.eys().eBe());
        }
        localObject = com.tencent.mm.plugin.voip.c.eys();
        if (((u)localObject).Cvh != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
          localPString.value = ((u)localObject).Cvh.getUserName();
          localPBool1.value = ((u)localObject).Cvh.eym();
          localPBool2.value = ((u)localObject).Cvh.eyl();
          localPInt.value = ((u)localObject).Cvh.getState();
          paramBundle = ((u)localObject).Cvh;
          if (paramBundle == null)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
            com.tencent.mm.plugin.voip.c.eys().aKI();
            super.finish();
            AppMethodBeat.o(115324);
          }
        }
        else
        {
          if (localPString.value == null)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
            paramBundle = null;
            continue;
          }
          if ((!localPBool1.value) && (!((u)localObject).Cvg.ezD()))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
            localObject = localPString.value;
            if (localPBool2.value)
            {
              paramBundle = bv.JgL;
              if (!localPBool1.value) {
                break label1472;
              }
              i = 1;
              s.c((String)localObject, paramBundle, i, 4, ak.getContext().getString(2131764797));
              paramBundle = null;
              continue;
            }
            paramBundle = bv.JgK;
            continue;
          }
          if (com.tencent.mm.plugin.voip.b.h.eDn())
          {
            ((u)localObject).Cvh = new NewVoipMgr();
            ((u)localObject).Cvh.a(this, localPString.value, localPBool1.value, localPBool2.value, paramBundle.value);
            paramBundle = ((u)localObject).Cvh;
            continue;
          }
          ((u)localObject).Cvh = new VoipMgr();
          continue;
        }
        this.CAv = new WeakReference(paramBundle);
      }
      catch (Exception paramBundle)
      {
        com.tencent.mm.plugin.voip.b.f.Vl(2);
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Voip.VideoActivity", paramBundle, "", new Object[0]);
        AppMethodBeat.o(115324);
        return;
      }
      this.fIQ = localPString.value;
      this.Cqj = localPBool2.value;
      this.Cqi = localPBool1.value;
      this.mStatus = localPInt.value;
      this.Cqh = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.fIQ);
      paramBundle = new Bundle();
      paramBundle.putString("key_username", this.Cqh.field_username);
      paramBundle.putBoolean("key_isoutcall", this.Cqi);
      paramBundle.putInt("key_status", com.tencent.mm.plugin.voip.b.l.aE(this.Cqi, this.Cqj));
      if (com.tencent.mm.plugin.voip.b.l.Vv(this.mStatus)) {
        if (com.tencent.mm.plugin.voip.b.h.eDn())
        {
          this.CAu = new NewVoipVideoFragment();
          this.CAu.setArguments(paramBundle);
          getSupportFragmentManager().beginTransaction().b(2131306559, this.CAu).commit();
          setTitleVisibility(8);
          if ((com.tencent.mm.plugin.voip.b.l.Vw(this.mStatus)) && (this.Cqi)) {
            this.jzz.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115315);
                if ((com.tencent.mm.plugin.voip.b.l.Vw(VideoActivity.b(VideoActivity.this))) && (!VideoActivity.c(VideoActivity.this)) && (VideoActivity.d(VideoActivity.this) != null)) {
                  VideoActivity.d(VideoActivity.this).iz(2131764812, 10000);
                }
                AppMethodBeat.o(115315);
              }
            }, 20000L);
          }
          if (com.tencent.mm.plugin.voip.c.eys().Cvh.eyn() != null) {
            aFb(com.tencent.mm.plugin.voip.c.eys().Cvh.eyn());
          }
          this.vgy = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
          this.vgy.ac(9, "VOIPFloatBall");
          if ((this.CAv != null) && (this.CAv.get() != null)) {
            ((c)this.CAv.get()).a(this, 1);
          }
          this.CAu.setVoipUIListener((c)this.CAv.get());
          this.CAu.a(this);
          this.CAu.setMute(this.mIsMute);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[] { Boolean.valueOf(this.Cqi), Boolean.valueOf(this.Cqj), this.fIQ, Integer.valueOf(this.mStatus) });
          if (!com.tencent.mm.plugin.voip.b.l.Vv(this.mStatus)) {
            break label1426;
          }
          bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this });
          if (!bool) {
            ((c)this.CAv.get()).eyH();
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bu.fpN(), this });
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.IvT.c(this.gIM);
        com.tencent.mm.sdk.b.a.IvT.c(this.wiZ);
        if (com.tencent.mm.compatible.util.d.lA(17))
        {
          this.htn = new Point();
          if (getWindow().getDecorView().getDisplay() != null) {
            getWindow().getDecorView().getDisplay().getRealSize(this.htn);
          }
        }
        AppMethodBeat.o(115324);
        return;
        this.CAu = new VoipVideoFragment();
        break;
        this.CAu = new VoipVoiceFragment();
        break;
        label1426:
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bu.fpN(), this });
      }
      label1472:
      int i = 0;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115331);
    this.CAz = 4;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.Vr(this.mStatus) });
    t localt = t.Cvc;
    t.eAE();
    if (!this.vhs) {
      finish();
    }
    if ((this.CAv != null) && (this.CAv.get() != null)) {
      ((c)this.CAv.get()).a(this);
    }
    if (this.vgy != null) {
      this.vgy.onDestroy();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.gIM);
    com.tencent.mm.sdk.b.a.IvT.d(this.wiZ);
    setScreenEnable(true);
    super.onDestroy();
    if (!this.CAy) {
      com.tencent.mm.media.g.c.hnb.atY();
    }
    AppMethodBeat.o(115331);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(115329);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.mu(paramInt);
    localb.bd(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", this, localb.ahF());
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(115329);
      return true;
    }
    if (paramInt == 25)
    {
      if ((!com.tencent.mm.plugin.voip.c.eys().Cvg.cbt()) && (!this.Cqi))
      {
        if ((this.CAv != null) && (this.CAv.get() != null)) {
          ((c)this.CAv.get()).eyU();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.bHy().isBluetoothScoOn()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.bHu();; paramInt = dgR())
      {
        com.tencent.mm.plugin.audio.c.a.xr(paramInt);
        break;
      }
    }
    if (paramInt == 24)
    {
      if ((!com.tencent.mm.plugin.voip.c.eys().Cvg.cbt()) && (!this.Cqi))
      {
        ((c)this.CAv.get()).eyU();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.bHy().isBluetoothScoOn()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.bHu();; paramInt = dgR())
      {
        com.tencent.mm.plugin.audio.c.a.xq(paramInt);
        break;
      }
    }
    if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gal == 1) && (paramInt == 700))
    {
      eCB();
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(115336);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(115337);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)ak.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)ak.getContext().getSystemService("power");
    boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool3 = hasWindowFocus();
    boolean bool4 = localPowerManager.isScreenOn();
    if (((bool3) || (!bool2)) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.vht = bool1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.Vr(this.mStatus), Boolean.valueOf(this.vht), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      AppMethodBeat.o(115337);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(115362);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(115362);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.Vr(this.mStatus) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    com.tencent.mm.plugin.voip.model.l locall = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd;
    if (locall.CrV) {
      locall.CrV = false;
    }
    super.onResume();
    if ((this.CAv != null) && (this.CAv.get() != null)) {
      ((c)this.CAv.get()).eyM();
    }
    setScreenEnable(true);
    this.CAx = bu.HQ();
    this.CAC = true;
    if ((this.CAv != null) && (this.CAv.get() != null)) {
      ((c)this.CAv.get()).eyN();
    }
    if ((this.vgy != null) && (!this.CAA))
    {
      this.vgy.bLp();
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
    if (!this.vhs)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "onStart");
      this.CAz = 1;
      iy(4096, this.mStatus);
    }
    AppMethodBeat.o(115333);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115332);
    this.CAz = 2;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.Vr(this.mStatus) });
    com.tencent.mm.plugin.report.service.g localg;
    if ((262 != this.mStatus) && (8 != this.mStatus) && (this.vht) && (!this.CAA) && (!this.vhs) && (this.CAv != null) && (this.CAv.get() != null) && (((c)this.CAv.get()).tm(false)))
    {
      if (this.CAu != null) {
        this.CAu.eCC();
      }
      aw(false, true);
      if (com.tencent.mm.plugin.voip.b.l.Vu(this.mStatus))
      {
        localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (!com.tencent.mm.plugin.voip.b.l.Vv(this.mStatus)) {
          break label218;
        }
      }
    }
    label218:
    for (int i = 2;; i = 3)
    {
      localg.f(11618, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      if ((this.vgy != null) && (!this.CAA))
      {
        this.vgy.bhk();
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
    if (this.CAu != null) {
      this.CAu.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115353);
  }
  
  @Deprecated
  public final void requestRender()
  {
    AppMethodBeat.i(115352);
    if (this.CAu != null) {
      this.CAu.requestRender();
    }
    AppMethodBeat.o(115352);
  }
  
  @Deprecated
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115360);
    this.pdJ = paramCaptureView;
    if (this.CAu != null) {
      this.CAu.a(paramCaptureView);
    }
    AppMethodBeat.o(115360);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115356);
    this.CAw = paramLong;
    if (this.CAu != null) {
      this.CAu.BV(this.CAw);
    }
    AppMethodBeat.o(115356);
  }
  
  @Deprecated
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115349);
    if (this.CAu != null) {
      this.CAu.setHWDecMode(paramInt);
    }
    AppMethodBeat.o(115349);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115346);
    this.mIsMute = paramBoolean;
    if (this.CAu != null) {
      this.CAu.setMute(paramBoolean);
    }
    AppMethodBeat.o(115346);
  }
  
  public void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(115335);
    super.setScreenEnable(paramBoolean);
    if (this.CAv != null) {
      this.CAv.get();
    }
    AppMethodBeat.o(115335);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115345);
    if (this.Cqn != -1) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.Cqn = paramInt;
      if ((this.CAv != null) && (this.CAv.get() != null)) {
        ((c)this.CAv.get()).setVoicePlayDevice(paramInt);
      }
      if (this.CAu != null) {
        this.CAu.setVoicePlayDevice(paramInt);
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
    if (this.CAu != null) {
      this.CAu.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115348);
  }
  
  public final void ty(boolean paramBoolean)
  {
    AppMethodBeat.i(115357);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(paramBoolean)));
    if (this.CAu != null) {
      this.CAu.tA(paramBoolean);
    }
    AppMethodBeat.o(115357);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115355);
    if (this.CAu != null) {
      this.CAu.uninit();
    }
    AppMethodBeat.o(115355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity
 * JD-Core Version:    0.7.0.1
 */