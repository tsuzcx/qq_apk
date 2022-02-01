package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class an
{
  private static an CqI;
  HashMap<String, WebViewJSSDKFileItem> CqJ;
  
  static
  {
    AppMethodBeat.i(79009);
    CqI = new an();
    AppMethodBeat.o(79009);
  }
  
  public an()
  {
    AppMethodBeat.i(79005);
    this.CqJ = new HashMap();
    AppMethodBeat.o(79005);
  }
  
  public static final an eBy()
  {
    return CqI;
  }
  
  public final void a(WebViewJSSDKFileItem paramWebViewJSSDKFileItem)
  {
    AppMethodBeat.i(79006);
    if ((paramWebViewJSSDKFileItem == null) || (bs.isNullOrNil(paramWebViewJSSDKFileItem.dgl)))
    {
      ac.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(79006);
      return;
    }
    ac.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[] { paramWebViewJSSDKFileItem.dgl, paramWebViewJSSDKFileItem.jAH });
    this.CqJ.put(paramWebViewJSSDKFileItem.dgl, paramWebViewJSSDKFileItem);
    AppMethodBeat.o(79006);
  }
  
  public final void aBT(String paramString)
  {
    AppMethodBeat.i(188339);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, local id is null");
      AppMethodBeat.o(188339);
      return;
    }
    ac.i("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, localId:%s", new Object[] { paramString });
    this.CqJ.remove(paramString);
    AppMethodBeat.o(188339);
  }
  
  public final WebViewJSSDKFileItem aBU(String paramString)
  {
    AppMethodBeat.i(79007);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(79007);
      return null;
    }
    paramString = (WebViewJSSDKFileItem)this.CqJ.get(paramString);
    AppMethodBeat.o(79007);
    return paramString;
  }
  
  public final WebViewJSSDKFileItem aBV(String paramString)
  {
    AppMethodBeat.i(79008);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
      AppMethodBeat.o(79008);
      return null;
    }
    Iterator localIterator = this.CqJ.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = (WebViewJSSDKFileItem)localIterator.next();
      if (bs.nullAsNil(localWebViewJSSDKFileItem.jAI).equals(paramString))
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