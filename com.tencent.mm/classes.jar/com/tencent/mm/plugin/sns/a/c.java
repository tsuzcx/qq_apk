package com.tencent.mm.plugin.sns.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
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
  public static void a(final int paramInt, final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(200551);
    if ((TextUtils.isEmpty(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(200551);
      return;
    }
    Log.d("HalfScreenSubscribeUtils", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    h.a(paramString, false, new f.a()
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(264359);
        try
        {
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              this.kOW.setImageBitmap(paramAnonymousString);
              this.kOW.setTag(paramInt, paramString);
              Log.d("HalfScreenSubscribeUtils", "onDownloaded succ, hash=" + this.kOW.hashCode());
              AppMethodBeat.o(264359);
              return;
            }
            Log.e("HalfScreenSubscribeUtils", "onDownloaded, bitmap==null");
            AppMethodBeat.o(264359);
            return;
          }
        }
        catch (Throwable paramAnonymousString)
        {
          Log.e("HalfScreenSubscribeUtils", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(264359);
          return;
        }
        Log.d("HalfScreenSubscribeUtils", "onDownloaded, url changed");
        AppMethodBeat.o(264359);
      }
      
      public final void fJU() {}
      
      public final void fJV()
      {
        AppMethodBeat.i(264358);
        this.kOW.setTag(paramInt, "");
        Log.e("HalfScreenSubscribeUtils", "onDownloadError, hash=" + this.kOW.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(264358);
      }
    });
    AppMethodBeat.o(200551);
  }
  
  public static void a(SnsInfo paramSnsInfo, int paramInt, z paramz)
  {
    AppMethodBeat.i(200557);
    if (paramSnsInfo == null)
    {
      Log.e("HalfScreenSubscribeUtils", "reportSubscribe snsInfo==null or reportInfo==null, scene = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(200557);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempId", paramz.JxA);
      localJSONObject2.put("weausername", paramz.KAe);
      localJSONObject2.put("clickSubmitBtn", paramz.KAf);
      localJSONObject2.put("subscribeResult", paramz.KAg);
      if (paramInt == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramz = Util.nullAsNil(paramSnsInfo.getUxinfo());
        localJSONObject1.put("extInfo", localJSONObject2);
        localJSONObject1.put("uxinfo", paramz);
        localJSONObject1.put("snsid", paramSnsInfo.field_snsId);
        localJSONObject1.put("scene", paramInt);
        paramSnsInfo = localJSONObject1.toString();
        m.ks("timeline_subscription_message", paramSnsInfo);
        Log.i("HalfScreenSubscribeUtils", "reportSubscribe timeline_subscription_message, content=".concat(String.valueOf(paramSnsInfo)));
        AppMethodBeat.o(200557);
        return;
      }
      return;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("HalfScreenSubscribeUtils", "reportSubscribe exp:" + paramSnsInfo.toString());
      AppMethodBeat.o(200557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.c
 * JD-Core Version:    0.7.0.1
 */