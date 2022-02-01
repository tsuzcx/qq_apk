package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "VERTICAL_DISPLAY", "NOT_SCALE", "plugin-vlog_release"})
public enum e
{
  static
  {
    AppMethodBeat.i(110928);
    e locale1 = new e("CENTER_CROP", 0);
    yZh = locale1;
    e locale2 = new e("CENTER_INSIDE", 1);
    yZi = locale2;
    e locale3 = new e("VERTICAL_DISPLAY", 2);
    yZj = locale3;
    e locale4 = new e("NOT_SCALE", 3);
    yZk = locale4;
    yZl = new e[] { locale1, locale2, locale3, locale4 };
    AppMethodBeat.o(110928);
  }
  
  private e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.e
 * JD-Core Version:    0.7.0.1
 */