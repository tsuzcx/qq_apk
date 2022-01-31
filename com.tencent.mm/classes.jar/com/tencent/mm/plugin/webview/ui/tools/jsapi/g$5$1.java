package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class g$5$1
  implements Runnable
{
  g$5$1(g.5 param5) {}
  
  public final void run()
  {
    Runnable localRunnable = (Runnable)g.cgx().pollFirst();
    if (localRunnable != null)
    {
      localRunnable.run();
      return;
    }
    y.i("MicroMsg.MsgHandler", "authJsApiQueue processed!");
    g.cgy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.5.1
 * JD-Core Version:    0.7.0.1
 */