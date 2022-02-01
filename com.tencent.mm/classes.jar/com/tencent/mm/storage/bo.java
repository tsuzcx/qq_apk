package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h;

public final class bo
  extends j<bn>
  implements o
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(117171);
    SQL_CREATE = new String[] { j.getCreateSQLs(bn.info, "GetSysCmdMsgInfo") };
    AppMethodBeat.o(117171);
  }
  
  public bo(h paramh)
  {
    super(paramh, bn.info, "GetSysCmdMsgInfo", null);
    this.db = paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bo
 * JD-Core Version:    0.7.0.1
 */