package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView
  extends FrameLayout
{
  private Runnable Sn = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(5136);
      float f = (float)(System.currentTimeMillis() - BaseSmallView.a(BaseSmallView.this)) * 1.0F / 200.0F;
      if (f <= 1.0F)
      {
        BaseSmallView.this.loX.postDelayed(BaseSmallView.b(BaseSmallView.this), 5L);
        BaseSmallView localBaseSmallView = BaseSmallView.this;
        int i = BaseSmallView.c(BaseSmallView.this).x;
        int j = (int)((BaseSmallView.d(BaseSmallView.this).x * 1.0F - BaseSmallView.c(BaseSmallView.this).x) * f);
        int k = BaseSmallView.c(BaseSmallView.this).y;
        BaseSmallView.a(localBaseSmallView, i + j, (int)(f * (BaseSmallView.d(BaseSmallView.this).y * 1.0F - BaseSmallView.c(BaseSmallView.this).y)) + k);
        AppMethodBeat.o(5136);
        return;
      }
      BaseSmallView.a(BaseSmallView.this, BaseSmallView.d(BaseSmallView.this).x, BaseSmallView.d(BaseSmallView.this).y);
      BaseSmallView.this.onAnimationEnd();
      AppMethodBeat.o(5136);
    }
  };
  public SurfaceTexture bbI;
  private WindowManager lnU;
  protected ak loX;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  protected WeakReference<c> tCc;
  private PointF tJa = new PointF();
  private Point tJb = new Point();
  private Point tJc = new Point();
  private Point tJd = new Point();
  private Point tJe;
  public int textureId;
  CaptureView txe;
  protected long txq;
  
  public BaseSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.lnU = ((WindowManager)paramContext.getSystemService("window"));
    this.loX = new ak();
    this.tJe = new Point(this.lnU.getDefaultDisplay().getWidth(), this.lnU.getDefaultDisplay().getHeight());
  }
  
  private void gt(int paramInt1, int paramInt2)
  {
    WindowManager.LayoutParams localLayoutParams;
    if (this.lnU != null)
    {
      localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      ab.d("MicroMsg.Voip.BaseSmallView", "updateWindowPosition, x: %d, y: %d", new Object[] { Integer.valueOf(localLayoutParams.x), Integer.valueOf(localLayoutParams.y) });
    }
    try
    {
      this.lnU.updateViewLayout(this, localLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.Voip.BaseSmallView", localThrowable, "", new Object[0]);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt) {}
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void cNc() {}
  
  public void cOQ() {}
  
  protected abstract void cPo();
  
  protected abstract void cPp();
  
  public void eh(int paramInt1, int paramInt2) {}
  
  public void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public abstract OpenGlRender getBeautyData();
  
  public abstract OpenGlRender getFilterData();
  
  public void gj(int paramInt1, int paramInt2) {}
  
  protected abstract void onAnimationEnd();
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        this.tJa.x = paramMotionEvent.getRawX();
        this.tJa.y = paramMotionEvent.getRawY();
        paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
        this.tJb.x = paramMotionEvent.x;
        this.tJb.y = paramMotionEvent.y;
        continue;
        gt((int)Math.max(Math.min(this.tJb.x + paramMotionEvent.getRawX() - this.tJa.x, this.tJe.x), 0.0F), (int)Math.max(Math.min(this.tJb.y + paramMotionEvent.getRawY() - this.tJa.y, this.tJe.y), 0.0F));
      }
    }
    if ((Math.abs(paramMotionEvent.getRawX() - this.tJa.x) < BackwardSupportUtil.b.b(getContext(), 3.0F)) && (Math.abs(paramMotionEvent.getRawY() - this.tJa.y) < BackwardSupportUtil.b.b(getContext(), 3.0F)) && (this.mOnClickListener != null)) {
      this.mOnClickListener.onClick(this);
    }
    cPo();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.tJc.x = ((int)Math.max(Math.min(f1 + this.tJb.x - this.tJa.x, this.tJe.x), 0.0F));
    this.tJc.y = ((int)Math.max(Math.min(f2 + this.tJb.y - this.tJa.y, this.tJe.y), 0.0F));
    int i = BackwardSupportUtil.b.b(getContext(), 5.0F);
    if (this.tJc.x + getWidth() / 2 <= this.tJe.x / 2) {}
    for (this.tJd.x = i;; this.tJd.x = (this.tJe.x - getWidth() - i))
    {
      this.tJd.y = this.tJc.y;
      this.mStartTime = System.currentTimeMillis();
      this.loX.postDelayed(this.Sn, 5L);
      cPp();
      break;
    }
  }
  
  public void requestRender() {}
  
  public abstract void setCaptureView(CaptureView paramCaptureView);
  
  public void setConnectSec(long paramLong)
  {
    this.txq = paramLong;
  }
  
  public void setHWDecMode(int paramInt) {}
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setVoipBeauty(int paramInt) {}
  
  public void setVoipUIListener(c paramc)
  {
    ab.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
    this.tCc = new WeakReference(paramc);
  }
  
  public void uninit()
  {
    this.loX.removeCallbacks(this.Sn);
    this.lnU = null;
    if (this.txe != null)
    {
      removeView(this.txe);
      this.txe = null;
      ab.d("MicroMsg.Voip.BaseSmallView", "CaptureView removed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.BaseSmallView
 * JD-Core Version:    0.7.0.1
 */