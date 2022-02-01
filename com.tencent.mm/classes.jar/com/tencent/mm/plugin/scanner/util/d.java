package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/util/ScanDebugUtil;", "", "()V", "TAG", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "showDebugView", "", "init", "", "scan-sdk_release"})
public final class d
{
  private static ay cCf;
  private static boolean yPE;
  public static final d yPF;
  
  static
  {
    AppMethodBeat.i(196704);
    yPF = new d();
    AppMethodBeat.o(196704);
  }
  
  public static final boolean dQg()
  {
    return yPE;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(196703);
    if ((j.DEBUG) || (j.IS_FLAVOR_RED)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(196703);
      return;
    }
    ay localay = ay.aRW("ScanDebug");
    cCf = localay;
    if (localay != null)
    {
      bool = localay.getBoolean("scan_debug_show_debug_view", false);
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      yPE = bool;
      ae.i("MicroMsg.ScanDebugUtil", "alvinluo ScanDebugUtil init showDebugView %b", new Object[] { Boolean.valueOf(yPE) });
      AppMethodBeat.o(196703);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.d
 * JD-Core Version:    0.7.0.1
 */