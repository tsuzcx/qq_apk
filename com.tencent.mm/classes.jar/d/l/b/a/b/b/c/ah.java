package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.u;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.d;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.t.a;
import d.l.b.a.b.f.f;
import d.l.b.a.b.l.i;
import d.l.b.a.b.m.ab;
import d.v;

public final class ah
  extends p
  implements ag
{
  public static final a LiE;
  final i KZf;
  private final d.l.b.a.b.l.g LiB;
  private d LiC;
  final ar LiD;
  
  static
  {
    AppMethodBeat.i(57298);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(ah.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;")) };
    LiE = new a((byte)0);
    AppMethodBeat.o(57298);
  }
  
  private ah(i parami, ar paramar, final d paramd, ag paramag, d.l.b.a.b.b.a.g paramg, b.a parama, an paraman)
  {
    super((d.l.b.a.b.b.l)paramar, (t)paramag, paramg, f.aWD("<init>"), parama, paraman);
    AppMethodBeat.i(57316);
    this.KZf = parami;
    this.LiD = paramar;
    this.Lhh = this.LiD.fQh();
    this.LiB = this.KZf.P((a)new b(this, paramd));
    this.LiC = paramd;
    AppMethodBeat.o(57316);
  }
  
  private ag d(d.l.b.a.b.b.l paraml, d.l.b.a.b.b.w paramw, d.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57312);
    d.g.b.k.h(paraml, "newOwner");
    d.g.b.k.h(paramw, "modality");
    d.g.b.k.h(paramba, "visibility");
    d.g.b.k.h(parama, "kind");
    paraml = fRx().h(paraml).a(paramw).a(paramba).a(parama).zj(paramBoolean).fRD();
    if (paraml == null)
    {
      paraml = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
      AppMethodBeat.o(57312);
      throw paraml;
    }
    paraml = (ag)paraml;
    AppMethodBeat.o(57312);
    return paraml;
  }
  
  private ag fST()
  {
    AppMethodBeat.i(57302);
    Object localObject = super.fRq();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
      AppMethodBeat.o(57302);
      throw ((Throwable)localObject);
    }
    localObject = (ag)localObject;
    AppMethodBeat.o(57302);
    return localObject;
  }
  
  private ag i(d.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57308);
    d.g.b.k.h(paramba, "substitutor");
    paramba = super.c(paramba);
    if (paramba == null)
    {
      paramba = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
      AppMethodBeat.o(57308);
      throw paramba;
    }
    paramba = (ah)paramba;
    Object localObject = d.l.b.a.b.m.ba.aA(paramba.fQS());
    d.g.b.k.g(localObject, "TypeSubstitutor.create(s…asConstructor.returnType)");
    localObject = this.LiC.fRi().a((d.l.b.a.b.m.ba)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(57308);
      return null;
    }
    paramba.LiC = ((d)localObject);
    paramba = (ag)paramba;
    AppMethodBeat.o(57308);
    return paramba;
  }
  
  public final ab fQS()
  {
    AppMethodBeat.i(57301);
    ab localab = super.fQS();
    if (localab == null) {
      d.g.b.k.fOy();
    }
    AppMethodBeat.o(57301);
    return localab;
  }
  
  public final e fRp()
  {
    AppMethodBeat.i(57300);
    e locale = this.LiC.fRp();
    d.g.b.k.g(locale, "underlyingConstructorDescriptor.constructedClass");
    AppMethodBeat.o(57300);
    return locale;
  }
  
  public final d fSS()
  {
    return this.LiC;
  }
  
  public final boolean isPrimary()
  {
    AppMethodBeat.i(57299);
    boolean bool = this.LiC.isPrimary();
    AppMethodBeat.o(57299);
    return bool;
  }
  
  public static final class a
  {
    static d.l.b.a.b.m.ba a(ar paramar)
    {
      AppMethodBeat.i(57296);
      if (paramar.fRU() == null)
      {
        AppMethodBeat.o(57296);
        return null;
      }
      paramar = d.l.b.a.b.m.ba.aA((ab)paramar.fRT());
      AppMethodBeat.o(57296);
      return paramar;
    }
  }
  
  static final class b
    extends d.g.b.l
    implements a<ah>
  {
    b(ah paramah, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.ah
 * JD-Core Version:    0.7.0.1
 */