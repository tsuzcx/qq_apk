package com.tencent.mm.storagebase;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class c
{
  private static long IOA = 0L;
  private static int IOB = 0;
  private static f.a IOz;
  private static int index;
  private static boolean on = false;
  
  static
  {
    index = 0;
    IOz = null;
  }
  
  static void a(String paramString, Cursor paramCursor, long paramLong)
  {
    AppMethodBeat.i(133329);
    if (!on)
    {
      AppMethodBeat.o(133329);
      return;
    }
    long l = IOz.abj();
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
      localObject2 = (String)localObject1 + "[cuCnt:" + IOB + ",cuTime:" + IOA + "]";
    }
    paramString = (String)localObject2 + "[" + paramString + "]--";
    ad.v("MicroMsg.dbtest", paramString + bt.flS());
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
    IOz = new f.a();
    index += 1;
    AppMethodBeat.o(133327);
  }
  
  public static void p(Exception paramException)
  {
    AppMethodBeat.i(133326);
    if (on) {
      ad.e("MicroMsg.DKTest", "exception:%s", new Object[] { bt.n(paramException) });
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
    IOB = paramCursor.getCount();
    f.a locala = new f.a();
    int i = 0;
    while (i < IOB)
    {
      paramCursor.moveToPosition(i);
      i += 1;
    }
    paramCursor.moveToPosition(-1);
    IOA = locala.abj();
    AppMethodBeat.o(133328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.c
 * JD-Core Version:    0.7.0.1
 */