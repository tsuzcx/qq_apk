package com.tencent.mm.plugin.sns.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import org.json.JSONObject;

public final class c
{
  public static void a(p paramp, int paramInt, y paramy)
  {
    AppMethodBeat.i(197738);
    if (paramp == null)
    {
      ad.e("HalfScreenSubscribeUtils", "reportSubscribe snsInfo==null or reportInfo==null, scene = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(197738);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempId", paramy.zwN);
      localJSONObject2.put("weausername", paramy.zNt);
      localJSONObject2.put("clickSubmitBtn", paramy.zNu);
      localJSONObject2.put("subscribeResult", paramy.zNv);
      if (paramInt == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramy = bt.nullAsNil(paramp.dYT());
        localJSONObject1.put("extInfo", localJSONObject2);
        localJSONObject1.put("uxinfo", paramy);
        localJSONObject1.put("snsid", paramp.field_snsId);
        localJSONObject1.put("scene", paramInt);
        paramp = localJSONObject1.toString();
        j.jf("timeline_subscription_message", paramp);
        ad.i("HalfScreenSubscribeUtils", "reportSubscribe timeline_subscription_message, content=".concat(String.valueOf(paramp)));
        AppMethodBeat.o(197738);
        return;
      }
      return;
    }
    catch (Exception paramp)
    {
      ad.e("HalfScreenSubscribeUtils", "reportSubscribe exp:" + paramp.toString());
      AppMethodBeat.o(197738);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.c
 * JD-Core Version:    0.7.0.1
 */