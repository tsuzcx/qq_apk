package com.tencent.mm.plugin.websearch.widget.b;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.u.i;

public final class a$2
  implements u.i
{
  public a$2(a.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(116655);
    if (paramInt == 0)
    {
      this.Wtq.ird();
      AppMethodBeat.o(116655);
      return;
    }
    AppMethodBeat.o(116655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.b.a.2
 * JD-Core Version:    0.7.0.1
 */