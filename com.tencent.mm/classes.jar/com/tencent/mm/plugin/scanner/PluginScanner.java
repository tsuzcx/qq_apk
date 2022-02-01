package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.scanner.model.q;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import d.g.b.k;

public class PluginScanner
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, d
{
  private m vLx;
  
  public PluginScanner()
  {
    AppMethodBeat.i(51554);
    this.vLx = new m();
    AppMethodBeat.o(51554);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(51555);
    com.tencent.mm.bs.c.aCW("scanner");
    pin(new t(h.class));
    if (paramg.agu())
    {
      paramg = q.vOR;
      paramg = aj.getContext();
      k.h(paramg, "context");
      e locale = new e(q.cg(paramg));
      if (!locale.exists()) {
        locale.mkdirs();
      }
      q.i(paramg, "scan_goods/center_det.bin", q.cg(paramg) + "center_det.bin");
      q.i(paramg, "scan_goods/center_det.param", q.cg(paramg) + "center_det.param");
    }
    paramg = com.tencent.mm.plugin.scanner.util.f.way;
    b.a((a)new com.tencent.mm.plugin.scanner.util.f(), new String[] { "//scan" });
    AppMethodBeat.o(51555);
  }
  
  public String genScanCaptureImgPath(String paramString)
  {
    AppMethodBeat.i(51558);
    h.dkY();
    paramString = h.getScanImageSaveDir() + String.format("%s_%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(51558);
    return paramString;
  }
  
  public String genScanTmpImgPath(String paramString)
  {
    AppMethodBeat.i(51559);
    h.dkY();
    paramString = h.genScanTmpImgPath(paramString);
    AppMethodBeat.o(51559);
    return paramString;
  }
  
  public String getAccScannerPath()
  {
    AppMethodBeat.i(51556);
    h.dkY();
    String str = h.getAccScannerPath();
    AppMethodBeat.o(51556);
    return str;
  }
  
  public m getScanCdnService()
  {
    return this.vLx;
  }
  
  public String getScanImageSaveDir()
  {
    AppMethodBeat.i(51557);
    h.dkY();
    String str = h.getScanImageSaveDir();
    AppMethodBeat.o(51557);
    return str;
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.PluginScanner
 * JD-Core Version:    0.7.0.1
 */