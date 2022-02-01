package com.tencent.mm.plugin.voip.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipEncoderReportUtil;", "", "()V", "ENCODE_FAILED", "", "ENCODE_SUCCESS", "encodeTick", "", "getEncodeTick", "()J", "setEncodeTick", "(J)V", "pixelTicker", "getPixelTicker", "setPixelTicker", "addEncoderCost", "", "addPixelReadCost", "release", "startRunEncode", "startRunPixelRead", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b UFY;
  private static long UFZ;
  private static long UGa;
  
  static
  {
    AppMethodBeat.i(292824);
    UFY = new b();
    AppMethodBeat.o(292824);
  }
  
  public static void hZA()
  {
    AppMethodBeat.i(292805);
    if (UFZ != 0L)
    {
      f localf = f.UGZ;
      int i = (f.hZZ() + (int)Util.ticksToNow(UFZ)) / 2;
      localf = f.UGZ;
      f.aqP(i);
      UFZ = 0L;
    }
    AppMethodBeat.o(292805);
  }
  
  public static void hZB()
  {
    AppMethodBeat.i(292811);
    UGa = Util.currentTicks();
    AppMethodBeat.o(292811);
  }
  
  public static void hZC()
  {
    AppMethodBeat.i(292815);
    f localf = f.UGZ;
    int i = f.getEncodeCost();
    localf = f.UGZ;
    f.aqO((i + (int)Util.ticksToNow(UGa)) / 2);
    AppMethodBeat.o(292815);
  }
  
  public static void hZz()
  {
    AppMethodBeat.i(292799);
    UFZ = Util.currentTicks();
    AppMethodBeat.o(292799);
  }
  
  public static void release()
  {
    UGa = 0L;
    UFZ = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.b
 * JD-Core Version:    0.7.0.1
 */