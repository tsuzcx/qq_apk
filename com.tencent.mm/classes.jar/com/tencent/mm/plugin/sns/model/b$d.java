package com.tencent.mm.plugin.sns.model;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$d
  implements MessageQueue.IdleHandler
{
  b$d(b paramb) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(36105);
    ab.d("MicroMsg.DownloadManager", "I run idleHandler ");
    b.a(this.rdk, bo.aox());
    boolean bool = b.a(this.rdk);
    AppMethodBeat.o(36105);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.d
 * JD-Core Version:    0.7.0.1
 */