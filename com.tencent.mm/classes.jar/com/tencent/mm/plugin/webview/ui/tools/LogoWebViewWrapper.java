package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper
  extends LinearLayout
{
  private Context context;
  WebView dpt;
  private int jb;
  FrameLayout rkM;
  private boolean rkN = false;
  private int rkO;
  private int rkP;
  private c rkQ;
  private int rkR = 0;
  boolean rkS = false;
  private boolean rkT = false;
  private int rkU = 0;
  LogoWebViewWrapper.a rkV;
  b rkW;
  private boolean rkX = false;
  private boolean rkY = false;
  private boolean rkZ = false;
  private int rla = -1;
  private int startY;
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  @TargetApi(11)
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    init();
  }
  
  private int getLogoHeight()
  {
    if (this.rla < 0) {
      this.rla = ((int)TypedValue.applyDimension(1, 60.0F, this.context.getResources().getDisplayMetrics()));
    }
    return this.rla;
  }
  
  private int getOverScrollDistance()
  {
    return getHeight();
  }
  
  private long getScrollBackDuration()
  {
    long l1 = Math.abs(getScrollY());
    long l2 = Math.abs(l1 - Math.abs(this.rkU));
    if (l2 >= l1) {
      return 300L;
    }
    return ((float)l2 / (float)l1 * 300.0F);
  }
  
  private void init()
  {
    setOrientation(1);
    this.jb = ViewConfiguration.get(this.context).getScaledTouchSlop();
  }
  
  public final void Cv(int paramInt)
  {
    int i = getOverScrollDistance();
    scrollTo(0, Math.min(i, Math.max(-i, paramInt)));
  }
  
  public WebView getWebView()
  {
    return this.dpt;
  }
  
  public FrameLayout getWebViewContainer()
  {
    int j;
    int i;
    if (this.rkM == null)
    {
      j = getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        View localView = getChildAt(i);
        if (((localView instanceof FrameLayout)) && (localView.getId() == R.h.logo_wv_container)) {
          this.rkM = ((FrameLayout)localView);
        }
      }
      else
      {
        return this.rkM;
      }
      i += 1;
    }
  }
  
  public final void lh(boolean paramBoolean)
  {
    this.rkS = paramBoolean;
    if (this.rkS)
    {
      this.rkN = false;
      this.rkR = 0;
    }
  }
  
  public final void o(int paramInt, long paramLong)
  {
    if (this.rkQ != null)
    {
      c localc = this.rkQ;
      localc.rlf = false;
      localc.rlb.removeCallbacks(localc);
    }
    int i = getScrollY();
    y.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (i != paramInt)
    {
      this.rkQ = new c(i, paramInt, paramLong);
      post(this.rkQ);
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.rkS) && (!this.rkX)) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.rkN = false;
      this.rkR = 0;
      this.rkY = false;
      return false;
    }
    if ((i == 2) && (this.rkN)) {
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.rkN;
      if (this.dpt.isOverScrollStart())
      {
        this.rkO = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.rkP = ((int)paramMotionEvent.getX());
        this.rkN = false;
        this.rkR = 0;
        this.rkX = true;
        this.rkY = true;
        continue;
        if (this.dpt.isOverScrollStart())
        {
          if (!this.rkY)
          {
            this.rkO = ((int)paramMotionEvent.getY());
            this.startY = ((int)paramMotionEvent.getY());
            this.rkP = ((int)paramMotionEvent.getX());
            this.rkN = false;
            this.rkR = 0;
            this.rkX = true;
            this.rkY = true;
            return this.rkN;
          }
          i = (int)paramMotionEvent.getY();
          int j = (int)paramMotionEvent.getX();
          int k = i - this.rkO;
          int m = this.rkP;
          if ((Math.abs(k) > this.jb) && (Math.abs(k) > Math.abs(j - m)) && (k > 0))
          {
            this.rkO = i;
            this.rkP = j;
            if (this.rkR == 1)
            {
              this.rkN = true;
              this.rkY = false;
              y.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
              if (this.rkV != null) {
                this.rkV.cdx();
              }
            }
            else
            {
              this.rkR += 1;
            }
          }
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.rkS) && (!this.rkX)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0));
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          case 0: 
            this.rkX = true;
          }
        } while (!this.dpt.isOverScrollStart());
        this.rkO = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.rkP = ((int)paramMotionEvent.getX());
        this.rkZ = true;
        return true;
      } while (!this.rkN);
      if (!this.rkZ)
      {
        this.rkO = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.rkP = ((int)paramMotionEvent.getX());
        this.rkZ = true;
        return true;
      }
      this.rkO = ((int)paramMotionEvent.getY());
      this.rkP = ((int)paramMotionEvent.getX());
      int j = Math.min(this.startY - this.rkO, 0) >> 1;
      int k = getOverScrollDistance();
      int i = (int)Math.sqrt((getLogoHeight() >> 1) * Math.abs(j)) << 1;
      if (i > Math.abs(j))
      {
        i = j;
        if (Math.abs(j) <= k) {}
      }
      for (i = -k;; i = -i)
      {
        Cv(i);
        if (this.rkW != null) {
          this.rkW.ae(i, true);
        }
        return true;
      }
      this.rkZ = false;
    } while ((!this.rkN) && (!this.rkX));
    this.rkN = false;
    o(-this.rkU, getScrollBackDuration());
    post(new LogoWebViewWrapper.1(this));
    return true;
  }
  
  public void setFastScrollBack(boolean paramBoolean)
  {
    this.rkT = paramBoolean;
  }
  
  public void setMMOverScrollListener(LogoWebViewWrapper.a parama)
  {
    this.rkV = parama;
  }
  
  public void setMMOverScrollOffsetListener(b paramb)
  {
    this.rkW = paramb;
  }
  
  public void setReleaseTargetHeight(int paramInt)
  {
    this.rkU = paramInt;
  }
  
  public static abstract interface b
  {
    public abstract void ae(int paramInt, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    private final long duration;
    private final Interpolator rlc;
    private final int rld;
    private final int rle;
    boolean rlf = true;
    private int rlg = -1;
    private long startTime = -1L;
    
    public c(int paramInt1, int paramInt2, long paramLong)
    {
      this.rle = paramInt1;
      this.rld = paramInt2;
      if (LogoWebViewWrapper.b(LogoWebViewWrapper.this)) {}
      for (this$1 = new AccelerateInterpolator();; this$1 = new DecelerateInterpolator())
      {
        this.rlc = LogoWebViewWrapper.this;
        this.duration = paramLong;
        return;
      }
    }
    
    public final void run()
    {
      if (this.startTime == -1L) {
        this.startTime = System.currentTimeMillis();
      }
      for (;;)
      {
        if ((this.rlf) && (this.rld != this.rlg)) {
          q.b(LogoWebViewWrapper.this, this);
        }
        return;
        long l = 500L;
        if (this.duration > 0L) {
          l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / this.duration, 1000L), 0L);
        }
        float f = this.rle - this.rld;
        int i = Math.round(this.rlc.getInterpolation((float)l / 1000.0F) * f);
        this.rlg = (this.rle - i);
        LogoWebViewWrapper.this.Cv(this.rlg);
        if (LogoWebViewWrapper.c(LogoWebViewWrapper.this) != null) {
          LogoWebViewWrapper.c(LogoWebViewWrapper.this).ae(this.rlg, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */