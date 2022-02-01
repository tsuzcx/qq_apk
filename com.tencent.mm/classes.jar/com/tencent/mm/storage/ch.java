package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.n.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;

public final class ch
  extends j<cg>
  implements n
{
  public static final String[] SQL_CREATE;
  private final l<n.a, cg> IIK;
  private e db;
  
  static
  {
    AppMethodBeat.i(117352);
    SQL_CREATE = new String[] { j.getCreateSQLs(cg.info, "Stranger") };
    AppMethodBeat.o(117352);
  }
  
  public ch(e parame)
  {
    super(parame, cg.info, "Stranger", null);
    AppMethodBeat.i(117347);
    this.IIK = new l() {};
    this.db = parame;
    AppMethodBeat.o(117347);
  }
  
  private void b(cg paramcg)
  {
    AppMethodBeat.i(117344);
    if (this.IIK.dW(paramcg)) {
      this.IIK.doNotify();
    }
    AppMethodBeat.o(117344);
  }
  
  public final void a(n.a parama)
  {
    AppMethodBeat.i(117345);
    this.IIK.a(parama, null);
    AppMethodBeat.o(117345);
  }
  
  public final cg arE(String paramString)
  {
    AppMethodBeat.i(117348);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117348);
      return null;
    }
    cg localcg = new cg();
    paramString = this.db.a("Stranger", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcg.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117348);
    return localcg;
  }
  
  public final int arF(String paramString)
  {
    AppMethodBeat.i(117349);
    int i = this.db.delete("Stranger", "(encryptUsername=?)", new String[] { String.valueOf(paramString) });
    if (i > 0) {
      doNotify();
    }
    ae.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + paramString + " result:" + i);
    AppMethodBeat.o(117349);
    return i;
  }
  
  public final void b(n.a parama)
  {
    AppMethodBeat.i(117346);
    this.IIK.remove(parama);
    AppMethodBeat.o(117346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ch
 * JD-Core Version:    0.7.0.1
 */