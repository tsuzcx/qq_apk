package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hy;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.concurrent.ConcurrentHashMap;

public final class cu
  extends MAutoStorage<hy>
{
  public static final String[] SQL_CREATE;
  public h omV;
  
  static
  {
    AppMethodBeat.i(133310);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ct.info, "TablesVersion") };
    AppMethodBeat.o(133310);
  }
  
  public cu(h paramh)
  {
    super(paramh, ct.info, "TablesVersion", hy.INDEX_CREATE);
    this.omV = paramh;
  }
  
  public final ConcurrentHashMap<Integer, String> jcS()
  {
    AppMethodBeat.i(133309);
    Cursor localCursor = this.omV.rawQuery("select * from TablesVersion", new String[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cu
 * JD-Core Version:    0.7.0.1
 */