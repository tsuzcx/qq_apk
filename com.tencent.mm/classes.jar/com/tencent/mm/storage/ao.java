package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ay;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ao
  extends MAutoStorage<ay>
{
  public static final String[] SQL_CREATE;
  private static ao acGT;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(248609);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(an.info, "CleanDeleteItem") };
    AppMethodBeat.o(248609);
  }
  
  private ao(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, an.info, "CleanDeleteItem", null);
    AppMethodBeat.i(248599);
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
    AppMethodBeat.o(248599);
  }
  
  public static ao iZt()
  {
    AppMethodBeat.i(248604);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    if (acGT == null) {
      acGT = new ao(com.tencent.mm.kernel.h.baE().mCN);
    }
    ao localao = acGT;
    AppMethodBeat.o(248604);
    return localao;
  }
  
  public final void a(long paramLong, PLong paramPLong1, PLong paramPLong2)
  {
    AppMethodBeat.i(248616);
    Object localObject = String.format("SELECT * FROM %s", new Object[] { "CleanDeleteItem" });
    Log.i("MicroMsg.CleanDeleteItemStorage", "calculateFreeSpaceSize, sql = ".concat(String.valueOf(localObject)));
    localObject = rawQuery((String)localObject, new String[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(248616);
      return;
    }
    while (((Cursor)localObject).moveToNext())
    {
      an localan = new an();
      localan.convertFrom((Cursor)localObject);
      if (localan.field_deleteTime - localan.field_modifyTime < paramLong) {
        paramPLong2.value += localan.field_size;
      }
      paramPLong1.value += localan.field_size;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(248616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ao
 * JD-Core Version:    0.7.0.1
 */