package com.tencent.mm.plugin.webview.luggage.c;

import android.os.Looper;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class b
{
  public static JSONObject BJ(String paramString)
  {
    AppMethodBeat.i(6505);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6505);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      AppMethodBeat.o(6505);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.LuggageWebViewUtil", paramString.getMessage());
      AppMethodBeat.o(6505);
    }
    return null;
  }
  
  public static boolean Fl(String paramString)
  {
    AppMethodBeat.i(153129);
    if ((!bo.isNullOrNil(paramString)) && ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString))))
    {
      AppMethodBeat.o(153129);
      return true;
    }
    AppMethodBeat.o(153129);
    return false;
  }
  
  public static WebViewJSSDKFileItem agY(String paramString)
  {
    AppMethodBeat.i(6506);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.LuggageWebViewUtil", "get by local id error, local id is null or nil");
      AppMethodBeat.o(6506);
      return null;
    }
    if (ah.brt())
    {
      paramString = g.dcE().ahh(paramString);
      AppMethodBeat.o(6506);
      return paramString;
    }
    paramString = (WebViewJSSDKFileItem)f.a("com.tencent.mm", new IPCString(paramString), b.a.class);
    AppMethodBeat.o(6506);
    return paramString;
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(6504);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      al.d(paramRunnable);
      AppMethodBeat.o(6504);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(6504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c.b
 * JD-Core Version:    0.7.0.1
 */