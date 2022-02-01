package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends MAutoStorage<f>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(28135);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )" };
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(f.info, "shakemessage") };
    AppMethodBeat.o(28135);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.info, "shakemessage", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final Cursor Xw(int paramInt)
  {
    AppMethodBeat.i(28130);
    Object localObject = "SELECT * FROM " + getTableName() + " ORDER BY rowid DESC LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(28130);
    return localObject;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(28129);
    if (paramf == null)
    {
      Log.e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
      AppMethodBeat.o(28129);
      return false;
    }
    if (super.insert(paramf))
    {
      doNotify(paramf.systemRowid);
      AppMethodBeat.o(28129);
      return true;
    }
    AppMethodBeat.o(28129);
    return false;
  }
  
  public final int ctM()
  {
    AppMethodBeat.i(28131);
    Cursor localCursor = this.db.rawQuery("select count(*) from " + getTableName() + " where status != 1", null, 2);
    if (localCursor.moveToFirst()) {}
    for (int i = localCursor.getInt(0);; i = 0)
    {
      localCursor.close();
      if (i > 0)
      {
        AppMethodBeat.o(28131);
        return i;
      }
      AppMethodBeat.o(28131);
      return 0;
    }
  }
  
  public final f eUd()
  {
    f localf = null;
    AppMethodBeat.i(28132);
    Object localObject = "SELECT * FROM " + getTableName() + " where status != 1 ORDER BY rowid DESC LIMIT 1";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(28132);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localf = new f();
      localf.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(28132);
    return localf;
  }
  
  public final List<f> eUe()
  {
    AppMethodBeat.i(28133);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "SELECT * FROM " + getTableName() + " where status != 1";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        f localf = new f();
        localf.convertFrom((Cursor)localObject);
        localArrayList.add(localf);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(28133);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.g
 * JD-Core Version:    0.7.0.1
 */