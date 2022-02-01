package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.b.c.a;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bf;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.v;
import kotlin.n.n;

public final class c
{
  private static <T> T a(ad paramad, k<T> paramk, y paramy, w<? extends T> paramw, h<T> paramh, kotlin.g.a.q<? super ad, ? super T, ? super y, kotlin.ah> paramq)
  {
    AppMethodBeat.i(191941);
    for (;;)
    {
      s.u(paramad, "kotlinType");
      s.u(paramk, "factory");
      s.u(paramy, "mode");
      s.u(paramw, "typeMappingConfiguration");
      s.u(paramq, "writeGenericType");
      Object localObject1 = paramw.M(paramad);
      if (localObject1 != null)
      {
        paramad = (ad)localObject1;
      }
      else if (g.e(paramad))
      {
        paramad = (ad)kotlin.l.b.a.b.a.l.a(paramad, paramw.ksY());
      }
      else
      {
        localObject1 = (bf)kotlin.l.b.a.b.m.a.q.ajrq;
        Object localObject2 = (kotlin.l.b.a.b.m.c.i)paramad;
        s.u(localObject1, "<this>");
        s.u(localObject2, "type");
        s.u(paramk, "typeFactory");
        s.u(paramy, "mode");
        Object localObject3 = ((bf)localObject1).q((kotlin.l.b.a.b.m.c.i)localObject2);
        boolean bool;
        if (((bf)localObject1).f((o)localObject3))
        {
          kotlin.l.b.a.b.a.i locali = ((bf)localObject1).c((o)localObject3);
          if (locali != null)
          {
            localObject3 = paramk.d(locali);
            if ((((bf)localObject1).m((kotlin.l.b.a.b.m.c.i)localObject2)) || (kotlin.l.b.a.b.d.a.f.q.a((bf)localObject1, (kotlin.l.b.a.b.m.c.i)localObject2)))
            {
              bool = true;
              localObject1 = z.a(paramk, localObject3, bool);
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label466;
          }
          paramk = z.a(paramk, localObject1, paramy.aiXi);
          paramq.invoke(paramad, paramk, paramy);
          AppMethodBeat.o(191941);
          return paramk;
          bool = false;
          break;
          localObject2 = ((bf)localObject1).b((o)localObject3);
          if (localObject2 != null)
          {
            localObject1 = paramk.bIS(s.X("[", kotlin.l.b.a.b.j.e.e.e((kotlin.l.b.a.b.a.i)localObject2).getDesc()));
          }
          else
          {
            if (((bf)localObject1).m((o)localObject3))
            {
              localObject1 = ((bf)localObject1).a((o)localObject3);
              if (localObject1 == null)
              {
                localObject1 = null;
                label315:
                if (localObject1 == null) {
                  break label460;
                }
                if (!paramy.aiXn)
                {
                  localObject2 = kotlin.l.b.a.b.a.b.c.aiEX;
                  localObject2 = (Iterable)kotlin.l.b.a.b.a.b.c.knG();
                  if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                    break label454;
                  }
                  localObject2 = ((Iterable)localObject2).iterator();
                  do
                  {
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                  } while (!s.p(((c.a)((Iterator)localObject2).next()).aiFm, localObject1));
                }
              }
              label454:
              for (int i = 1;; i = 0)
              {
                if (i != 0) {
                  break label460;
                }
                localObject1 = kotlin.l.b.a.b.j.e.d.g((b)localObject1).kzr();
                s.s(localObject1, "byClassId(classId).internalName");
                localObject1 = paramk.bIT((String)localObject1);
                break;
                localObject2 = kotlin.l.b.a.b.a.b.c.aiEX;
                localObject1 = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.d)localObject1);
                break label315;
              }
            }
            label460:
            localObject1 = null;
          }
        }
        label466:
        localObject2 = paramad.kzm();
        if ((localObject2 instanceof ac))
        {
          localObject1 = ((ac)localObject2).ajpN;
          paramad = (ad)localObject1;
          if (localObject1 == null) {
            paramad = paramw.N((Collection)((ac)localObject2).ajpO);
          }
          paramad = a.aG(paramad);
        }
        else
        {
          localObject2 = ((ax)localObject2).knA();
          if (localObject2 == null)
          {
            paramad = new UnsupportedOperationException(s.X("no descriptor for type constructor of ", paramad));
            AppMethodBeat.o(191941);
            throw paramad;
          }
          if (v.L((kotlin.l.b.a.b.b.l)localObject2))
          {
            paramk = paramk.bIT("error/NonExistentClass");
            paramw.a(paramad, (kotlin.l.b.a.b.b.e)localObject2);
            if (paramh != null)
            {
              AppMethodBeat.o(191941);
              throw null;
            }
            AppMethodBeat.o(191941);
            return paramk;
          }
          if (((localObject2 instanceof kotlin.l.b.a.b.b.e)) && (kotlin.l.b.a.b.a.h.m(paramad)))
          {
            if (paramad.klR().size() != 1)
            {
              paramad = new UnsupportedOperationException("arrays must have one type argument");
              AppMethodBeat.o(191941);
              throw paramad;
            }
            paramad = (kotlin.l.b.a.b.m.az)paramad.klR().get(0);
            localObject2 = paramad.koG();
            s.s(localObject2, "memberProjection.type");
            if (paramad.kAN() == bl.ajqN)
            {
              paramad = paramk.bIT("java/lang/Object");
              if (paramh != null)
              {
                AppMethodBeat.o(191941);
                throw null;
              }
            }
            else
            {
              if (paramh != null)
              {
                AppMethodBeat.o(191941);
                throw null;
              }
              paramad = paramad.kAN();
              s.s(paramad, "memberProjection.projectionKind");
              s.u(paramad, "effectiveVariance");
              if (!paramy.aiTZ) {
                break label802;
              }
              paramad = paramy;
            }
            for (;;)
            {
              paramad = a((ad)localObject2, paramk, paramad, paramw, paramh, paramq);
              paramad = paramk.bIS(s.X("[", paramk.ca(paramad)));
              AppMethodBeat.o(191941);
              return paramad;
              label802:
              switch (y.b.$EnumSwitchMapping$0[paramad.ordinal()])
              {
              default: 
                localObject1 = paramy.aiXm;
                paramad = (ad)localObject1;
                if (localObject1 == null) {
                  paramad = paramy;
                }
                break;
              case 1: 
                localObject1 = paramy.aiXo;
                paramad = (ad)localObject1;
                if (localObject1 == null) {
                  paramad = paramy;
                }
                break;
              case 2: 
                localObject1 = paramy.aiXp;
                paramad = (ad)localObject1;
                if (localObject1 == null) {
                  paramad = paramy;
                }
                break;
              }
            }
          }
          if ((localObject2 instanceof kotlin.l.b.a.b.b.e))
          {
            if ((kotlin.l.b.a.b.j.f.D((kotlin.l.b.a.b.b.l)localObject2)) && (!paramy.aiXj))
            {
              localObject1 = (bf)kotlin.l.b.a.b.m.a.q.ajrq;
              localObject3 = (kotlin.l.b.a.b.m.c.i)paramad;
              s.u(localObject1, "<this>");
              s.u(localObject3, "inlineClassType");
              localObject1 = (ad)kotlin.l.b.a.b.m.w.a((bf)localObject1, (kotlin.l.b.a.b.m.c.i)localObject3, new HashSet());
              if (localObject1 != null)
              {
                paramy = new y(paramy.aiXi, true, paramy.aiTZ, paramy.aiXk, paramy.aiXl, paramy.aiXm, paramy.aiXn, paramy.aiXo, paramy.aiXp, false, 512);
                paramad = (ad)localObject1;
                continue;
              }
            }
            if ((paramy.aiTZ) && (kotlin.l.b.a.b.a.h.g((kotlin.l.b.a.b.b.e)localObject2))) {
              paramh = paramk.ksW();
            }
            do
            {
              paramq.invoke(paramad, paramh, paramy);
              AppMethodBeat.o(191941);
              return paramh;
              paramh = ((kotlin.l.b.a.b.b.e)localObject2).kow();
              s.s(paramh, "descriptor.original");
              localObject1 = paramw.u(paramh);
              paramh = (h<T>)localObject1;
            } while (localObject1 != null);
            if (((kotlin.l.b.a.b.b.e)localObject2).kna() == kotlin.l.b.a.b.b.f.aiGw) {}
            for (paramh = (kotlin.l.b.a.b.b.e)((kotlin.l.b.a.b.b.e)localObject2).knp();; paramh = (kotlin.l.b.a.b.b.e)localObject2)
            {
              paramh = paramh.kow();
              s.s(paramh, "enumClassIfEnumEntry.original");
              paramh = paramk.bIT(a(paramh, paramw));
              break;
            }
          }
          else
          {
            if ((localObject2 instanceof ba))
            {
              paramad = a(a.d((ba)localObject2), paramk, paramy, paramw, null, kotlin.l.b.a.b.o.d.kBa());
              if (paramh != null)
              {
                s.s(((kotlin.l.b.a.b.b.h)localObject2).kok(), "descriptor.getName()");
                AppMethodBeat.o(191941);
                throw null;
              }
              AppMethodBeat.o(191941);
              return paramad;
            }
            if ((!(localObject2 instanceof kotlin.l.b.a.b.b.az)) || (!paramy.aiXq)) {
              break;
            }
            paramad = (ad)((kotlin.l.b.a.b.b.az)localObject2).kpm();
          }
        }
      }
    }
    paramad = new UnsupportedOperationException(s.X("Unknown type ", paramad));
    AppMethodBeat.o(191941);
    throw paramad;
  }
  
  private static String a(kotlin.l.b.a.b.b.e parame, w<?> paramw)
  {
    AppMethodBeat.i(191944);
    s.u(parame, "klass");
    s.u(paramw, "typeMappingConfiguration");
    Object localObject1 = paramw.w(parame);
    if (localObject1 != null)
    {
      AppMethodBeat.o(191944);
      return localObject1;
    }
    Object localObject2 = parame.knp();
    s.s(localObject2, "klass.containingDeclaration");
    String str = kotlin.l.b.a.b.f.h.w(parame.kok()).getIdentifier();
    s.s(str, "safeIdentifier(klass.name).identifier");
    if ((localObject2 instanceof kotlin.l.b.a.b.b.ah))
    {
      paramw = ((kotlin.l.b.a.b.b.ah)localObject2).koY();
      if (paramw.ajex.ajeC.isEmpty())
      {
        AppMethodBeat.o(191944);
        return str;
      }
      parame = new StringBuilder();
      paramw = paramw.PF();
      s.s(paramw, "fqName.asString()");
      parame = n.a(paramw, '.', '/') + '/' + str;
      AppMethodBeat.o(191944);
      return parame;
    }
    if ((localObject2 instanceof kotlin.l.b.a.b.b.e)) {}
    for (localObject1 = (kotlin.l.b.a.b.b.e)localObject2; localObject1 == null; localObject1 = null)
    {
      parame = new IllegalArgumentException("Unexpected container: " + localObject2 + " for " + parame);
      AppMethodBeat.o(191944);
      throw parame;
    }
    localObject2 = paramw.v((kotlin.l.b.a.b.b.e)localObject1);
    parame = (kotlin.l.b.a.b.b.e)localObject2;
    if (localObject2 == null) {
      parame = a((kotlin.l.b.a.b.b.e)localObject1, paramw);
    }
    parame = parame + '$' + str;
    AppMethodBeat.o(191944);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.c
 * JD-Core Version:    0.7.0.1
 */