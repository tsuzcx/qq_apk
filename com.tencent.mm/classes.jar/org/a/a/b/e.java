package org.a.a.b;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class e
{
  public static final String LINE_SEPARATOR;
  public static final String bbK;
  public static final String soX;
  public static final String soY;
  public static final String wxi;
  public static final String xsO;
  public static final String xsP;
  public static final String xsQ;
  public static final String xsR;
  public static final String xsS;
  public static final String xsT;
  public static final String xsU;
  public static final String xsV;
  public static final String xsW;
  public static final String xsX;
  public static final String xsY;
  public static final String xsZ;
  public static final float xtA;
  public static final int xtB;
  public static final boolean xtC;
  public static final boolean xtD;
  public static final boolean xtE;
  public static final boolean xtF;
  public static final boolean xtG;
  public static final boolean xtH;
  public static final boolean xtI;
  public static final boolean xtJ;
  public static final boolean xtK;
  public static final boolean xtL;
  public static final boolean xtM;
  public static final boolean xtN;
  public static final boolean xtO;
  public static final boolean xtP;
  public static final boolean xtQ;
  public static final boolean xtR;
  public static final boolean xtS;
  public static final boolean xtT;
  public static final boolean xtU;
  public static final boolean xtV;
  public static final boolean xtW;
  public static final boolean xtX;
  public static final boolean xtY;
  public static final boolean xtZ;
  public static final String xta;
  public static final String xtb;
  public static final String xtc;
  public static final String xtd;
  public static final String xte;
  public static final String xtf;
  public static final String xtg;
  public static final String xth;
  public static final String xti;
  public static final String xtj;
  public static final String xtk;
  public static final String xtl;
  public static final String xtm;
  public static final String xtn;
  public static final String xto;
  public static final String xtp;
  public static final String xtq;
  public static final String xtr;
  public static final String xts;
  public static final String xtt;
  public static final String xtu;
  public static final String xtv;
  public static final String xtw;
  public static final String xtx;
  public static final String xty;
  public static final String xtz;
  public static final boolean xua;
  public static final boolean xub;
  
  static
  {
    boolean bool2 = false;
    xsO = aht("awt.toolkit");
    xsP = aht("file.encoding");
    wxi = aht("file.separator");
    xsQ = aht("java.awt.fonts");
    xsR = aht("java.awt.graphicsenv");
    xsS = aht("java.awt.headless");
    xsT = aht("java.awt.printerjob");
    xsU = aht("java.class.path");
    xsV = aht("java.class.version");
    xsW = aht("java.compiler");
    xsX = aht("java.endorsed.dirs");
    xsY = aht("java.ext.dirs");
    xsZ = aht("java.home");
    xta = aht("java.io.tmpdir");
    xtb = aht("java.library.path");
    xtc = aht("java.runtime.name");
    xtd = aht("java.runtime.version");
    xte = aht("java.specification.name");
    xtf = aht("java.specification.vendor");
    xtg = aht("java.specification.version");
    xth = aht("java.util.prefs.PreferencesFactory");
    xti = aht("java.vendor");
    xtj = aht("java.vendor.url");
    xtk = aht("java.version");
    xtl = aht("java.vm.info");
    xtm = aht("java.vm.name");
    xtn = aht("java.vm.specification.name");
    xto = aht("java.vm.specification.vendor");
    xtp = aht("java.vm.specification.version");
    xtq = aht("java.vm.vendor");
    xtr = aht("java.vm.version");
    LINE_SEPARATOR = aht("line.separator");
    xts = aht("os.arch");
    soX = aht("os.name");
    soY = aht("os.version");
    xtt = aht("path.separator");
    int i;
    if (aht("user.country") == null)
    {
      localObject = aht("user.region");
      xtu = (String)localObject;
      xtv = aht("user.dir");
      xtw = aht("user.home");
      xtx = aht("user.language");
      bbK = aht("user.name");
      xty = aht("user.timezone");
      if (xtk == null) {
        break label764;
      }
      i = 0;
      label359:
      if (i >= xtk.length()) {
        break label764;
      }
      j = xtk.charAt(i);
      if ((j < 48) || (j > 57)) {
        break label757;
      }
    }
    boolean bool1;
    label544:
    label757:
    label764:
    for (Object localObject = xtk.substring(i);; localObject = null)
    {
      xtz = (String)localObject;
      xtA = B(ahu(xtk));
      localObject = ahu(xtk);
      if (localObject != null) {
        break label770;
      }
      j = 0;
      xtB = j;
      xtC = ahr("1.1");
      xtD = ahr("1.2");
      xtE = ahr("1.3");
      xtF = ahr("1.4");
      xtG = ahr("1.5");
      xtH = ahr("1.6");
      xtI = ahr("1.7");
      xtJ = ahs("AIX");
      xtK = ahs("HP-UX");
      xtL = ahs("Irix");
      if ((!ahs("Linux")) && (!ahs("LINUX"))) {
        break label820;
      }
      bool1 = true;
      xtM = bool1;
      xtN = ahs("Mac");
      xtO = ahs("Mac OS X");
      xtP = ahs("OS/2");
      xtQ = ahs("Solaris");
      xtR = ahs("SunOS");
      if ((!xtJ) && (!xtK) && (!xtL) && (!xtM) && (!xtO) && (!xtQ))
      {
        bool1 = bool2;
        if (!xtR) {}
      }
      else
      {
        bool1 = true;
      }
      xtS = bool1;
      xtT = ahs("Windows");
      xtU = gZ("Windows", "5.0");
      xtV = gZ("Windows 9", "4.0");
      xtW = gZ("Windows 9", "4.1");
      xtX = gZ("Windows", "4.9");
      xtY = ahs("Windows NT");
      xtZ = gZ("Windows", "5.1");
      xua = gZ("Windows", "6.0");
      xub = gZ("Windows", "6.1");
      return;
      localObject = aht("user.country");
      break;
      i += 1;
      break label359;
    }
    label770:
    int k = localObject.length;
    if (k > 0) {}
    for (int j = localObject[0] * 100;; j = 0)
    {
      i = j;
      if (k >= 2) {
        i = j + localObject[1] * 10;
      }
      j = i;
      if (k < 3) {
        break;
      }
      j = i + localObject[2];
      break;
      label820:
      bool1 = false;
      break label544;
    }
  }
  
  private static float B(int[] paramArrayOfInt)
  {
    int i = 1;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return 0.0F;
    }
    if (paramArrayOfInt.length == 1) {
      return paramArrayOfInt[0];
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramArrayOfInt[0]);
    localStringBuffer.append('.');
    while (i < paramArrayOfInt.length)
    {
      localStringBuffer.append(paramArrayOfInt[i]);
      i += 1;
    }
    try
    {
      float f = Float.parseFloat(localStringBuffer.toString());
      return f;
    }
    catch (Exception paramArrayOfInt) {}
    return 0.0F;
  }
  
  private static boolean ahr(String paramString)
  {
    String str = xtz;
    if (str == null) {
      return false;
    }
    return str.startsWith(paramString);
  }
  
  private static boolean ahs(String paramString)
  {
    String str = soX;
    if (str == null) {
      return false;
    }
    return str.startsWith(paramString);
  }
  
  private static String aht(String paramString)
  {
    try
    {
      String str = System.getProperty(paramString);
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      System.err.println("Caught a SecurityException reading the system property '" + paramString + "'; the SystemUtils property value will default to null.");
    }
    return null;
  }
  
  private static int[] ahu(String paramString)
  {
    if (paramString == null) {
      return a.aUJ;
    }
    if (paramString == null) {
      paramString = null;
    }
    Object localObject;
    int i;
    int j;
    int k;
    int m;
    int i1;
    for (;;)
    {
      localObject = new int[Math.min(3, paramString.length)];
      i = 0;
      for (j = 0; (i < paramString.length) && (j < 3); j = k)
      {
        String str = paramString[i];
        k = j;
        if (str.length() > 0) {}
        try
        {
          localObject[j] = Integer.parseInt(str);
          k = j + 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int n;
            int i2;
            k = j;
          }
        }
        i += 1;
      }
      n = paramString.length();
      if (n == 0)
      {
        paramString = a.EMPTY_STRING_ARRAY;
      }
      else
      {
        localObject = new ArrayList();
        if ("._- ".length() != 1) {
          break label424;
        }
        i2 = "._- ".charAt(0);
        j = 0;
        k = 0;
        i = 0;
        m = 1;
        while (i < n) {
          if (paramString.charAt(i) == i2)
          {
            if (j == 0) {
              break label409;
            }
            i1 = m + 1;
            j = i;
            if (m == -1) {
              j = n;
            }
            ((List)localObject).add(paramString.substring(k, j));
            k = 0;
            i = i1;
            m = j;
            j = m + 1;
            i1 = j;
            m = i;
            i = j;
            j = k;
            k = i1;
          }
          else
          {
            i += 1;
            j = 1;
          }
        }
        label220:
        if (j != 0) {
          ((List)localObject).add(paramString.substring(k, i));
        }
        paramString = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
      }
    }
    for (;;)
    {
      if (i < n)
      {
        if ("._- ".indexOf(paramString.charAt(i)) >= 0)
        {
          if (j == 0) {
            break label389;
          }
          i1 = k + 1;
          j = i;
          if (k == -1) {
            j = n;
          }
          ((List)localObject).add(paramString.substring(m, j));
          k = 0;
          i = i1;
          m = j;
        }
        for (;;)
        {
          j = m + 1;
          m = j;
          i1 = i;
          i = j;
          j = k;
          k = i1;
          break;
          i += 1;
          j = 1;
          break;
          if (localObject.length > j)
          {
            paramString = new int[j];
            System.arraycopy(localObject, 0, paramString, 0, j);
            return paramString;
          }
          return localObject;
          label389:
          i1 = k;
          m = i;
          k = j;
          i = i1;
        }
      }
      k = m;
      break label220;
      label409:
      i1 = m;
      m = i;
      k = j;
      i = i1;
      break;
      label424:
      j = 0;
      m = 0;
      i = 0;
      k = 1;
    }
  }
  
  private static boolean gZ(String paramString1, String paramString2)
  {
    String str1 = soX;
    String str2 = soY;
    if ((str1 == null) || (str2 == null)) {}
    while ((!str1.startsWith(paramString1)) || (!str2.startsWith(paramString2))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.a.a.b.e
 * JD-Core Version:    0.7.0.1
 */