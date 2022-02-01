package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;

public final class ab
  extends j<aa>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(97653);
    SQL_CREATE = new String[] { j.getCreateSQLs(aa.info, "UxCanvasInfo") };
    AppMethodBeat.o(97653);
  }
  
  public ab(e parame)
  {
    this(parame, aa.info, "UxCanvasInfo");
  }
  
  private ab(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(97652);
    if ((paramaa == null) || (bt.isNullOrNil(paramaa.field_canvasXml)))
    {
      AppMethodBeat.o(97652);
      return;
    }
    paramaa.field_createTime = System.currentTimeMillis();
    if (!insert(paramaa)) {
      update(paramaa, new String[0]);
    }
    AppMethodBeat.o(97652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ab
 * JD-Core Version:    0.7.0.1
 */