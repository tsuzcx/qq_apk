package com.tencent.mm.plugin.sns.ad.f;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.a.a.g;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;

public final class o
{
  public static o JFQ;
  public g<String, Bitmap> JFO;
  public final LruCache<String, Bitmap> JFP;
  
  static
  {
    AppMethodBeat.i(95042);
    JFQ = new o();
    AppMethodBeat.o(95042);
  }
  
  private o()
  {
    AppMethodBeat.i(95040);
    this.JFO = new g(5);
    this.JFP = new LruCache(10);
    AppMethodBeat.o(95040);
  }
  
  private boolean w(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(268303);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      Log.e("MicroMsg.SnsTimelineAdResourceMgr", "the imageView is null or filepath is empty");
      AppMethodBeat.o(268303);
      return false;
    }
    String str = (String)l.aB(paramImageView, i.f.sns_prefer_avatar_url);
    if (TextUtils.isEmpty(str))
    {
      Log.e("MicroMsg.SnsTimelineAdResourceMgr", "the imageView does not attach one url, in fillImageViewWithCache");
      AppMethodBeat.o(268303);
      return false;
    }
    if (!paramString.equalsIgnoreCase(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", str)))
    {
      Log.w("MicroMsg.SnsTimelineAdResourceMgr", "the bitmap file path is not same as the attachFilePath, in fillImageViewWithCache!");
      AppMethodBeat.o(268303);
      return false;
    }
    paramString = (Bitmap)this.JFP.get(paramString);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      paramImageView.setImageBitmap(paramString);
      AppMethodBeat.o(268303);
      return true;
    }
    Log.w("MicroMsg.SnsTimelineAdResourceMgr", "the bitmap is null or recycled!!!");
    AppMethodBeat.o(268303);
    return false;
  }
  
  public final Bitmap JL(String paramString)
  {
    AppMethodBeat.i(95041);
    if (this.JFO.check(paramString))
    {
      localBitmap = (Bitmap)this.JFO.aX(paramString);
      if (localBitmap != null)
      {
        Log.i("MicroMsg.SnsTimelineAdResourceMgr", "hit cache %s", new Object[] { paramString });
        AppMethodBeat.o(95041);
        return localBitmap;
      }
    }
    Log.i("MicroMsg.SnsTimelineAdResourceMgr", "not hit cache %s", new Object[] { paramString });
    Bitmap localBitmap = a.l(paramString, 0.1F);
    if (localBitmap != null) {
      this.JFO.put(paramString, localBitmap);
    }
    AppMethodBeat.o(95041);
    return localBitmap;
  }
  
  public final void h(final ImageView paramImageView, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(268302);
    String str;
    try
    {
      if (w(paramImageView, paramString)) {
        break label187;
      }
      Log.i("MicroMsg.SnsTimelineAdResourceMgr", "there is no cache bitmap, it should reload from flash!");
      if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
      {
        Log.e("MicroMsg.SnsTimelineAdResourceMgr", "the imageView is null or filepath is empty");
        AppMethodBeat.o(268302);
        return;
      }
      str = (String)l.aB(paramImageView, i.f.sns_prefer_avatar_url);
      if (TextUtils.isEmpty(str))
      {
        Log.e("MicroMsg.SnsTimelineAdResourceMgr", "the imageView does not attach one url");
        AppMethodBeat.o(268302);
        return;
      }
    }
    catch (Throwable paramImageView)
    {
      Log.e("MicroMsg.SnsTimelineAdResourceMgr", "there is something wrong in setImageToImageView");
      AppMethodBeat.o(268302);
      return;
    }
    if (!paramString.equalsIgnoreCase(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", str)))
    {
      Log.w("MicroMsg.SnsTimelineAdResourceMgr", "the bitmap file path is not same as the attachFilePath!");
      AppMethodBeat.o(268302);
      return;
    }
    final int i = paramImageView.getWidth();
    final int j = paramImageView.getHeight();
    Log.d("MicroMsg.SnsTimelineAdResourceMgr", "the image view width is " + i + ", height is " + j);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        final Bitmap localBitmap = null;
        AppMethodBeat.i(268767);
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
            com.tencent.e.h.ZvG.bc(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(231544);
                try
                {
                  if ((localBitmap == null) || (localBitmap.isRecycled()))
                  {
                    Log.w("MicroMsg.SnsTimelineAdResourceMgr", "decode bitmap failed!!! Is the bitmap file valid?");
                    AppMethodBeat.o(231544);
                    return;
                  }
                  o.a(o.this).put(o.1.this.val$filePath, localBitmap);
                  o.a(o.this, o.1.this.kOW, o.1.this.val$filePath);
                  AppMethodBeat.o(231544);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  Log.e("MicroMsg.SnsTimelineAdResourceMgr", "setImageToImageView set bitmap, exp=" + localThrowable.toString());
                  AppMethodBeat.o(231544);
                }
              }
            });
            AppMethodBeat.o(268767);
            return;
            localBitmap = BitmapUtil.decodeFile(paramString, null);
            continue;
            if (paramInt == 1) {
              localBitmap = o.this.JL(paramString);
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.SnsTimelineAdResourceMgr", "setImageToImageView decode bitmap, exp=" + localThrowable.toString());
          AppMethodBeat.o(268767);
        }
      }
    });
    label187:
    AppMethodBeat.o(268302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.o
 * JD-Core Version:    0.7.0.1
 */