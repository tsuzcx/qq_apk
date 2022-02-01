package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;

public final class bx
  extends j<bw>
  implements m
{
  public static final String[] SQL_CREATE;
  private final l<m.a, bw> Feu;
  private e db;
  
  static
  {
    AppMethodBeat.i(117352);
    SQL_CREATE = new String[] { j.getCreateSQLs(bw.info, "Stranger") };
    AppMethodBeat.o(117352);
  }
  
  public bx(e parame)
  {
    super(parame, bw.info, "Stranger", null);
    AppMethodBeat.i(117347);
    this.Feu = new l() {};
    this.db = parame;
    AppMethodBeat.o(117347);
  }
  
  private void b(bw parambw)
  {
    AppMethodBeat.i(117344);
    if (this.Feu.dR(parambw)) {
      this.Feu.doNotify();
    }
    AppMethodBeat.o(117344);
  }
  
  public final void a(m.a parama)
  {
    AppMethodBeat.i(117345);
    this.Feu.a(parama, null);
    AppMethodBeat.o(117345);
  }
  
  public final bw agQ(String paramString)
  {
    AppMethodBeat.i(117348);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117348);
      return null;
    }
    bw localbw = new bw();
    paramString = this.db.a("Stranger", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbw.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117348);
    return localbw;
  }
  
  public final int agR(String paramString)
  {
    AppMethodBeat.i(117349);
    int i = this.db.delete("Stranger", "(encryptUsername=?)", new String[] { String.valueOf(paramString) });
    if (i > 0) {
      doNotify();
    }
    ad.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + paramString + " result:" + i);
    AppMethodBeat.o(117349);
    return i;
  }
  
  public final void b(m.a parama)
  {
    AppMethodBeat.i(117346);
    this.Feu.remove(parama);
    AppMethodBeat.o(117346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bx
 * JD-Core Version:    0.7.0.1
 */