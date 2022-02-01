package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.b;

final class l
{
  public static final l TmT;
  
  static
  {
    AppMethodBeat.i(57391);
    TmT = new l();
    AppMethodBeat.o(57391);
  }
  
  public static String a(Constructor<?> paramConstructor)
  {
    AppMethodBeat.i(57389);
    p.h(paramConstructor, "constructor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    paramConstructor = paramConstructor.getParameterTypes();
    int j = paramConstructor.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConstructor[i];
      p.g(localObject, "parameterType");
      localStringBuilder.append(b.bC(localObject));
      i += 1;
    }
    localStringBuilder.append(")V");
    paramConstructor = localStringBuilder.toString();
    p.g(paramConstructor, "sb.toString()");
    AppMethodBeat.o(57389);
    return paramConstructor;
  }
  
  public static String d(Method paramMethod)
  {
    AppMethodBeat.i(57388);
    p.h(paramMethod, "method");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      p.g(localClass, "parameterType");
      localStringBuilder.append(b.bC(localClass));
      i += 1;
    }
    localStringBuilder.append(")");
    paramMethod = paramMethod.getReturnType();
    p.g(paramMethod, "method.returnType");
    localStringBuilder.append(b.bC(paramMethod));
    paramMethod = localStringBuilder.toString();
    p.g(paramMethod, "sb.toString()");
    AppMethodBeat.o(57388);
    return paramMethod;
  }
  
  public static String f(Field paramField)
  {
    AppMethodBeat.i(57390);
    p.h(paramField, "field");
    paramField = paramField.getType();
    p.g(paramField, "field.type");
    paramField = b.bC(paramField);
    AppMethodBeat.o(57390);
    return paramField;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.a.l
 * JD-Core Version:    0.7.0.1
 */