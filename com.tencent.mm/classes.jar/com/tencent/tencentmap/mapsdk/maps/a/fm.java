package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cz;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class fm
  implements dp<List<cz>>
{
  protected static List<cz> a(List<Double> paramList)
  {
    int i = 2;
    AppMethodBeat.i(147944);
    if ((paramList == null) || (paramList.size() < 2))
    {
      AppMethodBeat.o(147944);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cz(((Double)paramList.get(0)).doubleValue(), ((Double)paramList.get(1)).doubleValue()));
    while (i < paramList.size())
    {
      double d1 = ((cz)localArrayList.get(i / 2 - 1)).b;
      double d2 = ((Double)paramList.get(i + 1)).doubleValue() / 1000000.0D;
      localArrayList.add(new cz((float)(Math.round((((cz)localArrayList.get(i / 2 - 1)).a + ((Double)paramList.get(i)).doubleValue() / 1000000.0D) * 1000000.0D) / 1000000.0D), (float)(Math.round((d1 + d2) * 1000000.0D) / 1000000.0D)));
      i += 2;
    }
    AppMethodBeat.o(147944);
    return localArrayList;
  }
  
  public List<cz> a(dq paramdq, Type paramType, do paramdo)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(147943);
    paramdq = paramdq.n();
    if (paramdq.a() > 0)
    {
      if (paramdq.a(0).j())
      {
        paramType = new ArrayList();
        while (i < paramdq.a())
        {
          paramdo = paramdq.a(i).m();
          paramType.add(new cz(paramdo.a("latitude").d(), paramdo.a("longitude").d()));
          i += 1;
        }
        AppMethodBeat.o(147943);
        return paramType;
      }
      paramType = new ArrayList();
      i = j;
      while (i < paramdq.a())
      {
        paramType.add(Double.valueOf(paramdq.a(i).d()));
        i += 1;
      }
      paramdq = a(paramType);
      AppMethodBeat.o(147943);
      return paramdq;
    }
    AppMethodBeat.o(147943);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fm
 * JD-Core Version:    0.7.0.1
 */