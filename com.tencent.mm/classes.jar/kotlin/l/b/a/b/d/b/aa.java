package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.b.c.a;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.k;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;
import kotlin.t;
import kotlin.x;

public final class aa
{
  private static final <T> T a(l<T> paraml, T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(58274);
    if (paramBoolean)
    {
      paraml = paraml.fz(paramT);
      AppMethodBeat.o(58274);
      return paraml;
    }
    AppMethodBeat.o(58274);
    return paramT;
  }
  
  private static <T> T a(kotlin.l.b.a.b.m.ab paramab, l<T> paraml, y paramy, w<? extends T> paramw, i<T> parami, q<? super kotlin.l.b.a.b.m.ab, ? super T, ? super y, x> paramq)
  {
    AppMethodBeat.i(58275);
    Object localObject2;
    for (;;)
    {
      p.k(paramab, "kotlinType");
      p.k(paraml, "factory");
      p.k(paramy, "mode");
      p.k(paramw, "typeMappingConfiguration");
      p.k(paramq, "writeGenericType");
      paramw.V(paramab);
      if (kotlin.l.b.a.b.a.f.e(paramab))
      {
        paramab = (kotlin.l.b.a.b.m.ab)k.a(paramab, true);
      }
      else
      {
        Object localObject1 = (bb)kotlin.l.b.a.b.m.a.s.abrU;
        localObject2 = (kotlin.l.b.a.b.m.c.h)paramab;
        p.k(localObject1, "$this$mapBuiltInType");
        p.k(localObject2, "type");
        p.k(paraml, "typeFactory");
        p.k(paramy, "mode");
        Object localObject3 = ((bb)localObject1).d((kotlin.l.b.a.b.m.c.h)localObject2);
        boolean bool;
        if (((bb)localObject1).l((kotlin.l.b.a.b.m.c.n)localObject3))
        {
          kotlin.l.b.a.b.a.h localh = ((bb)localObject1).c((kotlin.l.b.a.b.m.c.n)localObject3);
          if (localh != null)
          {
            localObject3 = kotlin.l.b.a.b.j.e.d.d(localh);
            p.j(localObject3, "JvmPrimitiveType.get(primitiveType)");
            localObject3 = ((kotlin.l.b.a.b.j.e.d)localObject3).getDesc();
            p.j(localObject3, "JvmPrimitiveType.get(primitiveType).desc");
            localObject3 = paraml.bGP((String)localObject3);
            if ((((bb)localObject1).s((kotlin.l.b.a.b.m.c.h)localObject2)) || (kotlin.l.b.a.b.d.a.f.s.a((bb)localObject1, (kotlin.l.b.a.b.m.c.h)localObject2)))
            {
              bool = true;
              localObject1 = a(paraml, localObject3, bool);
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label513;
          }
          paraml = a(paraml, localObject1, paramy.aaYL);
          paramq.c(paramab, paraml, paramy);
          AppMethodBeat.o(58275);
          return paraml;
          bool = false;
          break;
          localObject2 = ((bb)localObject1).d((kotlin.l.b.a.b.m.c.n)localObject3);
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder("[");
            localObject2 = kotlin.l.b.a.b.j.e.d.d((kotlin.l.b.a.b.a.h)localObject2);
            p.j(localObject2, "JvmPrimitiveType.get(arrayElementType)");
            localObject1 = paraml.bGP(((kotlin.l.b.a.b.j.e.d)localObject2).getDesc());
          }
          else
          {
            if (((bb)localObject1).e((kotlin.l.b.a.b.m.c.n)localObject3))
            {
              localObject1 = ((bb)localObject1).f((kotlin.l.b.a.b.m.c.n)localObject3);
              if (localObject1 != null)
              {
                localObject2 = kotlin.l.b.a.b.a.b.c.aaIT;
                localObject1 = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.c)localObject1);
                label360:
                if (localObject1 == null) {
                  break label507;
                }
                if (!paramy.aaYQ)
                {
                  localObject2 = kotlin.l.b.a.b.a.b.c.aaIT;
                  localObject2 = (Iterable)kotlin.l.b.a.b.a.b.c.iEo();
                  if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                    break label501;
                  }
                  localObject2 = ((Iterable)localObject2).iterator();
                  do
                  {
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                  } while (!p.h(((c.a)((Iterator)localObject2).next()).aaIU, localObject1));
                }
              }
              label501:
              for (int i = 1;; i = 0)
              {
                if (i != 0) {
                  break label507;
                }
                localObject1 = kotlin.l.b.a.b.j.e.c.e((kotlin.l.b.a.b.f.a)localObject1);
                p.j(localObject1, "JvmClassName.byClassId(classId)");
                localObject1 = ((kotlin.l.b.a.b.j.e.c)localObject1).iOY();
                p.j(localObject1, "JvmClassName.byClassId(classId).internalName");
                localObject1 = paraml.bGQ((String)localObject1);
                break;
                localObject1 = null;
                break label360;
              }
            }
            label507:
            localObject1 = null;
          }
        }
        label513:
        localObject1 = paramab.iOU();
        if ((localObject1 instanceof kotlin.l.b.a.b.m.aa))
        {
          paramab = kotlin.l.b.a.b.m.d.a.aO(paramw.w((Collection)((kotlin.l.b.a.b.m.aa)localObject1).abqE));
        }
        else
        {
          localObject2 = ((at)localObject1).iEf();
          if (localObject2 == null)
          {
            paramab = (Throwable)new UnsupportedOperationException("no descriptor for type constructor of ".concat(String.valueOf(paramab)));
            AppMethodBeat.o(58275);
            throw paramab;
          }
          p.j(localObject2, "constructor.declarationD…structor of $kotlinType\")");
          if (u.L((kotlin.l.b.a.b.b.l)localObject2))
          {
            paraml = paraml.bGQ("error/NonExistentClass");
            if (localObject2 == null)
            {
              paramab = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              AppMethodBeat.o(58275);
              throw paramab;
            }
            paramw.a(paramab, (e)localObject2);
            if (parami != null)
            {
              AppMethodBeat.o(58275);
              throw null;
            }
            AppMethodBeat.o(58275);
            return paraml;
          }
          if (((localObject2 instanceof e)) && (g.m(paramab)))
          {
            if (paramab.iOR().size() != 1)
            {
              paramab = (Throwable)new UnsupportedOperationException("arrays must have one type argument");
              AppMethodBeat.o(58275);
              throw paramab;
            }
            paramab = (av)paramab.iOR().get(0);
            localObject2 = paramab.iFN();
            p.j(localObject2, "memberProjection.type");
            if (paramab.iQa() == bh.abrq)
            {
              paramab = paraml.bGQ("java/lang/Object");
              if (parami != null)
              {
                AppMethodBeat.o(58275);
                throw null;
              }
            }
            else
            {
              if (parami != null)
              {
                AppMethodBeat.o(58275);
                throw null;
              }
              paramab = paramab.iQa();
              p.j(paramab, "memberProjection.projectionKind");
              p.k(paramab, "effectiveVariance");
              switch (z.$EnumSwitchMapping$0[paramab.ordinal()])
              {
              default: 
                localObject1 = paramy.aaYP;
                paramab = (kotlin.l.b.a.b.m.ab)localObject1;
                if (localObject1 == null) {
                  paramab = paramy;
                }
                break;
              }
            }
            for (;;)
            {
              paramab = a((kotlin.l.b.a.b.m.ab)localObject2, paraml, paramab, paramw, parami, paramq);
              paramab = paraml.bGP("[" + paraml.cG(paramab));
              AppMethodBeat.o(58275);
              return paramab;
              localObject1 = paramy.aaYR;
              paramab = (kotlin.l.b.a.b.m.ab)localObject1;
              if (localObject1 == null)
              {
                paramab = paramy;
                continue;
                localObject1 = paramy.aaYS;
                paramab = (kotlin.l.b.a.b.m.ab)localObject1;
                if (localObject1 == null) {
                  paramab = paramy;
                }
              }
            }
          }
          if (!(localObject2 instanceof e)) {
            break label1257;
          }
          if ((!((e)localObject2).iDU()) || (paramy.aaYM)) {
            break;
          }
          localObject1 = (bb)kotlin.l.b.a.b.m.a.s.abrU;
          localObject3 = (kotlin.l.b.a.b.m.c.h)paramab;
          p.k(localObject1, "$this$computeExpandedTypeForInlineClass");
          p.k(localObject3, "inlineClassType");
          localObject1 = (kotlin.l.b.a.b.m.ab)f.a((bb)localObject1, (kotlin.l.b.a.b.m.c.h)localObject3, new HashSet());
          if (localObject1 == null) {
            break;
          }
          paramy = new y(paramy.aaYL, true, paramy.aaVX, paramy.aaYN, paramy.aaYO, paramy.aaYP, paramy.aaYQ, paramy.aaYR, paramy.aaYS);
          paramab = (kotlin.l.b.a.b.m.ab)localObject1;
        }
      }
    }
    if ((paramy.aaVX) && (g.g((e)localObject2)))
    {
      paraml = paraml.iIH();
      paramq.c(paramab, paraml, paramy);
      AppMethodBeat.o(58275);
      return paraml;
    }
    parami = ((e)localObject2).iFc();
    p.j(parami, "descriptor.original");
    paramw.t(parami);
    if (((e)localObject2).iDN() == kotlin.l.b.a.b.b.f.aaKb)
    {
      parami = ((e)localObject2).iDJ();
      if (parami == null)
      {
        paramab = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(58275);
        throw paramab;
      }
    }
    for (parami = (e)parami;; parami = (e)localObject2)
    {
      parami = parami.iFc();
      p.j(parami, "enumClassIfEnumEntry.original");
      paraml = paraml.bGQ(a(parami, paramw));
      break;
    }
    label1257:
    if ((localObject2 instanceof as))
    {
      paramab = a(kotlin.l.b.a.b.m.d.a.e((as)localObject2), paraml, paramy, paramw, null, kotlin.l.b.a.b.o.d.iQk());
      if (parami != null)
      {
        p.j(((kotlin.l.b.a.b.b.h)localObject2).iEU(), "descriptor.getName()");
        AppMethodBeat.o(58275);
        throw null;
      }
      AppMethodBeat.o(58275);
      return paramab;
    }
    paramab = (Throwable)new UnsupportedOperationException("Unknown type ".concat(String.valueOf(paramab)));
    AppMethodBeat.o(58275);
    throw paramab;
  }
  
  public static final String a(e parame, w<?> paramw)
  {
    AppMethodBeat.i(58277);
    p.k(parame, "klass");
    p.k(paramw, "typeMappingConfiguration");
    paramw.v(parame);
    kotlin.l.b.a.b.b.l locall = parame.iDJ();
    p.j(locall, "klass.containingDeclaration");
    Object localObject = kotlin.l.b.a.b.f.h.v(parame.iEU());
    p.j(localObject, "SpecialNames.safeIdentifier(klass.name)");
    String str = ((kotlin.l.b.a.b.f.f)localObject).getIdentifier();
    p.j(str, "SpecialNames.safeIdentifier(klass.name).identifier");
    if ((locall instanceof kotlin.l.b.a.b.b.ab))
    {
      paramw = ((kotlin.l.b.a.b.b.ab)locall).iFy();
      if (paramw.abfE.abfJ.isEmpty())
      {
        AppMethodBeat.o(58277);
        return str;
      }
      parame = new StringBuilder();
      paramw = paramw.qu();
      p.j(paramw, "fqName.asString()");
      parame = kotlin.n.n.a(paramw, '.', '/') + '/' + str;
      AppMethodBeat.o(58277);
      return parame;
    }
    if (!(locall instanceof e)) {}
    for (localObject = null;; localObject = locall)
    {
      localObject = (e)localObject;
      if (localObject == null)
      {
        parame = (Throwable)new IllegalArgumentException("Unexpected container: " + locall + " for " + parame);
        AppMethodBeat.o(58277);
        throw parame;
      }
      paramw.u((e)localObject);
      parame = a((e)localObject, paramw);
      parame = parame + '$' + str;
      AppMethodBeat.o(58277);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.aa
 * JD-Core Version:    0.7.0.1
 */