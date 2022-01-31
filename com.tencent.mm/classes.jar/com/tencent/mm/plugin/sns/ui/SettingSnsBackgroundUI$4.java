package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingSnsBackgroundUI$4
  implements Runnable
{
  SettingSnsBackgroundUI$4(SettingSnsBackgroundUI paramSettingSnsBackgroundUI, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(38556);
    SettingSnsBackgroundUI.a(this.rLd, this.val$requestCode, this.val$data);
    AppMethodBeat.o(38556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.4
 * JD-Core Version:    0.7.0.1
 */