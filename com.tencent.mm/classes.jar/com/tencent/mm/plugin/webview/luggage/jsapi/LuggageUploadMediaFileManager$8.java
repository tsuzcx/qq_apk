package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;

final class LuggageUploadMediaFileManager$8
  implements DialogInterface.OnCancelListener
{
  LuggageUploadMediaFileManager$8(d.b paramb, String paramString, LuggageUploadMediaFileManager.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(6399);
    g.dcD().a(this.uUh);
    g.dcD();
    al.zE(this.uUf);
    this.uUg.d(false, "", "");
    AppMethodBeat.o(6399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.8
 * JD-Core Version:    0.7.0.1
 */