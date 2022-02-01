package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cw;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.scanner.model.t;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.vfs.q;
import java.util.Map;
import kotlin.g.b.p;

public class PluginScanner
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, g
{
  private static final IListener<cw> IBz;
  
  static
  {
    AppMethodBeat.i(222960);
    IBz = new PluginScanner.1();
    AppMethodBeat.o(222960);
  }
  
  public PluginScanner()
  {
    AppMethodBeat.i(51554);
    AppMethodBeat.o(51554);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(222936);
    EventCenter.instance.add(IBz);
    ab.a("ImageSearchFilePath", "image_search_temp/", 259200000L, 70);
    AppMethodBeat.o(222936);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(51555);
    com.tencent.mm.by.b.bsj("scanner");
    pin(new y(o.class));
    if (paramg.aIE())
    {
      paramg = t.ILi;
      paramg = MMApplicationContext.getContext();
      p.k(paramg, "context");
      q localq = new q(t.cC(paramg));
      if (!localq.ifE()) {
        localq.ifL();
      }
      t.j(paramg, "scan_goods/center_det.bin", t.cC(paramg) + "center_det.bin");
      t.j(paramg, "scan_goods/center_det.param", t.cC(paramg) + "center_det.param");
      h.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.h.b());
      h.b(com.tencent.mm.plugin.scanner.api.b.class, new com.tencent.mm.plugin.scanner.h.a());
      paramg = com.tencent.mm.plugin.scanner.util.g.IYZ;
      com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new com.tencent.mm.plugin.scanner.util.g(), new String[] { "//scan" });
      paramg = com.tencent.mm.plugin.scanner.box.a.a.a.IIj;
      paramg = com.tencent.mm.plugin.webview.d.o.POy;
      com.tencent.mm.plugin.webview.d.o.bR((Map)com.tencent.mm.plugin.scanner.box.a.a.a.IIi.getValue());
      AppMethodBeat.o(51555);
      return;
    }
    if (paramg.MY(":tools"))
    {
      h.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.h.b());
      AppMethodBeat.o(51555);
      return;
    }
    if (paramg.MZ(":appbrand")) {
      h.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.h.b());
    }
    AppMethodBeat.o(51555);
  }
  
  public String genScanCaptureImgPath(String paramString)
  {
    AppMethodBeat.i(51558);
    o.fBS();
    paramString = o.getScanImageSaveDir() + String.format("%s_%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(51558);
    return paramString;
  }
  
  public String genScanTmpImgPath(String paramString)
  {
    AppMethodBeat.i(51559);
    o.fBS();
    paramString = o.getScanImageSaveDir() + String.format("%s_%d.%s", new Object[] { "tmp", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(51559);
    return paramString;
  }
  
  public String genScanTmpImgPath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222957);
    o.fBS();
    paramString1 = o.getScanImageSaveDir() + String.format("%s_%s.%s", new Object[] { "tmp", paramString1, paramString2 });
    AppMethodBeat.o(222957);
    return paramString1;
  }
  
  public String getAccScannerPath()
  {
    AppMethodBeat.i(51556);
    o.fBS();
    String str = o.getAccScannerPath();
    AppMethodBeat.o(51556);
    return str;
  }
  
  public String getScanImageSaveDir()
  {
    AppMethodBeat.i(51557);
    o.fBS();
    String str = o.getScanImageSaveDir();
    AppMethodBeat.o(51557);
    return str;
  }
  
  public k getScanTranslateCdnService()
  {
    return k.IZu;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(222959);
    o.fBS();
    o.fBT();
    AppMethodBeat.o(222959);
  }
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.PluginScanner
 * JD-Core Version:    0.7.0.1
 */