package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.scanner.model.q;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;

public class PluginScanner
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, e
{
  private m wVy;
  
  public PluginScanner()
  {
    AppMethodBeat.i(51554);
    this.wVy = new m();
    AppMethodBeat.o(51554);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(51555);
    com.tencent.mm.br.c.aIn("scanner");
    pin(new t(i.class));
    if (paramg.ahL())
    {
      paramg = q.wZn;
      paramg = ai.getContext();
      k.h(paramg, "context");
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(q.cm(paramg));
      if (!locale.exists()) {
        locale.mkdirs();
      }
      q.i(paramg, "scan_goods/center_det.bin", q.cm(paramg) + "center_det.bin");
      q.i(paramg, "scan_goods/center_det.param", q.cm(paramg) + "center_det.param");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.a.class, new com.tencent.mm.plugin.scanner.e.a());
    }
    for (;;)
    {
      paramg = com.tencent.mm.plugin.scanner.util.f.xlE;
      b.a((com.tencent.mm.pluginsdk.cmd.a)new com.tencent.mm.plugin.scanner.util.f(), new String[] { "//scan" });
      AppMethodBeat.o(51555);
      return;
      if (paramg.up(":tools")) {
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.a.class, new com.tencent.mm.plugin.scanner.e.a());
      }
    }
  }
  
  public String genScanCaptureImgPath(String paramString)
  {
    AppMethodBeat.i(51558);
    i.dza();
    paramString = i.getScanImageSaveDir() + String.format("%s_%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(51558);
    return paramString;
  }
  
  public String genScanTmpImgPath(String paramString)
  {
    AppMethodBeat.i(51559);
    i.dza();
    paramString = i.genScanTmpImgPath(paramString);
    AppMethodBeat.o(51559);
    return paramString;
  }
  
  public String getAccScannerPath()
  {
    AppMethodBeat.i(51556);
    i.dza();
    String str = i.getAccScannerPath();
    AppMethodBeat.o(51556);
    return str;
  }
  
  public m getScanCdnService()
  {
    return this.wVy;
  }
  
  public String getScanImageSaveDir()
  {
    AppMethodBeat.i(51557);
    i.dza();
    String str = i.getScanImageSaveDir();
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