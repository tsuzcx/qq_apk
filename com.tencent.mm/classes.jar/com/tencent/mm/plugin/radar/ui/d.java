package com.tencent.mm.plugin.radar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarPressDetector;", "", "()V", "PressIsClickDuringThreshold", "", "getPressIsClickDuringThreshold", "()I", "PressTooShortDuringThreshold", "getPressTooShortDuringThreshold", "isClick", "", "during", "", "isPress", "isTooShort", "plugin-radar_release"})
public final class d
{
  private static final int xjS = 1000;
  private static final int xjT = 500;
  public static final d xjU;
  
  static
  {
    AppMethodBeat.i(138634);
    xjU = new d();
    xjS = 1000;
    xjT = 500;
    AppMethodBeat.o(138634);
  }
  
  public static int dDl()
  {
    return xjS;
  }
  
  public static boolean yz(long paramLong)
  {
    return paramLong <= xjT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.d
 * JD-Core Version:    0.7.0.1
 */