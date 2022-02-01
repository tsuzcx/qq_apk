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
import com.tencent.mm.model.az;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sight.encode.a.a;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public abstract class SightCameraView
  extends FrameLayout
  implements d.a
{
  protected int hcL = 320;
  private long mmC = 0L;
  private com.tencent.mm.model.d nQt = new com.tencent.mm.model.d();
  private Animation tPe;
  protected a xGA;
  protected ImageView xGB;
  protected Runnable xGC;
  protected long xGD = -1L;
  protected SightCameraView.b xGE = SightCameraView.b.xGQ;
  protected boolean xGF = false;
  protected boolean xGG = false;
  protected int xGH = 6500;
  protected a xGI;
  private au xGJ = new au(Looper.getMainLooper(), new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(28780);
      float f = (float)SightCameraView.this.xGA.dEZ() / SightCameraView.this.xGH;
      if ((Float.compare(f, 0.0F) <= 0) && (System.currentTimeMillis() - SightCameraView.a(SightCameraView.this) > 20000L))
      {
        ac.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[] { Long.valueOf(20000L) });
        SightCameraView.this.cos();
        AppMethodBeat.o(28780);
        return false;
      }
      if ((Float.compare(f, 1.0F) > 0) && (SightCameraView.this.xGA.dFa() == a.a.xFk)) {
        if (!SightCameraView.this.xGA.LL()) {
          SightCameraView.b(SightCameraView.this);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28780);
        return true;
        SightCameraView.this.aZ(f);
      }
    }
  }, true);
  private int xGK = -1;
  private Runnable xGL = new SightCameraView.2(this);
  private Runnable xGM = new SightCameraView.3(this);
  protected e xGz;
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (com.tencent.mm.plugin.sight.base.e.dEv()) {
      inflate(getContext(), 2131495449, this);
    }
    for (;;)
    {
      this.xGF = false;
      this.xGG = false;
      this.xGz = new e();
      paramContext = this.xGz;
      ac.i("MicroMsg.SightCamera", "init needRotate %s", new Object[] { Boolean.FALSE });
      if (ae.fJf.fIQ)
      {
        paramContext.xGx.uLE = ae.fJf.mVideoHeight;
        paramContext.xGx.uLF = ae.fJf.mVideoWidth;
        paramContext.xGx.uLD = ae.fJf.fIS;
      }
      paramContext.xGx.uLO = com.tencent.mm.compatible.deviceinfo.d.getNumberOfCameras();
      paramContext.xGx.duc = 0;
      this.xGB = ((ImageView)findViewById(2131303526));
      dFs();
      return;
      inflate(getContext(), 2131495448, this);
    }
  }
  
  private void dFs()
  {
    if (this.xGB.getVisibility() == 4) {
      return;
    }
    if (this.tPe != null) {
      this.tPe.cancel();
    }
    this.xGB.setVisibility(4);
  }
  
  public final void aZ(float paramFloat)
  {
    ac.d("MicroMsg.SightCameraView", "update progress %f", new Object[] { Float.valueOf(paramFloat) });
    if (this.xGK < 0) {
      this.xGK = getResources().getDisplayMetrics().widthPixels;
    }
    if (paramFloat < 0.0F)
    {
      localLayoutParams = this.xGB.getLayoutParams();
      localLayoutParams.width = this.xGK;
      this.xGB.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramFloat > 1.0F)
    {
      i = this.xGK / 2;
      localLayoutParams = this.xGB.getLayoutParams();
      localLayoutParams.width = (this.xGK - (i - 1) * 2);
      this.xGB.setLayoutParams(localLayoutParams);
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels * paramFloat / 2.0F);
    ViewGroup.LayoutParams localLayoutParams = this.xGB.getLayoutParams();
    localLayoutParams.width = (this.xGK - i * 2);
    this.xGB.setLayoutParams(localLayoutParams);
  }
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  protected abstract void bB(String paramString, boolean paramBoolean);
  
  protected final void cos()
  {
    ac.w("MicroMsg.SightCameraView", "cancel record");
    if (this.xGA == null) {
      throw new IllegalStateException("The mSightMedia must be set!");
    }
    az.agU().cOC().removeCallbacks(this.xGL);
    az.agU().az(this.xGM);
    this.xGJ.stopTimer();
    aZ(0.0F);
    dFs();
    setKeepScreenOn(false);
  }
  
  protected abstract void dFr();
  
  protected final void dFt()
  {
    this.nQt.ev(false);
  }
  
  public a.a getCurMediaStatus()
  {
    return this.xGA.dFa();
  }
  
  public int getDuration()
  {
    return this.xGA.getDuration();
  }
  
  protected abstract Surface getPreviewSurface();
  
  public String getRecordPath()
  {
    return this.xGA.getRecordPath();
  }
  
  protected abstract int getSurfaceHeight();
  
  protected abstract int getSurfaceWidth();
  
  public abstract boolean isPlaying();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    e locale;
    if ((paramMotionEvent.getAction() == 0) && (this.xGF) && (this.xGG))
    {
      ac.i("MicroMsg.SightCameraView", "check double click %dms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.xGD) });
      if (SystemClock.elapsedRealtime() - this.xGD >= 400L) {
        break label381;
      }
      this.xGz.xGy.removeMessages(4354);
      locale = this.xGz;
      if (locale.uKx) {
        break label125;
      }
      ac.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
    }
    for (;;)
    {
      this.xGD = SystemClock.elapsedRealtime();
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      com.tencent.mm.compatible.util.d.la(14);
      return true;
      try
      {
        label125:
        Camera.Parameters localParameters = locale.fFt.getParameters();
        if (localParameters == null) {
          continue;
        }
        ac.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[] { Boolean.valueOf(locale.gXp), Boolean.valueOf(localParameters.isZoomSupported()) });
        if (!localParameters.isZoomSupported()) {
          continue;
        }
        locale.xGy.removeMessages(4353);
        if (locale.gXp)
        {
          locale.xGy.gXq = false;
          locale.xGy.gXp = false;
          locale.xGy.gXo = (e.a.h(localParameters) * -1);
          locale.xGy.sendMessage(locale.xGy.obtainMessage(4353, locale.fFt));
          if (!locale.gXp) {
            bool = true;
          }
          locale.gXp = bool;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.SightCamera", "getParameters failed %s", new Object[] { localException.getMessage() });
          ac.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          localObject = null;
          continue;
          locale.xGy.gXq = false;
          locale.xGy.gXp = true;
          locale.xGy.gXo = e.a.h((Camera.Parameters)localObject);
          locale.xGy.sendMessage(locale.xGy.obtainMessage(4353, locale.fFt));
        }
      }
      label381:
      Object localObject = this.xGz;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = getSurfaceWidth();
      int j = getSurfaceHeight();
      if (!com.tencent.mm.compatible.util.d.la(14))
      {
        ((e)localObject).xGy.removeMessages(4354);
        ((e)localObject).xGy.fTg = f1;
        ((e)localObject).xGy.fTh = f2;
        ((e)localObject).xGy.gXs = i;
        ((e)localObject).xGy.gXt = j;
        ((e)localObject).xGy.sendMessageDelayed(((e)localObject).xGy.obtainMessage(4354, ((e)localObject).fFt), 400L);
      }
    }
  }
  
  protected final void requestAudioFocus()
  {
    this.nQt.a(this);
  }
  
  public abstract void setFixPreviewRate(float paramFloat);
  
  protected abstract void setIsMute(boolean paramBoolean);
  
  public void setPreviewRate(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.height = ((int)(localDisplayMetrics.widthPixels / paramFloat));
    ac.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height), Float.valueOf(paramFloat) });
    postInvalidate();
  }
  
  public void setRecordMaxDuring(int paramInt)
  {
    ac.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : ".concat(String.valueOf(paramInt)));
    this.xGH = paramInt;
  }
  
  public void setSightCameraUIIm(a parama)
  {
    this.xGI = parama;
  }
  
  public void setSightMedia(a parama)
  {
    this.xGA = parama;
    if ((this.xGA != null) && (this.xGz != null)) {
      this.xGz.mPreviewCallback = this.xGA.dFb();
    }
  }
  
  protected void setStopCallback(Runnable paramRunnable)
  {
    this.xGC = paramRunnable;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.hcL = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView
 * JD-Core Version:    0.7.0.1
 */