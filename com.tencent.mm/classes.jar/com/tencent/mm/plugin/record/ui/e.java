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
  
  protected final com.tencent.mm.plugin.record.ui.viewWrappers.a a(com.tencent.mm.plugin.record.ui.viewWrappers.a parama)
  {
    parama.fromScene = this.fromScene;
    return parama;
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(27864);
    gGt();
    AppMethodBeat.o(27864);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(27863);
    if (parama != null)
    {
      this.NBz = parama;
      this.NBa.clear();
      this.NBa.addAll(parama.NBa);
      notifyDataSetChanged();
    }
    AppMethodBeat.o(27863);
  }
  
  public final void d(b paramb)
  {
    paramb.dataType = 0;
    paramb.fromScene = this.fromScene;
    paramb.NBB = this.NBB;
    paramb.msgId = ((f)this.NBz).msgId;
    paramb.hXv = ((f)this.NBz).hXv;
  }
  
  protected final int getFromScene()
  {
    return this.fromScene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.e
 * JD-Core Version:    0.7.0.1
 */