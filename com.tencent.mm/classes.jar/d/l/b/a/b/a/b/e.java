package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.l;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.b.c;
import d.l.b.a.b.b.y;
import d.l.b.a.b.l.f;
import d.l.b.a.b.l.i;
import d.l.k;

public final class e
  extends g
{
  public y LcF;
  public boolean LcG;
  private final f LcH;
  
  static
  {
    AppMethodBeat.i(56785);
    $$delegatedProperties = new k[] { (k)w.a(new u(w.bn(e.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;")) };
    AppMethodBeat.o(56785);
  }
  
  public e(final i parami, a parama)
  {
    super(parami);
    AppMethodBeat.i(56790);
    this.LcG = true;
    this.LcH = parami.O((d.g.a.a)new b(this, parami));
    switch (f.cfA[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(56790);
      return;
      AppMethodBeat.o(56790);
      return;
      fPz();
      AppMethodBeat.o(56790);
      return;
      fPz();
    }
  }
  
  public final d.l.b.a.b.b.b.a fPA()
  {
    AppMethodBeat.i(56788);
    d.l.b.a.b.b.b.a locala = (d.l.b.a.b.b.b.a)fQE();
    AppMethodBeat.o(56788);
    return locala;
  }
  
  public final c fPB()
  {
    AppMethodBeat.i(56787);
    c localc = (c)fQE();
    AppMethodBeat.o(56787);
    return localc;
  }
  
  public final h fQE()
  {
    AppMethodBeat.i(56786);
    h localh = (h)d.l.b.a.b.l.h.a(this.LcH, $$delegatedProperties[0]);
    AppMethodBeat.o(56786);
    return localh;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56778);
      a locala1 = new a("FROM_DEPENDENCIES", 0);
      LcI = locala1;
      a locala2 = new a("FROM_CLASS_LOADER", 1);
      LcJ = locala2;
      a locala3 = new a("FALLBACK", 2);
      LcK = locala3;
      LcL = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(56778);
    }
    
    private a() {}
  }
  
  static final class b
    extends l
    implements d.g.a.a<h>
  {
    b(e parame, i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */