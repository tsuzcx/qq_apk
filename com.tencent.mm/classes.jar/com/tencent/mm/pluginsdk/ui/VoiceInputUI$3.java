package com.tencent.mm.pluginsdk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class VoiceInputUI$3
  implements MenuItem.OnMenuItemClickListener
{
  VoiceInputUI$3(VoiceInputUI paramVoiceInputUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(27608);
    VoiceInputUI.c(this.vSL).setText("");
    VoiceInputUI.d(this.vSL);
    this.vSL.ni(6);
    AppMethodBeat.o(27608);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI.3
 * JD-Core Version:    0.7.0.1
 */