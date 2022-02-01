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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;

public final class a
{
  public static Drawable a(Resources paramResources, String paramString)
  {
    AppMethodBeat.i(210251);
    try
    {
      Bitmap localBitmap = f.decodeFile(paramString, null);
      if (localBitmap != null)
      {
        paramResources = new BitmapDrawable(paramResources, localBitmap);
        AppMethodBeat.o(210251);
        return paramResources;
      }
      ac.e("ImageLoader", "getDrawableFromFile bitmap==null, path=".concat(String.valueOf(paramString)));
    }
    catch (Throwable paramResources)
    {
      for (;;)
      {
        ac.e("ImageLoader", "getDrawableFromFile exp=" + paramResources.toString() + ", path=" + paramString);
      }
    }
    AppMethodBeat.o(210251);
    return null;
  }
  
  public static void h(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(200019);
    if (!paramString.equals((String)paramImageView.getTag(2131304892)))
    {
      paramImageView.setImageDrawable(null);
      loadImage(paramString, paramImageView);
    }
    AppMethodBeat.o(200019);
  }
  
  public static void loadImage(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(200020);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(200020);
      return;
    }
    ac.d("ImageLoader", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
    paramImageView.setTag(2131304892, paramString);
    h.a(paramString, false, new f.a()
    {
      public final void asD(String paramAnonymousString)
      {
        AppMethodBeat.i(200018);
        try
        {
          String str = (String)this.svh.getTag(2131304892);
          if (TextUtils.isEmpty(str)) {
            str = "";
          }
          while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
          {
            paramAnonymousString = f.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              this.svh.setImageBitmap(paramAnonymousString);
              ac.d("ImageLoader", "onDownloaded succ, hash=" + this.svh.hashCode());
              AppMethodBeat.o(200018);
              return;
              str = h.js("adId", str);
            }
            else
            {
              ac.e("ImageLoader", "onDownloaded, bitmap==null");
              AppMethodBeat.o(200018);
              return;
            }
          }
        }
        catch (Throwable paramAnonymousString)
        {
          ac.e("ImageLoader", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(200018);
          return;
        }
        ac.d("ImageLoader", "onDownloaded, url changed");
        AppMethodBeat.o(200018);
      }
      
      public final void dFC() {}
      
      public final void dFD()
      {
        AppMethodBeat.i(200017);
        this.svh.setTag(2131304892, "");
        ac.e("ImageLoader", "onDownloadError, hash=" + this.svh.hashCode() + ", url=" + paramString);
        AppMethodBeat.o(200017);
      }
    });
    AppMethodBeat.o(200020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.a
 * JD-Core Version:    0.7.0.1
 */