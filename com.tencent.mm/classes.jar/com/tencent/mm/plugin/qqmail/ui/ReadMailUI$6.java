package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.h;

final class ReadMailUI$6
  implements Runnable
{
  ReadMailUI$6(ReadMailUI paramReadMailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(123153);
    Intent localIntent = this.uRh.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
    h.a(this.uRh, localIntent, this.uRh.getString(2131757092), null);
    AppMethodBeat.o(123153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.6
 * JD-Core Version:    0.7.0.1
 */