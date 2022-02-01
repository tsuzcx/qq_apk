package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class bo
  extends MAutoStorage<bn>
  implements e
{
  private static final String[] NRG;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(117170);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bn.info, "fmessage_msginfo") };
    NRG = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )" };
    AppMethodBeat.o(117170);
  }
  
  public bo(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bn.info, "fmessage_msginfo", NRG);
    this.db = paramISQLiteDatabase;
  }
  
  public final bn aEm(String paramString)
  {
    AppMethodBeat.i(117163);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
      AppMethodBeat.o(117163);
      return null;
    }
    paramString = "select * from fmessage_msginfo where talker = '" + Util.escapeSqlValue(paramString) + "' order by createTime DESC limit 1";
    paramString = this.db.rawQuery(paramString, null, 2);
    bn localbn = new bn();
    if (paramString.moveToFirst()) {
      localbn.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117163);
    return localbn;
  }
  
  public final boolean aEn(String paramString)
  {
    AppMethodBeat.i(117168);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
      AppMethodBeat.o(117168);
      return false;
    }
    paramString = "delete from fmessage_msginfo where talker = '" + Util.escapeSqlValue(paramString) + "'";
    boolean bool = this.db.execSQL("fmessage_msginfo", paramString);
    AppMethodBeat.o(117168);
    return bool;
  }
  
  public final boolean b(bn parambn)
  {
    AppMethodBeat.i(117166);
    if (parambn == null)
    {
      Log.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
      AppMethodBeat.o(117166);
      return false;
    }
    if (super.insert(parambn))
    {
      doNotify(parambn.systemRowid);
      AppMethodBeat.o(117166);
      return true;
    }
    AppMethodBeat.o(117166);
    return false;
  }
  
  public final bn[] bku(String paramString)
  {
    AppMethodBeat.i(117162);
    Log.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
    paramString = "select *, rowid from fmessage_msginfo  where talker = '" + Util.escapeSqlValue(paramString) + "' order by createTime DESC limit 3";
    paramString = this.db.rawQuery(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bn localbn = new bn();
      localbn.convertFrom(paramString);
      localArrayList.add(localbn);
    }
    paramString.close();
    paramString = (bn[])localArrayList.toArray(new bn[localArrayList.size()]);
    AppMethodBeat.o(117162);
    return paramString;
  }
  
  public final bn bkv(String paramString)
  {
    AppMethodBeat.i(117164);
    paramString = gQ(paramString, 1);
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(117164);
      return paramString;
    }
    AppMethodBeat.o(117164);
    return null;
  }
  
  public final List<bn> eiD()
  {
    AppMethodBeat.i(117167);
    Log.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.rawQuery("select *, rowid from fmessage_msginfo where type = 0", null, 2);
    while (localCursor.moveToNext())
    {
      bn localbn = new bn();
      localbn.convertFrom(localCursor);
      localArrayList.add(localbn);
    }
    localCursor.close();
    Log.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + localArrayList.size());
    AppMethodBeat.o(117167);
    return localArrayList;
  }
  
  public final bn[] gQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(117165);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
      AppMethodBeat.o(117165);
      return null;
    }
    paramString = "select * from fmessage_msginfo where isSend != 1 and talker = '" + Util.escapeSqlValue(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.db.rawQuery(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bn localbn = new bn();
      localbn.convertFrom(paramString);
      localArrayList.add(localbn);
    }
    paramString.close();
    paramString = (bn[])localArrayList.toArray(new bn[localArrayList.size()]);
    AppMethodBeat.o(117165);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bo
 * JD-Core Version:    0.7.0.1
 */