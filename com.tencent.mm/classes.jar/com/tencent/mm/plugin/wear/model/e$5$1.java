package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.lx.a;
import com.tencent.mm.protocal.protobuf.cwy;
import java.util.ArrayList;

final class e$5$1
  implements Runnable
{
  e$5$1(e.5 param5, lx paramlx) {}
  
  public final void run()
  {
    AppMethodBeat.i(26303);
    a.cYy().uGE.agc(this.uHf.cBX.talker);
    Object localObject1 = a.cYy().uGE.agb(this.uHf.cBX.talker);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Integer.valueOf(((f)localObject1).id));
    a.cYy().uGI.a(new com.tencent.mm.plugin.wear.model.f.i((ArrayList)localObject2));
    if (this.uHf.cBX.talker.equals("gh_43f2581f6fd6"))
    {
      localObject1 = a.cYy().uGC.uGT.uHH;
      if (localObject1 != null)
      {
        localObject2 = a.cYy().uGF;
        if ((localObject1 != null) && (((b)localObject2).uGM) && (b.aga(((cwy)localObject1).yeC))) {}
        for (int i = 1; i != 0; i = 0)
        {
          a.cYy();
          b.a((cwy)localObject1);
          AppMethodBeat.o(26303);
          return;
        }
        a.cYy().uGF.connect();
      }
    }
    AppMethodBeat.o(26303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.5.1
 * JD-Core Version:    0.7.0.1
 */