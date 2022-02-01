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
  public int IPQ = -1;
  public int IPR = -1;
  public int IPS = -1;
  public int IPT = -1;
  public int IPU = -1;
  public int IPV = -1;
  public String IPW = "";
  public String IPX = "";
  public int IPY = -1;
  public int IPZ = -1;
  public int IQa = -1;
  public int IQb = -1;
  public int IQc = -1;
  public double IQd = -1.0D;
  public double IQe = -1.0D;
  public String IQf = "";
  public String IQg = "";
  public int IQh = -1;
  public int IQi = -1;
  public int IQj = -1;
  public int IQk = -1;
  public String IQl = null;
  public String IQm = null;
  public String IQn = null;
  public String IQo = null;
  public int IQp = -1;
  public int IQq = -1;
  public String IQr;
  public String IQs;
  
  private static boolean H(double paramDouble)
  {
    return (paramDouble >= 0.0D) && (paramDouble < 24.0D);
  }
  
  private static boolean aPl(String paramString)
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
    boolean bool = me(paramString, (String)localObject2);
    AppMethodBeat.o(156954);
    return bool;
  }
  
  private static boolean aT(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {}
    while ((paramInt2 > 0) && (paramInt1 < paramInt2)) {
      return false;
    }
    return true;
  }
  
  private static boolean md(String paramString1, String paramString2)
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
  
  private static boolean me(String paramString1, String paramString2)
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
  
  public String frF()
  {
    AppMethodBeat.i(156951);
    String str = XWalkEnvironment.getRuntimeAbi();
    AppMethodBeat.o(156951);
    return str;
  }
  
  public final boolean frG()
  {
    AppMethodBeat.i(156952);
    int i = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int j = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
    int k = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
    if ((aT(i, this.IPS, this.IPT)) && (aT(200502, this.IPQ, this.IPR)) && (aT(j, this.IQh, this.IQi)) && (aT(k, this.IQj, this.IQk)) && (aT(Build.VERSION.SDK_INT, this.IPU, this.IPV)) && (aT(XWalkEnvironment.getGrayValue(), this.IPY, this.IPZ)) && (!aPl(this.IPW)) && (!me(this.IQf, XWalkEnvironment.getPackageName())))
    {
      double d;
      if ((H(this.IQd)) || (H(this.IQe)))
      {
        d = e.fsa();
        if ((this.IQe > 0.0D) && (d > this.IQe)) {
          i = 0;
        }
      }
      while (i != 0) {
        if ((this.IQc > 0) && (XWalkEnvironment.getUserType() != this.IQc))
        {
          AppMethodBeat.o(156952);
          return false;
          if ((this.IQd > 0.0D) && (d < this.IQd)) {
            i = 0;
          } else {
            i = 1;
          }
        }
        else
        {
          if ((this.IPX != null) && (this.IPX.trim() != null) && (!this.IPX.trim().isEmpty()) && (!aPl(this.IPX)))
          {
            AppMethodBeat.o(156952);
            return false;
          }
          if ((this.IQg != null) && (this.IQg.trim() != null) && (!this.IQg.trim().isEmpty()) && (!me(this.IQg, XWalkEnvironment.getPackageName())))
          {
            AppMethodBeat.o(156952);
            return false;
          }
          if (((this.IQa > 0) || (this.IQb > 0)) && (!aT(XWalkEnvironment.getChromiunVersion(), this.IQa, this.IQb)))
          {
            AppMethodBeat.o(156952);
            return false;
          }
          if (((frH()) || (!TextUtils.isEmpty(this.IQm))) && (!md(this.IQm, frF())))
          {
            Log.i("xweb.internal.ConfigDef", "not match runtimeabis, white abis is " + this.IQm + ", cur runtime abi is " + XWalkEnvironment.getRuntimeAbi());
            AppMethodBeat.o(156952);
            return false;
          }
          if ((!TextUtils.isEmpty(this.IQl)) && (!md(this.IQl, XWalkEnvironment.getDeviceAbi())))
          {
            Log.i("xweb.internal.ConfigDef", "not match deviceAbis, white abis is " + this.IQl + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
            AppMethodBeat.o(156952);
            return false;
          }
          if ((!TextUtils.isEmpty(this.IQo)) && (md(this.IQo, XWalkEnvironment.getRuntimeAbi())))
          {
            Log.i("xweb.internal.ConfigDef", " match blackRuntimeAbis, black abis is " + this.IQo + ", cur runtime abi is " + frF());
            AppMethodBeat.o(156952);
            return false;
          }
          if ((!TextUtils.isEmpty(this.IQn)) && (md(this.IQn, XWalkEnvironment.getDeviceAbi())))
          {
            Log.i("xweb.internal.ConfigDef", " match blackDeviceAbis, black abis is " + this.IQn + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
            AppMethodBeat.o(156952);
            return false;
          }
          i = XWalkEnvironment.getAppClientVersion();
          if ((i > 0) && (!aT(i, this.IQp, this.IQq)))
          {
            Log.i("xweb.internal.ConfigDef", " match AppClientVersion, failed cur client ver is ".concat(String.valueOf(i)));
            AppMethodBeat.o(156952);
            return false;
          }
          if ((!TextUtils.isEmpty(this.IQr)) && (!XWalkEnvironment.containsAppInfo(this.IQr)))
          {
            Log.i("xweb.internal.ConfigDef", " match appInfoWhiteList failed  ");
            AppMethodBeat.o(156952);
            return false;
          }
          if ((!TextUtils.isEmpty(this.IQs)) && (XWalkEnvironment.containsAppInfo(this.IQs)))
          {
            Log.i("xweb.internal.ConfigDef", " match appInfoBlackList failed  ");
            AppMethodBeat.o(156952);
            return false;
          }
          AppMethodBeat.o(156952);
          return true;
        }
      }
    }
    AppMethodBeat.o(156952);
    return false;
  }
  
  protected boolean frH()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.a.b
 * JD-Core Version:    0.7.0.1
 */