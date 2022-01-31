package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.c.dq;
import com.tencent.mm.sdk.e.j;

final class e$2
  implements h.d
{
  e$2(e parame) {}
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(104893);
    String str = j.getCreateSQLs(dq.Hm(), "PieceMusicInfo");
    AppMethodBeat.o(104893);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.2
 * JD-Core Version:    0.7.0.1
 */