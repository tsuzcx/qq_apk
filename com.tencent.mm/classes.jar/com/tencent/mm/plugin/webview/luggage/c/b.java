package com.tencent.mm.plugin.webview.luggage.c;

import android.os.Bundle;
import android.os.Looper;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
{
  public static JSONObject Zc(String paramString)
  {
    AppMethodBeat.i(78767);
    if (Util.isNullOrNil(paramString))
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
      Log.e("MicroMsg.LuggageWebViewUtil", paramString.getMessage());
      AppMethodBeat.o(78767);
    }
    return null;
  }
  
  public static WebViewJSSDKFileItem aYC(String paramString)
  {
    AppMethodBeat.i(78768);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.LuggageWebViewUtil", "get by local id error, local id is null or nil");
      AppMethodBeat.o(78768);
      return null;
    }
    if (MMApplicationContext.isMMProcess())
    {
      paramString = g.gdv().aYO(paramString);
      AppMethodBeat.o(78768);
      return paramString;
    }
    paramString = (WebViewJSSDKFileItem)h.a(MainProcessIPCService.dkO, new IPCString(paramString), b.class);
    AppMethodBeat.o(78768);
    return paramString;
  }
  
  public static boolean afC(String paramString)
  {
    AppMethodBeat.i(78769);
    if ((!Util.isNullOrNil(paramString)) && ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString))))
    {
      AppMethodBeat.o(78769);
      return true;
    }
    AppMethodBeat.o(78769);
    return false;
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(78766);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      MMHandlerThread.postToMainThread(paramRunnable);
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