package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class mb$4
  implements Comparator<T>
{
  mb$4(Comparator[] paramArrayOfComparator) {}
  
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(149275);
    Comparator[] arrayOfComparator = this.a;
    int j = arrayOfComparator.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfComparator[i].compare(paramT1, paramT2);
      if (k != 0)
      {
        AppMethodBeat.o(149275);
        return k;
      }
      i += 1;
    }
    AppMethodBeat.o(149275);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mb.4
 * JD-Core Version:    0.7.0.1
 */