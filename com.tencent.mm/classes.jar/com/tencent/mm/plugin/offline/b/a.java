package com.tencent.mm.plugin.offline.b;

import android.database.Cursor;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends i<r>
{
  public static final String[] dXp = { i.a(r.buS, "OfflineOrderStatus") };
  public e dXw;
  
  public a(e parame)
  {
    super(parame, r.buS, "OfflineOrderStatus", null);
    this.dXw = parame;
  }
  
  public final r Km(String paramString)
  {
    Object localObject = null;
    Cursor localCursor = this.dXw.a("select * from OfflineOrderStatus where reqkey=?", new String[] { paramString }, 2);
    if (localCursor == null) {
      return null;
    }
    localCursor.moveToFirst();
    y.i("MicroMsg.OfflineOrderStatusStorage", "in getOrderStatusByTranId: cursor.isAfterLast() = " + localCursor.isAfterLast());
    paramString = localObject;
    if (!localCursor.isAfterLast())
    {
      paramString = new r();
      paramString.d(localCursor);
    }
    localCursor.close();
    return paramString;
  }
  
  public final void Kn(String paramString)
  {
    r localr = Km(paramString);
    if (localr != null) {
      localr.field_status = -1;
    }
    for (paramString = localr;; paramString = localr)
    {
      b(paramString);
      return;
      localr = new r();
      localr.field_reqkey = paramString;
      localr.field_status = -1;
    }
  }
  
  public final void b(r paramr)
  {
    if (paramr.field_reqkey == null)
    {
      y.e("MicroMsg.OfflineOrderStatusStorage", "status.field_reqkey is null");
      return;
    }
    Cursor localCursor = this.dXw.a("select * from OfflineOrderStatus where reqkey=?", new String[] { paramr.field_reqkey }, 2);
    int i;
    if (localCursor == null)
    {
      i = 0;
      if (i == 0)
      {
        y.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: insert reqKey: %s,  status: %d ", new Object[] { paramr.field_reqkey, Integer.valueOf(paramr.field_status) });
        b(paramr);
      }
    }
    else
    {
      localCursor.moveToFirst();
      if (!localCursor.isAfterLast()) {}
      for (i = 1;; i = 0)
      {
        localCursor.close();
        break;
      }
    }
    y.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: update reqKey: %s,  status: %d ", new Object[] { paramr.field_reqkey, Integer.valueOf(paramr.field_status) });
    c(paramr, new String[0]);
  }
  
  public final r bqf()
  {
    int i = 1;
    r localr = null;
    y.i("MicroMsg.OfflineOrderStatusStorage", "in getLastestOrder: orders count: %d, latest 3 orders: %s", new Object[] { Integer.valueOf(bqh()), bqg() });
    Cursor localCursor = this.dXw.a("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
    if (localCursor == null) {
      return null;
    }
    localCursor.moveToFirst();
    if (!localCursor.isAfterLast()) {}
    for (;;)
    {
      if (i != 0)
      {
        localr = new r();
        localr.d(localCursor);
      }
      localCursor.close();
      if (localr == null) {
        break;
      }
      y.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + localr.field_status);
      return localr;
      i = 0;
    }
    y.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
    return localr;
  }
  
  public final String bqg()
  {
    String str = String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT %d;", new Object[] { "OfflineOrderStatus", "rowid", Integer.valueOf(3) });
    Cursor localCursor = this.dXw.a(str, null, 2);
    str = "";
    if (localCursor == null)
    {
      y.e("MicroMsg.OfflineOrderStatusStorage", "getAllOrdersInfo: error.cursor is null\n");
      return "";
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
          break;
        }
      }
      localCursor.close();
      return str;
    }
  }
  
  public final int bqh()
  {
    int j = 0;
    Object localObject = String.format("SELECT COUNT(*) FROM %s;", new Object[] { "OfflineOrderStatus" });
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.e("MicroMsg.OfflineOrderStatusStorage", "getOrdersCount: error.cursor is null\n");
      return 0;
    }
    int i = j;
    if (((Cursor)localObject).moveToNext())
    {
      i = j;
      if (((Cursor)localObject).getColumnCount() > 0) {
        i = ((Cursor)localObject).getInt(0);
      }
    }
    ((Cursor)localObject).close();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.b.a
 * JD-Core Version:    0.7.0.1
 */