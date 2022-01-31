package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class bw
  extends j<bv>
  implements m
{
  public static final String[] SQL_CREATE;
  private e db;
  private final l<m.a, bv> ywD;
  
  static
  {
    AppMethodBeat.i(1482);
    SQL_CREATE = new String[] { j.getCreateSQLs(bv.info, "Stranger") };
    AppMethodBeat.o(1482);
  }
  
  public bw(e parame)
  {
    super(parame, bv.info, "Stranger", null);
    AppMethodBeat.i(1477);
    this.ywD = new l() {};
    this.db = parame;
    AppMethodBeat.o(1477);
  }
  
  private void b(bv parambv)
  {
    AppMethodBeat.i(1474);
    if (this.ywD.cy(parambv)) {
      this.ywD.doNotify();
    }
    AppMethodBeat.o(1474);
  }
  
  public final bv TM(String paramString)
  {
    AppMethodBeat.i(1478);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(1478);
      return null;
    }
    bv localbv = new bv();
    paramString = this.db.a("Stranger", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1478);
    return localbv;
  }
  
  public final int TN(String paramString)
  {
    AppMethodBeat.i(1479);
    int i = this.db.delete("Stranger", "(encryptUsername=?)", new String[] { String.valueOf(paramString) });
    if (i > 0) {
      doNotify();
    }
    ab.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + paramString + " result:" + i);
    AppMethodBeat.o(1479);
    return i;
  }
  
  public final void a(m.a parama)
  {
    AppMethodBeat.i(1475);
    this.ywD.a(parama, null);
    AppMethodBeat.o(1475);
  }
  
  public final void b(m.a parama)
  {
    AppMethodBeat.i(1476);
    this.ywD.remove(parama);
    AppMethodBeat.o(1476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bw
 * JD-Core Version:    0.7.0.1
 */