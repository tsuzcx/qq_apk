package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

final class g$112
  implements Runnable
{
  g$112(g paramg, b paramb, String paramString1, String paramString2) {}
  
  public final void run()
  {
    String str1 = e.aeY(j.n(this.rAB.mUri));
    au.Hx();
    String str2 = EmojiLogic.J(c.FL(), "", str1);
    if (!e.bK(str2)) {
      e.r(j.n(this.rAB.cLr()), str2);
    }
    g.a(this.rzi, str1, this.eoz, this.rAA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.112
 * JD-Core Version:    0.7.0.1
 */