package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class LuggageUploadMediaFileManager$4
  implements Runnable
{
  LuggageUploadMediaFileManager$4(LuggageUploadMediaFileManager paramLuggageUploadMediaFileManager, LuggageUploadMediaFileManager.UploadMediaFileTask paramUploadMediaFileTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(6395);
    this.uUe.aBk();
    LuggageUploadMediaFileManager.b(this.uUd);
    if (this.uUe.success)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("serverId", bo.nullAsNil(this.uUe.cBO));
      localHashMap.put("mediaUrl", bo.nullAsNil(this.uUe.uUn));
      this.uUd.uUc.a(true, localHashMap);
      AppMethodBeat.o(6395);
      return;
    }
    this.uUd.uUc.a(false, null);
    AppMethodBeat.o(6395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.4
 * JD-Core Version:    0.7.0.1
 */