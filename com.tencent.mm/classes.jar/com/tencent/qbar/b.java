package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static int LJV;
  private static List<String> LJW;
  private static List<String> LJX;
  
  static
  {
    AppMethodBeat.i(91140);
    LJV = 6;
    ArrayList localArrayList = new ArrayList();
    LJW = localArrayList;
    localArrayList.add("weixin://wxpay/");
    LJW.add("wxp://");
    LJW.add("https://wx.tenpay.com/");
    LJW.add("https://payapp.weixin.qq.com/");
    LJW.add("https://action.weixin.qq.com/");
    LJX = new ArrayList();
    AppMethodBeat.o(91140);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(91139);
    if (paramf == null)
    {
      ad.w("MicroMsg.QBarAIModHelper", "config wxQBar is null");
      AppMethodBeat.o(91139);
      return;
    }
    Iterator localIterator = LJW.iterator();
    while (localIterator.hasNext()) {
      paramf.aZe((String)localIterator.next());
    }
    localIterator = LJX.iterator();
    while (localIterator.hasNext()) {
      paramf.aZf((String)localIterator.next());
    }
    paramf.agC(6);
    AppMethodBeat.o(91139);
  }
  
  public static void a(f paramf, int paramInt)
  {
    AppMethodBeat.i(176204);
    if (paramf == null)
    {
      AppMethodBeat.o(176204);
      return;
    }
    ad.i("MicroMsg.QBarAIModHelper", "alvinluo setBlackInterval %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt > 0) {
      paramf.agC(paramInt);
    }
    AppMethodBeat.o(176204);
  }
  
  public static boolean aZc(String paramString)
  {
    AppMethodBeat.i(218748);
    if (paramString == null)
    {
      AppMethodBeat.o(218748);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = LJW.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bt.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(218748);
        return true;
      }
    }
    AppMethodBeat.o(218748);
    return false;
  }
  
  public static boolean aZd(String paramString)
  {
    AppMethodBeat.i(218749);
    if (paramString == null)
    {
      AppMethodBeat.o(218749);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = LJX.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bt.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(218749);
        return true;
      }
    }
    AppMethodBeat.o(218749);
    return false;
  }
  
  public static void fTs()
  {
    AppMethodBeat.i(176203);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBE, 6);
    if (i > 0) {
      LJV = i;
    }
    LJX.clear();
    LJX.add("https://qr.alipay.com/");
    try
    {
      String str = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBF, "");
      if (!bt.isNullOrNil(str))
      {
        String[] arrayOfString = str.split(";");
        if (arrayOfString.length > 0) {
          Collections.addAll(LJX, arrayOfString);
        }
      }
      ad.i("MicroMsg.QBarAIModHelper", "alvinluo updateBlackList config: %d, blackListDelayFrames: %d, blackListConfigValue: %s, blackListSize: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(LJV), str, Integer.valueOf(LJX.size()) });
      AppMethodBeat.o(176203);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.QBarAIModHelper", localException, "alvinluo updateBlackList exception", new Object[0]);
      AppMethodBeat.o(176203);
    }
  }
  
  public static int fTt()
  {
    return LJV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qbar.b
 * JD-Core Version:    0.7.0.1
 */