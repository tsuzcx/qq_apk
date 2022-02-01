package com.tencent.mm.plugin.sns.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class c
{
  public static void a(final int paramInt, final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(306307);
    if ((TextUtils.isEmpty(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(306307);
      return;
    }
    Log.d("HalfScreenSubscribeUtils", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    k.a(paramString, false, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(306316);
        try
        {
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              c.this.setImageBitmap(paramAnonymousString);
              c.this.setTag(paramInt, paramString);
              Log.d("HalfScreenSubscribeUtils", "onDownloaded succ, hash=" + c.this.hashCode());
              AppMethodBeat.o(306316);
              return;
            }
            Log.e("HalfScreenSubscribeUtils", "onDownloaded, bitmap==null");
            AppMethodBeat.o(306316);
            return;
          }
        }
        finally
        {
          Log.e("HalfScreenSubscribeUtils", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(306316);
          return;
        }
        Log.d("HalfScreenSubscribeUtils", "onDownloaded, url changed");
        AppMethodBeat.o(306316);
      }
      
      public final void gZM() {}
      
      public final void gZN()
      {
        AppMethodBeat.i(306315);
        c.this.setTag(paramInt, "");
        Log.e("HalfScreenSubscribeUtils", "onDownloadError, hash=" + c.this.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(306315);
      }
    });
    AppMethodBeat.o(306307);
  }
  
  public static void a(SnsInfo paramSnsInfo, int paramInt, aj paramaj)
  {
    AppMethodBeat.i(306310);
    if (paramSnsInfo == null)
    {
      Log.e("HalfScreenSubscribeUtils", "reportSubscribe snsInfo==null or reportInfo==null, scene = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(306310);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempId", paramaj.PLp);
      localJSONObject2.put("weausername", paramaj.QZD);
      localJSONObject2.put("clickSubmitBtn", paramaj.QZE);
      localJSONObject2.put("subscribeResult", paramaj.QZF);
      if (paramInt == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramaj = Util.nullAsNil(paramSnsInfo.getUxinfo());
        localJSONObject1.put("extInfo", localJSONObject2);
        localJSONObject1.put("uxinfo", paramaj);
        localJSONObject1.put("snsid", paramSnsInfo.field_snsId);
        localJSONObject1.put("scene", paramInt);
        paramSnsInfo = localJSONObject1.toString();
        m.lU("timeline_subscription_message", paramSnsInfo);
        Log.i("HalfScreenSubscribeUtils", "reportSubscribe timeline_subscription_message, content=".concat(String.valueOf(paramSnsInfo)));
        AppMethodBeat.o(306310);
        return;
      }
      return;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("HalfScreenSubscribeUtils", "reportSubscribe exp:" + paramSnsInfo.toString());
      AppMethodBeat.o(306310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.c
 * JD-Core Version:    0.7.0.1
 */