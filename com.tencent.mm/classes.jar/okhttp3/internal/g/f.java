package okhttp3.internal.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class f<T>
{
  private final Class<?> ajSA;
  private final String ajSB;
  private final Class[] ajSC;
  
  f(Class<?> paramClass, String paramString, Class... paramVarArgs)
  {
    this.ajSA = paramClass;
    this.ajSB = paramString;
    this.ajSC = paramVarArgs;
  }
  
  private Object a(T paramT, Object... paramVarArgs)
  {
    AppMethodBeat.i(187094);
    Method localMethod = cO(paramT.getClass());
    if (localMethod == null)
    {
      paramT = new AssertionError("Method " + this.ajSB + " not supported for object " + paramT);
      AppMethodBeat.o(187094);
      throw paramT;
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      AppMethodBeat.o(187094);
      return paramT;
    }
    catch (IllegalAccessException paramT)
    {
      paramVarArgs = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(localMethod)));
      paramVarArgs.initCause(paramT);
      AppMethodBeat.o(187094);
      throw paramVarArgs;
    }
  }
  
  private Method cO(Class<?> paramClass)
  {
    Object localObject2 = null;
    AppMethodBeat.i(187105);
    Object localObject1 = localObject2;
    if (this.ajSB != null)
    {
      localObject1 = d(paramClass, this.ajSB, this.ajSC);
      if ((localObject1 == null) || (this.ajSA == null) || (this.ajSA.isAssignableFrom(((Method)localObject1).getReturnType()))) {
        break label63;
      }
      localObject1 = localObject2;
    }
    label63:
    for (;;)
    {
      AppMethodBeat.o(187105);
      return localObject1;
    }
  }
  
  private Object d(T paramT, Object... paramVarArgs)
  {
    AppMethodBeat.i(187083);
    Method localMethod = cO(paramT.getClass());
    if (localMethod == null)
    {
      AppMethodBeat.o(187083);
      return null;
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      AppMethodBeat.o(187083);
      return paramT;
    }
    catch (IllegalAccessException paramT)
    {
      AppMethodBeat.o(187083);
    }
    return null;
  }
  
  private static Method d(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    localObject = null;
    AppMethodBeat.i(187120);
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        int i;
        label29:
        paramClass = localObject;
      }
    }
    try
    {
      i = paramClass.getModifiers();
      if ((i & 0x1) != 0) {
        break label47;
      }
      paramClass = localObject;
    }
    catch (NoSuchMethodException paramString)
    {
      break label29;
      break label29;
    }
    AppMethodBeat.o(187120);
    return paramClass;
  }
  
  public final Object e(T paramT, Object... paramVarArgs)
  {
    AppMethodBeat.i(187136);
    try
    {
      paramT = d(paramT, paramVarArgs);
      AppMethodBeat.o(187136);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException))
      {
        paramT = (RuntimeException)paramT;
        AppMethodBeat.o(187136);
        throw paramT;
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      AppMethodBeat.o(187136);
      throw paramVarArgs;
    }
  }
  
  public final Object f(T paramT, Object... paramVarArgs)
  {
    AppMethodBeat.i(187142);
    try
    {
      paramT = a(paramT, paramVarArgs);
      AppMethodBeat.o(187142);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException))
      {
        paramT = (RuntimeException)paramT;
        AppMethodBeat.o(187142);
        throw paramT;
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      AppMethodBeat.o(187142);
      throw paramVarArgs;
    }
  }
  
  public final boolean jJ(T paramT)
  {
    AppMethodBeat.i(187127);
    if (cO(paramT.getClass()) != null)
    {
      AppMethodBeat.o(187127);
      return true;
    }
    AppMethodBeat.o(187127);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     okhttp3.internal.g.f
 * JD-Core Version:    0.7.0.1
 */