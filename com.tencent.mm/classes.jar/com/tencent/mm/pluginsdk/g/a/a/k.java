package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.f;
import com.tencent.mm.pluginsdk.g.a.c.f.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.c.u;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

final class k
  extends f<a>
{
  private final f<a>.a vNQ;
  
  k()
  {
    AppMethodBeat.i(79546);
    this.vNQ = new f.a(this, 0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new u());
    AppMethodBeat.o(79546);
  }
  
  static void g(s params)
  {
    AppMethodBeat.i(79547);
    new k.a(a.a(params)).run();
    AppMethodBeat.o(79547);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(79548);
    if (alN(parama.vMK))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.vMK });
      AppMethodBeat.o(79548);
      return;
    }
    if (((parama.vML) && (parama.coK == parama.vMO) && (parama.vMO >= 0)) || ((!parama.vML) && (parama.vMM))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(79548);
      return;
    }
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.vMK });
    super.b(parama);
    AppMethodBeat.o(79548);
  }
  
  public final f<a>.a dml()
  {
    return this.vNQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.k
 * JD-Core Version:    0.7.0.1
 */