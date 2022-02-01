package com.tencent.mm.plugin.subapp.ui.gallery;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class GestureGalleryUI$9
  implements ExportFileUtil.a
{
  GestureGalleryUI$9(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void cg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292122);
    Toast.makeText(this.SHm, this.SHm.getString(R.l.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString2) }), 1).show();
    t.refreshMediaScanner(paramString2, this.SHm);
    AppMethodBeat.o(292122);
  }
  
  public final void ch(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292129);
    Toast.makeText(this.SHm, this.SHm.getString(R.l.video_file_save_failed), 1).show();
    AppMethodBeat.o(292129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.9
 * JD-Core Version:    0.7.0.1
 */