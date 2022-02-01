package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;

public final class i
{
  static final byte[] JZc;
  private static final String JZd;
  private static final String JZe;
  static final int[] JZf;
  
  static
  {
    AppMethodBeat.i(151977);
    JZc = new byte[] { 48, -126, 1, 75, 48, -126, 1, 3, 6, 7, 42, -122, 72, -50, 61, 2, 1, 48, -127, -9, 2, 1, 1, 48, 44, 6, 7, 42, -122, 72, -50, 61, 1, 1, 2, 33, 0, -1, -1, -1, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, 91, 4, 32, -1, -1, -1, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -4, 4, 32, 90, -58, 53, -40, -86, 58, -109, -25, -77, -21, -67, 85, 118, -104, -122, -68, 101, 29, 6, -80, -52, 83, -80, -10, 59, -50, 60, 62, 39, -46, 96, 75, 3, 21, 0, -60, -99, 54, 8, -122, -25, 4, -109, 106, 102, 120, -31, 19, -99, 38, -73, -127, -97, 126, -112, 4, 65, 4, 107, 23, -47, -14, -31, 44, 66, 71, -8, -68, -26, -27, 99, -92, 64, -14, 119, 3, 125, -127, 45, -21, 51, -96, -12, -95, 57, 69, -40, -104, -62, -106, 79, -29, 66, -30, -2, 26, 127, -101, -114, -25, -21, 74, 124, 15, -98, 22, 43, -50, 51, 87, 107, 49, 94, -50, -53, -74, 64, 104, 55, -65, 81, -11, 2, 33, 0, -1, -1, -1, -1, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -68, -26, -6, -83, -89, 23, -98, -124, -13, -71, -54, -62, -4, 99, 37, 81, 2, 1, 1, 3, 66, 0, 4, 52, 4, -14, 45, -10, -68, -118, -59, 62, 64, -101, 93, 6, -54, -27, 79, 94, 126, -9, -80, -61, -63, -38, 115, -53, 70, -63, 16, -20, -32, -80, -80, 38, 102, 16, 27, 28, 61, -60, -33, 65, 93, -25, 30, 83, 66, -24, 28, 39, 24, 69, -104, 55, -63, 108, 5, 56, -63, -4, -5, 88, -49, -126, 85 };
    JZd = b.aKJ() + "CheckResUpdate/";
    JZe = b.aKC() + "CheckResUpdate/";
    JZf = new int[] { 27, 35, 29, 38, 40, 33, 37, 39, 49, 46, 47, 56, 59, 62, 66, 54, 55, 63, 73, 79, 85, 87 };
    AppMethodBeat.o(151977);
  }
  
  static String aee(String paramString)
  {
    AppMethodBeat.i(151974);
    if ((paramString.startsWith("38.")) || (paramString.startsWith("56."))) {}
    for (String str = JZe;; str = JZd)
    {
      FilePathGenerator.checkMkdir(str);
      paramString = str + paramString;
      AppMethodBeat.o(151974);
      return paramString;
    }
  }
  
  static boolean bdY(String paramString)
  {
    AppMethodBeat.i(151976);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151976);
      return false;
    }
    paramString = aee(paramString);
    boolean bool1 = a.bej(paramString);
    boolean bool2 = a.bej(paramString + ".decompressed");
    boolean bool3 = a.bej(paramString + ".decrypted");
    AppMethodBeat.o(151976);
    return bool3 & bool1 & true & bool2;
  }
  
  public static String kD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151975);
    String str = String.format(Locale.US, "%d.%d.data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(151975);
    return str;
  }
  
  static enum a
  {
    final int cSx;
    
    static
    {
      AppMethodBeat.i(151969);
      JZg = new a("ENCRYPTION", 0, 1);
      JZh = new a("COMPRESSION", 1, 2);
      JZi = new a[] { JZg, JZh };
      AppMethodBeat.o(151969);
    }
    
    private a(int paramInt)
    {
      this.cSx = paramInt;
    }
    
    static boolean ahQ(int paramInt)
    {
      return (JZg.cSx & paramInt) > 0;
    }
    
    static boolean ahR(int paramInt)
    {
      return (JZh.cSx & paramInt) > 0;
    }
    
    static int ahS(int paramInt)
    {
      return JZh.cSx | paramInt;
    }
    
    static int gnL()
    {
      return JZg.cSx | 0x0;
    }
  }
  
  static enum b
  {
    final int cSx;
    
    static
    {
      AppMethodBeat.i(151973);
      JZj = new b("DoNothing", 0, 0);
      JZk = new b("DoCache", 1, 1);
      JZl = new b("DoDecrypt", 2, 2);
      JZm = new b("DoDelete", 3, 4);
      JZn = new b[] { JZj, JZk, JZl, JZm };
      AppMethodBeat.o(151973);
    }
    
    private b(int paramInt)
    {
      this.cSx = paramInt;
    }
    
    static boolean ahT(int paramInt)
    {
      return paramInt == JZj.cSx;
    }
    
    static boolean ahU(int paramInt)
    {
      return (JZk.cSx & paramInt) > 0;
    }
    
    static boolean ahV(int paramInt)
    {
      return (JZl.cSx & paramInt) > 0;
    }
    
    static boolean ahW(int paramInt)
    {
      return (JZm.cSx & paramInt) > 0;
    }
    
    static int bdZ(String paramString)
    {
      AppMethodBeat.i(151972);
      if ("cache".equals(paramString))
      {
        i = JZk.cSx;
        AppMethodBeat.o(151972);
        return i;
      }
      if ("delete".equals(paramString))
      {
        i = JZm.cSx;
        AppMethodBeat.o(151972);
        return i;
      }
      if ("decrypt".equals(paramString))
      {
        i = JZl.cSx;
        AppMethodBeat.o(151972);
        return i;
      }
      int i = JZj.cSx;
      AppMethodBeat.o(151972);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.i
 * JD-Core Version:    0.7.0.1
 */