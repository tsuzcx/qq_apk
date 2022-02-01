package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "VERTICAL_DISPLAY", "NOT_SCALE", "plugin-vlog_release"})
public enum y
{
  static
  {
    AppMethodBeat.i(110928);
    y localy1 = new y("CENTER_CROP", 0);
    GyZ = localy1;
    y localy2 = new y("CENTER_INSIDE", 1);
    Gza = localy2;
    y localy3 = new y("VERTICAL_DISPLAY", 2);
    Gzb = localy3;
    y localy4 = new y("NOT_SCALE", 3);
    Gzc = localy4;
    Gzd = new y[] { localy1, localy2, localy3, localy4 };
    AppMethodBeat.o(110928);
  }
  
  private y() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.y
 * JD-Core Version:    0.7.0.1
 */