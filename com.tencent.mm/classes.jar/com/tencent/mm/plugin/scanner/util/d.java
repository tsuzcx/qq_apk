package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/util/ScanDebugUtil;", "", "()V", "TAG", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "showDebugView", "", "init", "", "scan-sdk_release"})
public final class d
{
  private static ax ctt;
  private static boolean waw;
  public static final d wax;
  
  static
  {
    AppMethodBeat.i(190154);
    wax = new d();
    AppMethodBeat.o(190154);
  }
  
  public static final boolean dnh()
  {
    return waw;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(190153);
    if ((h.DEBUG) || (h.IS_FLAVOR_RED)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(190153);
      return;
    }
    ax localax = ax.aFC("ScanDebug");
    ctt = localax;
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
      waw = bool;
      ad.i("MicroMsg.ScanDebugUtil", "alvinluo ScanDebugUtil init showDebugView %b", new Object[] { Boolean.valueOf(waw) });
      AppMethodBeat.o(190153);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.d
 * JD-Core Version:    0.7.0.1
 */