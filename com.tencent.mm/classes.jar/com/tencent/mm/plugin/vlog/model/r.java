package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "VERTICAL_DISPLAY", "NOT_SCALE", "plugin-vlog_release"})
public enum r
{
  static
  {
    AppMethodBeat.i(110928);
    r localr1 = new r("CENTER_CROP", 0);
    BFW = localr1;
    r localr2 = new r("CENTER_INSIDE", 1);
    BFX = localr2;
    r localr3 = new r("VERTICAL_DISPLAY", 2);
    BFY = localr3;
    r localr4 = new r("NOT_SCALE", 3);
    BFZ = localr4;
    BGa = new r[] { localr1, localr2, localr3, localr4 };
    AppMethodBeat.o(110928);
  }
  
  private r() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.r
 * JD-Core Version:    0.7.0.1
 */