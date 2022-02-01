package com.tencent.mm.plugin.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sandbox.updater.UpdateEventListener;

public final class a
  implements n
{
  public a()
  {
    AppMethodBeat.i(28048);
    new UpdateEventListener().alive();
    AppMethodBeat.o(28048);
  }
  
  public final void a(l paraml) {}
  
  public final void a(m paramm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sandbox.a
 * JD-Core Version:    0.7.0.1
 */