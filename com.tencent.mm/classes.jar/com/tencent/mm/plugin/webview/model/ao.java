package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class ao
{
  private static ao DUl;
  HashMap<String, WebViewJSSDKFileItem> DUm;
  
  static
  {
    AppMethodBeat.i(79009);
    DUl = new ao();
    AppMethodBeat.o(79009);
  }
  
  public ao()
  {
    AppMethodBeat.i(79005);
    this.DUm = new HashMap();
    AppMethodBeat.o(79005);
  }
  
  public static final ao eQs()
  {
    return DUl;
  }
  
  public final void a(WebViewJSSDKFileItem paramWebViewJSSDKFileItem)
  {
    AppMethodBeat.i(79006);
    if ((paramWebViewJSSDKFileItem == null) || (bt.isNullOrNil(paramWebViewJSSDKFileItem.drH)))
    {
      ad.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(79006);
      return;
    }
    ad.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[] { paramWebViewJSSDKFileItem.drH, paramWebViewJSSDKFileItem.jUC });
    this.DUm.put(paramWebViewJSSDKFileItem.drH, paramWebViewJSSDKFileItem);
    AppMethodBeat.o(79006);
  }
  
  public final void aHt(String paramString)
  {
    AppMethodBeat.i(207962);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, local id is null");
      AppMethodBeat.o(207962);
      return;
    }
    ad.i("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, localId:%s", new Object[] { paramString });
    this.DUm.remove(paramString);
    AppMethodBeat.o(207962);
  }
  
  public final WebViewJSSDKFileItem aHu(String paramString)
  {
    AppMethodBeat.i(79007);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(79007);
      return null;
    }
    paramString = (WebViewJSSDKFileItem)this.DUm.get(paramString);
    AppMethodBeat.o(79007);
    return paramString;
  }
  
  public final WebViewJSSDKFileItem aHv(String paramString)
  {
    AppMethodBeat.i(79008);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
      AppMethodBeat.o(79008);
      return null;
    }
    Iterator localIterator = this.DUm.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = (WebViewJSSDKFileItem)localIterator.next();
      if (bt.nullAsNil(localWebViewJSSDKFileItem.jUD).equals(paramString))
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
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ao
 * JD-Core Version:    0.7.0.1
 */