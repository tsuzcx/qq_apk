package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

public abstract class i
  extends a
  implements Serializable
{
  protected i() {}
  
  protected i(byte paramByte) {}
  
  public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType paramContainingType, q paramq, int paramInt, z.a parama, Class paramClass)
  {
    return new f(paramContainingType, Collections.emptyList(), paramq, new i.e(paramInt, parama, true), paramClass);
  }
  
  public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType paramContainingType, Type paramType, q paramq, int paramInt, z.a parama, Class paramClass)
  {
    return new f(paramContainingType, paramType, paramq, new i.e(paramInt, parama, false), paramClass);
  }
  
  static Object c(Method paramMethod, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(null, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      if ((paramMethod instanceof Error)) {
        throw ((Error)paramMethod);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
    }
  }
  
  static Method d(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      paramClass = String.valueOf(String.valueOf(paramClass.getName()));
      paramString = String.valueOf(String.valueOf(paramString));
      throw new RuntimeException(paramClass.length() + 45 + paramString.length() + "Generated message class \"" + paramClass + "\" missing method \"" + paramString + "\".", paramVarArgs);
    }
  }
  
  protected boolean a(e parame, f paramf, g paramg, int paramInt)
  {
    return parame.a(paramInt, paramf);
  }
  
  public s<? extends q> gqQ()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected void gwp() {}
  
  public static final class f<ContainingType extends q, Type>
  {
    final ContainingType NOq;
    final q NOr;
    final i.e NOs;
    final Class NOt;
    final Method NOu;
    final Type aFh;
    
    f(ContainingType paramContainingType, Type paramType, q paramq, i.e parame, Class paramClass)
    {
      AppMethodBeat.i(59475);
      if (paramContainingType == null)
      {
        paramContainingType = new IllegalArgumentException("Null containingTypeDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      if ((parame.NOn == z.a.NPy) && (paramq == null))
      {
        paramContainingType = new IllegalArgumentException("Null messageDefaultInstance");
        AppMethodBeat.o(59475);
        throw paramContainingType;
      }
      this.NOq = paramContainingType;
      this.aFh = paramType;
      this.NOr = paramq;
      this.NOs = parame;
      this.NOt = paramClass;
      if (j.a.class.isAssignableFrom(paramClass))
      {
        this.NOu = i.d(paramClass, "valueOf", new Class[] { Integer.TYPE });
        AppMethodBeat.o(59475);
        return;
      }
      this.NOu = null;
      AppMethodBeat.o(59475);
    }
    
    final Object fs(Object paramObject)
    {
      AppMethodBeat.i(59476);
      if (this.NOs.NOn.NPG == z.b.NPQ)
      {
        paramObject = i.c(this.NOu, new Object[] { (Integer)paramObject });
        AppMethodBeat.o(59476);
        return paramObject;
      }
      AppMethodBeat.o(59476);
      return paramObject;
    }
    
    final Object ft(Object paramObject)
    {
      AppMethodBeat.i(59477);
      if (this.NOs.NOn.NPG == z.b.NPQ)
      {
        int i = ((j.a)paramObject).getNumber();
        AppMethodBeat.o(59477);
        return Integer.valueOf(i);
      }
      AppMethodBeat.o(59477);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.h.i
 * JD-Core Version:    0.7.0.1
 */