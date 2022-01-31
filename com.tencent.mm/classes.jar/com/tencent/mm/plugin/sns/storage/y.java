package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class y
  extends j<x>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(38034);
    SQL_CREATE = new String[] { j.getCreateSQLs(x.info, "UxCanvasInfo") };
    AppMethodBeat.o(38034);
  }
  
  public y(e parame)
  {
    this(parame, x.info, "UxCanvasInfo");
  }
  
  private y(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
  }
  
  public final void a(x paramx)
  {
    AppMethodBeat.i(38033);
    if ((paramx == null) || (bo.isNullOrNil(paramx.field_canvasXml)))
    {
      AppMethodBeat.o(38033);
      return;
    }
    paramx.field_createTime = System.currentTimeMillis();
    if (!insert(paramx)) {
      update(paramx, new String[0]);
    }
    AppMethodBeat.o(38033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.y
 * JD-Core Version:    0.7.0.1
 */