package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ej;
import com.tencent.mm.sdk.e.i;
import java.util.concurrent.ConcurrentHashMap;

public final class by
  extends i<ej>
{
  public static final String[] dXp = { i.a(bx.buS, "TablesVersion") };
  public h dXo;
  
  public by(h paramh)
  {
    super(paramh, bx.buS, "TablesVersion", ej.cqY);
    this.dXo = paramh;
  }
  
  public final ConcurrentHashMap<Integer, String> cwe()
  {
    Cursor localCursor = this.dXo.a("select * from TablesVersion", new String[0], 0);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (localCursor == null) {
      return localConcurrentHashMap;
    }
    try
    {
      if (localCursor.moveToNext()) {
        localConcurrentHashMap.putIfAbsent(Integer.valueOf(localCursor.getInt(0)), localCursor.getString(1));
      }
      return localConcurrentHashMap1;
    }
    finally
    {
      localCursor.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.by
 * JD-Core Version:    0.7.0.1
 */