package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;

final class LuggageUploadMediaFileManager$6
  implements DialogInterface.OnCancelListener
{
  LuggageUploadMediaFileManager$6(d.b paramb, String paramString, LuggageUploadMediaFileManager.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.ccK().a(this.ref);
    g.ccK();
    ag.rO(this.rec);
    this.ree.c(false, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.6
 * JD-Core Version:    0.7.0.1
 */