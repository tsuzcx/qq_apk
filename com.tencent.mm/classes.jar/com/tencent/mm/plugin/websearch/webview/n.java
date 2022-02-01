package com.tencent.mm.plugin.websearch.webview;

import android.text.TextUtils;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.t;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.protocal.protobuf.flq;
import com.tencent.mm.protocal.protobuf.fvd;
import com.tencent.mm.protocal.protobuf.gid;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryData;", "T", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchQueryUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchQueryUIComponent;)V", "destroy", "", "getMMWebSearchData", "paramStr", "", "getQueryUIComponent", "getRequestModel", "Lcom/tencent/mm/plugin/websearch/api/NetSceneRequestModel;", "params", "", "", "getSearchData", "paramsStr", "getSuggestData", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class n<T>
  extends k<T>
{
  public static final a Wsa = new a((byte)0);
  
  public n(e<T> parame)
  {
    super((d)parame);
    com.tencent.mm.kernel.h.aZW().a(719, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(1161, (com.tencent.mm.am.h)this);
  }
  
  private e<T> iqT()
  {
    f localf = this.WrK;
    if (localf == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.websearch.webview.IWebSearchQueryUIComponent<T of com.tencent.mm.plugin.websearch.webview.WebSearchQueryData>");
    }
    return (e)localf;
  }
  
  public void aEN(String paramString)
  {
    kotlin.g.b.s.u(paramString, "paramsStr");
  }
  
  public final void biM(String paramString)
  {
    kotlin.g.b.s.u(paramString, "paramStr");
    paramString = new JSONObject(paramString);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramString.keys();
    kotlin.g.b.s.s(localIterator, "requestObj.keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Map localMap = (Map)localHashMap;
      kotlin.g.b.s.s(str, "it");
      localMap.put(str, paramString.opt(str));
    }
    paramString = new com.tencent.mm.plugin.websearch.api.s(bt((Map)localHashMap));
    com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
  }
  
  protected final w bt(Map<String, ? extends Object> paramMap)
  {
    kotlin.g.b.s.u(paramMap, "params");
    int i = aj.c(paramMap, "scene", 0);
    w localw = new w();
    localw.hAB = aj.au(paramMap, "query");
    localw.offset = aj.c(paramMap, "offset", 0);
    localw.businessType = aj.c(paramMap, "type", 0);
    localw.scene = i;
    localw.Wod = aj.au(paramMap, "sugId");
    localw.Wof = aj.c(paramMap, "sugType", 0);
    localw.Woe = aj.au(paramMap, "prefixSug");
    localw.Woq = aj.au(paramMap, "poiInfo");
    Object localObject1;
    if (aj.av(paramMap, "isHomePage"))
    {
      i = 1;
      localw.Wob = i;
      localw.xVe = aj.au(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localw.sessionId = aj.au(paramMap, "sessionId");
      }
      localw.hVr = aj.c(paramMap, "sceneActionType", 1);
      localw.Woh = aj.c(paramMap, "displayPattern", 2);
      localw.Woi = aj.c(paramMap, "sugPosition", 0);
      localw.Woj = aj.au(paramMap, "sugBuffer");
      localw.hOG = aj.au(paramMap, "requestId");
      localw.sessionId = aj.au(paramMap, "sessionId");
      localw.hVn = aj.au(paramMap, "subSessionId");
      localw.Wor = aj.au(paramMap, "tagId");
      localw.hVk = ipD();
      localObject1 = aj.au(paramMap, "extReqParams");
      if (Util.isNullOrNil((String)localObject1)) {}
    }
    for (;;)
    {
      int j;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        k = ((JSONArray)localObject1).length();
        if (k > 0)
        {
          i = 0;
          j = i + 1;
          localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          localObject3 = new aem();
          ((aem)localObject3).key = ((JSONObject)localObject2).optString("key", "");
          ((aem)localObject3).Zmx = ((JSONObject)localObject2).optInt("uintValue", 0);
          ((aem)localObject3).Zmy = ((JSONObject)localObject2).optString("textValue", "");
          localw.Wol.add(localObject3);
          if (j < k) {
            break label969;
          }
        }
        localObject1 = aj.au(paramMap, "matchUser");
        if (Util.isNullOrNil((String)localObject1)) {}
      }
      catch (Exception localException3)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          localObject2 = new fvd();
          ((fvd)localObject2).UserName = ((JSONObject)localObject1).optString("userName");
          ((fvd)localObject2).abTC = ((JSONObject)localObject1).optString("matchWord");
          if (!TextUtils.isEmpty((CharSequence)((fvd)localObject2).UserName)) {
            localw.Woc.add(localObject2);
          }
          localObject1 = aj.au(paramMap, "prefixQuery");
          if (Util.isNullOrNil((String)localObject1)) {}
        }
        catch (Exception localException3)
        {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            k = ((JSONArray)localObject1).length();
            if (k > 0)
            {
              i = 0;
              j = i + 1;
              localObject2 = ((JSONArray)localObject1).getString(i);
              localw.Wog.add(localObject2);
              if (j < k) {
                break label964;
              }
            }
            localObject1 = aj.au(paramMap, "tagInfo");
            if (Util.isNullOrNil((String)localObject1)) {}
          }
          catch (Exception localException3)
          {
            try
            {
              int k;
              Object localObject2;
              Object localObject3;
              localObject1 = new JSONObject((String)localObject1);
              localw.Wok = new flq();
              localw.Wok.abMd = ((JSONObject)localObject1).optString("tagText");
              localw.Wok.abMc = ((JSONObject)localObject1).optInt("tagType");
              localw.Wok.abMe = ((JSONObject)localObject1).optString("tagExtValue");
              localObject1 = aj.au(paramMap, "numConditions");
              if (!Util.isNullOrNil((String)localObject1)) {}
              try
              {
                localObject1 = new JSONArray((String)localObject1);
                k = ((JSONArray)localObject1).length();
                if (k > 0)
                {
                  i = 0;
                  j = i + 1;
                  localObject2 = ((JSONArray)localObject1).optJSONObject(i);
                  localObject3 = new duw();
                  ((duw)localObject3).abaM = ((JSONObject)localObject2).optLong("from");
                  ((duw)localObject3).abaN = ((JSONObject)localObject2).optLong("to");
                  ((duw)localObject3).abaL = ((JSONObject)localObject2).optInt("field");
                  localw.Wom.add(localObject3);
                  if (j < k) {
                    break label959;
                  }
                }
              }
              catch (Exception localException5)
              {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchQueryData", (Throwable)localException5, "numConditionsArray", new Object[0]);
                continue;
              }
              localw.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
              localw.subtype = aj.c(paramMap, "subType", 0);
              paramMap = aj.au(paramMap, "specialSearch");
              if (!Util.isNullOrNil(paramMap)) {}
              try
              {
                paramMap = new JSONObject(paramMap);
                localw.Wou = paramMap.optInt("type", 0);
                localw.hAT = paramMap.optJSONObject("params").optString("reqKey");
                return localw;
              }
              catch (Exception paramMap)
              {
                return localw;
              }
              i = 0;
              break;
              localException1 = localException1;
              Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchQueryData", (Throwable)localException1, "commKvJSONArray", new Object[0]);
              continue;
              localException2 = localException2;
              Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchQueryData", (Throwable)localException2, "matchUserJSONArray", new Object[0]);
              continue;
              localException3 = localException3;
              Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchQueryData", (Throwable)localException3, "prefixQueryJSONArray", new Object[0]);
            }
            catch (Exception localException4)
            {
              Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchQueryData", (Throwable)localException4, "tagInfoObj", new Object[0]);
              continue;
            }
          }
        }
      }
      label959:
      i = j;
      continue;
      label964:
      i = j;
      continue;
      label969:
      i = j;
    }
  }
  
  public void destroy()
  {
    super.destroy();
    com.tencent.mm.kernel.h.aZW().b(719, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(1161, (com.tencent.mm.am.h)this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    String str = null;
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    gid localgid;
    if ((paramp instanceof com.tencent.mm.plugin.websearch.api.s)) {
      if (((com.tencent.mm.plugin.websearch.api.s)paramp).WnS.hVk == ipD())
      {
        localgid = ((com.tencent.mm.plugin.websearch.api.s)paramp).WnR;
        if (localgid == null)
        {
          paramString = str;
          if (paramString == null)
          {
            paramString = ((n)this).iqT().fyP();
            if (paramString != null)
            {
              if (((com.tencent.mm.plugin.websearch.api.s)paramp).WnS.offset != 0) {
                break label227;
              }
              bool1 = bool2;
              label101:
              paramp = ((com.tencent.mm.plugin.websearch.api.s)paramp).WnS.hOG;
              kotlin.g.b.s.s(paramp, "scene.model.requestId");
              paramString.i(bool1, "{\"ret\":-1}", paramp);
            }
          }
        }
      }
    }
    label227:
    do
    {
      for (;;)
      {
        return;
        o localo = iqT().fyP();
        paramString = str;
        if (localo == null) {
          break;
        }
        if (((com.tencent.mm.plugin.websearch.api.s)paramp).WnS.offset == 0) {}
        for (bool1 = true;; bool1 = false)
        {
          paramString = localgid.aayd;
          kotlin.g.b.s.s(paramString, "it.Json");
          str = ((com.tencent.mm.plugin.websearch.api.s)paramp).WnS.hOG;
          kotlin.g.b.s.s(str, "scene.model.requestId");
          localo.i(bool1, paramString, str);
          paramString = ah.aiuX;
          break;
        }
        bool1 = false;
        break label101;
        paramString = iqT().fyP();
        if (paramString != null)
        {
          if (((com.tencent.mm.plugin.websearch.api.s)paramp).WnS.offset == 0) {}
          for (;;)
          {
            paramp = ((com.tencent.mm.plugin.websearch.api.s)paramp).WnS.hOG;
            kotlin.g.b.s.s(paramp, "scene.model.requestId");
            paramString.i(bool1, "{\"ret\":-1}", paramp);
            return;
            bool1 = false;
          }
          if (((paramp instanceof t)) && (((t)paramp).WnS.hVk == ipD()))
          {
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
              break label427;
            }
            paramp = ((t)paramp).WnR;
            if (paramp == null) {
              paramString = null;
            }
            for (;;)
            {
              if (paramString != null) {
                break label425;
              }
              paramString = ((n)this).iqT().fyP();
              if (paramString == null) {
                break;
              }
              paramString.biN("{\"ret\":-1}");
              return;
              paramString = iqT().fyP();
              if (paramString == null)
              {
                paramString = null;
              }
              else
              {
                paramp = paramp.aayd;
                kotlin.g.b.s.s(paramp, "it.Json");
                paramString.biN(paramp);
                paramString = ah.aiuX;
              }
            }
          }
        }
      }
      paramString = iqT().fyP();
    } while (paramString == null);
    label425:
    label427:
    paramString.biN("{\"ret\":-1}");
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryData$Companion;", "", "()V", "TAG", "", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.n
 * JD-Core Version:    0.7.0.1
 */