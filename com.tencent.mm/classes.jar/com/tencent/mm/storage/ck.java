package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ck
  extends MStorage
  implements l
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )" };
  private ISQLiteDatabase db = null;
  
  public ck(h paramh)
  {
    this.db = paramh;
  }
  
  private void a(cj paramcj)
  {
    AppMethodBeat.i(117324);
    paramcj.cUP = 135;
    paramcj = paramcj.convertTo();
    if ((paramcj.size() > 0) && (this.db.insert("role_info", "id", paramcj) != 0L)) {
      doNotify();
    }
    AppMethodBeat.o(117324);
  }
  
  private void b(cj paramcj)
  {
    AppMethodBeat.i(117329);
    ContentValues localContentValues = paramcj.convertTo();
    if (localContentValues.size() > 0)
    {
      int i = this.db.update("role_info", localContentValues, "name like ?", new String[] { paramcj.name });
      Log.d("MicroMsg.RoleStorage", "update role info, name=" + paramcj.name + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
    }
    AppMethodBeat.o(117329);
  }
  
  private cj bxs(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117322);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      cj localcj = new cj();
      Cursor localCursor = this.db.query("role_info", null, "name= ?", new String[] { paramString }, null, null, null, 2);
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        localcj.convertFrom(localCursor);
        paramString = localcj;
      }
      localCursor.close();
      AppMethodBeat.o(117322);
      return paramString;
    }
  }
  
  public final void Up(String paramString)
  {
    AppMethodBeat.i(117330);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      int i = this.db.delete("role_info", "name=?", new String[] { String.valueOf(paramString) });
      Log.d("MicroMsg.RoleStorage", "delete name name :" + paramString + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
      AppMethodBeat.o(117330);
      return;
    }
  }
  
  public final cj aPi(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117321);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117321);
      return null;
    }
    cj localcj = new cj();
    Cursor localCursor = this.db.query("role_info", null, "name LIKE ?", new String[] { "%".concat(String.valueOf(paramString)) }, null, null, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      localcj.convertFrom(localCursor);
      paramString = localcj;
    }
    localCursor.close();
    AppMethodBeat.o(117321);
    return paramString;
  }
  
  public final void bV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117327);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117327);
      return;
    }
    cj localcj = bxs(paramString);
    if (localcj == null)
    {
      a(new cj(paramString, paramBoolean, 2));
      Log.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117327);
      return;
    }
    localcj.setEnable(paramBoolean);
    localcj.cUP = 4;
    b(localcj);
    AppMethodBeat.o(117327);
  }
  
  public final List<cj> eSy()
  {
    AppMethodBeat.i(117323);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.db.query("role_info", null, "int_reserved1=1", null, null, null, null, 2);
    while (localCursor.moveToNext())
    {
      cj localcj = new cj();
      localcj.convertFrom(localCursor);
      localLinkedList.add(localcj);
    }
    localCursor.close();
    AppMethodBeat.o(117323);
    return localLinkedList;
  }
  
  public final void fk(String paramString, int paramInt)
  {
    AppMethodBeat.i(117326);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117326);
      return;
    }
    if (bxs(paramString) == null)
    {
      a(new cj(paramString, true, paramInt));
      Log.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(117326);
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(117325);
    cj localcj = bxs(paramString);
    if (localcj != null)
    {
      if (localcj.VHy == 4)
      {
        i = 1;
        if (i == 0) {
          if (localcj.VHy != 5) {
            break label55;
          }
        }
      }
      label55:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label60;
        }
        AppMethodBeat.o(117325);
        return true;
        i = 0;
        break;
      }
    }
    label60:
    localcj = aPi(new cj.a(paramString).bxr(""));
    if ((localcj != null) && (paramString.equals(localcj.name)))
    {
      AppMethodBeat.o(117325);
      return true;
    }
    AppMethodBeat.o(117325);
    return false;
  }
  
  public final void i(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    AppMethodBeat.i(117328);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117328);
      return;
    }
    cj localcj = bxs(paramString);
    if (localcj == null)
    {
      a(new cj(paramString, paramBoolean1, 2));
      Log.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117328);
      return;
    }
    localcj.setEnable(paramBoolean1);
    int j;
    if (paramBoolean2)
    {
      j = localcj.status;
      if (!paramBoolean2) {}
    }
    for (localcj.status = (i | j);; localcj.status &= 0xFFFFFFFD)
    {
      localcj.cUP = 4;
      b(localcj);
      AppMethodBeat.o(117328);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ck
 * JD-Core Version:    0.7.0.1
 */