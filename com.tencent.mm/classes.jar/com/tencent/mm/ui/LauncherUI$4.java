package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class LauncherUI$4
  implements Runnable
{
  long brn = 2000L;
  
  LauncherUI$4(LauncherUI paramLauncherUI) {}
  
  @TargetApi(17)
  public final void run()
  {
    y.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    ai.S(this);
    if (au.Hz())
    {
      g.DN();
      y.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", new Object[] { Integer.valueOf(a.CK()) });
      return;
    }
    if ((d.Ro()) || (b.foreground))
    {
      this.brn += 2000L;
      if (this.brn > 10000L) {
        this.brn = 2000L;
      }
      y.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[] { Boolean.valueOf(d.Ro()), Boolean.valueOf(b.foreground), Long.valueOf(this.brn) });
      ai.l(this, this.brn);
      return;
    }
    y.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
    if (WXHardCoderJNI.getCheckEnv()) {
      WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
    }
    y.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI.4
 * JD-Core Version:    0.7.0.1
 */