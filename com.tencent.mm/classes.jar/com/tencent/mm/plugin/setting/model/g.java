package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.dob;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public bfl xok;
  public byte[] xol;
  
  public g(byte[] paramArrayOfByte)
  {
    this.xol = paramArrayOfByte;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(73771);
    this.callback = paramg;
    paramg = new b.a();
    bfk localbfk = new bfk();
    if (this.xol != null) {
      localbfk.EUK = z.al(this.xol).getBuffer();
    }
    paramg.hvt = localbfk;
    this.xok = new bfl();
    paramg.hvu = this.xok;
    paramg.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
    paramg.funcId = getType();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    int i = dispatch(parame, paramg.aAz(), this);
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
    this.xok = ((bfl)((b)paramq).hvs.hvw);
    if (this.xok.EuM != null)
    {
      paramInt3 = this.xok.EuM.dfm;
      paramString = this.xok.EuM.dfn;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.g
 * JD-Core Version:    0.7.0.1
 */