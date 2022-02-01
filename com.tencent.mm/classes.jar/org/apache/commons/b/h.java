package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public static final String Fng;
  public static final String Fnh;
  public static final String NHr;
  public static final String NTA;
  public static final String NTB;
  public static final String NTC;
  public static final String NTD;
  public static final String NTE;
  public static final String NTF;
  public static final String NTG;
  public static final String NTH;
  public static final String NTI;
  public static final String NTJ;
  public static final String NTK;
  public static final String NTL;
  public static final String NTM;
  public static final String NTN;
  public static final String NTO;
  public static final String NTP;
  public static final String NTQ;
  public static final String NTR;
  public static final String NTS;
  public static final String NTT;
  public static final String NTU;
  public static final String NTV;
  public static final String NTW;
  public static final String NTX;
  public static final String NTY;
  public static final String NTZ;
  public static final String NTv;
  public static final String NTw;
  public static final String NTx;
  public static final String NTy;
  public static final String NTz;
  public static final boolean NUA;
  public static final boolean NUB;
  public static final boolean NUC;
  public static final boolean NUD;
  public static final boolean NUE;
  public static final boolean NUF;
  public static final boolean NUG;
  public static final boolean NUH;
  public static final boolean NUI;
  public static final boolean NUJ;
  public static final String NUa;
  public static final String NUb;
  public static final String NUc;
  public static final String NUd;
  public static final String NUe;
  public static final String NUf;
  public static final String NUg;
  public static final String NUh;
  public static final float NUi;
  public static final int NUj;
  public static final boolean NUk;
  public static final boolean NUl;
  public static final boolean NUm;
  public static final boolean NUn;
  public static final boolean NUo;
  public static final boolean NUp;
  public static final boolean NUq;
  public static final boolean NUr;
  public static final boolean NUs;
  public static final boolean NUt;
  public static final boolean NUu;
  public static final boolean NUv;
  public static final boolean NUw;
  public static final boolean NUx;
  public static final boolean NUy;
  public static final boolean NUz;
  public static final String ccG;
  
  static
  {
    boolean bool2 = false;
    AppMethodBeat.i(40756);
    NTv = getSystemProperty("awt.toolkit");
    NTw = getSystemProperty("file.encoding");
    NTx = getSystemProperty("file.separator");
    NTy = getSystemProperty("java.awt.fonts");
    NTz = getSystemProperty("java.awt.graphicsenv");
    NTA = getSystemProperty("java.awt.headless");
    NTB = getSystemProperty("java.awt.printerjob");
    NTC = getSystemProperty("java.class.path");
    NTD = getSystemProperty("java.class.version");
    NTE = getSystemProperty("java.compiler");
    NTF = getSystemProperty("java.endorsed.dirs");
    NTG = getSystemProperty("java.ext.dirs");
    NTH = getSystemProperty("java.home");
    NTI = getSystemProperty("java.io.tmpdir");
    NTJ = getSystemProperty("java.library.path");
    NTK = getSystemProperty("java.runtime.name");
    NTL = getSystemProperty("java.runtime.version");
    NTM = getSystemProperty("java.specification.name");
    NTN = getSystemProperty("java.specification.vendor");
    NTO = getSystemProperty("java.specification.version");
    NTP = getSystemProperty("java.util.prefs.PreferencesFactory");
    NTQ = getSystemProperty("java.vendor");
    NTR = getSystemProperty("java.vendor.url");
    NTS = getSystemProperty("java.version");
    NTT = getSystemProperty("java.vm.info");
    NTU = getSystemProperty("java.vm.name");
    NTV = getSystemProperty("java.vm.specification.name");
    NTW = getSystemProperty("java.vm.specification.vendor");
    NTX = getSystemProperty("java.vm.specification.version");
    NTY = getSystemProperty("java.vm.vendor");
    NTZ = getSystemProperty("java.vm.version");
    NHr = getSystemProperty("line.separator");
    NUa = getSystemProperty("os.arch");
    Fng = getSystemProperty("os.name");
    Fnh = getSystemProperty("os.version");
    NUb = getSystemProperty("path.separator");
    int i;
    if (getSystemProperty("user.country") == null)
    {
      localObject = getSystemProperty("user.region");
      NUc = (String)localObject;
      NUd = getSystemProperty("user.dir");
      NUe = getSystemProperty("user.home");
      NUf = getSystemProperty("user.language");
      ccG = getSystemProperty("user.name");
      NUg = getSystemProperty("user.timezone");
      if (NTS == null) {
        break label776;
      }
      i = 0;
      label366:
      if (i >= NTS.length()) {
        break label776;
      }
      j = NTS.charAt(i);
      if ((j < 48) || (j > 57)) {
        break label769;
      }
    }
    boolean bool1;
    label769:
    label776:
    for (Object localObject = NTS.substring(i);; localObject = null)
    {
      NUh = (String)localObject;
      NUi = R(bdR(NTS));
      localObject = bdR(NTS);
      if (localObject != null) {
        break label782;
      }
      j = 0;
      NUj = j;
      NUk = bdP("1.1");
      NUl = bdP("1.2");
      NUm = bdP("1.3");
      NUn = bdP("1.4");
      NUo = bdP("1.5");
      NUp = bdP("1.6");
      NUq = bdP("1.7");
      NUr = bdQ("AIX");
      NUs = bdQ("HP-UX");
      NUt = bdQ("Irix");
      if ((!bdQ("Linux")) && (!bdQ("LINUX"))) {
        break label832;
      }
      bool1 = true;
      label551:
      NUu = bool1;
      NUv = bdQ("Mac");
      NUw = bdQ("Mac OS X");
      NUx = bdQ("OS/2");
      NUy = bdQ("Solaris");
      NUz = bdQ("SunOS");
      if ((!NUr) && (!NUs) && (!NUt) && (!NUu) && (!NUw) && (!NUy))
      {
        bool1 = bool2;
        if (!NUz) {}
      }
      else
      {
        bool1 = true;
      }
      NUA = bool1;
      NUB = bdQ("Windows");
      NUC = nL("Windows", "5.0");
      NUD = nL("Windows 9", "4.0");
      NUE = nL("Windows 9", "4.1");
      NUF = nL("Windows", "4.9");
      NUG = bdQ("Windows NT");
      NUH = nL("Windows", "5.1");
      NUI = nL("Windows", "6.0");
      NUJ = nL("Windows", "6.1");
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
  
  private static boolean bdP(String paramString)
  {
    AppMethodBeat.i(40750);
    String str = NUh;
    if (str == null)
    {
      AppMethodBeat.o(40750);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40750);
    return bool;
  }
  
  private static boolean bdQ(String paramString)
  {
    AppMethodBeat.i(40752);
    String str = Fng;
    if (str == null)
    {
      AppMethodBeat.o(40752);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40752);
    return bool;
  }
  
  private static int[] bdR(String paramString)
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
  
  private static boolean nL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40751);
    String str1 = Fng;
    String str2 = Fnh;
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