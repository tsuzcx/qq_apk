package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.f.a.gy;
import com.tencent.mm.f.a.gy.a;
import com.tencent.mm.f.a.gy.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData;", "T", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchData;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;)V", "TAG", "", "avatarIdMap", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "emojiImgMap", "ftsEmojiDownloadedListener", "com/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1;", "destroy", "", "getImageUIComponent", "getSearchAvatarList", "data", "getSearchImageList", "requestType", "", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ui-websearch_release"})
public class g<T>
  extends a<T>
  implements MStorage.IOnStorageChange
{
  private final HashMap<String, HashSet<String>> PBw;
  private final HashMap<String, HashSet<String>> PBx;
  private final a PBy;
  private final String TAG;
  
  public g(c<T> paramc)
  {
    super((d)paramc);
    AppMethodBeat.i(198396);
    this.TAG = "MicroMsg.WebSearch.WebSearchImageData";
    this.PBw = new HashMap();
    this.PBx = new HashMap();
    this.PBy = new a(this);
    this.PBy.alive();
    q.bhP().add((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(198396);
  }
  
  public final void bjc(String paramString)
  {
    AppMethodBeat.i(198363);
    p.k(paramString, "data");
    Log.i(this.TAG, "getSearchAvatarList");
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramString);
        JSONArray localJSONArray1 = new JSONArray();
        localObject1 = null;
        int j = localJSONArray2.length();
        i = 0;
        String str1;
        String str2;
        int k;
        Object localObject2;
        String str3;
        if (i < j)
        {
          paramString = localJSONArray2.getJSONObject(i);
          str1 = paramString.optString("id");
          str2 = paramString.optString("userName");
          k = paramString.optInt("type");
          localObject2 = paramString.optString("imageUrl");
          str3 = paramString.optString("bigImageUrl");
          paramString = (String)localObject2;
        }
        switch (k)
        {
        case 1: 
          q.bhz();
          paramString = f.TG(str2);
          if (u.agG(paramString))
          {
            Log.i(this.TAG, "avatar file exist %s", new Object[] { paramString });
            paramString = "weixin://fts/avatar?path=".concat(String.valueOf(paramString));
          }
        case 4: 
        case 64: 
          localObject1 = paramString;
          if (paramString == null) {
            break label675;
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("id", str1);
          ((JSONObject)localObject1).put("src", paramString);
          localJSONArray1.put(localObject1);
          localObject1 = null;
          break;
        case 32: 
          paramString = new j();
          paramString.setUsername(str2);
          paramString.TQ(str3);
          paramString.TR((String)localObject2);
          paramString.bhF();
          paramString.bhG();
          paramString.gg(true);
          q.bhP().b(paramString);
          q.bhz();
          paramString = f.TG(str2);
          if (u.agG(paramString))
          {
            Log.i(this.TAG, "avatar file exist %s", new Object[] { paramString });
            paramString = "weixin://fts/avatar?path=".concat(String.valueOf(paramString));
            continue;
          }
          Log.i(this.TAG, "avatar file not exist %s", new Object[] { paramString });
          paramString = (HashSet)this.PBx.get(str2);
          if (paramString != null)
          {
            paramString.add(str1);
            if ((HashSet)this.PBx.put(str2, paramString) != null) {}
          }
          else
          {
            paramString = (g)this;
            localObject2 = new HashSet();
            ((HashSet)localObject2).add(str1);
            paramString.PBx.put(str2, localObject2);
          }
          a.b.hjf().gJ(str2);
          paramString = (String)localObject1;
          continue;
          Log.i(this.TAG, "avatar file not exist %s", new Object[] { paramString });
          paramString = (HashSet)this.PBx.get(str2);
          if (paramString != null)
          {
            paramString.add(str1);
            if ((HashSet)this.PBx.put(str2, paramString) != null) {}
          }
          else
          {
            paramString = (g)this;
            localObject2 = new HashSet();
            ((HashSet)localObject2).add(str1);
            paramString.PBx.put(str2, localObject2);
          }
          a.b.hjf().gJ(str2);
          paramString = (String)localObject1;
          continue;
          if (localJSONArray1.length() > 0)
          {
            paramString = gRD();
            if (paramString != null)
            {
              paramString = paramString.esI();
              if (paramString != null)
              {
                localObject1 = localJSONArray1.toString();
                p.j(localObject1, "returnArray.toString()");
                paramString.cQ(0, (String)localObject1);
                AppMethodBeat.o(198363);
                return;
              }
            }
            AppMethodBeat.o(198363);
            return;
          }
          break;
        }
      }
      catch (Exception paramString)
      {
        Object localObject1 = gRD();
        if (localObject1 != null)
        {
          localObject1 = ((c)localObject1).esI();
          if (localObject1 != null) {
            ((h)localObject1).cQ(-1, "");
          }
        }
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(198363);
        return;
      }
      continue;
      label675:
      i += 1;
    }
  }
  
  public final void cP(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(198379);
    p.k(paramString, "data");
    boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONArray(paramString);
        paramString = new JSONArray();
        paramInt = i;
        if (paramInt < ((JSONArray)localObject1).length())
        {
          Object localObject4 = ((JSONArray)localObject1).getJSONObject(paramInt);
          Object localObject2 = new JSONObject();
          Object localObject3 = ((JSONObject)localObject4).getString("id");
          localObject4 = ((JSONObject)localObject4).getString("imageUrl");
          ((JSONObject)localObject2).put("id", localObject3);
          ((JSONObject)localObject2).put("src", localObject4);
          paramString.put(localObject2);
          paramInt += 1;
          continue;
          String str;
          try
          {
            localObject4 = new JSONArray(paramString);
            localObject3 = new JSONArray();
            paramInt = 0;
            paramString = null;
            if (paramInt >= ((JSONArray)localObject4).length()) {
              continue;
            }
            localObject1 = ((JSONArray)localObject4).getJSONObject(paramInt);
            i = ((JSONObject)localObject1).optInt("emojiType");
            str = ((JSONObject)localObject1).optString("id");
            if (i != 2) {
              continue;
            }
            gy localgy = new gy();
            localgy.fDw.fvK = 3;
            localgy.fDw.md5 = ((JSONObject)localObject1).optString("md5");
            localgy.fDw.fDy = ((JSONObject)localObject1).optString("designerId");
            localgy.fDw.aeskey = ((JSONObject)localObject1).optString("aesKey");
            localgy.fDw.fDz = ((JSONObject)localObject1).optString("encryptUrl");
            localgy.fDw.productId = ((JSONObject)localObject1).optString("productID");
            localgy.fDw.name = ((JSONObject)localObject1).optString("express");
            localgy.fDw.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            EventCenter.instance.publish((IEvent)localgy);
            if (u.agG(localgy.fDx.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + localgy.fDx.path;
              Log.i(this.TAG, "path=%s", new Object[] { localgy.fDx.path });
              paramString = (String)localObject1;
              if (localObject1 == null) {
                break label880;
              }
              paramString = new JSONObject();
              paramString.put("id", str);
              paramString.put("src", localObject1);
              ((JSONArray)localObject3).put(paramString);
              paramString = null;
              break label880;
            }
            if (bool) {
              synchronized (this.PBw)
              {
                if (this.PBw.containsKey(localgy.fDw.md5))
                {
                  localObject2 = (HashSet)this.PBw.get(localgy.fDw.md5);
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new HashSet();
                  }
                  p.j(localObject1, "if (emojiImgMap.contains…                        }");
                  ((HashSet)localObject1).add(str);
                  this.PBw.put(localgy.fDw.md5, localObject1);
                  localgy.fDw.fvK = 1;
                  EventCenter.instance.publish((IEvent)localgy);
                  localObject1 = paramString;
                  continue;
                }
                localObject1 = new HashSet();
              }
            }
            localObject1 = ((JSONObject)localObject1).optString("imageUrl");
          }
          catch (Exception paramString)
          {
            AppMethodBeat.o(198379);
            return;
          }
          continue;
          if (i == 4)
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("id", str);
            if (bool)
            {
              ((JSONObject)localObject2).put("src", ((JSONObject)localObject1).optString("raw"));
              ((JSONArray)localObject3).put(localObject2);
              break label880;
            }
            ((JSONObject)localObject2).put("src", ((JSONObject)localObject1).optString("imageUrl"));
            continue;
          }
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("id", str);
          ((JSONObject)localObject2).put("src", ((JSONObject)localObject1).optString("imageUrl"));
          ((JSONArray)localObject3).put(localObject2);
          break label880;
          if (((JSONArray)localObject3).length() > 0)
          {
            paramString = gRD();
            if (paramString != null)
            {
              paramString = paramString.esI();
              if (paramString != null)
              {
                localObject1 = ((JSONArray)localObject3).toString();
                p.j(localObject1, "returnArray.toString()");
                paramString.cQ(0, (String)localObject1);
                AppMethodBeat.o(198379);
                return;
              }
            }
            AppMethodBeat.o(198379);
          }
        }
        else
        {
          localObject1 = gRD();
          if (localObject1 == null) {
            break label873;
          }
          localObject1 = ((c)localObject1).esI();
          if (localObject1 == null) {
            break label873;
          }
          paramString = paramString.toString();
          p.j(paramString, "returnArray.toString()");
          ((h)localObject1).cQ(0, paramString);
          AppMethodBeat.o(198379);
          return;
        }
      }
      catch (JSONException paramString)
      {
        AppMethodBeat.o(198379);
        return;
      }
      label873:
      AppMethodBeat.o(198379);
      return;
      label880:
      paramInt += 1;
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(198341);
    super.destroy();
    this.PBy.dead();
    q.bhP().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(198341);
  }
  
  public final c<T> gRD()
  {
    d locald2 = this.PBs;
    d locald1 = locald2;
    if (!(locald2 instanceof c)) {
      locald1 = null;
    }
    return (c)locald1;
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(198390);
    for (;;)
    {
      Object localObject;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (this.PBx)
      {
        Log.i(this.TAG, "event %s，eventData %s", new Object[] { paramString, String.valueOf(paramMStorageEventData) });
        if (paramMStorageEventData == null) {
          break label294;
        }
        paramString = paramMStorageEventData.obj;
        if (paramString == null) {
          break label294;
        }
        paramString = paramString.toString();
        if (paramString != null) {
          break label291;
        }
        break label294;
        if (this.PBx.containsKey(paramString))
        {
          Log.i(this.TAG, "notify avatar changed %s", new Object[] { paramString });
          paramMStorageEventData = new JSONArray();
          localObject = (HashSet)this.PBx.get(paramString);
          if (localObject != null)
          {
            localObject = ((Iterable)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              q.bhz();
              str2 = "weixin://fts/avatar?path=".concat(String.valueOf(f.TG(paramString)));
              localJSONObject = new JSONObject();
            }
          }
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label199:
        paramMStorageEventData.put(localJSONObject);
        continue;
        paramString = finally;
        AppMethodBeat.o(198390);
        throw paramString;
        localObject = gRD();
        if (localObject != null)
        {
          localObject = ((c)localObject).esI();
          if (localObject != null)
          {
            paramMStorageEventData = paramMStorageEventData.toString();
            p.j(paramMStorageEventData, "returnArray.toString()");
            ((h)localObject).cQ(0, paramMStorageEventData);
          }
        }
        this.PBx.remove(paramString);
        paramString = x.aazN;
        AppMethodBeat.o(198390);
        return;
      }
      catch (Exception localException)
      {
        break label199;
      }
      label291:
      continue;
      label294:
      paramString = "";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FTSEmojiDownloadedEvent;", "callback", "", "event", "ui-websearch_release"})
  public static final class a
    extends IListener<gy>
  {
    private boolean a(gy paramgy)
    {
      AppMethodBeat.i(198565);
      if ((paramgy != null) && (paramgy.fDw.fvK == 2))
      {
        Log.i(g.a(this.PBz), "emoji download callback %s", new Object[] { paramgy.fDw.md5 });
        if (!g.b(this.PBz).containsKey(paramgy.fDw.md5)) {}
      }
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        String str1;
        String str2;
        JSONObject localJSONObject;
        synchronized (g.b(this.PBz))
        {
          localObject2 = (HashSet)g.b(this.PBz).get(paramgy.fDw.md5);
          localObject1 = new JSONArray();
          if (localObject2 == null) {
            p.iCn();
          }
          localObject2 = ((HashSet)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            str1 = (String)((Iterator)localObject2).next();
            str2 = "weixin://fts/emoji?path=" + paramgy.fDx.path;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("id", str1);
          localJSONObject.put("src", str2);
          label196:
          ((JSONArray)localObject1).put(localJSONObject);
          continue;
          paramgy = finally;
          AppMethodBeat.o(198565);
          throw paramgy;
          localObject2 = this.PBz.gRD();
          if (localObject2 != null)
          {
            localObject2 = ((c)localObject2).esI();
            if (localObject2 != null)
            {
              localObject1 = ((JSONArray)localObject1).toString();
              p.j(localObject1, "returnArray.toString()");
              ((h)localObject2).cQ(0, (String)localObject1);
            }
          }
          g.b(this.PBz).remove(paramgy.fDw.md5);
          AppMethodBeat.o(198565);
          return false;
        }
        catch (JSONException localJSONException)
        {
          break label196;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.g
 * JD-Core Version:    0.7.0.1
 */