package com.tencent.mm.plugin.websearch.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.websearch.a.a.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.webview.c;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;)V", "TAG", "", "netSceneGetSearchShare", "Lcom/tencent/mm/plugin/websearch/api/NetSceneGetSearchShare;", "cancelSearchShare", "", "destroy", "getRequestModel", "Lcom/tencent/mm/plugin/websearch/api/NetSceneRequestModel;", "params", "", "", "getSearchData", "paramsStr", "getSearchShare", "getSuggestData", "getTagSearchUIComponent", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "ui-websearch_release"})
public final class d
  extends com.tencent.mm.plugin.websearch.webview.g<egj>
{
  com.tencent.mm.plugin.websearch.api.q IGc;
  private final String TAG;
  
  public d(b paramb)
  {
    super((c)paramb);
    AppMethodBeat.i(197955);
    this.TAG = "MicroMsg.WebSearch.TagSearchWebData";
    com.tencent.mm.kernel.g.azz().a(719, (i)this);
    com.tencent.mm.kernel.g.azz().a(1161, (i)this);
    com.tencent.mm.kernel.g.azz().a(4614, (i)this);
    com.tencent.mm.kernel.g.azz().a(4858, (i)this);
    AppMethodBeat.o(197955);
  }
  
  final v bh(Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(197954);
    int i = ai.b(paramMap, "scene", 0);
    v localv = new v();
    localv.dDv = ai.N(paramMap, "query");
    localv.offset = ai.b(paramMap, "offset", 0);
    localv.businessType = ai.b(paramMap, "type", 0);
    localv.scene = i;
    localv.IDG = ai.N(paramMap, "sugId");
    localv.IDI = ai.b(paramMap, "sugType", 0);
    localv.IDH = ai.N(paramMap, "prefixSug");
    localv.IDT = ai.N(paramMap, "poiInfo");
    if (ai.O(paramMap, "isHomePage")) {
      i = 1;
    }
    int j;
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      localv.IDE = i;
      localv.rjq = ai.N(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localv.sessionId = ai.N(paramMap, "sessionId");
      }
      localv.dVS = ai.b(paramMap, "sceneActionType", 1);
      localv.IDK = ai.b(paramMap, "displayPattern", 2);
      localv.IDL = ai.b(paramMap, "sugPosition", 0);
      localv.IDM = ai.N(paramMap, "sugBuffer");
      localv.dPI = ai.N(paramMap, "requestId");
      localv.sessionId = ai.N(paramMap, "sessionId");
      localv.dVO = ai.N(paramMap, "subSessionId");
      localv.IDU = ai.N(paramMap, "tagId");
      localv.dVL = fXz();
      Object localObject1 = ai.N(paramMap, "extReqParams");
      if (!Util.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          j = ((JSONArray)localObject1).length();
          i = 0;
          while (i < j)
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new aca();
            ((aca)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((aca)localObject5).LmC = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((aca)localObject5).LmD = ((JSONObject)localObject4).optString("textValue", "");
            localv.IDO.add(localObject5);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = ai.N(paramMap, "matchUser");
    if (!Util.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new eou();
      ((eou)localObject4).UserName = ((JSONObject)localObject2).optString("userName");
      ((eou)localObject4).NmU = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty((CharSequence)((eou)localObject4).UserName)) {
        localv.IDF.add(localObject4);
      }
      localObject2 = ai.N(paramMap, "prefixQuery");
      if (Util.isNullOrNil((String)localObject2)) {}
    }
    catch (Exception localException2)
    {
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        j = ((JSONArray)localObject2).length();
        i = 0;
        while (i < j)
        {
          localObject4 = ((JSONArray)localObject2).getString(i);
          localv.IDJ.add(localObject4);
          i += 1;
          continue;
          localException2 = localException2;
          Log.printErrStackTrace(this.TAG, (Throwable)localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException3, "prefixQueryJSONArray", new Object[0]);
      }
      Object localObject3 = ai.N(paramMap, "tagInfo");
      if (!Util.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        localv.IDN = new egk();
        localv.IDN.Ngs = ((JSONObject)localObject3).optString("tagText");
        localv.IDN.Ngr = ((JSONObject)localObject3).optInt("tagType");
        localv.IDN.Ngt = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = ai.N(paramMap, "numConditions");
        if (Util.isNullOrNil((String)localObject3)) {}
      }
      catch (Exception localException4)
      {
        try
        {
          localObject3 = new JSONArray((String)localObject3);
          j = ((JSONArray)localObject3).length();
          i = 0;
          while (i < j)
          {
            localObject4 = ((JSONArray)localObject3).optJSONObject(i);
            localObject5 = new ctz();
            ((ctz)localObject5).Mzn = ((JSONObject)localObject4).optLong("from");
            ((ctz)localObject5).Mzo = ((JSONObject)localObject4).optLong("to");
            ((ctz)localObject5).Mzm = ((JSONObject)localObject4).optInt("field");
            localv.IDP.add(localObject5);
            i += 1;
            continue;
            localException4 = localException4;
            Log.printErrStackTrace(this.TAG, (Throwable)localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)localException5, "numConditionsArray", new Object[0]);
        }
        localv.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        localv.wVW = ai.b(paramMap, "subType", 0);
        paramMap = ai.N(paramMap, "specialSearch");
        if (Util.isNullOrNil(paramMap)) {}
      }
    }
    try
    {
      paramMap = new JSONObject(paramMap);
      localv.IDX = paramMap.optInt("type", 0);
      localv.dDL = paramMap.optJSONObject("params").optString("reqKey");
      label927:
      AppMethodBeat.o(197954);
      return localv;
    }
    catch (Exception paramMap)
    {
      break label927;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(197953);
    super.destroy();
    com.tencent.mm.kernel.g.azz().b(719, (i)this);
    com.tencent.mm.kernel.g.azz().b(1161, (i)this);
    com.tencent.mm.kernel.g.azz().b(4614, (i)this);
    com.tencent.mm.kernel.g.azz().b(4858, (i)this);
    AppMethodBeat.o(197953);
  }
  
  public final b fYE()
  {
    com.tencent.mm.plugin.websearch.webview.d locald2 = this.IHe;
    com.tencent.mm.plugin.websearch.webview.d locald1 = locald2;
    if (!(locald2 instanceof b)) {
      locald1 = null;
    }
    return (b)locald1;
  }
  
  public final void fYF()
  {
    AppMethodBeat.i(197951);
    com.tencent.mm.plugin.websearch.api.q localq = this.IGc;
    if (localq != null)
    {
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localq);
      this.IGc = null;
      AppMethodBeat.o(197951);
      return;
    }
    AppMethodBeat.o(197951);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    Object localObject1 = null;
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(197952);
    Log.i(this.TAG, "onSceneEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof com.tencent.mm.plugin.websearch.api.x))
    {
      if (((com.tencent.mm.plugin.websearch.api.x)paramq).fXN().dVL == fXz())
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          fav localfav = ((com.tencent.mm.plugin.websearch.api.x)paramq).fXM();
          if (localfav != null)
          {
            Object localObject2 = fYE();
            paramString = (String)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((b)localObject2).fYH();
              paramString = (String)localObject1;
              if (localObject2 != null)
              {
                if (((com.tencent.mm.plugin.websearch.api.x)paramq).fXN().offset != 0) {
                  break label280;
                }
                bool1 = true;
                paramString = localfav.MaZ;
                p.g(paramString, "it.Json");
                localObject1 = ((com.tencent.mm.plugin.websearch.api.x)paramq).fXN().dPI;
                p.g(localObject1, "scene.model.requestId");
                ((a)localObject2).e(bool1, paramString, (String)localObject1);
                paramString = kotlin.x.SXb;
              }
            }
            if (paramString != null) {}
          }
          else
          {
            paramString = ((d)this).fYE();
            if (paramString != null)
            {
              paramString = paramString.fYH();
              if (paramString != null) {
                if (((com.tencent.mm.plugin.websearch.api.x)paramq).fXN().offset != 0) {
                  break label286;
                }
              }
            }
          }
          label280:
          label286:
          for (bool1 = bool2;; bool1 = false)
          {
            paramq = ((com.tencent.mm.plugin.websearch.api.x)paramq).fXN().dPI;
            p.g(paramq, "scene.model.requestId");
            paramString.e(bool1, "{\"ret\":-1}", paramq);
            paramString = kotlin.x.SXb;
            AppMethodBeat.o(197952);
            return;
            bool1 = false;
            break;
          }
        }
        paramString = fYE();
        if (paramString != null)
        {
          paramString = paramString.fYH();
          if (paramString != null)
          {
            if (((com.tencent.mm.plugin.websearch.api.x)paramq).fXN().offset == 0) {}
            for (;;)
            {
              paramq = ((com.tencent.mm.plugin.websearch.api.x)paramq).fXN().dPI;
              p.g(paramq, "scene.model.requestId");
              paramString.e(bool1, "{\"ret\":-1}", paramq);
              AppMethodBeat.o(197952);
              return;
              bool1 = false;
            }
          }
        }
        AppMethodBeat.o(197952);
      }
    }
    else if ((paramq instanceof s))
    {
      if (((s)paramq).fXN().dVL == fXz())
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((s)paramq).fXM();
          if (paramString != null)
          {
            paramq = fYE();
            if (paramq == null) {
              break label517;
            }
            paramq = paramq.fYH();
            if (paramq == null) {
              break label517;
            }
            paramString = paramString.MaZ;
            p.g(paramString, "it.Json");
            paramq.aXm(paramString);
          }
          label517:
          for (paramString = kotlin.x.SXb;; paramString = null)
          {
            if (paramString == null)
            {
              paramString = ((d)this).fYE();
              if (paramString != null)
              {
                paramString = paramString.fYH();
                if (paramString != null)
                {
                  paramString.aXm("{\"ret\":-1}");
                  paramString = kotlin.x.SXb;
                }
              }
            }
            AppMethodBeat.o(197952);
            return;
          }
        }
        paramString = fYE();
        if (paramString != null)
        {
          paramString = paramString.fYH();
          if (paramString != null)
          {
            paramString.aXm("{\"ret\":-1}");
            AppMethodBeat.o(197952);
            return;
          }
        }
        AppMethodBeat.o(197952);
      }
    }
    else if (((paramq instanceof com.tencent.mm.plugin.websearch.api.q)) && (((com.tencent.mm.plugin.websearch.api.q)paramq).fXz() == fXz()) && (p.j(paramq, this.IGc)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.websearch.api.q)paramq).fXK();
        if (paramString != null)
        {
          localObject1 = fYE();
          if (localObject1 != null) {
            ((b)localObject1).a(paramString, ((com.tencent.mm.plugin.websearch.api.q)paramq).getCropBitmap(), ((com.tencent.mm.plugin.websearch.api.q)paramq).fXL().KXA);
          }
        }
      }
      this.IGc = null;
    }
    AppMethodBeat.o(197952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.d
 * JD-Core Version:    0.7.0.1
 */