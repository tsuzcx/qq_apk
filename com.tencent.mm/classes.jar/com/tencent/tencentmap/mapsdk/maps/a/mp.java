package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class mp
{
  public static mv a(Collection<? extends ms> paramCollection)
  {
    AppMethodBeat.i(149328);
    if (paramCollection.isEmpty())
    {
      paramCollection = new IllegalArgumentException();
      AppMethodBeat.o(149328);
      throw paramCollection;
    }
    paramCollection = paramCollection.iterator();
    float f1 = 1.4E-45F;
    float f3 = 1.4E-45F;
    float f5 = 3.4028235E+38F;
    float f2 = 3.4028235E+38F;
    mv localmv;
    if (paramCollection.hasNext())
    {
      localmv = ((ms)paramCollection.next()).b().a();
      if (localmv.c() >= f2) {
        break label182;
      }
      f2 = localmv.c();
    }
    label182:
    for (;;)
    {
      float f4 = f5;
      if (localmv.d() < f5) {
        f4 = localmv.d();
      }
      f5 = f3;
      if (localmv.e() > f3) {
        f5 = localmv.e();
      }
      if (localmv.f() > f1) {
        f1 = localmv.f();
      }
      for (;;)
      {
        f3 = f5;
        f5 = f4;
        break;
        paramCollection = mv.a(f2, f5, f3, f1);
        AppMethodBeat.o(149328);
        return paramCollection;
      }
    }
  }
  
  static <T> List<T> a(List<T> paramList, T paramT)
  {
    AppMethodBeat.i(149329);
    ArrayList localArrayList = new ArrayList(paramList.size() + 2);
    localArrayList.addAll(paramList);
    localArrayList.add(paramT);
    AppMethodBeat.o(149329);
    return localArrayList;
  }
  
  static <T> List<? extends T> a(List<? extends T> paramList, T paramT, List<T> paramList1)
  {
    AppMethodBeat.i(149330);
    ArrayList localArrayList = new ArrayList(paramList.size() + paramList1.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject != paramT) {
        localArrayList.add(localObject);
      }
    }
    localArrayList.addAll(paramList1);
    AppMethodBeat.o(149330);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mp
 * JD-Core Version:    0.7.0.1
 */