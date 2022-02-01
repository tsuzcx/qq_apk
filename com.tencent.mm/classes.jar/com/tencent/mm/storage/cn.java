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

public final class cn
  extends MStorage
  implements l
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )" };
  private ISQLiteDatabase db = null;
  
  public cn(h paramh)
  {
    this.db = paramh;
  }
  
  private void a(cm paramcm)
  {
    AppMethodBeat.i(117324);
    paramcm.eQp = 135;
    paramcm = paramcm.convertTo();
    if ((paramcm.size() > 0) && (this.db.insert("role_info", "id", paramcm) != 0L)) {
      doNotify();
    }
    AppMethodBeat.o(117324);
  }
  
  private void b(cm paramcm)
  {
    AppMethodBeat.i(117329);
    ContentValues localContentValues = paramcm.convertTo();
    if (localContentValues.size() > 0)
    {
      int i = this.db.update("role_info", localContentValues, "name like ?", new String[] { paramcm.name });
      Log.d("MicroMsg.RoleStorage", "update role info, name=" + paramcm.name + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
    }
    AppMethodBeat.o(117329);
  }
  
  private cm byK(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117322);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      cm localcm = new cm();
      Cursor localCursor = this.db.query("role_info", null, "name= ?", new String[] { paramString }, null, null, null, 2);
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        localcm.convertFrom(localCursor);
        paramString = localcm;
      }
      localCursor.close();
      AppMethodBeat.o(117322);
      return paramString;
    }
  }
  
  public final void Mo(String paramString)
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
  
  public final cm aMh(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117321);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117321);
      return null;
    }
    cm localcm = new cm();
    Cursor localCursor = this.db.query("role_info", null, "name LIKE ?", new String[] { "%".concat(String.valueOf(paramString)) }, null, null, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      localcm.convertFrom(localCursor);
      paramString = localcm;
    }
    localCursor.close();
    AppMethodBeat.o(117321);
    return paramString;
  }
  
  public final void cr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117327);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117327);
      return;
    }
    cm localcm = byK(paramString);
    if (localcm == null)
    {
      a(new cm(paramString, paramBoolean, 2));
      Log.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117327);
      return;
    }
    localcm.setEnable(paramBoolean);
    localcm.eQp = 4;
    b(localcm);
    AppMethodBeat.o(117327);
  }
  
  public final List<cm> gbs()
  {
    AppMethodBeat.i(117323);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.db.query("role_info", null, "int_reserved1=1", null, null, null, null, 2);
    while (localCursor.moveToNext())
    {
      cm localcm = new cm();
      localcm.convertFrom(localCursor);
      localLinkedList.add(localcm);
    }
    localCursor.close();
    AppMethodBeat.o(117323);
    return localLinkedList;
  }
  
  public final void gd(String paramString, int paramInt)
  {
    AppMethodBeat.i(117326);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117326);
      return;
    }
    if (byK(paramString) == null)
    {
      a(new cm(paramString, true, paramInt));
      Log.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(117326);
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(117325);
    cm localcm = byK(paramString);
    if (localcm != null)
    {
      if (localcm.adlv == 4)
      {
        i = 1;
        if (i == 0)
        {
          if (localcm.adlv != 5) {
            break label70;
          }
          i = 1;
          label39:
          if (i == 0) {
            if (localcm.adlv != 6) {
              break label75;
            }
          }
        }
      }
      label70:
      label75:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label80;
        }
        AppMethodBeat.o(117325);
        return true;
        i = 0;
        break;
        i = 0;
        break label39;
      }
    }
    label80:
    localcm = aMh(new cm.a(paramString).byJ(""));
    if ((localcm != null) && (paramString.equals(localcm.name)))
    {
      AppMethodBeat.o(117325);
      return true;
    }
    AppMethodBeat.o(117325);
    return false;
  }
  
  public final void k(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    AppMethodBeat.i(117328);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      AppMethodBeat.o(117328);
      return;
    }
    cm localcm = byK(paramString);
    if (localcm == null)
    {
      a(new cm(paramString, paramBoolean1, 2));
      Log.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(117328);
      return;
    }
    localcm.setEnable(paramBoolean1);
    int j;
    if (paramBoolean2)
    {
      j = localcm.status;
      if (!paramBoolean2) {}
    }
    for (localcm.status = (i | j);; localcm.status &= 0xFFFFFFFD)
    {
      localcm.eQp = 4;
      b(localcm);
      AppMethodBeat.o(117328);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cn
 * JD-Core Version:    0.7.0.1
 */