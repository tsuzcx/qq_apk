package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/util/ScanDebugUtil;", "", "()V", "TAG", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "showDebugView", "", "init", "", "scan-sdk_release"})
public final class d
{
  private static aw cqB;
  private static boolean xlC;
  public static final d xlD;
  
  static
  {
    AppMethodBeat.i(204958);
    xlD = new d();
    AppMethodBeat.o(204958);
  }
  
  public static final boolean dBp()
  {
    return xlC;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(204957);
    if ((h.DEBUG) || (h.IS_FLAVOR_RED)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(204957);
      return;
    }
    aw localaw = aw.aKT("ScanDebug");
    cqB = localaw;
    if (localaw != null)
    {
      bool = localaw.getBoolean("scan_debug_show_debug_view", false);
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      xlC = bool;
      ac.i("MicroMsg.ScanDebugUtil", "alvinluo ScanDebugUtil init showDebugView %b", new Object[] { Boolean.valueOf(xlC) });
      AppMethodBeat.o(204957);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.d
 * JD-Core Version:    0.7.0.1
 */