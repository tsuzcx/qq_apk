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
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.f.a.lm;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c.g;
import com.tencent.mm.plugin.voip.model.NewVoipMgr;
import com.tencent.mm.plugin.voip.model.VoipMgr;
import com.tencent.mm.plugin.voip.model.l;
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
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity
  extends MMActivity
  implements ServiceConnection, d.a, VoipBaseFragment.d, b
{
  private com.tencent.mm.plugin.voip.a.b DYP;
  private boolean DZJ;
  private boolean DZK;
  private IListener Fix;
  private boolean Fvv;
  private int Fvw;
  private as NKq;
  private boolean NKr;
  private boolean NKs;
  private int NKw;
  private VoipBaseFragment NVd;
  private WeakReference<c> NVe;
  private long NVf;
  private long NVg;
  private boolean NVh;
  private int NVi;
  private boolean NVj;
  private boolean NVk;
  private long NVl;
  private int NVm;
  @Deprecated
  com.tencent.mm.plugin.voip.video.b.a NVn;
  @Deprecated
  com.tencent.mm.plugin.voip.video.d.b NVo;
  private String iSn;
  private IListener khI;
  private Point lbY;
  private boolean mIsMute;
  private int mStatus;
  private MMHandler ntw;
  com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private CaptureView tRv;
  private boolean wBU;
  
  public VideoActivity()
  {
    AppMethodBeat.i(115323);
    this.NVf = -1L;
    this.mStatus = -1;
    this.wBU = false;
    this.NVg = 0L;
    this.NVh = false;
    this.NKw = -1;
    this.mIsMute = false;
    this.NVi = 1;
    this.DZK = false;
    this.Fvv = false;
    this.Fvw = 0;
    this.DZJ = false;
    this.NVj = false;
    this.NVk = false;
    this.khI = new VideoActivity.1(this);
    this.NVm = 1;
    this.Fix = new VideoActivity.11(this);
    AppMethodBeat.o(115323);
  }
  
  private int eJJ()
  {
    AppMethodBeat.i(115344);
    int i;
    if (com.tencent.mm.plugin.audio.c.a.crn().crm())
    {
      i = com.tencent.mm.plugin.audio.c.a.cri();
      AppMethodBeat.o(115344);
      return i;
    }
    if (!com.tencent.mm.plugin.voip.c.k.alC(this.mStatus))
    {
      i = 2;
      if (this.NKr) {
        if (!this.NKs)
        {
          if (af.juI.jou < 0) {
            break label200;
          }
          i = af.juI.jou;
        }
      }
    }
    for (;;)
    {
      int j = i;
      if (!com.tencent.mm.plugin.audio.c.a.cro())
      {
        j = i;
        if (af.juI.jow < 0) {}
      }
      for (j = af.juI.jow;; j = com.tencent.mm.plugin.voip.c.gxs().gxF())
      {
        Log.i("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(115344);
        return j;
        i = 3;
        if (com.tencent.mm.plugin.audio.c.a.crh())
        {
          if (af.juI.jou < 0) {
            break label200;
          }
          i = af.juI.jou;
          break;
        }
        if (af.juI.jor < 0) {
          break;
        }
        i = af.juI.jor;
        break;
        if (!com.tencent.mm.plugin.audio.c.a.crh()) {
          break;
        }
        if (af.juI.jou < 0) {
          break label200;
        }
        i = af.juI.jou;
        break;
      }
      label200:
      i = 0;
    }
  }
  
  private static boolean eXG()
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
  
  private void gBS()
  {
    AppMethodBeat.i(115330);
    if ((this.NVe != null) && (this.NVe.get() != null) && (!this.NKr))
    {
      if (!this.NKs) {
        break label91;
      }
      ((c)this.NVe.get()).gxJ();
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.voip.c.gxs().fqP) && (this.NKs)) {
        ((c)this.NVe.get()).gxS();
      }
      AppMethodBeat.o(115330);
      return;
      label91:
      ((c)this.NVe.get()).gxL();
    }
  }
  
  private void gyb()
  {
    AppMethodBeat.i(115327);
    this.ntw.postDelayed(new VideoActivity.9(this), 2000L);
    AppMethodBeat.o(115327);
  }
  
  public final void Ba(boolean paramBoolean)
  {
    AppMethodBeat.i(115357);
    Log.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(paramBoolean)));
    if (this.NVd != null) {
      this.NVd.Bc(paramBoolean);
    }
    AppMethodBeat.o(115357);
  }
  
  public final void XB(int paramInt)
  {
    AppMethodBeat.i(234432);
    Intent localIntent = new Intent(this, SettingsAboutCamera.class);
    localIntent.putExtra("activity_caller_params", 1);
    startActivityForResult(localIntent, 1);
    this.Fvv = true;
    this.Fvw = paramInt;
    AppMethodBeat.o(234432);
  }
  
  @Deprecated
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115351);
    if (this.NVd != null) {
      this.NVd.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115351);
  }
  
  @Deprecated
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(234416);
    if (this.NVd != null) {
      this.NVd.b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(234416);
  }
  
  public final void aU(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115359);
    this.NVh = paramBoolean2;
    if (paramBoolean1)
    {
      gyb();
      AppMethodBeat.o(115359);
      return;
    }
    finish();
    AppMethodBeat.o(115359);
  }
  
  public final void akB(final int paramInt)
  {
    AppMethodBeat.i(234446);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233562);
        if (VideoActivity.g(VideoActivity.this) == paramInt)
        {
          AppMethodBeat.o(233562);
          return;
        }
        VideoActivity.b(VideoActivity.this, paramInt);
        AppMethodBeat.o(233562);
      }
    });
    AppMethodBeat.o(234446);
  }
  
  @Deprecated
  public final com.tencent.mm.plugin.voip.video.b.a alh(int paramInt)
  {
    AppMethodBeat.i(115340);
    if (((this.NVd instanceof VoipVideoFragment)) && (this.NVd.gBU() != null)) {
      this.NVd.gBU().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            VideoActivity.this.NVn = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.NVn;
    AppMethodBeat.o(115340);
    return locala;
  }
  
  public final void ali(int paramInt)
  {
    AppMethodBeat.i(234448);
    if (this.NVd != null) {
      this.NVd.ali(paramInt);
    }
    AppMethodBeat.o(234448);
  }
  
  public final void alj(int paramInt)
  {
    AppMethodBeat.i(234449);
    if (this.NVd != null) {
      this.NVd.alj(paramInt);
    }
    AppMethodBeat.o(234449);
  }
  
  public final void alk(int paramInt)
  {
    AppMethodBeat.i(234450);
    if (this.NVd != null) {
      this.NVd.alk(paramInt);
    }
    AppMethodBeat.o(234450);
  }
  
  public final void bgj(final String paramString)
  {
    AppMethodBeat.i(115342);
    if (this.NVd != null) {
      this.ntw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115321);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).bgj(paramString);
          }
          AppMethodBeat.o(115321);
        }
      });
    }
    AppMethodBeat.o(115342);
  }
  
  public final void cG(int paramInt, String paramString)
  {
    AppMethodBeat.i(115341);
    Log.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.NKs) });
    this.wBU = true;
    if (paramInt == 241)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, null, true);
      AppMethodBeat.o(115341);
      return;
    }
    this.ntw.post(new VideoActivity.12(this, paramInt));
    AppMethodBeat.o(115341);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(115343);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V", this, localb.aFi());
    ar.p(ar.a(getWindow(), null), getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(paramView, 0);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V");
    AppMethodBeat.o(115343);
  }
  
  public final void eIO()
  {
    AppMethodBeat.i(234430);
    if (this.NVd != null) {
      this.NVd.alo(10);
    }
    AppMethodBeat.o(234430);
  }
  
  public final void eKF()
  {
    AppMethodBeat.i(115358);
    Log.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
    if (this.NVd != null) {
      this.NVd.gBM();
    }
    AppMethodBeat.o(115358);
  }
  
  public final void eXH() {}
  
  @Deprecated
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115347);
    if (this.NVd != null) {
      this.NVd.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115347);
  }
  
  public void finish()
  {
    AppMethodBeat.i(115334);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V", this);
    this.NVi = 3;
    Log.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[] { Boolean.valueOf(this.NVh), com.tencent.mm.plugin.voip.c.k.alz(this.mStatus) });
    Object localObject;
    if ((!this.NVh) && (com.tencent.mm.plugin.voip.c.k.alC(this.mStatus)) && (4 != this.NVi))
    {
      Log.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.iSn);
      com.tencent.mm.plugin.voip.d.mIG.d((Intent)localObject, this);
    }
    int i;
    if (this.NVk)
    {
      this.NVk = false;
      int j = com.tencent.mm.plugin.voip.c.gxs().gAn();
      long l = com.tencent.mm.plugin.voip.c.gxs().gAo();
      if (this.NKr)
      {
        i = 0;
        com.tencent.mm.plugin.voip.c.e.c(j, l, i, 5);
        com.tencent.mm.plugin.voip.c.e.alt(1);
      }
    }
    else
    {
      if (this.orientationEventListener != null)
      {
        this.orientationEventListener.disable();
        this.orientationEventListener.EZi = null;
        this.orientationEventListener = null;
      }
      if (this.NVd == null) {
        break label379;
      }
      if (this.NVd.NVv != 4105) {
        break label374;
      }
      i = 1;
      label229:
      this.NVd.uninit();
      this.NVd = null;
    }
    for (;;)
    {
      this.NVe = null;
      this.tRv = null;
      this.DZJ = true;
      super.finish();
      if (i != 0)
      {
        localObject = new lm();
        ((lm)localObject).fJm.fJp = true;
        ((lm)localObject).fJm.fJo = this.NVl;
        EventCenter.instance.publish((IEvent)localObject);
      }
      for (;;)
      {
        VoipBaseFragment.NVw = -1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V");
        AppMethodBeat.o(115334);
        return;
        i = 1;
        break;
        localObject = new lm();
        ((lm)localObject).fJm.fJp = false;
        ((lm)localObject).fJm.fJo = 0L;
        EventCenter.instance.publish((IEvent)localObject);
      }
      label374:
      i = 0;
      break label229;
      label379:
      i = 0;
    }
  }
  
  @Deprecated
  public final void gBG()
  {
    AppMethodBeat.i(115361);
    if ((this.NVd instanceof VoipVideoFragment)) {
      ((VoipVideoFragment)this.NVd).gBG();
    }
    AppMethodBeat.o(115361);
  }
  
  @Deprecated
  public final com.tencent.mm.plugin.voip.video.d.b gBH()
  {
    AppMethodBeat.i(234411);
    if ((this.NVd != null) && (this.NVd.gBU() != null)) {
      this.NVd.getSpatioTemporalFilterData().a(new b.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.d.b paramAnonymousb)
        {
          if (paramAnonymousb != null) {
            VideoActivity.this.NVo = paramAnonymousb;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.d.b localb = this.NVo;
    AppMethodBeat.o(234411);
    return localb;
  }
  
  public final Context gBI()
  {
    AppMethodBeat.i(115354);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(115354);
    return localAppCompatActivity;
  }
  
  public final void gBJ()
  {
    AppMethodBeat.i(234444);
    if (this.NVd != null) {
      this.NVd.gBJ();
    }
    AppMethodBeat.o(234444);
  }
  
  public final void gBK()
  {
    AppMethodBeat.i(234427);
    if (this.NVd != null) {
      this.NVd.XK(10);
    }
    AppMethodBeat.o(234427);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.e.voip_main;
  }
  
  @Deprecated
  public final void kN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115350);
    if (this.NVd != null) {
      this.NVd.kN(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115350);
  }
  
  public final void kR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115328);
    this.mStatus = paramInt2;
    if ((1 != this.NVi) && (paramInt2 != 8) && (paramInt2 != 262))
    {
      Log.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
      AppMethodBeat.o(115328);
      return;
    }
    if (this.NVd == null)
    {
      Log.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
      AppMethodBeat.o(115328);
      return;
    }
    this.NVd.kR(paramInt1, paramInt2);
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
      this.NKs = false;
      if ((this.NVd == null) || (!(this.NVd instanceof VoipVoiceFragment)))
      {
        if (this.NVd != null)
        {
          this.NVd.uninit();
          getSupportFragmentManager().beginTransaction().a(this.NVd).in();
          this.NVd = null;
        }
        Log.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_username", this.NKq.field_username);
        ((Bundle)localObject).putBoolean("key_isoutcall", this.NKr);
        ((Bundle)localObject).putInt("key_status", this.mStatus);
        this.NVd = new VoipVoiceFragment();
        this.NVd.setArguments((Bundle)localObject);
        this.NVd.setVoipUIListener((c)this.NVe.get());
        this.NVd.SG(this.NVf);
        this.NVd.a(this);
        this.NVd.setVoicePlayDevice(this.NKw);
        this.NVd.setMute(this.mIsMute);
        getSupportFragmentManager().beginTransaction().b(b.d.voip_container, this.NVd).in();
      }
      AppMethodBeat.o(115328);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      gyb();
      Log.d("MicroMsg.Voip.VideoActivity", "finishSmallWindow mStatus: %s", new Object[] { com.tencent.mm.plugin.voip.c.k.alz(this.mStatus) });
      if ((this.mStatus != 262) && (this.mStatus != 8)) {
        break;
      }
      com.tencent.mm.plugin.voip.c.gxt().ic(true);
      break;
      if (this.NKr)
      {
        localObject = this.NVd;
        if (!this.NKs) {
          break label523;
        }
      }
      label523:
      for (paramInt1 = b.g.voip_video_call_rejected;; paramInt1 = b.g.voip_audio_call_rejected)
      {
        ((VoipBaseFragment)localObject).kS(paramInt1, -1);
        gyb();
        break;
      }
      this.ntw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115311);
          if (VideoActivity.d(VideoActivity.this) != null) {
            VideoActivity.d(VideoActivity.this).kS(b.g.voip_shutdown_tip, -1);
          }
          VideoActivity.e(VideoActivity.this);
          AppMethodBeat.o(115311);
        }
      });
      continue;
      this.ntw.post(new VideoActivity.3(this));
      continue;
      this.ntw.postDelayed(new VideoActivity.10(this), 50L);
      continue;
      gyb();
      continue;
      finish();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(234435);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.Fvv = false;
      if (this.NVd != null)
      {
        if (this.Fvw == 2)
        {
          this.NVd.XK(5);
          AppMethodBeat.o(234435);
          return;
        }
        if (this.Fvw == 1) {
          this.NVd.alo(5);
        }
      }
    }
    AppMethodBeat.o(234435);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(115325);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.lbY != null) && (com.tencent.mm.compatible.util.d.qV(17)))
    {
      paramConfiguration = new Point();
      getWindowManager().getDefaultDisplay().getRealSize(paramConfiguration);
      if ((!paramConfiguration.equals(this.lbY)) && (this.NVd != null))
      {
        this.lbY = paramConfiguration;
        this.NVd.l(this.lbY);
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
    com.tencent.mm.plugin.voip.c.d locald;
    try
    {
      paramBundle = t.NPb;
      t.gzI();
      com.tencent.mm.util.e.gsM();
      setActionbarColor(getResources().getColor(b.a.transparent));
      setRequestedOrientation(7);
      if (!com.tencent.mm.plugin.voip.c.m.iH(getContext())) {
        com.tencent.mm.plugin.voip.c.m.iI(getContext());
      }
      Log.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
      getSupportActionBar().hide();
      getWindow().setSoftInputMode(3);
      this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(this);
      this.orientationEventListener.enable();
      this.orientationEventListener.EZi = this;
      getWindow().addFlags(6815872);
      if (com.tencent.mm.kernel.h.aHB()) {
        com.tencent.mm.plugin.voip.c.gxs().aS(false, false);
      }
      this.ntw = new MMHandler();
      localObject1 = new PBool();
      localPBool = new PBool();
      localPString = new PString();
      localPInt = new PInt();
      localObject2 = new PInt();
      localPString.value = getIntent().getStringExtra("Voip_User");
      ((PBool)localObject1).value = getIntent().getBooleanExtra("Voip_Outcall", true);
      localPBool.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
      this.NVl = getIntent().getLongExtra("Voip_LastPage_Hash", 0L);
      localPInt.value = com.tencent.mm.plugin.voip.c.k.bc(((PBool)localObject1).value, localPBool.value);
      paramBundle = new PLong();
      paramBundle.value = getIntent().getLongExtra("Voip_CallRoomKey", 0L);
      ((PInt)localObject2).value = getIntent().getIntExtra("Voip_Call_From", -1);
      bool = ((PBool)localObject1).value;
      if (bool) {
        try
        {
          if ((eXG()) && (!isFinishing()))
          {
            Toast.makeText(this, b.g.voip_in_phone_tip, 0).show();
            Log.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
            com.tencent.mm.plugin.voip.c.gxs().unRegister();
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
      if (com.tencent.mm.plugin.voip.c.d.gCo())
      {
        locald = com.tencent.mm.plugin.voip.c.d.NXJ;
        com.tencent.mm.plugin.voip.c.d.gCx();
      }
      if (paramBundle.value != com.tencent.mm.plugin.voip.c.gxs().gAo())
      {
        if (com.tencent.mm.plugin.voip.c.gxs().gAo() != 0L)
        {
          locald = com.tencent.mm.plugin.voip.c.d.NXJ;
          com.tencent.mm.plugin.voip.c.d.gCq();
          if (((PBool)localObject1).value) {
            break label1710;
          }
          if (!com.tencent.mm.plugin.voip.c.gxs().NPf.gyH()) {
            break label514;
          }
          break label1710;
        }
        for (;;)
        {
          locald = com.tencent.mm.plugin.voip.c.d.NXJ;
          com.tencent.mm.plugin.voip.c.d.a(((PInt)localObject2).value, true, paramBundle.value, com.tencent.mm.plugin.voip.c.gxs().gAo(), bool);
          if ((!com.tencent.mm.plugin.voip.c.d.gCo()) || (com.tencent.mm.plugin.voip.c.gxs().gAo() == 0L)) {
            break;
          }
          Log.e("MicroMsg.Voip.VideoActivity", "fake calling comming and forbid itself cause key is no similar");
          com.tencent.mm.plugin.voip.c.gxs().unRegister();
          super.finish();
          AppMethodBeat.o(115324);
          return;
          label514:
          bool = false;
        }
      }
      locald = com.tencent.mm.plugin.voip.c.d.NXJ;
      com.tencent.mm.plugin.voip.c.d.gCr();
      if (((PBool)localObject1).value) {
        break label1715;
      }
      if (com.tencent.mm.plugin.voip.c.gxs().NPf.gyH())
      {
        break label1715;
        label550:
        locald = com.tencent.mm.plugin.voip.c.d.NXJ;
        com.tencent.mm.plugin.voip.c.d.a(((PInt)localObject2).value, false, paramBundle.value, com.tencent.mm.plugin.voip.c.gxs().gAo(), bool);
        if ((((PBool)localObject1).value) || (com.tencent.mm.plugin.voip.c.gxs().NPf.gyH()) || (!com.tencent.mm.plugin.voip.c.d.gCp())) {
          break label749;
        }
        Log.e("MicroMsg.Voip.VideoActivity", "fake calling comming and forbid itself cause engine is close");
        com.tencent.mm.plugin.voip.c.gxs().unRegister();
        localObject1 = com.tencent.mm.plugin.voip.c.d.NXJ;
        com.tencent.mm.plugin.voip.c.d.gCv();
        localObject1 = com.tencent.mm.plugin.voip.c.d.NXJ;
        com.tencent.mm.plugin.voip.c.d.a(((PInt)localObject2).value, true, paramBundle.value, com.tencent.mm.plugin.voip.c.gxs().gAo(), true);
        localObject1 = com.tencent.mm.plugin.voip.c.d.NXJ;
        localObject1 = com.tencent.mm.plugin.voip.c.gxs();
        long l = paramBundle.value;
        paramBundle = (Boolean)((u)localObject1).NPC.get(Long.valueOf(l));
        if (paramBundle != null) {
          break label710;
        }
        bool = false;
        label687:
        if (!bool) {
          break label718;
        }
        com.tencent.mm.plugin.voip.c.d.gCy();
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
        com.tencent.mm.plugin.voip.c.d.gCz();
      }
      localObject2 = com.tencent.mm.plugin.voip.c.gxs();
    }
    catch (Exception paramBundle)
    {
      com.tencent.mm.plugin.voip.c.e.alt(2);
      Log.printErrStackTrace("MicroMsg.Voip.VideoActivity", paramBundle, "", new Object[0]);
      AppMethodBeat.o(115324);
      return;
    }
    label749:
    if (((u)localObject2).NPg != null)
    {
      Log.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
      localPString.value = ((u)localObject2).NPg.getUserName();
      ((PBool)localObject1).value = ((u)localObject2).NPg.gxm();
      localPBool.value = ((u)localObject2).NPg.gxl();
      localPInt.value = ((u)localObject2).NPg.getState();
      paramBundle = ((u)localObject2).NPg;
    }
    label1031:
    for (;;)
    {
      label829:
      if (paramBundle == null)
      {
        Log.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
        com.tencent.mm.plugin.voip.c.gxs().unRegister();
        super.finish();
        AppMethodBeat.o(115324);
        return;
        Log.i("MicroMsg.Voip.VoipService", "pToUser before is %s and after is %s", new Object[] { localPString.value, ((u)localObject2).NPf.toUser });
        if (!localPString.value.equals(((u)localObject2).NPf.toUser))
        {
          locald = com.tencent.mm.plugin.voip.c.d.NXJ;
          com.tencent.mm.plugin.voip.c.d.gCw();
        }
        if (com.tencent.mm.plugin.voip.c.d.gCp()) {
          localPString.value = ((u)localObject2).NPf.toUser;
        }
        localPString.value = ((u)localObject2).NPf.toUser;
        localPBool.value = ((u)localObject2).NPf.NPF;
        if (localPString.value == null)
        {
          Log.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
          paramBundle = null;
        }
        else if ((!((PBool)localObject1).value) && (!((u)localObject2).NPf.gyH()))
        {
          Log.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
          localObject2 = localPString.value;
          if (localPBool.value)
          {
            paramBundle = ca.VGy;
            if (!((PBool)localObject1).value) {
              break label1720;
            }
          }
        }
      }
    }
    label1710:
    label1715:
    label1720:
    for (int i = 1;; i = 0)
    {
      s.b((String)localObject2, paramBundle, i, 4, MMApplicationContext.getContext().getString(b.g.voip_call_cancel_msg_from));
      paramBundle = null;
      break label829;
      paramBundle = ca.VGx;
      break label1031;
      if (g.gCD()) {}
      for (((u)localObject2).NPg = new NewVoipMgr();; ((u)localObject2).NPg = new VoipMgr())
      {
        ((u)localObject2).NPg.a(this, localPString.value, ((PBool)localObject1).value, localPBool.value, paramBundle.value);
        paramBundle = ((u)localObject2).NPg;
        break;
      }
      this.NVe = new WeakReference(paramBundle);
      this.iSn = localPString.value;
      this.NKs = localPBool.value;
      this.NKr = ((PBool)localObject1).value;
      if (this.mStatus == -1) {}
      for (i = localPInt.value;; i = this.mStatus)
      {
        this.mStatus = i;
        this.NKq = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.iSn);
        paramBundle = new Bundle();
        paramBundle.putString("key_username", this.NKq.field_username);
        paramBundle.putBoolean("key_isoutcall", this.NKr);
        paramBundle.putInt("key_status", com.tencent.mm.plugin.voip.c.k.bc(this.NKr, this.NKs));
        if (!com.tencent.mm.plugin.voip.c.k.asM(this.mStatus)) {
          break;
        }
        com.tencent.mm.plugin.voip.c.gxs().unRegister();
        Log.i("MicroMsg.Voip.VideoActivity", "current is run on failed");
        super.finish();
        AppMethodBeat.o(115324);
        return;
      }
      if (com.tencent.mm.plugin.voip.c.k.alD(this.mStatus)) {
        if (g.gCD()) {
          this.NVd = new NewVoipVideoFragment();
        }
      }
      for (;;)
      {
        this.NVd.setArguments(paramBundle);
        getSupportFragmentManager().beginTransaction().b(b.d.voip_container, this.NVd).in();
        setTitleVisibility(8);
        if ((com.tencent.mm.plugin.voip.c.k.alE(this.mStatus)) && (this.NKr)) {
          this.ntw.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115315);
              if ((com.tencent.mm.plugin.voip.c.k.alE(VideoActivity.b(VideoActivity.this))) && (!VideoActivity.c(VideoActivity.this)) && (VideoActivity.d(VideoActivity.this) != null)) {
                VideoActivity.d(VideoActivity.this).kS(b.g.voip_callout_timeout_prompt, 10000);
              }
              AppMethodBeat.o(115315);
            }
          }, 20000L);
        }
        if (com.tencent.mm.plugin.voip.c.gxs().NPg.gxn() != null) {
          bgj(com.tencent.mm.plugin.voip.c.gxs().NPg.gxn());
        }
        if (this.NKs) {
          s.iF(this);
        }
        this.DYP = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
        this.DYP.I(9, "VOIPFloatBall");
        if ((this.NVe != null) && (this.NVe.get() != null)) {
          ((c)this.NVe.get()).a(this, 1);
        }
        this.NVd.setVoipUIListener((c)this.NVe.get());
        this.NVd.a(this);
        this.NVd.setMute(this.mIsMute);
        Log.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[] { Boolean.valueOf(this.NKr), Boolean.valueOf(this.NKs), this.iSn, Integer.valueOf(this.mStatus) });
        EventCenter.instance.addListener(this.khI);
        EventCenter.instance.addListener(this.Fix);
        if (com.tencent.mm.compatible.util.d.qV(17))
        {
          this.lbY = new Point();
          if (getWindow().getDecorView().getDisplay() != null) {
            getWindow().getDecorView().getDisplay().getRealSize(this.lbY);
          }
        }
        AppMethodBeat.o(115324);
        return;
        this.NVd = new VoipVideoFragment();
        continue;
        this.NVd = new VoipVoiceFragment();
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
    this.NVi = 4;
    Log.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[] { com.tencent.mm.plugin.voip.c.k.alz(this.mStatus) });
    t localt = t.NPb;
    t.gzJ();
    if (!this.DZJ) {
      finish();
    }
    if ((this.NVe != null) && (this.NVe.get() != null)) {
      ((c)this.NVe.get()).a(this);
    }
    if (this.DYP != null) {
      this.DYP.onDestroy();
    }
    EventCenter.instance.removeListener(this.khI);
    EventCenter.instance.removeListener(this.Fix);
    setScreenEnable(true);
    super.onDestroy();
    if (!this.NVh) {
      com.tencent.mm.media.g.c.kVi.aUQ();
    }
    AppMethodBeat.o(115331);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(115329);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.sg(paramInt);
    localb.bn(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", this, localb.aFi());
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(115329);
      return true;
    }
    if (paramInt == 25)
    {
      if ((!com.tencent.mm.plugin.voip.c.gxs().NPf.cNL()) && (!this.NKr))
      {
        if ((this.NVe != null) && (this.NVe.get() != null)) {
          ((c)this.NVe.get()).gxW();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.crn().crm()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.cri();; paramInt = eJJ())
      {
        com.tencent.mm.plugin.audio.c.a.Ey(paramInt);
        break;
      }
    }
    if (paramInt == 24)
    {
      if ((!com.tencent.mm.plugin.voip.c.gxs().NPf.cNL()) && (!this.NKr))
      {
        if ((this.NVe != null) && ((c)this.NVe.get() != null)) {
          ((c)this.NVe.get()).gxW();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(115329);
        return true;
      }
      if (com.tencent.mm.plugin.audio.c.a.crn().crm()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.cri();; paramInt = eJJ())
      {
        com.tencent.mm.plugin.audio.c.a.Ex(paramInt);
        break;
      }
    }
    if ((af.juH.jpM == 1) && (paramInt == 700))
    {
      gBS();
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
    AppMethodBeat.i(234452);
    int j = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
    paramInt = i;
    switch (j)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if ((this.NVe != null) && (this.NVe.get() != null) && (this.NVd != null)) {
        ((c)this.NVe.get()).kM(j, paramInt);
      }
      if (this.NVd != null) {
        this.NVd.aln(paramInt);
      }
      AppMethodBeat.o(234452);
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
      this.DZK = bool1;
      Log.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[] { com.tencent.mm.plugin.voip.c.k.alz(this.mStatus), Boolean.valueOf(this.DZK), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
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
        for (paramInt = b.g.permission_camera_request_again_msg;; paramInt = b.g.permission_microphone_request_again_msg)
        {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(b.g.permission_tips_title), getString(b.g.jump_to_settings), getString(b.g.app_cancel), false, new VideoActivity.4(this), new VideoActivity.5(this));
          AppMethodBeat.o(115362);
          return;
        }
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(b.g.permission_microphone_request_again_msg), getString(b.g.permission_tips_title), getString(b.g.jump_to_settings), getString(b.g.app_cancel), false, new VideoActivity.6(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(115338);
    Log.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[] { com.tencent.mm.plugin.voip.c.k.alz(this.mStatus) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    l locall = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk;
    if (locall.NLU) {
      locall.NLU = false;
    }
    super.onResume();
    if ((this.NVe != null) && (this.NVe.get() != null)) {
      ((c)this.NVe.get()).gxO();
    }
    onOrientationChange(0);
    setScreenEnable(true);
    this.NVg = Util.currentTicks();
    this.NVk = true;
    if ((this.NVe != null) && (this.NVe.get() != null)) {
      ((c)this.NVe.get()).gxP();
    }
    if ((this.DYP != null) && (!this.Fvv))
    {
      this.DYP.aOf();
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
    if (this.NKs)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
      Log.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
      com.tencent.mm.plugin.voip.c.gxs().NPx = bool;
      Log.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), Util.getStack(), this });
    }
    for (;;)
    {
      if (!this.DZJ)
      {
        Log.i("MicroMsg.Voip.VideoActivity", "onStart");
        this.NVi = 1;
        kR(4096, this.mStatus);
      }
      AppMethodBeat.o(115333);
      return;
      Log.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), Util.getStack(), this });
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(115332);
    this.NVi = 2;
    Log.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[] { com.tencent.mm.plugin.voip.c.k.alz(this.mStatus) });
    com.tencent.mm.plugin.report.service.h localh;
    if ((262 != this.mStatus) && (8 != this.mStatus) && (this.DZK) && (!this.Fvv) && (!this.DZJ) && (this.NVe != null) && (this.NVe.get() != null) && (((c)this.NVe.get()).AP(false)))
    {
      if (this.NVd != null) {
        this.NVd.gBT();
      }
      aU(false, true);
      if (com.tencent.mm.plugin.voip.c.k.alC(this.mStatus))
      {
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (!com.tencent.mm.plugin.voip.c.k.alD(this.mStatus)) {
          break label218;
        }
      }
    }
    label218:
    for (int i = 2;; i = 3)
    {
      localh.a(11618, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      if ((this.DYP != null) && (!this.Fvv))
      {
        this.DYP.aOj();
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
  
  @Deprecated
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115353);
    if (this.NVd != null) {
      this.NVd.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115353);
  }
  
  @Deprecated
  public final void requestRender()
  {
    AppMethodBeat.i(115352);
    if (this.NVd != null) {
      this.NVd.requestRender();
    }
    AppMethodBeat.o(115352);
  }
  
  @Deprecated
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(234405);
    this.tRv = paramCaptureView;
    if (this.NVd != null) {
      this.NVd.a(paramCaptureView);
    }
    AppMethodBeat.o(234405);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115356);
    this.NVf = paramLong;
    if (this.NVd != null) {
      this.NVd.SG(this.NVf);
    }
    AppMethodBeat.o(115356);
  }
  
  @Deprecated
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115349);
    if (this.NVd != null) {
      this.NVd.setHWDecMode(paramInt);
    }
    AppMethodBeat.o(115349);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115346);
    this.mIsMute = paramBoolean;
    if (this.NVd != null) {
      this.NVd.setMute(paramBoolean);
    }
    AppMethodBeat.o(115346);
  }
  
  public void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(115335);
    super.setScreenEnable(paramBoolean);
    if (this.NVe != null) {
      this.NVe.get();
    }
    AppMethodBeat.o(115335);
  }
  
  @Deprecated
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(234406);
    if (this.NVd != null) {
      this.NVd.setSpatiotemporalDenosing(paramInt);
    }
    AppMethodBeat.o(234406);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115345);
    if (this.NKw != -1) {
      switch (paramInt)
      {
      default: 
        if (!this.NKs) {
          setScreenEnable(true);
        }
        break;
      }
    }
    for (;;)
    {
      this.NKw = paramInt;
      if ((this.NVe != null) && (this.NVe.get() != null)) {
        ((c)this.NVe.get()).setVoicePlayDevice(paramInt);
      }
      if (this.NVd != null) {
        this.NVd.setVoicePlayDevice(paramInt);
      }
      AppMethodBeat.o(115345);
      return;
      Toast.makeText(getContext(), getContext().getString(b.g.voip_voice_come_from_speaker), 0).show();
      if (!this.NKs)
      {
        setScreenEnable(true);
        continue;
        Toast.makeText(getContext(), getContext().getString(b.g.voip_voice_come_from_earpiece), 0).show();
      }
    }
  }
  
  @Deprecated
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115348);
    if (this.NVd != null) {
      this.NVd.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(115348);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115355);
    if (this.NVd != null) {
      this.NVd.uninit();
    }
    AppMethodBeat.o(115355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity
 * JD-Core Version:    0.7.0.1
 */