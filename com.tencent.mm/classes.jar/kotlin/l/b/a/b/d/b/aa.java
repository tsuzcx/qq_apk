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
      paraml = paraml.fu(paramT);
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
      p.h(paramab, "kotlinType");
      p.h(paraml, "factory");
      p.h(paramy, "mode");
      p.h(paramw, "typeMappingConfiguration");
      p.h(paramq, "writeGenericType");
      paramw.V(paramab);
      if (kotlin.l.b.a.b.a.f.e(paramab))
      {
        paramab = (kotlin.l.b.a.b.m.ab)k.a(paramab, true);
      }
      else
      {
        Object localObject1 = (bb)kotlin.l.b.a.b.m.a.s.TPv;
        localObject2 = (kotlin.l.b.a.b.m.c.h)paramab;
        p.h(localObject1, "$this$mapBuiltInType");
        p.h(localObject2, "type");
        p.h(paraml, "typeFactory");
        p.h(paramy, "mode");
        Object localObject3 = ((bb)localObject1).d((kotlin.l.b.a.b.m.c.h)localObject2);
        boolean bool;
        if (((bb)localObject1).l((kotlin.l.b.a.b.m.c.n)localObject3))
        {
          kotlin.l.b.a.b.a.h localh = ((bb)localObject1).c((kotlin.l.b.a.b.m.c.n)localObject3);
          if (localh != null)
          {
            localObject3 = kotlin.l.b.a.b.j.e.d.d(localh);
            p.g(localObject3, "JvmPrimitiveType.get(primitiveType)");
            localObject3 = ((kotlin.l.b.a.b.j.e.d)localObject3).getDesc();
            p.g(localObject3, "JvmPrimitiveType.get(primitiveType).desc");
            localObject3 = paraml.btM((String)localObject3);
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
          paraml = a(paraml, localObject1, paramy.TvV);
          paramq.d(paramab, paraml, paramy);
          AppMethodBeat.o(58275);
          return paraml;
          bool = false;
          break;
          localObject2 = ((bb)localObject1).d((kotlin.l.b.a.b.m.c.n)localObject3);
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder("[");
            localObject2 = kotlin.l.b.a.b.j.e.d.d((kotlin.l.b.a.b.a.h)localObject2);
            p.g(localObject2, "JvmPrimitiveType.get(arrayElementType)");
            localObject1 = paraml.btM(((kotlin.l.b.a.b.j.e.d)localObject2).getDesc());
          }
          else
          {
            if (((bb)localObject1).e((kotlin.l.b.a.b.m.c.n)localObject3))
            {
              localObject1 = ((bb)localObject1).f((kotlin.l.b.a.b.m.c.n)localObject3);
              if (localObject1 != null)
              {
                localObject2 = kotlin.l.b.a.b.a.b.c.TfZ;
                localObject1 = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.c)localObject1);
                label360:
                if (localObject1 == null) {
                  break label507;
                }
                if (!paramy.Twa)
                {
                  localObject2 = kotlin.l.b.a.b.a.b.c.TfZ;
                  localObject2 = (Iterable)kotlin.l.b.a.b.a.b.c.hAb();
                  if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                    break label501;
                  }
                  localObject2 = ((Iterable)localObject2).iterator();
                  do
                  {
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                  } while (!p.j(((c.a)((Iterator)localObject2).next()).Tga, localObject1));
                }
              }
              label501:
              for (int i = 1;; i = 0)
              {
                if (i != 0) {
                  break label507;
                }
                localObject1 = kotlin.l.b.a.b.j.e.c.e((kotlin.l.b.a.b.f.a)localObject1);
                p.g(localObject1, "JvmClassName.byClassId(classId)");
                localObject1 = ((kotlin.l.b.a.b.j.e.c)localObject1).hKI();
                p.g(localObject1, "JvmClassName.byClassId(classId).internalName");
                localObject1 = paraml.btN((String)localObject1);
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
        localObject1 = paramab.hKE();
        if ((localObject1 instanceof kotlin.l.b.a.b.m.aa))
        {
          paramab = kotlin.l.b.a.b.m.d.a.aO(paramw.y((Collection)((kotlin.l.b.a.b.m.aa)localObject1).TOe));
        }
        else
        {
          localObject2 = ((at)localObject1).hzS();
          if (localObject2 == null)
          {
            paramab = (Throwable)new UnsupportedOperationException("no descriptor for type constructor of ".concat(String.valueOf(paramab)));
            AppMethodBeat.o(58275);
            throw paramab;
          }
          p.g(localObject2, "constructor.declarationD…structor of $kotlinType\")");
          if (u.L((kotlin.l.b.a.b.b.l)localObject2))
          {
            paraml = paraml.btN("error/NonExistentClass");
            if (localObject2 == null)
            {
              paramab = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              AppMethodBeat.o(58275);
              throw paramab;
            }
            paramw.a(paramab, (e)localObject2);
            if (parami != null) {
              parami.fs(paraml);
            }
            AppMethodBeat.o(58275);
            return paraml;
          }
          if (((localObject2 instanceof e)) && (g.m(paramab)))
          {
            if (paramab.hKB().size() != 1)
            {
              paramab = (Throwable)new UnsupportedOperationException("arrays must have one type argument");
              AppMethodBeat.o(58275);
              throw paramab;
            }
            paramab = (av)paramab.hKB().get(0);
            localObject2 = paramab.hBy();
            p.g(localObject2, "memberProjection.type");
            if (paramab.hLI() == bh.TOR)
            {
              paramy = paraml.btN("java/lang/Object");
              paramab = paramy;
              if (parami != null)
              {
                parami.hEk();
                parami.fs(paramy);
                paramab = paramy;
              }
              paramab = paraml.btM("[" + paraml.toString(paramab));
              AppMethodBeat.o(58275);
              return paramab;
            }
            if (parami != null) {
              parami.hEk();
            }
            paramab = paramab.hLI();
            p.g(paramab, "memberProjection.projectionKind");
            p.h(paramab, "effectiveVariance");
            switch (z.$EnumSwitchMapping$0[paramab.ordinal()])
            {
            default: 
              localObject1 = paramy.TvZ;
              paramab = (kotlin.l.b.a.b.m.ab)localObject1;
              if (localObject1 == null) {
                paramab = paramy;
              }
              break;
            }
            for (;;)
            {
              paramab = a((kotlin.l.b.a.b.m.ab)localObject2, paraml, paramab, paramw, parami, paramq);
              break;
              localObject1 = paramy.Twb;
              paramab = (kotlin.l.b.a.b.m.ab)localObject1;
              if (localObject1 == null)
              {
                paramab = paramy;
                continue;
                localObject1 = paramy.Twc;
                paramab = (kotlin.l.b.a.b.m.ab)localObject1;
                if (localObject1 == null) {
                  paramab = paramy;
                }
              }
            }
          }
          if (!(localObject2 instanceof e)) {
            break label1264;
          }
          if ((!((e)localObject2).hzI()) || (paramy.TvW)) {
            break;
          }
          localObject1 = (bb)kotlin.l.b.a.b.m.a.s.TPv;
          localObject3 = (kotlin.l.b.a.b.m.c.h)paramab;
          p.h(localObject1, "$this$computeExpandedTypeForInlineClass");
          p.h(localObject3, "inlineClassType");
          localObject1 = (kotlin.l.b.a.b.m.ab)f.a((bb)localObject1, (kotlin.l.b.a.b.m.c.h)localObject3, new HashSet());
          if (localObject1 == null) {
            break;
          }
          paramy = new y(paramy.TvV, true, paramy.Ttd, paramy.TvX, paramy.TvY, paramy.TvZ, paramy.Twa, paramy.Twb, paramy.Twc);
          paramab = (kotlin.l.b.a.b.m.ab)localObject1;
        }
      }
    }
    if ((paramy.Ttd) && (g.g((e)localObject2)))
    {
      paraml = paraml.hEn();
      paramq.d(paramab, paraml, paramy);
      AppMethodBeat.o(58275);
      return paraml;
    }
    parami = ((e)localObject2).hAP();
    p.g(parami, "descriptor.original");
    paramw.t(parami);
    if (((e)localObject2).hzB() == kotlin.l.b.a.b.b.f.Thh)
    {
      parami = ((e)localObject2).hzx();
      if (parami == null)
      {
        paramab = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(58275);
        throw paramab;
      }
    }
    for (parami = (e)parami;; parami = (e)localObject2)
    {
      parami = parami.hAP();
      p.g(parami, "enumClassIfEnumEntry.original");
      paraml = paraml.btN(a(parami, paramw));
      break;
    }
    label1264:
    if ((localObject2 instanceof as))
    {
      paramab = a(kotlin.l.b.a.b.m.d.a.e((as)localObject2), paraml, paramy, paramw, null, kotlin.l.b.a.b.o.d.hLS());
      if (parami != null)
      {
        paraml = ((kotlin.l.b.a.b.b.h)localObject2).hAH();
        p.g(paraml, "descriptor.getName()");
        p.h(paraml, "name");
        p.h(paramab, "type");
        parami.ft(paramab);
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
    p.h(parame, "klass");
    p.h(paramw, "typeMappingConfiguration");
    paramw.v(parame);
    kotlin.l.b.a.b.b.l locall = parame.hzx();
    p.g(locall, "klass.containingDeclaration");
    Object localObject = kotlin.l.b.a.b.f.h.v(parame.hAH());
    p.g(localObject, "SpecialNames.safeIdentifier(klass.name)");
    String str = ((kotlin.l.b.a.b.f.f)localObject).getIdentifier();
    p.g(str, "SpecialNames.safeIdentifier(klass.name).identifier");
    if ((locall instanceof kotlin.l.b.a.b.b.ab))
    {
      paramw = ((kotlin.l.b.a.b.b.ab)locall).hBk();
      if (paramw.TCR.TCW.isEmpty())
      {
        AppMethodBeat.o(58277);
        return str;
      }
      parame = new StringBuilder();
      paramw = paramw.sG();
      p.g(paramw, "fqName.asString()");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.aa
 * JD-Core Version:    0.7.0.1
 */