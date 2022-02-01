package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;

final class ac$6
  implements Runnable
{
  ac$6(ac paramac, ab paramab) {}
  
  public final void run()
  {
    AppMethodBeat.i(248808);
    this.vsQ.field_isRead = 1;
    String str = "update BizTimeLineInfo set isRead = 1 where msgId = " + this.vsQ.field_msgId;
    Log.d("MicroMsg.BizTimeLineInfoStorage", "updateUnReadStatus ret = %b", new Object[] { Boolean.valueOf(ac.a(this.acFU).execSQL("BizTimeLineInfo", str)) });
    AppMethodBeat.o(248808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.storage.ac.6
 * JD-Core Version:    0.7.0.1
 */