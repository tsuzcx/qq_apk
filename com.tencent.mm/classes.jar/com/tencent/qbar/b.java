package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static int RJv;
  private static List<String> RJw;
  private static List<String> RJx;
  
  static
  {
    AppMethodBeat.i(91140);
    RJv = 6;
    ArrayList localArrayList = new ArrayList();
    RJw = localArrayList;
    localArrayList.add("weixin://wxpay/");
    RJw.add("wxp://");
    RJw.add("https://wx.tenpay.com/");
    RJw.add("https://" + WeChatHosts.domainString(2131761732) + "/");
    RJw.add("https://" + WeChatHosts.domainString(2131761702) + "/");
    RJx = new ArrayList();
    AppMethodBeat.o(91140);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(91139);
    if (paramf == null)
    {
      Log.w("MicroMsg.QBarAIModHelper", "config wxQBar is null");
      AppMethodBeat.o(91139);
      return;
    }
    Iterator localIterator = RJw.iterator();
    while (localIterator.hasNext()) {
      paramf.bpW((String)localIterator.next());
    }
    localIterator = RJx.iterator();
    while (localIterator.hasNext()) {
      paramf.bpX((String)localIterator.next());
    }
    paramf.aqy(6);
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
    Log.i("MicroMsg.QBarAIModHelper", "alvinluo setBlackInterval %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt > 0) {
      paramf.aqy(paramInt);
    }
    AppMethodBeat.o(176204);
  }
  
  public static boolean bpU(String paramString)
  {
    AppMethodBeat.i(194821);
    if (paramString == null)
    {
      AppMethodBeat.o(194821);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = RJw.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(194821);
        return true;
      }
    }
    AppMethodBeat.o(194821);
    return false;
  }
  
  public static boolean bpV(String paramString)
  {
    AppMethodBeat.i(194822);
    if (paramString == null)
    {
      AppMethodBeat.o(194822);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = RJx.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(194822);
        return true;
      }
    }
    AppMethodBeat.o(194822);
    return false;
  }
  
  public static void hke()
  {
    AppMethodBeat.i(176203);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sev, 6);
    if (i > 0) {
      RJv = i;
    }
    RJx.clear();
    RJx.add("https://qr.alipay.com/");
    try
    {
      String str = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sew, "");
      if (!Util.isNullOrNil(str))
      {
        String[] arrayOfString = str.split(";");
        if (arrayOfString.length > 0) {
          Collections.addAll(RJx, arrayOfString);
        }
      }
      Log.i("MicroMsg.QBarAIModHelper", "alvinluo updateBlackList config: %d, blackListDelayFrames: %d, blackListConfigValue: %s, blackListSize: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(RJv), str, Integer.valueOf(RJx.size()) });
      AppMethodBeat.o(176203);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.QBarAIModHelper", localException, "alvinluo updateBlackList exception", new Object[0]);
      AppMethodBeat.o(176203);
    }
  }
  
  public static int hkf()
  {
    return RJv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qbar.b
 * JD-Core Version:    0.7.0.1
 */