package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import java.lang.ref.WeakReference;

public final class a
  implements d.a
{
  private WeakReference<d.a> bJz;
  
  public a(d.a parama)
  {
    AppMethodBeat.i(23960);
    this.bJz = new WeakReference(parama);
    AppMethodBeat.o(23960);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(23961);
    if (this.bJz.get() != null) {
      ((d.a)this.bJz.get()).re(paramString);
    }
    AppMethodBeat.o(23961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.a
 * JD-Core Version:    0.7.0.1
 */