package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
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
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper
  extends LinearLayout
{
  private int AOM;
  FrameLayout Qba;
  private boolean Qbb;
  private c Qbc;
  boolean Qbd;
  private boolean Qbe;
  private int Qbf;
  a Qbg;
  b Qbh;
  private boolean Qbi;
  private boolean Qbj;
  private boolean Qbk;
  private boolean Qbl;
  private int Qbm;
  WebView jhN;
  private int mTouchSlop;
  private int vsl;
  private int waitTimes;
  private int zDE;
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79590);
    this.Qbb = false;
    this.waitTimes = 0;
    this.Qbd = false;
    this.Qbe = false;
    this.Qbf = 0;
    this.Qbi = false;
    this.Qbj = false;
    this.Qbk = false;
    this.Qbl = false;
    this.Qbm = -1;
    init();
    AppMethodBeat.o(79590);
  }
  
  @TargetApi(11)
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79591);
    this.Qbb = false;
    this.waitTimes = 0;
    this.Qbd = false;
    this.Qbe = false;
    this.Qbf = 0;
    this.Qbi = false;
    this.Qbj = false;
    this.Qbk = false;
    this.Qbl = false;
    this.Qbm = -1;
    init();
    AppMethodBeat.o(79591);
  }
  
  private int getLogoHeight()
  {
    AppMethodBeat.i(79597);
    if (this.Qbm < 0) {
      if (!this.Qbl) {
        break label39;
      }
    }
    label39:
    for (this.Qbm = getHeight();; this.Qbm = ((int)TypedValue.applyDimension(1, 60.0F, getContext().getResources().getDisplayMetrics())))
    {
      int i = this.Qbm;
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
    long l2 = Math.abs(l1 - Math.abs(this.Qbf));
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
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(79592);
  }
  
  public final void Dc(boolean paramBoolean)
  {
    this.Qbd = paramBoolean;
    if (this.Qbd)
    {
      this.Qbb = false;
      this.waitTimes = 0;
    }
  }
  
  public final void aoq(int paramInt)
  {
    AppMethodBeat.i(79600);
    int i = getOverScrollDistance();
    scrollTo(0, Math.min(i, Math.max(-i, paramInt)));
    AppMethodBeat.o(79600);
  }
  
  public WebView getWebView()
  {
    return this.jhN;
  }
  
  public FrameLayout getWebViewContainer()
  {
    AppMethodBeat.i(79593);
    int j;
    int i;
    if (this.Qba == null)
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
        if (((localObject instanceof FrameLayout)) && (((View)localObject).getId() == c.f.logo_wv_container)) {
          this.Qba = ((FrameLayout)localObject);
        }
      }
      else
      {
        localObject = this.Qba;
        AppMethodBeat.o(79593);
        return localObject;
      }
      i += 1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79594);
    if ((this.Qbd) && (!this.Qbi))
    {
      AppMethodBeat.o(79594);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.Qbb = false;
      this.waitTimes = 0;
      this.Qbj = false;
      AppMethodBeat.o(79594);
      return false;
    }
    if ((i == 2) && (this.Qbb))
    {
      AppMethodBeat.o(79594);
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.Qbb;
      AppMethodBeat.o(79594);
      return bool;
      if (this.jhN.isOverScrollStart())
      {
        this.zDE = ((int)paramMotionEvent.getY());
        this.vsl = ((int)paramMotionEvent.getY());
        this.AOM = ((int)paramMotionEvent.getX());
        this.Qbb = false;
        this.waitTimes = 0;
        this.Qbi = true;
        this.Qbj = true;
        continue;
        if (this.jhN.isOverScrollStart())
        {
          if (!this.Qbj)
          {
            this.zDE = ((int)paramMotionEvent.getY());
            this.vsl = ((int)paramMotionEvent.getY());
            this.AOM = ((int)paramMotionEvent.getX());
            this.Qbb = false;
            this.waitTimes = 0;
            this.Qbi = true;
            this.Qbj = true;
            bool = this.Qbb;
            AppMethodBeat.o(79594);
            return bool;
          }
          i = (int)paramMotionEvent.getY();
          int j = (int)paramMotionEvent.getX();
          int k = i - this.zDE;
          int m = this.AOM;
          if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) > Math.abs(j - m)) && (k > 0))
          {
            this.zDE = i;
            this.AOM = j;
            if (this.waitTimes == 1)
            {
              this.Qbb = true;
              this.Qbj = false;
              Log.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
              if (this.Qbg != null) {
                this.Qbg.gXs();
              }
            }
            else
            {
              this.waitTimes += 1;
            }
          }
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79595);
    if ((this.Qbd) && (!this.Qbi))
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
          this.Qbi = true;
        } while (!this.jhN.isOverScrollStart());
        this.zDE = ((int)paramMotionEvent.getY());
        this.vsl = ((int)paramMotionEvent.getY());
        this.AOM = ((int)paramMotionEvent.getX());
        this.Qbk = true;
        AppMethodBeat.o(79595);
        return true;
      } while (!this.Qbb);
      if (!this.Qbk)
      {
        this.zDE = ((int)paramMotionEvent.getY());
        this.vsl = ((int)paramMotionEvent.getY());
        this.AOM = ((int)paramMotionEvent.getX());
        this.Qbk = true;
        AppMethodBeat.o(79595);
        return true;
      }
      this.zDE = ((int)paramMotionEvent.getY());
      this.AOM = ((int)paramMotionEvent.getX());
      int j = Math.min(this.vsl - this.zDE, 0) >> 1;
      int k = getOverScrollDistance();
      int i = (int)Math.sqrt((getLogoHeight() >> 1) * Math.abs(j)) << 1;
      if (i > Math.abs(j))
      {
        i = j;
        if (Math.abs(j) <= k) {}
      }
      for (i = -k;; i = -i)
      {
        aoq(i);
        if (this.Qbh != null) {
          this.Qbh.bE(i, true);
        }
        AppMethodBeat.o(79595);
        return true;
      }
      this.Qbk = false;
    } while ((!this.Qbb) && (!this.Qbi));
    this.Qbb = false;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79586);
        LogoWebViewWrapper.a(LogoWebViewWrapper.this);
        AppMethodBeat.o(79586);
      }
    });
    s(-this.Qbf, getScrollBackDuration());
    AppMethodBeat.o(79595);
    return true;
  }
  
  public final void s(int paramInt, long paramLong)
  {
    AppMethodBeat.i(79601);
    if (this.Qbc != null) {
      this.Qbc.stop();
    }
    int i = getScrollY();
    Log.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (i != paramInt)
    {
      this.Qbc = new c(i, paramInt, paramLong);
      post(this.Qbc);
    }
    AppMethodBeat.o(79601);
  }
  
  public void setEasyMod(boolean paramBoolean)
  {
    this.Qbl = paramBoolean;
  }
  
  public void setFastScrollBack(boolean paramBoolean)
  {
    this.Qbe = paramBoolean;
  }
  
  public void setMMOverScrollListener(a parama)
  {
    this.Qbg = parama;
  }
  
  public void setMMOverScrollOffsetListener(b paramb)
  {
    this.Qbh = paramb;
  }
  
  public void setReleaseTargetHeight(int paramInt)
  {
    this.Qbf = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void gXs();
  }
  
  public static abstract interface b
  {
    public abstract void bE(int paramInt, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    private final Interpolator Qbo;
    private final int Qbp;
    private final int Qbq;
    private boolean Qbr;
    private int Qbs;
    private final long duration;
    private long startTime;
    
    public c(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(79587);
      this.Qbr = true;
      this.startTime = -1L;
      this.Qbs = -1;
      this.Qbq = paramInt1;
      this.Qbp = paramInt2;
      if (LogoWebViewWrapper.b(LogoWebViewWrapper.this)) {}
      for (this$1 = new AccelerateInterpolator();; this$1 = new DecelerateInterpolator())
      {
        this.Qbo = LogoWebViewWrapper.this;
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
        if ((this.Qbr) && (this.Qbp != this.Qbs)) {
          w.a(LogoWebViewWrapper.this, this);
        }
        AppMethodBeat.o(79588);
        return;
        long l = 500L;
        if (this.duration > 0L) {
          l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / this.duration, 1000L), 0L);
        }
        float f = this.Qbq - this.Qbp;
        int i = Math.round(this.Qbo.getInterpolation((float)l / 1000.0F) * f);
        this.Qbs = (this.Qbq - i);
        LogoWebViewWrapper.this.aoq(this.Qbs);
        if (LogoWebViewWrapper.c(LogoWebViewWrapper.this) != null) {
          LogoWebViewWrapper.c(LogoWebViewWrapper.this).bE(this.Qbs, false);
        }
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(79589);
      this.Qbr = false;
      LogoWebViewWrapper.this.removeCallbacks(this);
      AppMethodBeat.o(79589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */