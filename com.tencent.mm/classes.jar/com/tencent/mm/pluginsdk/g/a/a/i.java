package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import java.util.Locale;

public final class i
{
  static final byte[] vNu;
  private static final String vNv;
  private static final String vNw;
  static final int[] vNx;
  
  static
  {
    AppMethodBeat.i(79534);
    vNu = new byte[] { 48, -126, 1, 75, 48, -126, 1, 3, 6, 7, 42, -122, 72, -50, 61, 2, 1, 48, -127, -9, 2, 1, 1, 48, 44, 6, 7, 42, -122, 72, -50, 61, 1, 1, 2, 33, 0, -1, -1, -1, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, 91, 4, 32, -1, -1, -1, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -4, 4, 32, 90, -58, 53, -40, -86, 58, -109, -25, -77, -21, -67, 85, 118, -104, -122, -68, 101, 29, 6, -80, -52, 83, -80, -10, 59, -50, 60, 62, 39, -46, 96, 75, 3, 21, 0, -60, -99, 54, 8, -122, -25, 4, -109, 106, 102, 120, -31, 19, -99, 38, -73, -127, -97, 126, -112, 4, 65, 4, 107, 23, -47, -14, -31, 44, 66, 71, -8, -68, -26, -27, 99, -92, 64, -14, 119, 3, 125, -127, 45, -21, 51, -96, -12, -95, 57, 69, -40, -104, -62, -106, 79, -29, 66, -30, -2, 26, 127, -101, -114, -25, -21, 74, 124, 15, -98, 22, 43, -50, 51, 87, 107, 49, 94, -50, -53, -74, 64, 104, 55, -65, 81, -11, 2, 33, 0, -1, -1, -1, -1, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -68, -26, -6, -83, -89, 23, -98, -124, -13, -71, -54, -62, -4, 99, 37, 81, 2, 1, 1, 3, 66, 0, 4, 52, 4, -14, 45, -10, -68, -118, -59, 62, 64, -101, 93, 6, -54, -27, 79, 94, 126, -9, -80, -61, -63, -38, 115, -53, 70, -63, 16, -20, -32, -80, -80, 38, 102, 16, 27, 28, 61, -60, -33, 65, 93, -25, 30, 83, 66, -24, 28, 39, 24, 69, -104, 55, -63, 108, 5, 56, -63, -4, -5, 88, -49, -126, 85 };
    vNv = e.eQz + "CheckResUpdate/";
    vNw = e.eQw + "CheckResUpdate/";
    vNx = new int[] { 27, 35, 29, 38, 40, 33, 37, 39, 49, 46, 47, 56, 59 };
    AppMethodBeat.o(79534);
  }
  
  static String alH(String paramString)
  {
    AppMethodBeat.i(79531);
    if ((paramString.startsWith("38.")) || (paramString.startsWith("56."))) {}
    for (String str = vNw;; str = vNv)
    {
      j.akQ(str);
      paramString = str + paramString;
      AppMethodBeat.o(79531);
      return paramString;
    }
  }
  
  static boolean alI(String paramString)
  {
    AppMethodBeat.i(79533);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79533);
      return false;
    }
    paramString = alH(paramString);
    boolean bool1 = a.alT(paramString);
    boolean bool2 = a.alT(paramString + ".decompressed");
    boolean bool3 = a.alT(paramString + ".decrypted");
    AppMethodBeat.o(79533);
    return bool3 & bool1 & true & bool2;
  }
  
  public static String hd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79532);
    String str = String.format(Locale.US, "%d.%d.data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(79532);
    return str;
  }
  
  static enum a
  {
    final int bsY;
    
    static
    {
      AppMethodBeat.i(79526);
      vNy = new a("ENCRYPTION", 0, 1);
      vNz = new a("COMPRESSION", 1, 2);
      vNA = new a[] { vNy, vNz };
      AppMethodBeat.o(79526);
    }
    
    private a(int paramInt)
    {
      this.bsY = paramInt;
    }
    
    static boolean LF(int paramInt)
    {
      return (vNy.bsY & paramInt) > 0;
    }
    
    static boolean LG(int paramInt)
    {
      return (vNz.bsY & paramInt) > 0;
    }
    
    static int LH(int paramInt)
    {
      return vNz.bsY | paramInt;
    }
    
    static int dmk()
    {
      return vNy.bsY | 0x0;
    }
  }
  
  static enum b
  {
    final int bsY;
    
    static
    {
      AppMethodBeat.i(79530);
      vNB = new b("DoNothing", 0, 0);
      vNC = new b("DoCache", 1, 1);
      vND = new b("DoDecrypt", 2, 2);
      vNE = new b("DoDelete", 3, 4);
      vNF = new b[] { vNB, vNC, vND, vNE };
      AppMethodBeat.o(79530);
    }
    
    private b(int paramInt)
    {
      this.bsY = paramInt;
    }
    
    static boolean LI(int paramInt)
    {
      return paramInt == vNB.bsY;
    }
    
    static boolean LJ(int paramInt)
    {
      return (vNC.bsY & paramInt) > 0;
    }
    
    static boolean LK(int paramInt)
    {
      return (vND.bsY & paramInt) > 0;
    }
    
    static boolean LL(int paramInt)
    {
      return (vNE.bsY & paramInt) > 0;
    }
    
    static int alJ(String paramString)
    {
      AppMethodBeat.i(79529);
      if ("cache".equals(paramString))
      {
        i = vNC.bsY;
        AppMethodBeat.o(79529);
        return i;
      }
      if ("delete".equals(paramString))
      {
        i = vNE.bsY;
        AppMethodBeat.o(79529);
        return i;
      }
      if ("decrypt".equals(paramString))
      {
        i = vND.bsY;
        AppMethodBeat.o(79529);
        return i;
      }
      int i = vNB.bsY;
      AppMethodBeat.o(79529);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.i
 * JD-Core Version:    0.7.0.1
 */