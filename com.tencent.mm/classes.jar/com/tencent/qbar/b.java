package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static int JQi;
  private static List<String> JQj;
  private static List<String> JQk;
  
  static
  {
    AppMethodBeat.i(91140);
    JQi = 6;
    ArrayList localArrayList = new ArrayList();
    JQj = localArrayList;
    localArrayList.add("weixin://wxpay/");
    JQj.add("wxp://");
    JQj.add("https://wx.tenpay.com/");
    JQj.add("https://payapp.weixin.qq.com/");
    JQj.add("https://action.weixin.qq.com/");
    JQk = new ArrayList();
    AppMethodBeat.o(91140);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(91139);
    if (paramf == null)
    {
      ac.w("MicroMsg.QBarAIModHelper", "config wxQBar is null");
      AppMethodBeat.o(91139);
      return;
    }
    Iterator localIterator = JQj.iterator();
    while (localIterator.hasNext()) {
      paramf.aTe((String)localIterator.next());
    }
    localIterator = JQk.iterator();
    while (localIterator.hasNext()) {
      paramf.aTf((String)localIterator.next());
    }
    paramf.aec(6);
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
    ac.i("MicroMsg.QBarAIModHelper", "alvinluo setBlackInterval %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt > 0) {
      paramf.aec(paramInt);
    }
    AppMethodBeat.o(176204);
  }
  
  public static boolean aTc(String paramString)
  {
    AppMethodBeat.i(204943);
    if (paramString == null)
    {
      AppMethodBeat.o(204943);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = JQj.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bs.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(204943);
        return true;
      }
    }
    AppMethodBeat.o(204943);
    return false;
  }
  
  public static boolean aTd(String paramString)
  {
    AppMethodBeat.i(204944);
    if (paramString == null)
    {
      AppMethodBeat.o(204944);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = JQk.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bs.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(204944);
        return true;
      }
    }
    AppMethodBeat.o(204944);
    return false;
  }
  
  public static void fCd()
  {
    AppMethodBeat.i(176203);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWG, 6);
    if (i > 0) {
      JQi = i;
    }
    JQk.clear();
    JQk.add("https://qr.alipay.com/");
    try
    {
      String str = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWH, "");
      if (!bs.isNullOrNil(str))
      {
        String[] arrayOfString = str.split(";");
        if (arrayOfString.length > 0) {
          Collections.addAll(JQk, arrayOfString);
        }
      }
      ac.i("MicroMsg.QBarAIModHelper", "alvinluo updateBlackList config: %d, blackListDelayFrames: %d, blackListConfigValue: %s, blackListSize: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(JQi), str, Integer.valueOf(JQk.size()) });
      AppMethodBeat.o(176203);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.QBarAIModHelper", localException, "alvinluo updateBlackList exception", new Object[0]);
      AppMethodBeat.o(176203);
    }
  }
  
  public static int fCe()
  {
    return JQi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qbar.b
 * JD-Core Version:    0.7.0.1
 */