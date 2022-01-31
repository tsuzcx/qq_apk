package com.tencent.xweb;

import android.view.View;
import android.view.View.OnLongClickListener;

final class WebView$1
  implements View.OnLongClickListener
{
  WebView$1(WebView paramWebView) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (this.xhi.wjs != null) {
      return this.xhi.wjs.onLongClick(this.xhi);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.WebView.1
 * JD-Core Version:    0.7.0.1
 */