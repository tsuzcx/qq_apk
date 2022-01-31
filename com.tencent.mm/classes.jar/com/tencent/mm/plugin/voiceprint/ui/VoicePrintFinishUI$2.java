package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoicePrintFinishUI$2
  implements MenuItem.OnMenuItemClickListener
{
  VoicePrintFinishUI$2(VoicePrintFinishUI paramVoicePrintFinishUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26206);
    this.tst.finish();
    AppMethodBeat.o(26206);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintFinishUI.2
 * JD-Core Version:    0.7.0.1
 */