package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class l
  extends i<k>
{
  public static final String[] dXp = { i.a(k.buS, "BackupRecoverMsgListDataId") };
  public h dXo;
  
  public l(h paramh)
  {
    super(paramh, k.buS, "BackupRecoverMsgListDataId", null);
    this.dXo = paramh;
  }
  
  public final String aaF(String paramString)
  {
    Object localObject = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + paramString + "\" ";
    y.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:" + (String)localObject);
    localObject = this.dXo.a((String)localObject, null, 0);
    if (localObject == null)
    {
      y.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", new Object[] { paramString });
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new k();
      paramString.d((Cursor)localObject);
      ((Cursor)localObject).close();
      return paramString.field_sessionName;
    }
    ((Cursor)localObject).close();
    return null;
  }
  
  public final boolean ctu()
  {
    boolean bool = this.dXo.gk("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
    y.i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final HashMap<String, String> ctv()
  {
    HashMap localHashMap = new HashMap();
    Cursor localCursor = aAn();
    if (localCursor == null)
    {
      y.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
      return localHashMap;
    }
    while (localCursor.moveToNext())
    {
      k localk = new k();
      localk.d(localCursor);
      localHashMap.put(localk.field_msgListDataId, localk.field_sessionName);
    }
    localCursor.close();
    return localHashMap;
  }
  
  public final boolean ctw()
  {
    y.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:" + "SELECT * FROM BackupRecoverMsgListDataId");
    Cursor localCursor = this.dXo.a("SELECT * FROM BackupRecoverMsgListDataId", null, 0);
    if (localCursor == null)
    {
      y.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
      return false;
    }
    if (localCursor.getCount() <= 0)
    {
      y.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
      localCursor.close();
      return false;
    }
    localCursor.close();
    return true;
  }
  
  public final int ctx()
  {
    int i = 0;
    y.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionCount:" + "SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ");
    Cursor localCursor = this.dXo.a("SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ", null, 0);
    if (localCursor.moveToLast()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.l
 * JD-Core Version:    0.7.0.1
 */