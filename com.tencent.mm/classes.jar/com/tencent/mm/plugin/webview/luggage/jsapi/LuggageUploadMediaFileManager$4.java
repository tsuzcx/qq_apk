package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;

final class LuggageUploadMediaFileManager$4
  implements Runnable
{
  LuggageUploadMediaFileManager$4(LuggageUploadMediaFileManager paramLuggageUploadMediaFileManager, LuggageUploadMediaFileManager.UploadMediaFileTask paramUploadMediaFileTask) {}
  
  public final void run()
  {
    this.reb.ahD();
    LuggageUploadMediaFileManager.b(this.rea);
    if (this.reb.success)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("serverId", bk.pm(this.reb.bUi));
      localHashMap.put("mediaUrl", bk.pm(this.reb.rel));
      this.rea.rdZ.a(true, localHashMap);
      return;
    }
    this.rea.rdZ.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.4
 * JD-Core Version:    0.7.0.1
 */