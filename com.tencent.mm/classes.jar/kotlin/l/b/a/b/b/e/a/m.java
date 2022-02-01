package kotlin.l.b.a.b.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.e.b.b;

final class m
{
  public static final m aiMK;
  
  static
  {
    AppMethodBeat.i(57391);
    aiMK = new m();
    AppMethodBeat.o(57391);
  }
  
  public static String b(Constructor<?> paramConstructor)
  {
    AppMethodBeat.i(57389);
    s.u(paramConstructor, "constructor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    paramConstructor = paramConstructor.getParameterTypes();
    s.s(paramConstructor, "constructor.parameterTypes");
    int i = 0;
    int j = paramConstructor.length;
    while (i < j)
    {
      Object localObject = paramConstructor[i];
      i += 1;
      s.s(localObject, "parameterType");
      localStringBuilder.append(b.cN(localObject));
    }
    localStringBuilder.append(")V");
    paramConstructor = localStringBuilder.toString();
    s.s(paramConstructor, "sb.toString()");
    AppMethodBeat.o(57389);
    return paramConstructor;
  }
  
  public static String h(Method paramMethod)
  {
    AppMethodBeat.i(57388);
    s.u(paramMethod, "method");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    s.s(arrayOfClass, "method.parameterTypes");
    int i = 0;
    int j = arrayOfClass.length;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      i += 1;
      s.s(localClass, "parameterType");
      localStringBuilder.append(b.cN(localClass));
    }
    localStringBuilder.append(")");
    paramMethod = paramMethod.getReturnType();
    s.s(paramMethod, "method.returnType");
    localStringBuilder.append(b.cN(paramMethod));
    paramMethod = localStringBuilder.toString();
    s.s(paramMethod, "sb.toString()");
    AppMethodBeat.o(57388);
    return paramMethod;
  }
  
  public static String k(Field paramField)
  {
    AppMethodBeat.i(57390);
    s.u(paramField, "field");
    paramField = paramField.getType();
    s.s(paramField, "field.type");
    paramField = b.cN(paramField);
    AppMethodBeat.o(57390);
    return paramField;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.a.m
 * JD-Core Version:    0.7.0.1
 */