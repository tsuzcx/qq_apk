package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.i.c;
import d.l.b.a.b.j.a.a.d;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.au;
import d.l.b.a.b.m.au.a;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.ba;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.e.a;
import d.n.n;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

public final class z
{
  public static final ab a(ab paramab1, ab paramab2, x paramx)
  {
    AppMethodBeat.i(61191);
    k.h(paramab1, "subtype");
    k.h(paramab2, "supertype");
    k.h(paramx, "typeCheckingProcedureCallbacks");
    Object localObject1 = new ArrayDeque();
    ((ArrayDeque)localObject1).add(new u(paramab1, null));
    at localat = paramab2.fIW();
    while (!((ArrayDeque)localObject1).isEmpty())
    {
      paramab2 = (u)((ArrayDeque)localObject1).poll();
      paramab1 = paramab2.Jko;
      Object localObject2 = paramab1.fIW();
      if (paramx.b((at)localObject2, localat))
      {
        boolean bool = paramab1.fBT();
        paramab2 = paramab2.JZi;
        if (paramab2 != null)
        {
          localObject1 = paramab2.Jko;
          localObject2 = (Iterable)((ab)localObject1).fIT();
          label155:
          int i;
          if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
          {
            localObject2 = ((Iterable)localObject2).iterator();
            if (((Iterator)localObject2).hasNext()) {
              if (((av)((Iterator)localObject2).next()).fJZ() != bh.JYC)
              {
                i = 1;
                label188:
                if (i == 0) {
                  break label260;
                }
                i = 1;
                label194:
                if (i == 0) {
                  break label267;
                }
                localObject2 = au.JYl;
                paramab1 = d.c(au.a.ay((ab)localObject1)).fKa().b(paramab1, bh.JYC);
                k.g(paramab1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                paramab1 = aM(paramab1);
                label233:
                if ((!bool) && (!((ab)localObject1).fBT())) {
                  break label297;
                }
              }
            }
          }
          label260:
          label267:
          label297:
          for (bool = true;; bool = false)
          {
            paramab2 = paramab2.JZi;
            break;
            i = 0;
            break label188;
            break label155;
            i = 0;
            break label194;
            localObject2 = au.JYl;
            paramab1 = au.a.ay((ab)localObject1).fKa().b(paramab1, bh.JYC);
            k.g(paramab1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
            break label233;
          }
        }
        paramab2 = paramab1.fIW();
        if (!paramx.b(paramab2, localat))
        {
          paramab1 = (Throwable)new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + e(paramab2) + ", \n\nsupertype: " + e(localat) + " \n" + paramx.b(paramab2, localat));
          AppMethodBeat.o(61191);
          throw paramab1;
        }
        paramab1 = bc.a(paramab1, bool);
        AppMethodBeat.o(61191);
        return paramab1;
      }
      paramab1 = ((at)localObject2).fzP().iterator();
      while (paramab1.hasNext())
      {
        localObject2 = (ab)paramab1.next();
        k.g(localObject2, "immediateSupertype");
        ((ArrayDeque)localObject1).add(new u((ab)localObject2, paramab2));
      }
    }
    AppMethodBeat.o(61191);
    return null;
  }
  
  private static final ab aM(ab paramab)
  {
    AppMethodBeat.i(61192);
    paramab = (ab)d.l.b.a.b.m.e.b.aQ(paramab).JZK;
    AppMethodBeat.o(61192);
    return paramab;
  }
  
  private static final String e(at paramat)
  {
    AppMethodBeat.i(61193);
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = new a(localStringBuilder);
    locala.aQV("type: ".concat(String.valueOf(paramat)));
    locala.aQV("hashCode: " + paramat.hashCode());
    locala.aQV("javaClass: " + paramat.getClass().getCanonicalName());
    for (paramat = (d.l.b.a.b.b.l)paramat.fxM(); paramat != null; paramat = paramat.fxq())
    {
      locala.aQV("fqName: " + c.JOM.k(paramat));
      locala.aQV("javaClass: " + paramat.getClass().getCanonicalName());
    }
    paramat = localStringBuilder.toString();
    k.g(paramat, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(61193);
    return paramat;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<String, StringBuilder>
  {
    a(StringBuilder paramStringBuilder)
    {
      super();
    }
    
    public final StringBuilder aQV(String paramString)
    {
      AppMethodBeat.i(61190);
      k.h(paramString, "$this$unaryPlus");
      paramString = this.JZx.append(paramString);
      k.g(paramString, "append(value)");
      paramString = n.i(paramString);
      AppMethodBeat.o(61190);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a.z
 * JD-Core Version:    0.7.0.1
 */