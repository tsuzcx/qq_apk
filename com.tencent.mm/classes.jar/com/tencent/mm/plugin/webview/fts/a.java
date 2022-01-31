package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.a.gc.a;
import com.tencent.mm.g.a.gc.b;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.rt.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements k.a
{
  public c rbF;
  private volatile HashMap<String, HashSet<String>> uOp;
  volatile HashMap<String, HashSet<String>> uOq;
  volatile HashMap<String, HashSet<String>> uOr;
  private volatile HashMap<String, Integer> uOs;
  volatile HashMap<String, Integer> uOt;
  volatile HashMap<String, Integer> uOu;
  public c<gc> uOv;
  
  public a()
  {
    AppMethodBeat.i(5667);
    this.uOv = new a.1(this);
    this.rbF = new a.2(this);
    this.uOp = new HashMap();
    this.uOq = new HashMap();
    this.uOs = new HashMap();
    this.uOt = new HashMap();
    this.uOr = new HashMap();
    this.uOu = new HashMap();
    this.rbF.alive();
    this.uOv.alive();
    o.adg().add(this);
    AppMethodBeat.o(5667);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(5671);
    if ((paramm == null) || (paramm.obj == null))
    {
      AppMethodBeat.o(5671);
      return;
    }
    for (;;)
    {
      int i;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (this.uOp)
      {
        ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "event %s，eventData %s", new Object[] { paramString, paramm.toString() });
        paramString = paramm.obj.toString();
        if ((this.uOp.containsKey(paramString)) && (this.uOs.containsKey(paramString)))
        {
          ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "notify avatar changed %s", new Object[] { paramString });
          i = ((Integer)this.uOs.get(paramString)).intValue();
          Object localObject = new HashSet((HashSet)this.uOp.get(paramString));
          paramm = new JSONArray();
          localObject = ((HashSet)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            o.acQ();
            str2 = "weixin://fts/avatar?path=".concat(String.valueOf(d.E(paramString, false)));
            localJSONObject = new JSONObject();
          }
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label220:
        paramm.put(localJSONObject);
        continue;
        paramString = finally;
        AppMethodBeat.o(5671);
        throw paramString;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(i).bG(0, paramm.toString());
        this.uOp.remove(paramString);
        this.uOs.remove(paramString);
        AppMethodBeat.o(5671);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label220;
      }
    }
  }
  
  public final boolean as(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5668);
    ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchAvatarList");
    Object localObject1 = aa.t(paramMap, "data");
    int j = bo.f(paramMap.get("webview_instance_id"), -1);
    for (;;)
    {
      JSONArray localJSONArray2;
      int i;
      String str1;
      String str2;
      try
      {
        JSONArray localJSONArray1 = new JSONArray((String)localObject1);
        localJSONArray2 = new JSONArray();
        localObject1 = null;
        i = 0;
        if (i >= localJSONArray1.length()) {
          break label436;
        }
        paramMap = localJSONArray1.getJSONObject(i);
        str1 = paramMap.optString("id");
        str2 = paramMap.optString("userName");
        int k = paramMap.optInt("type");
        localObject2 = paramMap.optString("imageUrl");
        str3 = paramMap.optString("bigImageUrl");
        paramMap = (Map<String, Object>)localObject2;
        switch (k)
        {
        case 1: 
          o.acQ();
          paramMap = d.E(str2, false);
          if (!e.cN(paramMap)) {
            break;
          }
          ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file exist %s", new Object[] { paramMap });
          paramMap = "weixin://fts/avatar?path=".concat(String.valueOf(paramMap));
        case 4: 
        case 64: 
          localObject1 = paramMap;
          if (paramMap == null) {
            break label463;
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("id", str1);
          ((JSONObject)localObject1).put("src", paramMap);
          localJSONArray2.put(localObject1);
          localObject1 = null;
        }
      }
      catch (JSONException paramMap)
      {
        String str3;
        ab.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewImageLogic", paramMap, "", new Object[0]);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(j).bG(-1, "");
        AppMethodBeat.o(5668);
        return false;
      }
      paramMap = new com.tencent.mm.ah.h();
      paramMap.username = str2;
      paramMap.fsl = str3;
      paramMap.fsk = ((String)localObject2);
      paramMap.bsY = -1;
      paramMap.dqB = 3;
      paramMap.cM(true);
      o.adg().b(paramMap);
      continue;
      ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file not exist %s", new Object[] { paramMap });
      this.uOs.put(str2, Integer.valueOf(j));
      Object localObject2 = (HashSet)this.uOp.get(str2);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject2 == null) {
        paramMap = new HashSet();
      }
      paramMap.add(str1);
      this.uOp.put(str2, paramMap);
      a.b.dmT().dt(str2);
      paramMap = (Map<String, Object>)localObject1;
      continue;
      label436:
      if (localJSONArray2.length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(j).bG(0, localJSONArray2.toString());
        continue;
        continue;
        label463:
        i += 1;
      }
    }
  }
  
  public final boolean at(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5669);
    ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchSnsImageList");
    Object localObject1 = aa.t(paramMap, "data");
    int j = bo.f(paramMap.get("webview_instance_id"), -1);
    for (;;)
    {
      JSONArray localJSONArray2;
      int i;
      try
      {
        JSONArray localJSONArray1 = new JSONArray((String)localObject1);
        localJSONArray2 = new JSONArray();
        paramMap = null;
        i = 0;
        if (i < localJSONArray1.length())
        {
          localObject1 = localJSONArray1.getJSONObject(i);
          String str = ((JSONObject)localObject1).getString("id");
          Object localObject2 = ((JSONObject)localObject1).getString("objectXmlDesc");
          int k = ((JSONObject)localObject1).getInt("index");
          localObject1 = ((com.tencent.mm.plugin.sns.b.m)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sns.b.m.class)).uA((String)localObject2);
          if (((TimeLineObject)localObject1).xTS.wOa.size() <= k) {
            break label490;
          }
          localObject2 = (bcs)((TimeLineObject)localObject1).xTS.wOa.get(k);
          localObject1 = new rt();
          ((rt)localObject1).cIb.coO = 3;
          ((rt)localObject1).cIb.cBO = ((bcs)localObject2).Id;
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
          ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "generatePath: %s", new Object[] { ((rt)localObject1).cIb.path });
          if (e.cN(((rt)localObject1).cIb.path))
          {
            localObject1 = "weixin://fts/sns?path=" + ((rt)localObject1).cIb.path;
            paramMap = (Map<String, Object>)localObject1;
            if (localObject1 == null) {
              break label490;
            }
            paramMap = new JSONObject();
            paramMap.put("id", str);
            paramMap.put("src", localObject1);
            localJSONArray2.put(paramMap);
            paramMap = null;
            break label490;
          }
          synchronized (this.uOq)
          {
            if (this.uOq.containsKey(((bcs)localObject2).Id))
            {
              localObject1 = (HashSet)this.uOq.get(((bcs)localObject2).Id);
              ((HashSet)localObject1).add(str);
              this.uOq.put(((bcs)localObject2).Id, localObject1);
              this.uOt.put(((bcs)localObject2).Id, Integer.valueOf(j));
              localObject1 = new rt();
              ((rt)localObject1).cIb.coO = 1;
              ((rt)localObject1).cIb.cIc = ((bcs)localObject2);
              com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
              localObject1 = paramMap;
              continue;
            }
            localObject1 = new HashSet();
          }
        }
        if (localJSONArray2.length() <= 0) {
          continue;
        }
      }
      catch (JSONException paramMap)
      {
        AppMethodBeat.o(5669);
        return false;
      }
      com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(j).bG(0, localJSONArray2.toString());
      continue;
      label490:
      i += 1;
    }
  }
  
  public final boolean au(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5670);
    ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchImageList");
    i = aa.d(paramMap, "requestType", 0);
    Object localObject1 = aa.t(paramMap, "data");
    int j = bo.f(paramMap.get("webview_instance_id"), -1);
    boolean bool = at.isWifi(ah.getContext());
    switch (i)
    {
    }
    for (;;)
    {
      try
      {
        paramMap = new JSONArray((String)localObject1);
        localObject1 = new JSONArray();
        i = 0;
        if (i >= paramMap.length()) {
          continue;
        }
        localObject4 = paramMap.getJSONObject(i);
        localObject2 = new JSONObject();
        localObject3 = ((JSONObject)localObject4).getString("id");
        localObject4 = ((JSONObject)localObject4).getString("imageUrl");
        ((JSONObject)localObject2).put("id", localObject3);
        ((JSONObject)localObject2).put("src", localObject4);
        ((JSONArray)localObject1).put(localObject2);
        i += 1;
        continue;
      }
      catch (JSONException paramMap)
      {
        Object localObject4;
        Object localObject2;
        Object localObject3;
        int k;
        Object localObject5;
        continue;
        i += 1;
        continue;
      }
      try
      {
        localObject2 = new JSONArray((String)localObject1);
        localObject3 = new JSONArray();
        paramMap = null;
        i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          localObject1 = ((JSONArray)localObject2).getJSONObject(i);
          k = ((JSONObject)localObject1).optInt("emojiType");
          localObject4 = ((JSONObject)localObject1).optString("id");
          if (k == 2)
          {
            localObject5 = new gc();
            ((gc)localObject5).cuC.coO = 3;
            ((gc)localObject5).cuC.cqq = ((JSONObject)localObject1).optString("md5");
            ((gc)localObject5).cuC.cuE = ((JSONObject)localObject1).optString("designerId");
            ((gc)localObject5).cuC.aeskey = ((JSONObject)localObject1).optString("aesKey");
            ((gc)localObject5).cuC.cuF = ((JSONObject)localObject1).optString("encryptUrl");
            ((gc)localObject5).cuC.cqx = ((JSONObject)localObject1).optString("productID");
            ((gc)localObject5).cuC.name = ((JSONObject)localObject1).optString("express");
            ((gc)localObject5).cuC.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            com.tencent.mm.sdk.b.a.ymk.l((b)localObject5);
            if (e.cN(((gc)localObject5).cuD.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + ((gc)localObject5).cuD.path;
              ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "path=%s", new Object[] { ((gc)localObject5).cuD.path });
              paramMap = (Map<String, Object>)localObject1;
              if (localObject1 == null) {
                continue;
              }
              paramMap = new JSONObject();
              paramMap.put("id", localObject4);
              paramMap.put("src", localObject1);
              ((JSONArray)localObject3).put(paramMap);
              paramMap = null;
              continue;
            }
            if (bool)
            {
              synchronized (this.uOr)
              {
                if (this.uOr.containsKey(((gc)localObject5).cuC.cqq))
                {
                  localObject1 = (HashSet)this.uOr.get(((gc)localObject5).cuC.cqq);
                  ((HashSet)localObject1).add(localObject4);
                  this.uOr.put(((gc)localObject5).cuC.cqq, localObject1);
                  this.uOu.put(((gc)localObject5).cuC.cqq, Integer.valueOf(j));
                  ((gc)localObject5).cuC.coO = 1;
                  com.tencent.mm.sdk.b.a.ymk.l((b)localObject5);
                  localObject1 = paramMap;
                  continue;
                }
                localObject1 = new HashSet();
              }
              AppMethodBeat.o(5670);
            }
          }
        }
      }
      catch (Exception paramMap) {}
    }
    for (;;)
    {
      return false;
      localObject1 = ((JSONObject)localObject1).optString("imageUrl");
      break;
      if (k == 4)
      {
        localObject5 = new JSONObject();
        ((JSONObject)localObject5).put("id", localObject4);
        if (bool) {
          ((JSONObject)localObject5).put("src", ((JSONObject)localObject1).optString("raw"));
        }
        for (;;)
        {
          ((JSONArray)localObject3).put(localObject5);
          break;
          ((JSONObject)localObject5).put("src", ((JSONObject)localObject1).optString("imageUrl"));
        }
      }
      localObject5 = new JSONObject();
      ((JSONObject)localObject5).put("id", localObject4);
      ((JSONObject)localObject5).put("src", ((JSONObject)localObject1).optString("imageUrl"));
      ((JSONArray)localObject3).put(localObject5);
      break label817;
      if (((JSONArray)localObject3).length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(j).bG(0, ((JSONArray)localObject3).toString());
        continue;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(j).bG(0, ((JSONArray)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a
 * JD-Core Version:    0.7.0.1
 */