package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.j.a.a.d;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.m.au.a;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.e.a;
import kotlin.n.n;

public final class z
{
  public static final ab a(ab paramab1, ab paramab2, x paramx)
  {
    AppMethodBeat.i(61191);
    p.h(paramab1, "subtype");
    p.h(paramab2, "supertype");
    p.h(paramx, "typeCheckingProcedureCallbacks");
    Object localObject1 = new ArrayDeque();
    ((ArrayDeque)localObject1).add(new u(paramab1, null));
    at localat = paramab2.hKE();
    while (!((ArrayDeque)localObject1).isEmpty())
    {
      paramab2 = (u)((ArrayDeque)localObject1).poll();
      paramab1 = paramab2.Tbs;
      Object localObject2 = paramab1.hKE();
      if (paramx.b((at)localObject2, localat))
      {
        boolean bool = paramab1.hEa();
        paramab2 = paramab2.TPx;
        if (paramab2 != null)
        {
          localObject1 = paramab2.Tbs;
          localObject2 = (Iterable)((ab)localObject1).hKB();
          label155:
          int i;
          if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
          {
            localObject2 = ((Iterable)localObject2).iterator();
            if (((Iterator)localObject2).hasNext()) {
              if (((av)((Iterator)localObject2).next()).hLI() != bh.TOQ)
              {
                i = 1;
                label188:
                if (i == 0) {
                  break label258;
                }
                i = 1;
                label194:
                if (i == 0) {
                  break label265;
                }
                paramab1 = d.c(au.TOz.ax((ab)localObject1)).hLJ().b(paramab1, bh.TOQ);
                p.g(paramab1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                paramab1 = aL(paramab1);
                label231:
                if ((!bool) && (!((ab)localObject1).hEa())) {
                  break label293;
                }
              }
            }
          }
          label258:
          label265:
          label293:
          for (bool = true;; bool = false)
          {
            paramab2 = paramab2.TPx;
            break;
            i = 0;
            break label188;
            break label155;
            i = 0;
            break label194;
            paramab1 = au.TOz.ax((ab)localObject1).hLJ().b(paramab1, bh.TOQ);
            p.g(paramab1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
            break label231;
          }
        }
        paramab2 = paramab1.hKE();
        if (!paramx.b(paramab2, localat))
        {
          paramab1 = (Throwable)new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + e(paramab2) + ", \n\nsupertype: " + e(localat) + " \n" + paramx.b(paramab2, localat));
          AppMethodBeat.o(61191);
          throw paramab1;
        }
        paramab1 = bc.b(paramab1, bool);
        AppMethodBeat.o(61191);
        return paramab1;
      }
      paramab1 = ((at)localObject2).hBV().iterator();
      while (paramab1.hasNext())
      {
        localObject2 = (ab)paramab1.next();
        p.g(localObject2, "immediateSupertype");
        ((ArrayDeque)localObject1).add(new u((ab)localObject2, paramab2));
      }
    }
    AppMethodBeat.o(61191);
    return null;
  }
  
  private static final ab aL(ab paramab)
  {
    AppMethodBeat.i(61192);
    paramab = (ab)kotlin.l.b.a.b.m.e.b.aP(paramab).TPZ;
    AppMethodBeat.o(61192);
    return paramab;
  }
  
  private static final String e(at paramat)
  {
    AppMethodBeat.i(61193);
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = new a(localStringBuilder);
    locala.buq("type: ".concat(String.valueOf(paramat)));
    locala.buq("hashCode: " + paramat.hashCode());
    locala.buq("javaClass: " + paramat.getClass().getCanonicalName());
    for (paramat = (l)paramat.hzS(); paramat != null; paramat = paramat.hzx())
    {
      locala.buq("fqName: " + c.TFg.k(paramat));
      locala.buq("javaClass: " + paramat.getClass().getCanonicalName());
    }
    paramat = localStringBuilder.toString();
    p.g(paramat, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(61193);
    return paramat;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<String, StringBuilder>
  {
    a(StringBuilder paramStringBuilder)
    {
      super();
    }
    
    public final StringBuilder buq(String paramString)
    {
      AppMethodBeat.i(61190);
      p.h(paramString, "$this$unaryPlus");
      paramString = this.TPM.append(paramString);
      p.g(paramString, "append(value)");
      paramString = n.i(paramString);
      AppMethodBeat.o(61190);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.z
 * JD-Core Version:    0.7.0.1
 */