package com.tencent.mm.storagebase;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class c
{
  private static f.a Hbk = null;
  private static long Hbl = 0L;
  private static int Hbm = 0;
  private static int index;
  private static boolean on = false;
  
  static
  {
    index = 0;
  }
  
  static void a(String paramString, Cursor paramCursor, long paramLong)
  {
    AppMethodBeat.i(133329);
    if (!on)
    {
      AppMethodBeat.o(133329);
      return;
    }
    long l = Hbk.YH();
    Object localObject1 = "Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]";
    Object localObject2 = (String)localObject1 + "[" + index + "][" + l + "]";
    localObject1 = localObject2;
    if (paramLong != 0L) {
      localObject1 = (String)localObject2 + "[INTRANS]";
    }
    localObject2 = localObject1;
    if (paramCursor != null)
    {
      r(paramCursor);
      localObject2 = (String)localObject1 + "[cuCnt:" + Hbm + ",cuTime:" + Hbl + "]";
    }
    paramString = (String)localObject2 + "[" + paramString + "]--";
    ac.v("MicroMsg.dbtest", paramString + bs.eWi());
    AppMethodBeat.o(133329);
  }
  
  static void begin()
  {
    AppMethodBeat.i(133327);
    if (!on)
    {
      AppMethodBeat.o(133327);
      return;
    }
    Hbk = new f.a();
    index += 1;
    AppMethodBeat.o(133327);
  }
  
  public static void p(Exception paramException)
  {
    AppMethodBeat.i(133326);
    if (on) {
      ac.e("MicroMsg.DKTest", "exception:%s", new Object[] { bs.m(paramException) });
    }
    AppMethodBeat.o(133326);
  }
  
  private static void r(Cursor paramCursor)
  {
    AppMethodBeat.i(133328);
    if (!on)
    {
      AppMethodBeat.o(133328);
      return;
    }
    if (paramCursor == null)
    {
      AppMethodBeat.o(133328);
      return;
    }
    Hbm = paramCursor.getCount();
    f.a locala = new f.a();
    int i = 0;
    while (i < Hbm)
    {
      paramCursor.moveToPosition(i);
      i += 1;
    }
    paramCursor.moveToPosition(-1);
    Hbl = locala.YH();
    AppMethodBeat.o(133328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.c
 * JD-Core Version:    0.7.0.1
 */