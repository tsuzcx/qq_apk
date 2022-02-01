package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public static final String FFE;
  public static final String FFF;
  public static final String Oex;
  public static final String OqB;
  public static final String OqC;
  public static final String OqD;
  public static final String OqE;
  public static final String OqF;
  public static final String OqG;
  public static final String OqH;
  public static final String OqI;
  public static final String OqJ;
  public static final String OqK;
  public static final String OqL;
  public static final String OqM;
  public static final String OqN;
  public static final String OqO;
  public static final String OqP;
  public static final String OqQ;
  public static final String OqR;
  public static final String OqS;
  public static final String OqT;
  public static final String OqU;
  public static final String OqV;
  public static final String OqW;
  public static final String OqX;
  public static final String OqY;
  public static final String OqZ;
  public static final boolean OrA;
  public static final boolean OrB;
  public static final boolean OrC;
  public static final boolean OrD;
  public static final boolean OrE;
  public static final boolean OrF;
  public static final boolean OrG;
  public static final boolean OrH;
  public static final boolean OrI;
  public static final boolean OrJ;
  public static final boolean OrK;
  public static final boolean OrL;
  public static final boolean OrM;
  public static final boolean OrN;
  public static final boolean OrO;
  public static final boolean OrP;
  public static final String Ora;
  public static final String Orb;
  public static final String Orc;
  public static final String Ord;
  public static final String Ore;
  public static final String Orf;
  public static final String Org;
  public static final String Orh;
  public static final String Ori;
  public static final String Orj;
  public static final String Ork;
  public static final String Orl;
  public static final String Orm;
  public static final String Orn;
  public static final float Oro;
  public static final int Orp;
  public static final boolean Orq;
  public static final boolean Orr;
  public static final boolean Ors;
  public static final boolean Ort;
  public static final boolean Oru;
  public static final boolean Orv;
  public static final boolean Orw;
  public static final boolean Orx;
  public static final boolean Ory;
  public static final boolean Orz;
  public static final String ccG;
  
  static
  {
    boolean bool2 = false;
    AppMethodBeat.i(40756);
    OqB = getSystemProperty("awt.toolkit");
    OqC = getSystemProperty("file.encoding");
    OqD = getSystemProperty("file.separator");
    OqE = getSystemProperty("java.awt.fonts");
    OqF = getSystemProperty("java.awt.graphicsenv");
    OqG = getSystemProperty("java.awt.headless");
    OqH = getSystemProperty("java.awt.printerjob");
    OqI = getSystemProperty("java.class.path");
    OqJ = getSystemProperty("java.class.version");
    OqK = getSystemProperty("java.compiler");
    OqL = getSystemProperty("java.endorsed.dirs");
    OqM = getSystemProperty("java.ext.dirs");
    OqN = getSystemProperty("java.home");
    OqO = getSystemProperty("java.io.tmpdir");
    OqP = getSystemProperty("java.library.path");
    OqQ = getSystemProperty("java.runtime.name");
    OqR = getSystemProperty("java.runtime.version");
    OqS = getSystemProperty("java.specification.name");
    OqT = getSystemProperty("java.specification.vendor");
    OqU = getSystemProperty("java.specification.version");
    OqV = getSystemProperty("java.util.prefs.PreferencesFactory");
    OqW = getSystemProperty("java.vendor");
    OqX = getSystemProperty("java.vendor.url");
    OqY = getSystemProperty("java.version");
    OqZ = getSystemProperty("java.vm.info");
    Ora = getSystemProperty("java.vm.name");
    Orb = getSystemProperty("java.vm.specification.name");
    Orc = getSystemProperty("java.vm.specification.vendor");
    Ord = getSystemProperty("java.vm.specification.version");
    Ore = getSystemProperty("java.vm.vendor");
    Orf = getSystemProperty("java.vm.version");
    Oex = getSystemProperty("line.separator");
    Org = getSystemProperty("os.arch");
    FFE = getSystemProperty("os.name");
    FFF = getSystemProperty("os.version");
    Orh = getSystemProperty("path.separator");
    int i;
    if (getSystemProperty("user.country") == null)
    {
      localObject = getSystemProperty("user.region");
      Ori = (String)localObject;
      Orj = getSystemProperty("user.dir");
      Ork = getSystemProperty("user.home");
      Orl = getSystemProperty("user.language");
      ccG = getSystemProperty("user.name");
      Orm = getSystemProperty("user.timezone");
      if (OqY == null) {
        break label776;
      }
      i = 0;
      label366:
      if (i >= OqY.length()) {
        break label776;
      }
      j = OqY.charAt(i);
      if ((j < 48) || (j > 57)) {
        break label769;
      }
    }
    boolean bool1;
    label769:
    label776:
    for (Object localObject = OqY.substring(i);; localObject = null)
    {
      Orn = (String)localObject;
      Oro = S(bfv(OqY));
      localObject = bfv(OqY);
      if (localObject != null) {
        break label782;
      }
      j = 0;
      Orp = j;
      Orq = bft("1.1");
      Orr = bft("1.2");
      Ors = bft("1.3");
      Ort = bft("1.4");
      Oru = bft("1.5");
      Orv = bft("1.6");
      Orw = bft("1.7");
      Orx = bfu("AIX");
      Ory = bfu("HP-UX");
      Orz = bfu("Irix");
      if ((!bfu("Linux")) && (!bfu("LINUX"))) {
        break label832;
      }
      bool1 = true;
      label551:
      OrA = bool1;
      OrB = bfu("Mac");
      OrC = bfu("Mac OS X");
      OrD = bfu("OS/2");
      OrE = bfu("Solaris");
      OrF = bfu("SunOS");
      if ((!Orx) && (!Ory) && (!Orz) && (!OrA) && (!OrC) && (!OrE))
      {
        bool1 = bool2;
        if (!OrF) {}
      }
      else
      {
        bool1 = true;
      }
      OrG = bool1;
      OrH = bfu("Windows");
      OrI = nR("Windows", "5.0");
      OrJ = nR("Windows 9", "4.0");
      OrK = nR("Windows 9", "4.1");
      OrL = nR("Windows", "4.9");
      OrM = bfu("Windows NT");
      OrN = nR("Windows", "5.1");
      OrO = nR("Windows", "6.0");
      OrP = nR("Windows", "6.1");
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
  
  private static float S(int[] paramArrayOfInt)
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
  
  private static boolean bft(String paramString)
  {
    AppMethodBeat.i(40750);
    String str = Orn;
    if (str == null)
    {
      AppMethodBeat.o(40750);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40750);
    return bool;
  }
  
  private static boolean bfu(String paramString)
  {
    AppMethodBeat.i(40752);
    String str = FFE;
    if (str == null)
    {
      AppMethodBeat.o(40752);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40752);
    return bool;
  }
  
  private static int[] bfv(String paramString)
  {
    AppMethodBeat.i(40754);
    if (paramString == null)
    {
      paramString = a.bQP;
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
  
  private static boolean nR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40751);
    String str1 = FFE;
    String str2 = FFF;
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