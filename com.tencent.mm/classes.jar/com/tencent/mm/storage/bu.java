package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class bu
  extends MAutoStorage<bt>
  implements o
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(117171);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bt.info, "GetSysCmdMsgInfo") };
    AppMethodBeat.o(117171);
  }
  
  public bu(h paramh)
  {
    super(paramh, bt.info, "GetSysCmdMsgInfo", null);
    this.db = paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bu
 * JD-Core Version:    0.7.0.1
 */