package com.tencent.mm.plugin.webview.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

public final class e
  implements c
{
  private String PPp = "";
  
  public e() {}
  
  public e(String paramString)
  {
    this.PPp = paramString;
  }
  
  public final String SK()
  {
    return "weixin://bridge.js";
  }
  
  public final WebResourceResponse dx(String paramString)
  {
    AppMethodBeat.i(78212);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(78212);
      return null;
    }
    paramString = d.anc("LuggageBridge.js");
    paramString = paramString + this.PPp;
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
      Log.printDebugStack("MicroMsg.LuggageMMJsBridgeResourceProvider", "", new Object[] { paramString });
      AppMethodBeat.o(78212);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e
 * JD-Core Version:    0.7.0.1
 */