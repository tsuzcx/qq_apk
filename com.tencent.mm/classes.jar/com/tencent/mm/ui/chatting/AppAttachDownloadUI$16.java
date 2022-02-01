package com.tencent.mm.ui.chatting;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class AppAttachDownloadUI$16
  implements p.a
{
  AppAttachDownloadUI$16(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void bT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196801);
    Toast.makeText(this.WwM, this.WwM.getString(R.l.toast_file_saved_fmt, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString2) }), 1).show();
    AppMethodBeat.o(196801);
  }
  
  public final void bU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196804);
    Toast.makeText(this.WwM, this.WwM.getString(R.l.toast_file_saved_fail), 1).show();
    AppMethodBeat.o(196804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.16
 * JD-Core Version:    0.7.0.1
 */