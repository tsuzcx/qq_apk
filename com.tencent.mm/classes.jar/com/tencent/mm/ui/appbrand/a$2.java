package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class a$2
  implements n.c
{
  a$2(a parama) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(29927);
    if (this.zgk.zgi == null)
    {
      ab.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
      AppMethodBeat.o(29927);
      return;
    }
    this.zgk.zgi.onCreateMMMenu(paraml);
    AppMethodBeat.o(29927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.2
 * JD-Core Version:    0.7.0.1
 */