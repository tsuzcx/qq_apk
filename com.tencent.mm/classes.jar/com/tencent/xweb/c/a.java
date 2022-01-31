package com.tencent.xweb.c;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class a
{
  public static final class b
  {
    public String BGA = "";
    public String BGB = "";
    public int BGC = -1;
    public int BGD = -1;
    public int BGE = -1;
    public int BGF = -1;
    public String BGG = null;
    public String BGH = null;
    public String BGI = null;
    public String BGJ = null;
    public int BGn = -1;
    public int BGo = -1;
    public int BGp = -1;
    public int BGq = -1;
    public int BGr = -1;
    public int BGs = -1;
    public String BGt = "";
    public String BGu = "";
    public int BGv = -1;
    public int BGw = -1;
    public int BGx = -1;
    public int BGy = -1;
    public int BGz = -1;
    
    private static boolean aL(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {}
      while ((paramInt2 > 0) && (paramInt1 < paramInt2)) {
        return false;
      }
      return true;
    }
    
    private static boolean ayc(String paramString)
    {
      AppMethodBeat.i(3969);
      String str1 = "";
      if (Build.BRAND != null) {
        str1 = "" + Build.BRAND;
      }
      String str2 = str1;
      if (Build.MODEL != null) {
        str2 = str1 + " " + Build.MODEL;
      }
      if ((paramString == null) || (str2 == null) || (paramString.isEmpty()))
      {
        AppMethodBeat.o(3969);
        return false;
      }
      boolean bool = jc(paramString, str2);
      AppMethodBeat.o(3969);
      return bool;
    }
    
    private static boolean jb(String paramString1, String paramString2)
    {
      AppMethodBeat.i(155570);
      if (paramString1 == null)
      {
        AppMethodBeat.o(155570);
        return false;
      }
      paramString1 = paramString1.split("|");
      if ((paramString1 == null) || (paramString1.length < 0))
      {
        AppMethodBeat.o(155570);
        return false;
      }
      if (TextUtils.isEmpty(paramString2))
      {
        AppMethodBeat.o(155570);
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
          AppMethodBeat.o(155570);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(155570);
      return false;
    }
    
    private static boolean jc(String paramString1, String paramString2)
    {
      boolean bool1 = false;
      AppMethodBeat.i(3970);
      if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString1.trim() == null) || (paramString1.trim().isEmpty()))
      {
        AppMethodBeat.o(3970);
        return false;
      }
      if ((paramString2 == null) || (paramString2.isEmpty()))
      {
        AppMethodBeat.o(3970);
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
      AppMethodBeat.o(3970);
      return bool1;
    }
    
    public final boolean dYM()
    {
      AppMethodBeat.i(3968);
      int i = XWalkEnvironment.getInstalledNewstVersion();
      int j = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
      int k = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
      if ((aL(i, this.BGp, this.BGq)) && (aL(190503, this.BGn, this.BGo)) && (aL(j, this.BGC, this.BGD)) && (aL(k, this.BGE, this.BGF)) && (aL(Build.VERSION.SDK_INT, this.BGr, this.BGs)) && (aL(XWalkEnvironment.getGrayValue(), this.BGv, this.BGw)) && (!ayc(this.BGt)) && (!jc(this.BGA, XWalkEnvironment.getPackageName())))
      {
        if ((this.BGz > 0) && (XWalkEnvironment.getUserType() != this.BGz))
        {
          AppMethodBeat.o(3968);
          return false;
        }
        if ((this.BGu != null) && (this.BGu.trim() != null) && (!this.BGu.trim().isEmpty()) && (!ayc(this.BGu)))
        {
          AppMethodBeat.o(3968);
          return false;
        }
        if ((this.BGB != null) && (this.BGB.trim() != null) && (!this.BGB.trim().isEmpty()) && (!jc(this.BGB, XWalkEnvironment.getPackageName())))
        {
          AppMethodBeat.o(3968);
          return false;
        }
        if (((this.BGx > 0) || (this.BGy > 0)) && (!aL(XWalkEnvironment.getChromiunVersion(), this.BGx, this.BGy)))
        {
          AppMethodBeat.o(3968);
          return false;
        }
        if ((!TextUtils.isEmpty(this.BGH)) && (!jb(this.BGH, XWalkEnvironment.getRuntimeAbi())))
        {
          Log.i("xweb.internal.ConfigDef", "not match runtimeabis, white abis is " + this.BGH + ", cur runtime abi is " + XWalkEnvironment.getRuntimeAbi());
          AppMethodBeat.o(3968);
          return false;
        }
        if ((!TextUtils.isEmpty(this.BGG)) && (!jb(this.BGG, XWalkEnvironment.getDeviceAbi())))
        {
          Log.i("xweb.internal.ConfigDef", "not match deviceAbis, white abis is " + this.BGG + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
          AppMethodBeat.o(3968);
          return false;
        }
        if ((!TextUtils.isEmpty(this.BGJ)) && (jb(this.BGJ, XWalkEnvironment.getRuntimeAbi())))
        {
          Log.i("xweb.internal.ConfigDef", " match blackRuntimeAbis, black abis is " + this.BGJ + ", cur runtime abi is " + XWalkEnvironment.getRuntimeAbi());
          AppMethodBeat.o(3968);
          return false;
        }
        if ((!TextUtils.isEmpty(this.BGI)) && (jb(this.BGI, XWalkEnvironment.getDeviceAbi())))
        {
          Log.i("xweb.internal.ConfigDef", " match blackDeviceAbis, black abis is " + this.BGI + ", cur device abi is " + XWalkEnvironment.getDeviceAbi());
          AppMethodBeat.o(3968);
          return false;
        }
        AppMethodBeat.o(3968);
        return true;
      }
      AppMethodBeat.o(3968);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.c.a
 * JD-Core Version:    0.7.0.1
 */