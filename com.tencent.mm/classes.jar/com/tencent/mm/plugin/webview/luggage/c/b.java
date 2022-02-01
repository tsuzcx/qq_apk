package com.tencent.mm.plugin.webview.luggage.c;

import android.os.Bundle;
import android.os.Looper;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class b
{
  public static JSONObject LK(String paramString)
  {
    AppMethodBeat.i(78767);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78767);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      AppMethodBeat.o(78767);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.LuggageWebViewUtil", paramString.getMessage());
      AppMethodBeat.o(78767);
    }
    return null;
  }
  
  public static boolean Rp(String paramString)
  {
    AppMethodBeat.i(78769);
    if ((!bs.isNullOrNil(paramString)) && ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString))))
    {
      AppMethodBeat.o(78769);
      return true;
    }
    AppMethodBeat.o(78769);
    return false;
  }
  
  public static WebViewJSSDKFileItem aBI(String paramString)
  {
    AppMethodBeat.i(78768);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.LuggageWebViewUtil", "get by local id error, local id is null or nil");
      AppMethodBeat.o(78768);
      return null;
    }
    if (ai.ciE())
    {
      paramString = g.eCa().aBU(paramString);
      AppMethodBeat.o(78768);
      return paramString;
    }
    paramString = (WebViewJSSDKFileItem)h.a("com.tencent.mm", new IPCString(paramString), b.class);
    AppMethodBeat.o(78768);
    return paramString;
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(78766);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ap.f(paramRunnable);
      AppMethodBeat.o(78766);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(78766);
  }
  
  public static class a
    implements k<Bundle, Bundle>
  {}
  
  static class b
    implements k<IPCString, WebViewJSSDKFileItem>
  {}
  
  public static class c
    implements k<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c.b
 * JD-Core Version:    0.7.0.1
 */