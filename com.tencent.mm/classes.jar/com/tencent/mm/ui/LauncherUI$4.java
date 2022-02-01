package com.tencent.mm.ui;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;

final class LauncherUI$4
  implements Runnable
{
  long delay = 2000L;
  
  LauncherUI$4(LauncherUI paramLauncherUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33294);
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    MMHandlerThread.removeRunnable(this);
    if (bh.bCA())
    {
      h.baC();
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", new Object[] { Integer.valueOf(b.getUin()) });
      AppMethodBeat.o(33294);
      return;
    }
    if ((d.bMZ()) || (CrashReportFactory.foreground))
    {
      this.delay += 2000L;
      if (this.delay > 10000L) {
        this.delay = 2000L;
      }
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[] { Boolean.valueOf(d.bMZ()), Boolean.valueOf(CrashReportFactory.foreground), Long.valueOf(this.delay) });
      MMHandlerThread.postToMainThreadDelayed(this, this.delay);
      AppMethodBeat.o(33294);
      return;
    }
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
    if (WXHardCoderJNI.isCheckEnv()) {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249767);
          WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
          Log.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
          AppMethodBeat.o(249767);
        }
      }, "terminateApp");
    }
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
    AppMethodBeat.o(33294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI.4
 * JD-Core Version:    0.7.0.1
 */