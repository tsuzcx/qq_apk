package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.d;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;

public final class a
  implements c, com.tencent.mm.plugin.zero.b.a
{
  private f JRJ;
  private d JRK;
  
  public a()
  {
    AppMethodBeat.i(132988);
    this.JRJ = new f();
    this.JRK = new d();
    AppMethodBeat.o(132988);
  }
  
  public final f aqJ()
  {
    AppMethodBeat.i(132989);
    g.aAi();
    g.aAf().azk();
    f localf = this.JRJ;
    AppMethodBeat.o(132989);
    return localf;
  }
  
  public final d aqK()
  {
    AppMethodBeat.i(132990);
    g.aAi();
    g.aAf().azk();
    d locald = this.JRK;
    AppMethodBeat.o(132990);
    return locald;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(132991);
    if (paramc.hrc)
    {
      paramc = this.JRK;
      o localo1 = new o(b.aKJ() + "configlist/");
      if (localo1.exists())
      {
        o localo2 = new o(d.gMf);
        if (!localo2.exists())
        {
          Log.d("MicroMsg.ConfigListDecoder", "bugfix");
          paramc.a(localo1, localo2);
        }
      }
    }
    this.JRJ.vC();
    this.JRK.init();
    AppMethodBeat.o(132991);
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.a
 * JD-Core Version:    0.7.0.1
 */