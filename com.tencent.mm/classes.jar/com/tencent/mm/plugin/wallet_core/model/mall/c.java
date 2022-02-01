package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.geb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
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
  private static c VKX = null;
  public Map<String, MallNews> VKY;
  
  private c()
  {
    AppMethodBeat.i(70554);
    this.VKY = new HashMap();
    aNi();
    AppMethodBeat.o(70554);
  }
  
  public static boolean a(MallNews paramMallNews)
  {
    AppMethodBeat.i(70557);
    h.baF();
    String str = (String)h.baE().ban().get(at.a.acPP, "");
    ArrayList localArrayList = Util.stringsToList(str.split(","));
    Log.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[] { str });
    if (paramMallNews == null)
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (Util.isNullOrNil(paramMallNews.rBJ))
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (localArrayList.contains(paramMallNews.rBJ))
    {
      AppMethodBeat.o(70557);
      return true;
    }
    AppMethodBeat.o(70557);
    return false;
  }
  
  public static void bgM(String paramString)
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
          h.baF();
          h.baE().ban().set(at.a.acSv, paramString);
          h.baF();
          h.baE().ban().set(at.a.acSw, Integer.valueOf(i));
          h.baF();
          h.baE().ban().set(at.a.acSx, Integer.valueOf(j));
          h.baF();
          h.baE().ban().set(at.a.acSy, Integer.valueOf(k));
          ikg();
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
                    h.baF();
                    h.baE().ban().set(at.a.acUI, Boolean.TRUE);
                    if (l > 0L)
                    {
                      h.baF();
                      h.baE().ban().set(at.a.acUJ, Long.valueOf(l));
                    }
                  }
                  else if ("entry_wxpay_wallet".equals(str1))
                  {
                    h.baF();
                    h.baE().ban().set(at.a.acUL, Boolean.TRUE);
                    if (!Util.isNullOrNil(str2))
                    {
                      h.baF();
                      h.baE().ban().set(at.a.acUH, str2);
                    }
                    for (;;)
                    {
                      if (l <= 0L) {
                        break label621;
                      }
                      h.baF();
                      h.baE().ban().set(at.a.acUM, Long.valueOf(l));
                      break;
                      h.baF();
                      h.baE().ban().set(at.a.acUH, "");
                    }
                  }
                  else
                  {
                    label621:
                    if ("entry_wxpay_paycenter".equals(str1))
                    {
                      h.baF();
                      h.baE().ban().set(at.a.acUB, Boolean.TRUE);
                      if (l > 0L)
                      {
                        h.baF();
                        h.baE().ban().set(at.a.acUC, Long.valueOf(l));
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
              h.baF();
              h.baE().ban().set(at.a.acUA, paramString.toString());
              h.baF();
              h.baE().ban().set(at.a.acUB, Boolean.TRUE);
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
          h.baF();
          h.baE().ban().set(at.a.acSv, paramString);
          h.baF();
          h.baE().ban().set(at.a.acSw, Integer.valueOf(i));
          h.baF();
          h.baE().ban().set(at.a.acSz, Integer.valueOf(j));
          ikg();
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
                    com.tencent.mm.aa.c.aYo().b(at.a.acUP, true);
                    h.baF();
                    h.baE().ban().set(at.a.acUQ, Long.valueOf(l));
                    i = 1;
                  }
                  else
                  {
                    if ("entry_wxpay_pay".equals(paramString))
                    {
                      com.tencent.mm.aa.c.aYo().b(at.a.acUP, true);
                      if (!Util.isNullOrNil(str2))
                      {
                        h.baF();
                        h.baE().ban().set(at.a.acUO, str2);
                      }
                      for (;;)
                      {
                        h.baF();
                        h.baE().ban().set(at.a.acUR, Long.valueOf(l));
                        j = 1;
                        break;
                        h.baF();
                        h.baE().ban().set(at.a.acUO, "");
                      }
                    }
                    if ("entry_wxpay_pay_wallet".equals(paramString))
                    {
                      h.baF();
                      h.baE().ban().set(at.a.acUS, Boolean.TRUE);
                      h.baF();
                      h.baE().ban().set(at.a.acUT, Long.valueOf(l));
                    }
                    else
                    {
                      if (paramString.startsWith("bind_serial_"))
                      {
                        paramString = paramString.substring(12);
                        h.baF();
                        str2 = (String)h.baE().ban().get(at.a.acTm, "");
                        Log.d("MicroMsg.MallNewsManager", "bind serial: %s", new Object[] { paramString });
                        if (!Util.isNullOrNil(str2)) {
                          paramString = str2 + "," + paramString;
                        }
                        for (;;)
                        {
                          h.baF();
                          h.baE().ban().set(at.a.acTm, paramString);
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
              com.tencent.mm.aa.c.aYo().c(at.a.acUP, at.a.acUW);
            }
            if (j == 0) {
              com.tencent.mm.aa.c.aYo().c(at.a.acUP, at.a.acUV);
            }
            Log.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { ((JSONObject)localObject1).toString() });
            if (((JSONObject)localObject1).length() > 0)
            {
              h.baF();
              h.baE().ban().set(at.a.acUU, ((JSONObject)localObject1).toString());
              h.baF();
              h.baE().ban().set(at.a.acUS, Boolean.TRUE);
            }
          }
        }
      }
    }
    AppMethodBeat.o(70559);
  }
  
  public static MallNews bgP(String paramString)
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
        localMallNews.rBJ = ((String)localMap.get(".sysmsg.mallactivity.activityid"));
        localMallNews.hFb = ((String)localMap.get(".sysmsg.mallactivity.ticket"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivity.type"));
        localMallNews.hAN = Util.getInt((String)localMap.get(".sysmsg.mallactivity.showtype"), 0);
        localMallNews.igf = Util.getInt((String)localMap.get(".sysmsg.mallactivity.walletregion"), 0);
        if (localMap.containsKey(".sysmsg.mallactivity.showflag"))
        {
          localMallNews.VKO = ((String)localMap.get(".sysmsg.mallactivity.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivity.newsTipFlag"))
          {
            localMallNews.VKP = ((String)localMap.get(".sysmsg.mallactivity.newsTipFlag"));
            localMallNews.VKV = paramString;
            boolean bool = Util.isNullOrNil(localMallNews.otL);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70565);
            return null;
          }
        }
        else
        {
          localMallNews.VKO = "0";
          continue;
        }
        localMallNews.VKP = "0";
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
  
  public static void i(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(70558);
    try
    {
      if (Util.isNullOrNil(paramMallFunction.VKI.rBJ)) {
        break label181;
      }
      h.baF();
      localObject = Util.stringsToList(((String)h.baE().ban().get(at.a.acPP, "")).split(","));
      while (((List)localObject).size() > 20) {
        ((List)localObject).remove(0);
      }
      bool = ((List)localObject).contains(paramMallFunction.VKI.rBJ);
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
    ((List)localObject).add(paramMallFunction.VKI.rBJ);
    Object localObject = Util.listToString((List)localObject, ",");
    Log.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[] { paramMallFunction.VKI.rBJ, localObject });
    h.baF();
    h.baE().ban().set(at.a.acPP, localObject);
    label181:
    AppMethodBeat.o(70558);
  }
  
  public static c ikd()
  {
    AppMethodBeat.i(70553);
    if (VKX == null) {
      VKX = new c();
    }
    c localc = VKX;
    AppMethodBeat.o(70553);
    return localc;
  }
  
  public static void ikf()
  {
    AppMethodBeat.i(70560);
    h.baF();
    h.baE().ban().set(at.a.acSv, "");
    h.baF();
    h.baE().ban().set(at.a.acSw, Integer.valueOf(-1));
    AppMethodBeat.o(70560);
  }
  
  public static void ikg()
  {
    AppMethodBeat.i(70561);
    Log.d("MicroMsg.MallNewsManager", "clearMallNew ");
    com.tencent.mm.aa.c.aYo().dX(262156, 266248);
    AppMethodBeat.o(70561);
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(70555);
    this.VKY.clear();
    h.baF();
    Object localObject = (String)h.baE().ban().d(270339, "");
    Log.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = Util.stringsToList(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = bgP((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.VKY.put(localMallNews.otL, localMallNews);
      }
    }
    AppMethodBeat.o(70555);
  }
  
  public final void bL(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(70566);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.VKY.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((Set)localObject).remove(((MallFunction)paramArrayList.next()).qBb);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.VKY.remove(localObject);
      }
      gAt();
    }
    AppMethodBeat.o(70566);
  }
  
  public final void bM(ArrayList<caq> paramArrayList)
  {
    AppMethodBeat.i(301218);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.VKY.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        caq localcaq = (caq)paramArrayList.next();
        ((Set)localObject).remove(localcaq.aajz.acbJ);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.VKY.remove(localObject);
      }
      gAt();
    }
    AppMethodBeat.o(301218);
  }
  
  public final String bgN(String paramString)
  {
    AppMethodBeat.i(70563);
    paramString = (MallNews)this.VKY.get(paramString);
    if ((paramString != null) && (!Util.isNullOrNil(paramString.hFb)))
    {
      paramString = paramString.hFb;
      AppMethodBeat.o(70563);
      return paramString;
    }
    AppMethodBeat.o(70563);
    return null;
  }
  
  public final MallNews bgO(String paramString)
  {
    AppMethodBeat.i(70564);
    Log.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!Util.isNullOrNil(paramString)) && (this.VKY.containsKey(paramString)))
    {
      paramString = (MallNews)this.VKY.get(paramString);
      if ("0".equals(paramString.VKO))
      {
        paramString.VKO = "1";
        gAt();
      }
      AppMethodBeat.o(70564);
      return paramString;
    }
    AppMethodBeat.o(70564);
    return null;
  }
  
  public final boolean gAt()
  {
    AppMethodBeat.i(70562);
    Log.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.VKY.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.VKY.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.VKY.get(localObject);
        localStringBuffer.append(((MallNews)localObject).VKV.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + ((MallNews)localObject).VKO + "</showflag><newsTipFlag>" + ((MallNews)localObject).VKP + "</newsTipFlag></mallactivity></sysmsg>;");
      }
    }
    Log.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    h.baF();
    h.baE().ban().B(270339, localStringBuffer.toString());
    AppMethodBeat.o(70562);
    return true;
  }
  
  public final List<String> ike()
  {
    AppMethodBeat.i(70556);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.VKY.values().iterator();
    while (localIterator.hasNext())
    {
      MallNews localMallNews = (MallNews)localIterator.next();
      if (!Util.isNullOrNil(localMallNews.hFb)) {
        localArrayList.add(localMallNews.hFb);
      }
    }
    Log.d("MicroMsg.MallNewsManager", "tickets.size : " + localArrayList.size());
    AppMethodBeat.o(70556);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.c
 * JD-Core Version:    0.7.0.1
 */