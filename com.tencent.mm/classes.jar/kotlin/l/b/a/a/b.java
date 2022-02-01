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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.l.b.a.aa;
import kotlin.l.c;

@Metadata(d1={""}, d2={"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection"}, k=2, mv={1, 5, 1})
public final class b
{
  public static final <T> T a(Class<T> paramClass, final Map<String, ? extends Object> paramMap, final List<Method> paramList)
  {
    AppMethodBeat.i(56585);
    s.u(paramClass, "annotationClass");
    s.u(paramMap, "values");
    s.u(paramList, "methods");
    final a locala = new a(paramClass, paramList, paramMap);
    final j localj1 = kotlin.k.cm((kotlin.g.a.a)new b(paramMap));
    final j localj2 = kotlin.k.cm((kotlin.g.a.a)new b.d(paramClass, paramMap));
    paramList = paramClass.getClassLoader();
    paramMap = (InvocationHandler)new c(paramClass, localj2, localj1, locala, paramMap);
    paramClass = Proxy.newProxyInstance(paramList, new Class[] { paramClass }, paramMap);
    if (paramClass == null)
    {
      paramClass = new NullPointerException("null cannot be cast to non-null type T");
      AppMethodBeat.o(56585);
      throw paramClass;
    }
    AppMethodBeat.o(56585);
    return paramClass;
  }
  
  static final Object e(Object paramObject, Class<?> paramClass)
  {
    AppMethodBeat.i(191371);
    if ((paramObject instanceof Class))
    {
      AppMethodBeat.o(191371);
      return null;
    }
    Object localObject;
    if ((paramObject instanceof c)) {
      localObject = kotlin.g.a.b((c)paramObject);
    }
    while (paramClass.isInstance(localObject))
    {
      AppMethodBeat.o(191371);
      return localObject;
      localObject = paramObject;
      if ((paramObject instanceof Object[]))
      {
        if (((Object[])paramObject instanceof Class[]))
        {
          AppMethodBeat.o(191371);
          return null;
        }
        if (((Object[])paramObject instanceof c[]))
        {
          if (paramObject == null)
          {
            paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
            AppMethodBeat.o(191371);
            throw paramObject;
          }
          paramObject = (c[])paramObject;
          localObject = (Collection)new ArrayList(paramObject.length);
          int j = paramObject.length;
          int i = 0;
          while (i < j)
          {
            ((Collection)localObject).add(kotlin.g.a.b(paramObject[i]));
            i += 1;
          }
          paramObject = ((Collection)localObject).toArray(new Class[0]);
          localObject = paramObject;
          if (paramObject == null)
          {
            paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(191371);
            throw paramObject;
          }
        }
        else
        {
          localObject = (Object[])paramObject;
        }
      }
    }
    AppMethodBeat.o(191371);
    return null;
  }
  
  @Metadata(d1={""}, d2={"equals", "", "T", "", "other", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends u
    implements kotlin.g.a.b<Object, Boolean>
  {
    a(Class paramClass, List paramList, Map paramMap)
    {
      super();
    }
    
    public final boolean hQ(Object paramObject)
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
            localObject1 = kotlin.g.a.b((c)localObject3);
          }
        }
        if (s.p(localObject1, this.aiAK))
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
                  paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.BooleanArray");
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
                paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.CharArray");
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
                paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
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
                paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.ShortArray");
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
                paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.IntArray");
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
                paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.FloatArray");
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
                paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.LongArray");
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
                paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.DoubleArray");
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
                paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((Object[])localObject3, (Object[])localObject2);
              break label206;
            }
            bool = s.p(localObject3, localObject2);
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    b(Map paramMap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "T", "<anonymous parameter 0>", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
  static final class c
    implements InvocationHandler
  {
    c(Class paramClass, j paramj1, j paramj2, b.a parama, Map paramMap) {}
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56580);
      s.s(paramMethod, "method");
      paramObject = paramMethod.getName();
      if (paramObject == null) {}
      while ((s.p(paramObject, "equals")) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1))
      {
        boolean bool = locala.hQ(kotlin.a.k.aa(paramArrayOfObject));
        AppMethodBeat.o(56580);
        return Boolean.valueOf(bool);
        switch (paramObject.hashCode())
        {
        default: 
          break;
        case -1776922004: 
          if (paramObject.equals("toString"))
          {
            paramObject = localj2.getValue();
            AppMethodBeat.o(56580);
            return paramObject;
          }
          break;
        case 147696667: 
          if (paramObject.equals("hashCode"))
          {
            paramObject = localj1.getValue();
            AppMethodBeat.o(56580);
            return paramObject;
          }
          break;
        case 1444986633: 
          if (paramObject.equals("annotationType"))
          {
            paramObject = this.aiAK;
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
      paramObject = (Throwable)new aa(kotlin.a.k.ae(paramObject) + ')');
      AppMethodBeat.o(56580);
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */