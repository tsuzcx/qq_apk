package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxTemplateManager;", "", "()V", "TAG", "", "getImageOcrTemplateHtmlFile", "getScanGoodsTemplateHtmlFile", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o ONO;
  
  static
  {
    AppMethodBeat.i(52135);
    ONO = new o();
    AppMethodBeat.o(52135);
  }
  
  public static String gPV()
  {
    AppMethodBeat.i(313750);
    String str = aj.asW(4).iqs();
    Log.v("MicroMsg.ScanBoxTemplateManager", "alvinluo getScanGoodsTemplateHtmlFile: %s", new Object[] { str });
    s.s(str, "htmlPath");
    AppMethodBeat.o(313750);
    return str;
  }
  
  public static String gPW()
  {
    AppMethodBeat.i(313757);
    String str = aj.asW(8).iqs();
    Log.v("MicroMsg.ScanBoxTemplateManager", "alvinluo getImageOcrTemplateHtmlFile templateHtmlPath: %s", new Object[] { str });
    s.s(str, "htmlPath");
    AppMethodBeat.o(313757);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.o
 * JD-Core Version:    0.7.0.1
 */