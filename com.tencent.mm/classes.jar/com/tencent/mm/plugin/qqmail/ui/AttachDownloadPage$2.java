package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class AttachDownloadPage$2
  implements MenuItem.OnMenuItemClickListener
{
  AttachDownloadPage$2(AttachDownloadPage paramAttachDownloadPage) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68132);
    paramMenuItem = this.pLa;
    String str = this.pLa.getString(2131302102);
    AttachDownloadPage.2.1 local1 = new AttachDownloadPage.2.1(this);
    h.a(paramMenuItem, "", new String[] { str }, "", false, local1);
    AppMethodBeat.o(68132);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.2
 * JD-Core Version:    0.7.0.1
 */