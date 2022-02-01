package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.util.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/ImportVideoHevcChecker;", "", "()V", "TAG", "", "importVideoEnableHevc", "", "queryGpuRating", "", "plugin-videologic_release"})
public final class p
{
  public static final p QVp;
  
  static
  {
    AppMethodBeat.i(216983);
    QVp = new p();
    AppMethodBeat.o(216983);
  }
  
  public static boolean hgZ()
  {
    boolean bool3 = true;
    boolean bool4 = false;
    AppMethodBeat.i(216982);
    if (!BuildInfo.IS_ARM64)
    {
      AppMethodBeat.o(216982);
      return false;
    }
    i locali = i.YyX;
    int i = i.a(com.tencent.mm.util.b.a.Yyl, 0);
    boolean bool2;
    int j;
    boolean bool1;
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wcw, 0) == 1)
    {
      bool2 = true;
      Log.i("MicroMsg.ImportVideoHevcChecker", "importVideoEnableHevc software encode enable:".concat(String.valueOf(bool2)));
      j = MultiProcessMMKV.getMMKV("mmkv_gpu_info").getInt("gpu_info_rating", -1);
      bool1 = bool2;
      if (bool2)
      {
        int k = ((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wcx, -1);
        Log.i("MicroMsg.ImportVideoHevcChecker", "importVideoEnableHevc software encode gpu rating limit:" + k + ", gpuRating:" + j);
        if (k <= 0) {
          break label218;
        }
        bool1 = bool4;
        if (j >= k) {
          bool1 = true;
        }
      }
      label158:
      if (i != 1) {
        break label223;
      }
      bool1 = bool3;
    }
    label218:
    label223:
    for (;;)
    {
      Log.i("MicroMsg.ImportVideoHevcChecker", "importVideoEnableHevc software encode enable:" + bool1 + ", repairerConfig:" + i + ", gpuRating:" + j);
      AppMethodBeat.o(216982);
      return bool1;
      bool2 = false;
      break;
      bool1 = false;
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.p
 * JD-Core Version:    0.7.0.1
 */