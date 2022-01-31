package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.h.a.am;
import com.tencent.mm.h.a.am.a;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.h.a.mz.a;
import com.tencent.mm.plugin.ad.a.b.2;
import com.tencent.mm.plugin.ad.a.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
{
  public com.tencent.mm.sdk.b.c nHv = new o.1(this);
  public com.tencent.mm.sdk.b.c nHw = new o.2(this);
  b.a nHx = new o.3(this);
  
  public final boolean h(com.tencent.mm.sdk.b.b paramb)
  {
    if (paramb == null) {}
    do
    {
      return false;
      if ((paramb instanceof mz))
      {
        m.nHb.reset();
        m.nHb.wO(m.nHa);
        paramb = (mz)paramb;
        com.tencent.mm.plugin.scanner.c.bxd().nGn.a(paramb.bWF.filePath, this.nHx, paramb.bWF.bWG);
        return false;
      }
    } while (!(paramb instanceof am));
    m.nHb.bcI();
    Object localObject = (am)paramb;
    paramb = com.tencent.mm.plugin.scanner.c.bxd().nGn;
    localObject = ((am)localObject).bGF.filePath;
    b.a locala = this.nHx;
    y.i("MicroMsg.FileScanQueueService", "cancelDecode, fileUri: %s, callback: %x", new Object[] { localObject, Integer.valueOf(locala.hashCode()) });
    if (bk.bl((String)localObject))
    {
      y.e("MicroMsg.FileScanQueueService", "cancel failed, uri is null or nil");
      return false;
    }
    paramb.hcZ.post(new b.2(paramb, (String)localObject, locala));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.o
 * JD-Core Version:    0.7.0.1
 */