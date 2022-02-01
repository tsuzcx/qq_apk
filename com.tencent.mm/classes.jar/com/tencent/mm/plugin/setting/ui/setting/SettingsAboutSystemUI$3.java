package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class SettingsAboutSystemUI$3
  implements DialogInterface.OnClickListener
{
  SettingsAboutSystemUI$3(SettingsAboutSystemUI paramSettingsAboutSystemUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74043);
    if (!b.apl()) {}
    for (boolean bool = true;; bool = false)
    {
      b.du(bool);
      g.aAi().releaseAll();
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74042);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$2$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$2$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          AppMethodBeat.o(74042);
        }
      });
      AppMethodBeat.o(74043);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.3
 * JD-Core Version:    0.7.0.1
 */