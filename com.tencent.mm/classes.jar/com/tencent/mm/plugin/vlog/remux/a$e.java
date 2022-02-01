package com.tencent.mm.plugin.vlog.remux;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class a$e
  implements Runnable
{
  a$e(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(111011);
    int i = a.c(this.ArC);
    Object localObject = a.a(this.ArC);
    if (localObject != null) {
      ((m)localObject).n(new byte[i * 2048], Long.valueOf(a.b(this.ArC)));
    }
    localObject = this.ArC;
    a.a((a)localObject, a.b((a)localObject) + a.d(this.ArC) * 1000L);
    AppMethodBeat.o(111011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.a.e
 * JD-Core Version:    0.7.0.1
 */