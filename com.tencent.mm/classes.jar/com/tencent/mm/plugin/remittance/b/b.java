package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "DelayTransferRecord") };
  private static final String[] eWE = { "*", "rowid" };
  private e dXw;
  
  public b(e parame)
  {
    super(parame, a.buS, "DelayTransferRecord", null);
    this.dXw = parame;
  }
  
  public final a LL(String paramString)
  {
    if (bk.bl(paramString)) {
      y.i("MicroMsg.AARecordStorage", "empty transferId");
    }
    for (;;)
    {
      return null;
      paramString = this.dXw.a("DelayTransferRecord", eWE, "transferId=?", new String[] { paramString }, null, null, null, 2);
      try
      {
        if (paramString.moveToFirst())
        {
          a locala = new a();
          locala.d(paramString);
          return locala;
        }
        return null;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.AARecordStorage", localException, "", new Object[0]);
        return null;
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.b
 * JD-Core Version:    0.7.0.1
 */