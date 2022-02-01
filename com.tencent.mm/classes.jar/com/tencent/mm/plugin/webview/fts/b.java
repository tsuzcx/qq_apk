package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.gr.a;
import com.tencent.mm.g.a.gr.b;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.g.a.vr.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.s;
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
  public IListener DFm;
  private volatile HashMap<String, HashSet<String>> IHg;
  private volatile HashMap<String, HashSet<String>> IHh;
  private volatile HashMap<String, HashSet<String>> INR;
  private volatile HashMap<String, Integer> INS;
  private volatile HashMap<String, Integer> INU;
  private volatile HashMap<String, Integer> INV;
  public IListener<gr> INW;
  
  public b()
  {
    AppMethodBeat.i(77880);
    this.INW = new IListener()
    {
      private boolean a(gr paramAnonymousgr)
      {
        AppMethodBeat.i(77876);
        if (paramAnonymousgr.dKH.dDe == 2)
        {
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[] { paramAnonymousgr.dKH.md5 });
          if (!b.a(b.this).containsKey(paramAnonymousgr.dKH.md5)) {}
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
            i = ((Integer)b.b(b.this).get(paramAnonymousgr.dKH.md5)).intValue();
            Object localObject = (HashSet)b.a(b.this).get(paramAnonymousgr.dKH.md5);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/emoji?path=" + paramAnonymousgr.dKI.path;
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
            paramAnonymousgr = finally;
            AppMethodBeat.o(77876);
            throw paramAnonymousgr;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i).cQ(0, localJSONArray.toString());
            b.a(b.this).remove(paramAnonymousgr.dKH.md5);
            b.b(b.this).remove(paramAnonymousgr.dKH.md5);
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
    this.DFm = new IListener()
    {
      private boolean a(vr paramAnonymousvr)
      {
        AppMethodBeat.i(77878);
        if (((paramAnonymousvr instanceof vr)) && (paramAnonymousvr.ebQ.dDe == 2))
        {
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Download callback %s", new Object[] { paramAnonymousvr.ebQ.mediaId });
          if (!b.c(b.this).containsKey(paramAnonymousvr.ebQ.mediaId)) {}
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
            i = ((Integer)b.d(b.this).get(paramAnonymousvr.ebQ.mediaId)).intValue();
            Object localObject = (HashSet)b.c(b.this).get(paramAnonymousvr.ebQ.mediaId);
            localJSONArray = new JSONArray();
            localObject = ((HashSet)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              str2 = "weixin://fts/sns?path=" + s.k(paramAnonymousvr.ebQ.path, false);
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
            paramAnonymousvr = finally;
            AppMethodBeat.o(77878);
            throw paramAnonymousvr;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i).cQ(0, localJSONArray.toString());
            b.c(b.this).remove(paramAnonymousvr.ebQ.mediaId);
            b.d(b.this).remove(paramAnonymousvr.ebQ.mediaId);
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
    this.IHh = new HashMap();
    this.INR = new HashMap();
    this.INS = new HashMap();
    this.INU = new HashMap();
    this.IHg = new HashMap();
    this.INV = new HashMap();
    this.DFm.alive();
    this.INW.alive();
    p.aYB().add(this);
    AppMethodBeat.o(77880);
  }
  
  public final boolean bl(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77881);
    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchAvatarList");
    Object localObject1 = ai.N(paramMap, "data");
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
          p.aYn();
          paramMap = e.M(str2, false);
          if (!s.YS(paramMap)) {
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(j).cQ(-1, "");
        AppMethodBeat.o(77881);
        return false;
      }
      paramMap = new i();
      paramMap.username = str2;
      paramMap.iKX = str3;
      paramMap.iKW = ((String)localObject2);
      paramMap.cSx = -1;
      paramMap.fuz = 3;
      paramMap.fv(true);
      p.aYB().b(paramMap);
      continue;
      Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file not exist %s", new Object[] { paramMap });
      this.INS.put(str2, Integer.valueOf(j));
      Object localObject2 = (HashSet)this.IHh.get(str2);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject2 == null) {
        paramMap = new HashSet();
      }
      paramMap.add(str1);
      this.IHh.put(str2, paramMap);
      a.b.gov().fZ(str2);
      paramMap = (Map<String, Object>)localObject1;
      continue;
      label428:
      if (localJSONArray2.length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(j).cQ(0, localJSONArray2.toString());
        continue;
        continue;
        label455:
        i += 1;
      }
    }
  }
  
  public final boolean bm(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77882);
    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchSnsImageList");
    Object localObject1 = ai.N(paramMap, "data");
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
          localObject1 = ((n)com.tencent.mm.kernel.g.af(n.class)).PM((String)localObject2);
          if (((TimeLineObject)localObject1).ContentObj.LoV.size() <= k) {
            break label494;
          }
          localObject2 = (cnb)((TimeLineObject)localObject1).ContentObj.LoV.get(k);
          localObject1 = new vr();
          ((vr)localObject1).ebQ.dDe = 3;
          ((vr)localObject1).ebQ.mediaId = ((cnb)localObject2).Id;
          EventCenter.instance.publish((IEvent)localObject1);
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "generatePath: %s", new Object[] { ((vr)localObject1).ebQ.path });
          if (s.YS(((vr)localObject1).ebQ.path))
          {
            localObject1 = "weixin://fts/sns?path=" + s.k(((vr)localObject1).ebQ.path, false);
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
          synchronized (this.INR)
          {
            if (this.INR.containsKey(((cnb)localObject2).Id))
            {
              localObject1 = (HashSet)this.INR.get(((cnb)localObject2).Id);
              ((HashSet)localObject1).add(str);
              this.INR.put(((cnb)localObject2).Id, localObject1);
              this.INU.put(((cnb)localObject2).Id, Integer.valueOf(j));
              localObject1 = new vr();
              ((vr)localObject1).ebQ.dDe = 1;
              ((vr)localObject1).ebQ.ebR = ((cnb)localObject2);
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
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(j).cQ(0, localJSONArray2.toString());
      continue;
      label494:
      i += 1;
    }
  }
  
  public final boolean bn(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77883);
    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchImageList");
    i = ai.b(paramMap, "requestType", 0);
    Object localObject1 = ai.N(paramMap, "data");
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
            localObject5 = new gr();
            ((gr)localObject5).dKH.dDe = 3;
            ((gr)localObject5).dKH.md5 = ((JSONObject)localObject1).optString("md5");
            ((gr)localObject5).dKH.dKJ = ((JSONObject)localObject1).optString("designerId");
            ((gr)localObject5).dKH.aeskey = ((JSONObject)localObject1).optString("aesKey");
            ((gr)localObject5).dKH.dKK = ((JSONObject)localObject1).optString("encryptUrl");
            ((gr)localObject5).dKH.productId = ((JSONObject)localObject1).optString("productID");
            ((gr)localObject5).dKH.name = ((JSONObject)localObject1).optString("express");
            ((gr)localObject5).dKH.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            EventCenter.instance.publish((IEvent)localObject5);
            if (s.YS(((gr)localObject5).dKI.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + ((gr)localObject5).dKI.path;
              Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "path=%s", new Object[] { ((gr)localObject5).dKI.path });
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
              synchronized (this.IHg)
              {
                if (this.IHg.containsKey(((gr)localObject5).dKH.md5))
                {
                  localObject1 = (HashSet)this.IHg.get(((gr)localObject5).dKH.md5);
                  ((HashSet)localObject1).add(localObject4);
                  this.IHg.put(((gr)localObject5).dKH.md5, localObject1);
                  this.INV.put(((gr)localObject5).dKH.md5, Integer.valueOf(j));
                  ((gr)localObject5).dKH.dDe = 1;
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(j).cQ(0, ((JSONArray)localObject3).toString());
        continue;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(j).cQ(0, ((JSONArray)localObject1).toString());
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
      synchronized (this.IHh)
      {
        Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "event %s，eventData %s", new Object[] { paramString, paramMStorageEventData.toString() });
        paramString = paramMStorageEventData.obj.toString();
        if ((this.IHh.containsKey(paramString)) && (this.INS.containsKey(paramString)))
        {
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "notify avatar changed %s", new Object[] { paramString });
          i = ((Integer)this.INS.get(paramString)).intValue();
          Object localObject = new HashSet((HashSet)this.IHh.get(paramString));
          paramMStorageEventData = new JSONArray();
          localObject = ((HashSet)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            p.aYn();
            str2 = "weixin://fts/avatar?path=".concat(String.valueOf(e.M(paramString, false)));
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i).cQ(0, paramMStorageEventData.toString());
        this.IHh.remove(paramString);
        this.INS.remove(paramString);
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