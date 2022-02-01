package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ab;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;

public final class n
  implements ax
{
  public static final a ajjK;
  private final kotlin.l.b.a.b.b.ae aiEx;
  private final al aiUL;
  public final Set<ad> ajjL;
  private final j ajjM;
  private final long value;
  
  static
  {
    AppMethodBeat.i(60083);
    ajjK = new a((byte)0);
    AppMethodBeat.o(60083);
  }
  
  private n(long paramLong, kotlin.l.b.a.b.b.ae paramae, Set<? extends ad> paramSet)
  {
    AppMethodBeat.i(60088);
    g.a locala = kotlin.l.b.a.b.b.a.g.aiIh;
    this.aiUL = kotlin.l.b.a.b.m.ae.a(g.a.kpB(), this);
    this.ajjM = k.cm((a)new b(this));
    this.value = paramLong;
    this.aiEx = paramae;
    this.ajjL = paramSet;
    AppMethodBeat.o(60088);
  }
  
  public final ax c(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(192256);
    s.u(paramg, "kotlinTypeRefiner");
    paramg = (ax)this;
    AppMethodBeat.o(192256);
    return paramg;
  }
  
  public final List<ba> klq()
  {
    return (List)ab.aivy;
  }
  
  public final kotlin.l.b.a.b.b.h knA()
  {
    return null;
  }
  
  public final boolean knx()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.a.h koV()
  {
    AppMethodBeat.i(60085);
    kotlin.l.b.a.b.a.h localh = this.aiEx.koV();
    AppMethodBeat.o(60085);
    return localh;
  }
  
  public final Collection<ad> kpG()
  {
    AppMethodBeat.i(60084);
    Collection localCollection = (Collection)this.ajjM.getValue();
    AppMethodBeat.o(60084);
    return localCollection;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60086);
    String str = s.X("IntegerLiteralType", "[" + kotlin.a.p.a((Iterable)this.ajjL, (CharSequence)",", null, null, 0, null, (b)n.c.ajjR, 30) + ']');
    AppMethodBeat.o(60086);
    return str;
  }
  
  public static final class a
  {
    public static al P(Collection<? extends al> paramCollection)
    {
      AppMethodBeat.i(60078);
      s.u(paramCollection, "types");
      n.a.a locala = n.a.a.ajjO;
      if (paramCollection.isEmpty())
      {
        AppMethodBeat.o(60078);
        return null;
      }
      Iterator localIterator = ((Iterable)paramCollection).iterator();
      if (!localIterator.hasNext())
      {
        paramCollection = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
        AppMethodBeat.o(60078);
        throw paramCollection;
      }
      paramCollection = localIterator.next();
      while (localIterator.hasNext())
      {
        Object localObject1 = (al)localIterator.next();
        paramCollection = (al)paramCollection;
        Object localObject2 = n.ajjK;
        if ((paramCollection == null) || (localObject1 == null))
        {
          paramCollection = null;
        }
        else
        {
          Object localObject3 = paramCollection.kzm();
          localObject2 = ((al)localObject1).kzm();
          if (((localObject3 instanceof n)) && ((localObject2 instanceof n)))
          {
            localObject1 = (n)localObject3;
            localObject2 = (n)localObject2;
            switch (n.a.b.$EnumSwitchMapping$0[locala.ordinal()])
            {
            default: 
              paramCollection = new kotlin.p();
              AppMethodBeat.o(60078);
              throw paramCollection;
            case 1: 
              paramCollection = (Iterable)((n)localObject1).ajjL;
              localObject2 = (Iterable)((n)localObject2).ajjL;
              s.u(paramCollection, "$this$intersect");
              s.u(localObject2, "other");
              paramCollection = kotlin.a.p.u(paramCollection);
              localObject3 = (Collection)paramCollection;
              s.u(localObject3, "$this$retainAll");
              s.u(localObject2, "elements");
              localObject2 = kotlin.a.p.a((Iterable)localObject2, (Iterable)localObject3);
              an.hA(localObject3).retainAll((Collection)localObject2);
            }
            for (;;)
            {
              paramCollection = new n(n.a((n)localObject1), n.b((n)localObject1), paramCollection, (byte)0);
              localObject1 = kotlin.l.b.a.b.b.a.g.aiIh;
              paramCollection = kotlin.l.b.a.b.m.ae.a(g.a.kpB(), paramCollection);
              break;
              paramCollection = kotlin.a.p.b((Iterable)((n)localObject1).ajjL, (Iterable)((n)localObject2).ajjL);
            }
          }
          if ((localObject3 instanceof n)) {
            paramCollection = a((n)localObject3, (al)localObject1);
          } else if ((localObject2 instanceof n)) {
            paramCollection = a((n)localObject2, paramCollection);
          } else {
            paramCollection = null;
          }
        }
      }
      paramCollection = (al)paramCollection;
      AppMethodBeat.o(60078);
      return paramCollection;
    }
    
    private static al a(n paramn, al paramal)
    {
      AppMethodBeat.i(60079);
      if (paramn.ajjL.contains(paramal))
      {
        AppMethodBeat.o(60079);
        return paramal;
      }
      AppMethodBeat.o(60079);
      return null;
    }
  }
  
  static final class b
    extends u
    implements a<List<al>>
  {
    b(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.n
 * JD-Core Version:    0.7.0.1
 */