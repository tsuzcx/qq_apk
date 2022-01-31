package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Set;

final class d$2
  implements Runnable
{
  d$2(d paramd, int paramInt, t paramt) {}
  
  public final void run()
  {
    AppMethodBeat.i(154789);
    if (this.vKT.ftE.get(Integer.valueOf(this.bHS)) != null) {
      ((Set)this.vKT.ftE.get(Integer.valueOf(this.bHS))).remove(this.vKS);
    }
    AppMethodBeat.o(154789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.d.2
 * JD-Core Version:    0.7.0.1
 */