package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;

public final class co
  extends MAutoStorage<cn>
  implements n
{
  public static final String[] SQL_CREATE;
  private final MStorageEvent<n.a, cn> NQt;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(117352);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(cn.info, "Stranger") };
    AppMethodBeat.o(117352);
  }
  
  public co(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, cn.info, "Stranger", null);
    AppMethodBeat.i(117347);
    this.NQt = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(117347);
  }
  
  private void b(cn paramcn)
  {
    AppMethodBeat.i(117344);
    if (this.NQt.event(paramcn)) {
      this.NQt.doNotify();
    }
    AppMethodBeat.o(117344);
  }
  
  public final void a(n.a parama)
  {
    AppMethodBeat.i(117345);
    this.NQt.add(parama, null);
    AppMethodBeat.o(117345);
  }
  
  public final cn aEZ(String paramString)
  {
    AppMethodBeat.i(117348);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117348);
      return null;
    }
    cn localcn = new cn();
    paramString = this.db.query("Stranger", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcn.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117348);
    return localcn;
  }
  
  public final int aFa(String paramString)
  {
    AppMethodBeat.i(117349);
    int i = this.db.delete("Stranger", "(encryptUsername=?)", new String[] { String.valueOf(paramString) });
    if (i > 0) {
      doNotify();
    }
    Log.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + paramString + " result:" + i);
    AppMethodBeat.o(117349);
    return i;
  }
  
  public final void b(n.a parama)
  {
    AppMethodBeat.i(117346);
    this.NQt.remove(parama);
    AppMethodBeat.o(117346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.co
 * JD-Core Version:    0.7.0.1
 */