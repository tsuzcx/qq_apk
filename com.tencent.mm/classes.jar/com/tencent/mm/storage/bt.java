package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;

public final class bt
  extends MAutoStorage<bs>
  implements f
{
  public static final String[] SQL_CREATE;
  private final MStorageEvent<f.a, bs> acFL;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(248435);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bs.info, "FriendUser") };
    AppMethodBeat.o(248435);
  }
  
  public bt(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bs.info, "FriendUser", null);
    AppMethodBeat.i(248432);
    this.acFL = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(248432);
  }
  
  private void b(bs parambs)
  {
    AppMethodBeat.i(248429);
    if (this.acFL.event(parambs)) {
      this.acFL.doNotify();
    }
    AppMethodBeat.o(248429);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(248437);
    this.acFL.add(parama, null);
    AppMethodBeat.o(248437);
  }
  
  public final bs aLx(String paramString)
  {
    AppMethodBeat.i(248441);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(248441);
      return null;
    }
    bs localbs = new bs();
    paramString = this.db.query("FriendUser", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbs.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(248441);
    return localbs;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(248439);
    this.acFL.remove(parama);
    AppMethodBeat.o(248439);
  }
  
  public final int gbf()
  {
    AppMethodBeat.i(248442);
    Object localObject = String.format("select count(rowid) from %s", new Object[] { "FriendUser" });
    localObject = this.db.rawQuery((String)localObject, null);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      int i = ((Cursor)localObject).getInt(0);
      ((Cursor)localObject).close();
      Log.i("MicroMsg.FriendUserStorage", "#recordCnts#, count:".concat(String.valueOf(i)));
      AppMethodBeat.o(248442);
      return i;
    }
    AppMethodBeat.o(248442);
    return 0;
  }
  
  public final int gbg()
  {
    AppMethodBeat.i(248443);
    long l = System.currentTimeMillis();
    int i = this.db.delete("FriendUser", "(modifyTime< ?)", new String[] { String.valueOf(l - 604800000L) });
    if (i > 0) {
      doNotify();
    }
    Log.i("MicroMsg.FriendUserStorage", "#Clear Records#, result:".concat(String.valueOf(i)));
    AppMethodBeat.o(248443);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bt
 * JD-Core Version:    0.7.0.1
 */