package com.tencent.mm.plugin.multitalk.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$1
  implements Runnable
{
  m$1(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(190482);
    PlatformComm.init(this.val$context, new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(190482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.m.1
 * JD-Core Version:    0.7.0.1
 */