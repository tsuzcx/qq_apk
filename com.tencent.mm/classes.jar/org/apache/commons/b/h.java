package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public static final String RAA;
  public static final String RAz;
  public static final String abIN;
  public static final String abIO;
  public static final String abIP;
  public static final String abIQ;
  public static final String abIR;
  public static final String abIS;
  public static final String abIT;
  public static final String abIU;
  public static final String abIV;
  public static final String abIW;
  public static final String abIX;
  public static final String abIY;
  public static final String abIZ;
  public static final String abJA;
  public static final float abJB;
  public static final int abJC;
  public static final boolean abJD;
  public static final boolean abJE;
  public static final boolean abJF;
  public static final boolean abJG;
  public static final boolean abJH;
  public static final boolean abJI;
  public static final boolean abJJ;
  public static final boolean abJK;
  public static final boolean abJL;
  public static final boolean abJM;
  public static final boolean abJN;
  public static final boolean abJO;
  public static final boolean abJP;
  public static final boolean abJQ;
  public static final boolean abJR;
  public static final boolean abJS;
  public static final boolean abJT;
  public static final boolean abJU;
  public static final boolean abJV;
  public static final boolean abJW;
  public static final boolean abJX;
  public static final boolean abJY;
  public static final boolean abJZ;
  public static final String abJa;
  public static final String abJb;
  public static final String abJc;
  public static final String abJd;
  public static final String abJe;
  public static final String abJf;
  public static final String abJg;
  public static final String abJh;
  public static final String abJi;
  public static final String abJj;
  public static final String abJk;
  public static final String abJl;
  public static final String abJm;
  public static final String abJn;
  public static final String abJo;
  public static final String abJp;
  public static final String abJq;
  public static final String abJr;
  public static final String abJs;
  public static final String abJt;
  public static final String abJu;
  public static final String abJv;
  public static final String abJw;
  public static final String abJx;
  public static final String abJy;
  public static final String abJz;
  public static final boolean abKa;
  public static final boolean abKb;
  public static final boolean abKc;
  public static final String abvU;
  
  static
  {
    boolean bool2 = false;
    AppMethodBeat.i(40756);
    abIN = getSystemProperty("awt.toolkit");
    abIO = getSystemProperty("file.encoding");
    abIP = getSystemProperty("file.separator");
    abIQ = getSystemProperty("java.awt.fonts");
    abIR = getSystemProperty("java.awt.graphicsenv");
    abIS = getSystemProperty("java.awt.headless");
    abIT = getSystemProperty("java.awt.printerjob");
    abIU = getSystemProperty("java.class.path");
    abIV = getSystemProperty("java.class.version");
    abIW = getSystemProperty("java.compiler");
    abIX = getSystemProperty("java.endorsed.dirs");
    abIY = getSystemProperty("java.ext.dirs");
    abIZ = getSystemProperty("java.home");
    abJa = getSystemProperty("java.io.tmpdir");
    abJb = getSystemProperty("java.library.path");
    abJc = getSystemProperty("java.runtime.name");
    abJd = getSystemProperty("java.runtime.version");
    abJe = getSystemProperty("java.specification.name");
    abJf = getSystemProperty("java.specification.vendor");
    abJg = getSystemProperty("java.specification.version");
    abJh = getSystemProperty("java.util.prefs.PreferencesFactory");
    abJi = getSystemProperty("java.vendor");
    abJj = getSystemProperty("java.vendor.url");
    abJk = getSystemProperty("java.version");
    abJl = getSystemProperty("java.vm.info");
    abJm = getSystemProperty("java.vm.name");
    abJn = getSystemProperty("java.vm.specification.name");
    abJo = getSystemProperty("java.vm.specification.vendor");
    abJp = getSystemProperty("java.vm.specification.version");
    abJq = getSystemProperty("java.vm.vendor");
    abJr = getSystemProperty("java.vm.version");
    abvU = getSystemProperty("line.separator");
    abJs = getSystemProperty("os.arch");
    RAz = getSystemProperty("os.name");
    RAA = getSystemProperty("os.version");
    abJt = getSystemProperty("path.separator");
    int i;
    if (getSystemProperty("user.country") == null)
    {
      localObject = getSystemProperty("user.region");
      abJu = (String)localObject;
      abJv = getSystemProperty("user.dir");
      abJw = getSystemProperty("user.home");
      abJx = getSystemProperty("user.language");
      abJy = getSystemProperty("user.name");
      abJz = getSystemProperty("user.timezone");
      if (abJk == null) {
        break label776;
      }
      i = 0;
      label366:
      if (i >= abJk.length()) {
        break label776;
      }
      j = abJk.charAt(i);
      if ((j < 48) || (j > 57)) {
        break label769;
      }
    }
    boolean bool1;
    label769:
    label776:
    for (Object localObject = abJk.substring(i);; localObject = null)
    {
      abJA = (String)localObject;
      abJB = aa(bIq(abJk));
      localObject = bIq(abJk);
      if (localObject != null) {
        break label782;
      }
      j = 0;
      abJC = j;
      abJD = bIo("1.1");
      abJE = bIo("1.2");
      abJF = bIo("1.3");
      abJG = bIo("1.4");
      abJH = bIo("1.5");
      abJI = bIo("1.6");
      abJJ = bIo("1.7");
      abJK = bIp("AIX");
      abJL = bIp("HP-UX");
      abJM = bIp("Irix");
      if ((!bIp("Linux")) && (!bIp("LINUX"))) {
        break label832;
      }
      bool1 = true;
      label551:
      abJN = bool1;
      abJO = bIp("Mac");
      abJP = bIp("Mac OS X");
      abJQ = bIp("OS/2");
      abJR = bIp("Solaris");
      abJS = bIp("SunOS");
      if ((!abJK) && (!abJL) && (!abJM) && (!abJN) && (!abJP) && (!abJR))
      {
        bool1 = bool2;
        if (!abJS) {}
      }
      else
      {
        bool1 = true;
      }
      abJT = bool1;
      abJU = bIp("Windows");
      abJV = pF("Windows", "5.0");
      abJW = pF("Windows 9", "4.0");
      abJX = pF("Windows 9", "4.1");
      abJY = pF("Windows", "4.9");
      abJZ = bIp("Windows NT");
      abKa = pF("Windows", "5.1");
      abKb = pF("Windows", "6.0");
      abKc = pF("Windows", "6.1");
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
  
  private static float aa(int[] paramArrayOfInt)
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
  
  private static boolean bIo(String paramString)
  {
    AppMethodBeat.i(40750);
    String str = abJA;
    if (str == null)
    {
      AppMethodBeat.o(40750);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40750);
    return bool;
  }
  
  private static boolean bIp(String paramString)
  {
    AppMethodBeat.i(40752);
    String str = RAz;
    if (str == null)
    {
      AppMethodBeat.o(40752);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40752);
    return bool;
  }
  
  private static int[] bIq(String paramString)
  {
    AppMethodBeat.i(40754);
    if (paramString == null)
    {
      paramString = a.bZR;
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
  
  private static boolean pF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40751);
    String str1 = RAz;
    String str2 = RAA;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.h
 * JD-Core Version:    0.7.0.1
 */