package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private static final String[] iTS;
  private e db;
  
  static
  {
    AppMethodBeat.i(67618);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "DelayTransferRecord") };
    iTS = new String[] { "*", "rowid" };
    AppMethodBeat.o(67618);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "DelayTransferRecord", null);
    this.db = parame;
  }
  
  public final a awg(String paramString)
  {
    AppMethodBeat.i(67617);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.AARecordStorage", "empty transferId");
      AppMethodBeat.o(67617);
      return null;
    }
    paramString = this.db.a("DelayTransferRecord", iTS, "transferId=?", new String[] { paramString }, null, null, null, 2);
    try
    {
      if (paramString.moveToFirst())
      {
        a locala = new a();
        locala.convertFrom(paramString);
        return locala;
      }
      if (paramString != null) {
        paramString.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AARecordStorage", localException, "", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (paramString == null) {
        break label148;
      }
      paramString.close();
      AppMethodBeat.o(67617);
    }
    AppMethodBeat.o(67617);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.b
 * JD-Core Version:    0.7.0.1
 */