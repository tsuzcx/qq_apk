package com.tencent.mm.plugin.sns.ad.adxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class m
{
  public List<l> PMG;
  public int PMZ;
  public int PNa;
  
  public static m V(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309853);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309853);
      return null;
    }
    for (;;)
    {
      m localm;
      int i;
      try
      {
        localm = new m();
        localm.PMG = W(paramMap, paramString + ".sliderCardList");
        localm.PMZ = localm.PMG.size();
        localm.PNa = localm.PMZ;
        if ((localm.PMZ > 0) && (localm.PMZ <= 4)) {
          if (localm.PNa < 6)
          {
            i = 0;
            if (i >= localm.PMZ) {
              continue;
            }
            paramMap = (l)localm.PMG.get(i);
            if (paramMap == null) {
              break label211;
            }
            if (localm.PMZ < 4)
            {
              paramMap = l.a(paramMap, localm.PNa);
              if (paramMap != null)
              {
                localm.PMG.add(paramMap);
                localm.PNa += 1;
              }
            }
            else
            {
              localm.PMG.add(paramMap);
              localm.PNa += 1;
            }
          }
        }
      }
      finally
      {
        AppMethodBeat.o(309853);
        return null;
      }
      AppMethodBeat.o(309853);
      return localm;
      label211:
      i += 1;
    }
  }
  
  private static List<l> W(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309856);
    String str = paramString + ".sliderCardItem";
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder().append(str);
    if (i == 0) {}
    for (paramString = "";; paramString = Integer.valueOf(i))
    {
      paramString = paramString;
      if (!paramMap.containsKey(paramString)) {
        break label110;
      }
      paramString = l.U(paramMap, paramString);
      if (paramString == null) {
        break label110;
      }
      localArrayList.add(paramString);
      i += 1;
      break;
    }
    label110:
    AppMethodBeat.o(309856);
    return localArrayList;
  }
  
  public final int ajr(int paramInt)
  {
    int i = paramInt;
    if (this.PMZ <= 4) {
      i = paramInt % this.PMZ;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.m
 * JD-Core Version:    0.7.0.1
 */