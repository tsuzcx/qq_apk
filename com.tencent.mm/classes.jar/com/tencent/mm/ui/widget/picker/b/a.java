package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.d.e;

public final class a
{
  private com.tencent.mm.ui.widget.picker.c.a QSH;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(198512);
    this.QSH = new com.tencent.mm.ui.widget.picker.c.a(1);
    this.QSH.context = paramContext;
    this.QSH.QUz = parame;
    AppMethodBeat.o(198512);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.g.a parama)
  {
    AppMethodBeat.i(198513);
    parama.b(this.QSH);
    AppMethodBeat.o(198513);
  }
  
  public final a apt(int paramInt)
  {
    this.QSH.jKu = paramInt;
    return this;
  }
  
  public final a apu(int paramInt)
  {
    this.QSH.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.a
 * JD-Core Version:    0.7.0.1
 */