package com.tencent.mm.plugin.websearch.webview;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "T", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi;", "imageUIComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;)V", "TAG", "", "getImageUIComponent", "getSearchAvatarList", "params", "getSearchImageList", "onSearchImageListReady", "", "ret", "", "data", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public class l<T>
  extends b<T>
{
  private final String TAG;
  
  public l(d<T> paramd)
  {
    super((f)paramd);
    AppMethodBeat.i(315192);
    this.TAG = "MicroMsg.WebSearch.WebSearchImageJSApi";
    AppMethodBeat.o(315192);
  }
  
  private final d<T> iqS()
  {
    c localc = this.WrO;
    if ((localc instanceof d)) {
      return (d)localc;
    }
    return null;
  }
  
  public final void dG(int paramInt, String paramString)
  {
    AppMethodBeat.i(315213);
    s.u(paramString, "data");
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret", paramInt);
      ((JSONObject)localObject).put("data", paramString);
      label35:
      paramString = this.WrO;
      if (paramString != null)
      {
        paramString = paramString.getWebView();
        if (paramString != null)
        {
          m localm = m.WrX;
          localObject = ((JSONObject)localObject).toString();
          s.s(localObject, "requestObj.toString()");
          m.a(paramString, "onSearchImageListReady", (String)localObject);
        }
      }
      AppMethodBeat.o(315213);
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
    AppMethodBeat.i(315208);
    try
    {
      paramString = new JSONObject(paramString).optString("data", "");
      Object localObject = iqS();
      if (localObject != null)
      {
        localObject = ((d)localObject).fyR();
        if (localObject != null)
        {
          s.s(paramString, "data");
          ((k)localObject).biL(paramString);
        }
      }
      paramString = iqR().toString();
      AppMethodBeat.o(315208);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(315208);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public String getSearchImageList(String paramString)
  {
    AppMethodBeat.i(315204);
    Log.i(this.TAG, s.X("getSearchImageList ", paramString));
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("requestType", 0);
      paramString = paramString.optString("data", "");
      Object localObject = iqS();
      if (localObject != null)
      {
        localObject = ((d)localObject).fyR();
        if (localObject != null)
        {
          s.s(paramString, "data");
          ((k)localObject).dF(i, paramString);
        }
      }
      paramString = iqR().toString();
      AppMethodBeat.o(315204);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(315204);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.l
 * JD-Core Version:    0.7.0.1
 */