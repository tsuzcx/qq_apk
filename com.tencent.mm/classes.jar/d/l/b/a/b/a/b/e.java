package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.b.c;
import d.l.b.a.b.b.y;
import d.l.b.a.b.l.f;
import d.l.b.a.b.l.i;
import d.l.b.a.b.l.j;
import d.l.k;

public final class e
  extends g
{
  public y NqF;
  public boolean NqG;
  private final f NqH;
  
  static
  {
    AppMethodBeat.i(56785);
    cxA = new k[] { (k)z.a(new x(z.bp(e.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;")) };
    AppMethodBeat.o(56785);
  }
  
  public e(final j paramj, a parama)
  {
    super(paramj);
    AppMethodBeat.i(56790);
    this.NqG = true;
    this.NqH = paramj.S((d.g.a.a)new b(this, paramj));
    switch (f.cqt[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(56790);
      return;
      AppMethodBeat.o(56790);
      return;
      glz();
      AppMethodBeat.o(56790);
      return;
      glz();
    }
  }
  
  public final d.l.b.a.b.b.b.a glA()
  {
    AppMethodBeat.i(56788);
    d.l.b.a.b.b.b.a locala = (d.l.b.a.b.b.b.a)gmE();
    AppMethodBeat.o(56788);
    return locala;
  }
  
  public final c glB()
  {
    AppMethodBeat.i(56787);
    c localc = (c)gmE();
    AppMethodBeat.o(56787);
    return localc;
  }
  
  public final h gmE()
  {
    AppMethodBeat.i(56786);
    h localh = (h)i.a(this.NqH, cxA[0]);
    AppMethodBeat.o(56786);
    return localh;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56778);
      a locala1 = new a("FROM_DEPENDENCIES", 0);
      NqI = locala1;
      a locala2 = new a("FROM_CLASS_LOADER", 1);
      NqJ = locala2;
      a locala3 = new a("FALLBACK", 2);
      NqK = locala3;
      NqL = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(56778);
    }
    
    private a() {}
  }
  
  static final class b
    extends q
    implements d.g.a.a<h>
  {
    b(e parame, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */