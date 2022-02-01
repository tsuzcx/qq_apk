package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ac
  extends j<au>
{
  private static ac GCX;
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(206933);
    SQL_CREATE = new String[] { j.getCreateSQLs(ab.info, "CleanDeleteItem") };
    AppMethodBeat.o(206933);
  }
  
  private ac(h paramh)
  {
    super(paramh, ab.info, "CleanDeleteItem", null);
    AppMethodBeat.i(206929);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.vE(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new String[] { "CREATE INDEX IF NOT EXISTS ID ON CleanDeleteItem ( id )" }));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramh.execSQL("CleanDeleteItem", (String)localArrayList.get(i));
      i += 1;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.CleanDeleteItemStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.qL(l2);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CleanDeleteItemStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(206929);
  }
  
  public static ac eZV()
  {
    AppMethodBeat.i(206930);
    g.agS();
    g.agP().afT();
    if (GCX == null) {
      GCX = new ac(g.agR().ghG);
    }
    ac localac = GCX;
    AppMethodBeat.o(206930);
    return localac;
  }
  
  public final void a(long paramLong, PLong paramPLong1, PLong paramPLong2)
  {
    AppMethodBeat.i(206931);
    Object localObject = String.format("SELECT * FROM %s", new Object[] { "CleanDeleteItem" });
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CleanDeleteItemStorage", "calculateFreeSpaceSize, sql = ".concat(String.valueOf(localObject)));
    localObject = rawQuery((String)localObject, new String[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(206931);
      return;
    }
    while (((Cursor)localObject).moveToNext())
    {
      ab localab = new ab();
      localab.convertFrom((Cursor)localObject);
      if (localab.field_saveTime < paramLong) {
        paramPLong2.value += localab.field_size;
      }
      paramPLong1.value += localab.field_size;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(206931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ac
 * JD-Core Version:    0.7.0.1
 */