package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class m
  extends MAutoStorage<l>
{
  public static final String[] SQL_CREATE;
  public h omV;
  
  static
  {
    AppMethodBeat.i(32832);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(l.info, "BackupRecoverMsgListDataId") };
    AppMethodBeat.o(32832);
  }
  
  public m(h paramh)
  {
    super(paramh, l.info, "BackupRecoverMsgListDataId", null);
    this.omV = paramh;
  }
  
  public final boolean bjb()
  {
    AppMethodBeat.i(32830);
    boolean bool = this.omV.execSQL("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
    Log.i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(32830);
    return bool;
  }
  
  public final String bve(String paramString)
  {
    AppMethodBeat.i(32826);
    Object localObject = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + paramString + "\" ";
    Log.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:".concat(String.valueOf(localObject)));
    localObject = this.omV.rawQuery((String)localObject, null);
    if (localObject == null)
    {
      Log.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", new Object[] { paramString });
      AppMethodBeat.o(32826);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new l();
      paramString.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      paramString = paramString.field_sessionName;
      AppMethodBeat.o(32826);
      return paramString;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(32826);
    return null;
  }
  
  public final HashMap<String, String> iXc()
  {
    AppMethodBeat.i(32827);
    HashMap localHashMap = new HashMap();
    Cursor localCursor = getAll();
    if (localCursor == null)
    {
      Log.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
      AppMethodBeat.o(32827);
      return localHashMap;
    }
    while (localCursor.moveToNext())
    {
      l locall = new l();
      locall.convertFrom(localCursor);
      localHashMap.put(locall.field_msgListDataId, locall.field_sessionName);
    }
    localCursor.close();
    AppMethodBeat.o(32827);
    return localHashMap;
  }
  
  public final boolean iXd()
  {
    AppMethodBeat.i(32828);
    Log.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:".concat(String.valueOf("SELECT * FROM BackupRecoverMsgListDataId")));
    Cursor localCursor = this.omV.rawQuery("SELECT * FROM BackupRecoverMsgListDataId", null);
    if (localCursor == null)
    {
      Log.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
      AppMethodBeat.o(32828);
      return false;
    }
    if (localCursor.getCount() <= 0)
    {
      Log.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
      localCursor.close();
      AppMethodBeat.o(32828);
      return false;
    }
    localCursor.close();
    AppMethodBeat.o(32828);
    return true;
  }
  
  public final int iXe()
  {
    int i = 0;
    AppMethodBeat.i(32829);
    Log.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionCount:".concat(String.valueOf("SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ")));
    Cursor localCursor = this.omV.rawQuery("SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ", null);
    if (localCursor.moveToLast()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(32829);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.m
 * JD-Core Version:    0.7.0.1
 */