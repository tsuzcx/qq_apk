package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.c.dg;
import com.tencent.mm.sdk.e.j;

final class e$1
  implements h.d
{
  e$1(e parame) {}
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(104892);
    String str = j.getCreateSQLs(dg.Hm(), "Music");
    AppMethodBeat.o(104892);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.1
 * JD-Core Version:    0.7.0.1
 */