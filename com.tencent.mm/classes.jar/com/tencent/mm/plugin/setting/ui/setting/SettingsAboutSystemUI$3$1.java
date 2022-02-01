package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

final class SettingsAboutSystemUI$3$1
  implements Runnable
{
  SettingsAboutSystemUI$3$1(SettingsAboutSystemUI.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(74042);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$2$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$2$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(74042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.3.1
 * JD-Core Version:    0.7.0.1
 */