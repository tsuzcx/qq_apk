package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;

public class MMSlideDelView
  extends ViewGroup
{
  private boolean OST;
  private b OSU;
  private Runnable OSV;
  private long OSW;
  private boolean OSX;
  private a OSY;
  private e OSZ;
  private boolean ded;
  private MMHandler mHandler;
  private float mLastMotionX;
  private float mLastMotionY;
  private final Scroller mScroller;
  private final int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private boolean pPO;
  private MMSlideDelView.g pkY;
  private MMSlideDelView.c pkZ;
  private MMSlideDelView.d plb;
  long time;
  private int va;
  
  public MMSlideDelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142135);
    this.pPO = false;
    this.OST = false;
    this.ded = true;
    this.OSX = false;
    this.OSY = null;
    this.mHandler = new MMHandler();
    this.mScroller = new Scroller(paramContext, new LinearInterpolator());
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.OSW = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(142135);
  }
  
  private void gKW()
  {
    AppMethodBeat.i(142142);
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.OSU);
    }
    AppMethodBeat.o(142142);
  }
  
  private void gKX()
  {
    AppMethodBeat.i(142143);
    setPressed(false);
    if (this.OST)
    {
      gLa();
      AppMethodBeat.o(142143);
      return;
    }
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    localVelocityTracker.computeCurrentVelocity(1000);
    int i = (int)localVelocityTracker.getXVelocity();
    if (i < -600) {
      gKY();
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.pPO = false;
      lu(false);
      AppMethodBeat.o(142143);
      return;
      if (i > 600) {
        gLa();
      } else {
        gLb();
      }
    }
  }
  
  private void gKY()
  {
    AppMethodBeat.i(142145);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    this.plb.a(this, true);
    this.OST = true;
    this.mScroller.startScroll(i, 0, j - i, 0, 100);
    invalidate();
    AppMethodBeat.o(142145);
  }
  
  private void gLb()
  {
    AppMethodBeat.i(142148);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    if (i > j / 2)
    {
      this.plb.a(this, true);
      this.OST = true;
      this.mScroller.startScroll(i, 0, j - i, 0, 100);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(142148);
      return;
      this.OST = false;
      this.plb.a(this, false);
      this.mScroller.startScroll(i, 0, -i, 0, 100);
    }
  }
  
  public static MMSlideDelView.d getItemStatusCallBack()
  {
    AppMethodBeat.i(142134);
    MMSlideDelView.1 local1 = new MMSlideDelView.1();
    AppMethodBeat.o(142134);
    return local1;
  }
  
  private void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(142144);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(142144);
  }
  
  private void np()
  {
    AppMethodBeat.i(142140);
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.clear();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(142140);
  }
  
  public void buildDrawingCache() {}
  
  public void buildDrawingCache(boolean paramBoolean) {}
  
  public void computeScroll()
  {
    AppMethodBeat.i(142149);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
    AppMethodBeat.o(142149);
  }
  
  public final void gKZ()
  {
    AppMethodBeat.i(142146);
    this.plb.a(this, false);
    this.OST = false;
    scrollTo(0, 0);
    invalidate();
    AppMethodBeat.o(142146);
  }
  
  public final void gLa()
  {
    AppMethodBeat.i(142147);
    int i = getScrollX();
    this.plb.a(this, false);
    this.OST = false;
    this.mScroller.startScroll(i, 0, -i, 0, 100);
    invalidate();
    AppMethodBeat.o(142147);
  }
  
  public Bitmap getDrawingCache()
  {
    return null;
  }
  
  public Bitmap getDrawingCache(boolean paramBoolean)
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142136);
    if (getChildCount() < 2)
    {
      AppMethodBeat.o(142136);
      return;
    }
    int j = getChildCount();
    paramInt1 = 0;
    int i;
    for (paramInt3 = 0; paramInt1 < j; paramInt3 = i)
    {
      View localView = getChildAt(paramInt1);
      i = paramInt3;
      if (localView.getVisibility() != 8)
      {
        i = localView.getMeasuredWidth();
        localView.layout(paramInt3, 0, paramInt3 + i, paramInt4 - paramInt2);
        i = paramInt3 + i;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(142136);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142137);
    if (getChildCount() < 2)
    {
      AppMethodBeat.o(142137);
      return;
    }
    int k = View.MeasureSpec.getSize(paramInt1);
    try
    {
      getChildAt(0).measure(paramInt1, paramInt2);
      label37:
      int j = Math.max(0, getChildAt(0).getMeasuredHeight());
      ViewGroup.LayoutParams localLayoutParams = getChildAt(1).getLayoutParams();
      View localView = getChildAt(1);
      int i = j;
      if (localView != null)
      {
        i = j;
        if (localView.getVisibility() == 8) {}
      }
      try
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
        label113:
        i = Math.max(j, localView.getMeasuredHeight());
        setMeasuredDimension(resolveSize(k, paramInt1), resolveSize(i, paramInt2));
        AppMethodBeat.o(142137);
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException2)
      {
        break label113;
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException1)
    {
      break label37;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142139);
    if (!this.ded)
    {
      AppMethodBeat.o(142139);
      return false;
    }
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((this.plb.ebn()) && (!this.OST))
    {
      Log.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
      this.OSX = false;
      this.plb.ebo();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (this.OSX)
    {
      AppMethodBeat.o(142139);
      return false;
    }
    int j;
    int m;
    switch (i)
    {
    default: 
      if (this.mHandler != null) {
        this.mHandler.removeCallbacks(this.OSY);
      }
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(142139);
        return true;
        if ((getContext() instanceof MMActivity)) {
          ((MMActivity)getContext()).hideVKB();
        }
        this.pPO = false;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.time = System.currentTimeMillis();
        if (this.pkZ != null) {
          this.va = this.pkZ.dr(this);
        }
        if (this.OSU == null) {
          this.OSU = new b();
        }
        this.mHandler.postDelayed(this.OSU, ViewConfiguration.getTapTimeout());
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        if (this.OSY == null) {
          this.OSY = new a((byte)0);
        }
        paramMotionEvent = this.OSY;
        paramMotionEvent.OTb = paramMotionEvent.OTa.getWindowAttachCount();
        this.mHandler.postDelayed(this.OSY, this.OSW);
      }
    case 2: 
      j = (int)(this.mLastMotionX - f1);
      int k = (int)(this.mLastMotionY - f2);
      m = getScrollX();
      if (!this.pPO)
      {
        if ((j < 0) || (Math.abs(j) < this.mTouchSlop / 3)) {
          break label537;
        }
        i = k;
        if (k == 0) {
          i = 1;
        }
        if (Math.abs(j / i) <= 3) {
          break label537;
        }
        i = 1;
        label421:
        if ((i != 0) || (this.OST))
        {
          this.pPO = true;
          lu(true);
        }
      }
      if (this.pPO)
      {
        paramMotionEvent = getChildAt(1);
        if ((paramMotionEvent != null) && (!paramMotionEvent.isShown())) {
          paramMotionEvent.setVisibility(0);
        }
        gKW();
        setPressed(false);
        lu(true);
        if (m + j >= 0) {
          break label543;
        }
        i = -m;
      }
      break;
    }
    for (;;)
    {
      if (this.mHandler != null) {
        this.mHandler.removeCallbacks(this.OSY);
      }
      scrollBy(i, 0);
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      break;
      label537:
      i = 0;
      break label421;
      label543:
      if (m + j > getChildAt(1).getWidth())
      {
        i = getChildAt(1).getWidth() - m;
        continue;
        gKW();
        if ((!this.pPO) && ((isPressed()) || (System.currentTimeMillis() - this.time < 200L)) && (this.pkY != null) && (!this.OST))
        {
          setPressed(true);
          if (this.OSV != null) {
            removeCallbacks(this.OSV);
          }
          this.OSV = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142131);
              MMSlideDelView.this.setPressed(false);
              Log.v("MicroMsg.MMSlideDelView", "onClick");
              MMSlideDelView.b(MMSlideDelView.this).r(MMSlideDelView.this, MMSlideDelView.a(MMSlideDelView.this), 0);
              MMSlideDelView.this.gKZ();
              AppMethodBeat.o(142131);
            }
          };
          this.mHandler.postDelayed(this.OSV, ViewConfiguration.getPressedStateDuration());
        }
        for (;;)
        {
          if (this.pPO) {
            gKX();
          }
          np();
          if (this.mHandler == null) {
            break;
          }
          this.mHandler.removeCallbacks(this.OSY);
          break;
          setPressed(false);
        }
        gKW();
        setPressed(false);
        if (this.pPO) {
          gKX();
        }
        np();
        if (this.mHandler == null) {
          break;
        }
        this.mHandler.removeCallbacks(this.OSY);
        break;
      }
      i = j;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(142141);
    Log.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
    this.OSX = false;
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(142141);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.ded = paramBoolean;
  }
  
  public void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.pkZ = paramc;
  }
  
  public void setItemStatusCallBack(MMSlideDelView.d paramd)
  {
    this.plb = paramd;
  }
  
  public void setOnDelViewShowCallback(e parame)
  {
    this.OSZ = parame;
  }
  
  public void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.pkY = paramg;
  }
  
  public void setView(View paramView)
  {
    AppMethodBeat.i(142138);
    if (getChildCount() == 2) {
      removeViewAt(0);
    }
    addView(paramView, 0, new ViewGroup.LayoutParams(-1, -2));
    AppMethodBeat.o(142138);
  }
  
  final class a
    extends MMSlideDelView.h
    implements Runnable
  {
    private a()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(142132);
      if ((this.OTa.hasWindowFocus()) && (MMSlideDelView.c(this.OTa) == this.OTb)) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (!MMSlideDelView.d(MMSlideDelView.this)))
        {
          Log.i("MicroMsg.MMSlideDelView", "is long press");
          if (MMSlideDelView.this.getParent() != null)
          {
            MMSlideDelView.e(MMSlideDelView.this);
            MMSlideDelView.this.performLongClick();
          }
        }
        AppMethodBeat.o(142132);
        return;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      AppMethodBeat.i(142133);
      Log.v("MicroMsg.MMSlideDelView", "checkfortap");
      MMSlideDelView.this.setPressed(true);
      AppMethodBeat.o(142133);
    }
  }
  
  public static abstract interface e {}
  
  class h
  {
    int OTb;
    
    private h() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView
 * JD-Core Version:    0.7.0.1
 */