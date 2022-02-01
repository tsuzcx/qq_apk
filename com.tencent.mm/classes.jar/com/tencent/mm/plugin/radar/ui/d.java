package com.tencent.mm.plugin.radar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarPressDetector;", "", "()V", "PressIsClickDuringThreshold", "", "getPressIsClickDuringThreshold", "()I", "PressTooShortDuringThreshold", "getPressTooShortDuringThreshold", "isClick", "", "during", "", "isPress", "isTooShort", "plugin-radar_release"})
public final class d
{
  private static final int wcj = 1000;
  private static final int wck = 500;
  public static final d wcl;
  
  static
  {
    AppMethodBeat.i(138634);
    wcl = new d();
    wcj = 1000;
    wck = 500;
    AppMethodBeat.o(138634);
  }
  
  public static int dsO()
  {
    return wcj;
  }
  
  public static boolean wo(long paramLong)
  {
    return paramLong <= wck;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.d
 * JD-Core Version:    0.7.0.1
 */