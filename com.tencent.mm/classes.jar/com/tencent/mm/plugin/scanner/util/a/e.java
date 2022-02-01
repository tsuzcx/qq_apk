package com.tencent.mm.plugin.scanner.util.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/compress/ScanCompressImageUtils;", "", "()V", "COMPRESS_LOOP_TAG_DEFAULT", "", "TAG", "compressImageAsync", "", "T", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressRequest;", "request", "compressStrategy", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressStrategy;", "compressCallback", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressCallback;", "singleThread", "", "loopTag", "(Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressRequest;Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressStrategy;Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressCallback;ZLjava/lang/String;)V", "compressImageSync", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressResult;", "(Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressRequest;Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressStrategy;)Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressResult;", "doCompressImage", "(Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressRequest;Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressStrategy;Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressCallback;)Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressResult;", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e PjX;
  
  static
  {
    AppMethodBeat.i(314195);
    PjX = new e();
    AppMethodBeat.o(314195);
  }
  
  public static final <T extends g> h a(T paramT, i<T> parami)
  {
    AppMethodBeat.i(314171);
    s.u(paramT, "request");
    s.u(parami, "compressStrategy");
    paramT = b(paramT, parami);
    AppMethodBeat.o(314171);
    return paramT;
  }
  
  private static <T extends g> h b(T paramT, i<T> parami)
  {
    AppMethodBeat.i(314188);
    long l1 = System.currentTimeMillis();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    long l2 = paramT.bSj();
    String str = paramT.gUr();
    BitmapUtil.decodeFile(str, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    h localh = new h();
    if ((i <= 0) || (j <= 0))
    {
      Log.e("MicroMsg.ScanCompressImageUtils", "compressImage invalid width: " + i + ", height: " + j);
      localh.success = false;
      AppMethodBeat.o(314188);
      return localh;
    }
    if (!parami.kW(i, j))
    {
      Log.e("MicroMsg.ScanCompressImageUtils", "compressImage isSizeValid false width: " + i + ", height: " + j);
      localh.success = false;
      AppMethodBeat.o(314188);
      return localh;
    }
    int k = parami.j(paramT, i, j);
    Log.i("MicroMsg.ScanCompressImageUtils", "compressImage inSampleSize: " + k + ", origin size: " + localOptions.outWidth + ", " + localOptions.outHeight + ", strategy: " + parami.name() + ", session: " + l2);
    Bitmap localBitmap = null;
    localObject = localBitmap;
    try
    {
      localOptions.inSampleSize = k;
      localObject = localBitmap;
      localOptions.inJustDecodeBounds = false;
      localObject = localBitmap;
      localBitmap = BitmapUtil.decodeFile(str, localOptions);
      localObject = localBitmap;
      paramT = parami.a(paramT, localBitmap);
      localObject = paramT;
    }
    finally
    {
      for (;;)
      {
        long l3;
        Log.printErrStackTrace("MicroMsg.ScanCompressImageUtils", paramT, "compressImage exception", new Object[0]);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1259, 170);
        continue;
        paramT = Integer.valueOf(((Bitmap)localObject).getWidth());
        continue;
        paramT = Integer.valueOf(((Bitmap)localObject).getHeight());
        continue;
        boolean bool = false;
      }
    }
    l3 = System.currentTimeMillis();
    parami = new StringBuilder("compressImage decode result, width: ");
    if (localObject == null)
    {
      paramT = null;
      parami = parami.append(paramT).append(", height: ");
      if (localObject != null) {
        break label482;
      }
      paramT = null;
      Log.i("MicroMsg.ScanCompressImageUtils", paramT + ", cost: " + (l3 - l1) + " ms, session: " + l2);
      localh.PjY = new Point(i, j);
      localh.bitmap = ((Bitmap)localObject);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label494;
      }
      bool = true;
      localh.success = bool;
      AppMethodBeat.o(314188);
      return localh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a.e
 * JD-Core Version:    0.7.0.1
 */