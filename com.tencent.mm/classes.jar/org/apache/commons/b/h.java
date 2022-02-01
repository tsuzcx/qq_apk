package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public static final String CpH;
  public static final String CpI;
  public static final String Kdb;
  public static final String KlA;
  public static final String KlB;
  public static final String KlC;
  public static final String KlD;
  public static final String KlE;
  public static final String KlF;
  public static final String KlG;
  public static final String KlH;
  public static final String KlI;
  public static final String KlJ;
  public static final String KlK;
  public static final String KlL;
  public static final String KlM;
  public static final String KlN;
  public static final String KlO;
  public static final String KlP;
  public static final String KlQ;
  public static final String KlR;
  public static final String KlS;
  public static final String KlT;
  public static final String KlU;
  public static final String KlV;
  public static final String KlW;
  public static final String KlX;
  public static final String KlY;
  public static final String KlZ;
  public static final String Kln;
  public static final String Klo;
  public static final String Klp;
  public static final String Klq;
  public static final String Klr;
  public static final String Kls;
  public static final String Klt;
  public static final String Klu;
  public static final String Klv;
  public static final String Klw;
  public static final String Klx;
  public static final String Kly;
  public static final String Klz;
  public static final boolean KmA;
  public static final boolean KmB;
  public static final float Kma;
  public static final int Kmb;
  public static final boolean Kmc;
  public static final boolean Kmd;
  public static final boolean Kme;
  public static final boolean Kmf;
  public static final boolean Kmg;
  public static final boolean Kmh;
  public static final boolean Kmi;
  public static final boolean Kmj;
  public static final boolean Kmk;
  public static final boolean Kml;
  public static final boolean Kmm;
  public static final boolean Kmn;
  public static final boolean Kmo;
  public static final boolean Kmp;
  public static final boolean Kmq;
  public static final boolean Kmr;
  public static final boolean Kms;
  public static final boolean Kmt;
  public static final boolean Kmu;
  public static final boolean Kmv;
  public static final boolean Kmw;
  public static final boolean Kmx;
  public static final boolean Kmy;
  public static final boolean Kmz;
  public static final String bUL;
  
  static
  {
    boolean bool2 = false;
    AppMethodBeat.i(40756);
    Kln = getSystemProperty("awt.toolkit");
    Klo = getSystemProperty("file.encoding");
    Klp = getSystemProperty("file.separator");
    Klq = getSystemProperty("java.awt.fonts");
    Klr = getSystemProperty("java.awt.graphicsenv");
    Kls = getSystemProperty("java.awt.headless");
    Klt = getSystemProperty("java.awt.printerjob");
    Klu = getSystemProperty("java.class.path");
    Klv = getSystemProperty("java.class.version");
    Klw = getSystemProperty("java.compiler");
    Klx = getSystemProperty("java.endorsed.dirs");
    Kly = getSystemProperty("java.ext.dirs");
    Klz = getSystemProperty("java.home");
    KlA = getSystemProperty("java.io.tmpdir");
    KlB = getSystemProperty("java.library.path");
    KlC = getSystemProperty("java.runtime.name");
    KlD = getSystemProperty("java.runtime.version");
    KlE = getSystemProperty("java.specification.name");
    KlF = getSystemProperty("java.specification.vendor");
    KlG = getSystemProperty("java.specification.version");
    KlH = getSystemProperty("java.util.prefs.PreferencesFactory");
    KlI = getSystemProperty("java.vendor");
    KlJ = getSystemProperty("java.vendor.url");
    KlK = getSystemProperty("java.version");
    KlL = getSystemProperty("java.vm.info");
    KlM = getSystemProperty("java.vm.name");
    KlN = getSystemProperty("java.vm.specification.name");
    KlO = getSystemProperty("java.vm.specification.vendor");
    KlP = getSystemProperty("java.vm.specification.version");
    KlQ = getSystemProperty("java.vm.vendor");
    KlR = getSystemProperty("java.vm.version");
    Kdb = getSystemProperty("line.separator");
    KlS = getSystemProperty("os.arch");
    CpH = getSystemProperty("os.name");
    CpI = getSystemProperty("os.version");
    KlT = getSystemProperty("path.separator");
    int i;
    if (getSystemProperty("user.country") == null)
    {
      localObject = getSystemProperty("user.region");
      KlU = (String)localObject;
      KlV = getSystemProperty("user.dir");
      KlW = getSystemProperty("user.home");
      KlX = getSystemProperty("user.language");
      bUL = getSystemProperty("user.name");
      KlY = getSystemProperty("user.timezone");
      if (KlK == null) {
        break label776;
      }
      i = 0;
      label366:
      if (i >= KlK.length()) {
        break label776;
      }
      j = KlK.charAt(i);
      if ((j < 48) || (j > 57)) {
        break label769;
      }
    }
    boolean bool1;
    label769:
    label776:
    for (Object localObject = KlK.substring(i);; localObject = null)
    {
      KlZ = (String)localObject;
      Kma = S(aRx(KlK));
      localObject = aRx(KlK);
      if (localObject != null) {
        break label782;
      }
      j = 0;
      Kmb = j;
      Kmc = aRv("1.1");
      Kmd = aRv("1.2");
      Kme = aRv("1.3");
      Kmf = aRv("1.4");
      Kmg = aRv("1.5");
      Kmh = aRv("1.6");
      Kmi = aRv("1.7");
      Kmj = aRw("AIX");
      Kmk = aRw("HP-UX");
      Kml = aRw("Irix");
      if ((!aRw("Linux")) && (!aRw("LINUX"))) {
        break label832;
      }
      bool1 = true;
      label551:
      Kmm = bool1;
      Kmn = aRw("Mac");
      Kmo = aRw("Mac OS X");
      Kmp = aRw("OS/2");
      Kmq = aRw("Solaris");
      Kmr = aRw("SunOS");
      if ((!Kmj) && (!Kmk) && (!Kml) && (!Kmm) && (!Kmo) && (!Kmq))
      {
        bool1 = bool2;
        if (!Kmr) {}
      }
      else
      {
        bool1 = true;
      }
      Kms = bool1;
      Kmt = aRw("Windows");
      Kmu = mM("Windows", "5.0");
      Kmv = mM("Windows 9", "4.0");
      Kmw = mM("Windows 9", "4.1");
      Kmx = mM("Windows", "4.9");
      Kmy = aRw("Windows NT");
      Kmz = mM("Windows", "5.1");
      KmA = mM("Windows", "6.0");
      KmB = mM("Windows", "6.1");
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
  
  private static boolean aRv(String paramString)
  {
    AppMethodBeat.i(40750);
    String str = KlZ;
    if (str == null)
    {
      AppMethodBeat.o(40750);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40750);
    return bool;
  }
  
  private static boolean aRw(String paramString)
  {
    AppMethodBeat.i(40752);
    String str = CpH;
    if (str == null)
    {
      AppMethodBeat.o(40752);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40752);
    return bool;
  }
  
  private static int[] aRx(String paramString)
  {
    AppMethodBeat.i(40754);
    if (paramString == null)
    {
      paramString = a.bIT;
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
  
  private static boolean mM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40751);
    String str1 = CpH;
    String str2 = CpI;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.apache.commons.b.h
 * JD-Core Version:    0.7.0.1
 */