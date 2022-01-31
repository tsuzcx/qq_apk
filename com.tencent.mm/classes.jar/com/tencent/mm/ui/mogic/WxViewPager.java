package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.c;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.d;
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

public class WxViewPager
  extends ViewGroup
{
  private static final int CLOSE_ENOUGH = 2;
  private static final Comparator<WxViewPager.b> COMPARATOR;
  private static final boolean DEBUG = false;
  private static final int DEFAULT_GUTTER_SIZE = 16;
  private static final int DEFAULT_OFFSCREEN_PAGES = 1;
  private static final int DRAW_ORDER_DEFAULT = 0;
  private static final int DRAW_ORDER_FORWARD = 1;
  private static final int DRAW_ORDER_REVERSE = 2;
  private static final int INVALID_POINTER = -1;
  private static final int[] LAYOUT_ATTRS;
  private static final int MAX_SETTLE_DURATION = 600;
  private static final int MIN_DISTANCE_FOR_FLING = 25;
  private static final int MIN_FLING_VELOCITY = 400;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final String TAG = "WxViewPager";
  private static final boolean USE_CACHE = false;
  private static final Interpolator sInterpolator;
  private static final WxViewPager.f sPositionComparator;
  private int mActivePointerId;
  private q mAdapter;
  private WxViewPager.d mAdapterChangeListener;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  private int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable;
  private int mExpectedAdapterCount;
  private long mFakeDragBeginTime;
  private boolean mFakeDragging;
  private boolean mFirstLayout;
  private float mFirstOffset;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mIgnoreGutter;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private ViewPager.OnPageChangeListener mInternalPageChangeListener;
  private boolean mIsBeingDragged;
  private boolean mIsUnableToDrag;
  private final ArrayList<WxViewPager.b> mItems;
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset;
  private i mLeftEdge;
  private Drawable mMarginDrawable;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets;
  private e mObserver;
  private int mOffscreenPageLimit;
  private ViewPager.OnPageChangeListener mOnPageChangeListener;
  private int mPageMargin;
  private ViewPager.d mPageTransformer;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState;
  private ClassLoader mRestoredClassLoader;
  private int mRestoredCurItem;
  private i mRightEdge;
  private int mScrollState;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private Method mSetChildrenDrawingOrderEnabled;
  private final WxViewPager.b mTempItem;
  private final Rect mTempRect;
  private int mTopPageBounds;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(107547);
    LAYOUT_ATTRS = new int[] { 16842931 };
    COMPARATOR = new WxViewPager.1();
    sInterpolator = new WxViewPager.2();
    sPositionComparator = new WxViewPager.f();
    AppMethodBeat.o(107547);
  }
  
  public WxViewPager(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107467);
    this.mItems = new ArrayList();
    this.mTempItem = new WxViewPager.b();
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
    this.mEndScrollRunnable = new WxViewPager.3(this);
    this.mScrollState = 0;
    initViewPager();
    AppMethodBeat.o(107467);
  }
  
  public WxViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107468);
    this.mItems = new ArrayList();
    this.mTempItem = new WxViewPager.b();
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
    this.mEndScrollRunnable = new WxViewPager.3(this);
    this.mScrollState = 0;
    initViewPager();
    AppMethodBeat.o(107468);
  }
  
  private void calculatePageOffsets(WxViewPager.b paramb1, int paramInt, WxViewPager.b paramb2)
  {
    AppMethodBeat.i(107497);
    int m = this.mAdapter.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramb2 == null) {
        break label414;
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
          break label414;
        }
        for (paramb2 = (WxViewPager.b)this.mItems.get(j);; paramb2 = (WxViewPager.b)this.mItems.get(j))
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
        for (paramb2 = (WxViewPager.b)this.mItems.get(j);; paramb2 = (WxViewPager.b)this.mItems.get(j))
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
    label414:
    int k = this.mItems.size();
    float f3 = paramb1.offset;
    i = paramb1.position - 1;
    if (paramb1.position == 0)
    {
      f1 = paramb1.offset;
      this.mFirstOffset = f1;
      if (paramb1.position != m - 1) {
        break label555;
      }
      f1 = paramb1.offset + paramb1.widthFactor - 1.0F;
      label480:
      this.mLastOffset = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label608;
      }
      paramb2 = (WxViewPager.b)this.mItems.get(j);
      for (;;)
      {
        if (i > paramb2.position)
        {
          f1 -= this.mAdapter.getPageWidth(i) + f2;
          i -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label555:
          f1 = 3.4028235E+38F;
          break label480;
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
    label608:
    float f1 = paramb1.offset + paramb1.widthFactor + f2;
    int j = paramb1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramb1 = (WxViewPager.b)this.mItems.get(i);
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
    AppMethodBeat.o(107497);
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(107513);
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
        WxViewPager.b localb = (WxViewPager.b)this.mItems.get(i);
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
        AppMethodBeat.o(107513);
        return;
      }
      this.mEndScrollRunnable.run();
    }
    AppMethodBeat.o(107513);
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107520);
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0) {
          paramInt2 = Math.max(firstItemPosForDetermine(), Math.min(paramInt1, lastItemPosForDetermine()));
        }
        AppMethodBeat.o(107520);
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.mCurItem) {}
    for (float f = 0.6F;; f = 0.4F)
    {
      paramInt1 = (int)(f + (paramInt1 + paramFloat));
      break;
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    AppMethodBeat.i(107515);
    int k = getChildCount();
    int i = 0;
    if (i < k)
    {
      if (paramBoolean) {}
      for (int j = 2;; j = 0)
      {
        t.p(getChildAt(i), j);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(107515);
  }
  
  private void endDrag()
  {
    AppMethodBeat.i(107529);
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(107529);
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    AppMethodBeat.i(107535);
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        AppMethodBeat.o(107535);
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
      AppMethodBeat.o(107535);
      return paramRect;
    }
  }
  
  private int getClientWidth()
  {
    AppMethodBeat.i(107474);
    int i = getMeasuredWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(107474);
    return i - j - k;
  }
  
  private WxViewPager.b infoForCurrentScrollPosition()
  {
    AppMethodBeat.i(107519);
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
    WxViewPager.b localb;
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
      localb = (WxViewPager.b)this.mItems.get(i);
      if ((j != 0) || (localb.position == k + 1)) {
        break label267;
      }
      localb = this.mTempItem;
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
        AppMethodBeat.o(107519);
        return localb;
        f1 = 0.0F;
        break;
        label215:
        f2 = 0.0F;
        break label42;
      }
      AppMethodBeat.o(107519);
      return localObject;
      label229:
      k = localb.position;
      f3 = localb.widthFactor;
      i += 1;
      j = 0;
      localObject = localb;
      break label59;
      AppMethodBeat.o(107519);
      return localObject;
    }
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107528);
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
      AppMethodBeat.o(107528);
      return;
    }
  }
  
  private boolean pageScrolled(int paramInt)
  {
    AppMethodBeat.i(107511);
    if (this.mItems.size() == 0)
    {
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (!this.mCalledSuper)
      {
        localObject = new IllegalStateException("onPageScrolled did not call superclass implementation");
        AppMethodBeat.o(107511);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(107511);
      return false;
    }
    Object localObject = infoForCurrentScrollPosition();
    if (localObject == null)
    {
      AppMethodBeat.o(107511);
      return false;
    }
    int j = getClientWidth();
    int k = this.mPageMargin;
    float f = this.mPageMargin / j;
    int i = ((WxViewPager.b)localObject).position;
    f = (paramInt / j - ((WxViewPager.b)localObject).offset) / (((WxViewPager.b)localObject).widthFactor + f);
    paramInt = (int)((k + j) * f);
    this.mCalledSuper = false;
    onPageScrolled(i, f, paramInt);
    if (!this.mCalledSuper)
    {
      localObject = new IllegalStateException("onPageScrolled did not call superclass implementation");
      AppMethodBeat.o(107511);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(107511);
    return true;
  }
  
  private boolean performDrag(float paramFloat)
  {
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(107518);
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = getClientWidth();
    paramFloat = k * this.mFirstOffset;
    f1 = k;
    float f3 = this.mLastOffset;
    WxViewPager.b localb1 = (WxViewPager.b)this.mItems.get(0);
    WxViewPager.b localb2 = (WxViewPager.b)this.mItems.get(this.mItems.size() - 1);
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
            bool1 = this.mLeftEdge.E(Math.abs(paramFloat - f2) / k);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.mLastMotionX += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          pageScrolled((int)f1);
          AppMethodBeat.o(107518);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (j != 0) {
              bool1 = this.mRightEdge.E(Math.abs(f2 - f1) / k);
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
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107508);
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
        localb = infoForPosition(this.mCurItem);
        if (localb != null) {
          this.mScroller.startScroll(paramInt2, 0, (int)(localb.offset * paramInt1), 0, paramInt3 - paramInt4);
        }
      }
      AppMethodBeat.o(107508);
      return;
    }
    WxViewPager.b localb = infoForPosition(this.mCurItem);
    if (localb != null) {}
    for (float f = Math.min(localb.offset, this.mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        completeScroll(false);
        scrollTo(paramInt1, getScrollY());
      }
      AppMethodBeat.o(107508);
      return;
    }
  }
  
  private void removeNonDecorViews()
  {
    AppMethodBeat.i(107473);
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((WxViewPager.LayoutParams)getChildAt(i).getLayoutParams()).Hb)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
    AppMethodBeat.o(107473);
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(107479);
    WxViewPager.b localb = infoForPosition(paramInt1);
    float f;
    if (localb != null) {
      f = getClientWidth();
    }
    for (int i = (int)(Math.max(this.mFirstOffset, Math.min(localb.offset, this.mLastOffset)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        smoothScrollTo(i, 0, paramInt2);
        if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
          this.mOnPageChangeListener.onPageSelected(paramInt1);
        }
        if ((paramBoolean2) && (this.mInternalPageChangeListener != null))
        {
          this.mInternalPageChangeListener.onPageSelected(paramInt1);
          AppMethodBeat.o(107479);
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
      AppMethodBeat.o(107479);
      return;
    }
  }
  
  private void setScrollState(int paramInt)
  {
    AppMethodBeat.i(107471);
    if (this.mScrollState == paramInt)
    {
      AppMethodBeat.o(107471);
      return;
    }
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null) {
      if (paramInt == 0) {
        break label68;
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      enableLayers(bool);
      if (this.mOnPageChangeListener != null) {
        this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
      }
      AppMethodBeat.o(107471);
      return;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    AppMethodBeat.i(107496);
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
      Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
    }
    AppMethodBeat.o(107496);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107538);
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
          WxViewPager.b localb = infoForChild(localView);
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
        AppMethodBeat.o(107538);
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode()))
      {
        AppMethodBeat.o(107538);
        return;
      }
      paramArrayList.add(this);
    }
    AppMethodBeat.o(107538);
  }
  
  WxViewPager.b addNewItem(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107492);
    WxViewPager.b localb = new WxViewPager.b();
    localb.position = paramInt1;
    localb.object = this.mAdapter.instantiateItem(this, paramInt1);
    localb.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size())) {
      this.mItems.add(localb);
    }
    for (;;)
    {
      AppMethodBeat.o(107492);
      return localb;
      this.mItems.add(paramInt2, localb);
    }
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(107539);
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        WxViewPager.b localb = infoForChild(localView);
        if ((localb != null) && (localb.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(107539);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(107500);
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      Assert.assertNotNull(paramLayoutParams);
      WxViewPager.LayoutParams localLayoutParams = (WxViewPager.LayoutParams)paramLayoutParams;
      localLayoutParams.Hb |= paramView instanceof WxViewPager.a;
      if (this.mInLayout)
      {
        if (localLayoutParams.Hb)
        {
          paramView = new IllegalStateException("Cannot add pager decor view during layout");
          AppMethodBeat.o(107500);
          throw paramView;
        }
        localLayoutParams.Hc = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        AppMethodBeat.o(107500);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(107500);
      return;
    }
  }
  
  public boolean arrowScroll(int paramInt)
  {
    AppMethodBeat.i(107534);
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
        AppMethodBeat.o(107534);
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
  
  public boolean beginFakeDrag()
  {
    AppMethodBeat.i(107525);
    if (this.mIsBeingDragged)
    {
      AppMethodBeat.o(107525);
      return false;
    }
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.mVelocityTracker.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.mFakeDragBeginTime = l;
      AppMethodBeat.o(107525);
      return true;
      this.mVelocityTracker.clear();
    }
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107531);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop())) && (localView.isEnabled()))
        {
          AppMethodBeat.o(107531);
          return true;
        }
        i -= 1;
      }
    }
    if ((paramBoolean) && (t.m(paramView, -paramInt1)))
    {
      AppMethodBeat.o(107531);
      return true;
    }
    AppMethodBeat.o(107531);
    return false;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(107530);
    if (this.mAdapter == null)
    {
      AppMethodBeat.o(107530);
      return false;
    }
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0)
    {
      if (j > (int)(i * this.mFirstOffset))
      {
        AppMethodBeat.o(107530);
        return true;
      }
      AppMethodBeat.o(107530);
      return false;
    }
    if (paramInt > 0)
    {
      if (j < (int)(i * this.mLastOffset))
      {
        AppMethodBeat.o(107530);
        return true;
      }
      AppMethodBeat.o(107530);
      return false;
    }
    AppMethodBeat.o(107530);
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(107544);
    if (((paramLayoutParams instanceof WxViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      AppMethodBeat.o(107544);
      return true;
    }
    AppMethodBeat.o(107544);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(107510);
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
      t.R(this);
      AppMethodBeat.o(107510);
      return;
    }
    completeScroll(true);
    AppMethodBeat.o(107510);
  }
  
  void dataSetChanged()
  {
    AppMethodBeat.i(107493);
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
      localObject = (WxViewPager.b)this.mItems.get(n);
      i4 = this.mAdapter.getItemPosition(((WxViewPager.b)localObject).object);
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
        this.mAdapter.destroyItem(this, ((WxViewPager.b)localObject).position, ((WxViewPager.b)localObject).object);
        if (this.mCurItem != ((WxViewPager.b)localObject).position) {
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
      if (((WxViewPager.b)localObject).position != i4)
      {
        if (((WxViewPager.b)localObject).position == this.mCurItem) {
          j = i4;
        }
        ((WxViewPager.b)localObject).position = i4;
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
            localObject = (WxViewPager.LayoutParams)getChildAt(i).getLayoutParams();
            if (!((WxViewPager.LayoutParams)localObject).Hb) {
              ((WxViewPager.LayoutParams)localObject).widthFactor = 0.0F;
            }
            i += 1;
          }
          setCurrentItemInternal(j, false, true);
          requestLayout();
        }
        AppMethodBeat.o(107493);
        return;
        label393:
        i = 1;
        i1 = n;
        m = j;
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107532);
    if ((super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(107532);
      return true;
    }
    AppMethodBeat.o(107532);
    return false;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(107541);
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      boolean bool = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      AppMethodBeat.o(107541);
      return bool;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        WxViewPager.b localb = infoForChild(localView);
        if ((localb != null) && (localb.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
        {
          AppMethodBeat.o(107541);
          return true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(107541);
    return false;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(107489);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(107489);
    return paramFloat;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107523);
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = t.O(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.mAdapter != null) && (this.mAdapter.getCount() > 1)))
    {
      int j;
      if (!this.mLeftEdge.Ky.isFinished())
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
      if (!this.mRightEdge.Ky.isFinished())
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
        t.R(this);
      }
      AppMethodBeat.o(107523);
      return;
      this.mLeftEdge.Ky.finish();
      this.mRightEdge.Ky.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(107488);
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
    AppMethodBeat.o(107488);
  }
  
  public void endFakeDrag()
  {
    AppMethodBeat.i(107526);
    if (!this.mFakeDragging)
    {
      localObject = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
      AppMethodBeat.o(107526);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mVelocityTracker;
    ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
    int i = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
    this.mPopulatePending = true;
    int j = getClientWidth();
    int k = getScrollX();
    localObject = infoForCurrentScrollPosition();
    if (localObject != null) {
      setCurrentItemInternal(determineTargetPage(((WxViewPager.b)localObject).position, (k / j - ((WxViewPager.b)localObject).offset) / ((WxViewPager.b)localObject).widthFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, i);
    }
    endDrag();
    this.mFakeDragging = false;
    AppMethodBeat.o(107526);
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107533);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107533);
      return bool1;
      bool1 = arrowScroll(17);
      continue;
      bool1 = arrowScroll(66);
      continue;
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 11) {
        if (paramKeyEvent.hasNoModifiers())
        {
          bool1 = arrowScroll(2);
        }
        else
        {
          bool1 = bool2;
          if (paramKeyEvent.hasModifiers(1)) {
            bool1 = arrowScroll(1);
          }
        }
      }
    }
  }
  
  public void fakeDragBy(float paramFloat)
  {
    AppMethodBeat.i(107527);
    if (!this.mFakeDragging)
    {
      localObject = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
      AppMethodBeat.o(107527);
      throw ((Throwable)localObject);
    }
    this.mLastMotionX += paramFloat;
    float f2 = getScrollX() - paramFloat;
    int i = getClientWidth();
    paramFloat = i;
    float f4 = this.mFirstOffset;
    float f1 = i;
    float f3 = this.mLastOffset;
    Object localObject = (WxViewPager.b)this.mItems.get(0);
    WxViewPager.b localb = (WxViewPager.b)this.mItems.get(this.mItems.size() - 1);
    if (((WxViewPager.b)localObject).position != 0) {}
    for (paramFloat = ((WxViewPager.b)localObject).offset * i;; paramFloat *= f4)
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
          AppMethodBeat.o(107527);
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
  
  public int firstItemPosForDetermine()
  {
    AppMethodBeat.i(107521);
    int i = ((WxViewPager.b)this.mItems.get(0)).position;
    AppMethodBeat.o(107521);
    return i;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(107542);
    WxViewPager.LayoutParams localLayoutParams = new WxViewPager.LayoutParams();
    AppMethodBeat.o(107542);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(107545);
    paramAttributeSet = new WxViewPager.LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(107545);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(107543);
    paramLayoutParams = generateDefaultLayoutParams();
    AppMethodBeat.o(107543);
    return paramLayoutParams;
  }
  
  public q getAdapter()
  {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107482);
    int i = paramInt2;
    if (this.mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    paramInt1 = ((WxViewPager.LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).Hd;
    AppMethodBeat.o(107482);
    return paramInt1;
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
  
  WxViewPager.b infoForAnyChild(View paramView)
  {
    AppMethodBeat.i(107503);
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View)))
      {
        AppMethodBeat.o(107503);
        return null;
      }
      paramView = (View)localViewParent;
    }
    paramView = infoForChild(paramView);
    AppMethodBeat.o(107503);
    return paramView;
  }
  
  WxViewPager.b infoForChild(View paramView)
  {
    AppMethodBeat.i(107502);
    int i = 0;
    while (i < this.mItems.size())
    {
      WxViewPager.b localb = (WxViewPager.b)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localb.object))
      {
        AppMethodBeat.o(107502);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(107502);
    return null;
  }
  
  WxViewPager.b infoForPosition(int paramInt)
  {
    AppMethodBeat.i(107504);
    int i = 0;
    while (i < this.mItems.size())
    {
      WxViewPager.b localb = (WxViewPager.b)this.mItems.get(i);
      if (localb.position == paramInt)
      {
        AppMethodBeat.o(107504);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(107504);
    return null;
  }
  
  void initViewPager()
  {
    AppMethodBeat.i(107469);
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.mScroller = new Scroller(localContext, sInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = u.a(localViewConfiguration);
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new i(localContext);
    this.mRightEdge = new i(localContext);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(16.0F * f));
    t.a(this, new WxViewPager.c(this));
    if (t.S(this) == 0) {
      t.o(this, 1);
    }
    AppMethodBeat.o(107469);
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  protected boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107514);
    if (((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.mGutterSize) && (paramFloat2 < 0.0F)))
    {
      AppMethodBeat.o(107514);
      return true;
    }
    AppMethodBeat.o(107514);
    return false;
  }
  
  public int lastItemPosForDetermine()
  {
    AppMethodBeat.i(107522);
    int i = ((WxViewPager.b)this.mItems.get(this.mItems.size() - 1)).position;
    AppMethodBeat.o(107522);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(107505);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(107505);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(107470);
    removeCallbacks(this.mEndScrollRunnable);
    super.onDetachedFromWindow();
    AppMethodBeat.o(107470);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107524);
    super.onDraw(paramCanvas);
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f3 = this.mPageMargin / m;
      Object localObject = (WxViewPager.b)this.mItems.get(0);
      float f1 = ((WxViewPager.b)localObject).offset;
      int n = this.mItems.size();
      int i = ((WxViewPager.b)localObject).position;
      int i1 = ((WxViewPager.b)this.mItems.get(n - 1)).position;
      int j = 0;
      if (i < i1)
      {
        while ((i > ((WxViewPager.b)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (WxViewPager.b)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == ((WxViewPager.b)localObject).position) {
          f2 = (((WxViewPager.b)localObject).offset + ((WxViewPager.b)localObject).widthFactor) * m;
        }
        float f4;
        for (f1 = ((WxViewPager.b)localObject).offset + ((WxViewPager.b)localObject).widthFactor + f3;; f1 += f4 + f3)
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
    AppMethodBeat.o(107524);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107516);
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
      AppMethodBeat.o(107516);
      return false;
    }
    if (i != 0)
    {
      if (this.mIsBeingDragged)
      {
        AppMethodBeat.o(107516);
        return true;
      }
      if (this.mIsUnableToDrag)
      {
        AppMethodBeat.o(107516);
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
      AppMethodBeat.o(107516);
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
        if ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f1)) && (canScroll(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.mLastMotionX = f2;
          this.mLastMotionY = f3;
          this.mIsUnableToDrag = true;
          AppMethodBeat.o(107516);
          return false;
        }
        if ((f4 > this.mTouchSlop) && (0.5F * f4 > f5))
        {
          this.mIsBeingDragged = true;
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.mInitialMotionX + this.mTouchSlop;
            label345:
            this.mLastMotionX = f1;
            this.mLastMotionY = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.mIsBeingDragged) && (performDrag(f2)))
        {
          t.R(this);
          break;
          f1 = this.mInitialMotionX - this.mTouchSlop;
          break label345;
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
    AppMethodBeat.i(107509);
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
    WxViewPager.LayoutParams localLayoutParams;
    int n;
    int i;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label650;
      }
      localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.Hb) {
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
          localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.Hb)
          {
            WxViewPager.b localb = infoForChild(localView);
            if (localb != null)
            {
              float f = paramInt4;
              i = (int)(localb.offset * f) + paramInt1;
              if (localLayoutParams.Hc)
              {
                localLayoutParams.Hc = false;
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
      AppMethodBeat.o(107509);
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
    AppMethodBeat.i(107506);
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
    WxViewPager.LayoutParams localLayoutParams;
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
        localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.Hb)
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
            localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
            if (((localLayoutParams == null) || (!localLayoutParams.Hb)) && (localLayoutParams != null))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), this.mChildHeightMeasureSpec);
            }
          }
          paramInt2 += 1;
        }
        AppMethodBeat.o(107506);
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
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(107512);
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
        WxViewPager.LayoutParams localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.Hb) {
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
          if (!((WxViewPager.LayoutParams)localView.getLayoutParams()).Hb)
          {
            paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
            this.mPageTransformer.k(localView, paramFloat);
          }
          paramInt1 += 1;
        }
      }
      this.mCalledSuper = true;
      AppMethodBeat.o(107512);
      return;
      label380:
      n = k;
      j = i;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(107540);
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
        WxViewPager.b localb = infoForChild(localView);
        if ((localb != null) && (localb.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect)))
        {
          AppMethodBeat.o(107540);
          return true;
          i = k - 1;
          j = -1;
          k = -1;
          continue;
        }
      }
      i += j;
    }
    AppMethodBeat.o(107540);
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(107499);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(107499);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.mAdapter != null)
    {
      this.mAdapter.restoreState(paramParcelable.He, paramParcelable.Hf);
      setCurrentItemInternal(paramParcelable.position, false, true);
      AppMethodBeat.o(107499);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.He;
    this.mRestoredClassLoader = paramParcelable.Hf;
    AppMethodBeat.o(107499);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(107498);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    if (this.mAdapter != null) {
      localSavedState.He = this.mAdapter.saveState();
    }
    AppMethodBeat.o(107498);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107507);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      recomputeScrollPosition(paramInt1, paramInt3, this.mPageMargin, this.mPageMargin);
    }
    AppMethodBeat.o(107507);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = 0;
    AppMethodBeat.i(107517);
    if (this.mFakeDragging)
    {
      AppMethodBeat.o(107517);
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      AppMethodBeat.o(107517);
      return false;
    }
    if ((this.mAdapter == null) || (this.mAdapter.getCount() == 0))
    {
      AppMethodBeat.o(107517);
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
        t.R(this);
      }
      AppMethodBeat.o(107517);
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
        localObject = infoForCurrentScrollPosition();
        if (localObject != null)
        {
          int i1 = ((WxViewPager.b)localObject).position;
          f1 = (m / j - ((WxViewPager.b)localObject).offset) / ((WxViewPager.b)localObject).widthFactor;
          m = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          j = m;
          if (m < 0) {
            j = 0;
          }
          setCurrentItemInternal(determineTargetPage(i1, f1, n, (int)(paramMotionEvent.getX(j) - this.mInitialMotionX)), true, true, n);
        }
        this.mActivePointerId = -1;
        endDrag();
        boolean bool3 = this.mLeftEdge.ec();
        boolean bool2 = this.mRightEdge.ec() | bool3;
        continue;
        bool2 = m;
        if (this.mIsBeingDragged)
        {
          scrollToItem(this.mCurItem, true, 0, false);
          this.mActivePointerId = -1;
          endDrag();
          bool3 = this.mLeftEdge.ec();
          bool2 = this.mRightEdge.ec() | bool3;
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
  
  boolean pageLeft()
  {
    AppMethodBeat.i(107536);
    if (this.mCurItem > 0)
    {
      setCurrentItem(this.mCurItem - 1, true);
      AppMethodBeat.o(107536);
      return true;
    }
    AppMethodBeat.o(107536);
    return false;
  }
  
  boolean pageRight()
  {
    AppMethodBeat.i(107537);
    if ((this.mAdapter != null) && (this.mCurItem < this.mAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
      AppMethodBeat.o(107537);
      return true;
    }
    AppMethodBeat.o(107537);
    return false;
  }
  
  void populate()
  {
    AppMethodBeat.i(107494);
    populate(this.mCurItem);
    AppMethodBeat.o(107494);
  }
  
  void populate(int paramInt)
  {
    AppMethodBeat.i(107495);
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
      localObject3 = infoForPosition(this.mCurItem);
      this.mCurItem = paramInt;
      j = i;
      if (this.mAdapter != null) {
        break;
      }
      sortChildDrawingOrder();
      AppMethodBeat.o(107495);
      return;
    }
    if (this.mPopulatePending)
    {
      sortChildDrawingOrder();
      AppMethodBeat.o(107495);
      return;
    }
    if (getWindowToken() == null)
    {
      AppMethodBeat.o(107495);
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
        AppMethodBeat.o(107495);
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
      localObject2 = (WxViewPager.b)this.mItems.get(paramInt);
      if (((WxViewPager.b)localObject2).position >= this.mCurItem) {
        if (((WxViewPager.b)localObject2).position != this.mCurItem) {
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
      for (Object localObject4 = addNewItem(this.mCurItem, paramInt);; localObject4 = localObject2)
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
            localObject2 = (WxViewPager.b)this.mItems.get(m);
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
            if ((k != ((WxViewPager.b)localObject2).position) || (((WxViewPager.b)localObject2).scrolling)) {
              break label1279;
            }
            this.mItems.remove(paramInt);
            this.mAdapter.destroyItem(this, k, ((WxViewPager.b)localObject2).object);
            paramInt -= 1;
            if (paramInt < 0) {
              break label546;
            }
            localObject2 = (WxViewPager.b)this.mItems.get(paramInt);
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
          f2 = 2.0F - ((WxViewPager.b)localObject4).widthFactor + getPaddingLeft() / i3;
          break label397;
          localObject2 = null;
          break label497;
          if ((localObject2 != null) && (k == ((WxViewPager.b)localObject2).position))
          {
            f1 += ((WxViewPager.b)localObject2).widthFactor;
            paramInt -= 1;
            if (paramInt >= 0) {
              localObject2 = (WxViewPager.b)this.mItems.get(paramInt);
            } else {
              localObject2 = null;
            }
          }
          else
          {
            f1 += addNewItem(k, paramInt + 1).widthFactor;
            i += 1;
            if (paramInt >= 0) {}
            for (localObject2 = (WxViewPager.b)this.mItems.get(paramInt);; localObject2 = null) {
              break;
            }
            float f3 = ((WxViewPager.b)localObject4).widthFactor;
            m = i + 1;
            if (f3 < 2.0F)
            {
              Object localObject5;
              if (m < this.mItems.size())
              {
                localObject2 = (WxViewPager.b)this.mItems.get(m);
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
                    localObject2 = (WxViewPager.b)this.mItems.get(m);
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
                    localObject2 = (WxViewPager.b)this.mItems.get(paramInt);
                  } else {
                    localObject2 = null;
                  }
                }
                else
                {
                  localObject2 = addNewItem(k, m);
                  paramInt = m + 1;
                  f1 = f3 + ((WxViewPager.b)localObject2).widthFactor;
                  if (paramInt < this.mItems.size()) {
                    localObject2 = (WxViewPager.b)this.mItems.get(paramInt);
                  } else {
                    localObject2 = null;
                  }
                }
              }
            }
            calculatePageOffsets((WxViewPager.b)localObject4, i, (WxViewPager.b)localObject3);
            localObject3 = this.mAdapter;
            paramInt = this.mCurItem;
            if (localObject4 != null) {}
            for (localObject2 = ((WxViewPager.b)localObject4).object;; localObject2 = null)
            {
              ((q)localObject3).setPrimaryItem(this, paramInt, localObject2);
              this.mAdapter.finishUpdate(this);
              i = getChildCount();
              paramInt = 0;
              while (paramInt < i)
              {
                localObject3 = getChildAt(paramInt);
                localObject2 = (WxViewPager.LayoutParams)((View)localObject3).getLayoutParams();
                ((WxViewPager.LayoutParams)localObject2).Hd = paramInt;
                if ((!((WxViewPager.LayoutParams)localObject2).Hb) && (((WxViewPager.LayoutParams)localObject2).widthFactor == 0.0F))
                {
                  localObject3 = infoForChild((View)localObject3);
                  if (localObject3 != null)
                  {
                    ((WxViewPager.LayoutParams)localObject2).widthFactor = ((WxViewPager.b)localObject3).widthFactor;
                    ((WxViewPager.LayoutParams)localObject2).position = ((WxViewPager.b)localObject3).position;
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
              for (localObject2 = infoForAnyChild((View)localObject2); (localObject2 == null) || (((WxViewPager.b)localObject2).position != this.mCurItem); localObject2 = null)
              {
                paramInt = 0;
                while (paramInt < getChildCount())
                {
                  localObject2 = getChildAt(paramInt);
                  localObject3 = infoForChild((View)localObject2);
                  if ((localObject3 != null) && (((WxViewPager.b)localObject3).position == this.mCurItem) && (((View)localObject2).requestFocus(j))) {
                    break;
                  }
                  paramInt += 1;
                }
              }
            }
            AppMethodBeat.o(107495);
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
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(107501);
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      AppMethodBeat.o(107501);
      return;
    }
    super.removeView(paramView);
    AppMethodBeat.o(107501);
  }
  
  public void setAdapter(q paramq)
  {
    AppMethodBeat.i(107472);
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
      this.mAdapter.startUpdate(this);
      int i = 0;
      while (i < this.mItems.size())
      {
        WxViewPager.b localb = (WxViewPager.b)this.mItems.get(i);
        this.mAdapter.destroyItem(this, localb.position, localb.object);
        i += 1;
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      scrollTo(0, 0);
    }
    this.mAdapter = paramq;
    this.mExpectedAdapterCount = 0;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new e((byte)0);
      }
      this.mAdapter.registerDataSetObserver(this.mObserver);
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
        AppMethodBeat.o(107472);
        return;
      }
      if (!bool)
      {
        populate();
        AppMethodBeat.o(107472);
        return;
      }
      requestLayout();
    }
    AppMethodBeat.o(107472);
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    AppMethodBeat.i(107481);
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
        AppMethodBeat.o(107481);
        return;
      }
      catch (Exception localException) {}
      AppMethodBeat.o(107481);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label43;
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(107475);
    this.mPopulatePending = false;
    if (!this.mFirstLayout) {}
    for (boolean bool = true;; bool = false)
    {
      setCurrentItemInternal(paramInt, bool, false);
      AppMethodBeat.o(107475);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(107476);
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
    AppMethodBeat.o(107476);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(107477);
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
    AppMethodBeat.o(107477);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(107478);
    setCurrentItemInternal(paramInt1, paramBoolean1, paramBoolean2, paramInt2, false);
    AppMethodBeat.o(107478);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3)
  {
    boolean bool = false;
    AppMethodBeat.i(142762);
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      AppMethodBeat.o(142762);
      return;
    }
    if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      AppMethodBeat.o(142762);
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
        ((WxViewPager.b)this.mItems.get(paramInt1)).scrolling = true;
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
      if (((paramBoolean3) || (paramBoolean2)) && (this.mOnPageChangeListener != null)) {
        this.mOnPageChangeListener.onPageSelected(i);
      }
      if (((paramBoolean3) || (paramBoolean2)) && (this.mInternalPageChangeListener != null)) {
        this.mInternalPageChangeListener.onPageSelected(i);
      }
      requestLayout();
      AppMethodBeat.o(142762);
      return;
    }
    populate(i);
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
    AppMethodBeat.o(142762);
  }
  
  public void setCurrentItemNotify(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(142761);
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false, 0, true);
    AppMethodBeat.o(142761);
  }
  
  ViewPager.OnPageChangeListener setInternalPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }
  
  public void setLastMotion(float paramFloat1, float paramFloat2)
  {
    this.mLastMotionX = paramFloat1;
    this.mLastMotionY = paramFloat2;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    AppMethodBeat.i(107483);
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
    AppMethodBeat.o(107483);
  }
  
  void setOnAdapterChangeListener(WxViewPager.d paramd)
  {
    this.mAdapterChangeListener = paramd;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    AppMethodBeat.i(107484);
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
    AppMethodBeat.o(107484);
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    AppMethodBeat.i(107486);
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
    AppMethodBeat.o(107486);
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(107485);
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(107485);
      return;
    }
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.d paramd)
  {
    int j = 1;
    AppMethodBeat.i(107480);
    boolean bool1;
    boolean bool2;
    label34:
    int i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramd == null) {
        break label87;
      }
      bool1 = true;
      if (this.mPageTransformer == null) {
        break label93;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label99;
      }
      i = 1;
      label43:
      this.mPageTransformer = paramd;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (!bool1) {
        break label104;
      }
      if (paramBoolean) {
        j = 2;
      }
    }
    label87:
    label93:
    label99:
    label104:
    for (this.mDrawingOrder = j;; this.mDrawingOrder = 0)
    {
      if (i != 0) {
        populate();
      }
      AppMethodBeat.o(107480);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label34;
      i = 0;
      break label43;
    }
  }
  
  public void setScroller(Scroller paramScroller)
  {
    this.mScroller = paramScroller;
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107490);
    smoothScrollTo(paramInt1, paramInt2, 0);
    AppMethodBeat.o(107490);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107491);
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      AppMethodBeat.o(107491);
      return;
    }
    int i = getScrollX();
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if ((k == 0) && (paramInt2 == 0))
    {
      completeScroll(false);
      populate();
      setScrollState(0);
      AppMethodBeat.o(107491);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int m = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(k) * 1.0F / paramInt1);
    float f1 = m;
    float f2 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.mPageMargin) + 3.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
      t.R(this);
      AppMethodBeat.o(107491);
      return;
      f1 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(107487);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mMarginDrawable))
    {
      AppMethodBeat.o(107487);
      return true;
    }
    AppMethodBeat.o(107487);
    return false;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    Parcelable He;
    ClassLoader Hf;
    int position;
    
    static
    {
      AppMethodBeat.i(107465);
      CREATOR = c.a(new WxViewPager.SavedState.1());
      AppMethodBeat.o(107465);
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      AppMethodBeat.i(107464);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.He = paramParcel.readParcelable(localClassLoader);
      this.Hf = localClassLoader;
      AppMethodBeat.o(107464);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(107463);
      String str = "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
      AppMethodBeat.o(107463);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(107462);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.He, paramInt);
      AppMethodBeat.o(107462);
    }
  }
  
  final class e
    extends DataSetObserver
  {
    private e() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(107459);
      WxViewPager.this.dataSetChanged();
      AppMethodBeat.o(107459);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(107460);
      WxViewPager.this.dataSetChanged();
      AppMethodBeat.o(107460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.WxViewPager
 * JD-Core Version:    0.7.0.1
 */