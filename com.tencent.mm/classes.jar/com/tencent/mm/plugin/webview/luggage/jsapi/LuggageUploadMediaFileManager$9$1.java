package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuggageUploadMediaFileManager$9$1
  implements DialogInterface.OnClickListener
{
  LuggageUploadMediaFileManager$9$1(LuggageUploadMediaFileManager.9 param9) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(6400);
    LuggageUploadMediaFileManager.dbF().cancel();
    AppMethodBeat.o(6400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.9.1
 * JD-Core Version:    0.7.0.1
 */