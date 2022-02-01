package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;

final class ag$2
  implements Runnable
{
  ag$2(ag paramag) {}
  
  public final void run()
  {
    AppMethodBeat.i(248795);
    int i = this.acGF.getCount();
    if (i > 0)
    {
      Object localObject = this.acGF;
      int j = ((ag)localObject).acFN;
      ((ag)localObject).acFN = (j - 1);
      if (j > 0)
      {
        Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTable start");
        localObject = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineSingleMsgInfo", "msgSvrId", "msgSvrId", "BizTimeLineSingleMsgInfo", "createTime", Integer.valueOf(100) });
        Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTable end ret=%b", new Object[] { Boolean.valueOf(ag.a(this.acGF).execSQL("BizTimeLineSingleMsgInfo", (String)localObject)) });
        this.acGF.bSr();
      }
    }
    Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTable count: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(248795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.storage.ag.2
 * JD-Core Version:    0.7.0.1
 */