package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.d.b.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class l
{
  public static final l Ljj;
  
  static
  {
    AppMethodBeat.i(57391);
    Ljj = new l();
    AppMethodBeat.o(57391);
  }
  
  public static String a(Constructor<?> paramConstructor)
  {
    AppMethodBeat.i(57389);
    k.h(paramConstructor, "constructor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    paramConstructor = paramConstructor.getParameterTypes();
    int j = paramConstructor.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConstructor[i];
      k.g(localObject, "parameterType");
      localStringBuilder.append(b.bA(localObject));
      i += 1;
    }
    localStringBuilder.append(")V");
    paramConstructor = localStringBuilder.toString();
    k.g(paramConstructor, "sb.toString()");
    AppMethodBeat.o(57389);
    return paramConstructor;
  }
  
  public static String d(Method paramMethod)
  {
    AppMethodBeat.i(57388);
    k.h(paramMethod, "method");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      k.g(localClass, "parameterType");
      localStringBuilder.append(b.bA(localClass));
      i += 1;
    }
    localStringBuilder.append(")");
    paramMethod = paramMethod.getReturnType();
    k.g(paramMethod, "method.returnType");
    localStringBuilder.append(b.bA(paramMethod));
    paramMethod = localStringBuilder.toString();
    k.g(paramMethod, "sb.toString()");
    AppMethodBeat.o(57388);
    return paramMethod;
  }
  
  public static String f(Field paramField)
  {
    AppMethodBeat.i(57390);
    k.h(paramField, "field");
    paramField = paramField.getType();
    k.g(paramField, "field.type");
    paramField = b.bA(paramField);
    AppMethodBeat.o(57390);
    return paramField;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.a.l
 * JD-Core Version:    0.7.0.1
 */