package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "VERTICAL_DISPLAY", "NOT_SCALE", "plugin-vlog_release"})
public enum y
{
  static
  {
    AppMethodBeat.i(110928);
    y localy1 = new y("CENTER_CROP", 0);
    NmB = localy1;
    y localy2 = new y("CENTER_INSIDE", 1);
    NmC = localy2;
    y localy3 = new y("VERTICAL_DISPLAY", 2);
    NmD = localy3;
    y localy4 = new y("NOT_SCALE", 3);
    NmE = localy4;
    NmF = new y[] { localy1, localy2, localy3, localy4 };
    AppMethodBeat.o(110928);
  }
  
  private y() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.y
 * JD-Core Version:    0.7.0.1
 */