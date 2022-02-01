package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import d.g.b.p;
import d.l;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/TrackCache;", "", "()V", "bitmapCache", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "bitmapSizeLimit", "", "getBitmapSizeLimit", "()I", "setBitmapSizeLimit", "(I)V", "cache", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "imageDuration", "", "getImageDuration", "()J", "setImageDuration", "(J)V", "clear", "", "createRescaleBitmap", "path", "getBitmap", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getResource", "remove", "resizeBitmap", "bitmap", "video_composition_release"})
public final class e
{
  public static final HashMap<String, Bitmap> ErA;
  private static int LJq;
  private static long LJr;
  public static final e LJs;
  public static final HashMap<String, TAVResource> cache;
  
  static
  {
    AppMethodBeat.i(194964);
    LJs = new e();
    LJq = 1080;
    LJr = 10000L;
    ErA = new HashMap();
    cache = new HashMap();
    AppMethodBeat.o(194964);
  }
  
  public static void fTY()
  {
    LJr = 4000L;
  }
  
  public final TAVResource b(b paramb)
  {
    AppMethodBeat.i(194962);
    p.h(paramb, "track");
    try
    {
      localObject2 = (TAVResource)cache.get(paramb.path);
      localObject1 = localObject2;
      if (localObject2 == null) {}
      switch (paramb.type)
      {
      case 1: 
        localObject1 = (TAVResource)new TAVEmptyResource(CMTime.CMTimeZero);
        label83:
        cache.put(paramb.path, localObject1);
        paramb = ((TAVResource)localObject1).clone();
        p.g(paramb, "resource.clone()");
        return paramb;
      }
    }
    finally
    {
      Object localObject2;
      Object localObject3;
      long l;
      int j;
      int k;
      Canvas localCanvas;
      AppMethodBeat.o(194962);
    }
    localObject3 = paramb.path;
    l = SystemClock.elapsedRealtime();
    com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "createRescaleBitmap:".concat(String.valueOf(localObject3)), new Object[0]);
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
    j = ((BitmapFactory.Options)localObject1).outWidth;
    k = ((BitmapFactory.Options)localObject1).outHeight;
    localObject2 = com.tencent.mm.videocomposition.c.a.LKn;
    int i = LJq;
    ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.videocomposition.c.a.O(j, k, i, i);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    localObject1 = BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
      if (((Bitmap)localObject1).getWidth() % 2 == 1)
      {
        localObject2 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth() + 1, ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        if (localObject2 == null) {
          p.gkB();
        }
        localCanvas = new Canvas((Bitmap)localObject2);
        localCanvas.drawARGB(0, 0, 0, 0);
        localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        p.gkB();
      }
      switch (new androidx.a.a.a((InputStream)new FileInputStream((String)localObject3)).getAttributeInt("Orientation", 1))
      {
      case 6: 
      case 3: 
      case 8: 
        for (;;)
        {
          localObject2 = localObject1;
          if (i > 0)
          {
            localObject2 = com.tencent.mm.videocomposition.c.a.LKn;
            localObject3 = com.tencent.mm.videocomposition.c.a.a((Bitmap)localObject1, i);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "final rescale bitmap size:[" + ((Bitmap)localObject2).getWidth() + ", " + ((Bitmap)localObject2).getHeight() + "], origin size:[" + j + ", " + k + "], cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
          ((Map)ErA).put(paramb.path, localObject2);
          localObject1 = (TAVResource)new TAVImageResource(new CIImage((Bitmap)localObject2), CMTime.fromMs(LJr), true);
          break;
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "image rotate 90", new Object[0]);
          i = 90;
          continue;
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "image rotate 180", new Object[0]);
          i = 180;
          continue;
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "image rotate 270", new Object[0]);
          i = 270;
        }
        localObject1 = (TAVResource)new TAVAssetTrackResource((Asset)new URLAsset(paramb.path));
        break label83;
        break;
      case 4: 
      case 5: 
      case 7: 
      default: 
        for (;;)
        {
          label380:
          break;
          i = 0;
          break label380;
        }
        localObject1 = null;
      }
    }
  }
  
  public final Bitmap c(b paramb)
  {
    AppMethodBeat.i(194963);
    p.h(paramb, "track");
    try
    {
      paramb = (Bitmap)ErA.get(paramb.path);
      return paramb;
    }
    finally
    {
      AppMethodBeat.o(194963);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.e
 * JD-Core Version:    0.7.0.1
 */