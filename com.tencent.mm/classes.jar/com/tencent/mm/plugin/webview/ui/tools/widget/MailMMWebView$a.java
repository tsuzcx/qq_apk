package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

final class MailMMWebView$a
  extends FrameLayout
{
  public MailMMWebView$a(MailMMWebView paramMailMMWebView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!MailMMWebView.b(this.rCH)) && (!MailMMWebView.c(this.rCH))) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      MailMMWebView.d(this.rCH);
      MailMMWebView.e(this.rCH);
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this == MailMMWebView.f(this.rCH)) && (this.rCH.getTitleHeight() > 0)) {
      this.rCH.cgN();
    }
    while ((this != MailMMWebView.g(this.rCH)) || (this.rCH.getBottomHeight() <= 0)) {
      return;
    }
    this.rCH.cgO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView.a
 * JD-Core Version:    0.7.0.1
 */