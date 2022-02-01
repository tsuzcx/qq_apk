package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.plugin.scanner.model.af;
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
    SQL_CREATE = new String[] { j.getCreateSQLs(af.info, "ScanTranslationResult") };
    AppMethodBeat.o(120862);
  }
  
  public b(e parame)
  {
    super(parame, af.info, "ScanTranslationResult", null);
    this.db = parame;
  }
  
  public final boolean a(af paramaf)
  {
    AppMethodBeat.i(120861);
    if (awM(paramaf.field_originMD5) != null)
    {
      bool = replace(paramaf);
      AppMethodBeat.o(120861);
      return bool;
    }
    boolean bool = super.insert(paramaf);
    AppMethodBeat.o(120861);
    return bool;
  }
  
  public final fp awM(String paramString)
  {
    AppMethodBeat.i(120860);
    af localaf = new af();
    localaf.field_originMD5 = paramString;
    if (get(localaf, new String[0]))
    {
      AppMethodBeat.o(120860);
      return localaf;
    }
    AppMethodBeat.o(120860);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.b
 * JD-Core Version:    0.7.0.1
 */