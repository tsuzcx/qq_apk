package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class LuggageUploadMediaFileManager$7
  implements d.b
{
  LuggageUploadMediaFileManager$7(String paramString, LuggageUploadMediaFileManager.a parama) {}
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.UploadMediaFileHelp", "on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString2, paramString1, paramString3 });
    if ((bk.bl(paramString1)) || (!paramString1.equals(this.rec))) {
      return;
    }
    g.ccK().a(this);
    if (LuggageUploadMediaFileManager.cbB() != null)
    {
      LuggageUploadMediaFileManager.cbB().dismiss();
      LuggageUploadMediaFileManager.cbC();
    }
    this.ree.c(paramBoolean, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.7
 * JD-Core Version:    0.7.0.1
 */