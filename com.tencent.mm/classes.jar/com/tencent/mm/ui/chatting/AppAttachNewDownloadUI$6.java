package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q.g;

final class AppAttachNewDownloadUI$6
  implements q.g
{
  AppAttachNewDownloadUI$6(AppAttachNewDownloadUI paramAppAttachNewDownloadUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(290215);
    if (AppAttachNewDownloadUI.P(this.Wxg).equals("")) {}
    for (paramMenuItem = this.Wxg.getString(R.l.openapi_app_file);; paramMenuItem = AppAttachNewDownloadUI.P(this.Wxg))
    {
      ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramMenuItem);
      h.cO(this.Wxg, this.Wxg.getString(R.l.app_copy_ok));
      AppMethodBeat.o(290215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.6
 * JD-Core Version:    0.7.0.1
 */