package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.aa;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t.a;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.k;

public final class ah
  extends p
  implements ag
{
  public static final a Tmo;
  final j TcN;
  private final kotlin.l.b.a.b.l.g Tml;
  private d Tmm;
  final ar Tmn;
  
  static
  {
    AppMethodBeat.i(57298);
    cLI = new k[] { (k)aa.a(new y(aa.bp(ah.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;")) };
    Tmo = new a((byte)0);
    AppMethodBeat.o(57298);
  }
  
  private ah(j paramj, ar paramar, final d paramd, ag paramag, kotlin.l.b.a.b.b.a.g paramg, b.a parama, an paraman)
  {
    super((l)paramar, (kotlin.l.b.a.b.b.t)paramag, paramg, f.bua("<init>"), parama, paraman);
    AppMethodBeat.i(57316);
    this.TcN = paramj;
    this.Tmn = paramar;
    this.TkR = this.Tmn.hzK();
    this.Tml = this.TcN.am((a)new b(this, paramd));
    this.Tmm = paramd;
    AppMethodBeat.o(57316);
  }
  
  private ag d(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57312);
    kotlin.g.b.p.h(paraml, "newOwner");
    kotlin.g.b.p.h(paramw, "modality");
    kotlin.g.b.p.h(paramba, "visibility");
    kotlin.g.b.p.h(parama, "kind");
    paraml = hBa().h(paraml).a(paramw).a(paramba).a(parama).EB(paramBoolean).hBg();
    if (paraml == null)
    {
      paraml = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
      AppMethodBeat.o(57312);
      throw paraml;
    }
    paraml = (ag)paraml;
    AppMethodBeat.o(57312);
    return paraml;
  }
  
  private ag hCw()
  {
    AppMethodBeat.i(57302);
    Object localObject = super.hAT();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
      AppMethodBeat.o(57302);
      throw ((Throwable)localObject);
    }
    localObject = (ag)localObject;
    AppMethodBeat.o(57302);
    return localObject;
  }
  
  private ag i(kotlin.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57308);
    kotlin.g.b.p.h(paramba, "substitutor");
    paramba = super.c(paramba);
    if (paramba == null)
    {
      paramba = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
      AppMethodBeat.o(57308);
      throw paramba;
    }
    paramba = (ah)paramba;
    Object localObject = kotlin.l.b.a.b.m.ba.az(paramba.hAu());
    kotlin.g.b.p.g(localObject, "TypeSubstitutor.create(s…asConstructor.returnType)");
    localObject = this.Tmm.hAL().a((kotlin.l.b.a.b.m.ba)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(57308);
      return null;
    }
    paramba.Tmm = ((d)localObject);
    paramba = (ag)paramba;
    AppMethodBeat.o(57308);
    return paramba;
  }
  
  public final e hAS()
  {
    AppMethodBeat.i(57300);
    e locale = this.Tmm.hAS();
    kotlin.g.b.p.g(locale, "underlyingConstructorDescriptor.constructedClass");
    AppMethodBeat.o(57300);
    return locale;
  }
  
  public final ab hAu()
  {
    AppMethodBeat.i(57301);
    ab localab = super.hAu();
    if (localab == null) {
      kotlin.g.b.p.hyc();
    }
    AppMethodBeat.o(57301);
    return localab;
  }
  
  public final d hCv()
  {
    return this.Tmm;
  }
  
  public final boolean isPrimary()
  {
    AppMethodBeat.i(57299);
    boolean bool = this.Tmm.isPrimary();
    AppMethodBeat.o(57299);
    return bool;
  }
  
  public static final class a
  {
    static kotlin.l.b.a.b.m.ba a(ar paramar)
    {
      AppMethodBeat.i(57296);
      if (paramar.hBx() == null)
      {
        AppMethodBeat.o(57296);
        return null;
      }
      paramar = kotlin.l.b.a.b.m.ba.az((ab)paramar.hBw());
      AppMethodBeat.o(57296);
      return paramar;
    }
  }
  
  static final class b
    extends q
    implements a<ah>
  {
    b(ah paramah, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ah
 * JD-Core Version:    0.7.0.1
 */