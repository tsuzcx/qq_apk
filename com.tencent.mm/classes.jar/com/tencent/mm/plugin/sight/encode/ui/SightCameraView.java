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
  private Animation DWh;
  protected long DxT = -1L;
  protected e JvQ;
  protected a JvR;
  protected ImageView JvS;
  protected Runnable JvT;
  protected SightCameraView.b JvU = SightCameraView.b.Jwg;
  protected boolean JvV = false;
  protected boolean JvW = false;
  protected int JvX = 6500;
  protected a JvY;
  private MTimerHandler JvZ = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(28780);
      float f = (float)SightCameraView.this.JvR.fJb() / SightCameraView.this.JvX;
      if ((Float.compare(f, 0.0F) <= 0) && (System.currentTimeMillis() - SightCameraView.a(SightCameraView.this) > 20000L))
      {
        Log.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[] { Long.valueOf(20000L) });
        SightCameraView.this.diM();
        AppMethodBeat.o(28780);
        return false;
      }
      if ((Float.compare(f, 1.0F) > 0) && (SightCameraView.this.JvR.fJc() == a.a.Juz)) {
        if (!SightCameraView.this.JvR.ace()) {
          SightCameraView.b(SightCameraView.this);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28780);
        return true;
        SightCameraView.this.bi(f);
      }
    }
  }, true);
  private int Jwa = -1;
  private Runnable Jwb = new SightCameraView.2(this);
  private Runnable Jwc = new SightCameraView.3(this);
  protected int lgJ = 320;
  private long rgW = 0L;
  private com.tencent.mm.model.d sUi = com.tencent.mm.model.d.bcs();
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (f.fIx()) {
      inflate(getContext(), R.i.elm, this);
    }
    for (;;)
    {
      this.JvV = false;
      this.JvW = false;
      this.JvQ = new e();
      paramContext = this.JvQ;
      Log.i("MicroMsg.SightCamera", "init needRotate %s", new Object[] { Boolean.FALSE });
      if (af.juJ.juo)
      {
        paramContext.JvN.kUC = af.juJ.mVideoHeight;
        paramContext.JvN.kUB = af.juJ.mVideoWidth;
        paramContext.JvN.Faq = af.juJ.juq;
      }
      paramContext.JvN.Faz = com.tencent.mm.compatible.deviceinfo.d.auj();
      paramContext.JvN.fSM = 0;
      this.JvS = ((ImageView)findViewById(R.h.dRC));
      fJu();
      return;
      inflate(getContext(), R.i.ell, this);
    }
  }
  
  private void fJu()
  {
    if (this.JvS.getVisibility() == 4) {
      return;
    }
    if (this.DWh != null) {
      this.DWh.cancel();
    }
    this.JvS.setVisibility(4);
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void bi(float paramFloat)
  {
    Log.d("MicroMsg.SightCameraView", "update progress %f", new Object[] { Float.valueOf(paramFloat) });
    if (this.Jwa < 0) {
      this.Jwa = getResources().getDisplayMetrics().widthPixels;
    }
    if (paramFloat < 0.0F)
    {
      localLayoutParams = this.JvS.getLayoutParams();
      localLayoutParams.width = this.Jwa;
      this.JvS.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramFloat > 1.0F)
    {
      i = this.Jwa / 2;
      localLayoutParams = this.JvS.getLayoutParams();
      localLayoutParams.width = (this.Jwa - (i - 1) * 2);
      this.JvS.setLayoutParams(localLayoutParams);
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels * paramFloat / 2.0F);
    ViewGroup.LayoutParams localLayoutParams = this.JvS.getLayoutParams();
    localLayoutParams.width = (this.Jwa - i * 2);
    this.JvS.setLayoutParams(localLayoutParams);
  }
  
  protected abstract void cn(String paramString, boolean paramBoolean);
  
  protected final void diM()
  {
    Log.w("MicroMsg.SightCameraView", "cancel record");
    if (this.JvR == null) {
      throw new IllegalStateException("The mSightMedia must be set!");
    }
    bh.aHJ().getWorkerHandler().removeCallbacks(this.Jwb);
    bh.aHJ().postToWorker(this.Jwc);
    this.JvZ.stopTimer();
    bi(0.0F);
    fJu();
    setKeepScreenOn(false);
  }
  
  protected abstract void fJt();
  
  protected final void fJv()
  {
    this.sUi.fZ(false);
  }
  
  public a.a getCurMediaStatus()
  {
    return this.JvR.fJc();
  }
  
  public int getDuration()
  {
    return this.JvR.getDuration();
  }
  
  protected abstract Surface getPreviewSurface();
  
  public String getRecordPath()
  {
    return this.JvR.getRecordPath();
  }
  
  protected abstract int getSurfaceHeight();
  
  protected abstract int getSurfaceWidth();
  
  public abstract boolean isPlaying();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    e locale;
    if ((paramMotionEvent.getAction() == 0) && (this.JvV) && (this.JvW))
    {
      Log.i("MicroMsg.SightCameraView", "check double click %dms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.DxT) });
      if (SystemClock.elapsedRealtime() - this.DxT >= 400L) {
        break label381;
      }
      this.JvQ.JvP.removeMessages(4354);
      locale = this.JvQ;
      if (locale.EZk) {
        break label125;
      }
      Log.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
    }
    for (;;)
    {
      this.DxT = SystemClock.elapsedRealtime();
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      com.tencent.mm.compatible.util.d.qW(14);
      return true;
      try
      {
        label125:
        Camera.Parameters localParameters = locale.jqD.avd();
        if (localParameters == null) {
          continue;
        }
        Log.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[] { Boolean.valueOf(locale.EZj), Boolean.valueOf(localParameters.isZoomSupported()) });
        if (!localParameters.isZoomSupported()) {
          continue;
        }
        locale.JvP.removeMessages(4353);
        if (locale.EZj)
        {
          locale.JvP.EZM = false;
          locale.JvP.EZj = false;
          locale.JvP.EZL = (e.a.h(localParameters) * -1);
          locale.JvP.sendMessage(locale.JvP.obtainMessage(4353, locale.jqD));
          if (!locale.EZj) {
            bool = true;
          }
          locale.EZj = bool;
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
          locale.JvP.EZM = false;
          locale.JvP.EZj = true;
          locale.JvP.EZL = e.a.h((Camera.Parameters)localObject);
          locale.JvP.sendMessage(locale.JvP.obtainMessage(4353, locale.jqD));
        }
      }
      label381:
      Object localObject = this.JvQ;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = getSurfaceWidth();
      int j = getSurfaceHeight();
      if (!com.tencent.mm.compatible.util.d.qW(14))
      {
        ((e)localObject).JvP.removeMessages(4354);
        ((e)localObject).JvP.jLa = f1;
        ((e)localObject).JvP.jLb = f2;
        ((e)localObject).JvP.lbP = i;
        ((e)localObject).JvP.lbQ = j;
        ((e)localObject).JvP.sendMessageDelayed(((e)localObject).JvP.obtainMessage(4354, ((e)localObject).jqD), 400L);
      }
    }
  }
  
  protected final void requestAudioFocus()
  {
    this.sUi.a(this);
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
    this.JvX = paramInt;
  }
  
  public void setSightCameraUIIm(a parama)
  {
    this.JvY = parama;
  }
  
  public void setSightMedia(a parama)
  {
    this.JvR = parama;
    if ((this.JvR != null) && (this.JvQ != null)) {
      this.JvQ.JvO = this.JvR.fJd();
    }
  }
  
  protected void setStopCallback(Runnable paramRunnable)
  {
    this.JvT = paramRunnable;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.lgJ = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView
 * JD-Core Version:    0.7.0.1
 */