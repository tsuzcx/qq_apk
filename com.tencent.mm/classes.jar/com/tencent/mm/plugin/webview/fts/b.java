package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.hj;
import com.tencent.mm.autogen.a.hj.a;
import com.tencent.mm.autogen.a.hj.b;
import com.tencent.mm.autogen.a.yp;
import com.tencent.mm.autogen.a.yp.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.sns.c.p;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.y;
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
  public IListener QoU;
  private volatile HashMap<String, Integer> WAA;
  public IListener<hj> WAB;
  private volatile HashMap<String, HashSet<String>> WAx;
  private volatile HashMap<String, Integer> WAy;
  private volatile HashMap<String, Integer> WAz;
  private volatile HashMap<String, HashSet<String>> WrT;
  private volatile HashMap<String, HashSet<String>> WrU;
  
  public b()
  {
    AppMethodBeat.i(77880);
    this.WAB = new FTSWebViewImageLogic.1(this, f.hfK);
    this.QoU = new FTSWebViewImageLogic.2(this, f.hfK);
    this.WrU = new HashMap();
    this.WAx = new HashMap();
    this.WAy = new HashMap();
    this.WAz = new HashMap();
    this.WrT = new HashMap();
    this.WAA = new HashMap();
    this.QoU.alive();
    this.WAB.alive();
    q.bFE().add(this);
    AppMethodBeat.o(77880);
  }
  
  public final boolean bA(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77881);
    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchAvatarList");
    Object localObject1 = aj.au(paramMap, "data");
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
          q.bFp();
          paramMap = AvatarStorage.R(str2, false);
          if (!y.ZC(paramMap)) {
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(j).dG(-1, "");
        AppMethodBeat.o(77881);
        return false;
      }
      paramMap = new com.tencent.mm.modelavatar.j();
      paramMap.username = str2;
      paramMap.osN = str3;
      paramMap.osM = ((String)localObject2);
      paramMap.eQp = -1;
      paramMap.jZY = 3;
      paramMap.gX(true);
      q.bFE().b(paramMap);
      continue;
      Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file not exist %s", new Object[] { paramMap });
      this.WAy.put(str2, Integer.valueOf(j));
      Object localObject2 = (HashSet)this.WrU.get(str2);
      paramMap = (Map<String, Object>)localObject2;
      if (localObject2 == null) {
        paramMap = new HashSet();
      }
      paramMap.add(str1);
      this.WrU.put(str2, paramMap);
      a.b.iKa().loadBitmap(str2);
      paramMap = (Map<String, Object>)localObject1;
      continue;
      label428:
      if (localJSONArray2.length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(j).dG(0, localJSONArray2.toString());
        continue;
        continue;
        label455:
        i += 1;
      }
    }
  }
  
  public final boolean bB(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77882);
    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchSnsImageList");
    Object localObject1 = aj.au(paramMap, "data");
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
          localObject1 = ((p)h.ax(p.class)).Pm((String)localObject2);
          if (((TimeLineObject)localObject1).ContentObj.Zpr.size() <= k) {
            break label488;
          }
          localObject2 = (dmz)((TimeLineObject)localObject1).ContentObj.Zpr.get(k);
          localObject1 = new yp();
          ((yp)localObject1).ibS.hAf = 3;
          ((yp)localObject1).ibS.mediaId = ((dmz)localObject2).Id;
          ((yp)localObject1).publish();
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "generatePath: %s", new Object[] { ((yp)localObject1).ibS.path });
          if (y.ZC(((yp)localObject1).ibS.path))
          {
            localObject1 = "weixin://fts/sns?path=" + y.n(((yp)localObject1).ibS.path, false);
            paramMap = (Map<String, Object>)localObject1;
            if (localObject1 == null) {
              break label488;
            }
            paramMap = new JSONObject();
            paramMap.put("id", str);
            paramMap.put("src", localObject1);
            localJSONArray2.put(paramMap);
            paramMap = null;
            break label488;
          }
          synchronized (this.WAx)
          {
            if (this.WAx.containsKey(((dmz)localObject2).Id))
            {
              localObject1 = (HashSet)this.WAx.get(((dmz)localObject2).Id);
              ((HashSet)localObject1).add(str);
              this.WAx.put(((dmz)localObject2).Id, localObject1);
              this.WAz.put(((dmz)localObject2).Id, Integer.valueOf(j));
              localObject1 = new yp();
              ((yp)localObject1).ibS.hAf = 1;
              ((yp)localObject1).ibS.ibT = ((dmz)localObject2);
              ((yp)localObject1).publish();
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
      com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(j).dG(0, localJSONArray2.toString());
      continue;
      label488:
      i += 1;
    }
  }
  
  public final boolean bC(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77883);
    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchImageList");
    i = aj.c(paramMap, "requestType", 0);
    Object localObject1 = aj.au(paramMap, "data");
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
            localObject5 = new hj();
            ((hj)localObject5).hIm.hAf = 3;
            ((hj)localObject5).hIm.md5 = ((JSONObject)localObject1).optString("md5");
            ((hj)localObject5).hIm.hIo = ((JSONObject)localObject1).optString("designerId");
            ((hj)localObject5).hIm.aeskey = ((JSONObject)localObject1).optString("aesKey");
            ((hj)localObject5).hIm.hIp = ((JSONObject)localObject1).optString("encryptUrl");
            ((hj)localObject5).hIm.productId = ((JSONObject)localObject1).optString("productID");
            ((hj)localObject5).hIm.name = ((JSONObject)localObject1).optString("express");
            ((hj)localObject5).hIm.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            ((hj)localObject5).publish();
            if (y.ZC(((hj)localObject5).hIn.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + ((hj)localObject5).hIn.path;
              Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "path=%s", new Object[] { ((hj)localObject5).hIn.path });
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
              synchronized (this.WrT)
              {
                if (this.WrT.containsKey(((hj)localObject5).hIm.md5))
                {
                  localObject1 = (HashSet)this.WrT.get(((hj)localObject5).hIm.md5);
                  ((HashSet)localObject1).add(localObject4);
                  this.WrT.put(((hj)localObject5).hIm.md5, localObject1);
                  this.WAA.put(((hj)localObject5).hIm.md5, Integer.valueOf(j));
                  ((hj)localObject5).hIm.hAf = 1;
                  ((hj)localObject5).publish();
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
      break label811;
      if (((JSONArray)localObject3).length() > 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(j).dG(0, ((JSONArray)localObject3).toString());
        continue;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(j).dG(0, ((JSONArray)localObject1).toString());
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
      synchronized (this.WrU)
      {
        Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "event %s，eventData %s", new Object[] { paramString, paramMStorageEventData.toString() });
        paramString = paramMStorageEventData.obj.toString();
        if ((this.WrU.containsKey(paramString)) && (this.WAy.containsKey(paramString)))
        {
          Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "notify avatar changed %s", new Object[] { paramString });
          i = ((Integer)this.WAy.get(paramString)).intValue();
          Object localObject = new HashSet((HashSet)this.WrU.get(paramString));
          paramMStorageEventData = new JSONArray();
          localObject = ((HashSet)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            q.bFp();
            str2 = "weixin://fts/avatar?path=".concat(String.valueOf(AvatarStorage.R(paramString, false)));
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(i).dG(0, paramMStorageEventData.toString());
        this.WrU.remove(paramString);
        this.WAy.remove(paramString);
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