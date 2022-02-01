package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public static final String KyL;
  public static final String KyM;
  public static final String TTr;
  public static final String UfA;
  public static final String UfB;
  public static final String UfC;
  public static final String UfD;
  public static final String UfE;
  public static final String UfF;
  public static final String UfG;
  public static final String UfH;
  public static final String UfI;
  public static final String UfJ;
  public static final String UfK;
  public static final String UfL;
  public static final String UfM;
  public static final String UfN;
  public static final String UfO;
  public static final String UfP;
  public static final String UfQ;
  public static final String UfR;
  public static final String UfS;
  public static final String UfT;
  public static final String UfU;
  public static final String UfV;
  public static final String UfW;
  public static final String UfX;
  public static final String UfY;
  public static final String UfZ;
  public static final String Ufz;
  public static final boolean UgA;
  public static final boolean UgB;
  public static final boolean UgC;
  public static final boolean UgD;
  public static final boolean UgE;
  public static final boolean UgF;
  public static final boolean UgG;
  public static final boolean UgH;
  public static final boolean UgI;
  public static final boolean UgJ;
  public static final boolean UgK;
  public static final boolean UgL;
  public static final boolean UgM;
  public static final boolean UgN;
  public static final String Uga;
  public static final String Ugb;
  public static final String Ugc;
  public static final String Ugd;
  public static final String Uge;
  public static final String Ugf;
  public static final String Ugg;
  public static final String Ugh;
  public static final String Ugi;
  public static final String Ugj;
  public static final String Ugk;
  public static final String Ugl;
  public static final float Ugm;
  public static final int Ugn;
  public static final boolean Ugo;
  public static final boolean Ugp;
  public static final boolean Ugq;
  public static final boolean Ugr;
  public static final boolean Ugs;
  public static final boolean Ugt;
  public static final boolean Ugu;
  public static final boolean Ugv;
  public static final boolean Ugw;
  public static final boolean Ugx;
  public static final boolean Ugy;
  public static final boolean Ugz;
  public static final String cnm;
  
  static
  {
    boolean bool2 = false;
    AppMethodBeat.i(40756);
    Ufz = getSystemProperty("awt.toolkit");
    UfA = getSystemProperty("file.encoding");
    UfB = getSystemProperty("file.separator");
    UfC = getSystemProperty("java.awt.fonts");
    UfD = getSystemProperty("java.awt.graphicsenv");
    UfE = getSystemProperty("java.awt.headless");
    UfF = getSystemProperty("java.awt.printerjob");
    UfG = getSystemProperty("java.class.path");
    UfH = getSystemProperty("java.class.version");
    UfI = getSystemProperty("java.compiler");
    UfJ = getSystemProperty("java.endorsed.dirs");
    UfK = getSystemProperty("java.ext.dirs");
    UfL = getSystemProperty("java.home");
    UfM = getSystemProperty("java.io.tmpdir");
    UfN = getSystemProperty("java.library.path");
    UfO = getSystemProperty("java.runtime.name");
    UfP = getSystemProperty("java.runtime.version");
    UfQ = getSystemProperty("java.specification.name");
    UfR = getSystemProperty("java.specification.vendor");
    UfS = getSystemProperty("java.specification.version");
    UfT = getSystemProperty("java.util.prefs.PreferencesFactory");
    UfU = getSystemProperty("java.vendor");
    UfV = getSystemProperty("java.vendor.url");
    UfW = getSystemProperty("java.version");
    UfX = getSystemProperty("java.vm.info");
    UfY = getSystemProperty("java.vm.name");
    UfZ = getSystemProperty("java.vm.specification.name");
    Uga = getSystemProperty("java.vm.specification.vendor");
    Ugb = getSystemProperty("java.vm.specification.version");
    Ugc = getSystemProperty("java.vm.vendor");
    Ugd = getSystemProperty("java.vm.version");
    TTr = getSystemProperty("line.separator");
    Uge = getSystemProperty("os.arch");
    KyL = getSystemProperty("os.name");
    KyM = getSystemProperty("os.version");
    Ugf = getSystemProperty("path.separator");
    int i;
    if (getSystemProperty("user.country") == null)
    {
      localObject = getSystemProperty("user.region");
      Ugg = (String)localObject;
      Ugh = getSystemProperty("user.dir");
      Ugi = getSystemProperty("user.home");
      Ugj = getSystemProperty("user.language");
      cnm = getSystemProperty("user.name");
      Ugk = getSystemProperty("user.timezone");
      if (UfW == null) {
        break label776;
      }
      i = 0;
      label366:
      if (i >= UfW.length()) {
        break label776;
      }
      j = UfW.charAt(i);
      if ((j < 48) || (j > 57)) {
        break label769;
      }
    }
    boolean bool1;
    label769:
    label776:
    for (Object localObject = UfW.substring(i);; localObject = null)
    {
      Ugl = (String)localObject;
      Ugm = ab(bvl(UfW));
      localObject = bvl(UfW);
      if (localObject != null) {
        break label782;
      }
      j = 0;
      Ugn = j;
      Ugo = bvj("1.1");
      Ugp = bvj("1.2");
      Ugq = bvj("1.3");
      Ugr = bvj("1.4");
      Ugs = bvj("1.5");
      Ugt = bvj("1.6");
      Ugu = bvj("1.7");
      Ugv = bvk("AIX");
      Ugw = bvk("HP-UX");
      Ugx = bvk("Irix");
      if ((!bvk("Linux")) && (!bvk("LINUX"))) {
        break label832;
      }
      bool1 = true;
      label551:
      Ugy = bool1;
      Ugz = bvk("Mac");
      UgA = bvk("Mac OS X");
      UgB = bvk("OS/2");
      UgC = bvk("Solaris");
      UgD = bvk("SunOS");
      if ((!Ugv) && (!Ugw) && (!Ugx) && (!Ugy) && (!UgA) && (!UgC))
      {
        bool1 = bool2;
        if (!UgD) {}
      }
      else
      {
        bool1 = true;
      }
      UgE = bool1;
      UgF = bvk("Windows");
      UgG = oJ("Windows", "5.0");
      UgH = oJ("Windows 9", "4.0");
      UgI = oJ("Windows 9", "4.1");
      UgJ = oJ("Windows", "4.9");
      UgK = bvk("Windows NT");
      UgL = oJ("Windows", "5.1");
      UgM = oJ("Windows", "6.0");
      UgN = oJ("Windows", "6.1");
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
  
  private static float ab(int[] paramArrayOfInt)
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
  
  private static boolean bvj(String paramString)
  {
    AppMethodBeat.i(40750);
    String str = Ugl;
    if (str == null)
    {
      AppMethodBeat.o(40750);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40750);
    return bool;
  }
  
  private static boolean bvk(String paramString)
  {
    AppMethodBeat.i(40752);
    String str = KyL;
    if (str == null)
    {
      AppMethodBeat.o(40752);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40752);
    return bool;
  }
  
  private static int[] bvl(String paramString)
  {
    AppMethodBeat.i(40754);
    if (paramString == null)
    {
      paramString = a.bYn;
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
  
  private static boolean oJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40751);
    String str1 = KyL;
    String str2 = KyM;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.apache.commons.b.h
 * JD-Core Version:    0.7.0.1
 */