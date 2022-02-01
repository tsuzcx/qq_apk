package com.tencent.mm.ui.chatting;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class AppAttachNewDownloadUI$18
  implements p.a
{
  AppAttachNewDownloadUI$18(AppAttachNewDownloadUI paramAppAttachNewDownloadUI) {}
  
  public final void bT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275234);
    Toast.makeText(this.Wxg, this.Wxg.getString(R.l.toast_file_saved_fmt, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString2) }), 1).show();
    AppMethodBeat.o(275234);
  }
  
  public final void bU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275236);
    Toast.makeText(this.Wxg, this.Wxg.getString(R.l.toast_file_saved_fail), 1).show();
    AppMethodBeat.o(275236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.18
 * JD-Core Version:    0.7.0.1
 */