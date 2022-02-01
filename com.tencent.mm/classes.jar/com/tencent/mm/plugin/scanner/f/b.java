package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class b
  extends j
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(120862);
    SQL_CREATE = new String[] { j.getCreateSQLs(ag.info, "ScanTranslationResult") };
    AppMethodBeat.o(120862);
  }
  
  public b(e parame)
  {
    super(parame, ag.info, "ScanTranslationResult", null);
    this.db = parame;
  }
  
  public final boolean a(ag paramag)
  {
    AppMethodBeat.i(120861);
    if (ayb(paramag.field_originMD5) != null)
    {
      bool = replace(paramag);
      AppMethodBeat.o(120861);
      return bool;
    }
    boolean bool = super.insert(paramag);
    AppMethodBeat.o(120861);
    return bool;
  }
  
  public final fp ayb(String paramString)
  {
    AppMethodBeat.i(120860);
    ag localag = new ag();
    localag.field_originMD5 = paramString;
    if (get(localag, new String[0]))
    {
      AppMethodBeat.o(120860);
      return localag;
    }
    AppMethodBeat.o(120860);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.b
 * JD-Core Version:    0.7.0.1
 */