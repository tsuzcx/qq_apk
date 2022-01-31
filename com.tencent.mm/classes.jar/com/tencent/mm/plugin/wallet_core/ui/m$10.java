package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$10
  implements CompoundButton.OnCheckedChangeListener
{
  m$10(Button paramButton) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(47401);
    if (!paramBoolean)
    {
      this.uqE.setEnabled(false);
      this.uqE.setClickable(false);
      AppMethodBeat.o(47401);
      return;
    }
    this.uqE.setEnabled(true);
    this.uqE.setClickable(true);
    AppMethodBeat.o(47401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m.10
 * JD-Core Version:    0.7.0.1
 */