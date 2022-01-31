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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;

public class j
  extends FrameLayout
{
  View Qz;
  View ixK;
  FrameLayout ixL;
  FrameLayout ixM;
  private boolean ixN;
  private boolean ixO;
  private boolean ixP;
  private boolean ixQ;
  private boolean ixR;
  private int ixS;
  private int ixT;
  private ObjectAnimator ixV;
  private int mTouchSlop;
  private int tW;
  
  public j(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(6158);
    this.ixN = true;
    this.ixO = false;
    this.ixP = false;
    this.ixQ = false;
    this.ixR = false;
    this.ixV = null;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(6158);
  }
  
  private void aJD()
  {
    AppMethodBeat.i(6161);
    pe(0);
    this.ixQ = false;
    this.ixP = false;
    this.ixR = false;
    AppMethodBeat.o(6161);
  }
  
  private int getMaxOverScrollDistance()
  {
    AppMethodBeat.i(6164);
    int i = getHeight();
    AppMethodBeat.o(6164);
    return i;
  }
  
  private void pe(int paramInt)
  {
    AppMethodBeat.i(6167);
    int i = (int)this.ixM.getTranslationY();
    if (i == paramInt)
    {
      AppMethodBeat.o(6167);
      return;
    }
    ab.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (this.ixV != null) {
      this.ixV.cancel();
    }
    long l = (Math.abs(i - paramInt) / getStayHeight() * 250.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.ixM, "translationY", new float[] { i, paramInt });
    localObjectAnimator.setDuration(Math.min(l, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(6157);
        ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        AppMethodBeat.o(6157);
      }
    });
    this.ixV = localObjectAnimator;
    AppMethodBeat.o(6167);
  }
  
  private boolean vq()
  {
    AppMethodBeat.i(6163);
    if ((this.Qz instanceof WebView))
    {
      if (((WebView)this.Qz).getWebScrollY() == 0)
      {
        AppMethodBeat.o(6163);
        return true;
      }
      AppMethodBeat.o(6163);
      return false;
    }
    if (this.Qz.getScrollY() == 0)
    {
      AppMethodBeat.o(6163);
      return true;
    }
    AppMethodBeat.o(6163);
    return false;
  }
  
  protected int getOpenHeight()
  {
    AppMethodBeat.i(6165);
    int i = this.ixK.getHeight();
    AppMethodBeat.o(6165);
    return i;
  }
  
  protected int getStayHeight()
  {
    AppMethodBeat.i(6166);
    int i = this.ixK.getHeight();
    AppMethodBeat.o(6166);
    return i;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(6159);
    if (this.ixN)
    {
      boolean bool = this.ixR;
      AppMethodBeat.o(6159);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      AppMethodBeat.o(6159);
      return false;
    }
    if (this.ixQ)
    {
      AppMethodBeat.o(6159);
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
          AppMethodBeat.o(6159);
          return false;
          if (vq())
          {
            this.ixS = ((int)paramMotionEvent.getX());
            this.ixT = ((int)paramMotionEvent.getY());
            this.tW = ((int)paramMotionEvent.getY());
          }
        }
      } while (!vq());
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      j = this.ixS;
      k -= this.ixT;
    } while ((Math.abs(k) <= this.mTouchSlop) || (Math.abs(k) <= Math.abs(i - j)) || (k <= 0));
    this.ixQ = true;
    AppMethodBeat.o(6159);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(6160);
    if (this.ixN)
    {
      if (this.ixR) {
        aJD();
      }
      boolean bool = this.ixR;
      AppMethodBeat.o(6160);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(6160);
      return false;
    case 0: 
      this.tW = ((int)paramMotionEvent.getY());
      AppMethodBeat.o(6160);
      return true;
    case 2: 
      int k = (int)paramMotionEvent.getY() - this.tW;
      int i = k >> 1;
      int j = getMaxOverScrollDistance();
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        j = i;
        if (this.ixP) {
          j = i + getStayHeight();
        }
        i = Math.max(j, 0);
        ab.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        i = Math.min(getMaxOverScrollDistance(), i);
        this.ixM.setTranslationY(i);
        AppMethodBeat.o(6160);
        return true;
      }
    }
    if ((this.ixM.getTranslationY() > getOpenHeight()) && (this.ixO))
    {
      pe(getStayHeight());
      this.ixQ = true;
      this.ixP = true;
      this.ixR = true;
    }
    for (;;)
    {
      AppMethodBeat.o(6160);
      return true;
      aJD();
    }
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.ixO = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(6162);
    this.ixL.setBackgroundColor(paramInt);
    AppMethodBeat.o(6162);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.ixN = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.j
 * JD-Core Version:    0.7.0.1
 */