package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class bn
  extends j<bm>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(80292);
    SQL_CREATE = new String[] { j.getCreateSQLs(bm.info, "NewTipsInfo") };
    AppMethodBeat.o(80292);
  }
  
  public bn(e parame)
  {
    super(parame, bm.info, "NewTipsInfo", null);
    this.db = parame;
  }
  
  public final bm Ny(int paramInt)
  {
    AppMethodBeat.i(80289);
    if (this.db == null)
    {
      ab.e("MicroMsg.NewTipsInfoStorage", "getByTipsId, but db is null, return");
      AppMethodBeat.o(80289);
      return null;
    }
    Cursor localCursor = this.db.a("NewTipsInfo", null, "tipId=?", new String[] { String.valueOf(paramInt) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      bm localbm = new bm();
      try
      {
        localbm.convertFrom(localCursor);
        localCursor.close();
        AppMethodBeat.o(80289);
        return localbm;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.NewTipsInfoStorage", "getByTipsId convertFrom(cu) cause IlleagalStateException, return null");
        localCursor.close();
        AppMethodBeat.o(80289);
        return null;
      }
    }
    ab.w("MicroMsg.NewTipsInfoStorage", "getByTipsId:%d, no data", new Object[] { Integer.valueOf(paramInt) });
    localCursor.close();
    AppMethodBeat.o(80289);
    return null;
  }
  
  public final boolean a(bm parambm, String... paramVarArgs)
  {
    AppMethodBeat.i(80288);
    if (parambm == null)
    {
      ab.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
      AppMethodBeat.o(80288);
      return false;
    }
    boolean bool = super.updateNotify(parambm, false, paramVarArgs);
    if (bool) {
      doNotify(parambm.field_tipId, 3, Integer.valueOf(parambm.field_tipId));
    }
    ab.d("MicroMsg.NewTipsInfoStorage", "update result[%B]", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(80288);
    return bool;
  }
  
  public final boolean f(bm parambm)
  {
    AppMethodBeat.i(80287);
    if (parambm == null)
    {
      ab.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
      AppMethodBeat.o(80287);
      return false;
    }
    if (parambm.field_tipId <= 0)
    {
      ab.e("MicroMsg.NewTipsInfoStorage", "newTipsId is error, tipsId = %s", new Object[] { Integer.valueOf(parambm.field_tipId) });
      AppMethodBeat.o(80287);
      return false;
    }
    boolean bool = insertNotify(parambm, false);
    if (bool) {
      doNotify(parambm.field_tipId, 2, Integer.valueOf(parambm.field_tipId));
    }
    AppMethodBeat.o(80287);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bn
 * JD-Core Version:    0.7.0.1
 */