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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public abstract class SightCameraView
  extends FrameLayout
  implements d.a
{
  protected int gCn = 320;
  private long lKF = 0L;
  private com.tencent.mm.model.d nnt = new com.tencent.mm.model.d();
  private Animation sHx;
  protected e wvj;
  protected a wvk;
  protected ImageView wvl;
  protected Runnable wvm;
  protected long wvn = -1L;
  protected SightCameraView.b wvo = SightCameraView.b.wvA;
  protected boolean wvp = false;
  protected boolean wvq = false;
  protected int wvr = 6500;
  protected a wvs;
  private av wvt = new av(Looper.getMainLooper(), new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(28780);
      float f = (float)SightCameraView.this.wvk.dqQ() / SightCameraView.this.wvr;
      if ((Float.compare(f, 0.0F) <= 0) && (System.currentTimeMillis() - SightCameraView.a(SightCameraView.this) > 20000L))
      {
        ad.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[] { Long.valueOf(20000L) });
        SightCameraView.this.cgL();
        AppMethodBeat.o(28780);
        return false;
      }
      if ((Float.compare(f, 1.0F) > 0) && (SightCameraView.this.wvk.dqR() == a.a.wtU)) {
        if (!SightCameraView.this.wvk.LN()) {
          SightCameraView.b(SightCameraView.this);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28780);
        return true;
        SightCameraView.this.aT(f);
      }
    }
  }, true);
  private int wvu = -1;
  private Runnable wvv = new SightCameraView.2(this);
  private Runnable wvw = new SightCameraView.3(this);
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (com.tencent.mm.plugin.sight.base.e.dqm()) {
      inflate(getContext(), 2131495449, this);
    }
    for (;;)
    {
      this.wvp = false;
      this.wvq = false;
      this.wvj = new e();
      paramContext = this.wvj;
      ad.i("MicroMsg.SightCamera", "init needRotate %s", new Object[] { Boolean.FALSE });
      if (ae.fFy.fFj)
      {
        paramContext.wvh.tDh = ae.fFy.mVideoHeight;
        paramContext.wvh.tDi = ae.fFy.mVideoWidth;
        paramContext.wvh.tDg = ae.fFy.fFl;
      }
      paramContext.wvh.tDr = com.tencent.mm.compatible.deviceinfo.d.getNumberOfCameras();
      paramContext.wvh.dwp = 0;
      this.wvl = ((ImageView)findViewById(2131303526));
      drj();
      return;
      inflate(getContext(), 2131495448, this);
    }
  }
  
  private void drj()
  {
    if (this.wvl.getVisibility() == 4) {
      return;
    }
    if (this.sHx != null) {
      this.sHx.cancel();
    }
    this.wvl.setVisibility(4);
  }
  
  public final void aT(float paramFloat)
  {
    ad.d("MicroMsg.SightCameraView", "update progress %f", new Object[] { Float.valueOf(paramFloat) });
    if (this.wvu < 0) {
      this.wvu = getResources().getDisplayMetrics().widthPixels;
    }
    if (paramFloat < 0.0F)
    {
      localLayoutParams = this.wvl.getLayoutParams();
      localLayoutParams.width = this.wvu;
      this.wvl.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramFloat > 1.0F)
    {
      i = this.wvu / 2;
      localLayoutParams = this.wvl.getLayoutParams();
      localLayoutParams.width = (this.wvu - (i - 1) * 2);
      this.wvl.setLayoutParams(localLayoutParams);
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels * paramFloat / 2.0F);
    ViewGroup.LayoutParams localLayoutParams = this.wvl.getLayoutParams();
    localLayoutParams.width = (this.wvu - i * 2);
    this.wvl.setLayoutParams(localLayoutParams);
  }
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  protected abstract void bu(String paramString, boolean paramBoolean);
  
  protected final void cgL()
  {
    ad.w("MicroMsg.SightCameraView", "cancel record");
    if (this.wvk == null) {
      throw new IllegalStateException("The mSightMedia must be set!");
    }
    az.afE().cBt().removeCallbacks(this.wvv);
    az.afE().ax(this.wvw);
    this.wvt.stopTimer();
    aT(0.0F);
    drj();
    setKeepScreenOn(false);
  }
  
  protected abstract void dri();
  
  protected final void drk()
  {
    this.nnt.ea(false);
  }
  
  public a.a getCurMediaStatus()
  {
    return this.wvk.dqR();
  }
  
  public int getDuration()
  {
    return this.wvk.getDuration();
  }
  
  protected abstract Surface getPreviewSurface();
  
  public String getRecordPath()
  {
    return this.wvk.getRecordPath();
  }
  
  protected abstract int getSurfaceHeight();
  
  protected abstract int getSurfaceWidth();
  
  public abstract boolean isPlaying();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    e locale;
    if ((paramMotionEvent.getAction() == 0) && (this.wvp) && (this.wvq))
    {
      ad.i("MicroMsg.SightCameraView", "check double click %dms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.wvn) });
      if (SystemClock.elapsedRealtime() - this.wvn >= 400L) {
        break label381;
      }
      this.wvj.wvi.removeMessages(4354);
      locale = this.wvj;
      if (locale.tCa) {
        break label125;
      }
      ad.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
    }
    for (;;)
    {
      this.wvn = SystemClock.elapsedRealtime();
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      com.tencent.mm.compatible.util.d.lg(14);
      return true;
      try
      {
        label125:
        Camera.Parameters localParameters = locale.fBM.getParameters();
        if (localParameters == null) {
          continue;
        }
        ad.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[] { Boolean.valueOf(locale.gwS), Boolean.valueOf(localParameters.isZoomSupported()) });
        if (!localParameters.isZoomSupported()) {
          continue;
        }
        locale.wvi.removeMessages(4353);
        if (locale.gwS)
        {
          locale.wvi.gwT = false;
          locale.wvi.gwS = false;
          locale.wvi.gwR = (e.a.h(localParameters) * -1);
          locale.wvi.sendMessage(locale.wvi.obtainMessage(4353, locale.fBM));
          if (!locale.gwS) {
            bool = true;
          }
          locale.gwS = bool;
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
          locale.wvi.gwT = false;
          locale.wvi.gwS = true;
          locale.wvi.gwR = e.a.h((Camera.Parameters)localObject);
          locale.wvi.sendMessage(locale.wvi.obtainMessage(4353, locale.fBM));
        }
      }
      label381:
      Object localObject = this.wvj;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = getSurfaceWidth();
      int j = getSurfaceHeight();
      if (!com.tencent.mm.compatible.util.d.lg(14))
      {
        ((e)localObject).wvi.removeMessages(4354);
        ((e)localObject).wvi.fPl = f1;
        ((e)localObject).wvi.fPm = f2;
        ((e)localObject).wvi.gwV = i;
        ((e)localObject).wvi.gwW = j;
        ((e)localObject).wvi.sendMessageDelayed(((e)localObject).wvi.obtainMessage(4354, ((e)localObject).fBM), 400L);
      }
    }
  }
  
  protected final void requestAudioFocus()
  {
    this.nnt.a(this);
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
    this.wvr = paramInt;
  }
  
  public void setSightCameraUIIm(a parama)
  {
    this.wvs = parama;
  }
  
  public void setSightMedia(a parama)
  {
    this.wvk = parama;
    if ((this.wvk != null) && (this.wvj != null)) {
      this.wvj.mPreviewCallback = this.wvk.dqS();
    }
  }
  
  protected void setStopCallback(Runnable paramRunnable)
  {
    this.wvm = paramRunnable;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.gCn = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView
 * JD-Core Version:    0.7.0.1
 */