package com.tencent.mm.plugin.sns.ad.j;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;

public final class a
{
  private static f<String, Bitmap> QcX;
  
  static
  {
    AppMethodBeat.i(309837);
    QcX = new com.tencent.mm.b.h(3);
    AppMethodBeat.o(309837);
  }
  
  public static void a(final String paramString, b paramb)
  {
    AppMethodBeat.i(309805);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("SnsAd.AdCdnImageLoaderMM", "loadImageAsync, imageUrl is null, you need operate this previously");
      AppMethodBeat.o(309805);
      return;
    }
    Log.d("SnsAd.AdCdnImageLoaderMM", "loadImageAsync, hash=" + paramb.hashCode() + ", url=" + paramString);
    try
    {
      Bitmap localBitmap = (Bitmap)QcX.ct(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        paramb.g(localBitmap, true);
        Log.d("SnsAd.AdCdnImageLoaderMM", "loadImageAsync, hit mem cache, url=".concat(String.valueOf(paramString)));
        AppMethodBeat.o(309805);
        return;
      }
      a(paramString, "adId_mm", new g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(309783);
          try
          {
            Log.i("SnsAd.AdCdnImageLoaderMM", "loadImageAsync, onDownloaded and imageUrl is " + paramString);
            a.a(paramString, paramAnonymousString, a.this);
            AppMethodBeat.o(309783);
            return;
          }
          finally
          {
            Log.e("SnsAd.AdCdnImageLoaderMM", "loadImageAsync, onDownloaded, exp=" + paramAnonymousString.toString());
            AppMethodBeat.o(309783);
          }
        }
        
        public final void gZM() {}
        
        public final void gZN()
        {
          AppMethodBeat.i(309778);
          a.this.g(null, false);
          Log.e("SnsAd.AdCdnImageLoaderMM", "loadImageAsync, onDownloadError, hash=" + a.this.hashCode() + ", url=" + paramString);
          AppMethodBeat.o(309778);
        }
      });
      AppMethodBeat.o(309805);
      return;
    }
    finally
    {
      Log.e("SnsAd.AdCdnImageLoaderMM", "loadImageAsync, exp=" + paramString.toString());
      AppMethodBeat.o(309805);
    }
  }
  
  public static void a(String paramString, g.a parama)
  {
    AppMethodBeat.i(369988);
    a(paramString, "adId_mm", parama);
    AppMethodBeat.o(369988);
  }
  
  public static void a(final String paramString1, final String paramString2, final g.a parama)
  {
    AppMethodBeat.i(309797);
    final String str1 = k.hkC();
    paramString2 = k.mF(paramString2, paramString1);
    final String str2 = str1 + paramString2;
    Log.i("SnsAd.AdCdnImageLoaderMM", "downloadImageByCdn, fileName=" + paramString2 + ", url=" + paramString1);
    if (y.ZC(str2))
    {
      Log.i("SnsAd.AdCdnImageLoaderMM", "hit local cache, fileName=".concat(String.valueOf(paramString2)));
      if (parama != null) {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(309795);
            a.this.aWn(str2);
            AppMethodBeat.o(309795);
          }
        });
      }
      AppMethodBeat.o(309797);
      return;
    }
    y.bDX(str1);
    dmz localdmz = o.a(paramString2, 2, paramString1, paramString1, 1, 1, "");
    final p localp = new p(localdmz);
    localp.QnY = 3;
    localp.hOG = localdmz.Id;
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309762);
        al.hgw().a(new a.a(a.this.Id, str2, paramString1, parama));
        c localc = al.hgw();
        dmz localdmz = a.this;
        p localp = localp;
        br localbr = br.jbh();
        localbr.time = ((int)(System.currentTimeMillis() / 1000L));
        localc.a(localdmz, 8, localp, localbr, str1, paramString2);
        AppMethodBeat.o(309762);
      }
    });
    AppMethodBeat.o(309797);
  }
  
  public static String aWQ(String paramString)
  {
    AppMethodBeat.i(309772);
    String str = k.hkC();
    paramString = k.mF("adId_mm", paramString);
    paramString = str + paramString;
    AppMethodBeat.o(309772);
    return paramString;
  }
  
  public static void o(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(309759);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(309759);
      return;
    }
    if (!paramString.equals((String)paramImageView.getTag(b.f.sns_ad_card_img_url)))
    {
      paramImageView.setImageDrawable(null);
      if (!TextUtils.isEmpty(paramString))
      {
        paramImageView.setTag(b.f.sns_ad_card_img_url, paramString);
        Log.d("SnsAd.AdCdnImageLoaderMM", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
        Bitmap localBitmap = (Bitmap)QcX.ct(paramString);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          paramImageView.setImageBitmap(localBitmap);
          Log.d("SnsAd.AdCdnImageLoaderMM", "hit mem cache, url=".concat(String.valueOf(paramString)));
          AppMethodBeat.o(309759);
          return;
        }
        a(paramString, "adId_mm", new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(309800);
            for (;;)
            {
              try
              {
                ImageView localImageView = (ImageView)a.this.get();
                if (localImageView == null)
                {
                  Log.w("SnsAd.AdCdnImageLoaderMM", "imageViewRef released");
                  AppMethodBeat.o(309800);
                  return;
                }
                str = (String)localImageView.getTag(b.f.sns_ad_card_img_url);
                if (TextUtils.isEmpty(str))
                {
                  str = "";
                  if ((TextUtils.isEmpty(paramAnonymousString)) || (!paramAnonymousString.equals(str))) {
                    break;
                  }
                  a.c(paramString, paramAnonymousString, localImageView);
                  AppMethodBeat.o(309800);
                  return;
                }
              }
              finally
              {
                Log.e("SnsAd.AdCdnImageLoaderMM", "onDownloaded, exp=" + paramAnonymousString.toString());
                AppMethodBeat.o(309800);
                return;
              }
              String str = k.mC("adId_mm", str);
            }
            Log.d("SnsAd.AdCdnImageLoaderMM", "onDownloaded, url changed");
            AppMethodBeat.o(309800);
          }
          
          public final void gZM() {}
          
          public final void gZN()
          {
            AppMethodBeat.i(309792);
            ImageView localImageView = (ImageView)a.this.get();
            if (localImageView == null)
            {
              Log.w("SnsAd.AdCdnImageLoaderMM", "imageViewRef released");
              AppMethodBeat.o(309792);
              return;
            }
            localImageView.setTag(b.f.sns_ad_card_img_url, "");
            localImageView.setImageDrawable(null);
            Log.e("SnsAd.AdCdnImageLoaderMM", "onDownloadError, hash=" + localImageView.hashCode() + ", url=" + paramString);
            AppMethodBeat.o(309792);
          }
        });
      }
    }
    AppMethodBeat.o(309759);
  }
  
  static final class a
    implements c.b
  {
    private String ADt;
    g.a Qdf;
    String filePath;
    private String mediaId;
    
    public a(String paramString1, String paramString2, String paramString3, g.a parama)
    {
      this.mediaId = paramString1;
      this.Qdf = parama;
      this.filePath = paramString2;
      this.ADt = paramString3;
    }
    
    public final void EE(String paramString)
    {
      AppMethodBeat.i(309742);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        Log.i("SnsAd.AdCdnImageLoaderMM", "onThumbFinish, mediaId=".concat(String.valueOf(paramString)));
        al.hgw().b(this);
      }
      AppMethodBeat.o(309742);
    }
    
    public final void aXr() {}
    
    public final void w(String paramString, final boolean paramBoolean)
    {
      AppMethodBeat.i(309765);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        Log.i("SnsAd.AdCdnImageLoaderMM", "onImageFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
        al.hgw().b(this);
        if (this.Qdf == null)
        {
          AppMethodBeat.o(309765);
          return;
        }
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(309744);
            if (paramBoolean)
            {
              a.a.this.Qdf.aWn(a.a.this.filePath);
              AppMethodBeat.o(309744);
              return;
            }
            a.a.this.Qdf.gZN();
            AppMethodBeat.o(309744);
          }
        });
        if (paramBoolean)
        {
          m.d(0, 0, 1, this.ADt);
          AppMethodBeat.o(309765);
          return;
        }
        m.d(1, 0, 1, this.ADt);
      }
      AppMethodBeat.o(309765);
    }
    
    public final void x(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(309752);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        Log.i("SnsAd.AdCdnImageLoaderMM", "onSightFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
        al.hgw().b(this);
      }
      AppMethodBeat.o(309752);
    }
  }
  
  public static abstract interface b
  {
    public abstract void g(Bitmap paramBitmap, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.a
 * JD-Core Version:    0.7.0.1
 */