package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class ei$b
  implements Serializable, ParameterizedType
{
  private final Type a;
  private final Type b;
  private final Type[] c;
  
  public ei$b(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    AppMethodBeat.i(147534);
    boolean bool1;
    if ((paramType2 instanceof Class))
    {
      Class localClass = (Class)paramType2;
      if ((paramType1 != null) || (localClass.getEnclosingClass() == null))
      {
        bool1 = true;
        eh.a(bool1);
        bool1 = bool2;
        if (paramType1 != null)
        {
          if (localClass.getEnclosingClass() == null) {
            break label165;
          }
          bool1 = bool2;
        }
        label68:
        eh.a(bool1);
      }
    }
    else
    {
      if (paramType1 != null) {
        break label171;
      }
    }
    label165:
    label171:
    for (paramType1 = null;; paramType1 = ei.d(paramType1))
    {
      this.a = paramType1;
      this.b = ei.d(paramType2);
      this.c = ((Type[])paramVarArgs.clone());
      while (i < this.c.length)
      {
        eh.a(this.c[i]);
        ei.h(this.c[i]);
        paramType1 = this.c;
        paramType1[i] = ei.d(paramType1[i]);
        i += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label68;
    }
    AppMethodBeat.o(147534);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147536);
    if (((paramObject instanceof ParameterizedType)) && (ei.a(this, (ParameterizedType)paramObject)))
    {
      AppMethodBeat.o(147536);
      return true;
    }
    AppMethodBeat.o(147536);
    return false;
  }
  
  public final Type[] getActualTypeArguments()
  {
    AppMethodBeat.i(147535);
    Type[] arrayOfType = (Type[])this.c.clone();
    AppMethodBeat.o(147535);
    return arrayOfType;
  }
  
  public final Type getOwnerType()
  {
    return this.a;
  }
  
  public final Type getRawType()
  {
    return this.b;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(147537);
    int i = Arrays.hashCode(this.c);
    int j = this.b.hashCode();
    int k = ei.a(this.a);
    AppMethodBeat.o(147537);
    return i ^ j ^ k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147538);
    Object localObject = new StringBuilder((this.c.length + 1) * 30);
    ((StringBuilder)localObject).append(ei.f(this.b));
    if (this.c.length == 0)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(147538);
      return localObject;
    }
    ((StringBuilder)localObject).append("<").append(ei.f(this.c[0]));
    int i = 1;
    while (i < this.c.length)
    {
      ((StringBuilder)localObject).append(", ").append(ei.f(this.c[i]));
      i += 1;
    }
    localObject = ">";
    AppMethodBeat.o(147538);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ei.b
 * JD-Core Version:    0.7.0.1
 */