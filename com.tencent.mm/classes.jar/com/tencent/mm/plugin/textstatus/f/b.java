package com.tencent.mm.plugin.textstatus.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"SubThread", "", "callback", "Lkotlin/Function0;", "", "decodeImg", "Landroid/graphics/Bitmap;", "filePath", "", "saveBitmap", "bitmap", "path", "plugin-textstatus_release"})
public final class b
{
  public static final void ah(a<? extends Object> parama)
  {
    AppMethodBeat.i(237695);
    p.k(parama, "callback");
    h.ZvG.be((Runnable)new a(parama));
    AppMethodBeat.o(237695);
  }
  
  public static final Bitmap bes(String paramString)
  {
    AppMethodBeat.i(237692);
    Bitmap localBitmap2 = BitmapUtil.decodeFileWithSample(paramString);
    Bitmap localBitmap1 = localBitmap2;
    int i;
    int j;
    int k;
    if (localBitmap2 != null)
    {
      i = localBitmap2.getWidth();
      j = localBitmap2.getHeight();
      k = ForceGpuUtil.getMaxTextureSize();
      if (i <= k) {
        break label72;
      }
      localBitmap1 = BitmapUtil.getCenterCropBitmap(localBitmap2, k, localBitmap2.getHeight(), true);
    }
    for (;;)
    {
      i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(237692);
      return localBitmap1;
      label72:
      localBitmap1 = localBitmap2;
      if (j > k) {
        localBitmap1 = BitmapUtil.getCenterCropBitmap(localBitmap2, localBitmap2.getWidth(), k, true);
      }
    }
    paramString = BitmapUtil.rotateAndScale(localBitmap1, i, 1.0F, 1.0F);
    AppMethodBeat.o(237692);
    return paramString;
  }
  
  public static final void i(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(237691);
    p.k(paramString, "path");
    if (paramBitmap == null) {}
    try
    {
      AppMethodBeat.o(237691);
      return;
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.TextStatus.StatusImgHandler", "save bitmap to image failed: ".concat(String.valueOf(paramBitmap)));
      AppMethodBeat.o(237691);
    }
    BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, false);
    AppMethodBeat.o(237691);
    return;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(237106);
      this.kWs.invoke();
      AppMethodBeat.o(237106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.b
 * JD-Core Version:    0.7.0.1
 */