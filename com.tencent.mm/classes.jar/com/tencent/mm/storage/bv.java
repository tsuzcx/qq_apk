package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class bv
  extends com.tencent.mm.sdk.e.k
  implements com.tencent.mm.plugin.messenger.foundation.a.a.k, g.a
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )" };
  private e db = null;
  
  public bv(h paramh)
  {
    this.db = paramh;
  }
  
  private void a(bu parambu)
  {
    AppMethodBeat.i(117324);
    parambu.drx = 135;
    parambu = parambu.convertTo();
    if ((parambu.size() > 0) && (this.db.insert("role_info", "id", parambu) != 0L)) {
      doNotify();
    }
    AppMethodBeat.o(117324);
  }
  
  private bu aOC(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117322);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bu localbu = new bu();
      Cursor localCursor = this.db.a("role_info", null, "name= ?", new String[] { paramString }, null, null, null, 2);
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        localbu.convertFrom(localCursor);
        paramString = localbu;
      }
      localCursor.close();
      AppMethodBeat.o(117322);
      return paramString;
    }
  }
  
  private void b(bu parambu)
  {
    AppMethodBeat.i(117329);
    ContentValues localContentValues = parambu.convertTo();
    if (localContentValues.size() > 0)
    {
      int i = this.db.update("role_info", localContentValues, "name like ?", new String[] { parambu.name });
      ac.d("MicroMsg.RoleStorage", "update role info, name=" + parambu.name + ", res:" + i);
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
  
  public final bu alJ(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117321);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117321);
      return null;
    }
    bu localbu = new bu();
    Cursor localCursor = this.db.a("role_info", null, "name LIKE ?", new String[] { "%".concat(String.valueOf(paramString)) }, null, null, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      localbu.convertFrom(localCursor);
      paramString = localbu;
    }
    localCursor.close();
    AppMethodBeat.o(117321);
    return paramString;
  }
  
  public final void bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117327);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117327);
      return;
    }
    bu localbu = aOC(paramString);
    if (localbu == null)
    {
      a(new bu(paramString, paramBoolean, 2));
      ac.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117327);
      return;
    }
    localbu.setEnable(paramBoolean);
    localbu.drx = 4;
    b(localbu);
    AppMethodBeat.o(117327);
  }
  
  public final void dX(String paramString, int paramInt)
  {
    AppMethodBeat.i(117326);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117326);
      return;
    }
    if (aOC(paramString) == null)
    {
      a(new bu(paramString, true, paramInt));
      ac.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(117326);
  }
  
  public final List<bu> dcK()
  {
    AppMethodBeat.i(117323);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.db.a("role_info", null, "int_reserved1=1", null, null, null, null, 2);
    while (localCursor.moveToNext())
    {
      bu localbu = new bu();
      localbu.convertFrom(localCursor);
      localLinkedList.add(localbu);
    }
    localCursor.close();
    AppMethodBeat.o(117323);
    return localLinkedList;
  }
  
  public final void delete(String paramString)
  {
    AppMethodBeat.i(117330);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      int i = this.db.delete("role_info", "name=?", new String[] { String.valueOf(paramString) });
      ac.d("MicroMsg.RoleStorage", "delete name name :" + paramString + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
      AppMethodBeat.o(117330);
      return;
    }
  }
  
  public final void f(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    AppMethodBeat.i(117328);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117328);
      return;
    }
    bu localbu = aOC(paramString);
    if (localbu == null)
    {
      a(new bu(paramString, paramBoolean1, 2));
      ac.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117328);
      return;
    }
    localbu.setEnable(paramBoolean1);
    int j;
    if (paramBoolean2)
    {
      j = localbu.status;
      if (!paramBoolean2) {}
    }
    for (localbu.status = (i | j);; localbu.status &= 0xFFFFFFFD)
    {
      localbu.drx = 4;
      b(localbu);
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
    bu localbu = alJ(new bu.a(paramString).aOB(""));
    if ((localbu != null) && (paramString.equals(localbu.name)))
    {
      AppMethodBeat.o(117325);
      return true;
    }
    AppMethodBeat.o(117325);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bv
 * JD-Core Version:    0.7.0.1
 */