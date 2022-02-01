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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;

public class k
  extends FrameLayout
{
  private int De;
  protected View mContentView;
  private int mTouchSlop;
  protected View mcP;
  protected FrameLayout mcQ;
  protected FrameLayout mcR;
  private boolean mcS;
  private boolean mcT;
  private boolean mcU;
  private boolean mcV;
  private boolean mcW;
  private int mcX;
  private int mcY;
  private ObjectAnimator mda;
  
  public k(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(78359);
    this.mcS = true;
    this.mcT = false;
    this.mcU = false;
    this.mcV = false;
    this.mcW = false;
    this.mda = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(78359);
  }
  
  private boolean Do()
  {
    AppMethodBeat.i(78365);
    ad.d("MicroMsg.AppBrandPullDownView", "canOverScroll, scrollY = %d, topY = %d", new Object[] { Integer.valueOf(this.mContentView.getScrollY()), Integer.valueOf(this.mContentView.getTop()) });
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
      if ((((LinearLayoutManager)((RecyclerView)this.mContentView).getLayoutManager()).km() == 0) && (this.mContentView.getScrollY() == 0))
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
  
  private void uR(int paramInt)
  {
    AppMethodBeat.i(78369);
    int i = (int)this.mcR.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(78369);
      return;
    }
    ad.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.mda != null) {
      this.mda.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mcR, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(78358);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        k.this.uQ((int)f);
        AppMethodBeat.o(78358);
      }
    });
    this.mda = localObjectAnimator;
    AppMethodBeat.o(78369);
  }
  
  protected void bva()
  {
    AppMethodBeat.i(78363);
    uR(0);
    this.mcV = false;
    this.mcU = false;
    this.mcW = false;
    AppMethodBeat.o(78363);
  }
  
  protected void bvb() {}
  
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
    int i = this.mcP.getHeight();
    AppMethodBeat.o(78367);
    return i;
  }
  
  protected int getStayHeight()
  {
    AppMethodBeat.i(78368);
    int i = this.mcP.getHeight();
    AppMethodBeat.o(78368);
    return i;
  }
  
  public void k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(78360);
    removeAllViews();
    this.mcP = paramView1;
    this.mcQ = new FrameLayout(getContext());
    this.mcQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mcQ.addView(paramView1);
    this.mContentView = paramView2;
    this.mcR = new FrameLayout(getContext());
    this.mcR.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mcR.addView(paramView2);
    addView(this.mcQ);
    addView(this.mcR);
    AppMethodBeat.o(78360);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78361);
    if (this.mcS)
    {
      boolean bool = this.mcW;
      AppMethodBeat.o(78361);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      AppMethodBeat.o(78361);
      return false;
    }
    if (this.mcV)
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
          if (Do())
          {
            this.mcX = ((int)paramMotionEvent.getX());
            this.mcY = ((int)paramMotionEvent.getY());
            this.De = ((int)paramMotionEvent.getY());
          }
        }
      } while (!Do());
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      j = this.mcX;
      k -= this.mcY;
    } while ((Math.abs(k) <= this.mTouchSlop) || (Math.abs(k) <= Math.abs(i - j)) || (k <= 0));
    this.mcV = true;
    AppMethodBeat.o(78361);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78362);
    if (this.mcS)
    {
      if (this.mcW) {
        bva();
      }
      boolean bool = this.mcW;
      AppMethodBeat.o(78362);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(78362);
      return false;
    case 0: 
      this.De = ((int)paramMotionEvent.getY());
      AppMethodBeat.o(78362);
      return true;
    case 2: 
      int k = (int)paramMotionEvent.getY() - this.De;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.mcU) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        ad.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.mcR.setTranslationY(j);
        uQ(i);
        AppMethodBeat.o(78362);
        return true;
      }
    }
    if ((this.mcR.getTranslationY() > getOpenHeight()) && (this.mcT))
    {
      uR(getStayHeight());
      if (!this.mcU) {
        bvb();
      }
      this.mcV = true;
      this.mcU = true;
      this.mcW = true;
    }
    for (;;)
    {
      AppMethodBeat.o(78362);
      return true;
      bva();
    }
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.mcT = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(78364);
    this.mcQ.setBackgroundColor(paramInt);
    AppMethodBeat.o(78364);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mcS = paramBoolean;
      return;
    }
  }
  
  protected void uQ(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.k
 * JD-Core Version:    0.7.0.1
 */