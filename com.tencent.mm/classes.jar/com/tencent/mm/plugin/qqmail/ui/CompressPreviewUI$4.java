package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CompressPreviewUI$4
  implements MenuItem.OnMenuItemClickListener
{
  CompressPreviewUI$4(CompressPreviewUI paramCompressPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68241);
    paramMenuItem = new Intent(this.pMs, AttachDownloadPage.class);
    paramMenuItem.putExtra("attach_name", CompressPreviewUI.e(this.pMs));
    paramMenuItem.putExtra("mail_id", CompressPreviewUI.b(this.pMs));
    paramMenuItem.putExtra("attach_id", CompressPreviewUI.f(this.pMs));
    paramMenuItem.putExtra("total_size", CompressPreviewUI.g(this.pMs));
    paramMenuItem.putExtra("is_preview", 0);
    paramMenuItem.putExtra("is_compress", true);
    this.pMs.startActivity(paramMenuItem);
    AppMethodBeat.o(68241);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */