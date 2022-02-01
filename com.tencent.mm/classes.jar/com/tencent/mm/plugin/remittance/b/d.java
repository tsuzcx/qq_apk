package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  private static final String[] iaF;
  public static Map<String, c> iaG;
  private e db;
  
  static
  {
    AppMethodBeat.i(67625);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "RemittanceRecord") };
    iaF = new String[] { "*", "rowid" };
    iaG = new HashMap();
    AppMethodBeat.o(67625);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "RemittanceRecord", null);
    this.db = parame;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(67621);
    if ((paramc != null) && (iaG.containsKey(paramc.field_transferId))) {
      iaG.put(paramc.field_transferId, paramc);
    }
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(67621);
    return bool;
  }
  
  public final c amc(String paramString)
  {
    AppMethodBeat.i(67620);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67620);
      return null;
    }
    paramString = this.db.a("RemittanceRecord", iaF, "transferId=?", new String[] { paramString }, null, null, null, 2);
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
        ad.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", localException, "getRecordByTransferId error: %s", new Object[] { localException.getMessage() });
        paramString.close();
      }
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(67620);
    }
    AppMethodBeat.o(67620);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.d
 * JD-Core Version:    0.7.0.1
 */