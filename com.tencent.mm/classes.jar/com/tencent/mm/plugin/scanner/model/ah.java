package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanImagePHashUtil;", "", "()V", "MAX_IMAGE_SIZE", "", "TAG", "", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imagePath", "computeSampleSize", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  public static final ah OSL;
  
  static
  {
    AppMethodBeat.i(314253);
    OSL = new ah();
    AppMethodBeat.o(314253);
  }
  
  public static ScanImagePHashInfo aUL(String paramString)
  {
    AppMethodBeat.i(314222);
    s.u(paramString, "imagePath");
    for (;;)
    {
      Object localObject2;
      try
      {
        int k = aUM(paramString);
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inSampleSize = k;
        localObject2 = kotlin.ah.aiuX;
        localObject1 = BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject1);
        if (localObject1 == null) {
          continue;
        }
        int i = ((Bitmap)localObject1).getWidth();
        int j = ((Bitmap)localObject1).getHeight();
        Log.i("MicroMsg.ScanImagePHashUtil", "computeImagePHash width: %d, height: %d, sampleSize: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        paramString = new int[i * j];
        ((Bitmap)localObject1).getPixels(paramString, 0, ((Bitmap)localObject1).getWidth(), 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        ((Bitmap)localObject1).recycle();
        localObject1 = new byte[i * j];
        k = d.a(paramString, (byte[])localObject1, i, j);
        if (k != 0)
        {
          Log.e("MicroMsg.ScanImagePHashUtil", "computeImagePHash transBytes failed result: %d", new Object[] { Integer.valueOf(k) });
          AppMethodBeat.o(314222);
          return null;
        }
        localObject2 = ac.M((byte[])localObject1, i, j);
        if (localObject2 != null) {
          break label240;
        }
        paramString = null;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ScanImagePHashUtil", paramString, "computeImagePHash exception", new Object[0]);
        AppMethodBeat.o(314222);
        return null;
      }
      Log.d("MicroMsg.ScanImagePHashUtil", "alvinluo computeImagePHash pHash: %s, pHashVersion: %s", new Object[] { paramString, localObject1 });
      AppMethodBeat.o(314222);
      return localObject2;
      label240:
      paramString = ((ScanImagePHashInfo)localObject2).pHash;
      while (localObject2 != null)
      {
        localObject1 = ((ScanImagePHashInfo)localObject2).pHashVersion;
        break;
      }
      Object localObject1 = null;
    }
  }
  
  private static int aUM(String paramString)
  {
    AppMethodBeat.i(314243);
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      i = localOptions.outHeight * i;
      if (i > 1166400)
      {
        float f = i / 1166400.0F;
        if (f > 1.0F)
        {
          i = (int)(float)Math.ceil((float)Math.sqrt(f));
          AppMethodBeat.o(314243);
          return i;
        }
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScanImagePHashUtil", (Throwable)paramString, "computeSampleSize exception", new Object[0]);
      AppMethodBeat.o(314243);
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ah
 * JD-Core Version:    0.7.0.1
 */