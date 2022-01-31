package com.tencent.tencentmap.mapsdk.a;

import java.util.Comparator;

final class th$a
  implements Comparator<Object>
{
  private th$a(th paramth) {}
  
  public final int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (tx)paramObject1;
    paramObject2 = (tx)paramObject2;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      try
      {
        if (paramObject1.k() > paramObject2.k()) {
          return 1;
        }
        float f1 = paramObject1.k();
        float f2 = paramObject2.k();
        if (f1 < f2) {
          return -1;
        }
      }
      catch (Exception paramObject1) {}
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.th.a
 * JD-Core Version:    0.7.0.1
 */