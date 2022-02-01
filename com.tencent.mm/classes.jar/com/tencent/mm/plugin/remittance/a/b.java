package com.tencent.mm.plugin.remittance.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  private static final String[] pHB;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(67618);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "DelayTransferRecord") };
    pHB = new String[] { "*", "rowid" };
    AppMethodBeat.o(67618);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "DelayTransferRecord", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final a aTN(String paramString)
  {
    AppMethodBeat.i(67617);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.AARecordStorage", "empty transferId");
      AppMethodBeat.o(67617);
      return null;
    }
    paramString = this.db.query("DelayTransferRecord", pHB, "transferId=?", new String[] { paramString }, null, null, null, 2);
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
        Log.printErrStackTrace("MicroMsg.AARecordStorage", localException, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.b
 * JD-Core Version:    0.7.0.1
 */