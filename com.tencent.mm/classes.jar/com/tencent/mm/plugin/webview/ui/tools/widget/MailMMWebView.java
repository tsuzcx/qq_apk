package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;

public class MailMMWebView
  extends MMWebViewWithJsApi
  implements k
{
  private View PwW;
  private boolean Xrd;
  private View Xre;
  private boolean Xrf;
  private boolean Xrg;
  private float fif;
  private float fig;
  
  public MailMMWebView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public MailMMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MailMMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int getViewHeightWithTitleBar()
  {
    AppMethodBeat.i(82282);
    int j = getHeight();
    int i = j;
    if (isHorizontalScrollBarEnabled())
    {
      i = j;
      if (!overlayHorizontalScrollbar()) {
        i = j - getHorizontalScrollbarHeight();
      }
    }
    AppMethodBeat.o(82282);
    return i;
  }
  
  private void setEmbeddedTitleBarSinceJellyBean(View paramView)
  {
    AppMethodBeat.i(82283);
    if (paramView != null)
    {
      if (this.Xre != null) {
        removeView(this.Xre);
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -2);
      this.Xre = new a(getContext());
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
      ((a)this.Xre).addView(paramView, localLayoutParams2);
      this.Xre.setBackgroundColor(getContext().getResources().getColor(c.c.White));
      addView(this.Xre, localLayoutParams1);
    }
    AppMethodBeat.o(82283);
  }
  
  public final void Ja(boolean paramBoolean)
  {
    AppMethodBeat.i(82284);
    if (this.PwW != null)
    {
      if (paramBoolean)
      {
        this.PwW.setVisibility(0);
        AppMethodBeat.o(82284);
        return;
      }
      this.PwW.setVisibility(4);
    }
    AppMethodBeat.o(82284);
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(82274);
    int i = getViewHeightWithTitleBar();
    int j = getVisibleTitleBarHeight();
    AppMethodBeat.o(82274);
    return i - j;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(82275);
    int i = Math.max(getWebScrollY() - getTitleHeight(), 0);
    AppMethodBeat.o(82275);
    return i;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82271);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = getWebScrollY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    while ((this.Xrf) && (this.Xre != null))
    {
      paramMotionEvent.setLocation(f1, f2 + i);
      bool = this.Xre.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82271);
      return bool;
      this.fif = f1;
      this.fig = f2;
      if ((this.Xre != null) && ((int)this.fig < getVisibleTitleBarHeight()))
      {
        this.Xrf = true;
      }
      else if ((this.PwW != null) && (this.PwW.getVisibility() == 0) && (this.fig + getBottomHeight() > getHeight()))
      {
        this.Xrg = true;
        continue;
        if ((Math.abs(f2 - this.fig) > 50.0F) && (this.Xrf))
        {
          paramMotionEvent.setAction(3);
          paramMotionEvent.setLocation(this.fif, this.fig + i);
          this.Xre.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(0);
          paramMotionEvent.setLocation(this.fif, this.fig);
          super.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(2);
          paramMotionEvent.setLocation(f1, f2);
        }
      }
    }
    if ((this.Xrg) && (this.PwW != null))
    {
      paramMotionEvent.setLocation(f1, f2 + getBottomHeight() - getHeight());
      bool = this.PwW.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82271);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(82271);
    return bool;
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(82277);
    boolean bool;
    if (paramView == this.Xre)
    {
      int i = getWebScrollY();
      paramCanvas.save();
      paramCanvas.translate(0.0F, -i);
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restore();
    }
    for (;;)
    {
      AppMethodBeat.o(82277);
      return bool;
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
  }
  
  public int getBottomHeight()
  {
    AppMethodBeat.i(82279);
    if (this.PwW != null)
    {
      int i = this.PwW.getHeight();
      AppMethodBeat.o(82279);
      return i;
    }
    AppMethodBeat.o(82279);
    return 0;
  }
  
  public int getTitleHeight()
  {
    AppMethodBeat.i(82278);
    if (this.Xre != null)
    {
      int i = this.Xre.getHeight();
      AppMethodBeat.o(82278);
      return i;
    }
    AppMethodBeat.o(82278);
    return 0;
  }
  
  public int getVisibleTitleBarHeight()
  {
    AppMethodBeat.i(82276);
    int i = Math.max(getTitleHeight() - getWebScrollY(), 0);
    AppMethodBeat.o(82276);
    return i;
  }
  
  public final boolean iCg()
  {
    return this.Xrd;
  }
  
  public final void iCh()
  {
    this.Xrd = false;
  }
  
  public final void iCi()
  {
    AppMethodBeat.i(82280);
    int i = (int)(getTitleHeight() / getScale());
    evaluateJavascript("javascript:_updateTitleBarHeight(" + i + ");", null);
    AppMethodBeat.o(82280);
  }
  
  public final void iCj()
  {
    AppMethodBeat.i(82281);
    int i = (int)(getBottomHeight() / getScale());
    evaluateJavascript("javascript:_updateBottomBarHeight(" + i + ");", null);
    AppMethodBeat.o(82281);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(82270);
    this.Xrd = true;
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(82270);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82272);
    int i = (int)(getContentHeight() * getScale());
    int j = getHeight() + paramInt2;
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    if (i - j < getBottomHeight())
    {
      if (Math.abs(i - j) <= 20) {
        break label92;
      }
      iCj();
      Ja(false);
    }
    for (;;)
    {
      if (getVisibleTitleHeight() == 0) {
        iCi();
      }
      AppMethodBeat.o(82272);
      return;
      label92:
      Ja(true);
    }
  }
  
  public void setEmbeddedBottomBar(View paramView)
  {
    AppMethodBeat.i(82285);
    if (paramView != null)
    {
      if (this.PwW != null) {
        removeView(this.PwW);
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -2, 80);
      this.PwW = new a(getContext());
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams3.setMargins(localLayoutParams2.leftMargin, localLayoutParams2.topMargin, localLayoutParams2.rightMargin, localLayoutParams2.bottomMargin);
      ((a)this.PwW).addView(paramView, localLayoutParams3);
      addView(this.PwW, localLayoutParams1);
      this.PwW.setVisibility(4);
    }
    AppMethodBeat.o(82285);
  }
  
  public void setEmbeddedTitleBarCompat(View paramView)
  {
    AppMethodBeat.i(82273);
    setEmbeddedTitleBarSinceJellyBean(paramView);
    AppMethodBeat.o(82273);
  }
  
  final class a
    extends FrameLayout
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(82267);
      if ((!MailMMWebView.b(MailMMWebView.this)) && (!MailMMWebView.c(MailMMWebView.this)))
      {
        AppMethodBeat.o(82267);
        return false;
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(82267);
        return true;
        MailMMWebView.d(MailMMWebView.this);
        MailMMWebView.e(MailMMWebView.this);
      }
    }
    
    protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(82268);
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this == MailMMWebView.f(MailMMWebView.this)) && (MailMMWebView.this.getTitleHeight() > 0))
      {
        MailMMWebView.this.iCi();
        AppMethodBeat.o(82268);
        return;
      }
      if ((this == MailMMWebView.g(MailMMWebView.this)) && (MailMMWebView.this.getBottomHeight() > 0)) {
        MailMMWebView.this.iCj();
      }
      AppMethodBeat.o(82268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView
 * JD-Core Version:    0.7.0.1
 */