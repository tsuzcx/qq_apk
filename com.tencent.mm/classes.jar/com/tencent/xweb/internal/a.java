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

public final class a
{
  public static final class a
  {
    public a.b SCE;
    public String SCF;
    public String SCG;
    public String SCH;
    
    public a()
    {
      AppMethodBeat.i(156950);
      this.SCE = new a.b();
      AppMethodBeat.o(156950);
    }
  }
  
  public static class b
  {
    public int SCI = -1;
    public int SCJ = -1;
    public int SCK = -1;
    public int SCL = -1;
    public int SCM = -1;
    public int SCN = -1;
    public int SCO = -1;
    public int SCP = -1;
    public int SCQ = -1;
    public int SCR = -1;
    public String SCS = "";
    public String SCT = "";
    public int SCU = -1;
    public int SCV = -1;
    public int SCW = -1;
    public int SCX = -1;
    public int SCY = -1;
    public int SCZ = -1;
    public int SDa = -1;
    public double SDb = -1.0D;
    public double SDc = -1.0D;
    public String SDd = "";
    public String SDe = "";
    public int SDf = -1;
    public int SDg = -1;
    public int SDh = -1;
    public int SDi = -1;
    public String SDj = null;
    public String SDk = null;
    public String SDl = null;
    public String SDm = null;
    public int SDn = -1;
    public int SDo = -1;
    public String SDp;
    public String SDq;
    
    private static boolean G(double paramDouble)
    {
      return (paramDouble >= 0.0D) && (paramDouble < 24.0D);
    }
    
    private static boolean bd(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {}
      while ((paramInt2 > 0) && (paramInt1 < paramInt2)) {
        return false;
      }
      return true;
    }
    
    private static boolean bsu(String paramString)
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
      boolean bool = oe(paramString, (String)localObject2);
      AppMethodBeat.o(156954);
      return bool;
    }
    
    private boolean hty()
    {
      AppMethodBeat.i(219066);
      if ((!G(this.SDb)) && (!G(this.SDc)))
      {
        AppMethodBeat.o(219066);
        return true;
      }
      double d = e.htS();
      if ((this.SDc > 0.0D) && (d > this.SDc))
      {
        AppMethodBeat.o(219066);
        return false;
      }
      if ((this.SDb > 0.0D) && (d < this.SDb))
      {
        AppMethodBeat.o(219066);
        return false;
      }
      AppMethodBeat.o(219066);
      return true;
    }
    
    private static boolean od(String paramString1, String paramString2)
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
    
    private static boolean oe(String paramString1, String paramString2)
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
    
    public final boolean Ep(boolean paramBoolean)
    {
      AppMethodBeat.i(219065);
      int k = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
      int m = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
      int n = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
      int i1 = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
      if (XWalkEnvironment.getApplicationContext().getApplicationInfo() != null) {}
      for (int i = XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion;; i = 0)
      {
        int j;
        if ((paramBoolean) || (bd(XWalkEnvironment.getGrayValue(), this.SCU, this.SCV))) {
          j = 1;
        }
        while ((bd(k, this.SCK, this.SCL)) && (bd(m, this.SCM, this.SCN)) && (bd(201201, this.SCI, this.SCJ)) && (bd(n, this.SDf, this.SDg)) && (bd(i1, this.SDh, this.SDi)) && (bd(Build.VERSION.SDK_INT, this.SCO, this.SCP)) && (bd(i, this.SCQ, this.SCR)) && (j != 0) && (bd(XWalkEnvironment.getTodayGrayValue(), this.SCW, this.SCX)) && (!bsu(this.SCS)) && (!oe(this.SDd, XWalkEnvironment.getPackageName())) && (hty())) {
          if ((this.SDa > 0) && (XWalkEnvironment.getUserType() != this.SDa))
          {
            AppMethodBeat.o(219065);
            return false;
            j = 0;
          }
          else
          {
            if ((this.SCT != null) && (this.SCT.trim() != null) && (!this.SCT.trim().isEmpty()) && (!bsu(this.SCT)))
            {
              AppMethodBeat.o(219065);
              return false;
            }
            if ((this.SDe != null) && (this.SDe.trim() != null) && (!this.SDe.trim().isEmpty()) && (!oe(this.SDe, XWalkEnvironment.getPackageName())))
            {
              AppMethodBeat.o(219065);
              return false;
            }
            if (((this.SCY > 0) || (this.SCZ > 0)) && (!bd(XWalkEnvironment.getChromiunVersion(), this.SCY, this.SCZ)))
            {
              AppMethodBeat.o(219065);
              return false;
            }
            if (((htx()) || (!TextUtils.isEmpty(this.SDk))) && (!od(this.SDk, htv())))
            {
              Log.i("xweb.internal.ConfigDef", "not match runtimeabis, white abis is " + this.SDk + ", cur runtime abi is " + XWalkEnvironment.getRuntimeAbi());
              AppMethodBeat.o(219065);
              return false;
            }
            if ((!TextUtils.isEmpty(this.SDj)) && (!od(this.SDj, XWalkEnvironment.getDeviceAbi())))
            {
              Log.i("xweb.internal.ConfigDef", "not match deviceAbis, white abis is " + this.SDj + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
              AppMethodBeat.o(219065);
              return false;
            }
            if ((!TextUtils.isEmpty(this.SDm)) && (od(this.SDm, XWalkEnvironment.getRuntimeAbi())))
            {
              Log.i("xweb.internal.ConfigDef", " match blackRuntimeAbis, black abis is " + this.SDm + ", cur runtime abi is " + htv());
              AppMethodBeat.o(219065);
              return false;
            }
            if ((!TextUtils.isEmpty(this.SDl)) && (od(this.SDl, XWalkEnvironment.getDeviceAbi())))
            {
              Log.i("xweb.internal.ConfigDef", " match blackDeviceAbis, black abis is " + this.SDl + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
              AppMethodBeat.o(219065);
              return false;
            }
            i = XWalkEnvironment.getAppClientVersion();
            if ((i > 0) && (!bd(i, this.SDn, this.SDo)))
            {
              Log.i("xweb.internal.ConfigDef", " match AppClientVersion, failed cur client ver is ".concat(String.valueOf(i)));
              AppMethodBeat.o(219065);
              return false;
            }
            if ((!TextUtils.isEmpty(this.SDp)) && (!XWalkEnvironment.containsAppInfo(this.SDp)))
            {
              Log.i("xweb.internal.ConfigDef", " match appInfoWhiteList failed  ");
              AppMethodBeat.o(219065);
              return false;
            }
            if ((!TextUtils.isEmpty(this.SDq)) && (XWalkEnvironment.containsAppInfo(this.SDq)))
            {
              Log.i("xweb.internal.ConfigDef", " match appInfoBlackList failed  ");
              AppMethodBeat.o(219065);
              return false;
            }
            AppMethodBeat.o(219065);
            return true;
          }
        }
        AppMethodBeat.o(219065);
        return false;
      }
    }
    
    public String htv()
    {
      AppMethodBeat.i(156951);
      String str = XWalkEnvironment.getRuntimeAbi();
      AppMethodBeat.o(156951);
      return str;
    }
    
    public final boolean htw()
    {
      AppMethodBeat.i(156952);
      boolean bool = Ep(false);
      AppMethodBeat.o(156952);
      return bool;
    }
    
    protected boolean htx()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.internal.a
 * JD-Core Version:    0.7.0.1
 */