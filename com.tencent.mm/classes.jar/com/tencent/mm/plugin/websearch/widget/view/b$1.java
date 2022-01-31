package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.widget.f;
import com.tencent.mm.plugin.websearch.widget.view.footer.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

final class b$1
  implements a.a
{
  b$1(b paramb) {}
  
  public final void dar()
  {
    AppMethodBeat.i(91512);
    List localList = this.uNn.uNf.dai();
    if ((localList == null) || (localList.isEmpty()) || (localList.size() == 1))
    {
      AppMethodBeat.o(91512);
      return;
    }
    f.a(1, this.uNn.uNg, null);
    this.uNn.uNe = ((h)g.E(h.class)).a(this.uNn.hwZ, ah.getContext().getString(2131306213), "", localList, new b.1.1(this));
    AppMethodBeat.o(91512);
  }
  
  public final void das()
  {
    AppMethodBeat.i(91513);
    this.uNn.mXR.cZf();
    AppMethodBeat.o(91513);
  }
  
  public final void dat()
  {
    AppMethodBeat.i(91514);
    this.uNn.mXR.cZg();
    AppMethodBeat.o(91514);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(91517);
    int i = this.uNn.uNf.dah();
    AppMethodBeat.o(91517);
    return i;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(91515);
    boolean bool = this.uNn.uNf.hasNext();
    AppMethodBeat.o(91515);
    return bool;
  }
  
  public final boolean hasPrevious()
  {
    AppMethodBeat.i(91516);
    boolean bool = this.uNn.uNf.daj();
    AppMethodBeat.o(91516);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.1
 * JD-Core Version:    0.7.0.1
 */