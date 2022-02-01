package com.tencent.mm.plugin.radar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarPressDetector;", "", "()V", "PressIsClickDuringThreshold", "", "getPressIsClickDuringThreshold", "()I", "PressTooShortDuringThreshold", "getPressTooShortDuringThreshold", "isClick", "", "during", "", "isPress", "isTooShort", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c NsW;
  private static final int NsX;
  private static final int NsY;
  
  static
  {
    AppMethodBeat.i(138634);
    NsW = new c();
    NsX = 1000;
    NsY = 500;
    AppMethodBeat.o(138634);
  }
  
  public static int gFh()
  {
    return NsX;
  }
  
  public static boolean tj(long paramLong)
  {
    return paramLong <= NsY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.c
 * JD-Core Version:    0.7.0.1
 */