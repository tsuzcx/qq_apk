package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;

public class fe<T>
{
  final Class<? super T> a;
  final Type b;
  final int c;
  
  protected fe()
  {
    AppMethodBeat.i(147867);
    this.b = a(getClass());
    this.a = ei.e(this.b);
    this.c = this.b.hashCode();
    AppMethodBeat.o(147867);
  }
  
  fe(Type paramType)
  {
    AppMethodBeat.i(147868);
    this.b = ei.d((Type)eh.a(paramType));
    this.a = ei.e(this.b);
    this.c = this.b.hashCode();
    AppMethodBeat.o(147868);
  }
  
  public static fe<?> a(Type paramType)
  {
    AppMethodBeat.i(147871);
    paramType = new fe(paramType);
    AppMethodBeat.o(147871);
    return paramType;
  }
  
  static Type a(Class<?> paramClass)
  {
    AppMethodBeat.i(147869);
    paramClass = paramClass.getGenericSuperclass();
    if ((paramClass instanceof Class))
    {
      paramClass = new RuntimeException("Missing type parameter.");
      AppMethodBeat.o(147869);
      throw paramClass;
    }
    paramClass = ei.d(((java.lang.reflect.ParameterizedType)paramClass).getActualTypeArguments()[0]);
    AppMethodBeat.o(147869);
    return paramClass;
  }
  
  public static <T> fe<T> b(Class<T> paramClass)
  {
    AppMethodBeat.i(147872);
    paramClass = new fe(paramClass);
    AppMethodBeat.o(147872);
    return paramClass;
  }
  
  public final Class<? super T> a()
  {
    return this.a;
  }
  
  public final Type b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147870);
    if (((paramObject instanceof fe)) && (ei.a(this.b, ((fe)paramObject).b)))
    {
      AppMethodBeat.o(147870);
      return true;
    }
    AppMethodBeat.o(147870);
    return false;
  }
  
  public final int hashCode()
  {
    return this.c;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(98873);
    String str = ei.f(this.b);
    AppMethodBeat.o(98873);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fe
 * JD-Core Version:    0.7.0.1
 */