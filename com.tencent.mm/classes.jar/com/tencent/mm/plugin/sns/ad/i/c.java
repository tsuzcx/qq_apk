package com.tencent.mm.plugin.sns.ad.i;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static Drawable a(Resources paramResources, String paramString)
  {
    AppMethodBeat.i(248946);
    try
    {
      Bitmap localBitmap = BitmapUtil.decodeFile(paramString, null);
      if (localBitmap != null)
      {
        paramResources = new BitmapDrawable(paramResources, localBitmap);
        AppMethodBeat.o(248946);
        return paramResources;
      }
      Log.e("SnsAd.AdImageLoader", "getDrawableFromFile bitmap==null, path=".concat(String.valueOf(paramString)));
    }
    catch (Throwable paramResources)
    {
      for (;;)
      {
        Log.e("SnsAd.AdImageLoader", "getDrawableFromFile exp=" + paramResources.toString() + ", path=" + paramString);
      }
    }
    AppMethodBeat.o(248946);
    return null;
  }
  
  public static void a(final String paramString, ImageView paramImageView, final float paramFloat)
  {
    AppMethodBeat.i(293078);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(293078);
      return;
    }
    Log.d("SnsAd.AdImageLoader", "loadImageByCdn, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(i.f.sns_ad_card_img_url, paramString);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", paramString, new f.a()
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(194007);
        try
        {
          Log.d("SnsAd.AdImageLoader", "loadImageByCdn, succ, hash=" + this.kOW.hashCode() + ", url=" + paramString);
          c.e(this.kOW, paramAnonymousString, paramFloat);
          AppMethodBeat.o(194007);
          return;
        }
        catch (Throwable paramAnonymousString)
        {
          Log.e("SnsAd.AdImageLoader", "loadImageByCdn, onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(194007);
        }
      }
      
      public final void fJU() {}
      
      public final void fJV()
      {
        AppMethodBeat.i(194002);
        this.kOW.setTag(i.f.sns_ad_card_img_url, "");
        Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + this.kOW.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(194002);
      }
    });
    AppMethodBeat.o(293078);
  }
  
  public static void a(String paramString, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(248940);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(248940);
      return;
    }
    try
    {
      if (!paramString.equals((String)paramImageView.getTag(i.f.sns_ad_card_img_url))) {
        b(paramString, paramImageView, paramInt);
      }
      AppMethodBeat.o(248940);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(248940);
    }
  }
  
  private static void b(final String paramString, final ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(248944);
    if ((TextUtils.isEmpty(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(248944);
      return;
    }
    Log.d("SnsAd.AdImageLoader", "loadImageEx, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(i.f.sns_ad_card_img_url, paramString);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString, false, new f.a()
    {
      boolean started = false;
      
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(252672);
        c.e(paramImageView, paramAnonymousString, 0.0F);
        try
        {
          if (this.started) {
            m.jC(this.iWM, 0);
          }
          AppMethodBeat.o(252672);
          return;
        }
        catch (Throwable paramAnonymousString)
        {
          AppMethodBeat.o(252672);
        }
      }
      
      public final void fJU()
      {
        this.started = true;
      }
      
      public final void fJV()
      {
        AppMethodBeat.i(252670);
        try
        {
          m.jC(this.iWM, 1);
          paramImageView.setTag(i.f.sns_ad_card_img_url, "");
          paramImageView.setImageDrawable(null);
          label33:
          Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + paramImageView.hashCode() + ", url=" + paramString);
          AppMethodBeat.o(252670);
          return;
        }
        catch (Throwable localThrowable)
        {
          break label33;
        }
      }
    });
    AppMethodBeat.o(248944);
  }
  
  public static void l(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(248939);
    if (!paramString.equals((String)paramImageView.getTag(i.f.sns_ad_card_img_url)))
    {
      paramImageView.setImageDrawable(null);
      loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(248939);
  }
  
  public static void loadImage(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(248942);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(248942);
      return;
    }
    Log.d("SnsAd.AdImageLoader", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(i.f.sns_ad_card_img_url, paramString);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString, false, new f.a()
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(252473);
        try
        {
          String str = (String)this.kOW.getTag(i.f.sns_ad_card_img_url);
          if (TextUtils.isEmpty(str)) {
            str = "";
          }
          while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              this.kOW.setImageBitmap(paramAnonymousString);
              Log.d("SnsAd.AdImageLoader", "onDownloaded succ, hash=" + this.kOW.hashCode());
              AppMethodBeat.o(252473);
              return;
              str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", str);
            }
            else
            {
              Log.e("SnsAd.AdImageLoader", "onDownloaded, bitmap==null");
              AppMethodBeat.o(252473);
              return;
            }
          }
        }
        catch (Throwable paramAnonymousString)
        {
          Log.e("SnsAd.AdImageLoader", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(252473);
          return;
        }
        Log.d("SnsAd.AdImageLoader", "onDownloaded, url changed");
        AppMethodBeat.o(252473);
      }
      
      public final void fJU() {}
      
      public final void fJV()
      {
        AppMethodBeat.i(252471);
        this.kOW.setTag(i.f.sns_ad_card_img_url, "");
        Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + this.kOW.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(252471);
      }
    });
    AppMethodBeat.o(248942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.c
 * JD-Core Version:    0.7.0.1
 */