package com.tencent.mm.plugin.sns.ad.timeline.dynamic.a;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a, com.tencent.mm.plugin.sns.ad.timeline.dynamic.b
{
  private final WeakReference<Activity> mActivityRef;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(202140);
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(202140);
  }
  
  private static com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a aNP(String paramString)
  {
    AppMethodBeat.i(202143);
    try
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a locala = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a();
      paramString = new JSONObject(paramString);
      if (paramString.has("relationText")) {
        locala.DrQ = paramString.getString("relationText");
      }
      paramString = paramString.optJSONArray("finderTopicResList");
      if (paramString != null)
      {
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          a.b localb = new a.b();
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          localb.uNR = localJSONObject.optString("avatar");
          localb.nickname = localJSONObject.optString("nickname");
          localb.tag = localJSONObject.optString("tag");
          localb.desc = localJSONObject.optString("desc");
          localb.DrT = localJSONObject.optString("barBgColor");
          localb.DrV = localJSONObject.optString("duration");
          localJSONObject = localJSONObject.optJSONObject("imageInfo");
          if (localJSONObject != null)
          {
            localb.DxW = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a();
            localb.DxW.wQO = localJSONObject.optString("mid", "");
            localb.DxW.url = localJSONObject.optString("url", "");
            localb.DxW.dWJ = localJSONObject.optString("thumb");
            localb.DxW.width = localJSONObject.optInt("width", 0);
            localb.DxW.height = localJSONObject.optInt("height", 0);
            localb.DxW.cnR = localJSONObject.optInt("totalSize", 0);
          }
          locala.DxV.add(localb);
          i += 1;
        }
      }
      Log.d("SnsAd.TopicCardRequestAction", "the parse result takes " + (System.currentTimeMillis() - l) + "ms");
      AppMethodBeat.o(202143);
      return locala;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(202143);
    }
    return null;
  }
  
  public final void c(int paramInt, String paramString, List<bz> paramList)
  {
    AppMethodBeat.i(202142);
    if (paramInt == 0) {}
    try
    {
      if ((TextUtils.isEmpty(paramString)) || (com.tencent.mm.plugin.sns.ad.i.c.isEmpty(paramList)))
      {
        Log.w("SnsAd.TopicCardRequestAction", "the data is empty, or request failed!!! Do nothing!!");
        AppMethodBeat.o(202142);
        return;
      }
      Log.d("SnsAd.TopicCardRequestAction", "the response snsId is ".concat(String.valueOf(paramString)));
      paramList = (bz)paramList.get(0);
      if ((paramList != null) && (paramList.pTI == 3) && (!TextUtils.isEmpty(paramList.data)))
      {
        paramList = aNP(paramList.data);
        if ((paramList != null) && (this.mActivityRef != null))
        {
          Log.d("SnsAd.TopicCardRequestAction", "TopicCardResponseModel : ".concat(String.valueOf(paramList)));
          Object localObject = RequestListenerManager.aF((Activity)this.mActivityRef.get());
          if (localObject != null)
          {
            localObject = ((RequestListenerManager)localObject).DxU;
            if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
            {
              localObject = (WeakReference)((com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.b)localObject).iIE.get(paramString);
              if (localObject != null)
              {
                localObject = (com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a)((WeakReference)localObject).get();
                if (localObject != null) {
                  ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a)localObject).A(paramString, paramList);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(202142);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202142);
    }
  }
  
  public final void m(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202141);
    if ((paramSnsInfo != null) && (paramSnsInfo.getAdXml() != null)) {
      try
      {
        String str = r.Jb(paramSnsInfo.field_snsId);
        Object localObject = paramSnsInfo.getAdInfo(0);
        if ((localObject != null) && (TextUtils.isEmpty(((ADInfo)localObject).uxInfo))) {}
        for (localObject = ((ADInfo)localObject).uxInfo;; localObject = paramSnsInfo.getUxinfo())
        {
          paramSnsInfo.getAdXml();
          paramSnsInfo = new bz();
          paramSnsInfo.pTI = 3;
          paramSnsInfo.data = "";
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            break;
          }
          Log.w("SnsAd.TopicCardRequestAction", "are you sure input param is valid???");
          AppMethodBeat.o(202141);
          return;
        }
        new com.tencent.mm.plugin.sns.ad.h.c(str, (String)localObject, new bz[] { paramSnsInfo }).a(this);
        AppMethodBeat.o(202141);
        return;
      }
      catch (Throwable paramSnsInfo) {}
    }
    AppMethodBeat.o(202141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a
 * JD-Core Version:    0.7.0.1
 */