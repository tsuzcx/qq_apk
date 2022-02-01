package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.n.d;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;

public final class a
  implements c, com.tencent.mm.plugin.zero.b.a
{
  private f QQM;
  private d QQN;
  
  public a()
  {
    AppMethodBeat.i(132988);
    this.QQM = new f();
    this.QQN = new d();
    AppMethodBeat.o(132988);
  }
  
  public final f axc()
  {
    AppMethodBeat.i(132989);
    h.aHH();
    h.aHE().aGH();
    f localf = this.QQM;
    AppMethodBeat.o(132989);
    return localf;
  }
  
  public final d axd()
  {
    AppMethodBeat.i(132990);
    h.aHH();
    h.aHE().aGH();
    d locald = this.QQN;
    AppMethodBeat.o(132990);
    return locald;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(132991);
    if (paramc.kcX)
    {
      paramc = this.QQN;
      q localq1 = new q(com.tencent.mm.loader.j.b.aSL() + "configlist/");
      if (localq1.ifE())
      {
        q localq2 = new q(d.jwu);
        if (!localq2.ifE())
        {
          Log.d("MicroMsg.ConfigListDecoder", "bugfix");
          paramc.a(localq1, localq2);
        }
      }
    }
    this.QQM.tA();
    this.QQN.init();
    AppMethodBeat.o(132991);
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.a
 * JD-Core Version:    0.7.0.1
 */