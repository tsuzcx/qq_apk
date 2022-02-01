package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.misc.a.a.a;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.sdk.platformtools.Log;

final class u$2
  implements a.a
{
  u$2(u paramu) {}
  
  public final void onSIMCardChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293314);
    Log.d("MicroMsg.Voip.VoipService", "simtype " + paramInt1 + " reason " + paramInt2);
    if ((paramInt2 == 3) && (paramInt1 == 1))
    {
      paramInt1 = this.UCe.UBE.UvO.UyU.handleCommand(2, null, 0);
      if (paramInt1 < 0) {
        g.Loge("MicroMsg.Voip.VoipService", "v2protocal handlecommand failed ret:".concat(String.valueOf(paramInt1)));
      }
    }
    AppMethodBeat.o(293314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u.2
 * JD-Core Version:    0.7.0.1
 */