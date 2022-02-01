package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.gr.a;
import com.tencent.mm.g.a.gr.b;
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
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData;", "T", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchData;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;)V", "TAG", "", "avatarIdMap", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "emojiImgMap", "ftsEmojiDownloadedListener", "com/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1;", "destroy", "", "getImageUIComponent", "getSearchAvatarList", "data", "getSearchImageList", "requestType", "", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ui-websearch_release"})
public class g<T>
  extends a<T>
  implements MStorage.IOnStorageChange
{
  private final HashMap<String, HashSet<String>> IHg;
  private final HashMap<String, HashSet<String>> IHh;
  private final a IHi;
  private final String TAG;
  
  public g(c<T> paramc)
  {
    super((d)paramc);
    AppMethodBeat.i(198069);
    this.TAG = "MicroMsg.WebSearch.WebSearchImageData";
    this.IHg = new HashMap();
    this.IHh = new HashMap();
    this.IHi = new a(this);
    this.IHi.alive();
    com.tencent.mm.aj.p.aYB().add((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(198069);
  }
  
  public final void aXr(String paramString)
  {
    AppMethodBeat.i(198066);
    kotlin.g.b.p.h(paramString, "data");
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
          com.tencent.mm.aj.p.aYn();
          paramString = e.Ml(str2);
          if (s.YS(paramString))
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
          paramString = new i();
          paramString.setUsername(str2);
          paramString.Mv(str3);
          paramString.Mw((String)localObject2);
          paramString.aYr();
          paramString.aYs();
          paramString.fv(true);
          com.tencent.mm.aj.p.aYB().b(paramString);
          com.tencent.mm.aj.p.aYn();
          paramString = e.Ml(str2);
          if (s.YS(paramString))
          {
            Log.i(this.TAG, "avatar file exist %s", new Object[] { paramString });
            paramString = "weixin://fts/avatar?path=".concat(String.valueOf(paramString));
            continue;
          }
          Log.i(this.TAG, "avatar file not exist %s", new Object[] { paramString });
          paramString = (HashSet)this.IHh.get(str2);
          if (paramString != null)
          {
            paramString.add(str1);
            if ((HashSet)this.IHh.put(str2, paramString) != null) {}
          }
          else
          {
            paramString = (g)this;
            localObject2 = new HashSet();
            ((HashSet)localObject2).add(str1);
            paramString.IHh.put(str2, localObject2);
          }
          a.b.gov().fZ(str2);
          paramString = (String)localObject1;
          continue;
          Log.i(this.TAG, "avatar file not exist %s", new Object[] { paramString });
          paramString = (HashSet)this.IHh.get(str2);
          if (paramString != null)
          {
            paramString.add(str1);
            if ((HashSet)this.IHh.put(str2, paramString) != null) {}
          }
          else
          {
            paramString = (g)this;
            localObject2 = new HashSet();
            ((HashSet)localObject2).add(str1);
            paramString.IHh.put(str2, localObject2);
          }
          a.b.gov().fZ(str2);
          paramString = (String)localObject1;
          continue;
          if (localJSONArray1.length() > 0)
          {
            paramString = fYS();
            if (paramString != null)
            {
              paramString = paramString.dQi();
              if (paramString != null)
              {
                localObject1 = localJSONArray1.toString();
                kotlin.g.b.p.g(localObject1, "returnArray.toString()");
                paramString.cQ(0, (String)localObject1);
                AppMethodBeat.o(198066);
                return;
              }
            }
            AppMethodBeat.o(198066);
            return;
          }
          break;
        }
      }
      catch (Exception paramString)
      {
        Object localObject1 = fYS();
        if (localObject1 != null)
        {
          localObject1 = ((c)localObject1).dQi();
          if (localObject1 != null) {
            ((h)localObject1).cQ(-1, "");
          }
        }
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(198066);
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
    AppMethodBeat.i(198067);
    kotlin.g.b.p.h(paramString, "data");
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
            gr localgr = new gr();
            localgr.dKH.dDe = 3;
            localgr.dKH.md5 = ((JSONObject)localObject1).optString("md5");
            localgr.dKH.dKJ = ((JSONObject)localObject1).optString("designerId");
            localgr.dKH.aeskey = ((JSONObject)localObject1).optString("aesKey");
            localgr.dKH.dKK = ((JSONObject)localObject1).optString("encryptUrl");
            localgr.dKH.productId = ((JSONObject)localObject1).optString("productID");
            localgr.dKH.name = ((JSONObject)localObject1).optString("express");
            localgr.dKH.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
            EventCenter.instance.publish((IEvent)localgr);
            if (s.YS(localgr.dKI.path))
            {
              localObject1 = "weixin://fts/emoji?path=" + localgr.dKI.path;
              Log.i(this.TAG, "path=%s", new Object[] { localgr.dKI.path });
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
              synchronized (this.IHg)
              {
                if (this.IHg.containsKey(localgr.dKH.md5))
                {
                  localObject2 = (HashSet)this.IHg.get(localgr.dKH.md5);
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new HashSet();
                  }
                  kotlin.g.b.p.g(localObject1, "if (emojiImgMap.contains…                        }");
                  ((HashSet)localObject1).add(str);
                  this.IHg.put(localgr.dKH.md5, localObject1);
                  localgr.dKH.dDe = 1;
                  EventCenter.instance.publish((IEvent)localgr);
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
            AppMethodBeat.o(198067);
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
            paramString = fYS();
            if (paramString != null)
            {
              paramString = paramString.dQi();
              if (paramString != null)
              {
                localObject1 = ((JSONArray)localObject3).toString();
                kotlin.g.b.p.g(localObject1, "returnArray.toString()");
                paramString.cQ(0, (String)localObject1);
                AppMethodBeat.o(198067);
                return;
              }
            }
            AppMethodBeat.o(198067);
          }
        }
        else
        {
          localObject1 = fYS();
          if (localObject1 == null) {
            break label873;
          }
          localObject1 = ((c)localObject1).dQi();
          if (localObject1 == null) {
            break label873;
          }
          paramString = paramString.toString();
          kotlin.g.b.p.g(paramString, "returnArray.toString()");
          ((h)localObject1).cQ(0, paramString);
          AppMethodBeat.o(198067);
          return;
        }
      }
      catch (JSONException paramString)
      {
        AppMethodBeat.o(198067);
        return;
      }
      label873:
      AppMethodBeat.o(198067);
      return;
      label880:
      paramInt += 1;
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(198065);
    super.destroy();
    this.IHi.dead();
    com.tencent.mm.aj.p.aYB().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(198065);
  }
  
  public final c<T> fYS()
  {
    d locald2 = this.IHe;
    d locald1 = locald2;
    if (!(locald2 instanceof c)) {
      locald1 = null;
    }
    return (c)locald1;
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(198068);
    for (;;)
    {
      Object localObject;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (this.IHh)
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
        if (this.IHh.containsKey(paramString))
        {
          Log.i(this.TAG, "notify avatar changed %s", new Object[] { paramString });
          paramMStorageEventData = new JSONArray();
          localObject = (HashSet)this.IHh.get(paramString);
          if (localObject != null)
          {
            localObject = ((Iterable)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              str1 = (String)((Iterator)localObject).next();
              com.tencent.mm.aj.p.aYn();
              str2 = "weixin://fts/avatar?path=".concat(String.valueOf(e.Ml(paramString)));
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
        AppMethodBeat.o(198068);
        throw paramString;
        localObject = fYS();
        if (localObject != null)
        {
          localObject = ((c)localObject).dQi();
          if (localObject != null)
          {
            paramMStorageEventData = paramMStorageEventData.toString();
            kotlin.g.b.p.g(paramMStorageEventData, "returnArray.toString()");
            ((h)localObject).cQ(0, paramMStorageEventData);
          }
        }
        this.IHh.remove(paramString);
        paramString = x.SXb;
        AppMethodBeat.o(198068);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FTSEmojiDownloadedEvent;", "callback", "", "event", "ui-websearch_release"})
  public static final class a
    extends IListener<gr>
  {
    private boolean a(gr paramgr)
    {
      AppMethodBeat.i(198063);
      if ((paramgr != null) && (paramgr.dKH.dDe == 2))
      {
        Log.i(g.a(this.IHj), "emoji download callback %s", new Object[] { paramgr.dKH.md5 });
        if (!g.b(this.IHj).containsKey(paramgr.dKH.md5)) {}
      }
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        String str1;
        String str2;
        JSONObject localJSONObject;
        synchronized (g.b(this.IHj))
        {
          localObject2 = (HashSet)g.b(this.IHj).get(paramgr.dKH.md5);
          localObject1 = new JSONArray();
          if (localObject2 == null) {
            kotlin.g.b.p.hyc();
          }
          localObject2 = ((HashSet)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            str1 = (String)((Iterator)localObject2).next();
            str2 = "weixin://fts/emoji?path=" + paramgr.dKI.path;
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
          paramgr = finally;
          AppMethodBeat.o(198063);
          throw paramgr;
          localObject2 = this.IHj.fYS();
          if (localObject2 != null)
          {
            localObject2 = ((c)localObject2).dQi();
            if (localObject2 != null)
            {
              localObject1 = ((JSONArray)localObject1).toString();
              kotlin.g.b.p.g(localObject1, "returnArray.toString()");
              ((h)localObject2).cQ(0, (String)localObject1);
            }
          }
          g.b(this.IHj).remove(paramgr.dKH.md5);
          AppMethodBeat.o(198063);
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