package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.b.x.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.be;
import kotlin.l.o;

public final class ai
  extends p
  implements ah
{
  public static final a aiLX;
  final m aiBu;
  final az aiLY;
  private final i aiLZ;
  private d aiMa;
  
  static
  {
    AppMethodBeat.i(57298);
    aYe = new o[] { (o)kotlin.g.b.ai.a((af)new ag((kotlin.l.e)kotlin.g.b.ai.cz(ai.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;")) };
    aiLX = new a((byte)0);
    AppMethodBeat.o(57298);
  }
  
  private ai(m paramm, az paramaz, final d paramd, ah paramah, g paramg, b.a parama, av paramav)
  {
    super((l)paramaz, (x)paramah, paramg, f.bJg("<init>"), parama, paramav);
    AppMethodBeat.i(57316);
    this.aiBu = paramm;
    this.aiLY = paramaz;
    Pk(this.aiLY.knj());
    this.aiLZ = this.aiBu.cr((a)new b(this, paramd));
    this.aiMa = paramd;
    AppMethodBeat.o(57316);
  }
  
  private ah d(l paraml, ab paramab, t paramt, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(191888);
    s.u(paraml, "newOwner");
    s.u(paramab, "modality");
    s.u(paramt, "visibility");
    s.u(parama, "kind");
    paraml = koO().h(paraml).a(paramab).d(paramt).a(parama).Pj(paramBoolean).koU();
    if (paraml == null)
    {
      paraml = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
      AppMethodBeat.o(191888);
      throw paraml;
    }
    paraml = (ah)paraml;
    AppMethodBeat.o(191888);
    return paraml;
  }
  
  private ah i(be parambe)
  {
    AppMethodBeat.i(57308);
    s.u(parambe, "substitutor");
    parambe = super.c(parambe);
    if (parambe == null)
    {
      parambe = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
      AppMethodBeat.o(57308);
      throw parambe;
    }
    parambe = (ai)parambe;
    Object localObject = be.aq(parambe.kob());
    s.s(localObject, "create(substitutedTypeAliasConstructor.returnType)");
    localObject = this.aiMa.kos().a((be)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(57308);
      return null;
    }
    parambe.aiMa = ((d)localObject);
    parambe = (ah)parambe;
    AppMethodBeat.o(57308);
    return parambe;
  }
  
  public final boolean koA()
  {
    AppMethodBeat.i(57299);
    boolean bool = this.aiMa.koA();
    AppMethodBeat.o(57299);
    return bool;
  }
  
  public final ad kob()
  {
    AppMethodBeat.i(57301);
    ad localad = super.kob();
    s.checkNotNull(localad);
    s.s(localad, "super.getReturnType()!!");
    AppMethodBeat.o(57301);
    return localad;
  }
  
  public final kotlin.l.b.a.b.b.e koz()
  {
    AppMethodBeat.i(57300);
    kotlin.l.b.a.b.b.e locale = this.aiMa.koz();
    s.s(locale, "underlyingConstructorDescriptor.constructedClass");
    AppMethodBeat.o(57300);
    return locale;
  }
  
  public final d kqj()
  {
    return this.aiMa;
  }
  
  public static final class a
  {
    static be a(az paramaz)
    {
      AppMethodBeat.i(57296);
      if (paramaz.kpn() == null)
      {
        AppMethodBeat.o(57296);
        return null;
      }
      paramaz = be.aq((ad)paramaz.kpm());
      AppMethodBeat.o(57296);
      return paramaz;
    }
  }
  
  static final class b
    extends u
    implements a<ai>
  {
    b(ai paramai, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ai
 * JD-Core Version:    0.7.0.1
 */