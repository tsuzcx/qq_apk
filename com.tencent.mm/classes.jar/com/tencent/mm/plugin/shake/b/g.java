package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends j<f>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(24460);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )" };
    SQL_CREATE = new String[] { j.getCreateSQLs(f.info, "shakemessage") };
    AppMethodBeat.o(24460);
  }
  
  public g(e parame)
  {
    super(parame, f.info, "shakemessage", INDEX_CREATE);
    this.db = parame;
  }
  
  public final Cursor Dk(int paramInt)
  {
    AppMethodBeat.i(24455);
    Object localObject = "SELECT * FROM " + getTableName() + " ORDER BY rowid DESC LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(24455);
    return localObject;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(24454);
    if (paramf == null)
    {
      ab.e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
      AppMethodBeat.o(24454);
      return false;
    }
    if (super.insert(paramf))
    {
      doNotify(paramf.systemRowid);
      AppMethodBeat.o(24454);
      return true;
    }
    AppMethodBeat.o(24454);
    return false;
  }
  
  public final int bbZ()
  {
    AppMethodBeat.i(24456);
    Cursor localCursor = this.db.a("select count(*) from " + getTableName() + " where status != 1", null, 2);
    if (localCursor.moveToFirst()) {}
    for (int i = localCursor.getInt(0);; i = 0)
    {
      localCursor.close();
      if (i > 0)
      {
        AppMethodBeat.o(24456);
        return i;
      }
      AppMethodBeat.o(24456);
      return 0;
    }
  }
  
  public final f cle()
  {
    f localf = null;
    AppMethodBeat.i(24457);
    Object localObject = "SELECT * FROM " + getTableName() + " where status != 1 ORDER BY rowid DESC LIMIT 1";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(24457);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localf = new f();
      localf.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(24457);
    return localf;
  }
  
  public final List<f> clf()
  {
    AppMethodBeat.i(24458);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "SELECT * FROM " + getTableName() + " where status != 1";
    localObject = this.db.a((String)localObject, null, 2);
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
    AppMethodBeat.o(24458);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.g
 * JD-Core Version:    0.7.0.1
 */