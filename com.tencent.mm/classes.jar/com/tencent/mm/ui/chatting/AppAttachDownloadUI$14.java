package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.q.g;

final class AppAttachDownloadUI$14
  implements q.g
{
  AppAttachDownloadUI$14(AppAttachDownloadUI paramAppAttachDownloadUI, h.e parame) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(268310);
    if (this.Wiw != null) {
      this.Wiw.cS(paramInt, paramMenuItem.getItemId());
    }
    AppMethodBeat.o(268310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.14
 * JD-Core Version:    0.7.0.1
 */