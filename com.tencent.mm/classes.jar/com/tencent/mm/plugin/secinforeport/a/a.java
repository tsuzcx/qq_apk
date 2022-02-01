package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.eev;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public enum a
{
  private static b yBO;
  
  static
  {
    AppMethodBeat.i(145647);
    yBN = new a("INSTANCE");
    yBP = new a[] { yBN };
    yBO = new b()
    {
      public final void a(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(145641);
        ad.i("MicroMsg.ClipBordReport", "!! Dummy implementation !!");
        AppMethodBeat.o(145641);
      }
    };
    AppMethodBeat.o(145647);
  }
  
  private a() {}
  
  public static void L(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(145646);
    ad.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt), paramString1, paramString2 });
    bzc localbzc = new bzc();
    localbzc.duW = paramString1;
    localbzc.xZB = paramString2;
    paramString1 = null;
    try
    {
      paramString2 = localbzc.toByteArray();
      paramString1 = paramString2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ad.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { paramString2.getMessage() });
      }
    }
    yBO.a(5, "", paramInt, paramString1);
    AppMethodBeat.o(145646);
  }
  
  public static void a(b paramb)
  {
    if (paramb != null) {
      yBO = paramb;
    }
  }
  
  public static void k(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(145645);
    ad.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d, %d, %s", new Object[] { Integer.valueOf(3), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    Object localObject = new eev();
    ((eev)localObject).GRB = paramInt2;
    ((eev)localObject).HQk = paramString2;
    paramString2 = null;
    try
    {
      localObject = ((eev)localObject).toByteArray();
      paramString2 = (String)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { localIOException.getMessage() });
      }
    }
    yBO.a(3, paramString1, paramInt1, paramString2);
    AppMethodBeat.o(145645);
  }
  
  public static void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(145644);
    ad.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    yBO.a(paramInt1, paramString, paramInt2, null);
    AppMethodBeat.o(145644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.a
 * JD-Core Version:    0.7.0.1
 */