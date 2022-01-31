package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum nb$b
{
  public final int g;
  
  static
  {
    AppMethodBeat.i(149372);
    a = new b("LEFT_BOTTOM", 0, 0);
    b = new b("CENTER_BOTTOM", 1, 4);
    c = new b("RIGHT_BOTTOM", 2, 1);
    d = new b("LEFT_TOP", 3, 3);
    e = new b("CENTER_TOP", 4, 5);
    f = new b("RIGHT_TOP", 5, 2);
    h = new b[] { a, b, c, d, e, f };
    AppMethodBeat.o(149372);
  }
  
  private nb$b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public static b a(int paramInt)
  {
    AppMethodBeat.i(149371);
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < values().length) {}
    }
    else
    {
      i = 0;
    }
    Object localObject = a;
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    paramInt = 0;
    if (paramInt < j)
    {
      b localb = arrayOfb[paramInt];
      if (localb.g == i) {
        localObject = localb;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149371);
      return localObject;
      paramInt += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nb.b
 * JD-Core Version:    0.7.0.1
 */