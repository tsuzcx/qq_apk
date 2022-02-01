package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public class PluginScanner
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, f
{
  private static final IListener<cs> CzS;
  private com.tencent.mm.plugin.scanner.util.p CzR;
  
  static
  {
    AppMethodBeat.i(240711);
    CzS = new PluginScanner.1();
    AppMethodBeat.o(240711);
  }
  
  public PluginScanner()
  {
    AppMethodBeat.i(51554);
    this.CzR = new com.tencent.mm.plugin.scanner.util.p();
    AppMethodBeat.o(51554);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(240710);
    EventCenter.instance.add(CzS);
    com.tencent.mm.vfs.y.b("ImageSearchFilePath", "image_search_temp/", 259200000L, 68);
    AppMethodBeat.o(240710);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(51555);
    com.tencent.mm.br.b.bfQ("scanner");
    pin(new com.tencent.mm.model.y(j.class));
    if (paramg.aBb())
    {
      paramg = v.CFW;
      paramg = MMApplicationContext.getContext();
      kotlin.g.b.p.h(paramg, "context");
      com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(v.cF(paramg));
      if (!localo.exists()) {
        localo.mkdirs();
      }
      v.j(paramg, "scan_goods/center_det.bin", v.cF(paramg) + "center_det.bin");
      v.j(paramg, "scan_goods/center_det.param", v.cF(paramg) + "center_det.param");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.g.b());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.b.class, new com.tencent.mm.plugin.scanner.g.a());
      paramg = com.tencent.mm.plugin.scanner.util.g.CTH;
      com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new com.tencent.mm.plugin.scanner.util.g(), new String[] { "//scan" });
      paramg = com.tencent.mm.plugin.scanner.box.a.a.a.CDH;
      paramg = com.tencent.mm.plugin.webview.d.o.ISi;
      com.tencent.mm.plugin.webview.d.o.bM((Map)com.tencent.mm.plugin.scanner.box.a.a.a.CDG.getValue());
      AppMethodBeat.o(51555);
      return;
    }
    if (paramg.FY(":tools"))
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.g.b());
      AppMethodBeat.o(51555);
      return;
    }
    if (paramg.FZ(":appbrand")) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.g.b());
    }
    AppMethodBeat.o(51555);
  }
  
  public String genScanCaptureImgPath(String paramString)
  {
    AppMethodBeat.i(51558);
    j.eOR();
    paramString = j.getScanImageSaveDir() + String.format("%s_%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(51558);
    return paramString;
  }
  
  public String genScanTmpImgPath(String paramString)
  {
    AppMethodBeat.i(51559);
    j.eOR();
    paramString = j.genScanTmpImgPath(paramString);
    AppMethodBeat.o(51559);
    return paramString;
  }
  
  public String getAccScannerPath()
  {
    AppMethodBeat.i(51556);
    j.eOR();
    String str = j.getAccScannerPath();
    AppMethodBeat.o(51556);
    return str;
  }
  
  public com.tencent.mm.plugin.scanner.util.p getScanCdnService()
  {
    return this.CzR;
  }
  
  public String getScanImageSaveDir()
  {
    AppMethodBeat.i(51557);
    j.eOR();
    String str = j.getScanImageSaveDir();
    AppMethodBeat.o(51557);
    return str;
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.PluginScanner
 * JD-Core Version:    0.7.0.1
 */