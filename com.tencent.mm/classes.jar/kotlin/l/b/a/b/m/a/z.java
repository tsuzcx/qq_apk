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
    p.k(paramab1, "subtype");
    p.k(paramab2, "supertype");
    p.k(paramx, "typeCheckingProcedureCallbacks");
    Object localObject1 = new ArrayDeque();
    ((ArrayDeque)localObject1).add(new u(paramab1, null));
    at localat = paramab2.iOU();
    while (!((ArrayDeque)localObject1).isEmpty())
    {
      paramab2 = (u)((ArrayDeque)localObject1).poll();
      paramab1 = paramab2.aaEm;
      Object localObject2 = paramab1.iOU();
      if (paramx.b((at)localObject2, localat))
      {
        boolean bool = paramab1.iIu();
        paramab2 = paramab2.abrW;
        if (paramab2 != null)
        {
          localObject1 = paramab2.aaEm;
          localObject2 = (Iterable)((ab)localObject1).iOR();
          label155:
          int i;
          if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
          {
            localObject2 = ((Iterable)localObject2).iterator();
            if (((Iterator)localObject2).hasNext()) {
              if (((av)((Iterator)localObject2).next()).iQa() != bh.abrp)
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
                paramab1 = d.c(au.abqZ.ax((ab)localObject1)).iQb().b(paramab1, bh.abrp);
                p.j(paramab1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                paramab1 = aL(paramab1);
                label231:
                if ((!bool) && (!((ab)localObject1).iIu())) {
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
            paramab2 = paramab2.abrW;
            break;
            i = 0;
            break label188;
            break label155;
            i = 0;
            break label194;
            paramab1 = au.abqZ.ax((ab)localObject1).iQb().b(paramab1, bh.abrp);
            p.j(paramab1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
            break label231;
          }
        }
        paramab2 = paramab1.iOU();
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
      paramab1 = ((at)localObject2).iGk().iterator();
      while (paramab1.hasNext())
      {
        localObject2 = (ab)paramab1.next();
        p.j(localObject2, "immediateSupertype");
        ((ArrayDeque)localObject1).add(new u((ab)localObject2, paramab2));
      }
    }
    AppMethodBeat.o(61191);
    return null;
  }
  
  private static final ab aL(ab paramab)
  {
    AppMethodBeat.i(61192);
    paramab = (ab)kotlin.l.b.a.b.m.e.b.aP(paramab).absy;
    AppMethodBeat.o(61192);
    return paramab;
  }
  
  private static final String e(at paramat)
  {
    AppMethodBeat.i(61193);
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = new a(localStringBuilder);
    locala.bHs("type: ".concat(String.valueOf(paramat)));
    locala.bHs("hashCode: " + paramat.hashCode());
    locala.bHs("javaClass: " + paramat.getClass().getCanonicalName());
    for (paramat = (l)paramat.iEf(); paramat != null; paramat = paramat.iDJ())
    {
      locala.bHs("fqName: " + c.abhK.k(paramat));
      locala.bHs("javaClass: " + paramat.getClass().getCanonicalName());
    }
    paramat = localStringBuilder.toString();
    p.j(paramat, "StringBuilder().apply(builderAction).toString()");
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
    
    public final StringBuilder bHs(String paramString)
    {
      AppMethodBeat.i(61190);
      p.k(paramString, "$this$unaryPlus");
      paramString = this.absl.append(paramString);
      p.j(paramString, "append(value)");
      paramString = n.i(paramString);
      AppMethodBeat.o(61190);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.z
 * JD-Core Version:    0.7.0.1
 */