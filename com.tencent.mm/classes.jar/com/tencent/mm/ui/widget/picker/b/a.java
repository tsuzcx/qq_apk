package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.d.e;

public final class a
{
  private com.tencent.mm.ui.widget.picker.c.a LwV;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(200554);
    this.LwV = new com.tencent.mm.ui.widget.picker.c.a(1);
    this.LwV.context = paramContext;
    this.LwV.LyJ = parame;
    AppMethodBeat.o(200554);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.g.a parama)
  {
    AppMethodBeat.i(200555);
    parama.b(this.LwV);
    AppMethodBeat.o(200555);
  }
  
  public final a agq(int paramInt)
  {
    this.LwV.iNG = paramInt;
    return this;
  }
  
  public final a agr(int paramInt)
  {
    this.LwV.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.a
 * JD-Core Version:    0.7.0.1
 */