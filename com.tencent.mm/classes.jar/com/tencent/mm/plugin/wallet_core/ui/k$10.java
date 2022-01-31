package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public final class k$10
  implements CompoundButton.OnCheckedChangeListener
{
  public k$10(Button paramButton) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.qDJ.setEnabled(false);
      this.qDJ.setClickable(false);
      return;
    }
    this.qDJ.setEnabled(true);
    this.qDJ.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k.10
 * JD-Core Version:    0.7.0.1
 */