package com.tencent.mm.plugin.scanner.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/config/ScanClientConfigManager;", "", "()V", "TAG", "", "enableImageOCR", "", "init", "", "plugin-scan_release"})
public final class a
{
  private static boolean IIJ;
  public static final a IIK;
  
  static
  {
    AppMethodBeat.i(218583);
    IIK = new a();
    IIJ = true;
    int i = ((b)h.ae(b.class)).a(b.a.vOj, 0);
    if (i == 1) {
      IIJ = false;
    }
    Log.i("MicroMsg.ScanClientConfigManager", "ScanClientConfigManager init config: %d, enableImageOCR: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(IIJ) });
    AppMethodBeat.o(218583);
  }
  
  public static final boolean fCy()
  {
    return IIJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.c.a
 * JD-Core Version:    0.7.0.1
 */