package com.tencent.mm.plugin.multitalk.b;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class l$1
  implements Runnable
{
  l$1(Context paramContext, ConditionVariable paramConditionVariable) {}
  
  public final void run()
  {
    AppMethodBeat.i(200632);
    PlatformComm.init(this.val$context, new Handler(Looper.getMainLooper()));
    this.tRn.open();
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "PlatformComm.init finish, and open condition");
    AppMethodBeat.o(200632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.l.1
 * JD-Core Version:    0.7.0.1
 */