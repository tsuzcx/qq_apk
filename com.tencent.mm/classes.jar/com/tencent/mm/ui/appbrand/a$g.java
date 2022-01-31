package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.w;

public final class a$g
  extends a.c
{
  public a$g(a parama)
  {
    super(parama);
  }
  
  public final View dDv()
  {
    AppMethodBeat.i(29942);
    View localView = w.hM(this.zgk.context).inflate(2130969030, null);
    ((TextView)localView.findViewById(2131822459)).setText(this.zgk.context.getString(2131296852));
    AppMethodBeat.o(29942);
    return localView;
  }
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(29943);
    super.onCreateMMMenu(paraml);
    paraml.e(6, this.zgk.context.getString(2131296733));
    paraml.e(4, this.zgk.context.getString(2131296848));
    AppMethodBeat.o(29943);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(29944);
    super.onMMMenuItemSelected(paramMenuItem, paramInt);
    AppMethodBeat.o(29944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */