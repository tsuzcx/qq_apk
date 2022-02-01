package com.tencent.mm.plugin.voip.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipCameraReportUtil;", "", "()V", "cameraStartCost", "", "getCameraStartCost", "()J", "setCameraStartCost", "(J)V", "fps", "", "getFps", "()I", "setFps", "(I)V", "hasBeenReport", "", "getHasBeenReport", "()Z", "setHasBeenReport", "(Z)V", "resolution", "", "getResolution", "()Ljava/lang/String;", "setResolution", "(Ljava/lang/String;)V", "getCameraInfo", "", "initCameraReport", "release", "reportCameraInfo", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a UFW;
  private static long UFX;
  private static int fps;
  private static boolean hasBeenReport;
  private static String resolution;
  
  static
  {
    AppMethodBeat.i(292847);
    UFW = new a();
    resolution = "";
    AppMethodBeat.o(292847);
  }
  
  public static void hZx()
  {
    AppMethodBeat.i(292818);
    UFX = Util.currentTicks();
    AppMethodBeat.o(292818);
  }
  
  public static void hZy()
  {
    AppMethodBeat.i(292835);
    if ((!hasBeenReport) && (UFX != 0L))
    {
      f localf = f.UGZ;
      f.f(Util.ticksToNow(UFX), resolution, fps);
      UFX = 0L;
    }
    AppMethodBeat.o(292835);
  }
  
  public static void hz(String paramString, int paramInt)
  {
    AppMethodBeat.i(292826);
    s.u(paramString, "resolution");
    resolution = paramString;
    fps = paramInt;
    AppMethodBeat.o(292826);
  }
  
  public static void release()
  {
    UFX = 0L;
    hasBeenReport = false;
    resolution = "";
    fps = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.a
 * JD-Core Version:    0.7.0.1
 */