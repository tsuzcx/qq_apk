package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.j;
import android.support.v4.view.k;
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
  implements android.support.v4.view.i, k
{
  private static final l rc = new l();
  private static final int[] rd = { 16843130 };
  private final Rect ma = new Rect();
  private int mi;
  private boolean np = false;
  private int nv = -1;
  private VelocityTracker nw;
  private int nx;
  private int ny;
  private long qN;
  private OverScroller qO = new OverScroller(getContext());
  private EdgeEffect qP;
  private EdgeEffect qQ;
  private int qR;
  private boolean qS = true;
  private boolean qT = false;
  private View qU = null;
  private boolean qV;
  private boolean qW = true;
  private final int[] qX = new int[2];
  private final int[] qY = new int[2];
  private int qZ;
  private int ra;
  private NestedScrollView.SavedState rb;
  private final m re;
  private final j rf;
  private float rg;
  
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
    this.mi = localViewConfiguration.getScaledTouchSlop();
    this.nx = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.ny = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, rd, paramInt, 0);
    boolean bool = paramContext.getBoolean(0, false);
    if (bool != this.qV)
    {
      this.qV = bool;
      requestLayout();
    }
    paramContext.recycle();
    this.re = new m(this);
    this.rf = new j(this);
    setNestedScrollingEnabled(true);
    r.a(this, rc);
  }
  
  private boolean D(int paramInt)
  {
    return this.rf.D(paramInt);
  }
  
  private void E(int paramInt)
  {
    this.rf.E(paramInt);
  }
  
  private boolean T(View paramView)
  {
    boolean bool = false;
    if (!a(paramView, 0, getHeight())) {
      bool = true;
    }
    return bool;
  }
  
  private void U(View paramView)
  {
    paramView.getDrawingRect(this.ma);
    offsetDescendantRectToMyCoords(paramView, this.ma);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.ma);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  private boolean X(int paramInt)
  {
    return this.rf.c(2, paramInt);
  }
  
  private void Y(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.qW) {
        smoothScrollBy(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private View a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    Object localObject = null;
    int n = localArrayList.size();
    int k = 0;
    int i = 0;
    View localView;
    int m;
    int i1;
    int j;
    if (k < n)
    {
      localView = (View)localArrayList.get(k);
      m = localView.getTop();
      i1 = localView.getBottom();
      if ((paramInt1 >= i1) || (m >= paramInt2)) {
        break label204;
      }
      if ((paramInt1 < m) && (i1 < paramInt2))
      {
        j = 1;
        label87:
        if (localObject != null) {
          break label115;
        }
        i = j;
        localObject = localView;
      }
    }
    label174:
    label204:
    for (;;)
    {
      k += 1;
      break;
      j = 0;
      break label87;
      label115:
      if (((paramBoolean) && (m < localObject.getTop())) || ((!paramBoolean) && (i1 > localObject.getBottom()))) {}
      for (m = 1;; m = 0)
      {
        if (i == 0) {
          break label174;
        }
        if ((j == 0) || (m == 0)) {
          break label204;
        }
        localObject = localView;
        break;
      }
      if (j != 0)
      {
        i = 1;
        localObject = localView;
      }
      else if (m != 0)
      {
        localObject = localView;
        continue;
        return localObject;
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    int j = getHeight();
    int i = getScrollY();
    j = i + j;
    if (paramInt1 == 33) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, paramInt2, paramInt3);
      Object localObject = localView;
      if (localView == null) {
        localObject = this;
      }
      if ((paramInt2 < i) || (paramInt3 > j)) {
        break;
      }
      bool1 = bool2;
      if (localObject != findFocus()) {
        ((View)localObject).requestFocus(paramInt1);
      }
      return bool1;
    }
    if (bool1) {
      paramInt2 -= i;
    }
    for (;;)
    {
      Y(paramInt2);
      bool1 = true;
      break;
      paramInt2 = paramInt3 - j;
    }
  }
  
  private boolean a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    return this.rf.a(0, paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramInt2);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.ma);
    offsetDescendantRectToMyCoords(paramView, this.ma);
    return (this.ma.bottom + paramInt1 >= getScrollY()) && (this.ma.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (a((View)paramView1, paramView2));
  }
  
  private void aa(int paramInt)
  {
    int i = getScrollY();
    if (((i > 0) || (paramInt > 0)) && ((i < cq()) || (paramInt < 0))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!dispatchNestedPreFling(0.0F, paramInt))
      {
        dispatchNestedFling(0.0F, paramInt, bool);
        fling(paramInt);
      }
      return;
    }
  }
  
  private boolean arrowScroll(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int j = getMaxScrollAmount();
    if ((localView2 != null) && (a(localView2, j, getHeight())))
    {
      localView2.getDrawingRect(this.ma);
      offsetDescendantRectToMyCoords(localView2, this.ma);
      Y(computeScrollDeltaToGetChildRectOnScreen(this.ma));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()) && (T(localView1)))
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
      Y(i);
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
  
  private void b(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.nv) {
      if (i != 0) {
        break label57;
      }
    }
    label57:
    for (i = 1;; i = 0)
    {
      this.qR = ((int)paramMotionEvent.getY(i));
      this.nv = paramMotionEvent.getPointerId(i);
      if (this.nw != null) {
        this.nw.clear();
      }
      return;
    }
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
        if ((bool2) && (!D(1))) {
          this.qO.springBack(paramInt1, paramInt2, 0, 0, 0, cq());
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
  
  private boolean b(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    return this.rf.a(0, paramInt1, 0, paramInt2, paramArrayOfInt, paramInt3);
  }
  
  private void bT()
  {
    this.np = false;
    cp();
    E(0);
    if (this.qP != null)
    {
      this.qP.onRelease();
      this.qQ.onRelease();
    }
  }
  
  private void co()
  {
    if (this.nw == null) {
      this.nw = VelocityTracker.obtain();
    }
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
  
  private void cp()
  {
    if (this.nw != null)
    {
      this.nw.recycle();
      this.nw = null;
    }
  }
  
  private void cr()
  {
    if (getOverScrollMode() != 2)
    {
      if (this.qP == null)
      {
        Context localContext = getContext();
        this.qP = new EdgeEffect(localContext);
        this.qQ = new EdgeEffect(localContext);
      }
      return;
    }
    this.qP = null;
    this.qQ = null;
  }
  
  private void fling(int paramInt)
  {
    if (getChildCount() > 0)
    {
      X(1);
      this.qO.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      this.ra = getScrollY();
      r.g(this);
    }
  }
  
  private boolean fullScroll(int paramInt)
  {
    if (paramInt == 130) {}
    for (int i = 1;; i = 0)
    {
      int j = getHeight();
      this.ma.top = 0;
      this.ma.bottom = j;
      if (i != 0)
      {
        i = getChildCount();
        if (i > 0)
        {
          View localView = getChildAt(i - 1);
          this.ma.bottom = (localView.getBottom() + getPaddingBottom());
          this.ma.top = (this.ma.bottom - j);
        }
      }
      return a(paramInt, this.ma.top, this.ma.bottom);
    }
  }
  
  private int getMaxScrollAmount()
  {
    return (int)(0.5F * getHeight());
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.qN > 250L)
    {
      paramInt1 = getHeight();
      int i = getPaddingBottom();
      int j = getPaddingTop();
      i = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i - j));
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, i));
      this.qO.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1);
      r.g(this);
    }
    for (;;)
    {
      this.qN = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.qO.isFinished()) {
        this.qO.abortAnimation();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  public final void Z(int paramInt)
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
    if (this.qO.computeScrollOffset())
    {
      this.qO.getCurrX();
      int m = this.qO.getCurrY();
      int k = m - this.ra;
      int i = k;
      if (a(k, this.qY, null, 1)) {
        i = k - this.qY[1];
      }
      int n;
      if (i != 0)
      {
        k = cq();
        n = getScrollY();
        b(i, getScrollX(), n, k);
        int i1 = getScrollY() - n;
        if (!b(i1, i - i1, null, 1))
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
            cr();
            if ((m > 0) || (n <= 0)) {
              break label185;
            }
            this.qP.onAbsorb((int)this.qO.getCurrVelocity());
          }
        }
      }
      for (;;)
      {
        this.ra = m;
        r.g(this);
        return;
        label185:
        if ((m >= k) && (n < k)) {
          this.qQ.onAbsorb((int)this.qO.getCurrVelocity());
        }
      }
    }
    if (D(1)) {
      E(1);
    }
    this.ra = 0;
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
  
  final int cq()
  {
    int i = 0;
    if (getChildCount() > 0) {
      i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }
    return i;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      this.ma.setEmpty();
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
      this.ma.top = (getScrollY() + k);
      j = getChildCount();
      if (j > 0)
      {
        paramKeyEvent = getChildAt(j - 1);
        if (this.ma.top + k > paramKeyEvent.getBottom()) {
          this.ma.top = (paramKeyEvent.getBottom() - k);
        }
      }
    }
    for (;;)
    {
      this.ma.bottom = (k + this.ma.top);
      a(i, this.ma.top, this.ma.bottom);
      break;
      i = 130;
      break label280;
      label408:
      j = 0;
      break label289;
      label413:
      this.ma.top = (getScrollY() - k);
      if (this.ma.top < 0) {
        this.ma.top = 0;
      }
    }
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.rf.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.rf.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.rf.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.rf.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int n = 0;
    super.draw(paramCanvas);
    int i3;
    int i4;
    int j;
    int i2;
    int i1;
    if (this.qP != null)
    {
      i3 = getScrollY();
      if (!this.qP.isFinished())
      {
        i4 = paramCanvas.save();
        j = getWidth();
        i2 = getHeight();
        i1 = Math.min(0, i3);
        if ((Build.VERSION.SDK_INT >= 21) && (!getClipToPadding())) {
          break label374;
        }
        j -= getPaddingLeft() + getPaddingRight();
      }
    }
    label374:
    for (int i = getPaddingLeft() + 0;; i = 0)
    {
      int m = i1;
      int k = i2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        m = i1;
        k = i2;
        if (getClipToPadding())
        {
          k = i2 - (getPaddingTop() + getPaddingBottom());
          m = i1 + getPaddingTop();
        }
      }
      paramCanvas.translate(i, m);
      this.qP.setSize(j, k);
      if (this.qP.draw(paramCanvas)) {
        r.g(this);
      }
      paramCanvas.restoreToCount(i4);
      if (!this.qQ.isFinished())
      {
        i4 = paramCanvas.save();
        k = getWidth();
        i1 = getHeight();
        i2 = Math.max(cq(), i3) + i1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          i = k;
          j = n;
          if (!getClipToPadding()) {}
        }
        else
        {
          i = k - (getPaddingLeft() + getPaddingRight());
          j = getPaddingLeft() + 0;
        }
        m = i2;
        k = i1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          m = i2;
          k = i1;
          if (getClipToPadding())
          {
            k = i1 - (getPaddingTop() + getPaddingBottom());
            m = i2 - getPaddingBottom();
          }
        }
        paramCanvas.translate(j - i, m);
        paramCanvas.rotate(180.0F, i, 0.0F);
        this.qQ.setSize(i, k);
        if (this.qQ.draw(paramCanvas)) {
          r.g(this);
        }
        paramCanvas.restoreToCount(i4);
      }
      return;
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
    return this.re.getNestedScrollAxes();
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
    return this.rf.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.rf.isNestedScrollingEnabled();
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
    this.qT = false;
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
      if (!this.np)
      {
        float f = paramMotionEvent.getAxisValue(9);
        if (f != 0.0F)
        {
          if (this.rg == 0.0F)
          {
            paramMotionEvent = new TypedValue();
            Context localContext = getContext();
            if (!localContext.getTheme().resolveAttribute(16842829, paramMotionEvent, true)) {
              throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.rg = paramMotionEvent.getDimension(localContext.getResources().getDisplayMetrics());
          }
          int i = (int)(f * this.rg);
          int j = cq();
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
    if ((i == 2) && (this.np)) {
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return this.np;
      i = this.nv;
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
          if ((Math.abs(i - this.qR) > this.mi) && ((getNestedScrollAxes() & 0x2) == 0))
          {
            this.np = true;
            this.qR = i;
            co();
            this.nw.addMovement(paramMotionEvent);
            this.qZ = 0;
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
                this.np = false;
                cp();
                break;
                i = 0;
                continue;
                i = 0;
              }
              label307:
              this.qR = j;
              this.nv = paramMotionEvent.getPointerId(0);
              if (this.nw == null)
              {
                this.nw = VelocityTracker.obtain();
                label335:
                this.nw.addMovement(paramMotionEvent);
                this.qO.computeScrollOffset();
                if (this.qO.isFinished()) {
                  break label386;
                }
              }
              for (;;)
              {
                this.np = bool;
                X(0);
                break;
                this.nw.clear();
                break label335;
                label386:
                bool = false;
              }
              this.np = false;
              this.nv = -1;
              cp();
              if (this.qO.springBack(getScrollX(), getScrollY(), 0, 0, 0, cq())) {
                r.g(this);
              }
              E(0);
              continue;
              b(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.qS = false;
    if ((this.qU != null) && (a(this.qU, this))) {
      U(this.qU);
    }
    this.qU = null;
    if (!this.qT)
    {
      if (this.rb != null)
      {
        scrollTo(getScrollX(), this.rb.rh);
        this.rb = null;
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
      this.qT = true;
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
    if (!this.qV) {}
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
      aa((int)paramFloat2);
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
    this.re.G(paramInt);
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
    while (T(localView))
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
    this.rb = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    NestedScrollView.SavedState localSavedState = new NestedScrollView.SavedState(super.onSaveInstanceState());
    localSavedState.rh = getScrollY();
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
    localView.getDrawingRect(this.ma);
    offsetDescendantRectToMyCoords(localView, this.ma);
    Y(computeScrollDeltaToGetChildRectOnScreen(this.ma));
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.re.bE();
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    co();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.qZ = 0;
    }
    localMotionEvent.offsetLocation(0.0F, this.qZ);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.nw != null) {
        this.nw.addMovement(localMotionEvent);
      }
      localMotionEvent.recycle();
      bool = true;
      do
      {
        return bool;
      } while (getChildCount() == 0);
      if (!this.qO.isFinished()) {}
      ViewParent localViewParent;
      for (bool = true;; bool = false)
      {
        this.np = bool;
        if (bool)
        {
          localViewParent = getParent();
          if (localViewParent != null) {
            localViewParent.requestDisallowInterceptTouchEvent(true);
          }
        }
        if (!this.qO.isFinished()) {
          this.qO.abortAnimation();
        }
        this.qR = ((int)paramMotionEvent.getY());
        this.nv = paramMotionEvent.getPointerId(0);
        X(0);
        break;
      }
      int k = paramMotionEvent.findPointerIndex(this.nv);
      if (k == -1)
      {
        Log.e("NestedScrollView", "Invalid pointerId=" + this.nv + " in onTouchEvent");
      }
      else
      {
        int m = (int)paramMotionEvent.getY(k);
        i = this.qR - m;
        int j = i;
        if (a(i, this.qY, this.qX, 0))
        {
          j = i - this.qY[1];
          localMotionEvent.offsetLocation(0.0F, this.qX[1]);
          this.qZ += this.qX[1];
        }
        i = j;
        if (!this.np)
        {
          i = j;
          if (Math.abs(j) > this.mi)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
            this.np = true;
            if (j <= 0) {
              break label545;
            }
            i = j - this.mi;
          }
        }
        label389:
        if (this.np)
        {
          this.qR = (m - this.qX[1]);
          int n = getScrollY();
          m = cq();
          j = getOverScrollMode();
          if ((j == 0) || ((j == 1) && (m > 0))) {}
          for (j = 1;; j = 0)
          {
            if ((b(i, 0, getScrollY(), m)) && (!D(0))) {
              this.nw.clear();
            }
            int i1 = getScrollY() - n;
            if (!b(i1, i - i1, this.qX, 0)) {
              break label560;
            }
            this.qR -= this.qX[1];
            localMotionEvent.offsetLocation(0.0F, this.qX[1]);
            this.qZ += this.qX[1];
            break;
            label545:
            i = j + this.mi;
            break label389;
          }
          label560:
          if (j != 0)
          {
            cr();
            j = n + i;
            if (j < 0)
            {
              i.a(this.qP, i / getHeight(), paramMotionEvent.getX(k) / getWidth());
              if (!this.qQ.isFinished()) {
                this.qQ.onRelease();
              }
            }
            while ((this.qP != null) && ((!this.qP.isFinished()) || (!this.qQ.isFinished())))
            {
              r.g(this);
              break;
              if (j > m)
              {
                i.a(this.qQ, i / getHeight(), 1.0F - paramMotionEvent.getX(k) / getWidth());
                if (!this.qP.isFinished()) {
                  this.qP.onRelease();
                }
              }
            }
            paramMotionEvent = this.nw;
            paramMotionEvent.computeCurrentVelocity(1000, this.ny);
            i = (int)paramMotionEvent.getYVelocity(this.nv);
            if (Math.abs(i) > this.nx) {
              aa(-i);
            }
            for (;;)
            {
              this.nv = -1;
              bT();
              break;
              if (this.qO.springBack(getScrollX(), getScrollY(), 0, 0, 0, cq())) {
                r.g(this);
              }
            }
            if ((this.np) && (getChildCount() > 0) && (this.qO.springBack(getScrollX(), getScrollY(), 0, 0, 0, cq()))) {
              r.g(this);
            }
            this.nv = -1;
            bT();
            continue;
            i = paramMotionEvent.getActionIndex();
            this.qR = ((int)paramMotionEvent.getY(i));
            this.nv = paramMotionEvent.getPointerId(i);
            continue;
            b(paramMotionEvent);
            this.qR = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.nv)));
          }
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.qS) {
      U(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.qU = paramView2;
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
      cp();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.qS = true;
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
    this.rf.setNestedScrollingEnabled(paramBoolean);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.rf.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    this.rf.stopNestedScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.NestedScrollView
 * JD-Core Version:    0.7.0.1
 */