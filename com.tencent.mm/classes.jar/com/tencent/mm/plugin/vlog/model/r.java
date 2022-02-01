package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "VERTICAL_DISPLAY", "NOT_SCALE", "plugin-vlog_release"})
public enum r
{
  static
  {
    AppMethodBeat.i(110928);
    r localr1 = new r("CENTER_CROP", 0);
    BXu = localr1;
    r localr2 = new r("CENTER_INSIDE", 1);
    BXv = localr2;
    r localr3 = new r("VERTICAL_DISPLAY", 2);
    BXw = localr3;
    r localr4 = new r("NOT_SCALE", 3);
    BXx = localr4;
    BXy = new r[] { localr1, localr2, localr3, localr4 };
    AppMethodBeat.o(110928);
  }
  
  private r() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.r
 * JD-Core Version:    0.7.0.1
 */