package com.tencent.mm.plugin.vlog.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ExifInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.ui.plugin.d;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/util/FinderEditUtil;", "", "()V", "MIN_RATIO", "", "NORMAL_RATIO", "getNORMAL_RATIO", "()F", "TAG", "", "getRatio", "width", "", "height", "keepPhotoExifInfo", "", "source", "dst", "makePhotoSizeConformity", "maxSize", "", "quality", "bitmap", "Landroid/graphics/Bitmap;", "path", "savePhotoThumbNail", "compressQuality", "plugin-vlog_release"})
public final class a
{
  public static final a CmB;
  
  static
  {
    AppMethodBeat.i(192379);
    CmB = new a();
    AppMethodBeat.o(192379);
  }
  
  public static void a(int paramInt, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(192377);
    p.h(paramBitmap, "bitmap");
    p.h(paramString, "path");
    com.tencent.mm.sdk.platformtools.h.a(paramBitmap, paramInt, Bitmap.CompressFormat.JPEG, paramString, false);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while ((0L > 0L) && (o.aZR(paramString) > 0L) && (i > 0) && (paramInt <= 5))
    {
      i -= 5;
      com.tencent.mm.sdk.platformtools.h.a(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, false);
      paramInt += 1;
    }
    new StringBuilder("makePhotoSizeConformity  maxSize:0  compressQuality:").append(i).append(" size:").append(o.fB(paramString));
    com.tencent.d.f.h.fYG();
    AppMethodBeat.o(192377);
  }
  
  public static float exN()
  {
    AppMethodBeat.i(192376);
    d locald = d.CeI;
    if (d.ewY())
    {
      AppMethodBeat.o(192376);
      return 1.333333F;
    }
    AppMethodBeat.o(192376);
    return 1.166667F;
  }
  
  public static void ku(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192378);
    p.h(paramString1, "source");
    p.h(paramString2, "dst");
    Object localObject = new ExifInterface(o.k(paramString1, false));
    paramString1 = ((ExifInterface)localObject).getAttribute("GPSLongitude");
    String str1 = ((ExifInterface)localObject).getAttribute("GPSLatitude");
    String str2 = ((ExifInterface)localObject).getAttribute("GPSLongitudeRef");
    String str3 = ((ExifInterface)localObject).getAttribute("GPSLatitudeRef");
    String str4 = ((ExifInterface)localObject).getAttribute("GPSDestLongitude");
    localObject = ((ExifInterface)localObject).getAttribute("GPSDestLongitudeRef");
    paramString2 = new ExifInterface(o.k(paramString2, false));
    paramString2.setAttribute("GPSLongitude", paramString1);
    paramString2.setAttribute("GPSLatitude", str1);
    paramString2.setAttribute("GPSLongitudeRef", str2);
    paramString2.setAttribute("GPSLatitudeRef", str3);
    paramString2.setAttribute("GPSDestLongitude", str4);
    paramString2.setAttribute("GPSDestLongitudeRef", (String)localObject);
    paramString2.saveAttributes();
    AppMethodBeat.o(192378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.util.a
 * JD-Core Version:    0.7.0.1
 */