package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.Map;

final class as$6
  implements Runnable
{
  as$6(as paramas, az paramaz, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(36650);
    Object localObject = ag.cpf().abv(this.riI.crk);
    az localaz = this.riI;
    if (localObject != null)
    {
      localObject = ((n)localObject).field_userName;
      localaz.rjz = ((String)localObject);
      ab.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", new Object[] { Boolean.valueOf(this.riJ), this.riI });
      if (!this.riJ) {
        break label124;
      }
      this.riG.riC.offerFirst(this.riI);
    }
    for (;;)
    {
      this.riG.riD.put(this.riI.fVf, this.riI);
      AppMethodBeat.o(36650);
      return;
      localObject = "";
      break;
      label124:
      this.riG.riC.offerLast(this.riI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as.6
 * JD-Core Version:    0.7.0.1
 */