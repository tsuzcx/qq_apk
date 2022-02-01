package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/util/ScanDebugUtil;", "", "()V", "TAG", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "showDebugView", "", "init", "", "scan-sdk_release"})
public final class d
{
  private static ax cBy;
  private static boolean yzE;
  public static final d yzF;
  
  static
  {
    AppMethodBeat.i(218768);
    yzF = new d();
    AppMethodBeat.o(218768);
  }
  
  public static final boolean dMN()
  {
    return yzE;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(218767);
    if ((i.DEBUG) || (i.IS_FLAVOR_RED)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(218767);
      return;
    }
    ax localax = ax.aQz("ScanDebug");
    cBy = localax;
    if (localax != null)
    {
      bool = localax.getBoolean("scan_debug_show_debug_view", false);
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      yzE = bool;
      ad.i("MicroMsg.ScanDebugUtil", "alvinluo ScanDebugUtil init showDebugView %b", new Object[] { Boolean.valueOf(yzE) });
      AppMethodBeat.o(218767);
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