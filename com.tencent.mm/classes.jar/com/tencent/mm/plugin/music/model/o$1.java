package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fn;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;

final class o$1
  implements h.b
{
  o$1(o paramo) {}
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(63025);
    String str = MAutoStorage.getCreateSQLs(fn.aJm(), "Music");
    AppMethodBeat.o(63025);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.o.1
 * JD-Core Version:    0.7.0.1
 */