package com.tencent.xweb.internal;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class a$b
{
  public int MPK = -1;
  public int MPL = -1;
  public int MPM = -1;
  public int MPN = -1;
  public int MPO = -1;
  public int MPP = -1;
  public int MPQ = -1;
  public int MPR = -1;
  public String MPS = "";
  public String MPT = "";
  public int MPU = -1;
  public int MPV = -1;
  public int MPW = -1;
  public int MPX = -1;
  public int MPY = -1;
  public int MPZ = -1;
  public int MQa = -1;
  public double MQb = -1.0D;
  public double MQc = -1.0D;
  public String MQd = "";
  public String MQe = "";
  public int MQf = -1;
  public int MQg = -1;
  public int MQh = -1;
  public int MQi = -1;
  public String MQj = null;
  public String MQk = null;
  public String MQl = null;
  public String MQm = null;
  public int MQn = -1;
  public int MQo = -1;
  public String MQp;
  public String MQq;
  
  private static boolean H(double paramDouble)
  {
    return (paramDouble >= 0.0D) && (paramDouble < 24.0D);
  }
  
  private static boolean aX(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {}
    while ((paramInt2 > 0) && (paramInt1 < paramInt2)) {
      return false;
    }
    return true;
  }
  
  private static boolean bcK(String paramString)
  {
    AppMethodBeat.i(156954);
    Object localObject2 = "";
    if (Build.BRAND != null) {
      localObject2 = "" + Build.BRAND;
    }
    Object localObject1 = localObject2;
    if (Build.MODEL != null) {
      localObject1 = (String)localObject2 + " " + Build.MODEL;
    }
    localObject2 = localObject1;
    if (Build.MANUFACTURER != null) {
      localObject2 = (String)localObject1 + " " + Build.MANUFACTURER;
    }
    if ((paramString == null) || (localObject2 == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156954);
      return false;
    }
    boolean bool = nj(paramString, (String)localObject2);
    AppMethodBeat.o(156954);
    return bool;
  }
  
  private boolean ggg()
  {
    AppMethodBeat.i(217412);
    if ((!H(this.MQb)) && (!H(this.MQc)))
    {
      AppMethodBeat.o(217412);
      return true;
    }
    double d = e.ggA();
    if ((this.MQc > 0.0D) && (d > this.MQc))
    {
      AppMethodBeat.o(217412);
      return false;
    }
    if ((this.MQb > 0.0D) && (d < this.MQb))
    {
      AppMethodBeat.o(217412);
      return false;
    }
    AppMethodBeat.o(217412);
    return true;
  }
  
  private static boolean ni(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156953);
    if (paramString1 == null)
    {
      AppMethodBeat.o(156953);
      return false;
    }
    paramString1 = paramString1.split("\\|");
    if ((paramString1 == null) || (paramString1.length < 0))
    {
      AppMethodBeat.o(156953);
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(156953);
      return false;
    }
    paramString2 = paramString2.trim();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = paramString1[i];
      if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.trim().equalsIgnoreCase(paramString2)))
      {
        AppMethodBeat.o(156953);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(156953);
    return false;
  }
  
  private static boolean nj(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    AppMethodBeat.i(156955);
    if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString1.trim() == null) || (paramString1.trim().isEmpty()))
    {
      AppMethodBeat.o(156955);
      return false;
    }
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(156955);
      return false;
    }
    try
    {
      boolean bool2 = Pattern.compile(paramString1).matcher(paramString2.toUpperCase()).find();
      bool1 = bool2;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        XWalkEnvironment.addXWalkInitializeLog("ConfigDef", " _IsMatchRex compile strRex failed");
      }
    }
    AppMethodBeat.o(156955);
    return bool1;
  }
  
  public String ggd()
  {
    AppMethodBeat.i(156951);
    String str = XWalkEnvironment.getRuntimeAbi();
    AppMethodBeat.o(156951);
    return str;
  }
  
  public final boolean gge()
  {
    AppMethodBeat.i(156952);
    boolean bool = zZ(false);
    AppMethodBeat.o(156952);
    return bool;
  }
  
  protected boolean ggf()
  {
    return false;
  }
  
  public final boolean zZ(boolean paramBoolean)
  {
    AppMethodBeat.i(217411);
    int j = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int k = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
    int m = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
    int n = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
    int i;
    if ((paramBoolean) || (aX(XWalkEnvironment.getGrayValue(), this.MPU, this.MPV))) {
      i = 1;
    }
    while ((aX(j, this.MPM, this.MPN)) && (aX(k, this.MPO, this.MPP)) && (aX(200901, this.MPK, this.MPL)) && (aX(m, this.MQf, this.MQg)) && (aX(n, this.MQh, this.MQi)) && (aX(Build.VERSION.SDK_INT, this.MPQ, this.MPR)) && (i != 0) && (aX(XWalkEnvironment.getTodayGrayValue(), this.MPW, this.MPX)) && (!bcK(this.MPS)) && (!nj(this.MQd, XWalkEnvironment.getPackageName())) && (ggg())) {
      if ((this.MQa > 0) && (XWalkEnvironment.getUserType() != this.MQa))
      {
        AppMethodBeat.o(217411);
        return false;
        i = 0;
      }
      else
      {
        if ((this.MPT != null) && (this.MPT.trim() != null) && (!this.MPT.trim().isEmpty()) && (!bcK(this.MPT)))
        {
          AppMethodBeat.o(217411);
          return false;
        }
        if ((this.MQe != null) && (this.MQe.trim() != null) && (!this.MQe.trim().isEmpty()) && (!nj(this.MQe, XWalkEnvironment.getPackageName())))
        {
          AppMethodBeat.o(217411);
          return false;
        }
        if (((this.MPY > 0) || (this.MPZ > 0)) && (!aX(XWalkEnvironment.getChromiunVersion(), this.MPY, this.MPZ)))
        {
          AppMethodBeat.o(217411);
          return false;
        }
        if (((ggf()) || (!TextUtils.isEmpty(this.MQk))) && (!ni(this.MQk, ggd())))
        {
          Log.i("xweb.internal.ConfigDef", "not match runtimeabis, white abis is " + this.MQk + ", cur runtime abi is " + XWalkEnvironment.getRuntimeAbi());
          AppMethodBeat.o(217411);
          return false;
        }
        if ((!TextUtils.isEmpty(this.MQj)) && (!ni(this.MQj, XWalkEnvironment.getDeviceAbi())))
        {
          Log.i("xweb.internal.ConfigDef", "not match deviceAbis, white abis is " + this.MQj + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
          AppMethodBeat.o(217411);
          return false;
        }
        if ((!TextUtils.isEmpty(this.MQm)) && (ni(this.MQm, XWalkEnvironment.getRuntimeAbi())))
        {
          Log.i("xweb.internal.ConfigDef", " match blackRuntimeAbis, black abis is " + this.MQm + ", cur runtime abi is " + ggd());
          AppMethodBeat.o(217411);
          return false;
        }
        if ((!TextUtils.isEmpty(this.MQl)) && (ni(this.MQl, XWalkEnvironment.getDeviceAbi())))
        {
          Log.i("xweb.internal.ConfigDef", " match blackDeviceAbis, black abis is " + this.MQl + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
          AppMethodBeat.o(217411);
          return false;
        }
        i = XWalkEnvironment.getAppClientVersion();
        if ((i > 0) && (!aX(i, this.MQn, this.MQo)))
        {
          Log.i("xweb.internal.ConfigDef", " match AppClientVersion, failed cur client ver is ".concat(String.valueOf(i)));
          AppMethodBeat.o(217411);
          return false;
        }
        if ((!TextUtils.isEmpty(this.MQp)) && (!XWalkEnvironment.containsAppInfo(this.MQp)))
        {
          Log.i("xweb.internal.ConfigDef", " match appInfoWhiteList failed  ");
          AppMethodBeat.o(217411);
          return false;
        }
        if ((!TextUtils.isEmpty(this.MQq)) && (XWalkEnvironment.containsAppInfo(this.MQq)))
        {
          Log.i("xweb.internal.ConfigDef", " match appInfoBlackList failed  ");
          AppMethodBeat.o(217411);
          return false;
        }
        AppMethodBeat.o(217411);
        return true;
      }
    }
    AppMethodBeat.o(217411);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.a.b
 * JD-Core Version:    0.7.0.1
 */