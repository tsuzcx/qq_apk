package com.tencent.mm.plugin.websearch.webview;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "T", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi;", "imageUIComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;)V", "TAG", "", "getImageUIComponent", "getSearchAvatarList", "params", "getSearchImageList", "onSearchImageListReady", "", "ret", "", "data", "ui-websearch_release"})
public class h<T>
  extends b<T>
{
  private final String TAG;
  
  public h(c<T> paramc)
  {
    AppMethodBeat.i(198073);
    this.TAG = "MicroMsg.WebSearch.WebSearchImageJSApi";
    this.IHe = ((d)paramc);
    AppMethodBeat.o(198073);
  }
  
  private final c<T> fYS()
  {
    d locald2 = this.IHe;
    d locald1 = locald2;
    if (!(locald2 instanceof c)) {
      locald1 = null;
    }
    return (c)locald1;
  }
  
  public final void cQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(198072);
    p.h(paramString, "data");
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret", paramInt);
      ((JSONObject)localObject).put("data", paramString);
      label35:
      paramString = this.IHe;
      if (paramString != null)
      {
        paramString = paramString.dQg();
        if (paramString != null)
        {
          i locali = i.IHk;
          localObject = ((JSONObject)localObject).toString();
          p.g(localObject, "requestObj.toString()");
          i.a(paramString, "onSearchImageListReady", (String)localObject);
          AppMethodBeat.o(198072);
          return;
        }
      }
      AppMethodBeat.o(198072);
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
    AppMethodBeat.i(198071);
    try
    {
      paramString = new JSONObject(paramString).optString("data", "");
      Object localObject = fYS();
      if (localObject != null)
      {
        localObject = ((c)localObject).dQh();
        if (localObject != null)
        {
          p.g(paramString, "data");
          ((g)localObject).aXr(paramString);
        }
      }
      paramString = String.valueOf(fYQ());
      AppMethodBeat.o(198071);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(fYR());
      AppMethodBeat.o(198071);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public String getSearchImageList(String paramString)
  {
    AppMethodBeat.i(198070);
    Log.i(this.TAG, "getSearchImageList ".concat(String.valueOf(paramString)));
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("requestType", 0);
      paramString = paramString.optString("data", "");
      Object localObject = fYS();
      if (localObject != null)
      {
        localObject = ((c)localObject).dQh();
        if (localObject != null)
        {
          p.g(paramString, "data");
          ((g)localObject).cP(i, paramString);
        }
      }
      paramString = String.valueOf(fYQ());
      AppMethodBeat.o(198070);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(fYR());
      AppMethodBeat.o(198070);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.h
 * JD-Core Version:    0.7.0.1
 */