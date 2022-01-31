package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

final class g$122
  implements Runnable
{
  g$122(g paramg, com.tencent.mm.vfs.b paramb, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(9199);
    String str1 = e.avP(j.p(this.vrE.mUri));
    String str2 = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", str1);
    if (!e.cN(str2)) {
      e.C(j.p(this.vrE.dQJ()), str2);
    }
    g.a(this.vqm, str1, this.fEW, this.vrD);
    AppMethodBeat.o(9199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.122
 * JD-Core Version:    0.7.0.1
 */