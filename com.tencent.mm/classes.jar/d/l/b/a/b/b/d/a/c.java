package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.an;
import d.l.b.a.b.d.b.p.a;
import d.l.b.a.b.d.b.p.b;
import d.l.b.a.b.d.b.p.c;
import d.l.b.a.b.j.e.d;
import d.v;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

final class c
{
  public static final c JvE;
  
  static
  {
    AppMethodBeat.i(57358);
    JvE = new c();
    AppMethodBeat.o(57358);
  }
  
  private final void a(p.a parama, d.l.b.a.b.f.f paramf, Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(57357);
    Object localObject = paramObject.getClass();
    if (k.g(localObject, Class.class))
    {
      if (paramObject == null)
      {
        parama = new v("null cannot be cast to non-null type java.lang.Class<*>");
        AppMethodBeat.o(57357);
        throw parama;
      }
      parama.a(paramf, bq((Class)paramObject));
      AppMethodBeat.o(57357);
      return;
    }
    if (h.fAu().contains(localObject))
    {
      parama.a(paramf, paramObject);
      AppMethodBeat.o(57357);
      return;
    }
    if (d.l.b.a.b.b.d.b.b.bt((Class)localObject))
    {
      if (((Class)localObject).isEnum()) {}
      for (;;)
      {
        k.g(localObject, "(if (clazz.isEnum) clazz…lse clazz.enclosingClass)");
        localObject = d.l.b.a.b.b.d.b.b.bw((Class)localObject);
        if (paramObject != null) {
          break;
        }
        parama = new v("null cannot be cast to non-null type kotlin.Enum<*>");
        AppMethodBeat.o(57357);
        throw parama;
        localObject = ((Class)localObject).getEnclosingClass();
      }
      paramObject = d.l.b.a.b.f.f.aQC(((Enum)paramObject).name());
      k.g(paramObject, "Name.identifier((value as Enum<*>).name)");
      parama.a(paramf, (d.l.b.a.b.f.a)localObject, paramObject);
      AppMethodBeat.o(57357);
      return;
    }
    if (Annotation.class.isAssignableFrom((Class)localObject))
    {
      localObject = ((Class)localObject).getInterfaces();
      k.g(localObject, "clazz.interfaces");
      localObject = (Class)e.Q((Object[])localObject);
      k.g(localObject, "annotationClass");
      parama = parama.a(paramf, d.l.b.a.b.b.d.b.b.bw((Class)localObject));
      if (parama == null)
      {
        AppMethodBeat.o(57357);
        return;
      }
      if (paramObject == null)
      {
        parama = new v("null cannot be cast to non-null type kotlin.Annotation");
        AppMethodBeat.o(57357);
        throw parama;
      }
      a(parama, (Annotation)paramObject, (Class)localObject);
      AppMethodBeat.o(57357);
      return;
    }
    if (((Class)localObject).isArray())
    {
      parama = parama.n(paramf);
      if (parama == null)
      {
        AppMethodBeat.o(57357);
        return;
      }
      paramf = ((Class)localObject).getComponentType();
      k.g(paramf, "componentType");
      if (paramf.isEnum())
      {
        paramf = d.l.b.a.b.b.d.b.b.bw(paramf);
        if (paramObject == null)
        {
          parama = new v("null cannot be cast to non-null type kotlin.Array<*>");
          AppMethodBeat.o(57357);
          throw parama;
        }
        paramObject = (Object[])paramObject;
        j = paramObject.length;
        i = 0;
        while (i < j)
        {
          localObject = paramObject[i];
          if (localObject == null)
          {
            parama = new v("null cannot be cast to non-null type kotlin.Enum<*>");
            AppMethodBeat.o(57357);
            throw parama;
          }
          localObject = d.l.b.a.b.f.f.aQC(((Enum)localObject).name());
          k.g(localObject, "Name.identifier((element as Enum<*>).name)");
          parama.a(paramf, (d.l.b.a.b.f.f)localObject);
          i += 1;
        }
      }
      if (k.g(paramf, Class.class))
      {
        if (paramObject == null)
        {
          parama = new v("null cannot be cast to non-null type kotlin.Array<*>");
          AppMethodBeat.o(57357);
          throw parama;
        }
        paramf = (Object[])paramObject;
        j = paramf.length;
        i = 0;
        while (i < j)
        {
          paramObject = paramf[i];
          if (paramObject == null)
          {
            parama = new v("null cannot be cast to non-null type java.lang.Class<*>");
            AppMethodBeat.o(57357);
            throw parama;
          }
          parama.a(bq((Class)paramObject));
          i += 1;
        }
      }
      if (paramObject == null)
      {
        parama = new v("null cannot be cast to non-null type kotlin.Array<*>");
        AppMethodBeat.o(57357);
        throw parama;
      }
      paramf = (Object[])paramObject;
      int j = paramf.length;
      while (i < j)
      {
        parama.fe(paramf[i]);
        i += 1;
      }
      parama.HB();
      AppMethodBeat.o(57357);
      return;
    }
    parama = (Throwable)new UnsupportedOperationException("Unsupported annotation argument value (" + localObject + "): " + paramObject);
    AppMethodBeat.o(57357);
    throw parama;
  }
  
  static void a(p.c paramc, Annotation paramAnnotation)
  {
    AppMethodBeat.i(57354);
    Class localClass = d.g.a.a(d.g.a.a(paramAnnotation));
    paramc = paramc.a(d.l.b.a.b.b.d.b.b.bw(localClass), (an)new b(paramAnnotation));
    if (paramc != null)
    {
      JvE.a(paramc, paramAnnotation, localClass);
      AppMethodBeat.o(57354);
      return;
    }
    AppMethodBeat.o(57354);
  }
  
  public static void a(Class<?> paramClass, p.c paramc)
  {
    AppMethodBeat.i(57353);
    k.h(paramClass, "klass");
    k.h(paramc, "visitor");
    paramClass = paramClass.getDeclaredAnnotations();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      k.g(localObject, "annotation");
      a(paramc, localObject);
      i += 1;
    }
    paramc.HB();
    AppMethodBeat.o(57353);
  }
  
  private static d.l.b.a.b.j.b.f bq(Class<?> paramClass)
  {
    AppMethodBeat.i(57356);
    int i = 0;
    while (paramClass.isArray())
    {
      i += 1;
      paramClass = paramClass.getComponentType();
      k.g(paramClass, "currentClass.componentType");
    }
    if (paramClass.isPrimitive())
    {
      if (k.g(paramClass, Void.TYPE))
      {
        paramClass = d.l.b.a.b.f.a.p(g.JlM.JlU.fHh());
        k.g(paramClass, "ClassId.topLevel(KotlinB…s.FQ_NAMES.unit.toSafe())");
        paramClass = new d.l.b.a.b.j.b.f(paramClass, i);
        AppMethodBeat.o(57356);
        return paramClass;
      }
      paramClass = d.aQP(paramClass.getName());
      k.g(paramClass, "JvmPrimitiveType.get(currentClass.name)");
      paramClass = paramClass.fJc();
      k.g(paramClass, "JvmPrimitiveType.get(cur…Class.name).primitiveType");
      if (i > 0)
      {
        if (paramClass.JnE != null)
        {
          localObject = paramClass.JnE;
          paramClass = (Class<?>)localObject;
          if (localObject == null)
          {
            d.l.b.a.b.a.h.adP(4);
            paramClass = (Class<?>)localObject;
          }
        }
        for (;;)
        {
          paramClass = d.l.b.a.b.f.a.p(paramClass);
          k.g(paramClass, "ClassId.topLevel(primitiveType.arrayTypeFqName)");
          paramClass = new d.l.b.a.b.j.b.f(paramClass, i - 1);
          AppMethodBeat.o(57356);
          return paramClass;
          paramClass.JnE = g.JlB.p(paramClass.JnC);
          localObject = paramClass.JnE;
          paramClass = (Class<?>)localObject;
          if (localObject == null)
          {
            d.l.b.a.b.a.h.adP(5);
            paramClass = (Class<?>)localObject;
          }
        }
      }
      if (paramClass.JnD != null)
      {
        localObject = paramClass.JnD;
        paramClass = (Class<?>)localObject;
        if (localObject == null)
        {
          d.l.b.a.b.a.h.adP(1);
          paramClass = (Class<?>)localObject;
        }
      }
      for (;;)
      {
        paramClass = d.l.b.a.b.f.a.p(paramClass);
        k.g(paramClass, "ClassId.topLevel(primitiveType.typeFqName)");
        paramClass = new d.l.b.a.b.j.b.f(paramClass, i);
        AppMethodBeat.o(57356);
        return paramClass;
        paramClass.JnD = g.JlB.p(paramClass.JnB);
        localObject = paramClass.JnD;
        paramClass = (Class<?>)localObject;
        if (localObject == null)
        {
          d.l.b.a.b.a.h.adP(2);
          paramClass = (Class<?>)localObject;
        }
      }
    }
    paramClass = d.l.b.a.b.b.d.b.b.bw(paramClass);
    Object localObject = d.l.b.a.b.a.b.c.JoY;
    localObject = paramClass.fHb();
    k.g(localObject, "javaClassId.asSingleFqName()");
    localObject = d.l.b.a.b.a.b.c.c((d.l.b.a.b.f.b)localObject);
    if (localObject == null) {}
    for (;;)
    {
      paramClass = new d.l.b.a.b.j.b.f(paramClass, i);
      AppMethodBeat.o(57356);
      return paramClass;
      paramClass = (Class<?>)localObject;
    }
  }
  
  final void a(p.a parama, Annotation paramAnnotation, Class<?> paramClass)
  {
    int i = 0;
    AppMethodBeat.i(57355);
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    while (i < j)
    {
      Object localObject2 = paramClass[i];
      try
      {
        Object localObject1 = ((Method)localObject2).invoke(paramAnnotation, new Object[0]);
        if (localObject1 == null) {
          k.fvU();
        }
        k.g(localObject2, "method");
        localObject2 = d.l.b.a.b.f.f.aQC(((Method)localObject2).getName());
        k.g(localObject2, "Name.identifier(method.name)");
        a(parama, (d.l.b.a.b.f.f)localObject2, localObject1);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label86:
        break label86;
      }
      i += 1;
    }
    parama.HB();
    AppMethodBeat.o(57355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.a.c
 * JD-Core Version:    0.7.0.1
 */