package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.fm;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;

final class o$2
  implements h.b
{
  o$2(o paramo) {}
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(63026);
    String str = MAutoStorage.getCreateSQLs(fm.aoY(), "PieceMusicInfo");
    AppMethodBeat.o(63026);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.o.2
 * JD-Core Version:    0.7.0.1
 */