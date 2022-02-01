package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ag
  extends j<av>
{
  private static ag Ipq;
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(189898);
    SQL_CREATE = new String[] { j.getCreateSQLs(af.info, "CleanDeleteItem") };
    AppMethodBeat.o(189898);
  }
  
  private ag(h paramh)
  {
    super(paramh, af.info, "CleanDeleteItem", null);
    AppMethodBeat.i(189894);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.xO(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new String[] { "CREATE INDEX IF NOT EXISTS ID ON CleanDeleteItem ( id )" }));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramh.execSQL("CleanDeleteItem", (String)localArrayList.get(i));
      i += 1;
    }
    ad.d("MicroMsg.CleanDeleteItemStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.sJ(l2);
    ad.i("MicroMsg.CleanDeleteItemStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(189894);
  }
  
  public static ag fpX()
  {
    AppMethodBeat.i(189895);
    g.ajD();
    g.ajA().aiF();
    if (Ipq == null) {
      Ipq = new ag(g.ajC().gBq);
    }
    ag localag = Ipq;
    AppMethodBeat.o(189895);
    return localag;
  }
  
  public final void a(long paramLong, PLong paramPLong1, PLong paramPLong2)
  {
    AppMethodBeat.i(189896);
    Object localObject = String.format("SELECT * FROM %s", new Object[] { "CleanDeleteItem" });
    ad.i("MicroMsg.CleanDeleteItemStorage", "calculateFreeSpaceSize, sql = ".concat(String.valueOf(localObject)));
    localObject = rawQuery((String)localObject, new String[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(189896);
      return;
    }
    while (((Cursor)localObject).moveToNext())
    {
      af localaf = new af();
      localaf.convertFrom((Cursor)localObject);
      if (localaf.field_deleteTime - localaf.field_modifyTime < paramLong) {
        paramPLong2.value += localaf.field_size;
      }
      paramPLong1.value += localaf.field_size;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(189896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ag
 * JD-Core Version:    0.7.0.1
 */