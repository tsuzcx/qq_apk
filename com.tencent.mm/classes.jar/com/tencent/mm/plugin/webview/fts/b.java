package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.go.a;
import com.tencent.mm.g.a.go.b;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
  private volatile HashMap<String, HashSet<String>> EbG;
  volatile HashMap<String, HashSet<String>> EbH;
  volatile HashMap<String, HashSet<String>> EbI;
  private volatile HashMap<String, Integer> EbJ;
  volatile HashMap<String, Integer> EbK;
  volatile HashMap<String, Integer> EbL;
  public c<go> EbM;
  public c zuZ;
  
  public b()
  {
    AppMethodBeat.i(77880);
    this.EbM = new c()
    {
      private boolean a(go paramAnonymousgo)
      {
        AppMethodBeat.i(77876);
        if (paramAnonymousgo.dty.dlO == 2)
        {
          ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[] { paramAnonymousgo.dty.md5 });
          if (!b.this.EbI.containsKey(paramAnonymousgo.dty.md5)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (b.this.EbI)
          {
            i = ((Integer)b.this.EbL.get(paramAnonymousgo.dty.md5)).intValue();
            Object localObject = (HashSet)b.this.EbI.get(paramAnonymousgo.dty.md5);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/emoji?path=" + paramAnonymousgo.dtz.path;
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
            paramAnonymousgo = finally;
            AppMethodBeat.o(77876);
            throw paramAnonymousgo;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(i).cz(0, localJSONArray.toString());
            b.this.EbI.remove(paramAnonymousgo.dty.md5);
            b.this.EbL.remove(paramAnonymousgo.dty.md5);
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
    this.zuZ = new c()
    {
      private boolean a(ut paramAnonymousut)
      {
        AppMethodBeat.i(77878);
        if (((paramAnonymousut instanceof ut)) && (paramAnonymousut.dKd.dlO == 2))
        {
          ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Download callback %s", new Object[] { paramAnonymousut.dKd.mediaId });
          if (!b.this.EbH.containsKey(paramAnonymousut.dKd.mediaId)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (b.this.EbH)
          {
            i = ((Integer)b.this.EbK.get(paramAnonymousut.dKd.mediaId)).intValue();
            Object localObject = (HashSet)b.this.EbH.get(paramAnonymousut.dKd.mediaId);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/sns?path=" + o.k(paramAnonymousut.dKd.path, false);
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
            paramAnonymousut = finally;
            AppMethodBeat.o(77878);
            throw paramAnonymousut;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(i).cz(0, localJSONArray.toString());
            b.this.EbH.remove(paramAnonymousut.dKd.mediaId);
            b.this.EbK.remove(paramAnonymousut.dKd.mediaId);
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
    this.EbG = new HashMap();
    this.EbH = new HashMap();
    this.EbJ = new HashMap();
    this.EbK = new HashMap();
    this.EbI = new HashMap();
    this.EbL = new HashMap();
    this.zuZ.alive();
    this.EbM.alive();
    p.aEN().add(this);
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
      synchronized (this.EbG)
      {
        ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "event %s，eventData %s", new Object[] { paramString, paramm.toString() });
        paramString = paramm.obj.toString();
        if ((this.EbG.containsKey(paramString)) && (this.EbJ.containsKey(paramString)))
        {
          ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "notify avatar changed %s", new Object[] { paramString });
          i = ((Integer)this.EbJ.get(paramString)).intValue();
          Object localObject = new HashSet((HashSet)this.EbG.get(paramString));
          paramm = new JSONArray();
          localObject = ((HashSet)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            p.aEA();
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(i).cz(0, paramm.toString());
        this.EbG.remove(paramString);
        this.EbJ.remove(paramString);
        AppMethodBeat.o(77884);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label218;
      }
    }
  }
  
  public final boolean bk(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77881);
    ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchAvatarList");
    Object localObject1 = ad.A(paramMap, "data");
    int j = bu.m(paramMap.get("webview_instance_id"), -1);
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
          p.aEA();
          paramMap = e.K(str2, false);
          if (!o.fB(paramMap)) {
            break;
          }
          ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file exist %s", new Object[] { paramMap });
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
        ae.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewImageLogic", paramMap, "", new Object[0]);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(j).cz(-1, "");
        AppMethodBeat.o(77881);
        return false;
      }
      paramMap = new i();
      paramMap.username = str2;
      paramMap.hPQ = str3;
      paramMap.hPP = ((String)localObject2);
      paramMap.dEu = -1;
      paramMap.eQU = 3;
      paramMap.eD(true);
      p.aEN().b(paramMap);
      continue;
      ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file not exist %s", new Object[] { paramMap });
      this.EbJ.put(str2, Integer.valueOf(j));
      Object localObject2 = (HashSet)this.EbG.get(str2);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject2 == null) {
        paramMap = new HashSet();
      }
      paramMap.add(str1);
      this.EbG.put(str2, paramMap);
      a.b.ffl().fl(str2);
      paramMap = (Map<String, Object>)localObject1;
      continue;
      label431:
      if (localJSONArray2.length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(j).cz(0, localJSONArray2.toString());
        continue;
        continue;
        label458:
        i += 1;
      }
    }
  }
  
  public final boolean bl(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77882);
    ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchSnsImageList");
    Object localObject1 = ad.A(paramMap, "data");
    int j = bu.m(paramMap.get("webview_instance_id"), -1);
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
          localObject1 = ((n)com.tencent.mm.kernel.g.ab(n.class)).GZ((String)localObject2);
          if (((TimeLineObject)localObject1).HUG.Gtx.size() <= k) {
            break label494;
          }
          localObject2 = (bzh)((TimeLineObject)localObject1).HUG.Gtx.get(k);
          localObject1 = new ut();
          ((ut)localObject1).dKd.dlO = 3;
          ((ut)localObject1).dKd.mediaId = ((bzh)localObject2).Id;
          a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
          ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "generatePath: %s", new Object[] { ((ut)localObject1).dKd.path });
          if (o.fB(((ut)localObject1).dKd.path))
          {
            localObject1 = "weixin://fts/sns?path=" + o.k(((ut)localObject1).dKd.path, false);
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
          synchronized (this.EbH)
          {
            if (this.EbH.containsKey(((bzh)localObject2).Id))
            {
              localObject1 = (HashSet)this.EbH.get(((bzh)localObject2).Id);
              ((HashSet)localObject1).add(str);
              this.EbH.put(((bzh)localObject2).Id, localObject1);
              this.EbK.put(((bzh)localObject2).Id, Integer.valueOf(j));
              localObject1 = new ut();
              ((ut)localObject1).dKd.dlO = 1;
              ((ut)localObject1).dKd.dKe = ((bzh)localObject2);
              a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
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
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(j).cz(0, localJSONArray2.toString());
      continue;
      label494:
      i += 1;
    }
  }
  
  public final boolean bm(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77883);
    ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchImageList");
    i = ad.b(paramMap, "requestType", 0);
    Object localObject1 = ad.A(paramMap, "data");
    int j = bu.m(paramMap.get("webview_instance_id"), -1);
    boolean bool = az.isWifi(ak.getContext());
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
            localObject5 = new go();
            ((go)localObject5).dty.dlO = 3;
            ((go)localObject5).dty.md5 = ((JSONObject)localObject1).optString("md5");
            ((go)localObject5).dty.dtA = ((JSONObject)localObject1).optString("designerId");
            ((go)localObject5).dty.aeskey = ((JSONObject)localObject1).optString("aesKey");
            ((go)localObject5).dty.dtB = ((JSONObject)localObject1).optString("encryptUrl");
            ((go)localObject5).dty.dpp = ((JSONObject)localObject1).optString("productID");
            ((go)localObject5).dty.name = ((JSONObject)localObject1).optString("express");
            ((go)localObject5).dty.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            a.IvT.l((com.tencent.mm.sdk.b.b)localObject5);
            if (o.fB(((go)localObject5).dtz.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + ((go)localObject5).dtz.path;
              ae.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "path=%s", new Object[] { ((go)localObject5).dtz.path });
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
              synchronized (this.EbI)
              {
                if (this.EbI.containsKey(((go)localObject5).dty.md5))
                {
                  localObject1 = (HashSet)this.EbI.get(((go)localObject5).dty.md5);
                  ((HashSet)localObject1).add(localObject4);
                  this.EbI.put(((go)localObject5).dty.md5, localObject1);
                  this.EbL.put(((go)localObject5).dty.md5, Integer.valueOf(j));
                  ((go)localObject5).dty.dlO = 1;
                  a.IvT.l((com.tencent.mm.sdk.b.b)localObject5);
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(j).cz(0, ((JSONArray)localObject3).toString());
        continue;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(j).cz(0, ((JSONArray)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b
 * JD-Core Version:    0.7.0.1
 */