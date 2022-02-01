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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MMSlideDelView
  extends ViewGroup
{
  private boolean Wmg;
  private b Wmh;
  private Runnable Wmi;
  private long Wmj;
  private boolean Wmk;
  private a Wml;
  private e Wmm;
  private int bFx;
  private boolean dih;
  private MMHandler mHandler;
  private float mLastMotionX;
  private float mLastMotionY;
  private final Scroller mScroller;
  private final int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private boolean sWP;
  private g snh;
  private c sni;
  private d snk;
  long time;
  
  public MMSlideDelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142135);
    this.sWP = false;
    this.Wmg = false;
    this.dih = true;
    this.Wmk = false;
    this.Wml = null;
    this.mHandler = new MMHandler();
    this.mScroller = new Scroller(paramContext, new LinearInterpolator());
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.Wmj = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(142135);
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
          DWB.add(paramAnonymousMMSlideDelView);
          AppMethodBeat.o(142127);
          return;
        }
        DWB.remove(paramAnonymousMMSlideDelView);
        AppMethodBeat.o(142127);
      }
      
      public final boolean eKl()
      {
        AppMethodBeat.i(142128);
        if (DWB.size() > 0)
        {
          AppMethodBeat.o(142128);
          return true;
        }
        AppMethodBeat.o(142128);
        return false;
      }
      
      public final void eKm()
      {
        AppMethodBeat.i(142129);
        Iterator localIterator = DWB.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.hJY();
          }
        }
        DWB.clear();
        AppMethodBeat.o(142129);
      }
      
      public final void eKn()
      {
        AppMethodBeat.i(142130);
        Iterator localIterator = DWB.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.hJX();
          }
        }
        DWB.clear();
        AppMethodBeat.o(142130);
      }
    };
    AppMethodBeat.o(142134);
    return local1;
  }
  
  private void hJU()
  {
    AppMethodBeat.i(142142);
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.Wmh);
    }
    AppMethodBeat.o(142142);
  }
  
  private void hJV()
  {
    AppMethodBeat.i(142143);
    setPressed(false);
    if (this.Wmg)
    {
      hJY();
      AppMethodBeat.o(142143);
      return;
    }
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    localVelocityTracker.computeCurrentVelocity(1000);
    int i = (int)localVelocityTracker.getXVelocity();
    if (i < -600) {
      hJW();
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.sWP = false;
      mF(false);
      AppMethodBeat.o(142143);
      return;
      if (i > 600) {
        hJY();
      } else {
        hJZ();
      }
    }
  }
  
  private void hJW()
  {
    AppMethodBeat.i(142145);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    this.snk.a(this, true);
    this.Wmg = true;
    this.mScroller.startScroll(i, 0, j - i, 0, 100);
    invalidate();
    AppMethodBeat.o(142145);
  }
  
  private void hJZ()
  {
    AppMethodBeat.i(142148);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    if (i > j / 2)
    {
      this.snk.a(this, true);
      this.Wmg = true;
      this.mScroller.startScroll(i, 0, j - i, 0, 100);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(142148);
      return;
      this.Wmg = false;
      this.snk.a(this, false);
      this.mScroller.startScroll(i, 0, -i, 0, 100);
    }
  }
  
  private void ky()
  {
    AppMethodBeat.i(142140);
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.clear();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(142140);
  }
  
  private void mF(boolean paramBoolean)
  {
    AppMethodBeat.i(142144);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(142144);
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
  
  public Bitmap getDrawingCache()
  {
    return null;
  }
  
  public Bitmap getDrawingCache(boolean paramBoolean)
  {
    return null;
  }
  
  public final void hJX()
  {
    AppMethodBeat.i(142146);
    this.snk.a(this, false);
    this.Wmg = false;
    scrollTo(0, 0);
    invalidate();
    AppMethodBeat.o(142146);
  }
  
  public final void hJY()
  {
    AppMethodBeat.i(142147);
    int i = getScrollX();
    this.snk.a(this, false);
    this.Wmg = false;
    this.mScroller.startScroll(i, 0, -i, 0, 100);
    invalidate();
    AppMethodBeat.o(142147);
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
    if (!this.dih)
    {
      AppMethodBeat.o(142139);
      return false;
    }
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((this.snk.eKl()) && (!this.Wmg))
    {
      Log.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
      this.Wmk = false;
      this.snk.eKm();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (this.Wmk)
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
        this.mHandler.removeCallbacks(this.Wml);
      }
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(142139);
        return true;
        if ((getContext() instanceof MMActivity)) {
          ((MMActivity)getContext()).hideVKB();
        }
        this.sWP = false;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.time = System.currentTimeMillis();
        if (this.sni != null) {
          this.bFx = this.sni.dO(this);
        }
        if (this.Wmh == null) {
          this.Wmh = new b();
        }
        this.mHandler.postDelayed(this.Wmh, ViewConfiguration.getTapTimeout());
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        if (this.Wml == null) {
          this.Wml = new a((byte)0);
        }
        paramMotionEvent = this.Wml;
        paramMotionEvent.Wmo = paramMotionEvent.Wmn.getWindowAttachCount();
        this.mHandler.postDelayed(this.Wml, this.Wmj);
      }
    case 2: 
      j = (int)(this.mLastMotionX - f1);
      int k = (int)(this.mLastMotionY - f2);
      m = getScrollX();
      if (!this.sWP)
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
        if ((i != 0) || (this.Wmg))
        {
          this.sWP = true;
          mF(true);
        }
      }
      if (this.sWP)
      {
        paramMotionEvent = getChildAt(1);
        if ((paramMotionEvent != null) && (!paramMotionEvent.isShown())) {
          paramMotionEvent.setVisibility(0);
        }
        hJU();
        setPressed(false);
        mF(true);
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
        this.mHandler.removeCallbacks(this.Wml);
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
        hJU();
        if ((!this.sWP) && ((isPressed()) || (System.currentTimeMillis() - this.time < 200L)) && (this.snh != null) && (!this.Wmg))
        {
          setPressed(true);
          if (this.Wmi != null) {
            removeCallbacks(this.Wmi);
          }
          this.Wmi = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142131);
              MMSlideDelView.this.setPressed(false);
              Log.v("MicroMsg.MMSlideDelView", "onClick");
              MMSlideDelView.b(MMSlideDelView.this).s(MMSlideDelView.this, MMSlideDelView.a(MMSlideDelView.this), 0);
              MMSlideDelView.this.hJX();
              AppMethodBeat.o(142131);
            }
          };
          this.mHandler.postDelayed(this.Wmi, ViewConfiguration.getPressedStateDuration());
        }
        for (;;)
        {
          if (this.sWP) {
            hJV();
          }
          ky();
          if (this.mHandler == null) {
            break;
          }
          this.mHandler.removeCallbacks(this.Wml);
          break;
          setPressed(false);
        }
        hJU();
        setPressed(false);
        if (this.sWP) {
          hJV();
        }
        ky();
        if (this.mHandler == null) {
          break;
        }
        this.mHandler.removeCallbacks(this.Wml);
        break;
      }
      i = j;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(142141);
    Log.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
    this.Wmk = false;
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(142141);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.dih = paramBoolean;
  }
  
  public void setGetViewPositionCallback(c paramc)
  {
    this.sni = paramc;
  }
  
  public void setItemStatusCallBack(d paramd)
  {
    this.snk = paramd;
  }
  
  public void setOnDelViewShowCallback(e parame)
  {
    this.Wmm = parame;
  }
  
  public void setPerformItemClickListener(g paramg)
  {
    this.snh = paramg;
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
      if ((this.Wmn.hasWindowFocus()) && (MMSlideDelView.c(this.Wmn) == this.Wmo)) {}
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
  
  public static abstract interface c
  {
    public abstract int dO(View paramView);
  }
  
  public static abstract interface d
  {
    public static final Set<MMSlideDelView> DWB = new HashSet();
    
    public abstract void a(MMSlideDelView paramMMSlideDelView, boolean paramBoolean);
    
    public abstract boolean eKl();
    
    public abstract void eKm();
    
    public abstract void eKn();
  }
  
  public static abstract interface e {}
  
  public static abstract interface f
  {
    public abstract void cW(Object paramObject);
  }
  
  public static abstract interface g
  {
    public abstract void s(View paramView, int paramInt1, int paramInt2);
  }
  
  class h
  {
    int Wmo;
    
    private h() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView
 * JD-Core Version:    0.7.0.1
 */