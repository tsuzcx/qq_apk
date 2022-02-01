package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.l.b.a.b.j.a.a.d;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ay.a;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.e.a;
import kotlin.l.b.a.b.m.e.b;

public class u
{
  static
  {
    AppMethodBeat.i(61174);
    if (!u.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(61174);
      return;
    }
  }
  
  public static ad f(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(61163);
    if (paramad1 == null) {
      aKu(0);
    }
    if (paramad2 == null) {
      aKu(1);
    }
    t localt = new t();
    if (paramad1 == null) {
      aKu(2);
    }
    if (paramad2 == null) {
      aKu(3);
    }
    kotlin.g.b.s.u(paramad1, "subtype");
    kotlin.g.b.s.u(paramad2, "supertype");
    kotlin.g.b.s.u(localt, "typeCheckingProcedureCallbacks");
    Object localObject1 = new ArrayDeque();
    ((ArrayDeque)localObject1).add(new s(paramad1, null));
    ax localax = paramad2.kzm();
    while (!((ArrayDeque)localObject1).isEmpty())
    {
      paramad2 = (s)((ArrayDeque)localObject1).poll();
      paramad1 = paramad2.aiAd;
      Object localObject2 = paramad1.kzm();
      if (localt.b((ax)localObject2, localax))
      {
        boolean bool = paramad1.ksB();
        paramad2 = paramad2.ajrs;
        if (paramad2 != null)
        {
          localObject1 = paramad2.aiAd;
          localObject2 = (Iterable)((ad)localObject1).klR();
          label197:
          int i;
          if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
          {
            localObject2 = ((Iterable)localObject2).iterator();
            if (((Iterator)localObject2).hasNext()) {
              if (((az)((Iterator)localObject2).next()).kAN() != bl.ajqM)
              {
                i = 1;
                label230:
                if (i == 0) {
                  break label304;
                }
                i = 1;
                label236:
                if (i == 0) {
                  break label311;
                }
                paramad1 = d.c(ay.ajqs.ao((ad)localObject1)).kAO().b(paramad1, bl.ajqM);
                kotlin.g.b.s.s(paramad1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                paramad1 = (ad)b.aI(paramad1).ajrP;
                label279:
                if ((!bool) && (!((ad)localObject1).ksB())) {
                  break label339;
                }
              }
            }
          }
          label304:
          label311:
          label339:
          for (bool = true;; bool = false)
          {
            paramad2 = paramad2.ajrs;
            break;
            i = 0;
            break label230;
            break label197;
            i = 0;
            break label236;
            paramad1 = ay.ajqs.ao((ad)localObject1).kAO().b(paramad1, bl.ajqM);
            kotlin.g.b.s.s(paramad1, "{\n                    Ty…ARIANT)\n                }");
            break label279;
          }
        }
        paramad2 = paramad1.kzm();
        if (!localt.b(paramad2, localax))
        {
          paramad1 = new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + x.f(paramad2) + ", \n\nsupertype: " + x.f(localax) + " \n" + localt.b(paramad2, localax));
          AppMethodBeat.o(61163);
          throw paramad1;
        }
        paramad1 = bg.b(paramad1, bool);
        AppMethodBeat.o(61163);
        return paramad1;
      }
      paramad1 = ((ax)localObject2).kpG().iterator();
      while (paramad1.hasNext())
      {
        localObject2 = (ad)paramad1.next();
        kotlin.g.b.s.s(localObject2, "immediateSupertype");
        ((ArrayDeque)localObject1).add(new s((ad)localObject2, paramad2));
      }
    }
    AppMethodBeat.o(61163);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.u
 * JD-Core Version:    0.7.0.1
 */