package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/ExportConfig;", "", "()V", "FALLBACK_SIZE_CONFIG", "", "FALLBACK_SIZE_NONE", "KEY_FALLBACK_SIZE", "", "kvName", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "isFallbackSize", "setFallbackSize", "", "fallback", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j TYR;
  static final String TYS;
  private static final String ogg;
  
  static
  {
    AppMethodBeat.i(283378);
    TYR = new j();
    ogg = "video_composition_export_config";
    TYS = "fallback_size";
    AppMethodBeat.o(283378);
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(283364);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(ogg);
    s.s(localMultiProcessMMKV, "getMMKV(kvName)");
    AppMethodBeat.o(283364);
    return localMultiProcessMMKV;
  }
  
  public static int hQp()
  {
    AppMethodBeat.i(283371);
    int i = getKV().getInt(TYS, 0);
    AppMethodBeat.o(283371);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.j
 * JD-Core Version:    0.7.0.1
 */