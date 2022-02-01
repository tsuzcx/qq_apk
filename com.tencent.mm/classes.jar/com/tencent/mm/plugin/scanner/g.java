package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.n.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class g
{
  private static final String[] CAa;
  private static final String[] CAb;
  private static List<String> CAc;
  public static final String CAd;
  public static final String CAe;
  public static final String CAf;
  public static final String CAg;
  private static final String[] CzW;
  private static final String[] CzX;
  private static final String[] CzY;
  private static final String[] CzZ;
  private static final String qtb;
  
  static
  {
    AppMethodBeat.i(223703);
    qtb = MMApplicationContext.getApplicationId();
    CzW = new String[] { "http://" + WeChatHosts.domainString(2131761749) + "/g/", "https://" + WeChatHosts.domainString(2131761749) + "/g/" };
    CzX = new String[] { "http://" + WeChatHosts.domainString(2131761745) + "/", "https://" + WeChatHosts.domainString(2131761745) + "/" };
    CzY = new String[] { "http://" + WeChatHosts.domainString(2131761751) + "/u/", "http://" + WeChatHosts.domainString(2131761751) + "/ct/", "https://" + WeChatHosts.domainString(2131761751) + "/u/", "https://" + WeChatHosts.domainString(2131761751) + "/ct/" };
    CzZ = new String[] { "https://c.weixin.com/g/" };
    CAa = new String[] { "https://wx.tenpay.com/f2f", "wxp://f2f", "https://" + WeChatHosts.domainString(2131761732) + "/qr/" };
    CAb = new String[] { "m", "n" };
    CAd = "http://" + WeChatHosts.domainString(2131761749) + "/r/";
    CAe = "https://" + WeChatHosts.domainString(2131761749) + "/r/";
    CAf = "http://" + WeChatHosts.domainString(2131761749) + "/q/";
    CAg = "https://" + WeChatHosts.domainString(2131761749) + "/q/";
    AppMethodBeat.o(223703);
  }
  
  public static boolean ca(int paramInt, String paramString)
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
        localObject = qtb;
        if (c.axW().Fo((String)localObject)) {}
      }
    }
    else
    {
      localObject = eOL();
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
    Object localObject = (Bundle)h.a(qtb, null, g.b.class);
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
  
  public static boolean cb(int paramInt, String paramString)
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
        localObject = qtb;
        if (c.axW().Fo((String)localObject)) {}
      }
    }
    else
    {
      localObject = eOM();
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
    Object localObject = (Bundle)h.a(qtb, null, g.a.class);
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
  
  public static boolean cc(int paramInt, String paramString)
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
    String[] arrayOfString = CzX;
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
  
  public static boolean cd(int paramInt, String paramString)
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
    String[] arrayOfString = CzW;
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
  
  public static boolean ce(int paramInt, String paramString)
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
    String[] arrayOfString = CzY;
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
  
  public static boolean cf(int paramInt, String paramString)
  {
    AppMethodBeat.i(223701);
    if (paramInt != 19)
    {
      AppMethodBeat.o(223701);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(223701);
      return false;
    }
    String[] arrayOfString = CzZ;
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (paramString.startsWith(arrayOfString[paramInt]))
      {
        AppMethodBeat.o(223701);
        return true;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(223701);
    return false;
  }
  
  public static boolean cg(int paramInt, String paramString)
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
    String[] arrayOfString = CAb;
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
  
  public static boolean ch(int paramInt, String paramString)
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
    String[] arrayOfString = CAa;
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
  
  public static boolean ci(int paramInt, String paramString)
  {
    AppMethodBeat.i(151560);
    if ((ca(paramInt, paramString)) || (cb(paramInt, paramString)) || (cd(paramInt, paramString)) || (cc(paramInt, paramString)) || (ce(paramInt, paramString)) || (ch(paramInt, paramString)) || (cg(paramInt, paramString)))
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
    if (cb(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 3;
    }
    if (ca(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 4;
    }
    if (cd(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 2;
    }
    if (cc(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 1;
    }
    if (ce(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 7;
    }
    if (cg(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 5;
    }
    if (ch(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 6;
    }
    AppMethodBeat.o(151561);
    return -1;
  }
  
  public static boolean ck(int paramInt, String paramString)
  {
    AppMethodBeat.i(223702);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(223702);
      return false;
    }
    if (ca(paramInt, paramString))
    {
      AppMethodBeat.o(223702);
      return true;
    }
    Object localObject1;
    if ((CAc == null) || (CAc.size() <= 0))
    {
      CAc = new ArrayList();
      localObject1 = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.seI, "");
      if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
        break label151;
      }
      CAc.addAll(eOM());
    }
    for (;;)
    {
      for (localObject1 = CAc;; localObject1 = CAc)
      {
        localObject1 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (!paramString.startsWith((String)((Iterator)localObject1).next()));
        AppMethodBeat.o(223702);
        return true;
        label151:
        localObject1 = ((String)localObject1).split(";");
        if ((localObject1 != null) && (localObject1.length > 0)) {
          break;
        }
      }
      int i = localObject1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if ((localObject2 != null) && (localObject2.length() >= 0)) {
          CAc.add(localObject2);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(223702);
    return false;
  }
  
  private static Set<String> eOL()
  {
    AppMethodBeat.i(151562);
    HashSet localHashSet = new HashSet();
    localHashSet.add("k");
    localHashSet.add("l");
    if (MMApplicationContext.isMMProcess())
    {
      localObject = ((a)com.tencent.mm.kernel.g.af(a.class)).aqK();
      if (localObject == null) {
        break label143;
      }
    }
    label143:
    for (Object localObject = ((d)localObject).aj("ScanCode", "weAppCodePrefix");; localObject = "")
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
  
  private static Set<String> eOM()
  {
    AppMethodBeat.i(151563);
    HashSet localHashSet = new HashSet();
    localHashSet.add(CAd);
    localHashSet.add(CAe);
    localHashSet.add(CAf);
    localHashSet.add(CAg);
    if (MMApplicationContext.isMainProcess())
    {
      localObject = ((a)com.tencent.mm.kernel.g.af(a.class)).aqK();
      if (localObject == null) {
        break label162;
      }
    }
    label162:
    for (Object localObject = ((d)localObject).aj("ScanCode", "brandCodePrefix");; localObject = "")
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g
 * JD-Core Version:    0.7.0.1
 */