package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffect$SegmentMode;", "", "(Ljava/lang/String;I)V", "SEGMENT_NONE", "SEGMENT_BLUR", "SEGMENT_FOCUS", "SEGMENT_GLASS", "SEGMENT_GLASS_PENSE", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum k$e
{
  static
  {
    AppMethodBeat.i(261620);
    XLS = new e("SEGMENT_NONE", 0);
    XLT = new e("SEGMENT_BLUR", 1);
    XLU = new e("SEGMENT_FOCUS", 2);
    XLV = new e("SEGMENT_GLASS", 3);
    XLW = new e("SEGMENT_GLASS_PENSE", 4);
    XLX = new e[] { XLS, XLT, XLU, XLV, XLW };
    AppMethodBeat.o(261620);
  }
  
  private k$e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.k.e
 * JD-Core Version:    0.7.0.1
 */