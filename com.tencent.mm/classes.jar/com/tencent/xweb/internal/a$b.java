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
  public String KCA = "";
  public String KCB = "";
  public int KCC = -1;
  public int KCD = -1;
  public int KCE = -1;
  public int KCF = -1;
  public String KCG = null;
  public String KCH = null;
  public String KCI = null;
  public String KCJ = null;
  public int KCK = -1;
  public int KCL = -1;
  public String KCM;
  public String KCN;
  public int KCl = -1;
  public int KCm = -1;
  public int KCn = -1;
  public int KCo = -1;
  public int KCp = -1;
  public int KCq = -1;
  public String KCr = "";
  public String KCs = "";
  public int KCt = -1;
  public int KCu = -1;
  public int KCv = -1;
  public int KCw = -1;
  public int KCx = -1;
  public double KCy = -1.0D;
  public double KCz = -1.0D;
  
  private static boolean G(double paramDouble)
  {
    return (paramDouble >= 0.0D) && (paramDouble < 24.0D);
  }
  
  private static boolean aV(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {}
    while ((paramInt2 > 0) && (paramInt1 < paramInt2)) {
      return false;
    }
    return true;
  }
  
  private static boolean aVe(String paramString)
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
    boolean bool = mF(paramString, (String)localObject2);
    AppMethodBeat.o(156954);
    return bool;
  }
  
  private boolean fKk()
  {
    AppMethodBeat.i(205083);
    if ((!G(this.KCy)) && (!G(this.KCz)))
    {
      AppMethodBeat.o(205083);
      return true;
    }
    double d = e.fKD();
    if ((this.KCz > 0.0D) && (d > this.KCz))
    {
      AppMethodBeat.o(205083);
      return false;
    }
    if ((this.KCy > 0.0D) && (d < this.KCy))
    {
      AppMethodBeat.o(205083);
      return false;
    }
    AppMethodBeat.o(205083);
    return true;
  }
  
  private static boolean mE(String paramString1, String paramString2)
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
  
  private static boolean mF(String paramString1, String paramString2)
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
  
  public String fKh()
  {
    AppMethodBeat.i(156951);
    String str = XWalkEnvironment.getRuntimeAbi();
    AppMethodBeat.o(156951);
    return str;
  }
  
  public final boolean fKi()
  {
    AppMethodBeat.i(156952);
    boolean bool = yZ(false);
    AppMethodBeat.o(156952);
    return bool;
  }
  
  protected boolean fKj()
  {
    return false;
  }
  
  public final boolean yZ(boolean paramBoolean)
  {
    AppMethodBeat.i(205082);
    int j = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int k = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
    int m = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
    int i;
    if ((paramBoolean) || (aV(XWalkEnvironment.getGrayValue(), this.KCt, this.KCu))) {
      i = 1;
    }
    while ((aV(j, this.KCn, this.KCo)) && (aV(200601, this.KCl, this.KCm)) && (aV(k, this.KCC, this.KCD)) && (aV(m, this.KCE, this.KCF)) && (aV(Build.VERSION.SDK_INT, this.KCp, this.KCq)) && (i != 0) && (!aVe(this.KCr)) && (!mF(this.KCA, XWalkEnvironment.getPackageName())) && (fKk())) {
      if ((this.KCx > 0) && (XWalkEnvironment.getUserType() != this.KCx))
      {
        AppMethodBeat.o(205082);
        return false;
        i = 0;
      }
      else
      {
        if ((this.KCs != null) && (this.KCs.trim() != null) && (!this.KCs.trim().isEmpty()) && (!aVe(this.KCs)))
        {
          AppMethodBeat.o(205082);
          return false;
        }
        if ((this.KCB != null) && (this.KCB.trim() != null) && (!this.KCB.trim().isEmpty()) && (!mF(this.KCB, XWalkEnvironment.getPackageName())))
        {
          AppMethodBeat.o(205082);
          return false;
        }
        if (((this.KCv > 0) || (this.KCw > 0)) && (!aV(XWalkEnvironment.getChromiunVersion(), this.KCv, this.KCw)))
        {
          AppMethodBeat.o(205082);
          return false;
        }
        if (((fKj()) || (!TextUtils.isEmpty(this.KCH))) && (!mE(this.KCH, fKh())))
        {
          Log.i("xweb.internal.ConfigDef", "not match runtimeabis, white abis is " + this.KCH + ", cur runtime abi is " + XWalkEnvironment.getRuntimeAbi());
          AppMethodBeat.o(205082);
          return false;
        }
        if ((!TextUtils.isEmpty(this.KCG)) && (!mE(this.KCG, XWalkEnvironment.getDeviceAbi())))
        {
          Log.i("xweb.internal.ConfigDef", "not match deviceAbis, white abis is " + this.KCG + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
          AppMethodBeat.o(205082);
          return false;
        }
        if ((!TextUtils.isEmpty(this.KCJ)) && (mE(this.KCJ, XWalkEnvironment.getRuntimeAbi())))
        {
          Log.i("xweb.internal.ConfigDef", " match blackRuntimeAbis, black abis is " + this.KCJ + ", cur runtime abi is " + fKh());
          AppMethodBeat.o(205082);
          return false;
        }
        if ((!TextUtils.isEmpty(this.KCI)) && (mE(this.KCI, XWalkEnvironment.getDeviceAbi())))
        {
          Log.i("xweb.internal.ConfigDef", " match blackDeviceAbis, black abis is " + this.KCI + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
          AppMethodBeat.o(205082);
          return false;
        }
        i = XWalkEnvironment.getAppClientVersion();
        if ((i > 0) && (!aV(i, this.KCK, this.KCL)))
        {
          Log.i("xweb.internal.ConfigDef", " match AppClientVersion, failed cur client ver is ".concat(String.valueOf(i)));
          AppMethodBeat.o(205082);
          return false;
        }
        if ((!TextUtils.isEmpty(this.KCM)) && (!XWalkEnvironment.containsAppInfo(this.KCM)))
        {
          Log.i("xweb.internal.ConfigDef", " match appInfoWhiteList failed  ");
          AppMethodBeat.o(205082);
          return false;
        }
        if ((!TextUtils.isEmpty(this.KCN)) && (XWalkEnvironment.containsAppInfo(this.KCN)))
        {
          Log.i("xweb.internal.ConfigDef", " match appInfoBlackList failed  ");
          AppMethodBeat.o(205082);
          return false;
        }
        AppMethodBeat.o(205082);
        return true;
      }
    }
    AppMethodBeat.o(205082);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.a.b
 * JD-Core Version:    0.7.0.1
 */