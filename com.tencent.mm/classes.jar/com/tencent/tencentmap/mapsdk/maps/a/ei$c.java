package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class ei$c
  implements Serializable, WildcardType
{
  private final Type a;
  private final Type b;
  
  public ei$c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
  {
    AppMethodBeat.i(147539);
    if (paramArrayOfType2.length <= 1)
    {
      bool1 = true;
      eh.a(bool1);
      if (paramArrayOfType1.length != 1) {
        break label97;
      }
      bool1 = true;
      label32:
      eh.a(bool1);
      if (paramArrayOfType2.length != 1) {
        break label107;
      }
      eh.a(paramArrayOfType2[0]);
      ei.h(paramArrayOfType2[0]);
      if (paramArrayOfType1[0] != Object.class) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      eh.a(bool1);
      this.b = ei.d(paramArrayOfType2[0]);
      this.a = Object.class;
      AppMethodBeat.o(147539);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label32;
    }
    label107:
    eh.a(paramArrayOfType1[0]);
    ei.h(paramArrayOfType1[0]);
    this.b = null;
    this.a = ei.d(paramArrayOfType1[0]);
    AppMethodBeat.o(147539);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147540);
    if (((paramObject instanceof WildcardType)) && (ei.a(this, (WildcardType)paramObject)))
    {
      AppMethodBeat.o(147540);
      return true;
    }
    AppMethodBeat.o(147540);
    return false;
  }
  
  public final Type[] getLowerBounds()
  {
    if (this.b != null) {
      return new Type[] { this.b };
    }
    return ei.a;
  }
  
  public final Type[] getUpperBounds()
  {
    return new Type[] { this.a };
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(147541);
    if (this.b != null) {}
    for (int i = this.b.hashCode() + 31;; i = 1)
    {
      int j = this.a.hashCode();
      AppMethodBeat.o(147541);
      return i ^ j + 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147542);
    if (this.b != null)
    {
      str = "? super " + ei.f(this.b);
      AppMethodBeat.o(147542);
      return str;
    }
    if (this.a == Object.class)
    {
      AppMethodBeat.o(147542);
      return "?";
    }
    String str = "? extends " + ei.f(this.a);
    AppMethodBeat.o(147542);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ei.c
 * JD-Core Version:    0.7.0.1
 */