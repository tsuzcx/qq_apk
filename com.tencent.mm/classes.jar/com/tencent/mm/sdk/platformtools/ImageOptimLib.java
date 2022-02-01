package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class ImageOptimLib
{
  public static final int MAX_DECODE_PICTURE_SIZE = 2764800;
  
  public static boolean checkIntegrity(String paramString)
  {
    AppMethodBeat.i(215364);
    if ((Util.isNullOrNil(paramString)) || (!s.YS(paramString)))
    {
      AppMethodBeat.o(215364);
      return false;
    }
    boolean bool = MMJpegOptim.checkIntegrity(q.k(paramString, false));
    AppMethodBeat.o(215364);
    return bool;
  }
  
  public static int compressByQualityOptim(Bitmap paramBitmap, int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(215363);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(215363);
      return -1;
    }
    paramInt = MMJpegOptim.compressByQualityOptim(paramBitmap, paramInt, paramBoolean, q.k(paramString, false));
    AppMethodBeat.o(215363);
    return paramInt;
  }
  
  public static boolean convertToProgressive(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(215362);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (!s.YS(paramString1)))
    {
      AppMethodBeat.o(215362);
      return false;
    }
    if (MMJpegOptim.convertToProgressive(q.k(paramString1, false), q.k(paramString2, false), paramInt) == 0)
    {
      AppMethodBeat.o(215362);
      return true;
    }
    AppMethodBeat.o(215362);
    return false;
  }
  
  public static Bitmap extractThumbNailBeta(String paramString)
  {
    AppMethodBeat.i(215365);
    if ((Util.isNullOrNil(paramString)) || (!new o(paramString).exists()))
    {
      AppMethodBeat.o(215365);
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    Bitmap localBitmap = MMBitmapFactory.decodeFile(paramString, localOptions);
    if (localBitmap != null)
    {
      Log.i("ImageOptimLib", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
      localBitmap.recycle();
    }
    if (localOptions.inSampleSize <= 1) {
      localOptions.inSampleSize = 1;
    }
    if (localOptions.outHeight * localOptions.outWidth / localOptions.inSampleSize / localOptions.inSampleSize > 2764800) {
      localOptions.inSampleSize += 1;
    }
    if ((localOptions.inSampleSize < 0) || (localOptions.inSampleSize > 15)) {}
    int i;
    for (localOptions.inSampleSize = 1;; localOptions.inSampleSize = new short[] { 1, 1, 2, 2, 4, 4, 4, 4, 8, 8, 8, 8, 8, 8, 8, 8 }[i])
    {
      localBitmap = Bitmap.createBitmap((localOptions.outWidth + localOptions.inSampleSize - 1) / localOptions.inSampleSize, (localOptions.outHeight + localOptions.inSampleSize - 1) / localOptions.inSampleSize, Bitmap.Config.ARGB_8888);
      if (MMJpegOptim.decodeToBitmap(paramString, localBitmap, localOptions.inSampleSize) != 1) {
        break;
      }
      AppMethodBeat.o(215365);
      return localBitmap;
      i = localOptions.inSampleSize;
    }
    AppMethodBeat.o(215365);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ImageOptimLib
 * JD-Core Version:    0.7.0.1
 */