package com.tencent.mm.plugin.radar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarPressDetector;", "", "()V", "PressIsClickDuringThreshold", "", "getPressIsClickDuringThreshold", "()I", "PressTooShortDuringThreshold", "getPressTooShortDuringThreshold", "isClick", "", "during", "", "isPress", "isTooShort", "plugin-radar_release"})
public final class d
{
  private static final int Hvl = 1000;
  private static final int Hvm = 500;
  public static final d Hvn;
  
  static
  {
    AppMethodBeat.i(138634);
    Hvn = new d();
    Hvl = 1000;
    Hvm = 500;
    AppMethodBeat.o(138634);
  }
  
  public static boolean Pj(long paramLong)
  {
    return paramLong <= Hvm;
  }
  
  public static int ftu()
  {
    return Hvl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.d
 * JD-Core Version:    0.7.0.1
 */