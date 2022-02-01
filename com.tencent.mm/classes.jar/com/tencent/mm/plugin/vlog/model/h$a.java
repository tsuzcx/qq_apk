package com.tencent.mm.plugin.vlog.model;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$Companion;", "", "()V", "TAG", "", "alignN", "", "value", "align", "alignSize", "Landroid/util/Size;", "size", "plugin-vlog_release"})
public final class h$a
{
  public static Size a(Size paramSize)
  {
    AppMethodBeat.i(232549);
    p.k(paramSize, "size");
    int k = kD(paramSize.getWidth(), 4);
    int j = kD(paramSize.getHeight(), 3);
    int i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    paramSize = new Size(k, i);
    AppMethodBeat.o(232549);
    return paramSize;
  }
  
  private static int kD(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 % paramInt2 == 0) {
      return paramInt1;
    }
    for (;;)
    {
      paramInt1 = i;
      if (i % paramInt2 == 0) {
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.h.a
 * JD-Core Version:    0.7.0.1
 */