package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import java.lang.ref.WeakReference;

public final class b
  implements n.b
{
  private WeakReference<n.b> bJz;
  
  public b(n.b paramb)
  {
    AppMethodBeat.i(23962);
    this.bJz = new WeakReference(paramb);
    AppMethodBeat.o(23962);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(23963);
    if (this.bJz.get() != null) {
      ((n.b)this.bJz.get()).a(paramInt, paramn, paramObject);
    }
    AppMethodBeat.o(23963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.b
 * JD-Core Version:    0.7.0.1
 */