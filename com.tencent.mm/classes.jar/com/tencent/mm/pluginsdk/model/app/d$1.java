package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class d$1
  implements Runnable
{
  d$1(d paramd, int paramInt, t paramt) {}
  
  public final void run()
  {
    AppMethodBeat.i(154788);
    if (!this.vKT.ftE.containsKey(Integer.valueOf(this.bHS))) {
      this.vKT.ftE.put(Integer.valueOf(this.bHS), new HashSet());
    }
    if ((this.vKT.ftE.get(Integer.valueOf(this.bHS)) != null) && (!((Set)this.vKT.ftE.get(Integer.valueOf(this.bHS))).contains(this.vKS))) {
      ((Set)this.vKT.ftE.get(Integer.valueOf(this.bHS))).add(this.vKS);
    }
    AppMethodBeat.o(154788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.d.1
 * JD-Core Version:    0.7.0.1
 */