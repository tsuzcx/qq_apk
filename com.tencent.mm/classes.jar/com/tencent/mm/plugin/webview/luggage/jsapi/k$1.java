package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.g;
import com.tencent.luggage.e.h;
import java.util.LinkedList;

final class k$1
  implements Runnable
{
  k$1(k paramk, a.a parama) {}
  
  public final void run()
  {
    int i = ((com.tencent.mm.plugin.webview.luggage.e)this.kNj.big).bil.getPageStack().indexOf(this.kNj.big);
    if (i < 0) {}
    while (((com.tencent.mm.plugin.webview.luggage.e)this.kNj.big).bil.qj().bu(i)) {
      return;
    }
    ((Activity)((com.tencent.mm.plugin.webview.luggage.e)this.kNj.big).mContext).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.k.1
 * JD-Core Version:    0.7.0.1
 */