package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private static final String[] goC;
  private e db;
  
  static
  {
    AppMethodBeat.i(44705);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "DelayTransferRecord") };
    goC = new String[] { "*", "rowid" };
    AppMethodBeat.o(44705);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "DelayTransferRecord", null);
    this.db = parame;
  }
  
  public final a Yd(String paramString)
  {
    AppMethodBeat.i(44704);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.AARecordStorage", "empty transferId");
      AppMethodBeat.o(44704);
      return null;
    }
    paramString = this.db.a("DelayTransferRecord", goC, "transferId=?", new String[] { paramString }, null, null, null, 2);
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
        ab.printErrStackTrace("MicroMsg.AARecordStorage", localException, "", new Object[0]);
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
      AppMethodBeat.o(44704);
    }
    AppMethodBeat.o(44704);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.b
 * JD-Core Version:    0.7.0.1
 */