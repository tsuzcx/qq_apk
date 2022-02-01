package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class ao
{
  private static ao Emk;
  HashMap<String, WebViewJSSDKFileItem> Eml;
  
  static
  {
    AppMethodBeat.i(79009);
    Emk = new ao();
    AppMethodBeat.o(79009);
  }
  
  public ao()
  {
    AppMethodBeat.i(79005);
    this.Eml = new HashMap();
    AppMethodBeat.o(79005);
  }
  
  public static final ao eUe()
  {
    return Emk;
  }
  
  public final void a(WebViewJSSDKFileItem paramWebViewJSSDKFileItem)
  {
    AppMethodBeat.i(79006);
    if ((paramWebViewJSSDKFileItem == null) || (bu.isNullOrNil(paramWebViewJSSDKFileItem.dsN)))
    {
      ae.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(79006);
      return;
    }
    ae.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[] { paramWebViewJSSDKFileItem.dsN, paramWebViewJSSDKFileItem.jXT });
    this.Eml.put(paramWebViewJSSDKFileItem.dsN, paramWebViewJSSDKFileItem);
    AppMethodBeat.o(79006);
  }
  
  public final void aIM(String paramString)
  {
    AppMethodBeat.i(198139);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, local id is null");
      AppMethodBeat.o(198139);
      return;
    }
    ae.i("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, localId:%s", new Object[] { paramString });
    this.Eml.remove(paramString);
    AppMethodBeat.o(198139);
  }
  
  public final WebViewJSSDKFileItem aIN(String paramString)
  {
    AppMethodBeat.i(79007);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(79007);
      return null;
    }
    paramString = (WebViewJSSDKFileItem)this.Eml.get(paramString);
    AppMethodBeat.o(79007);
    return paramString;
  }
  
  public final WebViewJSSDKFileItem aIO(String paramString)
  {
    AppMethodBeat.i(79008);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
      AppMethodBeat.o(79008);
      return null;
    }
    Iterator localIterator = this.Eml.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = (WebViewJSSDKFileItem)localIterator.next();
      if (bu.nullAsNil(localWebViewJSSDKFileItem.jXU).equals(paramString))
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