package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class l
  extends j<k>
{
  public static final String[] SQL_CREATE;
  public h fnw;
  
  static
  {
    AppMethodBeat.i(29017);
    SQL_CREATE = new String[] { j.getCreateSQLs(k.info, "BackupRecoverMsgListDataId") };
    AppMethodBeat.o(29017);
  }
  
  public l(h paramh)
  {
    super(paramh, k.info, "BackupRecoverMsgListDataId", null);
    this.fnw = paramh;
  }
  
  public final String aqQ(String paramString)
  {
    AppMethodBeat.i(29011);
    Object localObject = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + paramString + "\" ";
    ab.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:".concat(String.valueOf(localObject)));
    localObject = this.fnw.a((String)localObject, null, 0);
    if (localObject == null)
    {
      ab.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", new Object[] { paramString });
      AppMethodBeat.o(29011);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new k();
      paramString.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      paramString = paramString.field_sessionName;
      AppMethodBeat.o(29011);
      return paramString;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(29011);
    return null;
  }
  
  public final boolean dvQ()
  {
    AppMethodBeat.i(29015);
    boolean bool = this.fnw.execSQL("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
    ab.i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(29015);
    return bool;
  }
  
  public final HashMap<String, String> dvR()
  {
    AppMethodBeat.i(29012);
    HashMap localHashMap = new HashMap();
    Cursor localCursor = getAll();
    if (localCursor == null)
    {
      ab.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
      AppMethodBeat.o(29012);
      return localHashMap;
    }
    while (localCursor.moveToNext())
    {
      k localk = new k();
      localk.convertFrom(localCursor);
      localHashMap.put(localk.field_msgListDataId, localk.field_sessionName);
    }
    localCursor.close();
    AppMethodBeat.o(29012);
    return localHashMap;
  }
  
  public final boolean dvS()
  {
    AppMethodBeat.i(29013);
    ab.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:".concat(String.valueOf("SELECT * FROM BackupRecoverMsgListDataId")));
    Cursor localCursor = this.fnw.a("SELECT * FROM BackupRecoverMsgListDataId", null, 0);
    if (localCursor == null)
    {
      ab.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
      AppMethodBeat.o(29013);
      return false;
    }
    if (localCursor.getCount() <= 0)
    {
      ab.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
      localCursor.close();
      AppMethodBeat.o(29013);
      return false;
    }
    localCursor.close();
    AppMethodBeat.o(29013);
    return true;
  }
  
  public final int dvT()
  {
    int i = 0;
    AppMethodBeat.i(29014);
    ab.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionCount:".concat(String.valueOf("SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ")));
    Cursor localCursor = this.fnw.a("SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ", null, 0);
    if (localCursor.moveToLast()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(29014);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.l
 * JD-Core Version:    0.7.0.1
 */