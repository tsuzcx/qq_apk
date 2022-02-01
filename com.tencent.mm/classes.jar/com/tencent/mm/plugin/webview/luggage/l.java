package com.tencent.mm.plugin.webview.luggage;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public class l
  extends FrameLayout
{
  private boolean cCE;
  private int cho;
  protected View mContentView;
  private boolean mDisabled;
  private int mTouchSlop;
  protected FrameLayout tsH;
  protected View tyc;
  protected FrameLayout tyd;
  private boolean tye;
  private boolean tyf;
  private boolean tyg;
  private int tyh;
  private int tyi;
  private ObjectAnimator tyk;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(78359);
    this.mDisabled = true;
    this.tye = false;
    this.tyf = false;
    this.tyg = false;
    this.cCE = false;
    this.tyk = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(78359);
  }
  
  private void CH(int paramInt)
  {
    AppMethodBeat.i(78369);
    int i = (int)this.tsH.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(78369);
      return;
    }
    Log.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.tyk != null) {
      this.tyk.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.tsH, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(78358);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        l.this.CG((int)f);
        AppMethodBeat.o(78358);
      }
    });
    this.tyk = localObjectAnimator;
    AppMethodBeat.o(78369);
  }
  
  private boolean apP()
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
      if ((((LinearLayoutManager)((RecyclerView)this.mContentView).getLayoutManager()).Ju() == 0) && (this.mContentView.getScrollY() == 0))
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
  
  protected void CG(int paramInt) {}
  
  protected void cFq()
  {
    AppMethodBeat.i(78363);
    CH(0);
    this.tyg = false;
    this.tyf = false;
    this.cCE = false;
    AppMethodBeat.o(78363);
  }
  
  protected void cFr() {}
  
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
    int i = this.tyc.getHeight();
    AppMethodBeat.o(78367);
    return i;
  }
  
  protected int getStayHeight()
  {
    AppMethodBeat.i(78368);
    int i = this.tyc.getHeight();
    AppMethodBeat.o(78368);
    return i;
  }
  
  public void h(View paramView1, View paramView2)
  {
    AppMethodBeat.i(78360);
    removeAllViews();
    this.tyc = paramView1;
    this.tyd = new FrameLayout(getContext());
    this.tyd.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.tyd.addView(paramView1);
    this.mContentView = paramView2;
    this.tsH = new FrameLayout(getContext());
    this.tsH.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.tsH.addView(paramView2);
    addView(this.tyd);
    addView(this.tsH);
    AppMethodBeat.o(78360);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78361);
    if (this.mDisabled)
    {
      boolean bool = this.cCE;
      AppMethodBeat.o(78361);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      AppMethodBeat.o(78361);
      return false;
    }
    if (this.tyg)
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
          if (apP())
          {
            this.tyh = ((int)paramMotionEvent.getX());
            this.tyi = ((int)paramMotionEvent.getY());
            this.cho = ((int)paramMotionEvent.getY());
          }
        }
      } while (!apP());
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      j = this.tyh;
      k -= this.tyi;
    } while ((Math.abs(k) <= this.mTouchSlop) || (Math.abs(k) <= Math.abs(i - j)) || (k <= 0));
    this.tyg = true;
    AppMethodBeat.o(78361);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78362);
    if (this.mDisabled)
    {
      if (this.cCE) {
        cFq();
      }
      boolean bool = this.cCE;
      AppMethodBeat.o(78362);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(78362);
      return false;
    case 0: 
      this.cho = ((int)paramMotionEvent.getY());
      AppMethodBeat.o(78362);
      return true;
    case 2: 
      int k = (int)paramMotionEvent.getY() - this.cho;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.tyf) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        Log.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.tsH.setTranslationY(j);
        CG(i);
        AppMethodBeat.o(78362);
        return true;
      }
    }
    if ((this.tsH.getTranslationY() > getOpenHeight()) && (this.tye))
    {
      CH(getStayHeight());
      if (!this.tyf) {
        cFr();
      }
      this.tyg = true;
      this.tyf = true;
      this.cCE = true;
    }
    for (;;)
    {
      AppMethodBeat.o(78362);
      return true;
      cFq();
    }
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.tye = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(78364);
    this.tyd.setBackgroundColor(paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l
 * JD-Core Version:    0.7.0.1
 */