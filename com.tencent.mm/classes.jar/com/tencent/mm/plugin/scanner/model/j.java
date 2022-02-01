package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.dqa;
import java.util.List;

public final class j
  extends n
  implements k
{
  public float angle;
  private f callback;
  public int dlK;
  public b rr;
  public List<dqa> ymP;
  public long ymQ;
  
  public j(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(120856);
    b.a locala = new b.a();
    ccm localccm = new ccm();
    localccm.GWh = paramInt2;
    localccm.GWi = paramInt3;
    localccm.GWm = paramString1;
    localccm.GWn = paramString2;
    localccm.Scene = paramInt1;
    locala.hNM = localccm;
    locala.hNN = new ccn();
    locala.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.dlK = paramInt2;
    AppMethodBeat.o(120856);
  }
  
  public j(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this(0, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public final float dKR()
  {
    return this.angle;
  }
  
  public final List<dqa> dKS()
  {
    return this.ymP;
  }
  
  public final String dKT()
  {
    return ((ccn)this.rr.hNL.hNQ).GWq;
  }
  
  public final long dKU()
  {
    return this.ymQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(120857);
    this.callback = paramf;
    this.ymQ = System.currentTimeMillis();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(120857);
    return i;
  }
  
  public final int getSessionId()
  {
    return this.dlK;
  }
  
  public final int getType()
  {
    return 294;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120858);
    this.angle = ((ccn)((b)paramq).hNL.hNQ).GWo;
    this.ymP = ((ccn)((b)paramq).hNL.hNQ).GyO;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(120858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.j
 * JD-Core Version:    0.7.0.1
 */