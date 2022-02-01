package com.tencent.mm.plugin.vlog.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.vlog.ui.plugin.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/util/FinderEditUtil;", "", "()V", "FULLSCREEN_RATIO", "", "getFULLSCREEN_RATIO", "()F", "MIN_RATIO", "NORMAL_RATIO", "getNORMAL_RATIO", "RATIO_TOLERANCE", "SUPPORT_RATIO", "TAG", "", "cropThumb", "Landroid/graphics/Bitmap;", "thumb", "cropRect", "Landroid/graphics/Rect;", "getGOPSize", "", "path", "getRatio", "width", "height", "keepPhotoExifInfo", "", "source", "dst", "makePhotoSizeConformity", "maxSize", "", "quality", "bitmap", "savePhotoThumbNail", "compressQuality", "plugin-vlog_release"})
public final class a
{
  private static final float GQB;
  public static final a GQC;
  
  static
  {
    AppMethodBeat.i(192226);
    GQC = new a();
    GQB = ((b)g.af(b.class)).a(b.a.snK, 1.777778F);
    AppMethodBeat.o(192226);
  }
  
  public static void a(int paramInt, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(192223);
    p.h(paramBitmap, "bitmap");
    p.h(paramString, "path");
    BitmapUtil.saveBitmapToImage(paramBitmap, paramInt, Bitmap.CompressFormat.JPEG, paramString, false);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while ((0L > 0L) && (s.boW(paramString) > 0L) && (i > 0) && (paramInt <= 5))
    {
      i -= 5;
      BitmapUtil.saveBitmapToImage(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, false);
      paramInt += 1;
    }
    Log.i("MicroMsg.FinderEditUtil", "makePhotoSizeConformity  maxSize:0  compressQuality:" + i + " size:" + s.YS(paramString));
    AppMethodBeat.o(192223);
  }
  
  public static int aUr(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(192225);
    p.h(paramString, "path");
    boolean bool = ((b)g.af(b.class)).a(b.a.slH, true);
    Log.i("MicroMsg.FinderEditUtil", "getGOPSize path:" + paramString + " enable:" + bool);
    if ((!s.YS(paramString)) && (bool))
    {
      AppMethodBeat.o(192225);
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
      AppMethodBeat.o(192225);
    }
    if (j < m)
    {
      i = k;
      localObject = localc.getTrackFormat(j);
      i = k;
      p.g(localObject, "extractor.getTrackFormat(i)");
      i = k;
      localObject = ((MediaFormat)localObject).getString("mime");
      if (localObject != null)
      {
        i = k;
        if (n.e((CharSequence)localObject, (CharSequence)"video") == true)
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
  
  public static float fEA()
  {
    AppMethodBeat.i(192222);
    f localf = f.GHk;
    if (f.fDl())
    {
      AppMethodBeat.o(192222);
      return 1.333333F;
    }
    AppMethodBeat.o(192222);
    return 1.166667F;
  }
  
  public static float fEB()
  {
    return GQB;
  }
  
  public static void lm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192224);
    p.h(paramString1, "source");
    p.h(paramString2, "dst");
    com.tencent.mm.plugin.gallery.picker.b.c localc = com.tencent.mm.plugin.gallery.picker.b.c.Uqd;
    com.tencent.mm.plugin.gallery.picker.b.c.lm(paramString1, paramString2);
    AppMethodBeat.o(192224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.util.a
 * JD-Core Version:    0.7.0.1
 */