package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class l
  extends j<k>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(151753);
    SQL_CREATE = new String[] { j.getCreateSQLs(k.info, "AppMessage") };
    AppMethodBeat.o(151753);
  }
  
  public l(e parame)
  {
    super(parame, k.info, "AppMessage", null);
  }
  
  public final k vk(long paramLong)
  {
    AppMethodBeat.i(151752);
    k localk = new k();
    localk.field_msgId = paramLong;
    if (super.get(localk, new String[0]))
    {
      AppMethodBeat.o(151752);
      return localk;
    }
    AppMethodBeat.o(151752);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.l
 * JD-Core Version:    0.7.0.1
 */