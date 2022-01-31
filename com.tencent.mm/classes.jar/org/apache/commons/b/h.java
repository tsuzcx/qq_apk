package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public static final String ASy;
  public static final String CPA;
  public static final String CPB;
  public static final String CPC;
  public static final String CPD;
  public static final String CPE;
  public static final String CPF;
  public static final String CPG;
  public static final String CPH;
  public static final String CPI;
  public static final String CPJ;
  public static final String CPK;
  public static final String CPL;
  public static final String CPM;
  public static final String CPN;
  public static final String CPO;
  public static final String CPP;
  public static final String CPQ;
  public static final String CPR;
  public static final String CPS;
  public static final String CPT;
  public static final String CPU;
  public static final String CPV;
  public static final String CPW;
  public static final String CPX;
  public static final String CPY;
  public static final String CPZ;
  public static final String CPw;
  public static final String CPx;
  public static final String CPy;
  public static final String CPz;
  public static final boolean CQA;
  public static final boolean CQB;
  public static final boolean CQC;
  public static final boolean CQD;
  public static final boolean CQE;
  public static final boolean CQF;
  public static final boolean CQG;
  public static final boolean CQH;
  public static final boolean CQI;
  public static final boolean CQJ;
  public static final String CQa;
  public static final String CQb;
  public static final String CQc;
  public static final String CQd;
  public static final String CQe;
  public static final String CQf;
  public static final String CQg;
  public static final String CQh;
  public static final float CQi;
  public static final int CQj;
  public static final boolean CQk;
  public static final boolean CQl;
  public static final boolean CQm;
  public static final boolean CQn;
  public static final boolean CQo;
  public static final boolean CQp;
  public static final boolean CQq;
  public static final boolean CQr;
  public static final boolean CQs;
  public static final boolean CQt;
  public static final boolean CQu;
  public static final boolean CQv;
  public static final boolean CQw;
  public static final boolean CQx;
  public static final boolean CQy;
  public static final boolean CQz;
  public static final String LINE_SEPARATOR;
  public static final String bsq;
  public static final String whE;
  public static final String whF;
  
  static
  {
    boolean bool2 = false;
    AppMethodBeat.i(116964);
    CPw = getSystemProperty("awt.toolkit");
    CPx = getSystemProperty("file.encoding");
    ASy = getSystemProperty("file.separator");
    CPy = getSystemProperty("java.awt.fonts");
    CPz = getSystemProperty("java.awt.graphicsenv");
    CPA = getSystemProperty("java.awt.headless");
    CPB = getSystemProperty("java.awt.printerjob");
    CPC = getSystemProperty("java.class.path");
    CPD = getSystemProperty("java.class.version");
    CPE = getSystemProperty("java.compiler");
    CPF = getSystemProperty("java.endorsed.dirs");
    CPG = getSystemProperty("java.ext.dirs");
    CPH = getSystemProperty("java.home");
    CPI = getSystemProperty("java.io.tmpdir");
    CPJ = getSystemProperty("java.library.path");
    CPK = getSystemProperty("java.runtime.name");
    CPL = getSystemProperty("java.runtime.version");
    CPM = getSystemProperty("java.specification.name");
    CPN = getSystemProperty("java.specification.vendor");
    CPO = getSystemProperty("java.specification.version");
    CPP = getSystemProperty("java.util.prefs.PreferencesFactory");
    CPQ = getSystemProperty("java.vendor");
    CPR = getSystemProperty("java.vendor.url");
    CPS = getSystemProperty("java.version");
    CPT = getSystemProperty("java.vm.info");
    CPU = getSystemProperty("java.vm.name");
    CPV = getSystemProperty("java.vm.specification.name");
    CPW = getSystemProperty("java.vm.specification.vendor");
    CPX = getSystemProperty("java.vm.specification.version");
    CPY = getSystemProperty("java.vm.vendor");
    CPZ = getSystemProperty("java.vm.version");
    LINE_SEPARATOR = getSystemProperty("line.separator");
    CQa = getSystemProperty("os.arch");
    whE = getSystemProperty("os.name");
    whF = getSystemProperty("os.version");
    CQb = getSystemProperty("path.separator");
    int i;
    if (getSystemProperty("user.country") == null)
    {
      localObject = getSystemProperty("user.region");
      CQc = (String)localObject;
      CQd = getSystemProperty("user.dir");
      CQe = getSystemProperty("user.home");
      CQf = getSystemProperty("user.language");
      bsq = getSystemProperty("user.name");
      CQg = getSystemProperty("user.timezone");
      if (CPS == null) {
        break label776;
      }
      i = 0;
      label366:
      if (i >= CPS.length()) {
        break label776;
      }
      j = CPS.charAt(i);
      if ((j < 48) || (j > 57)) {
        break label769;
      }
    }
    boolean bool1;
    label769:
    label776:
    for (Object localObject = CPS.substring(i);; localObject = null)
    {
      CQh = (String)localObject;
      CQi = P(azM(CPS));
      localObject = azM(CPS);
      if (localObject != null) {
        break label782;
      }
      j = 0;
      CQj = j;
      CQk = azK("1.1");
      CQl = azK("1.2");
      CQm = azK("1.3");
      CQn = azK("1.4");
      CQo = azK("1.5");
      CQp = azK("1.6");
      CQq = azK("1.7");
      CQr = azL("AIX");
      CQs = azL("HP-UX");
      CQt = azL("Irix");
      if ((!azL("Linux")) && (!azL("LINUX"))) {
        break label832;
      }
      bool1 = true;
      label551:
      CQu = bool1;
      CQv = azL("Mac");
      CQw = azL("Mac OS X");
      CQx = azL("OS/2");
      CQy = azL("Solaris");
      CQz = azL("SunOS");
      if ((!CQr) && (!CQs) && (!CQt) && (!CQu) && (!CQw) && (!CQy))
      {
        bool1 = bool2;
        if (!CQz) {}
      }
      else
      {
        bool1 = true;
      }
      CQA = bool1;
      CQB = azL("Windows");
      CQC = jG("Windows", "5.0");
      CQD = jG("Windows 9", "4.0");
      CQE = jG("Windows 9", "4.1");
      CQF = jG("Windows", "4.9");
      CQG = azL("Windows NT");
      CQH = jG("Windows", "5.1");
      CQI = jG("Windows", "6.0");
      CQJ = jG("Windows", "6.1");
      AppMethodBeat.o(116964);
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
  
  private static float P(int[] paramArrayOfInt)
  {
    int i = 1;
    AppMethodBeat.i(116963);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      AppMethodBeat.o(116963);
      return 0.0F;
    }
    float f;
    if (paramArrayOfInt.length == 1)
    {
      f = paramArrayOfInt[0];
      AppMethodBeat.o(116963);
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
      AppMethodBeat.o(116963);
      return f;
    }
    catch (Exception paramArrayOfInt)
    {
      AppMethodBeat.o(116963);
    }
    return 0.0F;
  }
  
  private static boolean azK(String paramString)
  {
    AppMethodBeat.i(116958);
    String str = CQh;
    if (str == null)
    {
      AppMethodBeat.o(116958);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(116958);
    return bool;
  }
  
  private static boolean azL(String paramString)
  {
    AppMethodBeat.i(116960);
    String str = whE;
    if (str == null)
    {
      AppMethodBeat.o(116960);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(116960);
    return bool;
  }
  
  private static int[] azM(String paramString)
  {
    AppMethodBeat.i(116962);
    if (paramString == null)
    {
      paramString = a.bgZ;
      AppMethodBeat.o(116962);
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
      AppMethodBeat.o(116962);
      return paramString;
    }
  }
  
  public static boolean erq()
  {
    return CQi >= 1.5F;
  }
  
  private static String getSystemProperty(String paramString)
  {
    AppMethodBeat.i(116961);
    try
    {
      String str = System.getProperty(paramString);
      AppMethodBeat.o(116961);
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      System.err.println("Caught a SecurityException reading the system property '" + paramString + "'; the SystemUtils property value will default to null.");
      AppMethodBeat.o(116961);
    }
    return null;
  }
  
  private static boolean jG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116959);
    String str1 = whE;
    String str2 = whF;
    if ((str1 == null) || (str2 == null))
    {
      AppMethodBeat.o(116959);
      return false;
    }
    if ((str1.startsWith(paramString1)) && (str2.startsWith(paramString2)))
    {
      AppMethodBeat.o(116959);
      return true;
    }
    AppMethodBeat.o(116959);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.apache.commons.b.h
 * JD-Core Version:    0.7.0.1
 */