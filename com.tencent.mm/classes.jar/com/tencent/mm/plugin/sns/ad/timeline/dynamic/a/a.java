package com.tencent.mm.plugin.sns.ad.timeline.dynamic.a;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.ch;
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
    AppMethodBeat.i(311053);
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(311053);
  }
  
  private static com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a aWJ(String paramString)
  {
    AppMethodBeat.i(311069);
    try
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a locala = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a();
      paramString = new JSONObject(paramString);
      if (paramString.has("relationText")) {
        locala.PME = paramString.getString("relationText");
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
          localb.PMH = localJSONObject.optString("barBgColor");
          localb.PMJ = localJSONObject.optString("duration");
          localJSONObject = localJSONObject.optJSONObject("imageInfo");
          if (localJSONObject != null)
          {
            localb.PYQ = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a();
            localb.PYQ.oOZ = localJSONObject.optString("mid", "");
            localb.PYQ.url = localJSONObject.optString("url", "");
            localb.PYQ.hWq = localJSONObject.optString("thumb");
            localb.PYQ.width = localJSONObject.optInt("width", 0);
            localb.PYQ.height = localJSONObject.optInt("height", 0);
            localb.PYQ.aes = localJSONObject.optInt("totalSize", 0);
          }
          locala.PYP.add(localb);
          i += 1;
        }
      }
      Log.d("SnsAd.TopicCardRequestAction", "the parse result takes " + (System.currentTimeMillis() - l) + "ms");
      AppMethodBeat.o(311069);
      return locala;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(311069);
    }
    return null;
  }
  
  public final void c(int paramInt, String paramString, List<ch> paramList)
  {
    AppMethodBeat.i(311094);
    if (paramInt == 0) {}
    try
    {
      if ((TextUtils.isEmpty(paramString)) || (com.tencent.mm.plugin.sns.ad.j.d.isEmpty(paramList)))
      {
        Log.w("SnsAd.TopicCardRequestAction", "the data is empty, or request failed!!! Do nothing!!");
        return;
      }
      Log.d("SnsAd.TopicCardRequestAction", "the response snsId is ".concat(String.valueOf(paramString)));
      paramList = (ch)paramList.get(0);
      if ((paramList != null) && (paramList.wuj == 3) && (!TextUtils.isEmpty(paramList.data)))
      {
        paramList = aWJ(paramList.data);
        if ((paramList != null) && (this.mActivityRef != null))
        {
          Log.d("SnsAd.TopicCardRequestAction", "TopicCardResponseModel : ".concat(String.valueOf(paramList)));
          Object localObject = RequestListenerManager.bn((Activity)this.mActivityRef.get());
          if (localObject != null)
          {
            localObject = ((RequestListenerManager)localObject).PYO;
            if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
            {
              localObject = (WeakReference)((com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.b)localObject).oqi.get(paramString);
              if (localObject != null)
              {
                localObject = (com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a)((WeakReference)localObject).get();
                if (localObject != null) {
                  ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a)localObject).L(paramString, paramList);
                }
              }
            }
          }
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311094);
    }
  }
  
  public final int hbC()
  {
    return 3;
  }
  
  public final void o(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311084);
    if ((paramSnsInfo != null) && (paramSnsInfo.getAdXml() != null)) {
      try
      {
        String str = t.uA(paramSnsInfo.field_snsId);
        Object localObject = paramSnsInfo.getAdInfo(0);
        if ((localObject != null) && (TextUtils.isEmpty(((ADInfo)localObject).uxInfo))) {}
        for (localObject = ((ADInfo)localObject).uxInfo;; localObject = paramSnsInfo.getUxinfo())
        {
          paramSnsInfo.getAdXml();
          paramSnsInfo = new ch();
          paramSnsInfo.wuj = 3;
          paramSnsInfo.data = "";
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            break;
          }
          Log.w("SnsAd.TopicCardRequestAction", "are you sure input param is valid???");
          AppMethodBeat.o(311084);
          return;
        }
        new com.tencent.mm.plugin.sns.ad.h.d(str, (String)localObject, new ch[] { paramSnsInfo }).a(this);
        AppMethodBeat.o(311084);
        return;
      }
      finally {}
    }
    AppMethodBeat.o(311084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a
 * JD-Core Version:    0.7.0.1
 */