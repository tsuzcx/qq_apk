package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/ExportConfig;", "", "()V", "FALLBACK_SIZE_CONFIG", "", "FALLBACK_SIZE_NONE", "KEY_FALLBACK_SIZE", "", "kvName", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "isFallbackSize", "setFallbackSize", "", "fallback", "plugin-vlog_release"})
public final class k
{
  private static final String GxN = "video_composition_export_config";
  static final String GxO = "fallback_size";
  public static final k GxP;
  
  static
  {
    AppMethodBeat.i(190565);
    GxP = new k();
    GxN = "video_composition_export_config";
    GxO = "fallback_size";
    AppMethodBeat.o(190565);
  }
  
  public static int fAT()
  {
    AppMethodBeat.i(190564);
    int i = getKV().getInt(GxO, 0);
    AppMethodBeat.o(190564);
    return i;
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(190563);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(GxN);
    p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(kvName)");
    AppMethodBeat.o(190563);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.k
 * JD-Core Version:    0.7.0.1
 */