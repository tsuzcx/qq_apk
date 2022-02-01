package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.gk.a;
import com.tencent.mm.g.a.gk.b;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.a.tw.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  private volatile HashMap<String, HashSet<String>> CgB;
  volatile HashMap<String, HashSet<String>> CgC;
  volatile HashMap<String, HashSet<String>> CgD;
  private volatile HashMap<String, Integer> CgE;
  volatile HashMap<String, Integer> CgF;
  volatile HashMap<String, Integer> CgG;
  public c<gk> CgH;
  public c xOq;
  
  public a()
  {
    AppMethodBeat.i(77880);
    this.CgH = new c()
    {
      private boolean a(gk paramAnonymousgk)
      {
        AppMethodBeat.i(77876);
        if (paramAnonymousgk.dgU.cZu == 2)
        {
          ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[] { paramAnonymousgk.dgU.md5 });
          if (!a.this.CgD.containsKey(paramAnonymousgk.dgU.md5)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (a.this.CgD)
          {
            i = ((Integer)a.this.CgG.get(paramAnonymousgk.dgU.md5)).intValue();
            Object localObject = (HashSet)a.this.CgD.get(paramAnonymousgk.dgU.md5);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/emoji?path=" + paramAnonymousgk.dgV.path;
              localJSONObject = new JSONObject();
            }
          }
          try
          {
            localJSONObject.put("id", str1);
            localJSONObject.put("src", str2);
            label204:
            localJSONArray.put(localJSONObject);
            continue;
            paramAnonymousgk = finally;
            AppMethodBeat.o(77876);
            throw paramAnonymousgk;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(i).ct(0, localJSONArray.toString());
            a.this.CgD.remove(paramAnonymousgk.dgU.md5);
            a.this.CgG.remove(paramAnonymousgk.dgU.md5);
            AppMethodBeat.o(77876);
            return false;
          }
          catch (JSONException localJSONException)
          {
            break label204;
          }
        }
      }
    };
    this.xOq = new c()
    {
      private boolean a(tw paramAnonymoustw)
      {
        AppMethodBeat.i(77878);
        if (((paramAnonymoustw instanceof tw)) && (paramAnonymoustw.dwD.cZu == 2))
        {
          ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Download callback %s", new Object[] { paramAnonymoustw.dwD.mediaId });
          if (!a.this.CgC.containsKey(paramAnonymoustw.dwD.mediaId)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (a.this.CgC)
          {
            i = ((Integer)a.this.CgF.get(paramAnonymoustw.dwD.mediaId)).intValue();
            Object localObject = (HashSet)a.this.CgC.get(paramAnonymoustw.dwD.mediaId);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/sns?path=" + com.tencent.mm.vfs.i.k(paramAnonymoustw.dwD.path, false);
              localJSONObject = new JSONObject();
            }
          }
          try
          {
            localJSONObject.put("id", str1);
            localJSONObject.put("src", str2);
            label215:
            localJSONArray.put(localJSONObject);
            continue;
            paramAnonymoustw = finally;
            AppMethodBeat.o(77878);
            throw paramAnonymoustw;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(i).ct(0, localJSONArray.toString());
            a.this.CgC.remove(paramAnonymoustw.dwD.mediaId);
            a.this.CgF.remove(paramAnonymoustw.dwD.mediaId);
            AppMethodBeat.o(77878);
            return false;
          }
          catch (JSONException localJSONException)
          {
            break label215;
          }
        }
      }
    };
    this.CgB = new HashMap();
    this.CgC = new HashMap();
    this.CgE = new HashMap();
    this.CgF = new HashMap();
    this.CgD = new HashMap();
    this.CgG = new HashMap();
    this.xOq.alive();
    this.CgH.alive();
    p.aBw().add(this);
    AppMethodBeat.o(77880);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(77884);
    if ((paramm == null) || (paramm.obj == null))
    {
      AppMethodBeat.o(77884);
      return;
    }
    for (;;)
    {
      int i;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (this.CgB)
      {
        ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "event %s，eventData %s", new Object[] { paramString, paramm.toString() });
        paramString = paramm.obj.toString();
        if ((this.CgB.containsKey(paramString)) && (this.CgE.containsKey(paramString)))
        {
          ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "notify avatar changed %s", new Object[] { paramString });
          i = ((Integer)this.CgE.get(paramString)).intValue();
          Object localObject = new HashSet((HashSet)this.CgB.get(paramString));
          paramm = new JSONArray();
          localObject = ((HashSet)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            p.aBh();
            str2 = "weixin://fts/avatar?path=".concat(String.valueOf(e.K(paramString, false)));
            localJSONObject = new JSONObject();
          }
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label218:
        paramm.put(localJSONObject);
        continue;
        paramString = finally;
        AppMethodBeat.o(77884);
        throw paramString;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(i).ct(0, paramm.toString());
        this.CgB.remove(paramString);
        this.CgE.remove(paramString);
        AppMethodBeat.o(77884);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label218;
      }
    }
  }
  
  public final boolean bb(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77881);
    ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchAvatarList");
    Object localObject1 = z.x(paramMap, "data");
    int j = bs.l(paramMap.get("webview_instance_id"), -1);
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
          break label431;
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
          p.aBh();
          paramMap = e.K(str2, false);
          if (!com.tencent.mm.vfs.i.eA(paramMap)) {
            break;
          }
          ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file exist %s", new Object[] { paramMap });
          paramMap = "weixin://fts/avatar?path=".concat(String.valueOf(paramMap));
        case 4: 
        case 64: 
          localObject1 = paramMap;
          if (paramMap == null) {
            break label458;
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
        ac.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewImageLogic", paramMap, "", new Object[0]);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(j).ct(-1, "");
        AppMethodBeat.o(77881);
        return false;
      }
      paramMap = new com.tencent.mm.aj.i();
      paramMap.username = str2;
      paramMap.huF = str3;
      paramMap.huE = ((String)localObject2);
      paramMap.drx = -1;
      paramMap.exK = 3;
      paramMap.ez(true);
      p.aBw().b(paramMap);
      continue;
      ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file not exist %s", new Object[] { paramMap });
      this.CgE.put(str2, Integer.valueOf(j));
      Object localObject2 = (HashSet)this.CgB.get(str2);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject2 == null) {
        paramMap = new HashSet();
      }
      paramMap.add(str1);
      this.CgB.put(str2, paramMap);
      a.b.eMA().el(str2);
      paramMap = (Map<String, Object>)localObject1;
      continue;
      label431:
      if (localJSONArray2.length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(j).ct(0, localJSONArray2.toString());
        continue;
        continue;
        label458:
        i += 1;
      }
    }
  }
  
  public final boolean bc(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77882);
    ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchSnsImageList");
    Object localObject1 = z.x(paramMap, "data");
    int j = bs.l(paramMap.get("webview_instance_id"), -1);
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
          localObject1 = ((n)com.tencent.mm.kernel.g.ab(n.class)).Ds((String)localObject2);
          if (((TimeLineObject)localObject1).FQo.Etz.size() <= k) {
            break label494;
          }
          localObject2 = (btz)((TimeLineObject)localObject1).FQo.Etz.get(k);
          localObject1 = new tw();
          ((tw)localObject1).dwD.cZu = 3;
          ((tw)localObject1).dwD.mediaId = ((btz)localObject2).Id;
          com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
          ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "generatePath: %s", new Object[] { ((tw)localObject1).dwD.path });
          if (com.tencent.mm.vfs.i.eA(((tw)localObject1).dwD.path))
          {
            localObject1 = "weixin://fts/sns?path=" + com.tencent.mm.vfs.i.k(((tw)localObject1).dwD.path, false);
            paramMap = (Map<String, Object>)localObject1;
            if (localObject1 == null) {
              break label494;
            }
            paramMap = new JSONObject();
            paramMap.put("id", str);
            paramMap.put("src", localObject1);
            localJSONArray2.put(paramMap);
            paramMap = null;
            break label494;
          }
          synchronized (this.CgC)
          {
            if (this.CgC.containsKey(((btz)localObject2).Id))
            {
              localObject1 = (HashSet)this.CgC.get(((btz)localObject2).Id);
              ((HashSet)localObject1).add(str);
              this.CgC.put(((btz)localObject2).Id, localObject1);
              this.CgF.put(((btz)localObject2).Id, Integer.valueOf(j));
              localObject1 = new tw();
              ((tw)localObject1).dwD.cZu = 1;
              ((tw)localObject1).dwD.dwE = ((btz)localObject2);
              com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
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
        AppMethodBeat.o(77882);
        return false;
      }
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(j).ct(0, localJSONArray2.toString());
      continue;
      label494:
      i += 1;
    }
  }
  
  public final boolean bd(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77883);
    ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchImageList");
    i = z.d(paramMap, "requestType", 0);
    Object localObject1 = z.x(paramMap, "data");
    int j = bs.l(paramMap.get("webview_instance_id"), -1);
    boolean bool = ax.isWifi(ai.getContext());
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
            localObject5 = new gk();
            ((gk)localObject5).dgU.cZu = 3;
            ((gk)localObject5).dgU.md5 = ((JSONObject)localObject1).optString("md5");
            ((gk)localObject5).dgU.dgW = ((JSONObject)localObject1).optString("designerId");
            ((gk)localObject5).dgU.aeskey = ((JSONObject)localObject1).optString("aesKey");
            ((gk)localObject5).dgU.dgX = ((JSONObject)localObject1).optString("encryptUrl");
            ((gk)localObject5).dgU.dcO = ((JSONObject)localObject1).optString("productID");
            ((gk)localObject5).dgU.name = ((JSONObject)localObject1).optString("express");
            ((gk)localObject5).dgU.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            com.tencent.mm.sdk.b.a.GpY.l((b)localObject5);
            if (com.tencent.mm.vfs.i.eA(((gk)localObject5).dgV.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + ((gk)localObject5).dgV.path;
              ac.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "path=%s", new Object[] { ((gk)localObject5).dgV.path });
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
              synchronized (this.CgD)
              {
                if (this.CgD.containsKey(((gk)localObject5).dgU.md5))
                {
                  localObject1 = (HashSet)this.CgD.get(((gk)localObject5).dgU.md5);
                  ((HashSet)localObject1).add(localObject4);
                  this.CgD.put(((gk)localObject5).dgU.md5, localObject1);
                  this.CgG.put(((gk)localObject5).dgU.md5, Integer.valueOf(j));
                  ((gk)localObject5).dgU.cZu = 1;
                  com.tencent.mm.sdk.b.a.GpY.l((b)localObject5);
                  localObject1 = paramMap;
                  continue;
                }
                localObject1 = new HashSet();
              }
              AppMethodBeat.o(77883);
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(j).ct(0, ((JSONArray)localObject3).toString());
        continue;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(j).ct(0, ((JSONArray)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a
 * JD-Core Version:    0.7.0.1
 */