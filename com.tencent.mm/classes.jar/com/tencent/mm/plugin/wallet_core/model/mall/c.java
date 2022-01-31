package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
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
  private static c qzN = null;
  public Map<String, MallNews> qzO = new HashMap();
  
  private c()
  {
    xK();
  }
  
  public static void Qv(String paramString)
  {
    Map localMap;
    if (!bk.bl(paramString))
    {
      localMap = bn.s(paramString, "sysmsg");
      if (localMap != null)
      {
        i = bk.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        if (i != 31) {
          break label217;
        }
        paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
        i = bk.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
        j = bk.getInt((String)localMap.get(".sysmsg.paymsg.BalanceRedDot"), -1);
        int k = bk.getInt((String)localMap.get(".sysmsg.paymsg.LQTRedDot"), -1);
        y.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k) });
        g.DQ();
        g.DP().Dz().c(ac.a.uwY, paramString);
        g.DQ();
        g.DP().Dz().c(ac.a.uwZ, Integer.valueOf(i));
        g.DQ();
        g.DP().Dz().c(ac.a.uxa, Integer.valueOf(j));
        g.DQ();
        g.DP().Dz().c(ac.a.uxb, Integer.valueOf(k));
        bWj();
      }
    }
    label217:
    label612:
    do
    {
      do
      {
        do
        {
          return;
          if (i != 34) {
            break;
          }
          localObject = localMap.keySet();
          y.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[] { paramString, localObject.toString() });
        } while (((Set)localObject).size() <= 0);
        paramString = new JSONObject();
        Object localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str3 = (String)((Iterator)localObject).next();
          if (str3.startsWith(".sysmsg.paymsg.reddot.item"))
          {
            String str1 = (String)localMap.get(str3);
            String str2 = str3 + ".$wording";
            str3 = str3 + ".$expire_time";
            str2 = (String)localMap.get(str2);
            long l = bk.getLong((String)localMap.get(str3), 0L) * 1000L;
            if (!bk.bl(str1))
            {
              y.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", new Object[] { str1, str2, Long.valueOf(l) });
              if ("mainentry_me".equals(str1))
              {
                g.DQ();
                g.DP().Dz().c(ac.a.uyI, Boolean.valueOf(true));
                if (l > 0L)
                {
                  g.DQ();
                  g.DP().Dz().c(ac.a.uyJ, Long.valueOf(l));
                }
              }
              else if ("entry_wxpay_wallet".equals(str1))
              {
                g.DQ();
                g.DP().Dz().c(ac.a.uyK, Boolean.valueOf(true));
                if (!bk.bl(str2))
                {
                  g.DQ();
                  g.DP().Dz().c(ac.a.uyH, str2);
                }
                for (;;)
                {
                  if (l <= 0L) {
                    break label612;
                  }
                  g.DQ();
                  g.DP().Dz().c(ac.a.uyL, Long.valueOf(l));
                  break;
                  g.DQ();
                  g.DP().Dz().c(ac.a.uyH, "");
                }
              }
              else if ("entry_wxpay_paycenter".equals(str1))
              {
                g.DQ();
                g.DP().Dz().c(ac.a.uyC, Boolean.valueOf(true));
                if (l > 0L)
                {
                  g.DQ();
                  g.DP().Dz().c(ac.a.uyD, Long.valueOf(l));
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
                  y.printErrStackTrace("MicroMsg.MallNewsManager", localException, "put redDotConfig json failed: %s", new Object[] { localException.getMessage() });
                }
              }
            }
          }
        }
        y.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { paramString.toString() });
      } while (paramString.length() <= 0);
      g.DQ();
      g.DP().Dz().c(ac.a.uyB, paramString.toString());
      g.DQ();
      g.DP().Dz().c(ac.a.uyC, Boolean.valueOf(true));
      return;
    } while (i != 36);
    paramString = (String)localMap.get(".sysmsg.paymsg.WalletRedDotWording");
    int i = bk.getInt((String)localMap.get(".sysmsg.paymsg.WalletRedDot"), -1);
    int j = bk.getInt((String)localMap.get(".sysmsg.paymsg.LQBRedDot"), -1);
    y.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
    g.DQ();
    g.DP().Dz().c(ac.a.uwY, paramString);
    g.DQ();
    g.DP().Dz().c(ac.a.uwZ, Integer.valueOf(i));
    g.DQ();
    g.DP().Dz().c(ac.a.uxc, Integer.valueOf(j));
    bWj();
  }
  
  public static MallNews Qy(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Map localMap = bn.s(paramString, "sysmsg");
    if (localMap == null) {
      return null;
    }
    MallNews localMallNews;
    for (;;)
    {
      try
      {
        localMallNews = new MallNews((String)localMap.get(".sysmsg.mallactivity.functionid"));
        localMallNews.pva = ((String)localMap.get(".sysmsg.mallactivity.activityid"));
        localMallNews.bJY = ((String)localMap.get(".sysmsg.mallactivity.ticket"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivity.type"));
        localMallNews.showType = bk.getInt((String)localMap.get(".sysmsg.mallactivity.showtype"), 0);
        if (localMap.containsKey(".sysmsg.mallactivity.showflag"))
        {
          localMallNews.qzD = ((String)localMap.get(".sysmsg.mallactivity.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivity.newsTipFlag"))
          {
            localMallNews.qzE = ((String)localMap.get(".sysmsg.mallactivity.newsTipFlag"));
            localMallNews.qzL = paramString;
            if (!bk.bl(localMallNews.ecR)) {
              break;
            }
            return null;
          }
        }
        else
        {
          localMallNews.qzD = "0";
          continue;
        }
        localMallNews.qzE = "0";
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.MallNewsManager", "cmdid error");
        return null;
      }
    }
    return localMallNews;
  }
  
  public static boolean a(MallNews paramMallNews)
  {
    g.DQ();
    String str = (String)g.DP().Dz().get(ac.a.uuU, "");
    ArrayList localArrayList = bk.G(str.split(","));
    y.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[] { str });
    if (paramMallNews == null) {
      return false;
    }
    if (bk.bl(paramMallNews.pva)) {
      return false;
    }
    return localArrayList.contains(paramMallNews.pva);
  }
  
  public static c bWg()
  {
    if (qzN == null) {
      qzN = new c();
    }
    return qzN;
  }
  
  public static void bWi()
  {
    g.DQ();
    g.DP().Dz().c(ac.a.uwY, "");
    g.DQ();
    g.DP().Dz().c(ac.a.uwZ, Integer.valueOf(-1));
  }
  
  public static void bWj()
  {
    y.d("MicroMsg.MallNewsManager", "clearMallNew ");
    com.tencent.mm.y.c.BS().bd(262156, 266248);
  }
  
  public static void c(MallFunction paramMallFunction)
  {
    try
    {
      if (!bk.bl(paramMallFunction.qzx.pva))
      {
        g.DQ();
        localObject = bk.G(((String)g.DP().Dz().get(ac.a.uuU, "")).split(","));
        while (((List)localObject).size() > 20) {
          ((List)localObject).remove(0);
        }
      }
      return;
    }
    catch (Exception paramMallFunction)
    {
      y.printErrStackTrace("MicroMsg.MallNewsManager", paramMallFunction, "error in markedFunction", new Object[0]);
    }
    while (((List)localObject).contains(paramMallFunction.qzx.pva)) {}
    ((List)localObject).add(paramMallFunction.qzx.pva);
    Object localObject = bk.c((List)localObject, ",");
    y.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[] { paramMallFunction.qzx.pva, localObject });
    g.DQ();
    g.DP().Dz().c(ac.a.uuU, localObject);
  }
  
  public final String Qw(String paramString)
  {
    paramString = (MallNews)this.qzO.get(paramString);
    if ((paramString != null) && (!bk.bl(paramString.bJY))) {
      return paramString.bJY;
    }
    return null;
  }
  
  public final MallNews Qx(String paramString)
  {
    y.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + paramString);
    if ((!bk.bl(paramString)) && (this.qzO.containsKey(paramString)))
    {
      paramString = (MallNews)this.qzO.get(paramString);
      if ("0".equals(paramString.qzD))
      {
        paramString.qzD = "1";
        bsi();
      }
      return paramString;
    }
    return null;
  }
  
  public final void S(ArrayList<MallFunction> paramArrayList)
  {
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.qzO.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((Set)localObject).remove(((MallFunction)paramArrayList.next()).npy);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.qzO.remove(localObject);
      }
      bsi();
    }
  }
  
  public final List<String> bWh()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qzO.values().iterator();
    while (localIterator.hasNext())
    {
      MallNews localMallNews = (MallNews)localIterator.next();
      if (!bk.bl(localMallNews.bJY)) {
        localArrayList.add(localMallNews.bJY);
      }
    }
    y.d("MicroMsg.MallNewsManager", "tickets.size : " + localArrayList.size());
    return localArrayList;
  }
  
  public final boolean bsi()
  {
    y.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.qzO.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.qzO.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!bk.bl((String)localObject))
      {
        localObject = (MallNews)this.qzO.get(localObject);
        localStringBuffer.append(((MallNews)localObject).qzL.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + ((MallNews)localObject).qzD + "</showflag><newsTipFlag>" + ((MallNews)localObject).qzE + "</newsTipFlag></mallactivity></sysmsg>;");
      }
    }
    y.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.DQ();
    g.DP().Dz().o(270339, localStringBuffer.toString());
    return true;
  }
  
  public final void xK()
  {
    this.qzO.clear();
    g.DQ();
    Object localObject = (String)g.DP().Dz().get(270339, "");
    y.d("MicroMsg.MallNewsManager", "data : " + (String)localObject);
    localObject = bk.G(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = Qy((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.qzO.put(localMallNews.ecR, localMallNews);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.c
 * JD-Core Version:    0.7.0.1
 */