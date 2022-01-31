package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class bg$1
  implements LuggageUploadMediaFileManager.b
{
  bg$1(bg parambg, a.a parama, LuggageUploadMediaFileManager paramLuggageUploadMediaFileManager) {}
  
  public final void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(6387);
    ab.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.njN.c("", paramHashMap);
    }
    for (;;)
    {
      paramHashMap = this.uTX;
      paramHashMap.kxD = null;
      paramHashMap.uSb = null;
      paramHashMap.mAppId = null;
      paramHashMap.uUa = null;
      paramHashMap.uUc = null;
      AppMethodBeat.o(6387);
      return;
      this.njN.a("fail", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bg.1
 * JD-Core Version:    0.7.0.1
 */