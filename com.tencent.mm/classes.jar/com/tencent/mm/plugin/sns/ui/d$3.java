package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class d$3
  implements Runnable
{
  d$3(d paramd, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(38079);
    if (this.rEc)
    {
      d locald = this.rEa;
      if (locald.rDY.size() > 1) {
        locald.rDY.remove(0);
      }
    }
    AppMethodBeat.o(38079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.3
 * JD-Core Version:    0.7.0.1
 */