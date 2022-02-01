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
  implements h
{
  private View Jkx;
  private boolean Qys;
  private View Qyt;
  private boolean Qyu;
  private boolean Qyv;
  private float dit;
  private float diu;
  
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
      if (this.Qyt != null) {
        removeView(this.Qyt);
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -2);
      this.Qyt = new a(getContext());
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
      ((a)this.Qyt).addView(paramView, localLayoutParams2);
      this.Qyt.setBackgroundColor(getContext().getResources().getColor(c.c.White));
      addView(this.Qyt, localLayoutParams1);
    }
    AppMethodBeat.o(82283);
  }
  
  public final void Ds(boolean paramBoolean)
  {
    AppMethodBeat.i(82284);
    if (this.Jkx != null)
    {
      if (paramBoolean)
      {
        this.Jkx.setVisibility(0);
        AppMethodBeat.o(82284);
        return;
      }
      this.Jkx.setVisibility(4);
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
    while ((this.Qyu) && (this.Qyt != null))
    {
      paramMotionEvent.setLocation(f1, f2 + i);
      bool = this.Qyt.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82271);
      return bool;
      this.dit = f1;
      this.diu = f2;
      if ((this.Qyt != null) && ((int)this.diu < getVisibleTitleBarHeight()))
      {
        this.Qyu = true;
      }
      else if ((this.Jkx != null) && (this.Jkx.getVisibility() == 0) && (this.diu + getBottomHeight() > getHeight()))
      {
        this.Qyv = true;
        continue;
        if ((Math.abs(f2 - this.diu) > 50.0F) && (this.Qyu))
        {
          paramMotionEvent.setAction(3);
          paramMotionEvent.setLocation(this.dit, this.diu + i);
          this.Qyt.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(0);
          paramMotionEvent.setLocation(this.dit, this.diu);
          super.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(2);
          paramMotionEvent.setLocation(f1, f2);
        }
      }
    }
    if ((this.Qyv) && (this.Jkx != null))
    {
      paramMotionEvent.setLocation(f1, f2 + getBottomHeight() - getHeight());
      bool = this.Jkx.dispatchTouchEvent(paramMotionEvent);
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
    if (paramView == this.Qyt)
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
    if (this.Jkx != null)
    {
      int i = this.Jkx.getHeight();
      AppMethodBeat.o(82279);
      return i;
    }
    AppMethodBeat.o(82279);
    return 0;
  }
  
  public int getTitleHeight()
  {
    AppMethodBeat.i(82278);
    if (this.Qyt != null)
    {
      int i = this.Qyt.getHeight();
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
  
  public final boolean hbM()
  {
    return this.Qys;
  }
  
  public final void hbN()
  {
    this.Qys = false;
  }
  
  public final void hbO()
  {
    AppMethodBeat.i(82280);
    int i = (int)(getTitleHeight() / getScale());
    evaluateJavascript("javascript:_updateTitleBarHeight(" + i + ");", null);
    AppMethodBeat.o(82280);
  }
  
  public final void hbP()
  {
    AppMethodBeat.i(82281);
    int i = (int)(getBottomHeight() / getScale());
    evaluateJavascript("javascript:_updateBottomBarHeight(" + i + ");", null);
    AppMethodBeat.o(82281);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(82270);
    this.Qys = true;
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
      hbP();
      Ds(false);
    }
    for (;;)
    {
      if (getVisibleTitleHeight() == 0) {
        hbO();
      }
      AppMethodBeat.o(82272);
      return;
      label92:
      Ds(true);
    }
  }
  
  public void setEmbeddedBottomBar(View paramView)
  {
    AppMethodBeat.i(82285);
    if (paramView != null)
    {
      if (this.Jkx != null) {
        removeView(this.Jkx);
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -2, 80);
      this.Jkx = new a(getContext());
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams3.setMargins(localLayoutParams2.leftMargin, localLayoutParams2.topMargin, localLayoutParams2.rightMargin, localLayoutParams2.bottomMargin);
      ((a)this.Jkx).addView(paramView, localLayoutParams3);
      addView(this.Jkx, localLayoutParams1);
      this.Jkx.setVisibility(4);
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
        MailMMWebView.this.hbO();
        AppMethodBeat.o(82268);
        return;
      }
      if ((this == MailMMWebView.g(MailMMWebView.this)) && (MailMMWebView.this.getBottomHeight() > 0)) {
        MailMMWebView.this.hbP();
      }
      AppMethodBeat.o(82268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView
 * JD-Core Version:    0.7.0.1
 */