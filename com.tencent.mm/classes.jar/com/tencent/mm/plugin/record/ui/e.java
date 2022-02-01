package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.ui.a.b;
import java.util.List;

public final class e
  extends h
  implements d
{
  int fromScene = 0;
  
  public e(Context paramContext, h.a parama)
  {
    super(paramContext, parama);
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(27864);
    dEv();
    AppMethodBeat.o(27864);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(27863);
    this.xrT = parama;
    this.xrx.clear();
    this.xrx.addAll(parama.xrx);
    notifyDataSetChanged();
    AppMethodBeat.o(27863);
  }
  
  public final void d(b paramb)
  {
    paramb.dataType = 0;
    paramb.fromScene = this.fromScene;
    paramb.msgId = ((f)this.xrT).msgId;
    paramb.dEP = ((f)this.xrT).dEP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.e
 * JD-Core Version:    0.7.0.1
 */