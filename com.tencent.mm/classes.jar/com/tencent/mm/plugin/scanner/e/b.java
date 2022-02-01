package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.plugin.scanner.model.aa;
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
    SQL_CREATE = new String[] { j.getCreateSQLs(aa.info, "ScanTranslationResult") };
    AppMethodBeat.o(120862);
  }
  
  public b(e parame)
  {
    super(parame, aa.info, "ScanTranslationResult", null);
    this.db = parame;
  }
  
  public final boolean a(aa paramaa)
  {
    AppMethodBeat.i(120861);
    if (amC(paramaa.field_originMD5) != null)
    {
      bool = replace(paramaa);
      AppMethodBeat.o(120861);
      return bool;
    }
    boolean bool = super.insert(paramaa);
    AppMethodBeat.o(120861);
    return bool;
  }
  
  public final fb amC(String paramString)
  {
    AppMethodBeat.i(120860);
    aa localaa = new aa();
    localaa.field_originMD5 = paramString;
    if (get(localaa, new String[0]))
    {
      AppMethodBeat.o(120860);
      return localaa;
    }
    AppMethodBeat.o(120860);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.b
 * JD-Core Version:    0.7.0.1
 */