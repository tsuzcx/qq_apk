package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.protocal.protobuf.gig;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public enum a
{
  private static b PlZ;
  
  static
  {
    AppMethodBeat.i(145647);
    PlY = new a("INSTANCE");
    Pma = new a[] { PlY };
    PlZ = new b()
    {
      public final void a(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(145641);
        Log.i("MicroMsg.ClipBordReport", "!! Dummy implementation !!");
        AppMethodBeat.o(145641);
      }
    };
    AppMethodBeat.o(145647);
  }
  
  private a() {}
  
  public static void T(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(145646);
    Log.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt), paramString1, paramString2 });
    dos localdos = new dos();
    localdos.appid = paramString1;
    localdos.OkP = paramString2;
    paramString1 = null;
    try
    {
      paramString2 = localdos.toByteArray();
      paramString1 = paramString2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        Log.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { paramString2.getMessage() });
      }
    }
    PlZ.a(5, "", paramInt, paramString1);
    AppMethodBeat.o(145646);
  }
  
  public static void a(b paramb)
  {
    if (paramb != null) {
      PlZ = paramb;
    }
  }
  
  public static void m(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(145645);
    Log.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d, %d, %s", new Object[] { Integer.valueOf(3), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    Object localObject = new gig();
    ((gig)localObject).aaSh = paramInt2;
    ((gig)localObject).aceO = paramString2;
    paramString2 = null;
    try
    {
      localObject = ((gig)localObject).toByteArray();
      paramString2 = (String)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { localIOException.getMessage() });
      }
    }
    PlZ.a(3, paramString1, paramInt1, paramString2);
    AppMethodBeat.o(145645);
  }
  
  public static void x(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(145644);
    Log.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    PlZ.a(paramInt1, paramString, paramInt2, null);
    AppMethodBeat.o(145644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.a
 * JD-Core Version:    0.7.0.1
 */