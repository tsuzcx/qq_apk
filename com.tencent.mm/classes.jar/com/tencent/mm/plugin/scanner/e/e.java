package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.api.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRReporter;", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRReporter;", "()V", "opReported", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "key", "opType", "", "scene", "reportOCRMenuOp", "", "reset", "Companion", "ResultOpType", "ZoomOpType", "plugin-scan_release"})
public final class e
  implements b
{
  public static final a CIJ;
  private final HashMap<String, Boolean> CII;
  
  static
  {
    AppMethodBeat.i(240553);
    CIJ = new a((byte)0);
    AppMethodBeat.o(240553);
  }
  
  public e()
  {
    AppMethodBeat.i(240552);
    this.CII = new HashMap();
    AppMethodBeat.o(240552);
  }
  
  public final void hY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240551);
    String str = paramInt1 + ',' + paramInt2;
    Log.v("MicroMsg.ImageOCRReporter", "alvinluo reportOCRMenuOp key: %s, reported: %s", new Object[] { str, this.CII.get(str) });
    if ((p.j((Boolean)this.CII.get(str), Boolean.TRUE) ^ true))
    {
      ((Map)this.CII).put(str, Boolean.TRUE);
      h.CyF.a(22143, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    }
    AppMethodBeat.o(240551);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(240550);
    Log.v("MicroMsg.ImageOCRReporter", "alvinluo ImageOCRReporter reset");
    this.CII.clear();
    AppMethodBeat.o(240550);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRReporter$Companion;", "", "()V", "TAG", "", "reportImageOCRResultOp", "", "sessionId", "", "opType", "", "reportImageZoomOp", "zoomOpType", "plugin-scan_release"})
  public static final class a
  {
    public static void S(long paramLong, int paramInt)
    {
      AppMethodBeat.i(240548);
      h.CyF.a(21699, new Object[] { String.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(240548);
    }
    
    public static void T(long paramLong, int paramInt)
    {
      AppMethodBeat.i(240549);
      h.CyF.a(21700, new Object[] { String.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(240549);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.e
 * JD-Core Version:    0.7.0.1
 */