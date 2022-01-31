package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.c.fa;
import com.tencent.mm.sdk.e.j;
import java.util.concurrent.ConcurrentHashMap;

public final class by
  extends j<fa>
{
  public static final String[] SQL_CREATE;
  public h fnw;
  
  static
  {
    AppMethodBeat.i(59018);
    SQL_CREATE = new String[] { j.getCreateSQLs(bx.info, "TablesVersion") };
    AppMethodBeat.o(59018);
  }
  
  public by(h paramh)
  {
    super(paramh, bx.info, "TablesVersion", fa.INDEX_CREATE);
    this.fnw = paramh;
  }
  
  public final ConcurrentHashMap<Integer, String> dyQ()
  {
    AppMethodBeat.i(59017);
    Cursor localCursor = this.fnw.a("select * from TablesVersion", new String[0], 0);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (localCursor == null)
    {
      AppMethodBeat.o(59017);
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
      AppMethodBeat.o(59017);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.by
 * JD-Core Version:    0.7.0.1
 */