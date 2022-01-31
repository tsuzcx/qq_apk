package com.tencent.xweb.c;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xwalk.core.XWalkEnvironment;

public final class a
{
  public static final class b
  {
    public int xjb = -1;
    public int xjc = -1;
    public int xjd = -1;
    public int xje = -1;
    public int xjf = -1;
    public int xjg = -1;
    public String xjh = "";
    public String xji = "";
    public int xjj = -1;
    public int xjk = -1;
    public int xjl = -1;
    public int xjm = -1;
    
    private static boolean agW(String paramString)
    {
      String str1 = "";
      if (Build.BRAND != null) {
        str1 = "" + Build.BRAND;
      }
      String str2 = str1;
      if (Build.MODEL != null) {
        str2 = str1 + " " + Build.MODEL;
      }
      if ((paramString == null) || (str2 == null) || (paramString.isEmpty())) {
        return false;
      }
      try
      {
        boolean bool = Pattern.compile(paramString).matcher(str2.toUpperCase()).find();
        return bool;
      }
      catch (Exception paramString)
      {
        XWalkEnvironment.addXWalkInitializeLog("ConfigDef", "compile strRex failed");
      }
      return false;
    }
    
    private static boolean az(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {}
      while ((paramInt2 > 0) && (paramInt1 < paramInt2)) {
        return false;
      }
      return true;
    }
    
    public final boolean cSF()
    {
      if ((!az(XWalkEnvironment.getAvailableVersion(), this.xjd, this.xje)) || (!az(180801, this.xjb, this.xjc)) || (!az(Build.VERSION.SDK_INT, this.xjf, this.xjg)) || (!az(XWalkEnvironment.getGrayValue(), this.xjj, this.xjk)) || (agW(this.xjh)) || ((this.xji != null) && (this.xji.trim() != null) && (!this.xji.trim().isEmpty()) && (!agW(this.xji)))) {}
      while (((this.xjl > 0) || (this.xjm > 0)) && (!az(XWalkEnvironment.getChromiunVersion(), this.xjl, this.xjm))) {
        return false;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.c.a
 * JD-Core Version:    0.7.0.1
 */