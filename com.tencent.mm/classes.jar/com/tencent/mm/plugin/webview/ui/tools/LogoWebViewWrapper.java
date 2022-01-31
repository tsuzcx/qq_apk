package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper
  extends LinearLayout
{
  private Context context;
  WebView egP;
  private int mTouchSlop;
  private int startY;
  private boolean vaA;
  private boolean vaB;
  private int vaC;
  private boolean vaD;
  FrameLayout van;
  private boolean vao;
  private int vap;
  private int vaq;
  private LogoWebViewWrapper.c var;
  private int vas;
  boolean vat;
  private boolean vau;
  private int vav;
  LogoWebViewWrapper.a vaw;
  LogoWebViewWrapper.b vax;
  private boolean vay;
  private boolean vaz;
  
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7395);
    this.vao = false;
    this.vas = 0;
    this.vat = false;
    this.vau = false;
    this.vav = 0;
    this.vay = false;
    this.vaz = false;
    this.vaA = false;
    this.vaB = false;
    this.vaC = -1;
    this.vaD = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(7395);
  }
  
  @TargetApi(11)
  public LogoWebViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7396);
    this.vao = false;
    this.vas = 0;
    this.vat = false;
    this.vau = false;
    this.vav = 0;
    this.vay = false;
    this.vaz = false;
    this.vaA = false;
    this.vaB = false;
    this.vaC = -1;
    this.vaD = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(7396);
  }
  
  private boolean ddw()
  {
    AppMethodBeat.i(154611);
    if (this.vaD)
    {
      AppMethodBeat.o(154611);
      return true;
    }
    boolean bool = this.egP.isOverScrollStart();
    AppMethodBeat.o(154611);
    return bool;
  }
  
  private int getLogoHeight()
  {
    AppMethodBeat.i(7402);
    if (this.vaC < 0) {
      if (!this.vaB) {
        break label41;
      }
    }
    label41:
    for (this.vaC = getHeight();; this.vaC = ((int)TypedValue.applyDimension(1, 60.0F, this.context.getResources().getDisplayMetrics())))
    {
      int i = this.vaC;
      AppMethodBeat.o(7402);
      return i;
    }
  }
  
  private int getOverScrollDistance()
  {
    AppMethodBeat.i(7403);
    int i = getHeight();
    AppMethodBeat.o(7403);
    return i;
  }
  
  private long getScrollBackDuration()
  {
    AppMethodBeat.i(7401);
    long l1 = Math.abs(getScrollY());
    long l2 = Math.abs(l1 - Math.abs(this.vav));
    if (l2 >= l1)
    {
      AppMethodBeat.o(7401);
      return 300L;
    }
    l1 = ((float)l2 / (float)l1 * 300.0F);
    AppMethodBeat.o(7401);
    return l1;
  }
  
  private void init()
  {
    AppMethodBeat.i(7397);
    setOrientation(1);
    this.mTouchSlop = ViewConfiguration.get(this.context).getScaledTouchSlop();
    AppMethodBeat.o(7397);
  }
  
  public final void Kp(int paramInt)
  {
    AppMethodBeat.i(7404);
    int i = getOverScrollDistance();
    scrollTo(0, Math.min(i, Math.max(-i, paramInt)));
    AppMethodBeat.o(7404);
  }
  
  public WebView getWebView()
  {
    return this.egP;
  }
  
  public FrameLayout getWebViewContainer()
  {
    AppMethodBeat.i(7398);
    int j;
    int i;
    if (this.van == null)
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
        if (((localObject instanceof FrameLayout)) && (((View)localObject).getId() == 2131823719)) {
          this.van = ((FrameLayout)localObject);
        }
      }
      else
      {
        localObject = this.van;
        AppMethodBeat.o(7398);
        return localObject;
      }
      i += 1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7399);
    if ((this.vat) && (!this.vay))
    {
      AppMethodBeat.o(7399);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.vao = false;
      this.vas = 0;
      this.vaz = false;
      AppMethodBeat.o(7399);
      return false;
    }
    if ((i == 2) && (this.vao))
    {
      AppMethodBeat.o(7399);
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.vao;
      AppMethodBeat.o(7399);
      return bool;
      if (ddw())
      {
        this.vap = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.vaq = ((int)paramMotionEvent.getX());
        this.vao = false;
        this.vas = 0;
        this.vay = true;
        this.vaz = true;
        continue;
        if (ddw())
        {
          if (!this.vaz)
          {
            this.vap = ((int)paramMotionEvent.getY());
            this.startY = ((int)paramMotionEvent.getY());
            this.vaq = ((int)paramMotionEvent.getX());
            this.vao = false;
            this.vas = 0;
            this.vay = true;
            this.vaz = true;
            bool = this.vao;
            AppMethodBeat.o(7399);
            return bool;
          }
          i = (int)paramMotionEvent.getY();
          int j = (int)paramMotionEvent.getX();
          int k = i - this.vap;
          int m = this.vaq;
          if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) > Math.abs(j - m)) && (k > 0))
          {
            this.vap = i;
            this.vaq = j;
            if (this.vas == 1)
            {
              this.vao = true;
              this.vaz = false;
              ab.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
              if (this.vaw != null) {
                this.vaw.ddx();
              }
            }
            else
            {
              this.vas += 1;
            }
          }
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7400);
    if ((this.vat) && (!this.vay))
    {
      AppMethodBeat.o(7400);
      return false;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      AppMethodBeat.o(7400);
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
          AppMethodBeat.o(7400);
          return false;
          this.vay = true;
        } while (!ddw());
        this.vap = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.vaq = ((int)paramMotionEvent.getX());
        this.vaA = true;
        AppMethodBeat.o(7400);
        return true;
      } while (!this.vao);
      if (!this.vaA)
      {
        this.vap = ((int)paramMotionEvent.getY());
        this.startY = ((int)paramMotionEvent.getY());
        this.vaq = ((int)paramMotionEvent.getX());
        this.vaA = true;
        AppMethodBeat.o(7400);
        return true;
      }
      this.vap = ((int)paramMotionEvent.getY());
      this.vaq = ((int)paramMotionEvent.getX());
      int j = Math.min(this.startY - this.vap, 0) >> 1;
      int k = getOverScrollDistance();
      int i = (int)Math.sqrt((getLogoHeight() >> 1) * Math.abs(j)) << 1;
      if (i > Math.abs(j))
      {
        i = j;
        if (Math.abs(j) <= k) {}
      }
      for (i = -k;; i = -i)
      {
        Kp(i);
        if (this.vax != null) {
          this.vax.P(i, true);
        }
        AppMethodBeat.o(7400);
        return true;
      }
      setForceOverScrollMode(false);
      this.vaA = false;
    } while ((!this.vao) && (!this.vay));
    this.vao = false;
    post(new LogoWebViewWrapper.1(this));
    if ((this.vax != null) && (this.vax.aZH()))
    {
      AppMethodBeat.o(7400);
      return true;
    }
    q(-this.vav, getScrollBackDuration());
    AppMethodBeat.o(7400);
    return true;
  }
  
  public final void op(boolean paramBoolean)
  {
    this.vat = paramBoolean;
    if (this.vat)
    {
      this.vao = false;
      this.vas = 0;
    }
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(7405);
    if (this.var != null) {
      this.var.stop();
    }
    int i = getScrollY();
    ab.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    if (i != paramInt)
    {
      this.var = new LogoWebViewWrapper.c(this, i, paramInt, paramLong);
      post(this.var);
    }
    AppMethodBeat.o(7405);
  }
  
  public void setEasyMod(boolean paramBoolean)
  {
    this.vaB = paramBoolean;
  }
  
  public void setFastScrollBack(boolean paramBoolean)
  {
    this.vau = paramBoolean;
  }
  
  public void setForceOverScrollMode(boolean paramBoolean)
  {
    this.vaD = paramBoolean;
  }
  
  public void setMMOverScrollListener(LogoWebViewWrapper.a parama)
  {
    this.vaw = parama;
  }
  
  public void setMMOverScrollOffsetListener(LogoWebViewWrapper.b paramb)
  {
    this.vax = paramb;
  }
  
  public void setReleaseTargetHeight(int paramInt)
  {
    this.vav = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */