package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$a$1
  implements Runnable
{
  c$a$1(c.a parama, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(109554);
    ab.i(c.g(this.sBr.sBo), "LogStory: deleteItem fake " + this.sBs);
    Object localObject = n.svx;
    n.a.FH(this.sBs.syr.cIp);
    localObject = k.sCp;
    k.mF(this.sBs.syr.timeStamp);
    localObject = k.sCp;
    localObject = k.sCp;
    k.c(k.mE(this.sBs.syr.timeStamp));
    AppMethodBeat.o(109554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.a.1
 * JD-Core Version:    0.7.0.1
 */