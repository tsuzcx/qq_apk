package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class ah
{
  private static ah rfW = new ah();
  HashMap<String, WebViewJSSDKFileItem> rfX = new HashMap();
  
  public static final ah cbW()
  {
    return rfW;
  }
  
  public final WebViewJSSDKFileItem Sl(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
      return null;
    }
    return (WebViewJSSDKFileItem)this.rfX.get(paramString);
  }
  
  public final void b(WebViewJSSDKFileItem paramWebViewJSSDKFileItem)
  {
    if ((paramWebViewJSSDKFileItem == null) || (bk.bl(paramWebViewJSSDKFileItem.bMB)))
    {
      y.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
      return;
    }
    y.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[] { paramWebViewJSSDKFileItem.bMB, paramWebViewJSSDKFileItem.fMZ });
    this.rfX.put(paramWebViewJSSDKFileItem.bMB, paramWebViewJSSDKFileItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah
 * JD-Core Version:    0.7.0.1
 */