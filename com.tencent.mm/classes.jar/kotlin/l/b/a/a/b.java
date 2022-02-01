package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.a.e;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.w;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection"})
public final class b
{
  public static final <T> T a(Class<T> paramClass, final Map<String, ? extends Object> paramMap, final List<Method> paramList)
  {
    AppMethodBeat.i(56585);
    p.h(paramClass, "annotationClass");
    p.h(paramMap, "values");
    p.h(paramList, "methods");
    final a locala = new a(paramClass, paramList, paramMap);
    final f localf1 = g.ah((kotlin.g.a.a)new b(paramMap));
    final f localf2 = g.ah((kotlin.g.a.a)new d(paramClass, paramMap));
    paramList = paramClass.getClassLoader();
    paramMap = (InvocationHandler)new c(paramClass, localf2, localf1, locala, paramMap);
    paramClass = Proxy.newProxyInstance(paramList, new Class[] { paramClass }, paramMap);
    if (paramClass == null)
    {
      paramClass = new t("null cannot be cast to non-null type T");
      AppMethodBeat.o(56585);
      throw paramClass;
    }
    AppMethodBeat.o(56585);
    return paramClass;
  }
  
  static final Object d(Object paramObject, Class<?> paramClass)
  {
    AppMethodBeat.i(186238);
    if ((paramObject instanceof Class))
    {
      AppMethodBeat.o(186238);
      return null;
    }
    Object localObject;
    if ((paramObject instanceof kotlin.l.b)) {
      localObject = kotlin.g.a.a((kotlin.l.b)paramObject);
    }
    while (paramClass.isInstance(localObject))
    {
      AppMethodBeat.o(186238);
      return localObject;
      localObject = paramObject;
      if ((paramObject instanceof Object[]))
      {
        if (((Object[])paramObject instanceof Class[]))
        {
          AppMethodBeat.o(186238);
          return null;
        }
        if (((Object[])paramObject instanceof kotlin.l.b[]))
        {
          if (paramObject == null)
          {
            paramObject = new t("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
            AppMethodBeat.o(186238);
            throw paramObject;
          }
          paramObject = (kotlin.l.b[])paramObject;
          localObject = (Collection)new ArrayList(paramObject.length);
          int j = paramObject.length;
          int i = 0;
          while (i < j)
          {
            ((Collection)localObject).add(kotlin.g.a.a(paramObject[i]));
            i += 1;
          }
          paramObject = ((Collection)localObject).toArray(new Class[0]);
          localObject = paramObject;
          if (paramObject == null)
          {
            paramObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(186238);
            throw paramObject;
          }
        }
        else
        {
          localObject = (Object[])paramObject;
        }
      }
    }
    AppMethodBeat.o(186238);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"equals", "", "T", "", "other", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Object, Boolean>
  {
    a(Class paramClass, List paramList, Map paramMap)
    {
      super();
    }
    
    public final boolean fj(Object paramObject)
    {
      Object localObject2 = null;
      AppMethodBeat.i(56578);
      if (!(paramObject instanceof Annotation)) {}
      for (Object localObject1 = null;; localObject1 = paramObject)
      {
        Object localObject3 = (Annotation)localObject1;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = kotlin.g.a.a((Annotation)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = kotlin.g.a.a((kotlin.l.b)localObject3);
          }
        }
        if (p.j(localObject1, this.TbZ))
        {
          localObject1 = (Iterable)paramList;
          boolean bool;
          if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
          {
            localObject1 = ((Iterable)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Method)((Iterator)localObject1).next();
              localObject3 = paramMap.get(((Method)localObject2).getName());
              localObject2 = ((Method)localObject2).invoke(paramObject, new Object[0]);
              if ((localObject3 instanceof boolean[]))
              {
                localObject3 = (boolean[])localObject3;
                if (localObject2 == null)
                {
                  paramObject = new t("null cannot be cast to non-null type kotlin.BooleanArray");
                  AppMethodBeat.o(56578);
                  throw paramObject;
                }
                bool = Arrays.equals((boolean[])localObject3, (boolean[])localObject2);
                label206:
                if (bool) {
                  break label640;
                }
              }
            }
          }
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label647;
            }
            AppMethodBeat.o(56578);
            return true;
            if ((localObject3 instanceof char[]))
            {
              localObject3 = (char[])localObject3;
              if (localObject2 == null)
              {
                paramObject = new t("null cannot be cast to non-null type kotlin.CharArray");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((char[])localObject3, (char[])localObject2);
              break label206;
            }
            if ((localObject3 instanceof byte[]))
            {
              localObject3 = (byte[])localObject3;
              if (localObject2 == null)
              {
                paramObject = new t("null cannot be cast to non-null type kotlin.ByteArray");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((byte[])localObject3, (byte[])localObject2);
              break label206;
            }
            if ((localObject3 instanceof short[]))
            {
              localObject3 = (short[])localObject3;
              if (localObject2 == null)
              {
                paramObject = new t("null cannot be cast to non-null type kotlin.ShortArray");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((short[])localObject3, (short[])localObject2);
              break label206;
            }
            if ((localObject3 instanceof int[]))
            {
              localObject3 = (int[])localObject3;
              if (localObject2 == null)
              {
                paramObject = new t("null cannot be cast to non-null type kotlin.IntArray");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((int[])localObject3, (int[])localObject2);
              break label206;
            }
            if ((localObject3 instanceof float[]))
            {
              localObject3 = (float[])localObject3;
              if (localObject2 == null)
              {
                paramObject = new t("null cannot be cast to non-null type kotlin.FloatArray");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((float[])localObject3, (float[])localObject2);
              break label206;
            }
            if ((localObject3 instanceof long[]))
            {
              localObject3 = (long[])localObject3;
              if (localObject2 == null)
              {
                paramObject = new t("null cannot be cast to non-null type kotlin.LongArray");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((long[])localObject3, (long[])localObject2);
              break label206;
            }
            if ((localObject3 instanceof double[]))
            {
              localObject3 = (double[])localObject3;
              if (localObject2 == null)
              {
                paramObject = new t("null cannot be cast to non-null type kotlin.DoubleArray");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((double[])localObject3, (double[])localObject2);
              break label206;
            }
            if ((localObject3 instanceof Object[]))
            {
              localObject3 = (Object[])localObject3;
              if (localObject2 == null)
              {
                paramObject = new t("null cannot be cast to non-null type kotlin.Array<*>");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((Object[])localObject3, (Object[])localObject2);
              break label206;
            }
            bool = p.j(localObject3, localObject2);
            break label206;
            label640:
            break;
          }
        }
        label647:
        AppMethodBeat.o(56578);
        return false;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Integer>
  {
    b(Map paramMap)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    implements InvocationHandler
  {
    c(Class paramClass, f paramf1, f paramf2, b.a parama, Map paramMap) {}
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56580);
      p.g(paramMethod, "method");
      paramObject = paramMethod.getName();
      if (paramObject == null) {}
      while ((p.j(paramObject, "equals")) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1))
      {
        boolean bool = locala.fj(e.T(paramArrayOfObject));
        AppMethodBeat.o(56580);
        return Boolean.valueOf(bool);
        switch (paramObject.hashCode())
        {
        default: 
          break;
        case -1776922004: 
          if (paramObject.equals("toString"))
          {
            paramObject = localf2.getValue();
            AppMethodBeat.o(56580);
            return paramObject;
          }
          break;
        case 147696667: 
          if (paramObject.equals("hashCode"))
          {
            paramObject = localf1.getValue();
            AppMethodBeat.o(56580);
            return paramObject;
          }
          break;
        case 1444986633: 
          if (paramObject.equals("annotationType"))
          {
            paramObject = this.TbZ;
            AppMethodBeat.o(56580);
            return paramObject;
          }
          break;
        }
      }
      if (paramMap.containsKey(paramObject))
      {
        paramObject = paramMap.get(paramObject);
        AppMethodBeat.o(56580);
        return paramObject;
      }
      paramMethod = new StringBuilder("Method is not supported: ").append(paramMethod).append(" (args: ");
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = new Object[0];
      }
      paramObject = (Throwable)new w(e.W(paramObject) + ')');
      AppMethodBeat.o(56580);
      throw paramObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<String>
  {
    d(Class paramClass, Map paramMap)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "", "entry", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<Map.Entry<? extends String, ? extends Object>, String>
    {
      public static final a Tcg;
      
      static
      {
        AppMethodBeat.i(56582);
        Tcg = new a();
        AppMethodBeat.o(56582);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.l.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */