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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView
  extends FrameLayout
{
  protected WeakReference<c> AJQ;
  public d AKY;
  Runnable ATg = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(115757);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184093);
          BaseSmallView.this.elz();
          AppMethodBeat.o(184093);
        }
      });
      AppMethodBeat.o(115757);
    }
  };
  protected int AzM = -1;
  protected long AzN;
  private PointF gqN = new PointF();
  private Point gqO = new Point();
  private Point gqP = new Point();
  private Point gqQ = new Point();
  private Point gqR;
  private WindowManager gqS;
  protected ao gqT;
  @Deprecated
  CaptureView otK;
  public SurfaceTexture surfaceTexture;
  
  public BaseSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.gqS = ((WindowManager)paramContext.getSystemService("window"));
    this.gqT = new ao();
    this.gqR = new Point(this.gqS.getDefaultDisplay().getWidth(), this.gqS.getDefaultDisplay().getHeight());
  }
  
  @Deprecated
  public void a(SurfaceTexture paramSurfaceTexture, d paramd) {}
  
  @Deprecated
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void ayB(String paramString) {}
  
  public void ayC(String paramString) {}
  
  public void dgi()
  {
    h.JZN.aTz("resumeIcon");
    h.JZN.a(this.ATg, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void ekY() {}
  
  public void elA() {}
  
  @Deprecated
  public void elk() {}
  
  public boolean ely()
  {
    h.JZN.aTz("resumeIcon");
    return true;
  }
  
  public void elz() {}
  
  public void enq() {}
  
  @Deprecated
  public OpenGlRender getBeautyData()
  {
    return null;
  }
  
  @Deprecated
  public void ie(int paramInt1, int paramInt2) {}
  
  @Deprecated
  protected void onAnimationEnd() {}
  
  @Deprecated
  public void releaseSurfaceTexture() {}
  
  @Deprecated
  public void requestRender() {}
  
  public void sM(boolean paramBoolean)
  {
    h.JZN.aTz("resumeIcon");
    h.JZN.a(this.ATg, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void setCaptureView(CaptureView paramCaptureView) {}
  
  public void setConnectSec(long paramLong)
  {
    this.AzN = paramLong;
  }
  
  @Deprecated
  public void setHWDecMode(int paramInt) {}
  
  public void setStatus(int paramInt) {}
  
  public void setVoicePlayDevice(int paramInt)
  {
    h.JZN.aTz("resumeIcon");
    h.JZN.a(this.ATg, 2000L, "resumeIcon");
  }
  
  @Deprecated
  public void setVoipBeauty(int paramInt) {}
  
  public void setVoipUIListener(c paramc)
  {
    ac.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
    this.AJQ = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    this.gqS = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.BaseSmallView
 * JD-Core Version:    0.7.0.1
 */