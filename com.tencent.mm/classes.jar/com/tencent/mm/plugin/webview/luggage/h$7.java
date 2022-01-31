package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.sdk.platformtools.ab;

final class h$7
  implements MenuItem.OnMenuItemClickListener
{
  h$7(h paramh, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(6129);
    ab.i("MicroMsg.GameWebViewMenuListHelper", "onMenuItemClick recognize qbcode");
    paramMenuItem = new Bundle();
    paramMenuItem.putString("result", this.ihp);
    paramMenuItem.putString("url", h.b(this.uSc));
    paramMenuItem.putInt("codeType", this.uSc.igY);
    paramMenuItem.putInt("codeVersion", this.uSc.igZ);
    b.a(h.a(this.uSc).mContext, paramMenuItem, h.d.class);
    AppMethodBeat.o(6129);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.7
 * JD-Core Version:    0.7.0.1
 */