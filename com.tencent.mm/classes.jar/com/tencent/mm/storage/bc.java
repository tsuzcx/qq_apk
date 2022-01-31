package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class bc
  extends j<bb>
  implements n
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(1303);
    SQL_CREATE = new String[] { j.getCreateSQLs(bb.info, "GetSysCmdMsgInfo") };
    AppMethodBeat.o(1303);
  }
  
  public bc(h paramh)
  {
    super(paramh, bb.info, "GetSysCmdMsgInfo", null);
    this.db = paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bc
 * JD-Core Version:    0.7.0.1
 */