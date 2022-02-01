package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView
  extends FrameLayout
{
  public d MRb;
  protected int NKw = -1;
  protected long NKx;
  protected WeakReference<c> NVe;
  private Point OgA = new Point();
  private Point OgB;
  Runnable OgC = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(115757);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184093);
          BaseSmallView.this.eYC();
          AppMethodBeat.o(184093);
        }
      });
      AppMethodBeat.o(115757);
    }
  };
  private Point Ogy = new Point();
  private Point Ogz = new Point();
  protected MMHandler cyl;
  private WindowManager mWindowManager;
  private PointF rmS = new PointF();
  public SurfaceTexture surfaceTexture;
  @Deprecated
  private CaptureView tRv;
  
  public BaseSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.cyl = new MMHandler();
    this.OgB = new Point(this.mWindowManager.getDefaultDisplay().getWidth(), this.mWindowManager.getDefaultDisplay().getHeight());
  }
  
  public void Be(boolean paramBoolean)
  {
    h.ZvG.bDh("resumeIcon");
    h.ZvG.a(this.OgC, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  @Deprecated
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void aQM(String paramString) {}
  
  public void aQN(String paramString) {}
  
  @Deprecated
  protected final void c(CaptureView paramCaptureView)
  {
    Log.printDebugStack("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
    if (this.tRv != null)
    {
      removeView(this.tRv);
      this.tRv = null;
    }
    if (paramCaptureView != null)
    {
      this.tRv = paramCaptureView;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(1, 1);
      localLayoutParams.leftMargin = 20;
      localLayoutParams.topMargin = 20;
      addView(paramCaptureView, localLayoutParams);
      paramCaptureView.setVisibility(0);
      Log.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
    }
  }
  
  public void eXH()
  {
    h.ZvG.bDh("resumeIcon");
    h.ZvG.a(this.OgC, 2000L, "resumeIcon");
  }
  
  public boolean eYB()
  {
    h.ZvG.bDh("resumeIcon");
    return true;
  }
  
  public void eYC() {}
  
  public void eYD() {}
  
  @Deprecated
  public void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void gBJ() {}
  
  @Deprecated
  public void gBT() {}
  
  public void gEJ() {}
  
  @Deprecated
  public OpenGlRender getBeautyData()
  {
    return null;
  }
  
  @Deprecated
  public OpenGlRender getSpatioTemporalFilterData()
  {
    return null;
  }
  
  @Deprecated
  public void kN(int paramInt1, int paramInt2) {}
  
  @Deprecated
  protected void onAnimationEnd() {}
  
  @Deprecated
  public void releaseSurfaceTexture() {}
  
  @Deprecated
  public void requestRender() {}
  
  @Deprecated
  public void setCaptureView(CaptureView paramCaptureView) {}
  
  public void setConnectSec(long paramLong)
  {
    this.NKx = paramLong;
  }
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  @Deprecated
  public void setSpatiotemporalDenosing(int paramInt) {}
  
  public void setStatus(int paramInt) {}
  
  public void setVoicePlayDevice(int paramInt)
  {
    h.ZvG.bDh("resumeIcon");
    h.ZvG.a(this.OgC, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public void setVoipUIListener(c paramc)
  {
    Log.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
    this.NVe = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    this.mWindowManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.BaseSmallView
 * JD-Core Version:    0.7.0.1
 */