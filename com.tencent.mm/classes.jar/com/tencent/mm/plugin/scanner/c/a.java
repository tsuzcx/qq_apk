package com.tencent.mm.plugin.scanner.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/config/ScanClientConfigManager;", "", "()V", "TAG", "", "enableImageOCR", "", "init", "", "plugin-scan_release"})
public final class a
{
  private static boolean CEh;
  public static final a CEi;
  
  static
  {
    AppMethodBeat.i(240359);
    CEi = new a();
    CEh = true;
    int i = ((b)g.af(b.class)).a(b.a.seH, 0);
    if (i == 1) {
      CEh = false;
    }
    Log.i("MicroMsg.ScanClientConfigManager", "ScanClientConfigManager init config: %d, enableImageOCR: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(CEh) });
    AppMethodBeat.o(240359);
  }
  
  public static final boolean ePI()
  {
    return CEh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.c.a
 * JD-Core Version:    0.7.0.1
 */