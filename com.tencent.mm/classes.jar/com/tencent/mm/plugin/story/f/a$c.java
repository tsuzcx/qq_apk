package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.model.a.f;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class a$c
  implements Runnable
{
  a$c(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(109502);
    Object localObject = a.sAw;
    ab.i(a.access$getTAG$cp(), "loadFpData username=" + a.a(this.sAx) + " maxId=" + a.d(this.sAx));
    localObject = g.RK();
    a.f.b.j.p(localObject, "MMKernel.network()");
    localObject = ((b)localObject).Rc();
    String str1 = a.a(this.sAx);
    long l = a.d(this.sAx);
    String str2 = a.a(this.sAx);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    ((p)localObject).b((m)new f(str1, l, bo.isEqual(str2, j.b.coK())));
    AppMethodBeat.o(109502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.c
 * JD-Core Version:    0.7.0.1
 */