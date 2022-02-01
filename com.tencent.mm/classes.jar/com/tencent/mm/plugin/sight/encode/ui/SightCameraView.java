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
import com.tencent.mm.model.bg;
import com.tencent.mm.model.d.a;
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
  protected e Dql;
  protected a Dqm;
  protected ImageView Dqn;
  protected Runnable Dqo;
  protected long Dqp = -1L;
  protected SightCameraView.b Dqq = SightCameraView.b.DqC;
  protected boolean Dqr = false;
  protected boolean Dqs = false;
  protected int Dqt = 6500;
  protected a Dqu;
  private MTimerHandler Dqv = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(28780);
      float f = (float)SightCameraView.this.Dqm.eVY() / SightCameraView.this.Dqt;
      if ((Float.compare(f, 0.0F) <= 0) && (System.currentTimeMillis() - SightCameraView.a(SightCameraView.this) > 20000L))
      {
        Log.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[] { Long.valueOf(20000L) });
        SightCameraView.this.cTH();
        AppMethodBeat.o(28780);
        return false;
      }
      if ((Float.compare(f, 1.0F) > 0) && (SightCameraView.this.Dqm.eVZ() == a.a.DoU)) {
        if (!SightCameraView.this.Dqm.XB()) {
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
  private int Dqw = -1;
  private Runnable Dqx = new SightCameraView.2(this);
  private Runnable Dqy = new SightCameraView.3(this);
  protected int irF = 320;
  private long ofl = 0L;
  private com.tencent.mm.model.d pNk = new com.tencent.mm.model.d();
  private Animation ywd;
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (com.tencent.mm.plugin.sight.base.e.eVu()) {
      inflate(getContext(), 2131496322, this);
    }
    for (;;)
    {
      this.Dqr = false;
      this.Dqs = false;
      this.Dql = new e();
      paramContext = this.Dql;
      Log.i("MicroMsg.SightCamera", "init needRotate %s", new Object[] { Boolean.FALSE });
      if (ae.gKv.gKa)
      {
        paramContext.Dqi.ifO = ae.gKv.mVideoHeight;
        paramContext.Dqi.ifN = ae.gKv.mVideoWidth;
        paramContext.Dqi.zuR = ae.gKv.gKc;
      }
      paramContext.Dqi.zva = com.tencent.mm.compatible.deviceinfo.d.getNumberOfCameras();
      paramContext.Dqi.dYT = 0;
      this.Dqn = ((ImageView)findViewById(2131306293));
      eWr();
      return;
      inflate(getContext(), 2131496321, this);
    }
  }
  
  private void eWr()
  {
    if (this.Dqn.getVisibility() == 4) {
      return;
    }
    if (this.ywd != null) {
      this.ywd.cancel();
    }
    this.Dqn.setVisibility(4);
  }
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void bi(float paramFloat)
  {
    Log.d("MicroMsg.SightCameraView", "update progress %f", new Object[] { Float.valueOf(paramFloat) });
    if (this.Dqw < 0) {
      this.Dqw = getResources().getDisplayMetrics().widthPixels;
    }
    if (paramFloat < 0.0F)
    {
      localLayoutParams = this.Dqn.getLayoutParams();
      localLayoutParams.width = this.Dqw;
      this.Dqn.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramFloat > 1.0F)
    {
      i = this.Dqw / 2;
      localLayoutParams = this.Dqn.getLayoutParams();
      localLayoutParams.width = (this.Dqw - (i - 1) * 2);
      this.Dqn.setLayoutParams(localLayoutParams);
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels * paramFloat / 2.0F);
    ViewGroup.LayoutParams localLayoutParams = this.Dqn.getLayoutParams();
    localLayoutParams.width = (this.Dqw - i * 2);
    this.Dqn.setLayoutParams(localLayoutParams);
  }
  
  protected final void cTH()
  {
    Log.w("MicroMsg.SightCameraView", "cancel record");
    if (this.Dqm == null) {
      throw new IllegalStateException("The mSightMedia must be set!");
    }
    bg.aAk().getWorkerHandler().removeCallbacks(this.Dqx);
    bg.aAk().postToWorker(this.Dqy);
    this.Dqv.stopTimer();
    bi(0.0F);
    eWr();
    setKeepScreenOn(false);
  }
  
  protected abstract void ce(String paramString, boolean paramBoolean);
  
  protected abstract void eWq();
  
  protected final void eWs()
  {
    this.pNk.fp(false);
  }
  
  public a.a getCurMediaStatus()
  {
    return this.Dqm.eVZ();
  }
  
  public int getDuration()
  {
    return this.Dqm.getDuration();
  }
  
  protected abstract Surface getPreviewSurface();
  
  public String getRecordPath()
  {
    return this.Dqm.getRecordPath();
  }
  
  protected abstract int getSurfaceHeight();
  
  protected abstract int getSurfaceWidth();
  
  public abstract boolean isPlaying();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    e locale;
    if ((paramMotionEvent.getAction() == 0) && (this.Dqr) && (this.Dqs))
    {
      Log.i("MicroMsg.SightCameraView", "check double click %dms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.Dqp) });
      if (SystemClock.elapsedRealtime() - this.Dqp >= 400L) {
        break label381;
      }
      this.Dql.Dqk.removeMessages(4354);
      locale = this.Dql;
      if (locale.ztJ) {
        break label125;
      }
      Log.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
    }
    for (;;)
    {
      this.Dqp = SystemClock.elapsedRealtime();
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      com.tencent.mm.compatible.util.d.oE(14);
      return true;
      try
      {
        label125:
        Camera.Parameters localParameters = locale.gGr.getParameters();
        if (localParameters == null) {
          continue;
        }
        Log.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[] { Boolean.valueOf(locale.ztI), Boolean.valueOf(localParameters.isZoomSupported()) });
        if (!localParameters.isZoomSupported()) {
          continue;
        }
        locale.Dqk.removeMessages(4353);
        if (locale.ztI)
        {
          locale.Dqk.zul = false;
          locale.Dqk.ztI = false;
          locale.Dqk.zuk = (e.a.e(localParameters) * -1);
          locale.Dqk.sendMessage(locale.Dqk.obtainMessage(4353, locale.gGr));
          if (!locale.ztI) {
            bool = true;
          }
          locale.ztI = bool;
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
          locale.Dqk.zul = false;
          locale.Dqk.ztI = true;
          locale.Dqk.zuk = e.a.e((Camera.Parameters)localObject);
          locale.Dqk.sendMessage(locale.Dqk.obtainMessage(4353, locale.gGr));
        }
      }
      label381:
      Object localObject = this.Dql;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = getSurfaceWidth();
      int j = getSurfaceHeight();
      if (!com.tencent.mm.compatible.util.d.oE(14))
      {
        ((e)localObject).Dqk.removeMessages(4354);
        ((e)localObject).Dqk.gZZ = f1;
        ((e)localObject).Dqk.haa = f2;
        ((e)localObject).Dqk.imO = i;
        ((e)localObject).Dqk.imP = j;
        ((e)localObject).Dqk.sendMessageDelayed(((e)localObject).Dqk.obtainMessage(4354, ((e)localObject).gGr), 400L);
      }
    }
  }
  
  protected final void requestAudioFocus()
  {
    this.pNk.a(this);
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
    this.Dqt = paramInt;
  }
  
  public void setSightCameraUIIm(a parama)
  {
    this.Dqu = parama;
  }
  
  public void setSightMedia(a parama)
  {
    this.Dqm = parama;
    if ((this.Dqm != null) && (this.Dql != null)) {
      this.Dql.Dqj = this.Dqm.eWa();
    }
  }
  
  protected void setStopCallback(Runnable paramRunnable)
  {
    this.Dqo = paramRunnable;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.irF = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView
 * JD-Core Version:    0.7.0.1
 */