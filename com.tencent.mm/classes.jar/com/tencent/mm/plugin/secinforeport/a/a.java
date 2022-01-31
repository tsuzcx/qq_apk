package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.protocal.c.ckz;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public enum a
{
  private static b nQp = new a.1();
  
  private a() {}
  
  public static void a(b paramb)
  {
    if (paramb != null) {
      nQp = paramb;
    }
  }
  
  public static void f(int paramInt1, String paramString, int paramInt2)
  {
    y.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    nQp.a(paramInt1, paramString, paramInt2, null);
  }
  
  public static void j(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    y.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d, %d, %s", new Object[] { Integer.valueOf(3), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    Object localObject = new ckz();
    ((ckz)localObject).trc = paramInt2;
    ((ckz)localObject).tYn = paramString2;
    paramString2 = null;
    try
    {
      localObject = ((ckz)localObject).toByteArray();
      paramString2 = (String)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { localIOException.getMessage() });
      }
    }
    nQp.a(3, paramString1, paramInt1, paramString2);
  }
  
  public static void t(int paramInt, String paramString1, String paramString2)
  {
    y.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt), paramString1, paramString2 });
    awr localawr = new awr();
    localawr.bOL = paramString1;
    localawr.tti = paramString2;
    paramString1 = null;
    try
    {
      paramString2 = localawr.toByteArray();
      paramString1 = paramString2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        y.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[] { paramString2.getMessage() });
      }
    }
    nQp.a(5, "", paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.a
 * JD-Core Version:    0.7.0.1
 */