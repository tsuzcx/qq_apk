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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MMSlideDelView
  extends ViewGroup
{
  private boolean Jnl;
  private b Jnm;
  private Runnable Jnn;
  private long Jno;
  private boolean Jnp;
  private a Jnq;
  private e Jnr;
  private boolean cMW;
  private ap mHandler;
  private float mLastMotionX;
  private float mLastMotionY;
  private final Scroller mScroller;
  private final int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private g nUw;
  private c nUx;
  private d nUz;
  private boolean ovC;
  long time;
  private int uT;
  
  public MMSlideDelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142135);
    this.ovC = false;
    this.Jnl = false;
    this.cMW = true;
    this.Jnp = false;
    this.Jnq = null;
    this.mHandler = new ap();
    this.mScroller = new Scroller(paramContext, new LinearInterpolator());
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.Jno = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(142135);
  }
  
  private void fyT()
  {
    AppMethodBeat.i(142142);
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.Jnm);
    }
    AppMethodBeat.o(142142);
  }
  
  private void fyU()
  {
    AppMethodBeat.i(142143);
    setPressed(false);
    if (this.Jnl)
    {
      fyX();
      AppMethodBeat.o(142143);
      return;
    }
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    localVelocityTracker.computeCurrentVelocity(1000);
    int i = (int)localVelocityTracker.getXVelocity();
    if (i < -600) {
      fyV();
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.ovC = false;
      kt(false);
      AppMethodBeat.o(142143);
      return;
      if (i > 600) {
        fyX();
      } else {
        fyY();
      }
    }
  }
  
  private void fyV()
  {
    AppMethodBeat.i(142145);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    this.nUz.a(this, true);
    this.Jnl = true;
    this.mScroller.startScroll(i, 0, j - i, 0, 100);
    invalidate();
    AppMethodBeat.o(142145);
  }
  
  private void fyY()
  {
    AppMethodBeat.i(142148);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    if (i > j / 2)
    {
      this.nUz.a(this, true);
      this.Jnl = true;
      this.mScroller.startScroll(i, 0, j - i, 0, 100);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(142148);
      return;
      this.Jnl = false;
      this.nUz.a(this, false);
      this.mScroller.startScroll(i, 0, -i, 0, 100);
    }
  }
  
  public static d getItemStatusCallBack()
  {
    AppMethodBeat.i(142134);
    d local1 = new d()
    {
      public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142127);
        if (paramAnonymousBoolean)
        {
          uSl.add(paramAnonymousMMSlideDelView);
          AppMethodBeat.o(142127);
          return;
        }
        uSl.remove(paramAnonymousMMSlideDelView);
        AppMethodBeat.o(142127);
      }
      
      public final boolean deB()
      {
        AppMethodBeat.i(142128);
        if (uSl.size() > 0)
        {
          AppMethodBeat.o(142128);
          return true;
        }
        AppMethodBeat.o(142128);
        return false;
      }
      
      public final void deC()
      {
        AppMethodBeat.i(142129);
        Iterator localIterator = uSl.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.fyX();
          }
        }
        uSl.clear();
        AppMethodBeat.o(142129);
      }
      
      public final void deD()
      {
        AppMethodBeat.i(142130);
        Iterator localIterator = uSl.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.fyW();
          }
        }
        uSl.clear();
        AppMethodBeat.o(142130);
      }
    };
    AppMethodBeat.o(142134);
    return local1;
  }
  
  private void kt(boolean paramBoolean)
  {
    AppMethodBeat.i(142144);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(142144);
  }
  
  private void nn()
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
  
  public final void fyW()
  {
    AppMethodBeat.i(142146);
    this.nUz.a(this, false);
    this.Jnl = false;
    scrollTo(0, 0);
    invalidate();
    AppMethodBeat.o(142146);
  }
  
  public final void fyX()
  {
    AppMethodBeat.i(142147);
    int i = getScrollX();
    this.nUz.a(this, false);
    this.Jnl = false;
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
    if (!this.cMW)
    {
      AppMethodBeat.o(142139);
      return false;
    }
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((this.nUz.deB()) && (!this.Jnl))
    {
      ad.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
      this.Jnp = false;
      this.nUz.deC();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (this.Jnp)
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
        this.mHandler.removeCallbacks(this.Jnq);
      }
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(142139);
        return true;
        if ((getContext() instanceof MMActivity)) {
          ((MMActivity)getContext()).hideVKB();
        }
        this.ovC = false;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.time = System.currentTimeMillis();
        if (this.nUx != null) {
          this.uT = this.nUx.dA(this);
        }
        if (this.Jnm == null) {
          this.Jnm = new b();
        }
        this.mHandler.postDelayed(this.Jnm, ViewConfiguration.getTapTimeout());
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        if (this.Jnq == null) {
          this.Jnq = new a((byte)0);
        }
        paramMotionEvent = this.Jnq;
        paramMotionEvent.Jnt = paramMotionEvent.Jns.getWindowAttachCount();
        this.mHandler.postDelayed(this.Jnq, this.Jno);
      }
    case 2: 
      j = (int)(this.mLastMotionX - f1);
      int k = (int)(this.mLastMotionY - f2);
      m = getScrollX();
      if (!this.ovC)
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
        if ((i != 0) || (this.Jnl))
        {
          this.ovC = true;
          kt(true);
        }
      }
      if (this.ovC)
      {
        paramMotionEvent = getChildAt(1);
        if ((paramMotionEvent != null) && (!paramMotionEvent.isShown())) {
          paramMotionEvent.setVisibility(0);
        }
        fyT();
        setPressed(false);
        kt(true);
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
        this.mHandler.removeCallbacks(this.Jnq);
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
        fyT();
        if ((!this.ovC) && ((isPressed()) || (System.currentTimeMillis() - this.time < 200L)) && (this.nUw != null) && (!this.Jnl))
        {
          setPressed(true);
          if (this.Jnn != null) {
            removeCallbacks(this.Jnn);
          }
          this.Jnn = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142131);
              MMSlideDelView.this.setPressed(false);
              ad.v("MicroMsg.MMSlideDelView", "onClick");
              MMSlideDelView.b(MMSlideDelView.this).s(MMSlideDelView.this, MMSlideDelView.a(MMSlideDelView.this), 0);
              MMSlideDelView.this.fyW();
              AppMethodBeat.o(142131);
            }
          };
          this.mHandler.postDelayed(this.Jnn, ViewConfiguration.getPressedStateDuration());
        }
        for (;;)
        {
          if (this.ovC) {
            fyU();
          }
          nn();
          if (this.mHandler == null) {
            break;
          }
          this.mHandler.removeCallbacks(this.Jnq);
          break;
          setPressed(false);
        }
        fyT();
        setPressed(false);
        if (this.ovC) {
          fyU();
        }
        nn();
        if (this.mHandler == null) {
          break;
        }
        this.mHandler.removeCallbacks(this.Jnq);
        break;
      }
      i = j;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(142141);
    ad.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
    this.Jnp = false;
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(142141);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.cMW = paramBoolean;
  }
  
  public void setGetViewPositionCallback(c paramc)
  {
    this.nUx = paramc;
  }
  
  public void setItemStatusCallBack(d paramd)
  {
    this.nUz = paramd;
  }
  
  public void setOnDelViewShowCallback(e parame)
  {
    this.Jnr = parame;
  }
  
  public void setPerformItemClickListener(g paramg)
  {
    this.nUw = paramg;
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
      if ((this.Jns.hasWindowFocus()) && (MMSlideDelView.c(this.Jns) == this.Jnt)) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (!MMSlideDelView.d(MMSlideDelView.this)))
        {
          ad.i("MicroMsg.MMSlideDelView", "is long press");
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
      ad.v("MicroMsg.MMSlideDelView", "checkfortap");
      MMSlideDelView.this.setPressed(true);
      AppMethodBeat.o(142133);
    }
  }
  
  public static abstract interface c
  {
    public abstract int dA(View paramView);
  }
  
  public static abstract interface d
  {
    public static final Set<MMSlideDelView> uSl = new HashSet();
    
    public abstract void a(MMSlideDelView paramMMSlideDelView, boolean paramBoolean);
    
    public abstract boolean deB();
    
    public abstract void deC();
    
    public abstract void deD();
  }
  
  public static abstract interface e {}
  
  public static abstract interface f
  {
    public abstract void cP(Object paramObject);
  }
  
  public static abstract interface g
  {
    public abstract void s(View paramView, int paramInt1, int paramInt2);
  }
  
  class h
  {
    int Jnt;
    
    private h() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView
 * JD-Core Version:    0.7.0.1
 */