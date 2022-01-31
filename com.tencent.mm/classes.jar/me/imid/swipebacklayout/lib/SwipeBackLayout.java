package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
import android.support.v4.widget.p;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SwipeBackLayout
  extends FrameLayout
{
  private static final int[] CKW = { 1, 2, 8, 11 };
  private float AEP;
  protected int AEQ;
  protected int AER;
  protected float AET;
  private int CKX;
  protected a CKY;
  private CopyOnWriteArrayList<SwipeBackLayout.a> CKZ;
  private Drawable CLa;
  private int CLb;
  private int JK;
  private float JL;
  private Drawable Kg;
  private Drawable Kh;
  private View Qz;
  private Rect hV;
  private boolean mEnable;
  private boolean mInLayout;
  
  public SwipeBackLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130771968);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91208);
    this.AEP = 0.3F;
    this.mEnable = true;
    this.JK = -1728053248;
    this.hV = new Rect();
    this.CKY = a.a(this, new SwipeBackLayout.c(this, (byte)0));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, com.tencent.luggage.a.a.SwipeBackLayout, paramInt, 2131493582);
    paramInt = paramContext.getDimensionPixelSize(0, -1);
    if (paramInt > 0) {
      setEdgeSize(paramInt);
    }
    setEdgeTrackingEnabled(CKW[paramContext.getInt(1, 0)]);
    paramInt = paramContext.getResourceId(2, 2130840252);
    int i = paramContext.getResourceId(3, 2130840253);
    int j = paramContext.getResourceId(4, 2130840250);
    iK(paramInt, 1);
    iK(i, 2);
    iK(j, 8);
    paramContext.recycle();
    float f = getResources().getDisplayMetrics().density * 400.0F;
    this.CKY.MI = f;
    this.CKY.MH = (f * 2.0F);
    AppMethodBeat.o(91208);
  }
  
  private void f(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(91213);
    if ((paramInt & 0x1) != 0) {
      this.Kg = paramDrawable;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(91213);
      return;
      if ((paramInt & 0x2) != 0) {
        this.Kh = paramDrawable;
      } else if ((paramInt & 0x8) != 0) {
        this.CLa = paramDrawable;
      }
    }
  }
  
  private void iK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91214);
    f(getResources().getDrawable(paramInt1), paramInt2);
    AppMethodBeat.o(91214);
  }
  
  public final void a(SwipeBackLayout.a parama)
  {
    AppMethodBeat.i(91211);
    if (this.CKZ == null) {
      this.CKZ = new CopyOnWriteArrayList();
    }
    this.CKZ.add(parama);
    AppMethodBeat.o(91211);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(91220);
    this.JL = (1.0F - this.AET);
    a locala = this.CKY;
    boolean bool;
    int i;
    if (locala.Mw == 2)
    {
      bool = locala.jtz.jR.computeScrollOffset();
      i = locala.jtz.jR.getCurrX();
      int j = locala.jtz.jR.getCurrY();
      int k = i - locala.MM.getLeft();
      int m = j - locala.MM.getTop();
      if (k != 0) {
        locala.MM.offsetLeftAndRight(k);
      }
      if (m != 0) {
        locala.MM.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        locala.CLf.o(locala.MM, i, j, k, m);
      }
      if ((!bool) || (i != locala.jtz.jR.getFinalX()) || (j != locala.jtz.jR.getFinalY())) {
        break label253;
      }
      locala.jtz.jR.abortAnimation();
      bool = locala.jtz.jR.isFinished();
    }
    label253:
    for (;;)
    {
      if (!bool) {
        locala.MO.post(locala.MP);
      }
      if (locala.Mw == 2) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          t.R(this);
        }
        AppMethodBeat.o(91220);
        return;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(91215);
    if (!this.mEnable)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(91215);
      return bool;
    }
    Object localObject;
    if ((this.CKZ != null) && (!this.CKZ.isEmpty()))
    {
      localObject = this.CKZ.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SwipeBackLayout.a)((Iterator)localObject).next()).l(paramMotionEvent);
      }
    }
    if (this.CKY.Mw == 1)
    {
      this.CKY.g(paramMotionEvent);
      AppMethodBeat.o(91215);
      return true;
    }
    try
    {
      localObject = this.CKY;
      j = paramMotionEvent.getActionMasked();
      i = paramMotionEvent.getActionIndex();
      if (j == 0) {
        ((a)localObject).cancel();
      }
      if (((a)localObject).mVelocityTracker == null) {
        ((a)localObject).mVelocityTracker = VelocityTracker.obtain();
      }
      ((a)localObject).mVelocityTracker.addMovement(paramMotionEvent);
      switch (j)
      {
      }
    }
    catch (NullPointerException paramMotionEvent)
    {
      for (;;)
      {
        AppMethodBeat.o(91215);
        return false;
        int j = paramMotionEvent.getPointerCount();
        i = 0;
        if (i < j)
        {
          k = paramMotionEvent.getPointerId(i);
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          f3 = f1 - localObject.Mx[k];
          f4 = f2 - localObject.My[k];
          ((a)localObject).b(f3, f4, k);
          if (((a)localObject).Mw != 1)
          {
            localView = ((a)localObject).A((int)f1, (int)f2);
            if ((localView == null) || (!((a)localObject).c(localView, f3, f4)) || (!((a)localObject).x(localView, k))) {
              break;
            }
          }
        }
        ((a)localObject).e(paramMotionEvent);
      }
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      for (;;)
      {
        AppMethodBeat.o(91215);
        return false;
        ((a)localObject).aJ(paramMotionEvent.getPointerId(i));
      }
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      AppMethodBeat.o(91215);
      return false;
    }
    if (((a)localObject).Mw == 1) {}
    for (int i = 1;; i = 0)
    {
      float f1;
      float f2;
      View localView;
      if (i != 0)
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(91215);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = paramMotionEvent.getPointerId(0);
        ((a)localObject).a(f1, f2, i);
        localView = ((a)localObject).A((int)f1, (int)f2);
        if ((localView == ((a)localObject).MM) && (((a)localObject).Mw == 2)) {
          ((a)localObject).x(localView, i);
        }
        if ((localObject.CLe[i] & ((a)localObject).MK) == 0) {
          break;
        }
        break;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        ((a)localObject).a(f1, f2, j);
        if ((((a)localObject).Mw == 0) || (((a)localObject).Mw != 2)) {
          break;
        }
        localView = ((a)localObject).A((int)f1, (int)f2);
        if (localView != ((a)localObject).MM) {
          break;
        }
        ((a)localObject).x(localView, j);
        break;
      }
      for (;;)
      {
        int k;
        float f3;
        float f4;
        ((a)localObject).cancel();
        break;
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(91215);
        return true;
        break;
        i += 1;
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(91219);
    int i;
    boolean bool;
    int j;
    if (paramView == this.Qz)
    {
      i = 1;
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((this.JL > 0.0F) && (i != 0) && (this.CKY.Mw != 0))
      {
        Rect localRect = this.hV;
        paramView.getHitRect(localRect);
        if ((this.CKX & 0x1) != 0)
        {
          this.Kg.setBounds(localRect.left - this.Kg.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
          this.Kg.setAlpha((int)(this.JL * 255.0F));
          this.Kg.draw(paramCanvas);
        }
        if ((this.CKX & 0x2) != 0)
        {
          this.Kh.setBounds(localRect.right, localRect.top, localRect.right + this.Kh.getIntrinsicWidth(), localRect.bottom);
          this.Kh.setAlpha((int)(this.JL * 255.0F));
          this.Kh.draw(paramCanvas);
        }
        if ((this.CKX & 0x8) != 0)
        {
          this.CLa.setBounds(localRect.left, localRect.bottom, localRect.right, localRect.bottom + this.CLa.getIntrinsicHeight());
          this.CLa.setAlpha((int)(this.JL * 255.0F));
          this.CLa.draw(paramCanvas);
        }
        i = (int)(((this.JK & 0xFF000000) >>> 24) * this.JL);
        j = this.JK;
        if ((this.CLb & 0x1) == 0) {
          break label348;
        }
        paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
      }
    }
    for (;;)
    {
      paramCanvas.drawColor(i << 24 | j & 0xFFFFFF);
      AppMethodBeat.o(91219);
      return bool;
      i = 0;
      break;
      label348:
      if ((this.CLb & 0x2) != 0) {
        paramCanvas.clipRect(paramView.getRight(), 0, getRight(), getHeight());
      } else if ((this.CLb & 0x8) != 0) {
        paramCanvas.clipRect(paramView.getLeft(), paramView.getBottom(), getRight(), getHeight());
      }
    }
  }
  
  public View getTargetView()
  {
    return this.Qz;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(91217);
    this.mInLayout = true;
    if (this.Qz != null) {
      this.Qz.layout(this.AEQ, this.AER, this.AEQ + this.Qz.getMeasuredWidth(), this.AER + this.Qz.getMeasuredHeight());
    }
    this.mInLayout = false;
    AppMethodBeat.o(91217);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(91216);
    if (!this.mEnable)
    {
      AppMethodBeat.o(91216);
      return false;
    }
    this.CKY.g(paramMotionEvent);
    AppMethodBeat.o(91216);
    return true;
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(91218);
    if (!this.mInLayout) {
      super.requestLayout();
    }
    AppMethodBeat.o(91218);
  }
  
  public void setContentView(View paramView)
  {
    this.Qz = paramView;
  }
  
  public void setEdgeSize(int paramInt)
  {
    this.CKY.MJ = paramInt;
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.CKX = paramInt;
    this.CKY.MK = this.CKX;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setMaxVelocity(float paramFloat)
  {
    this.CKY.MH = paramFloat;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.CKY.MI = paramFloat;
  }
  
  public void setScrimColor(int paramInt)
  {
    AppMethodBeat.i(91209);
    this.JK = paramInt;
    invalidate();
    AppMethodBeat.o(91209);
  }
  
  public void setScrollThresHold(float paramFloat)
  {
    AppMethodBeat.i(91212);
    if ((paramFloat >= 1.0F) || (paramFloat <= 0.0F))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Threshold value should be between 0 and 1.0");
      AppMethodBeat.o(91212);
      throw localIllegalArgumentException;
    }
    this.AEP = paramFloat;
    AppMethodBeat.o(91212);
  }
  
  @Deprecated
  public void setSwipeListener(SwipeBackLayout.a parama)
  {
    AppMethodBeat.i(91210);
    a(parama);
    AppMethodBeat.o(91210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */