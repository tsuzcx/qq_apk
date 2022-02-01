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
  private final MStorageEvent<f.a, bq> Vep;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(188028);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bq.info, "FriendUser") };
    AppMethodBeat.o(188028);
  }
  
  public br(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bq.info, "FriendUser", null);
    AppMethodBeat.i(188009);
    this.Vep = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(188009);
  }
  
  private void b(bq parambq)
  {
    AppMethodBeat.i(187998);
    if (this.Vep.event(parambq)) {
      this.Vep.doNotify();
    }
    AppMethodBeat.o(187998);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(188001);
    this.Vep.add(parama, null);
    AppMethodBeat.o(188001);
  }
  
  public final bq aOy(String paramString)
  {
    AppMethodBeat.i(188010);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(188010);
      return null;
    }
    bq localbq = new bq();
    paramString = this.db.query("FriendUser", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbq.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(188010);
    return localbq;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(188002);
    this.Vep.remove(parama);
    AppMethodBeat.o(188002);
  }
  
  public final int eSk()
  {
    AppMethodBeat.i(188012);
    Object localObject = String.format("select count(rowid) from %s", new Object[] { "FriendUser" });
    localObject = this.db.rawQuery((String)localObject, null);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      int i = ((Cursor)localObject).getInt(0);
      ((Cursor)localObject).close();
      Log.i("MicroMsg.FriendUserStorage", "#recordCnts#, count:".concat(String.valueOf(i)));
      AppMethodBeat.o(188012);
      return i;
    }
    AppMethodBeat.o(188012);
    return 0;
  }
  
  public final int eSl()
  {
    AppMethodBeat.i(188014);
    long l = System.currentTimeMillis();
    int i = this.db.delete("FriendUser", "(modifyTime< ?)", new String[] { String.valueOf(l - 604800000L) });
    if (i > 0) {
      doNotify();
    }
    Log.i("MicroMsg.FriendUserStorage", "#Clear Records#, result:".concat(String.valueOf(i)));
    AppMethodBeat.o(188014);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.br
 * JD-Core Version:    0.7.0.1
 */