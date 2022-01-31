package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class s$1
  implements n.b
{
  s$1(s params) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(45848);
    if (bo.f(paramObject, 0) == 339975)
    {
      g.RM();
      paramInt = ((Integer)g.RL().Ru().get(339975, Integer.valueOf(0))).intValue();
      if (paramInt != s.a(this.tUT))
      {
        am.dlO().reset();
        s.a(this.tUT, paramInt);
      }
      AppMethodBeat.o(45848);
      return;
    }
    if (ac.a.yCE.equals(paramObject))
    {
      g.RM();
      paramInt = ((Integer)g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
      if (paramInt != s.b(this.tUT))
      {
        am.dlO().reset();
        s.b(this.tUT, paramInt);
      }
    }
    AppMethodBeat.o(45848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s.1
 * JD-Core Version:    0.7.0.1
 */