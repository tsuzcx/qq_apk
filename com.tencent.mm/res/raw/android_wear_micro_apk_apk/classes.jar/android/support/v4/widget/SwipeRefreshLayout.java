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
  private static final int[] kV = { 16842766 };
  private static final String pP = SwipeRefreshLayout.class.getSimpleName();
  private float kk;
  private int kl;
  private boolean lt;
  private int lz = -1;
  private View pQ;
  u pR;
  boolean pS = false;
  private float pT = -1.0F;
  private float pU;
  private final m pV;
  private final j pW;
  private final int[] pX = new int[2];
  private final int[] pY = new int[2];
  private boolean pZ;
  private int qa;
  int qb;
  private float qc;
  boolean qd;
  private boolean qe;
  private final DecelerateInterpolator qf;
  a qg;
  private int qh = -1;
  protected int qi;
  float qj;
  protected int qk;
  int ql;
  c qm;
  private Animation qn;
  private Animation qo;
  private Animation qp;
  private Animation qq;
  boolean qr;
  private int qs;
  boolean qt;
  private t qu;
  private Animation.AnimationListener qv = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (SwipeRefreshLayout.this.pS)
      {
        SwipeRefreshLayout.this.qm.setAlpha(255);
        SwipeRefreshLayout.this.qm.start();
        if ((SwipeRefreshLayout.this.qr) && (SwipeRefreshLayout.this.pR != null)) {
          paramAnonymousAnimation = SwipeRefreshLayout.this.pR;
        }
        SwipeRefreshLayout.this.qb = SwipeRefreshLayout.this.qg.getTop();
        return;
      }
      SwipeRefreshLayout.this.reset();
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public final void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private final Animation qw = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      if (!SwipeRefreshLayout.this.qt) {}
      for (int i = SwipeRefreshLayout.this.ql - Math.abs(SwipeRefreshLayout.this.qk);; i = SwipeRefreshLayout.this.ql)
      {
        int j = SwipeRefreshLayout.this.qi;
        i = (int)((i - SwipeRefreshLayout.this.qi) * paramAnonymousFloat);
        int k = SwipeRefreshLayout.this.qg.getTop();
        SwipeRefreshLayout.this.R(i + j - k);
        SwipeRefreshLayout.this.qm.e(1.0F - paramAnonymousFloat);
        return;
      }
    }
  };
  private final Animation qx = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      SwipeRefreshLayout.this.n(paramAnonymousFloat);
    }
  };
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.kl = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.qa = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.qf = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.qs = ((int)(40.0F * localDisplayMetrics.density));
    this.qg = new a(getContext());
    this.qm = new c(getContext());
    this.qm.bW();
    this.qg.setImageDrawable(this.qm);
    this.qg.setVisibility(8);
    addView(this.qg);
    r.a(this);
    this.ql = ((int)(localDisplayMetrics.density * 64.0F));
    this.pT = this.ql;
    this.pV = new m(this);
    this.pW = new j(this);
    setNestedScrollingEnabled(true);
    int i = -this.qs;
    this.qb = i;
    this.qk = i;
    n(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, kV);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.lz) {
      if (i != 0) {
        break label33;
      }
    }
    label33:
    for (i = 1;; i = 0)
    {
      this.lz = paramMotionEvent.getPointerId(i);
      return;
    }
  }
  
  private static boolean b(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void cr()
  {
    int i;
    if (this.pQ == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.qg)) {
          this.pQ = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private boolean cs()
  {
    if (this.qu != null) {
      return this.qu.ct();
    }
    if ((this.pQ instanceof ListView))
    {
      ListView localListView = (ListView)this.pQ;
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
    return this.pQ.canScrollVertically(-1);
  }
  
  private Animation h(final int paramInt1, final int paramInt2)
  {
    Animation local3 = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.qm.setAlpha((int)(paramInt1 + (paramInt2 - paramInt1) * paramAnonymousFloat));
      }
    };
    local3.setDuration(300L);
    this.qg.setAnimationListener(null);
    this.qg.clearAnimation();
    this.qg.startAnimation(local3);
    return local3;
  }
  
  private void k(float paramFloat)
  {
    this.qm.j(true);
    float f2 = Math.min(1.0F, Math.abs(paramFloat / this.pT));
    float f3 = (float)Math.max(f2 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.pT;
    float f1;
    int i;
    int j;
    if (this.qt)
    {
      f1 = this.ql - this.qk;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f1 * 2.0F) / f1);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.qk;
      j = (int)(f1 * f2 + f1 * f4 * 2.0F);
      if (this.qg.getVisibility() != 0) {
        this.qg.setVisibility(0);
      }
      if (!this.qd)
      {
        this.qg.setScaleX(1.0F);
        this.qg.setScaleY(1.0F);
      }
      if (this.qd) {
        j(Math.min(1.0F, paramFloat / this.pT));
      }
      if (paramFloat >= this.pT) {
        break label329;
      }
      if ((this.qm.getAlpha() > 76) && (!b(this.qo))) {
        this.qo = h(this.qm.getAlpha(), 76);
      }
    }
    for (;;)
    {
      this.qm.f(Math.min(0.8F, f3 * 0.8F));
      this.qm.e(Math.min(1.0F, f3));
      this.qm.g((-0.25F + f3 * 0.4F + f4 * 2.0F) * 0.5F);
      R(j + i - this.qb);
      return;
      f1 = this.ql;
      break;
      label329:
      if ((this.qm.getAlpha() < 255) && (!b(this.qp))) {
        this.qp = h(this.qm.getAlpha(), 255);
      }
    }
  }
  
  private void l(float paramFloat)
  {
    if (paramFloat > this.pT)
    {
      if (this.pS != true)
      {
        this.qr = true;
        cr();
        this.pS = true;
        if (this.pS)
        {
          i = this.qb;
          localObject = this.qv;
          this.qi = i;
          this.qw.reset();
          this.qw.setDuration(200L);
          this.qw.setInterpolator(this.qf);
          if (localObject != null) {
            this.qg.setAnimationListener((Animation.AnimationListener)localObject);
          }
          this.qg.clearAnimation();
          this.qg.startAnimation(this.qw);
        }
      }
      else
      {
        return;
      }
      a(this.qv);
      return;
    }
    this.pS = false;
    this.qm.f(0.0F);
    Object localObject = null;
    if (!this.qd) {
      localObject = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (!SwipeRefreshLayout.this.qd) {
            SwipeRefreshLayout.this.a(null);
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    int i = this.qb;
    if (this.qd)
    {
      this.qi = i;
      this.qj = this.qg.getScaleX();
      this.qq = new Animation()
      {
        public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
        {
          float f1 = SwipeRefreshLayout.this.qj;
          float f2 = -SwipeRefreshLayout.this.qj;
          SwipeRefreshLayout.this.j(f1 + f2 * paramAnonymousFloat);
          SwipeRefreshLayout.this.n(paramAnonymousFloat);
        }
      };
      this.qq.setDuration(150L);
      if (localObject != null) {
        this.qg.setAnimationListener((Animation.AnimationListener)localObject);
      }
      this.qg.clearAnimation();
      this.qg.startAnimation(this.qq);
    }
    for (;;)
    {
      this.qm.j(false);
      return;
      this.qi = i;
      this.qx.reset();
      this.qx.setDuration(200L);
      this.qx.setInterpolator(this.qf);
      if (localObject != null) {
        this.qg.setAnimationListener((Animation.AnimationListener)localObject);
      }
      this.qg.clearAnimation();
      this.qg.startAnimation(this.qx);
    }
  }
  
  private void m(float paramFloat)
  {
    if ((paramFloat - this.qc > this.kl) && (!this.lt))
    {
      this.kk = (this.qc + this.kl);
      this.lt = true;
      this.qm.setAlpha(76);
    }
  }
  
  final void R(int paramInt)
  {
    this.qg.bringToFront();
    r.d(this.qg, paramInt);
    this.qb = this.qg.getTop();
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.qn = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.j(1.0F - paramAnonymousFloat);
      }
    };
    this.qn.setDuration(150L);
    this.qg.setAnimationListener(paramAnimationListener);
    this.qg.clearAnimation();
    this.qg.startAnimation(this.qn);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.pW.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.pW.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.pW.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.pW.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.qh < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.qh;
      }
    } while (paramInt2 < this.qh);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.pV.getNestedScrollAxes();
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.pW.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.pW.isNestedScrollingEnabled();
  }
  
  final void j(float paramFloat)
  {
    this.qg.setScaleX(paramFloat);
    this.qg.setScaleY(paramFloat);
  }
  
  final void n(float paramFloat)
  {
    R(this.qi + (int)((this.qk - this.qi) * paramFloat) - this.qg.getTop());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    cr();
    int i = paramMotionEvent.getActionMasked();
    if ((this.qe) && (i == 0)) {
      this.qe = false;
    }
    if ((!isEnabled()) || (this.qe) || (cs()) || (this.pS) || (this.pZ)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.lt;
      R(this.qk - this.qg.getTop());
      this.lz = paramMotionEvent.getPointerId(0);
      this.lt = false;
      i = paramMotionEvent.findPointerIndex(this.lz);
      if (i < 0) {
        break;
      }
      this.qc = paramMotionEvent.getY(i);
      continue;
      if (this.lz == -1)
      {
        Log.e(pP, "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
      }
      i = paramMotionEvent.findPointerIndex(this.lz);
      if (i < 0) {
        break;
      }
      m(paramMotionEvent.getY(i));
      continue;
      a(paramMotionEvent);
      continue;
      this.lt = false;
      this.lz = -1;
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
      if (this.pQ == null) {
        cr();
      }
    } while (this.pQ == null);
    View localView = this.pQ;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.qg.getMeasuredWidth();
    paramInt3 = this.qg.getMeasuredHeight();
    this.qg.layout(paramInt1 / 2 - paramInt2 / 2, this.qb, paramInt1 / 2 + paramInt2 / 2, this.qb + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.pQ == null) {
      cr();
    }
    if (this.pQ == null) {}
    for (;;)
    {
      return;
      this.pQ.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.qg.measure(View.MeasureSpec.makeMeasureSpec(this.qs, 1073741824), View.MeasureSpec.makeMeasureSpec(this.qs, 1073741824));
      this.qh = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == this.qg)
        {
          this.qh = paramInt1;
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
    if ((paramInt2 > 0) && (this.pU > 0.0F))
    {
      if (paramInt2 <= this.pU) {
        break label141;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.pU);
      this.pU = 0.0F;
    }
    for (;;)
    {
      k(this.pU);
      if ((this.qt) && (paramInt2 > 0) && (this.pU == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.qg.setVisibility(8);
      }
      paramView = this.pX;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      label141:
      this.pU -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.pY);
    paramInt1 = this.pY[1] + paramInt4;
    if ((paramInt1 < 0) && (!cs()))
    {
      float f = this.pU;
      this.pU = (Math.abs(paramInt1) + f);
      k(this.pU);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.pV.w(paramInt);
    startNestedScroll(paramInt & 0x2);
    this.pU = 0.0F;
    this.pZ = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.qe) && (!this.pS) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.pV.bo();
    this.pZ = false;
    if (this.pU > 0.0F)
    {
      l(this.pU);
      this.pU = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.qe) && (i == 0)) {
      this.qe = false;
    }
    if ((!isEnabled()) || (this.qe) || (cs()) || (this.pS) || (this.pZ)) {
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
        this.lz = paramMotionEvent.getPointerId(0);
        this.lt = false;
        continue;
        i = paramMotionEvent.findPointerIndex(this.lz);
        if (i < 0)
        {
          Log.e(pP, "Got ACTION_MOVE event but have an invalid active pointer id.");
          return false;
        }
        f1 = paramMotionEvent.getY(i);
        m(f1);
        if (this.lt)
        {
          f1 = (f1 - this.kk) * 0.5F;
          if (f1 <= 0.0F) {
            break;
          }
          k(f1);
          continue;
          i = paramMotionEvent.getActionIndex();
          if (i < 0)
          {
            Log.e(pP, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
            return false;
          }
          this.lz = paramMotionEvent.getPointerId(i);
          continue;
          a(paramMotionEvent);
        }
      }
    }
    i = paramMotionEvent.findPointerIndex(this.lz);
    if (i < 0)
    {
      Log.e(pP, "Got ACTION_UP event but don't have an active pointer id.");
      return false;
    }
    if (this.lt)
    {
      f1 = paramMotionEvent.getY(i);
      float f2 = this.kk;
      this.lt = false;
      l((f1 - f2) * 0.5F);
    }
    this.lz = -1;
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.pQ instanceof AbsListView))) && ((this.pQ == null) || (r.t(this.pQ)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  final void reset()
  {
    this.qg.clearAnimation();
    this.qm.stop();
    this.qg.setVisibility(8);
    this.qg.getBackground().setAlpha(255);
    this.qm.setAlpha(255);
    if (this.qd) {
      j(0.0F);
    }
    for (;;)
    {
      this.qb = this.qg.getTop();
      return;
      R(this.qk - this.qb);
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
    this.pW.setNestedScrollingEnabled(paramBoolean);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.pW.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    this.pW.stopNestedScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */