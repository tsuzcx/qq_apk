package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.b;

final class l
{
  public static final l aaPN;
  
  static
  {
    AppMethodBeat.i(57391);
    aaPN = new l();
    AppMethodBeat.o(57391);
  }
  
  public static String a(Constructor<?> paramConstructor)
  {
    AppMethodBeat.i(57389);
    p.k(paramConstructor, "constructor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    paramConstructor = paramConstructor.getParameterTypes();
    int j = paramConstructor.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConstructor[i];
      p.j(localObject, "parameterType");
      localStringBuilder.append(b.cb(localObject));
      i += 1;
    }
    localStringBuilder.append(")V");
    paramConstructor = localStringBuilder.toString();
    p.j(paramConstructor, "sb.toString()");
    AppMethodBeat.o(57389);
    return paramConstructor;
  }
  
  public static String d(Method paramMethod)
  {
    AppMethodBeat.i(57388);
    p.k(paramMethod, "method");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      p.j(localClass, "parameterType");
      localStringBuilder.append(b.cb(localClass));
      i += 1;
    }
    localStringBuilder.append(")");
    paramMethod = paramMethod.getReturnType();
    p.j(paramMethod, "method.returnType");
    localStringBuilder.append(b.cb(paramMethod));
    paramMethod = localStringBuilder.toString();
    p.j(paramMethod, "sb.toString()");
    AppMethodBeat.o(57388);
    return paramMethod;
  }
  
  public static String h(Field paramField)
  {
    AppMethodBeat.i(57390);
    p.k(paramField, "field");
    paramField = paramField.getType();
    p.j(paramField, "field.type");
    paramField = b.cb(paramField);
    AppMethodBeat.o(57390);
    return paramField;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.a.l
 * JD-Core Version:    0.7.0.1
 */