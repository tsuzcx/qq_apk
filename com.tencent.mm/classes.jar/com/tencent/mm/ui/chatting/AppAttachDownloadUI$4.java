package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q.g;

final class AppAttachDownloadUI$4
  implements q.g
{
  AppAttachDownloadUI$4(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(284003);
    if (AppAttachDownloadUI.J(this.WwM).equals("")) {}
    for (paramMenuItem = this.WwM.getString(R.l.openapi_app_file);; paramMenuItem = AppAttachDownloadUI.J(this.WwM))
    {
      ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramMenuItem);
      h.cO(this.WwM, this.WwM.getString(R.l.app_copy_ok));
      AppMethodBeat.o(284003);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.4
 * JD-Core Version:    0.7.0.1
 */