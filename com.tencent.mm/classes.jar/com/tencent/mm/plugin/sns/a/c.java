package com.tencent.mm.plugin.sns.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class c
{
  public static void a(SnsInfo paramSnsInfo, int paramInt, z paramz)
  {
    AppMethodBeat.i(202558);
    if (paramSnsInfo == null)
    {
      Log.e("HalfScreenSubscribeUtils", "reportSubscribe snsInfo==null or reportInfo==null, scene = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(202558);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempId", paramz.tempId);
      localJSONObject2.put("weausername", paramz.EmV);
      localJSONObject2.put("clickSubmitBtn", paramz.EmW);
      localJSONObject2.put("subscribeResult", paramz.EmX);
      if (paramInt == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramz = Util.nullAsNil(paramSnsInfo.getUxinfo());
        localJSONObject1.put("extInfo", localJSONObject2);
        localJSONObject1.put("uxinfo", paramz);
        localJSONObject1.put("snsid", paramSnsInfo.field_snsId);
        localJSONObject1.put("scene", paramInt);
        paramSnsInfo = localJSONObject1.toString();
        k.jY("timeline_subscription_message", paramSnsInfo);
        Log.i("HalfScreenSubscribeUtils", "reportSubscribe timeline_subscription_message, content=".concat(String.valueOf(paramSnsInfo)));
        AppMethodBeat.o(202558);
        return;
      }
      return;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("HalfScreenSubscribeUtils", "reportSubscribe exp:" + paramSnsInfo.toString());
      AppMethodBeat.o(202558);
    }
  }
  
  public static void k(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(202557);
    if ((TextUtils.isEmpty(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(202557);
      return;
    }
    Log.d("HalfScreenSubscribeUtils", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    h.a(paramString, false, new f.a()
    {
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(202556);
        try
        {
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              this.iaq.setImageBitmap(paramAnonymousString);
              this.iaq.setTag(this.DCK, paramString);
              Log.d("HalfScreenSubscribeUtils", "onDownloaded succ, hash=" + this.iaq.hashCode());
              AppMethodBeat.o(202556);
              return;
            }
            Log.e("HalfScreenSubscribeUtils", "onDownloaded, bitmap==null");
            AppMethodBeat.o(202556);
            return;
          }
        }
        catch (Throwable paramAnonymousString)
        {
          Log.e("HalfScreenSubscribeUtils", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(202556);
          return;
        }
        Log.d("HalfScreenSubscribeUtils", "onDownloaded, url changed");
        AppMethodBeat.o(202556);
      }
      
      public final void eWN() {}
      
      public final void eWO()
      {
        AppMethodBeat.i(202555);
        this.iaq.setTag(this.DCK, "");
        Log.e("HalfScreenSubscribeUtils", "onDownloadError, hash=" + this.iaq.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(202555);
      }
    });
    AppMethodBeat.o(202557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.c
 * JD-Core Version:    0.7.0.1
 */