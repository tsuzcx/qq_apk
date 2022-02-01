package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.g.b.z;
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
import kotlin.l.n;

public final class ah
  extends p
  implements ag
{
  public static final a aaPi;
  final j aaFH;
  private final kotlin.l.b.a.b.l.g aaPf;
  private d aaPg;
  final ar aaPh;
  
  static
  {
    AppMethodBeat.i(57298);
    cMt = new n[] { (n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(ah.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;")) };
    aaPi = new a((byte)0);
    AppMethodBeat.o(57298);
  }
  
  private ah(j paramj, ar paramar, final d paramd, ag paramag, kotlin.l.b.a.b.b.a.g paramg, b.a parama, an paraman)
  {
    super((l)paramar, (kotlin.l.b.a.b.b.t)paramag, paramg, f.bHd("<init>"), parama, paraman);
    AppMethodBeat.i(57316);
    this.aaFH = paramj;
    this.aaPh = paramar;
    Jh(this.aaPh.iDW());
    this.aaPf = this.aaFH.aw((a)new b(this, paramd));
    this.aaPg = paramd;
    AppMethodBeat.o(57316);
  }
  
  private ag d(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57312);
    kotlin.g.b.p.k(paraml, "newOwner");
    kotlin.g.b.p.k(paramw, "modality");
    kotlin.g.b.p.k(paramba, "visibility");
    kotlin.g.b.p.k(parama, "kind");
    paraml = iFo().h(paraml).a(paramw).a(paramba).a(parama).Jg(paramBoolean).iFu();
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
  
  private ag i(kotlin.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57308);
    kotlin.g.b.p.k(paramba, "substitutor");
    paramba = super.c(paramba);
    if (paramba == null)
    {
      paramba = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
      AppMethodBeat.o(57308);
      throw paramba;
    }
    paramba = (ah)paramba;
    Object localObject = kotlin.l.b.a.b.m.ba.az(paramba.iEH());
    kotlin.g.b.p.j(localObject, "TypeSubstitutor.create(s…asConstructor.returnType)");
    localObject = this.aaPg.iEY().a((kotlin.l.b.a.b.m.ba)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(57308);
      return null;
    }
    paramba.aaPg = ((d)localObject);
    paramba = (ag)paramba;
    AppMethodBeat.o(57308);
    return paramba;
  }
  
  private ag iGM()
  {
    AppMethodBeat.i(57302);
    Object localObject = super.iFh();
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
  
  public final kotlin.l.b.a.b.m.ab iEH()
  {
    AppMethodBeat.i(57301);
    kotlin.l.b.a.b.m.ab localab = super.iEH();
    if (localab == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(57301);
    return localab;
  }
  
  public final e iFf()
  {
    AppMethodBeat.i(57300);
    e locale = this.aaPg.iFf();
    kotlin.g.b.p.j(locale, "underlyingConstructorDescriptor.constructedClass");
    AppMethodBeat.o(57300);
    return locale;
  }
  
  public final boolean iFg()
  {
    AppMethodBeat.i(57299);
    boolean bool = this.aaPg.iFg();
    AppMethodBeat.o(57299);
    return bool;
  }
  
  public final d iGL()
  {
    return this.aaPg;
  }
  
  public static final class a
  {
    static kotlin.l.b.a.b.m.ba a(ar paramar)
    {
      AppMethodBeat.i(57296);
      if (paramar.iFM() == null)
      {
        AppMethodBeat.o(57296);
        return null;
      }
      paramar = kotlin.l.b.a.b.m.ba.az((kotlin.l.b.a.b.m.ab)paramar.iFL());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ah
 * JD-Core Version:    0.7.0.1
 */