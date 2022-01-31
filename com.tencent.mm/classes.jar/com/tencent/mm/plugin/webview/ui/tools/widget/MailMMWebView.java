package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

public class MailMMWebView
  extends MMWebViewWithJsApi
  implements h
{
  private float fSy;
  private float fSz;
  private View nWI;
  private boolean rCD;
  private View rCE;
  private boolean rCF;
  private boolean rCG;
  
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
    int j = getHeight();
    int i = j;
    if (isHorizontalScrollBarEnabled())
    {
      i = j;
      if (!overlayHorizontalScrollbar()) {
        i = j - getHorizontalScrollbarHeight();
      }
    }
    return i;
  }
  
  private void setEmbeddedTitleBarSinceJellyBean(View paramView)
  {
    if (paramView != null)
    {
      if (this.rCE != null) {
        removeView(this.rCE);
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -2);
      this.rCE = new MailMMWebView.a(this, getContext());
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
      ((MailMMWebView.a)this.rCE).addView(paramView, localLayoutParams2);
      this.rCE.setBackgroundColor(-1);
      addView(this.rCE, localLayoutParams1);
    }
  }
  
  public final boolean cgL()
  {
    return this.rCD;
  }
  
  public final void cgM()
  {
    this.rCD = false;
  }
  
  public final void cgN()
  {
    int i = (int)(getTitleHeight() / getScale());
    evaluateJavascript("javascript:_updateTitleBarHeight(" + i + ");", null);
  }
  
  public final void cgO()
  {
    int i = (int)(getBottomHeight() / getScale());
    evaluateJavascript("javascript:_updateBottomBarHeight(" + i + ");", null);
  }
  
  public int computeVerticalScrollExtent()
  {
    return getViewHeightWithTitleBar() - getVisibleTitleBarHeight();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(getWebScrollY() - getTitleHeight(), 0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = getWebScrollY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    while ((this.rCF) && (this.rCE != null))
    {
      paramMotionEvent.setLocation(f1, f2 + i);
      return this.rCE.dispatchTouchEvent(paramMotionEvent);
      this.fSy = f1;
      this.fSz = f2;
      if ((this.rCE != null) && ((int)this.fSz < getVisibleTitleBarHeight()))
      {
        this.rCF = true;
      }
      else if ((this.nWI != null) && (this.nWI.getVisibility() == 0) && (this.fSz + getBottomHeight() > getHeight()))
      {
        this.rCG = true;
        continue;
        if ((Math.abs(f2 - this.fSz) > 50.0F) && (this.rCF))
        {
          paramMotionEvent.setAction(3);
          paramMotionEvent.setLocation(this.fSy, this.fSz + i);
          this.rCE.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(0);
          paramMotionEvent.setLocation(this.fSy, this.fSz);
          super.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(2);
          paramMotionEvent.setLocation(f1, f2);
        }
      }
    }
    if ((this.rCG) && (this.nWI != null))
    {
      paramMotionEvent.setLocation(f1, f2 + getBottomHeight() - getHeight());
      return this.nWI.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (paramView == this.rCE)
    {
      int i = getWebScrollY();
      paramCanvas.save();
      paramCanvas.translate(0.0F, -i);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restore();
      return bool;
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public int getBottomHeight()
  {
    if (this.nWI != null) {
      return this.nWI.getHeight();
    }
    return 0;
  }
  
  public int getTitleHeight()
  {
    if (this.rCE != null) {
      return this.rCE.getHeight();
    }
    return 0;
  }
  
  public int getVisibleTitleBarHeight()
  {
    return Math.max(getTitleHeight() - getWebScrollY(), 0);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.rCD = true;
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final void lx(boolean paramBoolean)
  {
    if (this.nWI != null)
    {
      if (paramBoolean) {
        this.nWI.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.nWI.setVisibility(4);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = (int)(getContentHeight() * getScale());
    int j = getHeight() + paramInt2;
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    if (i - j < getBottomHeight())
    {
      if (Math.abs(i - j) <= 20) {
        break label80;
      }
      cgO();
      lx(false);
    }
    for (;;)
    {
      if (getVisibleTitleHeight() == 0) {
        cgN();
      }
      return;
      label80:
      lx(true);
    }
  }
  
  public void setEmbeddedBottomBar(View paramView)
  {
    if (paramView != null)
    {
      if (this.nWI != null) {
        removeView(this.nWI);
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -2, 80);
      this.nWI = new MailMMWebView.a(this, getContext());
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams3.setMargins(localLayoutParams2.leftMargin, localLayoutParams2.topMargin, localLayoutParams2.rightMargin, localLayoutParams2.bottomMargin);
      ((MailMMWebView.a)this.nWI).addView(paramView, localLayoutParams3);
      addView(this.nWI, localLayoutParams1);
      this.nWI.setVisibility(4);
    }
  }
  
  public void setEmbeddedTitleBarCompat(View paramView)
  {
    setEmbeddedTitleBarSinceJellyBean(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView
 * JD-Core Version:    0.7.0.1
 */