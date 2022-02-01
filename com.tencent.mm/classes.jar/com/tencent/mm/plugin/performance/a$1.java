package com.tencent.mm.plugin.performance;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.ArrayList;

final class a$1
  implements g
{
  a$1(a parama) {}
  
  public final void abB()
  {
    AppMethodBeat.i(176885);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1313);
    if (BuildInfo.IS_ARM64) {}
    for (int i = 1;; i = 0)
    {
      localIDKey.SetKey(i);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1313);
      localIDKey.SetKey(a.fnh());
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      com.tencent.mm.plugin.report.service.h.IzE.b(localArrayList, false);
      com.tencent.mm.kernel.h.aHH().b(this);
      AppMethodBeat.o(176885);
      return;
    }
  }
  
  public final void dn(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.1
 * JD-Core Version:    0.7.0.1
 */