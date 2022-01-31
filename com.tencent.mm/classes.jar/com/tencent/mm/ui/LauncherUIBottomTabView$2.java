package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class LauncherUIBottomTabView$2
  extends ak
{
  LauncherUIBottomTabView$2(LauncherUIBottomTabView paramLauncherUIBottomTabView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(29487);
    ab.v("MicroMsg.LauncherUITabView", "onMainTabClick");
    LauncherUIBottomTabView.d(this.yZI).onTabClick(0);
    AppMethodBeat.o(29487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView.2
 * JD-Core Version:    0.7.0.1
 */