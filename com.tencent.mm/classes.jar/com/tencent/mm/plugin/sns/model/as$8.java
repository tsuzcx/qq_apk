package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class as$8
  implements Runnable
{
  as$8(as paramas) {}
  
  public final void run()
  {
    AppMethodBeat.i(36652);
    if (this.riG.riB != null)
    {
      ab.i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", new Object[] { this.riG.riB.fVf });
      this.riG.riD.remove(this.riG.riB.fVf);
    }
    this.riG.riB = null;
    this.riG.cpL();
    AppMethodBeat.o(36652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as.8
 * JD-Core Version:    0.7.0.1
 */