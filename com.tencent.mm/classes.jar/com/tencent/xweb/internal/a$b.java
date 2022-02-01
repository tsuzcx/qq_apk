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
  public int MsG = -1;
  public int MsH = -1;
  public int MsI = -1;
  public int MsJ = -1;
  public int MsK = -1;
  public int MsL = -1;
  public int MsM = -1;
  public int MsN = -1;
  public String MsO = "";
  public String MsP = "";
  public int MsQ = -1;
  public int MsR = -1;
  public int MsS = -1;
  public int MsT = -1;
  public int MsU = -1;
  public int MsV = -1;
  public int MsW = -1;
  public double MsX = -1.0D;
  public double MsY = -1.0D;
  public String MsZ = "";
  public String Mta = "";
  public int Mtb = -1;
  public int Mtc = -1;
  public int Mtd = -1;
  public int Mte = -1;
  public String Mtf = null;
  public String Mtg = null;
  public String Mth = null;
  public String Mti = null;
  public int Mtj = -1;
  public int Mtk = -1;
  public String Mtl;
  public String Mtm;
  
  private static boolean H(double paramDouble)
  {
    return (paramDouble >= 0.0D) && (paramDouble < 24.0D);
  }
  
  private static boolean aW(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {}
    while ((paramInt2 > 0) && (paramInt1 < paramInt2)) {
      return false;
    }
    return true;
  }
  
  private static boolean bbh(String paramString)
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
    boolean bool = nd(paramString, (String)localObject2);
    AppMethodBeat.o(156954);
    return bool;
  }
  
  private boolean gbE()
  {
    AppMethodBeat.i(197094);
    if ((!H(this.MsX)) && (!H(this.MsY)))
    {
      AppMethodBeat.o(197094);
      return true;
    }
    double d = e.gbY();
    if ((this.MsY > 0.0D) && (d > this.MsY))
    {
      AppMethodBeat.o(197094);
      return false;
    }
    if ((this.MsX > 0.0D) && (d < this.MsX))
    {
      AppMethodBeat.o(197094);
      return false;
    }
    AppMethodBeat.o(197094);
    return true;
  }
  
  private static boolean nc(String paramString1, String paramString2)
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
  
  private static boolean nd(String paramString1, String paramString2)
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
  
  public String gbB()
  {
    AppMethodBeat.i(156951);
    String str = XWalkEnvironment.getRuntimeAbi();
    AppMethodBeat.o(156951);
    return str;
  }
  
  public final boolean gbC()
  {
    AppMethodBeat.i(156952);
    boolean bool = zM(false);
    AppMethodBeat.o(156952);
    return bool;
  }
  
  protected boolean gbD()
  {
    return false;
  }
  
  public final boolean zM(boolean paramBoolean)
  {
    AppMethodBeat.i(197093);
    int j = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int k = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
    int m = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
    int n = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
    int i;
    if ((paramBoolean) || (aW(XWalkEnvironment.getGrayValue(), this.MsQ, this.MsR))) {
      i = 1;
    }
    while ((aW(j, this.MsI, this.MsJ)) && (aW(k, this.MsK, this.MsL)) && (aW(200801, this.MsG, this.MsH)) && (aW(m, this.Mtb, this.Mtc)) && (aW(n, this.Mtd, this.Mte)) && (aW(Build.VERSION.SDK_INT, this.MsM, this.MsN)) && (i != 0) && (aW(XWalkEnvironment.getTodayGrayValue(), this.MsS, this.MsT)) && (!bbh(this.MsO)) && (!nd(this.MsZ, XWalkEnvironment.getPackageName())) && (gbE())) {
      if ((this.MsW > 0) && (XWalkEnvironment.getUserType() != this.MsW))
      {
        AppMethodBeat.o(197093);
        return false;
        i = 0;
      }
      else
      {
        if ((this.MsP != null) && (this.MsP.trim() != null) && (!this.MsP.trim().isEmpty()) && (!bbh(this.MsP)))
        {
          AppMethodBeat.o(197093);
          return false;
        }
        if ((this.Mta != null) && (this.Mta.trim() != null) && (!this.Mta.trim().isEmpty()) && (!nd(this.Mta, XWalkEnvironment.getPackageName())))
        {
          AppMethodBeat.o(197093);
          return false;
        }
        if (((this.MsU > 0) || (this.MsV > 0)) && (!aW(XWalkEnvironment.getChromiunVersion(), this.MsU, this.MsV)))
        {
          AppMethodBeat.o(197093);
          return false;
        }
        if (((gbD()) || (!TextUtils.isEmpty(this.Mtg))) && (!nc(this.Mtg, gbB())))
        {
          Log.i("xweb.internal.ConfigDef", "not match runtimeabis, white abis is " + this.Mtg + ", cur runtime abi is " + XWalkEnvironment.getRuntimeAbi());
          AppMethodBeat.o(197093);
          return false;
        }
        if ((!TextUtils.isEmpty(this.Mtf)) && (!nc(this.Mtf, XWalkEnvironment.getDeviceAbi())))
        {
          Log.i("xweb.internal.ConfigDef", "not match deviceAbis, white abis is " + this.Mtf + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
          AppMethodBeat.o(197093);
          return false;
        }
        if ((!TextUtils.isEmpty(this.Mti)) && (nc(this.Mti, XWalkEnvironment.getRuntimeAbi())))
        {
          Log.i("xweb.internal.ConfigDef", " match blackRuntimeAbis, black abis is " + this.Mti + ", cur runtime abi is " + gbB());
          AppMethodBeat.o(197093);
          return false;
        }
        if ((!TextUtils.isEmpty(this.Mth)) && (nc(this.Mth, XWalkEnvironment.getDeviceAbi())))
        {
          Log.i("xweb.internal.ConfigDef", " match blackDeviceAbis, black abis is " + this.Mth + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
          AppMethodBeat.o(197093);
          return false;
        }
        i = XWalkEnvironment.getAppClientVersion();
        if ((i > 0) && (!aW(i, this.Mtj, this.Mtk)))
        {
          Log.i("xweb.internal.ConfigDef", " match AppClientVersion, failed cur client ver is ".concat(String.valueOf(i)));
          AppMethodBeat.o(197093);
          return false;
        }
        if ((!TextUtils.isEmpty(this.Mtl)) && (!XWalkEnvironment.containsAppInfo(this.Mtl)))
        {
          Log.i("xweb.internal.ConfigDef", " match appInfoWhiteList failed  ");
          AppMethodBeat.o(197093);
          return false;
        }
        if ((!TextUtils.isEmpty(this.Mtm)) && (XWalkEnvironment.containsAppInfo(this.Mtm)))
        {
          Log.i("xweb.internal.ConfigDef", " match appInfoBlackList failed  ");
          AppMethodBeat.o(197093);
          return false;
        }
        AppMethodBeat.o(197093);
        return true;
      }
    }
    AppMethodBeat.o(197093);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.a.b
 * JD-Core Version:    0.7.0.1
 */