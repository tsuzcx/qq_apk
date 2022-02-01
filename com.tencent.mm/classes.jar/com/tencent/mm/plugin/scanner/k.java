package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.j.b;
import com.tencent.mm.n.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
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
  private static final String[] IBD;
  private static final String[] IBE;
  private static final String[] IBF;
  private static final String[] IBG;
  private static final String[] IBH;
  private static final String[] IBI;
  private static final String[] IBJ;
  private static final String[] IBK;
  private static final String[] IBL;
  public static final String IBM;
  public static final String IBN;
  public static final String IBO;
  public static final String IBP;
  private static int IBQ;
  private static int IBR;
  private static int IBS;
  private static final String tRN;
  
  static
  {
    AppMethodBeat.i(203683);
    tRN = MMApplicationContext.getApplicationId();
    IBD = new String[] { "http://" + WeChatHosts.domainString(c.h.host_weixin_qq_com) + "/g/", "https://" + WeChatHosts.domainString(c.h.host_weixin_qq_com) + "/g/" };
    IBE = new String[] { "http://" + WeChatHosts.domainString(c.h.host_u_wechat_com) + "/", "https://" + WeChatHosts.domainString(c.h.host_u_wechat_com) + "/" };
    IBF = new String[] { "http://" + WeChatHosts.domainString(c.h.host_work_weixin_qq_com) + "/u/", "http://" + WeChatHosts.domainString(c.h.host_work_weixin_qq_com) + "/ct/", "https://" + WeChatHosts.domainString(c.h.host_work_weixin_qq_com) + "/u/", "https://" + WeChatHosts.domainString(c.h.host_work_weixin_qq_com) + "/ct/" };
    IBG = new String[] { "https://c.weixin.com/g/" };
    IBH = new String[] { "http://work.weixin.qq.com/m/", "https://work.weixin.qq.com/m/", "http://work.weixin.qq.com/gm/", "https://work.weixin.qq.com/gm/" };
    IBI = new String[] { "https://wx.tenpay.com/f2f", "wxp://f2f", "https://" + WeChatHosts.domainString(c.h.host_payapp_weixin_qq_com) + "/qr/" };
    IBJ = new String[] { IBI[0], IBI[1], IBI[2], "weixin://wxpay/bizpayurl", "wxp://wbf2f", "weixin://wxpay/bindurl", "wxhb://f2f" };
    IBK = new String[] { "m", "n" };
    IBL = new String[] { "https://" + WeChatHosts.domainString(c.h.host_weixin_qq_com) + "/f/", "http://" + WeChatHosts.domainString(c.h.host_weixin_qq_com) + "/f/" };
    IBM = "http://" + WeChatHosts.domainString(j.b.host_weixin_qq_com) + "/r/";
    IBN = "https://" + WeChatHosts.domainString(j.b.host_weixin_qq_com) + "/r/";
    IBO = "http://" + WeChatHosts.domainString(j.b.host_weixin_qq_com) + "/q/";
    IBP = "https://" + WeChatHosts.domainString(j.b.host_weixin_qq_com) + "/q/";
    IBQ = 1;
    IBR = 2;
    IBS = 4;
    AppMethodBeat.o(203683);
  }
  
  public static boolean bY(int paramInt, String paramString)
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
        localObject = tRN;
        if (e.aFo().Ml((String)localObject)) {}
      }
    }
    else
    {
      localObject = fBJ();
      localObject = ((Set)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.startsWith((String)((Iterator)localObject).next()));
      AppMethodBeat.o(151555);
      return true;
    }
    HashSet localHashSet = new HashSet();
    Object localObject = (Bundle)j.a(tRN, null, k.b.class);
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
        AppMethodBeat.o(151555);
        return false;
      }
      localObject = localHashSet;
      break;
    }
  }
  
  public static boolean bZ(int paramInt, String paramString)
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
        localObject = tRN;
        if (e.aFo().Ml((String)localObject)) {}
      }
    }
    else
    {
      localObject = fBK();
      localObject = ((Set)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.startsWith((String)((Iterator)localObject).next()));
      AppMethodBeat.o(151556);
      return true;
    }
    HashSet localHashSet = new HashSet();
    Object localObject = (Bundle)j.a(tRN, null, k.a.class);
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
        AppMethodBeat.o(151556);
        return false;
      }
      localObject = localHashSet;
      break;
    }
  }
  
  public static boolean ca(int paramInt, String paramString)
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
    String[] arrayOfString = IBE;
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
  
  public static boolean cb(int paramInt, String paramString)
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
    String[] arrayOfString = IBD;
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
  
  public static boolean cc(int paramInt, String paramString)
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
    String[] arrayOfString = IBF;
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
  
  public static boolean cd(int paramInt, String paramString)
  {
    AppMethodBeat.i(203630);
    if (paramInt != 19)
    {
      AppMethodBeat.o(203630);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203630);
      return false;
    }
    String[] arrayOfString = IBG;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(203630);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(203630);
    return false;
  }
  
  public static boolean ce(int paramInt, String paramString)
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
    String[] arrayOfString = IBK;
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
  
  public static boolean cf(int paramInt, String paramString)
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
    String[] arrayOfString = IBI;
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
  
  public static boolean cg(int paramInt, String paramString)
  {
    AppMethodBeat.i(203637);
    if (ce(paramInt, paramString))
    {
      AppMethodBeat.o(203637);
      return true;
    }
    if (paramInt != 19)
    {
      AppMethodBeat.o(203637);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203637);
      return false;
    }
    String[] arrayOfString = IBJ;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(203637);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(203637);
    return false;
  }
  
  public static boolean ch(int paramInt, String paramString)
  {
    AppMethodBeat.i(203638);
    if (paramInt != 19)
    {
      AppMethodBeat.o(203638);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203638);
      return false;
    }
    String[] arrayOfString = IBL;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(203638);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(203638);
    return false;
  }
  
  public static boolean ci(int paramInt, String paramString)
  {
    AppMethodBeat.i(151560);
    if ((bY(paramInt, paramString)) || (bZ(paramInt, paramString)) || (cb(paramInt, paramString)) || (ca(paramInt, paramString)) || (cc(paramInt, paramString)) || (cf(paramInt, paramString)) || (ce(paramInt, paramString)) || (ch(paramInt, paramString)))
    {
      AppMethodBeat.o(151560);
      return true;
    }
    AppMethodBeat.o(151560);
    return false;
  }
  
  public static int cj(int paramInt, String paramString)
  {
    AppMethodBeat.i(151561);
    if (bZ(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 3;
    }
    if (bY(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 4;
    }
    if (cb(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 2;
    }
    if (ca(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 1;
    }
    if (cc(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 7;
    }
    if (ce(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 5;
    }
    if (cf(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 6;
    }
    if (ch(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 9;
    }
    AppMethodBeat.o(151561);
    return -1;
  }
  
  public static boolean e(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203665);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(203665);
      return false;
    }
    int i = ((b)h.ae(b.class)).a(b.a.vOl, 7);
    if ((bY(paramInt, paramString)) && (k(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(203665);
      return true;
    }
    i = ((b)h.ae(b.class)).a(b.a.vOm, 3);
    if ((ca(paramInt, paramString)) && (k(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(203665);
      return true;
    }
    i = ((b)h.ae(b.class)).a(b.a.vOn, 3);
    if ((cb(paramInt, paramString)) && (k(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(203665);
      return true;
    }
    i = ((b)h.ae(b.class)).a(b.a.vOo, 0);
    if ((cg(paramInt, paramString)) && (k(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(203665);
      return true;
    }
    i = ((b)h.ae(b.class)).a(b.a.vOp, 3);
    if ((cc(paramInt, paramString)) && (k(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(203665);
      return true;
    }
    i = ((b)h.ae(b.class)).a(b.a.vOq, 3);
    if ((cd(paramInt, paramString)) && (k(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(203665);
      return true;
    }
    i = ((b)h.ae(b.class)).a(b.a.vOr, 2);
    if ((bZ(paramInt, paramString)) && (k(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(203665);
      return true;
    }
    i = ((b)h.ae(b.class)).a(b.a.vOs, 0);
    if ((ch(paramInt, paramString)) && (k(i, paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(203665);
      return true;
    }
    paramBoolean1 = k(((b)h.ae(b.class)).a(b.a.vOt, 0), paramBoolean1, paramBoolean2);
    AppMethodBeat.o(203665);
    return paramBoolean1;
  }
  
  private static Set<String> fBJ()
  {
    AppMethodBeat.i(151562);
    HashSet localHashSet = new HashSet();
    localHashSet.add("k");
    localHashSet.add("l");
    if (MMApplicationContext.isMMProcess())
    {
      localObject = ((a)h.ae(a.class)).axd();
      if (localObject == null) {
        break label144;
      }
    }
    label144:
    for (Object localObject = ((d)localObject).ao("ScanCode", "weAppCodePrefix");; localObject = "")
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
  
  private static Set<String> fBK()
  {
    AppMethodBeat.i(151563);
    HashSet localHashSet = new HashSet();
    localHashSet.add(IBM);
    localHashSet.add(IBN);
    localHashSet.add(IBO);
    localHashSet.add(IBP);
    if (MMApplicationContext.isMainProcess())
    {
      localObject = ((a)h.ae(a.class)).axd();
      if (localObject == null) {
        break label164;
      }
    }
    label164:
    for (Object localObject = ((d)localObject).ao("ScanCode", "brandCodePrefix");; localObject = "")
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
  
  private static boolean k(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if ((IBR & paramInt) == 0) {}
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
      } while ((IBS & paramInt) != 0);
      return false;
    } while ((IBQ & paramInt) != 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.k
 * JD-Core Version:    0.7.0.1
 */