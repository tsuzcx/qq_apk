package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxTemplateManager;", "", "()V", "TAG", "", "getImageOcrTemplateHtmlFile", "getScanGoodsTemplateHtmlFile", "plugin-scan_release"})
public final class o
{
  public static final o CDl;
  
  static
  {
    AppMethodBeat.i(52135);
    CDl = new o();
    AppMethodBeat.o(52135);
  }
  
  public static String ePx()
  {
    AppMethodBeat.i(240300);
    Object localObject = ai.afr(4);
    p.g(localObject, "WebSearchApiLogic.getSea…TEMPLATE_TYPE_SCAN_GOODS)");
    localObject = ((at)localObject).fYv();
    Log.v("MicroMsg.ScanBoxTemplateManager", "alvinluo getScanGoodsTemplateHtmlFile: %s", new Object[] { localObject });
    p.g(localObject, "htmlPath");
    AppMethodBeat.o(240300);
    return localObject;
  }
  
  public static String ePy()
  {
    AppMethodBeat.i(240301);
    Object localObject = ai.afr(8);
    p.g(localObject, "WebSearchApiLogic.getSea….TEMPLATE_TYPE_IMAGE_OCR)");
    localObject = ((at)localObject).fYv();
    Log.v("MicroMsg.ScanBoxTemplateManager", "alvinluo getImageOcrTemplateHtmlFile templateHtmlPath: %s", new Object[] { localObject });
    p.g(localObject, "htmlPath");
    AppMethodBeat.o(240301);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.o
 * JD-Core Version:    0.7.0.1
 */