package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.Camera;
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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.v;
import com.tencent.mm.model.au;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sight.encode.a.a;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public abstract class SightCameraView
  extends FrameLayout
  implements d.a
{
  private com.tencent.mm.model.d gEB = new com.tencent.mm.model.d();
  private long hkx = 0L;
  private Animation lwn;
  protected int mjv = 320;
  protected ImageView oiA;
  protected Runnable oiB;
  protected long oiC = -1L;
  protected SightCameraView.b oiD = SightCameraView.b.oiP;
  protected boolean oiE = false;
  protected boolean oiF = false;
  protected int oiG = 6500;
  protected a oiH;
  private am oiI = new am(Looper.getMainLooper(), new SightCameraView.1(this), true);
  private int oiJ = -1;
  private Runnable oiK = new SightCameraView.2(this);
  private Runnable oiL = new SightCameraView.3(this);
  protected e oiy;
  protected a oiz;
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (com.tencent.mm.plugin.sight.base.d.bAV()) {
      inflate(getContext(), R.i.sight_camera_view_merge_v14, this);
    }
    for (;;)
    {
      this.oiE = false;
      this.oiF = false;
      this.oiy = new e();
      paramContext = this.oiy;
      y.i("MicroMsg.SightCamera", "init needRotate %s", new Object[] { Boolean.valueOf(false) });
      if (q.dyf.dyH)
      {
        paramContext.oiw.mhT = q.dyf.mVideoHeight;
        paramContext.oiw.mhU = q.dyf.mVideoWidth;
        paramContext.oiw.mhS = q.dyf.dyJ;
      }
      paramContext.oiw.jlS = com.tencent.mm.compatible.e.d.getNumberOfCameras();
      paramContext.oiw.rotate = 0;
      this.oiA = ((ImageView)findViewById(R.h.progress_iv));
      bBS();
      return;
      inflate(getContext(), R.i.sight_camera_view_merge, this);
    }
  }
  
  private void bBS()
  {
    if (this.oiA.getVisibility() == 4) {
      return;
    }
    if (this.lwn != null) {
      this.lwn.cancel();
    }
    this.oiA.setVisibility(4);
  }
  
  public final void aB(float paramFloat)
  {
    y.d("MicroMsg.SightCameraView", "update progress %f", new Object[] { Float.valueOf(paramFloat) });
    if (this.oiJ < 0) {
      this.oiJ = getResources().getDisplayMetrics().widthPixels;
    }
    if (paramFloat < 0.0F)
    {
      localLayoutParams = this.oiA.getLayoutParams();
      localLayoutParams.width = this.oiJ;
      this.oiA.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramFloat > 1.0F)
    {
      i = this.oiJ / 2;
      localLayoutParams = this.oiA.getLayoutParams();
      localLayoutParams.width = (this.oiJ - (i - 1) * 2);
      this.oiA.setLayoutParams(localLayoutParams);
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels * paramFloat / 2.0F);
    ViewGroup.LayoutParams localLayoutParams = this.oiA.getLayoutParams();
    localLayoutParams.width = (this.oiJ - i * 2);
    this.oiA.setLayoutParams(localLayoutParams);
  }
  
  protected final void aPl()
  {
    y.w("MicroMsg.SightCameraView", "cancel record");
    if (this.oiz == null) {
      throw new IllegalStateException("The mSightMedia must be set!");
    }
    au.DS().crf().removeCallbacks(this.oiK);
    au.DS().O(this.oiL);
    this.oiI.stopTimer();
    aB(0.0F);
    bBS();
    setKeepScreenOn(false);
  }
  
  protected abstract void aX(String paramString, boolean paramBoolean);
  
  protected abstract void bBR();
  
  protected final void bBT()
  {
    this.gEB.a(this);
  }
  
  protected final void bBU()
  {
    this.gEB.bH(false);
  }
  
  public a.a getCurMediaStatus()
  {
    return this.oiz.bBB();
  }
  
  public int getDuration()
  {
    return this.oiz.getDuration();
  }
  
  protected abstract Surface getPreviewSurface();
  
  public String getRecordPath()
  {
    return this.oiz.getRecordPath();
  }
  
  protected abstract int getSurfaceHeight();
  
  protected abstract int getSurfaceWidth();
  
  public abstract boolean isPlaying();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    e locale;
    if ((paramMotionEvent.getAction() == 0) && (this.oiE) && (this.oiF))
    {
      y.i("MicroMsg.SightCameraView", "check double click %dms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.oiC) });
      if (SystemClock.elapsedRealtime() - this.oiC >= 400L) {
        break label381;
      }
      this.oiy.oix.removeMessages(4354);
      locale = this.oiy;
      if (locale.mgy) {
        break label125;
      }
      y.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
    }
    for (;;)
    {
      this.oiC = SystemClock.elapsedRealtime();
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      com.tencent.mm.compatible.util.d.gG(14);
      return true;
      try
      {
        label125:
        Camera.Parameters localParameters = locale.dwJ.getParameters();
        if (localParameters == null) {
          continue;
        }
        y.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[] { Boolean.valueOf(locale.mgx), Boolean.valueOf(localParameters.isZoomSupported()) });
        if (!localParameters.isZoomSupported()) {
          continue;
        }
        locale.oix.removeMessages(4353);
        if (locale.mgx)
        {
          locale.oix.mhl = false;
          locale.oix.mgx = false;
          locale.oix.mhk = (e.a.e(localParameters) * -1);
          locale.oix.sendMessage(locale.oix.obtainMessage(4353, locale.dwJ));
          if (!locale.mgx) {
            bool = true;
          }
          locale.mgx = bool;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.SightCamera", "getParameters failed %s", new Object[] { localException.getMessage() });
          y.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          localObject = null;
          continue;
          locale.oix.mhl = false;
          locale.oix.mgx = true;
          locale.oix.mhk = e.a.e((Camera.Parameters)localObject);
          locale.oix.sendMessage(locale.oix.obtainMessage(4353, locale.dwJ));
        }
      }
      label381:
      Object localObject = this.oiy;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = getSurfaceWidth();
      int j = getSurfaceHeight();
      if (!com.tencent.mm.compatible.util.d.gG(14))
      {
        ((e)localObject).oix.removeMessages(4354);
        ((e)localObject).oix.mhn = f1;
        ((e)localObject).oix.lvi = f2;
        ((e)localObject).oix.mho = i;
        ((e)localObject).oix.mhp = j;
        ((e)localObject).oix.sendMessageDelayed(((e)localObject).oix.obtainMessage(4354, ((e)localObject).dwJ), 400L);
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
    y.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height), Float.valueOf(paramFloat) });
    postInvalidate();
  }
  
  public void setRecordMaxDuring(int paramInt)
  {
    y.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : " + paramInt);
    this.oiG = paramInt;
  }
  
  public void setSightCameraUIIm(a parama)
  {
    this.oiH = parama;
  }
  
  public void setSightMedia(a parama)
  {
    this.oiz = parama;
    if ((this.oiz != null) && (this.oiy != null)) {
      this.oiy.mPreviewCallback = this.oiz.bBC();
    }
  }
  
  protected void setStopCallback(Runnable paramRunnable)
  {
    this.oiB = paramRunnable;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.mjv = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView
 * JD-Core Version:    0.7.0.1
 */