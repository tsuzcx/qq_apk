package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

public final class a
  extends BaseSmallView
{
  private boolean OU;
  private ah hcZ = new ah(Looper.getMainLooper());
  private int pYt;
  private Runnable qcA = new a.2(this);
  private OpenGlRender qcr;
  private OpenGlView qcs;
  private OpenGlRender qct;
  private OpenGlView qcu;
  private int[] qcv = null;
  private int qcw = 0;
  private float qcx;
  private int qcy = 0;
  private Runnable qcz = new a.1(this);
  
  public a(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    LayoutInflater.from(paramContext).inflate(a.c.voip_widget_video_talking, this);
    this.qcx = paramFloat;
    this.qcs = ((OpenGlView)findViewById(a.b.ogv_talking));
    this.qcr = new OpenGlRender(this.qcs, OpenGlRender.RenderRemote);
    this.qcs.setRenderer(this.qcr);
    this.qcs.setRenderMode(0);
    this.qcu = ((OpenGlView)findViewById(a.b.ogv_local_video));
    this.qct = new OpenGlRender(this.qcu, OpenGlRender.RenderLocal);
    if (d.gF(21))
    {
      paramContext = this.qcu;
      paramContext.qbz = true;
      if (!paramContext.qbz) {
        break label355;
      }
      paramContext.setEGLConfigChooser(new com.tencent.mm.plugin.voip.video.b(8, 8, 8, 8));
    }
    for (;;)
    {
      this.qcu.getHolder().setFormat(1);
      paramContext = this.qct;
      y.i(OpenGlRender.TAG, "setRenderWithNativeGL: %s", new Object[] { Boolean.valueOf(true) });
      paramContext.qbs = true;
      this.qcu.setRenderer(this.qct);
      this.qcu.setRenderMode(0);
      this.qcu.setZOrderMediaOverlay(true);
      this.OU = false;
      this.pYr = ((MMTextureView)findViewById(a.b.hwViewSmall));
      if (this.pYr != null) {
        y.i("MicroMsg.Voip.TalkingSmallView", "hwViewSmall creat ok!");
      }
      this.jge.postDelayed(new a.3(this), 3000L);
      this.jge.postDelayed(this.qcA, 2000L);
      this.jge.postDelayed(this.qcz, 5000L);
      return;
      label355:
      paramContext.setEGLConfigChooser(new com.tencent.mm.plugin.voip.video.b(5, 6, 5, 0));
    }
  }
  
  private void bSG()
  {
    if (!this.OU)
    {
      y.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", new Object[] { Integer.valueOf(this.qcy) });
      this.OU = true;
      this.qcr.qaX = true;
      this.qct.qaX = true;
      this.qct.setVoipBeauty(this.qcy);
      this.qcr.setVoipBeauty(this.qcy);
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.qcu.getVisibility() != 0) {}
    do
    {
      do
      {
        return;
        bSG();
        if (OpenGlRender.qbn != 1) {
          break;
        }
        if (this.qcw < paramInt1 * paramInt2) {
          this.qcv = null;
        }
        if (this.qcv == null)
        {
          this.qcw = (paramInt1 * paramInt2);
          this.qcv = new int[this.qcw];
        }
      } while ((com.tencent.mm.plugin.voip.b.bPx().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.qcv, false) < 0) || (this.qcv == null));
      this.qct.a(this.qcv, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      return;
    } while (OpenGlRender.qbn != 2);
    this.qct.c(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true);
  }
  
  public final void bQK()
  {
    if (this.OU)
    {
      this.qct.bSz();
      this.qcr.bSz();
    }
  }
  
  protected final void bSg()
  {
    y.i("MicroMsg.Voip.TalkingSmallView", "onMoveStop");
    this.qcu.setVisibility(0);
    if (this.qcu.qbz) {
      this.qct.kf(false);
    }
    this.jge.removeCallbacks(this.qcz);
    this.jge.postDelayed(this.qcz, 3000L);
  }
  
  protected final void bSh()
  {
    this.qcr.bSy();
    this.qct.bSy();
  }
  
  public final void c(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    bSG();
    if (OpenGlRender.qbn == 1)
    {
      this.qcr.a(paramArrayOfInt, paramInt1, paramInt2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
      return;
    }
    this.qcr.a(paramArrayOfInt, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
  }
  
  public final void cK(int paramInt1, int paramInt2)
  {
    Object localObject = (RelativeLayout.LayoutParams)this.qcu.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (paramInt2 / 4);
    ((RelativeLayout.LayoutParams)localObject).width = ((int)(this.qcx * ((RelativeLayout.LayoutParams)localObject).height));
    this.qcu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new WindowManager.LayoutParams();
    }
    ((WindowManager.LayoutParams)localObject).width = paramInt1;
    ((WindowManager.LayoutParams)localObject).height = paramInt2;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public final OpenGlRender getFilterData()
  {
    return this.qct;
  }
  
  protected final void onAnimationEnd()
  {
    this.qcr.qaX = true;
    this.qct.qaX = true;
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    y.b("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
    if (this.pRW != null)
    {
      removeView(this.pRW);
      this.pRW = null;
    }
    if (paramCaptureView != null)
    {
      this.pRW = paramCaptureView;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(1, 1);
      localLayoutParams.leftMargin = 20;
      localLayoutParams.topMargin = 20;
      addView(paramCaptureView, localLayoutParams);
      paramCaptureView.setVisibility(0);
      y.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    int i;
    if (this.hcZ != null)
    {
      if ((paramInt & 0x1) == 0) {
        break label49;
      }
      i = 1;
      if (i != 0) {
        break label54;
      }
      y.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, not hwdec");
      this.hcZ.post(new a.4(this));
    }
    for (;;)
    {
      this.pYt = paramInt;
      return;
      label49:
      i = 0;
      break;
      label54:
      y.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, is hwdec");
      this.hcZ.post(new a.5(this));
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    y.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.OU), Integer.valueOf(paramInt) });
    this.qcy = paramInt;
    if (this.OU)
    {
      this.qct.setVoipBeauty(paramInt);
      this.qcr.setVoipBeauty(paramInt);
    }
  }
  
  public final void uninit()
  {
    super.uninit();
    setVisibility(4);
    if (this.OU)
    {
      this.qcr.bSy();
      this.qct.bSy();
    }
    this.jge.removeCallbacks(this.qcz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a
 * JD-Core Version:    0.7.0.1
 */