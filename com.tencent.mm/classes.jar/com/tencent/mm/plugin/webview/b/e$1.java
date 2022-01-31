package com.tencent.mm.plugin.webview.b;

public final class e$1
  implements Runnable
{
  public e$1(e parame) {}
  
  public final void run()
  {
    e locale = this.qYA;
    long l = System.currentTimeMillis() / 1000L;
    locale.gk("WebViewHistory", "delete from WebViewHistory where  timeStamp < " + (l - 604800L));
    e.a(this.qYA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.e.1
 * JD-Core Version:    0.7.0.1
 */