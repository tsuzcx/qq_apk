package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxTemplateManager;", "", "()V", "TAG", "", "getBoxTemplateHtmlFile", "plugin-scan_release"})
public final class g
{
  public static final g vNb;
  
  static
  {
    AppMethodBeat.i(52135);
    vNb = new g();
    AppMethodBeat.o(52135);
  }
  
  public static String dlf()
  {
    AppMethodBeat.i(52134);
    Object localObject = aa.RZ(4);
    k.g(localObject, "WebSearchApiLogic.getSea…TEMPLATE_TYPE_SCAN_GOODS)");
    localObject = ((am)localObject).eio();
    ad.v("MicroMsg.ScanBoxTemplateManager", "alvinluo ScanBox templateHtmlPath: %s", new Object[] { localObject });
    k.g(localObject, "htmlPath");
    AppMethodBeat.o(52134);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.g
 * JD-Core Version:    0.7.0.1
 */