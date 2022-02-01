package com.tencent.mm.plugin.sns.ad.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public static Drawable a(Resources paramResources, String paramString)
  {
    AppMethodBeat.i(219171);
    try
    {
      Bitmap localBitmap = com.tencent.mm.sdk.platformtools.h.decodeFile(paramString, null);
      if (localBitmap != null)
      {
        paramResources = new BitmapDrawable(paramResources, localBitmap);
        AppMethodBeat.o(219171);
        return paramResources;
      }
      ae.e("ImageLoader", "getDrawableFromFile bitmap==null, path=".concat(String.valueOf(paramString)));
    }
    catch (Throwable paramResources)
    {
      for (;;)
      {
        ae.e("ImageLoader", "getDrawableFromFile exp=" + paramResources.toString() + ", path=" + paramString);
      }
    }
    AppMethodBeat.o(219171);
    return null;
  }
  
  public static void i(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(219169);
    if (!paramString.equals((String)paramImageView.getTag(2131304892)))
    {
      paramImageView.setImageDrawable(null);
      loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(219169);
  }
  
  public static void loadImage(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(219170);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(219170);
      return;
    }
    ae.d("ImageLoader", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(2131304892, paramString);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString, false, new f.a()
    {
      public final void ayY(String paramAnonymousString)
      {
        AppMethodBeat.i(219168);
        try
        {
          String str = (String)this.tCz.getTag(2131304892);
          if (TextUtils.isEmpty(str)) {
            str = "";
          }
          while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
          {
            paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              this.tCz.setImageBitmap(paramAnonymousString);
              ae.d("ImageLoader", "onDownloaded succ, hash=" + this.tCz.hashCode());
              AppMethodBeat.o(219168);
              return;
              str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", str);
            }
            else
            {
              ae.e("ImageLoader", "onDownloaded, bitmap==null");
              AppMethodBeat.o(219168);
              return;
            }
          }
        }
        catch (Throwable paramAnonymousString)
        {
          ae.e("ImageLoader", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(219168);
          return;
        }
        ae.d("ImageLoader", "onDownloaded, url changed");
        AppMethodBeat.o(219168);
      }
      
      public final void dVu() {}
      
      public final void dVv()
      {
        AppMethodBeat.i(219167);
        this.tCz.setTag(2131304892, "");
        ae.e("ImageLoader", "onDownloadError, hash=" + this.tCz.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(219167);
      }
    });
    AppMethodBeat.o(219170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.b
 * JD-Core Version:    0.7.0.1
 */