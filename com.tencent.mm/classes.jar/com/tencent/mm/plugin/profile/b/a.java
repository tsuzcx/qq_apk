package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ao;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends n
  implements k
{
  private f callback;
  public String errMsg;
  public final b rr;
  public bfh wPx;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(26901);
    ad.i("MicroMsg.NetSceneGetOpenUrl", "NetSceneGetOpenUrl username:%s ticket:%s climsgid:%s content:%s ", new Object[] { paramString1, paramString2, paramString3, bt.aRp(paramString4) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenurl";
    ((b.a)localObject).funcId = 913;
    ((b.a)localObject).hNM = new bfg();
    ((b.a)localObject).hNN = new bfh();
    this.rr = ((b.a)localObject).aDC();
    localObject = (bfg)this.rr.hNK.hNQ;
    ((bfg)localObject).scene = 1;
    ao localao = new ao();
    localao.username = paramString1;
    localao.dpf = paramString2;
    localao.wPz = paramString3;
    localao.content = paramString4;
    ((bfg)localObject).GBf = localao;
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
    ad.d("MicroMsg.NetSceneGetOpenUrl", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(26903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.a
 * JD-Core Version:    0.7.0.1
 */