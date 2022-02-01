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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.sight.encode.a.a;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public abstract class SightCameraView
  extends FrameLayout
  implements d.a
{
  private Animation JNq;
  protected long JqZ = -1L;
  private Runnable PJA = new SightCameraView.3(this);
  protected e PJo;
  protected a PJp;
  protected ImageView PJq;
  protected Runnable PJr;
  protected SightCameraView.b PJs = SightCameraView.b.PJE;
  protected boolean PJt = false;
  protected boolean PJu = false;
  protected int PJv = 6500;
  protected a PJw;
  private MTimerHandler PJx = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(28780);
      float f = (float)SightCameraView.this.PJp.gYU() / SightCameraView.this.PJv;
      if ((Float.compare(f, 0.0F) <= 0) && (System.currentTimeMillis() - SightCameraView.a(SightCameraView.this) > 20000L))
      {
        Log.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[] { Long.valueOf(20000L) });
        SightCameraView.this.dPx();
        AppMethodBeat.o(28780);
        return false;
      }
      if ((Float.compare(f, 1.0F) > 0) && (SightCameraView.this.PJp.gYV() == a.a.PHX)) {
        if (!SightCameraView.this.PJp.aEd()) {
          SightCameraView.b(SightCameraView.this);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28780);
        return true;
        SightCameraView.this.cn(f);
      }
    }
  }, true);
  private int PJy = -1;
  private Runnable PJz = new SightCameraView.2(this);
  protected int nLt = 320;
  private long uoS = 0L;
  private com.tencent.mm.model.d vZw = new com.tencent.mm.model.d();
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (f.gYq()) {
      inflate(getContext(), R.i.gor, this);
    }
    for (;;)
    {
      this.PJt = false;
      this.PJu = false;
      this.PJo = new e();
      paramContext = this.PJo;
      Log.i("MicroMsg.SightCamera", "init needRotate %s", new Object[] { Boolean.FALSE });
      if (af.lYa.lXF)
      {
        paramContext.PJl.nAh = af.lYa.mVideoHeight;
        paramContext.PJl.nAg = af.lYa.mVideoWidth;
        paramContext.PJl.KWa = af.lYa.lXH;
      }
      paramContext.PJl.nvv = com.tencent.mm.compatible.deviceinfo.d.aOG();
      paramContext.PJl.hYK = 0;
      this.PJq = ((ImageView)findViewById(R.h.fTE));
      gZo();
      return;
      inflate(getContext(), R.i.goq, this);
    }
  }
  
  private void gZo()
  {
    if (this.PJq.getVisibility() == 4) {
      return;
    }
    if (this.JNq != null) {
      this.JNq.cancel();
    }
    this.PJq.setVisibility(4);
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  protected final void bUf()
  {
    this.vZw.a(this);
  }
  
  protected abstract void cN(String paramString, boolean paramBoolean);
  
  public final void cn(float paramFloat)
  {
    Log.d("MicroMsg.SightCameraView", "update progress %f", new Object[] { Float.valueOf(paramFloat) });
    if (this.PJy < 0) {
      this.PJy = getResources().getDisplayMetrics().widthPixels;
    }
    if (paramFloat < 0.0F)
    {
      localLayoutParams = this.PJq.getLayoutParams();
      localLayoutParams.width = this.PJy;
      this.PJq.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramFloat > 1.0F)
    {
      i = this.PJy / 2;
      localLayoutParams = this.PJq.getLayoutParams();
      localLayoutParams.width = (this.PJy - (i - 1) * 2);
      this.PJq.setLayoutParams(localLayoutParams);
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels * paramFloat / 2.0F);
    ViewGroup.LayoutParams localLayoutParams = this.PJq.getLayoutParams();
    localLayoutParams.width = (this.PJy - i * 2);
    this.PJq.setLayoutParams(localLayoutParams);
  }
  
  protected final void dPx()
  {
    Log.w("MicroMsg.SightCameraView", "cancel record");
    if (this.PJp == null) {
      throw new IllegalStateException("The mSightMedia must be set!");
    }
    bh.baH().getWorkerHandler().removeCallbacks(this.PJz);
    bh.baH().postToWorker(this.PJA);
    this.PJx.stopTimer();
    cn(0.0F);
    gZo();
    setKeepScreenOn(false);
  }
  
  protected abstract void gZn();
  
  protected final void gZp()
  {
    this.vZw.gR(false);
  }
  
  public a.a getCurMediaStatus()
  {
    return this.PJp.gYV();
  }
  
  public int getDuration()
  {
    return this.PJp.getDuration();
  }
  
  protected abstract Surface getPreviewSurface();
  
  public String getRecordPath()
  {
    return this.PJp.getRecordPath();
  }
  
  protected abstract int getSurfaceHeight();
  
  protected abstract int getSurfaceWidth();
  
  public abstract boolean isPlaying();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    e locale;
    if ((paramMotionEvent.getAction() == 0) && (this.PJt) && (this.PJu))
    {
      Log.i("MicroMsg.SightCameraView", "check double click %dms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.JqZ) });
      if (SystemClock.elapsedRealtime() - this.JqZ >= 400L) {
        break label381;
      }
      this.PJo.PJn.removeMessages(4354);
      locale = this.PJo;
      if (locale.KUW) {
        break label125;
      }
      Log.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
    }
    for (;;)
    {
      this.JqZ = SystemClock.elapsedRealtime();
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      com.tencent.mm.compatible.util.d.rc(14);
      return true;
      try
      {
        label125:
        Camera.Parameters localParameters = locale.lTN.aPy();
        if (localParameters == null) {
          continue;
        }
        Log.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[] { Boolean.valueOf(locale.KUV), Boolean.valueOf(localParameters.isZoomSupported()) });
        if (!localParameters.isZoomSupported()) {
          continue;
        }
        locale.PJn.removeMessages(4353);
        if (locale.KUV)
        {
          locale.PJn.KVy = false;
          locale.PJn.KUV = false;
          locale.PJn.KVx = (e.a.j(localParameters) * -1);
          locale.PJn.sendMessage(locale.PJn.obtainMessage(4353, locale.lTN));
          if (!locale.KUV) {
            bool = true;
          }
          locale.KUV = bool;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SightCamera", "getParameters failed %s", new Object[] { localException.getMessage() });
          Log.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          localObject = null;
          continue;
          locale.PJn.KVy = false;
          locale.PJn.KUV = true;
          locale.PJn.KVx = e.a.j((Camera.Parameters)localObject);
          locale.PJn.sendMessage(locale.PJn.obtainMessage(4353, locale.lTN));
        }
      }
      label381:
      Object localObject = this.PJo;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = getSurfaceWidth();
      int j = getSurfaceHeight();
      if (!com.tencent.mm.compatible.util.d.rc(14))
      {
        ((e)localObject).PJn.removeMessages(4354);
        ((e)localObject).PJn.mkm = f1;
        ((e)localObject).PJn.mkn = f2;
        ((e)localObject).PJn.nGM = i;
        ((e)localObject).PJn.nGN = j;
        ((e)localObject).PJn.sendMessageDelayed(((e)localObject).PJn.obtainMessage(4354, ((e)localObject).lTN), 400L);
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
    Log.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height), Float.valueOf(paramFloat) });
    postInvalidate();
  }
  
  public void setRecordMaxDuring(int paramInt)
  {
    Log.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : ".concat(String.valueOf(paramInt)));
    this.PJv = paramInt;
  }
  
  public void setSightCameraUIIm(a parama)
  {
    this.PJw = parama;
  }
  
  public void setSightMedia(a parama)
  {
    this.PJp = parama;
    if ((this.PJp != null) && (this.PJo != null)) {
      this.PJo.PJm = this.PJp.gYW();
    }
  }
  
  protected void setStopCallback(Runnable paramRunnable)
  {
    this.PJr = paramRunnable;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.nLt = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView
 * JD-Core Version:    0.7.0.1
 */