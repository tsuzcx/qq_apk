package com.tencent.mm.plugin.qqmail.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ReadMailUI$a$5
  implements Runnable
{
  ReadMailUI$a$5(ReadMailUI.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(68443);
    ReadMailUI.m(this.pPh.pOX).setVisibility(8);
    ReadMailUI.n(this.pPh.pOX);
    AppMethodBeat.o(68443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a.5
 * JD-Core Version:    0.7.0.1
 */