package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.l;
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
    p.h(paramab1, "subtype");
    p.h(paramab2, "supertype");
    p.h(paramx, "typeCheckingProcedureCallbacks");
    Object localObject1 = new ArrayDeque();
    ((ArrayDeque)localObject1).add(new u(paramab1, null));
    at localat = paramab2.gsZ();
    while (!((ArrayDeque)localObject1).isEmpty())
    {
      paramab2 = (u)((ArrayDeque)localObject1).poll();
      paramab1 = paramab2.MOF;
      Object localObject2 = paramab1.gsZ();
      if (paramx.b((at)localObject2, localat))
      {
        boolean bool = paramab1.glW();
        paramab2 = paramab2.NDw;
        if (paramab2 != null)
        {
          localObject1 = paramab2.MOF;
          localObject2 = (Iterable)((ab)localObject1).gsW();
          label155:
          int i;
          if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
          {
            localObject2 = ((Iterable)localObject2).iterator();
            if (((Iterator)localObject2).hasNext()) {
              if (((av)((Iterator)localObject2).next()).gud() != bh.NCP)
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
                localObject2 = au.NCz;
                paramab1 = d.c(au.a.ay((ab)localObject1)).gue().b(paramab1, bh.NCP);
                p.g(paramab1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                paramab1 = aM(paramab1);
                label233:
                if ((!bool) && (!((ab)localObject1).glW())) {
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
            paramab2 = paramab2.NDw;
            break;
            i = 0;
            break label188;
            break label155;
            i = 0;
            break label194;
            localObject2 = au.NCz;
            paramab1 = au.a.ay((ab)localObject1).gue().b(paramab1, bh.NCP);
            p.g(paramab1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
            break label233;
          }
        }
        paramab2 = paramab1.gsZ();
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
      paramab1 = ((at)localObject2).gjR().iterator();
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
  
  private static final ab aM(ab paramab)
  {
    AppMethodBeat.i(61192);
    paramab = (ab)d.l.b.a.b.m.e.b.aQ(paramab).NDY;
    AppMethodBeat.o(61192);
    return paramab;
  }
  
  private static final String e(at paramat)
  {
    AppMethodBeat.i(61193);
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = new a(localStringBuilder);
    locala.bcX("type: ".concat(String.valueOf(paramat)));
    locala.bcX("hashCode: " + paramat.hashCode());
    locala.bcX("javaClass: " + paramat.getClass().getCanonicalName());
    for (paramat = (l)paramat.ghO(); paramat != null; paramat = paramat.ghs())
    {
      locala.bcX("fqName: " + c.Ntc.k(paramat));
      locala.bcX("javaClass: " + paramat.getClass().getCanonicalName());
    }
    paramat = localStringBuilder.toString();
    p.g(paramat, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(61193);
    return paramat;
  }
  
  static final class a
    extends q
    implements d.g.a.b<String, StringBuilder>
  {
    a(StringBuilder paramStringBuilder)
    {
      super();
    }
    
    public final StringBuilder bcX(String paramString)
    {
      AppMethodBeat.i(61190);
      p.h(paramString, "$this$unaryPlus");
      paramString = this.NDL.append(paramString);
      p.g(paramString, "append(value)");
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