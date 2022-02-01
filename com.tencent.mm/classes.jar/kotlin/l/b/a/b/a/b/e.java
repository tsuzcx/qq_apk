package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.ab;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.b.c;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.n;

public final class e
  extends g
{
  public y aaJh;
  public boolean aaJi;
  private final f aaJj;
  
  static
  {
    AppMethodBeat.i(56785);
    cMt = new n[] { (n)ab.a(new z(ab.bO(e.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;")) };
    AppMethodBeat.o(56785);
  }
  
  public e(final j paramj, a parama)
  {
    super(paramj);
    AppMethodBeat.i(56790);
    this.aaJi = true;
    this.aaJj = paramj.av((kotlin.g.a.a)new b(this, paramj));
    switch (f.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(56790);
      return;
      AppMethodBeat.o(56790);
      return;
      iDo();
      AppMethodBeat.o(56790);
      return;
      iDo();
    }
  }
  
  public final kotlin.l.b.a.b.b.b.a iDp()
  {
    AppMethodBeat.i(56788);
    kotlin.l.b.a.b.b.b.a locala = (kotlin.l.b.a.b.b.b.a)iEt();
    AppMethodBeat.o(56788);
    return locala;
  }
  
  public final c iDq()
  {
    AppMethodBeat.i(56787);
    c localc = (c)iEt();
    AppMethodBeat.o(56787);
    return localc;
  }
  
  public final h iEt()
  {
    AppMethodBeat.i(56786);
    h localh = (h)i.a(this.aaJj, cMt[0]);
    AppMethodBeat.o(56786);
    return localh;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56778);
      a locala1 = new a("FROM_DEPENDENCIES", 0);
      aaJk = locala1;
      a locala2 = new a("FROM_CLASS_LOADER", 1);
      aaJl = locala2;
      a locala3 = new a("FALLBACK", 2);
      aaJm = locala3;
      aaJn = new a[] { locala1, locala2, locala3 };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */