package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.d;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.d;
import android.support.v4.view.a;
import android.support.v4.view.a.e;
import android.support.v4.view.q;
import android.support.v4.view.t;
import android.support.v4.view.u;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import junit.framework.Assert;

public class AdLandingViewPager
  extends ViewGroup
{
  private static final Comparator<b> COMPARATOR;
  private static final int[] LAYOUT_ATTRS;
  private static final Interpolator sInterpolator;
  private static final f yrp;
  int mActivePointerId;
  private q mAdapter;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  private int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable;
  private int mExpectedAdapterCount;
  long mFakeDragBeginTime;
  boolean mFakeDragging;
  private boolean mFirstLayout;
  private float mFirstOffset;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mInLayout;
  float mInitialMotionX;
  private float mInitialMotionY;
  private ViewPager.OnPageChangeListener mInternalPageChangeListener;
  boolean mIsBeingDragged;
  private boolean mIsUnableToDrag;
  private final ArrayList<b> mItems;
  float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset;
  private i mLeftEdge;
  private Drawable mMarginDrawable;
  int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets;
  private int mOffscreenPageLimit;
  private ViewPager.OnPageChangeListener mOnPageChangeListener;
  private int mPageMargin;
  ViewPager.d mPageTransformer;
  boolean mPopulatePending;
  private Parcelable mRestoredAdapterState;
  private ClassLoader mRestoredClassLoader;
  private int mRestoredCurItem;
  private i mRightEdge;
  private int mScrollState;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private Method mSetChildrenDrawingOrderEnabled;
  private final Rect mTempRect;
  private int mTopPageBounds;
  private int mTouchSlop;
  VelocityTracker mVelocityTracker;
  private final b yrm;
  private e yrn;
  private d yro;
  
  static
  {
    AppMethodBeat.i(97050);
    LAYOUT_ATTRS = new int[] { 16842931 };
    COMPARATOR = new Comparator() {};
    sInterpolator = new AdLandingViewPager.2();
    yrp = new f();
    AppMethodBeat.o(97050);
  }
  
  public AdLandingViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96980);
    this.mItems = new ArrayList();
    this.yrm = new b();
    this.mTempRect = new Rect();
    this.mRestoredCurItem = -1;
    this.mRestoredAdapterState = null;
    this.mRestoredClassLoader = null;
    this.mFirstOffset = -3.402824E+038F;
    this.mLastOffset = 3.4028235E+38F;
    this.mOffscreenPageLimit = 1;
    this.mActivePointerId = -1;
    this.mFirstLayout = true;
    this.mNeedCalculatePageOffsets = false;
    this.mEndScrollRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96966);
        AdLandingViewPager.a(AdLandingViewPager.this);
        AdLandingViewPager.this.populate();
        AppMethodBeat.o(96966);
      }
    };
    this.mScrollState = 0;
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    paramContext = getContext();
    this.mScroller = new Scroller(paramContext, sInterpolator);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = u.a(paramAttributeSet);
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = paramAttributeSet.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new i(paramContext);
    this.mRightEdge = new i(paramContext);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(16.0F * f));
    t.a(this, new c());
    if (t.X(this) == 0) {
      t.p(this, 1);
    }
    AppMethodBeat.o(96980);
  }
  
  private b OT(int paramInt)
  {
    AppMethodBeat.i(97012);
    int i = 0;
    while (i < this.mItems.size())
    {
      b localb = (b)this.mItems.get(i);
      if (localb.position == paramInt)
      {
        AppMethodBeat.o(97012);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(97012);
    return null;
  }
  
  private void a(b paramb1, int paramInt, b paramb2)
  {
    AppMethodBeat.i(97005);
    int m = this.mAdapter.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramb2 == null) {
        break label415;
      }
      i = paramb2.position;
      if (i < paramb1.position)
      {
        f1 = paramb2.offset + paramb2.widthFactor + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramb1.position) || (j >= this.mItems.size())) {
          break label415;
        }
        for (paramb2 = (b)this.mItems.get(j);; paramb2 = (b)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramb2.position)
        {
          f3 += this.mAdapter.getPageWidth(k) + f2;
          k += 1;
        }
        paramb2.offset = f3;
        f1 = f3 + (paramb2.widthFactor + f2);
        i = k + 1;
      }
    }
    if (i > paramb1.position)
    {
      j = this.mItems.size() - 1;
      f1 = paramb2.offset;
      i -= 1;
      while ((i >= paramb1.position) && (j >= 0))
      {
        for (paramb2 = (b)this.mItems.get(j);; paramb2 = (b)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i >= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramb2.position)
        {
          f3 -= this.mAdapter.getPageWidth(k) + f2;
          k -= 1;
        }
        f1 = f3 - (paramb2.widthFactor + f2);
        paramb2.offset = f1;
        i = k - 1;
      }
    }
    label415:
    int k = this.mItems.size();
    float f3 = paramb1.offset;
    i = paramb1.position - 1;
    if (paramb1.position == 0)
    {
      f1 = paramb1.offset;
      this.mFirstOffset = f1;
      if (paramb1.position != m - 1) {
        break label556;
      }
      f1 = paramb1.offset + paramb1.widthFactor - 1.0F;
      label481:
      this.mLastOffset = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label609;
      }
      paramb2 = (b)this.mItems.get(j);
      for (;;)
      {
        if (i > paramb2.position)
        {
          f1 -= this.mAdapter.getPageWidth(i) + f2;
          i -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label556:
          f1 = 3.4028235E+38F;
          break label481;
        }
      }
      f1 -= paramb2.widthFactor + f2;
      paramb2.offset = f1;
      if (paramb2.position == 0) {
        this.mFirstOffset = f1;
      }
      i -= 1;
      j -= 1;
    }
    label609:
    float f1 = paramb1.offset + paramb1.widthFactor + f2;
    int j = paramb1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramb1 = (b)this.mItems.get(i);
      while (paramInt < paramb1.position)
      {
        f1 += this.mAdapter.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramb1.position == m - 1) {
        this.mLastOffset = (paramb1.widthFactor + f1 - 1.0F);
      }
      paramb1.offset = f1;
      f1 += paramb1.widthFactor + f2;
      paramInt += 1;
      i += 1;
    }
    this.mNeedCalculatePageOffsets = false;
    AppMethodBeat.o(97005);
  }
  
  private boolean arrowScroll(int paramInt)
  {
    AppMethodBeat.i(97037);
    View localView = findFocus();
    Object localObject;
    int j;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label320;
      }
      if (paramInt != 17) {
        break label266;
      }
      i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
      j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = pageLeft();
        label95:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        AppMethodBeat.o(97037);
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label366;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label373;
      }
      if (localObject != this) {}
    }
    label266:
    label320:
    label360:
    label366:
    label373:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ").append(localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label95;
        if (paramInt == 66)
        {
          i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
          j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
          if ((localObject == null) || (i > j))
          {
            bool = localView.requestFocus();
            break label95;
            if ((paramInt == 17) || (paramInt == 1))
            {
              bool = pageLeft();
              break label95;
            }
            if ((paramInt != 66) && (paramInt != 2)) {
              break label360;
            }
          }
          bool = pageRight();
          break label95;
        }
        bool = false;
        break label95;
      }
      localObject = localView;
      break;
    }
  }
  
  private boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97035);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop())))
        {
          AppMethodBeat.o(97035);
          return true;
        }
        i -= 1;
      }
    }
    if ((paramBoolean) && (t.n(paramView, -paramInt1)))
    {
      AppMethodBeat.o(97035);
      return true;
    }
    AppMethodBeat.o(97035);
    return false;
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(97021);
    if (this.mScrollState == 2) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        this.mScroller.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.mScroller.getCurrX();
        int n = this.mScroller.getCurrY();
        if ((j != m) || (k != n)) {
          scrollTo(m, n);
        }
      }
      this.mPopulatePending = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.mItems.size())
      {
        b localb = (b)this.mItems.get(i);
        if (localb.scrolling)
        {
          localb.scrolling = false;
          j = 1;
        }
        i += 1;
      }
    }
    if (j != 0)
    {
      if (paramBoolean)
      {
        t.b(this, this.mEndScrollRunnable);
        AppMethodBeat.o(97021);
        return;
      }
      this.mEndScrollRunnable.run();
    }
    AppMethodBeat.o(97021);
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(96998);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(96998);
    return paramFloat;
  }
  
  private b eI(View paramView)
  {
    AppMethodBeat.i(97010);
    int i = 0;
    while (i < this.mItems.size())
    {
      b localb = (b)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localb.object))
      {
        AppMethodBeat.o(97010);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(97010);
    return null;
  }
  
  private b eJ(View paramView)
  {
    AppMethodBeat.i(97011);
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View)))
      {
        AppMethodBeat.o(97011);
        return null;
      }
      paramView = (View)localViewParent;
    }
    paramView = eI(paramView);
    AppMethodBeat.o(97011);
    return paramView;
  }
  
  private int firstItemPosForDetermine()
  {
    AppMethodBeat.i(97027);
    int i = ((b)this.mItems.get(0)).position;
    AppMethodBeat.o(97027);
    return i;
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    AppMethodBeat.i(97038);
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        AppMethodBeat.o(97038);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      AppMethodBeat.o(97038);
      return paramRect;
    }
  }
  
  private void ho(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96999);
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      AppMethodBeat.o(96999);
      return;
    }
    int i = getScrollX();
    int j = getScrollY();
    int k = paramInt1 - i;
    int m = 0 - j;
    if ((k == 0) && (m == 0))
    {
      completeScroll(false);
      populate();
      setScrollState(0);
      AppMethodBeat.o(96999);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int n = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(k) * 1.0F / paramInt1);
    float f1 = n;
    float f2 = n;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt2)) * 4;; paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.mPageMargin) + 3.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.mScroller.startScroll(i, j, k, m, paramInt1);
      t.W(this);
      AppMethodBeat.o(96999);
      return;
      f1 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
    }
  }
  
  private b hp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97000);
    b localb = new b();
    localb.position = paramInt1;
    localb.object = this.mAdapter.instantiateItem(this, paramInt1);
    localb.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size())) {
      this.mItems.add(localb);
    }
    for (;;)
    {
      AppMethodBeat.o(97000);
      return localb;
      this.mItems.add(paramInt2, localb);
    }
  }
  
  private int lastItemPosForDetermine()
  {
    AppMethodBeat.i(97028);
    int i = ((b)this.mItems.get(this.mItems.size() - 1)).position;
    AppMethodBeat.o(97028);
    return i;
  }
  
  private void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(97020);
    int i;
    int k;
    int i2;
    int m;
    View localView;
    int j;
    label124:
    int n;
    if (this.mDecorChildCount > 0)
    {
      int i1 = getScrollX();
      i = getPaddingLeft();
      k = getPaddingRight();
      i2 = getWidth();
      int i3 = getChildCount();
      m = 0;
      if (m < i3)
      {
        localView = getChildAt(m);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.OW) {
          break label380;
        }
        switch (localLayoutParams.gravity & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          j = i;
          int i4 = j + i1 - localView.getLeft();
          n = k;
          j = i;
          if (i4 != 0)
          {
            localView.offsetLeftAndRight(i4);
            j = i;
            n = k;
          }
          break;
        }
      }
    }
    for (;;)
    {
      m += 1;
      i = j;
      k = n;
      break;
      n = i + localView.getWidth();
      j = i;
      i = n;
      break label124;
      j = Math.max((i2 - localView.getMeasuredWidth()) / 2, i);
      break label124;
      j = i2 - k - localView.getMeasuredWidth();
      k += localView.getMeasuredWidth();
      break label124;
      if (this.mOnPageChangeListener != null) {
        this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      if (this.mInternalPageChangeListener != null) {
        this.mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      if (this.mPageTransformer != null)
      {
        paramInt2 = getScrollX();
        i = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          localView = getChildAt(paramInt1);
          if (!((LayoutParams)localView.getLayoutParams()).OW)
          {
            paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
            this.mPageTransformer.n(localView, paramFloat);
          }
          paramInt1 += 1;
        }
      }
      this.mCalledSuper = true;
      AppMethodBeat.o(97020);
      return;
      label380:
      n = k;
      j = i;
    }
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97032);
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label68;
      }
    }
    label68:
    for (i = 1;; i = 0)
    {
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      AppMethodBeat.o(97032);
      return;
    }
  }
  
  private boolean pageLeft()
  {
    AppMethodBeat.i(97039);
    if (this.mCurItem > 0)
    {
      setCurrentItem$2563266(this.mCurItem - 1);
      AppMethodBeat.o(97039);
      return true;
    }
    AppMethodBeat.o(97039);
    return false;
  }
  
  private boolean pageRight()
  {
    AppMethodBeat.i(97040);
    if ((this.mAdapter != null) && (this.mCurItem < this.mAdapter.getCount() - 1))
    {
      setCurrentItem$2563266(this.mCurItem + 1);
      AppMethodBeat.o(97040);
      return true;
    }
    AppMethodBeat.o(97040);
    return false;
  }
  
  private boolean pageScrolled(int paramInt)
  {
    AppMethodBeat.i(97019);
    if (this.mItems.size() == 0)
    {
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (!this.mCalledSuper)
      {
        localObject = new IllegalStateException("onPageScrolled did not call superclass implementation");
        AppMethodBeat.o(97019);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(97019);
      return false;
    }
    Object localObject = dLk();
    int j = getClientWidth();
    int k = this.mPageMargin;
    float f = this.mPageMargin / j;
    int i = ((b)localObject).position;
    f = (paramInt / j - ((b)localObject).offset) / (((b)localObject).widthFactor + f);
    paramInt = (int)((k + j) * f);
    this.mCalledSuper = false;
    onPageScrolled(i, f, paramInt);
    if (!this.mCalledSuper)
    {
      localObject = new IllegalStateException("onPageScrolled did not call superclass implementation");
      AppMethodBeat.o(97019);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(97019);
    return true;
  }
  
  private boolean performDrag(float paramFloat)
  {
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(97024);
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = getClientWidth();
    paramFloat = k * this.mFirstOffset;
    f1 = k;
    float f3 = this.mLastOffset;
    b localb1 = (b)this.mItems.get(0);
    b localb2 = (b)this.mItems.get(this.mItems.size() - 1);
    if (localb1.position != 0)
    {
      paramFloat = localb1.offset;
      paramFloat = k * paramFloat;
    }
    for (int i = 0;; i = 1)
    {
      if (localb2.position != this.mAdapter.getCount() - 1)
      {
        f1 = localb2.offset * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i != 0)
          {
            bool1 = this.mLeftEdge.I(Math.abs(paramFloat - f2) / k);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.mLastMotionX += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          pageScrolled((int)f1);
          AppMethodBeat.o(97024);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (j != 0) {
              bool1 = this.mRightEdge.I(Math.abs(f2 - f1) / k);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private void populate(int paramInt)
  {
    AppMethodBeat.i(97003);
    Object localObject3 = null;
    int j = 2;
    if (this.mCurItem != paramInt) {
      if (this.mCurItem >= paramInt) {
        break label69;
      }
    }
    label69:
    for (int i = 66;; i = 17)
    {
      localObject3 = OT(this.mCurItem);
      this.mCurItem = paramInt;
      j = i;
      if (this.mAdapter != null) {
        break;
      }
      sortChildDrawingOrder();
      AppMethodBeat.o(97003);
      return;
    }
    if (this.mPopulatePending)
    {
      sortChildDrawingOrder();
      AppMethodBeat.o(97003);
      return;
    }
    if (getWindowToken() == null)
    {
      AppMethodBeat.o(97003);
      return;
    }
    this.mAdapter.startUpdate(this);
    paramInt = this.mOffscreenPageLimit;
    int i2 = Math.max(0, this.mCurItem - paramInt);
    int n = this.mAdapter.getCount();
    int i1 = Math.min(n - 1, paramInt + this.mCurItem);
    Object localObject2;
    if (n != this.mExpectedAdapterCount) {
      try
      {
        Object localObject1 = getResources().getResourceName(getId());
        localObject1 = new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + n + " Pager id: " + (String)localObject1 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
        AppMethodBeat.o(97003);
        throw ((Throwable)localObject1);
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          localObject2 = Integer.toHexString(getId());
        }
      }
    }
    paramInt = 0;
    if (paramInt < this.mItems.size())
    {
      localObject2 = (b)this.mItems.get(paramInt);
      if (((b)localObject2).position >= this.mCurItem) {
        if (((b)localObject2).position != this.mCurItem) {
          break label1289;
        }
      }
    }
    label384:
    label652:
    for (;;)
    {
      if ((localObject2 == null) && (n > 0)) {}
      label397:
      label411:
      label497:
      label1009:
      for (Object localObject4 = hp(this.mCurItem, paramInt);; localObject4 = localObject2)
      {
        float f1;
        int m;
        int i3;
        float f2;
        int k;
        if (localObject4 != null)
        {
          f1 = 0.0F;
          m = paramInt - 1;
          if (m >= 0)
          {
            localObject2 = (b)this.mItems.get(m);
            i3 = getClientWidth();
            if (i3 > 0) {
              break label525;
            }
            f2 = 0.0F;
            k = this.mCurItem - 1;
            i = paramInt;
            paramInt = m;
            if (k < 0) {
              break label652;
            }
            if ((f1 < f2) || (k >= i2)) {
              break label552;
            }
            if (localObject2 == null) {
              break label652;
            }
            if ((k != ((b)localObject2).position) || (((b)localObject2).scrolling)) {
              break label1279;
            }
            this.mItems.remove(paramInt);
            this.mAdapter.destroyItem(this, k, ((b)localObject2).object);
            paramInt -= 1;
            if (paramInt < 0) {
              break label546;
            }
            localObject2 = (b)this.mItems.get(paramInt);
            i -= 1;
          }
        }
        label890:
        label1279:
        for (;;)
        {
          k -= 1;
          break label411;
          paramInt += 1;
          break;
          localObject2 = null;
          break label384;
          f2 = 2.0F - ((b)localObject4).widthFactor + getPaddingLeft() / i3;
          break label397;
          localObject2 = null;
          break label497;
          if ((localObject2 != null) && (k == ((b)localObject2).position))
          {
            f1 += ((b)localObject2).widthFactor;
            paramInt -= 1;
            if (paramInt >= 0) {
              localObject2 = (b)this.mItems.get(paramInt);
            } else {
              localObject2 = null;
            }
          }
          else
          {
            f1 += hp(k, paramInt + 1).widthFactor;
            i += 1;
            if (paramInt >= 0) {}
            for (localObject2 = (b)this.mItems.get(paramInt);; localObject2 = null) {
              break;
            }
            float f3 = ((b)localObject4).widthFactor;
            m = i + 1;
            if (f3 < 2.0F)
            {
              Object localObject5;
              if (m < this.mItems.size())
              {
                localObject2 = (b)this.mItems.get(m);
                if (i3 > 0) {
                  break label863;
                }
                f2 = 0.0F;
                k = this.mCurItem + 1;
                localObject5 = localObject2;
                if (k >= n) {
                  break label1009;
                }
                if ((f3 < f2) || (k <= i1)) {
                  break label890;
                }
                if (localObject5 == null) {
                  break label1009;
                }
                localObject2 = localObject5;
                f1 = f3;
                paramInt = m;
                if (k == localObject5.position)
                {
                  localObject2 = localObject5;
                  f1 = f3;
                  paramInt = m;
                  if (!localObject5.scrolling)
                  {
                    this.mItems.remove(m);
                    this.mAdapter.destroyItem(this, k, localObject5.object);
                    if (m >= this.mItems.size()) {
                      break label878;
                    }
                    localObject2 = (b)this.mItems.get(m);
                    paramInt = m;
                    f1 = f3;
                  }
                }
              }
              for (;;)
              {
                k += 1;
                localObject5 = localObject2;
                f3 = f1;
                m = paramInt;
                break label717;
                localObject2 = null;
                break;
                f2 = getPaddingRight() / i3 + 2.0F;
                break label705;
                localObject2 = null;
                f1 = f3;
                paramInt = m;
                continue;
                if ((localObject5 != null) && (k == localObject5.position))
                {
                  f1 = f3 + localObject5.widthFactor;
                  paramInt = m + 1;
                  if (paramInt < this.mItems.size()) {
                    localObject2 = (b)this.mItems.get(paramInt);
                  } else {
                    localObject2 = null;
                  }
                }
                else
                {
                  localObject2 = hp(k, m);
                  paramInt = m + 1;
                  f1 = f3 + ((b)localObject2).widthFactor;
                  if (paramInt < this.mItems.size()) {
                    localObject2 = (b)this.mItems.get(paramInt);
                  } else {
                    localObject2 = null;
                  }
                }
              }
            }
            a((b)localObject4, i, (b)localObject3);
            localObject3 = this.mAdapter;
            paramInt = this.mCurItem;
            if (localObject4 != null) {}
            for (localObject2 = ((b)localObject4).object;; localObject2 = null)
            {
              ((q)localObject3).setPrimaryItem(this, paramInt, localObject2);
              this.mAdapter.finishUpdate(this);
              i = getChildCount();
              paramInt = 0;
              while (paramInt < i)
              {
                localObject3 = getChildAt(paramInt);
                localObject2 = (LayoutParams)((View)localObject3).getLayoutParams();
                ((LayoutParams)localObject2).OY = paramInt;
                if ((!((LayoutParams)localObject2).OW) && (((LayoutParams)localObject2).widthFactor == 0.0F))
                {
                  localObject3 = eI((View)localObject3);
                  if (localObject3 != null)
                  {
                    ((LayoutParams)localObject2).widthFactor = ((b)localObject3).widthFactor;
                    ((LayoutParams)localObject2).position = ((b)localObject3).position;
                  }
                }
                paramInt += 1;
              }
            }
            sortChildDrawingOrder();
            if (hasFocus())
            {
              localObject2 = findFocus();
              if (localObject2 != null) {}
              for (localObject2 = eJ((View)localObject2); (localObject2 == null) || (((b)localObject2).position != this.mCurItem); localObject2 = null)
              {
                paramInt = 0;
                while (paramInt < getChildCount())
                {
                  localObject2 = getChildAt(paramInt);
                  localObject3 = eI((View)localObject2);
                  if ((localObject3 != null) && (((b)localObject3).position == this.mCurItem) && (((View)localObject2).requestFocus(j))) {
                    break;
                  }
                  paramInt += 1;
                }
              }
            }
            AppMethodBeat.o(97003);
            return;
          }
        }
      }
      label525:
      label546:
      label552:
      label705:
      label717:
      label863:
      label878:
      localObject2 = null;
    }
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97016);
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      paramInt2 = (int)((paramInt1 - i - j + paramInt3) * f);
      scrollTo(paramInt2, getScrollY());
      if (!this.mScroller.isFinished())
      {
        paramInt3 = this.mScroller.getDuration();
        paramInt4 = this.mScroller.timePassed();
        localb = OT(this.mCurItem);
        this.mScroller.startScroll(paramInt2, 0, (int)(localb.offset * paramInt1), 0, paramInt3 - paramInt4);
      }
      AppMethodBeat.o(97016);
      return;
    }
    b localb = OT(this.mCurItem);
    if (localb != null) {}
    for (float f = Math.min(localb.offset, this.mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        completeScroll(false);
        scrollTo(paramInt1, getScrollY());
      }
      AppMethodBeat.o(97016);
      return;
    }
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(96989);
    b localb = OT(paramInt1);
    float f;
    if (localb != null) {
      f = getClientWidth();
    }
    for (int i = (int)(Math.max(this.mFirstOffset, Math.min(localb.offset, this.mLastOffset)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        ho(i, paramInt2);
        if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
          this.mOnPageChangeListener.onPageSelected(paramInt1);
        }
        if ((paramBoolean2) && (this.mInternalPageChangeListener != null))
        {
          this.mInternalPageChangeListener.onPageSelected(paramInt1);
          AppMethodBeat.o(96989);
        }
      }
      else
      {
        if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
          this.mOnPageChangeListener.onPageSelected(paramInt1);
        }
        if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
          this.mInternalPageChangeListener.onPageSelected(paramInt1);
        }
        completeScroll(false);
        scrollTo(i, 0);
        pageScrolled(i);
      }
      AppMethodBeat.o(96989);
      return;
    }
  }
  
  private void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(96987);
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
    AppMethodBeat.o(96987);
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    AppMethodBeat.i(97004);
    if (this.mDrawingOrder != 0)
    {
      if (this.mDrawingOrderedChildren == null) {
        this.mDrawingOrderedChildren = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.mDrawingOrderedChildren.add(localView);
          i += 1;
        }
        this.mDrawingOrderedChildren.clear();
      }
      Collections.sort(this.mDrawingOrderedChildren, yrp);
    }
    AppMethodBeat.o(97004);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97041);
    Assert.assertNotNull(paramArrayList);
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          b localb = eI(localView);
          if ((localb != null) && (localb.position == this.mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if ((k != 262144) || (j == paramArrayList.size()))
    {
      if (!isFocusable())
      {
        AppMethodBeat.o(97041);
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode()))
      {
        AppMethodBeat.o(97041);
        return;
      }
      paramArrayList.add(this);
    }
    AppMethodBeat.o(97041);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(97042);
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = eI(localView);
        if ((localb != null) && (localb.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(97042);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(97008);
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      Assert.assertNotNull(paramLayoutParams);
      LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
      localLayoutParams.OW |= paramView instanceof a;
      if (this.mInLayout)
      {
        if ((localLayoutParams != null) && (localLayoutParams.OW))
        {
          paramView = new IllegalStateException("Cannot add pager decor view during layout");
          AppMethodBeat.o(97008);
          throw paramView;
        }
        localLayoutParams.OX = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        AppMethodBeat.o(97008);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(97008);
      return;
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(97034);
    if (this.mAdapter == null)
    {
      AppMethodBeat.o(97034);
      return false;
    }
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0)
    {
      if (j > (int)(i * this.mFirstOffset))
      {
        AppMethodBeat.o(97034);
        return true;
      }
      AppMethodBeat.o(97034);
      return false;
    }
    if (paramInt > 0)
    {
      if (j < (int)(i * this.mLastOffset))
      {
        AppMethodBeat.o(97034);
        return true;
      }
      AppMethodBeat.o(97034);
      return false;
    }
    AppMethodBeat.o(97034);
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(97047);
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      AppMethodBeat.o(97047);
      return true;
    }
    AppMethodBeat.o(97047);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(97018);
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!pageScrolled(k))
        {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      t.W(this);
      AppMethodBeat.o(97018);
      return;
    }
    completeScroll(true);
    AppMethodBeat.o(97018);
  }
  
  final b dLk()
  {
    AppMethodBeat.i(97025);
    int i = getClientWidth();
    float f1;
    float f2;
    label42:
    int k;
    int j;
    Object localObject;
    float f3;
    float f4;
    label59:
    b localb;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label215;
      }
      f2 = this.mPageMargin / i;
      k = -1;
      j = 1;
      i = 0;
      localObject = null;
      f3 = 0.0F;
      f4 = 0.0F;
      if (i >= this.mItems.size()) {
        break label258;
      }
      localb = (b)this.mItems.get(i);
      if ((j != 0) || (localb.position == k + 1)) {
        break label267;
      }
      localb = this.yrm;
      localb.offset = (f4 + f3 + f2);
      localb.position = (k + 1);
      localb.widthFactor = this.mAdapter.getPageWidth(localb.position);
      i -= 1;
    }
    label258:
    label267:
    for (;;)
    {
      f4 = localb.offset;
      f3 = localb.widthFactor;
      if ((j != 0) || (f1 >= f4))
      {
        if ((f1 >= f3 + f4 + f2) && (i != this.mItems.size() - 1)) {
          break label229;
        }
        AppMethodBeat.o(97025);
        return localb;
        f1 = 0.0F;
        break;
        label215:
        f2 = 0.0F;
        break label42;
      }
      AppMethodBeat.o(97025);
      return localObject;
      label229:
      k = localb.position;
      f3 = localb.widthFactor;
      i += 1;
      j = 0;
      localObject = localb;
      break label59;
      AppMethodBeat.o(97025);
      return localObject;
    }
  }
  
  final void dataSetChanged()
  {
    AppMethodBeat.i(97001);
    int i5 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i5;
    int i;
    int j;
    int n;
    int k;
    int i3;
    label66:
    Object localObject;
    int i4;
    int i2;
    int i1;
    int m;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i5))
    {
      i = 1;
      j = this.mCurItem;
      n = 0;
      k = 0;
      i3 = i;
      if (n >= this.mItems.size()) {
        break label302;
      }
      localObject = (b)this.mItems.get(n);
      i4 = this.mAdapter.getItemPosition(((b)localObject).object);
      i2 = n;
      i1 = k;
      m = j;
      i = i3;
      if (i4 != -1)
      {
        if (i4 != -2) {
          break label242;
        }
        this.mItems.remove(n);
        i2 = n - 1;
        n = k;
        if (k == 0)
        {
          this.mAdapter.startUpdate(this);
          n = 1;
        }
        this.mAdapter.destroyItem(this, ((b)localObject).position, ((b)localObject).object);
        if (this.mCurItem != ((b)localObject).position) {
          break label393;
        }
        m = Math.max(0, Math.min(this.mCurItem, i5 - 1));
        i = 1;
        i1 = n;
      }
    }
    for (;;)
    {
      n = i2 + 1;
      k = i1;
      j = m;
      i3 = i;
      break label66;
      i = 0;
      break;
      label242:
      i2 = n;
      i1 = k;
      m = j;
      i = i3;
      if (((b)localObject).position != i4)
      {
        if (((b)localObject).position == this.mCurItem) {
          j = i4;
        }
        ((b)localObject).position = i4;
        i = 1;
        i2 = n;
        i1 = k;
        m = j;
        continue;
        label302:
        if (k != 0) {
          this.mAdapter.finishUpdate(this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (i3 != 0)
        {
          k = getChildCount();
          i = 0;
          while (i < k)
          {
            localObject = (LayoutParams)getChildAt(i).getLayoutParams();
            if (!((LayoutParams)localObject).OW) {
              ((LayoutParams)localObject).widthFactor = 0.0F;
            }
            i += 1;
          }
          setCurrentItemInternal(j, false, true);
          requestLayout();
        }
        AppMethodBeat.o(97001);
        return;
        label393:
        i = 1;
        i1 = n;
        m = j;
      }
    }
  }
  
  final int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97026);
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0) {
          paramInt2 = Math.max(firstItemPosForDetermine(), Math.min(paramInt1, lastItemPosForDetermine()));
        }
        AppMethodBeat.o(97026);
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.mCurItem) {}
    for (float f = 0.85F;; f = 0.15F)
    {
      paramInt1 = (int)(f + (paramInt1 + paramFloat));
      break;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(97036);
    boolean bool;
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      if (paramKeyEvent.getAction() == 0) {}
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool = false;
      }
    }
    for (;;)
    {
      if (!bool) {
        break label135;
      }
      AppMethodBeat.o(97036);
      return true;
      bool = arrowScroll(17);
      continue;
      bool = arrowScroll(66);
      continue;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      if (paramKeyEvent.hasNoModifiers())
      {
        bool = arrowScroll(2);
      }
      else
      {
        if (!paramKeyEvent.hasModifiers(1)) {
          break;
        }
        bool = arrowScroll(1);
      }
    }
    label135:
    AppMethodBeat.o(97036);
    return false;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(97044);
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      boolean bool = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      AppMethodBeat.o(97044);
      return bool;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = eI(localView);
        if ((localb != null) && (localb.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
        {
          AppMethodBeat.o(97044);
          return true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(97044);
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97029);
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = t.R(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.mAdapter != null) && (this.mAdapter.getCount() > 1)))
    {
      int j;
      if (!this.mLeftEdge.Su.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.mFirstOffset * m);
        this.mLeftEdge.setSize(i, m);
        j = this.mLeftEdge.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.mRightEdge.Su.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * k);
        this.mRightEdge.setSize(n - i1 - i2, k);
        bool = j | this.mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        t.W(this);
      }
      AppMethodBeat.o(97029);
      return;
      this.mLeftEdge.Su.finish();
      this.mRightEdge.Su.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(96997);
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
    AppMethodBeat.o(96997);
  }
  
  final void endDrag()
  {
    AppMethodBeat.i(97033);
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(97033);
  }
  
  public final void fakeDragBy(float paramFloat)
  {
    AppMethodBeat.i(97031);
    if (!this.mFakeDragging)
    {
      localObject = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
      AppMethodBeat.o(97031);
      throw ((Throwable)localObject);
    }
    this.mLastMotionX += paramFloat;
    float f2 = getScrollX() - paramFloat;
    int i = getClientWidth();
    paramFloat = i;
    float f4 = this.mFirstOffset;
    float f1 = i;
    float f3 = this.mLastOffset;
    Object localObject = (b)this.mItems.get(0);
    b localb = (b)this.mItems.get(this.mItems.size() - 1);
    if (((b)localObject).position != 0) {}
    for (paramFloat = ((b)localObject).offset * i;; paramFloat *= f4)
    {
      if (localb.position != this.mAdapter.getCount() - 1) {}
      for (f1 = localb.offset * i;; f1 *= f3)
      {
        if (f2 < paramFloat) {}
        for (;;)
        {
          this.mLastMotionX += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          pageScrolled((int)paramFloat);
          long l = SystemClock.uptimeMillis();
          localObject = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
          this.mVelocityTracker.addMovement((MotionEvent)localObject);
          ((MotionEvent)localObject).recycle();
          AppMethodBeat.o(97031);
          return;
          if (f2 > f1) {
            paramFloat = f1;
          } else {
            paramFloat = f2;
          }
        }
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(97045);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(97045);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(97048);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(97048);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(97046);
    paramLayoutParams = generateDefaultLayoutParams();
    AppMethodBeat.o(97046);
    return paramLayoutParams;
  }
  
  public q getAdapter()
  {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96991);
    int i = paramInt2;
    if (this.mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    paramInt1 = ((LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).OY;
    AppMethodBeat.o(96991);
    return paramInt1;
  }
  
  int getClientWidth()
  {
    AppMethodBeat.i(96984);
    int i = getMeasuredWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(96984);
    return i - j - k;
  }
  
  public int getCurrentItem()
  {
    return this.mCurItem;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageMargin()
  {
    return this.mPageMargin;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(97013);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(97013);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(96981);
    removeCallbacks(this.mEndScrollRunnable);
    super.onDetachedFromWindow();
    AppMethodBeat.o(96981);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97030);
    super.onDraw(paramCanvas);
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f3 = this.mPageMargin / m;
      Object localObject = (b)this.mItems.get(0);
      float f1 = ((b)localObject).offset;
      int n = this.mItems.size();
      int i = ((b)localObject).position;
      int i1 = ((b)this.mItems.get(n - 1)).position;
      int j = 0;
      if (i < i1)
      {
        while ((i > ((b)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (b)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == ((b)localObject).position) {
          f2 = (((b)localObject).offset + ((b)localObject).widthFactor) * m;
        }
        float f4;
        for (f1 = ((b)localObject).offset + ((b)localObject).widthFactor + f3;; f1 += f4 + f3)
        {
          if (this.mPageMargin + f2 > k)
          {
            this.mMarginDrawable.setBounds((int)f2, this.mTopPageBounds, (int)(this.mPageMargin + f2 + 0.5F), this.mBottomPageBounds);
            this.mMarginDrawable.draw(paramCanvas);
          }
          if (f2 > k + m) {
            break label316;
          }
          i += 1;
          break;
          f4 = this.mAdapter.getPageWidth(i);
          f2 = (f1 + f4) * m;
        }
      }
    }
    label316:
    AppMethodBeat.o(97030);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97022);
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.mIsBeingDragged = false;
      this.mIsUnableToDrag = false;
      this.mActivePointerId = -1;
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      AppMethodBeat.o(97022);
      return false;
    }
    if (i != 0)
    {
      if (this.mIsBeingDragged)
      {
        AppMethodBeat.o(97022);
        return true;
      }
      if (this.mIsUnableToDrag)
      {
        AppMethodBeat.o(97022);
        return false;
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      boolean bool = this.mIsBeingDragged;
      AppMethodBeat.o(97022);
      return bool;
      i = this.mActivePointerId;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        float f2 = paramMotionEvent.getX(i);
        float f1 = f2 - this.mLastMotionX;
        float f4 = Math.abs(f1);
        float f3 = paramMotionEvent.getY(i);
        float f5 = Math.abs(f3 - this.mInitialMotionY);
        if (f1 != 0.0F)
        {
          float f6 = this.mLastMotionX;
          if (((f6 < this.mGutterSize) && (f1 > 0.0F)) || ((f6 > getWidth() - this.mGutterSize) && (f1 < 0.0F))) {}
          for (i = 1; (i == 0) && (canScroll(this, false, (int)f1, (int)f2, (int)f3)); i = 0)
          {
            this.mLastMotionX = f2;
            this.mLastMotionY = f3;
            this.mIsUnableToDrag = true;
            AppMethodBeat.o(97022);
            return false;
          }
        }
        if ((f4 > this.mTouchSlop) && (0.5F * f4 > f5))
        {
          this.mIsBeingDragged = true;
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.mInitialMotionX + this.mTouchSlop;
            label392:
            this.mLastMotionX = f1;
            this.mLastMotionY = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.mIsBeingDragged) && (performDrag(f2)))
        {
          t.W(this);
          break;
          f1 = this.mInitialMotionX - this.mTouchSlop;
          break label392;
          if (f5 > this.mTouchSlop) {
            this.mIsUnableToDrag = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mScroller.computeScrollOffset();
        if ((this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough))
        {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          this.mIsBeingDragged = false;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97017);
    int i1 = getChildCount();
    int i3 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    paramInt1 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    paramInt3 = getPaddingRight();
    int j = getPaddingBottom();
    int i4 = getScrollX();
    int k = 0;
    int m = 0;
    View localView;
    LayoutParams localLayoutParams;
    int n;
    int i;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label650;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.OW) {
        break label650;
      }
      paramInt4 = localLayoutParams.gravity;
      n = localLayoutParams.gravity;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt1;
        i = paramInt3;
        paramInt3 = paramInt1;
        paramInt1 = i;
        label169:
        switch (n & 0x70)
        {
        default: 
          i = paramInt2;
          label211:
          paramInt4 += i4;
          localView.layout(paramInt4, i, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + i);
          paramInt4 = k + 1;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
      k = paramInt4;
      break;
      i = paramInt1 + localView.getMeasuredWidth();
      paramInt4 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
      break label169;
      i = Math.max((i3 - localView.getMeasuredWidth()) / 2, paramInt1);
      paramInt4 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = paramInt4;
      paramInt4 = i;
      break label169;
      paramInt4 = localView.getMeasuredWidth();
      i = localView.getMeasuredWidth();
      paramInt4 = i3 - paramInt3 - paramInt4;
      i = paramInt3 + i;
      paramInt3 = paramInt1;
      paramInt1 = i;
      break label169;
      n = paramInt2 + localView.getMeasuredHeight();
      i = paramInt2;
      paramInt2 = n;
      break label211;
      i = Math.max((i2 - localView.getMeasuredHeight()) / 2, paramInt2);
      break label211;
      i = i2 - j - localView.getMeasuredHeight();
      j += localView.getMeasuredHeight();
      break label211;
      paramInt4 = i3 - paramInt1 - paramInt3;
      paramInt3 = 0;
      while (paramInt3 < i1)
      {
        localView = getChildAt(paramInt3);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.OW)
          {
            b localb = eI(localView);
            if (localb != null)
            {
              float f = paramInt4;
              i = (int)(localb.offset * f) + paramInt1;
              if (localLayoutParams.OX)
              {
                localLayoutParams.OX = false;
                f = paramInt4;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - paramInt2 - j, 1073741824));
              }
              localView.layout(i, paramInt2, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt2);
            }
          }
        }
        paramInt3 += 1;
      }
      this.mTopPageBounds = paramInt2;
      this.mBottomPageBounds = (i2 - j);
      this.mDecorChildCount = k;
      if (this.mFirstLayout) {
        scrollToItem(this.mCurItem, false, 0, false);
      }
      this.mFirstLayout = false;
      AppMethodBeat.o(97017);
      return;
      label650:
      paramInt4 = k;
      i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97014);
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int i;
    int j;
    LayoutParams localLayoutParams;
    int m;
    int i1;
    label189:
    int n;
    if (k < i4)
    {
      localView = getChildAt(k);
      i = paramInt1;
      j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.OW)
          {
            i = localLayoutParams.gravity & 0x7;
            m = localLayoutParams.gravity & 0x70;
            i1 = -2147483648;
            j = -2147483648;
            if ((m != 48) && (m != 80)) {
              break label339;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label345;
            }
            n = 1;
            label204:
            if (m == 0) {
              break label351;
            }
            i = 1073741824;
            label214:
            if (localLayoutParams.width == -2) {
              break label545;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label539;
            }
            i = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i3;
      if (localLayoutParams.height != -2)
      {
        i2 = 1073741824;
        j = i2;
        if (localLayoutParams.height != -1)
        {
          i3 = localLayoutParams.height;
          j = i2;
        }
      }
      for (int i2 = i3;; i2 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i1), View.MeasureSpec.makeMeasureSpec(i2, j));
        if (m != 0)
        {
          j = paramInt2 - localView.getMeasuredHeight();
          i = paramInt1;
        }
        for (;;)
        {
          k += 1;
          paramInt1 = i;
          paramInt2 = j;
          break;
          label339:
          m = 0;
          break label189;
          label345:
          n = 0;
          break label204;
          label351:
          i = i1;
          if (n == 0) {
            break label214;
          }
          j = 1073741824;
          i = i1;
          break label214;
          i = paramInt1;
          j = paramInt2;
          if (n != 0)
          {
            i = paramInt1 - localView.getMeasuredWidth();
            j = paramInt2;
          }
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (((localLayoutParams == null) || (!localLayoutParams.OW)) && (localLayoutParams != null))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), this.mChildHeightMeasureSpec);
            }
          }
          paramInt2 += 1;
        }
        AppMethodBeat.o(97014);
        return;
      }
      label539:
      i = paramInt1;
      continue;
      label545:
      i1 = paramInt1;
      i2 = i;
      i = i1;
      i1 = i2;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(97043);
    int k = getChildCount();
    int j;
    int i;
    if ((paramInt & 0x2) != 0)
    {
      j = 1;
      i = 0;
    }
    while (i != k)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = eI(localView);
        if ((localb != null) && (localb.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect)))
        {
          AppMethodBeat.o(97043);
          return true;
          i = k - 1;
          j = -1;
          k = -1;
          continue;
        }
      }
      i += j;
    }
    AppMethodBeat.o(97043);
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(97007);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(97007);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.mAdapter != null)
    {
      this.mAdapter.restoreState(paramParcelable.OZ, paramParcelable.Pa);
      setCurrentItemInternal(paramParcelable.position, false, true);
      AppMethodBeat.o(97007);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.OZ;
    this.mRestoredClassLoader = paramParcelable.Pa;
    AppMethodBeat.o(97007);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(97006);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    if (this.mAdapter != null) {
      localSavedState.OZ = this.mAdapter.saveState();
    }
    AppMethodBeat.o(97006);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97015);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      recomputeScrollPosition(paramInt1, paramInt3, this.mPageMargin, this.mPageMargin);
    }
    AppMethodBeat.o(97015);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = 0;
    AppMethodBeat.i(97023);
    if (this.mFakeDragging)
    {
      AppMethodBeat.o(97023);
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      AppMethodBeat.o(97023);
      return false;
    }
    if ((this.mAdapter == null) || (this.mAdapter.getCount() == 0))
    {
      AppMethodBeat.o(97023);
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = m;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = m;
    }
    for (;;)
    {
      if (i != 0) {
        t.W(this);
      }
      AppMethodBeat.o(97023);
      return true;
      this.mScroller.abortAnimation();
      this.mPopulatePending = false;
      populate();
      this.mIsBeingDragged = true;
      setScrollState(1);
      float f1 = paramMotionEvent.getX();
      this.mInitialMotionX = f1;
      this.mLastMotionX = f1;
      f1 = paramMotionEvent.getY();
      this.mInitialMotionY = f1;
      this.mLastMotionY = f1;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      i = m;
      continue;
      float f2;
      if (!this.mIsBeingDragged)
      {
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        float f3 = Math.abs(f1 - this.mLastMotionX);
        f2 = paramMotionEvent.getY(i);
        float f4 = Math.abs(f2 - this.mLastMotionY);
        if ((f3 > this.mTouchSlop) && (f3 > f4))
        {
          this.mIsBeingDragged = true;
          if (f1 - this.mInitialMotionX <= 0.0F) {
            break label394;
          }
        }
      }
      label394:
      for (f1 = this.mInitialMotionX + this.mTouchSlop;; f1 = this.mInitialMotionX - this.mTouchSlop)
      {
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        i = m;
        if (!this.mIsBeingDragged) {
          break;
        }
        bool1 = performDrag(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId))) | false;
        break;
      }
      boolean bool1 = m;
      if (this.mIsBeingDragged)
      {
        Object localObject = this.mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
        int n = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int j = getClientWidth();
        m = getScrollX();
        localObject = dLk();
        int i1 = ((b)localObject).position;
        f1 = (m / j - ((b)localObject).offset) / ((b)localObject).widthFactor;
        m = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        j = m;
        if (m < 0) {
          j = 0;
        }
        setCurrentItemInternal(determineTargetPage(i1, f1, n, (int)(paramMotionEvent.getX(j) - this.mInitialMotionX)), true, true, n);
        this.mActivePointerId = -1;
        endDrag();
        boolean bool3 = this.mLeftEdge.fC();
        boolean bool2 = this.mRightEdge.fC() | bool3;
        continue;
        bool2 = m;
        if (this.mIsBeingDragged)
        {
          scrollToItem(this.mCurItem, true, 0, false);
          this.mActivePointerId = -1;
          endDrag();
          bool3 = this.mLeftEdge.fC();
          bool2 = this.mRightEdge.fC() | bool3;
          continue;
          int k = paramMotionEvent.getActionIndex();
          this.mLastMotionX = paramMotionEvent.getX(k);
          this.mActivePointerId = paramMotionEvent.getPointerId(k);
          k = m;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
          this.mLastMotionX = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
          k = m;
        }
      }
    }
  }
  
  final void populate()
  {
    AppMethodBeat.i(97002);
    populate(this.mCurItem);
    AppMethodBeat.o(97002);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(97009);
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      AppMethodBeat.o(97009);
      return;
    }
    super.removeView(paramView);
    AppMethodBeat.o(97009);
  }
  
  public void setAdapter(q paramq)
  {
    AppMethodBeat.i(96983);
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.yrn);
      this.mAdapter.startUpdate(this);
      int i = 0;
      while (i < this.mItems.size())
      {
        b localb = (b)this.mItems.get(i);
        this.mAdapter.destroyItem(this, localb.position, localb.object);
        i += 1;
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      int j;
      for (i = 0; i < getChildCount(); i = j + 1)
      {
        j = i;
        if (!((LayoutParams)getChildAt(i).getLayoutParams()).OW)
        {
          removeViewAt(i);
          j = i - 1;
        }
      }
      this.mCurItem = 0;
      scrollTo(0, 0);
    }
    this.mAdapter = paramq;
    this.mExpectedAdapterCount = 0;
    if (this.mAdapter != null)
    {
      if (this.yrn == null) {
        this.yrn = new e((byte)0);
      }
      this.mAdapter.registerDataSetObserver(this.yrn);
      this.mPopulatePending = false;
      boolean bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem >= 0)
      {
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        AppMethodBeat.o(96983);
        return;
      }
      if (!bool)
      {
        populate();
        AppMethodBeat.o(96983);
        return;
      }
      requestLayout();
    }
    AppMethodBeat.o(96983);
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    AppMethodBeat.i(96990);
    if ((Build.VERSION.SDK_INT < 7) || (this.mSetChildrenDrawingOrderEnabled == null)) {}
    try
    {
      this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
      try
      {
        label43:
        if (this.mSetChildrenDrawingOrderEnabled != null) {
          this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
        }
        AppMethodBeat.o(96990);
        return;
      }
      catch (Exception localException) {}
      AppMethodBeat.o(96990);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label43;
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(96985);
    this.mPopulatePending = false;
    if (!this.mFirstLayout) {}
    for (boolean bool = true;; bool = false)
    {
      setCurrentItemInternal(paramInt, bool, false);
      AppMethodBeat.o(96985);
      return;
    }
  }
  
  public final void setCurrentItem$2563266(int paramInt)
  {
    AppMethodBeat.i(96986);
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, true, false);
    AppMethodBeat.o(96986);
  }
  
  final void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(96988);
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      AppMethodBeat.o(96988);
      return;
    }
    if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      AppMethodBeat.o(96988);
      return;
    }
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = this.mOffscreenPageLimit;
      if ((i <= this.mCurItem + paramInt1) && (i >= this.mCurItem - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.mItems.size())
      {
        ((b)this.mItems.get(paramInt1)).scrolling = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.mAdapter.getCount()) {
        i = this.mAdapter.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.mCurItem != i) {
      paramBoolean2 = true;
    }
    if (this.mFirstLayout)
    {
      this.mCurItem = i;
      if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
        this.mOnPageChangeListener.onPageSelected(i);
      }
      if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
        this.mInternalPageChangeListener.onPageSelected(i);
      }
      requestLayout();
      AppMethodBeat.o(96988);
      return;
    }
    populate(i);
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
    AppMethodBeat.o(96988);
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    AppMethodBeat.i(96992);
    int i = paramInt;
    if (paramInt <= 0)
    {
      new StringBuilder("Requested offscreen page limit ").append(paramInt).append(" too small; defaulting to 1");
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
    AppMethodBeat.o(96992);
  }
  
  void setOnAdapterChangeListener(d paramd)
  {
    this.yro = paramd;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    AppMethodBeat.i(96993);
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
    AppMethodBeat.o(96993);
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    AppMethodBeat.i(96995);
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
    AppMethodBeat.o(96995);
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(96994);
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(96994);
      return;
    }
  }
  
  void setScrollState(int paramInt)
  {
    AppMethodBeat.i(96982);
    if (this.mScrollState == paramInt)
    {
      AppMethodBeat.o(96982);
      return;
    }
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null)
    {
      int i;
      int j;
      if (paramInt != 0)
      {
        i = 1;
        int m = getChildCount();
        j = 0;
        label47:
        if (j >= m) {
          break label88;
        }
        if (i == 0) {
          break label82;
        }
      }
      label82:
      for (int k = 2;; k = 0)
      {
        t.q(getChildAt(j), k);
        j += 1;
        break label47;
        i = 0;
        break;
      }
    }
    label88:
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
    AppMethodBeat.o(96982);
  }
  
  public void setScroller(Scroller paramScroller)
  {
    this.mScroller = paramScroller;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(96996);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mMarginDrawable))
    {
      AppMethodBeat.o(96996);
      return true;
    }
    AppMethodBeat.o(96996);
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public boolean OW;
    boolean OX;
    int OY;
    public int gravity;
    int position;
    float widthFactor;
    
    public LayoutParams()
    {
      super(-1);
      this.widthFactor = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(96967);
      this.widthFactor = 0.0F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, AdLandingViewPager.LAYOUT_ATTRS);
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
      AppMethodBeat.o(96967);
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    Parcelable OZ;
    ClassLoader Pa;
    int position;
    
    static
    {
      AppMethodBeat.i(96978);
      CREATOR = android.support.v4.os.c.a(new d() {});
      AppMethodBeat.o(96978);
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      AppMethodBeat.i(96977);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.OZ = paramParcel.readParcelable(localClassLoader);
      this.Pa = localClassLoader;
      AppMethodBeat.o(96977);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(96976);
      String str = "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
      AppMethodBeat.o(96976);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(96975);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.OZ, paramInt);
      AppMethodBeat.o(96975);
    }
  }
  
  static abstract interface a {}
  
  static final class b
  {
    Object object;
    float offset;
    int position;
    boolean scrolling;
    float widthFactor;
  }
  
  final class c
    extends a
  {
    c() {}
    
    private boolean fi()
    {
      AppMethodBeat.i(96971);
      if ((AdLandingViewPager.b(AdLandingViewPager.this) != null) && (AdLandingViewPager.b(AdLandingViewPager.this).getCount() > 1))
      {
        AppMethodBeat.o(96971);
        return true;
      }
      AppMethodBeat.o(96971);
      return false;
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(96968);
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(AdLandingViewPager.class.getName());
      paramView = e.fl();
      paramView.setScrollable(fi());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (AdLandingViewPager.b(AdLandingViewPager.this) != null))
      {
        paramView.setItemCount(AdLandingViewPager.b(AdLandingViewPager.this).getCount());
        paramView.setFromIndex(AdLandingViewPager.c(AdLandingViewPager.this));
        paramView.setToIndex(AdLandingViewPager.c(AdLandingViewPager.this));
      }
      AppMethodBeat.o(96968);
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, android.support.v4.view.a.c paramc)
    {
      AppMethodBeat.i(96969);
      super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      paramc.setClassName(AdLandingViewPager.class.getName());
      paramc.setScrollable(fi());
      if (AdLandingViewPager.this.canScrollHorizontally(1)) {
        paramc.addAction(4096);
      }
      if (AdLandingViewPager.this.canScrollHorizontally(-1)) {
        paramc.addAction(8192);
      }
      AppMethodBeat.o(96969);
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(96970);
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      {
        AppMethodBeat.o(96970);
        return true;
      }
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(96970);
        return false;
      case 4096: 
        if (AdLandingViewPager.this.canScrollHorizontally(1))
        {
          AdLandingViewPager.this.setCurrentItem(AdLandingViewPager.c(AdLandingViewPager.this) + 1);
          AppMethodBeat.o(96970);
          return true;
        }
        AppMethodBeat.o(96970);
        return false;
      }
      if (AdLandingViewPager.this.canScrollHorizontally(-1))
      {
        AdLandingViewPager.this.setCurrentItem(AdLandingViewPager.c(AdLandingViewPager.this) - 1);
        AppMethodBeat.o(96970);
        return true;
      }
      AppMethodBeat.o(96970);
      return false;
    }
  }
  
  static abstract interface d {}
  
  final class e
    extends DataSetObserver
  {
    private e() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(96972);
      AdLandingViewPager.this.dataSetChanged();
      AppMethodBeat.o(96972);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(96973);
      AdLandingViewPager.this.dataSetChanged();
      AppMethodBeat.o(96973);
    }
  }
  
  static final class f
    implements Comparator<View>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager
 * JD-Core Version:    0.7.0.1
 */