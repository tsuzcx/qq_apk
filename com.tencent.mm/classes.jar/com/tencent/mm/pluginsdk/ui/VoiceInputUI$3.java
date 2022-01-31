package com.tencent.mm.pluginsdk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.MMEditText;

final class VoiceInputUI$3
  implements MenuItem.OnMenuItemClickListener
{
  VoiceInputUI$3(VoiceInputUI paramVoiceInputUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    VoiceInputUI.c(this.sbE).setText("");
    VoiceInputUI.d(this.sbE);
    this.sbE.DX(6);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI.3
 * JD-Core Version:    0.7.0.1
 */