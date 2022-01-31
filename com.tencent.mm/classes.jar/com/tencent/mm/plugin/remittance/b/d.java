package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  private static final String[] goC;
  public static Map<String, c> goD;
  private e db;
  
  static
  {
    AppMethodBeat.i(44712);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "RemittanceRecord") };
    goC = new String[] { "*", "rowid" };
    goD = new HashMap();
    AppMethodBeat.o(44712);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "RemittanceRecord", null);
    this.db = parame;
  }
  
  public final c Ye(String paramString)
  {
    AppMethodBeat.i(44707);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44707);
      return null;
    }
    paramString = this.db.a("RemittanceRecord", goC, "transferId=?", new String[] { paramString }, null, null, null, 2);
    try
    {
      if (paramString.moveToFirst())
      {
        c localc = new c();
        localc.convertFrom(paramString);
        return localc;
      }
      paramString.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", localException, "getRecordByTransferId error: %s", new Object[] { localException.getMessage() });
        paramString.close();
      }
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(44707);
    }
    AppMethodBeat.o(44707);
    return null;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(44708);
    if ((paramc != null) && (goD.containsKey(paramc.field_transferId))) {
      goD.put(paramc.field_transferId, paramc);
    }
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(44708);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.d
 * JD-Core Version:    0.7.0.1
 */