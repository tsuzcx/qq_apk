package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class AppAttachDownloadUI$1
  implements MenuItem.OnMenuItemClickListener
{
  AppAttachDownloadUI$1(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(30264);
    if (AppAttachDownloadUI.a(this.zvM) != null) {
      aw.Rc().a(AppAttachDownloadUI.a(this.zvM));
    }
    this.zvM.finish();
    AppMethodBeat.o(30264);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.1
 * JD-Core Version:    0.7.0.1
 */