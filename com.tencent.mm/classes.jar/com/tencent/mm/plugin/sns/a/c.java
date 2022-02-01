package com.tencent.mm.plugin.sns.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class c
{
  public static void a(p paramp, int paramInt, y paramy)
  {
    AppMethodBeat.i(219211);
    if (paramp == null)
    {
      ae.e("HalfScreenSubscribeUtils", "reportSubscribe snsInfo==null or reportInfo==null, scene = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(219211);
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempId", paramy.zOm);
      localJSONObject2.put("weausername", paramy.AeA);
      localJSONObject2.put("clickSubmitBtn", paramy.AeB);
      localJSONObject2.put("subscribeResult", paramy.AeC);
      if (paramInt == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramy = bu.nullAsNil(paramp.ecx());
        localJSONObject1.put("extInfo", localJSONObject2);
        localJSONObject1.put("uxinfo", paramy);
        localJSONObject1.put("snsid", paramp.field_snsId);
        localJSONObject1.put("scene", paramInt);
        paramp = localJSONObject1.toString();
        k.jm("timeline_subscription_message", paramp);
        ae.i("HalfScreenSubscribeUtils", "reportSubscribe timeline_subscription_message, content=".concat(String.valueOf(paramp)));
        AppMethodBeat.o(219211);
        return;
      }
      return;
    }
    catch (Exception paramp)
    {
      ae.e("HalfScreenSubscribeUtils", "reportSubscribe exp:" + paramp.toString());
      AppMethodBeat.o(219211);
    }
  }
  
  public static void j(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(219210);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(219210);
      return;
    }
    ae.d("HalfScreenSubscribeUtils", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString, false, new f.a()
    {
      public final void ayY(String paramAnonymousString)
      {
        AppMethodBeat.i(219209);
        try
        {
          if (!bu.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              this.tCz.setImageBitmap(paramAnonymousString);
              this.tCz.setTag(this.zst, paramString);
              ae.d("HalfScreenSubscribeUtils", "onDownloaded succ, hash=" + this.tCz.hashCode());
              AppMethodBeat.o(219209);
              return;
            }
            ae.e("HalfScreenSubscribeUtils", "onDownloaded, bitmap==null");
            AppMethodBeat.o(219209);
            return;
          }
        }
        catch (Throwable paramAnonymousString)
        {
          ae.e("HalfScreenSubscribeUtils", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(219209);
          return;
        }
        ae.d("HalfScreenSubscribeUtils", "onDownloaded, url changed");
        AppMethodBeat.o(219209);
      }
      
      public final void dVu() {}
      
      public final void dVv()
      {
        AppMethodBeat.i(219208);
        this.tCz.setTag(this.zst, "");
        ae.e("HalfScreenSubscribeUtils", "onDownloadError, hash=" + this.tCz.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(219208);
      }
    });
    AppMethodBeat.o(219210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.c
 * JD-Core Version:    0.7.0.1
 */