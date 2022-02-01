package com.tencent.mm.plugin.multitalk.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class m$1
  implements Runnable
{
  m$1(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(239058);
    PlatformComm.init(this.val$context, new Handler(Looper.getMainLooper()));
    Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "PlatformComm.init finish");
    AppMethodBeat.o(239058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.m.1
 * JD-Core Version:    0.7.0.1
 */