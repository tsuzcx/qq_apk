package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import java.lang.ref.WeakReference;

public final class a
  implements e.a
{
  private WeakReference<e.a> cMO;
  
  public a(e.a parama)
  {
    AppMethodBeat.i(27599);
    this.cMO = new WeakReference(parama);
    AppMethodBeat.o(27599);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(27600);
    if (this.cMO.get() != null) {
      ((e.a)this.cMO.get()).Mr(paramString);
    }
    AppMethodBeat.o(27600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.a
 * JD-Core Version:    0.7.0.1
 */