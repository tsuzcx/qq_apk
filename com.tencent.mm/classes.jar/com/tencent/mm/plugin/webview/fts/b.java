package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.gn.a;
import com.tencent.mm.g.a.gn.b;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.up.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements k.a
{
  private volatile HashMap<String, HashSet<String>> DJI;
  volatile HashMap<String, HashSet<String>> DJJ;
  volatile HashMap<String, HashSet<String>> DJK;
  private volatile HashMap<String, Integer> DJL;
  volatile HashMap<String, Integer> DJM;
  volatile HashMap<String, Integer> DJN;
  public c<gn> DJO;
  public c zek;
  
  public b()
  {
    AppMethodBeat.i(77880);
    this.DJO = new c()
    {
      private boolean a(gn paramAnonymousgn)
      {
        AppMethodBeat.i(77876);
        if (paramAnonymousgn.dsr.dkM == 2)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[] { paramAnonymousgn.dsr.md5 });
          if (!b.this.DJK.containsKey(paramAnonymousgn.dsr.md5)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (b.this.DJK)
          {
            i = ((Integer)b.this.DJN.get(paramAnonymousgn.dsr.md5)).intValue();
            Object localObject = (HashSet)b.this.DJK.get(paramAnonymousgn.dsr.md5);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/emoji?path=" + paramAnonymousgn.dss.path;
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
            paramAnonymousgn = finally;
            AppMethodBeat.o(77876);
            throw paramAnonymousgn;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(i).cz(0, localJSONArray.toString());
            b.this.DJK.remove(paramAnonymousgn.dsr.md5);
            b.this.DJN.remove(paramAnonymousgn.dsr.md5);
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
    this.zek = new c()
    {
      private boolean a(up paramAnonymousup)
      {
        AppMethodBeat.i(77878);
        if (((paramAnonymousup instanceof up)) && (paramAnonymousup.dIP.dkM == 2))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Download callback %s", new Object[] { paramAnonymousup.dIP.mediaId });
          if (!b.this.DJJ.containsKey(paramAnonymousup.dIP.mediaId)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (b.this.DJJ)
          {
            i = ((Integer)b.this.DJM.get(paramAnonymousup.dIP.mediaId)).intValue();
            Object localObject = (HashSet)b.this.DJJ.get(paramAnonymousup.dIP.mediaId);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/sns?path=" + com.tencent.mm.vfs.i.k(paramAnonymousup.dIP.path, false);
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
            paramAnonymousup = finally;
            AppMethodBeat.o(77878);
            throw paramAnonymousup;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(i).cz(0, localJSONArray.toString());
            b.this.DJJ.remove(paramAnonymousup.dIP.mediaId);
            b.this.DJM.remove(paramAnonymousup.dIP.mediaId);
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
    this.DJI = new HashMap();
    this.DJJ = new HashMap();
    this.DJL = new HashMap();
    this.DJM = new HashMap();
    this.DJK = new HashMap();
    this.DJN = new HashMap();
    this.zek.alive();
    this.DJO.alive();
    p.aEx().add(this);
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
      synchronized (this.DJI)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "event %s，eventData %s", new Object[] { paramString, paramm.toString() });
        paramString = paramm.obj.toString();
        if ((this.DJI.containsKey(paramString)) && (this.DJL.containsKey(paramString)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "notify avatar changed %s", new Object[] { paramString });
          i = ((Integer)this.DJL.get(paramString)).intValue();
          Object localObject = new HashSet((HashSet)this.DJI.get(paramString));
          paramm = new JSONArray();
          localObject = ((HashSet)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            p.aEk();
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(i).cz(0, paramm.toString());
        this.DJI.remove(paramString);
        this.DJL.remove(paramString);
        AppMethodBeat.o(77884);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label218;
      }
    }
  }
  
  public final boolean be(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77881);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchAvatarList");
    Object localObject1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "data");
    int j = bt.m(paramMap.get("webview_instance_id"), -1);
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
          p.aEk();
          paramMap = e.K(str2, false);
          if (!com.tencent.mm.vfs.i.fv(paramMap)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file exist %s", new Object[] { paramMap });
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewImageLogic", paramMap, "", new Object[0]);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(j).cz(-1, "");
        AppMethodBeat.o(77881);
        return false;
      }
      paramMap = new com.tencent.mm.ak.i();
      paramMap.username = str2;
      paramMap.hMX = str3;
      paramMap.hMW = ((String)localObject2);
      paramMap.dDp = -1;
      paramMap.ePj = 3;
      paramMap.eB(true);
      p.aEx().b(paramMap);
      continue;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file not exist %s", new Object[] { paramMap });
      this.DJL.put(str2, Integer.valueOf(j));
      Object localObject2 = (HashSet)this.DJI.get(str2);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject2 == null) {
        paramMap = new HashSet();
      }
      paramMap.add(str1);
      this.DJI.put(str2, paramMap);
      a.b.fbx().fg(str2);
      paramMap = (Map<String, Object>)localObject1;
      continue;
      label431:
      if (localJSONArray2.length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(j).cz(0, localJSONArray2.toString());
        continue;
        continue;
        label458:
        i += 1;
      }
    }
  }
  
  public final boolean bf(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77882);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchSnsImageList");
    Object localObject1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "data");
    int j = bt.m(paramMap.get("webview_instance_id"), -1);
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
          localObject1 = ((n)com.tencent.mm.kernel.g.ab(n.class)).Gx((String)localObject2);
          if (((TimeLineObject)localObject1).HAT.GaQ.size() <= k) {
            break label494;
          }
          localObject2 = (byn)((TimeLineObject)localObject1).HAT.GaQ.get(k);
          localObject1 = new up();
          ((up)localObject1).dIP.dkM = 3;
          ((up)localObject1).dIP.mediaId = ((byn)localObject2).Id;
          a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "generatePath: %s", new Object[] { ((up)localObject1).dIP.path });
          if (com.tencent.mm.vfs.i.fv(((up)localObject1).dIP.path))
          {
            localObject1 = "weixin://fts/sns?path=" + com.tencent.mm.vfs.i.k(((up)localObject1).dIP.path, false);
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
          synchronized (this.DJJ)
          {
            if (this.DJJ.containsKey(((byn)localObject2).Id))
            {
              localObject1 = (HashSet)this.DJJ.get(((byn)localObject2).Id);
              ((HashSet)localObject1).add(str);
              this.DJJ.put(((byn)localObject2).Id, localObject1);
              this.DJM.put(((byn)localObject2).Id, Integer.valueOf(j));
              localObject1 = new up();
              ((up)localObject1).dIP.dkM = 1;
              ((up)localObject1).dIP.dIQ = ((byn)localObject2);
              a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
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
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(j).cz(0, localJSONArray2.toString());
      continue;
      label494:
      i += 1;
    }
  }
  
  public final boolean bg(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77883);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchImageList");
    i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "requestType", 0);
    Object localObject1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "data");
    int j = bt.m(paramMap.get("webview_instance_id"), -1);
    boolean bool = ay.isWifi(aj.getContext());
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
            localObject5 = new gn();
            ((gn)localObject5).dsr.dkM = 3;
            ((gn)localObject5).dsr.md5 = ((JSONObject)localObject1).optString("md5");
            ((gn)localObject5).dsr.dsu = ((JSONObject)localObject1).optString("designerId");
            ((gn)localObject5).dsr.aeskey = ((JSONObject)localObject1).optString("aesKey");
            ((gn)localObject5).dsr.dsv = ((JSONObject)localObject1).optString("encryptUrl");
            ((gn)localObject5).dsr.dok = ((JSONObject)localObject1).optString("productID");
            ((gn)localObject5).dsr.name = ((JSONObject)localObject1).optString("express");
            ((gn)localObject5).dsr.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            a.IbL.l((com.tencent.mm.sdk.b.b)localObject5);
            if (com.tencent.mm.vfs.i.fv(((gn)localObject5).dss.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + ((gn)localObject5).dss.path;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "path=%s", new Object[] { ((gn)localObject5).dss.path });
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
              synchronized (this.DJK)
              {
                if (this.DJK.containsKey(((gn)localObject5).dsr.md5))
                {
                  localObject1 = (HashSet)this.DJK.get(((gn)localObject5).dsr.md5);
                  ((HashSet)localObject1).add(localObject4);
                  this.DJK.put(((gn)localObject5).dsr.md5, localObject1);
                  this.DJN.put(((gn)localObject5).dsr.md5, Integer.valueOf(j));
                  ((gn)localObject5).dsr.dkM = 1;
                  a.IbL.l((com.tencent.mm.sdk.b.b)localObject5);
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(j).cz(0, ((JSONArray)localObject3).toString());
        continue;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(j).cz(0, ((JSONArray)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b
 * JD-Core Version:    0.7.0.1
 */