package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static int MgU;
  private static List<String> MgV;
  private static List<String> MgW;
  
  static
  {
    AppMethodBeat.i(91140);
    MgU = 6;
    ArrayList localArrayList = new ArrayList();
    MgV = localArrayList;
    localArrayList.add("weixin://wxpay/");
    MgV.add("wxp://");
    MgV.add("https://wx.tenpay.com/");
    MgV.add("https://payapp.weixin.qq.com/");
    MgV.add("https://action.weixin.qq.com/");
    MgW = new ArrayList();
    AppMethodBeat.o(91140);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(91139);
    if (paramf == null)
    {
      ae.w("MicroMsg.QBarAIModHelper", "config wxQBar is null");
      AppMethodBeat.o(91139);
      return;
    }
    Iterator localIterator = MgV.iterator();
    while (localIterator.hasNext()) {
      paramf.baH((String)localIterator.next());
    }
    localIterator = MgW.iterator();
    while (localIterator.hasNext()) {
      paramf.baI((String)localIterator.next());
    }
    paramf.ahl(6);
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
    ae.i("MicroMsg.QBarAIModHelper", "alvinluo setBlackInterval %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt > 0) {
      paramf.ahl(paramInt);
    }
    AppMethodBeat.o(176204);
  }
  
  public static boolean baF(String paramString)
  {
    AppMethodBeat.i(196683);
    if (paramString == null)
    {
      AppMethodBeat.o(196683);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = MgV.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bu.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(196683);
        return true;
      }
    }
    AppMethodBeat.o(196683);
    return false;
  }
  
  public static boolean baG(String paramString)
  {
    AppMethodBeat.i(196684);
    if (paramString == null)
    {
      AppMethodBeat.o(196684);
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = MgW.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bu.isNullOrNil(str)) && (paramString.startsWith(str)))
      {
        AppMethodBeat.o(196684);
        return true;
      }
    }
    AppMethodBeat.o(196684);
    return false;
  }
  
  public static void fXS()
  {
    AppMethodBeat.i(176203);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIX, 6);
    if (i > 0) {
      MgU = i;
    }
    MgW.clear();
    MgW.add("https://qr.alipay.com/");
    try
    {
      String str = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIY, "");
      if (!bu.isNullOrNil(str))
      {
        String[] arrayOfString = str.split(";");
        if (arrayOfString.length > 0) {
          Collections.addAll(MgW, arrayOfString);
        }
      }
      ae.i("MicroMsg.QBarAIModHelper", "alvinluo updateBlackList config: %d, blackListDelayFrames: %d, blackListConfigValue: %s, blackListSize: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(MgU), str, Integer.valueOf(MgW.size()) });
      AppMethodBeat.o(176203);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.QBarAIModHelper", localException, "alvinluo updateBlackList exception", new Object[0]);
      AppMethodBeat.o(176203);
    }
  }
  
  public static int fXT()
  {
    return MgU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qbar.b
 * JD-Core Version:    0.7.0.1
 */