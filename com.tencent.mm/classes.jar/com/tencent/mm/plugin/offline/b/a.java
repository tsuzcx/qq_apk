package com.tencent.mm.plugin.offline.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends j<r>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(66341);
    SQL_CREATE = new String[] { j.getCreateSQLs(r.info, "OfflineOrderStatus") };
    AppMethodBeat.o(66341);
  }
  
  public a(e parame)
  {
    super(parame, r.info, "OfflineOrderStatus", null);
    this.db = parame;
  }
  
  private boolean b(r paramr)
  {
    boolean bool = true;
    AppMethodBeat.i(66335);
    paramr = this.db.a("select * from OfflineOrderStatus where reqkey=?", new String[] { paramr.field_reqkey }, 2);
    if (paramr == null)
    {
      AppMethodBeat.o(66335);
      return false;
    }
    paramr.moveToFirst();
    if (!paramr.isAfterLast()) {}
    for (;;)
    {
      paramr.close();
      AppMethodBeat.o(66335);
      return bool;
      bool = false;
    }
  }
  
  public final r ajF(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(66336);
    Cursor localCursor = this.db.a("select * from OfflineOrderStatus where reqkey=?", new String[] { paramString }, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(66336);
      return null;
    }
    localCursor.moveToFirst();
    ad.i("MicroMsg.OfflineOrderStatusStorage", "in getOrderStatusByTranId: cursor.isAfterLast() = " + localCursor.isAfterLast());
    paramString = localObject;
    if (!localCursor.isAfterLast())
    {
      paramString = new r();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(66336);
    return paramString;
  }
  
  public final void ajG(String paramString)
  {
    AppMethodBeat.i(66338);
    r localr = ajF(paramString);
    if (localr != null) {
      localr.field_status = -1;
    }
    for (paramString = localr;; paramString = localr)
    {
      c(paramString);
      AppMethodBeat.o(66338);
      return;
      localr = new r();
      localr.field_reqkey = paramString;
      localr.field_status = -1;
    }
  }
  
  public final void c(r paramr)
  {
    AppMethodBeat.i(66337);
    if (paramr.field_reqkey == null)
    {
      ad.e("MicroMsg.OfflineOrderStatusStorage", "status.field_reqkey is null");
      AppMethodBeat.o(66337);
      return;
    }
    if (!b(paramr))
    {
      ad.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: insert reqKey: %s,  status: %d ", new Object[] { paramr.field_reqkey, Integer.valueOf(paramr.field_status) });
      insert(paramr);
      AppMethodBeat.o(66337);
      return;
    }
    ad.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: update reqKey: %s,  status: %d ", new Object[] { paramr.field_reqkey, Integer.valueOf(paramr.field_status) });
    update(paramr, new String[0]);
    AppMethodBeat.o(66337);
  }
  
  public final r cYx()
  {
    int i = 1;
    r localr = null;
    AppMethodBeat.i(66334);
    ad.i("MicroMsg.OfflineOrderStatusStorage", "in getLastestOrder: orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(cYz()), cYy() });
    Cursor localCursor = this.db.a("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
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
        localr = new r();
        localr.convertFrom(localCursor);
      }
      localCursor.close();
      if (localr == null) {
        break label141;
      }
      ad.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + localr.field_status);
    }
    for (;;)
    {
      AppMethodBeat.o(66334);
      return localr;
      i = 0;
      break;
      label141:
      ad.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
    }
  }
  
  public final String cYy()
  {
    AppMethodBeat.i(66339);
    String str = String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT %d;", new Object[] { "OfflineOrderStatus", "rowid", Integer.valueOf(3) });
    Cursor localCursor = this.db.a(str, null, 2);
    str = "";
    if (localCursor == null)
    {
      ad.e("MicroMsg.OfflineOrderStatusStorage", "getAllOrdersInfo: error.cursor is null\n");
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
  
  public final int cYz()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(66340);
    Object localObject = String.format("SELECT COUNT(*) FROM %s;", new Object[] { "OfflineOrderStatus" });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null) {
      ad.e("MicroMsg.OfflineOrderStatusStorage", "getOrdersCount: error.cursor is null\n");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.b.a
 * JD-Core Version:    0.7.0.1
 */