package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class au$1
  implements Runnable
{
  au$1(au paramau, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(6800);
    av.a(ah.getContext(), this.efI, this.val$appId, null);
    AppMethodBeat.o(6800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.au.1
 * JD-Core Version:    0.7.0.1
 */