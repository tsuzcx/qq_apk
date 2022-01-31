package com.tencent.mm.plugin.multitalk.ui.widget;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$b
  implements Runnable
{
  f.a oWu;
  
  public f$b(f paramf, f.a parama)
  {
    this.oWu = parama;
  }
  
  public final void run()
  {
    AppMethodBeat.i(54202);
    this.oWu.oWt.setVisibility(8);
    AppMethodBeat.o(54202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.f.b
 * JD-Core Version:    0.7.0.1
 */