package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.czq;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.dup;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private String dmf;
  public byte[] ySV;
  public czr ySY;
  
  public k(String paramString)
  {
    this.dmf = paramString;
  }
  
  public k(byte[] paramArrayOfByte)
  {
    this.ySV = paramArrayOfByte;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73778);
    this.callback = paramf;
    paramf = new b.a();
    czq localczq = new czq();
    localczq.dmf = this.dmf;
    if (this.ySV != null) {
      localczq.GXK = z.al(this.ySV).getBuffer();
    }
    paramf.hQF = localczq;
    paramf.hQG = new czr();
    paramf.funcId = getType();
    paramf.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.aDS(), this);
    AppMethodBeat.o(73778);
    return i;
  }
  
  public final int getType()
  {
    return 1169;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73779);
    this.ySY = ((czr)((b)paramq).hQE.hQJ);
    if (this.ySY.GuN != null)
    {
      paramInt3 = this.ySY.GuN.drN;
      paramString = this.ySY.GuN.drO;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.k
 * JD-Core Version:    0.7.0.1
 */