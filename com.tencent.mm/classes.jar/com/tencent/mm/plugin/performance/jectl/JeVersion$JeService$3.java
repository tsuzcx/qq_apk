package com.tencent.mm.plugin.performance.jectl;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;

final class JeVersion$JeService$3
  implements Runnable
{
  JeVersion$JeService$3(JeVersion.JeService paramJeService) {}
  
  public final void run()
  {
    AppMethodBeat.i(201748);
    Log.i("MicroMsg.JeVersion", "onDestroy: kill self");
    com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/performance/jectl/JeVersion$JeService$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/performance/jectl/JeVersion$JeService$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(201748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.jectl.JeVersion.JeService.3
 * JD-Core Version:    0.7.0.1
 */