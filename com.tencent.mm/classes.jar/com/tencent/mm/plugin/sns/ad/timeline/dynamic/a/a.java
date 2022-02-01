package com.tencent.mm.plugin.sns.ad.timeline.dynamic.a;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.c;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bx;
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
    AppMethodBeat.i(202082);
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(202082);
  }
  
  private static com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a aYF(String paramString)
  {
    AppMethodBeat.i(202103);
    try
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a locala = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a();
      paramString = new JSONObject(paramString);
      if (paramString.has("relationText")) {
        locala.Jyk = paramString.getString("relationText");
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
          localb.avatar = localJSONObject.optString("avatar");
          localb.nickname = localJSONObject.optString("nickname");
          localb.tag = localJSONObject.optString("tag");
          localb.desc = localJSONObject.optString("desc");
          localb.Jyn = localJSONObject.optString("barBgColor");
          localb.Jyp = localJSONObject.optString("duration");
          localJSONObject = localJSONObject.optJSONObject("imageInfo");
          if (localJSONObject != null)
          {
            localb.JHQ = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a();
            localb.JHQ.JHP = localJSONObject.optString("mid", "");
            localb.JHQ.url = localJSONObject.optString("url", "");
            localb.JHQ.fQv = localJSONObject.optString("thumb");
            localb.JHQ.width = localJSONObject.optInt("width", 0);
            localb.JHQ.height = localJSONObject.optInt("height", 0);
            localb.JHQ.cjr = localJSONObject.optInt("totalSize", 0);
          }
          locala.JHO.add(localb);
          i += 1;
        }
      }
      Log.d("SnsAd.TopicCardRequestAction", "the parse result takes " + (System.currentTimeMillis() - l) + "ms");
      AppMethodBeat.o(202103);
      return locala;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(202103);
    }
    return null;
  }
  
  public final void c(int paramInt, String paramString, List<bx> paramList)
  {
    AppMethodBeat.i(202094);
    if (paramInt == 0) {}
    try
    {
      if ((TextUtils.isEmpty(paramString)) || (d.isEmpty(paramList)))
      {
        Log.w("SnsAd.TopicCardRequestAction", "the data is empty, or request failed!!! Do nothing!!");
        AppMethodBeat.o(202094);
        return;
      }
      Log.d("SnsAd.TopicCardRequestAction", "the response snsId is ".concat(String.valueOf(paramString)));
      paramList = (bx)paramList.get(0);
      if ((paramList != null) && (paramList.tpK == 3) && (!TextUtils.isEmpty(paramList.data)))
      {
        paramList = aYF(paramList.data);
        if ((paramList != null) && (this.mActivityRef != null))
        {
          Log.d("SnsAd.TopicCardRequestAction", "TopicCardResponseModel : ".concat(String.valueOf(paramList)));
          Object localObject = RequestListenerManager.aL((Activity)this.mActivityRef.get());
          if (localObject != null)
          {
            localObject = ((RequestListenerManager)localObject).JHN;
            if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
            {
              localObject = (WeakReference)((com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.b)localObject).lyH.get(paramString);
              if (localObject != null)
              {
                localObject = (com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a)((WeakReference)localObject).get();
                if (localObject != null) {
                  ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a)localObject).z(paramString, paramList);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(202094);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202094);
    }
  }
  
  public final void m(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202089);
    if ((paramSnsInfo != null) && (paramSnsInfo.getAdXml() != null)) {
      try
      {
        String str = t.Qu(paramSnsInfo.field_snsId);
        Object localObject = paramSnsInfo.getAdInfo(0);
        if ((localObject != null) && (TextUtils.isEmpty(((ADInfo)localObject).uxInfo))) {}
        for (localObject = ((ADInfo)localObject).uxInfo;; localObject = paramSnsInfo.getUxinfo())
        {
          paramSnsInfo.getAdXml();
          paramSnsInfo = new bx();
          paramSnsInfo.tpK = 3;
          paramSnsInfo.data = "";
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            break;
          }
          Log.w("SnsAd.TopicCardRequestAction", "are you sure input param is valid???");
          AppMethodBeat.o(202089);
          return;
        }
        new c(str, (String)localObject, new bx[] { paramSnsInfo }).a(this);
        AppMethodBeat.o(202089);
        return;
      }
      catch (Throwable paramSnsInfo) {}
    }
    AppMethodBeat.o(202089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a
 * JD-Core Version:    0.7.0.1
 */