package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class n$49$2
  implements MenuItem.OnMenuItemClickListener
{
  n$49$2(n.49 param49) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(153227);
    ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "click item: %s", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
    ((WebViewUI)n.a(this.vdU.vdr).get()).uQS.dgp();
    AppMethodBeat.o(153227);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.49.2
 * JD-Core Version:    0.7.0.1
 */