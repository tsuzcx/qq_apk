package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.f.h;
import com.tencent.f.i;
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
  protected int GUk = -1;
  protected long GUl;
  public d GgP;
  protected WeakReference<c> Hen;
  private Point HpF = new Point();
  private Point HpG = new Point();
  private Point HpH = new Point();
  private Point HpI;
  Runnable HpJ = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(115757);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184093);
          BaseSmallView.this.eoL();
          AppMethodBeat.o(184093);
        }
      });
      AppMethodBeat.o(115757);
    }
  };
  protected MMHandler czp;
  private WindowManager mWindowManager;
  private PointF okA = new PointF();
  @Deprecated
  CaptureView qsJ;
  public SurfaceTexture surfaceTexture;
  
  public BaseSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.czp = new MMHandler();
    this.HpI = new Point(this.mWindowManager.getDefaultDisplay().getWidth(), this.mWindowManager.getDefaultDisplay().getHeight());
  }
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  @Deprecated
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void aGx(String paramString) {}
  
  public void aGy(String paramString) {}
  
  public void enR()
  {
    h.RTc.bqo("resumeIcon");
    h.RTc.a(this.HpJ, 2000L, "resumeIcon");
  }
  
  public boolean eoK()
  {
    h.RTc.bqo("resumeIcon");
    return true;
  }
  
  public void eoL() {}
  
  public void eoM() {}
  
  @Deprecated
  public void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void fJm() {}
  
  @Deprecated
  public void fJx() {}
  
  public void fMf() {}
  
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
  public void jA(int paramInt1, int paramInt2) {}
  
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
    this.GUl = paramLong;
  }
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  @Deprecated
  public void setSpatiotemporalDenosing(int paramInt) {}
  
  public void setStatus(int paramInt) {}
  
  public void setVoicePlayDevice(int paramInt)
  {
    h.RTc.bqo("resumeIcon");
    h.RTc.a(this.HpJ, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public void setVoipUIListener(c paramc)
  {
    Log.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
    this.Hen = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    this.mWindowManager = null;
  }
  
  public void xm(boolean paramBoolean)
  {
    h.RTc.bqo("resumeIcon");
    h.RTc.a(this.HpJ, 2000L, "resumeIcon");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.BaseSmallView
 * JD-Core Version:    0.7.0.1
 */