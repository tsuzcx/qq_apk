package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailMMWebView$a
  extends FrameLayout
{
  public MailMMWebView$a(MailMMWebView paramMailMMWebView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(10037);
    if ((!MailMMWebView.b(this.vsT)) && (!MailMMWebView.c(this.vsT)))
    {
      AppMethodBeat.o(10037);
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(10037);
      return true;
      MailMMWebView.d(this.vsT);
      MailMMWebView.e(this.vsT);
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(10038);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this == MailMMWebView.f(this.vsT)) && (this.vsT.getTitleHeight() > 0))
    {
      this.vsT.dgU();
      AppMethodBeat.o(10038);
      return;
    }
    if ((this == MailMMWebView.g(this.vsT)) && (this.vsT.getBottomHeight() > 0)) {
      this.vsT.dgV();
    }
    AppMethodBeat.o(10038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView.a
 * JD-Core Version:    0.7.0.1
 */