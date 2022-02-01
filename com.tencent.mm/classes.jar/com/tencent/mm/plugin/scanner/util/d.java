package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/util/ScanDebugUtil;", "", "()V", "TAG", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "showDebugView", "", "init", "", "scan-sdk_release"})
public final class d
{
  private static boolean CTE;
  public static final d CTF;
  private static MultiProcessMMKV cQe;
  
  static
  {
    AppMethodBeat.i(194776);
    CTF = new d();
    AppMethodBeat.o(194776);
  }
  
  public static final boolean eRT()
  {
    return CTE;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(194775);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(194775);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("ScanDebug");
    cQe = localMultiProcessMMKV;
    if (localMultiProcessMMKV != null)
    {
      bool = localMultiProcessMMKV.getBoolean("scan_debug_show_debug_view", false);
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      CTE = bool;
      Log.i("MicroMsg.ScanDebugUtil", "alvinluo ScanDebugUtil init showDebugView %b", new Object[] { Boolean.valueOf(CTE) });
      AppMethodBeat.o(194775);
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