package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private static c Dtj = null;
  public Map<String, MallNews> Dtk;
  
  private c()
  {
    AppMethodBeat.i(70554);
    this.Dtk = new HashMap();
    Zm();
    AppMethodBeat.o(70554);
  }
  
  public static boolean a(MallNews paramMallNews)
  {
    AppMethodBeat.i(70557);
    g.ajS();
    String str = (String)g.ajR().ajA().get(am.a.ISp, "");
    ArrayList localArrayList = bu.U(str.split(","));
    ae.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[] { str });
    if (paramMallNews == null)
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (bu.isNullOrNil(paramMallNews.ByB))
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (localArrayList.contains(paramMallNews.ByB))
    {
      AppMethodBeat.o(70557);
      return true;
    }
    AppMethodBeat.o(70557);
    return false;
  }
  
  public static void aFU(String paramString)
  {
    AppMethodBeat.i(70559);
    if (!bu.isNullOrNil(paramString))
    {
      Map localMap = bx.M(paramString, "sysmsg");
      if (localMap != null)
      {
        int i = bu.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        int j;
        if (i == 31)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = bu.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = bu.getInt((String)localMap.get(".sysmsg.paymsg.BalanceRedDot"), -1);
          int k = bu.getInt((String)localMap.get(".sysmsg.paymsg.LQTRedDot"), -1);
          ae.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k) });
          g.ajS();
          g.ajR().ajA().set(am.a.IUy, paramString);
          g.ajS();
          g.ajR().ajA().set(am.a.IUz, Integer.valueOf(i));
          g.ajS();
          g.ajR().ajA().set(am.a.IUA, Integer.valueOf(j));
          g.ajS();
          g.ajR().ajA().set(am.a.IUB, Integer.valueOf(k));
          eKE();
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
          ae.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject1.toString() });
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
                l = bu.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!bu.isNullOrNil(str1))
                {
                  ae.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { str1, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(str1))
                  {
                    g.ajS();
                    g.ajR().ajA().set(am.a.IWA, Boolean.TRUE);
                    if (l > 0L)
                    {
                      g.ajS();
                      g.ajR().ajA().set(am.a.IWB, Long.valueOf(l));
                    }
                  }
                  else if ("entry_wxpay_wallet".equals(str1))
                  {
                    g.ajS();
                    g.ajR().ajA().set(am.a.IWC, Boolean.TRUE);
                    if (!bu.isNullOrNil(str2))
                    {
                      g.ajS();
                      g.ajR().ajA().set(am.a.IWz, str2);
                    }
                    for (;;)
                    {
                      if (l <= 0L) {
                        break label620;
                      }
                      g.ajS();
                      g.ajR().ajA().set(am.a.IWD, Long.valueOf(l));
                      break;
                      g.ajS();
                      g.ajR().ajA().set(am.a.IWz, "");
                    }
                  }
                  else
                  {
                    label620:
                    if ("entry_wxpay_paycenter".equals(str1))
                    {
                      g.ajS();
                      g.ajR().ajA().set(am.a.IWt, Boolean.TRUE);
                      if (l > 0L)
                      {
                        g.ajS();
                        g.ajR().ajA().set(am.a.IWu, Long.valueOf(l));
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
                        ae.printErrStackTrace("MicroMsg.MallNewsManager", localException, "put redDotConfig json failed: %s", new Object[] { localException.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            ae.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { paramString.toString() });
            if (paramString.length() > 0)
            {
              g.ajS();
              g.ajR().ajA().set(am.a.IWs, paramString.toString());
              g.ajS();
              g.ajR().ajA().set(am.a.IWt, Boolean.TRUE);
            }
          }
          AppMethodBeat.o(70559);
          return;
        }
        if (i == 36)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = bu.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = bu.getInt((String)localMap.get(".sysmsg.paymsg.LQBRedDot"), -1);
          ae.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
          g.ajS();
          g.ajR().ajA().set(am.a.IUy, paramString);
          g.ajS();
          g.ajR().ajA().set(am.a.IUz, Integer.valueOf(i));
          g.ajS();
          g.ajR().ajA().set(am.a.IUC, Integer.valueOf(j));
          eKE();
          AppMethodBeat.o(70559);
          return;
        }
        if (i == 38)
        {
          Object localObject2 = localMap.keySet();
          ae.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject2.toString() });
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
                l = bu.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!bu.isNullOrNil(paramString))
                {
                  ae.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { paramString, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(paramString))
                  {
                    com.tencent.mm.y.c.ahI().b(am.a.IWG, true);
                    g.ajS();
                    g.ajR().ajA().set(am.a.IWH, Long.valueOf(l));
                    i = 1;
                  }
                  else
                  {
                    if ("entry_wxpay_pay".equals(paramString))
                    {
                      com.tencent.mm.y.c.ahI().b(am.a.IWG, true);
                      if (!bu.isNullOrNil(str2))
                      {
                        g.ajS();
                        g.ajR().ajA().set(am.a.IWF, str2);
                      }
                      for (;;)
                      {
                        g.ajS();
                        g.ajR().ajA().set(am.a.IWI, Long.valueOf(l));
                        j = 1;
                        break;
                        g.ajS();
                        g.ajR().ajA().set(am.a.IWF, "");
                      }
                    }
                    if ("entry_wxpay_pay_wallet".equals(paramString))
                    {
                      g.ajS();
                      g.ajR().ajA().set(am.a.IWJ, Boolean.TRUE);
                      g.ajS();
                      g.ajR().ajA().set(am.a.IWK, Long.valueOf(l));
                    }
                    else
                    {
                      if (paramString.startsWith("bind_serial_"))
                      {
                        paramString = paramString.substring(12);
                        g.ajS();
                        str2 = (String)g.ajR().ajA().get(am.a.IVf, "");
                        ae.d("MicroMsg.MallNewsManager", "bind serial: %s", new Object[] { paramString });
                        if (!bu.isNullOrNil(str2)) {
                          paramString = str2 + "," + paramString;
                        }
                        for (;;)
                        {
                          g.ajS();
                          g.ajR().ajA().set(am.a.IVf, paramString);
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
                        ae.printErrStackTrace("MicroMsg.MallNewsManager", paramString, "put redDotConfig json failed: %s", new Object[] { paramString.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            if (i == 0) {
              com.tencent.mm.y.c.ahI().c(am.a.IWG, am.a.IWN);
            }
            if (j == 0) {
              com.tencent.mm.y.c.ahI().c(am.a.IWG, am.a.IWM);
            }
            ae.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { ((JSONObject)localObject1).toString() });
            if (((JSONObject)localObject1).length() > 0)
            {
              g.ajS();
              g.ajR().ajA().set(am.a.IWL, ((JSONObject)localObject1).toString());
              g.ajS();
              g.ajR().ajA().set(am.a.IWJ, Boolean.TRUE);
            }
          }
        }
      }
    }
    AppMethodBeat.o(70559);
  }
  
  public static MallNews aFX(String paramString)
  {
    AppMethodBeat.i(70565);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70565);
      return null;
    }
    Map localMap = bx.M(paramString, "sysmsg");
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
        localMallNews.ByB = ((String)localMap.get(".sysmsg.mallactivity.activityid"));
        localMallNews.dqk = ((String)localMap.get(".sysmsg.mallactivity.ticket"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivity.type"));
        localMallNews.dmr = bu.getInt((String)localMap.get(".sysmsg.mallactivity.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivity.showflag"))
        {
          localMallNews.DsZ = ((String)localMap.get(".sysmsg.mallactivity.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivity.newsTipFlag"))
          {
            localMallNews.Dta = ((String)localMap.get(".sysmsg.mallactivity.newsTipFlag"));
            localMallNews.Dth = paramString;
            boolean bool = bu.isNullOrNil(localMallNews.hQM);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70565);
            return null;
          }
        }
        else
        {
          localMallNews.DsZ = "0";
          continue;
        }
        localMallNews.Dta = "0";
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.MallNewsManager", "cmdid error");
        AppMethodBeat.o(70565);
        return null;
      }
    }
    AppMethodBeat.o(70565);
    return localMallNews;
  }
  
  public static c eKB()
  {
    AppMethodBeat.i(70553);
    if (Dtj == null) {
      Dtj = new c();
    }
    c localc = Dtj;
    AppMethodBeat.o(70553);
    return localc;
  }
  
  public static void eKD()
  {
    AppMethodBeat.i(70560);
    g.ajS();
    g.ajR().ajA().set(am.a.IUy, "");
    g.ajS();
    g.ajR().ajA().set(am.a.IUz, Integer.valueOf(-1));
    AppMethodBeat.o(70560);
  }
  
  public static void eKE()
  {
    AppMethodBeat.i(70561);
    ae.d("MicroMsg.MallNewsManager", "clearMallNew ");
    com.tencent.mm.y.c.ahI().cK(262156, 266248);
    AppMethodBeat.o(70561);
  }
  
  public static void i(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(70558);
    try
    {
      if (bu.isNullOrNil(paramMallFunction.DsT.ByB)) {
        break label181;
      }
      g.ajS();
      localObject = bu.U(((String)g.ajR().ajA().get(am.a.ISp, "")).split(","));
      while (((List)localObject).size() > 20) {
        ((List)localObject).remove(0);
      }
      bool = ((List)localObject).contains(paramMallFunction.DsT.ByB);
    }
    catch (Exception paramMallFunction)
    {
      ae.printErrStackTrace("MicroMsg.MallNewsManager", paramMallFunction, "error in markedFunction", new Object[0]);
      AppMethodBeat.o(70558);
      return;
    }
    boolean bool;
    if (bool)
    {
      AppMethodBeat.o(70558);
      return;
    }
    ((List)localObject).add(paramMallFunction.DsT.ByB);
    Object localObject = bu.m((List)localObject, ",");
    ae.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[] { paramMallFunction.DsT.ByB, localObject });
    g.ajS();
    g.ajR().ajA().set(am.a.ISp, localObject);
    label181:
    AppMethodBeat.o(70558);
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(70555);
    this.Dtk.clear();
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(270339, "");
    ae.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bu.U(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = aFX((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.Dtk.put(localMallNews.hQM, localMallNews);
      }
    }
    AppMethodBeat.o(70555);
  }
  
  public final void aE(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(70566);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.Dtk.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((Set)localObject).remove(((MallFunction)paramArrayList.next()).jFZ);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.Dtk.remove(localObject);
      }
      dDe();
    }
    AppMethodBeat.o(70566);
  }
  
  public final void aF(ArrayList<aum> paramArrayList)
  {
    AppMethodBeat.i(190207);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.Dtk.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        aum localaum = (aum)paramArrayList.next();
        ((Set)localObject).remove(localaum.GLn.IhV);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.Dtk.remove(localObject);
      }
      dDe();
    }
    AppMethodBeat.o(190207);
  }
  
  public final String aFV(String paramString)
  {
    AppMethodBeat.i(70563);
    paramString = (MallNews)this.Dtk.get(paramString);
    if ((paramString != null) && (!bu.isNullOrNil(paramString.dqk)))
    {
      paramString = paramString.dqk;
      AppMethodBeat.o(70563);
      return paramString;
    }
    AppMethodBeat.o(70563);
    return null;
  }
  
  public final MallNews aFW(String paramString)
  {
    AppMethodBeat.i(70564);
    ae.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bu.isNullOrNil(paramString)) && (this.Dtk.containsKey(paramString)))
    {
      paramString = (MallNews)this.Dtk.get(paramString);
      if ("0".equals(paramString.DsZ))
      {
        paramString.DsZ = "1";
        dDe();
      }
      AppMethodBeat.o(70564);
      return paramString;
    }
    AppMethodBeat.o(70564);
    return null;
  }
  
  public final boolean dDe()
  {
    AppMethodBeat.i(70562);
    ae.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.Dtk.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.Dtk.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.Dtk.get(localObject);
        localStringBuffer.append(((MallNews)localObject).Dth.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + ((MallNews)localObject).DsZ + "</showflag><newsTipFlag>" + ((MallNews)localObject).Dta + "</newsTipFlag></mallactivity></sysmsg>;");
      }
    }
    ae.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.ajS();
    g.ajR().ajA().set(270339, localStringBuffer.toString());
    AppMethodBeat.o(70562);
    return true;
  }
  
  public final List<String> eKC()
  {
    AppMethodBeat.i(70556);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Dtk.values().iterator();
    while (localIterator.hasNext())
    {
      MallNews localMallNews = (MallNews)localIterator.next();
      if (!bu.isNullOrNil(localMallNews.dqk)) {
        localArrayList.add(localMallNews.dqk);
      }
    }
    ae.d("MicroMsg.MallNewsManager", "tickets.size : " + localArrayList.size());
    AppMethodBeat.o(70556);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.c
 * JD-Core Version:    0.7.0.1
 */