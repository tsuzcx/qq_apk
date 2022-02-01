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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper
  extends LinearLayout
{
  FrameLayout EqR;
  private boolean EqS;
  private int EqT;
  private c EqU;
  private int EqV;
  boolean EqW;
  private boolean EqX;
  private int EqY;
  a EqZ;
  b Era;
  private boolean Erb;
  private boolean Erc;
  private boolean Erd;
  private int Ere;
  private Context context;
  WebView fSD;
  private int mTouchSlop;
  private boolean oAC;
  private int startY;
  private int tbj;
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79590);
    this.EqS = false;
    this.EqV = 0;
    this.EqW = false;
    this.EqX = false;
    this.EqY = 0;
    this.Erb = false;
    this.Erc = false;
    this.oAC = false;
    this.Erd = false;
    this.Ere = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79590);
  }
  
  @TargetApi(11)
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79591);
    this.EqS = false;
    this.EqV = 0;
    this.EqW = false;
    this.EqX = false;
    this.EqY = 0;
    this.Erb = false;
    this.Erc = false;
    this.oAC = false;
    this.Erd = false;
    this.Ere = -1;
    this.context = paramContext;
    init();
    AppMethodBeat.o(79591);
  }
  
  private int getLogoHeight()
  {
    AppMethodBeat.i(79597);
    if (this.Ere < 0) {
      if (!this.Erd) {
        break label39;
      }
    }
    label39:
    for (this.Ere = getHeight();; this.Ere = ((int)TypedValue.applyDimension(1, 60.0F, this.context.getResources().getDisplayMetrics())))
    {
      int i = this.Ere;
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
    long l2 = Math.abs(l1 - Math.abs(this.EqY));
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
  
  public final void XU(int paramInt)
  {
    AppMethodBeat.i(79600);
    int i = getOverScrollDistance();
    scrollTo(0, Math.min(i, Math.max(-i, paramInt)));
    AppMethodBeat.o(79600);
  }
  
  public WebView getWebView()
  {
    return this.fSD;
  }
  
  public FrameLayout getWebViewContainer()
  {
    AppMethodBeat.i(79593);
    int j;
    int i;
    if (this.EqR == null)
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
          this.EqR = ((FrameLayout)localObject);
        }
      }
      else
      {
        localObject = this.EqR;
        AppMethodBeat.o(79593);
        return localObject;
      }
      i += 1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79594);
    if ((this.EqW) && (!this.Erb))
    {
      AppMethodBeat.o(79594);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.EqS = false;
      this.EqV = 0;
      this.Erc = false;
      AppMethodBeat.o(79594);
      return false;
    }
    if ((i == 2) && (this.EqS))
    {
      AppMethodBeat.o(79594);
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.EqS;
      AppMethodBeat.o(79594);
      return bool;
      if (this.fSD.isOverScrollStart())
      {
        this.EqT = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.tbj = ((int)paramMotionEvent.getX());
        this.EqS = false;
        this.EqV = 0;
        this.Erb = true;
        this.Erc = true;
        continue;
        if (this.fSD.isOverScrollStart())
        {
          if (!this.Erc)
          {
            this.EqT = ((int)paramMotionEvent.getY());
            this.startY = ((int)paramMotionEvent.getY());
            this.tbj = ((int)paramMotionEvent.getX());
            this.EqS = false;
            this.EqV = 0;
            this.Erb = true;
            this.Erc = true;
            bool = this.EqS;
            AppMethodBeat.o(79594);
            return bool;
          }
          i = (int)paramMotionEvent.getY();
          int j = (int)paramMotionEvent.getX();
          int k = i - this.EqT;
          int m = this.tbj;
          if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) > Math.abs(j - m)) && (k > 0))
          {
            this.EqT = i;
            this.tbj = j;
            if (this.EqV == 1)
            {
              this.EqS = true;
              this.Erc = false;
              ae.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
              if (this.EqZ != null) {
                this.EqZ.eVy();
              }
            }
            else
            {
              this.EqV += 1;
            }
          }
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79595);
    if ((this.EqW) && (!this.Erb))
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
          this.Erb = true;
        } while (!this.fSD.isOverScrollStart());
        this.EqT = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.tbj = ((int)paramMotionEvent.getX());
        this.oAC = true;
        AppMethodBeat.o(79595);
        return true;
      } while (!this.EqS);
      if (!this.oAC)
      {
        this.EqT = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.tbj = ((int)paramMotionEvent.getX());
        this.oAC = true;
        AppMethodBeat.o(79595);
        return true;
      }
      this.EqT = ((int)paramMotionEvent.getY());
      this.tbj = ((int)paramMotionEvent.getX());
      int j = Math.min(this.startY - this.EqT, 0) >> 1;
      int k = getOverScrollDistance();
      int i = (int)Math.sqrt((getLogoHeight() >> 1) * Math.abs(j)) << 1;
      if (i > Math.abs(j))
      {
        i = j;
        if (Math.abs(j) <= k) {}
      }
      for (i = -k;; i = -i)
      {
        XU(i);
        if (this.Era != null) {
          this.Era.U(i, true);
        }
        AppMethodBeat.o(79595);
        return true;
      }
      this.oAC = false;
    } while ((!this.EqS) && (!this.Erb));
    this.EqS = false;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79586);
        LogoWebViewWrapper.a(LogoWebViewWrapper.this);
        AppMethodBeat.o(79586);
      }
    });
    q(-this.EqY, getScrollBackDuration());
    AppMethodBeat.o(79595);
    return true;
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(79601);
    if (this.EqU != null) {
      this.EqU.stop();
    }
    int i = getScrollY();
    ae.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (i != paramInt)
    {
      this.EqU = new c(i, paramInt, paramLong);
      post(this.EqU);
    }
    AppMethodBeat.o(79601);
  }
  
  public void setEasyMod(boolean paramBoolean)
  {
    this.Erd = paramBoolean;
  }
  
  public void setFastScrollBack(boolean paramBoolean)
  {
    this.EqX = paramBoolean;
  }
  
  public void setMMOverScrollListener(a parama)
  {
    this.EqZ = parama;
  }
  
  public void setMMOverScrollOffsetListener(b paramb)
  {
    this.Era = paramb;
  }
  
  public void setReleaseTargetHeight(int paramInt)
  {
    this.EqY = paramInt;
  }
  
  public final void vm(boolean paramBoolean)
  {
    this.EqW = paramBoolean;
    if (this.EqW)
    {
      this.EqS = false;
      this.EqV = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void eVy();
  }
  
  public static abstract interface b
  {
    public abstract void U(int paramInt, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    private final Interpolator Erg;
    private final int Erh;
    private final int Eri;
    private boolean Erj;
    private final long duration;
    private int oxm;
    private long startTime;
    
    public c(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(79587);
      this.Erj = true;
      this.startTime = -1L;
      this.oxm = -1;
      this.Eri = paramInt1;
      this.Erh = paramInt2;
      if (LogoWebViewWrapper.b(LogoWebViewWrapper.this)) {}
      for (this$1 = new AccelerateInterpolator();; this$1 = new DecelerateInterpolator())
      {
        this.Erg = LogoWebViewWrapper.this;
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
        if ((this.Erj) && (this.Erh != this.oxm)) {
          t.b(LogoWebViewWrapper.this, this);
        }
        AppMethodBeat.o(79588);
        return;
        long l = 500L;
        if (this.duration > 0L) {
          l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / this.duration, 1000L), 0L);
        }
        float f = this.Eri - this.Erh;
        int i = Math.round(this.Erg.getInterpolation((float)l / 1000.0F) * f);
        this.oxm = (this.Eri - i);
        LogoWebViewWrapper.this.XU(this.oxm);
        if (LogoWebViewWrapper.c(LogoWebViewWrapper.this) != null) {
          LogoWebViewWrapper.c(LogoWebViewWrapper.this).U(this.oxm, false);
        }
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(79589);
      this.Erj = false;
      LogoWebViewWrapper.this.removeCallbacks(this);
      AppMethodBeat.o(79589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */