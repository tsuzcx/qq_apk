package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h.b;

final class f$2
  implements h.b
{
  f$2(f paramf) {}
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(63026);
    String str = j.getCreateSQLs(eo.Th(), "PieceMusicInfo");
    AppMethodBeat.o(63026);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.f.2
 * JD-Core Version:    0.7.0.1
 */