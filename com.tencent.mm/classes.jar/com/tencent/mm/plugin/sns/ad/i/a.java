package com.tencent.mm.plugin.sns.ad.i;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;

public final class a
{
  private static f<String, Bitmap> JLo;
  
  static
  {
    AppMethodBeat.i(268834);
    JLo = new com.tencent.mm.b.h(3);
    AppMethodBeat.o(268834);
  }
  
  public static void a(final String paramString, final f.a parama)
  {
    AppMethodBeat.i(268832);
    final String str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.fSq();
    final String str2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kX("adId_mm", paramString);
    final String str3 = str1 + str2;
    Log.i("SnsAd.AdCdnImageLoaderMM", "downloadImageByCdn, fileName=" + str2 + ", url=" + paramString);
    if (u.agG(str3))
    {
      Log.i("SnsAd.AdCdnImageLoaderMM", "hit local cache, fileName=".concat(String.valueOf(str2)));
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(245721);
          this.JLs.aYs(str3);
          AppMethodBeat.o(245721);
        }
      });
      AppMethodBeat.o(268832);
      return;
    }
    u.bBD(str1);
    cvt localcvt = o.a(str2, 2, paramString, paramString, 1, 1, "");
    final p localp = new p(localcvt);
    localp.JRn = 3;
    localp.fIY = localcvt.Id;
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212383);
        aj.fOD().a(new a.a(this.JJb.Id, str3, paramString, parama));
        c localc = aj.fOD();
        cvt localcvt = this.JJb;
        p localp = localp;
        bp localbp = bp.hzh();
        localbp.time = ((int)(System.currentTimeMillis() / 1000L));
        localc.a(localcvt, 8, localp, localbp, str1, str2);
        AppMethodBeat.o(212383);
      }
    });
    AppMethodBeat.o(268832);
  }
  
  public static void l(final String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(268830);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(268830);
      return;
    }
    if (!paramString.equals((String)paramImageView.getTag(i.f.sns_ad_card_img_url)))
    {
      paramImageView.setImageDrawable(null);
      if (!TextUtils.isEmpty(paramString))
      {
        paramImageView.setTag(i.f.sns_ad_card_img_url, paramString);
        Log.d("SnsAd.AdCdnImageLoaderMM", "loadImage, hash=" + paramImageView.hashCode() + ", url=" + paramString);
        Bitmap localBitmap = (Bitmap)JLo.aX(paramString);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          paramImageView.setImageBitmap(localBitmap);
          Log.d("SnsAd.AdCdnImageLoaderMM", "hit mem cache, url=".concat(String.valueOf(paramString)));
          AppMethodBeat.o(268830);
          return;
        }
        a(paramString, new f.a()
        {
          public final void aYs(String paramAnonymousString)
          {
            AppMethodBeat.i(200566);
            for (;;)
            {
              try
              {
                ImageView localImageView = (ImageView)this.JLp.get();
                if (localImageView == null)
                {
                  Log.w("SnsAd.AdCdnImageLoaderMM", "imageViewRef released");
                  AppMethodBeat.o(200566);
                  return;
                }
                str = (String)localImageView.getTag(i.f.sns_ad_card_img_url);
                if (TextUtils.isEmpty(str))
                {
                  str = "";
                  if ((TextUtils.isEmpty(paramAnonymousString)) || (!paramAnonymousString.equals(str))) {
                    break;
                  }
                  a.c(paramString, paramAnonymousString, localImageView);
                  AppMethodBeat.o(200566);
                  return;
                }
              }
              catch (Throwable paramAnonymousString)
              {
                Log.e("SnsAd.AdCdnImageLoaderMM", "onDownloaded, exp=" + paramAnonymousString.toString());
                AppMethodBeat.o(200566);
                return;
              }
              String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId_mm", str);
            }
            Log.d("SnsAd.AdCdnImageLoaderMM", "onDownloaded, url changed");
            AppMethodBeat.o(200566);
          }
          
          public final void fJU() {}
          
          public final void fJV()
          {
            AppMethodBeat.i(200563);
            ImageView localImageView = (ImageView)this.JLp.get();
            if (localImageView == null)
            {
              Log.w("SnsAd.AdCdnImageLoaderMM", "imageViewRef released");
              AppMethodBeat.o(200563);
              return;
            }
            localImageView.setTag(i.f.sns_ad_card_img_url, "");
            localImageView.setImageDrawable(null);
            Log.e("SnsAd.AdCdnImageLoaderMM", "onDownloadError, hash=" + localImageView.hashCode() + ", url=" + paramString);
            AppMethodBeat.o(200563);
          }
        });
      }
    }
    AppMethodBeat.o(268830);
  }
  
  static final class a
    implements c.b
  {
    f.a JLv;
    String filePath;
    private String mediaId;
    private String xei;
    
    public a(String paramString1, String paramString2, String paramString3, f.a parama)
    {
      this.mediaId = paramString1;
      this.JLv = parama;
      this.filePath = paramString2;
      this.xei = paramString3;
    }
    
    public final void aYK(String paramString)
    {
      AppMethodBeat.i(266048);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        Log.i("SnsAd.AdCdnImageLoaderMM", "onThumbFinish, mediaId=".concat(String.valueOf(paramString)));
        aj.fOD().b(this);
      }
      AppMethodBeat.o(266048);
    }
    
    public final void cq(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(266049);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        Log.i("SnsAd.AdCdnImageLoaderMM", "onSightFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
        aj.fOD().b(this);
      }
      AppMethodBeat.o(266049);
    }
    
    public final void cr(String paramString, final boolean paramBoolean)
    {
      AppMethodBeat.i(266050);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        Log.i("SnsAd.AdCdnImageLoaderMM", "onImageFinish, mediaId=" + paramString + ", isOk=" + paramBoolean);
        aj.fOD().b(this);
        if (this.JLv == null)
        {
          AppMethodBeat.o(266050);
          return;
        }
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216759);
            if (paramBoolean)
            {
              a.a.this.JLv.aYs(a.a.this.filePath);
              AppMethodBeat.o(216759);
              return;
            }
            a.a.this.JLv.fJV();
            AppMethodBeat.o(216759);
          }
        });
        if (paramBoolean)
        {
          m.b(0, 0, 1, this.xei);
          AppMethodBeat.o(266050);
          return;
        }
        m.b(1, 0, 1, this.xei);
      }
      AppMethodBeat.o(266050);
    }
    
    public final void fLL() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.a
 * JD-Core Version:    0.7.0.1
 */