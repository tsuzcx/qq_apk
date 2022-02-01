package com.tencent.mm.plugin.newtips.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(127268);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "NewTipsInfo") };
    AppMethodBeat.o(127268);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "NewTipsInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(127264);
    if (parama == null)
    {
      Log.e("MicroMsg.NewTipsCompatInfoStorage", "NewTipsCompatInfo is null!");
      AppMethodBeat.o(127264);
      return false;
    }
    boolean bool = super.updateNotify(parama, false, paramVarArgs);
    if (bool) {
      doNotify(parama.field_tipId, 3, Integer.valueOf(parama.field_tipId));
    }
    Log.d("MicroMsg.NewTipsCompatInfoStorage", "update result[%B]", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(127264);
    return bool;
  }
  
  public final a aas(int paramInt)
  {
    AppMethodBeat.i(127265);
    if (this.db == null)
    {
      Log.e("MicroMsg.NewTipsCompatInfoStorage", "getByTipsId, but db is null, return");
      AppMethodBeat.o(127265);
      return null;
    }
    Cursor localCursor = this.db.query("NewTipsInfo", null, "tipId=?", new String[] { String.valueOf(paramInt) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      a locala = new a();
      try
      {
        locala.convertFrom(localCursor);
        localCursor.close();
        AppMethodBeat.o(127265);
        return locala;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NewTipsCompatInfoStorage", "getByTipsId convertFrom(cu) cause IlleagalStateException, return null");
        localCursor.close();
        AppMethodBeat.o(127265);
        return null;
      }
    }
    Log.w("MicroMsg.NewTipsCompatInfoStorage", "getByTipsId:%d, no data", new Object[] { Integer.valueOf(paramInt) });
    localCursor.close();
    AppMethodBeat.o(127265);
    return null;
  }
  
  public final boolean f(a parama)
  {
    AppMethodBeat.i(127263);
    if (parama == null)
    {
      Log.e("MicroMsg.NewTipsCompatInfoStorage", "NewTipsCompatInfo is null!");
      AppMethodBeat.o(127263);
      return false;
    }
    if (parama.field_tipId <= 0)
    {
      Log.e("MicroMsg.NewTipsCompatInfoStorage", "newTipsId is error, tipsId = %s", new Object[] { Integer.valueOf(parama.field_tipId) });
      AppMethodBeat.o(127263);
      return false;
    }
    boolean bool = insertNotify(parama, false);
    if (bool) {
      doNotify(parama.field_tipId, 2, Integer.valueOf(parama.field_tipId));
    }
    AppMethodBeat.o(127263);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.b
 * JD-Core Version:    0.7.0.1
 */