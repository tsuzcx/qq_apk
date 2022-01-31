package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.luggage.ipc.b;

final class LuggageUploadMediaFileManager$c$1
  implements LuggageUploadMediaFileManager.a
{
  LuggageUploadMediaFileManager$c$1(LuggageUploadMediaFileManager.c paramc) {}
  
  public final void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (LuggageUploadMediaFileManager.c.a(this.rej) != null)
    {
      if (paramBoolean)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("media_id", paramString1);
        localBundle.putString("media_url", paramString2);
        LuggageUploadMediaFileManager.c.a(this.rej).g(localBundle);
      }
    }
    else {
      return;
    }
    LuggageUploadMediaFileManager.c.a(this.rej).g(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.c.1
 * JD-Core Version:    0.7.0.1
 */