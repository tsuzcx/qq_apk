package com.tencent.mm.plugin.radar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarPressDetector;", "", "()V", "PressIsClickDuringThreshold", "", "getPressIsClickDuringThreshold", "()I", "PressTooShortDuringThreshold", "getPressTooShortDuringThreshold", "isClick", "", "during", "", "isPress", "isTooShort", "plugin-radar_release"})
public final class d
{
  private static final int xzP = 1000;
  private static final int xzQ = 500;
  public static final d xzR;
  
  static
  {
    AppMethodBeat.i(138634);
    xzR = new d();
    xzP = 1000;
    xzQ = 500;
    AppMethodBeat.o(138634);
  }
  
  public static int dGC()
  {
    return xzP;
  }
  
  public static boolean yY(long paramLong)
  {
    return paramLong <= xzQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.d
 * JD-Core Version:    0.7.0.1
 */