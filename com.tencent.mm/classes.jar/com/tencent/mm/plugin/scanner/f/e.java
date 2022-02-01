package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.api.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRReporter;", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRReporter;", "()V", "opReported", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "key", "opType", "", "scene", "reportOCRMenuOp", "", "reason", "reset", "Companion", "ResultOpType", "ZoomOpType", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements b
{
  public static final a OUC;
  private final HashMap<String, Boolean> OUD;
  
  static
  {
    AppMethodBeat.i(313476);
    OUC = new a((byte)0);
    AppMethodBeat.o(313476);
  }
  
  public e()
  {
    AppMethodBeat.i(313468);
    this.OUD = new HashMap();
    AppMethodBeat.o(313468);
  }
  
  public final void aZ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(313495);
    String str = paramInt1 + ',' + paramInt2;
    Log.v("MicroMsg.ImageOCRReporter", "alvinluo reportOCRMenuOp key: %s, reported: %s, reason: %s", new Object[] { str, this.OUD.get(str), Integer.valueOf(paramInt3) });
    if (!s.p(this.OUD.get(str), Boolean.TRUE))
    {
      ((Map)this.OUD).put(str, Boolean.TRUE);
      h.OAn.b(22143, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    }
    AppMethodBeat.o(313495);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(313483);
    Log.v("MicroMsg.ImageOCRReporter", "alvinluo ImageOCRReporter reset");
    this.OUD.clear();
    AppMethodBeat.o(313483);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRReporter$Companion;", "", "()V", "TAG", "", "reportImageOCRResultOp", "", "sessionId", "", "opType", "", "reportImageZoomOp", "zoomOpType", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void as(long paramLong, int paramInt)
    {
      AppMethodBeat.i(313463);
      h.OAn.b(21699, new Object[] { String.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(313463);
    }
    
    public static void at(long paramLong, int paramInt)
    {
      AppMethodBeat.i(313472);
      h.OAn.b(21700, new Object[] { String.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(313472);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.e
 * JD-Core Version:    0.7.0.1
 */