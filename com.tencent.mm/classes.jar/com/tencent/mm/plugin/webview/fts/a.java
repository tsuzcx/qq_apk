package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.gj.a;
import com.tencent.mm.g.a.gj.b;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.g.a.tn.a;
import com.tencent.mm.plugin.sns.c.n;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
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

public final class a
  implements k.a
{
  private volatile HashMap<String, HashSet<String>> AOj;
  volatile HashMap<String, HashSet<String>> AOk;
  volatile HashMap<String, HashSet<String>> AOl;
  private volatile HashMap<String, Integer> AOm;
  volatile HashMap<String, Integer> AOn;
  volatile HashMap<String, Integer> AOo;
  public c<gj> AOp;
  public c wBV;
  
  public a()
  {
    AppMethodBeat.i(77880);
    this.AOp = new c()
    {
      private boolean a(gj paramAnonymousgj)
      {
        AppMethodBeat.i(77876);
        if (paramAnonymousgj.djz.dbV == 2)
        {
          ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[] { paramAnonymousgj.djz.md5 });
          if (!a.this.AOl.containsKey(paramAnonymousgj.djz.md5)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (a.this.AOl)
          {
            i = ((Integer)a.this.AOo.get(paramAnonymousgj.djz.md5)).intValue();
            Object localObject = (HashSet)a.this.AOl.get(paramAnonymousgj.djz.md5);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/emoji?path=" + paramAnonymousgj.djA.path;
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
            paramAnonymousgj = finally;
            AppMethodBeat.o(77876);
            throw paramAnonymousgj;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(i).cq(0, localJSONArray.toString());
            a.this.AOl.remove(paramAnonymousgj.djz.md5);
            a.this.AOo.remove(paramAnonymousgj.djz.md5);
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
    this.wBV = new c()
    {
      private boolean a(tn paramAnonymoustn)
      {
        AppMethodBeat.i(77878);
        if (((paramAnonymoustn instanceof tn)) && (paramAnonymoustn.dyR.dbV == 2))
        {
          ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Download callback %s", new Object[] { paramAnonymoustn.dyR.mediaId });
          if (!a.this.AOk.containsKey(paramAnonymoustn.dyR.mediaId)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (a.this.AOk)
          {
            i = ((Integer)a.this.AOn.get(paramAnonymoustn.dyR.mediaId)).intValue();
            Object localObject = (HashSet)a.this.AOk.get(paramAnonymoustn.dyR.mediaId);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/sns?path=" + com.tencent.mm.vfs.i.k(paramAnonymoustn.dyR.path, false);
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
            paramAnonymoustn = finally;
            AppMethodBeat.o(77878);
            throw paramAnonymoustn;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(i).cq(0, localJSONArray.toString());
            a.this.AOk.remove(paramAnonymoustn.dyR.mediaId);
            a.this.AOn.remove(paramAnonymoustn.dyR.mediaId);
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
    this.AOj = new HashMap();
    this.AOk = new HashMap();
    this.AOm = new HashMap();
    this.AOn = new HashMap();
    this.AOl = new HashMap();
    this.AOo = new HashMap();
    this.wBV.alive();
    this.AOp.alive();
    p.auF().add(this);
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
      synchronized (this.AOj)
      {
        ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "event %s，eventData %s", new Object[] { paramString, paramm.toString() });
        paramString = paramm.obj.toString();
        if ((this.AOj.containsKey(paramString)) && (this.AOm.containsKey(paramString)))
        {
          ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "notify avatar changed %s", new Object[] { paramString });
          i = ((Integer)this.AOm.get(paramString)).intValue();
          Object localObject = new HashSet((HashSet)this.AOj.get(paramString));
          paramm = new JSONArray();
          localObject = ((HashSet)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            p.auq();
            str2 = "weixin://fts/avatar?path=".concat(String.valueOf(e.J(paramString, false)));
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(i).cq(0, paramm.toString());
        this.AOj.remove(paramString);
        this.AOm.remove(paramString);
        AppMethodBeat.o(77884);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label218;
      }
    }
  }
  
  public final boolean aX(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77881);
    ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchAvatarList");
    Object localObject1 = aa.w(paramMap, "data");
    int j = bt.i(paramMap.get("webview_instance_id"), -1);
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
          p.auq();
          paramMap = e.J(str2, false);
          if (!com.tencent.mm.vfs.i.eK(paramMap)) {
            break;
          }
          ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file exist %s", new Object[] { paramMap });
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
        ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewImageLogic", paramMap, "", new Object[0]);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(j).cq(-1, "");
        AppMethodBeat.o(77881);
        return false;
      }
      paramMap = new com.tencent.mm.ak.i();
      paramMap.username = str2;
      paramMap.gUg = str3;
      paramMap.gUf = ((String)localObject2);
      paramMap.dtM = -1;
      paramMap.evo = 3;
      paramMap.ee(true);
      p.auF().b(paramMap);
      continue;
      ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file not exist %s", new Object[] { paramMap });
      this.AOm.put(str2, Integer.valueOf(j));
      Object localObject2 = (HashSet)this.AOj.get(str2);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject2 == null) {
        paramMap = new HashSet();
      }
      paramMap.add(str1);
      this.AOj.put(str2, paramMap);
      a.b.exg().ew(str2);
      paramMap = (Map<String, Object>)localObject1;
      continue;
      label431:
      if (localJSONArray2.length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(j).cq(0, localJSONArray2.toString());
        continue;
        continue;
        label458:
        i += 1;
      }
    }
  }
  
  public final boolean aY(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77882);
    ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchSnsImageList");
    Object localObject1 = aa.w(paramMap, "data");
    int j = bt.i(paramMap.get("webview_instance_id"), -1);
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
          localObject1 = ((n)com.tencent.mm.kernel.g.ab(n.class)).zn((String)localObject2);
          if (((TimeLineObject)localObject1).Etm.DaC.size() <= k) {
            break label494;
          }
          localObject2 = (bpi)((TimeLineObject)localObject1).Etm.DaC.get(k);
          localObject1 = new tn();
          ((tn)localObject1).dyR.dbV = 3;
          ((tn)localObject1).dyR.mediaId = ((bpi)localObject2).Id;
          com.tencent.mm.sdk.b.a.ESL.l((b)localObject1);
          ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "generatePath: %s", new Object[] { ((tn)localObject1).dyR.path });
          if (com.tencent.mm.vfs.i.eK(((tn)localObject1).dyR.path))
          {
            localObject1 = "weixin://fts/sns?path=" + com.tencent.mm.vfs.i.k(((tn)localObject1).dyR.path, false);
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
          synchronized (this.AOk)
          {
            if (this.AOk.containsKey(((bpi)localObject2).Id))
            {
              localObject1 = (HashSet)this.AOk.get(((bpi)localObject2).Id);
              ((HashSet)localObject1).add(str);
              this.AOk.put(((bpi)localObject2).Id, localObject1);
              this.AOn.put(((bpi)localObject2).Id, Integer.valueOf(j));
              localObject1 = new tn();
              ((tn)localObject1).dyR.dbV = 1;
              ((tn)localObject1).dyR.dyS = ((bpi)localObject2);
              com.tencent.mm.sdk.b.a.ESL.l((b)localObject1);
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
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(j).cq(0, localJSONArray2.toString());
      continue;
      label494:
      i += 1;
    }
  }
  
  public final boolean aZ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77883);
    ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchImageList");
    i = aa.d(paramMap, "requestType", 0);
    Object localObject1 = aa.w(paramMap, "data");
    int j = bt.i(paramMap.get("webview_instance_id"), -1);
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
            localObject5 = new gj();
            ((gj)localObject5).djz.dbV = 3;
            ((gj)localObject5).djz.md5 = ((JSONObject)localObject1).optString("md5");
            ((gj)localObject5).djz.djB = ((JSONObject)localObject1).optString("designerId");
            ((gj)localObject5).djz.aeskey = ((JSONObject)localObject1).optString("aesKey");
            ((gj)localObject5).djz.djC = ((JSONObject)localObject1).optString("encryptUrl");
            ((gj)localObject5).djz.dft = ((JSONObject)localObject1).optString("productID");
            ((gj)localObject5).djz.name = ((JSONObject)localObject1).optString("express");
            ((gj)localObject5).djz.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            com.tencent.mm.sdk.b.a.ESL.l((b)localObject5);
            if (com.tencent.mm.vfs.i.eK(((gj)localObject5).djA.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + ((gj)localObject5).djA.path;
              ad.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "path=%s", new Object[] { ((gj)localObject5).djA.path });
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
              synchronized (this.AOl)
              {
                if (this.AOl.containsKey(((gj)localObject5).djz.md5))
                {
                  localObject1 = (HashSet)this.AOl.get(((gj)localObject5).djz.md5);
                  ((HashSet)localObject1).add(localObject4);
                  this.AOl.put(((gj)localObject5).djz.md5, localObject1);
                  this.AOo.put(((gj)localObject5).djz.md5, Integer.valueOf(j));
                  ((gj)localObject5).djz.dbV = 1;
                  com.tencent.mm.sdk.b.a.ESL.l((b)localObject5);
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(j).cq(0, ((JSONArray)localObject3).toString());
        continue;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(j).cq(0, ((JSONArray)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a
 * JD-Core Version:    0.7.0.1
 */