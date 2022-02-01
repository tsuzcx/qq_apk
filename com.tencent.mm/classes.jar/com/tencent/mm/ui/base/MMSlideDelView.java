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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.Set;

public class MMSlideDelView
  extends ViewGroup
{
  private boolean JIa;
  private b JIb;
  private Runnable JIc;
  private long JId;
  private boolean JIe;
  private a JIf;
  private e JIg;
  private boolean cNF;
  private aq mHandler;
  private float mLastMotionX;
  private float mLastMotionY;
  private final Scroller mScroller;
  private final int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private boolean oCd;
  private MMSlideDelView.g oac;
  private MMSlideDelView.c oad;
  private MMSlideDelView.d oaf;
  long time;
  private int uT;
  
  public MMSlideDelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142135);
    this.oCd = false;
    this.JIa = false;
    this.cNF = true;
    this.JIe = false;
    this.JIf = null;
    this.mHandler = new aq();
    this.mScroller = new Scroller(paramContext, new LinearInterpolator());
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.JId = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(142135);
  }
  
  private void fCV()
  {
    AppMethodBeat.i(142142);
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.JIb);
    }
    AppMethodBeat.o(142142);
  }
  
  private void fCW()
  {
    AppMethodBeat.i(142143);
    setPressed(false);
    if (this.JIa)
    {
      fCZ();
      AppMethodBeat.o(142143);
      return;
    }
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    localVelocityTracker.computeCurrentVelocity(1000);
    int i = (int)localVelocityTracker.getXVelocity();
    if (i < -600) {
      fCX();
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.oCd = false;
      ks(false);
      AppMethodBeat.o(142143);
      return;
      if (i > 600) {
        fCZ();
      } else {
        fDa();
      }
    }
  }
  
  private void fCX()
  {
    AppMethodBeat.i(142145);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    this.oaf.a(this, true);
    this.JIa = true;
    this.mScroller.startScroll(i, 0, j - i, 0, 100);
    invalidate();
    AppMethodBeat.o(142145);
  }
  
  private void fDa()
  {
    AppMethodBeat.i(142148);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    if (i > j / 2)
    {
      this.oaf.a(this, true);
      this.JIa = true;
      this.mScroller.startScroll(i, 0, j - i, 0, 100);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(142148);
      return;
      this.JIa = false;
      this.oaf.a(this, false);
      this.mScroller.startScroll(i, 0, -i, 0, 100);
    }
  }
  
  public static MMSlideDelView.d getItemStatusCallBack()
  {
    AppMethodBeat.i(142134);
    MMSlideDelView.d local1 = new MMSlideDelView.d()
    {
      public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142127);
        if (paramAnonymousBoolean)
        {
          vdX.add(paramAnonymousMMSlideDelView);
          AppMethodBeat.o(142127);
          return;
        }
        vdX.remove(paramAnonymousMMSlideDelView);
        AppMethodBeat.o(142127);
      }
      
      public final boolean dht()
      {
        AppMethodBeat.i(142128);
        if (vdX.size() > 0)
        {
          AppMethodBeat.o(142128);
          return true;
        }
        AppMethodBeat.o(142128);
        return false;
      }
      
      public final void dhu()
      {
        AppMethodBeat.i(142129);
        Iterator localIterator = vdX.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.fCZ();
          }
        }
        vdX.clear();
        AppMethodBeat.o(142129);
      }
      
      public final void dhv()
      {
        AppMethodBeat.i(142130);
        Iterator localIterator = vdX.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.fCY();
          }
        }
        vdX.clear();
        AppMethodBeat.o(142130);
      }
    };
    AppMethodBeat.o(142134);
    return local1;
  }
  
  private void ks(boolean paramBoolean)
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
  
  public final void fCY()
  {
    AppMethodBeat.i(142146);
    this.oaf.a(this, false);
    this.JIa = false;
    scrollTo(0, 0);
    invalidate();
    AppMethodBeat.o(142146);
  }
  
  public final void fCZ()
  {
    AppMethodBeat.i(142147);
    int i = getScrollX();
    this.oaf.a(this, false);
    this.JIa = false;
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
    if (!this.cNF)
    {
      AppMethodBeat.o(142139);
      return false;
    }
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((this.oaf.dht()) && (!this.JIa))
    {
      ae.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
      this.JIe = false;
      this.oaf.dhu();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (this.JIe)
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
        this.mHandler.removeCallbacks(this.JIf);
      }
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(142139);
        return true;
        if ((getContext() instanceof MMActivity)) {
          ((MMActivity)getContext()).hideVKB();
        }
        this.oCd = false;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.time = System.currentTimeMillis();
        if (this.oad != null) {
          this.uT = this.oad.dA(this);
        }
        if (this.JIb == null) {
          this.JIb = new b();
        }
        this.mHandler.postDelayed(this.JIb, ViewConfiguration.getTapTimeout());
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        if (this.JIf == null) {
          this.JIf = new a((byte)0);
        }
        paramMotionEvent = this.JIf;
        paramMotionEvent.JIi = paramMotionEvent.JIh.getWindowAttachCount();
        this.mHandler.postDelayed(this.JIf, this.JId);
      }
    case 2: 
      j = (int)(this.mLastMotionX - f1);
      int k = (int)(this.mLastMotionY - f2);
      m = getScrollX();
      if (!this.oCd)
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
        if ((i != 0) || (this.JIa))
        {
          this.oCd = true;
          ks(true);
        }
      }
      if (this.oCd)
      {
        paramMotionEvent = getChildAt(1);
        if ((paramMotionEvent != null) && (!paramMotionEvent.isShown())) {
          paramMotionEvent.setVisibility(0);
        }
        fCV();
        setPressed(false);
        ks(true);
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
        this.mHandler.removeCallbacks(this.JIf);
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
        fCV();
        if ((!this.oCd) && ((isPressed()) || (System.currentTimeMillis() - this.time < 200L)) && (this.oac != null) && (!this.JIa))
        {
          setPressed(true);
          if (this.JIc != null) {
            removeCallbacks(this.JIc);
          }
          this.JIc = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142131);
              MMSlideDelView.this.setPressed(false);
              ae.v("MicroMsg.MMSlideDelView", "onClick");
              MMSlideDelView.b(MMSlideDelView.this).r(MMSlideDelView.this, MMSlideDelView.a(MMSlideDelView.this), 0);
              MMSlideDelView.this.fCY();
              AppMethodBeat.o(142131);
            }
          };
          this.mHandler.postDelayed(this.JIc, ViewConfiguration.getPressedStateDuration());
        }
        for (;;)
        {
          if (this.oCd) {
            fCW();
          }
          nn();
          if (this.mHandler == null) {
            break;
          }
          this.mHandler.removeCallbacks(this.JIf);
          break;
          setPressed(false);
        }
        fCV();
        setPressed(false);
        if (this.oCd) {
          fCW();
        }
        nn();
        if (this.mHandler == null) {
          break;
        }
        this.mHandler.removeCallbacks(this.JIf);
        break;
      }
      i = j;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(142141);
    ae.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
    this.JIe = false;
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(142141);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.cNF = paramBoolean;
  }
  
  public void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.oad = paramc;
  }
  
  public void setItemStatusCallBack(MMSlideDelView.d paramd)
  {
    this.oaf = paramd;
  }
  
  public void setOnDelViewShowCallback(e parame)
  {
    this.JIg = parame;
  }
  
  public void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.oac = paramg;
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
      if ((this.JIh.hasWindowFocus()) && (MMSlideDelView.c(this.JIh) == this.JIi)) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (!MMSlideDelView.d(MMSlideDelView.this)))
        {
          ae.i("MicroMsg.MMSlideDelView", "is long press");
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
      ae.v("MicroMsg.MMSlideDelView", "checkfortap");
      MMSlideDelView.this.setPressed(true);
      AppMethodBeat.o(142133);
    }
  }
  
  public static abstract interface e {}
  
  class h
  {
    int JIi;
    
    private h() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView
 * JD-Core Version:    0.7.0.1
 */