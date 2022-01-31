package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends i<c>
{
  public static final String[] dXp = { i.a(c.buS, "RemittanceRecord") };
  private static final String[] eWE = { "*", "rowid" };
  public static Map<String, c> eWF = new HashMap();
  private e dXw;
  
  public d(e parame)
  {
    super(parame, c.buS, "RemittanceRecord", null);
    this.dXw = parame;
  }
  
  public final c LM(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    paramString = this.dXw.a("RemittanceRecord", eWE, "transferId=?", new String[] { paramString }, null, null, null, 2);
    try
    {
      if (paramString.moveToFirst())
      {
        c localc = new c();
        localc.d(paramString);
        return localc;
      }
      return null;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", localException, "getRecordByTransferId error: %s", new Object[] { localException.getMessage() });
      return null;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public final boolean a(c paramc)
  {
    if ((paramc != null) && (eWF.containsKey(paramc.field_transferId))) {
      eWF.put(paramc.field_transferId, paramc);
    }
    return super.a(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.d
 * JD-Core Version:    0.7.0.1
 */