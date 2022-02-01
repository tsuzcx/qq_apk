package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f.b;

final class AppAttachDownloadUI$15
  implements f.b
{
  AppAttachDownloadUI$15(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(253848);
    Log.d("MicroMsg.AppAttachDownloadUI", "showAlert, onDismiss");
    AppAttachDownloadUI.B(this.aeed);
    AppMethodBeat.o(253848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.15
 * JD-Core Version:    0.7.0.1
 */