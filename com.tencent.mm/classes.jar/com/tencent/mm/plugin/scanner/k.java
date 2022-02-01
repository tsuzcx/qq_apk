package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.k.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.j.b;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class k
{
  private static final String[] OHF;
  private static final String[] OHG;
  private static final String[] OHH;
  private static final String[] OHI;
  private static final String[] OHJ;
  private static final String[] OHK;
  private static final String[] OHL;
  private static final String[] OHM;
  private static final String[] OHN;
  public static final String OHO;
  public static final String OHP;
  public static final String OHQ;
  public static final String OHR;
  private static int OHS;
  private static int OHT;
  private static int OHU;
  private static final String wVd;
  
  static
  {
    AppMethodBeat.i(313398);
    wVd = MMApplicationContext.getApplicationId();
    OHF = new String[] { "http://" + WeChatHosts.domainString(c.h.host_weixin_qq_com) + "/g/", "https://" + WeChatHosts.domainString(c.h.host_weixin_qq_com) + "/g/" };
    OHG = new String[] { "http://" + WeChatHosts.domainString(c.h.host_u_wechat_com) + "/", "https://" + WeChatHosts.domainString(c.h.host_u_wechat_com) + "/" };
    OHH = new String[] { "http://" + WeChatHosts.domainString(c.h.host_work_weixin_qq_com) + "/u/", "http://" + WeChatHosts.domainString(c.h.host_work_weixin_qq_com) + "/ct/", "https://" + WeChatHosts.domainString(c.h.host_work_weixin_qq_com) + "/u/", "https://" + WeChatHosts.domainString(c.h.host_work_weixin_qq_com) + "/ct/" };
    OHI = new String[] { "https://c.weixin.com/g/" };
    OHJ = new String[] { "http://work.weixin.qq.com/m/", "https://work.weixin.qq.com/m/", "http://work.weixin.qq.com/gm/", "https://work.weixin.qq.com/gm/" };
    OHK = new String[] { "https://wx.tenpay.com/f2f", "wxp://f2f", "https://" + WeChatHosts.domainString(c.h.host_payapp_weixin_qq_com) + "/qr/" };
    OHL = new String[] { OHK[0], OHK[1], OHK[2], "weixin://wxpay/bizpayurl", "wxp://wbf2f", "weixin://wxpay/bindurl", "wxhb://f2f" };
    OHM = new String[] { "m", "n" };
    OHN = new String[] { "https://" + WeChatHosts.domainString(c.h.host_weixin_qq_com) + "/f/", "http://" + WeChatHosts.domainString(c.h.host_weixin_qq_com) + "/f/" };
    OHO = "http://" + WeChatHosts.domainString(j.b.host_weixin_qq_com) + "/r/";
    OHP = "https://" + WeChatHosts.domainString(j.b.host_weixin_qq_com) + "/r/";
    OHQ = "http://" + WeChatHosts.domainString(j.b.host_weixin_qq_com) + "/q/";
    OHR = "https://" + WeChatHosts.domainString(j.b.host_weixin_qq_com) + "/q/";
    OHS = 1;
    OHT = 2;
    OHU = 4;
    AppMethodBeat.o(313398);
  }
  
  public static boolean cK(int paramInt, String paramString)
  {
    AppMethodBeat.i(151555);
    if (paramInt != 22)
    {
      AppMethodBeat.o(151555);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151555);
      return false;
    }
    if (!MMApplicationContext.isMMProcess())
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        localObject = wVd;
        if (e.aYp().ET((String)localObject)) {}
      }
    }
    else
    {
      localObject = gPm();
      if (localObject != null) {
        break label151;
      }
      AppMethodBeat.o(151555);
      return false;
    }
    HashSet localHashSet = new HashSet();
    Object localObject = (Bundle)j.a(wVd, null, k.b.class);
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).getString("wxCodePrefix", "");; localObject = "")
    {
      localObject = ((String)localObject).split("|");
      paramInt = 0;
      while (paramInt < localObject.length)
      {
        if (!Util.isNullOrNil(localObject[paramInt])) {
          localHashSet.add(localObject[paramInt]);
        }
        paramInt += 1;
        continue;
        label151:
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.startsWith((String)((Iterator)localObject).next()))
          {
            AppMethodBeat.o(151555);
            return true;
          }
        }
        AppMethodBeat.o(151555);
        return false;
      }
      localObject = localHashSet;
      break;
    }
  }
  
  public static boolean cL(int paramInt, String paramString)
  {
    AppMethodBeat.i(151556);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151556);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151556);
      return false;
    }
    if (!MMApplicationContext.isMainProcess())
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        localObject = wVd;
        if (e.aYp().ET((String)localObject)) {}
      }
    }
    else
    {
      localObject = gPn();
      if (localObject != null) {
        break label157;
      }
      AppMethodBeat.o(151556);
      return false;
    }
    HashSet localHashSet = new HashSet();
    Object localObject = (Bundle)j.a(wVd, null, k.a.class);
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).getString("brandCodePrefix", "");; localObject = "")
    {
      localObject = ((String)localObject).split("\\|");
      paramInt = 0;
      while (paramInt < localObject.length)
      {
        if (!Util.isNullOrNil(localObject[paramInt])) {
          localHashSet.add(localObject[paramInt]);
        }
        paramInt += 1;
        continue;
        label157:
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.startsWith((String)((Iterator)localObject).next()))
          {
            AppMethodBeat.o(151556);
            return true;
          }
        }
        AppMethodBeat.o(151556);
        return false;
      }
      localObject = localHashSet;
      break;
    }
  }
  
  public static boolean cM(int paramInt, String paramString)
  {
    AppMethodBeat.i(151557);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151557);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151557);
      return false;
    }
    String[] arrayOfString = OHG;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(151557);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(151557);
    return false;
  }
  
  public static boolean cN(int paramInt, String paramString)
  {
    AppMethodBeat.i(151558);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151558);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151558);
      return false;
    }
    String[] arrayOfString = OHF;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(151558);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(151558);
    return false;
  }
  
  public static boolean cO(int paramInt, String paramString)
  {
    AppMethodBeat.i(151559);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151559);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151559);
      return false;
    }
    String[] arrayOfString = OHH;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(151559);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(151559);
    return false;
  }
  
  public static boolean cP(int paramInt, String paramString)
  {
    AppMethodBeat.i(313355);
    if (paramInt != 19)
    {
      AppMethodBeat.o(313355);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(313355);
      return false;
    }
    String[] arrayOfString = OHI;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(313355);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(313355);
    return false;
  }
  
  public static boolean cQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(177300);
    if (paramInt != 22)
    {
      AppMethodBeat.o(177300);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177300);
      return false;
    }
    String[] arrayOfString = OHM;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(177300);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(177300);
    return false;
  }
  
  public static boolean cR(int paramInt, String paramString)
  {
    AppMethodBeat.i(177301);
    if (paramInt != 19)
    {
      AppMethodBeat.o(177301);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177301);
      return false;
    }
    String[] arrayOfString = OHK;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(177301);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(177301);
    return false;
  }
  
  public static boolean cS(int paramInt, String paramString)
  {
    AppMethodBeat.i(313366);
    if (cQ(paramInt, paramString))
    {
      AppMethodBeat.o(313366);
      return true;
    }
    if (paramInt != 19)
    {
      AppMethodBeat.o(313366);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(313366);
      return false;
    }
    String[] arrayOfString = OHL;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(313366);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(313366);
    return false;
  }
  
  public static boolean cT(int paramInt, String paramString)
  {
    AppMethodBeat.i(313368);
    if (paramInt != 19)
    {
      AppMethodBeat.o(313368);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(313368);
      return false;
    }
    String[] arrayOfString = OHN;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(313368);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(313368);
    return false;
  }
  
  public static boolean cU(int paramInt, String paramString)
  {
    AppMethodBeat.i(151560);
    if ((cK(paramInt, paramString)) || (cL(paramInt, paramString)) || (cN(paramInt, paramString)) || (cM(paramInt, paramString)) || (cO(paramInt, paramString)) || (cR(paramInt, paramString)) || (cQ(paramInt, paramString)) || (cT(paramInt, paramString)))
    {
      AppMethodBeat.o(151560);
      return true;
    }
    AppMethodBeat.o(151560);
    return false;
  }
  
  public static int cV(int paramInt, String paramString)
  {
    AppMethodBeat.i(151561);
    if (cL(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 3;
    }
    if (cK(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 4;
    }
    if (cN(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 2;
    }
    if (cM(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 1;
    }
    if (cO(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 7;
    }
    if (cQ(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 5;
    }
    if (cR(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 6;
    }
    if (cT(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 9;
    }
    AppMethodBeat.o(151561);
    return -1;
  }
  
  public static boolean e(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(313384);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(313384);
      return false;
    }
    int i = ((c)h.ax(c.class)).a(c.a.zgN, 7);
    if ((cK(paramInt, paramString)) && (m(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(313384);
      return true;
    }
    i = ((c)h.ax(c.class)).a(c.a.zgO, 3);
    if ((cM(paramInt, paramString)) && (m(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(313384);
      return true;
    }
    i = ((c)h.ax(c.class)).a(c.a.zgP, 3);
    if ((cN(paramInt, paramString)) && (m(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(313384);
      return true;
    }
    i = ((c)h.ax(c.class)).a(c.a.zgQ, 0);
    if ((cS(paramInt, paramString)) && (m(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(313384);
      return true;
    }
    i = ((c)h.ax(c.class)).a(c.a.zgR, 3);
    if ((cO(paramInt, paramString)) && (m(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(313384);
      return true;
    }
    i = ((c)h.ax(c.class)).a(c.a.zgS, 3);
    if ((cP(paramInt, paramString)) && (m(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(313384);
      return true;
    }
    i = ((c)h.ax(c.class)).a(c.a.zgT, 2);
    if ((cL(paramInt, paramString)) && (m(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(313384);
      return true;
    }
    i = ((c)h.ax(c.class)).a(c.a.zgU, 0);
    if ((cT(paramInt, paramString)) && (m(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(313384);
      return true;
    }
    paramBoolean1 = m(((c)h.ax(c.class)).a(c.a.zgV, 0), paramBoolean1, paramBoolean2);
    AppMethodBeat.o(313384);
    return paramBoolean1;
  }
  
  private static Set<String> gPm()
  {
    AppMethodBeat.i(151562);
    HashSet localHashSet = new HashSet();
    localHashSet.add("k");
    localHashSet.add("l");
    if (MMApplicationContext.isMMProcess())
    {
      localObject = ((a)h.ax(a.class)).aRD();
      if (localObject == null) {
        break label144;
      }
    }
    label144:
    for (Object localObject = ((d)localObject).at("ScanCode", "weAppCodePrefix");; localObject = "")
    {
      Log.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", new Object[] { localObject });
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        int i = 0;
        while (i < localObject.length)
        {
          if (!Util.isNullOrNil(localObject[i])) {
            localHashSet.add(localObject[i]);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(151562);
      return localHashSet;
    }
  }
  
  private static Set<String> gPn()
  {
    AppMethodBeat.i(151563);
    HashSet localHashSet = new HashSet();
    localHashSet.add(OHO);
    localHashSet.add(OHP);
    localHashSet.add(OHQ);
    localHashSet.add(OHR);
    if (MMApplicationContext.isMainProcess())
    {
      localObject = ((a)h.ax(a.class)).aRD();
      if (localObject == null) {
        break label164;
      }
    }
    label164:
    for (Object localObject = ((d)localObject).at("ScanCode", "brandCodePrefix");; localObject = "")
    {
      Log.v("MicroMsg.QRCodeLogic", "getWxBrandCodePrefix(%s)", new Object[] { localObject });
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        int i = 0;
        while (i < localObject.length)
        {
          if (!Util.isNullOrNil(localObject[i])) {
            localHashSet.add(localObject[i]);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(151563);
      return localHashSet;
    }
  }
  
  private static boolean m(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if ((OHT & paramInt) == 0) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!paramBoolean2) {
          break;
        }
      } while ((OHU & paramInt) != 0);
      return false;
    } while ((OHS & paramInt) != 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.k
 * JD-Core Version:    0.7.0.1
 */