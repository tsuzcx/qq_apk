package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class am
{
  private static am uWj;
  HashMap<String, WebViewJSSDKFileItem> uWk;
  
  static
  {
    AppMethodBeat.i(6717);
    uWj = new am();
    AppMethodBeat.o(6717);
  }
  
  public am()
  {
    AppMethodBeat.i(6714);
    this.uWk = new HashMap();
    AppMethodBeat.o(6714);
  }
  
  public static final am dbZ()
  {
    return uWj;
  }
  
  public final void a(WebViewJSSDKFileItem paramWebViewJSSDKFileItem)
  {
    AppMethodBeat.i(6715);
    if ((paramWebViewJSSDKFileItem == null) || (bo.isNullOrNil(paramWebViewJSSDKFileItem.ctV)))
    {
      ab.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(6715);
      return;
    }
    ab.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[] { paramWebViewJSSDKFileItem.ctV, paramWebViewJSSDKFileItem.hgj });
    this.uWk.put(paramWebViewJSSDKFileItem.ctV, paramWebViewJSSDKFileItem);
    AppMethodBeat.o(6715);
  }
  
  public final WebViewJSSDKFileItem ahh(String paramString)
  {
    AppMethodBeat.i(6716);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(6716);
      return null;
    }
    paramString = (WebViewJSSDKFileItem)this.uWk.get(paramString);
    AppMethodBeat.o(6716);
    return paramString;
  }
  
  public final WebViewJSSDKFileItem ahi(String paramString)
  {
    AppMethodBeat.i(153138);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
      AppMethodBeat.o(153138);
      return null;
    }
    Iterator localIterator = this.uWk.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = (WebViewJSSDKFileItem)localIterator.next();
      if (bo.nullAsNil(localWebViewJSSDKFileItem.hgk).equals(paramString))
      {
        AppMethodBeat.o(153138);
        return localWebViewJSSDKFileItem;
      }
    }
    AppMethodBeat.o(153138);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.am
 * JD-Core Version:    0.7.0.1
 */