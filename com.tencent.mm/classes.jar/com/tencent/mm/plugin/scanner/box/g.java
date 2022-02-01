package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ao;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxTemplateManager;", "", "()V", "TAG", "", "getBoxTemplateHtmlFile", "plugin-scan_release"})
public final class g
{
  public static final g yle;
  
  static
  {
    AppMethodBeat.i(52135);
    yle = new g();
    AppMethodBeat.o(52135);
  }
  
  public static String dKF()
  {
    AppMethodBeat.i(52134);
    Object localObject = com.tencent.mm.plugin.websearch.api.ad.Wc(4);
    p.g(localObject, "WebSearchApiLogic.getSea…TEMPLATE_TYPE_SCAN_GOODS)");
    localObject = ((ao)localObject).eMz();
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanBoxTemplateManager", "alvinluo ScanBox templateHtmlPath: %s", new Object[] { localObject });
    p.g(localObject, "htmlPath");
    AppMethodBeat.o(52134);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.g
 * JD-Core Version:    0.7.0.1
 */