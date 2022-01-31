package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
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
  private static c umx = null;
  public Map<String, MallNews> umy;
  
  private c()
  {
    AppMethodBeat.i(47022);
    this.umy = new HashMap();
    Kc();
    AppMethodBeat.o(47022);
  }
  
  public static boolean a(MallNews paramMallNews)
  {
    AppMethodBeat.i(47025);
    g.RM();
    String str = (String)g.RL().Ru().get(ac.a.yFb, "");
    ArrayList localArrayList = bo.P(str.split(","));
    ab.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[] { str });
    if (paramMallNews == null)
    {
      AppMethodBeat.o(47025);
      return false;
    }
    if (bo.isNullOrNil(paramMallNews.sWB))
    {
      AppMethodBeat.o(47025);
      return false;
    }
    if (localArrayList.contains(paramMallNews.sWB))
    {
      AppMethodBeat.o(47025);
      return true;
    }
    AppMethodBeat.o(47025);
    return false;
  }
  
  public static void afp(String paramString)
  {
    AppMethodBeat.i(47027);
    if (!bo.isNullOrNil(paramString))
    {
      Map localMap = br.F(paramString, "sysmsg");
      if (localMap != null)
      {
        int i = bo.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        int j;
        if (i == 31)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = bo.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = bo.getInt((String)localMap.get(".sysmsg.paymsg.BalanceRedDot"), -1);
          int k = bo.getInt((String)localMap.get(".sysmsg.paymsg.LQTRedDot"), -1);
          ab.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k) });
          g.RM();
          g.RL().Ru().set(ac.a.yHh, paramString);
          g.RM();
          g.RL().Ru().set(ac.a.yHi, Integer.valueOf(i));
          g.RM();
          g.RL().Ru().set(ac.a.yHj, Integer.valueOf(j));
          g.RM();
          g.RL().Ru().set(ac.a.yHk, Integer.valueOf(k));
          cVa();
          AppMethodBeat.o(47027);
          return;
        }
        Object localObject1;
        String str3;
        String str2;
        long l;
        if (i == 34)
        {
          localObject1 = localMap.keySet();
          ab.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject1.toString() });
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
                l = bo.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!bo.isNullOrNil(str1))
                {
                  ab.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { str1, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(str1))
                  {
                    g.RM();
                    g.RL().Ru().set(ac.a.yIS, Boolean.TRUE);
                    if (l > 0L)
                    {
                      g.RM();
                      g.RL().Ru().set(ac.a.yIT, Long.valueOf(l));
                    }
                  }
                  else if ("entry_wxpay_wallet".equals(str1))
                  {
                    g.RM();
                    g.RL().Ru().set(ac.a.yIU, Boolean.TRUE);
                    if (!bo.isNullOrNil(str2))
                    {
                      g.RM();
                      g.RL().Ru().set(ac.a.yIR, str2);
                    }
                    for (;;)
                    {
                      if (l <= 0L) {
                        break label620;
                      }
                      g.RM();
                      g.RL().Ru().set(ac.a.yIV, Long.valueOf(l));
                      break;
                      g.RM();
                      g.RL().Ru().set(ac.a.yIR, "");
                    }
                  }
                  else
                  {
                    label620:
                    if ("entry_wxpay_paycenter".equals(str1))
                    {
                      g.RM();
                      g.RL().Ru().set(ac.a.yIM, Boolean.TRUE);
                      if (l > 0L)
                      {
                        g.RM();
                        g.RL().Ru().set(ac.a.yIN, Long.valueOf(l));
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
                        ab.printErrStackTrace("MicroMsg.MallNewsManager", localException, "put redDotConfig json failed: %s", new Object[] { localException.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            ab.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { paramString.toString() });
            if (paramString.length() > 0)
            {
              g.RM();
              g.RL().Ru().set(ac.a.yIL, paramString.toString());
              g.RM();
              g.RL().Ru().set(ac.a.yIM, Boolean.TRUE);
            }
          }
          AppMethodBeat.o(47027);
          return;
        }
        if (i == 36)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = bo.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = bo.getInt((String)localMap.get(".sysmsg.paymsg.LQBRedDot"), -1);
          ab.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
          g.RM();
          g.RL().Ru().set(ac.a.yHh, paramString);
          g.RM();
          g.RL().Ru().set(ac.a.yHi, Integer.valueOf(i));
          g.RM();
          g.RL().Ru().set(ac.a.yHl, Integer.valueOf(j));
          cVa();
          AppMethodBeat.o(47027);
          return;
        }
        if (i == 38)
        {
          Object localObject2 = localMap.keySet();
          ab.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject2.toString() });
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
                l = bo.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!bo.isNullOrNil(paramString))
                {
                  ab.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { paramString, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(paramString))
                  {
                    com.tencent.mm.x.c.PJ().b(ac.a.yIY, true);
                    g.RM();
                    g.RL().Ru().set(ac.a.yIZ, Long.valueOf(l));
                    i = 1;
                  }
                  else
                  {
                    if ("entry_wxpay_pay".equals(paramString))
                    {
                      com.tencent.mm.x.c.PJ().b(ac.a.yIY, true);
                      if (!bo.isNullOrNil(str2))
                      {
                        g.RM();
                        g.RL().Ru().set(ac.a.yIX, str2);
                      }
                      for (;;)
                      {
                        g.RM();
                        g.RL().Ru().set(ac.a.yJa, Long.valueOf(l));
                        j = 1;
                        break;
                        g.RM();
                        g.RL().Ru().set(ac.a.yIX, "");
                      }
                    }
                    if ("entry_wxpay_pay_wallet".equals(paramString))
                    {
                      g.RM();
                      g.RL().Ru().set(ac.a.yJb, Boolean.TRUE);
                      g.RM();
                      g.RL().Ru().set(ac.a.yJc, Long.valueOf(l));
                    }
                    else
                    {
                      if (paramString.startsWith("bind_serial_"))
                      {
                        paramString = paramString.substring(12);
                        g.RM();
                        str2 = (String)g.RL().Ru().get(ac.a.yHC, "");
                        ab.d("MicroMsg.MallNewsManager", "bind serial: %s", new Object[] { paramString });
                        if (!bo.isNullOrNil(str2)) {
                          paramString = str2 + "," + paramString;
                        }
                        for (;;)
                        {
                          g.RM();
                          g.RL().Ru().set(ac.a.yHC, paramString);
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
                        ab.printErrStackTrace("MicroMsg.MallNewsManager", paramString, "put redDotConfig json failed: %s", new Object[] { paramString.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            if (i == 0) {
              com.tencent.mm.x.c.PJ().c(ac.a.yIY, ac.a.yJf);
            }
            if (j == 0) {
              com.tencent.mm.x.c.PJ().c(ac.a.yIY, ac.a.yJe);
            }
            ab.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { ((JSONObject)localObject1).toString() });
            if (((JSONObject)localObject1).length() > 0)
            {
              g.RM();
              g.RL().Ru().set(ac.a.yJd, ((JSONObject)localObject1).toString());
              g.RM();
              g.RL().Ru().set(ac.a.yJb, Boolean.TRUE);
            }
          }
        }
      }
    }
    AppMethodBeat.o(47027);
  }
  
  public static MallNews afs(String paramString)
  {
    AppMethodBeat.i(47033);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47033);
      return null;
    }
    Map localMap = br.F(paramString, "sysmsg");
    if (localMap == null)
    {
      AppMethodBeat.o(47033);
      return null;
    }
    MallNews localMallNews;
    for (;;)
    {
      try
      {
        localMallNews = new MallNews((String)localMap.get(".sysmsg.mallactivity.functionid"));
        localMallNews.sWB = ((String)localMap.get(".sysmsg.mallactivity.activityid"));
        localMallNews.crs = ((String)localMap.get(".sysmsg.mallactivity.ticket"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivity.type"));
        localMallNews.showType = bo.getInt((String)localMap.get(".sysmsg.mallactivity.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivity.showflag"))
        {
          localMallNews.umn = ((String)localMap.get(".sysmsg.mallactivity.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivity.newsTipFlag"))
          {
            localMallNews.umo = ((String)localMap.get(".sysmsg.mallactivity.newsTipFlag"));
            localMallNews.umv = paramString;
            boolean bool = bo.isNullOrNil(localMallNews.ftd);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(47033);
            return null;
          }
        }
        else
        {
          localMallNews.umn = "0";
          continue;
        }
        localMallNews.umo = "0";
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.MallNewsManager", "cmdid error");
        AppMethodBeat.o(47033);
        return null;
      }
    }
    AppMethodBeat.o(47033);
    return localMallNews;
  }
  
  public static c cUX()
  {
    AppMethodBeat.i(47021);
    if (umx == null) {
      umx = new c();
    }
    c localc = umx;
    AppMethodBeat.o(47021);
    return localc;
  }
  
  public static void cUZ()
  {
    AppMethodBeat.i(47028);
    g.RM();
    g.RL().Ru().set(ac.a.yHh, "");
    g.RM();
    g.RL().Ru().set(ac.a.yHi, Integer.valueOf(-1));
    AppMethodBeat.o(47028);
  }
  
  public static void cVa()
  {
    AppMethodBeat.i(47029);
    ab.d("MicroMsg.MallNewsManager", "clearMallNew ");
    com.tencent.mm.x.c.PJ().ce(262156, 266248);
    AppMethodBeat.o(47029);
  }
  
  public static void e(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(47026);
    try
    {
      if (bo.isNullOrNil(paramMallFunction.umh.sWB)) {
        break label181;
      }
      g.RM();
      localObject = bo.P(((String)g.RL().Ru().get(ac.a.yFb, "")).split(","));
      while (((List)localObject).size() > 20) {
        ((List)localObject).remove(0);
      }
      bool = ((List)localObject).contains(paramMallFunction.umh.sWB);
    }
    catch (Exception paramMallFunction)
    {
      ab.printErrStackTrace("MicroMsg.MallNewsManager", paramMallFunction, "error in markedFunction", new Object[0]);
      AppMethodBeat.o(47026);
      return;
    }
    boolean bool;
    if (bool)
    {
      AppMethodBeat.o(47026);
      return;
    }
    ((List)localObject).add(paramMallFunction.umh.sWB);
    Object localObject = bo.d((List)localObject, ",");
    ab.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[] { paramMallFunction.umh.sWB, localObject });
    g.RM();
    g.RL().Ru().set(ac.a.yFb, localObject);
    label181:
    AppMethodBeat.o(47026);
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(47023);
    this.umy.clear();
    g.RM();
    Object localObject = (String)g.RL().Ru().get(270339, "");
    ab.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bo.P(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = afs((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.umy.put(localMallNews.ftd, localMallNews);
      }
    }
    AppMethodBeat.o(47023);
  }
  
  public final void X(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(47034);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.umy.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((Set)localObject).remove(((MallFunction)paramArrayList.next()).pUM);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.umy.remove(localObject);
      }
      cbo();
    }
    AppMethodBeat.o(47034);
  }
  
  public final String afq(String paramString)
  {
    AppMethodBeat.i(47031);
    paramString = (MallNews)this.umy.get(paramString);
    if ((paramString != null) && (!bo.isNullOrNil(paramString.crs)))
    {
      paramString = paramString.crs;
      AppMethodBeat.o(47031);
      return paramString;
    }
    AppMethodBeat.o(47031);
    return null;
  }
  
  public final MallNews afr(String paramString)
  {
    AppMethodBeat.i(47032);
    ab.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bo.isNullOrNil(paramString)) && (this.umy.containsKey(paramString)))
    {
      paramString = (MallNews)this.umy.get(paramString);
      if ("0".equals(paramString.umn))
      {
        paramString.umn = "1";
        cbo();
      }
      AppMethodBeat.o(47032);
      return paramString;
    }
    AppMethodBeat.o(47032);
    return null;
  }
  
  public final List<String> cUY()
  {
    AppMethodBeat.i(47024);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.umy.values().iterator();
    while (localIterator.hasNext())
    {
      MallNews localMallNews = (MallNews)localIterator.next();
      if (!bo.isNullOrNil(localMallNews.crs)) {
        localArrayList.add(localMallNews.crs);
      }
    }
    ab.d("MicroMsg.MallNewsManager", "tickets.size : " + localArrayList.size());
    AppMethodBeat.o(47024);
    return localArrayList;
  }
  
  public final boolean cbo()
  {
    AppMethodBeat.i(47030);
    ab.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.umy.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.umy.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.umy.get(localObject);
        localStringBuffer.append(((MallNews)localObject).umv.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + ((MallNews)localObject).umn + "</showflag><newsTipFlag>" + ((MallNews)localObject).umo + "</newsTipFlag></mallactivity></sysmsg>;");
      }
    }
    ab.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.RM();
    g.RL().Ru().set(270339, localStringBuffer.toString());
    AppMethodBeat.o(47030);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.c
 * JD-Core Version:    0.7.0.1
 */