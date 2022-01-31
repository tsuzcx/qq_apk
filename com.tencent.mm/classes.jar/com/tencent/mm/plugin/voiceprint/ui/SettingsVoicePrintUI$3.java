package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsVoicePrintUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SettingsVoicePrintUI$3(SettingsVoicePrintUI paramSettingsVoicePrintUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26145);
    this.tsf.finish();
    AppMethodBeat.o(26145);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.3
 * JD-Core Version:    0.7.0.1
 */