package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
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
  private static Boolean IGb;
  private static Boolean IGc;
  private static int IGd;
  private static boolean IGe;
  
  static
  {
    AppMethodBeat.i(207818);
    IGb = null;
    IGc = null;
    IGd = 0;
    IGe = true;
    int i = ((b)h.ae(b.class)).a(b.a.vXf, 10);
    int j = ((b)h.ae(b.class)).a(b.a.vXg, 0);
    if (j == 1)
    {
      IGd = ((b)h.ae(b.class)).a(b.a.vXh, 10);
      if (((b)h.ae(b.class)).a(b.a.vOe, 0) != 1) {
        break label211;
      }
    }
    label211:
    for (boolean bool = true;; bool = false)
    {
      IGc = Boolean.valueOf(bool);
      int k = ((b)h.ae(b.class)).a(b.a.vXi, 0);
      if (k == 1) {
        IGe = false;
      }
      Log.i("MicroMsg.ScannerHelper", "alvinluo initScannerHelper testTranslateConfig: %s, useConfig: %s, translateConfigRatio %d, pendingWordDetect: %b, disableAlwaysShowTranslateMenu: %s, alwaysShowTranlsateMenu: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(IGd), IGc, Integer.valueOf(k), Boolean.valueOf(IGe) });
      AppMethodBeat.o(207818);
      return;
      IGd = i;
      break;
    }
  }
  
  private static String adh(int paramInt)
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
  
  public static boolean adi(int paramInt)
  {
    return paramInt >= IGd;
  }
  
  public static boolean adj(int paramInt)
  {
    return paramInt >= IGd;
  }
  
  private static boolean fBL()
  {
    AppMethodBeat.i(207794);
    if (((b)h.ae(b.class)).a(b.a.vzP, 1) == 1)
    {
      AppMethodBeat.o(207794);
      return true;
    }
    AppMethodBeat.o(207794);
    return false;
  }
  
  public static boolean fBM()
  {
    AppMethodBeat.i(207795);
    if ((BuildInfo.DEBUG) && (IGb != null))
    {
      boolean bool = IGb.booleanValue();
      AppMethodBeat.o(207795);
      return bool;
    }
    e locale = (e)h.ae(e.class);
    if ((IGc.booleanValue()) && (locale != null) && (locale.bwe()))
    {
      Log.i("MicroMsg.ScannerHelper", "isPendingWordDetect disabled by memory degrade.");
      AppMethodBeat.o(207795);
      return true;
    }
    AppMethodBeat.o(207795);
    return false;
  }
  
  public static boolean fBN()
  {
    AppMethodBeat.i(207798);
    if (!fBL())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(207798);
      return false;
    }
    int i = ((a)h.ae(a.class)).axc().getInt("EnableSessionPicTranslation", 0);
    Object localObject = ((a)h.ae(a.class)).axc().getValue("PicTranslationSupportUserLanguage");
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
      AppMethodBeat.o(207798);
      return true;
    }
    if (d.RAH)
    {
      AppMethodBeat.o(207798);
      return true;
    }
    AppMethodBeat.o(207798);
    return false;
  }
  
  public static boolean fBO()
  {
    AppMethodBeat.i(151578);
    if (!fBL())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(151578);
      return false;
    }
    int i = ((a)h.ae(a.class)).axc().getInt("EnableSnsPicTranslation", 0);
    Object localObject = ((a)h.ae(a.class)).axc().getValue("PicTranslationSupportUserLanguage");
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
    if (d.RAH)
    {
      AppMethodBeat.o(151578);
      return true;
    }
    AppMethodBeat.o(151578);
    return false;
  }
  
  public static boolean fBP()
  {
    AppMethodBeat.i(151579);
    if (!fBL())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(151579);
      return false;
    }
    int i = ((a)h.ae(a.class)).axc().getInt("EnableFavPicTranslation", 0);
    Object localObject = ((a)h.ae(a.class)).axc().getValue("PicTranslationSupportUserLanguage");
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
    if (d.RAH)
    {
      AppMethodBeat.o(151579);
      return true;
    }
    AppMethodBeat.o(151579);
    return false;
  }
  
  public static boolean fBQ()
  {
    AppMethodBeat.i(207804);
    if (!fBL())
    {
      Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
      AppMethodBeat.o(207804);
      return false;
    }
    int i = ((a)h.ae(a.class)).axc().getInt("EnableWebviewPicTranslation", 0);
    Object localObject = ((a)h.ae(a.class)).axc().getValue("PicTranslationSupportUserLanguage");
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
      AppMethodBeat.o(207804);
      return true;
    }
    if (d.RAH)
    {
      AppMethodBeat.o(207804);
      return true;
    }
    AppMethodBeat.o(207804);
    return false;
  }
  
  public static boolean fBR()
  {
    return IGe;
  }
  
  public static int hc(List<Float> paramList)
  {
    AppMethodBeat.i(207810);
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
        if (!adh(j).equalsIgnoreCase("bg"))
        {
          k = i;
          if (!adh(j).equalsIgnoreCase(LocaleUtil.getApplicationLanguage())) {
            k = i + (int)(((Float)paramList.get(j)).floatValue() * 100.0F);
          }
        }
        j += 1;
      }
    }
    int k = 0;
    AppMethodBeat.o(207810);
    return k;
  }
  
  public static boolean hd(List<Float> paramList)
  {
    AppMethodBeat.i(207816);
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (adh(i).equalsIgnoreCase("bg"))
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
      AppMethodBeat.o(207816);
      return true;
      i += 1;
      break;
      i = 0;
      break label51;
    }
    label109:
    AppMethodBeat.o(207816);
    return false;
  }
  
  public static void xk(boolean paramBoolean)
  {
    AppMethodBeat.i(207796);
    IGb = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(207796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.n
 * JD-Core Version:    0.7.0.1
 */