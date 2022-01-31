package com.tencent.mm.plugin.webview.luggage.d;

import android.os.Looper;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class c
{
  public static WebViewJSSDKFileItem Sc(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.LuggageWebViewUtil", "get by local id error, local id is null or nil");
      return null;
    }
    if (ae.cqV()) {
      return g.ccL().Sl(paramString);
    }
    return (WebViewJSSDKFileItem)f.a("com.tencent.mm", new IPCString(paramString), c.a.class);
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ai.d(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  public static JSONObject tJ(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.LuggageWebViewUtil", paramString.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.c
 * JD-Core Version:    0.7.0.1
 */