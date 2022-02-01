package com.tencent.mm.storagebase;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class c
{
  private static boolean adne = false;
  private static f.a adnf = null;
  private static long adng = 0L;
  private static int adnh = 0;
  private static int index = 0;
  
  static void a(String paramString, Cursor paramCursor, long paramLong)
  {
    AppMethodBeat.i(133329);
    if (!adne)
    {
      AppMethodBeat.o(133329);
      return;
    }
    long l = adnf.aPY();
    Object localObject1 = "Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]";
    Object localObject2 = (String)localObject1 + "[" + index + "][" + l + "]";
    localObject1 = localObject2;
    if (paramLong != 0L) {
      localObject1 = (String)localObject2 + "[INTRANS]";
    }
    localObject2 = localObject1;
    if (paramCursor != null)
    {
      v(paramCursor);
      localObject2 = (String)localObject1 + "[cuCnt:" + adnh + ",cuTime:" + adng + "]";
    }
    paramString = (String)localObject2 + "[" + paramString + "]--";
    Log.v("MicroMsg.dbtest", paramString + Util.getStack());
    AppMethodBeat.o(133329);
  }
  
  static void begin()
  {
    AppMethodBeat.i(133327);
    if (!adne)
    {
      AppMethodBeat.o(133327);
      return;
    }
    adnf = new f.a();
    index += 1;
    AppMethodBeat.o(133327);
  }
  
  public static void n(Exception paramException)
  {
    AppMethodBeat.i(133326);
    if (adne) {
      Log.e("MicroMsg.DKTest", "exception:%s", new Object[] { Util.stackTraceToString(paramException) });
    }
    AppMethodBeat.o(133326);
  }
  
  private static void v(Cursor paramCursor)
  {
    AppMethodBeat.i(133328);
    if (!adne)
    {
      AppMethodBeat.o(133328);
      return;
    }
    if (paramCursor == null)
    {
      AppMethodBeat.o(133328);
      return;
    }
    adnh = paramCursor.getCount();
    f.a locala = new f.a();
    int i = 0;
    while (i < adnh)
    {
      paramCursor.moveToPosition(i);
      i += 1;
    }
    paramCursor.moveToPosition(-1);
    adng = locala.aPY();
    AppMethodBeat.o(133328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.c
 * JD-Core Version:    0.7.0.1
 */