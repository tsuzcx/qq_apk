package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.plugin.scanner.model.q;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class b
  extends j
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(80897);
    SQL_CREATE = new String[] { j.getCreateSQLs(q.info, "ScanTranslationResult") };
    AppMethodBeat.o(80897);
  }
  
  public b(e parame)
  {
    super(parame, q.info, "ScanTranslationResult", null);
    this.db = parame;
  }
  
  public final eg Yz(String paramString)
  {
    AppMethodBeat.i(80896);
    q localq = new q();
    localq.field_originMD5 = paramString;
    if (get(localq, new String[0]))
    {
      AppMethodBeat.o(80896);
      return localq;
    }
    AppMethodBeat.o(80896);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.b
 * JD-Core Version:    0.7.0.1
 */