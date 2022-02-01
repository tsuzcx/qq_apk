package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.d.e;

public final class a
{
  private com.tencent.mm.ui.widget.picker.c.a HID;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(195364);
    this.HID = new com.tencent.mm.ui.widget.picker.c.a(1);
    this.HID.context = paramContext;
    this.HID.HKo = parame;
    AppMethodBeat.o(195364);
  }
  
  public final void a(com.tencent.mm.ui.widget.picker.g.a parama)
  {
    AppMethodBeat.i(195365);
    parama.b(this.HID);
    AppMethodBeat.o(195365);
  }
  
  public final a aaV(int paramInt)
  {
    this.HID.hRF = paramInt;
    return this;
  }
  
  public final a aaW(int paramInt)
  {
    this.HID.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.a
 * JD-Core Version:    0.7.0.1
 */