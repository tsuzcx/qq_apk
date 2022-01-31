package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class MMTagPanel$b$3
  implements Runnable
{
  MMTagPanel$b$3(MMTagPanel.b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(106823);
    MMTagPanel.a(this.zmI.zmE).setText("");
    MMTagPanel.a(this.zmI.zmE).append(this.zmJ);
    AppMethodBeat.o(106823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.b.3
 * JD-Core Version:    0.7.0.1
 */