package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class fc<T>
  extends eb<T>
{
  private final dk a;
  private final eb<T> b;
  private final Type c;
  
  fc(dk paramdk, eb<T> parameb, Type paramType)
  {
    this.a = paramdk;
    this.b = parameb;
    this.c = paramType;
  }
  
  private Type a(Type paramType, Object paramObject)
  {
    AppMethodBeat.i(147742);
    Object localObject = paramType;
    if (paramObject != null) {
      if ((paramType != Object.class) && (!(paramType instanceof TypeVariable)))
      {
        localObject = paramType;
        if (!(paramType instanceof Class)) {}
      }
      else
      {
        localObject = paramObject.getClass();
      }
    }
    AppMethodBeat.o(147742);
    return localObject;
  }
  
  public final void a(fh paramfh, T paramT)
  {
    AppMethodBeat.i(147741);
    Object localObject1 = this.b;
    Object localObject2 = a(this.c, paramT);
    if (localObject2 != this.c)
    {
      localObject2 = this.a.a(fe.a((Type)localObject2));
      localObject1 = localObject2;
      if ((localObject2 instanceof ez.a))
      {
        localObject1 = localObject2;
        if (!(this.b instanceof ez.a)) {
          localObject1 = this.b;
        }
      }
    }
    ((eb)localObject1).a(paramfh, paramT);
    AppMethodBeat.o(147741);
  }
  
  public final T b(ff paramff)
  {
    AppMethodBeat.i(147740);
    paramff = this.b.b(paramff);
    AppMethodBeat.o(147740);
    return paramff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fc
 * JD-Core Version:    0.7.0.1
 */