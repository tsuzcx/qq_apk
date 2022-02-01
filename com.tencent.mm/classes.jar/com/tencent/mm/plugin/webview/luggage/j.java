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

public class j
  extends FrameLayout
{
  private int Ao;
  private boolean ldA;
  private boolean ldB;
  private boolean ldC;
  private int ldD;
  private int ldE;
  private ObjectAnimator ldG;
  protected View ldv;
  protected FrameLayout ldw;
  protected FrameLayout ldx;
  private boolean ldy;
  private boolean ldz;
  protected View mContentView;
  private int mTouchSlop;
  
  public j(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(78359);
    this.ldy = true;
    this.ldz = false;
    this.ldA = false;
    this.ldB = false;
    this.ldC = false;
    this.ldG = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(78359);
  }
  
  private boolean Cl()
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
      if ((((LinearLayoutManager)((RecyclerView)this.mContentView).getLayoutManager()).jO() == 0) && (this.mContentView.getScrollY() == 0))
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
  
  private void tx(int paramInt)
  {
    AppMethodBeat.i(78369);
    int i = (int)this.ldx.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(78369);
      return;
    }
    ad.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.ldG != null) {
      this.ldG.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.ldx, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(78358);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.tw((int)f);
        AppMethodBeat.o(78358);
      }
    });
    this.ldG = localObjectAnimator;
    AppMethodBeat.o(78369);
  }
  
  protected void bkk()
  {
    AppMethodBeat.i(78363);
    tx(0);
    this.ldB = false;
    this.ldA = false;
    this.ldC = false;
    AppMethodBeat.o(78363);
  }
  
  protected void bkl() {}
  
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
    int i = this.ldv.getHeight();
    AppMethodBeat.o(78367);
    return i;
  }
  
  protected int getStayHeight()
  {
    AppMethodBeat.i(78368);
    int i = this.ldv.getHeight();
    AppMethodBeat.o(78368);
    return i;
  }
  
  public void j(View paramView1, View paramView2)
  {
    AppMethodBeat.i(78360);
    removeAllViews();
    this.ldv = paramView1;
    this.ldw = new FrameLayout(getContext());
    this.ldw.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.ldw.addView(paramView1);
    this.mContentView = paramView2;
    this.ldx = new FrameLayout(getContext());
    this.ldx.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.ldx.addView(paramView2);
    addView(this.ldw);
    addView(this.ldx);
    AppMethodBeat.o(78360);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78361);
    if (this.ldy)
    {
      boolean bool = this.ldC;
      AppMethodBeat.o(78361);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      AppMethodBeat.o(78361);
      return false;
    }
    if (this.ldB)
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
          if (Cl())
          {
            this.ldD = ((int)paramMotionEvent.getX());
            this.ldE = ((int)paramMotionEvent.getY());
            this.Ao = ((int)paramMotionEvent.getY());
          }
        }
      } while (!Cl());
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      j = this.ldD;
      k -= this.ldE;
    } while ((Math.abs(k) <= this.mTouchSlop) || (Math.abs(k) <= Math.abs(i - j)) || (k <= 0));
    this.ldB = true;
    AppMethodBeat.o(78361);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78362);
    if (this.ldy)
    {
      if (this.ldC) {
        bkk();
      }
      boolean bool = this.ldC;
      AppMethodBeat.o(78362);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(78362);
      return false;
    case 0: 
      this.Ao = ((int)paramMotionEvent.getY());
      AppMethodBeat.o(78362);
      return true;
    case 2: 
      int k = (int)paramMotionEvent.getY() - this.Ao;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.ldA) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        ad.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.ldx.setTranslationY(j);
        tw(i);
        AppMethodBeat.o(78362);
        return true;
      }
    }
    if ((this.ldx.getTranslationY() > getOpenHeight()) && (this.ldz))
    {
      tx(getStayHeight());
      if (!this.ldA) {
        bkl();
      }
      this.ldB = true;
      this.ldA = true;
      this.ldC = true;
    }
    for (;;)
    {
      AppMethodBeat.o(78362);
      return true;
      bkk();
    }
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.ldz = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(78364);
    this.ldw.setBackgroundColor(paramInt);
    AppMethodBeat.o(78364);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.ldy = paramBoolean;
      return;
    }
  }
  
  protected void tw(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.j
 * JD-Core Version:    0.7.0.1
 */