package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class k
  extends MAutoStorage<j>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(28146);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.info, "ShakeNewYearFriendInfo") };
    AppMethodBeat.o(28146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.k
 * JD-Core Version:    0.7.0.1
 */