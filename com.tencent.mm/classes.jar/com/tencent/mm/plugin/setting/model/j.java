package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.dob;

public final class j
  extends n
  implements k
{
  private String cZL;
  private g callback;
  public byte[] xol;
  public ctn xoo;
  
  public j(String paramString)
  {
    this.cZL = paramString;
  }
  
  public j(byte[] paramArrayOfByte)
  {
    this.xol = paramArrayOfByte;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(73778);
    this.callback = paramg;
    paramg = new b.a();
    ctm localctm = new ctm();
    localctm.cZL = this.cZL;
    if (this.xol != null) {
      localctm.EUK = z.al(this.xol).getBuffer();
    }
    paramg.hvt = localctm;
    paramg.hvu = new ctn();
    paramg.funcId = getType();
    paramg.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    int i = dispatch(parame, paramg.aAz(), this);
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
    this.xoo = ((ctn)((b)paramq).hvs.hvw);
    if (this.xoo.EuM != null)
    {
      paramInt3 = this.xoo.EuM.dfm;
      paramString = this.xoo.EuM.dfn;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.j
 * JD-Core Version:    0.7.0.1
 */