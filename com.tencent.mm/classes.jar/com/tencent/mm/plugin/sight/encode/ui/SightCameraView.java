package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sight.encode.a.a;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public abstract class SightCameraView
  extends FrameLayout
  implements d.a
{
  protected int huT = 320;
  private long mNe = 0L;
  private com.tencent.mm.model.d ota = new com.tencent.mm.model.d();
  private Animation uRR;
  protected e yVj;
  protected a yVk;
  protected ImageView yVl;
  protected Runnable yVm;
  protected long yVn = -1L;
  protected SightCameraView.b yVo = SightCameraView.b.yVA;
  protected boolean yVp = false;
  protected boolean yVq = false;
  protected int yVr = 6500;
  protected a yVs;
  private av yVt = new av(Looper.getMainLooper(), new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(28780);
      float f = (float)SightCameraView.this.yVk.dQB() / SightCameraView.this.yVr;
      if ((Float.compare(f, 0.0F) <= 0) && (System.currentTimeMillis() - SightCameraView.a(SightCameraView.this) > 20000L))
      {
        ad.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[] { Long.valueOf(20000L) });
        SightCameraView.this.ctX();
        AppMethodBeat.o(28780);
        return false;
      }
      if ((Float.compare(f, 1.0F) > 0) && (SightCameraView.this.yVk.dQC() == a.a.yTU)) {
        if (!SightCameraView.this.yVk.Nu()) {
          SightCameraView.b(SightCameraView.this);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28780);
        return true;
        SightCameraView.this.bc(f);
      }
    }
  }, true);
  private int yVu = -1;
  private Runnable yVv = new SightCameraView.2(this);
  private Runnable yVw = new SightCameraView.3(this);
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (com.tencent.mm.plugin.sight.base.e.dPY()) {
      inflate(getContext(), 2131495449, this);
    }
    for (;;)
    {
      this.yVp = false;
      this.yVq = false;
      this.yVj = new e();
      paramContext = this.yVj;
      ad.i("MicroMsg.SightCamera", "init needRotate %s", new Object[] { Boolean.FALSE });
      if (ae.gcG.gcr)
      {
        paramContext.yVh.vOK = ae.gcG.mVideoHeight;
        paramContext.yVh.vOL = ae.gcG.mVideoWidth;
        paramContext.yVh.vOJ = ae.gcG.gct;
      }
      paramContext.yVh.vOU = com.tencent.mm.compatible.deviceinfo.d.getNumberOfCameras();
      paramContext.yVh.dGc = 0;
      this.yVl = ((ImageView)findViewById(2131303526));
      dQU();
      return;
      inflate(getContext(), 2131495448, this);
    }
  }
  
  private void dQU()
  {
    if (this.yVl.getVisibility() == 4) {
      return;
    }
    if (this.uRR != null) {
      this.uRR.cancel();
    }
    this.yVl.setVisibility(4);
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final void azY() {}
  
  public final void azZ() {}
  
  protected abstract void bI(String paramString, boolean paramBoolean);
  
  public final void bc(float paramFloat)
  {
    ad.d("MicroMsg.SightCameraView", "update progress %f", new Object[] { Float.valueOf(paramFloat) });
    if (this.yVu < 0) {
      this.yVu = getResources().getDisplayMetrics().widthPixels;
    }
    if (paramFloat < 0.0F)
    {
      localLayoutParams = this.yVl.getLayoutParams();
      localLayoutParams.width = this.yVu;
      this.yVl.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramFloat > 1.0F)
    {
      i = this.yVu / 2;
      localLayoutParams = this.yVl.getLayoutParams();
      localLayoutParams.width = (this.yVu - (i - 1) * 2);
      this.yVl.setLayoutParams(localLayoutParams);
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels * paramFloat / 2.0F);
    ViewGroup.LayoutParams localLayoutParams = this.yVl.getLayoutParams();
    localLayoutParams.width = (this.yVu - i * 2);
    this.yVl.setLayoutParams(localLayoutParams);
  }
  
  protected final void ctX()
  {
    ad.w("MicroMsg.SightCameraView", "cancel record");
    if (this.yVk == null) {
      throw new IllegalStateException("The mSightMedia must be set!");
    }
    ba.ajF().cWY().removeCallbacks(this.yVv);
    ba.ajF().ay(this.yVw);
    this.yVt.stopTimer();
    bc(0.0F);
    dQU();
    setKeepScreenOn(false);
  }
  
  protected abstract void dQT();
  
  protected final void dQV()
  {
    this.ota.ex(false);
  }
  
  public a.a getCurMediaStatus()
  {
    return this.yVk.dQC();
  }
  
  public int getDuration()
  {
    return this.yVk.getDuration();
  }
  
  protected abstract Surface getPreviewSurface();
  
  public String getRecordPath()
  {
    return this.yVk.getRecordPath();
  }
  
  protected abstract int getSurfaceHeight();
  
  protected abstract int getSurfaceWidth();
  
  public abstract boolean isPlaying();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    e locale;
    if ((paramMotionEvent.getAction() == 0) && (this.yVp) && (this.yVq))
    {
      ad.i("MicroMsg.SightCameraView", "check double click %dms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.yVn) });
      if (SystemClock.elapsedRealtime() - this.yVn >= 400L) {
        break label381;
      }
      this.yVj.yVi.removeMessages(4354);
      locale = this.yVj;
      if (locale.vND) {
        break label125;
      }
      ad.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
    }
    for (;;)
    {
      this.yVn = SystemClock.elapsedRealtime();
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      com.tencent.mm.compatible.util.d.lz(14);
      return true;
      try
      {
        label125:
        Camera.Parameters localParameters = locale.fYS.getParameters();
        if (localParameters == null) {
          continue;
        }
        ad.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[] { Boolean.valueOf(locale.hpv), Boolean.valueOf(localParameters.isZoomSupported()) });
        if (!localParameters.isZoomSupported()) {
          continue;
        }
        locale.yVi.removeMessages(4353);
        if (locale.hpv)
        {
          locale.yVi.hpw = false;
          locale.yVi.hpv = false;
          locale.yVi.hpu = (e.a.f(localParameters) * -1);
          locale.yVi.sendMessage(locale.yVi.obtainMessage(4353, locale.fYS));
          if (!locale.hpv) {
            bool = true;
          }
          locale.hpv = bool;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.SightCamera", "getParameters failed %s", new Object[] { localException.getMessage() });
          ad.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          localObject = null;
          continue;
          locale.yVi.hpw = false;
          locale.yVi.hpv = true;
          locale.yVi.hpu = e.a.f((Camera.Parameters)localObject);
          locale.yVi.sendMessage(locale.yVi.obtainMessage(4353, locale.fYS));
        }
      }
      label381:
      Object localObject = this.yVj;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = getSurfaceWidth();
      int j = getSurfaceHeight();
      if (!com.tencent.mm.compatible.util.d.lz(14))
      {
        ((e)localObject).yVi.removeMessages(4354);
        ((e)localObject).yVi.gmK = f1;
        ((e)localObject).yVi.gmL = f2;
        ((e)localObject).yVi.hpy = i;
        ((e)localObject).yVi.hpz = j;
        ((e)localObject).yVi.sendMessageDelayed(((e)localObject).yVi.obtainMessage(4354, ((e)localObject).fYS), 400L);
      }
    }
  }
  
  protected final void requestAudioFocus()
  {
    this.ota.a(this);
  }
  
  public abstract void setFixPreviewRate(float paramFloat);
  
  protected abstract void setIsMute(boolean paramBoolean);
  
  public void setPreviewRate(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.height = ((int)(localDisplayMetrics.widthPixels / paramFloat));
    ad.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height), Float.valueOf(paramFloat) });
    postInvalidate();
  }
  
  public void setRecordMaxDuring(int paramInt)
  {
    ad.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : ".concat(String.valueOf(paramInt)));
    this.yVr = paramInt;
  }
  
  public void setSightCameraUIIm(a parama)
  {
    this.yVs = parama;
  }
  
  public void setSightMedia(a parama)
  {
    this.yVk = parama;
    if ((this.yVk != null) && (this.yVj != null)) {
      this.yVj.mPreviewCallback = this.yVk.dQD();
    }
  }
  
  protected void setStopCallback(Runnable paramRunnable)
  {
    this.yVm = paramRunnable;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.huT = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView
 * JD-Core Version:    0.7.0.1
 */