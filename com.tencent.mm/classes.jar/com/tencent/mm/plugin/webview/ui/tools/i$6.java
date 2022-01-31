package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d.a;

final class i$6
  implements d.a
{
  i$6(i parami) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(153201);
    if ((this.vcB.iha != null) && (this.vcB.ddt().igU != null)) {
      try
      {
        this.vcB.ddt().igU.ahW(this.vcB.iha.uYi);
        this.vcB.iha.dcJ();
        AppMethodBeat.o(153201);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "cancel capture failed");
      }
    }
    AppMethodBeat.o(153201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i.6
 * JD-Core Version:    0.7.0.1
 */