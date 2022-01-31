package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MailMMWebView
  extends MMWebViewWithJsApi
  implements h
{
  private float bTE;
  private float bTF;
  private View qKT;
  private boolean vsP;
  private View vsQ;
  private boolean vsR;
  private boolean vsS;
  
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
    AppMethodBeat.i(10051);
    int j = getHeight();
    int i = j;
    if (isHorizontalScrollBarEnabled())
    {
      i = j;
      if (!overlayHorizontalScrollbar()) {
        i = j - getHorizontalScrollbarHeight();
      }
    }
    AppMethodBeat.o(10051);
    return i;
  }
  
  private void setEmbeddedTitleBarSinceJellyBean(View paramView)
  {
    AppMethodBeat.i(10052);
    if (paramView != null)
    {
      if (this.vsQ != null) {
        removeView(this.vsQ);
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -2);
      this.vsQ = new MailMMWebView.a(this, getContext());
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
      ((MailMMWebView.a)this.vsQ).addView(paramView, localLayoutParams2);
      this.vsQ.setBackgroundColor(-1);
      addView(this.vsQ, localLayoutParams1);
    }
    AppMethodBeat.o(10052);
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(10043);
    int i = getViewHeightWithTitleBar();
    int j = getVisibleTitleBarHeight();
    AppMethodBeat.o(10043);
    return i - j;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(10044);
    int i = Math.max(getWebScrollY() - getTitleHeight(), 0);
    AppMethodBeat.o(10044);
    return i;
  }
  
  public final boolean dgS()
  {
    return this.vsP;
  }
  
  public final void dgT()
  {
    this.vsP = false;
  }
  
  public final void dgU()
  {
    AppMethodBeat.i(10049);
    int i = (int)(getTitleHeight() / getScale());
    evaluateJavascript("javascript:_updateTitleBarHeight(" + i + ");", null);
    AppMethodBeat.o(10049);
  }
  
  public final void dgV()
  {
    AppMethodBeat.i(10050);
    int i = (int)(getBottomHeight() / getScale());
    evaluateJavascript("javascript:_updateBottomBarHeight(" + i + ");", null);
    AppMethodBeat.o(10050);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(10040);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = getWebScrollY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    while ((this.vsR) && (this.vsQ != null))
    {
      paramMotionEvent.setLocation(f1, f2 + i);
      bool = this.vsQ.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(10040);
      return bool;
      this.bTE = f1;
      this.bTF = f2;
      if ((this.vsQ != null) && ((int)this.bTF < getVisibleTitleBarHeight()))
      {
        this.vsR = true;
      }
      else if ((this.qKT != null) && (this.qKT.getVisibility() == 0) && (this.bTF + getBottomHeight() > getHeight()))
      {
        this.vsS = true;
        continue;
        if ((Math.abs(f2 - this.bTF) > 50.0F) && (this.vsR))
        {
          paramMotionEvent.setAction(3);
          paramMotionEvent.setLocation(this.bTE, this.bTF + i);
          this.vsQ.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(0);
          paramMotionEvent.setLocation(this.bTE, this.bTF);
          super.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(2);
          paramMotionEvent.setLocation(f1, f2);
        }
      }
    }
    if ((this.vsS) && (this.qKT != null))
    {
      paramMotionEvent.setLocation(f1, f2 + getBottomHeight() - getHeight());
      bool = this.qKT.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(10040);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(10040);
    return bool;
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(10046);
    boolean bool;
    if (paramView == this.vsQ)
    {
      int i = getWebScrollY();
      paramCanvas.save();
      paramCanvas.translate(0.0F, -i);
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restore();
    }
    for (;;)
    {
      AppMethodBeat.o(10046);
      return bool;
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
  }
  
  public int getBottomHeight()
  {
    AppMethodBeat.i(10048);
    if (this.qKT != null)
    {
      int i = this.qKT.getHeight();
      AppMethodBeat.o(10048);
      return i;
    }
    AppMethodBeat.o(10048);
    return 0;
  }
  
  public int getTitleHeight()
  {
    AppMethodBeat.i(10047);
    if (this.vsQ != null)
    {
      int i = this.vsQ.getHeight();
      AppMethodBeat.o(10047);
      return i;
    }
    AppMethodBeat.o(10047);
    return 0;
  }
  
  public int getVisibleTitleBarHeight()
  {
    AppMethodBeat.i(10045);
    int i = Math.max(getTitleHeight() - getWebScrollY(), 0);
    AppMethodBeat.o(10045);
    return i;
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(10039);
    this.vsP = true;
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(10039);
  }
  
  public final void oH(boolean paramBoolean)
  {
    AppMethodBeat.i(10053);
    if (this.qKT != null)
    {
      if (paramBoolean)
      {
        this.qKT.setVisibility(0);
        AppMethodBeat.o(10053);
        return;
      }
      this.qKT.setVisibility(4);
    }
    AppMethodBeat.o(10053);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(10041);
    int i = (int)(getContentHeight() * getScale());
    int j = getHeight() + paramInt2;
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    if (i - j < getBottomHeight())
    {
      if (Math.abs(i - j) <= 20) {
        break label92;
      }
      dgV();
      oH(false);
    }
    for (;;)
    {
      if (getVisibleTitleHeight() == 0) {
        dgU();
      }
      AppMethodBeat.o(10041);
      return;
      label92:
      oH(true);
    }
  }
  
  public void setEmbeddedBottomBar(View paramView)
  {
    AppMethodBeat.i(10054);
    if (paramView != null)
    {
      if (this.qKT != null) {
        removeView(this.qKT);
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -2, 80);
      this.qKT = new MailMMWebView.a(this, getContext());
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams3.setMargins(localLayoutParams2.leftMargin, localLayoutParams2.topMargin, localLayoutParams2.rightMargin, localLayoutParams2.bottomMargin);
      ((MailMMWebView.a)this.qKT).addView(paramView, localLayoutParams3);
      addView(this.qKT, localLayoutParams1);
      this.qKT.setVisibility(4);
    }
    AppMethodBeat.o(10054);
  }
  
  public void setEmbeddedTitleBarCompat(View paramView)
  {
    AppMethodBeat.i(10042);
    setEmbeddedTitleBarSinceJellyBean(paramView);
    AppMethodBeat.o(10042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView
 * JD-Core Version:    0.7.0.1
 */