package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class MMFlipper
  extends ViewGroup
{
  private Scroller GB;
  private float GS;
  private float GT;
  private Interpolator eO;
  private VelocityTracker fB;
  private int jb;
  private int uTR = 0;
  protected int uTT;
  protected int uTU;
  private boolean uTW = true;
  protected int uUK;
  private int uUL = 0;
  private boolean uUM = false;
  private MMFlipper.b uUN;
  private MMFlipper.a uUO;
  int uUP = -123454321;
  int uUQ = -123454321;
  
  public MMFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    init(paramContext);
  }
  
  public MMFlipper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void Gl(int paramInt)
  {
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int i = getWidth() * paramInt - getScrollX();
      this.GB.startScroll(getScrollX(), 0, i, 0, a.ad(getContext(), (int)(Math.abs(i) * 1.3F)));
      if (this.uTT != paramInt)
      {
        this.uUM = true;
        this.uUK += paramInt - this.uTT;
      }
      this.uTU = this.uTT;
      this.uTT = paramInt;
      invalidate();
    }
  }
  
  private void init(Context paramContext)
  {
    this.eO = getInterpolator();
    this.GB = new Scroller(paramContext, this.eO);
    this.uTU = -1;
    int i = this.uUL;
    this.uTT = i;
    this.uUK = i;
    this.jb = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public final void Go(int paramInt)
  {
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.uUM = false;
    if (!this.GB.isFinished()) {
      this.GB.abortAnimation();
    }
    this.uTU = this.uTT;
    this.uTT = paramInt;
    scrollTo(paramInt * getWidth(), 0);
  }
  
  public final void Gp(int paramInt)
  {
    this.uUK = paramInt;
  }
  
  public void computeScroll()
  {
    this.GB.getCurrX();
    if (this.GB.computeScrollOffset())
    {
      scrollTo(this.GB.getCurrX(), this.GB.getCurrY());
      postInvalidate();
    }
    do
    {
      do
      {
        return;
      } while (!this.uUM);
      this.uUM = false;
    } while (this.uUN == null);
    this.uUN.wS(this.uUK);
  }
  
  public int getCurScreen()
  {
    y.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[] { Integer.valueOf(this.uTT) });
    return this.uTT;
  }
  
  protected Interpolator getInterpolator()
  {
    return new MMFlipper.c();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.uTW) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i;
    do
    {
      return bool1;
      if (getChildCount() == 1) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      i = paramMotionEvent.getAction();
      if (i != 2) {
        break;
      }
      bool1 = bool2;
    } while (this.uTR != 0);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      bool1 = bool2;
      if (this.uTR != 0) {
        break;
      }
      return false;
      i = (int)Math.abs(this.GS - f1);
      int j = (int)Math.abs(this.GT - f2);
      y.v("MicroMsg.MMFlipper", "xDif = " + i + ", yDif = " + j);
      if ((i > this.jb) && (j < this.jb)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label209;
        }
        this.uTR = 1;
        break;
      }
      label209:
      this.uTR = 0;
      continue;
      this.GS = f1;
      this.GT = f2;
      if (this.GB.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.uTR = i;
        break;
      }
      this.uTR = 0;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = bk.UZ();
    int j = 0;
    int m = getChildCount();
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      int k = j;
      if (localView.getVisibility() != 8)
      {
        k = localView.getMeasuredWidth();
        y.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:" + k);
        localView.layout(j, 0, j + k, localView.getMeasuredHeight());
        k = j + k;
      }
      i += 1;
      j = k;
    }
    y.v("MicroMsg.MMFlipper", "use " + bk.cp(l) + " ms, flipper onLayout changed:" + paramBoolean + " Left,Top,Right,Bottom:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    long l = bk.UZ();
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.uUO != null) {
      this.uUO.dH(j, i);
    }
    this.uUP = j;
    this.uUQ = i;
    int k = getChildCount();
    i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    scrollTo(this.uTT * j, 0);
    y.v("MicroMsg.MMFlipper", "flipper onMeasure:" + j + "," + View.MeasureSpec.getSize(paramInt2) + " childCount:" + k + ", use " + bk.cp(l));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getChildCount() == 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
    this.fB.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    switch (i)
    {
    default: 
      return true;
    case 0: 
      if (!this.GB.isFinished()) {
        this.GB.abortAnimation();
      }
      this.GS = f;
      return true;
    case 2: 
      i = (int)(this.GS - f);
      this.GS = f;
      scrollBy(i, 0);
      return true;
    }
    paramMotionEvent = this.fB;
    paramMotionEvent.computeCurrentVelocity(1000);
    i = (int)paramMotionEvent.getXVelocity();
    if ((i > 600) && (this.uTT > 0)) {
      Gl(this.uTT - 1);
    }
    for (;;)
    {
      if (this.fB != null)
      {
        this.fB.recycle();
        this.fB = null;
      }
      this.uTR = 0;
      this.GS = 0.0F;
      this.GT = 0.0F;
      return true;
      if ((i < -600) && (this.uTT < getChildCount() - 1))
      {
        Gl(this.uTT + 1);
      }
      else
      {
        i = getWidth();
        Gl((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setOnMeasureListener(MMFlipper.a parama)
  {
    this.uUO = parama;
  }
  
  public void setOnScreenChangedListener(MMFlipper.b paramb)
  {
    this.uUN = paramb;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.uTW = paramBoolean;
  }
  
  public void setToScreen(int paramInt)
  {
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.uUM = false;
    if (!this.GB.isFinished()) {
      this.GB.abortAnimation();
    }
    if (this.uUN != null) {
      this.uUN.wS(paramInt);
    }
    this.uTU = this.uTT;
    this.uTT = paramInt;
    this.uUK = paramInt;
    scrollTo(paramInt * getWidth(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFlipper
 * JD-Core Version:    0.7.0.1
 */