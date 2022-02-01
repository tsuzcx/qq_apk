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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper
  extends LinearLayout
{
  FrameLayout Cvi;
  private boolean Cvj;
  private int Cvk;
  private c Cvl;
  private int Cvm;
  boolean Cvn;
  private boolean Cvo;
  private int Cvp;
  a Cvq;
  b Cvr;
  private boolean Cvs;
  private boolean Cvt;
  private boolean Cvu;
  private int Cvv;
  private Context context;
  WebView fxk;
  private int mTouchSlop;
  private boolean nRu;
  private int rTm;
  private int startY;
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79590);
    this.Cvj = false;
    this.Cvm = 0;
    this.Cvn = false;
    this.Cvo = false;
    this.Cvp = 0;
    this.Cvs = false;
    this.Cvt = false;
    this.nRu = false;
    this.Cvu = false;
    this.Cvv = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79590);
  }
  
  @TargetApi(11)
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79591);
    this.Cvj = false;
    this.Cvm = 0;
    this.Cvn = false;
    this.Cvo = false;
    this.Cvp = 0;
    this.Cvs = false;
    this.Cvt = false;
    this.nRu = false;
    this.Cvu = false;
    this.Cvv = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79591);
  }
  
  private int getLogoHeight()
  {
    AppMethodBeat.i(79597);
    if (this.Cvv < 0) {
      if (!this.Cvu) {
        break label39;
      }
    }
    label39:
    for (this.Cvv = getHeight();; this.Cvv = ((int)TypedValue.applyDimension(1, 60.0F, this.context.getResources().getDisplayMetrics())))
    {
      int i = this.Cvv;
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
    long l2 = Math.abs(l1 - Math.abs(this.Cvp));
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
  
  public final void Vz(int paramInt)
  {
    AppMethodBeat.i(79600);
    int i = getOverScrollDistance();
    scrollTo(0, Math.min(i, Math.max(-i, paramInt)));
    AppMethodBeat.o(79600);
  }
  
  public WebView getWebView()
  {
    return this.fxk;
  }
  
  public FrameLayout getWebViewContainer()
  {
    AppMethodBeat.i(79593);
    int j;
    int i;
    if (this.Cvi == null)
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
          this.Cvi = ((FrameLayout)localObject);
        }
      }
      else
      {
        localObject = this.Cvi;
        AppMethodBeat.o(79593);
        return localObject;
      }
      i += 1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79594);
    if ((this.Cvn) && (!this.Cvs))
    {
      AppMethodBeat.o(79594);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.Cvj = false;
      this.Cvm = 0;
      this.Cvt = false;
      AppMethodBeat.o(79594);
      return false;
    }
    if ((i == 2) && (this.Cvj))
    {
      AppMethodBeat.o(79594);
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.Cvj;
      AppMethodBeat.o(79594);
      return bool;
      if (this.fxk.isOverScrollStart())
      {
        this.Cvk = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.rTm = ((int)paramMotionEvent.getX());
        this.Cvj = false;
        this.Cvm = 0;
        this.Cvs = true;
        this.Cvt = true;
        continue;
        if (this.fxk.isOverScrollStart())
        {
          if (!this.Cvt)
          {
            this.Cvk = ((int)paramMotionEvent.getY());
            this.startY = ((int)paramMotionEvent.getY());
            this.rTm = ((int)paramMotionEvent.getX());
            this.Cvj = false;
            this.Cvm = 0;
            this.Cvs = true;
            this.Cvt = true;
            bool = this.Cvj;
            AppMethodBeat.o(79594);
            return bool;
          }
          i = (int)paramMotionEvent.getY();
          int j = (int)paramMotionEvent.getX();
          int k = i - this.Cvk;
          int m = this.rTm;
          if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) > Math.abs(j - m)) && (k > 0))
          {
            this.Cvk = i;
            this.rTm = j;
            if (this.Cvm == 1)
            {
              this.Cvj = true;
              this.Cvt = false;
              ac.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
              if (this.Cvq != null) {
                this.Cvq.eCV();
              }
            }
            else
            {
              this.Cvm += 1;
            }
          }
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79595);
    if ((this.Cvn) && (!this.Cvs))
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
          this.Cvs = true;
        } while (!this.fxk.isOverScrollStart());
        this.Cvk = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.rTm = ((int)paramMotionEvent.getX());
        this.nRu = true;
        AppMethodBeat.o(79595);
        return true;
      } while (!this.Cvj);
      if (!this.nRu)
      {
        this.Cvk = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.rTm = ((int)paramMotionEvent.getX());
        this.nRu = true;
        AppMethodBeat.o(79595);
        return true;
      }
      this.Cvk = ((int)paramMotionEvent.getY());
      this.rTm = ((int)paramMotionEvent.getX());
      int j = Math.min(this.startY - this.Cvk, 0) >> 1;
      int k = getOverScrollDistance();
      int i = (int)Math.sqrt((getLogoHeight() >> 1) * Math.abs(j)) << 1;
      if (i > Math.abs(j))
      {
        i = j;
        if (Math.abs(j) <= k) {}
      }
      for (i = -k;; i = -i)
      {
        Vz(i);
        if (this.Cvr != null) {
          this.Cvr.S(i, true);
        }
        AppMethodBeat.o(79595);
        return true;
      }
      this.nRu = false;
    } while ((!this.Cvj) && (!this.Cvs));
    this.Cvj = false;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79586);
        LogoWebViewWrapper.a(LogoWebViewWrapper.this);
        AppMethodBeat.o(79586);
      }
    });
    q(-this.Cvp, getScrollBackDuration());
    AppMethodBeat.o(79595);
    return true;
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(79601);
    if (this.Cvl != null) {
      this.Cvl.stop();
    }
    int i = getScrollY();
    ac.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (i != paramInt)
    {
      this.Cvl = new c(i, paramInt, paramLong);
      post(this.Cvl);
    }
    AppMethodBeat.o(79601);
  }
  
  public void setEasyMod(boolean paramBoolean)
  {
    this.Cvu = paramBoolean;
  }
  
  public void setFastScrollBack(boolean paramBoolean)
  {
    this.Cvo = paramBoolean;
  }
  
  public void setMMOverScrollListener(a parama)
  {
    this.Cvq = parama;
  }
  
  public void setMMOverScrollOffsetListener(b paramb)
  {
    this.Cvr = paramb;
  }
  
  public void setReleaseTargetHeight(int paramInt)
  {
    this.Cvp = paramInt;
  }
  
  public final void ut(boolean paramBoolean)
  {
    this.Cvn = paramBoolean;
    if (this.Cvn)
    {
      this.Cvj = false;
      this.Cvm = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void eCV();
  }
  
  public static abstract interface b
  {
    public abstract void S(int paramInt, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    private boolean CvA;
    private final Interpolator Cvx;
    private final int Cvy;
    private final int Cvz;
    private final long duration;
    private int nOk;
    private long startTime;
    
    public c(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(79587);
      this.CvA = true;
      this.startTime = -1L;
      this.nOk = -1;
      this.Cvz = paramInt1;
      this.Cvy = paramInt2;
      if (LogoWebViewWrapper.b(LogoWebViewWrapper.this)) {}
      for (this$1 = new AccelerateInterpolator();; this$1 = new DecelerateInterpolator())
      {
        this.Cvx = LogoWebViewWrapper.this;
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
        if ((this.CvA) && (this.Cvy != this.nOk)) {
          t.b(LogoWebViewWrapper.this, this);
        }
        AppMethodBeat.o(79588);
        return;
        long l = 500L;
        if (this.duration > 0L) {
          l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / this.duration, 1000L), 0L);
        }
        float f = this.Cvz - this.Cvy;
        int i = Math.round(this.Cvx.getInterpolation((float)l / 1000.0F) * f);
        this.nOk = (this.Cvz - i);
        LogoWebViewWrapper.this.Vz(this.nOk);
        if (LogoWebViewWrapper.c(LogoWebViewWrapper.this) != null) {
          LogoWebViewWrapper.c(LogoWebViewWrapper.this).S(this.nOk, false);
        }
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(79589);
      this.CvA = false;
      LogoWebViewWrapper.this.removeCallbacks(this);
      AppMethodBeat.o(79589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */