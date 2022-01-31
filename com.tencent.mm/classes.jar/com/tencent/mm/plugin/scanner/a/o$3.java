package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.h.a.na;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.plugin.ad.a.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class o$3
  implements b.a
{
  o$3(o paramo) {}
  
  public final void Lv(String paramString)
  {
    y.i("MicroMsg.RecogQBarOfImageFileListener", "result(failed): %s", new Object[] { paramString });
    na localna = new na();
    localna.bWH.filePath = paramString;
    a.udP.m(localna);
  }
  
  public final void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.RecogQBarOfImageFileListener", "result: %s, codeType: %s, codeVersion: %s, filePath:%s", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
    m.nHb.bcI();
    paramArrayOfByte = new nb();
    paramArrayOfByte.bWI.filePath = paramString1;
    paramArrayOfByte.bWI.result = paramString2;
    paramArrayOfByte.bWI.bIj = paramInt1;
    paramArrayOfByte.bWI.bIk = paramInt2;
    a.udP.m(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.o.3
 * JD-Core Version:    0.7.0.1
 */