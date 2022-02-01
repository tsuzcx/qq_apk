package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gk;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h;
import java.util.concurrent.ConcurrentHashMap;

public final class ci
  extends j<gk>
{
  public static final String[] SQL_CREATE;
  public h hHS;
  
  static
  {
    AppMethodBeat.i(133310);
    SQL_CREATE = new String[] { j.getCreateSQLs(ch.info, "TablesVersion") };
    AppMethodBeat.o(133310);
  }
  
  public ci(h paramh)
  {
    super(paramh, ch.info, "TablesVersion", gk.INDEX_CREATE);
    this.hHS = paramh;
  }
  
  public final ConcurrentHashMap<Integer, String> fsL()
  {
    AppMethodBeat.i(133309);
    Cursor localCursor = this.hHS.a("select * from TablesVersion", new String[0], 0);
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
 * Qualified Name:     com.tencent.mm.storage.ci
 * JD-Core Version:    0.7.0.1
 */