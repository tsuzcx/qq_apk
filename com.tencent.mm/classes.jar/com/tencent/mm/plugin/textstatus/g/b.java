package com.tencent.mm.plugin.textstatus.g;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"SubThread", "", "callback", "Lkotlin/Function0;", "", "decodeImg", "Landroid/graphics/Bitmap;", "filePath", "", "saveBitmap", "bitmap", "path", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final Bitmap aXb(String paramString)
  {
    AppMethodBeat.i(289848);
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
      AppMethodBeat.o(289848);
      return localBitmap1;
      label72:
      localBitmap1 = localBitmap2;
      if (j > k) {
        localBitmap1 = BitmapUtil.getCenterCropBitmap(localBitmap2, localBitmap2.getWidth(), k, true);
      }
    }
    paramString = BitmapUtil.rotateAndScale(localBitmap1, i, 1.0F, 1.0F);
    AppMethodBeat.o(289848);
    return paramString;
  }
  
  public static final void bP(a<? extends Object> parama)
  {
    AppMethodBeat.i(289855);
    s.u(parama, "callback");
    h.ahAA.bm(new b..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(289855);
  }
  
  private static final void bQ(a parama)
  {
    AppMethodBeat.i(289862);
    s.u(parama, "$callback");
    parama.invoke();
    AppMethodBeat.o(289862);
  }
  
  public static final void m(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(289837);
    s.u(paramString, "path");
    if (paramBitmap == null) {}
    try
    {
      AppMethodBeat.o(289837);
      return;
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.TextStatus.StatusImgHandler", s.X("save bitmap to image failed: ", paramBitmap));
      AppMethodBeat.o(289837);
    }
    BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, false);
    AppMethodBeat.o(289837);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.b
 * JD-Core Version:    0.7.0.1
 */