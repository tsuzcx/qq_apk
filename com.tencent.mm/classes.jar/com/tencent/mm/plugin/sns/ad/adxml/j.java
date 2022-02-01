package com.tencent.mm.plugin.sns.ad.adxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class j
{
  public int JyE;
  public int JyF;
  public List<i> Jym;
  
  public static j H(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(210010);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(210010);
      return null;
    }
    for (;;)
    {
      j localj;
      int i;
      try
      {
        localj = new j();
        localj.Jym = I(paramMap, paramString + ".sliderCardList");
        localj.JyE = localj.Jym.size();
        localj.JyF = localj.JyE;
        if ((localj.JyE > 0) && (localj.JyE <= 4)) {
          if (localj.JyF < 6)
          {
            i = 0;
            if (i >= localj.JyE) {
              continue;
            }
            paramMap = (i)localj.Jym.get(i);
            if (paramMap == null) {
              break label211;
            }
            if (localj.JyE < 4)
            {
              paramMap = i.a(paramMap, localj.JyF);
              if (paramMap != null)
              {
                localj.Jym.add(paramMap);
                localj.JyF += 1;
              }
            }
            else
            {
              localj.Jym.add(paramMap);
              localj.JyF += 1;
            }
          }
        }
      }
      catch (Throwable paramMap)
      {
        AppMethodBeat.o(210010);
        return null;
      }
      AppMethodBeat.o(210010);
      return localj;
      label211:
      i += 1;
    }
  }
  
  private static List<i> I(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(210011);
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
      paramString = i.G(paramMap, paramString);
      if (paramString == null) {
        break label110;
      }
      localArrayList.add(paramString);
      i += 1;
      break;
    }
    label110:
    AppMethodBeat.o(210011);
    return localArrayList;
  }
  
  public final int aeI(int paramInt)
  {
    int i = paramInt;
    if (this.JyE <= 4) {
      i = paramInt % this.JyE;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.j
 * JD-Core Version:    0.7.0.1
 */