package com.tencent.mm.pluginsdk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoiceInputUI$1
  implements MenuItem.OnMenuItemClickListener
{
  VoiceInputUI$1(VoiceInputUI paramVoiceInputUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(27606);
    this.vSL.ni(1);
    AppMethodBeat.o(27606);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI.1
 * JD-Core Version:    0.7.0.1
 */