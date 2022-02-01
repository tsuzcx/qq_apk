package com.tencent.mm.plugin.offline.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a
  extends MAutoStorage<t>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(66341);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(t.info, "OfflineOrderStatus") };
    AppMethodBeat.o(66341);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, t.info, "OfflineOrderStatus", null);
    this.db = paramISQLiteDatabase;
  }
  
  private boolean b(t paramt)
  {
    boolean bool = true;
    AppMethodBeat.i(66335);
    paramt = this.db.rawQuery("select * from OfflineOrderStatus where reqkey=?", new String[] { paramt.field_reqkey }, 2);
    if (paramt == null)
    {
      AppMethodBeat.o(66335);
      return false;
    }
    paramt.moveToFirst();
    if (!paramt.isAfterLast()) {}
    for (;;)
    {
      paramt.close();
      AppMethodBeat.o(66335);
      return bool;
      bool = false;
    }
  }
  
  public final t aQD(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(66336);
    Cursor localCursor = this.db.rawQuery("select * from OfflineOrderStatus where reqkey=?", new String[] { paramString }, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(66336);
      return null;
    }
    localCursor.moveToFirst();
    Log.i("MicroMsg.OfflineOrderStatusStorage", "in getOrderStatusByTranId: cursor.isAfterLast() = " + localCursor.isAfterLast());
    paramString = localObject;
    if (!localCursor.isAfterLast())
    {
      paramString = new t();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(66336);
    return paramString;
  }
  
  public final void aQE(String paramString)
  {
    AppMethodBeat.i(66338);
    t localt = aQD(paramString);
    if (localt != null) {
      localt.field_status = -1;
    }
    for (paramString = localt;; paramString = localt)
    {
      c(paramString);
      AppMethodBeat.o(66338);
      return;
      localt = new t();
      localt.field_reqkey = paramString;
      localt.field_status = -1;
    }
  }
  
  public final void c(t paramt)
  {
    AppMethodBeat.i(66337);
    if (paramt.field_reqkey == null)
    {
      Log.e("MicroMsg.OfflineOrderStatusStorage", "status.field_reqkey is null");
      AppMethodBeat.o(66337);
      return;
    }
    if (!b(paramt))
    {
      Log.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: insert reqKey: %s,  status: %d ", new Object[] { paramt.field_reqkey, Integer.valueOf(paramt.field_status) });
      insert(paramt);
      AppMethodBeat.o(66337);
      return;
    }
    Log.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: update reqKey: %s,  status: %d ", new Object[] { paramt.field_reqkey, Integer.valueOf(paramt.field_status) });
    update(paramt, new String[0]);
    AppMethodBeat.o(66337);
  }
  
  public final t gvq()
  {
    int i = 1;
    t localt = null;
    AppMethodBeat.i(66334);
    Log.i("MicroMsg.OfflineOrderStatusStorage", "in getLastestOrder: orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(gvs()), gvr() });
    Cursor localCursor = this.db.rawQuery("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(66334);
      return null;
    }
    localCursor.moveToFirst();
    if (!localCursor.isAfterLast())
    {
      if (i != 0)
      {
        localt = new t();
        localt.convertFrom(localCursor);
      }
      localCursor.close();
      if (localt == null) {
        break label141;
      }
      Log.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + localt.field_status);
    }
    for (;;)
    {
      AppMethodBeat.o(66334);
      return localt;
      i = 0;
      break;
      label141:
      Log.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
    }
  }
  
  public final String gvr()
  {
    AppMethodBeat.i(66339);
    String str = String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT %d;", new Object[] { "OfflineOrderStatus", "rowid", Integer.valueOf(3) });
    Cursor localCursor = this.db.rawQuery(str, null, 2);
    str = "";
    if (localCursor == null)
    {
      Log.e("MicroMsg.OfflineOrderStatusStorage", "getAllOrdersInfo: error.cursor is null\n");
      AppMethodBeat.o(66339);
      return str;
      label68:
      str = str + ";";
    }
    int j;
    for (int i = j;; i = 0)
    {
      if (localCursor.moveToNext())
      {
        j = i + 1;
        if (j <= 3)
        {
          i = 0;
          while (i < localCursor.getColumnCount())
          {
            str = str + localCursor.getColumnName(i) + ": " + localCursor.getString(i) + ", ";
            i += 1;
          }
          break label68;
        }
      }
      localCursor.close();
      break;
    }
  }
  
  public final int gvs()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(66340);
    Object localObject = String.format("SELECT COUNT(*) FROM %s;", new Object[] { "OfflineOrderStatus" });
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null) {
      Log.e("MicroMsg.OfflineOrderStatusStorage", "getOrdersCount: error.cursor is null\n");
    }
    for (;;)
    {
      AppMethodBeat.o(66340);
      return i;
      i = j;
      if (((Cursor)localObject).moveToNext())
      {
        i = j;
        if (((Cursor)localObject).getColumnCount() > 0) {
          i = ((Cursor)localObject).getInt(0);
        }
      }
      ((Cursor)localObject).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.b.a
 * JD-Core Version:    0.7.0.1
 */