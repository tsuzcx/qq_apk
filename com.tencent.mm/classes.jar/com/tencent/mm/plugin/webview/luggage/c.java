package com.tencent.mm.plugin.webview.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.g.d;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

public final class c
  implements com.tencent.luggage.webview.a.c
{
  private String uRe = "";
  
  public c() {}
  
  public c(String paramString)
  {
    this.uRe = paramString;
  }
  
  public final WebResourceResponse bG(String paramString)
  {
    AppMethodBeat.i(5979);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(5979);
      return null;
    }
    paramString = i.p(ah.getContext(), "LuggageBridge.js");
    paramString = paramString + this.uRe;
    try
    {
      paramString = new WebResourceResponse("application/javascript", "utf-8", new ByteArrayInputStream(paramString.getBytes("UTF-8")));
      HashMap localHashMap = new HashMap();
      localHashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
      localHashMap.put("Pragma", "no-cache");
      localHashMap.put("Expires", "0");
      paramString.setResponseHeaders(localHashMap);
      AppMethodBeat.o(5979);
      return paramString;
    }
    catch (Exception paramString)
    {
      d.a("MicroMsg.LuggageMMJsBridgeResourceProvider", "", new Object[] { paramString });
      AppMethodBeat.o(5979);
    }
    return null;
  }
  
  public final String xd()
  {
    return "weixin://bridge.js";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c
 * JD-Core Version:    0.7.0.1
 */