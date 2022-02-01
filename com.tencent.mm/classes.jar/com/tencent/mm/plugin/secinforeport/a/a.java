package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.protocal.protobuf.dyt;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public enum a
{
  private static b xnN;
  
  static
  {
    AppMethodBeat.i(145647);
    xnM = new a("INSTANCE");
    xnO = new a[] { xnM };
    xnN = new b()
    {
      public final void a(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(145641);
        ac.i("MicroMsg.ClipBordReport", "!! Dummy implementation !!");
        AppMethodBeat.o(145641);
      }
    };
    AppMethodBeat.o(145647);
  }
  
  private a() {}
  
  public static void J(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(145646);
    ac.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt), paramString1, paramString2 });
    bun localbun = new bun();
    localbun.djj = paramString1;
    localbun.wLU = paramString2;
    paramString1 = null;
    try
    {
      paramString2 = localbun.toByteArray();
      paramString1 = paramString2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ac.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { paramString2.getMessage() });
      }
    }
    xnN.a(5, "", paramInt, paramString1);
    AppMethodBeat.o(145646);
  }
  
  public static void a(b paramb)
  {
    if (paramb != null) {
      xnN = paramb;
    }
  }
  
  public static void j(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(145645);
    ac.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d, %d, %s", new Object[] { Integer.valueOf(3), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    Object localObject = new dyt();
    ((dyt)localObject).Fia = paramInt2;
    ((dyt)localObject).Gfd = paramString2;
    paramString2 = null;
    try
    {
      localObject = ((dyt)localObject).toByteArray();
      paramString2 = (String)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { localIOException.getMessage() });
      }
    }
    xnN.a(3, paramString1, paramInt1, paramString2);
    AppMethodBeat.o(145645);
  }
  
  public static void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(145644);
    ac.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    xnN.a(paramInt1, paramString, paramInt2, null);
    AppMethodBeat.o(145644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.a
 * JD-Core Version:    0.7.0.1
 */