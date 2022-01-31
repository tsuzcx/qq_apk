package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  extends BaseSmallView
{
  private boolean Ux;
  private ak iMP;
  private c tCo;
  private int tDS;
  private OpenGlRender tJg;
  private OpenGlView tJh;
  private OpenGlRender tJi;
  private OpenGlView tJj;
  private int[] tJk;
  private int tJl;
  private float tJm;
  private int tJn;
  private Runnable tJo;
  private Runnable tJp;
  private int txY;
  private int txZ;
  
  public a(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    AppMethodBeat.i(5145);
    this.tJk = null;
    this.tJl = 0;
    this.iMP = new ak(Looper.getMainLooper());
    this.tJn = 0;
    this.txY = 0;
    this.txZ = 0;
    this.tJo = new a.1(this);
    this.tJp = new a.2(this);
    this.tCo = new a.3(this);
    LayoutInflater.from(paramContext).inflate(2130971116, this);
    this.tJm = paramFloat;
    this.tJh = ((OpenGlView)findViewById(2131828903));
    this.tJg = new OpenGlRender(this.tJh, OpenGlRender.RenderRemote);
    this.tJh.setRenderer(this.tJg);
    this.tJh.setRenderMode(0);
    this.tJj = ((OpenGlView)findViewById(2131828905));
    this.tJi = new OpenGlRender(this.tJj, OpenGlRender.RenderLocal);
    if (d.fv(21))
    {
      paramContext = this.tJj;
      paramContext.tHl = true;
      if (paramContext.tHl)
      {
        paramContext.setEGLConfigChooser(new com.tencent.mm.plugin.voip.video.b(8, 8, 8, 8));
        this.tJj.setZOrderOnTop(true);
        this.tJj.getHolder().setFormat(1);
      }
    }
    for (;;)
    {
      this.tJj.setRenderer(this.tJi);
      this.tJj.setRenderMode(0);
      this.Ux = false;
      com.tencent.mm.sdk.b.a.ymk.c(this.tCo);
      this.loX.postDelayed(new a.4(this), 3000L);
      this.loX.postDelayed(this.tJp, 2000L);
      this.loX.postDelayed(this.tJo, 5000L);
      AppMethodBeat.o(5145);
      return;
      paramContext.setEGLConfigChooser(new com.tencent.mm.plugin.voip.video.b(5, 6, 5, 0));
      break;
      this.tJj.setVisibility(4);
      this.tJj.setZOrderMediaOverlay(true);
    }
  }
  
  private void cQb()
  {
    AppMethodBeat.i(5147);
    if (!this.Ux)
    {
      ab.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", new Object[] { Integer.valueOf(this.tJn) });
      this.Ux = true;
      this.tJg.onStarted();
      this.tJi.onStarted();
      this.tJi.setVoipBeauty(this.tJn);
      this.tJg.setVoipBeauty(this.tJn);
      if ((this.txY != 0) && (this.txZ != 0)) {
        gj(this.txY, this.txZ);
      }
    }
    AppMethodBeat.o(5147);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    AppMethodBeat.i(140253);
    if ((this.tJi == null) || (this.tJg == null))
    {
      AppMethodBeat.o(140253);
      return;
    }
    this.bbI = paramSurfaceTexture;
    this.textureId = paramInt;
    this.tJi.a(this.bbI, this.textureId);
    this.tJg.a(this.bbI, this.textureId);
    AppMethodBeat.o(140253);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(5152);
    if (this.tJj.getVisibility() != 0)
    {
      AppMethodBeat.o(5152);
      return;
    }
    cQb();
    if (OpenGlRender.tGO == 1)
    {
      if (this.tJl < paramInt1 * paramInt2) {
        this.tJk = null;
      }
      if (this.tJk == null)
      {
        this.tJl = (paramInt1 * paramInt2);
        this.tJk = new int[this.tJl];
      }
      if ((com.tencent.mm.plugin.voip.b.cLC().a(paramArrayOfByte, (int)paramLong, paramInt3 & 0x1F, paramInt1, paramInt2, this.tJk, false) < 0) || (this.tJk == null))
      {
        AppMethodBeat.o(5152);
        return;
      }
      this.tJi.a(this.tJk, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + paramInt4 + paramInt5, true);
      AppMethodBeat.o(5152);
      return;
    }
    if (OpenGlRender.tGO == 2) {
      this.tJi.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + paramInt4 + paramInt5, true, 3);
    }
    AppMethodBeat.o(5152);
  }
  
  public final void cNc()
  {
    AppMethodBeat.i(5149);
    if ((this.Ux) && (this.tJi != null) && (this.tJg != null))
    {
      this.tJi.cPG();
      this.tJg.cPG();
    }
    AppMethodBeat.o(5149);
  }
  
  public final void cOQ()
  {
    AppMethodBeat.i(140256);
    if (this.tJi.tGW == 1)
    {
      this.tJi.cOQ();
      AppMethodBeat.o(140256);
      return;
    }
    if (this.tJg.tGW == 1) {
      this.tJg.cOQ();
    }
    AppMethodBeat.o(140256);
  }
  
  protected final void cPo()
  {
    AppMethodBeat.i(5155);
    ab.i("MicroMsg.Voip.TalkingSmallView", "onMoveStop");
    this.tJj.setVisibility(0);
    if (this.tJj.tHl) {
      this.tJi.nd(false);
    }
    this.loX.removeCallbacks(this.tJo);
    this.loX.postDelayed(this.tJo, 3000L);
    AppMethodBeat.o(5155);
  }
  
  protected final void cPp()
  {
    AppMethodBeat.i(5156);
    this.tJg.cPF();
    this.tJi.cPF();
    AppMethodBeat.o(5156);
  }
  
  public final void eh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5146);
    Object localObject = (RelativeLayout.LayoutParams)this.tJj.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (paramInt2 / 4);
    ((RelativeLayout.LayoutParams)localObject).width = ((int)(this.tJm * ((RelativeLayout.LayoutParams)localObject).height));
    this.tJj.setLayoutParams((ViewGroup.LayoutParams)localObject);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new WindowManager.LayoutParams();
    }
    ((WindowManager.LayoutParams)localObject).width = paramInt1;
    ((WindowManager.LayoutParams)localObject).height = paramInt2;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(5146);
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140252);
    cQb();
    if (OpenGlRender.tGO == 1)
    {
      this.tJg.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false, 1);
      AppMethodBeat.o(140252);
      return;
    }
    this.tJg.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
    AppMethodBeat.o(140252);
  }
  
  public final OpenGlRender getBeautyData()
  {
    return this.tJi;
  }
  
  public final OpenGlRender getFilterData()
  {
    return this.tJi;
  }
  
  public final void gj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140255);
    ab.i("MicroMsg.Voip.TalkingSmallView", "adjustHWViewAspectRatio, mIsStarted:%b, HWDecsize:%dx%d", new Object[] { Boolean.valueOf(this.Ux), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(140255);
      return;
    }
    this.txY = paramInt1;
    this.txZ = paramInt2;
    if ((this.Ux) && (this.tJi != null) && (this.tJg != null))
    {
      this.tJi.gj(paramInt1, paramInt2);
      this.tJg.gj(paramInt1, paramInt2);
    }
    AppMethodBeat.o(140255);
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(140257);
    this.tJg.onStarted();
    this.tJi.onStarted();
    AppMethodBeat.o(140257);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(140254);
    this.tJh.requestRender();
    AppMethodBeat.o(140254);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(5154);
    ab.a("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
    if (this.txe != null)
    {
      removeView(this.txe);
      this.txe = null;
    }
    if (paramCaptureView != null)
    {
      this.txe = paramCaptureView;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(1, 1);
      localLayoutParams.leftMargin = 20;
      localLayoutParams.topMargin = 20;
      addView(paramCaptureView, localLayoutParams);
      paramCaptureView.setVisibility(0);
      ab.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
    }
    AppMethodBeat.o(5154);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(5151);
    this.tDS = paramInt;
    ab.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, hwdec: %d, before changeSurfaceRender", new Object[] { Integer.valueOf(this.tDS) });
    if ((this.tJi != null) && (this.tJg != null))
    {
      this.tJi.HV(0);
      if ((this.tDS & 0x1) == 0) {
        break label117;
      }
      this.tJg.HV(1);
    }
    for (;;)
    {
      ab.i("MicroMsg.Voip.TalkingSmallView", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d, after changeSurfaceRender", new Object[] { Integer.valueOf(this.tJi.tGW), Integer.valueOf(this.tJg.tGW) });
      AppMethodBeat.o(5151);
      return;
      label117:
      this.tJg.HV(0);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(5150);
    ab.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(this.Ux), Integer.valueOf(paramInt) });
    this.tJn = paramInt;
    if ((this.Ux) && (this.tJi != null) && (this.tJg != null))
    {
      this.tJi.setVoipBeauty(paramInt);
      this.tJg.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(5150);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(5153);
    super.uninit();
    com.tencent.mm.sdk.b.a.ymk.d(this.tCo);
    setVisibility(4);
    if (this.Ux)
    {
      this.tJg.cPF();
      this.tJi.cPF();
    }
    this.loX.removeCallbacks(this.tJo);
    AppMethodBeat.o(5153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a
 * JD-Core Version:    0.7.0.1
 */