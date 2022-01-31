package com.tencent.mm.plugin.webview.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.j.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements com.tencent.luggage.webview.a.c
{
  public final WebResourceResponse bf(String paramString)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    paramString = h.k(ae.getContext(), "LuggageBridge.js");
    Object localObject = h.k(ae.getContext(), "luggage_game_adapter.js");
    paramString = paramString + (String)localObject;
    try
    {
      paramString = new WebResourceResponse("application/javascript", "utf-8", new ByteArrayInputStream(paramString.getBytes("UTF-8")));
      localObject = new HashMap();
      ((HashMap)localObject).put("Cache-Control", "no-cache, no-store, must-revalidate");
      ((HashMap)localObject).put("Pragma", "no-cache");
      ((HashMap)localObject).put("Expires", "0");
      paramString.setResponseHeaders((Map)localObject);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.luggage.j.c.b("MicroMsg.LuggageMMJsBridgeResourceProvider", "", new Object[] { paramString });
    }
    return null;
  }
  
  public final String qx()
  {
    return "weixin://bridge.js";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c
 * JD-Core Version:    0.7.0.1
 */