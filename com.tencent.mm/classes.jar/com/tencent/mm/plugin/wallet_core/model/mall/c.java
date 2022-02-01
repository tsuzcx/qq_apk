package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.exc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  private static c Icu = null;
  public Map<String, MallNews> Icv;
  
  private c()
  {
    AppMethodBeat.i(70554);
    this.Icv = new HashMap();
    amZ();
    AppMethodBeat.o(70554);
  }
  
  public static boolean a(MallNews paramMallNews)
  {
    AppMethodBeat.i(70557);
    g.aAi();
    String str = (String)g.aAh().azQ().get(ar.a.Oar, "");
    ArrayList localArrayList = Util.stringsToList(str.split(","));
    Log.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[] { str });
    if (paramMallNews == null)
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (Util.isNullOrNil(paramMallNews.FJm))
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (localArrayList.contains(paramMallNews.FJm))
    {
      AppMethodBeat.o(70557);
      return true;
    }
    AppMethodBeat.o(70557);
    return false;
  }
  
  public static void aVt(String paramString)
  {
    AppMethodBeat.i(70559);
    if (!Util.isNullOrNil(paramString))
    {
      Map localMap = XmlParser.parseXml(paramString, "sysmsg", null);
      if (localMap != null)
      {
        int i = Util.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        int j;
        if (i == 31)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = Util.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = Util.getInt((String)localMap.get(".sysmsg.paymsg.BalanceRedDot"), -1);
          int k = Util.getInt((String)localMap.get(".sysmsg.paymsg.LQTRedDot"), -1);
          Log.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k) });
          g.aAi();
          g.aAh().azQ().set(ar.a.OcM, paramString);
          g.aAi();
          g.aAh().azQ().set(ar.a.OcN, Integer.valueOf(i));
          g.aAi();
          g.aAh().azQ().set(ar.a.OcO, Integer.valueOf(j));
          g.aAi();
          g.aAh().azQ().set(ar.a.OcP, Integer.valueOf(k));
          fSj();
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
          Log.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject1.toString() });
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
                l = Util.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!Util.isNullOrNil(str1))
                {
                  Log.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { str1, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(str1))
                  {
                    g.aAi();
                    g.aAh().azQ().set(ar.a.OeS, Boolean.TRUE);
                    if (l > 0L)
                    {
                      g.aAi();
                      g.aAh().azQ().set(ar.a.OeT, Long.valueOf(l));
                    }
                  }
                  else if ("entry_wxpay_wallet".equals(str1))
                  {
                    g.aAi();
                    g.aAh().azQ().set(ar.a.OeU, Boolean.TRUE);
                    if (!Util.isNullOrNil(str2))
                    {
                      g.aAi();
                      g.aAh().azQ().set(ar.a.OeR, str2);
                    }
                    for (;;)
                    {
                      if (l <= 0L) {
                        break label621;
                      }
                      g.aAi();
                      g.aAh().azQ().set(ar.a.OeV, Long.valueOf(l));
                      break;
                      g.aAi();
                      g.aAh().azQ().set(ar.a.OeR, "");
                    }
                  }
                  else
                  {
                    label621:
                    if ("entry_wxpay_paycenter".equals(str1))
                    {
                      g.aAi();
                      g.aAh().azQ().set(ar.a.OeL, Boolean.TRUE);
                      if (l > 0L)
                      {
                        g.aAi();
                        g.aAh().azQ().set(ar.a.OeM, Long.valueOf(l));
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
                        Log.printErrStackTrace("MicroMsg.MallNewsManager", localException, "put redDotConfig json failed: %s", new Object[] { localException.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            Log.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { paramString.toString() });
            if (paramString.length() > 0)
            {
              g.aAi();
              g.aAh().azQ().set(ar.a.OeK, paramString.toString());
              g.aAi();
              g.aAh().azQ().set(ar.a.OeL, Boolean.TRUE);
            }
          }
          AppMethodBeat.o(70559);
          return;
        }
        if (i == 36)
        {
          paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
          i = Util.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
          j = Util.getInt((String)localMap.get(".sysmsg.paymsg.LQBRedDot"), -1);
          Log.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
          g.aAi();
          g.aAh().azQ().set(ar.a.OcM, paramString);
          g.aAi();
          g.aAh().azQ().set(ar.a.OcN, Integer.valueOf(i));
          g.aAi();
          g.aAh().azQ().set(ar.a.OcQ, Integer.valueOf(j));
          fSj();
          AppMethodBeat.o(70559);
          return;
        }
        if (i == 38)
        {
          Object localObject2 = localMap.keySet();
          Log.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject2.toString() });
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
                l = Util.getLong((String)localMap.get(str3), 0L) * 1000L;
                if (!Util.isNullOrNil(paramString))
                {
                  Log.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { paramString, str2, Long.valueOf(l) });
                  if ("mainentry_me".equals(paramString))
                  {
                    com.tencent.mm.y.c.axV().b(ar.a.OeY, true);
                    g.aAi();
                    g.aAh().azQ().set(ar.a.OeZ, Long.valueOf(l));
                    i = 1;
                  }
                  else
                  {
                    if ("entry_wxpay_pay".equals(paramString))
                    {
                      com.tencent.mm.y.c.axV().b(ar.a.OeY, true);
                      if (!Util.isNullOrNil(str2))
                      {
                        g.aAi();
                        g.aAh().azQ().set(ar.a.OeX, str2);
                      }
                      for (;;)
                      {
                        g.aAi();
                        g.aAh().azQ().set(ar.a.Ofa, Long.valueOf(l));
                        j = 1;
                        break;
                        g.aAi();
                        g.aAh().azQ().set(ar.a.OeX, "");
                      }
                    }
                    if ("entry_wxpay_pay_wallet".equals(paramString))
                    {
                      g.aAi();
                      g.aAh().azQ().set(ar.a.Ofb, Boolean.TRUE);
                      g.aAi();
                      g.aAh().azQ().set(ar.a.Ofc, Long.valueOf(l));
                    }
                    else
                    {
                      if (paramString.startsWith("bind_serial_"))
                      {
                        paramString = paramString.substring(12);
                        g.aAi();
                        str2 = (String)g.aAh().azQ().get(ar.a.Odx, "");
                        Log.d("MicroMsg.MallNewsManager", "bind serial: %s", new Object[] { paramString });
                        if (!Util.isNullOrNil(str2)) {
                          paramString = str2 + "," + paramString;
                        }
                        for (;;)
                        {
                          g.aAi();
                          g.aAh().azQ().set(ar.a.Odx, paramString);
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
                        Log.printErrStackTrace("MicroMsg.MallNewsManager", paramString, "put redDotConfig json failed: %s", new Object[] { paramString.getMessage() });
                      }
                    }
                  }
                }
              }
            }
            if (i == 0) {
              com.tencent.mm.y.c.axV().c(ar.a.OeY, ar.a.Off);
            }
            if (j == 0) {
              com.tencent.mm.y.c.axV().c(ar.a.OeY, ar.a.Ofe);
            }
            Log.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { ((JSONObject)localObject1).toString() });
            if (((JSONObject)localObject1).length() > 0)
            {
              g.aAi();
              g.aAh().azQ().set(ar.a.Ofd, ((JSONObject)localObject1).toString());
              g.aAi();
              g.aAh().azQ().set(ar.a.Ofb, Boolean.TRUE);
            }
          }
        }
      }
    }
    AppMethodBeat.o(70559);
  }
  
  public static MallNews aVw(String paramString)
  {
    AppMethodBeat.i(70565);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70565);
      return null;
    }
    Map localMap = XmlParser.parseXml(paramString, "sysmsg", null);
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
        localMallNews.FJm = ((String)localMap.get(".sysmsg.mallactivity.activityid"));
        localMallNews.dHx = ((String)localMap.get(".sysmsg.mallactivity.ticket"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivity.type"));
        localMallNews.dDG = Util.getInt((String)localMap.get(".sysmsg.mallactivity.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivity.showflag"))
        {
          localMallNews.Icl = ((String)localMap.get(".sysmsg.mallactivity.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivity.newsTipFlag"))
          {
            localMallNews.Icm = ((String)localMap.get(".sysmsg.mallactivity.newsTipFlag"));
            localMallNews.Ics = paramString;
            boolean bool = Util.isNullOrNil(localMallNews.iLU);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70565);
            return null;
          }
        }
        else
        {
          localMallNews.Icl = "0";
          continue;
        }
        localMallNews.Icm = "0";
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.MallNewsManager", "cmdid error");
        AppMethodBeat.o(70565);
        return null;
      }
    }
    AppMethodBeat.o(70565);
    return localMallNews;
  }
  
  public static c fSg()
  {
    AppMethodBeat.i(70553);
    if (Icu == null) {
      Icu = new c();
    }
    c localc = Icu;
    AppMethodBeat.o(70553);
    return localc;
  }
  
  public static void fSi()
  {
    AppMethodBeat.i(70560);
    g.aAi();
    g.aAh().azQ().set(ar.a.OcM, "");
    g.aAi();
    g.aAh().azQ().set(ar.a.OcN, Integer.valueOf(-1));
    AppMethodBeat.o(70560);
  }
  
  public static void fSj()
  {
    AppMethodBeat.i(70561);
    Log.d("MicroMsg.MallNewsManager", "clearMallNew ");
    com.tencent.mm.y.c.axV().cQ(262156, 266248);
    AppMethodBeat.o(70561);
  }
  
  public static void i(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(70558);
    try
    {
      if (Util.isNullOrNil(paramMallFunction.Icf.FJm)) {
        break label181;
      }
      g.aAi();
      localObject = Util.stringsToList(((String)g.aAh().azQ().get(ar.a.Oar, "")).split(","));
      while (((List)localObject).size() > 20) {
        ((List)localObject).remove(0);
      }
      bool = ((List)localObject).contains(paramMallFunction.Icf.FJm);
    }
    catch (Exception paramMallFunction)
    {
      Log.printErrStackTrace("MicroMsg.MallNewsManager", paramMallFunction, "error in markedFunction", new Object[0]);
      AppMethodBeat.o(70558);
      return;
    }
    boolean bool;
    if (bool)
    {
      AppMethodBeat.o(70558);
      return;
    }
    ((List)localObject).add(paramMallFunction.Icf.FJm);
    Object localObject = Util.listToString((List)localObject, ",");
    Log.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[] { paramMallFunction.Icf.FJm, localObject });
    g.aAi();
    g.aAh().azQ().set(ar.a.Oar, localObject);
    label181:
    AppMethodBeat.o(70558);
  }
  
  public final String aVu(String paramString)
  {
    AppMethodBeat.i(70563);
    paramString = (MallNews)this.Icv.get(paramString);
    if ((paramString != null) && (!Util.isNullOrNil(paramString.dHx)))
    {
      paramString = paramString.dHx;
      AppMethodBeat.o(70563);
      return paramString;
    }
    AppMethodBeat.o(70563);
    return null;
  }
  
  public final MallNews aVv(String paramString)
  {
    AppMethodBeat.i(70564);
    Log.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!Util.isNullOrNil(paramString)) && (this.Icv.containsKey(paramString)))
    {
      paramString = (MallNews)this.Icv.get(paramString);
      if ("0".equals(paramString.Icl))
      {
        paramString.Icl = "1";
        eDw();
      }
      AppMethodBeat.o(70564);
      return paramString;
    }
    AppMethodBeat.o(70564);
    return null;
  }
  
  public final void aW(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(70566);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.Icv.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((Set)localObject).remove(((MallFunction)paramArrayList.next()).kHR);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.Icv.remove(localObject);
      }
      eDw();
    }
    AppMethodBeat.o(70566);
  }
  
  public final void aX(ArrayList<bfv> paramArrayList)
  {
    AppMethodBeat.i(214214);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.Icv.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        bfv localbfv = (bfv)paramArrayList.next();
        ((Set)localObject).remove(localbfv.LPr.Nuz);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.Icv.remove(localObject);
      }
      eDw();
    }
    AppMethodBeat.o(214214);
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(70555);
    this.Icv.clear();
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(270339, "");
    Log.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = Util.stringsToList(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = aVw((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.Icv.put(localMallNews.iLU, localMallNews);
      }
    }
    AppMethodBeat.o(70555);
  }
  
  public final boolean eDw()
  {
    AppMethodBeat.i(70562);
    Log.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.Icv.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.Icv.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.Icv.get(localObject);
        localStringBuffer.append(((MallNews)localObject).Ics.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + ((MallNews)localObject).Icl + "</showflag><newsTipFlag>" + ((MallNews)localObject).Icm + "</newsTipFlag></mallactivity></sysmsg>;");
      }
    }
    Log.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.aAi();
    g.aAh().azQ().set(270339, localStringBuffer.toString());
    AppMethodBeat.o(70562);
    return true;
  }
  
  public final List<String> fSh()
  {
    AppMethodBeat.i(70556);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Icv.values().iterator();
    while (localIterator.hasNext())
    {
      MallNews localMallNews = (MallNews)localIterator.next();
      if (!Util.isNullOrNil(localMallNews.dHx)) {
        localArrayList.add(localMallNews.dHx);
      }
    }
    Log.d("MicroMsg.MallNewsManager", "tickets.size : " + localArrayList.size());
    AppMethodBeat.o(70556);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.c
 * JD-Core Version:    0.7.0.1
 */