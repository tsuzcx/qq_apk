package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.plugin.scanner.model.ac;
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
    SQL_CREATE = new String[] { j.getCreateSQLs(ac.info, "ScanTranslationResult") };
    AppMethodBeat.o(120862);
  }
  
  public b(e parame)
  {
    super(parame, ac.info, "ScanTranslationResult", null);
    this.db = parame;
  }
  
  public final boolean a(ac paramac)
  {
    AppMethodBeat.i(120861);
    if (arL(paramac.field_originMD5) != null)
    {
      bool = replace(paramac);
      AppMethodBeat.o(120861);
      return bool;
    }
    boolean bool = super.insert(paramac);
    AppMethodBeat.o(120861);
    return bool;
  }
  
  public final ff arL(String paramString)
  {
    AppMethodBeat.i(120860);
    ac localac = new ac();
    localac.field_originMD5 = paramString;
    if (get(localac, new String[0]))
    {
      AppMethodBeat.o(120860);
      return localac;
    }
    AppMethodBeat.o(120860);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.b
 * JD-Core Version:    0.7.0.1
 */