package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import java.lang.ref.WeakReference;

public final class a
  implements f.a
{
  private WeakReference<f.a> cNB;
  
  public a(f.a parama)
  {
    AppMethodBeat.i(27599);
    this.cNB = new WeakReference(parama);
    AppMethodBeat.o(27599);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(27600);
    if (this.cNB.get() != null) {
      ((f.a)this.cNB.get()).TM(paramString);
    }
    AppMethodBeat.o(27600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.a
 * JD-Core Version:    0.7.0.1
 */