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
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sight.encode.a.a;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;

public abstract class SightCameraView
  extends FrameLayout
  implements d.a
{
  protected int fch = 320;
  private long iWt = 0L;
  private com.tencent.mm.model.d idF = new com.tencent.mm.model.d();
  private Animation nTC;
  protected e qWL;
  protected a qWM;
  protected ImageView qWN;
  protected Runnable qWO;
  protected long qWP = -1L;
  protected SightCameraView.b qWQ = SightCameraView.b.qXc;
  protected boolean qWR = false;
  protected boolean qWS = false;
  protected int qWT = 6500;
  protected SightCameraView.a qWU;
  private ap qWV = new ap(Looper.getMainLooper(), new SightCameraView.1(this), true);
  private int qWW = -1;
  private Runnable qWX = new SightCameraView.2(this);
  private Runnable qWY = new SightCameraView.3(this);
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (com.tencent.mm.plugin.sight.base.d.cmv()) {
      inflate(getContext(), 2130970744, this);
    }
    for (;;)
    {
      this.qWR = false;
      this.qWS = false;
      this.qWL = new e();
      paramContext = this.qWL;
      ab.i("MicroMsg.SightCamera", "init needRotate %s", new Object[] { Boolean.FALSE });
      if (ac.erw.erh)
      {
        paramContext.qWJ.oHZ = ac.erw.mVideoHeight;
        paramContext.qWJ.oIa = ac.erw.mVideoWidth;
        paramContext.qWJ.oHY = ac.erw.erj;
      }
      paramContext.qWJ.oIj = com.tencent.mm.compatible.e.d.getNumberOfCameras();
      paramContext.qWJ.rotate = 0;
      this.qWN = ((ImageView)findViewById(2131827767));
      cnt();
      return;
      inflate(getContext(), 2130970743, this);
    }
  }
  
  private void cnt()
  {
    if (this.qWN.getVisibility() == 4) {
      return;
    }
    if (this.nTC != null) {
      this.nTC.cancel();
    }
    this.qWN.setVisibility(4);
  }
  
  public final void aZ(float paramFloat)
  {
    ab.d("MicroMsg.SightCameraView", "update progress %f", new Object[] { Float.valueOf(paramFloat) });
    if (this.qWW < 0) {
      this.qWW = getResources().getDisplayMetrics().widthPixels;
    }
    if (paramFloat < 0.0F)
    {
      localLayoutParams = this.qWN.getLayoutParams();
      localLayoutParams.width = this.qWW;
      this.qWN.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramFloat > 1.0F)
    {
      i = this.qWW / 2;
      localLayoutParams = this.qWN.getLayoutParams();
      localLayoutParams.width = (this.qWW - (i - 1) * 2);
      this.qWN.setLayoutParams(localLayoutParams);
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels * paramFloat / 2.0F);
    ViewGroup.LayoutParams localLayoutParams = this.qWN.getLayoutParams();
    localLayoutParams.width = (this.qWW - i * 2);
    this.qWN.setLayoutParams(localLayoutParams);
  }
  
  protected abstract void bm(String paramString, boolean paramBoolean);
  
  protected final void bvq()
  {
    ab.w("MicroMsg.SightCameraView", "cancel record");
    if (this.qWM == null) {
      throw new IllegalStateException("The mSightMedia must be set!");
    }
    aw.RO().caB().removeCallbacks(this.qWX);
    aw.RO().ac(this.qWY);
    this.qWV.stopTimer();
    aZ(0.0F);
    cnt();
    setKeepScreenOn(false);
  }
  
  protected abstract void cns();
  
  protected final void cnu()
  {
    this.idF.a(this);
  }
  
  protected final void cnv()
  {
    this.idF.cJ(false);
  }
  
  public a.a getCurMediaStatus()
  {
    return this.qWM.cna();
  }
  
  public int getDuration()
  {
    return this.qWM.getDuration();
  }
  
  protected abstract Surface getPreviewSurface();
  
  public String getRecordPath()
  {
    return this.qWM.getRecordPath();
  }
  
  protected abstract int getSurfaceHeight();
  
  protected abstract int getSurfaceWidth();
  
  public abstract boolean isPlaying();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    e locale;
    if ((paramMotionEvent.getAction() == 0) && (this.qWR) && (this.qWS))
    {
      ab.i("MicroMsg.SightCameraView", "check double click %dms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.qWP) });
      if (SystemClock.elapsedRealtime() - this.qWP >= 400L) {
        break label381;
      }
      this.qWL.qWK.removeMessages(4354);
      locale = this.qWL;
      if (locale.oGT) {
        break label125;
      }
      ab.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
    }
    for (;;)
    {
      this.qWP = SystemClock.elapsedRealtime();
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      com.tencent.mm.compatible.util.d.fw(14);
      return true;
      try
      {
        label125:
        Camera.Parameters localParameters = locale.eoH.getParameters();
        if (localParameters == null) {
          continue;
        }
        ab.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[] { Boolean.valueOf(locale.eZZ), Boolean.valueOf(localParameters.isZoomSupported()) });
        if (!localParameters.isZoomSupported()) {
          continue;
        }
        locale.qWK.removeMessages(4353);
        if (locale.eZZ)
        {
          locale.qWK.faa = false;
          locale.qWK.eZZ = false;
          locale.qWK.eZY = (e.a.h(localParameters) * -1);
          locale.qWK.sendMessage(locale.qWK.obtainMessage(4353, locale.eoH));
          if (!locale.eZZ) {
            bool = true;
          }
          locale.eZZ = bool;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.SightCamera", "getParameters failed %s", new Object[] { localException.getMessage() });
          ab.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          localObject = null;
          continue;
          locale.qWK.faa = false;
          locale.qWK.eZZ = true;
          locale.qWK.eZY = e.a.h((Camera.Parameters)localObject);
          locale.qWK.sendMessage(locale.qWK.obtainMessage(4353, locale.eoH));
        }
      }
      label381:
      Object localObject = this.qWL;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = getSurfaceWidth();
      int j = getSurfaceHeight();
      if (!com.tencent.mm.compatible.util.d.fw(14))
      {
        ((e)localObject).qWK.removeMessages(4354);
        ((e)localObject).qWK.fac = f1;
        ((e)localObject).qWK.fad = f2;
        ((e)localObject).qWK.fae = i;
        ((e)localObject).qWK.faf = j;
        ((e)localObject).qWK.sendMessageDelayed(((e)localObject).qWK.obtainMessage(4354, ((e)localObject).eoH), 400L);
      }
    }
  }
  
  public abstract void setFixPreviewRate(float paramFloat);
  
  protected abstract void setIsMute(boolean paramBoolean);
  
  public void setPreviewRate(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.height = ((int)(localDisplayMetrics.widthPixels / paramFloat));
    ab.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height), Float.valueOf(paramFloat) });
    postInvalidate();
  }
  
  public void setRecordMaxDuring(int paramInt)
  {
    ab.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : ".concat(String.valueOf(paramInt)));
    this.qWT = paramInt;
  }
  
  public void setSightCameraUIIm(SightCameraView.a parama)
  {
    this.qWU = parama;
  }
  
  public void setSightMedia(a parama)
  {
    this.qWM = parama;
    if ((this.qWM != null) && (this.qWL != null)) {
      this.qWL.mPreviewCallback = this.qWM.cnb();
    }
  }
  
  protected void setStopCallback(Runnable paramRunnable)
  {
    this.qWO = paramRunnable;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.fch = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView
 * JD-Core Version:    0.7.0.1
 */