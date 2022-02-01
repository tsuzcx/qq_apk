package com.tencent.worddetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.scanner.util.a.f;
import com.tencent.mm.plugin.scanner.util.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/worddetect/WordDetectImageCompressStrategy;", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressStrategy;", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressDefaultRequest;", "()V", "computeSampleSize", "", "request", "width", "height", "isSizeValid", "", "name", "", "onTransform", "Landroid/graphics/Bitmap;", "bitmap", "Companion", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements i<f>
{
  public static final a aidd;
  private static int aide;
  
  static
  {
    AppMethodBeat.i(210662);
    aidd = new a((byte)0);
    aide = 11;
    AppMethodBeat.o(210662);
  }
  
  public a()
  {
    AppMethodBeat.i(210643);
    int j = ((c)h.ax(c.class)).a(c.a.zgu, 0);
    int i;
    if (10 <= j) {
      if (j <= 15) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        aide = j;
      }
      Log.i("MicroMsg.WordDetectImageCompressStrategy", "alvinluo initWordDetectImageCompressStrategy ratioLimit: %s, config: %s", new Object[] { Integer.valueOf(aide), Integer.valueOf(j) });
      AppMethodBeat.o(210643);
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static final boolean qd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210652);
    boolean bool = a.qd(paramInt1, paramInt2);
    AppMethodBeat.o(210652);
    return bool;
  }
  
  public final boolean kW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210668);
    if (!a.qd(paramInt1, paramInt2))
    {
      AppMethodBeat.o(210668);
      return true;
    }
    AppMethodBeat.o(210668);
    return false;
  }
  
  public final String name()
  {
    return "MicroMsg.WordDetectImageCompressStrategy";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/worddetect/WordDetectImageCompressStrategy$Companion;", "", "()V", "MIN_LONG_SIZE", "", "MIN_SHORT_SIZE", "TAG", "", "WIDTH_HEIGHT_RATIO_MAX", "WIDTH_HEIGHT_RATIO_MIN", "ratioLimit", "isOverRatioLimit", "", "width", "height", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean qd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210649);
      float f = paramInt2 * 1.0F / paramInt1;
      if ((f > a.keK()) || (f < 1.0F / a.keK()))
      {
        Log.w("MicroMsg.WordDetectImageCompressStrategy", s.X("isOverRatioLimit ratio invalid ", Float.valueOf(f)));
        AppMethodBeat.o(210649);
        return true;
      }
      AppMethodBeat.o(210649);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.worddetect.a
 * JD-Core Version:    0.7.0.1
 */