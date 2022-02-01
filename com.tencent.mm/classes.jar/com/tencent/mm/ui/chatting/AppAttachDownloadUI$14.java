package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.ui.base.u.i;

final class AppAttachDownloadUI$14
  implements u.i
{
  AppAttachDownloadUI$14(AppAttachDownloadUI paramAppAttachDownloadUI, k.e parame) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(253849);
    if (this.adPx != null) {
      this.adPx.onClick(paramInt, paramMenuItem.getItemId());
    }
    AppMethodBeat.o(253849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.14
 * JD-Core Version:    0.7.0.1
 */