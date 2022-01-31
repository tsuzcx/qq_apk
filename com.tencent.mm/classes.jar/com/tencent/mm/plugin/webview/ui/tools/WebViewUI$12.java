package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.an.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.o;

final class WebViewUI$12
  implements o
{
  WebViewUI$12(WebViewUI paramWebViewUI) {}
  
  public final void alk()
  {
    if (this.rpH.niQ == null) {
      return;
    }
    this.rpH.niQ.cJU();
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (this.rpH.niQ == null) {
      return false;
    }
    an.a locala = this.rpH.rfg.cci();
    if (paramInt4 > locala.rgy) {
      locala.rgy = paramInt4;
    }
    locala.piC = paramInt6;
    return this.rpH.niQ.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.rpH.niQ == null) {}
    do
    {
      return;
      this.rpH.niQ.e(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    } while ((!paramBoolean2) || (this.rpH.rfg == null));
    this.rpH.rfg.n("mm_scroll_bottom", Boolean.valueOf(true));
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.rpH.niQ == null) {
      return;
    }
    this.rpH.niQ.F(paramInt1, paramInt2, paramInt3, paramInt4);
    this.rpH.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean v(MotionEvent paramMotionEvent)
  {
    if (this.rpH.niQ == null) {
      return false;
    }
    return this.rpH.niQ.L(paramMotionEvent);
  }
  
  public final boolean w(MotionEvent paramMotionEvent)
  {
    if (this.rpH.niQ == null) {
      return false;
    }
    return this.rpH.niQ.M(paramMotionEvent);
  }
  
  public final boolean x(MotionEvent paramMotionEvent)
  {
    if (this.rpH.niQ == null) {
      return false;
    }
    return this.rpH.niQ.N(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12
 * JD-Core Version:    0.7.0.1
 */