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
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sight.encode.a.a;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public abstract class SightCameraView
  extends FrameLayout
  implements d.a
{
  protected int hxH = 320;
  private long mSh = 0L;
  private com.tencent.mm.model.d ozB = new com.tencent.mm.model.d();
  private Animation vdD;
  protected boolean zlA = false;
  protected int zlB = 6500;
  protected a zlC;
  private aw zlD = new aw(Looper.getMainLooper(), new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(28780);
      float f = (float)SightCameraView.this.zlu.dTY() / SightCameraView.this.zlB;
      if ((Float.compare(f, 0.0F) <= 0) && (System.currentTimeMillis() - SightCameraView.a(SightCameraView.this) > 20000L))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[] { Long.valueOf(20000L) });
        SightCameraView.this.cvy();
        AppMethodBeat.o(28780);
        return false;
      }
      if ((Float.compare(f, 1.0F) > 0) && (SightCameraView.this.zlu.dTZ() == a.a.zke)) {
        if (!SightCameraView.this.zlu.Np()) {
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
  private int zlE = -1;
  private Runnable zlF = new SightCameraView.2(this);
  private Runnable zlG = new SightCameraView.3(this);
  protected e zlt;
  protected a zlu;
  protected ImageView zlv;
  protected Runnable zlw;
  protected long zlx = -1L;
  protected SightCameraView.b zly = SightCameraView.b.zlK;
  protected boolean zlz = false;
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (com.tencent.mm.plugin.sight.base.e.dTv()) {
      inflate(getContext(), 2131495449, this);
    }
    for (;;)
    {
      this.zlz = false;
      this.zlA = false;
      this.zlt = new e();
      paramContext = this.zlt;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCamera", "init needRotate %s", new Object[] { Boolean.FALSE });
      if (com.tencent.mm.compatible.deviceinfo.ae.geO.gez)
      {
        paramContext.zlr.waN = com.tencent.mm.compatible.deviceinfo.ae.geO.mVideoHeight;
        paramContext.zlr.waO = com.tencent.mm.compatible.deviceinfo.ae.geO.mVideoWidth;
        paramContext.zlr.waM = com.tencent.mm.compatible.deviceinfo.ae.geO.geB;
      }
      paramContext.zlr.waX = com.tencent.mm.compatible.deviceinfo.d.getNumberOfCameras();
      paramContext.zlr.dHi = 0;
      this.zlv = ((ImageView)findViewById(2131303526));
      dUr();
      return;
      inflate(getContext(), 2131495448, this);
    }
  }
  
  private void dUr()
  {
    if (this.zlv.getVisibility() == 4) {
      return;
    }
    if (this.vdD != null) {
      this.vdD.cancel();
    }
    this.zlv.setVisibility(4);
  }
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  protected abstract void bM(String paramString, boolean paramBoolean);
  
  public final void bc(float paramFloat)
  {
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SightCameraView", "update progress %f", new Object[] { Float.valueOf(paramFloat) });
    if (this.zlE < 0) {
      this.zlE = getResources().getDisplayMetrics().widthPixels;
    }
    if (paramFloat < 0.0F)
    {
      localLayoutParams = this.zlv.getLayoutParams();
      localLayoutParams.width = this.zlE;
      this.zlv.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramFloat > 1.0F)
    {
      i = this.zlE / 2;
      localLayoutParams = this.zlv.getLayoutParams();
      localLayoutParams.width = (this.zlE - (i - 1) * 2);
      this.zlv.setLayoutParams(localLayoutParams);
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels * paramFloat / 2.0F);
    ViewGroup.LayoutParams localLayoutParams = this.zlv.getLayoutParams();
    localLayoutParams.width = (this.zlE - i * 2);
    this.zlv.setLayoutParams(localLayoutParams);
  }
  
  protected final void cvy()
  {
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SightCameraView", "cancel record");
    if (this.zlu == null) {
      throw new IllegalStateException("The mSightMedia must be set!");
    }
    bc.ajU().cZF().removeCallbacks(this.zlF);
    bc.ajU().aw(this.zlG);
    this.zlD.stopTimer();
    bc(0.0F);
    dUr();
    setKeepScreenOn(false);
  }
  
  protected abstract void dUq();
  
  protected final void dUs()
  {
    this.ozB.ez(false);
  }
  
  public a.a getCurMediaStatus()
  {
    return this.zlu.dTZ();
  }
  
  public int getDuration()
  {
    return this.zlu.getDuration();
  }
  
  protected abstract Surface getPreviewSurface();
  
  public String getRecordPath()
  {
    return this.zlu.getRecordPath();
  }
  
  protected abstract int getSurfaceHeight();
  
  protected abstract int getSurfaceWidth();
  
  public abstract boolean isPlaying();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    e locale;
    if ((paramMotionEvent.getAction() == 0) && (this.zlz) && (this.zlA))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCameraView", "check double click %dms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.zlx) });
      if (SystemClock.elapsedRealtime() - this.zlx >= 400L) {
        break label381;
      }
      this.zlt.zls.removeMessages(4354);
      locale = this.zlt;
      if (locale.vZG) {
        break label125;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
    }
    for (;;)
    {
      this.zlx = SystemClock.elapsedRealtime();
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      com.tencent.mm.compatible.util.d.lB(14);
      return true;
      try
      {
        label125:
        Camera.Parameters localParameters = locale.gaZ.getParameters();
        if (localParameters == null) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[] { Boolean.valueOf(locale.hsj), Boolean.valueOf(localParameters.isZoomSupported()) });
        if (!localParameters.isZoomSupported()) {
          continue;
        }
        locale.zls.removeMessages(4353);
        if (locale.hsj)
        {
          locale.zls.hsk = false;
          locale.zls.hsj = false;
          locale.zls.hsi = (e.a.f(localParameters) * -1);
          locale.zls.sendMessage(locale.zls.obtainMessage(4353, locale.gaZ));
          if (!locale.hsj) {
            bool = true;
          }
          locale.hsj = bool;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightCamera", "getParameters failed %s", new Object[] { localException.getMessage() });
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          localObject = null;
          continue;
          locale.zls.hsk = false;
          locale.zls.hsj = true;
          locale.zls.hsi = e.a.f((Camera.Parameters)localObject);
          locale.zls.sendMessage(locale.zls.obtainMessage(4353, locale.gaZ));
        }
      }
      label381:
      Object localObject = this.zlt;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = getSurfaceWidth();
      int j = getSurfaceHeight();
      if (!com.tencent.mm.compatible.util.d.lB(14))
      {
        ((e)localObject).zls.removeMessages(4354);
        ((e)localObject).zls.gpg = f1;
        ((e)localObject).zls.gph = f2;
        ((e)localObject).zls.hsm = i;
        ((e)localObject).zls.hsn = j;
        ((e)localObject).zls.sendMessageDelayed(((e)localObject).zls.obtainMessage(4354, ((e)localObject).gaZ), 400L);
      }
    }
  }
  
  protected final void requestAudioFocus()
  {
    this.ozB.a(this);
  }
  
  public abstract void setFixPreviewRate(float paramFloat);
  
  protected abstract void setIsMute(boolean paramBoolean);
  
  public void setPreviewRate(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.height = ((int)(localDisplayMetrics.widthPixels / paramFloat));
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height), Float.valueOf(paramFloat) });
    postInvalidate();
  }
  
  public void setRecordMaxDuring(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : ".concat(String.valueOf(paramInt)));
    this.zlB = paramInt;
  }
  
  public void setSightCameraUIIm(a parama)
  {
    this.zlC = parama;
  }
  
  public void setSightMedia(a parama)
  {
    this.zlu = parama;
    if ((this.zlu != null) && (this.zlt != null)) {
      this.zlt.mPreviewCallback = this.zlu.dUa();
    }
  }
  
  protected void setStopCallback(Runnable paramRunnable)
  {
    this.zlw = paramRunnable;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.hxH = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView
 * JD-Core Version:    0.7.0.1
 */