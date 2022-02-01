package com.tencent.mm.sensitive.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/condition/AccountReadyCondition;", "Lcom/tencent/mm/sensitive/condition/ICondition;", "()V", "checkCondition", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements e
{
  public final boolean iUe()
  {
    AppMethodBeat.i(240937);
    if (MMApplicationContext.isMainProcess())
    {
      boolean bool = h.baz();
      AppMethodBeat.o(240937);
      return bool;
    }
    if (b.aZP() != 0)
    {
      AppMethodBeat.o(240937);
      return true;
    }
    AppMethodBeat.o(240937);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.a.a
 * JD-Core Version:    0.7.0.1
 */