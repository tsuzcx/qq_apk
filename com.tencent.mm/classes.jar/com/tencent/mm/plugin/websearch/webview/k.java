package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hj;
import com.tencent.mm.autogen.a.hj.a;
import com.tencent.mm.autogen.a.hj.b;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData;", "T", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchData;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;)V", "TAG", "", "avatarIdMap", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "emojiImgMap", "ftsEmojiDownloadedListener", "com/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1;", "destroy", "", "getImageUIComponent", "getSearchAvatarList", "data", "getSearchImageList", "requestType", "", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public class k<T>
  extends a<T>
  implements MStorage.IOnStorageChange
{
  private final String TAG;
  private final HashMap<String, HashSet<String>> WrT;
  private final HashMap<String, HashSet<String>> WrU;
  private final WebSearchImageData.ftsEmojiDownloadedListener.1 WrV;
  
  public k(d<T> paramd)
  {
    super((f)paramd);
    AppMethodBeat.i(315238);
    this.TAG = "MicroMsg.WebSearch.WebSearchImageData";
    this.WrT = new HashMap();
    this.WrU = new HashMap();
    this.WrV = new WebSearchImageData.ftsEmojiDownloadedListener.1(this, com.tencent.mm.app.f.hfK);
    this.WrV.alive();
    q.bFE().add((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(315238);
  }
  
  public final void biL(String paramString)
  {
    AppMethodBeat.i(315304);
    s.u(paramString, "data");
    Log.i(this.TAG, "getSearchAvatarList");
    for (;;)
    {
      int i;
      int k;
      int j;
      Object localObject2;
      String str1;
      String str2;
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramString);
        JSONArray localJSONArray1 = new JSONArray();
        i = 0;
        k = localJSONArray2.length();
        if (k > 0)
        {
          paramString = null;
          j = i + 1;
          localObject2 = localJSONArray2.getJSONObject(i);
          str1 = ((JSONObject)localObject2).optString("id");
          str2 = ((JSONObject)localObject2).optString("userName");
          i = ((JSONObject)localObject2).optInt("type");
          localObject1 = ((JSONObject)localObject2).optString("imageUrl");
          localObject2 = ((JSONObject)localObject2).optString("bigImageUrl");
        }
        switch (i)
        {
        case 1: 
          label156:
          q.bFp();
          localObject1 = AvatarStorage.R(str2, false);
          if (!y.ZC((String)localObject1)) {
            break label600;
          }
          Log.i(this.TAG, "avatar file exist %s", new Object[] { localObject1 });
          paramString = s.X("weixin://fts/avatar?path=", localObject1);
          localObject1 = paramString;
          if (paramString == null) {
            break label734;
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("id", str1);
          ((JSONObject)localObject1).put("src", paramString);
          localJSONArray1.put(localObject1);
          localObject1 = null;
          break label734;
          if (localJSONArray1.length() <= 0) {
            continue;
          }
          paramString = iqS();
          if (paramString == null) {
            continue;
          }
          paramString = paramString.fyT();
          if (paramString == null) {
            continue;
          }
          localObject1 = localJSONArray1.toString();
          s.s(localObject1, "returnArray.toString()");
          paramString.dG(0, (String)localObject1);
          AppMethodBeat.o(315304);
          return;
        }
      }
      catch (Exception paramString)
      {
        j localj;
        localObject1 = iqS();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((d)localObject1).fyT();
        if (localObject1 == null) {
          continue;
        }
        ((l)localObject1).dG(-1, "");
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(315304);
        return;
      }
      paramString = (String)localObject1;
      continue;
      localj = new j();
      localj.username = str2;
      localj.osN = ((String)localObject2);
      localj.osM = ((String)localObject1);
      localj.eQp = -1;
      localj.jZY = 3;
      localj.gX(true);
      q.bFE().b(localj);
      q.bFp();
      Object localObject1 = AvatarStorage.R(str2, false);
      if (y.ZC((String)localObject1))
      {
        Log.i(this.TAG, "avatar file exist %s", new Object[] { localObject1 });
        paramString = s.X("weixin://fts/avatar?path=", localObject1);
      }
      else
      {
        Log.i(this.TAG, "avatar file not exist %s", new Object[] { localObject1 });
        localObject1 = (HashSet)this.WrU.get(str2);
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            localObject1 = (k)this;
            localObject2 = new HashSet();
            ((HashSet)localObject2).add(str1);
            ((k)localObject1).WrU.put(str2, localObject2);
          }
          a.b.iKa().loadBitmap(str2);
        }
        else
        {
          ((HashSet)localObject1).add(str1);
          localObject1 = (HashSet)this.WrU.put(str2, localObject1);
          continue;
          label600:
          Log.i(this.TAG, "avatar file not exist %s", new Object[] { localObject1 });
          localObject1 = (HashSet)this.WrU.get(str2);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = (HashSet)this.WrU.put(str2, localObject1))
          {
            if (localObject1 == null)
            {
              localObject1 = (k)this;
              localObject2 = new HashSet();
              ((HashSet)localObject2).add(str1);
              ((k)localObject1).WrU.put(str2, localObject2);
            }
            a.b.iKa().loadBitmap(str2);
            break;
            ((HashSet)localObject1).add(str1);
          }
          label734:
          do
          {
            i = j;
            paramString = (String)localObject1;
            break;
            break label156;
          } while (j < k);
        }
      }
    }
  }
  
  public final void dF(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(315319);
    s.u(paramString, "data");
    boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    if (paramInt == 1) {}
    for (;;)
    {
      Object localObject4;
      Object localObject3;
      Object localObject1;
      String str;
      Object localObject2;
      try
      {
        localObject4 = new JSONArray(paramString);
        localObject3 = new JSONArray();
        paramInt = 0;
        paramString = null;
        if (paramInt >= ((JSONArray)localObject4).length()) {
          break label626;
        }
        localObject1 = ((JSONArray)localObject4).getJSONObject(paramInt);
        i = ((JSONObject)localObject1).optInt("emojiType");
        str = ((JSONObject)localObject1).optString("id");
        switch (i)
        {
        case 3: 
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("id", str);
          ((JSONObject)localObject2).put("src", ((JSONObject)localObject1).optString("imageUrl"));
          ((JSONArray)localObject3).put(localObject2);
        }
      }
      catch (Exception paramString)
      {
        hj localhj;
        AppMethodBeat.o(315319);
        return;
      }
      localhj = new hj();
      localhj.hIm.hAf = 3;
      localhj.hIm.md5 = ((JSONObject)localObject1).optString("md5");
      localhj.hIm.hIo = ((JSONObject)localObject1).optString("designerId");
      localhj.hIm.aeskey = ((JSONObject)localObject1).optString("aesKey");
      localhj.hIm.hIp = ((JSONObject)localObject1).optString("encryptUrl");
      localhj.hIm.productId = ((JSONObject)localObject1).optString("productID");
      localhj.hIm.name = ((JSONObject)localObject1).optString("express");
      localhj.hIm.thumbUrl = ((JSONObject)localObject1).optString("imageUrl");
      localhj.publish();
      if (y.ZC(localhj.hIn.path))
      {
        localObject1 = s.X("weixin://fts/emoji?path=", localhj.hIn.path);
        Log.i(this.TAG, "path=%s", new Object[] { localhj.hIn.path });
        paramString = (String)localObject1;
        if (localObject1 != null)
        {
          paramString = new JSONObject();
          paramString.put("id", str);
          paramString.put("src", localObject1);
          ((JSONArray)localObject3).put(paramString);
          paramString = null;
        }
      }
      else
      {
        if (bool) {
          synchronized (this.WrT)
          {
            if (this.WrT.containsKey(localhj.hIm.md5))
            {
              localObject2 = (HashSet)this.WrT.get(localhj.hIm.md5);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = new HashSet();
              }
              ((HashSet)localObject1).add(str);
              this.WrT.put(localhj.hIm.md5, localObject1);
              localhj.hIm.hAf = 1;
              localhj.publish();
              localObject1 = paramString;
              continue;
            }
            localObject1 = new HashSet();
          }
        }
        localObject1 = ((JSONObject)localObject1).optString("imageUrl");
        continue;
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("id", str);
        if (bool) {
          ((JSONObject)localObject2).put("src", ((JSONObject)localObject1).optString("raw"));
        }
        for (;;)
        {
          ((JSONArray)localObject3).put(localObject2);
          break;
          ((JSONObject)localObject2).put("src", ((JSONObject)localObject1).optString("imageUrl"));
        }
        label626:
        if (((JSONArray)localObject3).length() > 0)
        {
          paramString = iqS();
          if (paramString != null)
          {
            paramString = paramString.fyT();
            if (paramString != null)
            {
              localObject1 = ((JSONArray)localObject3).toString();
              s.s(localObject1, "returnArray.toString()");
              paramString.dG(0, (String)localObject1);
              AppMethodBeat.o(315319);
              return;
              try
              {
                localObject1 = new JSONArray(paramString);
                paramString = new JSONArray();
                paramInt = i;
                while (paramInt < ((JSONArray)localObject1).length())
                {
                  localObject4 = ((JSONArray)localObject1).getJSONObject(paramInt);
                  localObject2 = new JSONObject();
                  localObject3 = ((JSONObject)localObject4).getString("id");
                  localObject4 = ((JSONObject)localObject4).getString("imageUrl");
                  ((JSONObject)localObject2).put("id", localObject3);
                  ((JSONObject)localObject2).put("src", localObject4);
                  paramString.put(localObject2);
                  paramInt += 1;
                }
                localObject1 = iqS();
                if (localObject1 != null)
                {
                  localObject1 = ((d)localObject1).fyT();
                  if (localObject1 != null)
                  {
                    paramString = paramString.toString();
                    s.s(paramString, "returnArray.toString()");
                    ((l)localObject1).dG(0, paramString);
                    AppMethodBeat.o(315319);
                    return;
                  }
                }
              }
              catch (JSONException paramString) {}
            }
          }
        }
        AppMethodBeat.o(315319);
        return;
        continue;
      }
      paramInt += 1;
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(315269);
    super.destroy();
    this.WrV.dead();
    q.bFE().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(315269);
  }
  
  public final d<T> iqS()
  {
    f localf = this.WrK;
    if ((localf instanceof d)) {
      return (d)localf;
    }
    return null;
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(315326);
    for (;;)
    {
      Object localObject;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (this.WrU)
      {
        Log.i(this.TAG, "event %s，eventData %s", new Object[] { paramString, String.valueOf(paramMStorageEventData) });
        if (paramMStorageEventData == null)
        {
          paramString = "";
          if (!this.WrU.containsKey(paramString)) {
            break label285;
          }
          Log.i(this.TAG, "notify avatar changed %s", new Object[] { paramString });
          paramMStorageEventData = new JSONArray();
          localObject = (HashSet)this.WrU.get(paramString);
          if (localObject == null) {
            break label233;
          }
          localObject = ((Iterable)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label233;
          }
          str1 = (String)((Iterator)localObject).next();
          q.bFp();
          str2 = s.X("weixin://fts/avatar?path=", AvatarStorage.R(paramString, false));
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label180:
        paramMStorageEventData.put(localJSONObject);
        continue;
        paramString = finally;
        AppMethodBeat.o(315326);
        throw paramString;
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = "";
        }
        else
        {
          paramString = paramString.toString();
          if (paramString == null)
          {
            paramString = "";
            continue;
            label233:
            localObject = iqS();
            if (localObject != null)
            {
              localObject = ((d)localObject).fyT();
              if (localObject != null)
              {
                paramMStorageEventData = paramMStorageEventData.toString();
                s.s(paramMStorageEventData, "returnArray.toString()");
                ((l)localObject).dG(0, paramMStorageEventData);
              }
            }
            this.WrU.remove(paramString);
            label285:
            paramString = ah.aiuX;
            AppMethodBeat.o(315326);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        break label180;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.k
 * JD-Core Version:    0.7.0.1
 */