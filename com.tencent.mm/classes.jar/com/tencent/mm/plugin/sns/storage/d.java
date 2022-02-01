package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(96282);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "CanvasInfo") };
    AppMethodBeat.o(96282);
  }
  
  public d(e parame)
  {
    this(parame, c.info, "CanvasInfo");
  }
  
  private d(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(96281);
    if (paramc == null)
    {
      AppMethodBeat.o(96281);
      return;
    }
    paramc.field_createTime = System.currentTimeMillis();
    if (!insert(paramc)) {
      update(paramc, new String[0]);
    }
    AppMethodBeat.o(96281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.d
 * JD-Core Version:    0.7.0.1
 */