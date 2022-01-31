package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class mo
  implements mn
{
  static <T extends ms> T a(List<T> paramList1, List<T> paramList2, mv parammv)
  {
    AppMethodBeat.i(149326);
    Iterator localIterator = paramList1.iterator();
    paramList2 = null;
    paramList1 = null;
    if (localIterator.hasNext())
    {
      ms localms = (ms)localIterator.next();
      double d = parammv.b(localms.b().a()).g();
      if ((paramList2 != null) && (d >= paramList2.doubleValue())) {
        break label91;
      }
      paramList2 = Double.valueOf(d);
      paramList1 = localms;
    }
    label91:
    for (;;)
    {
      break;
      AppMethodBeat.o(149326);
      return paramList1;
    }
  }
  
  static <T extends ms> mx<T> a(List<T> paramList)
  {
    AppMethodBeat.i(149327);
    Iterator localIterator1 = paramList.iterator();
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    while (localIterator1.hasNext())
    {
      ms localms = (ms)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      Object localObject3 = localObject4;
      Object localObject1 = localObject5;
      Object localObject2 = localObject6;
      localObject6 = localObject2;
      localObject5 = localObject1;
      localObject4 = localObject3;
      if (localIterator2.hasNext())
      {
        localObject4 = (ms)localIterator2.next();
        if (localms == localObject4) {
          break label219;
        }
        double d = localms.b().a().b(((ms)localObject4).b().a()).g();
        if ((localObject2 != null) && (d <= ((Double)localObject2).doubleValue())) {
          break label219;
        }
        localObject2 = Double.valueOf(d);
        localObject3 = localms;
        localObject1 = localObject4;
      }
    }
    label219:
    for (;;)
    {
      break;
      if (localObject4 != null)
      {
        paramList = new mx(localObject4, localObject5);
        AppMethodBeat.o(149327);
        return paramList;
      }
      paramList = new mx(paramList.get(0), paramList.get(1));
      AppMethodBeat.o(149327);
      return paramList;
    }
  }
  
  private <T extends ms> void a(List<T> paramList1, List<T> paramList2, List<T> paramList3, int paramInt)
  {
    AppMethodBeat.i(149325);
    mv localmv1 = mp.a(paramList1);
    mv localmv2 = mp.a(paramList2);
    ms localms1 = a(paramList3, paramList1, localmv1);
    ms localms2 = a(paramList3, paramList2, localmv2);
    if (localms1.b().a().b(localmv1).g() <= localms2.b().a().b(localmv2).g()) {}
    for (int i = 1; ((i != 0) && (paramList2.size() + paramList3.size() - 1 >= paramInt)) || ((i == 0) && (paramList1.size() + paramList3.size() == paramInt)); i = 0)
    {
      paramList1.add(localms1);
      paramList3.remove(localms1);
      AppMethodBeat.o(149325);
      return;
    }
    paramList2.add(localms2);
    paramList3.remove(localms2);
    AppMethodBeat.o(149325);
  }
  
  public final <T extends ms> mt<T> a(List<T> paramList, int paramInt)
  {
    AppMethodBeat.i(149324);
    if (paramList.size() < 2)
    {
      paramList = new IllegalArgumentException();
      AppMethodBeat.o(149324);
      throw paramList;
    }
    mx localmx = a(paramList);
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(localmx.a());
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localmx.b());
    ArrayList localArrayList3 = new ArrayList(paramList);
    localArrayList3.remove(localmx.a());
    localArrayList3.remove(localmx.b());
    paramInt = paramList.size() / 2;
    while (localArrayList3.size() > 0) {
      a(localArrayList1, localArrayList2, localArrayList3, paramInt);
    }
    paramList = new mt(localArrayList1, localArrayList2);
    AppMethodBeat.o(149324);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mo
 * JD-Core Version:    0.7.0.1
 */