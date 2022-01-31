package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$1
  implements View.OnClickListener
{
  f$1(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44981);
    if (f.a(this.qoV) != null)
    {
      f.a(this.qoV).onClick(paramView);
      this.qoV.dismiss();
    }
    AppMethodBeat.o(44981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.f.1
 * JD-Core Version:    0.7.0.1
 */