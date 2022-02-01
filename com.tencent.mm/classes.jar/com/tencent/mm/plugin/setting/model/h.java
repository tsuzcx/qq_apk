package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.dup;

public final class h
  extends n
  implements k
{
  private f callback;
  public bkl ySU;
  public byte[] ySV;
  
  public h(byte[] paramArrayOfByte)
  {
    this.ySV = paramArrayOfByte;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73771);
    this.callback = paramf;
    paramf = new b.a();
    bkk localbkk = new bkk();
    if (this.ySV != null) {
      localbkk.GXK = z.al(this.ySV).getBuffer();
    }
    paramf.hQF = localbkk;
    this.ySU = new bkl();
    paramf.hQG = this.ySU;
    paramf.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
    paramf.funcId = getType();
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.aDS(), this);
    AppMethodBeat.o(73771);
    return i;
  }
  
  public final int getType()
  {
    return 1146;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73772);
    this.ySU = ((bkl)((b)paramq).hQE.hQJ);
    if (this.ySU.GuN != null)
    {
      paramInt3 = this.ySU.GuN.drN;
      paramString = this.ySU.GuN.drO;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.h
 * JD-Core Version:    0.7.0.1
 */