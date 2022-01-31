package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mm.R.g;

final class WebViewInputFooter$2
  implements View.OnTouchListener
{
  WebViewInputFooter$2(WebViewInputFooter paramWebViewInputFooter) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    WebViewInputFooter.g(this.rDo);
    WebViewInputFooter.i(this.rDo).setVisibility(8);
    WebViewInputFooter.f(this.rDo).setImageResource(R.g.chatting_setmode_biaoqing_btn);
    WebViewInputFooter.a(this.rDo, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.2
 * JD-Core Version:    0.7.0.1
 */