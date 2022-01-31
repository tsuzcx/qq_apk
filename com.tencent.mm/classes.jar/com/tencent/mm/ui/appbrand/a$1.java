package com.tencent.mm.ui.appbrand;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class a$1
  implements n.d
{
  a$1(a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(29926);
    if (this.zgk.zgi == null)
    {
      ab.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
      AppMethodBeat.o(29926);
      return;
    }
    this.zgk.zgi.onMMMenuItemSelected(paramMenuItem, paramInt);
    AppMethodBeat.o(29926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.1
 * JD-Core Version:    0.7.0.1
 */