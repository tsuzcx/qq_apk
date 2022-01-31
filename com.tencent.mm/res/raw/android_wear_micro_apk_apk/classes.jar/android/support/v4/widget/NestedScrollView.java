package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.i;
import android.support.v4.view.j;
import android.support.v4.view.m;
import android.support.v4.view.r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements i, android.support.v4.view.k
{
  private static final k pm = new k();
  private static final int[] pn = { 16843130 };
  private final Rect kd = new Rect();
  private int kl;
  private VelocityTracker lA;
  private int lB;
  private int lC;
  private boolean lt = false;
  private int lz = -1;
  private long oX;
  private OverScroller oY = new OverScroller(getContext());
  private EdgeEffect oZ;
  private EdgeEffect pa;
  private int pb;
  private boolean pc = true;
  private boolean pd = false;
  private View pe = null;
  private boolean pf;
  private boolean pg = true;
  private final int[] ph = new int[2];
  private final int[] pi = new int[2];
  private int pj;
  private int pk;
  private NestedScrollView.SavedState pl;
  private final m po;
  private final j pp;
  private float pq;
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.kl = localViewConfiguration.getScaledTouchSlop();
    this.lB = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.lC = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, pn, paramInt, 0);
    boolean bool = paramContext.getBoolean(0, false);
    if (bool != this.pf)
    {
      this.pf = bool;
      requestLayout();
    }
    paramContext.recycle();
    this.po = new m(this);
    this.pp = new j(this);
    setNestedScrollingEnabled(true);
    r.a(this, pm);
  }
  
  private boolean M(int paramInt)
  {
    return this.pp.c(2, paramInt);
  }
  
  private void N(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.pg) {
        smoothScrollBy(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private boolean N(View paramView)
  {
    boolean bool = false;
    if (!a(paramView, 0, getHeight())) {
      bool = true;
    }
    return bool;
  }
  
  private void O(View paramView)
  {
    paramView.getDrawingRect(this.kd);
    offsetDescendantRectToMyCoords(paramView, this.kd);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.kd);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  private void P(int paramInt)
  {
    int i = getScrollY();
    if (((i > 0) || (paramInt > 0)) && ((i < cl()) || (paramInt < 0))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!dispatchNestedPreFling(0.0F, paramInt))
      {
        dispatchNestedFling(0.0F, paramInt, bool);
        if (getChildCount() > 0)
        {
          M(1);
          this.oY.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
          this.pk = getScrollY();
          r.f(this);
        }
      }
      return;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.lz) {
      if (i != 0) {
        break label57;
      }
    }
    label57:
    for (i = 1;; i = 0)
    {
      this.pb = ((int)paramMotionEvent.getY(i));
      this.lz = paramMotionEvent.getPointerId(i);
      if (this.lA != null) {
        this.lA.clear();
      }
      return;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getHeight();
    int i1 = getScrollY();
    int i2 = i1 + i;
    int k;
    Object localObject1;
    int m;
    label53:
    Object localObject2;
    int n;
    int i4;
    int j;
    if (paramInt1 == 33)
    {
      k = 1;
      ArrayList localArrayList = getFocusables(2);
      localObject1 = null;
      i = 0;
      int i3 = localArrayList.size();
      m = 0;
      if (m >= i3) {
        break label237;
      }
      localObject2 = (View)localArrayList.get(m);
      n = ((View)localObject2).getTop();
      i4 = ((View)localObject2).getBottom();
      if ((paramInt2 >= i4) || (n >= paramInt3)) {
        break label312;
      }
      if ((paramInt2 >= n) || (i4 >= paramInt3)) {
        break label143;
      }
      j = 1;
      label115:
      if (localObject1 != null) {
        break label149;
      }
      i = j;
      localObject1 = localObject2;
    }
    label143:
    label149:
    label312:
    for (;;)
    {
      m += 1;
      break label53;
      k = 0;
      break;
      j = 0;
      break label115;
      if (((k != 0) && (n < localObject1.getTop())) || ((k == 0) && (i4 > localObject1.getBottom()))) {}
      for (n = 1;; n = 0)
      {
        if (i == 0) {
          break label210;
        }
        if ((j == 0) || (n == 0)) {
          break label312;
        }
        localObject1 = localObject2;
        break;
      }
      label210:
      if (j != 0)
      {
        i = 1;
        localObject1 = localObject2;
      }
      else if (n != 0)
      {
        localObject1 = localObject2;
        continue;
        label237:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this;
        }
        boolean bool;
        if ((paramInt2 >= i1) && (paramInt3 <= i2))
        {
          bool = false;
          if (localObject2 != findFocus()) {
            ((View)localObject2).requestFocus(paramInt1);
          }
          return bool;
        }
        if (k != 0) {
          paramInt2 -= i1;
        }
        for (;;)
        {
          N(paramInt2);
          bool = true;
          break;
          paramInt2 = paramInt3 - i2;
        }
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    return this.pp.a(0, paramInt1, 0, paramInt2, paramArrayOfInt, paramInt3);
  }
  
  private boolean a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    return this.pp.a(0, paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramInt2);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.kd);
    offsetDescendantRectToMyCoords(paramView, this.kd);
    return (this.kd.bottom + paramInt1 >= getScrollY()) && (this.kd.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (a((View)paramView1, paramView2));
  }
  
  private boolean arrowScroll(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int j = (int)(0.5F * getHeight());
    if ((localView2 != null) && (a(localView2, j, getHeight())))
    {
      localView2.getDrawingRect(this.kd);
      offsetDescendantRectToMyCoords(localView2, this.kd);
      N(computeScrollDeltaToGetChildRectOnScreen(this.kd));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()) && (N(localView1)))
      {
        paramInt = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(paramInt);
      }
      return true;
    }
    int i;
    if ((paramInt == 33) && (getScrollY() < j)) {
      i = getScrollY();
    }
    while (i == 0)
    {
      return false;
      i = j;
      if (paramInt == 130)
      {
        i = j;
        if (getChildCount() > 0)
        {
          int k = getChildAt(0).getBottom();
          int m = getScrollY() + getHeight() - getPaddingBottom();
          i = j;
          if (k - m < j) {
            i = k - m;
          }
        }
      }
    }
    if (paramInt == 130) {}
    for (;;)
    {
      N(i);
      break;
      i = -i;
    }
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0)) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (paramInt2 + paramInt1 <= paramInt3);
    return paramInt3 - paramInt2;
  }
  
  private boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool3 = false;
    getOverScrollMode();
    computeHorizontalScrollRange();
    computeHorizontalScrollExtent();
    computeVerticalScrollRange();
    computeVerticalScrollExtent();
    int i = paramInt2 + 0;
    paramInt2 = paramInt3 + paramInt1;
    paramInt3 = paramInt4 + 0;
    boolean bool1;
    if (i > 0)
    {
      paramInt1 = 0;
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      if (paramInt2 > paramInt3)
      {
        bool2 = true;
        paramInt2 = paramInt3;
      }
      for (;;)
      {
        if ((bool2) && (!t(1))) {
          this.oY.springBack(paramInt1, paramInt2, 0, 0, 0, cl());
        }
        onOverScrolled(paramInt1, paramInt2, bool1, bool2);
        if (!bool1)
        {
          bool1 = bool3;
          if (!bool2) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
        if (i >= 0) {
          break label153;
        }
        paramInt1 = 0;
        bool1 = true;
        break;
        if (paramInt2 < 0)
        {
          bool2 = true;
          paramInt2 = 0;
        }
        else
        {
          bool2 = false;
        }
      }
      label153:
      bool1 = false;
      paramInt1 = i;
    }
  }
  
  private void cj()
  {
    if (this.lA == null) {
      this.lA = VelocityTracker.obtain();
    }
  }
  
  private void ck()
  {
    if (this.lA != null)
    {
      this.lA.recycle();
      this.lA = null;
    }
  }
  
  private void cm()
  {
    this.lt = false;
    ck();
    u(0);
    if (this.oZ != null)
    {
      this.oZ.onRelease();
      this.pa.onRelease();
    }
  }
  
  private void cn()
  {
    if (getOverScrollMode() != 2)
    {
      if (this.oZ == null)
      {
        Context localContext = getContext();
        this.oZ = new EdgeEffect(localContext);
        this.pa = new EdgeEffect(localContext);
      }
      return;
    }
    this.oZ = null;
    this.pa = null;
  }
  
  private int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int m = getHeight();
    int i = getScrollY();
    int k = i + m;
    int n = getVerticalFadingEdgeLength();
    int j = i;
    if (paramRect.top > 0) {
      j = i + n;
    }
    i = k;
    if (paramRect.bottom < getChildAt(0).getHeight()) {
      i = k - n;
    }
    if ((paramRect.bottom > i) && (paramRect.top > j)) {
      if (paramRect.height() > m)
      {
        j = paramRect.top - j + 0;
        i = Math.min(j, getChildAt(0).getBottom() - i);
      }
    }
    for (;;)
    {
      return i;
      j = paramRect.bottom - i + 0;
      break;
      if ((paramRect.top < j) && (paramRect.bottom < i))
      {
        if (paramRect.height() > m) {}
        for (i = 0 - (i - paramRect.bottom);; i = 0 - (j - paramRect.top))
        {
          i = Math.max(i, -getScrollY());
          break;
        }
      }
      i = 0;
    }
  }
  
  private boolean fullScroll(int paramInt)
  {
    if (paramInt == 130) {}
    for (int i = 1;; i = 0)
    {
      int j = getHeight();
      this.kd.top = 0;
      this.kd.bottom = j;
      if (i != 0)
      {
        i = getChildCount();
        if (i > 0)
        {
          View localView = getChildAt(i - 1);
          this.kd.bottom = (localView.getBottom() + getPaddingBottom());
          this.kd.top = (this.kd.bottom - j);
        }
      }
      return a(paramInt, this.kd.top, this.kd.bottom);
    }
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.oX > 250L)
    {
      paramInt1 = getHeight();
      int i = getPaddingBottom();
      int j = getPaddingTop();
      i = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i - j));
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, i));
      this.oY.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1);
      r.f(this);
    }
    for (;;)
    {
      this.oX = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.oY.isFinished()) {
        this.oY.abortAnimation();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  private boolean t(int paramInt)
  {
    return this.pp.t(paramInt);
  }
  
  private void u(int paramInt)
  {
    this.pp.u(paramInt);
  }
  
  public final void O(int paramInt)
  {
    smoothScrollBy(0 - getScrollX(), paramInt - getScrollY());
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  final int cl()
  {
    int i = 0;
    if (getChildCount() > 0) {
      i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }
    return i;
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    int j = 0;
    if (this.oY.computeScrollOffset())
    {
      this.oY.getCurrX();
      int m = this.oY.getCurrY();
      int k = m - this.pk;
      int i = k;
      if (a(k, this.pi, null, 1)) {
        i = k - this.pi[1];
      }
      int n;
      if (i != 0)
      {
        k = cl();
        n = getScrollY();
        b(i, getScrollX(), n, k);
        int i1 = getScrollY() - n;
        if (!a(i1, i - i1, null, 1))
        {
          i1 = getOverScrollMode();
          if (i1 != 0)
          {
            i = j;
            if (i1 == 1)
            {
              i = j;
              if (k <= 0) {}
            }
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            cn();
            if ((m > 0) || (n <= 0)) {
              break label185;
            }
            this.oZ.onAbsorb((int)this.oY.getCurrVelocity());
          }
        }
      }
      for (;;)
      {
        this.pk = m;
        r.f(this);
        return;
        label185:
        if ((m >= k) && (n < k)) {
          this.pa.onAbsorb((int)this.oY.getCurrVelocity());
        }
      }
    }
    if (t(1)) {
      u(1);
    }
    this.pk = 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int j = getChildCount();
    int i = getHeight() - getPaddingBottom() - getPaddingTop();
    if (j == 0) {}
    int k;
    int m;
    do
    {
      return i;
      j = getChildAt(0).getBottom();
      k = getScrollY();
      m = Math.max(0, j - i);
      if (k < 0) {
        return j - k;
      }
      i = j;
    } while (k <= m);
    return j + (k - m);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      this.kd.setEmpty();
      View localView = getChildAt(0);
      if (localView == null) {
        break label142;
      }
      i = localView.getHeight();
      if (getHeight() >= i + getPaddingTop() + getPaddingBottom()) {
        break label137;
      }
      i = 1;
      if (i != 0) {
        break label159;
      }
      if ((!isFocused()) || (paramKeyEvent.getKeyCode() == 4)) {
        break label153;
      }
      localView = findFocus();
      paramKeyEvent = localView;
      if (localView == this) {
        paramKeyEvent = null;
      }
      paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
      if ((paramKeyEvent == null) || (paramKeyEvent == this) || (!paramKeyEvent.requestFocus(130))) {
        break label147;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (bool1) {
        bool2 = true;
      }
      return bool2;
      label137:
      i = 0;
      break;
      label142:
      i = 0;
      break;
      label147:
      bool1 = false;
      continue;
      label153:
      bool1 = false;
      continue;
      label159:
      if (paramKeyEvent.getAction() == 0) {}
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = false;
        break;
      case 19: 
        if (!paramKeyEvent.isAltPressed()) {
          bool1 = arrowScroll(33);
        } else {
          bool1 = fullScroll(33);
        }
        break;
      case 20: 
        if (!paramKeyEvent.isAltPressed()) {
          bool1 = arrowScroll(130);
        } else {
          bool1 = fullScroll(130);
        }
        break;
      }
    }
    label280:
    int j;
    label289:
    int k;
    if (paramKeyEvent.isShiftPressed())
    {
      i = 33;
      if (i != 130) {
        break label408;
      }
      j = 1;
      k = getHeight();
      if (j == 0) {
        break label413;
      }
      this.kd.top = (getScrollY() + k);
      j = getChildCount();
      if (j > 0)
      {
        paramKeyEvent = getChildAt(j - 1);
        if (this.kd.top + k > paramKeyEvent.getBottom()) {
          this.kd.top = (paramKeyEvent.getBottom() - k);
        }
      }
    }
    for (;;)
    {
      this.kd.bottom = (k + this.kd.top);
      a(i, this.kd.top, this.kd.bottom);
      break;
      i = 130;
      break label280;
      label408:
      j = 0;
      break label289;
      label413:
      this.kd.top = (getScrollY() - k);
      if (this.kd.top < 0) {
        this.kd.top = 0;
      }
    }
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.pp.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.pp.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.pp.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.pp.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.oZ != null)
    {
      int i = getScrollY();
      int j;
      int k;
      int m;
      if (!this.oZ.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth();
        m = getPaddingLeft();
        int n = getPaddingRight();
        paramCanvas.translate(getPaddingLeft(), Math.min(0, i));
        this.oZ.setSize(k - m - n, getHeight());
        if (this.oZ.draw(paramCanvas)) {
          r.f(this);
        }
        paramCanvas.restoreToCount(j);
      }
      if (!this.pa.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth() - getPaddingLeft() - getPaddingRight();
        m = getHeight();
        paramCanvas.translate(-k + getPaddingLeft(), Math.max(cl(), i) + m);
        paramCanvas.rotate(180.0F, k, 0.0F);
        this.pa.setSize(k, m);
        if (this.pa.draw(paramCanvas)) {
          r.f(this);
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    j = getChildAt(0).getBottom() - getScrollY() - (j - k);
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public int getNestedScrollAxes()
  {
    return this.po.getNestedScrollAxes();
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getScrollY();
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.pp.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.pp.isNestedScrollingEnabled();
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = localMarginLayoutParams.topMargin;
    paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.bottomMargin + paramInt2, 0));
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.pd = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      if (!this.lt)
      {
        float f = paramMotionEvent.getAxisValue(9);
        if (f != 0.0F)
        {
          if (this.pq == 0.0F)
          {
            paramMotionEvent = new TypedValue();
            Context localContext = getContext();
            if (!localContext.getTheme().resolveAttribute(16842829, paramMotionEvent, true)) {
              throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.pq = paramMotionEvent.getDimension(localContext.getResources().getDisplayMetrics());
          }
          int i = (int)(f * this.pq);
          int j = cl();
          int m = getScrollY();
          int k = m - i;
          if (k < 0) {
            i = 0;
          }
          while (i != m)
          {
            super.scrollTo(getScrollX(), i);
            return true;
            i = j;
            if (k <= j) {
              i = k;
            }
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.lt)) {
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return this.lt;
      i = this.lz;
      if (i != -1)
      {
        int j = paramMotionEvent.findPointerIndex(i);
        if (j == -1)
        {
          Log.e("NestedScrollView", "Invalid pointerId=" + i + " in onInterceptTouchEvent");
        }
        else
        {
          i = (int)paramMotionEvent.getY(j);
          if ((Math.abs(i - this.pb) > this.kl) && ((getNestedScrollAxes() & 0x2) == 0))
          {
            this.lt = true;
            this.pb = i;
            cj();
            this.lA.addMovement(paramMotionEvent);
            this.pj = 0;
            paramMotionEvent = getParent();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              continue;
              j = (int)paramMotionEvent.getY();
              i = (int)paramMotionEvent.getX();
              if (getChildCount() > 0)
              {
                int k = getScrollY();
                View localView = getChildAt(0);
                if ((j >= localView.getTop() - k) && (j < localView.getBottom() - k) && (i >= localView.getLeft()) && (i < localView.getRight())) {
                  i = 1;
                }
              }
              for (;;)
              {
                if (i != 0) {
                  break label307;
                }
                this.lt = false;
                ck();
                break;
                i = 0;
                continue;
                i = 0;
              }
              label307:
              this.pb = j;
              this.lz = paramMotionEvent.getPointerId(0);
              if (this.lA == null)
              {
                this.lA = VelocityTracker.obtain();
                label335:
                this.lA.addMovement(paramMotionEvent);
                this.oY.computeScrollOffset();
                if (this.oY.isFinished()) {
                  break label386;
                }
              }
              for (;;)
              {
                this.lt = bool;
                M(0);
                break;
                this.lA.clear();
                break label335;
                label386:
                bool = false;
              }
              this.lt = false;
              this.lz = -1;
              ck();
              if (this.oY.springBack(getScrollX(), getScrollY(), 0, 0, 0, cl())) {
                r.f(this);
              }
              u(0);
              continue;
              a(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pc = false;
    if ((this.pe != null) && (a(this.pe, this))) {
      O(this.pe);
    }
    this.pe = null;
    if (!this.pd)
    {
      if (this.pl != null)
      {
        scrollTo(getScrollX(), this.pl.pr);
        this.pl = null;
      }
      if (getChildCount() <= 0) {
        break label153;
      }
      paramInt1 = getChildAt(0).getMeasuredHeight();
      paramInt1 = Math.max(0, paramInt1 - (paramInt4 - paramInt2 - getPaddingBottom() - getPaddingTop()));
      if (getScrollY() <= paramInt1) {
        break label158;
      }
      scrollTo(getScrollX(), paramInt1);
    }
    for (;;)
    {
      scrollTo(getScrollX(), getScrollY());
      this.pd = true;
      return;
      label153:
      paramInt1 = 0;
      break;
      label158:
      if (getScrollY() < 0) {
        scrollTo(getScrollX(), 0);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.pf) {}
    View localView;
    do
    {
      do
      {
        return;
      } while ((View.MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
      localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
    } while (localView.getMeasuredHeight() >= paramInt2);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      P((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt, null);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getScrollY();
    scrollBy(0, paramInt4);
    paramInt1 = getScrollY() - paramInt1;
    dispatchNestedScroll(0, paramInt1, 0, paramInt4 - paramInt1, null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.po.w(paramInt);
    startNestedScroll(2);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    View localView;
    if (paramInt == 2)
    {
      i = 130;
      if (paramRect != null) {
        break label44;
      }
      localView = FocusFinder.getInstance().findNextFocus(this, null, i);
      label24:
      if (localView != null) {
        break label58;
      }
    }
    label44:
    label58:
    while (N(localView))
    {
      return false;
      i = paramInt;
      if (paramInt != 1) {
        break;
      }
      i = 33;
      break;
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i);
      break label24;
    }
    return localView.requestFocus(i, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof NestedScrollView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (NestedScrollView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.pl = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    NestedScrollView.SavedState localSavedState = new NestedScrollView.SavedState(super.onSaveInstanceState());
    localSavedState.pr = getScrollY();
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView)) {}
    while (!a(localView, 0, paramInt4)) {
      return;
    }
    localView.getDrawingRect(this.kd);
    offsetDescendantRectToMyCoords(localView, this.kd);
    N(computeScrollDeltaToGetChildRectOnScreen(this.kd));
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.po.bo();
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    cj();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.pj = 0;
    }
    localMotionEvent.offsetLocation(0.0F, this.pj);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.lA != null) {
        this.lA.addMovement(localMotionEvent);
      }
      localMotionEvent.recycle();
      bool = true;
      do
      {
        return bool;
      } while (getChildCount() == 0);
      if (!this.oY.isFinished()) {}
      ViewParent localViewParent;
      for (bool = true;; bool = false)
      {
        this.lt = bool;
        if (bool)
        {
          localViewParent = getParent();
          if (localViewParent != null) {
            localViewParent.requestDisallowInterceptTouchEvent(true);
          }
        }
        if (!this.oY.isFinished()) {
          this.oY.abortAnimation();
        }
        this.pb = ((int)paramMotionEvent.getY());
        this.lz = paramMotionEvent.getPointerId(0);
        M(0);
        break;
      }
      int k = paramMotionEvent.findPointerIndex(this.lz);
      if (k == -1)
      {
        Log.e("NestedScrollView", "Invalid pointerId=" + this.lz + " in onTouchEvent");
      }
      else
      {
        int m = (int)paramMotionEvent.getY(k);
        i = this.pb - m;
        int j = i;
        if (a(i, this.pi, this.ph, 0))
        {
          j = i - this.pi[1];
          localMotionEvent.offsetLocation(0.0F, this.ph[1]);
          this.pj += this.ph[1];
        }
        i = j;
        if (!this.lt)
        {
          i = j;
          if (Math.abs(j) > this.kl)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
            this.lt = true;
            if (j <= 0) {
              break label545;
            }
            i = j - this.kl;
          }
        }
        label389:
        if (this.lt)
        {
          this.pb = (m - this.ph[1]);
          int n = getScrollY();
          m = cl();
          j = getOverScrollMode();
          if ((j == 0) || ((j == 1) && (m > 0))) {}
          for (j = 1;; j = 0)
          {
            if ((b(i, 0, getScrollY(), m)) && (!t(0))) {
              this.lA.clear();
            }
            int i1 = getScrollY() - n;
            if (!a(i1, i - i1, this.ph, 0)) {
              break label560;
            }
            this.pb -= this.ph[1];
            localMotionEvent.offsetLocation(0.0F, this.ph[1]);
            this.pj += this.ph[1];
            break;
            label545:
            i = j + this.kl;
            break label389;
          }
          label560:
          if (j != 0)
          {
            cn();
            j = n + i;
            if (j < 0)
            {
              h.a(this.oZ, i / getHeight(), paramMotionEvent.getX(k) / getWidth());
              if (!this.pa.isFinished()) {
                this.pa.onRelease();
              }
            }
            while ((this.oZ != null) && ((!this.oZ.isFinished()) || (!this.pa.isFinished())))
            {
              r.f(this);
              break;
              if (j > m)
              {
                h.a(this.pa, i / getHeight(), 1.0F - paramMotionEvent.getX(k) / getWidth());
                if (!this.oZ.isFinished()) {
                  this.oZ.onRelease();
                }
              }
            }
            paramMotionEvent = this.lA;
            paramMotionEvent.computeCurrentVelocity(1000, this.lC);
            i = (int)paramMotionEvent.getYVelocity(this.lz);
            if (Math.abs(i) > this.lB) {
              P(-i);
            }
            for (;;)
            {
              this.lz = -1;
              cm();
              break;
              if (this.oY.springBack(getScrollX(), getScrollY(), 0, 0, 0, cl())) {
                r.f(this);
              }
            }
            if ((this.lt) && (getChildCount() > 0) && (this.oY.springBack(getScrollX(), getScrollY(), 0, 0, 0, cl()))) {
              r.f(this);
            }
            this.lz = -1;
            cm();
            continue;
            i = paramMotionEvent.getActionIndex();
            this.pb = ((int)paramMotionEvent.getY(i));
            this.lz = paramMotionEvent.getPointerId(i);
            continue;
            a(paramMotionEvent);
            this.pb = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.lz)));
          }
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.pc) {
      O(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.pe = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean) {
          break;
        }
        scrollBy(0, i);
      }
      return bool;
    }
    smoothScrollBy(0, i);
    return bool;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      ck();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.pc = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = b(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
      paramInt2 = b(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.pp.setNestedScrollingEnabled(paramBoolean);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.pp.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    this.pp.stopNestedScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.NestedScrollView
 * JD-Core Version:    0.7.0.1
 */