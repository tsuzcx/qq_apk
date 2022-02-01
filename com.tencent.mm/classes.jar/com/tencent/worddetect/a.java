package com.tencent.worddetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.util.a.f;
import com.tencent.mm.plugin.scanner.util.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/worddetect/WordDetectImageCompressStrategy;", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressStrategy;", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressDefaultRequest;", "()V", "computeSampleSize", "", "request", "width", "height", "isSizeValid", "", "name", "", "onTransform", "Landroid/graphics/Bitmap;", "bitmap", "Companion", "scan-sdk_release"})
public final class a
  implements i<f>
{
  public static final a ZYA;
  private static int ZYz;
  
  static
  {
    AppMethodBeat.i(193288);
    ZYA = new a((byte)0);
    ZYz = 11;
    AppMethodBeat.o(193288);
  }
  
  public a()
  {
    AppMethodBeat.i(193286);
    int i = ((b)h.ae(b.class)).a(b.a.vOd, 0);
    if (10 > i) {}
    for (;;)
    {
      Log.i("MicroMsg.WordDetectImageCompressStrategy", "alvinluo initWordDetectImageCompressStrategy ratioLimit: %s, config: %s", new Object[] { Integer.valueOf(ZYz), Integer.valueOf(i) });
      AppMethodBeat.o(193286);
      return;
      if (15 >= i) {
        ZYz = i;
      }
    }
  }
  
  public final boolean jo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193276);
    float f = paramInt2 * 1.0F / paramInt1;
    if ((f > ZYz) || (f < 1.0F / ZYz))
    {
      Log.w("MicroMsg.WordDetectImageCompressStrategy", "isSizeValid ratio invalid ".concat(String.valueOf(f)));
      AppMethodBeat.o(193276);
      return false;
    }
    AppMethodBeat.o(193276);
    return true;
  }
  
  public final String name()
  {
    return "MicroMsg.WordDetectImageCompressStrategy";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/worddetect/WordDetectImageCompressStrategy$Companion;", "", "()V", "MIN_LONG_SIZE", "", "MIN_SHORT_SIZE", "TAG", "", "WIDTH_HEIGHT_RATIO_MAX", "WIDTH_HEIGHT_RATIO_MIN", "ratioLimit", "scan-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.worddetect.a
 * JD-Core Version:    0.7.0.1
 */