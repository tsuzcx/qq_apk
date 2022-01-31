package com.tencent.mm.plugin.webview.luggage;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.e.g;
import java.util.LinkedList;

final class m$2
  implements View.OnClickListener
{
  m$2(m paramm, e parame) {}
  
  public final void onClick(View paramView)
  {
    if (this.kNu.bil.getPageStack().peek() == m.a(this.rcK)) {
      this.rcK.aYv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m.2
 * JD-Core Version:    0.7.0.1
 */