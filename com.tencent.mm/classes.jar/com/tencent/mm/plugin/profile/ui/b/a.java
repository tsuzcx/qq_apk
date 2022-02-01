package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import java.lang.ref.WeakReference;

public final class a
  implements e.a
{
  private WeakReference<e.a> cnv;
  
  public a(e.a parama)
  {
    AppMethodBeat.i(27599);
    this.cnv = new WeakReference(parama);
    AppMethodBeat.o(27599);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(27600);
    if (this.cnv.get() != null) {
      ((e.a)this.cnv.get()).Af(paramString);
    }
    AppMethodBeat.o(27600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.a
 * JD-Core Version:    0.7.0.1
 */