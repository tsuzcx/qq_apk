package d.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.g;
import d.g.b.p;
import d.g.b.z;
import d.l;
import d.l.b;
import d.v;
import java.lang.annotation.Annotation;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"})
public final class a
{
  public static final <T extends Annotation> b<? extends T> a(T paramT)
  {
    AppMethodBeat.i(129349);
    p.h(paramT, "$this$annotationClass");
    paramT = paramT.annotationType();
    p.g(paramT, "(this as java.lang.annot…otation).annotationType()");
    paramT = bo(paramT);
    if (paramT == null)
    {
      paramT = new v("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
      AppMethodBeat.o(129349);
      throw paramT;
    }
    AppMethodBeat.o(129349);
    return paramT;
  }
  
  public static final <T> Class<T> a(b<T> paramb)
  {
    AppMethodBeat.i(129345);
    p.h(paramb, "$this$java");
    paramb = ((g)paramb).gkv();
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type java.lang.Class<T>");
      AppMethodBeat.o(129345);
      throw paramb;
    }
    AppMethodBeat.o(129345);
    return paramb;
  }
  
  public static final <T> Class<T> b(b<T> paramb)
  {
    AppMethodBeat.i(129346);
    p.h(paramb, "$this$javaPrimitiveType");
    paramb = ((g)paramb).gkv();
    if (paramb.isPrimitive())
    {
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type java.lang.Class<T>");
        AppMethodBeat.o(129346);
        throw paramb;
      }
      AppMethodBeat.o(129346);
      return paramb;
    }
    paramb = paramb.getName();
    if (paramb == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      for (;;)
                      {
                        AppMethodBeat.o(129346);
                        return null;
                        switch (paramb.hashCode())
                        {
                        }
                      }
                    } while (!paramb.equals("java.lang.Integer"));
                    paramb = Integer.TYPE;
                    AppMethodBeat.o(129346);
                    return paramb;
                  } while (!paramb.equals("java.lang.Float"));
                  paramb = Float.TYPE;
                  AppMethodBeat.o(129346);
                  return paramb;
                } while (!paramb.equals("java.lang.Void"));
                paramb = Void.TYPE;
                AppMethodBeat.o(129346);
                return paramb;
              } while (!paramb.equals("java.lang.Character"));
              paramb = Character.TYPE;
              AppMethodBeat.o(129346);
              return paramb;
            } while (!paramb.equals("java.lang.Long"));
            paramb = Long.TYPE;
            AppMethodBeat.o(129346);
            return paramb;
          } while (!paramb.equals("java.lang.Double"));
          paramb = Double.TYPE;
          AppMethodBeat.o(129346);
          return paramb;
        } while (!paramb.equals("java.lang.Short"));
        paramb = Short.TYPE;
        AppMethodBeat.o(129346);
        return paramb;
      } while (!paramb.equals("java.lang.Boolean"));
      paramb = Boolean.TYPE;
      AppMethodBeat.o(129346);
      return paramb;
    } while (!paramb.equals("java.lang.Byte"));
    paramb = Byte.TYPE;
    AppMethodBeat.o(129346);
    return paramb;
  }
  
  public static final <T> b<T> bo(Class<T> paramClass)
  {
    AppMethodBeat.i(129348);
    p.h(paramClass, "$this$kotlin");
    paramClass = z.bp(paramClass);
    AppMethodBeat.o(129348);
    return paramClass;
  }
  
  public static final <T> Class<T> c(b<T> paramb)
  {
    AppMethodBeat.i(129347);
    p.h(paramb, "$this$javaObjectType");
    paramb = ((g)paramb).gkv();
    if (!paramb.isPrimitive())
    {
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type java.lang.Class<T>");
        AppMethodBeat.o(129347);
        throw paramb;
      }
      AppMethodBeat.o(129347);
      return paramb;
    }
    String str = paramb.getName();
    if (str == null) {}
    while (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type java.lang.Class<T>");
      AppMethodBeat.o(129347);
      throw paramb;
      switch (str.hashCode())
      {
      default: 
        break;
      case -1325958191: 
        if (str.equals("double")) {
          paramb = Double.class;
        }
        break;
      case 64711720: 
        if (str.equals("boolean")) {
          paramb = Boolean.class;
        }
        break;
      case 3625364: 
        if (str.equals("void")) {
          paramb = Void.class;
        }
        break;
      case 3039496: 
        if (str.equals("byte")) {
          paramb = Byte.class;
        }
        break;
      case 3052374: 
        if (str.equals("char")) {
          paramb = Character.class;
        }
        break;
      case 109413500: 
        if (str.equals("short")) {
          paramb = Short.class;
        }
        break;
      case 97526364: 
        if (str.equals("float")) {
          paramb = Float.class;
        }
        break;
      case 104431: 
        if (str.equals("int")) {
          paramb = Integer.class;
        }
        break;
      case 3327612: 
        if (str.equals("long")) {
          paramb = Long.class;
        }
        break;
      }
    }
    AppMethodBeat.o(129347);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.a
 * JD-Core Version:    0.7.0.1
 */