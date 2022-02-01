package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanImagePHashUtil;", "", "()V", "TAG", "", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imagePath", "plugin-scan_release"})
public final class aa
{
  public static final aa ILM;
  
  static
  {
    AppMethodBeat.i(217462);
    ILM = new aa();
    AppMethodBeat.o(217462);
  }
  
  public static ScanImagePHashInfo aXh(String paramString)
  {
    AppMethodBeat.i(217459);
    p.k(paramString, "imagePath");
    for (;;)
    {
      try
      {
        localObject = BitmapUtil.decodeFile(paramString);
        if (localObject != null)
        {
          int i = ((Bitmap)localObject).getWidth();
          int j = ((Bitmap)localObject).getHeight();
          Log.i("MicroMsg.ScanImagePHashUtil", "computeImagePHash width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          paramString = new int[i * j];
          ((Bitmap)localObject).getPixels(paramString, 0, ((Bitmap)localObject).getWidth(), 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          ((Bitmap)localObject).recycle();
          localObject = new byte[i * j];
          int k = d.a(paramString, (byte[])localObject, i, j);
          if (k != 0)
          {
            Log.e("MicroMsg.ScanImagePHashUtil", "computeImagePHash transBytes failed result: %d", new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(217459);
            return null;
          }
          ScanImagePHashInfo localScanImagePHashInfo = v.O((byte[])localObject, i, j);
          if (localScanImagePHashInfo == null) {
            break label219;
          }
          paramString = localScanImagePHashInfo.pHash;
          if (localScanImagePHashInfo == null) {
            break label224;
          }
          localObject = localScanImagePHashInfo.pHashVersion;
          Log.d("MicroMsg.ScanImagePHashUtil", "alvinluo computeImagePHash pHash: %s, pHashVersion: %s", new Object[] { paramString, localObject });
          AppMethodBeat.o(217459);
          return localScanImagePHashInfo;
        }
      }
      catch (Throwable paramString)
      {
        Log.printErrStackTrace("MicroMsg.ScanImagePHashUtil", paramString, "computeImagePHash exception", new Object[0]);
        AppMethodBeat.o(217459);
        return null;
      }
      label219:
      paramString = null;
      continue;
      label224:
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.aa
 * JD-Core Version:    0.7.0.1
 */