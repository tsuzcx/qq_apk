package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.al.a.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static int ahqx;
  private static List<String> ahqy;
  private static List<String> ahqz;
  
  static
  {
    AppMethodBeat.i(91140);
    ahqx = 6;
    ArrayList localArrayList = new ArrayList();
    ahqy = localArrayList;
    localArrayList.add("weixin://wxpay/");
    ahqy.add("wxp://");
    ahqy.add("https://wx.tenpay.com/");
    ahqy.add("https://" + WeChatHosts.domainString(a.h.host_payapp_weixin_qq_com) + "/");
    ahqy.add("https://" + WeChatHosts.domainString(a.h.host_action_weixin_qq_com) + "/");
    ahqz = new ArrayList();
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
    Iterator localIterator = ahqy.iterator();
    while (localIterator.hasNext()) {
      paramf.bFs((String)localIterator.next());
    }
    localIterator = ahqz.iterator();
    while (localIterator.hasNext()) {
      paramf.bFt((String)localIterator.next());
    }
    paramf.aGX(6);
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
      paramf.aGX(paramInt);
    }
    AppMethodBeat.o(176204);
  }
  
  public static boolean bFp(String paramString)
  {
    AppMethodBeat.i(226807);
    if (paramString == null)
    {
      AppMethodBeat.o(226807);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = ahqy.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(226807);
        return true;
      }
    }
    AppMethodBeat.o(226807);
    return false;
  }
  
  public static boolean bFq(String paramString)
  {
    AppMethodBeat.i(226810);
    if (paramString == null)
    {
      AppMethodBeat.o(226810);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = ahqz.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(226810);
        return true;
      }
    }
    AppMethodBeat.o(226810);
    return false;
  }
  
  public static void jWI()
  {
    AppMethodBeat.i(176203);
    int i = ((c)h.ax(c.class)).a(c.a.zgb, 6);
    if (i > 0) {
      ahqx = i;
    }
    ahqz.clear();
    ahqz.add("https://qr.alipay.com/");
    try
    {
      String str = ((c)h.ax(c.class)).a(c.a.zgc, "");
      if (!Util.isNullOrNil(str))
      {
        String[] arrayOfString = str.split(";");
        if (arrayOfString.length > 0) {
          Collections.addAll(ahqz, arrayOfString);
        }
      }
      Log.i("MicroMsg.QBarAIModHelper", "alvinluo updateBlackList config: %d, blackListDelayFrames: %d, blackListConfigValue: %s, blackListSize: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(ahqx), str, Integer.valueOf(ahqz.size()) });
      AppMethodBeat.o(176203);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.QBarAIModHelper", localException, "alvinluo updateBlackList exception", new Object[0]);
      AppMethodBeat.o(176203);
    }
  }
  
  public static int jWJ()
  {
    return ahqx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qbar.b
 * JD-Core Version:    0.7.0.1
 */