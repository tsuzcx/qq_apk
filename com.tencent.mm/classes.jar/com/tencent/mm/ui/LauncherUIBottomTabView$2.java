package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class LauncherUIBottomTabView$2
  extends ah
{
  LauncherUIBottomTabView$2(LauncherUIBottomTabView paramLauncherUIBottomTabView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    y.v("MicroMsg.LauncherUITabView", "onMainTabClick");
    LauncherUIBottomTabView.d(this.uLD).qc(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView.2
 * JD-Core Version:    0.7.0.1
 */