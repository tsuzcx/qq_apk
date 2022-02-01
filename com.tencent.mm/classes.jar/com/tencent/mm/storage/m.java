package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class m
  extends j<l>
{
  public static final String[] SQL_CREATE;
  public h hpA;
  
  static
  {
    AppMethodBeat.i(32832);
    SQL_CREATE = new String[] { j.getCreateSQLs(l.info, "BackupRecoverMsgListDataId") };
    AppMethodBeat.o(32832);
  }
  
  public m(h paramh)
  {
    super(paramh, l.info, "BackupRecoverMsgListDataId", null);
    this.hpA = paramh;
  }
  
  public final String aMG(String paramString)
  {
    AppMethodBeat.i(32826);
    Object localObject = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + paramString + "\" ";
    ac.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:".concat(String.valueOf(localObject)));
    localObject = this.hpA.a((String)localObject, null, 0);
    if (localObject == null)
    {
      ac.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", new Object[] { paramString });
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
  
  public final boolean alL()
  {
    AppMethodBeat.i(32830);
    boolean bool = this.hpA.execSQL("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
    ac.i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(32830);
    return bool;
  }
  
  public final HashMap<String, String> eYY()
  {
    AppMethodBeat.i(32827);
    HashMap localHashMap = new HashMap();
    Cursor localCursor = getAll();
    if (localCursor == null)
    {
      ac.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
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
  
  public final boolean eYZ()
  {
    AppMethodBeat.i(32828);
    ac.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:".concat(String.valueOf("SELECT * FROM BackupRecoverMsgListDataId")));
    Cursor localCursor = this.hpA.a("SELECT * FROM BackupRecoverMsgListDataId", null, 0);
    if (localCursor == null)
    {
      ac.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
      AppMethodBeat.o(32828);
      return false;
    }
    if (localCursor.getCount() <= 0)
    {
      ac.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
      localCursor.close();
      AppMethodBeat.o(32828);
      return false;
    }
    localCursor.close();
    AppMethodBeat.o(32828);
    return true;
  }
  
  public final int eZa()
  {
    int i = 0;
    AppMethodBeat.i(32829);
    ac.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionCount:".concat(String.valueOf("SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ")));
    Cursor localCursor = this.hpA.a("SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ", null, 0);
    if (localCursor.moveToLast()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(32829);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.m
 * JD-Core Version:    0.7.0.1
 */