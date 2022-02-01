package com.tencent.mm.plugin.wallet_core.utils;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k$5
  implements CompoundButton.OnCheckedChangeListener
{
  public k$5(View paramView) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(189202);
    if (this.PhH != null) {
      this.PhH.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(189202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.k.5
 * JD-Core Version:    0.7.0.1
 */