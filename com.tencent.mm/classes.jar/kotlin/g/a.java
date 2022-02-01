package kotlin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.h;
import kotlin.g.b.s;
import kotlin.l.c;

@Metadata(d1={""}, d2={"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class a
{
  public static final <T extends Annotation> c<? extends T> a(T paramT)
  {
    AppMethodBeat.i(129349);
    s.u(paramT, "$this$annotationClass");
    paramT = paramT.annotationType();
    s.s(paramT, "(this as java.lang.annot…otation).annotationType()");
    paramT = cx(paramT);
    if (paramT == null)
    {
      paramT = new NullPointerException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
      AppMethodBeat.o(129349);
      throw paramT;
    }
    AppMethodBeat.o(129349);
    return paramT;
  }
  
  public static final <T> Class<T> b(c<T> paramc)
  {
    AppMethodBeat.i(129345);
    s.u(paramc, "$this$java");
    paramc = ((h)paramc).kls();
    if (paramc == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
      AppMethodBeat.o(129345);
      throw paramc;
    }
    AppMethodBeat.o(129345);
    return paramc;
  }
  
  public static final <T> Class<T> c(c<T> paramc)
  {
    AppMethodBeat.i(129346);
    s.u(paramc, "$this$javaPrimitiveType");
    paramc = ((h)paramc).kls();
    if (paramc.isPrimitive())
    {
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        AppMethodBeat.o(129346);
        throw paramc;
      }
      AppMethodBeat.o(129346);
      return paramc;
    }
    paramc = paramc.getName();
    if (paramc == null) {}
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
                        switch (paramc.hashCode())
                        {
                        }
                      }
                    } while (!paramc.equals("java.lang.Integer"));
                    paramc = Integer.TYPE;
                    AppMethodBeat.o(129346);
                    return paramc;
                  } while (!paramc.equals("java.lang.Float"));
                  paramc = Float.TYPE;
                  AppMethodBeat.o(129346);
                  return paramc;
                } while (!paramc.equals("java.lang.Void"));
                paramc = Void.TYPE;
                AppMethodBeat.o(129346);
                return paramc;
              } while (!paramc.equals("java.lang.Character"));
              paramc = Character.TYPE;
              AppMethodBeat.o(129346);
              return paramc;
            } while (!paramc.equals("java.lang.Long"));
            paramc = Long.TYPE;
            AppMethodBeat.o(129346);
            return paramc;
          } while (!paramc.equals("java.lang.Double"));
          paramc = Double.TYPE;
          AppMethodBeat.o(129346);
          return paramc;
        } while (!paramc.equals("java.lang.Short"));
        paramc = Short.TYPE;
        AppMethodBeat.o(129346);
        return paramc;
      } while (!paramc.equals("java.lang.Boolean"));
      paramc = Boolean.TYPE;
      AppMethodBeat.o(129346);
      return paramc;
    } while (!paramc.equals("java.lang.Byte"));
    paramc = Byte.TYPE;
    AppMethodBeat.o(129346);
    return paramc;
  }
  
  public static final <T> c<T> cx(Class<T> paramClass)
  {
    AppMethodBeat.i(129348);
    s.u(paramClass, "$this$kotlin");
    paramClass = ai.cz(paramClass);
    AppMethodBeat.o(129348);
    return paramClass;
  }
  
  public static final <T> Class<T> d(c<T> paramc)
  {
    AppMethodBeat.i(129347);
    s.u(paramc, "$this$javaObjectType");
    paramc = ((h)paramc).kls();
    if (!paramc.isPrimitive())
    {
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        AppMethodBeat.o(129347);
        throw paramc;
      }
      AppMethodBeat.o(129347);
      return paramc;
    }
    String str = paramc.getName();
    if (str == null) {}
    while (paramc == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
      AppMethodBeat.o(129347);
      throw paramc;
      switch (str.hashCode())
      {
      default: 
        break;
      case -1325958191: 
        if (str.equals("double")) {
          paramc = Double.class;
        }
        break;
      case 64711720: 
        if (str.equals("boolean")) {
          paramc = Boolean.class;
        }
        break;
      case 3625364: 
        if (str.equals("void")) {
          paramc = Void.class;
        }
        break;
      case 3039496: 
        if (str.equals("byte")) {
          paramc = Byte.class;
        }
        break;
      case 3052374: 
        if (str.equals("char")) {
          paramc = Character.class;
        }
        break;
      case 109413500: 
        if (str.equals("short")) {
          paramc = Short.class;
        }
        break;
      case 97526364: 
        if (str.equals("float")) {
          paramc = Float.class;
        }
        break;
      case 104431: 
        if (str.equals("int")) {
          paramc = Integer.class;
        }
        break;
      case 3327612: 
        if (str.equals("long")) {
          paramc = Long.class;
        }
        break;
      }
    }
    AppMethodBeat.o(129347);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.g.a
 * JD-Core Version:    0.7.0.1
 */