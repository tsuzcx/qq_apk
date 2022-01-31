package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.a;

final class i$5
  implements MMEditText.a
{
  i$5(i parami) {}
  
  public final void bNU()
  {
    AppMethodBeat.i(38182);
    if (this.rFD.rFo.getVisibility() == 0)
    {
      this.rFD.rFo.setVisibility(8);
      AppMethodBeat.o(38182);
      return;
    }
    ((Activity)i.c(this.rFD)).finish();
    AppMethodBeat.o(38182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.5
 * JD-Core Version:    0.7.0.1
 */