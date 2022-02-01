package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "VERTICAL_DISPLAY", "NOT_SCALE", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum y
{
  static
  {
    AppMethodBeat.i(110928);
    Uad = new y("CENTER_CROP", 0);
    Uae = new y("CENTER_INSIDE", 1);
    Uaf = new y("VERTICAL_DISPLAY", 2);
    Uag = new y("NOT_SCALE", 3);
    Uah = new y[] { Uad, Uae, Uaf, Uag };
    AppMethodBeat.o(110928);
  }
  
  private y() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.y
 * JD-Core Version:    0.7.0.1
 */