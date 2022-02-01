package com.tinkerboots.sdk.tinker.service;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.util.b;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.b.d.a;
import com.tinkerboots.sdk.b.d.b;
import java.io.File;

public class TinkerServerResultService
  extends DefaultTinkerResultService
{
  private static boolean MAu = false;
  private static com.tinkerboots.sdk.tinker.a.a uIZ = null;
  
  static void restartProcess()
  {
    AppMethodBeat.i(3458);
    ShareTinkerLog.v("Tinker.TinkerServerResultService", "app is background now, i can kill quietly", new Object[0]);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tinkerboots/sdk/tinker/service/TinkerServerResultService", "restartProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tinkerboots/sdk/tinker/service/TinkerServerResultService", "restartProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(3458);
  }
  
  public final void a(com.tencent.tinker.lib.service.a parama)
  {
    AppMethodBeat.i(3457);
    if (parama == null)
    {
      ShareTinkerLog.v("Tinker.TinkerServerResultService", "received null result!!!!", new Object[0]);
      AppMethodBeat.o(3457);
      return;
    }
    ShareTinkerLog.v("Tinker.TinkerServerResultService", "receive result: %s", new Object[] { parama.toString() });
    b.ll(getApplicationContext());
    if (uIZ != null) {
      uIZ.a(parama);
    }
    if (parama.dpX)
    {
      ShareTinkerLog.v("Tinker.TinkerServerResultService", "patch success, please restart process", new Object[0]);
      ac(new File(parama.MgK));
      if (b(parama))
      {
        if (MAu)
        {
          ShareTinkerLog.v("Tinker.TinkerServerResultService", "tinker wait screen to restart process", new Object[0]);
          new d.b(getApplicationContext(), new d.a()
          {
            public final void onScreenOff()
            {
              AppMethodBeat.i(3456);
              TinkerServerResultService.restartProcess();
              AppMethodBeat.o(3456);
            }
          });
          AppMethodBeat.o(3457);
        }
      }
      else
      {
        ShareTinkerLog.v("Tinker.TinkerServerResultService", "I have already install the newly patch version!", new Object[0]);
        AppMethodBeat.o(3457);
      }
    }
    else
    {
      ShareTinkerLog.v("Tinker.TinkerServerResultService", "patch fail, please check reason", new Object[0]);
    }
    AppMethodBeat.o(3457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.tinker.service.TinkerServerResultService
 * JD-Core Version:    0.7.0.1
 */