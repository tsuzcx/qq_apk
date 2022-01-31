package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
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
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(24223);
    cgb();
    AppMethodBeat.o(24223);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(24222);
    this.pZv = parama;
    this.pZa.clear();
    this.pZa.addAll(parama.pZa);
    notifyDataSetChanged();
    AppMethodBeat.o(24222);
  }
  
  public final void d(b paramb)
  {
    paramb.dataType = 0;
    paramb.fromScene = this.fromScene;
    paramb.cpO = ((f)this.pZv).cpO;
    paramb.cEB = ((f)this.pZv).cEB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.e
 * JD-Core Version:    0.7.0.1
 */