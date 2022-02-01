package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab$a$2
  implements MessageQueue.IdleHandler
{
  ab$a$2(Context paramContext) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(133676);
    Looper.myQueue().removeIdleHandler(this);
    ab.a.ju(this.val$context);
    AppMethodBeat.o(133676);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.ab.a.2
 * JD-Core Version:    0.7.0.1
 */