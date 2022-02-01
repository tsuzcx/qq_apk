package com.tencent.mm.plugin.radar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarPressDetector;", "", "()V", "PressIsClickDuringThreshold", "", "getPressIsClickDuringThreshold", "()I", "PressTooShortDuringThreshold", "getPressTooShortDuringThreshold", "isClick", "", "during", "", "isPress", "isTooShort", "plugin-radar_release"})
public final class d
{
  private static final int uTu = 1000;
  private static final int uTv = 500;
  public static final d uTw;
  
  static
  {
    AppMethodBeat.i(138634);
    uTw = new d();
    uTu = 1000;
    uTv = 500;
    AppMethodBeat.o(138634);
  }
  
  public static int dfh()
  {
    return uTu;
  }
  
  public static boolean rL(long paramLong)
  {
    return paramLong <= uTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.d
 * JD-Core Version:    0.7.0.1
 */