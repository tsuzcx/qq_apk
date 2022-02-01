package com.tencent.mm.plugin.wallet_core.utils;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n$6
  implements CompoundButton.OnCheckedChangeListener
{
  public n$6(View paramView) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(301463);
    if (this.VYv != null) {
      this.VYv.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(301463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.n.6
 * JD-Core Version:    0.7.0.1
 */