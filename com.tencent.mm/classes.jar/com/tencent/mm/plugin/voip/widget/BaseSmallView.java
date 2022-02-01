package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView
  extends FrameLayout
{
  protected WeakReference<c> UJb;
  private Point UUM = new Point();
  private Point UUN = new Point();
  private Point UUO = new Point();
  private Point UUP;
  Runnable UUQ = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(115757);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184093);
          BaseSmallView.this.ghx();
          AppMethodBeat.o(184093);
        }
      });
      AppMethodBeat.o(115757);
    }
  };
  protected int Uxg = -1;
  protected long Uxh;
  protected MMHandler eqE;
  private WindowManager mWindowManager;
  private PointF uwL = new PointF();
  @Deprecated
  private CaptureView wUL;
  
  public BaseSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.eqE = new MMHandler();
    this.UUP = new Point(this.mWindowManager.getDefaultDisplay().getWidth(), this.mWindowManager.getDefaultDisplay().getHeight());
  }
  
  public void GH(boolean paramBoolean)
  {
    h.ahAA.bFQ("resumeIcon");
    h.ahAA.a(this.UUQ, 2000L, "resumeIcon");
  }
  
  @Deprecated
  protected final void a(CaptureView paramCaptureView)
  {
    Log.printDebugStack("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
    if (this.wUL != null)
    {
      removeView(this.wUL);
      this.wUL = null;
    }
    if (paramCaptureView != null)
    {
      this.wUL = paramCaptureView;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(1, 1);
      localLayoutParams.leftMargin = 20;
      localLayoutParams.topMargin = 20;
      addView(paramCaptureView, localLayoutParams);
      paramCaptureView.setVisibility(0);
      Log.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
    }
  }
  
  public void aNF(String paramString) {}
  
  public void fwi()
  {
    h.ahAA.bFQ("resumeIcon");
    h.ahAA.a(this.UUQ, 2000L, "resumeIcon");
  }
  
  public void fwq() {}
  
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
  
  public boolean ghw()
  {
    h.ahAA.bFQ("resumeIcon");
    return true;
  }
  
  public void ghx() {}
  
  public void ghy() {}
  
  public void idK() {}
  
  @Deprecated
  protected void onAnimationEnd() {}
  
  @Deprecated
  public void setCaptureView(CaptureView paramCaptureView) {}
  
  public void setConnectSec(long paramLong)
  {
    this.Uxh = paramLong;
  }
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  @Deprecated
  public void setSpatiotemporalDenosing(int paramInt) {}
  
  public void setStatus(int paramInt) {}
  
  public void setVoicePlayDevice(int paramInt)
  {
    h.ahAA.bFQ("resumeIcon");
    h.ahAA.a(this.UUQ, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public void setVoipUIListener(c paramc)
  {
    Log.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
    this.UJb = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    this.mWindowManager = null;
  }
  
  public void updateText(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.BaseSmallView
 * JD-Core Version:    0.7.0.1
 */