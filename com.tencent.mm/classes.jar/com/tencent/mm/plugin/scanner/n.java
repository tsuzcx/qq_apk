package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.performance.a.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.List;

public final class n
{
  private static Boolean OMj;
  private static Boolean OMk;
  private static int OMl;
  private static boolean OMm;
  
  static
  {
    AppMethodBeat.i(313363);
    OMj = null;
    OMk = null;
    OMl = 0;
    OMm = true;
    int i = ((c)h.ax(c.class)).a(c.a.zpK, 10);
    int j = ((c)h.ax(c.class)).a(c.a.zpL, 0);
    if (j == 1)
    {
      OMl = ((c)h.ax(c.class)).a(c.a.zpM, 10);
      if (((c)h.ax(c.class)).a(c.a.zgv, 0) != 1) {
        break label211;
      }
    }
    label211:
    for (boolean bool = true;; bool = false)
    {
      OMk = Boolean.valueOf(bool);
      int k = ((c)h.ax(c.class)).a(c.a.zpN, 0);
      if (k == 1) {
        OMm = false;
      }
      Log.i("MicroMsg.ScannerHelper", "alvinluo initScannerHelper testTranslateConfig: %s, useConfig: %s, translateConfigRatio %d, pendingWordDetect: %b, disableAlwaysShowTranslateMenu: %s, alwaysShowTranlsateMenu: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(OMl), OMk, Integer.valueOf(k), Boolean.valueOf(OMm) });
      AppMethodBeat.o(313363);
      return;
      OMl = i;
      break;
    }
  }
  
  public static void BV(boolean paramBoolean)
  {
    AppMethodBeat.i(313311);
    OMj = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(313311);
  }
  
  private static String ahE(int paramInt)
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
  
  public static boolean ahF(int paramInt)
  {
    return paramInt >= OMl;
  }
  
  public static boolean ahG(int paramInt)
  {
    return paramInt >= OMl;
  }
  
  private static boolean gPp()
  {
    AppMethodBeat.i(313302);
    if (((c)h.ax(c.class)).a(c.a.yNx, 1) == 1)
    {
      AppMethodBeat.o(313302);
      return true;
    }
    AppMethodBeat.o(313302);
    return false;
  }
  
  public static boolean gPq()
  {
    AppMethodBeat.i(313306);
    if ((BuildInfo.DEBUG) && (OMj != null))
    {
      boolean bool = OMj.booleanValue();
      AppMethodBeat.o(313306);
      return bool;
    }
    e locale = (e)h.ax(e.class);
    if ((OMk.booleanValue()) && (locale != null) && (locale.bUX()))
    {
      Log.i("MicroMsg.ScannerHelper", "isPendingWordDetect disabled by memory degrade.");
      AppMethodBeat.o(313306);
      return true;
    }
    AppMethodBeat.o(313306);
    return false;
  }
  
  public static boolean gPr()
  {
    AppMethodBeat.i(313318);
    if (!gPp())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(313318);
      return false;
    }
    int i = ((a)h.ax(a.class)).aRC().getInt("EnableSessionPicTranslation", 0);
    Object localObject = ((a)h.ax(a.class)).aRC().getValue("PicTranslationSupportUserLanguage");
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
      AppMethodBeat.o(313318);
      return true;
    }
    if (d.Yxl)
    {
      AppMethodBeat.o(313318);
      return true;
    }
    AppMethodBeat.o(313318);
    return false;
  }
  
  public static boolean gPs()
  {
    AppMethodBeat.i(151578);
    if (!gPp())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(151578);
      return false;
    }
    int i = ((a)h.ax(a.class)).aRC().getInt("EnableSnsPicTranslation", 0);
    Object localObject = ((a)h.ax(a.class)).aRC().getValue("PicTranslationSupportUserLanguage");
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
    if (d.Yxl)
    {
      AppMethodBeat.o(151578);
      return true;
    }
    AppMethodBeat.o(151578);
    return false;
  }
  
  public static boolean gPt()
  {
    AppMethodBeat.i(151579);
    if (!gPp())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(151579);
      return false;
    }
    int i = ((a)h.ax(a.class)).aRC().getInt("EnableFavPicTranslation", 0);
    Object localObject = ((a)h.ax(a.class)).aRC().getValue("PicTranslationSupportUserLanguage");
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
    if (d.Yxl)
    {
      AppMethodBeat.o(151579);
      return true;
    }
    AppMethodBeat.o(151579);
    return false;
  }
  
  public static boolean gPu()
  {
    AppMethodBeat.i(313330);
    if (!gPp())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(313330);
      return false;
    }
    int i = ((a)h.ax(a.class)).aRC().getInt("EnableWebviewPicTranslation", 0);
    Object localObject = ((a)h.ax(a.class)).aRC().getValue("PicTranslationSupportUserLanguage");
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
      AppMethodBeat.o(313330);
      return true;
    }
    if (d.Yxl)
    {
      AppMethodBeat.o(313330);
      return true;
    }
    AppMethodBeat.o(313330);
    return false;
  }
  
  public static boolean gPv()
  {
    return OMm;
  }
  
  public static int kd(List<Float> paramList)
  {
    AppMethodBeat.i(313342);
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
        if (!ahE(j).equalsIgnoreCase("bg"))
        {
          k = i;
          if (!ahE(j).equalsIgnoreCase(LocaleUtil.getApplicationLanguage())) {
            k = i + (int)(((Float)paramList.get(j)).floatValue() * 100.0F);
          }
        }
        j += 1;
      }
    }
    int k = 0;
    AppMethodBeat.o(313342);
    return k;
  }
  
  public static boolean ke(List<Float> paramList)
  {
    AppMethodBeat.i(313359);
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (ahE(i).equalsIgnoreCase("bg"))
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
      AppMethodBeat.o(313359);
      return true;
      i += 1;
      break;
      i = 0;
      break label51;
    }
    label109:
    AppMethodBeat.o(313359);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.n
 * JD-Core Version:    0.7.0.1
 */