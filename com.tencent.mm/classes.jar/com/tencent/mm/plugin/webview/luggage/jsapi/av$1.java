package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.e.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class av$1
  implements LuggageUploadMediaFileManager.b
{
  av$1(av paramav, a.a parama, LuggageUploadMediaFileManager paramLuggageUploadMediaFileManager) {}
  
  public final void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    y.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.kNj.c("", paramHashMap);
    }
    for (;;)
    {
      paramHashMap = this.rdU;
      paramHashMap.iwz = null;
      paramHashMap.rcp = null;
      paramHashMap.mAppId = null;
      paramHashMap.rdX = null;
      paramHashMap.rdZ = null;
      return;
      this.kNj.a("fail", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.av.1
 * JD-Core Version:    0.7.0.1
 */