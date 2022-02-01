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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.WebView;

public class j
  extends FrameLayout
{
  private int Bm;
  protected View lDm;
  protected FrameLayout lDn;
  protected FrameLayout lDo;
  private boolean lDp;
  private boolean lDq;
  private boolean lDr;
  private boolean lDs;
  private boolean lDt;
  private int lDu;
  private int lDv;
  private ObjectAnimator lDx;
  protected View mContentView;
  private int mTouchSlop;
  
  public j(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(78359);
    this.lDp = true;
    this.lDq = false;
    this.lDr = false;
    this.lDs = false;
    this.lDt = false;
    this.lDx = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(78359);
  }
  
  private boolean BP()
  {
    AppMethodBeat.i(78365);
    ac.d("MicroMsg.AppBrandPullDownView", "canOverScroll, scrollY = %d, topY = %d", new Object[] { Integer.valueOf(this.mContentView.getScrollY()), Integer.valueOf(this.mContentView.getTop()) });
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
      if ((((LinearLayoutManager)((RecyclerView)this.mContentView).getLayoutManager()).jW() == 0) && (this.mContentView.getScrollY() == 0))
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
  
  private void un(int paramInt)
  {
    AppMethodBeat.i(78369);
    int i = (int)this.lDo.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(78369);
      return;
    }
    ac.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.lDx != null) {
      this.lDx.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.lDo, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(78358);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.um((int)f);
        AppMethodBeat.o(78358);
      }
    });
    this.lDx = localObjectAnimator;
    AppMethodBeat.o(78369);
  }
  
  protected void bqZ()
  {
    AppMethodBeat.i(78363);
    un(0);
    this.lDs = false;
    this.lDr = false;
    this.lDt = false;
    AppMethodBeat.o(78363);
  }
  
  protected void bra() {}
  
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
    int i = this.lDm.getHeight();
    AppMethodBeat.o(78367);
    return i;
  }
  
  protected int getStayHeight()
  {
    AppMethodBeat.i(78368);
    int i = this.lDm.getHeight();
    AppMethodBeat.o(78368);
    return i;
  }
  
  public void j(View paramView1, View paramView2)
  {
    AppMethodBeat.i(78360);
    removeAllViews();
    this.lDm = paramView1;
    this.lDn = new FrameLayout(getContext());
    this.lDn.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.lDn.addView(paramView1);
    this.mContentView = paramView2;
    this.lDo = new FrameLayout(getContext());
    this.lDo.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.lDo.addView(paramView2);
    addView(this.lDn);
    addView(this.lDo);
    AppMethodBeat.o(78360);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78361);
    if (this.lDp)
    {
      boolean bool = this.lDt;
      AppMethodBeat.o(78361);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      AppMethodBeat.o(78361);
      return false;
    }
    if (this.lDs)
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
          if (BP())
          {
            this.lDu = ((int)paramMotionEvent.getX());
            this.lDv = ((int)paramMotionEvent.getY());
            this.Bm = ((int)paramMotionEvent.getY());
          }
        }
      } while (!BP());
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      j = this.lDu;
      k -= this.lDv;
    } while ((Math.abs(k) <= this.mTouchSlop) || (Math.abs(k) <= Math.abs(i - j)) || (k <= 0));
    this.lDs = true;
    AppMethodBeat.o(78361);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78362);
    if (this.lDp)
    {
      if (this.lDt) {
        bqZ();
      }
      boolean bool = this.lDt;
      AppMethodBeat.o(78362);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(78362);
      return false;
    case 0: 
      this.Bm = ((int)paramMotionEvent.getY());
      AppMethodBeat.o(78362);
      return true;
    case 2: 
      int k = (int)paramMotionEvent.getY() - this.Bm;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.lDr) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        ac.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.lDo.setTranslationY(j);
        um(i);
        AppMethodBeat.o(78362);
        return true;
      }
    }
    if ((this.lDo.getTranslationY() > getOpenHeight()) && (this.lDq))
    {
      un(getStayHeight());
      if (!this.lDr) {
        bra();
      }
      this.lDs = true;
      this.lDr = true;
      this.lDt = true;
    }
    for (;;)
    {
      AppMethodBeat.o(78362);
      return true;
      bqZ();
    }
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.lDq = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(78364);
    this.lDn.setBackgroundColor(paramInt);
    AppMethodBeat.o(78364);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.lDp = paramBoolean;
      return;
    }
  }
  
  protected void um(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.j
 * JD-Core Version:    0.7.0.1
 */