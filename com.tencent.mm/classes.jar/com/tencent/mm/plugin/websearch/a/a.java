package com.tencent.mm.plugin.websearch.a;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.plugin.websearch.webview.o;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/emojisearch/EmojiSearchJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryJSApi;", "Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/emojisearch/ui/IEmojiSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/emojisearch/ui/IEmojiSearchUIComponent;)V", "enterEmojiStore", "", "params", "getUIComponent", "openSearchWebView", "setSearchTagResult", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends o<amr>
{
  public a(com.tencent.mm.plugin.websearch.a.a.d paramd)
  {
    super((e)paramd);
    AppMethodBeat.i(315040);
    AppMethodBeat.o(315040);
  }
  
  private final com.tencent.mm.plugin.websearch.a.a.d iqy()
  {
    com.tencent.mm.plugin.websearch.webview.c localc = this.WrO;
    if ((localc instanceof com.tencent.mm.plugin.websearch.a.a.d)) {
      return (com.tencent.mm.plugin.websearch.a.a.d)localc;
    }
    return null;
  }
  
  @JavascriptInterface
  public final String enterEmojiStore(String paramString)
  {
    AppMethodBeat.i(315076);
    try
    {
      paramString = new JSONObject(paramString).optString("talker");
      Intent localIntent = new Intent();
      localIntent.putExtra("preceding_scence", 13);
      localIntent.putExtra("download_entrance_scene", 17);
      localIntent.putExtra("check_clickflag", false);
      if (!Util.isNullOrNil(paramString)) {
        localIntent.putExtra("to_talker_name", paramString);
      }
      paramString = iqy();
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.getActivityContext())
      {
        com.tencent.mm.br.c.b(paramString, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
        paramString = iqR().toString();
        kotlin.g.b.s.s(paramString, "returnSuccess().toString()");
        AppMethodBeat.o(315076);
        return paramString;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      kotlin.g.b.s.s(paramString, "returnFail().toString()");
      AppMethodBeat.o(315076);
    }
  }
  
  @JavascriptInterface
  public final String openSearchWebView(String paramString)
  {
    AppMethodBeat.i(315069);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", kotlin.g.b.s.X("openSearchWebView ", paramString));
    try
    {
      Object localObject = new JSONObject(paramString);
      String str1 = ((JSONObject)localObject).optString("query");
      int i = ((JSONObject)localObject).optInt("scene", 0);
      int j = ((JSONObject)localObject).optInt("type", 0);
      int k = ((JSONObject)localObject).optInt("subType", 0);
      String str2 = ((JSONObject)localObject).optString("searchId", "");
      String str3 = ((JSONObject)localObject).optString("sessionId", "");
      int m = ((JSONObject)localObject).optInt("actionType", 0);
      paramString = ((JSONObject)localObject).optString("extParams", "");
      localObject = ((JSONObject)localObject).optJSONObject("nativeConfig");
      if (localObject != null) {
        ((JSONObject)localObject).optString("title");
      }
      Map localMap;
      amr localamr;
      if (m == 3)
      {
        localMap = aj.a(i, false, j, paramString);
        localMap.put("query", str1);
        localMap.put("searchId", str2);
        localMap.put("subType", String.valueOf(k));
        localMap.put("sessionId", str3);
        localMap.put("subSessionId", aj.asV(i));
        localamr = new amr();
        paramString = iqy();
        if (paramString != null) {
          break label322;
        }
        paramString = "";
      }
      for (;;)
      {
        localamr.talker = paramString;
        paramString = c.WqA;
        kotlin.g.b.s.s(localMap, "urlParams");
        localamr.url = c.bq(localMap);
        localamr.hAB = str1;
        localamr.scene = i;
        localamr.mpa = str2;
        localamr.sessionId = str3;
        localamr.hOG = aj.asV(i);
        paramString = iqy();
        if (paramString != null) {
          paramString.a(localamr);
        }
        paramString = iqR().toString();
        AppMethodBeat.o(315069);
        return paramString;
        label322:
        paramString = (amr)paramString.fyQ();
        if (paramString == null)
        {
          paramString = "";
        }
        else
        {
          localObject = paramString.talker;
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = "";
          }
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(315069);
    }
  }
  
  @JavascriptInterface
  public final String setSearchTagResult(String paramString)
  {
    AppMethodBeat.i(315056);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", kotlin.g.b.s.X("setSearchTagResult ", paramString));
    Object localObject1;
    if (paramString != null)
    {
      localObject1 = iqy();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.websearch.a.a.d)localObject1).iqB();
        if (localObject1 != null) {
          kotlin.g.b.s.u(paramString, "paramsStr");
        }
      }
    }
    try
    {
      Object localObject2 = ((d)localObject1).WqB;
      if (localObject2 != null)
      {
        h.aZW().a((p)localObject2);
        ((d)localObject1).WqB = null;
      }
      localObject2 = new JSONObject(paramString);
      paramString = new crx();
      paramString.IJG = ((JSONObject)localObject2).optInt("scene", 0);
      paramString.SessionId = ((JSONObject)localObject2).optString("sessionId", "");
      paramString.aaye = ((JSONObject)localObject2).optString("requestId", "");
      paramString.aayf = ((JSONObject)localObject2).optString("searchId", "");
      paramString.YWK = ((JSONObject)localObject2).optString("query", "");
      paramString.nUB = ((JSONObject)localObject2).optString("content", "");
      paramString.aayc = ((JSONObject)localObject2).optInt("h5Version", 0);
      localObject2 = new r(paramString, ((d)localObject1).ipD());
      h.aZW().a((p)localObject2, 0);
      ah localah = ah.aiuX;
      ((d)localObject1).WqB = ((r)localObject2);
      localObject1 = ((d)localObject1).iqz();
      paramString = paramString.aaye;
      kotlin.g.b.s.s(paramString, "request.RequestId");
      ((com.tencent.mm.plugin.websearch.a.a.d)localObject1).biF(paramString);
    }
    catch (Exception paramString)
    {
      label233:
      break label233;
    }
    paramString = iqR().toString();
    AppMethodBeat.o(315056);
    return paramString;
    paramString = fqu().toString();
    AppMethodBeat.o(315056);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a
 * JD-Core Version:    0.7.0.1
 */