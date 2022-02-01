package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fw;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h;
import java.util.concurrent.ConcurrentHashMap;

public final class bz
  extends j<fw>
{
  public static final String[] SQL_CREATE;
  public h gPa;
  
  static
  {
    AppMethodBeat.i(133310);
    SQL_CREATE = new String[] { j.getCreateSQLs(by.info, "TablesVersion") };
    AppMethodBeat.o(133310);
  }
  
  public bz(h paramh)
  {
    super(paramh, by.info, "TablesVersion", fw.INDEX_CREATE);
    this.gPa = paramh;
  }
  
  public final ConcurrentHashMap<Integer, String> eNa()
  {
    AppMethodBeat.i(133309);
    Cursor localCursor = this.gPa.a("select * from TablesVersion", new String[0], 0);
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
 * Qualified Name:     com.tencent.mm.storage.bz
 * JD-Core Version:    0.7.0.1
 */