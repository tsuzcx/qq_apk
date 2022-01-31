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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;

public class MMSlideDelView
  extends ViewGroup
{
  private boolean bTy;
  private MMSlideDelView.g jSb;
  private MMSlideDelView.c jSc;
  private d jSe;
  private boolean kke;
  private int lxQ;
  private ak mHandler;
  private float mLastMotionX;
  private float mLastMotionY;
  private final Scroller mScroller;
  private final int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  long time;
  private boolean zmd;
  private MMSlideDelView.b zme;
  private Runnable zmf;
  private long zmg;
  private boolean zmh;
  private MMSlideDelView.a zmi;
  private e zmj;
  
  public MMSlideDelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106778);
    this.kke = false;
    this.zmd = false;
    this.bTy = true;
    this.zmh = false;
    this.zmi = null;
    this.mHandler = new ak();
    this.mScroller = new Scroller(paramContext, new LinearInterpolator());
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.zmg = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(106778);
  }
  
  private void dEg()
  {
    AppMethodBeat.i(106785);
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.zme);
    }
    AppMethodBeat.o(106785);
  }
  
  private void dEh()
  {
    AppMethodBeat.i(106786);
    setPressed(false);
    if (this.zmd)
    {
      dEk();
      AppMethodBeat.o(106786);
      return;
    }
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    localVelocityTracker.computeCurrentVelocity(1000);
    int i = (int)localVelocityTracker.getXVelocity();
    if (i < -600) {
      dEi();
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.kke = false;
      gH(false);
      AppMethodBeat.o(106786);
      return;
      if (i > 600) {
        dEk();
      } else {
        dEl();
      }
    }
  }
  
  private void dEi()
  {
    AppMethodBeat.i(106788);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    this.jSe.a(this, true);
    this.zmd = true;
    this.mScroller.startScroll(i, 0, j - i, 0, 100);
    invalidate();
    AppMethodBeat.o(106788);
  }
  
  private void dEl()
  {
    AppMethodBeat.i(106791);
    int i = getScrollX();
    int j = getChildAt(1).getWidth();
    if (i > j / 2)
    {
      this.jSe.a(this, true);
      this.zmd = true;
      this.mScroller.startScroll(i, 0, j - i, 0, 100);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(106791);
      return;
      this.zmd = false;
      this.jSe.a(this, false);
      this.mScroller.startScroll(i, 0, -i, 0, 100);
    }
  }
  
  private void gH(boolean paramBoolean)
  {
    AppMethodBeat.i(106787);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(106787);
  }
  
  public static d getItemStatusCallBack()
  {
    AppMethodBeat.i(106777);
    MMSlideDelView.1 local1 = new MMSlideDelView.1();
    AppMethodBeat.o(106777);
    return local1;
  }
  
  private void ld()
  {
    AppMethodBeat.i(106783);
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.clear();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(106783);
  }
  
  public void buildDrawingCache() {}
  
  public void buildDrawingCache(boolean paramBoolean) {}
  
  public void computeScroll()
  {
    AppMethodBeat.i(106792);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
    AppMethodBeat.o(106792);
  }
  
  public final void dEj()
  {
    AppMethodBeat.i(106789);
    this.jSe.a(this, false);
    this.zmd = false;
    scrollTo(0, 0);
    invalidate();
    AppMethodBeat.o(106789);
  }
  
  public final void dEk()
  {
    AppMethodBeat.i(106790);
    int i = getScrollX();
    this.jSe.a(this, false);
    this.zmd = false;
    this.mScroller.startScroll(i, 0, -i, 0, 100);
    invalidate();
    AppMethodBeat.o(106790);
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
    AppMethodBeat.i(106779);
    if (getChildCount() < 2)
    {
      AppMethodBeat.o(106779);
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
    AppMethodBeat.o(106779);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106780);
    if (getChildCount() < 2)
    {
      AppMethodBeat.o(106780);
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
        AppMethodBeat.o(106780);
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
    AppMethodBeat.i(106782);
    if (!this.bTy)
    {
      AppMethodBeat.o(106782);
      return false;
    }
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((this.jSe.bKj()) && (!this.zmd))
    {
      ab.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
      this.zmh = false;
      this.jSe.bKk();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (this.zmh)
    {
      AppMethodBeat.o(106782);
      return false;
    }
    int j;
    int m;
    switch (i)
    {
    default: 
      if (this.mHandler != null) {
        this.mHandler.removeCallbacks(this.zmi);
      }
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(106782);
        return true;
        if ((getContext() instanceof MMActivity)) {
          ((MMActivity)getContext()).hideVKB();
        }
        this.kke = false;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.time = System.currentTimeMillis();
        if (this.jSc != null) {
          this.lxQ = this.jSc.dc(this);
        }
        if (this.zme == null) {
          this.zme = new MMSlideDelView.b(this);
        }
        this.mHandler.postDelayed(this.zme, ViewConfiguration.getTapTimeout());
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        if (this.zmi == null) {
          this.zmi = new MMSlideDelView.a(this, (byte)0);
        }
        paramMotionEvent = this.zmi;
        paramMotionEvent.zml = paramMotionEvent.zmk.getWindowAttachCount();
        this.mHandler.postDelayed(this.zmi, this.zmg);
      }
    case 2: 
      j = (int)(this.mLastMotionX - f1);
      int k = (int)(this.mLastMotionY - f2);
      m = getScrollX();
      if (!this.kke)
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
        if ((i != 0) || (this.zmd))
        {
          this.kke = true;
          gH(true);
        }
      }
      if (this.kke)
      {
        paramMotionEvent = getChildAt(1);
        if ((paramMotionEvent != null) && (!paramMotionEvent.isShown())) {
          paramMotionEvent.setVisibility(0);
        }
        dEg();
        setPressed(false);
        gH(true);
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
        this.mHandler.removeCallbacks(this.zmi);
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
        dEg();
        if ((!this.kke) && ((isPressed()) || (System.currentTimeMillis() - this.time < 200L)) && (this.jSb != null) && (!this.zmd))
        {
          setPressed(true);
          if (this.zmf != null) {
            removeCallbacks(this.zmf);
          }
          this.zmf = new MMSlideDelView.2(this);
          this.mHandler.postDelayed(this.zmf, ViewConfiguration.getPressedStateDuration());
        }
        for (;;)
        {
          if (this.kke) {
            dEh();
          }
          ld();
          if (this.mHandler == null) {
            break;
          }
          this.mHandler.removeCallbacks(this.zmi);
          break;
          setPressed(false);
        }
        dEg();
        setPressed(false);
        if (this.kke) {
          dEh();
        }
        ld();
        if (this.mHandler == null) {
          break;
        }
        this.mHandler.removeCallbacks(this.zmi);
        break;
      }
      i = j;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(106784);
    ab.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
    this.zmh = false;
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(106784);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.bTy = paramBoolean;
  }
  
  public void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public void setItemStatusCallBack(d paramd)
  {
    this.jSe = paramd;
  }
  
  public void setOnDelViewShowCallback(e parame)
  {
    this.zmj = parame;
  }
  
  public void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
  
  public void setView(View paramView)
  {
    AppMethodBeat.i(106781);
    if (getChildCount() == 2) {
      removeViewAt(0);
    }
    addView(paramView, 0, new ViewGroup.LayoutParams(-1, -2));
    AppMethodBeat.o(106781);
  }
  
  public static abstract interface d
  {
    public static final Set<MMSlideDelView> nTX = new HashSet();
    
    public abstract void a(MMSlideDelView paramMMSlideDelView, boolean paramBoolean);
    
    public abstract boolean bKj();
    
    public abstract void bKk();
    
    public abstract void bKl();
  }
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView
 * JD-Core Version:    0.7.0.1
 */