package kotlin.l.b.a.b.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.a.k;
import kotlin.g.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.l.b.a.b.a.i;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.d.b.o.a;
import kotlin.l.b.a.b.d.b.o.b;
import kotlin.l.b.a.b.d.b.o.c;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.j.e.e;

final class c
{
  public static final c aiMx;
  
  static
  {
    AppMethodBeat.i(57358);
    aiMx = new c();
    AppMethodBeat.o(57358);
  }
  
  public static void a(Class<?> paramClass, o.c paramc)
  {
    AppMethodBeat.i(57353);
    s.u(paramClass, "klass");
    s.u(paramc, "visitor");
    paramClass = paramClass.getDeclaredAnnotations();
    s.s(paramClass, "klass.declaredAnnotations");
    int i = 0;
    int j = paramClass.length;
    while (i < j)
    {
      Object localObject = paramClass[i];
      i += 1;
      s.s(localObject, "annotation");
      a(paramc, localObject);
    }
    paramc.azp();
    AppMethodBeat.o(57353);
  }
  
  private final void a(o.a parama, kotlin.l.b.a.b.f.f paramf, Object paramObject)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    AppMethodBeat.i(57357);
    Object localObject = paramObject.getClass();
    if (s.p(localObject, Class.class))
    {
      parama.a(paramf, cG((Class)paramObject));
      AppMethodBeat.o(57357);
      return;
    }
    if (h.kqp().contains(localObject))
    {
      parama.a(paramf, paramObject);
      AppMethodBeat.o(57357);
      return;
    }
    if (kotlin.l.b.a.b.b.e.b.b.cJ((Class)localObject))
    {
      if (((Class)localObject).isEnum()) {}
      for (;;)
      {
        s.s(localObject, "if (clazz.isEnum) clazz else clazz.enclosingClass");
        localObject = kotlin.l.b.a.b.b.e.b.b.cM((Class)localObject);
        paramObject = kotlin.l.b.a.b.f.f.bJe(((Enum)paramObject).name());
        s.s(paramObject, "identifier((value as Enum<*>).name)");
        parama.a(paramf, (kotlin.l.b.a.b.f.b)localObject, paramObject);
        AppMethodBeat.o(57357);
        return;
        localObject = ((Class)localObject).getEnclosingClass();
      }
    }
    if (Annotation.class.isAssignableFrom((Class)localObject))
    {
      localObject = ((Class)localObject).getInterfaces();
      s.s(localObject, "clazz.interfaces");
      localObject = (Class)k.aa((Object[])localObject);
      s.s(localObject, "annotationClass");
      parama = parama.a(paramf, kotlin.l.b.a.b.b.e.b.b.cM((Class)localObject));
      if (parama == null)
      {
        AppMethodBeat.o(57357);
        return;
      }
      a(parama, (Annotation)paramObject, (Class)localObject);
      AppMethodBeat.o(57357);
      return;
    }
    if (((Class)localObject).isArray())
    {
      parama = parama.o(paramf);
      if (parama == null)
      {
        AppMethodBeat.o(57357);
        return;
      }
      paramf = ((Class)localObject).getComponentType();
      if (paramf.isEnum())
      {
        s.s(paramf, "componentType");
        paramf = kotlin.l.b.a.b.b.e.b.b.cM(paramf);
        paramObject = (Object[])paramObject;
        j = paramObject.length;
        while (i < j)
        {
          localObject = paramObject[i];
          i += 1;
          if (localObject == null)
          {
            parama = new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
            AppMethodBeat.o(57357);
            throw parama;
          }
          localObject = kotlin.l.b.a.b.f.f.bJe(((Enum)localObject).name());
          s.s(localObject, "identifier((element as Enum<*>).name)");
          parama.a(paramf, (kotlin.l.b.a.b.f.f)localObject);
        }
      }
      if (s.p(paramf, Class.class))
      {
        paramf = (Object[])paramObject;
        k = paramf.length;
        i = j;
        while (i < k)
        {
          paramObject = paramf[i];
          i += 1;
          if (paramObject == null)
          {
            parama = new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
            AppMethodBeat.o(57357);
            throw parama;
          }
          parama.a(cG((Class)paramObject));
        }
      }
      if (Annotation.class.isAssignableFrom(paramf))
      {
        paramObject = (Object[])paramObject;
        int m = paramObject.length;
        i = k;
        while (i < m)
        {
          localObject = paramObject[i];
          j = i + 1;
          s.s(paramf, "componentType");
          o.a locala = parama.e(kotlin.l.b.a.b.b.e.b.b.cM(paramf));
          i = j;
          if (locala != null)
          {
            if (localObject == null)
            {
              parama = new NullPointerException("null cannot be cast to non-null type kotlin.Annotation");
              AppMethodBeat.o(57357);
              throw parama;
            }
            a(locala, (Annotation)localObject, paramf);
            i = j;
          }
        }
      }
      paramf = (Object[])paramObject;
      j = paramf.length;
      i = 0;
      while (i < j)
      {
        paramObject = paramf[i];
        i += 1;
        parama.hY(paramObject);
      }
      parama.azp();
      AppMethodBeat.o(57357);
      return;
    }
    parama = new UnsupportedOperationException("Unsupported annotation argument value (" + localObject + "): " + paramObject);
    AppMethodBeat.o(57357);
    throw parama;
  }
  
  static void a(o.c paramc, Annotation paramAnnotation)
  {
    AppMethodBeat.i(57354);
    Class localClass = a.b(a.a(paramAnnotation));
    paramc = paramc.a(kotlin.l.b.a.b.b.e.b.b.cM(localClass), (av)new b(paramAnnotation));
    if (paramc != null) {
      aiMx.a(paramc, paramAnnotation, localClass);
    }
    AppMethodBeat.o(57354);
  }
  
  private static kotlin.l.b.a.b.j.b.f cG(Class<?> paramClass)
  {
    AppMethodBeat.i(57356);
    int i = 0;
    while (paramClass.isArray())
    {
      paramClass = paramClass.getComponentType();
      s.s(paramClass, "currentClass.componentType");
      i += 1;
    }
    if (paramClass.isPrimitive())
    {
      if (s.p(paramClass, Void.TYPE))
      {
        paramClass = kotlin.l.b.a.b.f.b.s(k.a.aiCC.kxX());
        s.s(paramClass, "topLevel(StandardNames.FqNames.unit.toSafe())");
        paramClass = new kotlin.l.b.a.b.j.b.f(paramClass, i);
        AppMethodBeat.o(57356);
        return paramClass;
      }
      paramClass = e.bJq(paramClass.getName()).kzs();
      s.s(paramClass, "get(currentClass.name).primitiveType");
      if (i > 0)
      {
        paramClass = kotlin.l.b.a.b.f.b.s((kotlin.l.b.a.b.f.c)paramClass.aiBF.getValue());
        s.s(paramClass, "topLevel(primitiveType.arrayTypeFqName)");
        paramClass = new kotlin.l.b.a.b.j.b.f(paramClass, i - 1);
        AppMethodBeat.o(57356);
        return paramClass;
      }
      paramClass = kotlin.l.b.a.b.f.b.s((kotlin.l.b.a.b.f.c)paramClass.aiBE.getValue());
      s.s(paramClass, "topLevel(primitiveType.typeFqName)");
      paramClass = new kotlin.l.b.a.b.j.b.f(paramClass, i);
      AppMethodBeat.o(57356);
      return paramClass;
    }
    paramClass = kotlin.l.b.a.b.b.e.b.b.cM(paramClass);
    Object localObject = kotlin.l.b.a.b.a.b.c.aiEX;
    localObject = paramClass.kxQ();
    s.s(localObject, "javaClassId.asSingleFqName()");
    localObject = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.c)localObject);
    if (localObject == null) {}
    for (;;)
    {
      paramClass = new kotlin.l.b.a.b.j.b.f(paramClass, i);
      AppMethodBeat.o(57356);
      return paramClass;
      paramClass = (Class<?>)localObject;
    }
  }
  
  final void a(o.a parama, Annotation paramAnnotation, Class<?> paramClass)
  {
    int i = 0;
    AppMethodBeat.i(57355);
    paramClass = paramClass.getDeclaredMethods();
    s.s(paramClass, "annotationType.declaredMethods");
    int j = paramClass.length;
    for (;;)
    {
      kotlin.l.b.a.b.f.f localf;
      if (i < j)
      {
        localf = paramClass[i];
        i += 1;
      }
      try
      {
        Object localObject = localf.invoke(paramAnnotation, new Object[0]);
        s.checkNotNull(localObject);
        localf = kotlin.l.b.a.b.f.f.bJe(localf.getName());
        s.s(localf, "identifier(method.name)");
        a(parama, localf, localObject);
      }
      catch (IllegalAccessException localIllegalAccessException) {}
      parama.azp();
      AppMethodBeat.o(57355);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.a.c
 * JD-Core Version:    0.7.0.1
 */