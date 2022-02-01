package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class g
{
  private static final String[] yyY = { "http://weixin.qq.com/g/", "https://weixin.qq.com/g/" };
  private static final String[] yyZ = { "http://u.wechat.com/", "https://u.wechat.com/" };
  private static final String[] yza = { "http://work.weixin.qq.com/u/", "http://work.weixin.qq.com/ct/", "https://work.weixin.qq.com/u/", "https://work.weixin.qq.com/ct/" };
  private static final String[] yzb = { "https://wx.tenpay.com/f2f", "wxp://f2f", "https://payapp.weixin.qq.com/qr/" };
  private static final String[] yzc = { "m", "n" };
  
  public static boolean bM(int paramInt, String paramString)
  {
    AppMethodBeat.i(151555);
    if (paramInt != 22)
    {
      AppMethodBeat.o(151555);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151555);
      return false;
    }
    if ((ak.cpe()) || ((Looper.myLooper() == Looper.getMainLooper()) && (!com.tencent.mm.ipcinvoker.c.ahJ().xb("com.tencent.mm"))))
    {
      localObject = dNL();
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
        if (!bu.isNullOrNil(localObject[paramInt])) {
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
  
  public static boolean bN(int paramInt, String paramString)
  {
    AppMethodBeat.i(151556);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151556);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151556);
      return false;
    }
    if ((ak.coh()) || ((Looper.myLooper() == Looper.getMainLooper()) && (!com.tencent.mm.ipcinvoker.c.ahJ().xb("com.tencent.mm"))))
    {
      localObject = dNM();
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
        if (!bu.isNullOrNil(localObject[paramInt])) {
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
  
  public static boolean bO(int paramInt, String paramString)
  {
    AppMethodBeat.i(151557);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151557);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151557);
      return false;
    }
    String[] arrayOfString = yyZ;
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
  
  public static boolean bP(int paramInt, String paramString)
  {
    AppMethodBeat.i(151558);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151558);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151558);
      return false;
    }
    String[] arrayOfString = yyY;
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
  
  public static boolean bQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(151559);
    if (paramInt != 19)
    {
      AppMethodBeat.o(151559);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151559);
      return false;
    }
    String[] arrayOfString = yza;
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
  
  public static boolean bR(int paramInt, String paramString)
  {
    AppMethodBeat.i(177300);
    if (paramInt != 22)
    {
      AppMethodBeat.o(177300);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177300);
      return false;
    }
    String[] arrayOfString = yzc;
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
  
  public static boolean bS(int paramInt, String paramString)
  {
    AppMethodBeat.i(177301);
    if (paramInt != 19)
    {
      AppMethodBeat.o(177301);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177301);
      return false;
    }
    String[] arrayOfString = yzb;
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
  
  public static boolean bT(int paramInt, String paramString)
  {
    AppMethodBeat.i(151560);
    if ((bM(paramInt, paramString)) || (bN(paramInt, paramString)) || (bP(paramInt, paramString)) || (bO(paramInt, paramString)) || (bQ(paramInt, paramString)) || (bS(paramInt, paramString)) || (bR(paramInt, paramString)))
    {
      AppMethodBeat.o(151560);
      return true;
    }
    AppMethodBeat.o(151560);
    return false;
  }
  
  public static int bU(int paramInt, String paramString)
  {
    AppMethodBeat.i(151561);
    if (bN(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 3;
    }
    if (bM(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 4;
    }
    if (bP(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 2;
    }
    if (bO(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 1;
    }
    if (bQ(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 7;
    }
    if (bR(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 5;
    }
    if (bS(paramInt, paramString))
    {
      AppMethodBeat.o(151561);
      return 6;
    }
    AppMethodBeat.o(151561);
    return -1;
  }
  
  private static Set<String> dNL()
  {
    AppMethodBeat.i(151562);
    HashSet localHashSet = new HashSet();
    localHashSet.add("k");
    localHashSet.add("l");
    if (ak.cpe())
    {
      localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).acM();
      if (localObject == null) {
        break label134;
      }
    }
    label134:
    for (Object localObject = ((com.tencent.mm.n.c)localObject).ah("ScanCode", "weAppCodePrefix");; localObject = "")
    {
      ae.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", new Object[] { localObject });
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        int i = 0;
        while (i < localObject.length)
        {
          if (!bu.isNullOrNil(localObject[i])) {
            localHashSet.add(localObject[i]);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(151562);
      return localHashSet;
    }
  }
  
  private static Set<String> dNM()
  {
    AppMethodBeat.i(151563);
    HashSet localHashSet = new HashSet();
    localHashSet.add("http://weixin.qq.com/r/");
    localHashSet.add("http://weixin.qq.com/q/");
    if (ak.coh())
    {
      localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).acM();
      if (localObject == null) {
        break label134;
      }
    }
    label134:
    for (Object localObject = ((com.tencent.mm.n.c)localObject).ah("ScanCode", "brandCodePrefix");; localObject = "")
    {
      ae.v("MicroMsg.QRCodeLogic", "getWxBrandCodePrefix(%s)", new Object[] { localObject });
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        int i = 0;
        while (i < localObject.length)
        {
          if (!bu.isNullOrNil(localObject[i])) {
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
 * Qualified Name:     com.tencent.mm.plugin.scanner.g
 * JD-Core Version:    0.7.0.1
 */