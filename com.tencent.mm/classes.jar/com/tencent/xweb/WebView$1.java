package com.tencent.xweb;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WebView$1
  implements View.OnLongClickListener
{
  WebView$1(WebView paramWebView) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(156799);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/xweb/WebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    if (this.aabg.Ybx != null)
    {
      boolean bool = this.aabg.Ybx.onLongClick(this.aabg);
      a.a(bool, this, "com/tencent/xweb/WebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(156799);
      return bool;
    }
    a.a(false, this, "com/tencent/xweb/WebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(156799);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.WebView.1
 * JD-Core Version:    0.7.0.1
 */