package d.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.f;
import d.g;
import d.g.b.s;
import d.g.b.w;
import d.l.b.a.x;
import d.v;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection", "hashCode", "toString"})
public final class b
{
  static
  {
    AppMethodBeat.i(56584);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new s(w.g(b.class, "kotlin-reflection"), "hashCode", "<v#0>")), (d.l.k)w.a(new s(w.g(b.class, "kotlin-reflection"), "toString", "<v#1>")) };
    AppMethodBeat.o(56584);
  }
  
  public static final <T> T a(Class<T> paramClass, final Map<String, ? extends Object> paramMap, final List<Method> paramList)
  {
    AppMethodBeat.i(56585);
    d.g.b.k.h(paramClass, "annotationClass");
    d.g.b.k.h(paramMap, "values");
    d.g.b.k.h(paramList, "methods");
    final a locala = new a(paramClass, paramList, paramMap);
    final f localf1 = g.E((d.g.a.a)new b(paramMap));
    final d.l.k localk1 = $$delegatedProperties[0];
    final f localf2 = g.E((d.g.a.a)new b.d(paramClass, paramMap));
    final d.l.k localk2 = $$delegatedProperties[1];
    paramList = paramClass.getClassLoader();
    paramMap = (InvocationHandler)new c(paramClass, localf2, localk2, localf1, localk1, locala, paramMap);
    paramClass = Proxy.newProxyInstance(paramList, new Class[] { paramClass }, paramMap);
    if (paramClass == null)
    {
      paramClass = new v("null cannot be cast to non-null type T");
      AppMethodBeat.o(56585);
      throw paramClass;
    }
    AppMethodBeat.o(56585);
    return paramClass;
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"equals", "", "T", "", "other", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Object, Boolean>
  {
    a(Class paramClass, List paramList, Map paramMap)
    {
      super();
    }
    
    public final boolean eW(Object paramObject)
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
          localObject3 = d.g.a.a((Annotation)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = d.g.a.a((d.l.b)localObject3);
          }
        }
        if (d.g.b.k.g(localObject1, this.JkV))
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
                  paramObject = new v("null cannot be cast to non-null type kotlin.BooleanArray");
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
                paramObject = new v("null cannot be cast to non-null type kotlin.CharArray");
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
                paramObject = new v("null cannot be cast to non-null type kotlin.ByteArray");
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
                paramObject = new v("null cannot be cast to non-null type kotlin.ShortArray");
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
                paramObject = new v("null cannot be cast to non-null type kotlin.IntArray");
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
                paramObject = new v("null cannot be cast to non-null type kotlin.FloatArray");
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
                paramObject = new v("null cannot be cast to non-null type kotlin.LongArray");
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
                paramObject = new v("null cannot be cast to non-null type kotlin.DoubleArray");
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
                paramObject = new v("null cannot be cast to non-null type kotlin.Array<*>");
                AppMethodBeat.o(56578);
                throw paramObject;
              }
              bool = Arrays.equals((Object[])localObject3, (Object[])localObject2);
              break label206;
            }
            bool = d.g.b.k.g(localObject3, localObject2);
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
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "T", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    b(Map paramMap)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "T", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    implements InvocationHandler
  {
    c(Class paramClass, f paramf1, d.l.k paramk1, f paramf2, d.l.k paramk2, b.a parama, Map paramMap) {}
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56580);
      d.g.b.k.g(paramMethod, "method");
      paramObject = paramMethod.getName();
      if (paramObject == null) {}
      while ((d.g.b.k.g(paramObject, "equals")) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1))
      {
        boolean bool = locala.eW(e.Q(paramArrayOfObject));
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
            paramObject = this.JkV;
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
      paramObject = (Throwable)new x(e.T(paramObject) + ')');
      AppMethodBeat.o(56580);
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */