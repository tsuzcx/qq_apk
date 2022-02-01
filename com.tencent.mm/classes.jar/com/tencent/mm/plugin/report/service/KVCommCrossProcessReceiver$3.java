package com.tencent.mm.plugin.report.service;

import android.os.Process;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class KVCommCrossProcessReceiver$3
  implements Runnable
{
  KVCommCrossProcessReceiver$3(KVCommCrossProcessReceiver paramKVCommCrossProcessReceiver) {}
  
  public final void run()
  {
    AppMethodBeat.i(143821);
    if (n.dw(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "KVCommCrossProcessReceiver shut_down_weixin need to kill process");
      Log.appenderFlushSync();
      Mars.onSingalCrash(0);
      com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/report/service/KVCommCrossProcessReceiver$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/report/service/KVCommCrossProcessReceiver$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    }
    AppMethodBeat.o(143821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver.3
 * JD-Core Version:    0.7.0.1
 */