package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.d;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.t.a;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import d.l.b.a.b.l.j;
import d.l.b.a.b.m.ab;
import d.l.k;
import d.v;

public final class ah
  extends p
  implements ag
{
  public static final a MZA;
  final j MQa;
  private final d.l.b.a.b.l.g MZx;
  private d MZy;
  final ar MZz;
  
  static
  {
    AppMethodBeat.i(57298);
    cwV = new k[] { (k)z.a(new x(z.bp(ah.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;")) };
    MZA = new a((byte)0);
    AppMethodBeat.o(57298);
  }
  
  private ah(j paramj, ar paramar, final d paramd, ag paramag, d.l.b.a.b.b.a.g paramg, b.a parama, an paraman)
  {
    super((l)paramar, (t)paramag, paramg, f.bcG("<init>"), parama, paraman);
    AppMethodBeat.i(57316);
    this.MQa = paramj;
    this.MZz = paramar;
    this.MYd = this.MZz.ghF();
    this.MZx = this.MQa.T((a)new b(this, paramd));
    this.MZy = paramd;
    AppMethodBeat.o(57316);
  }
  
  private ag d(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57312);
    d.g.b.p.h(paraml, "newOwner");
    d.g.b.p.h(paramw, "modality");
    d.g.b.p.h(paramba, "visibility");
    d.g.b.p.h(parama, "kind");
    paraml = giW().h(paraml).a(paramw).a(paramba).a(parama).zX(paramBoolean).gjc();
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
  
  private ag gks()
  {
    AppMethodBeat.i(57302);
    Object localObject = super.giP();
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
    d.g.b.p.h(paramba, "substitutor");
    paramba = super.c(paramba);
    if (paramba == null)
    {
      paramba = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
      AppMethodBeat.o(57308);
      throw paramba;
    }
    paramba = (ah)paramba;
    Object localObject = d.l.b.a.b.m.ba.aA(paramba.giq());
    d.g.b.p.g(localObject, "TypeSubstitutor.create(s…asConstructor.returnType)");
    localObject = this.MZy.giH().a((d.l.b.a.b.m.ba)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(57308);
      return null;
    }
    paramba.MZy = ((d)localObject);
    paramba = (ag)paramba;
    AppMethodBeat.o(57308);
    return paramba;
  }
  
  public final e giO()
  {
    AppMethodBeat.i(57300);
    e locale = this.MZy.giO();
    d.g.b.p.g(locale, "underlyingConstructorDescriptor.constructedClass");
    AppMethodBeat.o(57300);
    return locale;
  }
  
  public final ab giq()
  {
    AppMethodBeat.i(57301);
    ab localab = super.giq();
    if (localab == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(57301);
    return localab;
  }
  
  public final d gkr()
  {
    return this.MZy;
  }
  
  public final boolean isPrimary()
  {
    AppMethodBeat.i(57299);
    boolean bool = this.MZy.isPrimary();
    AppMethodBeat.o(57299);
    return bool;
  }
  
  public static final class a
  {
    static d.l.b.a.b.m.ba a(ar paramar)
    {
      AppMethodBeat.i(57296);
      if (paramar.gjt() == null)
      {
        AppMethodBeat.o(57296);
        return null;
      }
      paramar = d.l.b.a.b.m.ba.aA((ab)paramar.gjs());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.ah
 * JD-Core Version:    0.7.0.1
 */