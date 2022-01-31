package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class br
  extends com.tencent.mm.sdk.e.j
  implements g.a, com.tencent.mm.plugin.messenger.foundation.a.a.j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )" };
  private e dXw = null;
  
  public br(h paramh)
  {
    this.dXw = paramh;
  }
  
  private void a(bq parambq)
  {
    parambq.bcw = 135;
    parambq = parambq.vf();
    if ((parambq.size() > 0) && (this.dXw.insert("role_info", "id", parambq) != 0L)) {
      doNotify();
    }
  }
  
  private bq acp(String paramString)
  {
    Object localObject = null;
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bq localbq = new bq();
      Cursor localCursor = this.dXw.a("role_info", null, "name= ?", new String[] { paramString }, null, null, null, 2);
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        localbq.d(localCursor);
        paramString = localbq;
      }
      localCursor.close();
      return paramString;
    }
  }
  
  private void b(bq parambq)
  {
    ContentValues localContentValues = parambq.vf();
    if (localContentValues.size() > 0)
    {
      int i = this.dXw.update("role_info", localContentValues, "name like ?", new String[] { parambq.name });
      y.d("MicroMsg.RoleStorage", "update role info, name=" + parambq.name + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
    }
  }
  
  public final bq Ic(String paramString)
  {
    Object localObject = null;
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    bq localbq = new bq();
    Cursor localCursor = this.dXw.a("role_info", null, "name LIKE ?", new String[] { "%" + paramString }, null, null, null, 2);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      localbq.d(localCursor);
      paramString = localbq;
    }
    localCursor.close();
    return paramString;
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final void aK(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      return;
    }
    bq localbq = acp(paramString);
    if (localbq == null)
    {
      a(new bq(paramString, paramBoolean, 2));
      y.d("MicroMsg.RoleStorage", "insert new role, user=" + paramString);
      return;
    }
    localbq.setEnable(paramBoolean);
    localbq.bcw = 4;
    b(localbq);
  }
  
  public final void bX(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
    }
    while (acp(paramString) != null) {
      return;
    }
    a(new bq(paramString, true, paramInt));
    y.d("MicroMsg.RoleStorage", "insert new role, user=" + paramString);
  }
  
  public final List<bq> big()
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.dXw.a("role_info", null, "int_reserved1=1", null, null, null, null, 2);
    while (localCursor.moveToNext())
    {
      bq localbq = new bq();
      localbq.d(localCursor);
      localLinkedList.add(localbq);
    }
    localCursor.close();
    return localLinkedList;
  }
  
  public final void c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      return;
    }
    bq localbq = acp(paramString);
    if (localbq == null)
    {
      a(new bq(paramString, paramBoolean1, 2));
      y.d("MicroMsg.RoleStorage", "insert new role, user=" + paramString);
      return;
    }
    localbq.setEnable(paramBoolean1);
    int j;
    if (paramBoolean2)
    {
      j = localbq.status;
      if (!paramBoolean2) {}
    }
    for (localbq.status = (i | j);; localbq.status &= 0xFFFFFFFD)
    {
      localbq.bcw = 4;
      b(localbq);
      return;
      i = 0;
      break;
    }
  }
  
  public final void delete(String paramString)
  {
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      int i = this.dXw.delete("role_info", "name=?", new String[] { paramString });
      y.d("MicroMsg.RoleStorage", "delete name name :" + paramString + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
      return;
    }
  }
  
  public final String getTableName()
  {
    return "role_info";
  }
  
  public final boolean has(String paramString)
  {
    bq localbq = Ic(new bq.a(paramString).aco(""));
    return (localbq != null) && (paramString.equals(localbq.name));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.br
 * JD-Core Version:    0.7.0.1
 */