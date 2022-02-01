package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.d.e;

public final class a
{
  private com.tencent.mm.ui.widget.picker.c.a Lax;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(192781);
    this.Lax = new com.tencent.mm.ui.widget.picker.c.a(1);
    this.Lax.context = paramContext;
    this.Lax.Lci = parame;
    AppMethodBeat.o(192781);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.g.a parama)
  {
    AppMethodBeat.i(192782);
    parama.b(this.Lax);
    AppMethodBeat.o(192782);
  }
  
  public final a afH(int paramInt)
  {
    this.Lax.iKN = paramInt;
    return this;
  }
  
  public final a afI(int paramInt)
  {
    this.Lax.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.a
 * JD-Core Version:    0.7.0.1
 */