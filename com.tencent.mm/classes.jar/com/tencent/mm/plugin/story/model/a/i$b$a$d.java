package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ak;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class i$b$a$d
  implements Runnable
{
  i$b$a$d(i.b.a parama, ud paramud) {}
  
  public final void run()
  {
    AppMethodBeat.i(109242);
    ud localud = this.sxr;
    j.p(localud, "item");
    if (!i.f(localud, (ak)this.sxq)) {
      this.sxq.sendEmptyMessage(0);
    }
    AppMethodBeat.o(109242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.i.b.a.d
 * JD-Core Version:    0.7.0.1
 */