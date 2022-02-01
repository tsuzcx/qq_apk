package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.dts;

public final class j
  extends n
  implements k
{
  private f callback;
  private String dld;
  public byte[] yCQ;
  public cyx yCT;
  
  public j(String paramString)
  {
    this.dld = paramString;
  }
  
  public j(byte[] paramArrayOfByte)
  {
    this.yCQ = paramArrayOfByte;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73778);
    this.callback = paramf;
    paramf = new b.a();
    cyw localcyw = new cyw();
    localcyw.dld = this.dld;
    if (this.yCQ != null) {
      localcyw.GEh = z.al(this.yCQ).getBuffer();
    }
    paramf.hNM = localcyw;
    paramf.hNN = new cyx();
    paramf.funcId = getType();
    paramf.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.aDC(), this);
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
    this.yCT = ((cyx)((b)paramq).hNL.hNQ);
    if (this.yCT.Gcg != null)
    {
      paramInt3 = this.yCT.Gcg.dqI;
      paramString = this.yCT.Gcg.dqJ;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.j
 * JD-Core Version:    0.7.0.1
 */