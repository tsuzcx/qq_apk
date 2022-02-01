package com.tencent.mm.plugin.webview.ui.tools;

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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper
  extends LinearLayout
{
  private int EHM;
  private int Grf;
  FrameLayout WSl;
  private boolean WSm;
  private c WSn;
  boolean WSo;
  private boolean WSp;
  private int WSq;
  a WSr;
  b WSs;
  private boolean WSt;
  private boolean WSu;
  private boolean WSv;
  private boolean WSw;
  private int WSx;
  WebView lKd;
  private int mTouchSlop;
  private int waitTimes;
  private int yEA;
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79590);
    this.WSm = false;
    this.waitTimes = 0;
    this.WSo = false;
    this.WSp = false;
    this.WSq = 0;
    this.WSt = false;
    this.WSu = false;
    this.WSv = false;
    this.WSw = false;
    this.WSx = -1;
    init();
    AppMethodBeat.o(79590);
  }
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79591);
    this.WSm = false;
    this.waitTimes = 0;
    this.WSo = false;
    this.WSp = false;
    this.WSq = 0;
    this.WSt = false;
    this.WSu = false;
    this.WSv = false;
    this.WSw = false;
    this.WSx = -1;
    init();
    AppMethodBeat.o(79591);
  }
  
  private int getLogoHeight()
  {
    AppMethodBeat.i(79597);
    if (this.WSx < 0) {
      if (!this.WSw) {
        break label39;
      }
    }
    label39:
    for (this.WSx = getHeight();; this.WSx = ((int)TypedValue.applyDimension(1, 60.0F, getContext().getResources().getDisplayMetrics())))
    {
      int i = this.WSx;
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
    long l2 = Math.abs(l1 - Math.abs(this.WSq));
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
  
  public final void IJ(boolean paramBoolean)
  {
    this.WSo = paramBoolean;
    if (this.WSo)
    {
      this.WSm = false;
      this.waitTimes = 0;
    }
  }
  
  public final void aui(int paramInt)
  {
    AppMethodBeat.i(79600);
    int i = getOverScrollDistance();
    scrollTo(0, Math.min(i, Math.max(-i, paramInt)));
    AppMethodBeat.o(79600);
  }
  
  public WebView getWebView()
  {
    return this.lKd;
  }
  
  public FrameLayout getWebViewContainer()
  {
    AppMethodBeat.i(79593);
    int j;
    int i;
    if (this.WSl == null)
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
          this.WSl = ((FrameLayout)localObject);
        }
      }
      else
      {
        localObject = this.WSl;
        AppMethodBeat.o(79593);
        return localObject;
      }
      i += 1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79594);
    if ((this.WSo) && (!this.WSt))
    {
      AppMethodBeat.o(79594);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.WSm = false;
      this.waitTimes = 0;
      this.WSu = false;
      AppMethodBeat.o(79594);
      return false;
    }
    if ((i == 2) && (this.WSm))
    {
      AppMethodBeat.o(79594);
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.WSm;
      AppMethodBeat.o(79594);
      return bool;
      if (this.lKd.isOverScrollStart())
      {
        this.EHM = ((int)paramMotionEvent.getY());
        this.yEA = ((int)paramMotionEvent.getY());
        this.Grf = ((int)paramMotionEvent.getX());
        this.WSm = false;
        this.waitTimes = 0;
        this.WSt = true;
        this.WSu = true;
        continue;
        if (this.lKd.isOverScrollStart())
        {
          if (!this.WSu)
          {
            this.EHM = ((int)paramMotionEvent.getY());
            this.yEA = ((int)paramMotionEvent.getY());
            this.Grf = ((int)paramMotionEvent.getX());
            this.WSm = false;
            this.waitTimes = 0;
            this.WSt = true;
            this.WSu = true;
            bool = this.WSm;
            AppMethodBeat.o(79594);
            return bool;
          }
          i = (int)paramMotionEvent.getY();
          int j = (int)paramMotionEvent.getX();
          int k = i - this.EHM;
          int m = this.Grf;
          if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) > Math.abs(j - m)) && (k > 0))
          {
            this.EHM = i;
            this.Grf = j;
            if (this.waitTimes == 1)
            {
              this.WSm = true;
              this.WSu = false;
              Log.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
              if (this.WSr != null) {
                this.WSr.ixl();
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
    if ((this.WSo) && (!this.WSt))
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
          this.WSt = true;
        } while (!this.lKd.isOverScrollStart());
        this.EHM = ((int)paramMotionEvent.getY());
        this.yEA = ((int)paramMotionEvent.getY());
        this.Grf = ((int)paramMotionEvent.getX());
        this.WSv = true;
        AppMethodBeat.o(79595);
        return true;
      } while (!this.WSm);
      if (!this.WSv)
      {
        this.EHM = ((int)paramMotionEvent.getY());
        this.yEA = ((int)paramMotionEvent.getY());
        this.Grf = ((int)paramMotionEvent.getX());
        this.WSv = true;
        AppMethodBeat.o(79595);
        return true;
      }
      this.EHM = ((int)paramMotionEvent.getY());
      this.Grf = ((int)paramMotionEvent.getX());
      int j = Math.min(this.yEA - this.EHM, 0) >> 1;
      int k = getOverScrollDistance();
      int i = (int)Math.sqrt((getLogoHeight() >> 1) * Math.abs(j)) << 1;
      if (i > Math.abs(j))
      {
        i = j;
        if (Math.abs(j) <= k) {}
      }
      for (i = -k;; i = -i)
      {
        aui(i);
        if (this.WSs != null) {
          this.WSs.cm(i, true);
        }
        AppMethodBeat.o(79595);
        return true;
      }
      this.WSv = false;
    } while ((!this.WSm) && (!this.WSt));
    this.WSm = false;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79586);
        LogoWebViewWrapper.a(LogoWebViewWrapper.this);
        AppMethodBeat.o(79586);
      }
    });
    if ((this.WSs != null) && (this.WSs.ixm()))
    {
      AppMethodBeat.o(79595);
      return true;
    }
    w(-this.WSq, getScrollBackDuration());
    AppMethodBeat.o(79595);
    return true;
  }
  
  public void setEasyMod(boolean paramBoolean)
  {
    this.WSw = paramBoolean;
  }
  
  public void setFastScrollBack(boolean paramBoolean)
  {
    this.WSp = paramBoolean;
  }
  
  public void setMMOverScrollListener(a parama)
  {
    this.WSr = parama;
  }
  
  public void setMMOverScrollOffsetListener(b paramb)
  {
    this.WSs = paramb;
  }
  
  public void setReleaseTargetHeight(int paramInt)
  {
    this.WSq = paramInt;
  }
  
  public final void w(int paramInt, long paramLong)
  {
    AppMethodBeat.i(79601);
    if (this.WSn != null) {
      this.WSn.stop();
    }
    int i = getScrollY();
    Log.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (i != paramInt)
    {
      this.WSn = new c(i, paramInt, paramLong);
      post(this.WSn);
    }
    AppMethodBeat.o(79601);
  }
  
  public static abstract interface a
  {
    public abstract void ixl();
  }
  
  public static abstract interface b
  {
    public abstract void cm(int paramInt, boolean paramBoolean);
    
    public abstract boolean ixm();
  }
  
  final class c
    implements Runnable
  {
    private final int WSA;
    private final int WSB;
    private boolean WSC;
    private int WSD;
    private final Interpolator WSz;
    private final long duration;
    private long startTime;
    
    public c(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(79587);
      this.WSC = true;
      this.startTime = -1L;
      this.WSD = -1;
      this.WSB = paramInt1;
      this.WSA = paramInt2;
      if (LogoWebViewWrapper.b(LogoWebViewWrapper.this)) {}
      for (this$1 = new AccelerateInterpolator();; this$1 = new DecelerateInterpolator())
      {
        this.WSz = LogoWebViewWrapper.this;
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
        if ((this.WSC) && (this.WSA != this.WSD)) {
          z.b(LogoWebViewWrapper.this, this);
        }
        AppMethodBeat.o(79588);
        return;
        long l = 500L;
        if (this.duration > 0L) {
          l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / this.duration, 1000L), 0L);
        }
        float f = this.WSB - this.WSA;
        int i = Math.round(this.WSz.getInterpolation((float)l / 1000.0F) * f);
        this.WSD = (this.WSB - i);
        LogoWebViewWrapper.this.aui(this.WSD);
        if (LogoWebViewWrapper.c(LogoWebViewWrapper.this) != null) {
          LogoWebViewWrapper.c(LogoWebViewWrapper.this).cm(this.WSD, false);
        }
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(79589);
      this.WSC = false;
      LogoWebViewWrapper.this.removeCallbacks(this);
      AppMethodBeat.o(79589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */