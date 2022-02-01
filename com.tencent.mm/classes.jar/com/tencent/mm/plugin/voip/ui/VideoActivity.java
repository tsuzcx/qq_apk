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
import com.tencent.mm.g.a.kv;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera;
import com.tencent.mm.plugin.voip.model.NewVoipMgr;
import com.tencent.mm.plugin.voip.model.VoipMgr;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.b;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.video.d.b.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@i
@com.tencent.mm.ui.base.a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity
  extends MMActivity
  implements ServiceConnection, d.a, VoipBaseFragment.d, b
{
  private as GUe;
  private boolean GUf;
  private boolean GUg;
  private int GUk;
  private VoipBaseFragment Hem;
  private WeakReference<c> Hen;
  private long Heo;
  private long Hep;
  private boolean Heq;
  private int Her;
  private boolean Hes;
  private boolean Het;
  private boolean Heu;
  private long Hev;
  @Deprecated
  com.tencent.mm.plugin.voip.video.b.a Hew;
  @Deprecated
  com.tencent.mm.plugin.voip.video.d.b Hex;
  private String goe;
  private IListener hvF;
  private Point imX;
  private MMHandler kAn;
  private boolean mIsMute;
  private int mStatus;
  com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private CaptureView qsJ;
  private boolean sVW;
  private com.tencent.mm.plugin.voip.a.b yyX;
  private boolean yzR;
  private boolean yzS;
  private IListener zDy;
  
  public VideoActivity()
  {
    AppMethodBeat.i(115323);
    this.Heo = -1L;
    this.sVW = false;
    this.Hep = 0L;
    this.Heq = false;
    this.GUk = -1;
    this.mIsMute = false;
    this.Her = 1;
    this.yzS = false;
    this.Hes = false;
    this.yzR = false;
    this.Het = false;
    this.Heu = false;
    this.hvF = new VideoActivity.1(this);
    this.zDy = new VideoActivity.10(this);
    AppMethodBeat.o(115323);
  }
  
  private int eaL()
  {
    AppMethodBeat.i(115344);
    int i;
    if (com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn())
    {
      i = com.tencent.mm.plugin.audio.c.a.cdX();
      AppMethodBeat.o(115344);
      return i;
    }
    if (!com.tencent.mm.plugin.voip.b.k.adP(this.mStatus))
    {
      i = 2;
      if (this.GUf) {
        if (!this.GUg)
        {
          if (ae.gKu.gEk < 0) {
            break label200;
          }
          i = ae.gKu.gEk;
        }
      }
    }
    for (;;)
    {
      int j = i;
      if (!com.tencent.mm.plugin.audio.c.a.ceb())
      {
        j = i;
        if (ae.gKu.gEm < 0) {}
      }
      for (j = ae.gKu.gEm;; j = com.tencent.mm.plugin.voip.c.fFg().bhV())
      {
        Log.i("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(115344);
        return j;
        i = 3;
        if (com.tencent.mm.plugin.audio.c.a.cdW())
        {
          if (ae.gKu.gEk < 0) {
            break label200;
          }
          i = ae.gKu.gEk;
          break;
        }
        if (ae.gKu.gEh < 0) {
          break;
        }
        i = ae.gKu.gEh;
        break;
        if (!com.tencent.mm.plugin.audio.c.a.cdW()) {
          break;
        }
        if (ae.gKu.gEk < 0) {
          break label200;
        }
        i = ae.gKu.gEk;
        break;
      }
      label200:
      i = 0;
    }
  }
  
  private static boolean enQ()
  {
    AppMethodBeat.i(115326);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
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
        Log.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        Log.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
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
  
  private void fFP()
  {
    AppMethodBeat.i(115327);
    this.kAn.postDelayed(new Runnable()
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
  
  private void fJw()
  {
    AppMethodBeat.i(115330);
    if ((this.Hen != null) && (this.Hen.get() != null) && (!this.GUf))
    {
      if (!this.GUg) {
        break label91;
      }
      ((c)this.Hen.get()).fFw();
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.voip.c.fFg().dya) && (this.GUg)) {
        ((c)this.Hen.get()).fFG();
      }
      AppMethodBeat.o(115330);
      return;
      label91:
      ((c)this.Hen.get()).fFz();
    }
  }
  
  @Deprecated
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115351);
    if (this.Hem != null) {
      this.Hem.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115351);
  }
  
  @Deprecated
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(235769);
    if (this.Hem != null) {
      this.Hem.b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(235769);
  }
  
  public final void aI(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115359);
    this.Heq = paramBoolean2;
    if (paramBoolean1)
    {
      fFP();
      AppMethodBeat.o(115359);
      return;
    }
    finish();
    AppMethodBeat.o(115359);
  }
  
  public final void aUB(final String paramString)
  {
    AppMethodBeat.i(115342);
    if (this.Hem != null) {
      this.kAn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115321);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).aUB(paramString);
          }
          AppMethodBeat.o(115321);
        }
      });
    }
    AppMethodBeat.o(115342);
  }
  
  @Deprecated
  public final com.tencent.mm.plugin.voip.video.b.a adw(int paramInt)
  {
    AppMethodBeat.i(115340);
    if (((this.Hem instanceof VoipVideoFragment)) && (this.Hem.fJy() != null)) {
      this.Hem.fJy().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            VideoActivity.this.Hew = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.Hew;
    AppMethodBeat.o(115340);
    return locala;
  }
  
  public final void adx(int paramInt)
  {
    AppMethodBeat.i(235774);
    if (this.Hem != null) {
      this.Hem.adx(paramInt);
    }
    AppMethodBeat.o(235774);
  }
  
  public final void ady(int paramInt)
  {
    AppMethodBeat.i(235775);
    if (this.Hem != null) {
      this.Hem.ady(paramInt);
    }
    AppMethodBeat.o(235775);
  }
  
  public final void adz(int paramInt)
  {
    AppMethodBeat.i(235776);
    if (this.Hem != null) {
      this.Hem.adz(paramInt);
    }
    AppMethodBeat.o(235776);
  }
  
  public final void cF(final int paramInt, String paramString)
  {
    AppMethodBeat.i(115341);
    Log.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.GUg) });
    this.sVW = true;
    if (paramInt == 241)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, null, true);
      AppMethodBeat.o(115341);
      return;
    }
    this.kAn.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235765);
        VideoActivity.a(VideoActivity.this, paramInt);
        AppMethodBeat.o(235765);
      }
    });
    AppMethodBeat.o(115341);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(115343);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V", this, localb.axR());
    ao.p(ao.a(getWindow(), null), getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(paramView, 0);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V");
    AppMethodBeat.o(115343);
  }
  
  public final void ebH()
  {
    AppMethodBeat.i(115358);
    Log.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
    if (this.Hem != null) {
      this.Hem.fJq();
    }
    AppMethodBeat.o(115358);
  }
  
  public final void enR() {}
  
  @Deprecated
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115347);
    if (this.Hem != null) {
      this.Hem.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115347);
  }
  
  public final void fFL()
  {
    AppMethodBeat.i(235771);
    Intent localIntent = new Intent(this, SettingsAboutCamera.class);
    localIntent.putExtra("activity_caller_params", 1);
    startActivityForResult(localIntent, 1);
    this.Hes = true;
    AppMethodBeat.o(235771);
  }
  
  @Deprecated
  public final void fJj()
  {
    AppMethodBeat.i(115361);
    if ((this.Hem instanceof VoipVideoFragment)) {
      ((VoipVideoFragment)this.Hem).fJj();
    }
    AppMethodBeat.o(115361);
  }
  
  @Deprecated
  public final com.tencent.mm.plugin.voip.video.d.b fJk()
  {
    AppMethodBeat.i(235768);
    if ((this.Hem != null) && (this.Hem.fJy() != null)) {
      this.Hem.getSpatioTemporalFilterData().a(new b.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.d.b paramAnonymousb)
        {
          if (paramAnonymousb != null) {
            VideoActivity.this.Hex = paramAnonymousb;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.d.b localb = this.Hex;
    AppMethodBeat.o(235768);
    return localb;
  }
  
  public final Context fJl()
  {
    AppMethodBeat.i(115354);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(115354);
    return localAppCompatActivity;
  }
  
  public final void fJm()
  {
    AppMethodBeat.i(235773);
    if (this.Hem != null) {
      this.Hem.fJm();
    }
    AppMethodBeat.o(235773);
  }
  
  public final void fJn()
  {
    AppMethodBeat.i(235770);
    if (this.Hem != null) {
      this.Hem.adB(10);
    }
    AppMethodBeat.o(235770);
  }
  
  public void finish()
  {
    AppMethodBeat.i(115334);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V", this);
    this.Her = 3;
    Log.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[] { Boolean.valueOf(this.Heq), com.tencent.mm.plugin.voip.b.k.adM(this.mStatus) });
    Object localObject;
    if ((!this.Heq) && (com.tencent.mm.plugin.voip.b.k.adP(this.mStatus)) && (4 != this.Her))
    {
      Log.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.goe);
      com.tencent.mm.plugin.voip.d.jRt.d((Intent)localObject, this);
    }
    int i;
    if (this.Heu)
    {
      this.Heu = false;
      int j = com.tencent.mm.plugin.voip.c.fFg().fHU();
      long l = com.tencent.mm.plugin.voip.c.fFg().fHV();
      if (this.GUf)
      {
        i = 0;
        com.tencent.mm.plugin.voip.b.e.c(j, l, i, 5);
        com.tencent.mm.plugin.voip.b.e.adG(1);
      }
    }
    else
    {
      if (this.orientationEventListener != null)
      {
        this.orientationEventListener.disable();
        this.orientationEventListener.ztH = null;
        this.orientationEventListener = null;
      }
      if (this.Hem == null) {
        break label379;
      }
      if (this.Hem.HeE != 4105) {
        break label374;
      }
      i = 1;
      label229:
      this.Hem.uninit();
      this.Hem = null;
    }
    for (;;)
    {
      this.Hen = null;
      this.qsJ = null;
      this.yzR = true;
      super.finish();
      if (i != 0)
      {
        localObject = new kv();
        ((kv)localObject).dPV.dPY = true;
        ((kv)localObject).dPV.dPX = this.Hev;
        EventCenter.instance.publish((IEvent)localObject);
      }
      for (;;)
      {
        VoipBaseFragment.HeF = -1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V");
        AppMethodBeat.o(115334);
        return;
        i = 1;
        break;
        localObject = new kv();
        ((kv)localObject).dPV.dPY = false;
        ((kv)localObject).dPV.dPX = 0L;
        EventCenter.instance.publish((IEvent)localObject);
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
    return 2131496859;
  }
  
  @Deprecated
  public final void jA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115350);
    if (this.Hem != null) {
      this.Hem.jA(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115350);
  }
  
  public final void jD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115328);
    this.mStatus = paramInt2;
    if ((1 != this.Her) && (paramInt2 != 8) && (paramInt2 != 262))
    {
      Log.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
      AppMethodBeat.o(115328);
      return;
    }
    if (this.Hem == null)
    {
      Log.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
      AppMethodBeat.o(115328);
      return;
    }
    this.Hem.jD(paramInt1, paramInt2);
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
      this.GUg = false;
      if ((this.Hem == null) || (!(this.Hem instanceof VoipVoiceFragment)))
      {
        if (this.Hem != null)
        {
          this.Hem.uninit();
          getSupportFragmentManager().beginTransaction().a(this.Hem).commit();
          this.Hem = null;
        }
        Log.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_username", this.GUe.field_username);
        ((Bundle)localObject).putBoolean("key_isoutcall", this.GUf);
        ((Bundle)localObject).putInt("key_status", this.mStatus);
        this.Hem = new VoipVoiceFragment();
        this.Hem.setArguments((Bundle)localObject);
        this.Hem.setVoipUIListener((c)this.Hen.get());
        this.Hem.Li(this.Heo);
        this.Hem.a(this);
        this.Hem.setVoicePlayDevice(this.GUk);
        this.Hem.setMute(this.mIsMute);
        getSupportFragmentManager().beginTransaction().b(2131310019, this.Hem).commit();
      }
      AppMethodBeat.o(115328);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      fFP();
      Log.d("MicroMsg.Voip.VideoActivity", "finishSmallWindow mStatus: %s", new Object[] { com.tencent.mm.plugin.voip.b.k.adM(this.mStatus) });
      if ((this.mStatus != 262) && (this.mStatus != 8)) {
        break;
      }
      com.tencent.mm.plugin.voip.c.fFh().rX(true);
      break;
      if (this.GUf)
      {
        localObject = this.Hem;
        if (!this.GUg) {
          break label523;
        }
      }
      label523:
      for (paramInt1 = 2131767372;; paramInt1 = 2131767226)
      {
        ((VoipBaseFragment)localObject).jE(paramInt1, -1);
        fFP();
        break;
      }
      this.kAn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115311);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).jE(2131767359, -1);
          }
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115311);
        }
      });
      continue;
      this.kAn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235763);
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(235763);
        }
      });
      continue;
      this.kAn.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115317);
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115317);
        }
      }, 50L);
      continue;
      fFP();
      continue;
      finish();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(235772);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.Hes = false;
      if (this.Hem != null) {
        this.Hem.adB(5);
      }
    }
    AppMethodBeat.o(235772);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(115325);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.imX != null) && (com.tencent.mm.compatible.util.d.oD(17)))
    {
      paramConfiguration = new Point();
      getWindowManager().getDefaultDisplay().getRealSize(paramConfiguration);
      if ((!paramConfiguration.equals(this.imX)) && (this.Hem != null))
      {
        this.imX = paramConfiguration;
        this.Hem.m(this.imX);
      }
    }
    AppMethodBeat.o(115325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(115324);
    super.onCreate(paramBundle);
    Object localObject1;
    PBool localPBool;
    PString localPString;
    PInt localPInt;
    Object localObject2;
    boolean bool;
    com.tencent.mm.plugin.voip.b.d locald;
    try
    {
      paramBundle = t.GYO;
      t.fHu();
      com.tencent.mm.util.d.fAL();
      setActionbarColor(getResources().getColor(2131101287));
      setRequestedOrientation(7);
      if (!com.tencent.mm.plugin.voip.b.m.hC(getContext())) {
        com.tencent.mm.plugin.voip.b.m.hD(getContext());
      }
      Log.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
      getSupportActionBar().hide();
      getWindow().setSoftInputMode(3);
      this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(this);
      this.orientationEventListener.enable();
      this.orientationEventListener.ztH = this;
      getWindow().addFlags(6815872);
      if (com.tencent.mm.kernel.g.aAc()) {
        com.tencent.mm.plugin.voip.c.fFg().aG(false, false);
      }
      this.kAn = new MMHandler();
      localObject1 = new PBool();
      localPBool = new PBool();
      localPString = new PString();
      localPInt = new PInt();
      localObject2 = new PInt();
      localPString.value = getIntent().getStringExtra("Voip_User");
      ((PBool)localObject1).value = getIntent().getBooleanExtra("Voip_Outcall", true);
      localPBool.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
      this.Hev = getIntent().getLongExtra("Voip_LastPage_Hash", 0L);
      localPInt.value = com.tencent.mm.plugin.voip.b.k.aQ(((PBool)localObject1).value, localPBool.value);
      paramBundle = new PLong();
      paramBundle.value = getIntent().getLongExtra("Voip_CallRoomKey", 0L);
      ((PInt)localObject2).value = getIntent().getIntExtra("Voip_Call_From", -1);
      bool = ((PBool)localObject1).value;
      if (bool) {
        try
        {
          if ((enQ()) && (!isFinishing()))
          {
            Toast.makeText(this, 2131767308, 0).show();
            Log.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
            com.tencent.mm.plugin.voip.c.fFg().unRegister();
            super.finish();
            AppMethodBeat.o(115324);
            return;
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.Voip.VideoActivity", "not ready now!");
        }
      }
      if (com.tencent.mm.plugin.voip.b.d.fJQ())
      {
        locald = com.tencent.mm.plugin.voip.b.d.HgU;
        com.tencent.mm.plugin.voip.b.d.fJZ();
      }
      if (paramBundle.value != com.tencent.mm.plugin.voip.c.fFg().fHV())
      {
        if (com.tencent.mm.plugin.voip.c.fFg().fHV() != 0L)
        {
          locald = com.tencent.mm.plugin.voip.b.d.HgU;
          com.tencent.mm.plugin.voip.b.d.fJS();
          if (((PBool)localObject1).value) {
            break label1820;
          }
          if (!com.tencent.mm.plugin.voip.c.fFg().GYS.fGt()) {
            break label514;
          }
          break label1820;
        }
        for (;;)
        {
          locald = com.tencent.mm.plugin.voip.b.d.HgU;
          com.tencent.mm.plugin.voip.b.d.a(((PInt)localObject2).value, true, paramBundle.value, com.tencent.mm.plugin.voip.c.fFg().fHV(), bool);
          if ((!com.tencent.mm.plugin.voip.b.d.fJQ()) || (com.tencent.mm.plugin.voip.c.fFg().fHV() == 0L)) {
            break;
          }
          Log.e("MicroMsg.Voip.VideoActivity", "fake calling comming and forbid itself cause key is no similar");
          com.tencent.mm.plugin.voip.c.fFg().unRegister();
          super.finish();
          AppMethodBeat.o(115324);
          return;
          label514:
          bool = false;
        }
      }
      locald = com.tencent.mm.plugin.voip.b.d.HgU;
      com.tencent.mm.plugin.voip.b.d.fJT();
      if (((PBool)localObject1).value) {
        break label1825;
      }
      if (com.tencent.mm.plugin.voip.c.fFg().GYS.fGt())
      {
        break label1825;
        label550:
        locald = com.tencent.mm.plugin.voip.b.d.HgU;
        com.tencent.mm.plugin.voip.b.d.a(((PInt)localObject2).value, false, paramBundle.value, com.tencent.mm.plugin.voip.c.fFg().fHV(), bool);
        if ((((PBool)localObject1).value) || (com.tencent.mm.plugin.voip.c.fFg().GYS.fGt()) || (!com.tencent.mm.plugin.voip.b.d.fJR())) {
          break label749;
        }
        Log.e("MicroMsg.Voip.VideoActivity", "fake calling comming and forbid itself cause engine is close");
        com.tencent.mm.plugin.voip.c.fFg().unRegister();
        localObject1 = com.tencent.mm.plugin.voip.b.d.HgU;
        com.tencent.mm.plugin.voip.b.d.fJX();
        localObject1 = com.tencent.mm.plugin.voip.b.d.HgU;
        com.tencent.mm.plugin.voip.b.d.a(((PInt)localObject2).value, true, paramBundle.value, com.tencent.mm.plugin.voip.c.fFg().fHV(), true);
        localObject1 = com.tencent.mm.plugin.voip.b.d.HgU;
        localObject1 = com.tencent.mm.plugin.voip.c.fFg();
        long l = paramBundle.value;
        paramBundle = (Boolean)((u)localObject1).GZp.get(Long.valueOf(l));
        if (paramBundle != null) {
          break label710;
        }
        bool = false;
        label687:
        if (!bool) {
          break label718;
        }
        com.tencent.mm.plugin.voip.b.d.fKa();
      }
      for (;;)
      {
        super.finish();
        AppMethodBeat.o(115324);
        return;
        bool = false;
        break;
        label710:
        bool = paramBundle.booleanValue();
        break label687;
        label718:
        com.tencent.mm.plugin.voip.b.d.fKb();
      }
      localObject2 = com.tencent.mm.plugin.voip.c.fFg();
    }
    catch (Exception paramBundle)
    {
      com.tencent.mm.plugin.voip.b.e.adG(2);
      Log.printErrStackTrace("MicroMsg.Voip.VideoActivity", paramBundle, "", new Object[0]);
      AppMethodBeat.o(115324);
      return;
    }
    label749:
    if (((u)localObject2).GYT != null)
    {
      Log.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
      localPString.value = ((u)localObject2).GYT.getUserName();
      ((PBool)localObject1).value = ((u)localObject2).GYT.fFa();
      localPBool.value = ((u)localObject2).GYT.fEZ();
      localPInt.value = ((u)localObject2).GYT.getState();
      paramBundle = ((u)localObject2).GYT;
    }
    label1031:
    for (;;)
    {
      label829:
      if (paramBundle == null)
      {
        Log.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
        com.tencent.mm.plugin.voip.c.fFg().unRegister();
        super.finish();
        AppMethodBeat.o(115324);
        return;
        Log.i("MicroMsg.Voip.VoipService", "pToUser before is %s and after is %s", new Object[] { localPString.value, ((u)localObject2).GYS.toUser });
        if (!localPString.value.equals(((u)localObject2).GYS.toUser))
        {
          locald = com.tencent.mm.plugin.voip.b.d.HgU;
          com.tencent.mm.plugin.voip.b.d.fJY();
        }
        if (com.tencent.mm.plugin.voip.b.d.fJR()) {
          localPString.value = ((u)localObject2).GYS.toUser;
        }
        localPString.value = ((u)localObject2).GYS.toUser;
        localPBool.value = ((u)localObject2).GYS.GZt;
        if (localPString.value == null)
        {
          Log.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
          paramBundle = null;
        }
        else if ((!((PBool)localObject1).value) && (!((u)localObject2).GYS.fGt()))
        {
          Log.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
          localObject2 = localPString.value;
          if (localPBool.value)
          {
            paramBundle = ca.OqC;
            if (!((PBool)localObject1).value) {
              break label1830;
            }
          }
        }
      }
    }
    label1820:
    label1825:
    label1830:
    for (int i = 1;; i = 0)
    {
      s.c((String)localObject2, paramBundle, i, 4, MMApplicationContext.getContext().getString(2131767235));
      paramBundle = null;
      break label829;
      paramBundle = ca.OqB;
      break label1031;
      if (com.tencent.mm.plugin.voip.b.g.fKe()) {}
      for (((u)localObject2).GYT = new NewVoipMgr();; ((u)localObject2).GYT = new VoipMgr())
      {
        ((u)localObject2).GYT.a(this, localPString.value, ((PBool)localObject1).value, localPBool.value, paramBundle.value);
        paramBundle = ((u)localObject2).GYT;
        break;
      }
      this.Hen = new WeakReference(paramBundle);
      this.goe = localPString.value;
      this.GUg = localPBool.value;
      this.GUf = ((PBool)localObject1).value;
      this.mStatus = localPInt.value;
      this.GUe = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.goe);
      paramBundle = new Bundle();
      paramBundle.putString("key_username", this.GUe.field_username);
      paramBundle.putBoolean("key_isoutcall", this.GUf);
      paramBundle.putInt("key_status", com.tencent.mm.plugin.voip.b.k.aQ(this.GUf, this.GUg));
      if (com.tencent.mm.plugin.voip.b.k.adQ(this.mStatus)) {
        if (com.tencent.mm.plugin.voip.b.g.fKe())
        {
          this.Hem = new NewVoipVideoFragment();
          this.Hem.setArguments(paramBundle);
          getSupportFragmentManager().beginTransaction().b(2131310019, this.Hem).commit();
          setTitleVisibility(8);
          if ((com.tencent.mm.plugin.voip.b.k.adR(this.mStatus)) && (this.GUf)) {
            this.kAn.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115315);
                if ((com.tencent.mm.plugin.voip.b.k.adR(VideoActivity.b(VideoActivity.this))) && (!VideoActivity.c(VideoActivity.this)) && (VideoActivity.d(VideoActivity.this) != null)) {
                  VideoActivity.d(VideoActivity.this).jE(2131767250, 10000);
                }
                AppMethodBeat.o(115315);
              }
            }, 20000L);
          }
          if (com.tencent.mm.plugin.voip.c.fFg().GYT.fFb() != null) {
            aUB(com.tencent.mm.plugin.voip.c.fFg().GYT.fFb());
          }
          if (this.GUg) {
            s.hA(this);
          }
          this.yyX = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
          this.yyX.G(9, "VOIPFloatBall");
          if ((this.Hen != null) && (this.Hen.get() != null)) {
            ((c)this.Hen.get()).a(this, 1);
          }
          this.Hem.setVoipUIListener((c)this.Hen.get());
          this.Hem.a(this);
          this.Hem.setMute(this.mIsMute);
          Log.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[] { Boolean.valueOf(this.GUf), Boolean.valueOf(this.GUg), this.goe, Integer.valueOf(this.mStatus) });
          if (!com.tencent.mm.plugin.voip.b.k.adQ(this.mStatus)) {
            break label1774;
          }
          bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
          Log.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
          if (!bool) {
            ((c)this.Hen.get()).fFx();
          }
          Log.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), Util.getStack(), this });
        }
      }
      for (;;)
      {
        EventCenter.instance.addListener(this.hvF);
        EventCenter.instance.addListener(this.zDy);
        if (com.tencent.mm.compatible.util.d.oD(17))
        {
          this.imX = new Point();
          if (getWindow().getDecorView().getDisplay() != null) {
            getWindow().getDecorView().getDisplay().getRealSize(this.imX);
          }
        }
        AppMethodBeat.o(115324);
        return;
        this.Hem = new VoipVideoFragment();
        break;
        this.Hem = new VoipVoiceFragment();
        break;
        label1774:
        Log.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), Util.getStack(), this });
      }
      bool = true;
      break;
      bool = true;
      break label550;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115331);
    this.Her = 4;
    Log.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.k.adM(this.mStatus) });
    t localt = t.GYO;
    t.fHv();
    if (!this.yzR) {
      finish();
    }
    if ((this.Hen != null) && (this.Hen.get() != null)) {
      ((c)this.Hen.get()).a(this);
    }
    if (this.yyX != null) {
      this.yyX.onDestroy();
    }
    EventCenter.instance.removeListener(this.hvF);
    EventCenter.instance.removeListener(this.zDy);
    setScreenEnable(true);
    super.onDestroy();
    if (!this.Heq) {
      com.tencent.mm.media.g.c.igu.aMA();
    }
    AppMethodBeat.o(115331);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(115329);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.pH(paramInt);
    localb.bm(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", this, localb.axR());
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(115329);
      return true;
    }
    if (paramInt == 25)
    {
      if ((!com.tencent.mm.plugin.voip.c.fFg().GYS.czl()) && (!this.GUf))
      {
        if ((this.Hen != null) && (this.Hen.get() != null)) {
          ((c)this.Hen.get()).fFK();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.cdX();; paramInt = eaL())
      {
        com.tencent.mm.plugin.audio.c.a.AX(paramInt);
        break;
      }
    }
    if (paramInt == 24)
    {
      if ((!com.tencent.mm.plugin.voip.c.fFg().GYS.czl()) && (!this.GUf))
      {
        ((c)this.Hen.get()).fFK();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.cdX();; paramInt = eaL())
      {
        com.tencent.mm.plugin.audio.c.a.AW(paramInt);
        break;
      }
    }
    if ((ae.gKt.gFC == 1) && (paramInt == 700))
    {
      fJw();
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
    Log.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(115336);
  }
  
  public void onOrientationChange(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(235777);
    int j = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
    paramInt = i;
    switch (j)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if ((this.Hen != null) && (this.Hen.get() != null) && (this.Hem != null)) {
        ((c)this.Hen.get()).jz(j, paramInt);
      }
      if (this.Hem != null) {
        this.Hem.setDeviceOrientation(paramInt);
      }
      AppMethodBeat.o(235777);
      return;
      paramInt = 180;
      continue;
      paramInt = 90;
      continue;
      paramInt = 270;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(115337);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
    boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool3 = hasWindowFocus();
    boolean bool4 = localPowerManager.isScreenOn();
    if (((bool3) || (!bool2)) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.yzS = bool1;
      Log.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[] { com.tencent.mm.plugin.voip.b.k.adM(this.mStatus), Boolean.valueOf(this.yzS), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      AppMethodBeat.o(115337);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(115362);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(115362);
      return;
    }
    Log.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
        for (paramInt = 2131763864;; paramInt = 2131763876)
        {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131763890), getString(2131762043), getString(2131755761), false, new VideoActivity.4(this), new VideoActivity.5(this));
          AppMethodBeat.o(115362);
          return;
        }
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131755761), false, new VideoActivity.6(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(115338);
    Log.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.k.adM(this.mStatus) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    com.tencent.mm.plugin.voip.model.l locall = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ;
    if (locall.GVH) {
      locall.GVH = false;
    }
    super.onResume();
    if ((this.Hen != null) && (this.Hen.get() != null)) {
      ((c)this.Hen.get()).fFC();
    }
    onOrientationChange(0);
    setScreenEnable(true);
    this.Hep = Util.currentTicks();
    this.Heu = true;
    if ((this.Hen != null) && (this.Hen.get() != null)) {
      ((c)this.Hen.get()).fFD();
    }
    if ((this.yyX != null) && (!this.Hes))
    {
      this.yyX.aGf();
      f.e(true, false, true);
    }
    AppMethodBeat.o(115338);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStart()
  {
    AppMethodBeat.i(115333);
    super.onStart();
    if (!this.yzR)
    {
      Log.i("MicroMsg.Voip.VideoActivity", "onStart");
      this.Her = 1;
      jD(4096, this.mStatus);
    }
    AppMethodBeat.o(115333);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115332);
    this.Her = 2;
    Log.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[] { com.tencent.mm.plugin.voip.b.k.adM(this.mStatus) });
    com.tencent.mm.plugin.report.service.h localh;
    if ((262 != this.mStatus) && (8 != this.mStatus) && (this.yzS) && (!this.Hes) && (!this.yzR) && (this.Hen != null) && (this.Hen.get() != null) && (((c)this.Hen.get()).wX(false)))
    {
      if (this.Hem != null) {
        this.Hem.fJx();
      }
      aI(false, true);
      if (com.tencent.mm.plugin.voip.b.k.adP(this.mStatus))
      {
        localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (!com.tencent.mm.plugin.voip.b.k.adQ(this.mStatus)) {
          break label218;
        }
      }
    }
    label218:
    for (int i = 2;; i = 3)
    {
      localh.a(11618, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      if ((this.yyX != null) && (!this.Hes))
      {
        this.yyX.aGj();
        f.e(false, true, true);
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
    if (this.Hem != null) {
      this.Hem.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115353);
  }
  
  @Deprecated
  public final void requestRender()
  {
    AppMethodBeat.i(115352);
    if (this.Hem != null) {
      this.Hem.requestRender();
    }
    AppMethodBeat.o(115352);
  }
  
  @Deprecated
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(235766);
    this.qsJ = paramCaptureView;
    if (this.Hem != null) {
      this.Hem.a(paramCaptureView);
    }
    AppMethodBeat.o(235766);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115356);
    this.Heo = paramLong;
    if (this.Hem != null) {
      this.Hem.Li(this.Heo);
    }
    AppMethodBeat.o(115356);
  }
  
  @Deprecated
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115349);
    if (this.Hem != null) {
      this.Hem.setHWDecMode(paramInt);
    }
    AppMethodBeat.o(115349);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115346);
    this.mIsMute = paramBoolean;
    if (this.Hem != null) {
      this.Hem.setMute(paramBoolean);
    }
    AppMethodBeat.o(115346);
  }
  
  public void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(115335);
    super.setScreenEnable(paramBoolean);
    if (this.Hen != null) {
      this.Hen.get();
    }
    AppMethodBeat.o(115335);
  }
  
  @Deprecated
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(235767);
    if (this.Hem != null) {
      this.Hem.setSpatiotemporalDenosing(paramInt);
    }
    AppMethodBeat.o(235767);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115345);
    if (this.GUk != -1) {
      switch (paramInt)
      {
      default: 
        if (!this.GUg) {
          setScreenEnable(true);
        }
        break;
      }
    }
    for (;;)
    {
      this.GUk = paramInt;
      if ((this.Hen != null) && (this.Hen.get() != null)) {
        ((c)this.Hen.get()).setVoicePlayDevice(paramInt);
      }
      if (this.Hem != null) {
        this.Hem.setVoicePlayDevice(paramInt);
      }
      AppMethodBeat.o(115345);
      return;
      Toast.makeText(getContext(), getContext().getString(2131767378), 0).show();
      if (!this.GUg)
      {
        setScreenEnable(true);
        continue;
        Toast.makeText(getContext(), getContext().getString(2131767377), 0).show();
      }
    }
  }
  
  @Deprecated
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115348);
    if (this.Hem != null) {
      this.Hem.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115348);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115355);
    if (this.Hem != null) {
      this.Hem.uninit();
    }
    AppMethodBeat.o(115355);
  }
  
  public final void xi(boolean paramBoolean)
  {
    AppMethodBeat.i(115357);
    Log.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(paramBoolean)));
    if (this.Hem != null) {
      this.Hem.xk(paramBoolean);
    }
    AppMethodBeat.o(115357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity
 * JD-Core Version:    0.7.0.1
 */