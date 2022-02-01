package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.b.p;
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
  public static final c NwZ;
  
  static
  {
    AppMethodBeat.i(57358);
    NwZ = new c();
    AppMethodBeat.o(57358);
  }
  
  private final void a(p.a parama, d.l.b.a.b.f.f paramf, Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(57357);
    Object localObject = paramObject.getClass();
    if (p.i(localObject, Class.class))
    {
      if (paramObject == null)
      {
        parama = new v("null cannot be cast to non-null type java.lang.Class<*>");
        AppMethodBeat.o(57357);
        throw parama;
      }
      parama.a(paramf, bv((Class)paramObject));
      AppMethodBeat.o(57357);
      return;
    }
    if (h.goZ().contains(localObject))
    {
      parama.a(paramf, paramObject);
      AppMethodBeat.o(57357);
      return;
    }
    if (d.l.b.a.b.b.d.b.b.by((Class)localObject))
    {
      if (((Class)localObject).isEnum()) {}
      for (;;)
      {
        p.g(localObject, "(if (clazz.isEnum) clazz…lse clazz.enclosingClass)");
        localObject = d.l.b.a.b.b.d.b.b.bB((Class)localObject);
        if (paramObject != null) {
          break;
        }
        parama = new v("null cannot be cast to non-null type kotlin.Enum<*>");
        AppMethodBeat.o(57357);
        throw parama;
        localObject = ((Class)localObject).getEnclosingClass();
      }
      paramObject = d.l.b.a.b.f.f.bei(((Enum)paramObject).name());
      p.g(paramObject, "Name.identifier((value as Enum<*>).name)");
      parama.a(paramf, (d.l.b.a.b.f.a)localObject, paramObject);
      AppMethodBeat.o(57357);
      return;
    }
    if (Annotation.class.isAssignableFrom((Class)localObject))
    {
      localObject = ((Class)localObject).getInterfaces();
      p.g(localObject, "clazz.interfaces");
      localObject = (Class)e.S((Object[])localObject);
      p.g(localObject, "annotationClass");
      parama = parama.a(paramf, d.l.b.a.b.b.d.b.b.bB((Class)localObject));
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
      p.g(paramf, "componentType");
      if (paramf.isEnum())
      {
        paramf = d.l.b.a.b.b.d.b.b.bB(paramf);
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
          localObject = d.l.b.a.b.f.f.bei(((Enum)localObject).name());
          p.g(localObject, "Name.identifier((element as Enum<*>).name)");
          parama.a(paramf, (d.l.b.a.b.f.f)localObject);
          i += 1;
        }
      }
      if (p.i(paramf, Class.class))
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
          parama.a(bv((Class)paramObject));
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
        parama.fm(paramf[i]);
        i += 1;
      }
      parama.IP();
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
    paramc = paramc.a(d.l.b.a.b.b.d.b.b.bB(localClass), (an)new b(paramAnnotation));
    if (paramc != null)
    {
      NwZ.a(paramc, paramAnnotation, localClass);
      AppMethodBeat.o(57354);
      return;
    }
    AppMethodBeat.o(57354);
  }
  
  public static void a(Class<?> paramClass, p.c paramc)
  {
    AppMethodBeat.i(57353);
    p.h(paramClass, "klass");
    p.h(paramc, "visitor");
    paramClass = paramClass.getDeclaredAnnotations();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      p.g(localObject, "annotation");
      a(paramc, localObject);
      i += 1;
    }
    paramc.IP();
    AppMethodBeat.o(57353);
  }
  
  private static d.l.b.a.b.j.b.f bv(Class<?> paramClass)
  {
    AppMethodBeat.i(57356);
    int i = 0;
    while (paramClass.isArray())
    {
      i += 1;
      paramClass = paramClass.getComponentType();
      p.g(paramClass, "currentClass.componentType");
    }
    if (paramClass.isPrimitive())
    {
      if (p.i(paramClass, Void.TYPE))
      {
        paramClass = d.l.b.a.b.f.a.p(g.Nng.Nno.gvM());
        p.g(paramClass, "ClassId.topLevel(KotlinB…s.FQ_NAMES.unit.toSafe())");
        paramClass = new d.l.b.a.b.j.b.f(paramClass, i);
        AppMethodBeat.o(57356);
        return paramClass;
      }
      paramClass = d.bev(paramClass.getName());
      p.g(paramClass, "JvmPrimitiveType.get(currentClass.name)");
      paramClass = paramClass.gxG();
      p.g(paramClass, "JvmPrimitiveType.get(cur…Class.name).primitiveType");
      if (i > 0)
      {
        if (paramClass.NoY != null)
        {
          localObject = paramClass.NoY;
          paramClass = (Class<?>)localObject;
          if (localObject == null)
          {
            d.l.b.a.b.a.h.ajW(4);
            paramClass = (Class<?>)localObject;
          }
        }
        for (;;)
        {
          paramClass = d.l.b.a.b.f.a.p(paramClass);
          p.g(paramClass, "ClassId.topLevel(primitiveType.arrayTypeFqName)");
          paramClass = new d.l.b.a.b.j.b.f(paramClass, i - 1);
          AppMethodBeat.o(57356);
          return paramClass;
          paramClass.NoY = g.NmV.p(paramClass.NoW);
          localObject = paramClass.NoY;
          paramClass = (Class<?>)localObject;
          if (localObject == null)
          {
            d.l.b.a.b.a.h.ajW(5);
            paramClass = (Class<?>)localObject;
          }
        }
      }
      if (paramClass.NoX != null)
      {
        localObject = paramClass.NoX;
        paramClass = (Class<?>)localObject;
        if (localObject == null)
        {
          d.l.b.a.b.a.h.ajW(1);
          paramClass = (Class<?>)localObject;
        }
      }
      for (;;)
      {
        paramClass = d.l.b.a.b.f.a.p(paramClass);
        p.g(paramClass, "ClassId.topLevel(primitiveType.typeFqName)");
        paramClass = new d.l.b.a.b.j.b.f(paramClass, i);
        AppMethodBeat.o(57356);
        return paramClass;
        paramClass.NoX = g.NmV.p(paramClass.NoV);
        localObject = paramClass.NoX;
        paramClass = (Class<?>)localObject;
        if (localObject == null)
        {
          d.l.b.a.b.a.h.ajW(2);
          paramClass = (Class<?>)localObject;
        }
      }
    }
    paramClass = d.l.b.a.b.b.d.b.b.bB(paramClass);
    Object localObject = d.l.b.a.b.a.b.c.Nqr;
    localObject = paramClass.gvG();
    p.g(localObject, "javaClassId.asSingleFqName()");
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
          p.gkB();
        }
        p.g(localObject2, "method");
        localObject2 = d.l.b.a.b.f.f.bei(((Method)localObject2).getName());
        p.g(localObject2, "Name.identifier(method.name)");
        a(parama, (d.l.b.a.b.f.f)localObject2, localObject1);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label86:
        break label86;
      }
      i += 1;
    }
    parama.IP();
    AppMethodBeat.o(57355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.a.c
 * JD-Core Version:    0.7.0.1
 */