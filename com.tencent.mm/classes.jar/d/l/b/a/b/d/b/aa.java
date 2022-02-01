package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.q;
import d.g.b.p;
import d.l.b.a.b.a.b.c.a;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.k;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.f.b;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bb;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.u;
import d.v;
import d.z;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class aa
{
  private static final <T> T a(l<T> paraml, T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(58274);
    if (paramBoolean)
    {
      paraml = paraml.fp(paramT);
      AppMethodBeat.o(58274);
      return paraml;
    }
    AppMethodBeat.o(58274);
    return paramT;
  }
  
  private static <T> T a(d.l.b.a.b.m.ab paramab, l<T> paraml, y paramy, w<? extends T> paramw, i<T> parami, q<? super d.l.b.a.b.m.ab, ? super T, ? super y, z> paramq)
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
      paramw.W(paramab);
      if (d.l.b.a.b.a.f.e(paramab))
      {
        paramab = (d.l.b.a.b.m.ab)k.E(paramab);
      }
      else
      {
        Object localObject1 = (bb)d.l.b.a.b.m.a.s.OaB;
        localObject2 = (d.l.b.a.b.m.c.h)paramab;
        p.h(localObject1, "$this$mapBuiltInType");
        p.h(localObject2, "type");
        p.h(paraml, "typeFactory");
        p.h(paramy, "mode");
        Object localObject3 = ((bb)localObject1).d((d.l.b.a.b.m.c.h)localObject2);
        boolean bool;
        if (((bb)localObject1).l((d.l.b.a.b.m.c.n)localObject3))
        {
          d.l.b.a.b.a.h localh = ((bb)localObject1).c((d.l.b.a.b.m.c.n)localObject3);
          if (localh != null)
          {
            localObject3 = d.l.b.a.b.j.e.d.d(localh);
            p.g(localObject3, "JvmPrimitiveType.get(primitiveType)");
            localObject3 = ((d.l.b.a.b.j.e.d)localObject3).getDesc();
            p.g(localObject3, "JvmPrimitiveType.get(primitiveType).desc");
            localObject3 = paraml.bdW((String)localObject3);
            if ((((bb)localObject1).s((d.l.b.a.b.m.c.h)localObject2)) || (d.l.b.a.b.d.a.f.s.a((bb)localObject1, (d.l.b.a.b.m.c.h)localObject2)))
            {
              bool = true;
              localObject1 = a(paraml, localObject3, bool);
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label512;
          }
          paraml = a(paraml, localObject1, paramy.NGp);
          paramq.d(paramab, paraml, paramy);
          AppMethodBeat.o(58275);
          return paraml;
          bool = false;
          break;
          localObject2 = ((bb)localObject1).d((d.l.b.a.b.m.c.n)localObject3);
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder("[");
            localObject2 = d.l.b.a.b.j.e.d.d((d.l.b.a.b.a.h)localObject2);
            p.g(localObject2, "JvmPrimitiveType.get(arrayElementType)");
            localObject1 = paraml.bdW(((d.l.b.a.b.j.e.d)localObject2).getDesc());
          }
          else
          {
            if (((bb)localObject1).e((d.l.b.a.b.m.c.n)localObject3))
            {
              localObject1 = ((bb)localObject1).f((d.l.b.a.b.m.c.n)localObject3);
              if (localObject1 != null)
              {
                localObject2 = d.l.b.a.b.a.b.c.Nqr;
                localObject1 = d.l.b.a.b.a.b.c.c((d.l.b.a.b.f.c)localObject1);
                label359:
                if (localObject1 == null) {
                  break label506;
                }
                if (!paramy.NGu)
                {
                  localObject2 = d.l.b.a.b.a.b.c.Nqr;
                  localObject2 = (Iterable)d.l.b.a.b.a.b.c.gmz();
                  if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                    break label500;
                  }
                  localObject2 = ((Iterable)localObject2).iterator();
                  do
                  {
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                  } while (!p.i(((c.a)((Iterator)localObject2).next()).Nqs, localObject1));
                }
              }
              label500:
              for (int i = 1;; i = 0)
              {
                if (i != 0) {
                  break label506;
                }
                localObject1 = d.l.b.a.b.j.e.c.e((d.l.b.a.b.f.a)localObject1);
                p.g(localObject1, "JvmClassName.byClassId(classId)");
                localObject1 = ((d.l.b.a.b.j.e.c)localObject1).gxF();
                p.g(localObject1, "JvmClassName.byClassId(classId).internalName");
                localObject1 = paraml.bdX((String)localObject1);
                break;
                localObject1 = null;
                break label359;
              }
            }
            label506:
            localObject1 = null;
          }
        }
        label512:
        localObject1 = paramab.gxB();
        if ((localObject1 instanceof d.l.b.a.b.m.aa))
        {
          paramab = d.l.b.a.b.m.d.a.aP(paramw.v((Collection)((d.l.b.a.b.m.aa)localObject1).NZl));
        }
        else
        {
          localObject2 = ((at)localObject1).gmq();
          if (localObject2 == null)
          {
            paramab = (Throwable)new UnsupportedOperationException("no descriptor for type constructor of ".concat(String.valueOf(paramab)));
            AppMethodBeat.o(58275);
            throw paramab;
          }
          p.g(localObject2, "constructor.declarationD…structor of $kotlinType\")");
          if (u.L((d.l.b.a.b.b.l)localObject2))
          {
            paraml = paraml.bdX("error/NonExistentClass");
            if (localObject2 == null)
            {
              paramab = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              AppMethodBeat.o(58275);
              throw paramab;
            }
            paramw.a(paramab, (e)localObject2);
            if (parami != null) {
              parami.fn(paraml);
            }
            AppMethodBeat.o(58275);
            return paraml;
          }
          if (((localObject2 instanceof e)) && (g.m(paramab)))
          {
            if (paramab.gxy().size() != 1)
            {
              paramab = (Throwable)new UnsupportedOperationException("arrays must have one type argument");
              AppMethodBeat.o(58275);
              throw paramab;
            }
            paramab = (av)paramab.gxy().get(0);
            localObject2 = paramab.gnW();
            p.g(localObject2, "memberProjection.type");
            if (paramab.gyF() == bh.NZX)
            {
              paramy = paraml.bdX("java/lang/Object");
              paramab = paramy;
              if (parami != null)
              {
                parami.gqI();
                parami.fn(paramy);
                paramab = paramy;
              }
              paramab = paraml.bdW("[" + paraml.toString(paramab));
              AppMethodBeat.o(58275);
              return paramab;
            }
            if (parami != null) {
              parami.gqI();
            }
            paramab = paramab.gyF();
            p.g(paramab, "memberProjection.projectionKind");
            p.h(paramab, "effectiveVariance");
            switch (z.cqt[paramab.ordinal()])
            {
            default: 
              localObject1 = paramy.NGt;
              paramab = (d.l.b.a.b.m.ab)localObject1;
              if (localObject1 == null) {
                paramab = paramy;
              }
              break;
            }
            for (;;)
            {
              paramab = a((d.l.b.a.b.m.ab)localObject2, paraml, paramab, paramw, parami, paramq);
              break;
              localObject1 = paramy.NGv;
              paramab = (d.l.b.a.b.m.ab)localObject1;
              if (localObject1 == null)
              {
                paramab = paramy;
                continue;
                localObject1 = paramy.NGw;
                paramab = (d.l.b.a.b.m.ab)localObject1;
                if (localObject1 == null) {
                  paramab = paramy;
                }
              }
            }
          }
          if (!(localObject2 instanceof e)) {
            break label1264;
          }
          if ((!((e)localObject2).gmf()) || (paramy.NGq)) {
            break;
          }
          localObject1 = (bb)d.l.b.a.b.m.a.s.OaB;
          localObject3 = (d.l.b.a.b.m.c.h)paramab;
          p.h(localObject1, "$this$computeExpandedTypeForInlineClass");
          p.h(localObject3, "inlineClassType");
          localObject1 = (d.l.b.a.b.m.ab)f.a((bb)localObject1, (d.l.b.a.b.m.c.h)localObject3, new HashSet());
          if (localObject1 == null) {
            break;
          }
          paramy = new y(paramy.NGp, true, paramy.NDw, paramy.NGr, paramy.NGs, paramy.NGt, paramy.NGu, paramy.NGv, paramy.NGw);
          paramab = (d.l.b.a.b.m.ab)localObject1;
        }
      }
    }
    if ((paramy.NDw) && (g.g((e)localObject2)))
    {
      paraml = paraml.gqL();
      paramq.d(paramab, paraml, paramy);
      AppMethodBeat.o(58275);
      return paraml;
    }
    parami = ((e)localObject2).gnn();
    p.g(parami, "descriptor.original");
    paramw.t(parami);
    if (((e)localObject2).glY() == d.l.b.a.b.b.f.Nrz)
    {
      parami = ((e)localObject2).glU();
      if (parami == null)
      {
        paramab = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(58275);
        throw paramab;
      }
    }
    for (parami = (e)parami;; parami = (e)localObject2)
    {
      parami = parami.gnn();
      p.g(parami, "enumClassIfEnumEntry.original");
      paraml = paraml.bdX(a(parami, paramw));
      break;
    }
    label1264:
    if ((localObject2 instanceof as))
    {
      paramab = a(d.l.b.a.b.m.d.a.e((as)localObject2), paraml, paramy, paramw, null, d.l.b.a.b.o.d.gyP());
      if (parami != null)
      {
        paraml = ((d.l.b.a.b.b.h)localObject2).gnf();
        p.g(paraml, "descriptor.getName()");
        p.h(paraml, "name");
        p.h(paramab, "type");
        parami.fo(paramab);
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
    d.l.b.a.b.b.l locall = parame.glU();
    p.g(locall, "klass.containingDeclaration");
    Object localObject = d.l.b.a.b.f.h.v(parame.gnf());
    p.g(localObject, "SpecialNames.safeIdentifier(klass.name)");
    String str = ((d.l.b.a.b.f.f)localObject).getIdentifier();
    p.g(str, "SpecialNames.safeIdentifier(klass.name).identifier");
    if ((locall instanceof d.l.b.a.b.b.ab))
    {
      paramw = ((d.l.b.a.b.b.ab)locall).gnI();
      if (paramw.NNm.NNr.isEmpty())
      {
        AppMethodBeat.o(58277);
        return str;
      }
      parame = new StringBuilder();
      paramw = paramw.sD();
      p.g(paramw, "fqName.asString()");
      parame = d.n.n.a(paramw, '.', '/') + '/' + str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.aa
 * JD-Core Version:    0.7.0.1
 */