package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxTemplateManager;", "", "()V", "TAG", "", "getImageOcrTemplateHtmlFile", "getScanGoodsTemplateHtmlFile", "plugin-scan_release"})
public final class o
{
  public static final o IHL;
  
  static
  {
    AppMethodBeat.i(52135);
    IHL = new o();
    AppMethodBeat.o(52135);
  }
  
  public static String fCk()
  {
    AppMethodBeat.i(221166);
    Object localObject = ai.anf(4);
    p.j(localObject, "WebSearchApiLogic.getSea…TEMPLATE_TYPE_SCAN_GOODS)");
    localObject = ((at)localObject).gRg();
    Log.v("MicroMsg.ScanBoxTemplateManager", "alvinluo getScanGoodsTemplateHtmlFile: %s", new Object[] { localObject });
    p.j(localObject, "htmlPath");
    AppMethodBeat.o(221166);
    return localObject;
  }
  
  public static String fCl()
  {
    AppMethodBeat.i(221168);
    Object localObject = ai.anf(8);
    p.j(localObject, "WebSearchApiLogic.getSea….TEMPLATE_TYPE_IMAGE_OCR)");
    localObject = ((at)localObject).gRg();
    Log.v("MicroMsg.ScanBoxTemplateManager", "alvinluo getImageOcrTemplateHtmlFile templateHtmlPath: %s", new Object[] { localObject });
    p.j(localObject, "htmlPath");
    AppMethodBeat.o(221168);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.o
 * JD-Core Version:    0.7.0.1
 */