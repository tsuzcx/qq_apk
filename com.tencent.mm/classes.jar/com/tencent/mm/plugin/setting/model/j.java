package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.dim;

public final class j
  extends n
  implements k
{
  private g callback;
  private String dcm;
  public byte[] wcX;
  public cog wda;
  
  public j(String paramString)
  {
    this.dcm = paramString;
  }
  
  public j(byte[] paramArrayOfByte)
  {
    this.wcX = paramArrayOfByte;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(73778);
    this.callback = paramg;
    paramg = new b.a();
    cof localcof = new cof();
    localcof.dcm = this.dcm;
    if (this.wcX != null) {
      localcof.Dzo = z.am(this.wcX).getBuffer();
    }
    paramg.gUU = localcof;
    paramg.gUV = new cog();
    paramg.funcId = getType();
    paramg.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    int i = dispatch(parame, paramg.atI(), this);
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
    this.wda = ((cog)((b)paramq).gUT.gUX);
    if (this.wda.DbG != null)
    {
      paramInt3 = this.wda.DbG.dhR;
      paramString = this.wda.DbG.dhS;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.j
 * JD-Core Version:    0.7.0.1
 */