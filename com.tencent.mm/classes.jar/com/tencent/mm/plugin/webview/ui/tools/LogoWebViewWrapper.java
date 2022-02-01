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
  FrameLayout BcW;
  private boolean BcX;
  private int BcY;
  private int BcZ;
  private c Bda;
  private int Bdb;
  boolean Bdc;
  private boolean Bdd;
  private int Bde;
  a Bdf;
  b Bdg;
  private boolean Bdh;
  private boolean Bdi;
  private boolean Bdj;
  private int Bdk;
  private Context context;
  WebView ftD;
  private int mTouchSlop;
  private boolean nou;
  private int startY;
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79590);
    this.BcX = false;
    this.Bdb = 0;
    this.Bdc = false;
    this.Bdd = false;
    this.Bde = 0;
    this.Bdh = false;
    this.Bdi = false;
    this.nou = false;
    this.Bdj = false;
    this.Bdk = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79590);
  }
  
  @TargetApi(11)
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79591);
    this.BcX = false;
    this.Bdb = 0;
    this.Bdc = false;
    this.Bdd = false;
    this.Bde = 0;
    this.Bdh = false;
    this.Bdi = false;
    this.nou = false;
    this.Bdj = false;
    this.Bdk = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79591);
  }
  
  private int getLogoHeight()
  {
    AppMethodBeat.i(79597);
    if (this.Bdk < 0) {
      if (!this.Bdj) {
        break label39;
      }
    }
    label39:
    for (this.Bdk = getHeight();; this.Bdk = ((int)TypedValue.applyDimension(1, 60.0F, this.context.getResources().getDisplayMetrics())))
    {
      int i = this.Bdk;
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
    long l2 = Math.abs(l1 - Math.abs(this.Bde));
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
  
  public final void Tr(int paramInt)
  {
    AppMethodBeat.i(79600);
    int i = getOverScrollDistance();
    scrollTo(0, Math.min(i, Math.max(-i, paramInt)));
    AppMethodBeat.o(79600);
  }
  
  public WebView getWebView()
  {
    return this.ftD;
  }
  
  public FrameLayout getWebViewContainer()
  {
    AppMethodBeat.i(79593);
    int j;
    int i;
    if (this.BcW == null)
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
          this.BcW = ((FrameLayout)localObject);
        }
      }
      else
      {
        localObject = this.BcW;
        AppMethodBeat.o(79593);
        return localObject;
      }
      i += 1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79594);
    if ((this.Bdc) && (!this.Bdh))
    {
      AppMethodBeat.o(79594);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.BcX = false;
      this.Bdb = 0;
      this.Bdi = false;
      AppMethodBeat.o(79594);
      return false;
    }
    if ((i == 2) && (this.BcX))
    {
      AppMethodBeat.o(79594);
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.BcX;
      AppMethodBeat.o(79594);
      return bool;
      if (this.ftD.isOverScrollStart())
      {
        this.BcY = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.BcZ = ((int)paramMotionEvent.getX());
        this.BcX = false;
        this.Bdb = 0;
        this.Bdh = true;
        this.Bdi = true;
        continue;
        if (this.ftD.isOverScrollStart())
        {
          if (!this.Bdi)
          {
            this.BcY = ((int)paramMotionEvent.getY());
            this.startY = ((int)paramMotionEvent.getY());
            this.BcZ = ((int)paramMotionEvent.getX());
            this.BcX = false;
            this.Bdb = 0;
            this.Bdh = true;
            this.Bdi = true;
            bool = this.BcX;
            AppMethodBeat.o(79594);
            return bool;
          }
          i = (int)paramMotionEvent.getY();
          int j = (int)paramMotionEvent.getX();
          int k = i - this.BcY;
          int m = this.BcZ;
          if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) > Math.abs(j - m)) && (k > 0))
          {
            this.BcY = i;
            this.BcZ = j;
            if (this.Bdb == 1)
            {
              this.BcX = true;
              this.Bdi = false;
              ad.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
              if (this.Bdf != null) {
                this.Bdf.enC();
              }
            }
            else
            {
              this.Bdb += 1;
            }
          }
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79595);
    if ((this.Bdc) && (!this.Bdh))
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
          this.Bdh = true;
        } while (!this.ftD.isOverScrollStart());
        this.BcY = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.BcZ = ((int)paramMotionEvent.getX());
        this.nou = true;
        AppMethodBeat.o(79595);
        return true;
      } while (!this.BcX);
      if (!this.nou)
      {
        this.BcY = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.BcZ = ((int)paramMotionEvent.getX());
        this.nou = true;
        AppMethodBeat.o(79595);
        return true;
      }
      this.BcY = ((int)paramMotionEvent.getY());
      this.BcZ = ((int)paramMotionEvent.getX());
      int j = Math.min(this.startY - this.BcY, 0) >> 1;
      int k = getOverScrollDistance();
      int i = (int)Math.sqrt((getLogoHeight() >> 1) * Math.abs(j)) << 1;
      if (i > Math.abs(j))
      {
        i = j;
        if (Math.abs(j) <= k) {}
      }
      for (i = -k;; i = -i)
      {
        Tr(i);
        if (this.Bdg != null) {
          this.Bdg.S(i, true);
        }
        AppMethodBeat.o(79595);
        return true;
      }
      this.nou = false;
    } while ((!this.BcX) && (!this.Bdh));
    this.BcX = false;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79586);
        LogoWebViewWrapper.a(LogoWebViewWrapper.this);
        AppMethodBeat.o(79586);
      }
    });
    r(-this.Bde, getScrollBackDuration());
    AppMethodBeat.o(79595);
    return true;
  }
  
  public final void r(int paramInt, long paramLong)
  {
    AppMethodBeat.i(79601);
    if (this.Bda != null) {
      this.Bda.stop();
    }
    int i = getScrollY();
    ad.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (i != paramInt)
    {
      this.Bda = new c(i, paramInt, paramLong);
      post(this.Bda);
    }
    AppMethodBeat.o(79601);
  }
  
  public void setEasyMod(boolean paramBoolean)
  {
    this.Bdj = paramBoolean;
  }
  
  public void setFastScrollBack(boolean paramBoolean)
  {
    this.Bdd = paramBoolean;
  }
  
  public void setMMOverScrollListener(a parama)
  {
    this.Bdf = parama;
  }
  
  public void setMMOverScrollOffsetListener(b paramb)
  {
    this.Bdg = paramb;
  }
  
  public void setReleaseTargetHeight(int paramInt)
  {
    this.Bde = paramInt;
  }
  
  public final void tr(boolean paramBoolean)
  {
    this.Bdc = paramBoolean;
    if (this.Bdc)
    {
      this.BcX = false;
      this.Bdb = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void enC();
  }
  
  public static abstract interface b
  {
    public abstract void S(int paramInt, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    private final Interpolator Bdm;
    private final int Bdn;
    private final int Bdo;
    private boolean Bdp;
    private final long duration;
    private int nlk;
    private long startTime;
    
    public c(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(79587);
      this.Bdp = true;
      this.startTime = -1L;
      this.nlk = -1;
      this.Bdo = paramInt1;
      this.Bdn = paramInt2;
      if (LogoWebViewWrapper.b(LogoWebViewWrapper.this)) {}
      for (this$1 = new AccelerateInterpolator();; this$1 = new DecelerateInterpolator())
      {
        this.Bdm = LogoWebViewWrapper.this;
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
        if ((this.Bdp) && (this.Bdn != this.nlk)) {
          t.b(LogoWebViewWrapper.this, this);
        }
        AppMethodBeat.o(79588);
        return;
        long l = 500L;
        if (this.duration > 0L) {
          l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / this.duration, 1000L), 0L);
        }
        float f = this.Bdo - this.Bdn;
        int i = Math.round(this.Bdm.getInterpolation((float)l / 1000.0F) * f);
        this.nlk = (this.Bdo - i);
        LogoWebViewWrapper.this.Tr(this.nlk);
        if (LogoWebViewWrapper.c(LogoWebViewWrapper.this) != null) {
          LogoWebViewWrapper.c(LogoWebViewWrapper.this).S(this.nlk, false);
        }
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(79589);
      this.Bdp = false;
      LogoWebViewWrapper.this.removeCallbacks(this);
      AppMethodBeat.o(79589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */