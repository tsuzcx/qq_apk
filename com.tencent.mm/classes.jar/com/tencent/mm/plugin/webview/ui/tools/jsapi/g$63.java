package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

final class g$63
  implements o.a
{
  g$63(g paramg, i parami) {}
  
  public final void c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(154984);
    if (bo.isNullOrNil(paramString)) {
      this.vqm.a(this.uZa, "resume_download_task:ok", g.aV(paramJSONObject));
    }
    AppMethodBeat.o(154984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.63
 * JD-Core Version:    0.7.0.1
 */