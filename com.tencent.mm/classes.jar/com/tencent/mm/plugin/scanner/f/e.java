package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.api.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRReporter;", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRReporter;", "()V", "opReported", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "key", "opType", "", "scene", "reportOCRMenuOp", "", "reset", "Companion", "ResultOpType", "ZoomOpType", "plugin-scan_release"})
public final class e
  implements b
{
  public static final a INz;
  private final HashMap<String, Boolean> INy;
  
  static
  {
    AppMethodBeat.i(219122);
    INz = new a((byte)0);
    AppMethodBeat.o(219122);
  }
  
  public e()
  {
    AppMethodBeat.i(219119);
    this.INy = new HashMap();
    AppMethodBeat.o(219119);
  }
  
  public final void jc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219118);
    String str = paramInt1 + ',' + paramInt2;
    Log.v("MicroMsg.ImageOCRReporter", "alvinluo reportOCRMenuOp key: %s, reported: %s", new Object[] { str, this.INy.get(str) });
    if ((p.h((Boolean)this.INy.get(str), Boolean.TRUE) ^ true))
    {
      ((Map)this.INy).put(str, Boolean.TRUE);
      h.IzE.a(22143, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    }
    AppMethodBeat.o(219118);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(219110);
    Log.v("MicroMsg.ImageOCRReporter", "alvinluo ImageOCRReporter reset");
    this.INy.clear();
    AppMethodBeat.o(219110);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRReporter$Companion;", "", "()V", "TAG", "", "reportImageOCRResultOp", "", "sessionId", "", "opType", "", "reportImageZoomOp", "zoomOpType", "plugin-scan_release"})
  public static final class a
  {
    public static void ab(long paramLong, int paramInt)
    {
      AppMethodBeat.i(220921);
      h.IzE.a(21699, new Object[] { String.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(220921);
    }
    
    public static void ac(long paramLong, int paramInt)
    {
      AppMethodBeat.i(220923);
      h.IzE.a(21700, new Object[] { String.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(220923);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.e
 * JD-Core Version:    0.7.0.1
 */