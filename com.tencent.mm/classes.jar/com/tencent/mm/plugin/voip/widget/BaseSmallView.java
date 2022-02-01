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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView
  extends FrameLayout
{
  protected WeakReference<c> CAv;
  public d CBE;
  Runnable CKS = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(115757);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184093);
          BaseSmallView.this.eCR();
          AppMethodBeat.o(184093);
        }
      });
      AppMethodBeat.o(115757);
    }
  };
  protected int Cqn = -1;
  protected long Cqo;
  private PointF gNg = new PointF();
  private Point gNh = new Point();
  private Point gNi = new Point();
  private Point gNj = new Point();
  private Point gNk;
  private WindowManager gNl;
  protected aq gNm;
  @Deprecated
  CaptureView pdJ;
  public SurfaceTexture surfaceTexture;
  
  public BaseSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.gNl = ((WindowManager)paramContext.getSystemService("window"));
    this.gNm = new aq();
    this.gNk = new Point(this.gNl.getDefaultDisplay().getWidth(), this.gNl.getDefaultDisplay().getHeight());
  }
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  @Deprecated
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void aFc(String paramString) {}
  
  public void aFd(String paramString) {}
  
  public void dtu()
  {
    h.MqF.bbc("resumeIcon");
    h.MqF.a(this.CKS, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void eCC() {}
  
  public boolean eCQ()
  {
    h.MqF.bbc("resumeIcon");
    return true;
  }
  
  public void eCR() {}
  
  public void eCS() {}
  
  public void eCr() {}
  
  public void eEX() {}
  
  @Deprecated
  public void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  @Deprecated
  public OpenGlRender getBeautyData()
  {
    return null;
  }
  
  @Deprecated
  public void iv(int paramInt1, int paramInt2) {}
  
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
    this.Cqo = paramLong;
  }
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  public void setStatus(int paramInt) {}
  
  public void setVoicePlayDevice(int paramInt)
  {
    h.MqF.bbc("resumeIcon");
    h.MqF.a(this.CKS, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public void setVoipUIListener(c paramc)
  {
    ae.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
    this.CAv = new WeakReference(paramc);
  }
  
  public void tC(boolean paramBoolean)
  {
    h.MqF.bbc("resumeIcon");
    h.MqF.a(this.CKS, 2000L, "resumeIcon");
  }
  
  public void uninit()
  {
    this.gNl = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.BaseSmallView
 * JD-Core Version:    0.7.0.1
 */