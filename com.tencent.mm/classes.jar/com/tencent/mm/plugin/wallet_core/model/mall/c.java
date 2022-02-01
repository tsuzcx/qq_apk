package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.z.a;
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
  private static c AiS = null;
  public Map<String, MallNews> AiT;
  
  private c()
  {
    AppMethodBeat.i(70554);
    this.AiT = new HashMap();
    VL();
    AppMethodBeat.o(70554);
  }
  
  public static boolean a(MallNews paramMallNews)
  {
    AppMethodBeat.i(70557);
    g.afC();
    String str = (String)g.afB().afk().get(ae.a.FnK, "");
    ArrayList localArrayList = bt.S(str.split(","));
    ad.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[] { str });
    if (paramMallNews == null)
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (bt.isNullOrNil(paramMallNews.yCo))
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (localArrayList.contains(paramMallNews.yCo))
    {
      AppMethodBeat.o(70557);
      return true;
    }
    AppMethodBeat.o(70557);
    return false;
  }
  
  public static void atY(String paramString)
  {
    AppMethodBeat.i(70559);
    if (!bt.isNullOrNil(paramString))
    {
      Map localMap = bw.K(paramString, "sysmsg");
      if (localMap != null)
      {
        int i = bt.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        int j;
        if (i == 31)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = bt.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = bt.getInt((String)localMap.get(".sysmsg.paymsg.BalanceRedDot"), -1);
          int k = bt.getInt((String)localMap.get(".sysmsg.paymsg.LQTRedDot"), -1);
          ad.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k) });
          g.afC();
          g.afB().afk().set(ae.a.FpS, paramString);
          g.afC();
          g.afB().afk().set(ae.a.FpT, Integer.valueOf(i));
          g.afC();
          g.afB().afk().set(ae.a.FpU, Integer.valueOf(j));
          g.afC();
          g.afB().afk().set(ae.a.FpV, Integer.valueOf(k));
          edv();
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
          ad.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject1.toString() });
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
                l = bt.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!bt.isNullOrNil(str1))
                {
                  ad.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { str1, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(str1))
                  {
                    g.afC();
                    g.afB().afk().set(ae.a.FrQ, Boolean.TRUE);
                    if (l > 0L)
                    {
                      g.afC();
                      g.afB().afk().set(ae.a.FrR, Long.valueOf(l));
                    }
                  }
                  else if ("entry_wxpay_wallet".equals(str1))
                  {
                    g.afC();
                    g.afB().afk().set(ae.a.FrS, Boolean.TRUE);
                    if (!bt.isNullOrNil(str2))
                    {
                      g.afC();
                      g.afB().afk().set(ae.a.FrP, str2);
                    }
                    for (;;)
                    {
                      if (l <= 0L) {
                        break label620;
                      }
                      g.afC();
                      g.afB().afk().set(ae.a.FrT, Long.valueOf(l));
                      break;
                      g.afC();
                      g.afB().afk().set(ae.a.FrP, "");
                    }
                  }
                  else
                  {
                    label620:
                    if ("entry_wxpay_paycenter".equals(str1))
                    {
                      g.afC();
                      g.afB().afk().set(ae.a.FrJ, Boolean.TRUE);
                      if (l > 0L)
                      {
                        g.afC();
                        g.afB().afk().set(ae.a.FrK, Long.valueOf(l));
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
                        ad.printErrStackTrace("MicroMsg.MallNewsManager", localException, "put redDotConfig json failed: %s", new Object[] { localException.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            ad.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { paramString.toString() });
            if (paramString.length() > 0)
            {
              g.afC();
              g.afB().afk().set(ae.a.FrI, paramString.toString());
              g.afC();
              g.afB().afk().set(ae.a.FrJ, Boolean.TRUE);
            }
          }
          AppMethodBeat.o(70559);
          return;
        }
        if (i == 36)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = bt.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = bt.getInt((String)localMap.get(".sysmsg.paymsg.LQBRedDot"), -1);
          ad.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
          g.afC();
          g.afB().afk().set(ae.a.FpS, paramString);
          g.afC();
          g.afB().afk().set(ae.a.FpT, Integer.valueOf(i));
          g.afC();
          g.afB().afk().set(ae.a.FpW, Integer.valueOf(j));
          edv();
          AppMethodBeat.o(70559);
          return;
        }
        if (i == 38)
        {
          Object localObject2 = localMap.keySet();
          ad.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject2.toString() });
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
                l = bt.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!bt.isNullOrNil(paramString))
                {
                  ad.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { paramString, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(paramString))
                  {
                    com.tencent.mm.z.c.adr().b(ae.a.FrW, true);
                    g.afC();
                    g.afB().afk().set(ae.a.FrX, Long.valueOf(l));
                    i = 1;
                  }
                  else
                  {
                    if ("entry_wxpay_pay".equals(paramString))
                    {
                      com.tencent.mm.z.c.adr().b(ae.a.FrW, true);
                      if (!bt.isNullOrNil(str2))
                      {
                        g.afC();
                        g.afB().afk().set(ae.a.FrV, str2);
                      }
                      for (;;)
                      {
                        g.afC();
                        g.afB().afk().set(ae.a.FrY, Long.valueOf(l));
                        j = 1;
                        break;
                        g.afC();
                        g.afB().afk().set(ae.a.FrV, "");
                      }
                    }
                    if ("entry_wxpay_pay_wallet".equals(paramString))
                    {
                      g.afC();
                      g.afB().afk().set(ae.a.FrZ, Boolean.TRUE);
                      g.afC();
                      g.afB().afk().set(ae.a.Fsa, Long.valueOf(l));
                    }
                    else
                    {
                      if (paramString.startsWith("bind_serial_"))
                      {
                        paramString = paramString.substring(12);
                        g.afC();
                        str2 = (String)g.afB().afk().get(ae.a.Fqv, "");
                        ad.d("MicroMsg.MallNewsManager", "bind serial: %s", new Object[] { paramString });
                        if (!bt.isNullOrNil(str2)) {
                          paramString = str2 + "," + paramString;
                        }
                        for (;;)
                        {
                          g.afC();
                          g.afB().afk().set(ae.a.Fqv, paramString);
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
                        ad.printErrStackTrace("MicroMsg.MallNewsManager", paramString, "put redDotConfig json failed: %s", new Object[] { paramString.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            if (i == 0) {
              com.tencent.mm.z.c.adr().c(ae.a.FrW, ae.a.Fsd);
            }
            if (j == 0) {
              com.tencent.mm.z.c.adr().c(ae.a.FrW, ae.a.Fsc);
            }
            ad.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { ((JSONObject)localObject1).toString() });
            if (((JSONObject)localObject1).length() > 0)
            {
              g.afC();
              g.afB().afk().set(ae.a.Fsb, ((JSONObject)localObject1).toString());
              g.afC();
              g.afB().afk().set(ae.a.FrZ, Boolean.TRUE);
            }
          }
        }
      }
    }
    AppMethodBeat.o(70559);
  }
  
  public static MallNews aub(String paramString)
  {
    AppMethodBeat.i(70565);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70565);
      return null;
    }
    Map localMap = bw.K(paramString, "sysmsg");
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
        localMallNews.yCo = ((String)localMap.get(".sysmsg.mallactivity.activityid"));
        localMallNews.dgo = ((String)localMap.get(".sysmsg.mallactivity.ticket"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivity.type"));
        localMallNews.dcz = bt.getInt((String)localMap.get(".sysmsg.mallactivity.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivity.showflag"))
        {
          localMallNews.AiI = ((String)localMap.get(".sysmsg.mallactivity.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivity.newsTipFlag"))
          {
            localMallNews.AiJ = ((String)localMap.get(".sysmsg.mallactivity.newsTipFlag"));
            localMallNews.AiQ = paramString;
            boolean bool = bt.isNullOrNil(localMallNews.gVf);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70565);
            return null;
          }
        }
        else
        {
          localMallNews.AiI = "0";
          continue;
        }
        localMallNews.AiJ = "0";
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.MallNewsManager", "cmdid error");
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
      if (bt.isNullOrNil(paramMallFunction.AiC.yCo)) {
        break label181;
      }
      g.afC();
      localObject = bt.S(((String)g.afB().afk().get(ae.a.FnK, "")).split(","));
      while (((List)localObject).size() > 20) {
        ((List)localObject).remove(0);
      }
      bool = ((List)localObject).contains(paramMallFunction.AiC.yCo);
    }
    catch (Exception paramMallFunction)
    {
      ad.printErrStackTrace("MicroMsg.MallNewsManager", paramMallFunction, "error in markedFunction", new Object[0]);
      AppMethodBeat.o(70558);
      return;
    }
    boolean bool;
    if (bool)
    {
      AppMethodBeat.o(70558);
      return;
    }
    ((List)localObject).add(paramMallFunction.AiC.yCo);
    Object localObject = bt.n((List)localObject, ",");
    ad.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[] { paramMallFunction.AiC.yCo, localObject });
    g.afC();
    g.afB().afk().set(ae.a.FnK, localObject);
    label181:
    AppMethodBeat.o(70558);
  }
  
  public static c eds()
  {
    AppMethodBeat.i(70553);
    if (AiS == null) {
      AiS = new c();
    }
    c localc = AiS;
    AppMethodBeat.o(70553);
    return localc;
  }
  
  public static void edu()
  {
    AppMethodBeat.i(70560);
    g.afC();
    g.afB().afk().set(ae.a.FpS, "");
    g.afC();
    g.afB().afk().set(ae.a.FpT, Integer.valueOf(-1));
    AppMethodBeat.o(70560);
  }
  
  public static void edv()
  {
    AppMethodBeat.i(70561);
    ad.d("MicroMsg.MallNewsManager", "clearMallNew ");
    com.tencent.mm.z.c.adr().cK(262156, 266248);
    AppMethodBeat.o(70561);
  }
  
  public final void VL()
  {
    AppMethodBeat.i(70555);
    this.AiT.clear();
    g.afC();
    Object localObject = (String)g.afB().afk().get(270339, "");
    ad.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bt.S(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = aub((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.AiT.put(localMallNews.gVf, localMallNews);
      }
    }
    AppMethodBeat.o(70555);
  }
  
  public final String atZ(String paramString)
  {
    AppMethodBeat.i(70563);
    paramString = (MallNews)this.AiT.get(paramString);
    if ((paramString != null) && (!bt.isNullOrNil(paramString.dgo)))
    {
      paramString = paramString.dgo;
      AppMethodBeat.o(70563);
      return paramString;
    }
    AppMethodBeat.o(70563);
    return null;
  }
  
  public final MallNews aua(String paramString)
  {
    AppMethodBeat.i(70564);
    ad.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bt.isNullOrNil(paramString)) && (this.AiT.containsKey(paramString)))
    {
      paramString = (MallNews)this.AiT.get(paramString);
      if ("0".equals(paramString.AiI))
      {
        paramString.AiI = "1";
        dbD();
      }
      AppMethodBeat.o(70564);
      return paramString;
    }
    AppMethodBeat.o(70564);
    return null;
  }
  
  public final void av(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(70566);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.AiT.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((Set)localObject).remove(((MallFunction)paramArrayList.next()).uWF);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.AiT.remove(localObject);
      }
      dbD();
    }
    AppMethodBeat.o(70566);
  }
  
  public final boolean dbD()
  {
    AppMethodBeat.i(70562);
    ad.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.AiT.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.AiT.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.AiT.get(localObject);
        localStringBuffer.append(((MallNews)localObject).AiQ.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + ((MallNews)localObject).AiI + "</showflag><newsTipFlag>" + ((MallNews)localObject).AiJ + "</newsTipFlag></mallactivity></sysmsg>;");
      }
    }
    ad.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.afC();
    g.afB().afk().set(270339, localStringBuffer.toString());
    AppMethodBeat.o(70562);
    return true;
  }
  
  public final List<String> edt()
  {
    AppMethodBeat.i(70556);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.AiT.values().iterator();
    while (localIterator.hasNext())
    {
      MallNews localMallNews = (MallNews)localIterator.next();
      if (!bt.isNullOrNil(localMallNews.dgo)) {
        localArrayList.add(localMallNews.dgo);
      }
    }
    ad.d("MicroMsg.MallNewsManager", "tickets.size : " + localArrayList.size());
    AppMethodBeat.o(70556);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.c
 * JD-Core Version:    0.7.0.1
 */