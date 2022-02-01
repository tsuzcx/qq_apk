package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/ExportConfig;", "", "()V", "FALLBACK_SIZE_CONFIG", "", "FALLBACK_SIZE_NONE", "KEY_FALLBACK_SIZE", "", "kvName", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "isFallbackSize", "setFallbackSize", "", "fallback", "plugin-vlog_release"})
public final class k
{
  private static final String Nlp = "video_composition_export_config";
  static final String Nlq = "fallback_size";
  public static final k Nlr;
  
  static
  {
    AppMethodBeat.i(224432);
    Nlr = new k();
    Nlp = "video_composition_export_config";
    Nlq = "fallback_size";
    AppMethodBeat.o(224432);
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(224430);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(Nlp);
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(kvName)");
    AppMethodBeat.o(224430);
    return localMultiProcessMMKV;
  }
  
  public static int gsT()
  {
    AppMethodBeat.i(224431);
    int i = getKV().getInt(Nlq, 0);
    AppMethodBeat.o(224431);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.k
 * JD-Core Version:    0.7.0.1
 */