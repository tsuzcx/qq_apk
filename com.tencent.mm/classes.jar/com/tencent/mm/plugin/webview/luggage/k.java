package com.tencent.mm.plugin.webview.luggage;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public class k
  extends FrameLayout
{
  private int Dn;
  protected View mContentView;
  private boolean mDisabled;
  private int mTouchSlop;
  protected FrameLayout nms;
  protected View nrE;
  protected FrameLayout nrF;
  private boolean nrG;
  private boolean nrH;
  private boolean nrI;
  private boolean nrJ;
  private int nrK;
  private int nrL;
  private ObjectAnimator nrN;
  
  public k(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(78359);
    this.mDisabled = true;
    this.nrG = false;
    this.nrH = false;
    this.nrI = false;
    this.nrJ = false;
    this.nrN = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(78359);
  }
  
  private boolean MN()
  {
    AppMethodBeat.i(78365);
    Log.d("MicroMsg.AppBrandPullDownView", "canOverScroll, scrollY = %d, topY = %d", new Object[] { Integer.valueOf(this.mContentView.getScrollY()), Integer.valueOf(this.mContentView.getTop()) });
    if ((this.mContentView instanceof WebView))
    {
      if (((WebView)this.mContentView).getWebScrollY() == 0)
      {
        AppMethodBeat.o(78365);
        return true;
      }
      AppMethodBeat.o(78365);
      return false;
    }
    if ((this.mContentView instanceof RecyclerView))
    {
      if ((((LinearLayoutManager)((RecyclerView)this.mContentView).getLayoutManager()).ks() == 0) && (this.mContentView.getScrollY() == 0))
      {
        AppMethodBeat.o(78365);
        return true;
      }
      AppMethodBeat.o(78365);
      return false;
    }
    if (this.mContentView.getScrollY() == 0)
    {
      AppMethodBeat.o(78365);
      return true;
    }
    AppMethodBeat.o(78365);
    return false;
  }
  
  private void yN(int paramInt)
  {
    AppMethodBeat.i(78369);
    int i = (int)this.nms.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(78369);
      return;
    }
    Log.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.nrN != null) {
      this.nrN.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.nms, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(78358);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        k.this.yM((int)f);
        AppMethodBeat.o(78358);
      }
    });
    this.nrN = localObjectAnimator;
    AppMethodBeat.o(78369);
  }
  
  protected void bRQ()
  {
    AppMethodBeat.i(78363);
    yN(0);
    this.nrI = false;
    this.nrH = false;
    this.nrJ = false;
    AppMethodBeat.o(78363);
  }
  
  protected void bRR() {}
  
  protected int getMaxOverScrollDistance()
  {
    AppMethodBeat.i(78366);
    int i = getHeight();
    AppMethodBeat.o(78366);
    return i;
  }
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(78367);
    int i = this.nrE.getHeight();
    AppMethodBeat.o(78367);
    return i;
  }
  
  protected int getStayHeight()
  {
    AppMethodBeat.i(78368);
    int i = this.nrE.getHeight();
    AppMethodBeat.o(78368);
    return i;
  }
  
  public void l(View paramView1, View paramView2)
  {
    AppMethodBeat.i(78360);
    removeAllViews();
    this.nrE = paramView1;
    this.nrF = new FrameLayout(getContext());
    this.nrF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.nrF.addView(paramView1);
    this.mContentView = paramView2;
    this.nms = new FrameLayout(getContext());
    this.nms.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.nms.addView(paramView2);
    addView(this.nrF);
    addView(this.nms);
    AppMethodBeat.o(78360);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78361);
    if (this.mDisabled)
    {
      boolean bool = this.nrJ;
      AppMethodBeat.o(78361);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      AppMethodBeat.o(78361);
      return false;
    }
    if (this.nrI)
    {
      AppMethodBeat.o(78361);
      return true;
    }
    switch (i)
    {
    }
    int k;
    int j;
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(78361);
          return false;
          if (MN())
          {
            this.nrK = ((int)paramMotionEvent.getX());
            this.nrL = ((int)paramMotionEvent.getY());
            this.Dn = ((int)paramMotionEvent.getY());
          }
        }
      } while (!MN());
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      j = this.nrK;
      k -= this.nrL;
    } while ((Math.abs(k) <= this.mTouchSlop) || (Math.abs(k) <= Math.abs(i - j)) || (k <= 0));
    this.nrI = true;
    AppMethodBeat.o(78361);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78362);
    if (this.mDisabled)
    {
      if (this.nrJ) {
        bRQ();
      }
      boolean bool = this.nrJ;
      AppMethodBeat.o(78362);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(78362);
      return false;
    case 0: 
      this.Dn = ((int)paramMotionEvent.getY());
      AppMethodBeat.o(78362);
      return true;
    case 2: 
      int k = (int)paramMotionEvent.getY() - this.Dn;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.nrH) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        Log.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.nms.setTranslationY(j);
        yM(i);
        AppMethodBeat.o(78362);
        return true;
      }
    }
    if ((this.nms.getTranslationY() > getOpenHeight()) && (this.nrG))
    {
      yN(getStayHeight());
      if (!this.nrH) {
        bRR();
      }
      this.nrI = true;
      this.nrH = true;
      this.nrJ = true;
    }
    for (;;)
    {
      AppMethodBeat.o(78362);
      return true;
      bRQ();
    }
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.nrG = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(78364);
    this.nrF.setBackgroundColor(paramInt);
    AppMethodBeat.o(78364);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mDisabled = paramBoolean;
      return;
    }
  }
  
  protected void yM(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.k
 * JD-Core Version:    0.7.0.1
 */