package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.n.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;

public final class cg
  extends j<cf>
  implements n
{
  public static final String[] SQL_CREATE;
  private final l<n.a, cf> Iou;
  private e db;
  
  static
  {
    AppMethodBeat.i(117352);
    SQL_CREATE = new String[] { j.getCreateSQLs(cf.info, "Stranger") };
    AppMethodBeat.o(117352);
  }
  
  public cg(e parame)
  {
    super(parame, cf.info, "Stranger", null);
    AppMethodBeat.i(117347);
    this.Iou = new l() {};
    this.db = parame;
    AppMethodBeat.o(117347);
  }
  
  private void b(cf paramcf)
  {
    AppMethodBeat.i(117344);
    if (this.Iou.dV(paramcf)) {
      this.Iou.doNotify();
    }
    AppMethodBeat.o(117344);
  }
  
  public final void a(n.a parama)
  {
    AppMethodBeat.i(117345);
    this.Iou.a(parama, null);
    AppMethodBeat.o(117345);
  }
  
  public final int aqA(String paramString)
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
  
  public final cf aqz(String paramString)
  {
    AppMethodBeat.i(117348);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117348);
      return null;
    }
    cf localcf = new cf();
    paramString = this.db.a("Stranger", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcf.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117348);
    return localcf;
  }
  
  public final void b(n.a parama)
  {
    AppMethodBeat.i(117346);
    this.Iou.remove(parama);
    AppMethodBeat.o(117346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.cg
 * JD-Core Version:    0.7.0.1
 */