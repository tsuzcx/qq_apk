package com.tencent.mm.plugin.wallet_core.utils;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$4
  implements CompoundButton.OnCheckedChangeListener
{
  public e$4(View paramView) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(48019);
    if (this.uyq != null) {
      this.uyq.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(48019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.e.4
 * JD-Core Version:    0.7.0.1
 */