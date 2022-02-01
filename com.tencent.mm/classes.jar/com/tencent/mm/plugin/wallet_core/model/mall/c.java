package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private static c DbF = null;
  public Map<String, MallNews> DbG;
  
  private c()
  {
    AppMethodBeat.i(70554);
    this.DbG = new HashMap();
    Zd();
    AppMethodBeat.o(70554);
  }
  
  public static boolean a(MallNews paramMallNews)
  {
    AppMethodBeat.i(70557);
    g.ajD();
    String str = (String)g.ajC().ajl().get(al.a.IxR, "");
    ArrayList localArrayList = bt.U(str.split(","));
    ad.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[] { str });
    if (paramMallNews == null)
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (bt.isNullOrNil(paramMallNews.Bhd))
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (localArrayList.contains(paramMallNews.Bhd))
    {
      AppMethodBeat.o(70557);
      return true;
    }
    AppMethodBeat.o(70557);
    return false;
  }
  
  public static void aEA(String paramString)
  {
    AppMethodBeat.i(70559);
    if (!bt.isNullOrNil(paramString))
    {
      Map localMap = bw.M(paramString, "sysmsg");
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
          g.ajD();
          g.ajC().ajl().set(al.a.IzZ, paramString);
          g.ajD();
          g.ajC().ajl().set(al.a.IAa, Integer.valueOf(i));
          g.ajD();
          g.ajC().ajl().set(al.a.IAb, Integer.valueOf(j));
          g.ajD();
          g.ajC().ajl().set(al.a.IAc, Integer.valueOf(k));
          eGW();
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
                    g.ajD();
                    g.ajC().ajl().set(al.a.ICb, Boolean.TRUE);
                    if (l > 0L)
                    {
                      g.ajD();
                      g.ajC().ajl().set(al.a.ICc, Long.valueOf(l));
                    }
                  }
                  else if ("entry_wxpay_wallet".equals(str1))
                  {
                    g.ajD();
                    g.ajC().ajl().set(al.a.ICd, Boolean.TRUE);
                    if (!bt.isNullOrNil(str2))
                    {
                      g.ajD();
                      g.ajC().ajl().set(al.a.ICa, str2);
                    }
                    for (;;)
                    {
                      if (l <= 0L) {
                        break label620;
                      }
                      g.ajD();
                      g.ajC().ajl().set(al.a.ICe, Long.valueOf(l));
                      break;
                      g.ajD();
                      g.ajC().ajl().set(al.a.ICa, "");
                    }
                  }
                  else
                  {
                    label620:
                    if ("entry_wxpay_paycenter".equals(str1))
                    {
                      g.ajD();
                      g.ajC().ajl().set(al.a.IBU, Boolean.TRUE);
                      if (l > 0L)
                      {
                        g.ajD();
                        g.ajC().ajl().set(al.a.IBV, Long.valueOf(l));
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
              g.ajD();
              g.ajC().ajl().set(al.a.IBT, paramString.toString());
              g.ajD();
              g.ajC().ajl().set(al.a.IBU, Boolean.TRUE);
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
          g.ajD();
          g.ajC().ajl().set(al.a.IzZ, paramString);
          g.ajD();
          g.ajC().ajl().set(al.a.IAa, Integer.valueOf(i));
          g.ajD();
          g.ajC().ajl().set(al.a.IAd, Integer.valueOf(j));
          eGW();
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
                    com.tencent.mm.z.c.aht().b(al.a.ICh, true);
                    g.ajD();
                    g.ajC().ajl().set(al.a.ICi, Long.valueOf(l));
                    i = 1;
                  }
                  else
                  {
                    if ("entry_wxpay_pay".equals(paramString))
                    {
                      com.tencent.mm.z.c.aht().b(al.a.ICh, true);
                      if (!bt.isNullOrNil(str2))
                      {
                        g.ajD();
                        g.ajC().ajl().set(al.a.ICg, str2);
                      }
                      for (;;)
                      {
                        g.ajD();
                        g.ajC().ajl().set(al.a.ICj, Long.valueOf(l));
                        j = 1;
                        break;
                        g.ajD();
                        g.ajC().ajl().set(al.a.ICg, "");
                      }
                    }
                    if ("entry_wxpay_pay_wallet".equals(paramString))
                    {
                      g.ajD();
                      g.ajC().ajl().set(al.a.ICk, Boolean.TRUE);
                      g.ajD();
                      g.ajC().ajl().set(al.a.ICl, Long.valueOf(l));
                    }
                    else
                    {
                      if (paramString.startsWith("bind_serial_"))
                      {
                        paramString = paramString.substring(12);
                        g.ajD();
                        str2 = (String)g.ajC().ajl().get(al.a.IAG, "");
                        ad.d("MicroMsg.MallNewsManager", "bind serial: %s", new Object[] { paramString });
                        if (!bt.isNullOrNil(str2)) {
                          paramString = str2 + "," + paramString;
                        }
                        for (;;)
                        {
                          g.ajD();
                          g.ajC().ajl().set(al.a.IAG, paramString);
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
              com.tencent.mm.z.c.aht().c(al.a.ICh, al.a.ICo);
            }
            if (j == 0) {
              com.tencent.mm.z.c.aht().c(al.a.ICh, al.a.ICn);
            }
            ad.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { ((JSONObject)localObject1).toString() });
            if (((JSONObject)localObject1).length() > 0)
            {
              g.ajD();
              g.ajC().ajl().set(al.a.ICm, ((JSONObject)localObject1).toString());
              g.ajD();
              g.ajC().ajl().set(al.a.ICk, Boolean.TRUE);
            }
          }
        }
      }
    }
    AppMethodBeat.o(70559);
  }
  
  public static MallNews aED(String paramString)
  {
    AppMethodBeat.i(70565);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70565);
      return null;
    }
    Map localMap = bw.M(paramString, "sysmsg");
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
        localMallNews.Bhd = ((String)localMap.get(".sysmsg.mallactivity.activityid"));
        localMallNews.dpf = ((String)localMap.get(".sysmsg.mallactivity.ticket"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivity.type"));
        localMallNews.dlp = bt.getInt((String)localMap.get(".sysmsg.mallactivity.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivity.showflag"))
        {
          localMallNews.Dbv = ((String)localMap.get(".sysmsg.mallactivity.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivity.newsTipFlag"))
          {
            localMallNews.Dbw = ((String)localMap.get(".sysmsg.mallactivity.newsTipFlag"));
            localMallNews.DbD = paramString;
            boolean bool = bt.isNullOrNil(localMallNews.hNT);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70565);
            return null;
          }
        }
        else
        {
          localMallNews.Dbv = "0";
          continue;
        }
        localMallNews.Dbw = "0";
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
  
  public static c eGT()
  {
    AppMethodBeat.i(70553);
    if (DbF == null) {
      DbF = new c();
    }
    c localc = DbF;
    AppMethodBeat.o(70553);
    return localc;
  }
  
  public static void eGV()
  {
    AppMethodBeat.i(70560);
    g.ajD();
    g.ajC().ajl().set(al.a.IzZ, "");
    g.ajD();
    g.ajC().ajl().set(al.a.IAa, Integer.valueOf(-1));
    AppMethodBeat.o(70560);
  }
  
  public static void eGW()
  {
    AppMethodBeat.i(70561);
    ad.d("MicroMsg.MallNewsManager", "clearMallNew ");
    com.tencent.mm.z.c.aht().cK(262156, 266248);
    AppMethodBeat.o(70561);
  }
  
  public static void i(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(70558);
    try
    {
      if (bt.isNullOrNil(paramMallFunction.Dbp.Bhd)) {
        break label181;
      }
      g.ajD();
      localObject = bt.U(((String)g.ajC().ajl().get(al.a.IxR, "")).split(","));
      while (((List)localObject).size() > 20) {
        ((List)localObject).remove(0);
      }
      bool = ((List)localObject).contains(paramMallFunction.Dbp.Bhd);
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
    ((List)localObject).add(paramMallFunction.Dbp.Bhd);
    Object localObject = bt.m((List)localObject, ",");
    ad.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[] { paramMallFunction.Dbp.Bhd, localObject });
    g.ajD();
    g.ajC().ajl().set(al.a.IxR, localObject);
    label181:
    AppMethodBeat.o(70558);
  }
  
  public final void Zd()
  {
    AppMethodBeat.i(70555);
    this.DbG.clear();
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(270339, "");
    ad.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bt.U(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = aED((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.DbG.put(localMallNews.hNT, localMallNews);
      }
    }
    AppMethodBeat.o(70555);
  }
  
  public final void aD(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(70566);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.DbG.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((Set)localObject).remove(((MallFunction)paramArrayList.next()).jDb);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.DbG.remove(localObject);
      }
      dzN();
    }
    AppMethodBeat.o(70566);
  }
  
  public final void aE(ArrayList<atw> paramArrayList)
  {
    AppMethodBeat.i(199327);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.DbG.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        atw localatw = (atw)paramArrayList.next();
        ((Set)localObject).remove(localatw.GrP.HNO);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.DbG.remove(localObject);
      }
      dzN();
    }
    AppMethodBeat.o(199327);
  }
  
  public final String aEB(String paramString)
  {
    AppMethodBeat.i(70563);
    paramString = (MallNews)this.DbG.get(paramString);
    if ((paramString != null) && (!bt.isNullOrNil(paramString.dpf)))
    {
      paramString = paramString.dpf;
      AppMethodBeat.o(70563);
      return paramString;
    }
    AppMethodBeat.o(70563);
    return null;
  }
  
  public final MallNews aEC(String paramString)
  {
    AppMethodBeat.i(70564);
    ad.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!bt.isNullOrNil(paramString)) && (this.DbG.containsKey(paramString)))
    {
      paramString = (MallNews)this.DbG.get(paramString);
      if ("0".equals(paramString.Dbv))
      {
        paramString.Dbv = "1";
        dzN();
      }
      AppMethodBeat.o(70564);
      return paramString;
    }
    AppMethodBeat.o(70564);
    return null;
  }
  
  public final boolean dzN()
  {
    AppMethodBeat.i(70562);
    ad.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.DbG.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.DbG.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.DbG.get(localObject);
        localStringBuffer.append(((MallNews)localObject).DbD.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + ((MallNews)localObject).Dbv + "</showflag><newsTipFlag>" + ((MallNews)localObject).Dbw + "</newsTipFlag></mallactivity></sysmsg>;");
      }
    }
    ad.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.ajD();
    g.ajC().ajl().set(270339, localStringBuffer.toString());
    AppMethodBeat.o(70562);
    return true;
  }
  
  public final List<String> eGU()
  {
    AppMethodBeat.i(70556);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.DbG.values().iterator();
    while (localIterator.hasNext())
    {
      MallNews localMallNews = (MallNews)localIterator.next();
      if (!bt.isNullOrNil(localMallNews.dpf)) {
        localArrayList.add(localMallNews.dpf);
      }
    }
    ad.d("MicroMsg.MallNewsManager", "tickets.size : " + localArrayList.size());
    AppMethodBeat.o(70556);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.c
 * JD-Core Version:    0.7.0.1
 */