package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.ipc.c;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.modeltools.g;

public class LuggageUploadMediaFileManager$c
  implements c
{
  private LuggageUploadMediaFileManager.a uUj;
  private com.tencent.mm.plugin.webview.luggage.ipc.a uUk;
  
  public LuggageUploadMediaFileManager$c()
  {
    AppMethodBeat.i(6403);
    this.uUj = new LuggageUploadMediaFileManager.c.1(this);
    AppMethodBeat.o(6403);
  }
  
  public final void a(Context paramContext, Bundle paramBundle, com.tencent.mm.plugin.webview.luggage.ipc.a parama)
  {
    AppMethodBeat.i(6404);
    this.uUk = parama;
    String str1 = paramBundle.getString("local_id");
    String str2 = paramBundle.getString("app_id");
    boolean bool = paramBundle.getBoolean("show_progress_tips");
    paramBundle = g.dcE().ahh(str1);
    if (paramBundle == null)
    {
      parama.o(null);
      AppMethodBeat.o(6404);
      return;
    }
    switch (paramBundle.cth)
    {
    case 2: 
    case 3: 
    default: 
      LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.ecN, bool, this.uUj);
      AppMethodBeat.o(6404);
      return;
    case 1: 
      LuggageUploadMediaFileManager.a(paramContext, paramBundle, str2, str1, com.tencent.mm.i.a.ecM, bool, this.uUj);
      AppMethodBeat.o(6404);
      return;
    }
    LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.ecN, bool, this.uUj);
    AppMethodBeat.o(6404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.c
 * JD-Core Version:    0.7.0.1
 */