package d.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.aa;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.i.c;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ai;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.d.a;
import d.n.n;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class g
  extends d.l.b.a.b.m.v
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
      paramBoolean = d.l.b.a.b.m.a.g.LMg.c((ab)paramaj1, (ab)paramaj2);
      if ((aa.KTq) && (!paramBoolean))
      {
        paramaj1 = (Throwable)new AssertionError("Lower bound " + paramaj1 + " of a flexible type must be a subtype of the upper bound " + paramaj2);
        AppMethodBeat.o(58006);
        throw paramaj1;
      }
    }
    AppMethodBeat.o(58006);
  }
  
  private d.l.b.a.b.m.v c(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(58003);
    k.h(parami, "kotlinTypeRefiner");
    Object localObject = parami.aL((ab)this.LLa);
    if (localObject == null)
    {
      parami = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(58003);
      throw parami;
    }
    localObject = (aj)localObject;
    parami = parami.aL((ab)this.LLb);
    if (parami == null)
    {
      parami = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(58003);
      throw parami;
    }
    parami = (d.l.b.a.b.m.v)new g((aj)localObject, (aj)parami, true);
    AppMethodBeat.o(58003);
    return parami;
  }
  
  public final String a(c paramc, d.l.b.a.b.i.i parami)
  {
    int i = 0;
    AppMethodBeat.i(58002);
    k.h(paramc, "renderer");
    k.h(parami, "options");
    Object localObject1 = a.LpQ;
    Object localObject2 = new b(paramc);
    localObject1 = c.LpS;
    String str = paramc.b((ab)this.LLa);
    localObject1 = paramc.b((ab)this.LLb);
    if (parami.gaS())
    {
      paramc = "raw (" + str + ".." + (String)localObject1 + ')';
      AppMethodBeat.o(58002);
      return paramc;
    }
    if (this.LLb.gbw().isEmpty())
    {
      paramc = paramc.a(str, (String)localObject1, a.aN(this));
      AppMethodBeat.o(58002);
      return paramc;
    }
    parami = ((b)localObject2).Q((ab)this.LLa);
    Object localObject3 = ((b)localObject2).Q((ab)this.LLb);
    localObject2 = j.a((Iterable)parami, (CharSequence)", ", null, null, 0, null, (b)g.d.LpT, 30);
    parami = (Iterable)j.b((Iterable)parami, (Iterable)localObject3);
    if (!((Collection)parami).isEmpty())
    {
      parami = parami.iterator();
      while (parami.hasNext())
      {
        localObject3 = (o)parami.next();
        a locala = a.LpQ;
        if (!a.mT((String)((o)localObject3).first, (String)((o)localObject3).second)) {
          if (i == 0) {
            break label327;
          }
        }
      }
    }
    label327:
    for (parami = c.mU((String)localObject1, (String)localObject2);; parami = (d.l.b.a.b.i.i)localObject1)
    {
      localObject1 = c.mU(str, (String)localObject2);
      if (!k.g(localObject1, parami)) {
        break label333;
      }
      AppMethodBeat.o(58002);
      return localObject1;
      i = 1;
      break;
    }
    label333:
    paramc = paramc.a((String)localObject1, parami, a.aN(this));
    AppMethodBeat.o(58002);
    return paramc;
  }
  
  public final d.l.b.a.b.j.f.h fQN()
  {
    AppMethodBeat.i(57999);
    d.l.b.a.b.b.h localh = gbz().fQq();
    Object localObject = localh;
    if (!(localh instanceof d.l.b.a.b.b.e)) {
      localObject = null;
    }
    localObject = (d.l.b.a.b.b.e)localObject;
    if (localObject == null)
    {
      localObject = (Throwable)new IllegalStateException(("Incorrect classifier: " + gbz().fQq()).toString());
      AppMethodBeat.o(57999);
      throw ((Throwable)localObject);
    }
    localObject = ((d.l.b.a.b.b.e)localObject).a((ay)e.LpM);
    k.g(localObject, "classDescriptor.getMemberScope(RawSubstitution)");
    AppMethodBeat.o(57999);
    return localObject;
  }
  
  public final aj fUt()
  {
    return this.LLa;
  }
  
  static final class a
    extends l
    implements m<String, String, Boolean>
  {
    public static final a LpQ;
    
    static
    {
      AppMethodBeat.i(57991);
      LpQ = new a();
      AppMethodBeat.o(57991);
    }
    
    a()
    {
      super();
    }
    
    public static boolean mT(String paramString1, String paramString2)
    {
      AppMethodBeat.i(57990);
      k.h(paramString1, "first");
      k.h(paramString2, "second");
      if ((k.g(paramString1, n.b(paramString2, (CharSequence)"out "))) || (k.g(paramString2, "*")))
      {
        AppMethodBeat.o(57990);
        return true;
      }
      AppMethodBeat.o(57990);
      return false;
    }
  }
  
  static final class b
    extends l
    implements b<ab, List<? extends String>>
  {
    b(c paramc)
    {
      super();
    }
    
    public final List<String> Q(ab paramab)
    {
      AppMethodBeat.i(57993);
      k.h(paramab, "type");
      Object localObject = (Iterable)paramab.gbw();
      paramab = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        av localav = (av)((Iterator)localObject).next();
        paramab.add(this.LpR.a(localav));
      }
      paramab = (List)paramab;
      AppMethodBeat.o(57993);
      return paramab;
    }
  }
  
  static final class c
    extends l
    implements m<String, String, String>
  {
    public static final c LpS;
    
    static
    {
      AppMethodBeat.i(57996);
      LpS = new c();
      AppMethodBeat.o(57996);
    }
    
    c()
    {
      super();
    }
    
    public static String mU(String paramString1, String paramString2)
    {
      AppMethodBeat.i(57995);
      k.h(paramString1, "$this$replaceArgs");
      k.h(paramString2, "newArgs");
      if (!n.c((CharSequence)paramString1, '<'))
      {
        AppMethodBeat.o(57995);
        return paramString1;
      }
      paramString1 = n.a(paramString1, '<') + '<' + paramString2 + '>' + n.b(paramString1, '>');
      AppMethodBeat.o(57995);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.b.g
 * JD-Core Version:    0.7.0.1
 */