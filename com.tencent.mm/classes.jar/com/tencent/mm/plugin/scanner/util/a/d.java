package com.tencent.mm.plugin.scanner.util.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/compress/ScanCodeImageCompressStrategy;", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressStrategy;", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanCodeImageCompressRequest;", "()V", "configMaxImageSize", "", "getConfigMaxImageSize", "()I", "configMaxImageSize$delegate", "Lkotlin/Lazy;", "computeSampleSize", "request", "width", "height", "isSizeValid", "", "name", "", "onTransform", "Landroid/graphics/Bitmap;", "bitmap", "Companion", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements i<c>
{
  public static final a PjU;
  private final j PjV;
  
  static
  {
    AppMethodBeat.i(314153);
    PjU = new a((byte)0);
    AppMethodBeat.o(314153);
  }
  
  public d()
  {
    AppMethodBeat.i(314149);
    this.PjV = k.cm((a)b.PjW);
    AppMethodBeat.o(314149);
  }
  
  public final boolean kW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(314159);
    if ((paramInt1 < 4) || (paramInt2 < 4))
    {
      Log.w("MicroMsg.ScanCodeImageCompressStrategy", "isSizeValid invalid width: " + paramInt1 + ", height: " + paramInt2);
      AppMethodBeat.o(314159);
      return false;
    }
    AppMethodBeat.o(314159);
    return true;
  }
  
  public final String name()
  {
    return "MicroMsg.ScanCodeImageCompressStrategy";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/compress/ScanCodeImageCompressStrategy$Companion;", "", "()V", "DEFAULT_SCAN_CODE_IMAGE_SIZE", "", "MAX_SCAN_CODE_IMAGE_SIZE", "MIN_IMAGE_SIZE", "MIN_SCAN_CODE_IMAGE_SIZE", "TAG", "", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Integer>
  {
    public static final b PjW;
    
    static
    {
      AppMethodBeat.i(314147);
      PjW = new b();
      AppMethodBeat.o(314147);
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