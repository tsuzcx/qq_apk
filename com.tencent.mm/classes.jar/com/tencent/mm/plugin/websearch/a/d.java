package com.tencent.mm.plugin.websearch.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.a.a.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.webview.c;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.eql;
import com.tencent.mm.protocal.protobuf.eqm;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.protocal.protobuf.flo;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;)V", "TAG", "", "netSceneGetSearchShare", "Lcom/tencent/mm/plugin/websearch/api/NetSceneGetSearchShare;", "cancelSearchShare", "", "destroy", "getRequestModel", "Lcom/tencent/mm/plugin/websearch/api/NetSceneRequestModel;", "params", "", "", "getSearchData", "paramsStr", "getSearchShare", "getSuggestData", "getTagSearchUIComponent", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "ui-websearch_release"})
public final class d
  extends g<eql>
{
  com.tencent.mm.plugin.websearch.api.q PAt;
  private final String TAG;
  
  public d(b paramb)
  {
    super((c)paramb);
    AppMethodBeat.i(198624);
    this.TAG = "MicroMsg.WebSearch.TagSearchWebData";
    h.aGY().a(719, (i)this);
    h.aGY().a(1161, (i)this);
    h.aGY().a(4614, (i)this);
    h.aGY().a(4858, (i)this);
    AppMethodBeat.o(198624);
  }
  
  final v bb(Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(198621);
    int i = ai.b(paramMap, "scene", 0);
    v localv = new v();
    localv.fwe = ai.aa(paramMap, "query");
    localv.offset = ai.b(paramMap, "offset", 0);
    localv.businessType = ai.b(paramMap, "type", 0);
    localv.scene = i;
    localv.PxW = ai.aa(paramMap, "sugId");
    localv.PxY = ai.b(paramMap, "sugType", 0);
    localv.PxX = ai.aa(paramMap, "prefixSug");
    localv.Pyj = ai.aa(paramMap, "poiInfo");
    if (ai.ab(paramMap, "isHomePage")) {
      i = 1;
    }
    int j;
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      localv.PxU = i;
      localv.uMC = ai.aa(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localv.sessionId = ai.aa(paramMap, "sessionId");
      }
      localv.fPw = ai.b(paramMap, "sceneActionType", 1);
      localv.Pya = ai.b(paramMap, "displayPattern", 2);
      localv.Pyb = ai.b(paramMap, "sugPosition", 0);
      localv.Pyc = ai.aa(paramMap, "sugBuffer");
      localv.fIY = ai.aa(paramMap, "requestId");
      localv.sessionId = ai.aa(paramMap, "sessionId");
      localv.fPs = ai.aa(paramMap, "subSessionId");
      localv.Pyk = ai.aa(paramMap, "tagId");
      localv.fPp = gQm();
      Object localObject1 = ai.aa(paramMap, "extReqParams");
      if (!Util.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          j = ((JSONArray)localObject1).length();
          i = 0;
          while (i < j)
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new aci();
            ((aci)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((aci)localObject5).SnV = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((aci)localObject5).SnW = ((JSONObject)localObject4).optString("textValue", "");
            localv.Pye.add(localObject5);
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
    Object localObject2 = ai.aa(paramMap, "matchUser");
    if (!Util.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new ezc();
      ((ezc)localObject4).UserName = ((JSONObject)localObject2).optString("userName");
      ((ezc)localObject4).UzH = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty((CharSequence)((ezc)localObject4).UserName)) {
        localv.PxV.add(localObject4);
      }
      localObject2 = ai.aa(paramMap, "prefixQuery");
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
          localv.PxZ.add(localObject4);
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
      Object localObject3 = ai.aa(paramMap, "tagInfo");
      if (!Util.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        localv.Pyd = new eqm();
        localv.Pyd.UsW = ((JSONObject)localObject3).optString("tagText");
        localv.Pyd.UsV = ((JSONObject)localObject3).optInt("tagType");
        localv.Pyd.UsX = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = ai.aa(paramMap, "numConditions");
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
            localObject5 = new ddb();
            ((ddb)localObject5).TKT = ((JSONObject)localObject4).optLong("from");
            ((ddb)localObject5).TKU = ((JSONObject)localObject4).optLong("to");
            ((ddb)localObject5).TKS = ((JSONObject)localObject4).optInt("field");
            localv.Pyf.add(localObject5);
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
        localv.BHR = ai.b(paramMap, "subType", 0);
        paramMap = ai.aa(paramMap, "specialSearch");
        if (Util.isNullOrNil(paramMap)) {}
      }
    }
    try
    {
      paramMap = new JSONObject(paramMap);
      localv.Pyn = paramMap.optInt("type", 0);
      localv.fwv = paramMap.optJSONObject("params").optString("reqKey");
      label927:
      AppMethodBeat.o(198621);
      return localv;
    }
    catch (Exception paramMap)
    {
      break label927;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(198598);
    super.destroy();
    h.aGY().b(719, (i)this);
    h.aGY().b(1161, (i)this);
    h.aGY().b(4614, (i)this);
    h.aGY().b(4858, (i)this);
    AppMethodBeat.o(198598);
  }
  
  public final b gRp()
  {
    com.tencent.mm.plugin.websearch.webview.d locald2 = this.PBs;
    com.tencent.mm.plugin.websearch.webview.d locald1 = locald2;
    if (!(locald2 instanceof b)) {
      locald1 = null;
    }
    return (b)locald1;
  }
  
  public final void gRq()
  {
    AppMethodBeat.i(198590);
    com.tencent.mm.plugin.websearch.api.q localq = this.PAt;
    if (localq != null)
    {
      h.aGY().a((com.tencent.mm.an.q)localq);
      this.PAt = null;
      AppMethodBeat.o(198590);
      return;
    }
    AppMethodBeat.o(198590);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    Object localObject1 = null;
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(198597);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    Log.i(this.TAG, "onSceneEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof com.tencent.mm.plugin.websearch.api.x))
    {
      if (((com.tencent.mm.plugin.websearch.api.x)paramq).gQy().fPp == gQm())
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          flo localflo = ((com.tencent.mm.plugin.websearch.api.x)paramq).gQx();
          if (localflo != null)
          {
            Object localObject2 = gRp();
            paramString = (String)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((b)localObject2).gRs();
              paramString = (String)localObject1;
              if (localObject2 != null)
              {
                if (((com.tencent.mm.plugin.websearch.api.x)paramq).gQy().offset != 0) {
                  break label289;
                }
                bool1 = true;
                paramString = localflo.Tkw;
                p.j(paramString, "it.Json");
                localObject1 = ((com.tencent.mm.plugin.websearch.api.x)paramq).gQy().fIY;
                p.j(localObject1, "scene.model.requestId");
                ((a)localObject2).i(bool1, paramString, (String)localObject1);
                paramString = kotlin.x.aazN;
              }
            }
            if (paramString != null) {}
          }
          else
          {
            paramString = ((d)this).gRp();
            if (paramString != null)
            {
              paramString = paramString.gRs();
              if (paramString != null) {
                if (((com.tencent.mm.plugin.websearch.api.x)paramq).gQy().offset != 0) {
                  break label295;
                }
              }
            }
          }
          label289:
          label295:
          for (bool1 = bool2;; bool1 = false)
          {
            paramq = ((com.tencent.mm.plugin.websearch.api.x)paramq).gQy().fIY;
            p.j(paramq, "scene.model.requestId");
            paramString.i(bool1, "{\"ret\":-1}", paramq);
            paramString = kotlin.x.aazN;
            AppMethodBeat.o(198597);
            return;
            bool1 = false;
            break;
          }
        }
        paramString = gRp();
        if (paramString != null)
        {
          paramString = paramString.gRs();
          if (paramString != null)
          {
            if (((com.tencent.mm.plugin.websearch.api.x)paramq).gQy().offset == 0) {}
            for (;;)
            {
              paramq = ((com.tencent.mm.plugin.websearch.api.x)paramq).gQy().fIY;
              p.j(paramq, "scene.model.requestId");
              paramString.i(bool1, "{\"ret\":-1}", paramq);
              AppMethodBeat.o(198597);
              return;
              bool1 = false;
            }
          }
        }
        AppMethodBeat.o(198597);
      }
    }
    else if ((paramq instanceof s))
    {
      if (((s)paramq).gQy().fPp == gQm())
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((s)paramq).gQx();
          if (paramString != null)
          {
            paramq = gRp();
            if (paramq == null) {
              break label526;
            }
            paramq = paramq.gRs();
            if (paramq == null) {
              break label526;
            }
            paramString = paramString.Tkw;
            p.j(paramString, "it.Json");
            paramq.biX(paramString);
          }
          label526:
          for (paramString = kotlin.x.aazN;; paramString = null)
          {
            if (paramString == null)
            {
              paramString = ((d)this).gRp();
              if (paramString != null)
              {
                paramString = paramString.gRs();
                if (paramString != null)
                {
                  paramString.biX("{\"ret\":-1}");
                  paramString = kotlin.x.aazN;
                }
              }
            }
            AppMethodBeat.o(198597);
            return;
          }
        }
        paramString = gRp();
        if (paramString != null)
        {
          paramString = paramString.gRs();
          if (paramString != null)
          {
            paramString.biX("{\"ret\":-1}");
            AppMethodBeat.o(198597);
            return;
          }
        }
        AppMethodBeat.o(198597);
      }
    }
    else if (((paramq instanceof com.tencent.mm.plugin.websearch.api.q)) && (((com.tencent.mm.plugin.websearch.api.q)paramq).gQm() == gQm()) && (p.h(paramq, this.PAt)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.websearch.api.q)paramq).gQv();
        if (paramString != null)
        {
          localObject1 = gRp();
          if (localObject1 != null) {
            ((b)localObject1).a(paramString, ((com.tencent.mm.plugin.websearch.api.q)paramq).getCropBitmap(), ((com.tencent.mm.plugin.websearch.api.q)paramq).gQw().RYJ);
          }
        }
      }
      this.PAt = null;
    }
    AppMethodBeat.o(198597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.d
 * JD-Core Version:    0.7.0.1
 */