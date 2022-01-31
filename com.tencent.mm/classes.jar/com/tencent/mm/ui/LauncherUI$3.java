package com.tencent.mm.ui;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class LauncherUI$3
  implements Runnable
{
  long cps = 2000L;
  
  LauncherUI$3(LauncherUI paramLauncherUI) {}
  
  @TargetApi(17)
  public final void run()
  {
    AppMethodBeat.i(29446);
    ab.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    al.ae(this);
    if (aw.aaB())
    {
      g.RJ();
      ab.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", new Object[] { Integer.valueOf(a.getUin()) });
      AppMethodBeat.o(29446);
      return;
    }
    if ((com.tencent.mm.modelstat.d.akx()) || (b.foreground))
    {
      this.cps += 2000L;
      if (this.cps > 10000L) {
        this.cps = 2000L;
      }
      ab.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelstat.d.akx()), Boolean.valueOf(b.foreground), Long.valueOf(this.cps) });
      al.p(this, this.cps);
      AppMethodBeat.o(29446);
      return;
    }
    ab.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
    if (WXHardCoderJNI.isCheckEnv()) {
      com.tencent.mm.sdk.g.d.post(new LauncherUI.3.1(this), "terminateApp");
    }
    ab.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
    AppMethodBeat.o(29446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI.3
 * JD-Core Version:    0.7.0.1
 */