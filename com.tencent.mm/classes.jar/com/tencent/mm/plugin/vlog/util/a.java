package com.tencent.mm.plugin.vlog.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/util/FinderEditUtil;", "", "()V", "FULLSCREEN_RATIO", "", "getFULLSCREEN_RATIO", "()F", "MIN_RATIO", "NORMAL_RATIO", "getNORMAL_RATIO", "RATIO_TOLERANCE", "SUPPORT_RATIO", "TAG", "", "calculateEnhancementLimitRect", "Landroid/graphics/RectF;", "valid", "getGOPSize", "", "path", "getRatio", "width", "height", "getVideoCompositionThumb", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "keepPhotoExifInfo", "source", "dst", "makePhotoSizeConformity", "maxSize", "quality", "bitmap", "savePhotoThumbNail", "compressQuality", "plugin-vlog_release"})
public final class a
{
  private static final float NGM;
  public static final a NGN;
  
  static
  {
    AppMethodBeat.i(233331);
    NGN = new a();
    NGM = ((b)h.ae(b.class)).a(b.a.vYZ, 1.777778F);
    AppMethodBeat.o(233331);
  }
  
  public static void a(int paramInt, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(233323);
    p.k(paramBitmap, "bitmap");
    p.k(paramString, "path");
    BitmapUtil.saveBitmapToImage(paramBitmap, paramInt, Bitmap.CompressFormat.JPEG, paramString, false);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while ((0L > 0L) && (u.bBQ(paramString) > 0L) && (i > 0) && (paramInt <= 5))
    {
      i -= 5;
      BitmapUtil.saveBitmapToImage(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, false);
      paramInt += 1;
    }
    Log.i("MicroMsg.FinderEditUtil", "makePhotoSizeConformity  maxSize:0  compressQuality:" + i + " size:" + u.agG(paramString));
    AppMethodBeat.o(233323);
  }
  
  public static int bfV(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(233326);
    p.k(paramString, "path");
    boolean bool = ((b)h.ae(b.class)).a(b.a.vWu, true);
    Log.i("MicroMsg.FinderEditUtil", "getGOPSize path:" + paramString + " enable:" + bool);
    if ((!u.agG(paramString)) && (bool))
    {
      AppMethodBeat.o(233326);
      return 0;
    }
    localc = new com.tencent.mm.compatible.i.c();
    i = k;
    try
    {
      localc.setDataSource(paramString);
      i = k;
      m = localc.getTrackCount();
      j = 0;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int m;
        int j;
        Object localObject;
        localException1 = localException1;
        localc.release();
      }
    }
    finally
    {
      localc.release();
      AppMethodBeat.o(233326);
    }
    if (j < m)
    {
      i = k;
      localObject = localc.getTrackFormat(j);
      i = k;
      p.j(localObject, "extractor.getTrackFormat(i)");
      i = k;
      localObject = ((MediaFormat)localObject).getString("mime");
      if (localObject != null)
      {
        i = k;
        if (n.g((CharSequence)localObject, (CharSequence)"video") == true)
        {
          i = k;
          localc.selectTrack(j);
        }
      }
    }
    else
    {
      i = k;
      localObject = ByteBuffer.allocate(102400);
      i = 0;
      j = i;
    }
  }
  
  public static float gwN()
  {
    AppMethodBeat.i(233318);
    e locale = e.NuX;
    if (e.gvk())
    {
      AppMethodBeat.o(233318);
      return 1.333333F;
    }
    AppMethodBeat.o(233318);
    return 1.166667F;
  }
  
  public static float gwO()
  {
    return NGM;
  }
  
  public static void hL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(233325);
    p.k(paramString1, "source");
    p.k(paramString2, "dst");
    com.tencent.mm.plugin.gallery.picker.b.c localc = com.tencent.mm.plugin.gallery.picker.b.c.BXE;
    com.tencent.mm.plugin.gallery.picker.b.c.hL(paramString1, paramString2);
    AppMethodBeat.o(233325);
  }
  
  public static RectF j(RectF paramRectF)
  {
    AppMethodBeat.i(233328);
    p.k(paramRectF, "valid");
    int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 208);
    int j = ar.au(MMApplicationContext.getContext()).y;
    int k = ax.aB(MMApplicationContext.getContext());
    paramRectF = new RectF(0.0F, paramRectF.top, paramRectF.right, Math.min(j - i - k, paramRectF.bottom));
    AppMethodBeat.o(233328);
    return paramRectF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.util.a
 * JD-Core Version:    0.7.0.1
 */