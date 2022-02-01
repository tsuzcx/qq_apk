package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import java.lang.ref.WeakReference;

public final class b
  implements n.b
{
  private WeakReference<n.b> cya;
  
  public b(n.b paramb)
  {
    AppMethodBeat.i(27601);
    this.cya = new WeakReference(paramb);
    AppMethodBeat.o(27601);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27602);
    if (this.cya.get() != null) {
      ((n.b)this.cya.get()).a(paramInt, paramn, paramObject);
    }
    AppMethodBeat.o(27602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.b
 * JD-Core Version:    0.7.0.1
 */