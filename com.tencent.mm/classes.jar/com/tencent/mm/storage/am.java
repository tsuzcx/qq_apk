package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class am
  extends MAutoStorage<aw>
{
  private static am NRH;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(197174);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(al.info, "CleanDeleteItem") };
    AppMethodBeat.o(197174);
  }
  
  private am(h paramh)
  {
    super(paramh, al.info, "CleanDeleteItem", null);
    AppMethodBeat.i(197170);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.beginTransaction(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new String[] { "CREATE INDEX IF NOT EXISTS ID ON CleanDeleteItem ( id )" }));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramh.execSQL("CleanDeleteItem", (String)localArrayList.get(i));
      i += 1;
    }
    Log.d("MicroMsg.CleanDeleteItemStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.endTransaction(l2);
    Log.i("MicroMsg.CleanDeleteItemStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(197170);
  }
  
  public static am gBD()
  {
    AppMethodBeat.i(197171);
    g.aAi();
    g.aAf().azk();
    if (NRH == null) {
      NRH = new am(g.aAh().hqK);
    }
    am localam = NRH;
    AppMethodBeat.o(197171);
    return localam;
  }
  
  public final void a(long paramLong, PLong paramPLong1, PLong paramPLong2)
  {
    AppMethodBeat.i(197172);
    Object localObject = String.format("SELECT * FROM %s", new Object[] { "CleanDeleteItem" });
    Log.i("MicroMsg.CleanDeleteItemStorage", "calculateFreeSpaceSize, sql = ".concat(String.valueOf(localObject)));
    localObject = rawQuery((String)localObject, new String[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(197172);
      return;
    }
    while (((Cursor)localObject).moveToNext())
    {
      al localal = new al();
      localal.convertFrom((Cursor)localObject);
      if (localal.field_deleteTime - localal.field_modifyTime < paramLong) {
        paramPLong2.value += localal.field_size;
      }
      paramPLong1.value += localal.field_size;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(197172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.am
 * JD-Core Version:    0.7.0.1
 */