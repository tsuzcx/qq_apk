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

public class k
  extends FrameLayout
{
  private int asF;
  protected View mContentView;
  private boolean mDisabled;
  private int mTouchSlop;
  protected FrameLayout qoa;
  private boolean qtA;
  private boolean qtB;
  private int qtC;
  private int qtD;
  private ObjectAnimator qtF;
  protected View qtw;
  protected FrameLayout qtx;
  private boolean qty;
  private boolean qtz;
  
  public k(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(78359);
    this.mDisabled = true;
    this.qty = false;
    this.qtz = false;
    this.qtA = false;
    this.qtB = false;
    this.qtF = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(78359);
  }
  
  private void Cr(int paramInt)
  {
    AppMethodBeat.i(78369);
    int i = (int)this.qoa.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(78369);
      return;
    }
    Log.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.qtF != null) {
      this.qtF.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.qoa, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(78358);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        k.this.Cq((int)f);
        AppMethodBeat.o(78358);
      }
    });
    this.qtF = localObjectAnimator;
    AppMethodBeat.o(78369);
  }
  
  private boolean PF()
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
      if ((((LinearLayoutManager)((RecyclerView)this.mContentView).getLayoutManager()).kJ() == 0) && (this.mContentView.getScrollY() == 0))
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
  
  protected void Cq(int paramInt) {}
  
  protected void ceN()
  {
    AppMethodBeat.i(78363);
    Cr(0);
    this.qtA = false;
    this.qtz = false;
    this.qtB = false;
    AppMethodBeat.o(78363);
  }
  
  protected void ceO() {}
  
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
    int i = this.qtw.getHeight();
    AppMethodBeat.o(78367);
    return i;
  }
  
  protected int getStayHeight()
  {
    AppMethodBeat.i(78368);
    int i = this.qtw.getHeight();
    AppMethodBeat.o(78368);
    return i;
  }
  
  public void h(View paramView1, View paramView2)
  {
    AppMethodBeat.i(78360);
    removeAllViews();
    this.qtw = paramView1;
    this.qtx = new FrameLayout(getContext());
    this.qtx.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.qtx.addView(paramView1);
    this.mContentView = paramView2;
    this.qoa = new FrameLayout(getContext());
    this.qoa.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.qoa.addView(paramView2);
    addView(this.qtx);
    addView(this.qoa);
    AppMethodBeat.o(78360);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78361);
    if (this.mDisabled)
    {
      boolean bool = this.qtB;
      AppMethodBeat.o(78361);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      AppMethodBeat.o(78361);
      return false;
    }
    if (this.qtA)
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
          if (PF())
          {
            this.qtC = ((int)paramMotionEvent.getX());
            this.qtD = ((int)paramMotionEvent.getY());
            this.asF = ((int)paramMotionEvent.getY());
          }
        }
      } while (!PF());
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      j = this.qtC;
      k -= this.qtD;
    } while ((Math.abs(k) <= this.mTouchSlop) || (Math.abs(k) <= Math.abs(i - j)) || (k <= 0));
    this.qtA = true;
    AppMethodBeat.o(78361);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78362);
    if (this.mDisabled)
    {
      if (this.qtB) {
        ceN();
      }
      boolean bool = this.qtB;
      AppMethodBeat.o(78362);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(78362);
      return false;
    case 0: 
      this.asF = ((int)paramMotionEvent.getY());
      AppMethodBeat.o(78362);
      return true;
    case 2: 
      int k = (int)paramMotionEvent.getY() - this.asF;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.qtz) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        Log.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.min(getMaxOverScrollDistance(), i);
        this.qoa.setTranslationY(j);
        Cq(i);
        AppMethodBeat.o(78362);
        return true;
      }
    }
    if ((this.qoa.getTranslationY() > getOpenHeight()) && (this.qty))
    {
      Cr(getStayHeight());
      if (!this.qtz) {
        ceO();
      }
      this.qtA = true;
      this.qtz = true;
      this.qtB = true;
    }
    for (;;)
    {
      AppMethodBeat.o(78362);
      return true;
      ceN();
    }
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.qty = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(78364);
    this.qtx.setBackgroundColor(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.k
 * JD-Core Version:    0.7.0.1
 */