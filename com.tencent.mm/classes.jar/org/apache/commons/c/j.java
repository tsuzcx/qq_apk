package org.apache.commons.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class j
{
  public static final String Yxd;
  public static final String Yxe;
  public static final String ajUO;
  public static final String ajVI;
  public static final String ajVJ;
  public static final String ajVK;
  public static final String ajVL;
  public static final String ajVM;
  public static final String ajVN;
  public static final String ajVO;
  public static final String ajVP;
  public static final String ajVQ;
  public static final String ajVR;
  public static final String ajVS;
  public static final String ajVT;
  public static final String ajVU;
  public static final String ajVV;
  public static final String ajVW;
  public static final String ajVX;
  public static final String ajVY;
  public static final String ajVZ;
  public static final boolean ajWA;
  public static final boolean ajWB;
  public static final boolean ajWC;
  public static final boolean ajWD;
  public static final boolean ajWE;
  public static final boolean ajWF;
  public static final boolean ajWG;
  public static final boolean ajWH;
  public static final boolean ajWI;
  public static final boolean ajWJ;
  public static final boolean ajWK;
  public static final boolean ajWL;
  public static final boolean ajWM;
  public static final boolean ajWN;
  public static final boolean ajWO;
  public static final boolean ajWP;
  public static final boolean ajWQ;
  public static final boolean ajWR;
  public static final boolean ajWS;
  public static final boolean ajWT;
  public static final boolean ajWU;
  public static final boolean ajWV;
  public static final boolean ajWW;
  public static final boolean ajWX;
  public static final String ajWa;
  public static final String ajWb;
  public static final String ajWc;
  public static final String ajWd;
  public static final String ajWe;
  public static final String ajWf;
  public static final String ajWg;
  public static final String ajWh;
  public static final String ajWi;
  public static final String ajWj;
  public static final String ajWk;
  public static final String ajWl;
  public static final String ajWm;
  public static final String ajWn;
  public static final String ajWo;
  public static final String ajWp;
  public static final String ajWq;
  public static final String ajWr;
  public static final String ajWs;
  public static final String ajWt;
  public static final String ajWu;
  public static final String ajWv;
  public static final float ajWw;
  public static final int ajWx;
  public static final boolean ajWy;
  public static final boolean ajWz;
  
  static
  {
    boolean bool2 = false;
    AppMethodBeat.i(40756);
    ajVI = getSystemProperty("awt.toolkit");
    ajVJ = getSystemProperty("file.encoding");
    ajVK = getSystemProperty("file.separator");
    ajVL = getSystemProperty("java.awt.fonts");
    ajVM = getSystemProperty("java.awt.graphicsenv");
    ajVN = getSystemProperty("java.awt.headless");
    ajVO = getSystemProperty("java.awt.printerjob");
    ajVP = getSystemProperty("java.class.path");
    ajVQ = getSystemProperty("java.class.version");
    ajVR = getSystemProperty("java.compiler");
    ajVS = getSystemProperty("java.endorsed.dirs");
    ajVT = getSystemProperty("java.ext.dirs");
    ajVU = getSystemProperty("java.home");
    ajVV = getSystemProperty("java.io.tmpdir");
    ajVW = getSystemProperty("java.library.path");
    ajVX = getSystemProperty("java.runtime.name");
    ajVY = getSystemProperty("java.runtime.version");
    ajVZ = getSystemProperty("java.specification.name");
    ajWa = getSystemProperty("java.specification.vendor");
    ajWb = getSystemProperty("java.specification.version");
    ajWc = getSystemProperty("java.util.prefs.PreferencesFactory");
    ajWd = getSystemProperty("java.vendor");
    ajWe = getSystemProperty("java.vendor.url");
    ajWf = getSystemProperty("java.version");
    ajWg = getSystemProperty("java.vm.info");
    ajWh = getSystemProperty("java.vm.name");
    ajWi = getSystemProperty("java.vm.specification.name");
    ajWj = getSystemProperty("java.vm.specification.vendor");
    ajWk = getSystemProperty("java.vm.specification.version");
    ajWl = getSystemProperty("java.vm.vendor");
    ajWm = getSystemProperty("java.vm.version");
    ajUO = getSystemProperty("line.separator");
    ajWn = getSystemProperty("os.arch");
    Yxd = getSystemProperty("os.name");
    Yxe = getSystemProperty("os.version");
    ajWo = getSystemProperty("path.separator");
    int i;
    if (getSystemProperty("user.country") == null)
    {
      localObject = getSystemProperty("user.region");
      ajWp = (String)localObject;
      ajWq = getSystemProperty("user.dir");
      ajWr = getSystemProperty("user.home");
      ajWs = getSystemProperty("user.language");
      ajWt = getSystemProperty("user.name");
      ajWu = getSystemProperty("user.timezone");
      if (ajWf == null) {
        break label776;
      }
      i = 0;
      label366:
      if (i >= ajWf.length()) {
        break label776;
      }
      j = ajWf.charAt(i);
      if ((j < 48) || (j > 57)) {
        break label769;
      }
    }
    boolean bool1;
    label769:
    label776:
    for (Object localObject = ajWf.substring(i);; localObject = null)
    {
      ajWv = (String)localObject;
      ajWw = ai(bLl(ajWf));
      localObject = bLl(ajWf);
      if (localObject != null) {
        break label782;
      }
      j = 0;
      ajWx = j;
      ajWy = bLj("1.1");
      ajWz = bLj("1.2");
      ajWA = bLj("1.3");
      ajWB = bLj("1.4");
      ajWC = bLj("1.5");
      ajWD = bLj("1.6");
      ajWE = bLj("1.7");
      ajWF = bLk("AIX");
      ajWG = bLk("HP-UX");
      ajWH = bLk("Irix");
      if ((!bLk("Linux")) && (!bLk("LINUX"))) {
        break label832;
      }
      bool1 = true;
      label551:
      ajWI = bool1;
      ajWJ = bLk("Mac");
      ajWK = bLk("Mac OS X");
      ajWL = bLk("OS/2");
      ajWM = bLk("Solaris");
      ajWN = bLk("SunOS");
      if ((!ajWF) && (!ajWG) && (!ajWH) && (!ajWI) && (!ajWK) && (!ajWM))
      {
        bool1 = bool2;
        if (!ajWN) {}
      }
      else
      {
        bool1 = true;
      }
      ajWO = bool1;
      ajWP = bLk("Windows");
      ajWQ = rJ("Windows", "5.0");
      ajWR = rJ("Windows 9", "4.0");
      ajWS = rJ("Windows 9", "4.1");
      ajWT = rJ("Windows", "4.9");
      ajWU = bLk("Windows NT");
      ajWV = rJ("Windows", "5.1");
      ajWW = rJ("Windows", "6.0");
      ajWX = rJ("Windows", "6.1");
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
  
  private static float ai(int[] paramArrayOfInt)
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
  
  private static boolean bLj(String paramString)
  {
    AppMethodBeat.i(40750);
    String str = ajWv;
    if (str == null)
    {
      AppMethodBeat.o(40750);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40750);
    return bool;
  }
  
  private static boolean bLk(String paramString)
  {
    AppMethodBeat.i(40752);
    String str = Yxd;
    if (str == null)
    {
      AppMethodBeat.o(40752);
      return false;
    }
    boolean bool = str.startsWith(paramString);
    AppMethodBeat.o(40752);
    return bool;
  }
  
  private static int[] bLl(String paramString)
  {
    AppMethodBeat.i(40754);
    if (paramString == null)
    {
      paramString = a.dTZ;
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
  
  private static boolean rJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40751);
    String str1 = Yxd;
    String str2 = Yxe;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.apache.commons.c.j
 * JD-Core Version:    0.7.0.1
 */