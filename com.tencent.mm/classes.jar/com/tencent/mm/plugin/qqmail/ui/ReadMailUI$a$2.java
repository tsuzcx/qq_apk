package com.tencent.mm.plugin.qqmail.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class ReadMailUI$a$2
  implements Runnable
{
  ReadMailUI$a$2(ReadMailUI.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(68440);
    ReadMailUI.h(this.pPh.pOX).setEnabled(false);
    ReadMailUI.h(this.pPh.pOX).setText(2131302321);
    ReadMailUI.h(this.pPh.pOX).setTextColor(-7829368);
    ReadMailUI.h(this.pPh.pOX).setCompoundDrawablesWithIntrinsicBounds(a.k(this.pPh.pOX, 2130840246), null, null, null);
    AppMethodBeat.o(68440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a.2
 * JD-Core Version:    0.7.0.1
 */