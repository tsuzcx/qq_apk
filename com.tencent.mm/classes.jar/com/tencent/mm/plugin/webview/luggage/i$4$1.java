package com.tencent.mm.plugin.webview.luggage;

import com.tencent.mm.pluginsdk.ui.tools.s.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class i$4$1
  implements s.a
{
  i$4$1(i.4 param4) {}
  
  public final void uK(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.GameWebViewMenuListHelper", "share image to friend fail, imgPath is null");
      return;
    }
    i.a(this.rct.rcq, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.4.1
 * JD-Core Version:    0.7.0.1
 */