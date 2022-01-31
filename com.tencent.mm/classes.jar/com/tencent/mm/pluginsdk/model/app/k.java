package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;

public final class k
  extends com.tencent.mm.sdk.e.j<com.tencent.mm.af.j>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(79328);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.af.j.info, "AppMessage") };
    AppMethodBeat.o(79328);
  }
  
  public k(e parame)
  {
    super(parame, com.tencent.mm.af.j.info, "AppMessage", null);
  }
  
  public final com.tencent.mm.af.j nx(long paramLong)
  {
    AppMethodBeat.i(79327);
    com.tencent.mm.af.j localj = new com.tencent.mm.af.j();
    localj.field_msgId = paramLong;
    if (super.get(localj, new String[0]))
    {
      AppMethodBeat.o(79327);
      return localj;
    }
    AppMethodBeat.o(79327);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.k
 * JD-Core Version:    0.7.0.1
 */