package com.tencent.mm.plugin.sns.ad.i;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static Drawable a(Resources paramResources, String paramString)
  {
    AppMethodBeat.i(202346);
    try
    {
      Bitmap localBitmap = BitmapUtil.decodeFile(paramString, null);
      if (localBitmap != null)
      {
        paramResources = new BitmapDrawable(paramResources, localBitmap);
        AppMethodBeat.o(202346);
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
    AppMethodBeat.o(202346);
    return null;
  }
  
  public static void a(String paramString, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(202343);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(202343);
      return;
    }
    try
    {
      if (!paramString.equals((String)paramImageView.getTag(2131307979))) {
        b(paramString, paramImageView, paramInt);
      }
      AppMethodBeat.o(202343);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202343);
    }
  }
  
  private static void b(final String paramString, final ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(202345);
    if ((TextUtils.isEmpty(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(202345);
      return;
    }
    Log.d("SnsAd.AdImageLoader", "loadImageEx, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(2131307979, paramString);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString, false, new f.a()
    {
      boolean started = false;
      
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(202339);
        ImageView localImageView = paramImageView;
        if (localImageView != null) {}
        for (;;)
        {
          try
          {
            if (TextUtils.isEmpty(paramAnonymousString)) {
              Log.w("SnsAd.AdImageLoader", "are you sure the input param is valid?");
            }
          }
          catch (Throwable paramAnonymousString)
          {
            Log.e("SnsAd.AdImageLoader", "setImageBitmapAsync, exp=" + paramAnonymousString.toString());
            continue;
            String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", str);
            continue;
            int i = localImageView.getWidth();
            int j = localImageView.getHeight();
            com.tencent.f.h.RTc.aX(new b.3(i, j, paramAnonymousString, localImageView));
            continue;
          }
          try
          {
            if (this.started) {
              k.it(this.gsA, 0);
            }
            AppMethodBeat.o(202339);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            AppMethodBeat.o(202339);
          }
          str = (String)localImageView.getTag(2131307979);
          if (!TextUtils.isEmpty(str)) {
            continue;
          }
          str = "";
          if (paramAnonymousString.equals(str)) {
            continue;
          }
          Log.w("SnsAd.AdImageLoader", "the input file path is not same as the tag file path");
        }
      }
      
      public final void eWN()
      {
        this.started = true;
      }
      
      public final void eWO()
      {
        AppMethodBeat.i(202338);
        try
        {
          k.it(this.gsA, 1);
          paramImageView.setTag(2131307979, "");
          paramImageView.setImageDrawable(null);
          label32:
          Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + paramImageView.hashCode() + ", url=" + paramString);
          AppMethodBeat.o(202338);
          return;
        }
        catch (Throwable localThrowable)
        {
          break label32;
        }
      }
    });
    AppMethodBeat.o(202345);
  }
  
  public static void j(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(202342);
    if (!paramString.equals((String)paramImageView.getTag(2131307979)))
    {
      paramImageView.setImageDrawable(null);
      loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(202342);
  }
  
  public static void loadImage(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(202344);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(202344);
      return;
    }
    Log.d("SnsAd.AdImageLoader", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(2131307979, paramString);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString, false, new f.a()
    {
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(202337);
        try
        {
          String str = (String)this.iaq.getTag(2131307979);
          if (TextUtils.isEmpty(str)) {
            str = "";
          }
          while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              this.iaq.setImageBitmap(paramAnonymousString);
              Log.d("SnsAd.AdImageLoader", "onDownloaded succ, hash=" + this.iaq.hashCode());
              AppMethodBeat.o(202337);
              return;
              str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", str);
            }
            else
            {
              Log.e("SnsAd.AdImageLoader", "onDownloaded, bitmap==null");
              AppMethodBeat.o(202337);
              return;
            }
          }
        }
        catch (Throwable paramAnonymousString)
        {
          Log.e("SnsAd.AdImageLoader", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(202337);
          return;
        }
        Log.d("SnsAd.AdImageLoader", "onDownloaded, url changed");
        AppMethodBeat.o(202337);
      }
      
      public final void eWN() {}
      
      public final void eWO()
      {
        AppMethodBeat.i(202336);
        this.iaq.setTag(2131307979, "");
        Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + this.iaq.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(202336);
      }
    });
    AppMethodBeat.o(202344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.b
 * JD-Core Version:    0.7.0.1
 */