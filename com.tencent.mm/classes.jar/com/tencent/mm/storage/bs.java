package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class bs
  extends com.tencent.mm.sdk.e.k
  implements com.tencent.mm.plugin.messenger.foundation.a.a.k, g.a
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )" };
  private e db = null;
  
  public bs(h paramh)
  {
    this.db = paramh;
  }
  
  private void a(br parambr)
  {
    AppMethodBeat.i(117324);
    parambr.dtM = 135;
    parambr = parambr.convertTo();
    if ((parambr.size() > 0) && (this.db.insert("role_info", "id", parambr) != 0L)) {
      doNotify();
    }
    AppMethodBeat.o(117324);
  }
  
  private br aJg(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117322);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      br localbr = new br();
      Cursor localCursor = this.db.a("role_info", null, "name= ?", new String[] { paramString }, null, null, null, 2);
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        localbr.convertFrom(localCursor);
        paramString = localbr;
      }
      localCursor.close();
      AppMethodBeat.o(117322);
      return paramString;
    }
  }
  
  private void b(br parambr)
  {
    AppMethodBeat.i(117329);
    ContentValues localContentValues = parambr.convertTo();
    if (localContentValues.size() > 0)
    {
      int i = this.db.update("role_info", localContentValues, "name like ?", new String[] { parambr.name });
      ad.d("MicroMsg.RoleStorage", "update role info, name=" + parambr.name + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
    }
    AppMethodBeat.o(117329);
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final br agP(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117321);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117321);
      return null;
    }
    br localbr = new br();
    Cursor localCursor = this.db.a("role_info", null, "name LIKE ?", new String[] { "%".concat(String.valueOf(paramString)) }, null, null, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      localbr.convertFrom(localCursor);
      paramString = localbr;
    }
    localCursor.close();
    AppMethodBeat.o(117321);
    return paramString;
  }
  
  public final void bi(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117327);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117327);
      return;
    }
    br localbr = aJg(paramString);
    if (localbr == null)
    {
      a(new br(paramString, paramBoolean, 2));
      ad.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117327);
      return;
    }
    localbr.setEnable(paramBoolean);
    localbr.dtM = 4;
    b(localbr);
    AppMethodBeat.o(117327);
  }
  
  public final List<br> cPb()
  {
    AppMethodBeat.i(117323);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.db.a("role_info", null, "int_reserved1=1", null, null, null, null, 2);
    while (localCursor.moveToNext())
    {
      br localbr = new br();
      localbr.convertFrom(localCursor);
      localLinkedList.add(localbr);
    }
    localCursor.close();
    AppMethodBeat.o(117323);
    return localLinkedList;
  }
  
  public final void dQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(117326);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117326);
      return;
    }
    if (aJg(paramString) == null)
    {
      a(new br(paramString, true, paramInt));
      ad.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(117326);
  }
  
  public final void delete(String paramString)
  {
    AppMethodBeat.i(117330);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      int i = this.db.delete("role_info", "name=?", new String[] { String.valueOf(paramString) });
      ad.d("MicroMsg.RoleStorage", "delete name name :" + paramString + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
      AppMethodBeat.o(117330);
      return;
    }
  }
  
  public final void e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    AppMethodBeat.i(117328);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117328);
      return;
    }
    br localbr = aJg(paramString);
    if (localbr == null)
    {
      a(new br(paramString, paramBoolean1, 2));
      ad.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117328);
      return;
    }
    localbr.setEnable(paramBoolean1);
    int j;
    if (paramBoolean2)
    {
      j = localbr.status;
      if (!paramBoolean2) {}
    }
    for (localbr.status = (i | j);; localbr.status &= 0xFFFFFFFD)
    {
      localbr.dtM = 4;
      b(localbr);
      AppMethodBeat.o(117328);
      return;
      i = 0;
      break;
    }
  }
  
  public final String getTableName()
  {
    return "role_info";
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(117325);
    br localbr = agP(new br.a(paramString).aJf(""));
    if ((localbr != null) && (paramString.equals(localbr.name)))
    {
      AppMethodBeat.o(117325);
      return true;
    }
    AppMethodBeat.o(117325);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bs
 * JD-Core Version:    0.7.0.1
 */