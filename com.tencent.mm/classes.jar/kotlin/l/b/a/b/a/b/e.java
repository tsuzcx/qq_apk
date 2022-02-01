package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.b.c;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.k;

public final class e
  extends g
{
  public kotlin.l.b.a.b.b.y Tgn;
  public boolean Tgo;
  private final f Tgp;
  
  static
  {
    AppMethodBeat.i(56785);
    cLI = new k[] { (k)aa.a(new kotlin.g.b.y(aa.bp(e.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;")) };
    AppMethodBeat.o(56785);
  }
  
  public e(final j paramj, a parama)
  {
    super(paramj);
    AppMethodBeat.i(56790);
    this.Tgo = true;
    this.Tgp = paramj.al((kotlin.g.a.a)new b(this, paramj));
    switch (f.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(56790);
      return;
      AppMethodBeat.o(56790);
      return;
      hzc();
      AppMethodBeat.o(56790);
      return;
      hzc();
    }
  }
  
  public final h hAg()
  {
    AppMethodBeat.i(56786);
    h localh = (h)i.a(this.Tgp, cLI[0]);
    AppMethodBeat.o(56786);
    return localh;
  }
  
  public final kotlin.l.b.a.b.b.b.a hzd()
  {
    AppMethodBeat.i(56788);
    kotlin.l.b.a.b.b.b.a locala = (kotlin.l.b.a.b.b.b.a)hAg();
    AppMethodBeat.o(56788);
    return locala;
  }
  
  public final c hze()
  {
    AppMethodBeat.i(56787);
    c localc = (c)hAg();
    AppMethodBeat.o(56787);
    return localc;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56778);
      a locala1 = new a("FROM_DEPENDENCIES", 0);
      Tgq = locala1;
      a locala2 = new a("FROM_CLASS_LOADER", 1);
      Tgr = locala2;
      a locala3 = new a("FALLBACK", 2);
      Tgs = locala3;
      Tgt = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(56778);
    }
    
    private a() {}
  }
  
  static final class b
    extends q
    implements kotlin.g.a.a<h>
  {
    b(e parame, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */