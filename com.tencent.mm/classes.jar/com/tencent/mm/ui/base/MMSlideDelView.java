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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.Set;

public class MMSlideDelView
  extends ViewGroup
{
  private final Scroller GB;
  private float GS;
  private float GT;
  private VelocityTracker fB;
  private MMSlideDelView.g hZd;
  private MMSlideDelView.c hZe;
  private MMSlideDelView.d hZg;
  private boolean ije = false;
  private final int jb;
  private int lJz;
  private boolean lwA = true;
  private ah mHandler = new ah();
  long time;
  private boolean uXM = false;
  private MMSlideDelView.b uXN;
  private Runnable uXO;
  private long uXP;
  private boolean uXQ = false;
  private MMSlideDelView.a uXR = null;
  private e uXS;
  
  public MMSlideDelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.GB = new Scroller(paramContext, new LinearInterpolator());
    this.jb = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.uXP = ViewConfiguration.getLongPressTimeout();
  }
  
  private void cAV()
  {
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.uXN);
    }
  }
  
  private void cAW()
  {
    setPressed(false);
    if (this.uXM)
    {
      cAY();
      return;
    }
    VelocityTracker localVelocityTracker = this.fB;
    localVelocityTracker.computeCurrentVelocity(1000);
    int i = (int)localVelocityTracker.getXVelocity();
    int j;
    if (i < -600)
    {
      i = getScrollX();
      j = getChildAt(1).getWidth();
      this.hZg.a(this, true);
      this.uXM = true;
      this.GB.startScroll(i, 0, j - i, 0, 100);
    }
    for (;;)
    {
      invalidate();
      for (;;)
      {
        if (this.fB != null)
        {
          this.fB.recycle();
          this.fB = null;
        }
        this.ije = false;
        fg(false);
        return;
        if (i <= 600) {
          break;
        }
        cAY();
      }
      i = getScrollX();
      j = getChildAt(1).getWidth();
      if (i > j / 2)
      {
        this.hZg.a(this, true);
        this.uXM = true;
        this.GB.startScroll(i, 0, j - i, 0, 100);
      }
      else
      {
        this.uXM = false;
        this.hZg.a(this, false);
        this.GB.startScroll(i, 0, -i, 0, 100);
      }
    }
  }
  
  private void fg(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public static MMSlideDelView.d getItemStatusCallBack()
  {
    new MMSlideDelView.d()
    {
      public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          lwK.add(paramAnonymousMMSlideDelView);
          return;
        }
        lwK.remove(paramAnonymousMMSlideDelView);
      }
      
      public final boolean bda()
      {
        return lwK.size() > 0;
      }
      
      public final void bdb()
      {
        Iterator localIterator = lwK.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.cAY();
          }
        }
        lwK.clear();
      }
      
      public final void bdc()
      {
        Iterator localIterator = lwK.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.cAX();
          }
        }
        lwK.clear();
      }
    };
  }
  
  private void ji()
  {
    if (this.fB != null)
    {
      this.fB.clear();
      this.fB = null;
    }
  }
  
  public void buildDrawingCache() {}
  
  public void buildDrawingCache(boolean paramBoolean) {}
  
  public final void cAX()
  {
    this.hZg.a(this, false);
    this.uXM = false;
    scrollTo(0, 0);
    invalidate();
  }
  
  public final void cAY()
  {
    int i = getScrollX();
    this.hZg.a(this, false);
    this.uXM = false;
    this.GB.startScroll(i, 0, -i, 0, 100);
    invalidate();
  }
  
  public void computeScroll()
  {
    if (this.GB.computeScrollOffset())
    {
      scrollTo(this.GB.getCurrX(), this.GB.getCurrY());
      postInvalidate();
    }
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
    if (getChildCount() < 2) {}
    for (;;)
    {
      return;
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
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getChildCount() < 2) {
      return;
    }
    int k = View.MeasureSpec.getSize(paramInt1);
    try
    {
      getChildAt(0).measure(paramInt1, paramInt2);
      label25:
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
        label101:
        i = Math.max(j, localView.getMeasuredHeight());
        setMeasuredDimension(resolveSize(k, paramInt1), resolveSize(i, paramInt2));
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException2)
      {
        break label101;
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException1)
    {
      break label25;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.lwA) {
      bool = false;
    }
    int i;
    float f1;
    float f2;
    do
    {
      return bool;
      i = paramMotionEvent.getAction();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      if ((this.hZg.bda()) && (!this.uXM))
      {
        y.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
        this.uXQ = false;
        this.hZg.bdb();
      }
      if (this.fB == null) {
        this.fB = VelocityTracker.obtain();
      }
      this.fB.addMovement(paramMotionEvent);
      if (this.uXQ) {
        return false;
      }
      switch (i)
      {
      }
    } while (this.mHandler == null);
    this.mHandler.removeCallbacks(this.uXR);
    return true;
    if ((getContext() instanceof MMActivity)) {
      ((MMActivity)getContext()).XM();
    }
    this.ije = false;
    if (!this.GB.isFinished()) {
      this.GB.abortAnimation();
    }
    this.time = System.currentTimeMillis();
    if (this.hZe != null) {
      this.lJz = this.hZe.cA(this);
    }
    if (this.uXN == null) {
      this.uXN = new MMSlideDelView.b(this);
    }
    this.mHandler.postDelayed(this.uXN, ViewConfiguration.getTapTimeout());
    this.GS = f1;
    this.GT = f2;
    if (this.uXR == null) {
      this.uXR = new MMSlideDelView.a(this, (byte)0);
    }
    paramMotionEvent = this.uXR;
    paramMotionEvent.uXU = paramMotionEvent.uXT.getWindowAttachCount();
    this.mHandler.postDelayed(this.uXR, this.uXP);
    return true;
    int j = (int)(this.GS - f1);
    int k = (int)(this.GT - f2);
    int m = getScrollX();
    if (!this.ije)
    {
      if ((j < 0) || (Math.abs(j) < this.jb / 3)) {
        break label517;
      }
      i = k;
      if (k == 0) {
        i = 1;
      }
      if (Math.abs(j / i) <= 3) {
        break label517;
      }
      i = 1;
      label402:
      if ((i != 0) || (this.uXM))
      {
        this.ije = true;
        fg(true);
      }
    }
    if (this.ije)
    {
      paramMotionEvent = getChildAt(1);
      if ((paramMotionEvent != null) && (!paramMotionEvent.isShown())) {
        paramMotionEvent.setVisibility(0);
      }
      cAV();
      setPressed(false);
      fg(true);
      if (m + j >= 0) {
        break label523;
      }
      i = -m;
    }
    for (;;)
    {
      if (this.mHandler != null) {
        this.mHandler.removeCallbacks(this.uXR);
      }
      scrollBy(i, 0);
      this.GS = f1;
      this.GT = f2;
      return true;
      label517:
      i = 0;
      break label402;
      label523:
      if (m + j > getChildAt(1).getWidth())
      {
        i = getChildAt(1).getWidth() - m;
        continue;
        cAV();
        if ((!this.ije) && ((isPressed()) || (System.currentTimeMillis() - this.time < 200L)) && (this.hZd != null) && (!this.uXM))
        {
          setPressed(true);
          if (this.uXO != null) {
            removeCallbacks(this.uXO);
          }
          this.uXO = new MMSlideDelView.2(this);
          this.mHandler.postDelayed(this.uXO, ViewConfiguration.getPressedStateDuration());
        }
        for (;;)
        {
          if (this.ije) {
            cAW();
          }
          ji();
          if (this.mHandler == null) {
            break;
          }
          this.mHandler.removeCallbacks(this.uXR);
          return true;
          setPressed(false);
        }
        cAV();
        setPressed(false);
        if (this.ije) {
          cAW();
        }
        ji();
        if (this.mHandler == null) {
          break;
        }
        this.mHandler.removeCallbacks(this.uXR);
        return true;
      }
      i = j;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    y.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
    this.uXQ = false;
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.lwA = paramBoolean;
  }
  
  public void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public void setItemStatusCallBack(MMSlideDelView.d paramd)
  {
    this.hZg = paramd;
  }
  
  public void setOnDelViewShowCallback(e parame)
  {
    this.uXS = parame;
  }
  
  public void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
  
  public void setView(View paramView)
  {
    if (getChildCount() == 2) {
      removeViewAt(0);
    }
    addView(paramView, 0, new ViewGroup.LayoutParams(-1, -2));
  }
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView
 * JD-Core Version:    0.7.0.1
 */