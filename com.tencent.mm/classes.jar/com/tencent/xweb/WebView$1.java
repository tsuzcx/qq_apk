package com.tencent.xweb;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebView$1
  implements View.OnLongClickListener
{
  WebView$1(WebView paramWebView) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(151427);
    if (this.BEk.ACZ != null)
    {
      boolean bool = this.BEk.ACZ.onLongClick(this.BEk);
      AppMethodBeat.o(151427);
      return bool;
    }
    AppMethodBeat.o(151427);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.WebView.1
 * JD-Core Version:    0.7.0.1
 */