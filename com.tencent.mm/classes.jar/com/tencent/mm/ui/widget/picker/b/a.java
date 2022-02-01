package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.d.e;

public final class a
{
  private com.tencent.mm.ui.widget.picker.c.a Jja;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(199835);
    this.Jja = new com.tencent.mm.ui.widget.picker.c.a(1);
    this.Jja.context = paramContext;
    this.Jja.JkL = parame;
    AppMethodBeat.o(199835);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.g.a parama)
  {
    AppMethodBeat.i(199836);
    parama.b(this.Jja);
    AppMethodBeat.o(199836);
  }
  
  public final a adh(int paramInt)
  {
    this.Jja.irK = paramInt;
    return this;
  }
  
  public final a adi(int paramInt)
  {
    this.Jja.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.a
 * JD-Core Version:    0.7.0.1
 */