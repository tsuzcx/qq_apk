package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.ao.a;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.nw.a;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.u.a.b.2;
import com.tencent.mm.plugin.u.a.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class p
{
  public c quU;
  public c quV;
  b.a quW;
  
  public p()
  {
    AppMethodBeat.i(80883);
    this.quU = new p.1(this);
    this.quV = new p.2(this);
    this.quW = new p.3(this);
    AppMethodBeat.o(80883);
  }
  
  public final boolean g(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(80884);
    if (paramb == null)
    {
      AppMethodBeat.o(80884);
      return false;
    }
    if ((paramb instanceof nw))
    {
      n.qux.reset();
      n.qux.CE(n.quw);
      paramb = (nw)paramb;
      e.chX().qtq.a(paramb.cEv.filePath, this.quW, paramb.cEv.cEw);
    }
    for (;;)
    {
      AppMethodBeat.o(80884);
      return false;
      if ((paramb instanceof ao))
      {
        n.qux.bJP();
        Object localObject = (ao)paramb;
        paramb = e.chX().qtq;
        localObject = ((ao)localObject).cnS.filePath;
        b.a locala = this.quW;
        ab.i("MicroMsg.FileScanQueueService", "cancelDecode, fileUri: %s, callback: %x", new Object[] { localObject, Integer.valueOf(locala.hashCode()) });
        if (bo.isNullOrNil((String)localObject)) {
          ab.e("MicroMsg.FileScanQueueService", "cancel failed, uri is null or nil");
        } else {
          paramb.iMP.post(new b.2(paramb, (String)localObject, locala));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.p
 * JD-Core Version:    0.7.0.1
 */