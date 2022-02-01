package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class an
{
  private static an AYv;
  HashMap<String, WebViewJSSDKFileItem> AYw;
  
  static
  {
    AppMethodBeat.i(79009);
    AYv = new an();
    AppMethodBeat.o(79009);
  }
  
  public an()
  {
    AppMethodBeat.i(79005);
    this.AYw = new HashMap();
    AppMethodBeat.o(79005);
  }
  
  public static final an emc()
  {
    return AYv;
  }
  
  public final void a(WebViewJSSDKFileItem paramWebViewJSSDKFileItem)
  {
    AppMethodBeat.i(79006);
    if ((paramWebViewJSSDKFileItem == null) || (bt.isNullOrNil(paramWebViewJSSDKFileItem.diQ)))
    {
      ad.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(79006);
      return;
    }
    ad.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[] { paramWebViewJSSDKFileItem.diQ, paramWebViewJSSDKFileItem.jau });
    this.AYw.put(paramWebViewJSSDKFileItem.diQ, paramWebViewJSSDKFileItem);
    AppMethodBeat.o(79006);
  }
  
  public final void awB(String paramString)
  {
    AppMethodBeat.i(187912);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, local id is null");
      AppMethodBeat.o(187912);
      return;
    }
    ad.i("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, localId:%s", new Object[] { paramString });
    this.AYw.remove(paramString);
    AppMethodBeat.o(187912);
  }
  
  public final WebViewJSSDKFileItem awC(String paramString)
  {
    AppMethodBeat.i(79007);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(79007);
      return null;
    }
    paramString = (WebViewJSSDKFileItem)this.AYw.get(paramString);
    AppMethodBeat.o(79007);
    return paramString;
  }
  
  public final WebViewJSSDKFileItem awD(String paramString)
  {
    AppMethodBeat.i(79008);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
      AppMethodBeat.o(79008);
      return null;
    }
    Iterator localIterator = this.AYw.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = (WebViewJSSDKFileItem)localIterator.next();
      if (bt.nullAsNil(localWebViewJSSDKFileItem.jav).equals(paramString))
      {
        AppMethodBeat.o(79008);
        return localWebViewJSSDKFileItem;
      }
    }
    AppMethodBeat.o(79008);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an
 * JD-Core Version:    0.7.0.1
 */