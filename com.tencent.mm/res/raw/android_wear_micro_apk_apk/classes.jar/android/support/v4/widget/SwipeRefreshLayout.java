package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.h;
import android.support.v4.view.j;
import android.support.v4.view.k;
import android.support.v4.view.m;
import android.support.v4.view.r;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;

public class SwipeRefreshLayout
  extends ViewGroup
  implements h, k
{
  private static final int[] mR = { 16842766 };
  private static final String rF = SwipeRefreshLayout.class.getSimpleName();
  private final m bc;
  private float mh;
  private int mi;
  private boolean np;
  private int nv = -1;
  private View rG;
  boolean rH = false;
  private float rI = -1.0F;
  private float rJ;
  private final j rK;
  private final int[] rL = new int[2];
  private final int[] rM = new int[2];
  private boolean rN;
  private int rO;
  int rP;
  private float rQ;
  boolean rR;
  private boolean rS;
  private final DecelerateInterpolator rT;
  a rU;
  private int rV = -1;
  protected int rW;
  float rX;
  protected int rY;
  int rZ;
  c sa;
  private Animation sb;
  private Animation sc;
  private Animation sd;
  private Animation se;
  boolean sf;
  private int sg;
  boolean sh;
  private u si;
  private Animation.AnimationListener sj = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (SwipeRefreshLayout.this.rH)
      {
        SwipeRefreshLayout.this.sa.setAlpha(255);
        SwipeRefreshLayout.this.sa.start();
        SwipeRefreshLayout.this.rP = SwipeRefreshLayout.this.rU.getTop();
        return;
      }
      SwipeRefreshLayout.this.reset();
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public final void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private final Animation sk = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      if (!SwipeRefreshLayout.this.sh) {}
      for (int i = SwipeRefreshLayout.this.rZ - Math.abs(SwipeRefreshLayout.this.rY);; i = SwipeRefreshLayout.this.rZ)
      {
        int j = SwipeRefreshLayout.this.rW;
        i = (int)((i - SwipeRefreshLayout.this.rW) * paramAnonymousFloat);
        int k = SwipeRefreshLayout.this.rU.getTop();
        SwipeRefreshLayout.this.ac(i + j - k);
        SwipeRefreshLayout.this.sa.f(1.0F - paramAnonymousFloat);
        return;
      }
    }
  };
  private final Animation sl = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      SwipeRefreshLayout.this.o(paramAnonymousFloat);
    }
  };
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mi = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.rO = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.rT = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.sg = ((int)(40.0F * localDisplayMetrics.density));
    this.rU = new a(getContext());
    this.sa = new c(getContext());
    this.sa.ca();
    this.rU.setImageDrawable(this.sa);
    this.rU.setVisibility(8);
    addView(this.rU);
    setChildrenDrawingOrderEnabled(true);
    this.rZ = ((int)(localDisplayMetrics.density * 64.0F));
    this.rI = this.rZ;
    this.bc = new m(this);
    this.rK = new j(this);
    setNestedScrollingEnabled(true);
    int i = -this.sg;
    this.rP = i;
    this.rY = i;
    o(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, mR);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.rR)
    {
      b(paramInt, paramAnimationListener);
      return;
    }
    this.rW = paramInt;
    this.sl.reset();
    this.sl.setDuration(200L);
    this.sl.setInterpolator(this.rT);
    if (paramAnimationListener != null) {
      this.rU.setAnimationListener(paramAnimationListener);
    }
    this.rU.clearAnimation();
    this.rU.startAnimation(this.sl);
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.rW = paramInt;
    this.rX = this.rU.getScaleX();
    this.se = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f1 = SwipeRefreshLayout.this.rX;
        float f2 = -SwipeRefreshLayout.this.rX;
        SwipeRefreshLayout.this.k(f1 + f2 * paramAnonymousFloat);
        SwipeRefreshLayout.this.o(paramAnonymousFloat);
      }
    };
    this.se.setDuration(150L);
    if (paramAnimationListener != null) {
      this.rU.setAnimationListener(paramAnimationListener);
    }
    this.rU.clearAnimation();
    this.rU.startAnimation(this.se);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.nv) {
      if (i != 0) {
        break label33;
      }
    }
    label33:
    for (i = 1;; i = 0)
    {
      this.nv = paramMotionEvent.getPointerId(i);
      return;
    }
  }
  
  private static boolean b(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void cv()
  {
    if (this.rH != true)
    {
      this.sf = true;
      cy();
      this.rH = true;
      if (this.rH)
      {
        int i = this.rP;
        Animation.AnimationListener localAnimationListener = this.sj;
        this.rW = i;
        this.sk.reset();
        this.sk.setDuration(200L);
        this.sk.setInterpolator(this.rT);
        if (localAnimationListener != null) {
          this.rU.setAnimationListener(localAnimationListener);
        }
        this.rU.clearAnimation();
        this.rU.startAnimation(this.sk);
      }
    }
    else
    {
      return;
    }
    a(this.sj);
  }
  
  private void cw()
  {
    this.sc = i(this.sa.getAlpha(), 76);
  }
  
  private void cx()
  {
    this.sd = i(this.sa.getAlpha(), 255);
  }
  
  private void cy()
  {
    int i;
    if (this.rG == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.rU)) {
          this.rG = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private boolean cz()
  {
    if (this.si != null) {
      return this.si.cA();
    }
    if ((this.rG instanceof ListView))
    {
      ListView localListView = (ListView)this.rG;
      if (Build.VERSION.SDK_INT >= 19) {
        return localListView.canScrollList(-1);
      }
      if (localListView.getChildCount() != 0)
      {
        int i = localListView.getFirstVisiblePosition();
        int j = localListView.getChildAt(0).getTop();
        if ((i > 0) || (j < localListView.getListPaddingTop())) {
          return true;
        }
      }
      return false;
    }
    return this.rG.canScrollVertically(-1);
  }
  
  private Animation i(final int paramInt1, final int paramInt2)
  {
    Animation local3 = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.sa.setAlpha((int)(paramInt1 + (paramInt2 - paramInt1) * paramAnonymousFloat));
      }
    };
    local3.setDuration(300L);
    this.rU.setAnimationListener(null);
    this.rU.clearAnimation();
    this.rU.startAnimation(local3);
    return local3;
  }
  
  private void l(float paramFloat)
  {
    this.sa.m(true);
    float f2 = Math.min(1.0F, Math.abs(paramFloat / this.rI));
    float f3 = Math.max((float)(f2 - 0.4D), 0.0F) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.rI;
    float f1;
    int i;
    int j;
    if (this.sh)
    {
      f1 = this.rZ - this.rY;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f1 * 2.0F) / f1);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.rY;
      j = (int)(f1 * f2 + f1 * f4 * 2.0F);
      if (this.rU.getVisibility() != 0) {
        this.rU.setVisibility(0);
      }
      if (!this.rR)
      {
        this.rU.setScaleX(1.0F);
        this.rU.setScaleY(1.0F);
      }
      if (this.rR) {
        k(Math.min(1.0F, paramFloat / this.rI));
      }
      if (paramFloat >= this.rI) {
        break label316;
      }
      if ((this.sa.getAlpha() > 76) && (!b(this.sc))) {
        cw();
      }
    }
    for (;;)
    {
      this.sa.g(Math.min(0.8F, f3 * 0.8F));
      this.sa.f(Math.min(1.0F, f3));
      this.sa.h((-0.25F + f3 * 0.4F + f4 * 2.0F) * 0.5F);
      ac(j + i - this.rP);
      return;
      f1 = this.rZ;
      break;
      label316:
      if ((this.sa.getAlpha() < 255) && (!b(this.sd))) {
        cx();
      }
    }
  }
  
  private void m(float paramFloat)
  {
    if (paramFloat > this.rI)
    {
      cv();
      return;
    }
    this.rH = false;
    this.sa.g(0.0F);
    Animation.AnimationListener local4 = null;
    if (!this.rR) {
      local4 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (!SwipeRefreshLayout.this.rR) {
            SwipeRefreshLayout.this.a(null);
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    a(this.rP, local4);
    this.sa.m(false);
  }
  
  private void n(float paramFloat)
  {
    if ((paramFloat - this.rQ > this.mi) && (!this.np))
    {
      this.mh = (this.rQ + this.mi);
      this.np = true;
      this.sa.setAlpha(76);
    }
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.sb = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.k(1.0F - paramAnonymousFloat);
      }
    };
    this.sb.setDuration(150L);
    this.rU.setAnimationListener(paramAnimationListener);
    this.rU.clearAnimation();
    this.rU.startAnimation(this.sb);
  }
  
  final void ac(int paramInt)
  {
    this.rU.bringToFront();
    r.g(this.rU, paramInt);
    this.rP = this.rU.getTop();
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.rK.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.rK.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.rK.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.rK.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.rV < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.rV;
      }
    } while (paramInt2 < this.rV);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.bc.getNestedScrollAxes();
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.rK.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.rK.isNestedScrollingEnabled();
  }
  
  final void k(float paramFloat)
  {
    this.rU.setScaleX(paramFloat);
    this.rU.setScaleY(paramFloat);
  }
  
  final void o(float paramFloat)
  {
    ac(this.rW + (int)((this.rY - this.rW) * paramFloat) - this.rU.getTop());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    cy();
    int i = paramMotionEvent.getActionMasked();
    if ((this.rS) && (i == 0)) {
      this.rS = false;
    }
    if ((!isEnabled()) || (this.rS) || (cz()) || (this.rH) || (this.rN)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.np;
      ac(this.rY - this.rU.getTop());
      this.nv = paramMotionEvent.getPointerId(0);
      this.np = false;
      i = paramMotionEvent.findPointerIndex(this.nv);
      if (i < 0) {
        break;
      }
      this.rQ = paramMotionEvent.getY(i);
      continue;
      if (this.nv == -1)
      {
        Log.e(rF, "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
      }
      i = paramMotionEvent.findPointerIndex(this.nv);
      if (i < 0) {
        break;
      }
      n(paramMotionEvent.getY(i));
      continue;
      b(paramMotionEvent);
      continue;
      this.np = false;
      this.nv = -1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {}
    do
    {
      return;
      if (this.rG == null) {
        cy();
      }
    } while (this.rG == null);
    View localView = this.rG;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.rU.getMeasuredWidth();
    paramInt3 = this.rU.getMeasuredHeight();
    this.rU.layout(paramInt1 / 2 - paramInt2 / 2, this.rP, paramInt1 / 2 + paramInt2 / 2, this.rP + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.rG == null) {
      cy();
    }
    if (this.rG == null) {}
    for (;;)
    {
      return;
      this.rG.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.rU.measure(View.MeasureSpec.makeMeasureSpec(this.sg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.sg, 1073741824));
      this.rV = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == this.rU)
        {
          this.rV = paramInt1;
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramInt2 > 0) && (this.rJ > 0.0F))
    {
      if (paramInt2 <= this.rJ) {
        break label141;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.rJ);
      this.rJ = 0.0F;
    }
    for (;;)
    {
      l(this.rJ);
      if ((this.sh) && (paramInt2 > 0) && (this.rJ == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.rU.setVisibility(8);
      }
      paramView = this.rL;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      label141:
      this.rJ -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.rM);
    paramInt1 = this.rM[1] + paramInt4;
    if ((paramInt1 < 0) && (!cz()))
    {
      float f = this.rJ;
      this.rJ = (Math.abs(paramInt1) + f);
      l(this.rJ);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.bc.G(paramInt);
    startNestedScroll(paramInt & 0x2);
    this.rJ = 0.0F;
    this.rN = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.rS) && (!this.rH) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.bc.bE();
    this.rN = false;
    if (this.rJ > 0.0F)
    {
      m(this.rJ);
      this.rJ = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.rS) && (i == 0)) {
      this.rS = false;
    }
    if ((!isEnabled()) || (this.rS) || (cz()) || (this.rH) || (this.rN)) {
      return false;
    }
    float f1;
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      for (;;)
      {
        return true;
        this.nv = paramMotionEvent.getPointerId(0);
        this.np = false;
        continue;
        i = paramMotionEvent.findPointerIndex(this.nv);
        if (i < 0)
        {
          Log.e(rF, "Got ACTION_MOVE event but have an invalid active pointer id.");
          return false;
        }
        f1 = paramMotionEvent.getY(i);
        n(f1);
        if (this.np)
        {
          f1 = (f1 - this.mh) * 0.5F;
          if (f1 <= 0.0F) {
            break;
          }
          l(f1);
          continue;
          i = paramMotionEvent.getActionIndex();
          if (i < 0)
          {
            Log.e(rF, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
            return false;
          }
          this.nv = paramMotionEvent.getPointerId(i);
          continue;
          b(paramMotionEvent);
        }
      }
    }
    i = paramMotionEvent.findPointerIndex(this.nv);
    if (i < 0)
    {
      Log.e(rF, "Got ACTION_UP event but don't have an active pointer id.");
      return false;
    }
    if (this.np)
    {
      f1 = paramMotionEvent.getY(i);
      float f2 = this.mh;
      this.np = false;
      m((f1 - f2) * 0.5F);
    }
    this.nv = -1;
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.rG instanceof AbsListView))) && ((this.rG == null) || (r.v(this.rG)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  final void reset()
  {
    this.rU.clearAnimation();
    this.sa.stop();
    this.rU.setVisibility(8);
    this.rU.getBackground().setAlpha(255);
    this.sa.setAlpha(255);
    if (this.rR) {
      k(0.0F);
    }
    for (;;)
    {
      this.rP = this.rU.getTop();
      return;
      ac(this.rY - this.rP);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {
      reset();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.rK.setNestedScrollingEnabled(paramBoolean);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.rK.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    this.rK.stopNestedScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */