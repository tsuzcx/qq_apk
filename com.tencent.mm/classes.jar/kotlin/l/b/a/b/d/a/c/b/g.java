package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ai;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.v;
import kotlin.o;
import kotlin.t;

public final class g
  extends v
  implements ai
{
  public g(aj paramaj1, aj paramaj2)
  {
    this(paramaj1, paramaj2, false);
    AppMethodBeat.i(58007);
    AppMethodBeat.o(58007);
  }
  
  private g(aj paramaj1, aj paramaj2, boolean paramBoolean)
  {
    super(paramaj1, paramaj2);
    AppMethodBeat.i(58006);
    if (!paramBoolean)
    {
      paramBoolean = kotlin.l.b.a.b.m.a.g.TPc.c((ab)paramaj1, (ab)paramaj2);
      if ((aa.SXc) && (!paramBoolean))
      {
        paramaj1 = (Throwable)new AssertionError("Lower bound " + paramaj1 + " of a flexible type must be a subtype of the upper bound " + paramaj2);
        AppMethodBeat.o(58006);
        throw paramaj1;
      }
    }
    AppMethodBeat.o(58006);
  }
  
  private v c(kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(58003);
    p.h(parami, "kotlinTypeRefiner");
    Object localObject = parami.aK((ab)this.TNV);
    if (localObject == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(58003);
      throw parami;
    }
    localObject = (aj)localObject;
    parami = parami.aK((ab)this.TNW);
    if (parami == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(58003);
      throw parami;
    }
    parami = (v)new g((aj)localObject, (aj)parami, true);
    AppMethodBeat.o(58003);
    return parami;
  }
  
  public final String a(c paramc, kotlin.l.b.a.b.i.i parami)
  {
    int i = 0;
    AppMethodBeat.i(58002);
    p.h(paramc, "renderer");
    p.h(parami, "options");
    Object localObject1 = g.a.Ttz;
    Object localObject2 = new b(paramc);
    localObject1 = g.c.TtB;
    String str = paramc.b((ab)this.TNV);
    localObject1 = paramc.b((ab)this.TNW);
    if (parami.hJW())
    {
      paramc = "raw (" + str + ".." + (String)localObject1 + ')';
      AppMethodBeat.o(58002);
      return paramc;
    }
    if (this.TNW.hKB().isEmpty())
    {
      paramc = paramc.a(str, (String)localObject1, a.aM(this));
      AppMethodBeat.o(58002);
      return paramc;
    }
    parami = ((b)localObject2).P((ab)this.TNV);
    Object localObject3 = ((b)localObject2).P((ab)this.TNW);
    localObject2 = j.a((Iterable)parami, (CharSequence)", ", null, null, 0, null, (b)g.d.TtC, 30);
    parami = (Iterable)j.c((Iterable)parami, (Iterable)localObject3);
    if (!((Collection)parami).isEmpty())
    {
      parami = parami.iterator();
      while (parami.hasNext())
      {
        localObject3 = (o)parami.next();
        g.a locala = g.a.Ttz;
        if (!g.a.or((String)((o)localObject3).first, (String)((o)localObject3).second)) {
          if (i == 0) {
            break label327;
          }
        }
      }
    }
    label327:
    for (parami = g.c.os((String)localObject1, (String)localObject2);; parami = (kotlin.l.b.a.b.i.i)localObject1)
    {
      localObject1 = g.c.os(str, (String)localObject2);
      if (!p.j(localObject1, parami)) {
        break label333;
      }
      AppMethodBeat.o(58002);
      return localObject1;
      i = 1;
      break;
    }
    label333:
    paramc = paramc.a((String)localObject1, parami, a.aM(this));
    AppMethodBeat.o(58002);
    return paramc;
  }
  
  public final kotlin.l.b.a.b.j.f.h hAp()
  {
    AppMethodBeat.i(57999);
    kotlin.l.b.a.b.b.h localh = hKE().hzS();
    Object localObject = localh;
    if (!(localh instanceof kotlin.l.b.a.b.b.e)) {
      localObject = null;
    }
    localObject = (kotlin.l.b.a.b.b.e)localObject;
    if (localObject == null)
    {
      localObject = (Throwable)new IllegalStateException(("Incorrect classifier: " + hKE().hzS()).toString());
      AppMethodBeat.o(57999);
      throw ((Throwable)localObject);
    }
    localObject = ((kotlin.l.b.a.b.b.e)localObject).a((ay)e.Ttv);
    p.g(localObject, "classDescriptor.getMemberScope(RawSubstitution)");
    AppMethodBeat.o(57999);
    return localObject;
  }
  
  public final aj hDW()
  {
    return this.TNV;
  }
  
  static final class b
    extends q
    implements b<ab, List<? extends String>>
  {
    b(c paramc)
    {
      super();
    }
    
    public final List<String> P(ab paramab)
    {
      AppMethodBeat.i(57993);
      p.h(paramab, "type");
      Object localObject = (Iterable)paramab.hKB();
      paramab = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        av localav = (av)((Iterator)localObject).next();
        paramab.add(this.TtA.a(localav));
      }
      paramab = (List)paramab;
      AppMethodBeat.o(57993);
      return paramab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.g
 * JD-Core Version:    0.7.0.1
 */