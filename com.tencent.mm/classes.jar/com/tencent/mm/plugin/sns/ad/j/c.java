package com.tencent.mm.plugin.sns.ad.j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.widget.gllib.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class c
{
  public static Drawable a(Resources paramResources, String paramString)
  {
    AppMethodBeat.i(309773);
    try
    {
      Bitmap localBitmap = BitmapUtil.decodeFile(paramString, null);
      if (localBitmap != null)
      {
        paramResources = new BitmapDrawable(paramResources, localBitmap);
        AppMethodBeat.o(309773);
        return paramResources;
      }
      Log.e("SnsAd.AdImageLoader", "getDrawableFromFile bitmap==null, path=".concat(String.valueOf(paramString)));
    }
    finally
    {
      for (;;)
      {
        Log.e("SnsAd.AdImageLoader", "getDrawableFromFile exp=" + paramResources.toString() + ", path=" + paramString);
      }
    }
    AppMethodBeat.o(309773);
    return null;
  }
  
  public static void a(final String paramString, ImageView paramImageView, final float paramFloat)
  {
    AppMethodBeat.i(309779);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(309779);
      return;
    }
    Log.d("SnsAd.AdImageLoader", "loadImageByCdn, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(b.f.sns_ad_card_img_url, paramString);
    k.b("adId", paramString, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(309811);
        try
        {
          Log.d("SnsAd.AdImageLoader", "loadImageByCdn, succ, hash=" + c.this.hashCode() + ", url=" + paramString);
          c.d(c.this, paramAnonymousString, paramFloat);
          AppMethodBeat.o(309811);
          return;
        }
        finally
        {
          Log.e("SnsAd.AdImageLoader", "loadImageByCdn, onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(309811);
        }
      }
      
      public final void gZM() {}
      
      public final void gZN()
      {
        AppMethodBeat.i(309804);
        c.this.setTag(b.f.sns_ad_card_img_url, "");
        Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + c.this.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(309804);
      }
    });
    AppMethodBeat.o(309779);
  }
  
  public static void b(String paramString, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(309749);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(309749);
      return;
    }
    try
    {
      if (!paramString.equals((String)paramImageView.getTag(b.f.sns_ad_card_img_url))) {
        c(paramString, paramImageView, paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(309749);
    }
  }
  
  private static void c(final String paramString, final ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(309767);
    if ((TextUtils.isEmpty(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(309767);
      return;
    }
    Log.d("SnsAd.AdImageLoader", "loadImageEx, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(b.f.sns_ad_card_img_url, paramString);
    k.a(paramString, false, new g.a()
    {
      boolean started = false;
      
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(309835);
        c.d(paramImageView, paramAnonymousString, 0.0F);
        try
        {
          if (this.started) {
            m.ln(this.lyQ, 0);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(309835);
        }
      }
      
      public final void gZM()
      {
        this.started = true;
      }
      
      public final void gZN()
      {
        AppMethodBeat.i(309824);
        try
        {
          m.ln(this.lyQ, 1);
          paramImageView.setTag(b.f.sns_ad_card_img_url, "");
          paramImageView.setImageDrawable(null);
          label33:
          Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + paramImageView.hashCode() + ", url=" + paramString);
          AppMethodBeat.o(309824);
          return;
        }
        finally
        {
          break label33;
        }
      }
    });
    AppMethodBeat.o(309767);
  }
  
  private static void loadImage(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(309756);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(309756);
      return;
    }
    Log.d("SnsAd.AdImageLoader", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(b.f.sns_ad_card_img_url, paramString);
    k.a(paramString, false, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(309821);
        try
        {
          String str = (String)c.this.getTag(b.f.sns_ad_card_img_url);
          if (TextUtils.isEmpty(str)) {
            str = "";
          }
          while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              c.this.setImageBitmap(paramAnonymousString);
              Log.d("SnsAd.AdImageLoader", "onDownloaded succ, hash=" + c.this.hashCode());
              AppMethodBeat.o(309821);
              return;
              str = k.mC("adId", str);
            }
            else
            {
              Log.e("SnsAd.AdImageLoader", "onDownloaded, bitmap==null");
              AppMethodBeat.o(309821);
              return;
            }
          }
        }
        finally
        {
          Log.e("SnsAd.AdImageLoader", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(309821);
          return;
        }
        Log.d("SnsAd.AdImageLoader", "onDownloaded, url changed");
        AppMethodBeat.o(309821);
      }
      
      public final void gZM() {}
      
      public final void gZN()
      {
        AppMethodBeat.i(309812);
        c.this.setTag(b.f.sns_ad_card_img_url, "");
        Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + c.this.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(309812);
      }
    });
    AppMethodBeat.o(309756);
  }
  
  public static void o(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(309737);
    if (!paramString.equals((String)paramImageView.getTag(b.f.sns_ad_card_img_url)))
    {
      paramImageView.setImageDrawable(null);
      loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(309737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.c
 * JD-Core Version:    0.7.0.1
 */