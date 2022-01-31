package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

final class d$2
  implements Runnable
{
  d$2(d paramd, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(38078);
    this.rEa.dl(this.rEb);
    d locald = this.rEa;
    boolean bool = this.rEc;
    ag.coO().post(new d.3(locald, bool));
    AppMethodBeat.o(38078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.2
 * JD-Core Version:    0.7.0.1
 */