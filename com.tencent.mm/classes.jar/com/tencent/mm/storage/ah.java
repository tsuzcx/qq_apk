package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.sdk.e.j;

public final class ah
  extends j<ag>
  implements g.a
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(29025);
    SQL_CREATE = new String[] { j.getCreateSQLs(ag.info, "ContactLabelCache") };
    AppMethodBeat.o(29025);
  }
  
  public final int a(g paramg)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.ah
 * JD-Core Version:    0.7.0.1
 */