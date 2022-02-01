package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;

final class LauncherUI$5
  implements Runnable
{
  long gY = 2000L;
  
  LauncherUI$5(LauncherUI paramLauncherUI) {}
  
  @TargetApi(17)
  public final void run()
  {
    AppMethodBeat.i(33293);
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    MMHandlerThread.removeRunnable(this);
    if (bg.aVG())
    {
      g.aAf();
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", new Object[] { Integer.valueOf(a.getUin()) });
      AppMethodBeat.o(33293);
      return;
    }
    if ((d.bgc()) || (CrashReportFactory.foreground))
    {
      this.gY += 2000L;
      if (this.gY > 10000L) {
        this.gY = 2000L;
      }
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[] { Boolean.valueOf(d.bgc()), Boolean.valueOf(CrashReportFactory.foreground), Long.valueOf(this.gY) });
      MMHandlerThread.postToMainThreadDelayed(this, this.gY);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI.5
 * JD-Core Version:    0.7.0.1
 */