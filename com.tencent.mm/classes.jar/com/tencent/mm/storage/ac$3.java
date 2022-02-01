package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;

final class ac$3
  implements Runnable
{
  ac$3(ac paramac) {}
  
  public final void run()
  {
    AppMethodBeat.i(124611);
    int i = this.acFU.dWF();
    if (i > 0)
    {
      Object localObject = this.acFU;
      int j = ((ac)localObject).acFN;
      ((ac)localObject).acFN = (j - 1);
      if (j > 0)
      {
        Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable start");
        localObject = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineInfo", "orderFlag", "orderFlag", "BizTimeLineInfo", "orderFlag", Integer.valueOf(100) });
        Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable end ret=%b", new Object[] { Boolean.valueOf(ac.a(this.acFU).execSQL("BizTimeLineInfo", (String)localObject)) });
        this.acFU.bSr();
      }
    }
    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable count: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(124611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.storage.ac.3
 * JD-Core Version:    0.7.0.1
 */