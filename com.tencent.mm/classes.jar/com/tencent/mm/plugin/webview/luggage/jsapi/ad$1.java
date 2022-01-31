package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.g;
import com.tencent.luggage.e.h;
import com.tencent.mm.plugin.webview.luggage.c.a;

final class ad$1
  implements Runnable
{
  ad$1(ad paramad, String paramString, a.a parama) {}
  
  public final void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("rawUrl", this.val$url);
    a.w(System.currentTimeMillis(), this.val$url);
    ((com.tencent.mm.plugin.webview.luggage.e)this.kNj.big).bil.qj().d(this.val$url, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ad.1
 * JD-Core Version:    0.7.0.1
 */