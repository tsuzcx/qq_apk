package com.tencent.mm.plugin.offline.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends j<r>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(43442);
    SQL_CREATE = new String[] { j.getCreateSQLs(r.info, "OfflineOrderStatus") };
    AppMethodBeat.o(43442);
  }
  
  public a(e parame)
  {
    super(parame, r.info, "OfflineOrderStatus", null);
    this.db = parame;
  }
  
  private boolean b(r paramr)
  {
    boolean bool = true;
    AppMethodBeat.i(43436);
    paramr = this.db.a("select * from OfflineOrderStatus where reqkey=?", new String[] { paramr.field_reqkey }, 2);
    if (paramr == null)
    {
      AppMethodBeat.o(43436);
      return false;
    }
    paramr.moveToFirst();
    if (!paramr.isAfterLast()) {}
    for (;;)
    {
      paramr.close();
      AppMethodBeat.o(43436);
      return bool;
      bool = false;
    }
  }
  
  public final r Wl(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(43437);
    Cursor localCursor = this.db.a("select * from OfflineOrderStatus where reqkey=?", new String[] { paramString }, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(43437);
      return null;
    }
    localCursor.moveToFirst();
    ab.i("MicroMsg.OfflineOrderStatusStorage", "in getOrderStatusByTranId: cursor.isAfterLast() = " + localCursor.isAfterLast());
    paramString = localObject;
    if (!localCursor.isAfterLast())
    {
      paramString = new r();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(43437);
    return paramString;
  }
  
  public final void Wm(String paramString)
  {
    AppMethodBeat.i(43439);
    r localr = Wl(paramString);
    if (localr != null) {
      localr.field_status = -1;
    }
    for (paramString = localr;; paramString = localr)
    {
      c(paramString);
      AppMethodBeat.o(43439);
      return;
      localr = new r();
      localr.field_reqkey = paramString;
      localr.field_status = -1;
    }
  }
  
  public final r bYL()
  {
    int i = 1;
    r localr = null;
    AppMethodBeat.i(43435);
    ab.i("MicroMsg.OfflineOrderStatusStorage", "in getLastestOrder: orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(bYN()), bYM() });
    Cursor localCursor = this.db.a("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(43435);
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
      ab.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + localr.field_status);
    }
    for (;;)
    {
      AppMethodBeat.o(43435);
      return localr;
      i = 0;
      break;
      label141:
      ab.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
    }
  }
  
  public final String bYM()
  {
    AppMethodBeat.i(43440);
    String str = String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT %d;", new Object[] { "OfflineOrderStatus", "rowid", Integer.valueOf(3) });
    Cursor localCursor = this.db.a(str, null, 2);
    str = "";
    if (localCursor == null)
    {
      ab.e("MicroMsg.OfflineOrderStatusStorage", "getAllOrdersInfo: error.cursor is null\n");
      AppMethodBeat.o(43440);
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
  
  public final int bYN()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(43441);
    Object localObject = String.format("SELECT COUNT(*) FROM %s;", new Object[] { "OfflineOrderStatus" });
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null) {
      ab.e("MicroMsg.OfflineOrderStatusStorage", "getOrdersCount: error.cursor is null\n");
    }
    for (;;)
    {
      AppMethodBeat.o(43441);
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
  
  public final void c(r paramr)
  {
    AppMethodBeat.i(43438);
    if (paramr.field_reqkey == null)
    {
      ab.e("MicroMsg.OfflineOrderStatusStorage", "status.field_reqkey is null");
      AppMethodBeat.o(43438);
      return;
    }
    if (!b(paramr))
    {
      ab.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: insert reqKey: %s,  status: %d ", new Object[] { paramr.field_reqkey, Integer.valueOf(paramr.field_status) });
      insert(paramr);
      AppMethodBeat.o(43438);
      return;
    }
    ab.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: update reqKey: %s,  status: %d ", new Object[] { paramr.field_reqkey, Integer.valueOf(paramr.field_status) });
    update(paramr, new String[0]);
    AppMethodBeat.o(43438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.b.a
 * JD-Core Version:    0.7.0.1
 */