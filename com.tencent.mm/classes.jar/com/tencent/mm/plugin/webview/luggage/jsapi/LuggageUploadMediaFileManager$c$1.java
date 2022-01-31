package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.ipc.a;

final class LuggageUploadMediaFileManager$c$1
  implements LuggageUploadMediaFileManager.a
{
  LuggageUploadMediaFileManager$c$1(LuggageUploadMediaFileManager.c paramc) {}
  
  public final void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6402);
    if (LuggageUploadMediaFileManager.c.a(this.uUl) != null)
    {
      if (paramBoolean)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("media_id", paramString1);
        localBundle.putString("media_url", paramString2);
        LuggageUploadMediaFileManager.c.a(this.uUl).o(localBundle);
        AppMethodBeat.o(6402);
        return;
      }
      LuggageUploadMediaFileManager.c.a(this.uUl).o(null);
    }
    AppMethodBeat.o(6402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.c.1
 * JD-Core Version:    0.7.0.1
 */