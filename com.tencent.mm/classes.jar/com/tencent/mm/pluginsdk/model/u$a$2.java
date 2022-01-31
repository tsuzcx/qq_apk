package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$a$2
  implements MessageQueue.IdleHandler
{
  u$a$2(Context paramContext) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(114665);
    Looper.myQueue().removeIdleHandler(this);
    u.a.fP(this.val$context);
    AppMethodBeat.o(114665);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.u.a.2
 * JD-Core Version:    0.7.0.1
 */