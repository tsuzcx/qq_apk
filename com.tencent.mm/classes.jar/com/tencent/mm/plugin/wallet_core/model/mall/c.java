package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.y.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class c
{
  private static c BBn = null;
  public Map<String, MallNews> BBo;
  
  private c()
  {
    AppMethodBeat.i(70554);
    this.BBo = new HashMap();
    WJ();
    AppMethodBeat.o(70554);
  }
  
  public static boolean a(MallNews paramMallNews)
  {
    AppMethodBeat.i(70557);
    g.agS();
    String str = (String)g.agR().agA().get(ah.a.GLz, "");
    ArrayList localArrayList = bs.S(str.split(","));
    ac.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[] { str });
    if (paramMallNews == null)
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (bs.isNullOrNil(paramMallNews.zPC))
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (localArrayList.contains(paramMallNews.zPC))
    {
      AppMethodBeat.o(70557);
      return true;
    }
    AppMethodBeat.o(70557);
    return false;
  }
  
  public static void azq(String paramString)
  {
    AppMethodBeat.i(70559);
    if (!bs.isNullOrNil(paramString))
    {
      Map localMap = bv.L(paramString, "sysmsg");
      if (localMap != null)
      {
        int i = bs.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        int j;
        if (i == 31)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = bs.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = bs.getInt((String)localMap.get(".sysmsg.paymsg.BalanceRedDot"), -1);
          int k = bs.getInt((String)localMap.get(".sysmsg.paymsg.LQTRedDot"), -1);
          ac.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k) });
          g.agS();
          g.agR().agA().set(ah.a.GNI, paramString);
          g.agS();
          g.agR().agA().set(ah.a.GNJ, Integer.valueOf(i));
          g.agS();
          g.agR().agA().set(ah.a.GNK, Integer.valueOf(j));
          g.agS();
          g.agR().agA().set(ah.a.GNL, Integer.valueOf(k));
          esQ();
          AppMethodBeat.o(70559);
          return;
        }
        Object localObject1;
        String str3;
        String str2;
        long l;
        if (i == 34)
        {
          localObject1 = localMap.keySet();
          ac.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject1.toString() });
          if (((Set)localObject1).size() > 0)
          {
            paramString = new JSONObject();
            localObject1 = ((Set)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              str3 = (String)((Iterator)localObject1).next();
              if (str3.startsWith(".sysmsg.paymsg.reddot.item"))
              {
                String str1 = (String)localMap.get(str3);
                str2 = str3 + ".$wording";
                str3 = str3 + ".$expire_time";
                str2 = (String)localMap.get(str2);
                l = bs.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!bs.isNullOrNil(str1))
                {
                  ac.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { str1, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(str1))
                  {
                    g.agS();
                    g.agR().agA().set(ah.a.GPG, Boolean.TRUE);
                    if (l > 0L)
                    {
                      g.agS();
                      g.agR().agA().set(ah.a.GPH, Long.valueOf(l));
                    }
                  }
                  else if ("entry_wxpay_wallet".equals(str1))
                  {
                    g.agS();
                    g.agR().agA().set(ah.a.GPI, Boolean.TRUE);
                    if (!bs.isNullOrNil(str2))
                    {
                      g.agS();
                      g.agR().agA().set(ah.a.GPF, str2);
                    }
                    for (;;)
                    {
                      if (l <= 0L) {
                        break label620;
                      }
                      g.agS();
                      g.agR().agA().set(ah.a.GPJ, Long.valueOf(l));
                      break;
                      g.agS();
                      g.agR().agA().set(ah.a.GPF, "");
                    }
                  }
                  else
                  {
                    label620:
                    if ("entry_wxpay_paycenter".equals(str1))
                    {
                      g.agS();
                      g.agR().agA().set(ah.a.GPz, Boolean.TRUE);
                      if (l > 0L)
                      {
                        g.agS();
                        g.agR().agA().set(ah.a.GPA, Long.valueOf(l));
                      }
                    }
                    else
                    {
                      try
                      {
                        paramString.put(str1, 1);
                        if (l > 0L) {
                          paramString.put(String.format("%s_expiretime", new Object[] { str1 }), l);
                        }
                      }
                      catch (Exception localException)
                      {
                        ac.printErrStackTrace("MicroMsg.MallNewsManager", localException, "put redDotConfig json failed: %s", new Object[] { localException.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            ac.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { paramString.toString() });
            if (paramString.length() > 0)
            {
              g.agS();
              g.agR().agA().set(ah.a.GPy, paramString.toString());
              g.agS();
              g.agR().agA().set(ah.a.GPz, Boolean.TRUE);
            }
          }
          AppMethodBeat.o(70559);
          return;
        }
        if (i == 36)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = bs.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = bs.getInt((String)localMap.get(".sysmsg.paymsg.LQBRedDot"), -1);
          ac.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
          g.agS();
          g.agR().agA().set(ah.a.GNI, paramString);
          g.agS();
          g.agR().agA().set(ah.a.GNJ, Integer.valueOf(i));
          g.agS();
          g.agR().agA().set(ah.a.GNM, Integer.valueOf(j));
          esQ();
          AppMethodBeat.o(70559);
          return;
        }
        if (i == 38)
        {
          Object localObject2 = localMap.keySet();
          ac.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject2.toString() });
          if (((Set)localObject2).size() > 0)
          {
            localObject1 = new JSONObject();
            localObject2 = ((Set)localObject2).iterator();
            j = 0;
            i = 0;
            while (((Iterator)localObject2).hasNext())
            {
              str3 = (String)((Iterator)localObject2).next();
              if (str3.startsWith(".sysmsg.paymsg.reddot.item"))
              {
                paramString = (String)localMap.get(str3);
                str2 = str3 + ".$wording";
                str3 = str3 + ".$expire_time";
                str2 = (String)localMap.get(str2);
                l = bs.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!bs.isNullOrNil(paramString))
                {
                  ac.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { paramString, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(paramString))
                  {
                    com.tencent.mm.y.c.aeH().b(ah.a.GPM, true);
                    g.agS();
                    g.agR().agA().set(ah.a.GPN, Long.valueOf(l));
                    i = 1;
                  }
                  else
                  {
                    if ("entry_wxpay_pay".equals(paramString))
                    {
                      com.tencent.mm.y.c.aeH().b(ah.a.GPM, true);
                      if (!bs.isNullOrNil(str2))
                      {
                        g.agS();
                        g.agR().agA().set(ah.a.GPL, str2);
                      }
                      for (;;)
                      {
                        g.agS();
                        g.agR().agA().set(ah.a.GPO, Long.valueOf(l));
                        j = 1;
                        break;
                        g.agS();
                        g.agR().agA().set(ah.a.GPL, "");
                      }
                    }
                    if ("entry_wxpay_pay_wallet".equals(paramString))
                    {
                      g.agS();
                      g.agR().agA().set(ah.a.GPP, Boolean.TRUE);
                      g.agS();
                      g.agR().agA().set(ah.a.GPQ, Long.valueOf(l));
                    }
                    else
                    {
                      if (paramString.startsWith("bind_serial_"))
                      {
                        paramString = paramString.substring(12);
                        g.agS();
                        str2 = (String)g.agR().agA().get(ah.a.GOl, "");
                        ac.d("MicroMsg.MallNewsManager", "bind serial: %s", new Object[] { paramString });
                        if (!bs.isNullOrNil(str2)) {
                          paramString = str2 + "," + paramString;
                        }
                        for (;;)
                        {
                          g.agS();
                          g.agR().agA().set(ah.a.GOl, paramString);
                          break;
                        }
                      }
                      try
                      {
                        ((JSONObject)localObject1).put(paramString, 1);
                        ((JSONObject)localObject1).put(String.format("%s_expiretime", new Object[] { paramString }), l);
                      }
                      catch (Exception paramString)
                      {
                        ac.printErrStackTrace("MicroMsg.MallNewsManager", paramString, "put redDotConfig json failed: %s", new Object[] { paramString.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            if (i == 0) {
              com.tencent.mm.y.c.aeH().c(ah.a.GPM, ah.a.GPU);
            }
            if (j == 0) {
              com.tencent.mm.y.c.aeH().c(ah.a.GPM, ah.a.GPT);
            }
            ac.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { ((JSONObject)localObject1).toString() });
            if (((JSONObject)localObject1).length() > 0)
            {
              g.agS();
              g.agR().agA().set(ah.a.GPR, ((JSONObject)localObject1).toString());
              g.agS();
              g.agR().agA().set(ah.a.GPP, Boolean.TRUE);
            }
          }
        }
      }
    }
    AppMethodBeat.o(70559);
  }
  
  public static MallNews azt(String paramString)
  {
    AppMethodBeat.i(70565);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70565);
      return null;
    }
    Map localMap = bv.L(paramString, "sysmsg");
    if (localMap == null)
    {
      AppMethodBeat.o(70565);
      return null;
    }
    MallNews localMallNews;
    for (;;)
    {
      try
      {
        localMallNews = new MallNews((String)localMap.get(".sysmsg.mallactivity.functionid"));
        localMallNews.zPC = ((String)localMap.get(".sysmsg.mallactivity.activityid"));
        localMallNews.ddJ = ((String)localMap.get(".sysmsg.mallactivity.ticket"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivity.type"));
        localMallNews.cZX = bs.getInt((String)localMap.get(".sysmsg.mallactivity.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivity.showflag"))
        {
          localMallNews.BBd = ((String)localMap.get(".sysmsg.mallactivity.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivity.newsTipFlag"))
          {
            localMallNews.BBe = ((String)localMap.get(".sysmsg.mallactivity.newsTipFlag"));
            localMallNews.BBl = paramString;
            boolean bool = bs.isNullOrNil(localMallNews.hvE);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70565);
            return null;
          }
        }
        else
        {
          localMallNews.BBd = "0";
          continue;
        }
        localMallNews.BBe = "0";
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.MallNewsManager", "cmdid error");
        AppMethodBeat.o(70565);
        return null;
      }
    }
    AppMethodBeat.o(70565);
    return localMallNews;
  }
  
  public static void e(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(70558);
    try
    {
      if (bs.isNullOrNil(paramMallFunction.BAX.zPC)) {
        break label181;
      }
      g.agS();
      localObject = bs.S(((String)g.agR().agA().get(ah.a.GLz, "")).split(","));
      while (((List)localObject).size() > 20) {
        ((List)localObject).remove(0);
      }
      bool = ((List)localObject).contains(paramMallFunction.BAX.zPC);
    }
    catch (Exception paramMallFunction)
    {
      ac.printErrStackTrace("MicroMsg.MallNewsManager", paramMallFunction, "error in markedFunction", new Object[0]);
      AppMethodBeat.o(70558);
      return;
    }
    boolean bool;
    if (bool)
    {
      AppMethodBeat.o(70558);
      return;
    }
    ((List)localObject).add(paramMallFunction.BAX.zPC);
    Object localObject = bs.n((List)localObject, ",");
    ac.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[] { paramMallFunction.BAX.zPC, localObject });
    g.agS();
    g.agR().agA().set(ah.a.GLz, localObject);
    label181:
    AppMethodBeat.o(70558);
  }
  
  public static c esN()
  {
    AppMethodBeat.i(70553);
    if (BBn == null) {
      BBn = new c();
    }
    c localc = BBn;
    AppMethodBeat.o(70553);
    return localc;
  }
  
  public static void esP()
  {
    AppMethodBeat.i(70560);
    g.agS();
    g.agR().agA().set(ah.a.GNI, "");
    g.agS();
    g.agR().agA().set(ah.a.GNJ, Integer.valueOf(-1));
    AppMethodBeat.o(70560);
  }
  
  public static void esQ()
  {
    AppMethodBeat.i(70561);
    ac.d("MicroMsg.MallNewsManager", "clearMallNew ");
    com.tencent.mm.y.c.aeH().cI(262156, 266248);
    AppMethodBeat.o(70561);
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(70555);
    this.BBo.clear();
    g.agS();
    Object localObject = (String)g.agR().agA().get(270339, "");
    ac.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bs.S(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = azt((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.BBo.put(localMallNews.hvE, localMallNews);
      }
    }
    AppMethodBeat.o(70555);
  }
  
  public final void aH(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(70566);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.BBo.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((Set)localObject).remove(((MallFunction)paramArrayList.next()).wfu);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.BBo.remove(localObject);
      }
      dpl();
    }
    AppMethodBeat.o(70566);
  }
  
  public final String azr(String paramString)
  {
    AppMethodBeat.i(70563);
    paramString = (MallNews)this.BBo.get(paramString);
    if ((paramString != null) && (!bs.isNullOrNil(paramString.ddJ)))
    {
      paramString = paramString.ddJ;
      AppMethodBeat.o(70563);
      return paramString;
    }
    AppMethodBeat.o(70563);
    return null;
  }
  
  public final MallNews azs(String paramString)
  {
    AppMethodBeat.i(70564);
    ac.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bs.isNullOrNil(paramString)) && (this.BBo.containsKey(paramString)))
    {
      paramString = (MallNews)this.BBo.get(paramString);
      if ("0".equals(paramString.BBd))
      {
        paramString.BBd = "1";
        dpl();
      }
      AppMethodBeat.o(70564);
      return paramString;
    }
    AppMethodBeat.o(70564);
    return null;
  }
  
  public final boolean dpl()
  {
    AppMethodBeat.i(70562);
    ac.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.BBo.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.BBo.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.BBo.get(localObject);
        localStringBuffer.append(((MallNews)localObject).BBl.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + ((MallNews)localObject).BBd + "</showflag><newsTipFlag>" + ((MallNews)localObject).BBe + "</newsTipFlag></mallactivity></sysmsg>;");
      }
    }
    ac.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.agS();
    g.agR().agA().set(270339, localStringBuffer.toString());
    AppMethodBeat.o(70562);
    return true;
  }
  
  public final List<String> esO()
  {
    AppMethodBeat.i(70556);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.BBo.values().iterator();
    while (localIterator.hasNext())
    {
      MallNews localMallNews = (MallNews)localIterator.next();
      if (!bs.isNullOrNil(localMallNews.ddJ)) {
        localArrayList.add(localMallNews.ddJ);
      }
    }
    ac.d("MicroMsg.MallNewsManager", "tickets.size : " + localArrayList.size());
    AppMethodBeat.o(70556);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.c
 * JD-Core Version:    0.7.0.1
 */