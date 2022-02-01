package com.tencent.mm.plugin.performance;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.i;
import java.util.ArrayList;

final class a$1
  implements com.tencent.mm.kernel.api.g
{
  a$1(a parama) {}
  
  public final void MP()
  {
    AppMethodBeat.i(176885);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1313);
    if (i.hgJ) {}
    for (int i = 1;; i = 0)
    {
      localIDKey.SetKey(i);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1313);
      localIDKey.SetKey(a.dyw());
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      com.tencent.mm.plugin.report.service.g.yhR.b(localArrayList, false);
      com.tencent.mm.kernel.g.ajD().b(this);
      AppMethodBeat.o(176885);
      return;
    }
  }
  
  public final void cg(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.1
 * JD-Core Version:    0.7.0.1
 */