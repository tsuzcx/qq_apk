package com.tencent.xweb.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
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
  public int aadS = -1;
  public int aadT = -1;
  public int aadU = -1;
  public int aadV = -1;
  public int aadW = -1;
  public int aadX = -1;
  public int aadY = -1;
  public int aadZ = -1;
  public String aaeA;
  public int aaea = -1;
  public int aaeb = -1;
  public String aaec = "";
  public String aaed = "";
  public int aaee = -1;
  public int aaef = -1;
  public int aaeg = -1;
  public int aaeh = -1;
  public int aaei = -1;
  public int aaej = -1;
  public int aaek = -1;
  public double aael = -1.0D;
  public double aaem = -1.0D;
  public String aaen = "";
  public String aaeo = "";
  public int aaep = -1;
  public int aaeq = -1;
  public int aaer = -1;
  public int aaes = -1;
  public String aaet = null;
  public String aaeu = null;
  public String aaev = null;
  public String aaew = null;
  public int aaex = -1;
  public int aaey = -1;
  public String aaez;
  
  private static boolean I(double paramDouble)
  {
    return (paramDouble >= 0.0D) && (paramDouble < 24.0D);
  }
  
  private static boolean bFt(String paramString)
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
    boolean bool = pa(paramString, (String)localObject2);
    AppMethodBeat.o(156954);
    return bool;
  }
  
  private static boolean bi(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {}
    while ((paramInt2 > 0) && (paramInt1 < paramInt2)) {
      return false;
    }
    return true;
  }
  
  private boolean ixh()
  {
    AppMethodBeat.i(197567);
    if ((!I(this.aael)) && (!I(this.aaem)))
    {
      AppMethodBeat.o(197567);
      return true;
    }
    double d = e.ixB();
    if ((this.aaem > 0.0D) && (d > this.aaem))
    {
      AppMethodBeat.o(197567);
      return false;
    }
    if ((this.aael > 0.0D) && (d < this.aael))
    {
      AppMethodBeat.o(197567);
      return false;
    }
    AppMethodBeat.o(197567);
    return true;
  }
  
  private static boolean oZ(String paramString1, String paramString2)
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
  
  private static boolean pa(String paramString1, String paramString2)
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
  
  public final boolean IS(boolean paramBoolean)
  {
    AppMethodBeat.i(197561);
    int k = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int m = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
    int n = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
    int i1 = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
    if (XWalkEnvironment.getApplicationContext().getApplicationInfo() != null) {}
    for (int i = XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion;; i = 0)
    {
      int j;
      if ((paramBoolean) || (bi(XWalkEnvironment.getGrayValue(), this.aaee, this.aaef))) {
        j = 1;
      }
      while ((bi(k, this.aadU, this.aadV)) && (bi(m, this.aadW, this.aadX)) && (bi(20210601, this.aadS, this.aadT)) && (bi(n, this.aaep, this.aaeq)) && (bi(i1, this.aaer, this.aaes)) && (bi(Build.VERSION.SDK_INT, this.aadY, this.aadZ)) && (bi(i, this.aaea, this.aaeb)) && (j != 0) && (bi(XWalkEnvironment.getTodayGrayValue(), this.aaeg, this.aaeh)) && (!bFt(this.aaec)) && (!pa(this.aaen, XWalkEnvironment.getPackageName())) && (ixh())) {
        if ((this.aaek > 0) && (XWalkEnvironment.getUserType() != this.aaek))
        {
          AppMethodBeat.o(197561);
          return false;
          j = 0;
        }
        else
        {
          if ((this.aaed != null) && (this.aaed.trim() != null) && (!this.aaed.trim().isEmpty()) && (!bFt(this.aaed)))
          {
            AppMethodBeat.o(197561);
            return false;
          }
          if ((this.aaeo != null) && (this.aaeo.trim() != null) && (!this.aaeo.trim().isEmpty()) && (!pa(this.aaeo, XWalkEnvironment.getPackageName())))
          {
            AppMethodBeat.o(197561);
            return false;
          }
          if (((this.aaei > 0) || (this.aaej > 0)) && (!bi(XWalkEnvironment.getChromiunVersion(), this.aaei, this.aaej)))
          {
            AppMethodBeat.o(197561);
            return false;
          }
          if (((ixg()) || (!TextUtils.isEmpty(this.aaeu))) && (!oZ(this.aaeu, ixe())))
          {
            Log.i("xweb.internal.ConfigDef", "not match runtimeabis, white abis is " + this.aaeu + ", cur runtime abi is " + XWalkEnvironment.getRuntimeAbi());
            AppMethodBeat.o(197561);
            return false;
          }
          if ((!TextUtils.isEmpty(this.aaet)) && (!oZ(this.aaet, XWalkEnvironment.getDeviceAbi())))
          {
            Log.i("xweb.internal.ConfigDef", "not match deviceAbis, white abis is " + this.aaet + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
            AppMethodBeat.o(197561);
            return false;
          }
          if ((!TextUtils.isEmpty(this.aaew)) && (oZ(this.aaew, XWalkEnvironment.getRuntimeAbi())))
          {
            Log.i("xweb.internal.ConfigDef", " match blackRuntimeAbis, black abis is " + this.aaew + ", cur runtime abi is " + ixe());
            AppMethodBeat.o(197561);
            return false;
          }
          if ((!TextUtils.isEmpty(this.aaev)) && (oZ(this.aaev, XWalkEnvironment.getDeviceAbi())))
          {
            Log.i("xweb.internal.ConfigDef", " match blackDeviceAbis, black abis is " + this.aaev + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
            AppMethodBeat.o(197561);
            return false;
          }
          i = XWalkEnvironment.getAppClientVersion();
          if ((i > 0) && (!bi(i, this.aaex, this.aaey)))
          {
            Log.i("xweb.internal.ConfigDef", " match AppClientVersion, failed cur client ver is ".concat(String.valueOf(i)));
            AppMethodBeat.o(197561);
            return false;
          }
          if ((!TextUtils.isEmpty(this.aaez)) && (!XWalkEnvironment.containsAppInfo(this.aaez)))
          {
            Log.i("xweb.internal.ConfigDef", " match appInfoWhiteList failed  ");
            AppMethodBeat.o(197561);
            return false;
          }
          if ((!TextUtils.isEmpty(this.aaeA)) && (XWalkEnvironment.containsAppInfo(this.aaeA)))
          {
            Log.i("xweb.internal.ConfigDef", " match appInfoBlackList failed  ");
            AppMethodBeat.o(197561);
            return false;
          }
          AppMethodBeat.o(197561);
          return true;
        }
      }
      AppMethodBeat.o(197561);
      return false;
    }
  }
  
  public String ixe()
  {
    AppMethodBeat.i(156951);
    String str = XWalkEnvironment.getRuntimeAbi();
    AppMethodBeat.o(156951);
    return str;
  }
  
  public final boolean ixf()
  {
    AppMethodBeat.i(156952);
    boolean bool = IS(false);
    AppMethodBeat.o(156952);
    return bool;
  }
  
  protected boolean ixg()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.a.b
 * JD-Core Version:    0.7.0.1
 */