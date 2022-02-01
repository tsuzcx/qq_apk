package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.q;
import d.l.b.a.b.a.b.c.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.f.b;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bb;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.c.m;
import d.l.b.a.b.m.u;
import d.n.n;
import d.v;
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
      paraml = paraml.fk(paramT);
      AppMethodBeat.o(58274);
      return paraml;
    }
    AppMethodBeat.o(58274);
    return paramT;
  }
  
  private static <T> T a(d.l.b.a.b.m.ab paramab, l<T> paraml, y paramy, w<? extends T> paramw, i<T> parami, q<? super d.l.b.a.b.m.ab, ? super T, ? super y, d.y> paramq)
  {
    AppMethodBeat.i(58275);
    Object localObject2;
    for (;;)
    {
      d.g.b.k.h(paramab, "kotlinType");
      d.g.b.k.h(paraml, "factory");
      d.g.b.k.h(paramy, "mode");
      d.g.b.k.h(paramw, "typeMappingConfiguration");
      d.g.b.k.h(paramq, "writeGenericType");
      paramw.W(paramab);
      if (d.l.b.a.b.a.f.e(paramab))
      {
        paramab = (d.l.b.a.b.m.ab)d.l.b.a.b.a.k.E(paramab);
      }
      else
      {
        Object localObject1 = (bb)d.l.b.a.b.m.a.s.LMz;
        localObject2 = (d.l.b.a.b.m.c.g)paramab;
        d.g.b.k.h(localObject1, "$this$mapBuiltInType");
        d.g.b.k.h(localObject2, "type");
        d.g.b.k.h(paraml, "typeFactory");
        d.g.b.k.h(paramy, "mode");
        Object localObject3 = ((bb)localObject1).d((d.l.b.a.b.m.c.g)localObject2);
        boolean bool;
        if (((bb)localObject1).l((m)localObject3))
        {
          d.l.b.a.b.a.h localh = ((bb)localObject1).c((m)localObject3);
          if (localh != null)
          {
            localObject3 = d.l.b.a.b.j.e.d.d(localh);
            d.g.b.k.g(localObject3, "JvmPrimitiveType.get(primitiveType)");
            localObject3 = ((d.l.b.a.b.j.e.d)localObject3).getDesc();
            d.g.b.k.g(localObject3, "JvmPrimitiveType.get(primitiveType).desc");
            localObject3 = paraml.aWp((String)localObject3);
            if ((((bb)localObject1).s((d.l.b.a.b.m.c.g)localObject2)) || (d.l.b.a.b.d.a.f.s.a((bb)localObject1, (d.l.b.a.b.m.c.g)localObject2)))
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
          paraml = a(paraml, localObject1, paramy.Lsm);
          paramq.d(paramab, paraml, paramy);
          AppMethodBeat.o(58275);
          return paraml;
          bool = false;
          break;
          localObject2 = ((bb)localObject1).d((m)localObject3);
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder("[");
            localObject2 = d.l.b.a.b.j.e.d.d((d.l.b.a.b.a.h)localObject2);
            d.g.b.k.g(localObject2, "JvmPrimitiveType.get(arrayElementType)");
            localObject1 = paraml.aWp(((d.l.b.a.b.j.e.d)localObject2).getDesc());
          }
          else
          {
            if (((bb)localObject1).e((m)localObject3))
            {
              localObject1 = ((bb)localObject1).f((m)localObject3);
              if (localObject1 != null)
              {
                localObject2 = d.l.b.a.b.a.b.c.Lcr;
                localObject1 = d.l.b.a.b.a.b.c.c((d.l.b.a.b.f.c)localObject1);
                label359:
                if (localObject1 == null) {
                  break label506;
                }
                if (!paramy.Lsr)
                {
                  localObject2 = d.l.b.a.b.a.b.c.Lcr;
                  localObject2 = (Iterable)d.l.b.a.b.a.b.c.fQz();
                  if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                    break label500;
                  }
                  localObject2 = ((Iterable)localObject2).iterator();
                  do
                  {
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                  } while (!d.g.b.k.g(((c.a)((Iterator)localObject2).next()).Lcs, localObject1));
                }
              }
              label500:
              for (int i = 1;; i = 0)
              {
                if (i != 0) {
                  break label506;
                }
                localObject1 = d.l.b.a.b.j.e.c.e((d.l.b.a.b.f.a)localObject1);
                d.g.b.k.g(localObject1, "JvmClassName.byClassId(classId)");
                localObject1 = ((d.l.b.a.b.j.e.c)localObject1).gbE();
                d.g.b.k.g(localObject1, "JvmClassName.byClassId(classId).internalName");
                localObject1 = paraml.aWq((String)localObject1);
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
        localObject1 = paramab.gbz();
        if ((localObject1 instanceof d.l.b.a.b.m.aa))
        {
          paramab = d.l.b.a.b.m.d.a.aP(paramw.u((Collection)((d.l.b.a.b.m.aa)localObject1).LLj));
        }
        else
        {
          localObject2 = ((at)localObject1).fQq();
          if (localObject2 == null)
          {
            paramab = (Throwable)new UnsupportedOperationException("no descriptor for type constructor of ".concat(String.valueOf(paramab)));
            AppMethodBeat.o(58275);
            throw paramab;
          }
          d.g.b.k.g(localObject2, "constructor.declarationD…structor of $kotlinType\")");
          if (u.L((d.l.b.a.b.b.l)localObject2))
          {
            paraml = paraml.aWq("error/NonExistentClass");
            if (localObject2 == null)
            {
              paramab = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              AppMethodBeat.o(58275);
              throw paramab;
            }
            paramw.a(paramab, (e)localObject2);
            if (parami != null) {
              parami.fi(paraml);
            }
            AppMethodBeat.o(58275);
            return paraml;
          }
          if (((localObject2 instanceof e)) && (d.l.b.a.b.a.g.m(paramab)))
          {
            if (paramab.gbw().size() != 1)
            {
              paramab = (Throwable)new UnsupportedOperationException("arrays must have one type argument");
              AppMethodBeat.o(58275);
              throw paramab;
            }
            paramab = (av)paramab.gbw().get(0);
            localObject2 = paramab.fRV();
            d.g.b.k.g(localObject2, "memberProjection.type");
            if (paramab.gcC() == bh.LLW)
            {
              paramy = paraml.aWq("java/lang/Object");
              paramab = paramy;
              if (parami != null)
              {
                parami.fUH();
                parami.fi(paramy);
                paramab = paramy;
              }
              paramab = paraml.aWp("[" + paraml.toString(paramab));
              AppMethodBeat.o(58275);
              return paramab;
            }
            if (parami != null) {
              parami.fUH();
            }
            paramab = paramab.gcC();
            d.g.b.k.g(paramab, "memberProjection.projectionKind");
            d.g.b.k.h(paramab, "effectiveVariance");
            switch (z.cfA[paramab.ordinal()])
            {
            default: 
              localObject1 = paramy.Lsq;
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
              localObject1 = paramy.Lss;
              paramab = (d.l.b.a.b.m.ab)localObject1;
              if (localObject1 == null)
              {
                paramab = paramy;
                continue;
                localObject1 = paramy.Lst;
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
          if ((!((e)localObject2).fQf()) || (paramy.Lsn)) {
            break;
          }
          localObject1 = (bb)d.l.b.a.b.m.a.s.LMz;
          localObject3 = (d.l.b.a.b.m.c.g)paramab;
          d.g.b.k.h(localObject1, "$this$computeExpandedTypeForInlineClass");
          d.g.b.k.h(localObject3, "inlineClassType");
          localObject1 = (d.l.b.a.b.m.ab)f.a((bb)localObject1, (d.l.b.a.b.m.c.g)localObject3, new HashSet());
          if (localObject1 == null) {
            break;
          }
          paramy = new y(paramy.Lsm, true, paramy.Lpu, paramy.Lso, paramy.Lsp, paramy.Lsq, paramy.Lsr, paramy.Lss, paramy.Lst);
          paramab = (d.l.b.a.b.m.ab)localObject1;
        }
      }
    }
    if ((paramy.Lpu) && (d.l.b.a.b.a.g.g((e)localObject2)))
    {
      paraml = paraml.fUK();
      paramq.d(paramab, paraml, paramy);
      AppMethodBeat.o(58275);
      return paraml;
    }
    parami = ((e)localObject2).fRm();
    d.g.b.k.g(parami, "descriptor.original");
    paramw.t(parami);
    if (((e)localObject2).fPY() == d.l.b.a.b.b.f.Ldz)
    {
      parami = ((e)localObject2).fPU();
      if (parami == null)
      {
        paramab = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(58275);
        throw paramab;
      }
    }
    for (parami = (e)parami;; parami = (e)localObject2)
    {
      parami = parami.fRm();
      d.g.b.k.g(parami, "enumClassIfEnumEntry.original");
      paraml = paraml.aWq(a(parami, paramw));
      break;
    }
    label1264:
    if ((localObject2 instanceof as))
    {
      paramab = a(d.l.b.a.b.m.d.a.e((as)localObject2), paraml, paramy, paramw, null, d.l.b.a.b.o.d.gcM());
      if (parami != null)
      {
        paraml = ((d.l.b.a.b.b.h)localObject2).fRf();
        d.g.b.k.g(paraml, "descriptor.getName()");
        d.g.b.k.h(paraml, "name");
        d.g.b.k.h(paramab, "type");
        parami.fj(paramab);
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
    d.g.b.k.h(parame, "klass");
    d.g.b.k.h(paramw, "typeMappingConfiguration");
    paramw.v(parame);
    d.l.b.a.b.b.l locall = parame.fPU();
    d.g.b.k.g(locall, "klass.containingDeclaration");
    Object localObject = d.l.b.a.b.f.h.v(parame.fRf());
    d.g.b.k.g(localObject, "SpecialNames.safeIdentifier(klass.name)");
    String str = ((d.l.b.a.b.f.f)localObject).getIdentifier();
    d.g.b.k.g(str, "SpecialNames.safeIdentifier(klass.name).identifier");
    if ((locall instanceof d.l.b.a.b.b.ab))
    {
      paramw = ((d.l.b.a.b.b.ab)locall).fRH();
      if (paramw.Lzj.Lzo.isEmpty())
      {
        AppMethodBeat.o(58277);
        return str;
      }
      parame = new StringBuilder();
      paramw = paramw.rf();
      d.g.b.k.g(paramw, "fqName.asString()");
      parame = n.a(paramw, '.', '/') + '/' + str;
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