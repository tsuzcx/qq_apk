package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.List;

public final class i
{
  private static String Wq(int paramInt)
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
  
  public static boolean eOO()
  {
    AppMethodBeat.i(223713);
    if (((b)g.af(b.class)).a(b.a.rTn, 1) == 1)
    {
      AppMethodBeat.o(223713);
      return true;
    }
    AppMethodBeat.o(223713);
    return false;
  }
  
  public static boolean eOP()
  {
    AppMethodBeat.i(151578);
    if (!eOO())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(151578);
      return false;
    }
    int i = ((a)g.af(a.class)).aqJ().getInt("EnableSnsPicTranslation", 0);
    Object localObject = ((a)g.af(a.class)).aqJ().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, LocaleUtil.getApplicationLanguage() });
      if ((i != 1) || (Util.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(LocaleUtil.getApplicationLanguage()))) {
        break;
      }
      AppMethodBeat.o(151578);
      return true;
    }
    if (d.KyS)
    {
      AppMethodBeat.o(151578);
      return true;
    }
    AppMethodBeat.o(151578);
    return false;
  }
  
  public static boolean eOQ()
  {
    AppMethodBeat.i(151579);
    if (!eOO())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(151579);
      return false;
    }
    int i = ((a)g.af(a.class)).aqJ().getInt("EnableFavPicTranslation", 0);
    Object localObject = ((a)g.af(a.class)).aqJ().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, LocaleUtil.getApplicationLanguage() });
      if ((i != 1) || (Util.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(LocaleUtil.getApplicationLanguage()))) {
        break;
      }
      AppMethodBeat.o(151579);
      return true;
    }
    if (d.KyS)
    {
      AppMethodBeat.o(151579);
      return true;
    }
    AppMethodBeat.o(151579);
    return false;
  }
  
  public static int gw(List<Float> paramList)
  {
    AppMethodBeat.i(223714);
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
        if (!Wq(j).equalsIgnoreCase("bg"))
        {
          k = i;
          if (!Wq(j).equalsIgnoreCase(LocaleUtil.getApplicationLanguage()))
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
    AppMethodBeat.o(223714);
    return k;
  }
  
  public static boolean gx(List<Float> paramList)
  {
    AppMethodBeat.i(223715);
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (Wq(i).equalsIgnoreCase("bg"))
        {
          i = (int)(((Float)paramList.get(i)).floatValue() * 100.0F);
          label51:
          Log.i("MicroMsg.ScannerHelper", "needShowOCRMenu transBgRatio: %s", new Object[] { Integer.valueOf(i) });
          if ((i >= 99) || (i <= 0)) {
            break label104;
          }
        }
      }
    }
    label104:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label109;
      }
      AppMethodBeat.o(223715);
      return true;
      i += 1;
      break;
      i = 0;
      break label51;
    }
    label109:
    AppMethodBeat.o(223715);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.i
 * JD-Core Version:    0.7.0.1
 */