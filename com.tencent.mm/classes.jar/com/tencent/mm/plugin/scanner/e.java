package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class e
{
  private static final String[] vLA = { "http://work.weixin.qq.com/u/", "http://work.weixin.qq.com/ct/", "https://work.weixin.qq.com/u/", "https://work.weixin.qq.com/ct/" };
  private static final String[] vLB = { "https://wx.tenpay.com/f2f", "wxp://f2f", "https://payapp.weixin.qq.com/qr/" };
  private static final String[] vLC = { "m", "n" };
  private static final String[] vLy = { "http://weixin.qq.com/g/", "https://weixin.qq.com/g/" };
  private static final String[] vLz = { "http://u.wechat.com/", "https://u.wechat.com/" };
  
  public static boolean bD(int paramInt, String paramString)
  {
    AppMethodBeat.i(151555);
    if (paramInt != 22)
    {
      AppMethodBeat.o(151555);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151555);
      return false;
    }
    if ((aj.cbv()) || ((Looper.myLooper() == Looper.getMainLooper()) && (!com.tencent.mm.ipcinvoker.c.ads().qn("com.tencent.mm"))))
    {
      localObject = dkS();
      localObject = ((Set)localObject).iterator();
    }
    HashSet localHashSet;
    while (((Iterator)localObject).hasNext()) {
      if (paramString.startsWith((String)((Iterator)localObject).next()))
      {
        AppMethodBeat.o(151555);
        return true;
        localHashSet = new HashSet();
        localObject = (Bundle)h.a("com.tencent.mm", null, b.class);
        if (localObject == null) {
          break label187;
        }
      }
    }
    label187:
    for (Object localObject = ((Bundle)localObject).getString("wxCodePrefix", "");; localObject = "")
    {
      localObject = ((String)localObject).split("|");
      paramInt = 0;
      while (paramInt < localObject.length)
      {
        if (!bt.isNullOrNil(localObject[paramInt])) {
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
  
  public static boolean bE(int paramInt, String paramString)
  {
    AppMethodBeat.i(151556);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151556);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151556);
      return false;
    }
    if ((aj.cbe()) || ((Looper.myLooper() == Looper.getMainLooper()) && (!com.tencent.mm.ipcinvoker.c.ads().qn("com.tencent.mm"))))
    {
      localObject = dkT();
      localObject = ((Set)localObject).iterator();
    }
    HashSet localHashSet;
    while (((Iterator)localObject).hasNext()) {
      if (paramString.startsWith((String)((Iterator)localObject).next()))
      {
        AppMethodBeat.o(151556);
        return true;
        localHashSet = new HashSet();
        localObject = (Bundle)h.a("com.tencent.mm", null, a.class);
        if (localObject == null) {
          break label187;
        }
      }
    }
    label187:
    for (Object localObject = ((Bundle)localObject).getString("brandCodePrefix", "");; localObject = "")
    {
      localObject = ((String)localObject).split("\\|");
      paramInt = 0;
      while (paramInt < localObject.length)
      {
        if (!bt.isNullOrNil(localObject[paramInt])) {
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
  
  public static boolean bF(int paramInt, String paramString)
  {
    AppMethodBeat.i(151557);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151557);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151557);
      return false;
    }
    String[] arrayOfString = vLz;
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
  
  public static boolean bG(int paramInt, String paramString)
  {
    AppMethodBeat.i(151558);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151558);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151558);
      return false;
    }
    String[] arrayOfString = vLy;
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
  
  public static boolean bH(int paramInt, String paramString)
  {
    AppMethodBeat.i(151559);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151559);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151559);
      return false;
    }
    String[] arrayOfString = vLA;
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
  
  public static boolean bI(int paramInt, String paramString)
  {
    AppMethodBeat.i(177300);
    if (paramInt != 22)
    {
      AppMethodBeat.o(177300);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177300);
      return false;
    }
    String[] arrayOfString = vLC;
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
  
  public static boolean bJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(177301);
    if (paramInt != 19)
    {
      AppMethodBeat.o(177301);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177301);
      return false;
    }
    String[] arrayOfString = vLB;
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
  
  public static boolean bK(int paramInt, String paramString)
  {
    AppMethodBeat.i(151560);
    if ((bD(paramInt, paramString)) || (bE(paramInt, paramString)) || (bG(paramInt, paramString)) || (bF(paramInt, paramString)) || (bH(paramInt, paramString)) || (bJ(paramInt, paramString)) || (bI(paramInt, paramString)))
    {
      AppMethodBeat.o(151560);
      return true;
    }
    AppMethodBeat.o(151560);
    return false;
  }
  
  public static int bL(int paramInt, String paramString)
  {
    AppMethodBeat.i(151561);
    if (bE(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 3;
    }
    if (bD(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 4;
    }
    if (bG(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 2;
    }
    if (bF(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 1;
    }
    if (bH(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 7;
    }
    if (bI(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 5;
    }
    if (bJ(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 6;
    }
    AppMethodBeat.o(151561);
    return -1;
  }
  
  private static Set<String> dkS()
  {
    AppMethodBeat.i(151562);
    HashSet localHashSet = new HashSet();
    localHashSet.add("k");
    localHashSet.add("l");
    if (aj.cbv())
    {
      localObject = ((a)g.ab(a.class)).Ze();
      if (localObject == null) {
        break label134;
      }
    }
    label134:
    for (Object localObject = ((com.tencent.mm.m.c)localObject).ad("ScanCode", "weAppCodePrefix");; localObject = "")
    {
      ad.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", new Object[] { localObject });
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        int i = 0;
        while (i < localObject.length)
        {
          if (!bt.isNullOrNil(localObject[i])) {
            localHashSet.add(localObject[i]);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(151562);
      return localHashSet;
    }
  }
  
  private static Set<String> dkT()
  {
    AppMethodBeat.i(151563);
    HashSet localHashSet = new HashSet();
    localHashSet.add("http://weixin.qq.com/r/");
    localHashSet.add("http://weixin.qq.com/q/");
    if (aj.cbe())
    {
      localObject = ((a)g.ab(a.class)).Ze();
      if (localObject == null) {
        break label134;
      }
    }
    label134:
    for (Object localObject = ((com.tencent.mm.m.c)localObject).ad("ScanCode", "brandCodePrefix");; localObject = "")
    {
      ad.v("MicroMsg.QRCodeLogic", "getWxBrandCodePrefix(%s)", new Object[] { localObject });
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        int i = 0;
        while (i < localObject.length)
        {
          if (!bt.isNullOrNil(localObject[i])) {
            localHashSet.add(localObject[i]);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(151563);
      return localHashSet;
    }
  }
  
  static class a
    implements k<Bundle, Bundle>
  {}
  
  static class b
    implements k<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e
 * JD-Core Version:    0.7.0.1
 */