package com.tencent.mm.ui;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ab;

final class LauncherUI$3$1
  implements Runnable
{
  LauncherUI$3$1(LauncherUI.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(29445);
    WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
    ab.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
    AppMethodBeat.o(29445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI.3.1
 * JD-Core Version:    0.7.0.1
 */