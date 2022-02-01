package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public static final String DHZ;
  public static final String DIa;
  public static final String LQw;
  public static final String LYW;
  public static final String LYX;
  public static final String LYY;
  public static final String LYZ;
  public static final String LZA;
  public static final String LZB;
  public static final String LZC;
  public static final String LZD;
  public static final String LZE;
  public static final String LZF;
  public static final String LZG;
  public static final String LZH;
  public static final String LZI;
  public static final float LZJ;
  public static final int LZK;
  public static final boolean LZL;
  public static final boolean LZM;
  public static final boolean LZN;
  public static final boolean LZO;
  public static final boolean LZP;
  public static final boolean LZQ;
  public static final boolean LZR;
  public static final boolean LZS;
  public static final boolean LZT;
  public static final boolean LZU;
  public static final boolean LZV;
  public static final boolean LZW;
  public static final boolean LZX;
  public static final boolean LZY;
  public static final boolean LZZ;
  public static final String LZa;
  public static final String LZb;
  public static final String LZc;
  public static final String LZd;
  public static final String LZe;
  public static final String LZf;
  public static final String LZg;
  public static final String LZh;
  public static final String LZi;
  public static final String LZj;
  public static final String LZk;
  public static final String LZl;
  public static final String LZm;
  public static final String LZn;
  public static final String LZo;
  public static final String LZp;
  public static final String LZq;
  public static final String LZr;
  public static final String LZs;
  public static final String LZt;
  public static final String LZu;
  public static final String LZv;
  public static final String LZw;
  public static final String LZx;
  public static final String LZy;
  public static final String LZz;
  public static final boolean Maa;
  public static final boolean Mab;
  public static final boolean Mac;
  public static final boolean Mad;
  public static final boolean Mae;
  public static final boolean Maf;
  public static final boolean Mag;
  public static final boolean Mah;
  public static final boolean Mai;
  public static final boolean Maj;
  public static final boolean Mak;
  public static final String bSt;
  
  static
  {
    boolean bool2 = false;
    AppMethodBeat.i(40756);
    LYW = getSystemProperty("awt.toolkit");
    LYX = getSystemProperty("file.encoding");
    LYY = getSystemProperty("file.separator");
    LYZ = getSystemProperty("java.awt.fonts");
    LZa = getSystemProperty("java.awt.graphicsenv");
    LZb = getSystemProperty("java.awt.headless");
    LZc = getSystemProperty("java.awt.printerjob");
    LZd = getSystemProperty("java.class.path");
    LZe = getSystemProperty("java.class.version");
    LZf = getSystemProperty("java.compiler");
    LZg = getSystemProperty("java.endorsed.dirs");
    LZh = getSystemProperty("java.ext.dirs");
    LZi = getSystemProperty("java.home");
    LZj = getSystemProperty("java.io.tmpdir");
    LZk = getSystemProperty("java.library.path");
    LZl = getSystemProperty("java.runtime.name");
    LZm = getSystemProperty("java.runtime.version");
    LZn = getSystemProperty("java.specification.name");
    LZo = getSystemProperty("java.specification.vendor");
    LZp = getSystemProperty("java.specification.version");
    LZq = getSystemProperty("java.util.prefs.PreferencesFactory");
    LZr = getSystemProperty("java.vendor");
    LZs = getSystemProperty("java.vendor.url");
    LZt = getSystemProperty("java.version");
    LZu = getSystemProperty("java.vm.info");
    LZv = getSystemProperty("java.vm.name");
    LZw = getSystemProperty("java.vm.specification.name");
    LZx = getSystemProperty("java.vm.specification.vendor");
    LZy = getSystemProperty("java.vm.specification.version");
    LZz = getSystemProperty("java.vm.vendor");
    LZA = getSystemProperty("java.vm.version");
    LQw = getSystemProperty("line.separator");
    LZB = getSystemProperty("os.arch");
    DHZ = getSystemProperty("os.name");
    DIa = getSystemProperty("os.version");
    LZC = getSystemProperty("path.separator");
    int i;
    if (getSystemProperty("user.country") == null)
    {
      localObject = getSystemProperty("user.region");
      LZD = (String)localObject;
      LZE = getSystemProperty("user.dir");
      LZF = getSystemProperty("user.home");
      LZG = getSystemProperty("user.language");
      bSt = getSystemProperty("user.name");
      LZH = getSystemProperty("user.timezone");
      if (LZt == null) {
        break label776;
      }
      i = 0;
      label366:
      if (i >= LZt.length()) {
        break label776;
      }
      j = LZt.charAt(i);
      if ((j < 48) || (j > 57)) {
        break label769;
      }
    }
    boolean bool1;
    label769:
    label776:
    for (Object localObject = LZt.substring(i);; localObject = null)
    {
      LZI = (String)localObject;
      LZJ = R(aXx(LZt));
      localObject = aXx(LZt);
      if (localObject != null) {
        break label782;
      }
      j = 0;
      LZK = j;
      LZL = aXv("1.1");
      LZM = aXv("1.2");
      LZN = aXv("1.3");
      LZO = aXv("1.4");
      LZP = aXv("1.5");
      LZQ = aXv("1.6");
      LZR = aXv("1.7");
      LZS = aXw("AIX");
      LZT = aXw("HP-UX");
      LZU = aXw("Irix");
      if ((!aXw("Linux")) && (!aXw("LINUX"))) {
        break label832;
      }
      bool1 = true;
      label551:
      LZV = bool1;
      LZW = aXw("Mac");
      LZX = aXw("Mac OS X");
      LZY = aXw("OS/2");
      LZZ = aXw("Solaris");
      Maa = aXw("SunOS");
      if ((!LZS) && (!LZT) && (!LZU) && (!LZV) && (!LZX) && (!LZZ))
      {
        bool1 = bool2;
        if (!Maa) {}
      }
      else
      {
        bool1 = true;
      }
      Mab = bool1;
      Mac = aXw("Windows");
      Mad = nm("Windows", "5.0");
      Mae = nm("Windows 9", "4.0");
      Maf = nm("Windows 9", "4.1");
      Mag = nm("Windows", "4.9");
      Mah = aXw("Windows NT");
      Mai = nm("Windows", "5.1");
      Maj = nm("Windows", "6.0");
      Mak = nm("Windows", "6.1");
      AppMethodBeat.o(40756);
      return;
      localObject = getSystemProperty("user.country");
      break;
      i += 1;
      break label366;
    }
    label782:
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
      label832:
      bool1 = false;
      break label551;
    }
  }
  
  private static float R(int[] paramArrayOfInt)
  {
    int i = 1;
    AppMethodBeat.i(40755);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      AppMethodBeat.o(40755);
      return 0.0F;
    }
    float f;
    if (paramArrayOfInt.length == 1)
    {
      f = paramArrayOfInt[0];
      AppMethodBeat.o(40755);
      return f;
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
      f = Float.parseFloat(localStringBuffer.toString());
      AppMethodBeat.o(40755);
      return f;
    }
    catch (Exception paramArrayOfInt)
    {
      AppMethodBeat.o(40755);
    }
    return 0.0F;
  }
  
  private static boolean aXv(String paramString)
  {
    AppMethodBeat.i(40750);
    String str = LZI;
    if (str == null)
    {
      AppMethodBeat.o(40750);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40750);
    return bool;
  }
  
  private static boolean aXw(String paramString)
  {
    AppMethodBeat.i(40752);
    String str = DHZ;
    if (str == null)
    {
      AppMethodBeat.o(40752);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40752);
    return bool;
  }
  
  private static int[] aXx(String paramString)
  {
    AppMethodBeat.i(40754);
    if (paramString == null)
    {
      paramString = a.bGB;
      AppMethodBeat.o(40754);
      return paramString;
    }
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      localObject = new int[Math.min(3, paramString.length)];
      i = 0;
      for (j = 0;; j = k)
      {
        if ((i >= paramString.length) || (j >= 3)) {
          break label371;
        }
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
            continue;
            paramString = (String)localObject;
            continue;
            int i1 = k;
            int m = i;
            k = j;
            i = i1;
            continue;
            k = m;
            continue;
            i1 = m;
            m = i;
            k = j;
            i = i1;
            continue;
            j = 0;
            m = 0;
            i = 0;
            k = 1;
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
          break label447;
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
              break label432;
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
        if (j != 0) {
          ((List)localObject).add(paramString.substring(k, i));
        }
        paramString = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
      }
    }
    for (;;)
    {
      if (i >= n) {
        break label426;
      }
      if ("._- ".indexOf(paramString.charAt(i)) >= 0)
      {
        if (j == 0) {
          break;
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
        j = m + 1;
        m = j;
        i1 = i;
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
    label371:
    if (localObject.length > j)
    {
      paramString = new int[j];
      System.arraycopy(localObject, 0, paramString, 0, j);
      AppMethodBeat.o(40754);
      return paramString;
    }
  }
  
  private static String getSystemProperty(String paramString)
  {
    AppMethodBeat.i(40753);
    try
    {
      String str = System.getProperty(paramString);
      AppMethodBeat.o(40753);
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      System.err.println("Caught a SecurityException reading the system property '" + paramString + "'; the SystemUtils property value will default to null.");
      AppMethodBeat.o(40753);
    }
    return null;
  }
  
  private static boolean nm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40751);
    String str1 = DHZ;
    String str2 = DIa;
    if ((str1 == null) || (str2 == null))
    {
      AppMethodBeat.o(40751);
      return false;
    }
    if ((str1.startsWith(paramString1)) && (str2.startsWith(paramString2)))
    {
      AppMethodBeat.o(40751);
      return true;
    }
    AppMethodBeat.o(40751);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.h
 * JD-Core Version:    0.7.0.1
 */