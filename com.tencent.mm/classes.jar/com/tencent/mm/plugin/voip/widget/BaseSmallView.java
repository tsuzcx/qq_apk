package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView
  extends FrameLayout
{
  protected int BYM = -1;
  protected long BYN;
  protected WeakReference<c> CiR;
  public d Cka;
  Runnable Cto = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(115757);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184093);
          BaseSmallView.this.ezj();
          AppMethodBeat.o(184093);
        }
      });
      AppMethodBeat.o(115757);
    }
  };
  private Point gKA = new Point();
  private Point gKB;
  private WindowManager gKC;
  protected ap gKD;
  private PointF gKx = new PointF();
  private Point gKy = new Point();
  private Point gKz = new Point();
  @Deprecated
  CaptureView oXg;
  public SurfaceTexture surfaceTexture;
  
  public BaseSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.gKC = ((WindowManager)paramContext.getSystemService("window"));
    this.gKD = new ap();
    this.gKB = new Point(this.gKC.getDefaultDisplay().getWidth(), this.gKC.getDefaultDisplay().getHeight());
  }
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  @Deprecated
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void aDJ(String paramString) {}
  
  public void aDK(String paramString) {}
  
  public void dqh()
  {
    h.LTJ.aZz("resumeIcon");
    h.LTJ.a(this.Cto, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void eBp() {}
  
  public void eyJ() {}
  
  @Deprecated
  public void eyU() {}
  
  public boolean ezi()
  {
    h.LTJ.aZz("resumeIcon");
    return true;
  }
  
  public void ezj() {}
  
  public void ezk() {}
  
  @Deprecated
  public OpenGlRender getBeautyData()
  {
    return null;
  }
  
  @Deprecated
  public void ir(int paramInt1, int paramInt2) {}
  
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
    this.BYN = paramLong;
  }
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  public void setStatus(int paramInt) {}
  
  public void setVoicePlayDevice(int paramInt)
  {
    h.LTJ.aZz("resumeIcon");
    h.LTJ.a(this.Cto, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public void setVoipUIListener(c paramc)
  {
    ad.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
    this.CiR = new WeakReference(paramc);
  }
  
  public void tv(boolean paramBoolean)
  {
    h.LTJ.aZz("resumeIcon");
    h.LTJ.a(this.Cto, 2000L, "resumeIcon");
  }
  
  public void uninit()
  {
    this.gKC = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.BaseSmallView
 * JD-Core Version:    0.7.0.1
 */