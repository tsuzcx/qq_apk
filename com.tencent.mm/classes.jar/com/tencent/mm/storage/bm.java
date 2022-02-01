package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;

public final class bm
  extends j<bl>
  implements f
{
  public static final String[] SQL_CREATE;
  private final l<f.a, bl> IIK;
  private e db;
  
  static
  {
    AppMethodBeat.i(211784);
    SQL_CREATE = new String[] { j.getCreateSQLs(bl.info, "FriendUser") };
    AppMethodBeat.o(211784);
  }
  
  public bm(e parame)
  {
    super(parame, bl.info, "FriendUser", null);
    AppMethodBeat.i(211778);
    this.IIK = new l() {};
    this.db = parame;
    AppMethodBeat.o(211778);
  }
  
  private void b(bl parambl)
  {
    AppMethodBeat.i(211775);
    if (this.IIK.dW(parambl)) {
      this.IIK.doNotify();
    }
    AppMethodBeat.o(211775);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(211776);
    this.IIK.a(parama, null);
    AppMethodBeat.o(211776);
  }
  
  public final bl aqT(String paramString)
  {
    AppMethodBeat.i(211779);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(211779);
      return null;
    }
    bl localbl = new bl();
    paramString = this.db.a("FriendUser", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbl.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(211779);
    return localbl;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(211777);
    this.IIK.remove(parama);
    AppMethodBeat.o(211777);
  }
  
  public final int doP()
  {
    AppMethodBeat.i(211780);
    Object localObject = String.format("select count(rowid) from %s", new Object[] { "FriendUser" });
    localObject = this.db.rawQuery((String)localObject, null);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      int i = ((Cursor)localObject).getInt(0);
      ((Cursor)localObject).close();
      ae.i("MicroMsg.FriendUserStorage", "#recordCnts#, count:".concat(String.valueOf(i)));
      AppMethodBeat.o(211780);
      return i;
    }
    AppMethodBeat.o(211780);
    return 0;
  }
  
  public final int doQ()
  {
    AppMethodBeat.i(211781);
    long l = System.currentTimeMillis();
    int i = this.db.delete("FriendUser", "(modifyTime< ?)", new String[] { String.valueOf(l - 604800000L) });
    if (i > 0) {
      doNotify();
    }
    ae.i("MicroMsg.FriendUserStorage", "#Clear Records#, result:".concat(String.valueOf(i)));
    AppMethodBeat.o(211781);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bm
 * JD-Core Version:    0.7.0.1
 */