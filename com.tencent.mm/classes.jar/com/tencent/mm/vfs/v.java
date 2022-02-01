package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;

public final class v
{
  public static long ot(String paramString1, String paramString2)
  {
    boolean bool = true;
    AppMethodBeat.i(197886);
    int i;
    if (!"0".equals(d.dgX().a("clicfg_enable_refcount_linking", "0", false, true)))
    {
      i = 1;
      if (i == 0) {
        break label54;
      }
    }
    for (;;)
    {
      long l = u.H(paramString1, paramString2, bool);
      AppMethodBeat.o(197886);
      return l;
      i = 0;
      break;
      label54:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.v
 * JD-Core Version:    0.7.0.1
 */