package com.tencent.mm.plugin.websearch.b;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.b.a.b;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.plugin.websearch.webview.o;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.flp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryJSApi;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;)V", "TAG", "", "appendSearchTag", "params", "getReportType", "", "getUIComponent", "openSearchWebView", "setSearchTagResult", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends o<flp>
{
  private final String TAG;
  
  public a(b paramb)
  {
    super((e)paramb);
    AppMethodBeat.i(315390);
    this.TAG = "MicroMsg.WebSearch.TagSearchJSApi";
    AppMethodBeat.o(315390);
  }
  
  private final b iqD()
  {
    com.tencent.mm.plugin.websearch.webview.c localc = this.WrO;
    if ((localc instanceof b)) {
      return (b)localc;
    }
    return null;
  }
  
  @JavascriptInterface
  public final String appendSearchTag(String paramString)
  {
    AppMethodBeat.i(315401);
    Log.i(this.TAG, kotlin.g.b.s.X("appendSearchTag ", paramString));
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("query", "");
      String str1 = ((JSONObject)localObject).optString("searchId", "");
      String str2 = ((JSONObject)localObject).optString("sessionId", "");
      localObject = ((JSONObject)localObject).optString("requestId", "");
      b localb = iqD();
      if (localb != null)
      {
        kotlin.g.b.s.s(paramString, "tag");
        kotlin.g.b.s.s(str2, "sessionId");
        kotlin.g.b.s.s(str1, "searchId");
        kotlin.g.b.s.s(localObject, "requestId");
        localb.N(paramString, str2, str1, (String)localObject);
      }
      paramString = iqR().toString();
      AppMethodBeat.o(315401);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(315401);
    }
    return paramString;
  }
  
  public final int edC()
  {
    return 1;
  }
  
  @JavascriptInterface
  public final String openSearchWebView(String paramString)
  {
    AppMethodBeat.i(315417);
    Log.i(this.TAG, kotlin.g.b.s.X("openSearchWebView ", paramString));
    try
    {
      Object localObject = new JSONObject(paramString);
      String str2 = ((JSONObject)localObject).optString("query");
      int i = ((JSONObject)localObject).optInt("scene", 0);
      int j = ((JSONObject)localObject).optInt("type", 0);
      int k = ((JSONObject)localObject).optInt("subType", 0);
      String str3 = ((JSONObject)localObject).optString("searchId", "");
      String str4 = ((JSONObject)localObject).optString("sessionId", "");
      int m = ((JSONObject)localObject).optInt("actionType", 0);
      paramString = ((JSONObject)localObject).optString("extParams", "");
      localObject = ((JSONObject)localObject).optJSONObject("nativeConfig");
      if (localObject == null) {
        localObject = "";
      }
      for (;;)
      {
        Map localMap;
        flp localflp;
        if (m == 3)
        {
          localMap = aj.a(i, false, j, paramString);
          localMap.put("query", str2);
          localMap.put("searchId", str3);
          localMap.put("subType", String.valueOf(k));
          localMap.put("sessionId", str4);
          localMap.put("subSessionId", aj.asV(i));
          localflp = new flp();
          paramString = iqD();
          if (paramString != null) {
            break label348;
          }
          paramString = "";
        }
        for (;;)
        {
          localflp.talker = paramString;
          paramString = c.WqP;
          kotlin.g.b.s.s(localMap, "urlParams");
          localflp.url = c.bs(localMap);
          localflp.hAB = str2;
          localflp.scene = i;
          localflp.mpa = str3;
          localflp.sessionId = str4;
          localflp.hOG = aj.asV(i);
          localflp.title = ((String)localObject);
          paramString = iqD();
          if (paramString != null) {
            paramString.a(localflp);
          }
          paramString = iqR().toString();
          AppMethodBeat.o(315417);
          return paramString;
          localObject = ((JSONObject)localObject).optString("title");
          if (localObject != null) {
            break label403;
          }
          localObject = "";
          break;
          label348:
          paramString = (flp)paramString.fyQ();
          if (paramString == null)
          {
            paramString = "";
          }
          else
          {
            String str1 = paramString.talker;
            paramString = str1;
            if (str1 == null) {
              paramString = "";
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(315417);
      return paramString;
    }
  }
  
  @JavascriptInterface
  public final String setSearchTagResult(String paramString)
  {
    AppMethodBeat.i(315405);
    Log.i(this.TAG, kotlin.g.b.s.X("setSearchTagResult ", paramString));
    if (paramString != null)
    {
      Object localObject1 = iqD();
      d locald;
      if (localObject1 != null)
      {
        locald = ((b)localObject1).iqF();
        if (locald != null) {
          kotlin.g.b.s.u(paramString, "paramsStr");
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = locald.WqB;
          if (localObject1 != null)
          {
            h.aZW().a((p)localObject1);
            locald.WqB = null;
          }
          paramString = new JSONObject(paramString);
          crx localcrx = new crx();
          localcrx.IJG = paramString.optInt("scene", 0);
          localcrx.SessionId = paramString.optString("sessionId", "");
          localcrx.aaye = paramString.optString("requestId", "");
          localcrx.aayf = paramString.optString("searchId", "");
          localcrx.YWK = paramString.optString("query", "");
          localcrx.nUB = paramString.optString("content", "");
          localcrx.aayc = paramString.optInt("h5Version", 0);
          localObject1 = new r(localcrx, locald.ipD());
          h.aZW().a((p)localObject1, 0);
          Object localObject2 = ah.aiuX;
          locald.WqB = ((r)localObject1);
          localObject2 = paramString.optJSONObject("screenshot");
          paramString = locald.iqE();
          if (paramString != null) {
            continue;
          }
          paramString = null;
          if ((localObject2 != null) && (paramString != null))
          {
            localObject1 = locald.iqE();
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
            int i = com.tencent.mm.cd.a.fromDPToPix((Context)localObject1, ((JSONObject)localObject2).optInt("x", 0));
            localObject1 = locald.iqE();
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
            int j = com.tencent.mm.cd.a.fromDPToPix((Context)localObject1, ((JSONObject)localObject2).optInt("y", 0));
            localObject1 = locald.iqE();
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
            int k = com.tencent.mm.cd.a.fromDPToPix((Context)localObject1, ((JSONObject)localObject2).optInt("w", 0));
            localObject1 = locald.iqE();
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
            int m = com.tencent.mm.cd.a.fromDPToPix((Context)localObject1, ((JSONObject)localObject2).optInt("h", 0));
            paramString = BitmapUtil.cropBitmap(paramString.getBitmap(), i, j, k, m, true);
            localObject1 = locald.WqB;
            if (localObject1 != null) {
              ((r)localObject1).WnX = paramString;
            }
          }
          paramString = locald.iqE();
          if (paramString != null)
          {
            localObject1 = localcrx.aaye;
            kotlin.g.b.s.s(localObject1, "request.RequestId");
            paramString.biF((String)localObject1);
          }
        }
        catch (Exception paramString)
        {
          continue;
        }
        paramString = iqR().toString();
        AppMethodBeat.o(315405);
        return paramString;
        paramString = paramString.getWebView();
        continue;
        localObject1 = ((b)localObject1).getActivityContext();
        continue;
        localObject1 = ((b)localObject1).getActivityContext();
        continue;
        localObject1 = ((b)localObject1).getActivityContext();
        continue;
        localObject1 = ((b)localObject1).getActivityContext();
      }
    }
    paramString = fqu().toString();
    AppMethodBeat.o(315405);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a
 * JD-Core Version:    0.7.0.1
 */