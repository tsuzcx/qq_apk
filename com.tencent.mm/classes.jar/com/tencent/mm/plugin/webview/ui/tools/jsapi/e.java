package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

public final class e
  implements b
{
  private MMWebView dYF;
  private d rvZ;
  
  public e(MMWebView paramMMWebView, d paramd)
  {
    this.dYF = paramMMWebView;
    this.rvZ = paramd;
  }
  
  public final boolean Tq(String paramString)
  {
    Object localObject = null;
    if (this.dYF != null) {
      this.dYF.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
    }
    paramString = paramString.substring(27);
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.JsApiResultHandler", "SetResultHandler handleUrl fail, value is null");
      return false;
    }
    int i = paramString.indexOf("&");
    if (i <= 0)
    {
      y.e("MicroMsg.JsApiResultHandler", "SetResultHandler, handleUrl fail, invalid splitorIdx = %d", new Object[] { Integer.valueOf(i) });
      return false;
    }
    String str = paramString.substring(0, i);
    try
    {
      paramString = Base64.decode(paramString.substring(i + 1), 0);
      if (paramString == null)
      {
        paramString = localObject;
        y.i("MicroMsg.JsApiResultHandler", "SetResultHandler, scene = %s, result = %s", new Object[] { str, paramString });
        this.rvZ.keep_setReturnValue(str, paramString);
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiResultHandler", "SetResultHandler decodeBase64 failed");
        paramString = null;
        continue;
        paramString = new String(paramString);
      }
    }
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://private/setresult/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.e
 * JD-Core Version:    0.7.0.1
 */