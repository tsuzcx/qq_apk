package com.tencent.mm.ui.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(113121);
    ak.d("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
    if (this.ANs.ANq != null) {
      this.ANs.ANq.dLu();
    }
    AppMethodBeat.o(113121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.5
 * JD-Core Version:    0.7.0.1
 */