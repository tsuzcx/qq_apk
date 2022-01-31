package com.tencent.mm.plugin.radar.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarPressDetector;", "", "()V", "PressIsClickDuringThreshold", "", "getPressIsClickDuringThreshold", "()I", "PressTooShortDuringThreshold", "getPressTooShortDuringThreshold", "isClick", "", "during", "", "isPress", "isTooShort", "plugin-radar_release"})
public final class d
{
  public static final d pRA;
  private static final int pRy = 1000;
  private static final int pRz = 500;
  
  static
  {
    AppMethodBeat.i(102988);
    pRA = new d();
    pRy = 1000;
    pRz = 500;
    AppMethodBeat.o(102988);
  }
  
  public static int ceT()
  {
    return pRy;
  }
  
  public static boolean kU(long paramLong)
  {
    return paramLong <= pRz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.d
 * JD-Core Version:    0.7.0.1
 */