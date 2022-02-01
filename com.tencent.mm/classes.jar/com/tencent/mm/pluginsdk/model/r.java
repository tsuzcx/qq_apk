package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/ImportVideoHevcChecker;", "", "()V", "TAG", "", "importVideoEnableHevc", "", "queryGpuRating", "", "plugin-videologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r XRn;
  
  static
  {
    AppMethodBeat.i(244745);
    XRn = new r();
    AppMethodBeat.o(244745);
  }
  
  public static boolean iHY()
  {
    boolean bool3 = true;
    boolean bool4 = false;
    AppMethodBeat.i(244740);
    if (!BuildInfo.IS_ARM64)
    {
      AppMethodBeat.o(244740);
      return false;
    }
    i locali = i.agtt;
    int i = i.a(b.a.agrx, 0);
    boolean bool2;
    int j;
    boolean bool1;
    if (((c)h.ax(c.class)).a(c.a.zwh, 0) == 1)
    {
      bool2 = true;
      Log.i("MicroMsg.ImportVideoHevcChecker", s.X("importVideoEnableHevc software encode enable:", Boolean.valueOf(bool2)));
      j = MultiProcessMMKV.getMMKV("mmkv_gpu_info").getInt("gpu_info_rating", -1);
      bool1 = bool2;
      if (bool2)
      {
        int k = ((c)h.ax(c.class)).a(c.a.zwi, -1);
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
      AppMethodBeat.o(244740);
      return bool1;
      bool2 = false;
      break;
      bool1 = false;
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.r
 * JD-Core Version:    0.7.0.1
 */