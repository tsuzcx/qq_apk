package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ay
  extends MAutoStorage<ax>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(32841);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ax.info, "ContactLabelCache") };
    AppMethodBeat.o(32841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ay
 * JD-Core Version:    0.7.0.1
 */