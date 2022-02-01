package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.u;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper
  extends LinearLayout
{
  FrameLayout Jea;
  private boolean Jeb;
  private c Jec;
  boolean Jed;
  private boolean Jee;
  private int Jef;
  a Jeg;
  b Jeh;
  private boolean Jei;
  private boolean Jej;
  private boolean Jek;
  private int Jel;
  private Context context;
  WebView gxL;
  private int mTouchSlop;
  private boolean pOn;
  private int startY;
  private int waitTimes;
  private int wcr;
  private int wqz;
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79590);
    this.Jeb = false;
    this.waitTimes = 0;
    this.Jed = false;
    this.Jee = false;
    this.Jef = 0;
    this.Jei = false;
    this.Jej = false;
    this.pOn = false;
    this.Jek = false;
    this.Jel = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79590);
  }
  
  @TargetApi(11)
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79591);
    this.Jeb = false;
    this.waitTimes = 0;
    this.Jed = false;
    this.Jee = false;
    this.Jef = 0;
    this.Jei = false;
    this.Jej = false;
    this.pOn = false;
    this.Jek = false;
    this.Jel = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79591);
  }
  
  private int getLogoHeight()
  {
    AppMethodBeat.i(79597);
    if (this.Jel < 0) {
      if (!this.Jek) {
        break label39;
      }
    }
    label39:
    for (this.Jel = getHeight();; this.Jel = ((int)TypedValue.applyDimension(1, 60.0F, this.context.getResources().getDisplayMetrics())))
    {
      int i = this.Jel;
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
    long l2 = Math.abs(l1 - Math.abs(this.Jef));
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
  
  public final void agB(int paramInt)
  {
    AppMethodBeat.i(79600);
    int i = getOverScrollDistance();
    scrollTo(0, Math.min(i, Math.max(-i, paramInt)));
    AppMethodBeat.o(79600);
  }
  
  public WebView getWebView()
  {
    return this.gxL;
  }
  
  public FrameLayout getWebViewContainer()
  {
    AppMethodBeat.i(79593);
    int j;
    int i;
    if (this.Jea == null)
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
        if (((localObject instanceof FrameLayout)) && (((View)localObject).getId() == 2131303820)) {
          this.Jea = ((FrameLayout)localObject);
        }
      }
      else
      {
        localObject = this.Jea;
        AppMethodBeat.o(79593);
        return localObject;
      }
      i += 1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79594);
    if ((this.Jed) && (!this.Jei))
    {
      AppMethodBeat.o(79594);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.Jeb = false;
      this.waitTimes = 0;
      this.Jej = false;
      AppMethodBeat.o(79594);
      return false;
    }
    if ((i == 2) && (this.Jeb))
    {
      AppMethodBeat.o(79594);
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.Jeb;
      AppMethodBeat.o(79594);
      return bool;
      if (this.gxL.isOverScrollStart())
      {
        this.wqz = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.wcr = ((int)paramMotionEvent.getX());
        this.Jeb = false;
        this.waitTimes = 0;
        this.Jei = true;
        this.Jej = true;
        continue;
        if (this.gxL.isOverScrollStart())
        {
          if (!this.Jej)
          {
            this.wqz = ((int)paramMotionEvent.getY());
            this.startY = ((int)paramMotionEvent.getY());
            this.wcr = ((int)paramMotionEvent.getX());
            this.Jeb = false;
            this.waitTimes = 0;
            this.Jei = true;
            this.Jej = true;
            bool = this.Jeb;
            AppMethodBeat.o(79594);
            return bool;
          }
          i = (int)paramMotionEvent.getY();
          int j = (int)paramMotionEvent.getX();
          int k = i - this.wqz;
          int m = this.wcr;
          if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) > Math.abs(j - m)) && (k > 0))
          {
            this.wqz = i;
            this.wcr = j;
            if (this.waitTimes == 1)
            {
              this.Jeb = true;
              this.Jej = false;
              Log.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
              if (this.Jeg != null) {
                this.Jeg.geq();
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
    if ((this.Jed) && (!this.Jei))
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
          this.Jei = true;
        } while (!this.gxL.isOverScrollStart());
        this.wqz = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.wcr = ((int)paramMotionEvent.getX());
        this.pOn = true;
        AppMethodBeat.o(79595);
        return true;
      } while (!this.Jeb);
      if (!this.pOn)
      {
        this.wqz = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.wcr = ((int)paramMotionEvent.getX());
        this.pOn = true;
        AppMethodBeat.o(79595);
        return true;
      }
      this.wqz = ((int)paramMotionEvent.getY());
      this.wcr = ((int)paramMotionEvent.getX());
      int j = Math.min(this.startY - this.wqz, 0) >> 1;
      int k = getOverScrollDistance();
      int i = (int)Math.sqrt((getLogoHeight() >> 1) * Math.abs(j)) << 1;
      if (i > Math.abs(j))
      {
        i = j;
        if (Math.abs(j) <= k) {}
      }
      for (i = -k;; i = -i)
      {
        agB(i);
        if (this.Jeh != null) {
          this.Jeh.aa(i, true);
        }
        AppMethodBeat.o(79595);
        return true;
      }
      this.pOn = false;
    } while ((!this.Jeb) && (!this.Jei));
    this.Jeb = false;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79586);
        LogoWebViewWrapper.a(LogoWebViewWrapper.this);
        AppMethodBeat.o(79586);
      }
    });
    s(-this.Jef, getScrollBackDuration());
    AppMethodBeat.o(79595);
    return true;
  }
  
  public final void s(int paramInt, long paramLong)
  {
    AppMethodBeat.i(79601);
    if (this.Jec != null) {
      this.Jec.stop();
    }
    int i = getScrollY();
    Log.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (i != paramInt)
    {
      this.Jec = new c(i, paramInt, paramLong);
      post(this.Jec);
    }
    AppMethodBeat.o(79601);
  }
  
  public void setEasyMod(boolean paramBoolean)
  {
    this.Jek = paramBoolean;
  }
  
  public void setFastScrollBack(boolean paramBoolean)
  {
    this.Jee = paramBoolean;
  }
  
  public void setMMOverScrollListener(a parama)
  {
    this.Jeg = parama;
  }
  
  public void setMMOverScrollOffsetListener(b paramb)
  {
    this.Jeh = paramb;
  }
  
  public void setReleaseTargetHeight(int paramInt)
  {
    this.Jef = paramInt;
  }
  
  public final void zh(boolean paramBoolean)
  {
    this.Jed = paramBoolean;
    if (this.Jed)
    {
      this.Jeb = false;
      this.waitTimes = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void geq();
  }
  
  public static abstract interface b
  {
    public abstract void aa(int paramInt, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    private final Interpolator Jen;
    private final int Jeo;
    private final int Jep;
    private boolean Jeq;
    private final long duration;
    private int pKQ;
    private long startTime;
    
    public c(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(79587);
      this.Jeq = true;
      this.startTime = -1L;
      this.pKQ = -1;
      this.Jep = paramInt1;
      this.Jeo = paramInt2;
      if (LogoWebViewWrapper.b(LogoWebViewWrapper.this)) {}
      for (this$1 = new AccelerateInterpolator();; this$1 = new DecelerateInterpolator())
      {
        this.Jen = LogoWebViewWrapper.this;
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
        if ((this.Jeq) && (this.Jeo != this.pKQ)) {
          u.b(LogoWebViewWrapper.this, this);
        }
        AppMethodBeat.o(79588);
        return;
        long l = 500L;
        if (this.duration > 0L) {
          l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / this.duration, 1000L), 0L);
        }
        float f = this.Jep - this.Jeo;
        int i = Math.round(this.Jen.getInterpolation((float)l / 1000.0F) * f);
        this.pKQ = (this.Jep - i);
        LogoWebViewWrapper.this.agB(this.pKQ);
        if (LogoWebViewWrapper.c(LogoWebViewWrapper.this) != null) {
          LogoWebViewWrapper.c(LogoWebViewWrapper.this).aa(this.pKQ, false);
        }
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(79589);
      this.Jeq = false;
      LogoWebViewWrapper.this.removeCallbacks(this);
      AppMethodBeat.o(79589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */