package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.t;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper
  extends LinearLayout
{
  FrameLayout DYP;
  private boolean DYQ;
  private int DYR;
  private c DYS;
  private int DYT;
  boolean DYU;
  private boolean DYV;
  private int DYW;
  a DYX;
  b DYY;
  private boolean DYZ;
  private boolean DZa;
  private boolean DZb;
  private int DZc;
  private Context context;
  WebView fQx;
  private int mTouchSlop;
  private boolean oub;
  private int sPW;
  private int startY;
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79590);
    this.DYQ = false;
    this.DYT = 0;
    this.DYU = false;
    this.DYV = false;
    this.DYW = 0;
    this.DYZ = false;
    this.DZa = false;
    this.oub = false;
    this.DZb = false;
    this.DZc = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79590);
  }
  
  @TargetApi(11)
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79591);
    this.DYQ = false;
    this.DYT = 0;
    this.DYU = false;
    this.DYV = false;
    this.DYW = 0;
    this.DYZ = false;
    this.DZa = false;
    this.oub = false;
    this.DZb = false;
    this.DZc = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79591);
  }
  
  private int getLogoHeight()
  {
    AppMethodBeat.i(79597);
    if (this.DZc < 0) {
      if (!this.DZb) {
        break label39;
      }
    }
    label39:
    for (this.DZc = getHeight();; this.DZc = ((int)TypedValue.applyDimension(1, 60.0F, this.context.getResources().getDisplayMetrics())))
    {
      int i = this.DZc;
      AppMethodBeat.o(79597);
      return i;
    }
  }
  
  private int getOverScrollDistance()
  {
    AppMethodBeat.i(79599);
    int i = getHeight();
    AppMethodBeat.o(79599);
    return i;
  }
  
  private long getScrollBackDuration()
  {
    AppMethodBeat.i(79596);
    long l1 = Math.abs(getScrollY());
    long l2 = Math.abs(l1 - Math.abs(this.DYW));
    if (l2 >= l1)
    {
      AppMethodBeat.o(79596);
      return 300L;
    }
    l1 = ((float)l2 / (float)l1 * 300.0F);
    AppMethodBeat.o(79596);
    return l1;
  }
  
  private void init()
  {
    AppMethodBeat.i(79592);
    setOrientation(1);
    this.mTouchSlop = ViewConfiguration.get(this.context).getScaledTouchSlop();
    AppMethodBeat.o(79592);
  }
  
  public final void Xo(int paramInt)
  {
    AppMethodBeat.i(79600);
    int i = getOverScrollDistance();
    scrollTo(0, Math.min(i, Math.max(-i, paramInt)));
    AppMethodBeat.o(79600);
  }
  
  public WebView getWebView()
  {
    return this.fQx;
  }
  
  public FrameLayout getWebViewContainer()
  {
    AppMethodBeat.i(79593);
    int j;
    int i;
    if (this.DYP == null)
    {
      j = getChildCount();
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i < j)
      {
        localObject = getChildAt(i);
        if (((localObject instanceof FrameLayout)) && (((View)localObject).getId() == 2131301590)) {
          this.DYP = ((FrameLayout)localObject);
        }
      }
      else
      {
        localObject = this.DYP;
        AppMethodBeat.o(79593);
        return localObject;
      }
      i += 1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79594);
    if ((this.DYU) && (!this.DYZ))
    {
      AppMethodBeat.o(79594);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.DYQ = false;
      this.DYT = 0;
      this.DZa = false;
      AppMethodBeat.o(79594);
      return false;
    }
    if ((i == 2) && (this.DYQ))
    {
      AppMethodBeat.o(79594);
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.DYQ;
      AppMethodBeat.o(79594);
      return bool;
      if (this.fQx.isOverScrollStart())
      {
        this.DYR = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.sPW = ((int)paramMotionEvent.getX());
        this.DYQ = false;
        this.DYT = 0;
        this.DYZ = true;
        this.DZa = true;
        continue;
        if (this.fQx.isOverScrollStart())
        {
          if (!this.DZa)
          {
            this.DYR = ((int)paramMotionEvent.getY());
            this.startY = ((int)paramMotionEvent.getY());
            this.sPW = ((int)paramMotionEvent.getX());
            this.DYQ = false;
            this.DYT = 0;
            this.DYZ = true;
            this.DZa = true;
            bool = this.DYQ;
            AppMethodBeat.o(79594);
            return bool;
          }
          i = (int)paramMotionEvent.getY();
          int j = (int)paramMotionEvent.getX();
          int k = i - this.DYR;
          int m = this.sPW;
          if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) > Math.abs(j - m)) && (k > 0))
          {
            this.DYR = i;
            this.sPW = j;
            if (this.DYT == 1)
            {
              this.DYQ = true;
              this.DZa = false;
              ad.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
              if (this.DYX != null) {
                this.DYX.eRM();
              }
            }
            else
            {
              this.DYT += 1;
            }
          }
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79595);
    if ((this.DYU) && (!this.DYZ))
    {
      AppMethodBeat.o(79595);
      return false;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      AppMethodBeat.o(79595);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(79595);
          return false;
          this.DYZ = true;
        } while (!this.fQx.isOverScrollStart());
        this.DYR = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.sPW = ((int)paramMotionEvent.getX());
        this.oub = true;
        AppMethodBeat.o(79595);
        return true;
      } while (!this.DYQ);
      if (!this.oub)
      {
        this.DYR = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.sPW = ((int)paramMotionEvent.getX());
        this.oub = true;
        AppMethodBeat.o(79595);
        return true;
      }
      this.DYR = ((int)paramMotionEvent.getY());
      this.sPW = ((int)paramMotionEvent.getX());
      int j = Math.min(this.startY - this.DYR, 0) >> 1;
      int k = getOverScrollDistance();
      int i = (int)Math.sqrt((getLogoHeight() >> 1) * Math.abs(j)) << 1;
      if (i > Math.abs(j))
      {
        i = j;
        if (Math.abs(j) <= k) {}
      }
      for (i = -k;; i = -i)
      {
        Xo(i);
        if (this.DYY != null) {
          this.DYY.S(i, true);
        }
        AppMethodBeat.o(79595);
        return true;
      }
      this.oub = false;
    } while ((!this.DYQ) && (!this.DYZ));
    this.DYQ = false;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79586);
        LogoWebViewWrapper.a(LogoWebViewWrapper.this);
        AppMethodBeat.o(79586);
      }
    });
    q(-this.DYW, getScrollBackDuration());
    AppMethodBeat.o(79595);
    return true;
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(79601);
    if (this.DYS != null) {
      this.DYS.stop();
    }
    int i = getScrollY();
    ad.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (i != paramInt)
    {
      this.DYS = new c(i, paramInt, paramLong);
      post(this.DYS);
    }
    AppMethodBeat.o(79601);
  }
  
  public void setEasyMod(boolean paramBoolean)
  {
    this.DZb = paramBoolean;
  }
  
  public void setFastScrollBack(boolean paramBoolean)
  {
    this.DYV = paramBoolean;
  }
  
  public void setMMOverScrollListener(a parama)
  {
    this.DYX = parama;
  }
  
  public void setMMOverScrollOffsetListener(b paramb)
  {
    this.DYY = paramb;
  }
  
  public void setReleaseTargetHeight(int paramInt)
  {
    this.DYW = paramInt;
  }
  
  public final void ve(boolean paramBoolean)
  {
    this.DYU = paramBoolean;
    if (this.DYU)
    {
      this.DYQ = false;
      this.DYT = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void eRM();
  }
  
  public static abstract interface b
  {
    public abstract void S(int paramInt, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    private final Interpolator DZe;
    private final int DZf;
    private final int DZg;
    private boolean DZh;
    private final long duration;
    private int oqQ;
    private long startTime;
    
    public c(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(79587);
      this.DZh = true;
      this.startTime = -1L;
      this.oqQ = -1;
      this.DZg = paramInt1;
      this.DZf = paramInt2;
      if (LogoWebViewWrapper.b(LogoWebViewWrapper.this)) {}
      for (this$1 = new AccelerateInterpolator();; this$1 = new DecelerateInterpolator())
      {
        this.DZe = LogoWebViewWrapper.this;
        this.duration = paramLong;
        AppMethodBeat.o(79587);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(79588);
      if (this.startTime == -1L) {
        this.startTime = System.currentTimeMillis();
      }
      for (;;)
      {
        if ((this.DZh) && (this.DZf != this.oqQ)) {
          t.b(LogoWebViewWrapper.this, this);
        }
        AppMethodBeat.o(79588);
        return;
        long l = 500L;
        if (this.duration > 0L) {
          l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / this.duration, 1000L), 0L);
        }
        float f = this.DZg - this.DZf;
        int i = Math.round(this.DZe.getInterpolation((float)l / 1000.0F) * f);
        this.oqQ = (this.DZg - i);
        LogoWebViewWrapper.this.Xo(this.oqQ);
        if (LogoWebViewWrapper.c(LogoWebViewWrapper.this) != null) {
          LogoWebViewWrapper.c(LogoWebViewWrapper.this).S(this.oqQ, false);
        }
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(79589);
      this.DZh = false;
      LogoWebViewWrapper.this.removeCallbacks(this);
      AppMethodBeat.o(79589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */