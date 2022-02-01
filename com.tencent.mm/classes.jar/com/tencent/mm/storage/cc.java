package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ga;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h;
import java.util.concurrent.ConcurrentHashMap;

public final class cc
  extends j<ga>
{
  public static final String[] SQL_CREATE;
  public h hpA;
  
  static
  {
    AppMethodBeat.i(133310);
    SQL_CREATE = new String[] { j.getCreateSQLs(cb.info, "TablesVersion") };
    AppMethodBeat.o(133310);
  }
  
  public cc(h paramh)
  {
    super(paramh, cb.info, "TablesVersion", ga.INDEX_CREATE);
    this.hpA = paramh;
  }
  
  public final ConcurrentHashMap<Integer, String> fcE()
  {
    AppMethodBeat.i(133309);
    Cursor localCursor = this.hpA.a("select * from TablesVersion", new String[0], 0);
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
 * Qualified Name:     com.tencent.mm.storage.cc
 * JD-Core Version:    0.7.0.1
 */