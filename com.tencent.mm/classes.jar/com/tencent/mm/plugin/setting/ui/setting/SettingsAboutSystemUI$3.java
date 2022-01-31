package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;

final class SettingsAboutSystemUI$3
  implements DialogInterface.OnClickListener
{
  SettingsAboutSystemUI$3(SettingsAboutSystemUI paramSettingsAboutSystemUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127111);
    if (!b.Mg()) {}
    for (boolean bool = true;; bool = false)
    {
      b.bS(bool);
      g.RM().releaseAll();
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127110);
          Process.killProcess(Process.myPid());
          AppMethodBeat.o(127110);
        }
      });
      AppMethodBeat.o(127111);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.3
 * JD-Core Version:    0.7.0.1
 */