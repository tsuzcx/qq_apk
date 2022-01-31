package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.support.v4.widget.n;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.tencent.luggage.a.b;
import com.tencent.luggage.a.d;
import com.tencent.luggage.a.e;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SwipeBackLayout
  extends FrameLayout
{
  private static final int[] xoU = { 1, 2, 8, 11 };
  private Drawable KA;
  private Drawable KB;
  private int Ke = -1728053248;
  private float Kf;
  private View QR;
  private Rect hc = new Rect();
  private boolean mEnable = true;
  private boolean mInLayout;
  private float wkX = 0.3F;
  private int wkY;
  private int wkZ;
  private float wlb;
  private int xoV;
  private a xoW = a.a(this, new SwipeBackLayout.b(this, (byte)0));
  private CopyOnWriteArrayList<SwipeBackLayout.a> xoX;
  private Drawable xoY;
  private int xoZ;
  
  public SwipeBackLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, com.tencent.luggage.a.a.SwipeBackLayoutStyle);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.e.SwipeBackLayout, paramInt, a.d.SwipeBackLayout);
    paramInt = paramContext.getDimensionPixelSize(a.e.SwipeBackLayout_edge_size, -1);
    if (paramInt > 0) {
      setEdgeSize(paramInt);
    }
    setEdgeTrackingEnabled(xoU[paramContext.getInt(a.e.SwipeBackLayout_edge_flag, 0)]);
    paramInt = paramContext.getResourceId(a.e.SwipeBackLayout_shadow_left, a.b.shadow_left);
    int i = paramContext.getResourceId(a.e.SwipeBackLayout_shadow_right, a.b.shadow_right);
    int j = paramContext.getResourceId(a.e.SwipeBackLayout_shadow_bottom, a.b.shadow_bottom);
    gv(paramInt, 1);
    gv(i, 2);
    gv(j, 8);
    paramContext.recycle();
    float f = getResources().getDisplayMetrics().density * 400.0F;
    this.xoW.MS = f;
    this.xoW.MR = (f * 2.0F);
  }
  
  private void gv(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt1);
    if ((paramInt2 & 0x1) != 0) {
      this.KA = localDrawable;
    }
    for (;;)
    {
      invalidate();
      return;
      if ((paramInt2 & 0x2) != 0) {
        this.KB = localDrawable;
      } else if ((paramInt2 & 0x8) != 0) {
        this.xoY = localDrawable;
      }
    }
  }
  
  public final void a(SwipeBackLayout.a parama)
  {
    if (this.xoX == null) {
      this.xoX = new CopyOnWriteArrayList();
    }
    this.xoX.add(parama);
  }
  
  public void computeScroll()
  {
    this.Kf = (1.0F - this.wlb);
    a locala = this.xoW;
    boolean bool;
    int i;
    if (locala.MI == 2)
    {
      bool = locala.hBk.iY.computeScrollOffset();
      i = locala.hBk.iY.getCurrX();
      int j = locala.hBk.iY.getCurrY();
      int k = i - locala.MW.getLeft();
      int m = j - locala.MW.getTop();
      if (k != 0) {
        locala.MW.offsetLeftAndRight(k);
      }
      if (m != 0) {
        locala.MW.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        locala.xpd.k(locala.MW, i, j, k, m);
      }
      if ((!bool) || (i != locala.hBk.iY.getFinalX()) || (j != locala.hBk.iY.getFinalY())) {
        break label243;
      }
      locala.hBk.iY.abortAnimation();
      bool = locala.hBk.iY.isFinished();
    }
    label243:
    for (;;)
    {
      if (!bool) {
        locala.MY.post(locala.MZ);
      }
      if (locala.MI == 2) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          q.O(this);
        }
        return;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnable) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    Object localObject;
    if ((this.xoX != null) && (!this.xoX.isEmpty()))
    {
      localObject = this.xoX.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SwipeBackLayout.a)((Iterator)localObject).next()).l(paramMotionEvent);
      }
    }
    if (this.xoW.MI == 1)
    {
      this.xoW.g(paramMotionEvent);
      return true;
    }
    for (;;)
    {
      try
      {
        localObject = this.xoW;
        j = paramMotionEvent.getActionMasked();
        i = paramMotionEvent.getActionIndex();
        if (j == 0) {
          ((a)localObject).cancel();
        }
        if (((a)localObject).fB == null) {
          ((a)localObject).fB = VelocityTracker.obtain();
        }
        ((a)localObject).fB.addMovement(paramMotionEvent);
        switch (j)
        {
        case 4: 
          if (((a)localObject).MI != 1) {
            break label573;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          paramMotionEvent.setAction(3);
          super.dispatchTouchEvent(paramMotionEvent);
          return true;
        }
      }
      catch (NullPointerException paramMotionEvent)
      {
        int j;
        float f1;
        float f2;
        View localView;
        int k;
        float f3;
        float f4;
        return false;
        i += 1;
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        return false;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        return false;
      }
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      int i = paramMotionEvent.getPointerId(0);
      ((a)localObject).a(f1, f2, i);
      localView = ((a)localObject).y((int)f1, (int)f2);
      if ((localView == ((a)localObject).MW) && (((a)localObject).MI == 2)) {
        ((a)localObject).u(localView, i);
      }
      if ((localObject.xpc[i] & ((a)localObject).MU) != 0)
      {
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        ((a)localObject).a(f1, f2, j);
        if ((((a)localObject).MI != 0) && (((a)localObject).MI == 2))
        {
          localView = ((a)localObject).y((int)f1, (int)f2);
          if (localView == ((a)localObject).MW)
          {
            ((a)localObject).u(localView, j);
            continue;
            j = paramMotionEvent.getPointerCount();
            i = 0;
            if (i < j)
            {
              k = paramMotionEvent.getPointerId(i);
              f1 = paramMotionEvent.getX(i);
              f2 = paramMotionEvent.getY(i);
              f3 = f1 - localObject.MJ[k];
              f4 = f2 - localObject.MK[k];
              ((a)localObject).b(f3, f4, k);
              if (((a)localObject).MI != 1)
              {
                localView = ((a)localObject).y((int)f1, (int)f2);
                if ((localView == null) || (!((a)localObject).c(localView, f3, f4)) || (!((a)localObject).u(localView, k))) {
                  continue;
                }
              }
            }
            ((a)localObject).e(paramMotionEvent);
            continue;
            ((a)localObject).aN(paramMotionEvent.getPointerId(i));
            continue;
            ((a)localObject).cancel();
            continue;
            super.dispatchTouchEvent(paramMotionEvent);
            return true;
            continue;
            label573:
            i = 0;
          }
        }
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i;
    boolean bool;
    int j;
    if (paramView == this.QR)
    {
      i = 1;
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((this.Kf > 0.0F) && (i != 0) && (this.xoW.MI != 0))
      {
        Rect localRect = this.hc;
        paramView.getHitRect(localRect);
        if ((this.xoV & 0x1) != 0)
        {
          this.KA.setBounds(localRect.left - this.KA.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
          this.KA.setAlpha((int)(this.Kf * 255.0F));
          this.KA.draw(paramCanvas);
        }
        if ((this.xoV & 0x2) != 0)
        {
          this.KB.setBounds(localRect.right, localRect.top, localRect.right + this.KB.getIntrinsicWidth(), localRect.bottom);
          this.KB.setAlpha((int)(this.Kf * 255.0F));
          this.KB.draw(paramCanvas);
        }
        if ((this.xoV & 0x8) != 0)
        {
          this.xoY.setBounds(localRect.left, localRect.bottom, localRect.right, localRect.bottom + this.xoY.getIntrinsicHeight());
          this.xoY.setAlpha((int)(this.Kf * 255.0F));
          this.xoY.draw(paramCanvas);
        }
        i = (int)(((this.Ke & 0xFF000000) >>> 24) * this.Kf);
        j = this.Ke;
        if ((this.xoZ & 0x1) == 0) {
          break label336;
        }
        paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
      }
    }
    for (;;)
    {
      paramCanvas.drawColor(i << 24 | j & 0xFFFFFF);
      return bool;
      i = 0;
      break;
      label336:
      if ((this.xoZ & 0x2) != 0) {
        paramCanvas.clipRect(paramView.getRight(), 0, getRight(), getHeight());
      } else if ((this.xoZ & 0x8) != 0) {
        paramCanvas.clipRect(paramView.getLeft(), paramView.getBottom(), getRight(), getHeight());
      }
    }
  }
  
  public View getTargetView()
  {
    return this.QR;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    if (this.QR != null) {
      this.QR.layout(this.wkY, this.wkZ, this.wkY + this.QR.getMeasuredWidth(), this.wkZ + this.QR.getMeasuredHeight());
    }
    this.mInLayout = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnable) {
      return false;
    }
    this.xoW.g(paramMotionEvent);
    return true;
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  public void setContentView(View paramView)
  {
    this.QR = paramView;
  }
  
  public void setEdgeSize(int paramInt)
  {
    this.xoW.MT = paramInt;
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.xoV = paramInt;
    this.xoW.MU = this.xoV;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setMaxVelocity(float paramFloat)
  {
    this.xoW.MR = paramFloat;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.xoW.MS = paramFloat;
  }
  
  public void setScrimColor(int paramInt)
  {
    this.Ke = paramInt;
    invalidate();
  }
  
  public void setScrollThresHold(float paramFloat)
  {
    if ((paramFloat >= 1.0F) || (paramFloat <= 0.0F)) {
      throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
    }
    this.wkX = paramFloat;
  }
  
  @Deprecated
  public void setSwipeListener(SwipeBackLayout.a parama)
  {
    a(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */