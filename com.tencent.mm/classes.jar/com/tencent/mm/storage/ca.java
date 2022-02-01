package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;

public final class ca
  extends j<bz>
  implements m
{
  public static final String[] SQL_CREATE;
  private final l<m.a, bz> GCe;
  private e db;
  
  static
  {
    AppMethodBeat.i(117352);
    SQL_CREATE = new String[] { j.getCreateSQLs(bz.info, "Stranger") };
    AppMethodBeat.o(117352);
  }
  
  public ca(e parame)
  {
    super(parame, bz.info, "Stranger", null);
    AppMethodBeat.i(117347);
    this.GCe = new l() {};
    this.db = parame;
    AppMethodBeat.o(117347);
  }
  
  private void b(bz parambz)
  {
    AppMethodBeat.i(117344);
    if (this.GCe.dS(parambz)) {
      this.GCe.doNotify();
    }
    AppMethodBeat.o(117344);
  }
  
  public final void a(m.a parama)
  {
    AppMethodBeat.i(117345);
    this.GCe.a(parama, null);
    AppMethodBeat.o(117345);
  }
  
  public final bz alK(String paramString)
  {
    AppMethodBeat.i(117348);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117348);
      return null;
    }
    bz localbz = new bz();
    paramString = this.db.a("Stranger", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbz.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117348);
    return localbz;
  }
  
  public final int alL(String paramString)
  {
    AppMethodBeat.i(117349);
    int i = this.db.delete("Stranger", "(encryptUsername=?)", new String[] { String.valueOf(paramString) });
    if (i > 0) {
      doNotify();
    }
    ac.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + paramString + " result:" + i);
    AppMethodBeat.o(117349);
    return i;
  }
  
  public final void b(m.a parama)
  {
    AppMethodBeat.i(117346);
    this.GCe.remove(parama);
    AppMethodBeat.o(117346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ca
 * JD-Core Version:    0.7.0.1
 */