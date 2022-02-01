package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import java.lang.ref.WeakReference;

public final class a
  implements e.a
{
  private WeakReference<e.a> cqo;
  
  public a(e.a parama)
  {
    AppMethodBeat.i(27599);
    this.cqo = new WeakReference(parama);
    AppMethodBeat.o(27599);
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(27600);
    if (this.cqo.get() != null) {
      ((e.a)this.cqo.get()).vZ(paramString);
    }
    AppMethodBeat.o(27600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.a
 * JD-Core Version:    0.7.0.1
 */