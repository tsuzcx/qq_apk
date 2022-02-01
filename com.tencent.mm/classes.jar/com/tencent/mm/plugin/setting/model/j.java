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
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.protocal.protobuf.dup;

public final class j
  extends n
  implements k
{
  private f callback;
  private final String dwb;
  private final int scene;
  public final String ySW;
  public final int ySX;
  
  public j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.dwb = paramString1;
    this.ySW = paramString2;
    this.ySX = paramInt1;
    this.scene = paramInt2;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73777);
    this.callback = paramf;
    paramf = new b.a();
    cbh localcbh = new cbh();
    localcbh.dwb = this.dwb;
    localcbh.HoC = this.ySW;
    localcbh.HoD = this.ySX;
    paramf.hQF = localcbh;
    paramf.uri = "/cgi-bin/mmbiz-bin/moduserauth";
    paramf.hQG = new cbi();
    paramf.funcId = getType();
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.aDS(), this);
    AppMethodBeat.o(73777);
    return i;
  }
  
  public final int getType()
  {
    return 1144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73776);
    paramString = (cbi)((b)paramq).hQE.hQJ;
    this.callback.onSceneEnd(paramInt2, paramString.GuN.drN, paramString.GuN.drO, this);
    AppMethodBeat.o(73776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.j
 * JD-Core Version:    0.7.0.1
 */