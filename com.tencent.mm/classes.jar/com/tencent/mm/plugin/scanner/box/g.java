package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxTemplateManager;", "", "()V", "TAG", "", "getBoxTemplateHtmlFile", "plugin-scan_release"})
public final class g
{
  public static final g wXt;
  
  static
  {
    AppMethodBeat.i(52135);
    wXt = new g();
    AppMethodBeat.o(52135);
  }
  
  public static String dzh()
  {
    AppMethodBeat.i(52134);
    Object localObject = z.Uj(4);
    k.g(localObject, "WebSearchApiLogic.getSea…TEMPLATE_TYPE_SCAN_GOODS)");
    localObject = ((ak)localObject).exI();
    ac.v("MicroMsg.ScanBoxTemplateManager", "alvinluo ScanBox templateHtmlPath: %s", new Object[] { localObject });
    k.g(localObject, "htmlPath");
    AppMethodBeat.o(52134);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.g
 * JD-Core Version:    0.7.0.1
 */