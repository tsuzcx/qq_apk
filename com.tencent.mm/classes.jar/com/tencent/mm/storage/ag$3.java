package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;

final class ag$3
  implements Runnable
{
  ag$3(ag paramag) {}
  
  public final void run()
  {
    AppMethodBeat.i(248781);
    ag localag = this.acGF;
    long l = System.currentTimeMillis();
    int i = localag.getCount();
    if (i > 2000)
    {
      String str = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineSingleMsgInfo", "msgSvrId", "msgSvrId", "BizTimeLineSingleMsgInfo", "createTime", Integer.valueOf(100) });
      localag.omV.execSQL("BizTimeLineSingleMsgInfo", str);
      Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTooOldData delete cost: %d, count: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
    }
    for (;;)
    {
      ag.b(this.acGF);
      AppMethodBeat.o(248781);
      return;
      Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTooOldData count: %d", new Object[] { Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.storage.ag.3
 * JD-Core Version:    0.7.0.1
 */