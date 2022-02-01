package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h.b;

final class f$1
  implements h.b
{
  f$1(f paramf) {}
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(63025);
    String str = j.getCreateSQLs(dy.So(), "Music");
    AppMethodBeat.o(63025);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.f.1
 * JD-Core Version:    0.7.0.1
 */