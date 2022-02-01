package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
public final class a$a
  implements Runnable
{
  public a$a(v paramv) {}
  
  public final void run()
  {
    AppMethodBeat.i(210296);
    Object localObject = new aa(this.INP);
    g.azz().b((q)localObject);
    localObject = a.INO;
    localObject = this.INP.IDZ;
    p.g(localObject, "model.imageSearchSessionId");
    int i = this.INP.scene;
    a locala = a.INO;
    a.L((String)localObject, i, a.aXX(this.INP.content));
    AppMethodBeat.o(210296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a
 * JD-Core Version:    0.7.0.1
 */