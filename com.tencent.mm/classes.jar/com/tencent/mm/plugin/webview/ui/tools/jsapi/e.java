package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

public final class e
  implements b
{
  private MMWebView foJ;
  private d vmp;
  
  public e(MMWebView paramMMWebView, d paramd)
  {
    this.foJ = paramMMWebView;
    this.vmp = paramd;
  }
  
  public final boolean ait(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(9019);
    if (this.foJ != null) {
      this.foJ.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
    }
    paramString = paramString.substring(27);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.JsApiResultHandler", "SetResultHandler handleUrl fail, value is null");
      AppMethodBeat.o(9019);
      return false;
    }
    int i = paramString.indexOf("&");
    if (i <= 0)
    {
      ab.e("MicroMsg.JsApiResultHandler", "SetResultHandler, handleUrl fail, invalid splitorIdx = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(9019);
      return false;
    }
    String str = paramString.substring(0, i);
    try
    {
      paramString = Base64.decode(paramString.substring(i + 1), 0);
      if (paramString == null)
      {
        paramString = localObject;
        ab.i("MicroMsg.JsApiResultHandler", "SetResultHandler, scene = %s, result = %s", new Object[] { str, paramString });
        this.vmp.keep_setReturnValue(str, paramString);
        AppMethodBeat.o(9019);
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiResultHandler", "SetResultHandler decodeBase64 failed");
        paramString = null;
        continue;
        paramString = new String(paramString);
      }
    }
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(9018);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(9018);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://private/setresult/");
    AppMethodBeat.o(9018);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.e
 * JD-Core Version:    0.7.0.1
 */