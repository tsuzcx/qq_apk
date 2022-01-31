package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Process;

final class SettingsAboutSystemUI$3$1
  implements Runnable
{
  SettingsAboutSystemUI$3$1(SettingsAboutSystemUI.3 param3) {}
  
  public final void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.3.1
 * JD-Core Version:    0.7.0.1
 */