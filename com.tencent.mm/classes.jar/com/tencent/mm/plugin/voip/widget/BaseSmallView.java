package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView
  extends FrameLayout
{
  private WindowManager jfe;
  protected ah jge;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  CaptureView pRW;
  protected long pSi;
  protected WeakReference<c> pWz;
  public MMTextureView pYr;
  private PointF qck = new PointF();
  private Point qcl = new Point();
  private Point qcm = new Point();
  private Point qcn = new Point();
  private Point qco;
  private Runnable qcp = new Runnable()
  {
    public final void run()
    {
      float f = (float)(System.currentTimeMillis() - BaseSmallView.a(BaseSmallView.this)) * 1.0F / 200.0F;
      if (f <= 1.0F)
      {
        BaseSmallView.this.jge.postDelayed(BaseSmallView.b(BaseSmallView.this), 5L);
        BaseSmallView localBaseSmallView = BaseSmallView.this;
        int i = BaseSmallView.c(BaseSmallView.this).x;
        int j = (int)((BaseSmallView.d(BaseSmallView.this).x * 1.0F - BaseSmallView.c(BaseSmallView.this).x) * f);
        int k = BaseSmallView.c(BaseSmallView.this).y;
        BaseSmallView.a(localBaseSmallView, i + j, (int)(f * (BaseSmallView.d(BaseSmallView.this).y * 1.0F - BaseSmallView.c(BaseSmallView.this).y)) + k);
        return;
      }
      BaseSmallView.a(BaseSmallView.this, BaseSmallView.d(BaseSmallView.this).x, BaseSmallView.d(BaseSmallView.this).y);
      BaseSmallView.this.onAnimationEnd();
    }
  };
  
  public BaseSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jfe = ((WindowManager)paramContext.getSystemService("window"));
    this.jge = new ah();
    this.qco = new Point(this.jfe.getDefaultDisplay().getWidth(), this.jfe.getDefaultDisplay().getHeight());
  }
  
  private void es(int paramInt1, int paramInt2)
  {
    WindowManager.LayoutParams localLayoutParams;
    if (this.jfe != null)
    {
      localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      y.d("MicroMsg.Voip.BaseSmallView", "updateWindowPosition, x: %d, y: %d", new Object[] { Integer.valueOf(localLayoutParams.x), Integer.valueOf(localLayoutParams.y) });
    }
    try
    {
      this.jfe.updateViewLayout(this, localLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.Voip.BaseSmallView", localThrowable, "", new Object[0]);
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void bQK() {}
  
  public abstract void bSg();
  
  public abstract void bSh();
  
  public void c(int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void cK(int paramInt1, int paramInt2) {}
  
  public abstract OpenGlRender getFilterData();
  
  public abstract void onAnimationEnd();
  
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
        this.qck.x = paramMotionEvent.getRawX();
        this.qck.y = paramMotionEvent.getRawY();
        paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
        this.qcl.x = paramMotionEvent.x;
        this.qcl.y = paramMotionEvent.y;
        continue;
        es((int)Math.max(Math.min(this.qcl.x + paramMotionEvent.getRawX() - this.qck.x, this.qco.x), 0.0F), (int)Math.max(Math.min(this.qcl.y + paramMotionEvent.getRawY() - this.qck.y, this.qco.y), 0.0F));
      }
    }
    if ((Math.abs(paramMotionEvent.getRawX() - this.qck.x) < BackwardSupportUtil.b.b(getContext(), 3.0F)) && (Math.abs(paramMotionEvent.getRawY() - this.qck.y) < BackwardSupportUtil.b.b(getContext(), 3.0F)) && (this.mOnClickListener != null)) {
      this.mOnClickListener.onClick(this);
    }
    bSg();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.qcm.x = ((int)Math.max(Math.min(f1 + this.qcl.x - this.qck.x, this.qco.x), 0.0F));
    this.qcm.y = ((int)Math.max(Math.min(f2 + this.qcl.y - this.qck.y, this.qco.y), 0.0F));
    int i = BackwardSupportUtil.b.b(getContext(), 5.0F);
    if (this.qcm.x + getWidth() / 2 <= this.qco.x / 2) {}
    for (this.qcn.x = i;; this.qcn.x = (this.qco.x - getWidth() - i))
    {
      this.qcn.y = this.qcm.y;
      this.mStartTime = System.currentTimeMillis();
      this.jge.postDelayed(this.qcp, 5L);
      bSh();
      break;
    }
  }
  
  public abstract void setCaptureView(CaptureView paramCaptureView);
  
  public void setConnectSec(long paramLong)
  {
    this.pSi = paramLong;
  }
  
  public void setHWDecMode(int paramInt) {}
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setVoipBeauty(int paramInt) {}
  
  public void setVoipUIListener(c paramc)
  {
    y.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
    this.pWz = new WeakReference(paramc);
    ((c)this.pWz.get()).b(this.pYr);
  }
  
  public void uninit()
  {
    this.jge.removeCallbacks(this.qcp);
    this.jfe = null;
    if (this.pRW != null)
    {
      removeView(this.pRW);
      this.pRW = null;
      y.d("MicroMsg.Voip.BaseSmallView", "CaptureView removed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.BaseSmallView
 * JD-Core Version:    0.7.0.1
 */