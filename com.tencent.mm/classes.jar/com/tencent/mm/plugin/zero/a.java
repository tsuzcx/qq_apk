package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.d;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

public final class a
  implements c, com.tencent.mm.plugin.zero.b.a
{
  private f XMs;
  private d XMt;
  
  public a()
  {
    AppMethodBeat.i(132988);
    this.XMs = new f();
    this.XMt = new d();
    AppMethodBeat.o(132988);
  }
  
  public final f aRC()
  {
    AppMethodBeat.i(132989);
    h.baF();
    h.baC().aZJ();
    f localf = this.XMs;
    AppMethodBeat.o(132989);
    return localf;
  }
  
  public final d aRD()
  {
    AppMethodBeat.i(132990);
    h.baF();
    h.baC().aZJ();
    d locald = this.XMt;
    AppMethodBeat.o(132990);
    return locald;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(132991);
    if (paramc.mDg)
    {
      paramc = this.XMt;
      u localu1 = new u(com.tencent.mm.loader.i.b.bmz() + "configlist/");
      if (localu1.jKS())
      {
        u localu2 = new u(d.lZM);
        if (!localu2.jKS())
        {
          Log.d("MicroMsg.ConfigListDecoder", "bugfix");
          paramc.a(localu1, localu2);
        }
      }
    }
    this.XMs.Td();
    this.XMt.init();
    AppMethodBeat.o(132991);
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.a
 * JD-Core Version:    0.7.0.1
 */