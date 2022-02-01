package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.f.a.gy;
import com.tencent.mm.f.a.gy.a;
import com.tencent.mm.f.a.gy.b;
import com.tencent.mm.f.a.ww;
import com.tencent.mm.f.a.ww.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.u;
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
  implements MStorage.IOnStorageChange
{
  public IListener JSi;
  private volatile HashMap<String, HashSet<String>> PBw;
  private volatile HashMap<String, HashSet<String>> PBx;
  private volatile HashMap<String, HashSet<String>> PKj;
  private volatile HashMap<String, Integer> PKk;
  private volatile HashMap<String, Integer> PKl;
  private volatile HashMap<String, Integer> PKm;
  public IListener<gy> PKn;
  
  public b()
  {
    AppMethodBeat.i(77880);
    this.PKn = new IListener()
    {
      private boolean a(gy paramAnonymousgy)
      {
        AppMethodBeat.i(77876);
        if (paramAnonymousgy.fDw.fvK == 2)
        {
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[] { paramAnonymousgy.fDw.md5 });
          if (!b.a(b.this).containsKey(paramAnonymousgy.fDw.md5)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (b.a(b.this))
          {
            i = ((Integer)b.b(b.this).get(paramAnonymousgy.fDw.md5)).intValue();
            Object localObject = (HashSet)b.a(b.this).get(paramAnonymousgy.fDw.md5);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/emoji?path=" + paramAnonymousgy.fDx.path;
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
            paramAnonymousgy = finally;
            AppMethodBeat.o(77876);
            throw paramAnonymousgy;
            i.aoU(i).cQ(0, localJSONArray.toString());
            b.a(b.this).remove(paramAnonymousgy.fDw.md5);
            b.b(b.this).remove(paramAnonymousgy.fDw.md5);
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
    this.JSi = new IListener()
    {
      private boolean a(ww paramAnonymousww)
      {
        AppMethodBeat.i(77878);
        if (((paramAnonymousww instanceof ww)) && (paramAnonymousww.fVS.fvK == 2))
        {
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Download callback %s", new Object[] { paramAnonymousww.fVS.mediaId });
          if (!b.c(b.this).containsKey(paramAnonymousww.fVS.mediaId)) {}
        }
        for (;;)
        {
          int i;
          JSONArray localJSONArray;
          String str1;
          String str2;
          JSONObject localJSONObject;
          synchronized (b.c(b.this))
          {
            i = ((Integer)b.d(b.this).get(paramAnonymousww.fVS.mediaId)).intValue();
            Object localObject = (HashSet)b.c(b.this).get(paramAnonymousww.fVS.mediaId);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/sns?path=" + u.n(paramAnonymousww.fVS.path, false);
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
            paramAnonymousww = finally;
            AppMethodBeat.o(77878);
            throw paramAnonymousww;
            i.aoU(i).cQ(0, localJSONArray.toString());
            b.c(b.this).remove(paramAnonymousww.fVS.mediaId);
            b.d(b.this).remove(paramAnonymousww.fVS.mediaId);
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
    this.PBx = new HashMap();
    this.PKj = new HashMap();
    this.PKk = new HashMap();
    this.PKl = new HashMap();
    this.PBw = new HashMap();
    this.PKm = new HashMap();
    this.JSi.alive();
    this.PKn.alive();
    q.bhP().add(this);
    AppMethodBeat.o(77880);
  }
  
  public final boolean bh(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77881);
    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchAvatarList");
    Object localObject1 = ai.aa(paramMap, "data");
    int j = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
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
          break label428;
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
          q.bhz();
          paramMap = f.O(str2, false);
          if (!u.agG(paramMap)) {
            break;
          }
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file exist %s", new Object[] { paramMap });
          paramMap = "weixin://fts/avatar?path=".concat(String.valueOf(paramMap));
        case 4: 
        case 64: 
          localObject1 = paramMap;
          if (paramMap == null) {
            break label455;
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
        Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewImageLogic", paramMap, "", new Object[0]);
        i.aoU(j).cQ(-1, "");
        AppMethodBeat.o(77881);
        return false;
      }
      paramMap = new j();
      paramMap.username = str2;
      paramMap.lBe = str3;
      paramMap.lBd = ((String)localObject2);
      paramMap.cUP = -1;
      paramMap.hDc = 3;
      paramMap.gg(true);
      q.bhP().b(paramMap);
      continue;
      Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file not exist %s", new Object[] { paramMap });
      this.PKk.put(str2, Integer.valueOf(j));
      Object localObject2 = (HashSet)this.PBx.get(str2);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject2 == null) {
        paramMap = new HashSet();
      }
      paramMap.add(str1);
      this.PBx.put(str2, paramMap);
      a.b.hjf().gJ(str2);
      paramMap = (Map<String, Object>)localObject1;
      continue;
      label428:
      if (localJSONArray2.length() > 0)
      {
        i.aoU(j).cQ(0, localJSONArray2.toString());
        continue;
        continue;
        label455:
        i += 1;
      }
    }
  }
  
  public final boolean bi(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77882);
    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchSnsImageList");
    Object localObject1 = ai.aa(paramMap, "data");
    int j = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
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
          localObject1 = ((o)com.tencent.mm.kernel.h.ae(o.class)).Xk((String)localObject2);
          if (((TimeLineObject)localObject1).ContentObj.Sqr.size() <= k) {
            break label494;
          }
          localObject2 = (cvt)((TimeLineObject)localObject1).ContentObj.Sqr.get(k);
          localObject1 = new ww();
          ((ww)localObject1).fVS.fvK = 3;
          ((ww)localObject1).fVS.mediaId = ((cvt)localObject2).Id;
          EventCenter.instance.publish((IEvent)localObject1);
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "generatePath: %s", new Object[] { ((ww)localObject1).fVS.path });
          if (u.agG(((ww)localObject1).fVS.path))
          {
            localObject1 = "weixin://fts/sns?path=" + u.n(((ww)localObject1).fVS.path, false);
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
          synchronized (this.PKj)
          {
            if (this.PKj.containsKey(((cvt)localObject2).Id))
            {
              localObject1 = (HashSet)this.PKj.get(((cvt)localObject2).Id);
              ((HashSet)localObject1).add(str);
              this.PKj.put(((cvt)localObject2).Id, localObject1);
              this.PKl.put(((cvt)localObject2).Id, Integer.valueOf(j));
              localObject1 = new ww();
              ((ww)localObject1).fVS.fvK = 1;
              ((ww)localObject1).fVS.fVT = ((cvt)localObject2);
              EventCenter.instance.publish((IEvent)localObject1);
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
      i.aoU(j).cQ(0, localJSONArray2.toString());
      continue;
      label494:
      i += 1;
    }
  }
  
  public final boolean bj(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77883);
    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchImageList");
    i = ai.b(paramMap, "requestType", 0);
    Object localObject1 = ai.aa(paramMap, "data");
    int j = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
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
            localObject5 = new gy();
            ((gy)localObject5).fDw.fvK = 3;
            ((gy)localObject5).fDw.md5 = ((JSONObject)localObject1).optString("md5");
            ((gy)localObject5).fDw.fDy = ((JSONObject)localObject1).optString("designerId");
            ((gy)localObject5).fDw.aeskey = ((JSONObject)localObject1).optString("aesKey");
            ((gy)localObject5).fDw.fDz = ((JSONObject)localObject1).optString("encryptUrl");
            ((gy)localObject5).fDw.productId = ((JSONObject)localObject1).optString("productID");
            ((gy)localObject5).fDw.name = ((JSONObject)localObject1).optString("express");
            ((gy)localObject5).fDw.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            EventCenter.instance.publish((IEvent)localObject5);
            if (u.agG(((gy)localObject5).fDx.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + ((gy)localObject5).fDx.path;
              Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "path=%s", new Object[] { ((gy)localObject5).fDx.path });
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
              synchronized (this.PBw)
              {
                if (this.PBw.containsKey(((gy)localObject5).fDw.md5))
                {
                  localObject1 = (HashSet)this.PBw.get(((gy)localObject5).fDw.md5);
                  ((HashSet)localObject1).add(localObject4);
                  this.PBw.put(((gy)localObject5).fDw.md5, localObject1);
                  this.PKm.put(((gy)localObject5).fDw.md5, Integer.valueOf(j));
                  ((gy)localObject5).fDw.fvK = 1;
                  EventCenter.instance.publish((IEvent)localObject5);
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
        i.aoU(j).cQ(0, ((JSONArray)localObject3).toString());
        continue;
        i.aoU(j).cQ(0, ((JSONArray)localObject1).toString());
      }
    }
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(77884);
    if ((paramMStorageEventData == null) || (paramMStorageEventData.obj == null))
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
      synchronized (this.PBx)
      {
        Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "event %s，eventData %s", new Object[] { paramString, paramMStorageEventData.toString() });
        paramString = paramMStorageEventData.obj.toString();
        if ((this.PBx.containsKey(paramString)) && (this.PKk.containsKey(paramString)))
        {
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "notify avatar changed %s", new Object[] { paramString });
          i = ((Integer)this.PKk.get(paramString)).intValue();
          Object localObject = new HashSet((HashSet)this.PBx.get(paramString));
          paramMStorageEventData = new JSONArray();
          localObject = ((HashSet)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            q.bhz();
            str2 = "weixin://fts/avatar?path=".concat(String.valueOf(f.O(paramString, false)));
            localJSONObject = new JSONObject();
          }
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label222:
        paramMStorageEventData.put(localJSONObject);
        continue;
        paramString = finally;
        AppMethodBeat.o(77884);
        throw paramString;
        i.aoU(i).cQ(0, paramMStorageEventData.toString());
        this.PBx.remove(paramString);
        this.PKk.remove(paramString);
        AppMethodBeat.o(77884);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label222;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b
 * JD-Core Version:    0.7.0.1
 */