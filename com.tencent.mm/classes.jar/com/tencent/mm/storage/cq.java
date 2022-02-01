package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gw;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.concurrent.ConcurrentHashMap;

public final class cq
  extends MAutoStorage<gw>
{
  public static final String[] SQL_CREATE;
  public h iFy;
  
  static
  {
    AppMethodBeat.i(133310);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(cp.info, "TablesVersion") };
    AppMethodBeat.o(133310);
  }
  
  public cq(h paramh)
  {
    super(paramh, cp.info, "TablesVersion", gw.INDEX_CREATE);
    this.iFy = paramh;
  }
  
  public final ConcurrentHashMap<Integer, String> gEy()
  {
    AppMethodBeat.i(133309);
    Cursor localCursor = this.iFy.rawQuery("select * from TablesVersion", new String[0]);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (localCursor == null)
    {
      AppMethodBeat.o(133309);
      return localConcurrentHashMap;
    }
    try
    {
      if (localCursor.moveToNext()) {}
      return localConcurrentHashMap1;
    }
    finally
    {
      localCursor.close();
      AppMethodBeat.o(133309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.cq
 * JD-Core Version:    0.7.0.1
 */