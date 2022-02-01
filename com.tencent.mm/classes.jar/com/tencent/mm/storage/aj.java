package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class aj
  extends j<ai>
  implements g.a
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(32841);
    SQL_CREATE = new String[] { j.getCreateSQLs(ai.info, "ContactLabelCache") };
    AppMethodBeat.o(32841);
  }
  
  public final int a(g paramg)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.aj
 * JD-Core Version:    0.7.0.1
 */