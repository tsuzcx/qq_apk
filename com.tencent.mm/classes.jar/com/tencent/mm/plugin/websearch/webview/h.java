package com.tencent.mm.plugin.websearch.webview;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "T", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi;", "imageUIComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;)V", "TAG", "", "getImageUIComponent", "getSearchAvatarList", "params", "getSearchImageList", "onSearchImageListReady", "", "ret", "", "data", "ui-websearch_release"})
public class h<T>
  extends b<T>
{
  private final String TAG;
  
  public h(c<T> paramc)
  {
    AppMethodBeat.i(198317);
    this.TAG = "MicroMsg.WebSearch.WebSearchImageJSApi";
    this.PBs = ((d)paramc);
    AppMethodBeat.o(198317);
  }
  
  private final c<T> gRD()
  {
    d locald2 = this.PBs;
    d locald1 = locald2;
    if (!(locald2 instanceof c)) {
      locald1 = null;
    }
    return (c)locald1;
  }
  
  public final void cQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(198316);
    p.k(paramString, "data");
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret", paramInt);
      ((JSONObject)localObject).put("data", paramString);
      label35:
      paramString = this.PBs;
      if (paramString != null)
      {
        paramString = paramString.esG();
        if (paramString != null)
        {
          i locali = i.PBA;
          localObject = ((JSONObject)localObject).toString();
          p.j(localObject, "requestObj.toString()");
          i.a(paramString, "onSearchImageListReady", (String)localObject);
          AppMethodBeat.o(198316);
          return;
        }
      }
      AppMethodBeat.o(198316);
      return;
    }
    catch (Exception paramString)
    {
      break label35;
    }
  }
  
  @JavascriptInterface
  public String getSearchAvatarList(String paramString)
  {
    AppMethodBeat.i(198313);
    try
    {
      paramString = new JSONObject(paramString).optString("data", "");
      Object localObject = gRD();
      if (localObject != null)
      {
        localObject = ((c)localObject).esH();
        if (localObject != null)
        {
          p.j(paramString, "data");
          ((g)localObject).bjc(paramString);
        }
      }
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198313);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(gRC());
      AppMethodBeat.o(198313);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public String getSearchImageList(String paramString)
  {
    AppMethodBeat.i(198312);
    Log.i(this.TAG, "getSearchImageList ".concat(String.valueOf(paramString)));
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("requestType", 0);
      paramString = paramString.optString("data", "");
      Object localObject = gRD();
      if (localObject != null)
      {
        localObject = ((c)localObject).esH();
        if (localObject != null)
        {
          p.j(paramString, "data");
          ((g)localObject).cP(i, paramString);
        }
      }
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198312);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(gRC());
      AppMethodBeat.o(198312);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.h
 * JD-Core Version:    0.7.0.1
 */