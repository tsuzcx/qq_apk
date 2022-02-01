package com.tencent.mm.plugin.vlog.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/util/VLogSizeUtil;", "", "()V", "MIN_RATIO", "", "NORMAL_RATIO", "getRatio", "width", "", "height", "plugin-vlog_release"})
public final class a
{
  public static final a LvS;
  
  static
  {
    AppMethodBeat.i(201261);
    LvS = new a();
    AppMethodBeat.o(201261);
  }
  
  public static float lj(int paramInt1, int paramInt2)
  {
    float f = paramInt2 * 1.0F / paramInt1;
    if (f > 1.166667F) {
      return 1.166667F;
    }
    if (f < 0.5625F) {
      return 0.5625F;
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.a.a
 * JD-Core Version:    0.7.0.1
 */