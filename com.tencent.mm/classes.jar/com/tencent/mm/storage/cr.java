package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.hd;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.concurrent.ConcurrentHashMap;

public final class cr
  extends MAutoStorage<hd>
{
  public static final String[] SQL_CREATE;
  public h lvy;
  
  static
  {
    AppMethodBeat.i(133310);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(cq.info, "TablesVersion") };
    AppMethodBeat.o(133310);
  }
  
  public cr(h paramh)
  {
    super(paramh, cq.info, "TablesVersion", hd.INDEX_CREATE);
    this.lvy = paramh;
  }
  
  public final ConcurrentHashMap<Integer, String> hAP()
  {
    AppMethodBeat.i(133309);
    Cursor localCursor = this.lvy.rawQuery("select * from TablesVersion", new String[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.cr
 * JD-Core Version:    0.7.0.1
 */