package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class p
  extends MAutoStorage<aa>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(31047);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(o.info, "AppSort") };
    AppMethodBeat.o(31047);
  }
  
  public p(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, o.info, "AppSort", null);
    AppMethodBeat.i(31044);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
    paramISQLiteDatabase.execSQL("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
    AppMethodBeat.o(31044);
  }
  
  public final List<String> Mq(long paramLong)
  {
    AppMethodBeat.i(31045);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder(256);
    ((StringBuilder)localObject).append("select * from AppSort");
    ((StringBuilder)localObject).append(" where ");
    ((StringBuilder)localObject).append("flag = ").append(paramLong);
    ((StringBuilder)localObject).append(" order by sortId desc ");
    localObject = rawQuery(((StringBuilder)localObject).toString(), new String[0]);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
      AppMethodBeat.o(31045);
      return null;
    }
    Log.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    int i = ((Cursor)localObject).getColumnIndex("appId");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(31045);
    return localArrayList;
  }
  
  public final boolean a(o paramo)
  {
    AppMethodBeat.i(31046);
    boolean bool = super.insert(paramo);
    AppMethodBeat.o(31046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.p
 * JD-Core Version:    0.7.0.1
 */