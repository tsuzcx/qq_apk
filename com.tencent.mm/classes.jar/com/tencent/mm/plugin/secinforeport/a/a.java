package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bdg;
import com.tencent.mm.protocal.protobuf.cyo;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public enum a
{
  private static b qEm;
  
  static
  {
    AppMethodBeat.i(126177);
    qEl = new a("INSTANCE");
    qEn = new a[] { qEl };
    qEm = new a.1();
    AppMethodBeat.o(126177);
  }
  
  private a() {}
  
  public static void D(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126176);
    ab.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt), paramString1, paramString2 });
    bdg localbdg = new bdg();
    localbdg.cwc = paramString1;
    localbdg.qkL = paramString2;
    paramString1 = null;
    try
    {
      paramString2 = localbdg.toByteArray();
      paramString1 = paramString2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ab.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { paramString2.getMessage() });
      }
    }
    qEm.a(5, "", paramInt, paramString1);
    AppMethodBeat.o(126176);
  }
  
  public static void a(b paramb)
  {
    if (paramb != null) {
      qEm = paramb;
    }
  }
  
  public static void i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(126174);
    ab.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    qEm.a(paramInt1, paramString, paramInt2, null);
    AppMethodBeat.o(126174);
  }
  
  public static void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(126175);
    ab.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d, %d, %s", new Object[] { Integer.valueOf(3), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    Object localObject = new cyo();
    ((cyo)localObject).xrc = paramInt2;
    ((cyo)localObject).yfF = paramString2;
    paramString2 = null;
    try
    {
      localObject = ((cyo)localObject).toByteArray();
      paramString2 = (String)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { localIOException.getMessage() });
      }
    }
    qEm.a(3, paramString1, paramInt1, paramString2);
    AppMethodBeat.o(126175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.a
 * JD-Core Version:    0.7.0.1
 */