package com.tencent.mm.plugin.sns.ad.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;

public final class a
{
  public static Drawable a(Resources paramResources, String paramString)
  {
    AppMethodBeat.i(197699);
    try
    {
      Bitmap localBitmap = g.decodeFile(paramString, null);
      if (localBitmap != null)
      {
        paramResources = new BitmapDrawable(paramResources, localBitmap);
        AppMethodBeat.o(197699);
        return paramResources;
      }
      ad.e("ImageLoader", "getDrawableFromFile bitmap==null, path=".concat(String.valueOf(paramString)));
    }
    catch (Throwable paramResources)
    {
      for (;;)
      {
        ad.e("ImageLoader", "getDrawableFromFile exp=" + paramResources.toString() + ", path=" + paramString);
      }
    }
    AppMethodBeat.o(197699);
    return null;
  }
  
  public static void i(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(197697);
    if (!paramString.equals((String)paramImageView.getTag(2131304892)))
    {
      paramImageView.setImageDrawable(null);
      loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(197697);
  }
  
  public static void loadImage(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(197698);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(197698);
      return;
    }
    ad.d("ImageLoader", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(2131304892, paramString);
    h.a(paramString, false, new f.a()
    {
      public final void axG(String paramAnonymousString)
      {
        AppMethodBeat.i(197696);
        try
        {
          String str = (String)this.trI.getTag(2131304892);
          if (TextUtils.isEmpty(str)) {
            str = "";
          }
          while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
          {
            paramAnonymousString = g.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              this.trI.setImageBitmap(paramAnonymousString);
              ad.d("ImageLoader", "onDownloaded succ, hash=" + this.trI.hashCode());
              AppMethodBeat.o(197696);
              return;
              str = h.jF("adId", str);
            }
            else
            {
              ad.e("ImageLoader", "onDownloaded, bitmap==null");
              AppMethodBeat.o(197696);
              return;
            }
          }
        }
        catch (Throwable paramAnonymousString)
        {
          ad.e("ImageLoader", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(197696);
          return;
        }
        ad.d("ImageLoader", "onDownloaded, url changed");
        AppMethodBeat.o(197696);
      }
      
      public final void dRW() {}
      
      public final void dRX()
      {
        AppMethodBeat.i(197695);
        this.trI.setTag(2131304892, "");
        ad.e("ImageLoader", "onDownloadError, hash=" + this.trI.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(197695);
      }
    });
    AppMethodBeat.o(197698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.a
 * JD-Core Version:    0.7.0.1
 */