package com.tencent.mm.plugin.voip.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.e.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipGPUReportUtil;", "", "()V", "hasBeenCheck", "", "getHasBeenCheck", "()Z", "setHasBeenCheck", "(Z)V", "initGpuEGL", "", "getInitGpuEGL", "()J", "setInitGpuEGL", "(J)V", "initGpuGFX", "getInitGpuGFX", "setInitGpuGFX", "initGpuGl", "getInitGpuGl", "setInitGpuGl", "getGpuInfo", "", "initGpuInfo", "release", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e UGU;
  private static long UGV;
  private static long UGW;
  private static long UGX;
  private static boolean UGY;
  
  static
  {
    AppMethodBeat.i(292808);
    UGU = new e();
    AppMethodBeat.o(292808);
  }
  
  public static void hZR()
  {
    AppMethodBeat.i(292790);
    a locala = new a();
    UGV = locala.aXS();
    UGW = locala.aXR();
    UGX = locala.aXQ();
    AppMethodBeat.o(292790);
  }
  
  public static void hZS()
  {
    AppMethodBeat.i(292795);
    if (!UGY)
    {
      a locala = new a();
      UGY = true;
      f localf = f.UGZ;
      f.r(locala.aXS() - UGV, locala.aXR() - UGW, locala.aXQ() - UGX);
    }
    AppMethodBeat.o(292795);
  }
  
  public static void release()
  {
    UGV = 0L;
    UGW = 0L;
    UGX = 0L;
    UGY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.e
 * JD-Core Version:    0.7.0.1
 */