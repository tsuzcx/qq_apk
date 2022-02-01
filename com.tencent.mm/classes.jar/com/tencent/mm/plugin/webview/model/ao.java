package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class ao
{
  private static ao IZk;
  HashMap<String, WebViewJSSDKFileItem> IZl;
  
  static
  {
    AppMethodBeat.i(79009);
    IZk = new ao();
    AppMethodBeat.o(79009);
  }
  
  public ao()
  {
    AppMethodBeat.i(79005);
    this.IZl = new HashMap();
    AppMethodBeat.o(79005);
  }
  
  public static final ao gcQ()
  {
    return IZk;
  }
  
  public final void a(WebViewJSSDKFileItem paramWebViewJSSDKFileItem)
  {
    AppMethodBeat.i(79006);
    if ((paramWebViewJSSDKFileItem == null) || (Util.isNullOrNil(paramWebViewJSSDKFileItem.dJX)))
    {
      Log.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(79006);
      return;
    }
    Log.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[] { paramWebViewJSSDKFileItem.dJX, paramWebViewJSSDKFileItem.laR });
    this.IZl.put(paramWebViewJSSDKFileItem.dJX, paramWebViewJSSDKFileItem);
    AppMethodBeat.o(79006);
  }
  
  public final void aYN(String paramString)
  {
    AppMethodBeat.i(211001);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, local id is null");
      AppMethodBeat.o(211001);
      return;
    }
    Log.i("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, localId:%s", new Object[] { paramString });
    this.IZl.remove(paramString);
    AppMethodBeat.o(211001);
  }
  
  public final WebViewJSSDKFileItem aYO(String paramString)
  {
    AppMethodBeat.i(79007);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(79007);
      return null;
    }
    paramString = (WebViewJSSDKFileItem)this.IZl.get(paramString);
    AppMethodBeat.o(79007);
    return paramString;
  }
  
  public final WebViewJSSDKFileItem aYP(String paramString)
  {
    AppMethodBeat.i(79008);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
      AppMethodBeat.o(79008);
      return null;
    }
    Iterator localIterator = this.IZl.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = (WebViewJSSDKFileItem)localIterator.next();
      if (Util.nullAsNil(localWebViewJSSDKFileItem.laS).equals(paramString))
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