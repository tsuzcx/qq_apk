package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class LuggageUploadMediaFileManager$7
  implements d.b
{
  LuggageUploadMediaFileManager$7(String paramString, LuggageUploadMediaFileManager.a parama) {}
  
  public final void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(153127);
    ab.i("MicroMsg.UploadMediaFileHelp", "on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString2, paramString1, paramString3 });
    if ((bo.isNullOrNil(paramString1)) || (!paramString1.equals(this.uUf)))
    {
      AppMethodBeat.o(153127);
      return;
    }
    g.dcD().a(this);
    if (LuggageUploadMediaFileManager.dbF() != null)
    {
      LuggageUploadMediaFileManager.dbF().dismiss();
      LuggageUploadMediaFileManager.dbG();
    }
    this.uUg.d(paramBoolean, paramString2, paramString3);
    AppMethodBeat.o(153127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.7
 * JD-Core Version:    0.7.0.1
 */