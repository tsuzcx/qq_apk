package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

final class g$55
  implements o.a
{
  g$55(g paramg, i parami) {}
  
  public final void c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(154978);
    if (!bo.isNullOrNil(paramString))
    {
      this.vqm.a(this.uZa, this.uZa.vrQ + ":fail_" + paramString, null);
      AppMethodBeat.o(154978);
      return;
    }
    this.vqm.a(this.uZa, this.uZa.vrQ + ":ok", g.aV(paramJSONObject));
    AppMethodBeat.o(154978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.55
 * JD-Core Version:    0.7.0.1
 */