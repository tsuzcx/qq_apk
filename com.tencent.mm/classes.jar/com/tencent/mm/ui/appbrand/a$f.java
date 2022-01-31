package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.w;

public final class a$f
  extends a.c
{
  public a$f(a parama)
  {
    super(parama);
  }
  
  public final View dDv()
  {
    AppMethodBeat.i(29939);
    View localView = w.hM(this.zgk.context).inflate(2130969030, null);
    ((TextView)localView.findViewById(2131822459)).setText(this.zgk.context.getString(2131296850));
    AppMethodBeat.o(29939);
    return localView;
  }
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(29940);
    super.onCreateMMMenu(paraml);
    paraml.e(5, this.zgk.context.getString(2131296732));
    paraml.e(4, this.zgk.context.getString(2131296848));
    AppMethodBeat.o(29940);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(29941);
    super.onMMMenuItemSelected(paramMenuItem, paramInt);
    AppMethodBeat.o(29941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.f
 * JD-Core Version:    0.7.0.1
 */