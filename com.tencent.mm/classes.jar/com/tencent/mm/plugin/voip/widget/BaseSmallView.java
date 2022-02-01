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
import com.tencent.mm.media.f.d;
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
  private PointF lPG = new PointF();
  private WindowManager oEl;
  protected ap oFl;
  public SurfaceTexture surfaceTexture;
  private Point zAO = new Point();
  private Point zAP = new Point();
  private Point zAQ = new Point();
  private Point zAR;
  Runnable zAS = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(115757);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184093);
          BaseSmallView.this.dWn();
          AppMethodBeat.o(184093);
        }
      });
      AppMethodBeat.o(115757);
    }
  };
  protected int zhd = -1;
  protected long zhe;
  @Deprecated
  CaptureView zlf;
  protected WeakReference<c> zrd;
  public d zsn;
  
  public BaseSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.oEl = ((WindowManager)paramContext.getSystemService("window"));
    this.oFl = new ap();
    this.zAR = new Point(this.oEl.getDefaultDisplay().getWidth(), this.oEl.getDefaultDisplay().getHeight());
  }
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  @Deprecated
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void atk(String paramString) {}
  
  public void atl(String paramString) {}
  
  public void cSz()
  {
    h.Iye.aNW("resumeIcon");
    h.Iye.a(this.zAS, 2000L, "resumeIcon");
  }
  
  public void dVN() {}
  
  @Deprecated
  public void dVY() {}
  
  public boolean dWm()
  {
    h.Iye.aNW("resumeIcon");
    return true;
  }
  
  public void dWn() {}
  
  public void dWo() {}
  
  public void dXU() {}
  
  @Deprecated
  public void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  @Deprecated
  public OpenGlRender getBeautyData()
  {
    return null;
  }
  
  @Deprecated
  public void hP(int paramInt1, int paramInt2) {}
  
  @Deprecated
  protected void onAnimationEnd() {}
  
  public void rL(boolean paramBoolean)
  {
    h.Iye.aNW("resumeIcon");
    h.Iye.a(this.zAS, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void releaseSurfaceTexture() {}
  
  @Deprecated
  public void requestRender() {}
  
  @Deprecated
  public void setCaptureView(CaptureView paramCaptureView) {}
  
  public void setConnectSec(long paramLong)
  {
    this.zhe = paramLong;
  }
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  public void setStatus(int paramInt) {}
  
  public void setVoicePlayDevice(int paramInt)
  {
    h.Iye.aNW("resumeIcon");
    h.Iye.a(this.zAS, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public void setVoipUIListener(c paramc)
  {
    ad.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
    this.zrd = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    this.oEl = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.BaseSmallView
 * JD-Core Version:    0.7.0.1
 */