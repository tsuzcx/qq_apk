package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static int Iox;
  private static List<String> Ioy;
  private static List<String> Ioz;
  
  static
  {
    AppMethodBeat.i(91140);
    Iox = 6;
    ArrayList localArrayList = new ArrayList();
    Ioy = localArrayList;
    localArrayList.add("weixin://wxpay/");
    Ioy.add("wxp://");
    Ioy.add("https://wx.tenpay.com/");
    Ioy.add("https://payapp.weixin.qq.com/");
    Ioy.add("https://action.weixin.qq.com/");
    Ioz = new ArrayList();
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
    Iterator localIterator = Ioy.iterator();
    while (localIterator.hasNext()) {
      paramf.aNB((String)localIterator.next());
    }
    localIterator = Ioz.iterator();
    while (localIterator.hasNext()) {
      paramf.aNC((String)localIterator.next());
    }
    paramf.abJ(6);
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
      paramf.abJ(paramInt);
    }
    AppMethodBeat.o(176204);
  }
  
  public static boolean aNA(String paramString)
  {
    AppMethodBeat.i(190141);
    if (paramString == null)
    {
      AppMethodBeat.o(190141);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = Ioz.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bt.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(190141);
        return true;
      }
    }
    AppMethodBeat.o(190141);
    return false;
  }
  
  public static boolean aNz(String paramString)
  {
    AppMethodBeat.i(190140);
    if (paramString == null)
    {
      AppMethodBeat.o(190140);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = Ioy.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bt.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(190140);
        return true;
      }
    }
    AppMethodBeat.o(190140);
    return false;
  }
  
  public static void flM()
  {
    AppMethodBeat.i(176203);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psx, 6);
    if (i > 0) {
      Iox = i;
    }
    Ioz.clear();
    Ioz.add("https://qr.alipay.com/");
    try
    {
      String str = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psy, "");
      if (!bt.isNullOrNil(str))
      {
        String[] arrayOfString = str.split(";");
        if (arrayOfString.length > 0) {
          Collections.addAll(Ioz, arrayOfString);
        }
      }
      ad.i("MicroMsg.QBarAIModHelper", "alvinluo updateBlackList config: %d, blackListDelayFrames: %d, blackListConfigValue: %s, blackListSize: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Iox), str, Integer.valueOf(Ioz.size()) });
      AppMethodBeat.o(176203);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.QBarAIModHelper", localException, "alvinluo updateBlackList exception", new Object[0]);
      AppMethodBeat.o(176203);
    }
  }
  
  public static int flN()
  {
    return Iox;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qbar.b
 * JD-Core Version:    0.7.0.1
 */