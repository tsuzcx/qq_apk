package com.tencent.mm.plugin.scanner.util.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/compress/ScanCodeImageCompressStrategy;", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressStrategy;", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanCodeImageCompressRequest;", "()V", "configMaxImageSize", "", "getConfigMaxImageSize", "()I", "configMaxImageSize$delegate", "Lkotlin/Lazy;", "computeSampleSize", "request", "width", "height", "isSizeValid", "", "name", "", "onTransform", "Landroid/graphics/Bitmap;", "bitmap", "Companion", "scan-sdk_release"})
public final class d
  implements i<c>
{
  public static final a Jad;
  private final f Jac;
  
  static
  {
    AppMethodBeat.i(193529);
    Jad = new a((byte)0);
    AppMethodBeat.o(193529);
  }
  
  public d()
  {
    AppMethodBeat.i(193528);
    this.Jac = g.ar((a)b.Jae);
    AppMethodBeat.o(193528);
  }
  
  public final boolean jo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193525);
    if ((paramInt1 < 4) || (paramInt2 < 4))
    {
      Log.w("MicroMsg.ScanCodeImageCompressStrategy", "isSizeValid invalid width: " + paramInt1 + ", height: " + paramInt2);
      AppMethodBeat.o(193525);
      return false;
    }
    AppMethodBeat.o(193525);
    return true;
  }
  
  public final String name()
  {
    return "MicroMsg.ScanCodeImageCompressStrategy";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/compress/ScanCodeImageCompressStrategy$Companion;", "", "()V", "DEFAULT_SCAN_CODE_IMAGE_SIZE", "", "MAX_SCAN_CODE_IMAGE_SIZE", "MIN_IMAGE_SIZE", "MIN_SCAN_CODE_IMAGE_SIZE", "TAG", "", "scan-sdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Integer>
  {
    public static final b Jae;
    
    static
    {
      AppMethodBeat.i(192599);
      Jae = new b();
      AppMethodBeat.o(192599);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a.d
 * JD-Core Version:    0.7.0.1
 */