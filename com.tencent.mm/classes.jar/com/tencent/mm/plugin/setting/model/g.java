package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.dim;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public bbt wcW;
  public byte[] wcX;
  
  public g(byte[] paramArrayOfByte)
  {
    this.wcX = paramArrayOfByte;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(73771);
    this.callback = paramg;
    paramg = new b.a();
    bbs localbbs = new bbs();
    if (this.wcX != null) {
      localbbs.Dzo = z.am(this.wcX).getBuffer();
    }
    paramg.gUU = localbbs;
    this.wcW = new bbt();
    paramg.gUV = this.wcW;
    paramg.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
    paramg.funcId = getType();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    int i = dispatch(parame, paramg.atI(), this);
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
    this.wcW = ((bbt)((b)paramq).gUT.gUX);
    if (this.wcW.DbG != null)
    {
      paramInt3 = this.wcW.DbG.dhR;
      paramString = this.wcW.DbG.dhS;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.g
 * JD-Core Version:    0.7.0.1
 */