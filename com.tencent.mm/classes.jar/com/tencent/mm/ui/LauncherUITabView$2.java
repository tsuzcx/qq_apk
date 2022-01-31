package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class LauncherUITabView$2
  extends ak
{
  LauncherUITabView$2(LauncherUITabView paramLauncherUITabView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(29516);
    ab.v("MicroMsg.LauncherUITabView", "onMainTabClick");
    LauncherUITabView.d(this.yZX).onTabClick(0);
    AppMethodBeat.o(29516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView.2
 * JD-Core Version:    0.7.0.1
 */