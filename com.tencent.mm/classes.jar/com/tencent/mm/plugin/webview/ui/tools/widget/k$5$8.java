package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class k$5$8
  implements Runnable
{
  k$5$8(k.5 param5, int paramInt1, int paramInt2, int paramInt3, String paramString, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(9932);
    try
    {
      k localk = this.vsJ.vsH;
      int i = this.bHS;
      int j = this.val$errType;
      int k = this.val$errCode;
      if (this.cax != null) {}
      for (Bundle localBundle = this.cax;; localBundle = new Bundle())
      {
        k.a(localk, i, j, k, localBundle);
        AppMethodBeat.o(9932);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMWebViewClient", localException.getMessage());
      AppMethodBeat.o(9932);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.5.8
 * JD-Core Version:    0.7.0.1
 */