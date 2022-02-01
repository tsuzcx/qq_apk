package com.tencent.mm.plugin.sns.ad.g;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.a.a.g;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.e.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class o
{
  public static o PWQ;
  public g<String, Bitmap> PWO;
  public final LruCache<String, Bitmap> PWP;
  
  static
  {
    AppMethodBeat.i(95042);
    PWQ = new o();
    AppMethodBeat.o(95042);
  }
  
  private o()
  {
    AppMethodBeat.i(95040);
    this.PWO = new g(5);
    this.PWP = new LruCache(10);
    AppMethodBeat.o(95040);
  }
  
  private boolean y(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(309897);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      Log.e("MicroMsg.SnsTimelineAdResourceMgr", "the imageView is null or filepath is empty");
      AppMethodBeat.o(309897);
      return false;
    }
    String str = (String)l.aX(paramImageView, b.f.sns_prefer_avatar_url);
    if (TextUtils.isEmpty(str))
    {
      Log.e("MicroMsg.SnsTimelineAdResourceMgr", "the imageView does not attach one url, in fillImageViewWithCache");
      AppMethodBeat.o(309897);
      return false;
    }
    if (!paramString.equalsIgnoreCase(k.mC("adId", str)))
    {
      Log.w("MicroMsg.SnsTimelineAdResourceMgr", "the bitmap file path is not same as the attachFilePath, in fillImageViewWithCache!");
      AppMethodBeat.o(309897);
      return false;
    }
    paramString = (Bitmap)this.PWP.get(paramString);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      paramImageView.setImageBitmap(paramString);
      AppMethodBeat.o(309897);
      return true;
    }
    Log.w("MicroMsg.SnsTimelineAdResourceMgr", "the bitmap is null or recycled!!!");
    AppMethodBeat.o(309897);
    return false;
  }
  
  public final Bitmap Cr(String paramString)
  {
    AppMethodBeat.i(95041);
    if (this.PWO.check(paramString))
    {
      localBitmap = (Bitmap)this.PWO.ct(paramString);
      if (localBitmap != null)
      {
        Log.i("MicroMsg.SnsTimelineAdResourceMgr", "hit cache %s", new Object[] { paramString });
        AppMethodBeat.o(95041);
        return localBitmap;
      }
    }
    Log.i("MicroMsg.SnsTimelineAdResourceMgr", "not hit cache %s", new Object[] { paramString });
    Bitmap localBitmap = a.m(paramString, 0.1F);
    if (localBitmap != null) {
      this.PWO.put(paramString, localBitmap);
    }
    AppMethodBeat.o(95041);
    return localBitmap;
  }
  
  public final void h(final ImageView paramImageView, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(309907);
    String str;
    try
    {
      if (y(paramImageView, paramString)) {
        break label187;
      }
      Log.i("MicroMsg.SnsTimelineAdResourceMgr", "there is no cache bitmap, it should reload from flash!");
      if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
      {
        Log.e("MicroMsg.SnsTimelineAdResourceMgr", "the imageView is null or filepath is empty");
        AppMethodBeat.o(309907);
        return;
      }
      str = (String)l.aX(paramImageView, b.f.sns_prefer_avatar_url);
      if (!TextUtils.isEmpty(str)) {}
    }
    finally
    {
      Log.e("MicroMsg.SnsTimelineAdResourceMgr", "there is something wrong in setImageToImageView");
      AppMethodBeat.o(309907);
      return;
    }
    if (!paramString.equalsIgnoreCase(k.mC("adId", str)))
    {
      Log.w("MicroMsg.SnsTimelineAdResourceMgr", "the bitmap file path is not same as the attachFilePath!");
      AppMethodBeat.o(309907);
      return;
    }
    final int i = paramImageView.getWidth();
    final int j = paramImageView.getHeight();
    Log.d("MicroMsg.SnsTimelineAdResourceMgr", "the image view width is " + i + ", height is " + j);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        final Bitmap localBitmap = null;
        AppMethodBeat.i(309899);
        try
        {
          Log.d("MicroMsg.SnsTimelineAdResourceMgr", "the imgDisplayType is " + paramInt);
          if (paramInt == 0) {
            if ((i > 0) && (j > 0)) {
              localBitmap = BitmapUtil.decodeFileWithSample(paramString, i, j);
            }
          }
          for (;;)
          {
            h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(309904);
                try
                {
                  if ((localBitmap == null) || (localBitmap.isRecycled()))
                  {
                    Log.w("MicroMsg.SnsTimelineAdResourceMgr", "decode bitmap failed!!! Is the bitmap file valid?");
                    AppMethodBeat.o(309904);
                    return;
                  }
                  o.a(o.this).put(o.1.this.val$filePath, localBitmap);
                  o.a(o.this, o.1.this.nqD, o.1.this.val$filePath);
                  AppMethodBeat.o(309904);
                  return;
                }
                finally
                {
                  Log.e("MicroMsg.SnsTimelineAdResourceMgr", "setImageToImageView set bitmap, exp=" + localObject.toString());
                  AppMethodBeat.o(309904);
                }
              }
            });
            AppMethodBeat.o(309899);
            return;
            localBitmap = BitmapUtil.decodeFile(paramString, null);
            continue;
            if (paramInt == 1) {
              localBitmap = o.this.Cr(paramString);
            }
          }
          return;
        }
        finally
        {
          Log.e("MicroMsg.SnsTimelineAdResourceMgr", "setImageToImageView decode bitmap, exp=" + localObject.toString());
          AppMethodBeat.o(309899);
        }
      }
    });
    label187:
    AppMethodBeat.o(309907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.o
 * JD-Core Version:    0.7.0.1
 */