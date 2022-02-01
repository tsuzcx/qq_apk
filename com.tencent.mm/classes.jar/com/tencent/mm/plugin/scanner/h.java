package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;
import java.util.List;

public final class h
{
  private static String Oo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "bg";
    case 1: 
      return "en";
    case 2: 
      return "zh_CN";
    case 3: 
      return "ja";
    case 4: 
      return "ko";
    case 5: 
      return "ru";
    case 6: 
      return "th";
    }
    return "vi";
  }
  
  public static boolean dKw()
  {
    AppMethodBeat.i(151578);
    int i = ((a)g.ab(a.class)).acA().getInt("EnableSnsPicTranslation", 0);
    Object localObject = ((a)g.ab(a.class)).acA().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, ac.fks() });
      if ((i != 1) || (bt.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(ac.fks()))) {
        break;
      }
      AppMethodBeat.o(151578);
      return true;
    }
    if (d.Fnn)
    {
      AppMethodBeat.o(151578);
      return true;
    }
    AppMethodBeat.o(151578);
    return false;
  }
  
  public static boolean dKx()
  {
    AppMethodBeat.i(151579);
    int i = ((a)g.ab(a.class)).acA().getInt("EnableFavPicTranslation", 0);
    Object localObject = ((a)g.ab(a.class)).acA().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, ac.fks() });
      if ((i != 1) || (bt.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(ac.fks()))) {
        break;
      }
      AppMethodBeat.o(151579);
      return true;
    }
    if (d.Fnn)
    {
      AppMethodBeat.o(151579);
      return true;
    }
    AppMethodBeat.o(151579);
    return false;
  }
  
  public static int ft(List<Float> paramList)
  {
    AppMethodBeat.i(195333);
    if (paramList != null)
    {
      int j = 0;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= paramList.size()) {
          break;
        }
        k = i;
        if (!Oo(j).equalsIgnoreCase("bg"))
        {
          k = i;
          if (!Oo(j).equalsIgnoreCase(ac.fks()))
          {
            int m = (int)(((Float)paramList.get(j)).floatValue() * 100.0F);
            k = i;
            if (m > i) {
              k = m;
            }
          }
        }
        j += 1;
      }
    }
    int k = 0;
    AppMethodBeat.o(195333);
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.h
 * JD-Core Version:    0.7.0.1
 */