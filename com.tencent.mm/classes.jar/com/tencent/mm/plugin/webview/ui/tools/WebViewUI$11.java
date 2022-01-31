package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.as.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.v;

final class WebViewUI$11
  implements v
{
  WebViewUI$11(WebViewUI paramWebViewUI) {}
  
  public final boolean A(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7819);
    if (this.vgz.pOd == null)
    {
      AppMethodBeat.o(7819);
      return false;
    }
    boolean bool = this.vgz.pOd.V(paramMotionEvent);
    AppMethodBeat.o(7819);
    return bool;
  }
  
  public final boolean B(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7824);
    if (this.vgz.pOd == null)
    {
      AppMethodBeat.o(7824);
      return false;
    }
    boolean bool = this.vgz.pOd.W(paramMotionEvent);
    AppMethodBeat.o(7824);
    return bool;
  }
  
  public final boolean C(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7825);
    if (this.vgz.pOd == null)
    {
      AppMethodBeat.o(7825);
      return false;
    }
    boolean bool = this.vgz.pOd.X(paramMotionEvent);
    AppMethodBeat.o(7825);
    return bool;
  }
  
  public final void aGl()
  {
    AppMethodBeat.i(7821);
    if (this.vgz.pOd == null)
    {
      AppMethodBeat.o(7821);
      return;
    }
    this.vgz.pOd.dON();
    AppMethodBeat.o(7821);
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(7820);
    if (this.vgz.pOd == null)
    {
      AppMethodBeat.o(7820);
      return false;
    }
    as.a locala = this.vgz.uVh.dcl();
    if (paramInt4 > locala.uWM) {
      locala.uWM = paramInt4;
    }
    locala.sbd = paramInt6;
    paramBoolean = this.vgz.pOd.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(7820);
    return paramBoolean;
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(7822);
    if (this.vgz.pOd == null)
    {
      AppMethodBeat.o(7822);
      return;
    }
    this.vgz.pOd.e(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if ((paramBoolean2) && (this.vgz.uVh != null)) {
      this.vgz.uVh.r("mm_scroll_bottom", Boolean.TRUE);
    }
    AppMethodBeat.o(7822);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(7823);
    if (this.vgz.pOd == null)
    {
      AppMethodBeat.o(7823);
      return;
    }
    this.vgz.pOd.M(paramInt1, paramInt2, paramInt3, paramInt4);
    this.vgz.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(7823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.11
 * JD-Core Version:    0.7.0.1
 */