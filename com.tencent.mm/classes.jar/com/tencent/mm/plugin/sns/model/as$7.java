package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class as$7
  implements Runnable
{
  as$7(as paramas) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(36651);
    if (this.riG.riC.isEmpty())
    {
      ab.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
      AppMethodBeat.o(36651);
      return;
    }
    az localaz = (az)this.riG.riC.poll();
    if (localaz == null)
    {
      ab.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", new Object[] { Integer.valueOf(this.riG.riC.size()) });
      AppMethodBeat.o(36651);
      return;
    }
    if ((this.riG.riB != null) && (localaz.fVf.equals(this.riG.riB.fVf))) {}
    for (;;)
    {
      this.riG.a(localaz, bool);
      AppMethodBeat.o(36651);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as.7
 * JD-Core Version:    0.7.0.1
 */