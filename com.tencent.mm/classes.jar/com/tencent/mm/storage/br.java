package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;

public final class br
  extends MAutoStorage<bq>
  implements f
{
  public static final String[] SQL_CREATE;
  private final MStorageEvent<f.a, bq> NQt;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(187516);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bq.info, "FriendUser") };
    AppMethodBeat.o(187516);
  }
  
  public br(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bq.info, "FriendUser", null);
    AppMethodBeat.i(187510);
    this.NQt = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(187510);
  }
  
  private void b(bq parambq)
  {
    AppMethodBeat.i(187507);
    if (this.NQt.event(parambq)) {
      this.NQt.doNotify();
    }
    AppMethodBeat.o(187507);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(187508);
    this.NQt.add(parama, null);
    AppMethodBeat.o(187508);
  }
  
  public final bq aEo(String paramString)
  {
    AppMethodBeat.i(187511);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(187511);
      return null;
    }
    bq localbq = new bq();
    paramString = this.db.query("FriendUser", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbq.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(187511);
    return localbq;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(187509);
    this.NQt.remove(parama);
    AppMethodBeat.o(187509);
  }
  
  public final int eiE()
  {
    AppMethodBeat.i(187512);
    Object localObject = String.format("select count(rowid) from %s", new Object[] { "FriendUser" });
    localObject = this.db.rawQuery((String)localObject, null);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      int i = ((Cursor)localObject).getInt(0);
      ((Cursor)localObject).close();
      Log.i("MicroMsg.FriendUserStorage", "#recordCnts#, count:".concat(String.valueOf(i)));
      AppMethodBeat.o(187512);
      return i;
    }
    AppMethodBeat.o(187512);
    return 0;
  }
  
  public final int eiF()
  {
    AppMethodBeat.i(187513);
    long l = System.currentTimeMillis();
    int i = this.db.delete("FriendUser", "(modifyTime< ?)", new String[] { String.valueOf(l - 604800000L) });
    if (i > 0) {
      doNotify();
    }
    Log.i("MicroMsg.FriendUserStorage", "#Clear Records#, result:".concat(String.valueOf(i)));
    AppMethodBeat.o(187513);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.br
 * JD-Core Version:    0.7.0.1
 */