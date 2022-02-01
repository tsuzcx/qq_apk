package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ah
  extends j<av>
{
  private static ah IJK;
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(193616);
    SQL_CREATE = new String[] { j.getCreateSQLs(ag.info, "CleanDeleteItem") };
    AppMethodBeat.o(193616);
  }
  
  private ah(h paramh)
  {
    super(paramh, ag.info, "CleanDeleteItem", null);
    AppMethodBeat.i(193612);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.yi(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new String[] { "CREATE INDEX IF NOT EXISTS ID ON CleanDeleteItem ( id )" }));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramh.execSQL("CleanDeleteItem", (String)localArrayList.get(i));
      i += 1;
    }
    ae.d("MicroMsg.CleanDeleteItemStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.sW(l2);
    ae.i("MicroMsg.CleanDeleteItemStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(193612);
  }
  
  public static ah ftX()
  {
    AppMethodBeat.i(193613);
    g.ajS();
    g.ajP().aiU();
    if (IJK == null) {
      IJK = new ah(g.ajR().gDX);
    }
    ah localah = IJK;
    AppMethodBeat.o(193613);
    return localah;
  }
  
  public final void a(long paramLong, PLong paramPLong1, PLong paramPLong2)
  {
    AppMethodBeat.i(193614);
    Object localObject = String.format("SELECT * FROM %s", new Object[] { "CleanDeleteItem" });
    ae.i("MicroMsg.CleanDeleteItemStorage", "calculateFreeSpaceSize, sql = ".concat(String.valueOf(localObject)));
    localObject = rawQuery((String)localObject, new String[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(193614);
      return;
    }
    while (((Cursor)localObject).moveToNext())
    {
      ag localag = new ag();
      localag.convertFrom((Cursor)localObject);
      if (localag.field_deleteTime - localag.field_modifyTime < paramLong) {
        paramPLong2.value += localag.field_size;
      }
      paramPLong1.value += localag.field_size;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(193614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ah
 * JD-Core Version:    0.7.0.1
 */