package com.tencent.mm.ui;

import android.annotation.TargetApi;
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

final class LauncherUI$5
  implements Runnable
{
  long delay = 2000L;
  
  LauncherUI$5(LauncherUI paramLauncherUI) {}
  
  @TargetApi(17)
  public final void run()
  {
    AppMethodBeat.i(33293);
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    MMHandlerThread.removeRunnable(this);
    if (bh.beJ())
    {
      h.aHE();
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", new Object[] { Integer.valueOf(b.getUin()) });
      AppMethodBeat.o(33293);
      return;
    }
    if ((d.bps()) || (CrashReportFactory.foreground))
    {
      this.delay += 2000L;
      if (this.delay > 10000L) {
        this.delay = 2000L;
      }
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[] { Boolean.valueOf(d.bps()), Boolean.valueOf(CrashReportFactory.foreground), Long.valueOf(this.delay) });
      MMHandlerThread.postToMainThreadDelayed(this, this.delay);
      AppMethodBeat.o(33293);
      return;
    }
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
    if (WXHardCoderJNI.isCheckEnv()) {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33292);
          WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
          Log.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
          AppMethodBeat.o(33292);
        }
      }, "terminateApp");
    }
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
    AppMethodBeat.o(33293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI.5
 * JD-Core Version:    0.7.0.1
 */