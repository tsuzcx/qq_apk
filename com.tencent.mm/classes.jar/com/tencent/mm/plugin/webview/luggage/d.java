package com.tencent.mm.plugin.webview.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

public final class d
  implements c
{
  private String Clb = "";
  
  public d() {}
  
  public d(String paramString)
  {
    this.Clb = paramString;
  }
  
  public final String DX()
  {
    return "weixin://bridge.js";
  }
  
  public final WebResourceResponse bM(String paramString)
  {
    AppMethodBeat.i(78212);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(78212);
      return null;
    }
    paramString = com.tencent.mm.plugin.appbrand.z.d.Rn("LuggageBridge.js");
    paramString = paramString + this.Clb;
    try
    {
      paramString = new WebResourceResponse("application/javascript", "utf-8", new ByteArrayInputStream(paramString.getBytes("UTF-8")));
      HashMap localHashMap = new HashMap();
      localHashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
      localHashMap.put("Pragma", "no-cache");
      localHashMap.put("Expires", "0");
      paramString.setResponseHeaders(localHashMap);
      AppMethodBeat.o(78212);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.l("MicroMsg.LuggageMMJsBridgeResourceProvider", "", new Object[] { paramString });
      AppMethodBeat.o(78212);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d
 * JD-Core Version:    0.7.0.1
 */