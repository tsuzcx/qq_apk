package com.tencent.mm.plugin.radar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarPressDetector;", "", "()V", "PressIsClickDuringThreshold", "", "getPressIsClickDuringThreshold", "()I", "PressTooShortDuringThreshold", "getPressTooShortDuringThreshold", "isClick", "", "during", "", "isPress", "isTooShort", "plugin-radar_release"})
public final class d
{
  private static final int BzQ = 1000;
  private static final int BzR = 500;
  public static final d BzS;
  
  static
  {
    AppMethodBeat.i(138634);
    BzS = new d();
    BzQ = 1000;
    BzR = 500;
    AppMethodBeat.o(138634);
  }
  
  public static boolean HO(long paramLong)
  {
    return paramLong <= BzR;
  }
  
  public static int eHq()
  {
    return BzQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.d
 * JD-Core Version:    0.7.0.1
 */