package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.b.c;
import kotlin.l.b.a.b.l.l;
import kotlin.l.b.a.b.l.m;
import kotlin.l.e;
import kotlin.l.o;

public final class f
  extends kotlin.l.b.a.b.a.h
{
  private final a aiFA;
  public kotlin.g.a.a<b> aiFB;
  private final kotlin.l.b.a.b.l.h aiFC;
  
  static
  {
    AppMethodBeat.i(56785);
    aYe = new o[] { (o)ai.a((af)new ag((e)ai.cz(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;")) };
    AppMethodBeat.o(56785);
  }
  
  public f(final m paramm, a parama)
  {
    super(paramm);
    AppMethodBeat.i(56790);
    this.aiFA = parama;
    this.aiFC = paramm.cq((kotlin.g.a.a)new d(this, paramm));
    paramm = this.aiFA;
    switch (c.$EnumSwitchMapping$0[paramm.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(56790);
      return;
      AppMethodBeat.o(56790);
      return;
      kmI();
      AppMethodBeat.o(56790);
      return;
      kmI();
    }
  }
  
  public final kotlin.l.b.a.b.b.b.a kmJ()
  {
    AppMethodBeat.i(56788);
    kotlin.l.b.a.b.b.b.a locala = (kotlin.l.b.a.b.b.b.a)knL();
    AppMethodBeat.o(56788);
    return locala;
  }
  
  public final c kmK()
  {
    AppMethodBeat.i(56787);
    c localc = (c)knL();
    AppMethodBeat.o(56787);
    return localc;
  }
  
  public final g knL()
  {
    AppMethodBeat.i(191468);
    g localg = (g)l.a(this.aiFC, aYe[0]);
    AppMethodBeat.o(191468);
    return localg;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56778);
      aiFD = new a("FROM_DEPENDENCIES", 0);
      aiFE = new a("FROM_CLASS_LOADER", 1);
      aiFF = new a("FALLBACK", 2);
      aiFG = new a[] { aiFD, aiFE, aiFF };
      AppMethodBeat.o(56778);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    final ae aiFH;
    final boolean aiFI;
    
    public b(ae paramae, boolean paramBoolean)
    {
      AppMethodBeat.i(191469);
      this.aiFH = paramae;
      this.aiFI = paramBoolean;
      AppMethodBeat.o(191469);
    }
  }
  
  static final class d
    extends u
    implements kotlin.g.a.a<g>
  {
    d(f paramf, m paramm)
    {
      super();
    }
  }
  
  public static final class e
    extends u
    implements kotlin.g.a.a<f.b>
  {
    public e(ae paramae)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.f
 * JD-Core Version:    0.7.0.1
 */