package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  private static c OUG = null;
  public Map<String, MallNews> OUH;
  
  private c()
  {
    AppMethodBeat.i(70554);
    this.OUH = new HashMap();
    ata();
    AppMethodBeat.o(70554);
  }
  
  public static boolean a(MallNews paramMallNews)
  {
    AppMethodBeat.i(70557);
    h.aHH();
    String str = (String)h.aHG().aHp().get(ar.a.Vot, "");
    ArrayList localArrayList = Util.stringsToList(str.split(","));
    Log.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[] { str });
    if (paramMallNews == null)
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (Util.isNullOrNil(paramMallNews.oym))
    {
      AppMethodBeat.o(70557);
      return false;
    }
    if (localArrayList.contains(paramMallNews.oym))
    {
      AppMethodBeat.o(70557);
      return true;
    }
    AppMethodBeat.o(70557);
    return false;
  }
  
  public static void bhc(String paramString)
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
          h.aHH();
          h.aHG().aHp().set(ar.a.VqT, paramString);
          h.aHH();
          h.aHG().aHp().set(ar.a.VqU, Integer.valueOf(i));
          h.aHH();
          h.aHG().aHp().set(ar.a.VqV, Integer.valueOf(j));
          h.aHH();
          h.aHG().aHp().set(ar.a.VqW, Integer.valueOf(k));
          gKO();
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
                    h.aHH();
                    h.aHG().aHp().set(ar.a.Vtd, Boolean.TRUE);
                    if (l > 0L)
                    {
                      h.aHH();
                      h.aHG().aHp().set(ar.a.Vte, Long.valueOf(l));
                    }
                  }
                  else if ("entry_wxpay_wallet".equals(str1))
                  {
                    h.aHH();
                    h.aHG().aHp().set(ar.a.Vtg, Boolean.TRUE);
                    if (!Util.isNullOrNil(str2))
                    {
                      h.aHH();
                      h.aHG().aHp().set(ar.a.Vtc, str2);
                    }
                    for (;;)
                    {
                      if (l <= 0L) {
                        break label621;
                      }
                      h.aHH();
                      h.aHG().aHp().set(ar.a.Vth, Long.valueOf(l));
                      break;
                      h.aHH();
                      h.aHG().aHp().set(ar.a.Vtc, "");
                    }
                  }
                  else
                  {
                    label621:
                    if ("entry_wxpay_paycenter".equals(str1))
                    {
                      h.aHH();
                      h.aHG().aHp().set(ar.a.VsW, Boolean.TRUE);
                      if (l > 0L)
                      {
                        h.aHH();
                        h.aHG().aHp().set(ar.a.VsX, Long.valueOf(l));
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
              h.aHH();
              h.aHG().aHp().set(ar.a.VsV, paramString.toString());
              h.aHH();
              h.aHG().aHp().set(ar.a.VsW, Boolean.TRUE);
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
          h.aHH();
          h.aHG().aHp().set(ar.a.VqT, paramString);
          h.aHH();
          h.aHG().aHp().set(ar.a.VqU, Integer.valueOf(i));
          h.aHH();
          h.aHG().aHp().set(ar.a.VqX, Integer.valueOf(j));
          gKO();
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
                    com.tencent.mm.aa.c.aFn().b(ar.a.Vtk, true);
                    h.aHH();
                    h.aHG().aHp().set(ar.a.Vtl, Long.valueOf(l));
                    i = 1;
                  }
                  else
                  {
                    if ("entry_wxpay_pay".equals(paramString))
                    {
                      com.tencent.mm.aa.c.aFn().b(ar.a.Vtk, true);
                      if (!Util.isNullOrNil(str2))
                      {
                        h.aHH();
                        h.aHG().aHp().set(ar.a.Vtj, str2);
                      }
                      for (;;)
                      {
                        h.aHH();
                        h.aHG().aHp().set(ar.a.Vtm, Long.valueOf(l));
                        j = 1;
                        break;
                        h.aHH();
                        h.aHG().aHp().set(ar.a.Vtj, "");
                      }
                    }
                    if ("entry_wxpay_pay_wallet".equals(paramString))
                    {
                      h.aHH();
                      h.aHG().aHp().set(ar.a.Vtn, Boolean.TRUE);
                      h.aHH();
                      h.aHG().aHp().set(ar.a.Vto, Long.valueOf(l));
                    }
                    else
                    {
                      if (paramString.startsWith("bind_serial_"))
                      {
                        paramString = paramString.substring(12);
                        h.aHH();
                        str2 = (String)h.aHG().aHp().get(ar.a.VrI, "");
                        Log.d("MicroMsg.MallNewsManager", "bind serial: %s", new Object[] { paramString });
                        if (!Util.isNullOrNil(str2)) {
                          paramString = str2 + "," + paramString;
                        }
                        for (;;)
                        {
                          h.aHH();
                          h.aHG().aHp().set(ar.a.VrI, paramString);
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
              com.tencent.mm.aa.c.aFn().c(ar.a.Vtk, ar.a.Vtr);
            }
            if (j == 0) {
              com.tencent.mm.aa.c.aFn().c(ar.a.Vtk, ar.a.Vtq);
            }
            Log.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[] { ((JSONObject)localObject1).toString() });
            if (((JSONObject)localObject1).length() > 0)
            {
              h.aHH();
              h.aHG().aHp().set(ar.a.Vtp, ((JSONObject)localObject1).toString());
              h.aHH();
              h.aHG().aHp().set(ar.a.Vtn, Boolean.TRUE);
            }
          }
        }
      }
    }
    AppMethodBeat.o(70559);
  }
  
  public static MallNews bhf(String paramString)
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
        localMallNews.oym = ((String)localMap.get(".sysmsg.mallactivity.activityid"));
        localMallNews.fAo = ((String)localMap.get(".sysmsg.mallactivity.ticket"));
        localMallNews.type = ((String)localMap.get(".sysmsg.mallactivity.type"));
        localMallNews.fwp = Util.getInt((String)localMap.get(".sysmsg.mallactivity.showtype"), 0);
        localMallNews.fZX = Util.getInt((String)localMap.get(".sysmsg.mallactivity.walletregion"), 0);
        if (localMap.containsKey(".sysmsg.mallactivity.showflag"))
        {
          localMallNews.OUx = ((String)localMap.get(".sysmsg.mallactivity.showflag"));
          if (localMap.containsKey(".sysmsg.mallactivity.newsTipFlag"))
          {
            localMallNews.OUy = ((String)localMap.get(".sysmsg.mallactivity.newsTipFlag"));
            localMallNews.OUE = paramString;
            boolean bool = Util.isNullOrNil(localMallNews.lCb);
            if (!bool) {
              break;
            }
            AppMethodBeat.o(70565);
            return null;
          }
        }
        else
        {
          localMallNews.OUx = "0";
          continue;
        }
        localMallNews.OUy = "0";
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
  
  public static c gKL()
  {
    AppMethodBeat.i(70553);
    if (OUG == null) {
      OUG = new c();
    }
    c localc = OUG;
    AppMethodBeat.o(70553);
    return localc;
  }
  
  public static void gKN()
  {
    AppMethodBeat.i(70560);
    h.aHH();
    h.aHG().aHp().set(ar.a.VqT, "");
    h.aHH();
    h.aHG().aHp().set(ar.a.VqU, Integer.valueOf(-1));
    AppMethodBeat.o(70560);
  }
  
  public static void gKO()
  {
    AppMethodBeat.i(70561);
    Log.d("MicroMsg.MallNewsManager", "clearMallNew ");
    com.tencent.mm.aa.c.aFn().dl(262156, 266248);
    AppMethodBeat.o(70561);
  }
  
  public static void i(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(70558);
    try
    {
      if (Util.isNullOrNil(paramMallFunction.OUr.oym)) {
        break label181;
      }
      h.aHH();
      localObject = Util.stringsToList(((String)h.aHG().aHp().get(ar.a.Vot, "")).split(","));
      while (((List)localObject).size() > 20) {
        ((List)localObject).remove(0);
      }
      bool = ((List)localObject).contains(paramMallFunction.OUr.oym);
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
    ((List)localObject).add(paramMallFunction.OUr.oym);
    Object localObject = Util.listToString((List)localObject, ",");
    Log.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[] { paramMallFunction.OUr.oym, localObject });
    h.aHH();
    h.aHG().aHp().set(ar.a.Vot, localObject);
    label181:
    AppMethodBeat.o(70558);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(70555);
    this.OUH.clear();
    h.aHH();
    Object localObject = (String)h.aHG().aHp().b(270339, "");
    Log.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = Util.stringsToList(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MallNews localMallNews = bhf((String)((Iterator)localObject).next());
      if (localMallNews != null) {
        this.OUH.put(localMallNews.lCb, localMallNews);
      }
    }
    AppMethodBeat.o(70555);
  }
  
  public final String bhd(String paramString)
  {
    AppMethodBeat.i(70563);
    paramString = (MallNews)this.OUH.get(paramString);
    if ((paramString != null) && (!Util.isNullOrNil(paramString.fAo)))
    {
      paramString = paramString.fAo;
      AppMethodBeat.o(70563);
      return paramString;
    }
    AppMethodBeat.o(70563);
    return null;
  }
  
  public final MallNews bhe(String paramString)
  {
    AppMethodBeat.i(70564);
    Log.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(paramString)));
    if ((!Util.isNullOrNil(paramString)) && (this.OUH.containsKey(paramString)))
    {
      paramString = (MallNews)this.OUH.get(paramString);
      if ("0".equals(paramString.OUx))
      {
        paramString.OUx = "1";
        fpp();
      }
      AppMethodBeat.o(70564);
      return paramString;
    }
    AppMethodBeat.o(70564);
    return null;
  }
  
  public final void bk(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(70566);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.OUH.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((Set)localObject).remove(((MallFunction)paramArrayList.next()).nBK);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.OUH.remove(localObject);
      }
      fpp();
    }
    AppMethodBeat.o(70566);
  }
  
  public final void bl(ArrayList<bmw> paramArrayList)
  {
    AppMethodBeat.i(227762);
    if (paramArrayList != null)
    {
      Object localObject = new HashSet(this.OUH.keySet());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        bmw localbmw = (bmw)paramArrayList.next();
        ((Set)localObject).remove(localbmw.SXF.UHA);
      }
      paramArrayList = ((Set)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.OUH.remove(localObject);
      }
      fpp();
    }
    AppMethodBeat.o(227762);
  }
  
  public final boolean fpp()
  {
    AppMethodBeat.i(70562);
    Log.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.OUH.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.OUH.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = (MallNews)this.OUH.get(localObject);
        localStringBuffer.append(((MallNews)localObject).OUE.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + ((MallNews)localObject).OUx + "</showflag><newsTipFlag>" + ((MallNews)localObject).OUy + "</newsTipFlag></mallactivity></sysmsg>;");
      }
    }
    Log.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    h.aHH();
    h.aHG().aHp().i(270339, localStringBuffer.toString());
    AppMethodBeat.o(70562);
    return true;
  }
  
  public final List<String> gKM()
  {
    AppMethodBeat.i(70556);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.OUH.values().iterator();
    while (localIterator.hasNext())
    {
      MallNews localMallNews = (MallNews)localIterator.next();
      if (!Util.isNullOrNil(localMallNews.fAo)) {
        localArrayList.add(localMallNews.fAo);
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