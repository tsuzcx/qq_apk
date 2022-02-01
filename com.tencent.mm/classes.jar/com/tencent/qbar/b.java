package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ak.a.h;
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
  private static int Zmd;
  private static List<String> Zme;
  private static List<String> Zmf;
  
  static
  {
    AppMethodBeat.i(91140);
    Zmd = 6;
    ArrayList localArrayList = new ArrayList();
    Zme = localArrayList;
    localArrayList.add("weixin://wxpay/");
    Zme.add("wxp://");
    Zme.add("https://wx.tenpay.com/");
    Zme.add("https://" + WeChatHosts.domainString(a.h.host_payapp_weixin_qq_com) + "/");
    Zme.add("https://" + WeChatHosts.domainString(a.h.host_action_weixin_qq_com) + "/");
    Zmf = new ArrayList();
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
    Iterator localIterator = Zme.iterator();
    while (localIterator.hasNext()) {
      paramf.bCO((String)localIterator.next());
    }
    localIterator = Zmf.iterator();
    while (localIterator.hasNext()) {
      paramf.bCP((String)localIterator.next());
    }
    paramf.aAl(6);
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
      paramf.aAl(paramInt);
    }
    AppMethodBeat.o(176204);
  }
  
  public static boolean bCM(String paramString)
  {
    AppMethodBeat.i(193683);
    if (paramString == null)
    {
      AppMethodBeat.o(193683);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = Zme.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(193683);
        return true;
      }
    }
    AppMethodBeat.o(193683);
    return false;
  }
  
  public static boolean bCN(String paramString)
  {
    AppMethodBeat.i(193684);
    if (paramString == null)
    {
      AppMethodBeat.o(193684);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = Zmf.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(193684);
        return true;
      }
    }
    AppMethodBeat.o(193684);
    return false;
  }
  
  public static void inA()
  {
    AppMethodBeat.i(176203);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNZ, 6);
    if (i > 0) {
      Zmd = i;
    }
    Zmf.clear();
    Zmf.add("https://qr.alipay.com/");
    try
    {
      String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOa, "");
      if (!Util.isNullOrNil(str))
      {
        String[] arrayOfString = str.split(";");
        if (arrayOfString.length > 0) {
          Collections.addAll(Zmf, arrayOfString);
        }
      }
      Log.i("MicroMsg.QBarAIModHelper", "alvinluo updateBlackList config: %d, blackListDelayFrames: %d, blackListConfigValue: %s, blackListSize: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Zmd), str, Integer.valueOf(Zmf.size()) });
      AppMethodBeat.o(176203);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.QBarAIModHelper", localException, "alvinluo updateBlackList exception", new Object[0]);
      AppMethodBeat.o(176203);
    }
  }
  
  public static int inB()
  {
    return Zmd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qbar.b
 * JD-Core Version:    0.7.0.1
 */