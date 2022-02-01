package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ao;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  extends n
  implements k
{
  private f callback;
  public String errMsg;
  public final b rr;
  public bfx xfo;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(26901);
    ae.i("MicroMsg.NetSceneGetOpenUrl", "NetSceneGetOpenUrl username:%s ticket:%s climsgid:%s content:%s ", new Object[] { paramString1, paramString2, paramString3, bu.aSM(paramString4) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenurl";
    ((b.a)localObject).funcId = 913;
    ((b.a)localObject).hQF = new bfw();
    ((b.a)localObject).hQG = new bfx();
    this.rr = ((b.a)localObject).aDS();
    localObject = (bfw)this.rr.hQD.hQJ;
    ((bfw)localObject).scene = 1;
    ao localao = new ao();
    localao.username = paramString1;
    localao.dqk = paramString2;
    localao.xfq = paramString3;
    localao.content = paramString4;
    ((bfw)localObject).GUF = localao;
    AppMethodBeat.o(26901);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26902);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26902);
    return i;
  }
  
  public final int getType()
  {
    return 913;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26903);
    ae.d("MicroMsg.NetSceneGetOpenUrl", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(26903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.a
 * JD-Core Version:    0.7.0.1
 */