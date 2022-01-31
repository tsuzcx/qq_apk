package com.tencent.mm.plugin.websearch.widget.b;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

public final class a$2
  implements n.d
{
  public a$2(a.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(91460);
    if (paramInt == 0)
    {
      this.uMF.dad();
      AppMethodBeat.o(91460);
      return;
    }
    if (paramInt == 1) {
      this.uMF.cZf();
    }
    AppMethodBeat.o(91460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.b.a.2
 * JD-Core Version:    0.7.0.1
 */