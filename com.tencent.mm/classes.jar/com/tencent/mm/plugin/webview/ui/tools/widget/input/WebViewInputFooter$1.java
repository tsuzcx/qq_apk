package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.R.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

final class WebViewInputFooter$1
  implements View.OnClickListener
{
  WebViewInputFooter$1(WebViewInputFooter paramWebViewInputFooter) {}
  
  public final void onClick(View paramView)
  {
    if (WebViewInputFooter.a(this.rDo) == 0)
    {
      WebViewInputFooter.b(this.rDo).XM();
      if (!WebViewInputFooter.c(this.rDo)) {
        WebViewInputFooter.d(this.rDo).requestFocus();
      }
      WebViewInputFooter.e(this.rDo);
      WebViewInputFooter.f(this.rDo).setImageResource(R.k.textfield_icon_emoji_pressed);
      WebViewInputFooter.a(this.rDo, 1);
      WebViewInputFooter.g(this.rDo);
      return;
    }
    WebViewInputFooter.g(this.rDo);
    WebViewInputFooter.d(this.rDo).requestFocus();
    WebViewInputFooter.b(this.rDo).showVKB();
    WebViewInputFooter.h(this.rDo);
    WebViewInputFooter.a(this.rDo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.1
 * JD-Core Version:    0.7.0.1
 */