package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;

public final class a$e
  extends a.c
{
  public a$e(a parama)
  {
    super(parama);
  }
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(29937);
    super.onCreateMMMenu(paraml);
    paraml.e(3, this.zgk.context.getString(2131296853));
    paraml.e(8, this.zgk.context.getString(2131296849));
    paraml.e(7, a.a(this.zgk));
    AppMethodBeat.o(29937);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(29938);
    super.onMMMenuItemSelected(paramMenuItem, paramInt);
    AppMethodBeat.o(29938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.e
 * JD-Core Version:    0.7.0.1
 */